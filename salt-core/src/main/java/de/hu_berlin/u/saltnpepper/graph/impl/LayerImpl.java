package de.hu_berlin.u.saltnpepper.graph.impl;

import java.util.HashSet;
import java.util.Set;

import de.hu_berlin.u.saltnpepper.graph.Edge;
import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.graph.Layer;
import de.hu_berlin.u.saltnpepper.graph.NamedElement;
import de.hu_berlin.u.saltnpepper.graph.Node;

@SuppressWarnings("serial")
public class LayerImpl<N extends Node, E extends Edge<N, N>> extends IdentifiableElementImpl implements Layer<N, E>, NamedElement {

	private Set<N> nodes = null;
	private Set<E> edges = null;

	public LayerImpl() {
		nodes = new HashSet<N>();
		edges = new HashSet<E>();
	}

	/** container graph**/
	protected Graph<N, E> graph= null;
	/** {@inheritDoc Edge#getGraph()} **/
	@Override
	public Graph<N, E> getGraph() {
		return(graph);
	}
	/** {@inheritDoc Edge#setGraph(Graph)} **/
	@Override
	public void setGraph(Graph<N, E> graph) {
		basicSetGraph(graph);
		if (graph!= null){
			graph.basicAddLayer(this);
		}else{
			//TODO: remove edge from graph
		}
	}
	/** {@inheritDoc Edge#basicSetGraph(Graph)} **/
	@Override
	public void basicSetGraph(Graph<N, E> graph) {
		this.graph= graph;
	}
	
	/** {@inheritDoc Layer#getNodes()} **/
	@Override
	public Set<N> getNodes() {
		return (nodes);
	}

	/** {@inheritDoc Layer#addNode(Node)} **/
	@Override
	public void addNode(N node) {
		nodes.add(node);
	}

	/** {@inheritDoc Layer#removeNode(Node)} **/
	@Override
	public void removeNode(N node){
		if (nodes!= null){
			nodes.remove(node);
		}
	}
	
	/** {@inheritDoc Layer#getEdges()} **/
	@Override
	public Set<E> getEdges() {
		return (edges);
	}

	/** {@inheritDoc Layer#addEdge(Edge)} **/
	@Override
	public void addEdge(E edge) {
		edges.add(edge);
	}
	/** {@inheritDoc Layer#removeEdge(Edge)} **/
	@Override
	public void removeEdge(E edge){
		if (edge!= null){
			edges.remove(edge);
		}
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setName(String name) {
		// TODO Auto-generated method stub

	}
}
