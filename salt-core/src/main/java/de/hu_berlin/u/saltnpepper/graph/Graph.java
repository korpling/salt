package de.hu_berlin.u.saltnpepper.graph;

import java.util.List;


public interface Graph<N extends Node, E extends Edge<N, N>> {
	/**
	 * Returns an unmodifiable list of all edges contained in this graph. 
	 * @return a list of all contained edges.
	 */
	public List<E> getEdges();
	/**
	 * Adds an edge to this graph and updates indexes. If edge is null nothing is inserted.
	 * For double chaining between this {@link Graph} and the passed {@link Edge} object,
	 * the real insertion is done by method {@link #basicAddEdge(Edge)}.
	 * @param edge edge to be inserted 
	 */
	public void addEdge(E edge);
	/**
	 * This is an internally used method. To implement a double chaining of {@link Graph} and {@link Edge} object when an
	 * edge is inserted into this graph and to avoid an endless invocation the insertion of an edge is splited into
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
	 * Adds a node to this graph and updates indexes.
	 * @param node node to be inserted
	 */
	public void addNode(N node);
	public void basicAddNode(N node);
}
