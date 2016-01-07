/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
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
package de.hu_berlin.u.saltnpepper.salt.util.internal;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.slf4j.LoggerFactory;

import de.hu_berlin.u.saltnpepper.salt.core.GraphTraverseHandler;
import de.hu_berlin.u.saltnpepper.salt.core.SGraph;
import de.hu_berlin.u.saltnpepper.salt.core.SGraph.GRAPH_TRAVERSE_TYPE;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltException;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltInvalidModelException;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltParameterException;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltTraverserException;

/**
 * Handles the traversal of a graph.
 * 
 * @author Florian Zipser
 * 
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
	public void traverse(List<SNode> startNodes, GRAPH_TRAVERSE_TYPE traverseType, String traverseId, GraphTraverseHandler traverseHandler) {
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
	 * @param traverseType
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
	public void traverse(List<SNode> startNodes, GRAPH_TRAVERSE_TYPE traverseType, String traverseId, GraphTraverseHandler traverseHandler, boolean isCycleSafe) {
		if (getGraph() == null) {
			throw new SaltTraverserException("Cannot start traversing graph, because the graph is null.");
		}
		if ((startNodes == null) || (startNodes.size() == 0)) {
			throw new SaltTraverserException("Cannot start traversing graph '" + getGraph().getId() + "', because the given start nodes are empty.");
		}
		if (traverseType == null) {
			throw new SaltTraverserException("Cannot start traversing graph '" + getGraph().getId() + "', because the given traverseType is empty.");
		}
		if (traverseHandler == null) {
			throw new SaltTraverserException("Cannot start traversing graph '" + getGraph().getId() + "', because the given callback handler 'traverseHandler' is empty.");
		}

		// check if traverseId is already in use
		synchronized (traverseIdTable) {
			if (traverseIdTable.containsKey(traverseHandler)) {
				List<String> ids = traverseIdTable.get(traverseHandler);
				if (ids.contains(traverseId)) {
					throw new SaltTraverserException("Cannot start traversing graph '" + getGraph().getId() + "', because the traverse id '" + traverseId + "' is already registered for the given callback handler '" + traverseHandler + "'.");
				} else
					ids.add(traverseId);
			} else {
				// TODO replace this with HashEList
				List<String> ids = new ArrayList<>();
				ids.add(traverseId);
				traverseIdTable.put(traverseHandler, ids);
			}
		}
		Traverser traverser = new Traverser();
		traverser.startNodes = startNodes;
		traverser.traverseType = traverseType;
		traverser.traverseId = traverseId;
		traverser.traverseHandler = traverseHandler;
		traverser.isCycleSafe = isCycleSafe;
		traverser.setGraph(getGraph());

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

	/**
	 * A threadable class, which traverses the graph and invokes methods of the
	 * given callback handler during the traversal.
	 * 
	 * @author Florian Zipser
	 * 
	 */
	static class Traverser implements Runnable {
		/**
		 * list of nodes where traversal starts
		 */
		List<SNode> startNodes = null;
		/**
		 * kind of traversal
		 */
		GRAPH_TRAVERSE_TYPE traverseType = null;
		/**
		 * an identifier for identifying the current traversal process
		 */
		String traverseId = null;
		/**
		 * The callback handler on which the methods while traversal will be
		 * invoked.
		 */
		GraphTraverseHandler traverseHandler = null;

		/**
		 * If value is false, this object does not take care about cycles in
		 * traversion.
		 */
		boolean isCycleSafe = true;

		/**
		 * The graph to traverse.
		 */
		private SGraph graph = null;

		public void setGraph(SGraph graph) {
			this.graph = graph;
		}

		public SGraph getGraph() {
			return graph;
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
		 * Currently only used for
		 * {@link GRAPH_TRAVERSE_TYPE#TOP_DOWN_DEPTH_FIRST}. Single entries for
		 * a stack to stores the path, which has been used in traversal.
		 * Contains a node, a counter for the relation and order, in which child
		 * node the traversal currently is.
		 * 
		 * @author florian
		 * 
		 */
		private static class NodeEntry {
			private final SNode node;
			private int order;
			private Iterator<SRelation<SNode, SNode>> iterator;
			private SRelation<SNode, SNode> rel;

			public NodeEntry(SNode node, int order) {
				this.node = node;
				this.order = order;
			}

			public String toString() {
				return (((node != null) ? node.toString() : "") + ": " + order);
			}
		}

		/**
		 * Currently only used for
		 * {@link GRAPH_TRAVERSE_TYPE#TOP_DOWN_DEPTH_FIRST}. Basing on the given
		 * order in the passed {@link NodeEntry} element, this method checks if
		 * further children exist. If true, the next child is returned and the
		 * order counter of the passed element is increased by 1.
		 * 
		 * @param entry
		 * @return
		 */
		protected SNode nextChild(NodeEntry entry) {
			SNode retVal = null;

			if (entry.order == 0) {
				// set the iterator
				List<SRelation<SNode, SNode>> outRels = getGraph().getOutRelations(entry.node.getId());
				if ((outRels != null) && (!outRels.isEmpty())) {
					entry.iterator = outRels.iterator();
				}
			}

			// if we already have an iterator use it
			if (entry.iterator != null && entry.iterator.hasNext()) {
				try {
					entry.rel = entry.iterator.next();
					retVal = entry.rel.getTarget();
					entry.order++;
				} catch (ConcurrentModificationException ex) {
					LoggerFactory.getLogger(GraphTraverserModule.class).warn("Graph was changed during traversal", ex);
					// use fallback
					entry.iterator = null;
				}
			}

			// even if something went wrong with the iterator we should be still
			// able to execute the code (just with less performance)
			if (entry.iterator == null) {
				List<SRelation<SNode, SNode>> outRels = getGraph().getOutRelations(entry.node.getId());
				if ((outRels != null) && (!outRels.isEmpty())) {
					if (entry.order < outRels.size()) {
						entry.rel = outRels.get(entry.order);
						retVal = entry.rel.getTarget();
						entry.order++;
					}
				}
			}
			return (retVal);
		}

		/**
		 * Starts traversal, with set properties.
		 */
		public void run() {
			try {
				if (GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST.equals(traverseType)) {
					// TOP_DOWN_DEPTH_FIRST traversal
					for (SNode startNode : startNodes) {
						if (traverseHandler.checkConstraint(GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, traverseId, null, startNode, 0l)) {
							Set<SNode> visitedNodes = null;
							if (isCycleSafe) {
								// if checking for cycles is enabled, initialize
								// hashset
								visitedNodes = new HashSet<>();
							}
							Stack<NodeEntry> parentStack = new Stack<>();
							NodeEntry currentEntry = new NodeEntry(startNode, 0);
							while ((!parentStack.isEmpty()) || (currentEntry != null)) {
								if (currentEntry != null) {
									// way down
									if (isCycleSafe) {
										// check if cycle exists
										if (visitedNodes.contains(currentEntry.node)) {
											StringBuffer text = new StringBuffer();
											if (currentNodePath != null) {
												for (SNode node : currentNodePath) {
													if (node != null) {
														text.append(node.getId());
													} else {
														text.append("null");
													}
													text.append(" --> ");
												}
											}
											text.append(currentEntry.node.getId());
											throw new SaltInvalidModelException("A cycle in graph '" + graph.getId() + "' has been detected, while traversing with type '" + traverseType + "'. The cycle has been detected when visiting node '" + currentEntry.node + "' while current path was '" + text.toString() + "'.");
										}
									}
									NodeEntry peekEntry = null;
									if (!parentStack.isEmpty())
										peekEntry = parentStack.peek();
									parentStack.push(currentEntry);
									if (isCycleSafe) {
										// if checking for cycles is enabled,
										// add node to hashset
										visitedNodes.add(currentEntry.node);
									}
									SNode nextChild = nextChild(currentEntry);
									if (peekEntry == null) {
										traverseHandler.nodeReached(GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, traverseId, currentEntry.node, null, null, 0);
									} else {
										traverseHandler.nodeReached(GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, traverseId, currentEntry.node, peekEntry.rel, (peekEntry.rel != null) ? peekEntry.rel.getSource() : null, peekEntry.order);
									}
									if (nextChild != null) {
										if (traverseHandler.checkConstraint(GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, traverseId, currentEntry.rel, nextChild, currentEntry.order)) {
											currentEntry = new NodeEntry(nextChild, 0);
										} else {
											currentEntry = null;
										}
									} else {
										currentEntry = null;
									}
								} else {
									NodeEntry peekEntry = parentStack.peek();
									if (peekEntry != null) {
										SNode nextChild = nextChild(peekEntry);
										if (nextChild != null) {
											// way down, another branch was
											// found
											if (traverseHandler.checkConstraint(GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, traverseId, peekEntry.rel, nextChild, peekEntry.order)) {
												currentEntry = new NodeEntry(nextChild, 0);
											} else {
												currentEntry = null;
											}
										} else {// way up
											parentStack.pop();
											if (isCycleSafe) {
												// if checking for cycles is
												// enabled, remove node from
												// hashset
												visitedNodes.remove(peekEntry.node);
											}
											// collect stuff for notification
											SNode peekNode = peekEntry.node;
											peekEntry = null;
											if (!parentStack.isEmpty()) {
												peekEntry = parentStack.peek();
											}
											if (peekEntry == null) {
												traverseHandler.nodeLeft(GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, traverseId, peekNode, null, null, 0);
											} else {
												traverseHandler.nodeLeft(GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, traverseId, peekNode, peekEntry.rel, (peekEntry.rel != null) ? peekEntry.rel.getSource() : null, peekEntry.order);
											}
										}
									}
								}
							}

						}
					}
				} else if (GRAPH_TRAVERSE_TYPE.BOTTOM_UP_DEPTH_FIRST.equals(traverseType)) {
					// BOTTOM_UP_DEPTH_FIRST traversal
					for (SNode startNode : startNodes) {
						// TODO replace EList with HashEList
						currentNodePath = new ArrayList<>();
						if (traverseHandler.checkConstraint(GRAPH_TRAVERSE_TYPE.BOTTOM_UP_DEPTH_FIRST, traverseId, null, startNode, 0l)) {
							currentNodePath.add(startNode);
							bottomUpDepthFirstRec(null, 0);
						}
					}
				} else if (GRAPH_TRAVERSE_TYPE.TOP_DOWN_BREADTH_FIRST.equals(traverseType)) {
					// TOP_DOWN_BREADTH_FIRST traversal
					for (SNode startNode : startNodes) {
						// TODO replace EList with HashEList
						currentNodePath = new ArrayList<>();
						if (traverseHandler.checkConstraint(GRAPH_TRAVERSE_TYPE.TOP_DOWN_BREADTH_FIRST, traverseId, null, startNode, 0l)) {
							currentNodePath.add(startNode);
						}
					}
					breadthFirst();
				} else if (GRAPH_TRAVERSE_TYPE.BOTTOM_UP_BREADTH_FIRST.equals(traverseType)) {
					// BOTTOM_UP_BREADTH_FIRST traversal
					for (SNode startNode : startNodes) {
						// TODO replace EList with HashEList
						currentNodePath = new ArrayList<SNode>();
						if (traverseHandler.checkConstraint(GRAPH_TRAVERSE_TYPE.BOTTOM_UP_BREADTH_FIRST, traverseId, null, startNode, 0l)) {
							currentNodePath.add(startNode);
						}
					}
					breadthFirst();
				}

			} catch (SaltException e) {
				setException(e);
			} catch (Exception e2) {
				SaltException e = new SaltException("An exception occured while traversing the graph '" + graph.getId() + "' with path '" + currentNodePath + "'.", e2);
				setException(e);
			}
		}

		/**
		 * Traverses the graph in breadth first order. Relations are followed
		 * from source to target. If the {@link Traverser#traverseType} is (
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
			final boolean isTopDown = traverseType != GRAPH_TRAVERSE_TYPE.BOTTOM_UP_BREADTH_FIRST;
			SNode fromNode = null;
			SRelation<SNode, SNode> fromRel = null;
			// TODO replace EList with HashEList
			List<SNode> queuedNodes = new ArrayList<>();
			List<SNode> queueReachedFrom = new ArrayList<>();
			List<SRelation<SNode, SNode>> queueReachedFromRel = new ArrayList<>();
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

				List<SRelation<SNode, SNode>> edgesIn = getGraph().getInRelations(tNode.getId());
				List<SRelation<SNode, SNode>> edgesOut = getGraph().getOutRelations(tNode.getId());
				List<SRelation<SNode, SNode>> edges = null;
				currentNodePath.add(tNode);
				traverseHandler.nodeReached(traverseType, traverseId, tNode, fromRel, fromNode, order);
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
					for (SRelation<SNode, SNode> e : edges) {
						SNode n = null;
						n = (isTopDown) ? e.getTarget() : e.getSource();

						if (traverseHandler.checkConstraint(traverseType, traverseId, e, n, order)) {
							queuedNodes.add(n);
							queueReachedFrom.add(fromNode);
							queueReachedFromRel.add(e);
							queueReachedOrder.add(orderCount);
						}
						++orderCount;
					}
				}
				traverseHandler.nodeLeft(traverseType, traverseId, tNode, fromRel, fromNode, order);
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
		private void topDownDepthFirstRec(SRelation<SNode, SNode> rel, long order) {
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
			traverseHandler.nodeReached(GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, traverseId, currNode, rel, parent, order);
			// walk through all childs of this node
			List<SRelation<SNode, SNode>> childEdges = getGraph().getOutRelations(currNode.getId());
			if (childEdges != null) {
				// in case of node has childs
				int i = 0;
				for (SRelation<SNode, SNode> childRel : childEdges) {
					SNode childNode = childRel.getTarget();

					if (traverseHandler.checkConstraint(GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, traverseId, childRel, childNode, order)) {
						if ((isCycleSafe) && (currentNodePath.contains(childNode))) {

							StringBuffer text = new StringBuffer();
							for (SNode node : currentNodePath) {
								text.append(node.getId());
								text.append(" --> ");
							}
							text.append(childNode.getId());

							throw new SaltInvalidModelException("A cycle in graph '" + graph.getId() + "' has been detected, while traversing with type '" + traverseType + "'. The cycle has been detected when visiting node '" + childNode + "' while current path was '" + text.toString() + "'.");
						}

						currentNodePath.add(childNode);
						topDownDepthFirstRec(childRel, i);
						currentNodePath.remove(currentNodePath.size() - 1);

						i++;
					}
				}
			}

			traverseHandler.nodeLeft(GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, traverseId, currNode, rel, parent, order);
		}

		/**
		 * A recursive method, which traverses through the graph in bottom-up
		 * and depth-first order. That means, it walk through the graph in
		 * opposite direction of the edges and always expands the node i first,
		 * before a node i+1 will be expanded. This method is cycle-safe,
		 * therefore the variable currentNodePath is used.
		 * 
		 * @param edge
		 *            is the edge, via which the current node (last one in
		 *            currentPath) was reached
		 * @param order
		 *            number of current edge in list of all outgoing edges of
		 *            the child node
		 */
		private void bottomUpDepthFirstRec(SRelation<SNode, SNode> edge, long order) {
			if ((currentNodePath == null) || (currentNodePath.size() == 0)) {
				throw new SaltParameterException("Cannot traverse node starting at empty start node.");
			}
			// current node is last element in currentPath
			SNode currNode = currentNodePath.get(currentNodePath.size() - 1);
			SNode child = null;
			if (currentNodePath.size() > 1) {
				// if current path is larger then 1, than a parent node exists
				child = currentNodePath.get(currentNodePath.size() - 1);
			}

			traverseHandler.nodeReached(GRAPH_TRAVERSE_TYPE.BOTTOM_UP_DEPTH_FIRST, traverseId, currNode, edge, child, order);

			// walk through all childs of this node
			List<SRelation<SNode, SNode>> parentEdges = getGraph().getInRelations(currNode.getId());
			if (parentEdges != null) {
				// in case of node has parents
				int i = 0;
				for (SRelation<SNode, SNode> parentEdge : parentEdges) {
					SNode parentNode = parentEdge.getSource();
					if ((isCycleSafe) && (currentNodePath.contains(parentNode)))
						throw new SaltInvalidModelException("A cycle in graph '" + graph.getId() + "' has been detected, while traversing with type '" + traverseType + "'. The cycle has been detected when visiting node '" + parentNode + "' while current path was '" + currentNodePath + "'.");

					currentNodePath.add(parentNode);
					if (traverseHandler.checkConstraint(GRAPH_TRAVERSE_TYPE.BOTTOM_UP_DEPTH_FIRST, traverseId, parentEdge, parentNode, order)) {
						bottomUpDepthFirstRec(parentEdge, i);
						i++;
					}
					// remove last entry, to update current path
					currentNodePath.remove(currentNodePath.size() - 1);
				}

			}

			traverseHandler.nodeLeft(GRAPH_TRAVERSE_TYPE.BOTTOM_UP_DEPTH_FIRST, traverseId, currNode, edge, child, order);
		}
	}
}
