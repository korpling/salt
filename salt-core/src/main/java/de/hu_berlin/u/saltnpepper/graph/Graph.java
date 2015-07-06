package de.hu_berlin.u.saltnpepper.graph;

import java.util.List;

/**
 * The here defined graph is given by G=(V, E, L, {label a , ...label b }) with:
 * <ul>
 * 	<li>V being a set of {@link Node}s with v= ({label c , ... label d }) ∊ V</li>
 *  <li>E being a set of directed {@link Edge}s with e= (v 1 ∊ V, v 2 ∊ V, {label e , ... label f }) ∊ E</li>
 *  <li>L being a set of {@link Layer}s with l= (V 1 ⊆ V, E 1 ⊆ E, L 1 ⊆ L, {label g ,.. label h }) ∊ L</li>
 *  <li>and a set of {@link Label}s {label a , ... label b } the graph is labeled with.</li>  
 * </ul>
 * 
 * @author florian
 *
 * @param <N> type of contained {@link Node}s
 * @param <E> type of contained {@link Edge}s
 */
public interface Graph<N extends Node, E extends Edge<N, N>> extends IdentifiableElement{
	/**
	 * Returns a list of all edges contained in this graph. 
	 * @return a list of all contained edges.
	 */
	public List<E> getEdges();
	/**
	 * Returns an edge corresponding to the passed id, if such an edge is contained in the graph.
	 * @param edgeId id of the edge to be searched for
	 */
	public E getEdge(String edgeId);
	/**
	 * Adds an edge to this graph and updates indexes. If edge is null nothing is inserted.
	 * For double chaining between this {@link Graph} and the passed {@link Edge} object,
	 * the real insertion is done by method {@link #basicAddEdge(Edge)}.
	 * @param edge edge to be inserted 
	 */
	public void addEdge(E edge);
	/**
	 * This is an internally used method. To implement a double chaining of {@link Graph} and {@link Edge} object when an
	 * edge is inserted into this graph and to avoid an endless invocation the insertion of an edge is splitted into
	 * the two methods {@link #addEdge(Edge)} and {@link #basicAddEdge(Edge)}. The invocation of methods is implement 
	 * as follows:
	 * <pre>
	 * {@link #addEdge(Edge)}                      {@link Edge#setGraph(Graph)}
	 *         ||             \ /                   ||
	 *         ||              X                    ||
	 *         \/             / \                   \/
	 * {@link #basicAddEdge(Edge)}            {@link Edge#basicSetGraph(Graph)}
	 * </pre> 
	 * 
	 * That means method {@link #addEdge(Edge)} calls {@link #basicAddEdge(Edge)} 
	 * and {@link Edge#basicSetGraph(Graph)}. And method {@link Edge#setGraph(Graph)} calls 
	 * {@link #basicAddEdge(Edge)} and {@link Edge#basicSetGraph(Graph)}.
	 * 
	 * @param edge edge to be inserted
	 */
	public void basicAddEdge(E edge);
	
	/**
	 * Returns a list of all edges contained in this graph. 
	 * @return a list of all contained edges.
	 */
	public List<N> getNodes();
	
	/**
	 * Returns a node corresponding to the passed id, if such a node is contained in the graph.
	 * @param nodeId id of the node to be searched for
	 */
	public N getNode(String nodeId);
	
	/**
	 * Adds a node to this graph and updates indexes. If node is null nothing is inserted.
	 * For double chaining between this {@link Graph} and the passed {@link node} object,
	 * the real insertion is done by method {@link #basicAddNode(Node)}.
	 * @param node node to be inserted 
	 */
	public void addNode(N node);
	/**
	 * This is an internally used method. To implement a double chaining of {@link Graph} and {@link Node} object when an
	 * node is inserted into this graph and to avoid an endless invocation the insertion of an edge is splitted into
	 * the two methods {@link #addNode(node)} and {@link #basicAddNode(Node)}. The invocation of methods is implement 
	 * as follows:
	 * <pre>
	 * {@link #addNode(node)}                      {@link Node#setGraph(Graph)}
	 *         ||             \ /                   ||
	 *         ||              X                    ||
	 *         \/             / \                   \/
	 * {@link #basicAddNode(Node)}            {@link Node#basicSetGraph(Graph)}
	 * </pre> 
	 * 
	 * That means method {@link #addNode(Node)} calls {@link #basicAddNode(Node)} 
	 * and {@link Node#basicSetGraph(Graph)}. And method {@link Node#setGraph(Graph)} calls 
	 * {@link #basicAddNode(Node)} and {@link Node#basicSetGraph(Graph)}.
	 * 
	 * @param node node to be inserted
	 */
	public void basicAddNode(N node);
	/**
	 * Removes a node from this graph and cleans all indexes. It also ensures, that the graph is removed from the
	 * node, thus invoking {@link Node#getGraph()} will return null. For cutting the double chaining between 
	 * this {@link Graph} and the passed {@link node} object, the real removal is done by method {@link #basicRemoveNode(Node)}.
	 * If the passed node is null nothing happens.
	 * @param node the node to be removed
	 */
	public void removeNode(N node);
	/**
	 * This is an internally used method. To realize the cut of the double chaining, the removal is splitted in two methods {@link #removeNode(Node)} and
	 * {@link #basicRemoveNode(Node)}. which are connected as follows: 
	 *  <pre>
	 * {@link #removeNode(node)}                      {@link Node#setGraph(null)}
	 *         ||             \ /                   ||
	 *         ||              X                    ||
	 *         \/             / \                   \/
	 * {@link #basicRemoveNode(Node)}            {@link Node#basicSetGraph(null)}
	 * </pre> 
	 * @param node the node to be removed
	 */
	public void basicRemoveNode(N node);
	/**
	 * Returns whether this graph contains a {@link Node} corresponding to the passed id.
	 * @param nodeId id of the node to be checked
	 * @return true if the node is contained, false otherwise
	 */
	public boolean containsNode(String nodeId);
	/**
	 * Returns whether this graph contains an {@link Edge} corresponding to the passed id.
	 * @param edgeId id of the node to be checked
	 * @return true if the edge is contained, false otherwise
	 */
	public boolean containsEdge(String edgeId);
	/**
	 * Returns whether this graph contains a {@link Layer} corresponding to the passed id.
	 * @param layerId id of the node to be checked
	 * @return true if the node is contained, false otherwise
	 */
	public boolean containsLayer(String layerId);
}
