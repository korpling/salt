package org.corpus_tools.salt.util.internal.traversal.backandforth;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.corpus_tools.salt.graph.SampleGraphs;
import org.corpus_tools.salt.util.traversal.TraversalFilter;
import org.corpus_tools.salt.util.traversal.TraversalLocation;
import org.corpus_tools.salt.util.traversal.TraversalStrategy;
import org.junit.Before;
import org.junit.Test;

public class TopDownBreadthFirstTest extends TraverserTest {
	@Before
	public void beforeEach() {
		strategy = TraversalStrategy.TOP_DOWN_BREADTH_FIRST;
	}

	@Test
	public void whenGraphIsTree() {
		// GIVEN
		graph = SampleGraphs.createTree();
		startNodes = graph.getRoots();
		// WHEN
		when();
		// THEN
		assertThat(nodeOrderWayThere).containsExactly("n1", "n2", "n5", "n7", "n3", "n4", "n6");
		assertThat(nodeOrderWayBack).containsExactly("n1", "n2", "n5", "n7", "n3", "n4", "n6");
	}

	@Test
	public void whenGraphIsDag() {
		// GIVEN
		graph = SampleGraphs.createDag();
		startNodes = graph.getRoots();
		// WHEN
		when();
		// THEN
		assertThat(nodeOrderWayThere).containsExactly("n1", "n4", "n2", "n2", "n3", "n6", "n3", "n6");
		assertThat(nodeOrderWayBack).containsExactly("n1", "n4", "n2", "n2", "n3", "n6", "n3", "n6");
	}

	@Test
	public void whenGraphIsDagAndStartNodesNotRoots() {
		// GIVEN
		graph = SampleGraphs.createDag();
		startNodes = Arrays.asList(graph.getNodeByName("n2").get());
		// WHEN
		when();
		// THEN
		assertThat(nodeOrderWayThere).containsExactly("n2", "n3", "n6");
		assertThat(nodeOrderWayBack).containsExactly("n2", "n3", "n6");
	}

	@Test
	public void testTraverse_TOP_DOWN_BREADTH_FIRST_CycleUnsafe() {
		// GIVEN
		graph = SampleGraphs.createCycledTree();
		startNodes = graph.getRoots();
		preventRunInCycle = true;
		// WHEN
		when();
		// THEN
		assertThat(nodeOrderWayThere).containsExactly("n1", "n2", "n3", "n6", "n7");
		assertThat(nodeOrderWayBack).containsExactly("n1", "n2", "n3", "n6", "n7");
	}

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
		assertThat(nodeOrderWayThere).containsExactly("n1", "n2", "n5", "n7", "n3", "n4", "n6");
		assertThat(nodeOrderWayBack).containsExactly("n1", "n2", "n5", "n7", "n3", "n4", "n6");
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
		assertThat(nodeOrderWayThere).containsExactly("n1", "n5", "n7", "n6");
		assertThat(nodeOrderWayBack).containsExactly("n1", "n5", "n7", "n6");
	}
}
