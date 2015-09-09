package de.hu_berlin.u.saltnpepper.graph.impl;

import java.util.HashSet;
import java.util.Set;

import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.graph.Layer;
import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.graph.Relation;

@SuppressWarnings("serial")
public class LayerImpl<N extends Node, R extends Relation<N, N>> extends IdentifiableElementImpl implements Layer<N, R> {

	private Set<N> nodes = null;
	private Set<R> relations = null;

	public LayerImpl() {
		nodes = new HashSet<N>();
		relations = new HashSet<R>();
	}

	/** container graph **/
	protected Graph<N, R> graph = null;

	/** {@inheritDoc Relation#getGraph()} **/
	@Override
	public Graph<N, R> getGraph() {
		return (graph);
	}

	/** {@inheritDoc Relation#setGraph(Graph)} **/
	@Override
	public void setGraph(Graph<N, R> graph) {
		if (graph != null) {
			if (graph instanceof GraphImpl) {
				((GraphImpl<N, R>) graph).basicAddLayer(this);
			}
		} else {
			if (getGraph() instanceof GraphImpl) {
				((GraphImpl<N, R>) getGraph()).basicRemoveLayer(this);
			}
		}
		basicSetGraph(graph);
	}

	/**
	 * This is an internally used method. To implement a double chaining of
	 * {@link Graph} and {@link Layer} object when an layer is inserted into
	 * this graph and to avoid an endless invocation the insertion of an layer
	 * is splited into the two methods {@link #setGraph(Graph)} and
	 * {@link #basicSetGraph(Graph)}. The invocation of methods is implement as
	 * follows:
	 * 
	 * <pre>
	 * {@link Graph#addLayer(Layer)}                      {@link Layer#setGraph(Graph)}
	 *         ||             \ /                   ||
	 *         ||              X                    ||
	 *         \/             / \                   \/
	 * {@link Graph#basicAddLayer(Layer)}            {@link Layer#basicSetGraph(Graph)}
	 * </pre>
	 * 
	 * That means method {@link #setGraph(Graph)} calls
	 * {@link #basicSetGraph(Graph)} and {@link Graph#basicAddLayer(Layer)}. And
	 * method {@link #setGraph(Graph)} calls {@link Graph#basicAddLayer(Layer)}
	 * and {@link Layer#basicSetGraph(Graph)}.
	 * 
	 * @param graph
	 *            graph which contains this layer
	 */
	protected void basicSetGraph(Graph<N, R> graph) {
		this.graph = graph;
	}

	/** {@inheritDoc Layer#getNodes()} **/
	@Override
	public Set<N> getNodes() {
		return (nodes);
	}

	/** {@inheritDoc Layer#addNode(Node)} **/
	@Override
	public void addNode(N node) {
		if ((getGraph() != null) && (!getGraph().containsNode(node.getId()))) {
			getGraph().addNode(node);
		}
		nodes.add(node);
	}

	/** {@inheritDoc Layer#removeNode(Node)} **/
	@Override
	public void removeNode(N node) {
		if (nodes != null) {
			nodes.remove(node);
		}
	}

	/** {@inheritDoc Layer#getRelations()} **/
	@Override
	public Set<R> getRelations() {
		return (relations);
	}

	/** {@inheritDoc Layer#addRelation(Relation)} **/
	@Override
	public void addRelation(Relation<? extends Node, ? extends Node> relation) {
		if ((getGraph() != null) && (!getGraph().containsRelation(relation.getId()))) {
			getGraph().addRelation(relation);
		}
		relations.add((R)relation);
	}

	/** {@inheritDoc Layer#removeRelation(Relation)} **/
	@Override
	public void removeRelation(R relation) {
		if (relation != null) {
			relations.remove(relation);
		}
	}
}
