package org.corpus_tools.salt.util.internal.traversal;

import java.util.Arrays;
import java.util.Collections;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.exceptions.SaltException;
import org.corpus_tools.salt.util.SaltUtil;
import org.corpus_tools.salt.util.traversal.TraversalStrategy;
import org.junit.Test;

public class TraverseBuilderTest {
	private SGraph graph = SaltFactory.createSGraph();

	@Test(expected = SaltException.class)
	public void whenStartNodesAreEmpty_throwException() {
		SaltUtil.traverse(graph)
				.startFrom(Collections.emptyList())
				.useStrategy(TraversalStrategy.TOP_DOWN_DEPTH_FIRST)
				.andCall(new MyTraverseHandler());
	}

	@Test(expected = SaltException.class)
	public void whenNoStrategyGiven_throwException() {
		SaltUtil.traverse(graph)
				.startFrom(Arrays.asList(SaltFactory.createSNode()))
				.useStrategy(null)
				.andCall(new MyTraverseHandler());
	}

	@Test(expected = SaltException.class)
	public void whenNoHandlerGiven_throwException() {
		SaltUtil.traverse(graph)
				.startFrom(Arrays.asList(SaltFactory.createSNode()))
				.useStrategy(TraversalStrategy.TOP_DOWN_DEPTH_FIRST)
				.andCall(null);
	}
}
