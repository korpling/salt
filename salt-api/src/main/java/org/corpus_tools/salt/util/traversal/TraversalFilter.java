package org.corpus_tools.salt.util.traversal;

import java.util.function.Predicate;

import org.corpus_tools.salt.common.SSpan;
import org.corpus_tools.salt.common.SStructure;
import org.corpus_tools.salt.common.STextualDS;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.util.traversal.internal.NodeTypeFilter;
import org.corpus_tools.salt.util.traversal.internal.SkipCycles;

public abstract interface TraversalFilter extends Predicate<TraversalLocation> {
	public static TraversalFilter skipCycles() {
		return new SkipCycles();
	}

	public static TraversalFilter includeTextualDs() {
		return new NodeTypeFilter(STextualDS.class);
	}

	public static TraversalFilter includeTokens() {
		return new NodeTypeFilter(SToken.class);
	}

	public static TraversalFilter includeSpans() {
		return new NodeTypeFilter(SSpan.class);
	}

	public static TraversalFilter includeStructures() {
		return new NodeTypeFilter(SStructure.class);
	}
}
