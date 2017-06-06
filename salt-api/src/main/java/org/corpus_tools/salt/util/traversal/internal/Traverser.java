package org.corpus_tools.salt.util.traversal.internal;

import static org.corpus_tools.salt.core.SGraph.GRAPH_TRAVERSE_TYPE.BOTTOM_UP_BREADTH_FIRST;
import static org.corpus_tools.salt.core.SGraph.GRAPH_TRAVERSE_TYPE.BOTTOM_UP_DEPTH_FIRST;
import static org.corpus_tools.salt.core.SGraph.GRAPH_TRAVERSE_TYPE.TOP_DOWN_BREADTH_FIRST;
import static org.corpus_tools.salt.core.SGraph.GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST;

import java.util.Arrays;
import java.util.List;

import org.corpus_tools.salt.core.GraphTraverseHandler;
import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SGraph.GRAPH_TRAVERSE_TYPE;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.exceptions.SaltTraverserException;

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

	public static Builder create(SGraph graph) {
		return new Builder(graph);
	}

	public static class Builder {
		private final SGraph graph;

		public Builder(SGraph graph) {
			if (graph == null) {
				throw new SaltTraverserException("Cannot start traversing graph, because the graph is null.");
			}
			this.graph = graph;
		}

		public Builder2 startFrom(SNode... startNodes) {
			if ((startNodes == null) || (startNodes.length == 0)) {
				throw new SaltTraverserException("Cannot start traversing graph '" + graph.getId()
						+ "', because the given start nodes are empty.");
			}
			return new Builder2(graph, Arrays.asList(startNodes));
		}
	}

	public static class Builder2 {
		private final SGraph graph;
		private final List<SNode> startNodes;

		public Builder2(SGraph graph, List<SNode> startNodes) {
			this.graph = graph;
			this.startNodes = startNodes;
		}

		public Builder3 useStrategy(GRAPH_TRAVERSE_TYPE strategy) {
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
		private final GRAPH_TRAVERSE_TYPE strategy;
		boolean isCycleSafe = true;
		private String id = null;

		public Builder3(SGraph graph, List<SNode> startNodes, GRAPH_TRAVERSE_TYPE strategy) {
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

		public void andCall(GraphTraverseHandler traverseHandler) {
			if (traverseHandler == null) {
				throw new SaltTraverserException("Cannot start traversing graph '" + graph.getId()
						+ "', because the given callback handler 'traverseHandler' is empty.");
			}
			if (TOP_DOWN_DEPTH_FIRST.equals(strategy)) {
				new TopDownDepthFirstTraverser(startNodes, strategy, id, traverseHandler, isCycleSafe, graph)
						.traverse();
			} else if (TOP_DOWN_BREADTH_FIRST.equals(strategy)) {
				new TopDownBreadthFirstTraverser(startNodes, strategy, id, traverseHandler, isCycleSafe, graph)
						.traverse();
			} else if (BOTTOM_UP_DEPTH_FIRST.equals(strategy)) {
				new BottomUpDepthFirstTraverser(startNodes, strategy, id, traverseHandler, isCycleSafe, graph)
						.traverse();
			} else if (BOTTOM_UP_BREADTH_FIRST.equals(strategy)) {
				new BottomUpBreadthFirstTraverser(startNodes, strategy, id, traverseHandler, isCycleSafe, graph)
						.traverse();
			}
		}
	}
}
