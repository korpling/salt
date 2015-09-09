package de.hu_berlin.u.saltnpepper.graph;

import java.util.Set;

/**
 * A layer is a grouping mechanism for nodes and relations, and can also contain
 * further layers (called sub layers). The containment relation implements a
 * recursive structure for layers, to build hierarchies. In general this
 * mechanism enables the creation of sub graphs. But note that a layer cannot be
 * contained by itself, so cycles of layers are not possible.
 * 
 * @author florian
 *
 */
public interface Layer<N extends Node, R extends Relation<N, N>> extends IdentifiableElement {

	/**
	 * Returns the container graph of this node.
	 * 
	 * @return graph object which contains this node.
	 */
	public Graph getGraph();

	/**
	 * Sets the container graph of this node. For double chaining between this
	 * {@link Layer} and the passed {@link Graph} object, the real insertion is
	 * done by method {@link #basicSetGraph(Graph)}.
	 * 
	 * @param graph
	 *            graph which contains this layer
	 */
	public void setGraph(Graph graph);

	/**
	 * Adds the passed node to this layer. The insertion order is preserved. If
	 * this layer is contained by a graph, the passed node is also added to the
	 * graph in case it was not already contained in the graph.
	 * 
	 * @param node
	 *            node to be inserted into this layer
	 */
	public void addNode(N node);

	/**
	 * Removes the passed node from this layer. If the passed relation is null,
	 * nothing is done.
	 * 
	 * @param node
	 *            to be removed
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
	 * Adds the passed relation to this layer. The insertion order is preserved.
	 * If this layer is contained by a graph, the passed relation is also added
	 * to the graph in case it was not already contained in the graph.
	 * 
	 * @param relation
	 *            relation to be inserted into this layer
	 */
	public void addRelation(Relation<? extends Node, ? extends Node> relation);

	/**
	 * Removes the passed relation from this layer. If the passed relation is
	 * null, nothing is done.
	 * 
	 * @param relation
	 *            to be removed
	 */
	public void removeRelation(R relation);

	/**
	 * Returns a set of all contained relations, in the order how the relations
	 * were inserted.
	 * 
	 * @return all contained relations
	 */
	public Set<R> getRelations();
}
