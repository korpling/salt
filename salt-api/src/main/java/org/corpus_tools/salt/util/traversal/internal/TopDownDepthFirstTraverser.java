package org.corpus_tools.salt.util.traversal.internal;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
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
	class NodeWithOrder {
		private final SNode node;
		private final SRelation<? extends SNode, ? extends SNode> fromRelation;
		private final List<SRelation<? extends SNode, ? extends SNode>> outRels;
		private final int order;
		private int nextChildOrder = 0;

		public NodeWithOrder(SNode node) {
			this(node, null, 0);
		}

		public NodeWithOrder(SNode node, SRelation<? extends SNode, ? extends SNode> fromRelation, int order) {
			this.node = node;
			this.fromRelation = fromRelation;
			this.order = order;
			outRels = graph.getOutRelations(node.getId());
		}

		public Optional<NodeWithOrder> nextChild() {
			if (SaltUtil.isNullOrEmpty(outRels)) {
				return Optional.empty();
			}
			if (outRels.size() <= nextChildOrder) {
				return Optional.empty();
			}
			SRelation<? extends SNode, ? extends SNode> nextRelation = outRels.get(nextChildOrder);
			nextChildOrder++;
			return Optional.of(new NodeWithOrder(nextRelation.getTarget(), nextRelation, nextChildOrder));
		}

		@Override
		public String toString() {
			return node.toString();
		}
	}

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
		boolean wayForth = true;
		final Set<SNode> visitedNodes = new LinkedHashSet<>();
		final Stack<NodeWithOrder> nodePath = new Stack<>();
		nodePath.push(new NodeWithOrder(startNode));
		while (!nodePath.isEmpty()) {
			NodeWithOrder currentNode = nodePath.peek();
			Optional<NodeWithOrder> nextChild = currentNode.nextChild();
			if (!wayForth && nextChild.isPresent()) {
				nodePath.push(nextChild.get());
				wayForth = true;
				continue;
			}
			TraversalLocation location = TraversalLocation.createWithStrategy(strategy)
					.withCurrentNode(currentNode.node)
					.withFromRelation(currentNode.fromRelation)
					.withFromNode(currentNode.fromRelation != null ? currentNode.fromRelation.getSource() : null)
					.withRelationOrder(currentNode.order)
					.withId(id)
					.build();

			if (wayForth && !handler.shouldTraversalGoOn(location)) {
				// if (!handler.shouldTraversalGoOn(location)) {
				nodePath.pop();
				visitedNodes.remove(currentNode.node);
				wayForth = false;
				continue;
			}

			if (isCycleSafe && wayForth) {
				whenGraphContainsCycleThrowExcpetion(currentNode.node, visitedNodes);
				visitedNodes.add(currentNode.node);
			}

			if (nextChild.isPresent()) {
				handler.nodeReachedOnWayForth(location);
				nodePath.push(nextChild.get());
				wayForth = true;
			} else {
				if (wayForth) {
					// node is a leaf node
					handler.nodeReachedOnWayForth(location);
				}
				handler.nodeReachedOnWayBack(location);
				nodePath.pop();
				visitedNodes.remove(currentNode.node);
				wayForth = false;
			}
		}
	}

	private void whenGraphContainsCycleThrowExcpetion(SNode currentNode, Set<SNode> visitedNodes) {
		if (visitedNodes.contains(currentNode)) {
			StringJoiner joiner = new StringJoiner(" -> ");
			visitedNodes.stream().map(SNode::getId).forEach(joiner::add);
			joiner.add(currentNode.getId());
			throw new SaltInvalidModelException(
					"A cycle in graph '" + graph.getId() + "' has been detected, while traversing with type '"
							+ strategy + "'. The cycle has been detected when visiting node '" + currentNode
							+ "' while current path was '" + joiner.toString() + "'.");
		}
	}
}
