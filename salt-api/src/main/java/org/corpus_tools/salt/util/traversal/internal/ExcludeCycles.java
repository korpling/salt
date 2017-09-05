package org.corpus_tools.salt.util.traversal.internal;

import java.util.HashSet;
import java.util.Set;

import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.util.traversal.ExcludeFilter;
import org.corpus_tools.salt.util.traversal.TraversalLocation;

/**
 * Prevents traversal running into a cycle. Whenever a cycle is detected (by
 * seeing a relation twice) it returns false on
 * {@link #test(TraversalLocation)}.
 */
public class ExcludeCycles implements ExcludeFilter {
	private final Set<SRelation<?, ?>> visitedRelations = new HashSet<>();

	@Override
	public boolean test(TraversalLocation location) {
		if (location.getFromRelation().isPresent()) {
			if (visitedRelations.contains(location.getFromRelation().get())) {
				return true;
			}
			visitedRelations.add(location.getFromRelation().get());
		} else {
			// current node must be root --> reset visited nodes
			visitedRelations.clear();
		}
		return false;
	}
}
