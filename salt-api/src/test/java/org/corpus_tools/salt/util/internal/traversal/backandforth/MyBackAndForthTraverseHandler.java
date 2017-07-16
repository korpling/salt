package org.corpus_tools.salt.util.internal.traversal.backandforth;

import java.util.ArrayList;
import java.util.List;

import org.corpus_tools.salt.util.traversal.BackAndForthTraverseHandler;
import org.corpus_tools.salt.util.traversal.TraversalLocation;

public class MyBackAndForthTraverseHandler implements BackAndForthTraverseHandler {
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