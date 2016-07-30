package org.corpus_tools.salt.util;

import java.util.List;

import org.corpus_tools.salt.core.GraphTraverseHandler;
import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SGraph.GRAPH_TRAVERSE_TYPE;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.impl.GraphTraverserModule;

public class TraverseFluent {
	private final GraphTraverserModule traverserModule = new GraphTraverserModule();
	private GRAPH_TRAVERSE_TYPE traverseType;
	private String traverseId;
	private GraphTraverseHandler traverseHandler;
	private boolean isCycleSafe;

	public TraverseFluent(SGraph graph) {
		traverserModule.setGraph(graph);
	}

	public void startFrom(List<? extends SNode> startNodes) {
		traverserModule.traverse(startNodes, traverseType, traverseId, traverseHandler, isCycleSafe);
	}

	public TraverseFluent withType(GRAPH_TRAVERSE_TYPE traverseType) {
		this.traverseType = traverseType;
		return this;
	}

	public TraverseFluent withId(String id) {
		this.traverseId = id;
		return this;
	}

	public TraverseFluent cycleSafe(boolean isCycleSafe) {
		this.isCycleSafe = isCycleSafe;
		return this;
	}
}
