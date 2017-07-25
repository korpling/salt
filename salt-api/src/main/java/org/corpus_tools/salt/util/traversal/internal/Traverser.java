package org.corpus_tools.salt.util.traversal.internal;

import java.util.ArrayList;
import java.util.List;

import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.util.traversal.BackAndForthTraverseHandler;
import org.corpus_tools.salt.util.traversal.SimpleTraverseHandler;
import org.corpus_tools.salt.util.traversal.TraversalStrategy;

public abstract class Traverser {
	protected final List<? extends SNode> startNodes;
	protected final TraversalStrategy strategy;
	protected final String id;
	protected BackAndForthTraverseHandler handler;
	protected SimpleTraverseHandler simpleHandler;
	protected final boolean isCycleSafe;
	protected final SGraph graph;
	protected final List<SNode> currentNodePath = new ArrayList<>();

	public Traverser(List<? extends SNode> startNodes, TraversalStrategy strategy, String id,
			BackAndForthTraverseHandler handler, boolean isCycleSafe, SGraph graph) {
		this.startNodes = startNodes;
		this.strategy = strategy;
		this.id = id;
		this.handler = handler;
		this.isCycleSafe = isCycleSafe;
		this.graph = graph;
	}

	public Traverser(List<? extends SNode> startNodes, TraversalStrategy strategy, String id,
			SimpleTraverseHandler simpleHandler, boolean isCycleSafe, SGraph graph) {
		this.startNodes = startNodes;
		this.strategy = strategy;
		this.id = id;
		this.simpleHandler = simpleHandler;
		this.isCycleSafe = isCycleSafe;
		this.graph = graph;
	}

	public abstract void traverse();
}
