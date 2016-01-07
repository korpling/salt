package de.hu_berlin.u.saltnpepper.graph;

import java.util.Set;

/**
 * In graph theory an relation is a relation between two nodes, often an
 * relation is realized as a pair of nodes.
 * 
 * This interface defines a directed and labeled relation. A directed relation
 * is a not symmetric relation. For instance if an relation relates a node
 * <i>a</i> with a node <i>b</i>, it is not the case for the way around. A
 * labeled relation is an relation, which can contain labels as defined in
 * {@link Label}. An relation always belong to 0..1 {@link Graph}s and can also
 * be contained in one or more {@link Layer} s.
 * 
 * @author florian
 *
 * @param <S>
 *            source node of the relation
 * @param <T>
 *            target node of the relation
 */
public interface Relation<S extends Node, T extends Node> extends IdentifiableElement {

	/**
	 * Returns the source node of this relation object.
	 * 
	 * @return source node
	 */
	public S getSource();

	/**
	 * Returns the source node of this relation object. If this relation belongs
	 * to a graph, the graph's indexes will be updated automatically.
	 * 
	 * @param source
	 *            source node
	 */
	public void setSource(S source);

	/**
	 * Returns the target node of this relation object.
	 * 
	 * @return target node
	 */
	public T getTarget();

	/**
	 * Sets the target node of this relation object. If this relation belongs to
	 * a graph, the graph's indexes will be updated automatically.
	 * 
	 * @param target
	 *            target node
	 */
	public void setTarget(T target);

	/**
	 * Returns the container graph of this relation.
	 * 
	 * @return graph object which contains this relation.
	 */
	public Graph getGraph();

	/**
	 * Sets the container graph of this relation.
	 * 
	 * @param graph
	 *            object which contains this relation.
	 */
	/**
	 * Sets the container graph of this relation. The passed graph and this
	 * relation will be double chained, which means the method
	 * {@link Graph#getRelations()} will return a list containing this relation.
	 * 
	 * @param graph
	 *            graph which contains this relation
	 */
	public void setGraph(Graph graph);

	/**
	 * Returns all layers containing this relation. This is a computed set and
	 * only works, when this relation is contained in a graph. If this list is
	 * used multiple times, it makes sense to store that set.
	 * 
	 * @return a set of layers containing this relation
	 */
	public Set<? extends Layer> getLayers();

	/**
	 * Adds this relation to the passed layer.
	 * 
	 * @param layer
	 *            to which this node should be added
	 */
	public void addLayer(Layer layer);

	/**
	 * Removes this relation from the passed layer.
	 * 
	 * @param layer
	 *            from which this node should be removed
	 */
	public void removeLayer(Layer layer);
}
