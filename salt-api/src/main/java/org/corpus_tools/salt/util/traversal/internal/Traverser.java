package org.corpus_tools.salt.util.traversal.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.util.traversal.BackAndForthTraverseHandler;
import org.corpus_tools.salt.util.traversal.SimpleTraverseHandler;
import org.corpus_tools.salt.util.traversal.TraversalFilter;
import org.corpus_tools.salt.util.traversal.TraversalLocation;
import org.corpus_tools.salt.util.traversal.TraversalStrategy;

public abstract class Traverser {
	protected final List<? extends SNode> startNodes;
	protected final TraversalStrategy strategy;
	protected final String id;
	protected BackAndForthTraverseHandler handler;
	protected SimpleTraverseHandler simpleHandler;
	protected final boolean isCycleSafe;
	protected final SGraph graph;
	protected final Collection<TraversalFilter> filters;
	protected final List<SNode> currentNodePath = new ArrayList<>();

	public Traverser(List<? extends SNode> startNodes, TraversalStrategy strategy, String id,
			BackAndForthTraverseHandler handler, boolean isCycleSafe, SGraph graph,
			Collection<TraversalFilter> filters) {
		this.startNodes = startNodes;
		this.strategy = strategy;
		this.id = id;
		this.handler = handler;
		this.isCycleSafe = isCycleSafe;
		this.graph = graph;
		this.filters = filters;
	}

	// public Traverser(List<? extends SNode> startNodes, TraversalStrategy
	// strategy, String id,
	// SimpleTraverseHandler simpleHandler, boolean isCycleSafe, SGraph graph) {
	// this.startNodes = startNodes;
	// this.strategy = strategy;
	// this.id = id;
	// this.simpleHandler = simpleHandler;
	// this.isCycleSafe = isCycleSafe;
	// this.graph = graph;
	// }

	protected boolean filterAndCheckShouldGoOn(TraversalLocation location) {
		return filter(location) && handler.shouldTraversalGoOn(location);
	}

	protected boolean filter(TraversalLocation location) {
		if (filters.isEmpty()) {
			return true;
		}
		return filters.stream().anyMatch(filter -> filter.test(location));
	}

	public abstract void traverse();
}
