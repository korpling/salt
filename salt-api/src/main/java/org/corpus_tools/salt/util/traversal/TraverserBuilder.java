package org.corpus_tools.salt.util.traversal;

import static org.corpus_tools.salt.util.traversal.TraversalStrategy.BOTTOM_UP_BREADTH_FIRST;
import static org.corpus_tools.salt.util.traversal.TraversalStrategy.BOTTOM_UP_DEPTH_FIRST;
import static org.corpus_tools.salt.util.traversal.TraversalStrategy.TOP_DOWN_BREADTH_FIRST;
import static org.corpus_tools.salt.util.traversal.TraversalStrategy.TOP_DOWN_DEPTH_FIRST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.exceptions.SaltTraverserException;
import org.corpus_tools.salt.util.traversal.internal.BottomUpBreadthFirstTraverser;
import org.corpus_tools.salt.util.traversal.internal.BottomUpDepthFirstTraverser;
import org.corpus_tools.salt.util.traversal.internal.TopDownBreadthFirstTraverser;
import org.corpus_tools.salt.util.traversal.internal.TopDownDepthFirstTraverser;

public class TraverserBuilder {
	private final SGraph graph;

	public TraverserBuilder(SGraph graph) {
		if (graph == null) {
			throw new SaltTraverserException("Cannot start traversing graph, because the graph is null.");
		}
		this.graph = graph;
	}

	public Builder2 startFrom(SNode... startNodes) {
		if ((startNodes == null) || (startNodes.length == 0)) {
			throw new SaltTraverserException(
					"Cannot start traversing graph '" + graph.getId() + "', because the given start nodes are empty.");
		}
		return startFrom(Arrays.asList(startNodes));
	}

	public Builder2 startFrom(List<SNode> startNodes) {
		if ((startNodes == null) || (startNodes.isEmpty())) {
			throw new SaltTraverserException(
					"Cannot start traversing graph '" + graph.getId() + "', because the given start nodes are empty.");
		}
		return new Builder2(graph, startNodes);
	}

	public static class Builder2 {
		private final SGraph graph;
		private final List<SNode> startNodes;

		public Builder2(SGraph graph, List<SNode> startNodes) {
			this.graph = graph;
			this.startNodes = startNodes;
		}

		public Builder3 useStrategy(TraversalStrategy strategy) {
			if (strategy == null) {
				throw new SaltTraverserException("Cannot start traversing graph '" + graph.getId()
						+ "', because the given traverseType is empty.");
			}
			return new Builder3(graph, startNodes, strategy);
		}
	}

	public static class Builder3 {
		private final SGraph graph;
		private final List<SNode> startNodes;
		private final TraversalStrategy strategy;
		private final Collection<TraversalFilter> filters = new ArrayList<>();
		private boolean isCycleSafe = true;
		private String id = null;

		public Builder3(SGraph graph, List<SNode> startNodes, TraversalStrategy strategy) {
			this.graph = graph;
			this.startNodes = startNodes;

			this.strategy = strategy;
		}

		public Builder3 cycleSafe(boolean isCycleSafe) {
			this.isCycleSafe = isCycleSafe;
			return this;
		}

		public Builder3 useId(String id) {
			this.id = id;
			return this;
		}

		public Builder3 filter(TraversalFilter filter) {
			if (filter != null) {
				filters.add(filter);
			}
			return this;
		}

		public void andCall(SimpleTraverseHandler handler) {
			if (handler == null) {
				throw new SaltTraverserException("Cannot start traversing graph '" + graph.getId()
						+ "', because the given callback handler 'traverseHandler' is empty.");
			}
			// if (TOP_DOWN_DEPTH_FIRST.equals(strategy)) {
			// new TopDownDepthFirstTraverser(startNodes, strategy, id, handler,
			// isCycleSafe, graph).traverse();
			// }
			// else if (TOP_DOWN_BREADTH_FIRST.equals(strategy)) {
			// new TopDownBreadthFirstTraverser(startNodes, strategy, id,
			// handler, isCycleSafe, graph).traverse();
			// } else if (BOTTOM_UP_DEPTH_FIRST.equals(strategy)) {
			// new BottomUpDepthFirstTraverser(startNodes, strategy, id,
			// handler, isCycleSafe, graph).traverse();
			// } else if (BOTTOM_UP_BREADTH_FIRST.equals(strategy)) {
			// new BottomUpBreadthFirstTraverser(startNodes, strategy, id,
			// handler, isCycleSafe, graph).traverse();
			// }
		}

		public void andCall(BackAndForthTraverseHandler handler) {
			if (handler == null) {
				throw new SaltTraverserException("Cannot start traversing graph '" + graph.getId()
						+ "', because the given callback handler 'traverseHandler' is empty.");
			}
			if (TOP_DOWN_DEPTH_FIRST.equals(strategy)) {
				new TopDownDepthFirstTraverser(startNodes, strategy, id, handler, isCycleSafe, graph, filters)
						.traverse();
			} else if (TOP_DOWN_BREADTH_FIRST.equals(strategy)) {
				new TopDownBreadthFirstTraverser(startNodes, strategy, id, handler, isCycleSafe, graph, filters)
						.traverse();
			} else if (BOTTOM_UP_DEPTH_FIRST.equals(strategy)) {
				new BottomUpDepthFirstTraverser(startNodes, strategy, id, handler, isCycleSafe, graph, filters)
						.traverse();
			} else if (BOTTOM_UP_BREADTH_FIRST.equals(strategy)) {
				new BottomUpBreadthFirstTraverser(startNodes, strategy, id, handler, isCycleSafe, graph, filters)
						.traverse();
			}
		}
	}
}
