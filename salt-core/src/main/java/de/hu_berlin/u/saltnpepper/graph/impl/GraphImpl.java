package de.hu_berlin.u.saltnpepper.graph.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

import de.hu_berlin.u.saltnpepper.graph.Edge;
import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.graph.NamedElement;
import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.graph.util.Index;
import de.hu_berlin.u.saltnpepper.graph.util.IndexImpl;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltInsertionException;

public class GraphImpl<N extends Node, E extends Edge<N, N>> extends IdentifiableElementImpl implements Graph<N, E>, NamedElement{
	/**
	 * name of index for node-types
	 */
	public static final String IDX_SNODETYPE=	"idx_sNodeType";
	/**
	 * name of index for relation-types
	 */
	public static final String IDX_SRELATIONTYPE=	"idx_sRelationType";
	
	private Index index= null;
	public Index getIndex(){
		return(index);
	}
	
	public GraphImpl(){
		index= new IndexImpl();
	}
	
	private List<NodeImpl> nodes= null;
	public List<NodeImpl> getNodes(){
		if (nodes== null){
			nodes= Collections.synchronizedList(new ArrayList<NodeImpl>());
		}
		return(Collections.unmodifiableList(nodes));
	}
	
	private List<LayerImpl> layers= null;
	public List<LayerImpl> getLayers(){
		if (layers== null){
			layers= Collections.synchronizedList(new ArrayList<LayerImpl>());
		}
		return(Collections.unmodifiableList(layers));
	}
	
	
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}
	/** internal list of all contained edges **/
	private List<E> edges= null;
	/** {@inheritDoc Graph#getEdges()} **/
	@Override
	public List<E> getEdges(){
		if (edges== null){
			edges= Collections.synchronizedList(new ArrayList<E>());
		}
		return(Collections.unmodifiableList(edges));
	}
	
	/** {@inheritDoc Graph#addEdge(Edge)} **/
	@Override
	public void addEdge(E edge) {
		basicAddEdge(edge);
		if (edge!= null){
			edge.basicSetGraph(this);
		}
	}
	/** {@inheritDoc Graph#basicAddEdge(Edge)} **/
	@Override
	public void basicAddEdge(E edge) {
		if (edge!= null){
			if (edge.getSource()== null){
				throw new SaltInsertionException(this, edge, "The source node is empty. ");
			}
			if (edge.getTarget()== null){
				throw new SaltInsertionException(this, edge, "The target node is empty. ");
			}
			edges.add(edge);
		}
	}
	
	/** {@inheritDoc Graph#addNode(Node)} **/
	@Override
	public void addNode(N node) {
		// TODO Auto-generated method stub
		
	}
	/** {@inheritDoc Graph#basicAddNode(Node)} **/
	@Override
	public void basicAddNode(N node) {
		// TODO Auto-generated method stub
		
	}
}
