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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.corpus_tools.salt.core.GraphTraverseHandler;
import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SGraph.GRAPH_TRAVERSE_TYPE;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.exceptions.SaltException;
import org.corpus_tools.salt.exceptions.SaltInvalidModelException;
import org.corpus_tools.salt.exceptions.SaltParameterException;
import org.corpus_tools.salt.exceptions.SaltTraverserException;

/**
 * Handles the traversal of a graph.
 */
public class GraphTraverserModule {
	/**
	 * Stores all used traverseIds to the corresponding traverse callback
	 * handler. This is used, to check, that an id is not used twice.
	 */
	private Map<GraphTraverseHandler, List<String>> traverseIdTable = new HashMap<>();

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

		// check if traverseId is already in use
		synchronized (traverseIdTable) {
			if (traverseIdTable.containsKey(traverseHandler)) {
				List<String> ids = traverseIdTable.get(traverseHandler);
				if (ids.contains(traverseId)) {
					throw new SaltTraverserException("Cannot start traversing graph '" + graph.getId()
							+ "', because the traverse id '" + traverseId
							+ "' is already registered for the given callback handler '" + traverseHandler + "'.");
				} else
					ids.add(traverseId);
			} else {
				// TODO replace this with HashEList
				List<String> ids = new ArrayList<>();
				ids.add(traverseId);
				traverseIdTable.put(traverseHandler, ids);
			}
		}
		Traverser traverser = new Traverser(startNodes, strategy, traverseId, traverseHandler, isCycleSafe, graph);
		traverser.run();

		// clean up traverseIdTable
		synchronized (traverseIdTable) {
			if (traverseIdTable.get(traverseHandler).size() > 1) {
				// only remove id
				traverseIdTable.get(traverseHandler).remove(traverseId);
			} else {
				// remove whole entry
				traverseIdTable.remove(traverseHandler);
			}
		}

		if (traverser.getException() != null) {
			// ckecks if an error occurs while traversal and throws it
			throw traverser.getException();
		}
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
		 * In Case of an exception occurs during traversal, it will be stored
		 * here, so that the calling method can check if the traversal finished
		 * successfully or with an error.
		 */
		private SaltException exception = null;

		private void setException(SaltException exception) {
			this.exception = exception;
		}

		/**
		 * In Case of an exception occurs during traversal, it will be stored
		 * here, so that the calling method can check if the traversal finished
		 * successfully or with an error.
		 * 
		 * @return
		 */
		public SaltException getException() {
			return exception;
		}

		/**
		 * Starts traversal, with set properties.
		 */
		public void run() {
			try {
				if (TOP_DOWN_DEPTH_FIRST.equals(strategy)) {
					new TopDownDepthFirstTraverser(startNodes, strategy, traverseId, traverseHandler, isCycleSafe,
							graph).traverse();
				} else if (TOP_DOWN_BREADTH_FIRST.equals(strategy)) {
					// TOP_DOWN_BREADTH_FIRST traversal
					for (SNode startNode : startNodes) {
						currentNodePath = new ArrayList<>();
						if (traverseHandler.checkConstraint(strategy, traverseId, null, startNode, 0l)) {
							currentNodePath.add(startNode);
						}
					}
					breadthFirst();
				} else if (BOTTOM_UP_DEPTH_FIRST.equals(strategy)) {
					new BottomUpDepthFirstTraverser(startNodes, strategy, traverseId, traverseHandler, isCycleSafe,
							graph).traverse();
				} else if (BOTTOM_UP_BREADTH_FIRST.equals(strategy)) {
					// BOTTOM_UP_BREADTH_FIRST traversal
					for (SNode startNode : startNodes) {
						currentNodePath = new ArrayList<SNode>();
						if (traverseHandler.checkConstraint(strategy, traverseId, null, startNode, 0l)) {
							currentNodePath.add(startNode);
						}
					}
					breadthFirst();
				}

			} catch (SaltException e) {
				setException(e);
			} catch (Exception e2) {
				SaltException e = new SaltException("An exception occured while traversing the graph '" + graph.getId()
						+ "' with path '" + currentNodePath + "'. because of " + e2.getMessage() + ". ", e2);
				setException(e);
			}
		}

