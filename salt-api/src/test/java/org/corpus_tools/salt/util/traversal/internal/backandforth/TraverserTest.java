package org.corpus_tools.salt.util.traversal.internal.backandforth;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.util.SaltUtil;
import org.corpus_tools.salt.util.traversal.TraverseCallBackHandler;
import org.corpus_tools.salt.util.traversal.TraversalFilter;
import org.corpus_tools.salt.util.traversal.TraversalLocation;
import org.corpus_tools.salt.util.traversal.TraversalStrategy;

public abstract class TraverserTest implements TraverseCallBackHandler {
	protected SGraph graph;
	protected List<SNode> startNodes;
	protected final List<String> stopNodes = new ArrayList<>();
	protected TraversalStrategy strategy;
	protected boolean isCycleSafe = false;
	protected TraversalFilter traversalFilter = null;
	protected List<String> nodeOrderWayThere = new ArrayList<>();
	protected List<String> nodeOrderWayBack = new ArrayList<>();
	protected boolean preventRunInCycle = false;
	private final Stack<SNode> nodePath = new Stack<>();

	private boolean whenNodeWasReachedTwice(SNode currNode) {
		return nodePath.contains(currNode);
	}

	protected void when() {
		SaltUtil.traverse(graph)
				.startFrom(startNodes)
				.useStrategy(strategy)
				.filter(traversalFilter)
				.cycleSafe(isCycleSafe)
				.andCall(this);
	}

	@Override
	public boolean shouldTraversalGoOn(TraversalLocation location) {
		if (stopNodes.contains(location.getCurrentNode().getName())) {
			return false;
		}
		if (preventRunInCycle && whenNodeWasReachedTwice(location.getCurrentNode())) {
			return false;
		}
		return true;
	}

	@Override
	public void nodeReachedOnWayForth(TraversalLocation location) {
		if (!location.getFromNode().isPresent()) {
			nodePath.clear();
		}
		nodePath.push(location.getCurrentNode());
		nodeOrderWayThere.add(location.getCurrentNode().getName());
	}

	@Override
	public void nodeReachedOnWayBack(TraversalLocation location) {
		nodeOrderWayBack.add(location.getCurrentNode().getName());
	}
}
