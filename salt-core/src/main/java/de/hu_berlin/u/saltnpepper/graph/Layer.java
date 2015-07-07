package de.hu_berlin.u.saltnpepper.graph;

import java.util.Set;

/**
 * A layer is a grouping mechanism for nodes and edges, and can also contain
 * further layers (called sub layers). The containment relation implements a
 * recursive structure for layers, to build hierarchies. In general this
 * mechanism enables the creation of sub graphs. But note that a layer cannot be
 * contained by itself, so cycles of layers are not possible.
 * 
 * @author florian
 *
 */
public interface Layer<N extends Node, E extends Edge<N, N>> extends IdentifiableElement {

	/**
	 * Returns the container graph of this node.
	 * 
	 * @return graph object which contains this node.
	 */
	public Graph<N, E> getGraph();

	/**
	 * Sets the container graph of this node. For double chaining between this
	 * {@link Layer} and the passed {@link Graph} object, the real insertion is
	 * done by method {@link #basicSetGraph(Graph)}.
	 * 
	 * @param graph
	 *            graph which contains this layer
	 */
	public void setGraph(Graph<N, E> graph);

	/**
	 * This is an internally used method. To implement a double chaining of
	 * {@link Graph} and {@link Layer} object when an layer is inserted into this
	 * graph and to avoid an endless invocation the insertion of an layer is
	 * splited into the two methods {@link #setGraph(Graph)} and
	 * {@link #basicSetGraph(Graph)}. The invocation of methods is implement as
	 * follows:
	 * 
	 * <pre>
	 * {@link Graph#addLayer(Layer)}                      {@link Layer#setGraph(Graph)}
	 *         ||             \ /                   ||
	 *         ||              X                    ||
	 *         \/             / \                   \/
	 * {@link Graph#basicAddLayer(Layer)}            {@link Layer#basicSetGraph(Graph)}
	 * </pre>
	 * 
	 * That means method {@link #setGraph(Graph)} calls
	 * {@link #basicSetGraph(Graph)} and {@link Graph#basicAddLayer(Layer)}. And
	 * method {@link #setGraph(Graph)} calls {@link Graph#basicAddLayer(Layer)}
	 * and {@link Layer#basicSetGraph(Graph)}.
	 * 
	 * @param graph
	 *            graph which contains this layer
	 */
	public void basicSetGraph(Graph<N, E> graph);

	/**
	 * Adds the passed node to this layer. The insertion order is preserved.
	 * 
	 * @param node
	 *            node to be inserted into this layer
	 */
	public void addNode(N node);
	/**
	 * Removes the passed node from this layer. If the passed edge is null, nothing is done.
	 * @param node to be removed
	 */
	public void removeNode(N node);

	/**
	 * Returns a set of all contained nodes, in the order how the nodes were
	 * inserted.
	 * 
	 * @return all contained nodes
	 */
	public Set<N> getNodes();

	/**
	 * Adds the passed edge to this layer. The insertion order is preserved.
	 * 
	 * @param edge
	 *            edge to be inserted into this layer
	 */
	public void addEdge(E edge);
	/**
	 * Removes the passed edge from this layer. If the passed edge is null, nothing is done.
	 * @param edge to be removed
	 */
	public void removeEdge(E edge);
	/**
	 * Returns a set of all contained edges, in the order how the edges were
	 * inserted.
	 * 
	 * @return all contained edges
	 */
	public Set<E> getEdges();
}
