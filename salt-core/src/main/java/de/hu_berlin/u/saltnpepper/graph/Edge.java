package de.hu_berlin.u.saltnpepper.graph;

public interface Edge<S extends Node, T extends Node> {
	
	/**
	 * Returns the delegate object. If {@link #delegate} is not null,  all functions of 
	 * this method are delegated to the delegate object. Setting {@link #delegate} makes this object
	 * to a container.
	 * @return the delegate object
	 */
	public Edge<S,T> getDelegate();
	/**
	 * Returns the source node of this edge object.
	 * @return source node
	 */
	public S getSource();
	/**
	 * Returns the source node of this edge object.
	 * @param source source node
	 */
	public void setSource(S source);
	/**
	 * Returns the target node of this edge object.
	 * @return target node
	 */
	public T getTarget();
	/**
	 * Sets the target node of this edge object.
	 * @param target target node
	 */
	public void setTarget(T target);
	
	/**
	 * Returns the container graph of this edge.
	 * @return graph object which contains this edge.
	 */
	public Graph getGraph();
	/**
	 * Sets the container graph of this edge.
	 * @param graph object which contains this edge.
	 */
	public void setGraph(Graph graph);
	/**
	 * 
	 * @param graph
	 */
	public void basicSetGraph(Graph graph);
}
