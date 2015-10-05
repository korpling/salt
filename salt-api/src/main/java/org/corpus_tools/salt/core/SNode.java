package org.corpus_tools.salt.core;

import java.util.List;
import java.util.Set;

import org.corpus_tools.salt.graph.Node;

public interface SNode extends Node, SAnnotationContainer, SNamedElement, SPathElement {
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
	
	/**
	 * Returns all layers containing this node. This is a computed set and only
	 * works, when this node is contained in a graph. If this list is used
	 * multiple times, it makes sense to store that set.
	 * 
	 * @return a set of layers containing this node
	 */
	@Override
	public Set<SLayer> getLayers();
	
	@Override
	public SGraph getGraph();
}
