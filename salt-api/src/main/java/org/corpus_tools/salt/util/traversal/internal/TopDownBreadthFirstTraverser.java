package org.corpus_tools.salt.util.traversal.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.exceptions.SaltException;
import org.corpus_tools.salt.util.traversal.ExcludeFilter;
import org.corpus_tools.salt.util.traversal.TraversalLocation;
import org.corpus_tools.salt.util.traversal.TraversalStrategy;
import org.corpus_tools.salt.util.traversal.TraverseCallBackHandler;

public class TopDownBreadthFirstTraverser extends Traverser {

	@Deprecated
	public TopDownBreadthFirstTraverser(List<? extends SNode> startNodes, TraversalStrategy strategy, String id,
			TraverseCallBackHandler handler, boolean isCycleSafe, SGraph graph, Collection<ExcludeFilter> filters) {
		super(startNodes, strategy, id, handler, isCycleSafe, graph, filters);
	}

	public TopDownBreadthFirstTraverser(List<? extends SNode> startNodes, TraversalStrategy strategy, String id,
			TraverseCallBackHandler handler, SGraph graph, Collection<ExcludeFilter> filters) {
		super(startNodes, strategy, id, handler, graph, filters);
	}

	@Override
	public void traverse() {
		if (isCycleSafe) {
			throw new SaltException("Not able to detect cycles with breadth first search");
		}
		startNodes.stream().forEach(startNode -> isIncludeNode(TraversalLocation.createWithStrategy(strategy)
				.withCurrentNode(startNode)
				.withRelationOrder(0)
				.withId(id)
				.build()));
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
		while (!queuedNodes.isEmpty()) {
			SNode tNode = queuedNodes.remove(0);
			fromNode = queueReachedFrom.remove(0);
			fromRel = queueReachedFromRel.remove(0);
			Integer order = queueReachedOrder.remove(0);

			List<SRelation<? extends SNode, ? extends SNode>> edgesOut = graph.getOutRelations(tNode.getId());
			List<SRelation<? extends SNode, ? extends SNode>> edges = null;
			handler.nodeReachedOnWayForth(TraversalLocation.createWithStrategy(strategy)
					.withCurrentNode(tNode)
					.withFromRelation(fromRel)
					.withFromNode(fromNode)
					.withId(id)
					.build());
			// Switching in and out nodes list
			edges = edgesOut;
			// in case of node has childs
			int orderCount = 0;
			for (SRelation<? extends SNode, ? extends SNode> fromRelation : edges) {
				SNode currentNode = null;
				currentNode = fromRelation.getTarget();
				if (isIncludeNode(TraversalLocation.createWithStrategy(strategy)
						.withCurrentNode(currentNode)
						.withFromRelation(fromRelation)
						.withRelationOrder(order)
						.withId(id)
						.build())) {
					queuedNodes.add(currentNode);
					queueReachedFrom.add(fromNode);
					queueReachedFromRel.add(fromRelation);
					queueReachedOrder.add(orderCount);
				}
				++orderCount;
			}
			handler.nodeReachedOnWayBack(TraversalLocation.createWithStrategy(strategy)
					.withCurrentNode(tNode)
					.withFromRelation(fromRel)
					.withFromNode(fromNode)
					.withRelationOrder(order)
					.withId(id)
					.build());
		}
	}
}
