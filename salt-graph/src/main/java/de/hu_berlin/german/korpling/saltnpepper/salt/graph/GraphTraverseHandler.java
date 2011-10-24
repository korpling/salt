package de.hu_berlin.german.korpling.saltnpepper.salt.graph;

/**
 * The interface of a callback handler for traversing a {@link Graph} object. When invoking the method 
 * {@link Graph#traverse(org.eclipse.emf.common.util.EList, GRAPH_TRAVERSE_TYPE, String, GraphTraverseHandler)} an object
 * implementing this interface must be passed. This interface contains three methods {@link #checkConstraint(GRAPH_TRAVERSE_TYPE, String, Edge, Node, long)},
 * {@link #nodeReached(GRAPH_TRAVERSE_TYPE, String, Node, Edge, Node, long)} and {@link #nodeLeft(GRAPH_TRAVERSE_TYPE, String, Node, Edge, Node, long)}.
 * If the traversal reaches a new {@link Node} object being contained in the {@link Graph} object, the method
 * {@link #checkConstraint(GRAPH_TRAVERSE_TYPE, String, Edge, Node, long)} will be invoked. If this method returns true, it means
 * that this node and eventually its sub-graph will also be traversed. When true is returned, the method {@link #nodeReached(GRAPH_TRAVERSE_TYPE, String, Node, Edge, Node, long)}
 * will be invoked, when reaching the node and {@link #nodeLeft(GRAPH_TRAVERSE_TYPE, String, Node, Edge, Node, long)} when lefting
 * the node. 
 * 
 * @author Florian Zipser
 *
 */
public interface GraphTraverseHandler {
	/**
	 * This method will be invoked, when a node is reached, after the method {@link #checkConstraint(GRAPH_TRAVERSE_TYPE, String, Edge, Node, long)}
	 * has returned true and before the method {@link #nodeLeft(GRAPH_TRAVERSE_TYPE, String, Node, Edge, Node, long)} 
	 * is invoked.
	 * @param traversalType the type of current traversal
	 * @param traversalId the id of current traversal, given by the invoking object
	 * @param currNode the current node
	 * @param edge the edge via which the current node was reached
	 * @param fromNode the parent node 
	 * @param order the number of the edge in the parent node
	 */
	public void nodeReached(	GRAPH_TRAVERSE_TYPE traversalType, 
								String traversalId,
								Node currNode, 
								Edge edge, 
								Node fromNode, 
								long order);

	/**
	 * This method will be invoked, when a node is left, after the method {@link #checkConstraint(GRAPH_TRAVERSE_TYPE, String, Edge, Node, long)}
	 * has returned true and the method {@link #nodeReached(GRAPH_TRAVERSE_TYPE, String, Node, Edge, Node, long)} 
	 * has been invoked.
	 * @param traversalType the type of current traversal
	 * @param traversalId the id of current traversal, given by the invoking object
	 * @param currNode the current node
	 * @param edge the edge via which the current node was reached
	 * @param fromNode the parent node 
	 * @param order the number of the edge in the parent node
	 */
	public void nodeLeft(	GRAPH_TRAVERSE_TYPE traversalType, 
							String traversalId,
							Node currNode, 
							Edge edge, 
							Node fromNode, 
							long order);

	/**
	 * This method is called during a traversal to check if the current node and eventually its sub-graph shall 
	 * be traversed or not. If the return value is false, the traversion for the current path, will stop at the
	 * current node and the methods {@link #nodeReached(GRAPH_TRAVERSE_TYPE, String, Node, Edge, Node, long)} and
	 * {@link #nodeLeft(GRAPH_TRAVERSE_TYPE, String, Node, Edge, Node, long)} as well will not be invoked. Otherwise
	 * the method {@link #nodeReached(GRAPH_TRAVERSE_TYPE, String, Node, Edge, Node, long)} will be invoked, when
	 * a new node is reached and {@link #nodeLeft(GRAPH_TRAVERSE_TYPE, String, Node, Edge, Node, long)} will  be 
	 * invoked, when this node is left.
	 * @param traversalType the type of current traversal
	 * @param traversalId the id of current traversal, given by the invoking object
	 * @param edge the edge via which the current node was reached
	 * @param currNode the current node
	 * @param order the number of the edge in the parent node
	 */
	public boolean checkConstraint(		GRAPH_TRAVERSE_TYPE traversalType, 
										String traversalId,
										Edge edge, 
										Node currNode, 
										long order);
}
