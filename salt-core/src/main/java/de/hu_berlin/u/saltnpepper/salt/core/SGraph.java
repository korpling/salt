package de.hu_berlin.u.saltnpepper.salt.core;

import java.util.List;

import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.graph.Node;

public interface SGraph<N extends SNode, R extends SRelation<N, N>> extends Graph<N, R>, NamedElement {

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
	public List<N> getRoots();

	/**
	 * Returns all leaf nodes, if exist. A leaf node is a node, which has no
	 * outgoing relations.
	 * 
	 * @return list of nodes being leafs in the given graph.
	 */
	public List<N> getLeafs();

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
	public void traverse(List<N> startNodes, GRAPH_TRAVERSE_TYPE traverseType, String traverseId, GraphTraverseHandler<N, R> traverseHandler);

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
	public void traverse(List<N> startNodes, GRAPH_TRAVERSE_TYPE traverseType, String traverseId, GraphTraverseHandler<N, R> traverseHandler, boolean isCycleSafe);
}
