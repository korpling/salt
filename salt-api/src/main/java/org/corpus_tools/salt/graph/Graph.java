/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
package org.corpus_tools.salt.graph;

import java.util.List;
import java.util.Set;

import org.corpus_tools.salt.index.IndexMgr;
import org.corpus_tools.salt.util.SaltUtil;

/**
 * The here defined graph is given by G=(V, E, L, {label a , ...label b }) with:
 * <ul>
 * <li>V being a set of {@link Node}s with v= ({label c , ... label d }) ∊ V
 * </li>
 * <li>E being a set of directed {@link Relation}s with e= (v 1 ∊ V, v 2 ∊ V,
 * {label e , ... label f }) ∊ E</li>
 * <li>L being a set of {@link Layer}s with l= (V 1 ⊆ V, E 1 ⊆ E, L 1 ⊆ L,
 * {label g ,.. label h }) ∊ L</li>
 * <li>and a set of {@link Label}s {label a , ... label b } the graph is labeled
 * with.</li>
 * </ul>
 * 
 * @author florian
 *
 * @param <N>
 *            type of contained {@link Node}s
 * @param <E>
 *            type of contained {@link Relation}s
 */
public interface Graph<N, R, L> extends IdentifiableElement {
	/**
	 * Returns the index manager. The index manager is used to register indexes
	 * for sets of nodes, relations, layers etc. or single values. The manager
	 * contains all indexes used by the {@link Graph} class. These indexes are:
	 * 
	 * <ul>
	 * <li>{@link SaltUtil#IDX_ID_NODES}</li>
	 * <li>{@link SaltUtil#IDX_ID_RELATIONS}</li>
	 * <li>{@link SaltUtil#IDX_ID_LAYER}</li>
	 * <li>{@link SaltUtil#IDX_OUT_RELATIONS}</li>
	 * <li>{@link SaltUtil#IDX_IN_RELATIONS}</li>
	 * </ul>
	 * Even further indexes can be added to the index manager.
	 * 
	 * @return the index manager
	 */
	public IndexMgr getIndexMgr();

	/**
	 * Returns a list of all relations contained in this graph.
	 * 
	 * @return a list of all contained relations.
	 */
	public List<R> getRelations();

	/**
	 * Returns an relation corresponding to the passed id, if such an relation
	 * is contained in the graph.
	 * 
	 * @param relationId
	 *            id of the relation to be searched for
	 */
	public R getRelation(String relationId);

	/**
	 * Returns all relations,which connects the two passed nodes.
	 * 
	 * @param sourceNodeId
	 *            the id of the source node
	 * @param targetNodeId
	 *            the id of the target node
	 * @return returns all nodes between source node and target node
	 */
	public List<R> getRelations(String sourceNodeId, String targetNodeId);

	/**
	 * Returns all relations, which have the node corresponding to the passed id
	 * as their target node.
	 * 
	 * @param nodeId
	 *            id corresponding to the node, for which all incoming relations
	 *            should be searched
	 * @return a list of all incoming relations
	 */
	public List<R> getInRelations(String nodeId);

	/**
	 * Returns all relations, which have the node corresponding to the passed id
	 * as their source node.
	 * 
	 * @param nodeId
	 *            id corresponding to the node, for which all outgoing relations
	 *            should be searched
	 * @return a list of all outgoing relations
	 */
	public List<R> getOutRelations(String nodeId);

	/**
	 * Adds the passed relation to this graph and updates indexes. If relation
	 * is null or relation is already contained nothing is inserted. The passed
	 * relation and this graph will be double chained, which means the method
	 * {@link Relation#getGraph()} will return this graph.
	 * 
	 * @param relation
	 *            relation to be inserted
	 */
	public void addRelation(R relation);

	/**
	 * Removes the passed relation from this graph. If a relation is removed, it
	 * will be deleted from all indexes. If the passed relation is null, nothing
	 * is removed.
	 * 
	 * @param relation
	 *            relation to be removed
	 */
	public void removeRelation(R relation);

	/**
	 * Removes all relations from this graph and cleans all indexes.
	 */
	public void removeRelations();

	/**
	 * Returns whether this graph contains an {@link Relation} corresponding to
	 * the passed id.
	 * 
	 * @param relationId
	 *            id of the node to be checked
	 * @return true if the relation is contained, false otherwise
	 */
	public boolean containsRelation(String relationId);

	/**
	 * Returns a list of all relations contained in this graph.
	 * 
	 * @return a list of all contained relations.
	 */
	public List<N> getNodes();

	/**
	 * Returns a node corresponding to the passed id, if such a node is
	 * contained in the graph.
	 * 
	 * @param nodeId
	 *            id of the node to be searched for
	 */
	public N getNode(String nodeId);

	/**
	 * Adds the passed node to this graph and updates indexes. If node is null
	 * or node is already contained nothing is inserted. The passed node and
	 * this graph will be double chained, which means the method
	 * {@link Node#getGraph()} will return this graph.
	 * 
	 * @param node
	 *            node to be inserted
	 */
	public void addNode(N node);

	/**
	 * Removes the passed node from this graph and cleans all indexes. It also
	 * ensures, that the graph is removed from the node, thus invoking
	 * {@link Node#getGraph()} will return null. The double chaining between
	 * this graph and the passed node will be cut off. If the passed node is
	 * null nothing is done.
	 * 
	 * @param node
	 *            the node to be removed
	 */
	public void removeNode(N node);

	/**
	 * Returns whether this graph contains a {@link Node} corresponding to the
	 * passed id.
	 * 
	 * @param nodeId
	 *            id of the node to be checked
	 * @return true if the node is contained, false otherwise
	 */
	public boolean containsNode(String nodeId);

	/**
	 * Returns a layer corresponding to the passed id, if such a layer is
	 * contained in the graph.
	 * 
	 * @param layerId
	 *            id of the layer to be searched for
	 */
	public L getLayer(String layerId);

	/**
	 * Returns a set of layers contained by this graph.
	 * 
	 * @return all contained layers
	 */
	public Set<L> getLayers();

	/**
	 * Adds the passed layer to this graph. If layer is null or layer is already
	 * contained nothing is inserted. The passed layer and this graph will be
	 * double chained, which means the method {@link Layer#getGraph()} will
	 * return this graph. If the passed layer contains nodes or relations, which
	 * are not already contained by the graph, they will be added.
	 * 
	 * @param layer
	 *            layer to be inserted
	 */
	public void addLayer(L layer);

	/**
	 * Returns whether this graph contains a {@link Layer} corresponding to the
	 * passed id.
	 * 
	 * @param layerId
	 *            id of the node to be checked
	 * @return true if the node is contained, false otherwise
	 */
	public boolean containsLayer(String layerId);

	/**
	 * Removes the passed layer from this graph and cleans all indexes. It also
	 * ensures, that the graph is removed from the layer, thus invoking
	 * {@link Layer#getGraph()} will return null. The double chaining between
	 * this graph and the passed layer will be cut off. If the passed layer is
	 * null nothing happens.
	 * 
	 * @param layer
	 *            the layer to be removed
	 */
	public void removeLayer(L layer);
}
