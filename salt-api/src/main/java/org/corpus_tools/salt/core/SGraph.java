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
package org.corpus_tools.salt.core;

import java.util.List;
import java.util.Set;

import org.corpus_tools.salt.graph.Graph;
import org.corpus_tools.salt.graph.Layer;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.graph.Relation;
import org.corpus_tools.salt.index.IndexMgr;
import org.corpus_tools.salt.util.SaltUtil;

public interface SGraph extends SAnnotationContainer, SNamedElement, SPathElement {

	/**
	 * The {@link GRAPH_TRAVERSE_TYPE} determines the the traversal order. In
	 * general top-down means a traversal along the direction of the relations,
	 * whereas bottom-up means a traversal against the direction of the
	 * relations.
	 * 
	 * @author florian
	 */
	public enum GRAPH_TRAVERSE_TYPE {
		TOP_DOWN_DEPTH_FIRST, TOP_DOWN_BREADTH_FIRST, BOTTOM_UP_DEPTH_FIRST, BOTTOM_UP_BREADTH_FIRST
	};

	/**
	 * Returns all root nodes, if exist. A root node is a node, which has no
	 * incoming relations.
	 * 
	 * @return list of nodes being roots in the given graph.
	 */
	public List<SNode> getRoots();

	/**
	 * Returns all leaf nodes, if exist. A leaf node is a node, which has no
	 * outgoing relations.
	 * 
	 * @return list of nodes being leafs in the given graph.
	 */
	public List<SNode> getLeafs();

	/**
	 * Traverses a graph in the given order traverseType and starts traversing
	 * with the given startNodes. When a node is reached, first this method will
	 * invoke the method
	 * {@link GraphTraverseHandler#checkConstraint(GRAPH_TRAVERSE_MODE, String, Edge, Node, long)}
	 * of the given callback handler traverseHandler, second the method
	 * {@link GraphTraverseHandler#nodeReached(GRAPH_TRAVERSE_MODE, String, Node, Edge, Node, long)}
	 * is invoked. When a node was left, the method
	 * {@link GraphTraverseHandler#nodeLeft(GRAPH_TRAVERSE_MODE, String, Node, Edge, Node, long)}
	 * is invoked. When calling these methods, the traverseId will be passed, so
	 * that the callback handler knows which traversal is meant. This is
	 * helpful, in case of a single callback handler is used for more than one
	 * traversal at the same time. This method throws a
	 * {@link GraphTraverserException} in case of the graph contains a cycle. A
	 * cycle means a path containing the same node twice.
	 * 
	 * @param startNodes
	 *            list of nodes at which the traversal shall start
	 * @param traverseType
	 *            type of traversing
	 * @param traverseId
	 *            identification for callback handler, in case of more than one
	 *            traversal is running at the same time with the same callback
	 *            handler
	 * @param traverseHandler
	 *            callback handler, on which the three methods will be invoked
	 */
	public void traverse(List<SNode> startNodes, GRAPH_TRAVERSE_TYPE traverseType, String traverseId, GraphTraverseHandler traverseHandler);

	/**
	 * {@inheritDoc #traverse(EList, GRAPH_TRAVERSE_TYPE, String,
	 * GraphTraverseHandler)} Attention: When isCycleSafe is set to false, this
	 * method does not take care about cycles, and it eventually runs into
	 * endless loops.
	 * 
	 * @model startNodesMany="true" traverseHandlerDataType=
	 *        "de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphTraverseHandler"
	 * @generated
	 */
	public void traverse(List<? extends SNode> startNodes, GRAPH_TRAVERSE_TYPE traverseType, String traverseId, GraphTraverseHandler traverseHandler, boolean isCycleSafe);

	/**
	 * Searches for a node or a set of nodes having the given node name.
	 * 
	 * @param nodeName
	 *            Name of the node to search for
	 * @return A complete list of all matching nodes. Is never null.
	 */
	public List<SNode> getNodesByName(String nodeName);

	/**
	 * Searches for a relation or a set of relations having the given relation
	 * name.
	 * 
	 * @param relationName
	 *            Name of the relation to search for
	 * @return A complete list of all matching relations. Is never null.
	 */
	public List<SRelation> getRelationsByName(String relationName);

	/**
	 * Searches for a layer or a set of layers having the given layer name.
	 * 
	 * @param layerName
	 *            Name of the layer to search for
	 * @return A complete list of all matching layers. Is never null.
	 */
	public List<SLayer> getLayerByName(String layerName);

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
	public List<SNode> getNodes();

	/**
	 * Returns a node corresponding to the passed id, if such a node is
	 * contained in the graph.
	 * 
	 * @param nodeId
	 *            id of the node to be searched for
	 */
	public SNode getNode(String nodeId);

	/**
	 * Adds the passed node to this graph and updates indexes. If node is null
	 * or node is already contained nothing is inserted. The passed node and
	 * this graph will be double chained, which means the method
	 * {@link Node#getGraph()} will return this graph.
	 * 
	 * @param node
	 *            node to be inserted
	 */
	public void addNode(SNode node);

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
	public void removeNode(SNode node);

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
	public SLayer getLayer(String layerId);

	/**
	 * Returns a set of layers contained by this graph.
	 * 
	 * @return all contained layers
	 */
	public Set<SLayer> getLayers();

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
	public void addLayer(SLayer layer);

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
	public void removeLayer(SLayer layer);
}
