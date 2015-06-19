package de.hu_berlin.u.saltnpepper.graph.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import de.hu_berlin.u.saltnpepper.graph.Edge;
import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.graph.NamedElement;
import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltInsertionException;

public class GraphImpl<N extends Node, E extends Edge<N, N>> extends IdentifiableElementImpl implements Graph<N, E>, NamedElement{

	
	public GraphImpl(){
	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	// =========================================================== > Indexes
	/** An index storing all nodes and their corresponding ids (key: id; value: node) **/
	private Map<String, Node> idx_node_id= new ConcurrentHashMap<String, Node>();
	/** An index storing all edges and their corresponding ids (key: id; value: edge) **/
	private Map<String, Edge<N,N>> idx_edge_id= new ConcurrentHashMap<String, Edge<N,N>>();
	/** An index storing all node ids and the corresponding outgoing edges (key: node id; value: edge) **/
	private Multimap<String, Edge<N,N>> idx_out_edge_id=  HashMultimap.create();
	/** An index storing all node ids and the corresponding incomming edges (key: node id; value: edge) **/
	private Multimap<String, Edge<N,N>> idx_in_edge_id=  HashMultimap.create();
	// =========================================================== < Indexes

	
	// =========================================================== > Nodes
	/** internal list of all contained nodes **/
	private List<N> nodes= null;
	/** {@inheritDoc Graph#getNodes()} **/
	@Override
	public List<N> getNodes(){
		if (nodes== null){
			nodes= Collections.synchronizedList(new ArrayList<N>());
		}
		return(nodes);
	}
	
	/** {@inheritDoc Graph#addNode(Node)} **/
	@Override
	public void addNode(N node) {
		basicAddNode(node);
		if (node!= null){
			node.basicSetGraph(this);
		}
	}
	/** {@inheritDoc Graph#basicAddNode(Node)} **/
	@Override
	public void basicAddNode(N node) {
		if (node!= null){
			getNodes().add(node);
		}
	}
	/** {@inheritDoc Graph#removeNode(Node)}**/
	@Override
	public void removeNode(N node){
		if (node!= null){
			node.basicSetGraph(null);
			basicRemoveNode(node);
		}
	}
	/** {@inheritDoc Graph#basicRemoveNode(Node)}**/
	@Override
	public void basicRemoveNode(N node){
		getNodes().remove(node);
	}
	// =========================================================== < Nodes
	
	// =========================================================== > Edges	
	
	/** internal list of all contained edges **/
	private List<E> edges= null;
	/** {@inheritDoc Graph#getEdges()} **/
	@Override
	public List<E> getEdges(){
		if (edges== null){
			edges= Collections.synchronizedList(new ArrayList<E>());
		}
		return(edges);
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
			getEdges().add(edge);
		}
	}
	// =========================================================== < Edges
	
	// =========================================================== > Layers
	private List<LayerImpl> layers= null;
	public List<LayerImpl> getLayers(){
		if (layers== null){
			layers= Collections.synchronizedList(new ArrayList<LayerImpl>());
		}
		return(Collections.unmodifiableList(layers));
	}
	// =========================================================== < Layers
}
