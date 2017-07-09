package org.corpus_tools.salt.util.internal.traversal;

import static org.assertj.core.api.Assertions.assertThat;

import org.corpus_tools.salt.exceptions.SaltInvalidModelException;
import org.corpus_tools.salt.graph.SampleGraphs;
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
}
