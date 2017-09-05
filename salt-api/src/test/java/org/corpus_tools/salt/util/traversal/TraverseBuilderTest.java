package org.corpus_tools.salt.util.traversal;

import java.util.Arrays;
import java.util.Collections;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.exceptions.SaltException;
import org.corpus_tools.salt.util.SaltUtil;
import org.corpus_tools.salt.util.traversal.internal.backandforth.MyBackAndForthTraverseHandler;
import org.junit.Test;

public class TraverseBuilderTest {
	private SGraph graph = SaltFactory.createSGraph();

	@Test(expected = SaltException.class)
	public void whenStartNodesAreEmpty_throwException() {
		SaltUtil.traverse(graph)
				.useStrategy(TraversalStrategy.TOP_DOWN_DEPTH_FIRST)
				.startFrom(Collections.emptyList())
				.andCall(new MyBackAndForthTraverseHandler());
	}

	@Test(expected = SaltException.class)
	public void whenNoStrategyGiven_throwException() {
		SaltUtil.traverse(graph).useStrategy(null).startFrom(Arrays.asList(SaltFactory.createSNode())).andCall(
				new MyBackAndForthTraverseHandler());
	}

	@Test(expected = SaltException.class)
	public void whenNullBackAndForthHandlerGiven_throwException() {
		SaltUtil.traverse(graph)
				.useStrategy(TraversalStrategy.TOP_DOWN_DEPTH_FIRST)
				.startFrom(Arrays.asList(SaltFactory.createSNode()))
				.andCall((TraverseCallBackHandler) null);
	}

	@Test(expected = SaltException.class)
	public void whenNullSimpleHandlerGiven_throwException() {
		SaltUtil.traverse(graph)
				.useStrategy(TraversalStrategy.TOP_DOWN_DEPTH_FIRST)
				.startFrom(Arrays.asList(SaltFactory.createSNode()))
				.andCall((TraverseCallBackHandler) null);
	}
}
