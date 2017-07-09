package org.corpus_tools.salt.util.internal.traversal;

import java.util.ArrayList;
import java.util.List;

import org.corpus_tools.salt.core.GraphTraverseHandler;
import org.corpus_tools.salt.core.SGraph.GRAPH_TRAVERSE_TYPE;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.util.traversal.BackAndForthTraverseHandler;
import org.corpus_tools.salt.util.traversal.TraversalLocation;

public class MyTraverseHandler implements GraphTraverseHandler, BackAndForthTraverseHandler {
	List<String> nodeOrderWayThere = new ArrayList<>();
	List<String> nodeOrderWayBack = new ArrayList<>();

	@Override
	public void nodeReached(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode,
			SRelation<? extends SNode, ? extends SNode> relation, SNode fromNode, long order) {
		nodeOrderWayThere.add(currNode.getName());
	}

	@Override
	public void nodeLeft(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode,
			SRelation<? extends SNode, ? extends SNode> relation, SNode fromNode, long order) {
		nodeOrderWayBack.add(currNode.getName());
	}

	@Override
	public boolean checkConstraint(GRAPH_TRAVERSE_TYPE traversalType, String traversalId,
			SRelation<? extends SNode, ? extends SNode> relation, SNode currNode, long order) {
		return true;
	}

	@Override
	public boolean shouldTraversalGoOn(TraversalLocation location) {
		return true;
	}

	@Override
	public void nodeReachedOnWayForth(TraversalLocation location) {
		nodeOrderWayThere.add(location.getCurrentNode().getName());
	}

	@Override
	public void nodeReachedOnWayBack(TraversalLocation location) {
		nodeOrderWayBack.add(location.getCurrentNode().getName());
	}
}