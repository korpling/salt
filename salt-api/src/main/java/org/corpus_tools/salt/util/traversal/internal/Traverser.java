package org.corpus_tools.salt.util.traversal.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.util.traversal.ExcludeFilter;
import org.corpus_tools.salt.util.traversal.TraversalLocation;
import org.corpus_tools.salt.util.traversal.TraversalStrategy;
import org.corpus_tools.salt.util.traversal.TraverseCallBackHandler;

public abstract class Traverser {
	protected final List<? extends SNode> startNodes;
	protected final TraversalStrategy strategy;
	protected final String id;
	protected final TraverseCallBackHandler handler;
	protected boolean isCycleSafe = false;
	protected final SGraph graph;
	protected final Collection<ExcludeFilter> excludeFilters;
	protected final List<SNode> currentNodePath = new ArrayList<>();

	@Deprecated
	public Traverser(List<? extends SNode> startNodes, TraversalStrategy strategy, String id,
			TraverseCallBackHandler handler, boolean isCycleSafe, SGraph graph,
			Collection<ExcludeFilter> excludeFilters) {
		this.startNodes = startNodes;
		this.strategy = strategy;
		this.id = id;
		this.handler = handler;
		this.isCycleSafe = isCycleSafe;
		this.graph = graph;
		this.excludeFilters = excludeFilters;
	}

	public Traverser(List<? extends SNode> startNodes, TraversalStrategy strategy, String id,
			TraverseCallBackHandler handler, SGraph graph, Collection<ExcludeFilter> excludeFilters) {
		this.startNodes = startNodes;
		this.strategy = strategy;
		this.id = id;
		this.handler = handler;
		this.graph = graph;
		this.excludeFilters = excludeFilters;
	}

	protected boolean isIncludeNode(TraversalLocation location) {
		return !isExclude(location) && handler.shouldTraversalGoOn(location);
	}

	protected boolean isExclude(TraversalLocation location) {
		if (excludeFilters.isEmpty()) {
			return false;
		}
		return excludeFilters.stream().anyMatch(excludeFilter -> excludeFilter.test(location));
	}

	public abstract void traverse();
}
