package de.hu_berlin.u.saltnpepper.graph;

/**
 * In graph theory an edge is a relation between two nodes, often an edge is realized as a pair of nodes.
 * 
 * This interface defines a directed and labeled edge. A directed edge is a not symmetric edge. For instance if an edge 
 * relates a node <i>a</i> with a node <i>b</i>, it is not the case for the way around. A labeled edge is an edge, which can 
 * contain labels as defined in {@link Label}. An edge always belong to 0..1 {@link Graph}s and can also be contained in one or 
 * more {@link Layer}s. 
 * 
 * @author florian
 *
 * @param <S> source node of the edge
 * @param <T> target nod eof the edge
 */
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
	/**
	 * Sets the container graph of this edge.
	 * For double chaining between this {@link Edge} and the passed {@link Graph} object,
	 * the real insertion is done by method {@link #basicSetGraph(Graph)}.
	 * @param graph graph which contains this edge 
	 */
	public void setGraph(Graph graph);
	/**
	 * This is an internally used method. To implement a double chaining of {@link Graph} and {@link Edge} object when an
	 * edge is inserted into this graph and to avoid an endless invocation the insertion of an edge is splited into
	 * the two methods {@link #setGraph(Graph)} and {@link #basicSetGraph(Graph)}. The invocation of methods is implement 
	 * as follows:
	 * <pre>
	 * {@link Graph#addEdge(Edge)}                      {@link Edge#setGraph(Graph)}
	 *         ||             \ /                   ||
	 *         ||              X                    ||
	 *         \/             / \                   \/
	 * {@link Graph#basicAddEdge(Edge)}            {@link Edge#basicSetGraph(Graph)}
	 * </pre> 
	 * 
	 * That means method {@link #setGraph(Graph)} calls {@link #basicSetGraph(Graph)} 
	 * and {@link Graph#basicAddEdge(Edge)}. And method {@link #setGraph(Graph)} calls 
	 * {@link Graph#basicAddEdge(Edge)} and {@link Edge#basicSetGraph(Graph)}.
	 * 
	 * @param graph graph which contains this edge
	 */
	public void basicSetGraph(Graph graph);
}
