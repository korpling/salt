package org.corpus_tools.salt.util.internal.traversal.simple;

import static org.assertj.core.api.Assertions.assertThat;

import org.corpus_tools.salt.exceptions.SaltInvalidModelException;
import org.corpus_tools.salt.graph.SampleGraphs;
import org.corpus_tools.salt.util.traversal.TraversalStrategy;
import org.junit.Before;
import org.junit.Test;

public class TopDownDepthFirstTest extends SimpleTraverserTest {
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

	@Test(expected = SaltInvalidModelException.class)
	public void whenGraphIsCycledDagAndIsCycleSafe() {
		// GIVEN
		graph = SampleGraphs.createCycledDag();
		startNodes = graph.getRoots();
		isCycleSafe = true;
		// WHEN
		when();
	}

	@Test
	public void whenGraphIsCycledTreeAndIsNotCycleSafe() {
		// GIVEN
		graph = SampleGraphs.createCycledTree();
		startNodes = graph.getRoots();
		preventRunInCycle = true;
		// WHEN
		when();
		// THEN
		assertThat(visitedNodes).containsExactly("n1", "n2", "n3", "n6", "n7");
	}
}
