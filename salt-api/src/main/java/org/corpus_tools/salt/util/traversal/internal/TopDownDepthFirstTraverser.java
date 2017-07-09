package org.corpus_tools.salt.util.traversal.internal;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.exceptions.SaltInvalidModelException;
import org.corpus_tools.salt.util.traversal.BackAndForthTraverseHandler;
import org.corpus_tools.salt.util.traversal.TraversalLocation;
import org.corpus_tools.salt.util.traversal.TraversalStrategy;
import org.corpus_tools.salt.util.traversal.Traverser;

public class TopDownDepthFirstTraverser extends Traverser {
	protected static class NodeEntry {
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

	private final Set<SNode> visitedNodes = new HashSet<>();
	private final Stack<NodeEntry> parentStack = new Stack<>();
	private NodeEntry currentEntry;

	public TopDownDepthFirstTraverser(List<? extends SNode> startNodes, TraversalStrategy strategy, String traverseId,
			BackAndForthTraverseHandler handler, boolean isCycleSafe, SGraph graph) {
		super(startNodes, strategy, traverseId, handler, isCycleSafe, graph);
	}

	@Override
	public void traverse() {
		startNodes.stream().forEach(this::traverseNode);
	}

	public void traverseNode(SNode startNode) {
		if (!handler.shouldTraversalGoOn(TraversalLocation.createWithStrategy(strategy)
				.withCurrentNode(startNode)
				.withRelationOrder(0)
				.withId(id)
				.build())) {
			return;
		}
		currentEntry = new NodeEntry(startNode, 0);
		while ((!parentStack.isEmpty()) || (currentEntry != null)) {
			if (currentEntry != null) {
				case1();
			} else {
				case2();
			}
		}
	}

	private void case1() {
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
				throw new SaltInvalidModelException(
						"A cycle in graph '" + graph.getId() + "' has been detected, while traversing with type '"
								+ strategy + "'. The cycle has been detected when visiting node '" + currentEntry.node
								+ "' while current path was '" + text.toString() + "'.");
			}
		}
		NodeEntry peekEntry = null;
		if (!parentStack.isEmpty()) {
			peekEntry = parentStack.peek();
		}
		parentStack.push(currentEntry);
		if (isCycleSafe) {
			// if checking for cycles is enabled, add node to hashset
			visitedNodes.add(currentEntry.node);
		}
		SNode nextChild = nextChild(currentEntry);
		if (peekEntry == null) {
			handler.nodeReachedOnWayForth(TraversalLocation.createWithStrategy(strategy)
					.withCurrentNode(currentEntry.node)
					.withRelationOrder(0)
					.withId(id)
					.build());
		} else {
			handler.nodeReachedOnWayForth(TraversalLocation.createWithStrategy(strategy)
					.withCurrentNode(currentEntry.node)
					.withFromRelation(peekEntry.rel)
					.withFromNode(peekEntry.rel != null ? peekEntry.rel.getSource() : null)
					.withRelationOrder(peekEntry.order)
					.withId(id)
					.build());
		}
		if (nextChild != null) {
			if (handler.shouldTraversalGoOn(TraversalLocation.createWithStrategy(strategy)
					.withCurrentNode(nextChild)
					.withFromRelation(currentEntry.rel)
					.withRelationOrder(currentEntry.order)
					.withId(id)
					.build())) {
				currentEntry = new NodeEntry(nextChild, 0);
			} else {
				currentEntry = null;
			}
		} else {
			currentEntry = null;
		}
	}

	private void case2() {
		NodeEntry peekEntry = parentStack.peek();
		if (peekEntry != null) {
			SNode nextChild = nextChild(peekEntry);
			if (nextChild != null) {
				// way down, another branch was found
				if (handler.shouldTraversalGoOn(TraversalLocation.createWithStrategy(strategy)
						.withCurrentNode(nextChild)
						.withFromRelation(peekEntry.rel)
						.withRelationOrder(peekEntry.order)
						.withId(id)
						.build())) {
					currentEntry = new NodeEntry(nextChild, 0);
				} else {
					currentEntry = null;
				}
			} else {// way up
				parentStack.pop();
				if (isCycleSafe) {
					// if checking for cycles is enabled, remove node from
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
					handler.nodeReachedOnWayBack(TraversalLocation.createWithStrategy(strategy)
							.withCurrentNode(peekNode)
							.withRelationOrder(0)
							.withId(id)
							.build());
				} else {
					handler.nodeReachedOnWayBack(TraversalLocation.createWithStrategy(strategy)
							.withCurrentNode(peekNode)
							.withFromRelation(peekEntry.rel)
							.withFromNode(peekEntry.rel != null ? peekEntry.rel.getSource() : null)
							.withId(id)
							.build());
				}
			}
		}
	}

	private SNode nextChild(NodeEntry entry) {
		SNode retVal = null;

		if (entry.order == 0) {
			// set the iterator
			List<SRelation<?, ?>> outRels = graph.getOutRelations(entry.node.getId());
			if ((outRels != null) && (!outRels.isEmpty())) {
				entry.iterator = outRels.iterator();
			}
		}

		// if we already have an iterator use it
		if (entry.iterator != null && entry.iterator.hasNext()) {
			entry.rel = entry.iterator.next();
			retVal = entry.rel.getTarget();
			entry.order++;
		}

		// even if something went wrong with the iterator we should be still
		// able to execute the code (just with less performance)
		if (entry.iterator == null) {
			List<SRelation<? extends SNode, ? extends SNode>> outRels = graph.getOutRelations(entry.node.getId());
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
