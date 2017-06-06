package org.corpus_tools.salt.util.traversal.internal;

import java.util.ArrayList;
import java.util.List;

import org.corpus_tools.salt.core.GraphTraverseHandler;
import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SGraph.GRAPH_TRAVERSE_TYPE;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.exceptions.SaltException;
import org.corpus_tools.salt.exceptions.SaltParameterException;

public class BottomUpBreadthFirstTraverser extends Traverser {

	public BottomUpBreadthFirstTraverser(List<? extends SNode> startNodes, GRAPH_TRAVERSE_TYPE strategy,
			String traverseId, GraphTraverseHandler traverseHandler, boolean isCycleSafe, SGraph graph) {
		super(startNodes, strategy, traverseId, traverseHandler, isCycleSafe, graph);
	}

	@Override
	public void traverse() {
		for (SNode startNode : startNodes) {
			if (traverseHandler.checkConstraint(strategy, traverseId, null, startNode, 0l)) {
				currentNodePath.add(startNode);
			}
		}
		if (isCycleSafe) {
			throw new SaltException("Not able to detect cycles with breadth first search");
		}
		if (currentNodePath.isEmpty()) {
			throw new SaltParameterException("Cannot traverse node starting at empty start node.");
		}
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
			List<SRelation<? extends SNode, ? extends SNode>> edges = null;
			currentNodePath.add(tNode);
			traverseHandler.nodeReached(strategy, traverseId, tNode, fromRel, fromNode, order);
			edges = edgesIn;
			if (edges != null) {
				// in case of node has childs
				int orderCount = 0;
				for (SRelation<? extends SNode, ? extends SNode> e : edges) {
					SNode n = null;
					n = e.getSource();

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
}
