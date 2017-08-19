package org.corpus_tools.salt.util.traversal.internal;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.graph.SampleGraphs;
import org.corpus_tools.salt.util.SaltUtil;
import org.corpus_tools.salt.util.traversal.TraversalLocation;
import org.corpus_tools.salt.util.traversal.TraversalStrategy;
import org.corpus_tools.salt.util.traversal.TraverseCallBackHandler;
import org.junit.Test;

public class SkipCyclesTest implements TraverseCallBackHandler {
	protected SGraph graph;
	protected List<String> visitedNodes = new ArrayList<>();

	private void when() {
		SaltUtil.traverse(graph)
				.startFrom(graph.getRoots())
				.useStrategy(TraversalStrategy.TOP_DOWN_DEPTH_FIRST)
				.cycleSafe(false)
				.filter(new SkipCycles())
				.andCall(this);
	}

	@Override
	public void nodeReachedOnWayForth(TraversalLocation location) {
		visitedNodes.add(location.getCurrentNode().getName());
	}

	@Test
	public void whenGraphContainsCycle_cycleShouldBeSkiped() {
		// GIVEN
		graph = SampleGraphs.createCycledTree();
		// WHEN
		when();
		// THEN
		assertThat(visitedNodes).containsExactly("n1", "n2", "n3", "n6", "n7", "n2");
	}

	@Test
	public void whenGraphIsDiamond_lowestNodeShouldBeVisitedTwice() {
		// GIVEN
		graph = SampleGraphs.createDiamond();
		// WHEN
		when();
		// THEN
		assertThat(visitedNodes).containsExactly("n1", "n2", "n3", "n4", "n3");
	}

	@Test
	public void whenGraphIsDag_noNodesShouldBeSkipped() {
		// GIVEN
		graph = SampleGraphs.createDag();
		// WHEN
		when();
		// THEN
		assertThat(visitedNodes).containsExactly("n1", "n2", "n3", "n6", "n4", "n2", "n3", "n6");
	}
}
