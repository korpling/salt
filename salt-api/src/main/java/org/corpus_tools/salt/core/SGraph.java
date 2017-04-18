/**
 * Copyright 2009 Humboldt-Universität zu Berlin.
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

import org.corpus_tools.salt.SALT_TYPE;
import org.corpus_tools.salt.graph.Graph;
import org.corpus_tools.salt.graph.Node;

public interface SGraph extends Graph<SNode, SRelation<? extends SNode, ? extends SNode>, SLayer>, SAnnotationContainer,
		SNamedElement, SPathElement {

	/**
	 * The {@link GRAPH_TRAVERSE_TYPE} determines the the traversal order. In
	 * general top-down means a traversal along the direction of the relations,
	 * whereas bottom-up means a traversal against the direction of the
	 * relations.
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
	 * Returns a list of nodes in base document. The returned nodes are
	 * equivalents to the direct children of the passed parent node. The
	 * children are retrieved via traversing of relations of the passed
	 * {@link SALT_TYPE}.
	 * 
	 * @param parent
	 *            node to who the children are retrieved
	 * @param relationType
	 *            type of relations to be traversed, if relationType is null,
	 *            all relations are used
	 * @return a list of children nodes, or an empty list
	 */
	public List<SNode> getChildren(SNode parent, SALT_TYPE relationType);

	/**
	 * Returns a list of nodes that are the parents of every node in the given
	 * base list. Only nodes with the given {@link SALT_TYPE} will be
	 * considered.
	 * 
	 * @param children
	 *            list of nodes whose parents are looked for
	 * @param nodeType
	 *            regarded types of relations
	 * @return a list of parents
	 */
	public List<SNode> getSharedParent(List<SNode> children, SALT_TYPE nodeType);

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
	public void traverse(List<SNode> startNodes, GRAPH_TRAVERSE_TYPE traverseType, String traverseId,
			GraphTraverseHandler traverseHandler);

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
	 * @param isCycleSafe
	 *            determines whether cycle safeness chould be checked
	 */
	public void traverse(List<? extends SNode> startNodes, GRAPH_TRAVERSE_TYPE traverseType, String traverseId,
			GraphTraverseHandler traverseHandler, boolean isCycleSafe);

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
	public List<SRelation<? extends SNode, ? extends SNode>> getRelationsByName(String relationName);

	/**
	 * Searches for a layer or a set of layers having the given layer name.
	 * 
	 * @param layerName
	 *            Name of the layer to search for
	 * @return A complete list of all matching layers. Is never null.
	 */
	public List<SLayer> getLayerByName(String layerName);
}
