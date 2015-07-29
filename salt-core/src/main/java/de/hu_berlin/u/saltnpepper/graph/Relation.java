package de.hu_berlin.u.saltnpepper.graph;

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
 *            target nod eof the relation
 */
public interface Relation<S extends Node, T extends Node> extends IdentifiableElement {

	/**
	 * Returns the delegate object. If {@link #delegate} is not null, all
	 * functions of this method are delegated to the delegate object. Setting
	 * {@link #delegate} makes this object to a container.
	 * 
	 * @return the delegate object
	 */
	public Relation<S, T> getDelegate();

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
}
