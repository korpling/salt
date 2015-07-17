package de.hu_berlin.u.saltnpepper.graph;

import java.util.List;
import java.util.Set;

/**
 * The here defined graph is given by G=(V, E, L, {label a , ...label b }) with:
 * <ul>
 * <li>V being a set of {@link Node}s with v= ({label c , ... label d }) ∊ V</li>
 * <li>E being a set of directed {@link Edge}s with e= (v 1 ∊ V, v 2 ∊ V, {label
 * e , ... label f }) ∊ E</li>
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
 *            type of contained {@link Edge}s
 */
public interface Graph<N extends Node, E extends Edge<N, N>> extends IdentifiableElement {
	/**
	 * Returns a list of all edges contained in this graph.
	 * 
	 * @return a list of all contained edges.
	 */
	public List<E> getEdges();

	/**
	 * Returns an edge corresponding to the passed id, if such an edge is
	 * contained in the graph.
	 * 
	 * @param edgeId
	 *            id of the edge to be searched for
	 */
	public E getEdge(String edgeId);
	/**
	 * Returns all edges,which connects the two passed nodes.
	 * @param sourceNodeId the id of the source node
	 * @param targetNodeId the id of the target node
	 * @return returns all nodes between source node and target node
	 */
	public List<E> getEdges(String sourceNodeId, String targetNodeId);
	/**
	 * Returns all edges, which have the node corresponding to the passed id as their target node.
	 * @param nodeId id corresponding to the node, for which all incoming edges should be searched
	 * @return a list of all incoming edges
	 */
	public List<E> getInEdges(String nodeId);
	/**
	 * Returns all edges, which have the node corresponding to the passed id as their source node.
	 * @param nodeId id corresponding to the node, for which all outgoing edges should be searched
	 * @return a list of all outgoing edges
	 */
	public List<E> getOutEdges(String nodeId);
	
	/**
	 * Adds the passed edge to this graph and updates indexes. If edge is null
	 * nothing is inserted. The passed edge and this graph will be double
	 * chained, which means the method {@link Edge#getGraph()} will return this
	 * graph.
	 * 
	 * @param edge
	 *            edge to be inserted
	 */
	public void addEdge(E edge);

	/**
	 * Returns whether this graph contains an {@link Edge} corresponding to the
	 * passed id.
	 * 
	 * @param edgeId
	 *            id of the node to be checked
	 * @return true if the edge is contained, false otherwise
	 */
	public boolean containsEdge(String edgeId);

	/**
	 * Returns a list of all edges contained in this graph.
	 * 
	 * @return a list of all contained edges.
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
	 * nothing is inserted. The passed node and this graph will be double
	 * chained, which means the method {@link Node#getGraph()} will return this
	 * graph.
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
	 * Returns a set of layers contained by this graph.
	 * 
	 * @return all contained layers
	 */
	public Set<Layer<N, E>> getLayers();

	/**
	 * Adds the passed layer to this graph. If layer is null nothing is
	 * inserted. The passed layer and this graph will be double chained, which
	 * means the method {@link Layer#getGraph()} will return this graph.
	 * 
	 * @param layer
	 *            layer to be inserted
	 */
	public void addLayer(Layer<N, E> layer);

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
	 * this graph and the passed layer will be cut off. If
	 * the passed layer is null nothing happens.
	 * 
	 * @param layer
	 *            the layer to be removed
	 */
	public void removeLayer(Layer<N, E> layer);
}
