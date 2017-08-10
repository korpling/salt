package org.corpus_tools.salt.util.traversal.internal.backandforth;

import static org.assertj.core.api.Assertions.assertThat;

import org.corpus_tools.salt.exceptions.SaltInvalidModelException;
import org.corpus_tools.salt.graph.SampleGraphs;
import org.corpus_tools.salt.util.traversal.TraversalFilter;
import org.corpus_tools.salt.util.traversal.TraversalLocation;
import org.corpus_tools.salt.util.traversal.TraversalStrategy;
import org.junit.Before;
import org.junit.Test;

public class BottomUpDepthFirstTest extends TraverserTest {
	@Before
	public void beforeEach() {
		strategy = TraversalStrategy.BOTTOM_UP_DEPTH_FIRST;
	}

	@Test
	public void whenGraphIsTree() {
		// GIVEN
		graph = SampleGraphs.createTree();
		startNodes = graph.getLeafs();
		// WHEN
		when();
		// THEN
		assertThat(nodeOrderWayThere).containsExactly("n3", "n2", "n1", "n4", "n2", "n1", "n6", "n5", "n1", "n7", "n1");
		assertThat(nodeOrderWayBack).containsExactly("n1", "n2", "n3", "n1", "n2", "n4", "n1", "n5", "n6", "n1", "n7");
	}

	@Test
	public void whenGraphIsDag() {
		// GIVEN
		graph = SampleGraphs.createDag();
		startNodes = graph.getLeafs();
		// WHEN
		when();
		// THEN
		assertThat(nodeOrderWayThere).containsExactly("n3", "n2", "n1", "n4", "n6", "n2", "n1", "n4");
		assertThat(nodeOrderWayBack).containsExactly("n1", "n4", "n2", "n3", "n1", "n4", "n2", "n6");
	}

	@Test(expected = SaltInvalidModelException.class)
	public void whenGraphIsCycledDag() {
		// GIVEN
		graph = SampleGraphs.createCycledDag();
		startNodes = graph.getLeafs();
		isCycleSafe = true;
		// WHEN
		when();
	}

	@Test
	public void whenFilteringForNothing_allNodesMustBeVisited() {
		// GIVEN
		graph = SampleGraphs.createTree();
		startNodes = graph.getLeafs();
		traversalFilter = new TraversalFilter() {
			@Override
			public boolean test(TraversalLocation location) {
				return true;
			}
		};
		// WHEN
		when();
		// THEN
		assertThat(nodeOrderWayThere).containsExactly("n3", "n2", "n1", "n4", "n2", "n1", "n6", "n5", "n1", "n7", "n1");
		assertThat(nodeOrderWayBack).containsExactly("n1", "n2", "n3", "n1", "n2", "n4", "n1", "n5", "n6", "n1", "n7");
	}

	@Test
	public void whenFilteringForNodes_subgraphsMustNotBeVisited() {
		// GIVEN
		graph = SampleGraphs.createTree();
		startNodes = graph.getLeafs();
		traversalFilter = new TraversalFilter() {
			@Override
			public boolean test(TraversalLocation location) {
				String nodeName = location.getCurrentNode().getName();
				if ("n2".equals(nodeName) || "n3".equals(nodeName)) {
					return false;
				}
				return true;
			}
		};
		// WHEN
		when();
		// THEN
		assertThat(nodeOrderWayThere).containsExactly("n4", "n6", "n5", "n1", "n7", "n1");
		assertThat(nodeOrderWayBack).containsExactly("n4", "n1", "n5", "n6", "n1", "n7");
	}
}
