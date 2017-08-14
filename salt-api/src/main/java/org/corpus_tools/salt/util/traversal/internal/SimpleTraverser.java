package org.corpus_tools.salt.util.traversal.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.util.traversal.SimpleTraverseHandler;
import org.corpus_tools.salt.util.traversal.TraversalFilter;
import org.corpus_tools.salt.util.traversal.TraversalLocation;
import org.corpus_tools.salt.util.traversal.TraversalStrategy;

public abstract class SimpleTraverser {
	protected final List<? extends SNode> startNodes;
	protected final TraversalStrategy strategy;
	protected final String id;
	protected final SimpleTraverseHandler handler;
	protected final boolean isCycleSafe;
	protected final SGraph graph;
	protected final Collection<TraversalFilter> filters;
	protected final List<SNode> currentNodePath = new ArrayList<>();

	public SimpleTraverser(List<? extends SNode> startNodes, TraversalStrategy strategy, String id,
			SimpleTraverseHandler handler, boolean isCycleSafe, SGraph graph, Collection<TraversalFilter> filters) {
		this.startNodes = startNodes;
		this.strategy = strategy;
		this.id = id;
		this.handler = handler;
		this.isCycleSafe = isCycleSafe;
		this.graph = graph;
		this.filters = filters;
	}

	protected boolean filter(TraversalLocation location) {
		if (filters.isEmpty()) {
			return true;
		}
		return filters.stream().anyMatch(filter -> filter.test(location));
	}

	public abstract void traverse();
}
