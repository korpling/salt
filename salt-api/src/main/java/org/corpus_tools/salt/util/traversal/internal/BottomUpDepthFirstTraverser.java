package org.corpus_tools.salt.util.traversal.internal;

import java.util.List;

import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.exceptions.SaltInvalidModelException;
import org.corpus_tools.salt.exceptions.SaltParameterException;
import org.corpus_tools.salt.util.traversal.BackAndForthTraverseHandler;
import org.corpus_tools.salt.util.traversal.TraversalStrategy;

public class BottomUpDepthFirstTraverser extends Traverser {

	public BottomUpDepthFirstTraverser(List<? extends SNode> startNodes, TraversalStrategy strategy, String traverseId,
			BackAndForthTraverseHandler handler, boolean isCycleSafe, SGraph graph) {
		super(startNodes, strategy, traverseId, handler, isCycleSafe, graph);
	}

	@Override
	public void traverse() {
		for (SNode startNode : startNodes) {
			if (handler.checkConstraint(strategy, id, null, startNode, 0l)) {
				currentNodePath.add(startNode);
				bottomUpDepthFirstRec(null, 0);
			}
		}
	}

	private void bottomUpDepthFirstRec(SRelation<? extends SNode, ? extends SNode> edge, long order) {
		if (currentNodePath.isEmpty()) {
			throw new SaltParameterException("Cannot traverse node starting at empty start node.");
		}
		// current node is last element in currentPath
		SNode currNode = currentNodePath.get(currentNodePath.size() - 1);
		SNode child = null;
		if (currentNodePath.size() > 1) {
			// if current path is larger then 1, than a parent node exists
			child = currentNodePath.get(currentNodePath.size() - 1);
		}

		handler.nodeReached(strategy, id, currNode, edge, child, order);

		// walk through all childs of this node
		List<SRelation<? extends SNode, ? extends SNode>> parentEdges = graph.getInRelations(currNode.getId());
		// in case of node has parents
		int i = 0;
		for (SRelation<? extends SNode, ? extends SNode> parentEdge : parentEdges) {
			SNode parentNode = parentEdge.getSource();
			if ((isCycleSafe) && (currentNodePath.contains(parentNode))) {
				throw new SaltInvalidModelException(
						"A cycle in graph '" + graph.getId() + "' has been detected, while traversing with type '"
								+ strategy + "'. The cycle has been detected when visiting node '" + parentNode
								+ "' while current path was '" + currentNodePath + "'.");
			}
			currentNodePath.add(parentNode);
			if (handler.checkConstraint(strategy, id, parentEdge, parentNode, order)) {
				bottomUpDepthFirstRec(parentEdge, i);
				i++;
			}
			// remove last entry, to update current path
			currentNodePath.remove(currentNodePath.size() - 1);
		}

		handler.nodeLeft(strategy, id, currNode, edge, child, order);
	}

}
