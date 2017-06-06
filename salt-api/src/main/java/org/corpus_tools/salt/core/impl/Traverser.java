package org.corpus_tools.salt.core.impl;

import java.util.List;

import org.corpus_tools.salt.core.GraphTraverseHandler;
import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SGraph.GRAPH_TRAVERSE_TYPE;
import org.corpus_tools.salt.core.SNode;

public abstract class Traverser {
	protected final List<? extends SNode> startNodes;
	protected final GRAPH_TRAVERSE_TYPE strategy;
	protected final String traverseId;
	protected final GraphTraverseHandler traverseHandler;
	protected final boolean isCycleSafe;
	protected SGraph graph;
	protected List<SNode> currentNodePath = null;

	public Traverser(List<? extends SNode> startNodes, GRAPH_TRAVERSE_TYPE strategy, String traverseId,
			GraphTraverseHandler traverseHandler, boolean isCycleSafe, SGraph graph) {
		this.startNodes = startNodes;
		this.strategy = strategy;
		this.traverseId = traverseId;
		this.traverseHandler = traverseHandler;
		this.isCycleSafe = isCycleSafe;
		this.graph = graph;
	}

	public abstract void traverse();
}
