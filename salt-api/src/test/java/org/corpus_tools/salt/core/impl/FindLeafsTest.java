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

		assertThat(graph.getLeafs()).containsExactly(graph.getNodeByName("n3").get(), graph.getNodeByName("n4").get(),
				graph.getNodeByName("n6").get(), graph.getNodeByName("n7").get());
	}

	@Test
	public void whenGraphIsDag_leafsAreN3N6() {
		graph = SampleGraphs.createDag();

		assertThat(graph.getLeafs()).containsExactly(graph.getNodeByName("n3").get(), graph.getNodeByName("n6").get());
	}

	@Test
	public void whenGraphIsCycledDag_leafsAreN3() {
		graph = SampleGraphs.createCycledDag();

		assertThat(graph.getLeafs()).containsExactly(graph.getNodeByName("n3").get());
	}
}
