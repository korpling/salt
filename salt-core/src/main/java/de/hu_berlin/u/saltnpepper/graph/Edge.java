package de.hu_berlin.u.saltnpepper.graph;

/**
 * In graph theory an edge is a relation between two nodes, often an edge is
 * realized as a pair of nodes.
 * 
 * This interface defines a directed and labeled edge. A directed edge is a not
 * symmetric edge. For instance if an edge relates a node <i>a</i> with a node
 * <i>b</i>, it is not the case for the way around. A labeled edge is an edge,
 * which can contain labels as defined in {@link Label}. An edge always belong
 * to 0..1 {@link Graph}s and can also be contained in one or more {@link Layer}
 * s.
 * 
 * @author florian
 *
 * @param <S>
 *            source node of the edge
 * @param <T>
 *            target nod eof the edge
 */
public interface Edge<S extends Node, T extends Node> extends IdentifiableElement {

	/**
	 * Returns the delegate object. If {@link #delegate} is not null, all
	 * functions of this method are delegated to the delegate object. Setting
	 * {@link #delegate} makes this object to a container.
	 * 
	 * @return the delegate object
	 */
	public Edge<S, T> getDelegate();

	/**
	 * Returns the source node of this edge object.
	 * 
	 * @return source node
	 */
	public S getSource();

	/**
	 * Returns the source node of this edge object.
	 * 
	 * @param source
	 *            source node
	 */
	public void setSource(S source);

	/**
	 * Returns the target node of this edge object.
	 * 
	 * @return target node
	 */
	public T getTarget();

	/**
	 * Sets the target node of this edge object.
	 * 
	 * @param target
	 *            target node
	 */
	public void setTarget(T target);

	/**
	 * Returns the container graph of this edge.
	 * 
	 * @return graph object which contains this edge.
	 */
	public Graph getGraph();

	/**
	 * Sets the container graph of this edge.
	 * 
	 * @param graph
	 *            object which contains this edge.
	 */
	/**
	 * Sets the container graph of this edge. The passed graph and this edge
	 * will be double chained, which means the method {@link Graph#getEdges()}
	 * will return a list containing this edge.
	 * 
	 * @param graph
	 *            graph which contains this edge
	 */
	public void setGraph(Graph graph);
}
