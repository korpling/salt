package org.corpus_tools.salt.core.impl;

import org.corpus_tools.salt.core.GraphTraverseHandler;
import org.corpus_tools.salt.core.SGraph.GRAPH_TRAVERSE_TYPE;
import org.corpus_tools.salt.util.traversal.BackAndForthTraverseHandler;
import org.corpus_tools.salt.util.traversal.TraversalLocation;
import org.corpus_tools.salt.util.traversal.TraversalStrategy;

@Deprecated
/**
 * Attention: This class is deprecated This is a wrapper between the old and the
 * new traverser. Use the following instead:
 * 
 * <pre>
 * SaltUtil.traverse(GRAPH_TO_BE_TRAVERSED)
 * 		.startFrom(NODES_TO_START_WITH)
 * 		.useStrategy(STRATEGY)
 * 		.cycleSafe(TRUE_OR_FALSE)
 * 		.useId(IDENTIFIER_FOR_TRAVERSAL_PROCESS)
 * 		.andCall(CALLBACK_HANDLER);
 * </pre>
 */
public class OldToNewTraverseHandler implements BackAndForthTraverseHandler {
	private final GraphTraverseHandler oldHandler;

	public OldToNewTraverseHandler(GraphTraverseHandler oldHandler) {
		this.oldHandler = oldHandler;
	}

	@Override
	public boolean shouldTraversalGoOn(TraversalLocation traversalLocation) {
		System.out.println("go-on: " + traversalLocation);
		return oldHandler.checkConstraint(strategyToType(traversalLocation.getStrategy()),
				traversalLocation.getId().orElse(null), traversalLocation.getFromRelation().orElse(null),
				traversalLocation.getCurrentNode(), traversalLocation.getRelationOrder());
	}

	@Override
	public void nodeReachedOnWayForth(TraversalLocation traversalLocation) {
		System.out.println("forth: " + traversalLocation);
		oldHandler.nodeReached(strategyToType(traversalLocation.getStrategy()), traversalLocation.getId().orElse(null),
				traversalLocation.getCurrentNode(), traversalLocation.getFromRelation().orElse(null),
				traversalLocation.getFromNode().orElse(null), traversalLocation.getRelationOrder());
	}

	@Override
	public void nodeReachedOnWayBack(TraversalLocation traversalLocation) {
		System.out.println("back: " + traversalLocation);
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
