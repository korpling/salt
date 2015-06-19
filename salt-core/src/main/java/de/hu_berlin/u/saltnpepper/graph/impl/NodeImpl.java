package de.hu_berlin.u.saltnpepper.graph.impl;

import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.graph.NamedElement;
import de.hu_berlin.u.saltnpepper.graph.Node;


public class NodeImpl extends IdentifiableElementImpl implements Node, NamedElement{

	/**
	 * Initializes an object of type {@link Node}.
	 */
	public NodeImpl(){
		
	}
	
	/**
	 * Initializes an object of type {@link Node}. If {@link #delegate} is not null,  all functions of 
	 * this method are delegated to the delegate object. Setting {@link #delegate} makes this object
	 * to a container.
	 * @param a delegate object of the same type.
	 */
	public NodeImpl(Node delegate){
		this.delegate= delegate;
	}
	
	/** 
	 * A delegate object of the same type. If {@link #delegate} is not null,  all functions of 
	 * this method are delegated to the delegate object. Setting {@link #delegate} makes this object
	 * to a container.   
	**/
	protected Node delegate= null;
	/**
	 * Returns the delegate object. If {@link #delegate} is not null,  all functions of 
	 * this method are delegated to the delegate object. Setting {@link #delegate} makes this object
	 * to a container.
	 * @return the delegate object
	 */
	public Node getDelegate(){
		return(delegate);
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
			graph.addNode(this);
		}else{
			graph.removeNode(this);
		}
	}
	/** {@inheritDoc Edge#basicSetGraph(Graph)} **/
	@Override
	public void basicSetGraph(Graph graph) {
		this.graph= graph;
	}
}
