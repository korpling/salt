/**
 * Copyright 2009 Humboldt-Universität zu Berlin.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
package org.corpus_tools.salt.core.impl;

import static org.corpus_tools.salt.core.SGraph.GRAPH_TRAVERSE_TYPE.BOTTOM_UP_BREADTH_FIRST;
import static org.corpus_tools.salt.core.SGraph.GRAPH_TRAVERSE_TYPE.BOTTOM_UP_DEPTH_FIRST;
import static org.corpus_tools.salt.core.SGraph.GRAPH_TRAVERSE_TYPE.TOP_DOWN_BREADTH_FIRST;
import static org.corpus_tools.salt.core.SGraph.GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST;

import java.util.List;

import org.corpus_tools.salt.core.GraphTraverseHandler;
import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SGraph.GRAPH_TRAVERSE_TYPE;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.exceptions.SaltInvalidModelException;
import org.corpus_tools.salt.exceptions.SaltTraverserException;

/**
 * Handles the traversal of a graph.
 */
public class GraphTraverserModule {
	protected SGraph graph = null;

	public SGraph getGraph() {
		return graph;
	}

	public void setGraph(SGraph graph) {
		this.graph = graph;
	}

	/**
	 * Traverses a graph in the given order traverseType and starts traversing
	 * with the given startNodes. When a node is reached, first this method will
	 * invoke the method
	 * {@link GraphTraverseHandler#checkConstraint(GRAPH_TRAVERSE_TYPE, String, SRelation, SNode, long)}
	 * of the given callback handler traverseHandler, second the method
	 * {@link GraphTraverseHandler#nodeReached(GRAPH_TRAVERSE_TYPE, String, SNode, SRelation, SNode, long)}
	 * is invoked. When a node was left, the method
	 * {@link GraphTraverseHandler#nodeLeft(GRAPH_TRAVERSE_TYPE, String, SNode, SRelation, SNode, long)}
	 * is invoked. When calling these methods, the traverseId will be passed, so
	 * that the callback handler knows which traversal is meant. This is
	 * helpful, in case of a single callback handler is used for more than one
	 * traversal at the same time. This method throws a
	 * {@link SaltInvalidModelException} in case of the graph contains a cycle.
	 * A cycle means a path containing the same node twice. Cycle safe breadth
	 * first traversing could consume a lot of memory because the algorithm
	 * keeps a map of all visited Nodes for every start node.
	 * 
	 * @param startNodes
	 *            list of nodes at which the traversal shall start
	 * @param traverseType
	 *            type of traversing
	 * @param traverseId
	 *            identification for callback handler, in case of more than one
	 *            traversal is running at the same time with the same callback
	 *            handler
	 * @param traverseHandler
	 *            callback handler, on which the three methods will be invoked
	 */
	public void traverse(List<SNode> startNodes, GRAPH_TRAVERSE_TYPE traverseType, String traverseId,
			GraphTraverseHandler traverseHandler) {
		traverse(startNodes, traverseType, traverseId, traverseHandler, true);
	}

	/**
	 * Traverses a graph in the given order traverseType and starts traversing
	 * with the given startNodes. When a node is reached, first this method will
	 * invoke the method
	 * {@link GraphTraverseHandler#checkConstraint(GRAPH_TRAVERSE_TYPE, String, SRelation, SNode, long)}
	 * of the given callback handler traverseHandler, second the method
	 * {@link GraphTraverseHandler#nodeReached(GRAPH_TRAVERSE_TYPE, String, SNode, SRelation, SNode, long)}
	 * is invoked. When a node was left, the method
	 * {@link GraphTraverseHandler#nodeLeft(GRAPH_TRAVERSE_TYPE, String, SNode, SRelation, SNode, long)}
	 * is invoked. When calling these methods, the traverseId will be passed, so
	 * that the callback handler knows which traversal is meant. This is
	 * helpful, in case of a single callback handler is used for more than one
	 * traversal at the same time. This method throws a
	 * {@link SaltInvalidModelException} in case of the graph contains a cycle.
	 * A cycle means a path containing the same node twice. Cycle safe breadth
	 * first traversing could consume a lot of memory because the algorithm
	 * keeps a map of all visited Nodes for every start node.
	 * 
	 * @param startNodes
	 *            list of nodes at which the traversal shall start
	 * @param strategy
	 *            type of traversing
	 * @param traverseId
	 *            identification for callback handler, in case of more than one
	 *            traversal is running at the same time with the same callback
	 *            handler
	 * @param traverseHandler
	 *            callback handler, on which the three methods will be invoked
	 * @param isCycleSafe
	 *            if this value is false, this method does not take care about
	 *            cycles. This can invoke endless loops.
	 */
	public void traverse(List<? extends SNode> startNodes, GRAPH_TRAVERSE_TYPE strategy, String traverseId,
			GraphTraverseHandler traverseHandler, boolean isCycleSafe) {
		if (graph == null) {
			throw new SaltTraverserException("Cannot start traversing graph, because the graph is null.");
		}
		if ((startNodes == null) || (startNodes.size() == 0)) {
			throw new SaltTraverserException(
					"Cannot start traversing graph '" + graph.getId() + "', because the given start nodes are empty.");
		}
		if (strategy == null) {
			throw new SaltTraverserException(
					"Cannot start traversing graph '" + graph.getId() + "', because the given traverseType is empty.");
		}
		if (traverseHandler == null) {
			throw new SaltTraverserException("Cannot start traversing graph '" + graph.getId()
					+ "', because the given callback handler 'traverseHandler' is empty.");
		}

		Traverser traverser = new Traverser(startNodes, strategy, traverseId, traverseHandler, isCycleSafe, graph);
		traverser.run();
	}

	static class Traverser {
		private final List<? extends SNode> startNodes;
		private final GRAPH_TRAVERSE_TYPE strategy;
		private final String traverseId;
		private final GraphTraverseHandler traverseHandler;
		private final boolean isCycleSafe;
		private SGraph graph;

		public Traverser(List<? extends SNode> startNodes, GRAPH_TRAVERSE_TYPE strategy, String traverseId,
				GraphTraverseHandler traverseHandler, boolean isCycleSafe, SGraph graph) {
			this.startNodes = startNodes;
			this.strategy = strategy;
			this.traverseId = traverseId;
			this.traverseHandler = traverseHandler;
			this.isCycleSafe = isCycleSafe;
			this.graph = graph;
		}

		/**
		 * Starts traversal, with set properties.
		 */
		public void run() {
			if (TOP_DOWN_DEPTH_FIRST.equals(strategy)) {
				new TopDownDepthFirstTraverser(startNodes, strategy, traverseId, traverseHandler, isCycleSafe, graph)
						.traverse();
			} else if (TOP_DOWN_BREADTH_FIRST.equals(strategy)) {
				new TopDownBreadthFirstTraverser(startNodes, strategy, traverseId, traverseHandler, isCycleSafe, graph)
						.traverse();
			} else if (BOTTOM_UP_DEPTH_FIRST.equals(strategy)) {
				new BottomUpDepthFirstTraverser(startNodes, strategy, traverseId, traverseHandler, isCycleSafe, graph)
						.traverse();
			} else if (BOTTOM_UP_BREADTH_FIRST.equals(strategy)) {
				new BottomUpBreadthFirstTraverser(startNodes, strategy, traverseId, traverseHandler, isCycleSafe, graph)
						.traverse();
			}
		}
	}
}
