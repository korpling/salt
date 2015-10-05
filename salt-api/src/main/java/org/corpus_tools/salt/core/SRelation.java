package org.corpus_tools.salt.core;

import java.util.Set;

import org.corpus_tools.salt.graph.Relation;

public interface SRelation<S extends SNode, T extends SNode> extends Relation<S, T>, SAnnotationContainer, SNamedElement, STypedElement, SPathElement {

	/**
	 * Returns all layers containing this relation. This is a computed set and
	 * only works, when this relation is contained in a graph. If this list is
	 * used multiple times, it makes sense to store that set.
	 * 
	 * @return a set of layers containing this relation
	 */
	@Override
	public Set<SLayer> getLayers();
}
