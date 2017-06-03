package org.corpus_tools.salt.core.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.graph.SampleGraphs;
import org.junit.Test;

public class FindLeafsTest {
	private SGraph graph;

	@Test
	public void whenGraphIsTree_leafsAreN3N4N6N7() {
		graph = SampleGraphs.createTree();

		assertThat(graph.getLeafs()).containsExactly(graph.getNodesByName("n3").get(0),
				graph.getNodesByName("n4").get(0), graph.getNodesByName("n6").get(0),
				graph.getNodesByName("n7").get(0));
	}

	@Test
	public void whenGraphIsDag_leafsAreN3N6() {
		graph = SampleGraphs.createDag();

		assertThat(graph.getLeafs()).containsExactly(graph.getNodesByName("n3").get(0),
				graph.getNodesByName("n6").get(0));
	}

	@Test
	public void whenGraphIsCycledDag_leafsAreN3() {
		graph = SampleGraphs.createCycledDag();

		assertThat(graph.getLeafs()).containsExactly(graph.getNodesByName("n3").get(0));
	}
}
