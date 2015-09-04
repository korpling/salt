package de.hu_berlin.u.saltnpepper.salt.core;

import java.util.List;

import de.hu_berlin.u.saltnpepper.graph.Node;

public interface SNode extends Node, SAnnotationContainer, SNamedElement {
	/**
	 * When this node belongs to a {@link SGraph}, a list of outgoing relations
	 * of this node are returned.
	 * 
	 * @return list of outgoing relations
	 */
	public List<SRelation> getOutRelations();

	/**
	 * When this node belongs to a {@link SGraph}, a list of incoming relations
	 * of this node are returned.
	 * 
	 * @return list of incoming relations
	 */
	public List<SRelation> getInRelations();
}
