package org.corpus_tools.salt.core.impl;

import org.corpus_tools.salt.core.GraphTraverseHandler;
import org.corpus_tools.salt.core.SGraph.GRAPH_TRAVERSE_TYPE;
import org.corpus_tools.salt.util.traversal.BackAndForthTraverseHandler;
import org.corpus_tools.salt.util.traversal.TraversalStrategy;
import org.corpus_tools.salt.util.traversal.internal.TraversalLocation;

public class OldToNewTraverseHandler implements BackAndForthTraverseHandler {
	private final GraphTraverseHandler oldHandler;

	public OldToNewTraverseHandler(GraphTraverseHandler oldHandler) {
		this.oldHandler = oldHandler;
	}

	@Override
	public boolean shouldTraversalGoOn(TraversalLocation traversalLocation) {
		return oldHandler.checkConstraint(strategyToType(traversalLocation.getStrategy()),
				traversalLocation.getId().orElse(null), traversalLocation.getFromRelation().orElse(null),
				traversalLocation.getCurrentNode(), traversalLocation.getRelationOrder());
	}

	@Override
	public void nodeReachedOnWayForth(TraversalLocation traversalLocation) {
		oldHandler.nodeReached(strategyToType(traversalLocation.getStrategy()), traversalLocation.getId().orElse(null),
				traversalLocation.getCurrentNode(), traversalLocation.getFromRelation().orElse(null),
				traversalLocation.getFromNode().orElse(null), traversalLocation.getRelationOrder());
	}

	@Override
	public void nodeReachedOnWayBack(TraversalLocation traversalLocation) {
		oldHandler.nodeLeft(strategyToType(traversalLocation.getStrategy()), traversalLocation.getId().orElse(null),
				traversalLocation.getCurrentNode(), traversalLocation.getFromRelation().orElse(null),
				traversalLocation.getFromNode().orElse(null), traversalLocation.getRelationOrder());
	}

	private GRAPH_TRAVERSE_TYPE strategyToType(TraversalStrategy strategy) {
		switch (strategy) {
		case TOP_DOWN_DEPTH_FIRST:
			return GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST;
		case TOP_DOWN_BREADTH_FIRST:
			return GRAPH_TRAVERSE_TYPE.TOP_DOWN_BREADTH_FIRST;
		case BOTTOM_UP_DEPTH_FIRST:
			return GRAPH_TRAVERSE_TYPE.BOTTOM_UP_DEPTH_FIRST;
		case BOTTOM_UP_BREADTH_FIRST:
			return GRAPH_TRAVERSE_TYPE.BOTTOM_UP_BREADTH_FIRST;
		default:
			return null;
		}
	}
}
