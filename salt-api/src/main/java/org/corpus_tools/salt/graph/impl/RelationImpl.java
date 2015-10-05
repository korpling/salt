package org.corpus_tools.salt.graph.impl;

import java.util.HashSet;
import java.util.Set;

import org.corpus_tools.salt.graph.Graph;
import org.corpus_tools.salt.graph.Layer;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.graph.Relation;
import org.corpus_tools.salt.graph.impl.GraphImpl.UPDATE_TYPE;

@SuppressWarnings("serial")
public class RelationImpl<S extends Node, T extends Node> extends IdentifiableElementImpl implements Relation<S, T> {
	/**
	 * Initializes an object of type {@link Relation}.
	 */
	public RelationImpl() {
	}

	/**
	 * Initializes an object of type {@link Relation}. If {@link #delegate} is
	 * not null, all functions of this method are delegated to the delegate
	 * object. Setting {@link #delegate} makes this object to a container.
	 * 
	 * @param a
	 *            delegate object of the same type.
	 */
	public RelationImpl(Relation<S, T> delegate) {
		this.delegate = delegate;
	}

	/**
	 * A delegate object of the same type. If {@link #delegate} is not null, all
	 * functions of this method are delegated to the delegate object. Setting
	 * {@link #delegate} makes this object to a container.
	 **/
	protected Relation<S, T> delegate = null;

	/**
	 * {@inheritDoc Relation#getDelegate()}
	 */
	public Relation<S, T> getDelegate() {
		return (delegate);
	}

	/** source node of this relation. **/
	protected S source = null;

	/**
	 * {@inheritDoc Relation#getSource()}
	 */
	public S getSource() {
		return source;
	}

	/**
	 * {@inheritDoc Relation#setSource(Node)} Notifies the graph, about the
	 * change of the source.
	 */
	public void setSource(S source) {
		S oldValue = getSource();
		this.source = source;
		// notify graph about change of target
		if (getGraph() != null && getGraph() instanceof GraphImpl) {
			((GraphImpl) getGraph()).update(oldValue, this, UPDATE_TYPE.RELATION_SOURCE);
		}
	}

	/** target node of this relation. **/
	private T target = null;

	/**
	 * {@inheritDoc Relation#getTarget()}
	 */
	public T getTarget() {
		return target;
	}

	/**
	 * {@inheritDoc Relation#setTarget(Node)} Notifies the graph, about the
	 * change of the target.
	 */
	public void setTarget(T target) {
		T oldValue = this.getTarget();
		this.target = target;
		// notify graph about change of target
		if (getGraph() != null && getGraph() instanceof GraphImpl) {
			((GraphImpl) getGraph()).update(oldValue, this, UPDATE_TYPE.RELATION_TARGET);
		}
	}

	/** container graph **/
	protected Graph graph = null;

	/** {@inheritDoc Relation#getGraph()} **/
	@Override
	public Graph getGraph() {
		return (graph);
	}

	/** {@inheritDoc Relation#setGraph(Graph)} **/
	@Override
	public void setGraph(Graph graph) {
		basicSetGraph(graph);
		if (graph != null) {
			graph.addRelation(this);
		} else {
			// TODO: remove relation from graph
		}
	}

	/**
	 * This is an internally used method. To implement a double chaining of
	 * {@link Graph} and {@link Relation} object when an relation is inserted
	 * into this graph and to avoid an endless invocation the insertion of an
	 * relation is splited into the two methods {@link #setGraph(Graph)} and
	 * {@link #basicSetGraph(Graph)}. The invocation of methods is implement as
	 * follows:
	 * 
	 * <pre>
	 * {@link Graph#addRelation(Relation)}                      {@link Relation#setGraph(Graph)}
	 *         ||             \ /                   ||
	 *         ||              X                    ||
	 *         \/             / \                   \/
	 * {@link Graph#basicAddRelation(Relation)}            {@link Relation#basicSetGraph(Graph)}
	 * </pre>
	 * 
	 * That means method {@link #setGraph(Graph)} calls
	 * {@link #basicSetGraph(Graph)} and
	 * {@link Graph#basicAddRelation(Relation)}. And method
	 * {@link #setGraph(Graph)} calls {@link Graph#basicAddRelation(Relation)}
	 * and {@link Relation#basicSetGraph(Graph)}.
	 * 
	 * @param graph
	 *            graph which contains this relation
	 */
	protected void basicSetGraph(Graph graph) {
		this.graph = graph;
	}

	/** {@inheritDoc} **/
	@Override
	public Set<? extends Layer> getLayers() {
		Set<Layer> layers = new HashSet<>();
		if (getGraph() != null) {
			Set<Layer> allLayers = getGraph().getLayers();
			if ((allLayers != null) && (allLayers.size() > 0)) {
				for (Layer layer : allLayers) {
					if (layer.getRelations().contains(this)) {
						layers.add(layer);
					}
				}
			}
		}
		return (layers);
	}

	/** {@inheritDoc} **/
	@Override
	public void addLayer(Layer layer) {
		if (layer != null) {
			layer.addRelation(this);
		}
	}

	/** {@inheritDoc} **/
	@Override
	public void removeLayer(Layer layer) {
		if (layer != null) {
			layer.removeRelation(this);
		}
	}
}
