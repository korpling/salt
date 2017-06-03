package org.corpus_tools.salt.core.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.graph.SampleGraphs;
import org.junit.Test;

public class FindRootsTest {
	private SGraph graph;

	@Test
	public void whenGraphIsTree_rootIsN1() {
		graph = SampleGraphs.createTree();

		assertThat(graph.getRoots()).containsExactly(graph.getNodesByName("n1").get(0));
	}

	@Test
	public void whenGraphIsDag_rootsAreN1N4() {
		graph = SampleGraphs.createDag();

		assertThat(graph.getRoots()).containsExactly(graph.getNodesByName("n1").get(0),
				graph.getNodesByName("n4").get(0));
	}

	@Test
	public void whenGraphIsCycledDag_rootsAreN1N4() {
		graph = SampleGraphs.createCycledDag();

		assertThat(graph.getRoots()).containsExactly(graph.getNodesByName("n1").get(0),
				graph.getNodesByName("n4").get(0));
	}
}
