package org.corpus_tools.salt.util.traversal;

import java.util.function.Predicate;

import org.corpus_tools.salt.common.SSpan;
import org.corpus_tools.salt.common.SStructure;
import org.corpus_tools.salt.common.STextualDS;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.util.traversal.internal.NodeTypeFilter;

public abstract interface TraversalFilter extends Predicate<TraversalLocation> {
	public static final TraversalFilter INCLUDE_TEXTUALDS = new NodeTypeFilter(STextualDS.class);
	public static final TraversalFilter INCLUDE_TOKEN = new NodeTypeFilter(SToken.class);
	public static final TraversalFilter INCLUDE_SPAN = new NodeTypeFilter(SSpan.class);
	public static final TraversalFilter INCLUDE_STRUCTURE = new NodeTypeFilter(SStructure.class);

	// public static TraversalFilter includeToken() {
	// return new NodeTypeFilter(SToken.class);
	// }
}
