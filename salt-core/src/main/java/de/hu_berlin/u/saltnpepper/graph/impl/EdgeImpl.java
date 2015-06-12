package de.hu_berlin.u.saltnpepper.graph.impl;

import de.hu_berlin.u.saltnpepper.graph.Edge;
import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.graph.NamedElement;
import de.hu_berlin.u.saltnpepper.graph.Node;


public class EdgeImpl<S extends Node, T extends Node> extends IdentifiableElementImpl implements Edge<S, T>, NamedElement{
	/**
	 * Initializes an object of type {@link Edge}.
	 */
	public EdgeImpl(){
	}
	
	/**
	 * Initializes an object of type {@link Edge}. If {@link #delegate} is not null,  all functions of 
	 * this method are delegated to the delegate object. Setting {@link #delegate} makes this object
	 * to a container.
	 * @param a delegate object of the same type.
	 */
	public EdgeImpl(Edge<S, T> delegate){
		this.delegate= delegate;
	}
	
	/** 
	 * A delegate object of the same type. If {@link #delegate} is not null,  all functions of 
	 * this method are delegated to the delegate object. Setting {@link #delegate} makes this object
	 * to a container.   
	**/
	protected Edge<S, T> delegate= null;
	/**
	 * {@inheritDoc Edge#getDelegate()}
	 */
	public Edge<S, T> getDelegate(){
		return(delegate);
	}
	/** source node of this edge. **/
	protected S source=null;
	/**
	 * {@inheritDoc Edge#getSource()}
	 */
	public S getSource() {
		return source;
	}
	/**
	 * {@inheritDoc Edge#setSource(Node)}
	 */
	public void setSource(S source) {
		this.source = source;
	}
	/** target node of this edge. **/
	private T target=null;
	/**
	 * {@inheritDoc Edge#getTarget()}
	 */
	public T getTarget() {
		return target;
	}
	/**
	 * {@inheritDoc Edge#setTarget(Node)}
	 */
	public void setTarget(T target) {
		this.target = target;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}
	/** container graph**/
	protected Graph graph= null;
	/** {@inheritDoc Edge#getGraph()} **/
	@Override
	public Graph getGraph() {
		return(graph);
	}
	/** {@inheritDoc Edge#setGraph(Graph)} **/
	@Override
	public void setGraph(Graph graph) {
		basicSetGraph(graph);
		if (graph!= null){
			graph.addEdge(this);
		}else{
			//TODO: remove edge from graph
		}
	}
	/** {@inheritDoc Edge#basicSetGraph(Graph)} **/
	@Override
	public void basicSetGraph(Graph graph) {
		this.graph= graph;
	}
}
