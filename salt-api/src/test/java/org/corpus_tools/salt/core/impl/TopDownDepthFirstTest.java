package org.corpus_tools.salt.core.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.corpus_tools.salt.core.SGraph.GRAPH_TRAVERSE_TYPE;
import org.corpus_tools.salt.exceptions.SaltInvalidModelException;
import org.corpus_tools.salt.graph.SampleGraphs;
import org.junit.Before;
import org.junit.Test;

public class TopDownDepthFirstTest extends TraverserTest {
	@Before
	public void beforeEach() {
		traverseType = GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST;
	}

	@Test
	public void whenGraphIsTree() {
		// GIVEN
		graph = SampleGraphs.createTree();
		startNodes = graph.getRoots();
		// WHEN
		when();
		// THEN
		assertThat(nodeOrderWayThere).containsExactly("n1", "n2", "n3", "n4", "n5", "n6", "n7");
		assertThat(nodeOrderWayBack).containsExactly("n3", "n4", "n2", "n6", "n5", "n7", "n1");
	}

	@Test
	public void whenGraphIsDag() {
		// GIVEN
		graph = SampleGraphs.createDag();
		startNodes = graph.getRoots();
		// WHEN
		when();
		// THEN
		assertThat(nodeOrderWayThere).containsExactly("n1", "n2", "n3", "n6", "n4", "n2", "n3", "n6");
		assertThat(nodeOrderWayBack).containsExactly("n3", "n6", "n2", "n1", "n3", "n6", "n2", "n4");
	}

	@Test(expected = SaltInvalidModelException.class)
	public void whenGraphIsCycledDagAndIsCycleSafe() {
		// GIVEN
		graph = SampleGraphs.createCycledDag();
		startNodes = graph.getRoots();
		isCycleSafe = true;
		// WHEN
		when();
		// THEN
		assertThat(nodeOrderWayThere).containsExactly("n1", "n2", "n3", "n6", "n7", "n2", "n6", "n7");
		assertThat(nodeOrderWayBack).containsExactly("n3", "n6", "n2", "n1", "n3", "n6", "n2", "n4");
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
		assertThat(nodeOrderWayThere).containsExactly("n1", "n2", "n3", "n6", "n7");
		assertThat(nodeOrderWayBack).containsExactly("n3", "n7", "n6", "n2", "n1");
	}
}
