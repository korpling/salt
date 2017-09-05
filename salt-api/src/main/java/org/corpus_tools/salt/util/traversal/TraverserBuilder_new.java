package org.corpus_tools.salt.util.traversal;

import static org.corpus_tools.salt.util.traversal.TraversalStrategy.BOTTOM_UP_BREADTH_FIRST;
import static org.corpus_tools.salt.util.traversal.TraversalStrategy.BOTTOM_UP_DEPTH_FIRST;
import static org.corpus_tools.salt.util.traversal.TraversalStrategy.TOP_DOWN_BREADTH_FIRST;
import static org.corpus_tools.salt.util.traversal.TraversalStrategy.TOP_DOWN_DEPTH_FIRST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.exceptions.SaltTraverserException;
import org.corpus_tools.salt.util.SaltUtil;
import org.corpus_tools.salt.util.traversal.internal.BottomUpBreadthFirstTraverser;
import org.corpus_tools.salt.util.traversal.internal.BottomUpDepthFirstTraverser;
import org.corpus_tools.salt.util.traversal.internal.ExcludeCycles;
import org.corpus_tools.salt.util.traversal.internal.TopDownBreadthFirstTraverser;
import org.corpus_tools.salt.util.traversal.internal.TopDownDepthFirstTraverser;

public class TraverserBuilder_new {
	private final SGraph graph;

	public TraverserBuilder_new(SGraph graph) {
		if (graph == null) {
			throw new SaltTraverserException("Cannot start traversing graph, because the graph is null.");
		}
		this.graph = graph;
	}

	public Builder2 useStrategy(TraversalStrategy strategy) {
		if (strategy == null) {
			throw new SaltTraverserException(
					"Cannot start traversing graph '" + graph.getId() + "', because the given traverseType is empty.");
		}
		return new Builder2(strategy, graph);
	}

	public static class Builder2 {
		private final TraversalStrategy strategy;
		private final SGraph graph;
		private final Collection<ExcludeFilter> excludeFilters = new ArrayList<>();
		private List<SNode> startNodes = new ArrayList<>();
		private boolean excludeCycles = true;
		private String id = null;

		public Builder2(TraversalStrategy strategy, SGraph graph) {
			this.strategy = strategy;
			this.graph = graph;
		}

		public Builder2 startFrom(SNode... startNodes) {
			// if ((startNodes == null) || (startNodes.length == 0)) {
			// throw new SaltTraverserException("Cannot start traversing graph
			// '" + graph.getId()
			// + "', because the given start nodes are empty.");
			// }
			return startFrom(Arrays.asList(startNodes));
		}

		public Builder2 startFrom(List<SNode> startNodes) {
			// if ((startNodes == null) || (startNodes.isEmpty())) {
			// throw new SaltTraverserException("Cannot start traversing graph
			// '" + graph.getId()
			// + "', because the given start nodes are empty.");
			// }
			if (SaltUtil.isNotNullOrEmpty(startNodes)) {
				this.startNodes.addAll(startNodes);
			}
			return this;
		}

		public Builder2 dontExcludeCycles() {
			excludeCycles = false;
			return this;
		}

		public Builder2 useId(String id) {
			this.id = id;
			return this;
		}

		public Builder2 exclude(ExcludeFilter filter) {
			if (filter != null) {
				excludeFilters.add(filter);
			}
			return this;
		}

		public void andCall(TraverseCallBackHandler handler) {
			if (handler == null) {
				throw new SaltTraverserException("Cannot start traversing graph '" + graph.getId()
						+ "', because the given callback handler 'traverseHandler' is empty.");
			}
			if (excludeCycles && !containsExcludeCycles()) {
				excludeFilters.add(ExcludeFilter.skipCycles());
			}
			if (startNodes.isEmpty()) {
				startNodes = emitStartNodes();
			}

			if (SaltUtil.isNullOrEmpty(startNodes)) {
				throw new SaltTraverserException("Cannot start traversing graph '" + graph.getId()
						+ "', because the given start nodes are empty.");
			}

			if (TOP_DOWN_DEPTH_FIRST.equals(strategy)) {
				new TopDownDepthFirstTraverser(startNodes, strategy, id, handler, graph, excludeFilters).traverse();
			} else if (TOP_DOWN_BREADTH_FIRST.equals(strategy)) {
				new TopDownBreadthFirstTraverser(startNodes, strategy, id, handler, graph, excludeFilters).traverse();
			} else if (BOTTOM_UP_DEPTH_FIRST.equals(strategy)) {
				new BottomUpDepthFirstTraverser(startNodes, strategy, id, handler, graph, excludeFilters).traverse();
			} else if (BOTTOM_UP_BREADTH_FIRST.equals(strategy)) {
				new BottomUpBreadthFirstTraverser(startNodes, strategy, id, handler, graph, excludeFilters).traverse();
			}
		}

		private List<SNode> emitStartNodes() {
			switch (strategy) {
			case TOP_DOWN_DEPTH_FIRST:
			case TOP_DOWN_BREADTH_FIRST:
				return graph.getRoots();
			case BOTTOM_UP_DEPTH_FIRST:
			case BOTTOM_UP_BREADTH_FIRST:
				return graph.getLeafs();
			default:
				return Collections.emptyList();
			}
		}

		private boolean containsExcludeCycles() {
			return excludeFilters.stream().anyMatch(filter -> filter instanceof ExcludeCycles);
		}
	}
}
