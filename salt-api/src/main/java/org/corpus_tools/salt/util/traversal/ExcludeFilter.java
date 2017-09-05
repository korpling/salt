package org.corpus_tools.salt.util.traversal;

import java.util.function.Predicate;

import org.corpus_tools.salt.common.SSpan;
import org.corpus_tools.salt.common.SStructure;
import org.corpus_tools.salt.common.STextualDS;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.util.traversal.internal.NodeTypeFilter;
import org.corpus_tools.salt.util.traversal.internal.ExcludeCycles;

public abstract interface ExcludeFilter extends Predicate<TraversalLocation> {
	public static ExcludeFilter skipCycles() {
		return new ExcludeCycles();
	}

	public static ExcludeFilter textualDs() {
		return new NodeTypeFilter(STextualDS.class);
	}

	public static ExcludeFilter excludeTokens() {
		return new NodeTypeFilter(SToken.class);
	}

	public static ExcludeFilter excludeSpans() {
		return new NodeTypeFilter(SSpan.class);
	}

	public static ExcludeFilter structures() {
		return new NodeTypeFilter(SStructure.class);
	}
}
