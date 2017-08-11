package org.corpus_tools.salt.util.traversal.internal;

import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.util.traversal.TraversalFilter;
import org.corpus_tools.salt.util.traversal.TraversalLocation;

public class NodeTypeFilter implements TraversalFilter {
	private final Class<? extends SNode> includedNodeClass;

	public NodeTypeFilter(Class<? extends SNode> includedNodeClass) {
		this.includedNodeClass = includedNodeClass;
	}

	@Override
	public boolean test(TraversalLocation location) {
		if (location == null) {
			throw new IllegalArgumentException("Cannot filter for node type when passed traversal location is null. ");
		}
		if (includedNodeClass.isAssignableFrom(location.getCurrentNode().getClass())) {
			return true;
		}
		return false;
	}
}
