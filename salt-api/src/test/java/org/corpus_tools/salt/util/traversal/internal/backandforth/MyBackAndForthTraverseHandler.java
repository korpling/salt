package org.corpus_tools.salt.util.traversal.internal.backandforth;

import java.util.ArrayList;
import java.util.List;

import org.corpus_tools.salt.util.traversal.TraverseCallBackHandler;
import org.corpus_tools.salt.util.traversal.TraversalLocation;

public class MyBackAndForthTraverseHandler implements TraverseCallBackHandler {
	protected List<String> nodeOrderWayThere = new ArrayList<>();
	protected List<String> nodeOrderWayBack = new ArrayList<>();

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