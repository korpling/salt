package org.corpus_tools.salt.util.traversal;

import org.corpus_tools.salt.common.SSpan;
import org.corpus_tools.salt.common.SStructure;
import org.corpus_tools.salt.common.STextualDS;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.core.SNode;

public class NodeTypeFilter implements TraversalFilter {
	public static final NodeTypeFilter INCLUDE_TEXTUALDS = new NodeTypeFilter(STextualDS.class);
	public static final NodeTypeFilter INCLUDE_TOKEN = new NodeTypeFilter(SToken.class);
	public static final NodeTypeFilter INCLUDE_SPAN = new NodeTypeFilter(SSpan.class);
	public static final NodeTypeFilter INCLUDE_STRUCTURE = new NodeTypeFilter(SStructure.class);
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
