package org.corpus_tools.salt.util.traversal.internal;

import java.util.HashSet;
import java.util.Set;

import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.util.traversal.TraversalFilter;
import org.corpus_tools.salt.util.traversal.TraversalLocation;

/**
 * Prevents traversal running into a cycle. Whenever a cycle is detected (by
 * seeing a relation twice) it returns false on
 * {@link #test(TraversalLocation)}.
 */
public class SkipCycles implements TraversalFilter {
	private final Set<SRelation<?, ?>> visitedRelations = new HashSet<>();

	@Override
	public boolean test(TraversalLocation location) {
		if (location.getFromRelation().isPresent()) {
			if (visitedRelations.contains(location.getFromRelation().get())) {
				return false;
			}
			visitedRelations.add(location.getFromRelation().get());
		}
		return true;
	}
}
