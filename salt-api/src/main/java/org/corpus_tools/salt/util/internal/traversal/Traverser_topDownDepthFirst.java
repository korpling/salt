package org.corpus_tools.salt.util.internal.traversal;

import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.corpus_tools.salt.core.GraphTraverseHandler;
import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SGraph.GRAPH_TRAVERSE_TYPE;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.core.impl.GraphTraverserModule;
import org.corpus_tools.salt.exceptions.SaltException;
import org.corpus_tools.salt.exceptions.SaltInvalidModelException;
import org.slf4j.LoggerFactory;

public class Traverser_topDownDepthFirst {
	private List<? extends SNode> startNodes = null;
	GRAPH_TRAVERSE_TYPE traverseType = null;
	String traverseId = null;
	GraphTraverseHandler traverseHandler = null;
	boolean isCycleSafe = true;
	private List<SNode> currentNodePath = null;

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

	public void blub() {
		try {
			bla();
		} catch (SaltException e) {
			throw e;
		} catch (Exception e2) {
			throw new SaltException("An exception occured while traversing the graph '" + graph.getId()
					+ "' with path '" + currentNodePath + "'. because of " + e2.getMessage() + ". ", e2);
		}
	}

	public void bla() {
		if (GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST.equals(traverseType)) {
			// TOP_DOWN_DEPTH_FIRST traversal
			for (SNode startNode : startNodes) {
				if (traverseHandler.checkConstraint(GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, traverseId, null,
						startNode, 0l)) {
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
									throw new SaltInvalidModelException("A cycle in graph '" + graph.getId()
											+ "' has been detected, while traversing with type '" + traverseType
											+ "'. The cycle has been detected when visiting node '" + currentEntry.node
											+ "' while current path was '" + text.toString() + "'.");
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
								traverseHandler.nodeReached(GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, traverseId,
										currentEntry.node, null, null, 0);
							} else {
								traverseHandler.nodeReached(GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, traverseId,
										currentEntry.node, peekEntry.rel,
										(peekEntry.rel != null) ? peekEntry.rel.getSource() : null, peekEntry.order);
							}
							if (nextChild != null) {
								if (traverseHandler.checkConstraint(GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST,
										traverseId, currentEntry.rel, nextChild, currentEntry.order)) {
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
									if (traverseHandler.checkConstraint(GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST,
											traverseId, peekEntry.rel, nextChild, peekEntry.order)) {
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
										traverseHandler.nodeLeft(GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, traverseId,
												peekNode, null, null, 0);
									} else {
										traverseHandler.nodeLeft(GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, traverseId,
												peekNode, peekEntry.rel,
												(peekEntry.rel != null) ? peekEntry.rel.getSource() : null,
												peekEntry.order);
									}
								}
							}
						}
					}

				}
			}
		}
	}

	private static class NodeEntry {
		private final SNode node;
		private int order;
		private Iterator<SRelation<? extends SNode, ? extends SNode>> iterator;
		private SRelation<? extends SNode, ? extends SNode> rel;

		public NodeEntry(SNode node, int order) {
			this.node = node;
			this.order = order;
		}

		public String toString() {
			return (((node != null) ? node.toString() : "") + ": " + order);
		}
	}

	protected SNode nextChild(NodeEntry entry) {
		SNode retVal = null;

		if (entry.order == 0) {
			// set the iterator
			List<SRelation<?, ?>> outRels = getGraph().getOutRelations(entry.node.getId());
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
			List<SRelation<? extends SNode, ? extends SNode>> outRels = getGraph().getOutRelations(entry.node.getId());
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
}