		/**
		 * Traverses the graph in breadth first order. Relations are followed
		 * from source to target. If the {@link Traverser#strategy} is (
		 * {@link GRAPH_TRAVERSE_TYPE#BOTTOM_UP_BREADTH_FIRST}) relations are
		 * followed in their opposite direction. <br/>
		 * During the BFS {@link Traverser#currentNodePath} will only contain
		 * one node at most. The node most recently visited node. <br/>
		 * This function isn't able to detect cycles.
		 * 
		 * @param rel
		 *            is the relation, via which the current node (last one in
		 *            currentPath) was reached
		 * @param order
		 *            number of current relation in list of all outgoing
		 *            relations of the parent node
		 */
		private void breadthFirst() {
			if (isCycleSafe) {
				throw new SaltException("Not able to detect cycles with breadth first search");
			}
			if ((currentNodePath == null) || (currentNodePath.isEmpty())) {
				throw new SaltParameterException("Cannot traverse node starting at empty start node.");
			}
			final boolean isTopDown = strategy != GRAPH_TRAVERSE_TYPE.BOTTOM_UP_BREADTH_FIRST;
			SNode fromNode = null;
			SRelation<?, ?> fromRel = null;
			List<SNode> queuedNodes = new ArrayList<>();
			List<SNode> queueReachedFrom = new ArrayList<>();
			List<SRelation<? extends SNode, ? extends SNode>> queueReachedFromRel = new ArrayList<>();
			List<Integer> queueReachedOrder = new ArrayList<>();

			queuedNodes.addAll(startNodes);
			for (SNode startNode : startNodes) {
				queueReachedFrom.add(startNode);
				queueReachedFromRel.add(null);
				queueReachedOrder.add(0);
			}
			currentNodePath.clear();
			while (!queuedNodes.isEmpty()) {
				SNode tNode = queuedNodes.remove(0);
				fromNode = queueReachedFrom.remove(0);
				fromRel = queueReachedFromRel.remove(0);
				Integer order = queueReachedOrder.remove(0);

				List<SRelation<? extends SNode, ? extends SNode>> edgesIn = graph.getInRelations(tNode.getId());
				List<SRelation<? extends SNode, ? extends SNode>> edgesOut = graph.getOutRelations(tNode.getId());
				List<SRelation<? extends SNode, ? extends SNode>> edges = null;
				currentNodePath.add(tNode);
				traverseHandler.nodeReached(strategy, traverseId, tNode, fromRel, fromNode, order);
				if (isTopDown) {
					// Switching in and out nodes list
					edges = edgesOut;
				} else {
					edges = edgesIn;
					// edgesIn = edgesOut;
					// edgesOut = edges;
				}
				if (edges != null) {
					// in case of node has childs
					int orderCount = 0;
					for (SRelation<? extends SNode, ? extends SNode> e : edges) {
						SNode n = null;
						n = (isTopDown) ? e.getTarget() : e.getSource();

						if (traverseHandler.checkConstraint(strategy, traverseId, e, n, order)) {
							queuedNodes.add(n);
							queueReachedFrom.add(fromNode);
							queueReachedFromRel.add(e);
							queueReachedOrder.add(orderCount);
						}
						++orderCount;
					}
				}
				traverseHandler.nodeLeft(strategy, traverseId, tNode, fromRel, fromNode, order);
				currentNodePath.remove(0);
			}
		}

		/**
		 * Contains the path beginning from root node to current node.
		 */
		private List<SNode> currentNodePath = null;

		/**
		 * A recursive method, which traverses through the graph in top down and
		 * depth first order. That means, it follows the direction of the edges
		 * and always expands the node i first, before a node i+1 will be
		 * expanded. This method is cyclesafe, therefore the variable
		 * currentNodePath is used.
		 * 
		 * @param rel
		 *            is the edge, via which the current node (last one in
		 *            currentPath) was reached
		 * @param order
		 *            number of current edge in list of all outgoing edges of
		 *            the parent node
		 */
		private void topDownDepthFirstRec(SRelation<? extends SNode, ? extends SNode> rel, long order) {
			if ((currentNodePath == null) || (currentNodePath.size() == 0)) {
				throw new SaltParameterException("Cannot traverse node starting at empty start node.");
			}
			// current node is last element in currentPath
			SNode currNode = currentNodePath.get(currentNodePath.size() - 1);
			SNode parent = null;
			if (currentNodePath.size() > 1) {
				// if current path is larger then 1, than a parent node exists
				parent = currentNodePath.get(currentNodePath.size() - 2);
			}
			traverseHandler.nodeReached(strategy, traverseId, currNode, rel, parent, order);
			// walk through all childs of this node
			List<SRelation<? extends SNode, ? extends SNode>> childEdges = graph.getOutRelations(currNode.getId());
			if (childEdges != null) {
				// in case of node has childs
				int i = 0;
				for (SRelation<? extends SNode, ? extends SNode> childRel : childEdges) {
					SNode childNode = childRel.getTarget();

					if (traverseHandler.checkConstraint(strategy, traverseId, childRel, childNode, order)) {
						if ((isCycleSafe) && (currentNodePath.contains(childNode))) {

							StringBuffer text = new StringBuffer();
							for (SNode node : currentNodePath) {
								text.append(node.getId());
								text.append(" --> ");
							}
							text.append(childNode.getId());

							throw new SaltInvalidModelException("A cycle in graph '" + graph.getId()
									+ "' has been detected, while traversing with type '" + strategy
									+ "'. The cycle has been detected when visiting node '" + childNode
									+ "' while current path was '" + text.toString() + "'.");
						}

						currentNodePath.add(childNode);
						topDownDepthFirstRec(childRel, i);
						currentNodePath.remove(currentNodePath.size() - 1);

						i++;
					}
				}
			}

			traverseHandler.nodeLeft(strategy, traverseId, currNode, rel, parent, order);
		}
	}
}
