package org.corpus_tools.salt.util.traversal.internal;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.StringJoiner;

import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.exceptions.SaltInvalidModelException;
import org.corpus_tools.salt.util.SaltUtil;
import org.corpus_tools.salt.util.traversal.BackAndForthTraverseHandler;
import org.corpus_tools.salt.util.traversal.SimpleTraverseHandler;
import org.corpus_tools.salt.util.traversal.TraversalLocation;
import org.corpus_tools.salt.util.traversal.TraversalStrategy;
import org.corpus_tools.salt.util.traversal.Traverser;

public class TopDownDepthFirstTraverser extends Traverser {
	protected static class NodeWithOrder {
		private final SNode node;
		private int order;
		private Iterator<SRelation<? extends SNode, ? extends SNode>> iterator;
		private SRelation<? extends SNode, ? extends SNode> rel;

		public NodeWithOrder(SNode node, int order) {
			this.node = node;
			this.order = order;
		}

		public String toString() {
			return (((node != null) ? node.toString() : "") + ": " + order);
		}
	}

	private final Set<SNode> visitedNodes = new HashSet<>();
	private final Stack<NodeWithOrder> parentStack = new Stack<>();
	private NodeWithOrder currentEntry;

	public TopDownDepthFirstTraverser(List<? extends SNode> startNodes, TraversalStrategy strategy, String traverseId,
			BackAndForthTraverseHandler handler, boolean isCycleSafe, SGraph graph) {
		super(startNodes, strategy, traverseId, handler, isCycleSafe, graph);
	}

	public TopDownDepthFirstTraverser(List<? extends SNode> startNodes, TraversalStrategy strategy, String traverseId,
			SimpleTraverseHandler simpleHandler, boolean isCycleSafe, SGraph graph) {
		super(startNodes, strategy, traverseId, simpleHandler, isCycleSafe, graph);
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
		currentEntry = new NodeWithOrder(startNode, 0);
		while ((!parentStack.isEmpty()) || (currentEntry != null)) {
			if (currentEntry != null) {
				wayForth();
			} else {
				wayBack();
			}
		}
	}

	private void wayForth() {
		whenGraphContainsCycleThrowExcpetion(currentEntry.node);
		NodeWithOrder peekEntry = parentStack.isEmpty() ? null : parentStack.peek();
		parentStack.push(currentEntry);
		if (isCycleSafe) {
			// if checking for cycles is enabled, add node to hashset
			visitedNodes.add(currentEntry.node);
		}
		SNode nextChild = nextChild(currentEntry);
		TraversalLocation location;
		if (peekEntry == null) {
			location = TraversalLocation.createWithStrategy(strategy)
					.withCurrentNode(currentEntry.node)
					.withRelationOrder(0)
					.withId(id)
					.build();

		} else {
			location = TraversalLocation.createWithStrategy(strategy)
					.withCurrentNode(currentEntry.node)
					.withFromRelation(peekEntry.rel)
					.withFromNode(peekEntry.rel != null ? peekEntry.rel.getSource() : null)
					.withRelationOrder(peekEntry.order)
					.withId(id)
					.build();
		}
		handler.nodeReachedOnWayForth(location);
		if (nextChild != null) {
			if (handler.shouldTraversalGoOn(TraversalLocation.createWithStrategy(strategy)
					.withCurrentNode(nextChild)
					.withFromRelation(currentEntry.rel)
					.withRelationOrder(currentEntry.order)
					.withId(id)
					.build())) {
				currentEntry = new NodeWithOrder(nextChild, 0);
			} else {
				currentEntry = null;
			}
		} else {
			currentEntry = null;
		}
	}

	private void whenGraphContainsCycleThrowExcpetion(SNode currentNode) {
		if (isCycleSafe && visitedNodes.contains(currentNode)) {
			StringJoiner joiner = new StringJoiner(" -> ");
			visitedNodes.stream().map(SNode::getId).forEach(joiner::add);
			joiner.add(currentNode.getId());
			throw new SaltInvalidModelException(
					"A cycle in graph '" + graph.getId() + "' has been detected, while traversing with type '"
							+ strategy + "'. The cycle has been detected when visiting node '" + currentNode
							+ "' while current path was '" + joiner.toString() + "'.");
		}
	}

	private void wayBack() {
		NodeWithOrder peekEntry = parentStack.peek();
		if (peekEntry == null) {
			return;
		}
		SNode nextChild = nextChild(peekEntry);
		if (nextChild != null) {
			// way down, another branch was found
			if (handler.shouldTraversalGoOn(TraversalLocation.createWithStrategy(strategy)
					.withCurrentNode(nextChild)
					.withFromRelation(peekEntry.rel)
					.withRelationOrder(peekEntry.order)
					.withId(id)
					.build())) {
				currentEntry = new NodeWithOrder(nextChild, 0);
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
			peekEntry = parentStack.isEmpty() ? null : parentStack.peek();
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

	private SNode nextChild(NodeWithOrder entry) {
		SNode nextChild = null;
		if (entry.order == 0) {
			// set the iterator
			List<SRelation<?, ?>> outRels = graph.getOutRelations(entry.node.getId());
			if (SaltUtil.isNotNullOrEmpty(outRels)) {
				entry.iterator = outRels.iterator();
			}
		}

		// if we already have an iterator use it
		if (entry.iterator != null && entry.iterator.hasNext()) {
			entry.rel = entry.iterator.next();
			nextChild = entry.rel.getTarget();
			entry.order++;
		}

		// TODO: check whether this can be removed
		// even if something went wrong with the iterator we should be still
		// able to execute the code (just with less performance)
		if (entry.iterator == null) {
			List<SRelation<? extends SNode, ? extends SNode>> outRels = graph.getOutRelations(entry.node.getId());
			if (SaltUtil.isNotNullOrEmpty(outRels)) {
				if (entry.order < outRels.size()) {
					entry.rel = outRels.get(entry.order);
					nextChild = entry.rel.getTarget();
					entry.order++;
				}
			}
		}
		return (nextChild);
	}
}
