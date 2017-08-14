package org.corpus_tools.salt.util.traversal.internal.simple;

import static org.assertj.core.api.Assertions.assertThat;

import org.corpus_tools.salt.exceptions.SaltInvalidModelException;
import org.corpus_tools.salt.graph.SampleGraphs;
import org.corpus_tools.salt.util.traversal.TraversalFilter;
import org.corpus_tools.salt.util.traversal.TraversalLocation;
import org.corpus_tools.salt.util.traversal.TraversalStrategy;
import org.junit.Before;
import org.junit.Test;

public class SimpleTopDownDepthFirstTest extends SimpleTraverserTest {
	@Before
	public void beforeEach() {
		strategy = TraversalStrategy.TOP_DOWN_DEPTH_FIRST;
	}

	@Test
	public void whenGraphIsTree() {
		// GIVEN
		graph = SampleGraphs.createTree();
		startNodes = graph.getRoots();
		// WHEN
		when();
		// THEN
		assertThat(visitedNodes).containsExactly("n1", "n2", "n3", "n4", "n5", "n6", "n7");
	}

	// @Test
	// public void whenGraphIsTreeAndTraversalShouldNotGoOn() {
	// // GIVEN
	// graph = SampleGraphs.createTree();
	// startNodes = graph.getRoots();
	// stopNodes.addAll(Arrays.asList("n3", "n4", "n6", "n7"));
	// // WHEN
	// when();
	// // THEN
	// assertThat(visitedNodes).containsExactly("n1", "n2", "n5");
	// }

	@Test
	public void whenGraphIsDiamond() {
		// GIVEN
		graph = SampleGraphs.createDiamond();
		startNodes = graph.getRoots();
		// WHEN
		when();
		// THEN
		assertThat(visitedNodes).containsExactly("n1", "n2", "n3", "n4", "n3");
	}

	// @Test
	// public void whenGraphIsDiamondAndTraversalShouldNotGoOn() {
	// // GIVEN
	// graph = SampleGraphs.createDiamond();
	// startNodes = graph.getRoots();
	// stopNodes.add("n3");
	// // WHEN
	// when();
	// // THEN
	// assertThat(nodeOrderWayThere).containsExactly("n1", "n2", "n4");
	// assertThat(nodeOrderWayBack).containsExactly("n2", "n4", "n1");
	// }

	@Test
	public void whenGraphIsDag() {
		// GIVEN
		graph = SampleGraphs.createDag();
		startNodes = graph.getRoots();
		// WHEN
		when();
		// THEN
		assertThat(visitedNodes).containsExactly("n1", "n2", "n3", "n6", "n4", "n2", "n3", "n6");
	}

	// @Test
	// public void whenGraphIsDagAndTraversalShouldNotGoOn() {
	// // GIVEN
	// graph = SampleGraphs.createDag();
	// startNodes = graph.getRoots();
	// stopNodes.add("n2");
	// // WHEN
	// when();
	// // THEN
	// assertThat(nodeOrderWayThere).containsExactly("n1", "n4");
	// assertThat(nodeOrderWayBack).containsExactly("n1", "n4");
	// }

	@Test(expected = SaltInvalidModelException.class)
	public void whenGraphIsCycledDagAndIsCycleSafe() {
		// GIVEN
		graph = SampleGraphs.createCycledDag();
		startNodes = graph.getRoots();
		isCycleSafe = true;
		// WHEN
		when();
	}

	// @Test
	// public void whenGraphIsCycledTreeAndIsNotCycleSafe() {
	// // GIVEN
	// graph = SampleGraphs.createCycledTree();
	// startNodes = graph.getRoots();
	// preventRunInCycle = true;
	// // WHEN
	// when();
	// // THEN
	// assertThat(visitedNodes).containsExactly("n1", "n2", "n3", "n6", "n7");
	// }

	@Test
	public void whenFilteringForNothing_allNodesMustBeVisited() {
		// GIVEN
		graph = SampleGraphs.createTree();
		startNodes = graph.getRoots();
		traversalFilter = new TraversalFilter() {
			@Override
			public boolean test(TraversalLocation location) {
				return true;
			}
		};
		// WHEN
		when();
		// THEN
		assertThat(visitedNodes).containsExactly("n1", "n2", "n3", "n4", "n5", "n6", "n7");
	}

	@Test
	public void whenFilteringForNodes_subgraphsMustNotBeVisited() {
		// GIVEN
		graph = SampleGraphs.createTree();
		startNodes = graph.getRoots();
		traversalFilter = new TraversalFilter() {
			@Override
			public boolean test(TraversalLocation location) {
				String nodeName = location.getCurrentNode().getName();
				if ("n2".equals(nodeName)) {
					return false;
				}
				return true;
			}
		};
		// WHEN
		when();
		// THEN
		assertThat(visitedNodes).containsExactly("n1", "n5", "n6", "n7");
	}
}
