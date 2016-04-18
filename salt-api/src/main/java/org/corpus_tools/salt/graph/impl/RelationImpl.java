/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
package org.corpus_tools.salt.graph.impl;

import java.util.HashSet;
import java.util.Set;

import org.corpus_tools.salt.exceptions.SaltParameterException;
import org.corpus_tools.salt.graph.Graph;
import org.corpus_tools.salt.graph.Layer;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.graph.Relation;
import org.corpus_tools.salt.graph.impl.GraphImpl.UPDATE_TYPE;

@SuppressWarnings("serial")
public class RelationImpl<S extends Node, T extends Node> extends IdentifiableElementImpl implements Relation<S, T> {
	
	private final Class<S> sourceClass;
	private final Class<T> targetClass;
	
	/**
	 * Initializes an object of type {@link Relation}.
	 */
	public RelationImpl(Class<S> sourceClass, Class<T> targetClass) {
		this(null, sourceClass, targetClass);
	}

	/**
	 * Initializes an object of type {@link Relation}. If {@link #delegate} is
	 * not null, all functions of this method are delegated to the delegate
	 * object. Setting {@link #delegate} makes this object to a container.
	 * 
	 * @param a
	 *            delegate object of the same type.
	 */
	public RelationImpl(Relation<S, T> delegate, Class<S> sourceClass, Class<T> targetClass) {
		super(delegate);
		this.sourceClass = sourceClass;
		this.targetClass = targetClass;
	}

	/**
	 * {@inheritDoc Relation#getDelegate()}
	 */
	@Override
	@SuppressWarnings("unchecked") // in sync with constructor (and delegate is final)
	public Relation<S, T> getDelegate() {
		return ((Relation<S, T>) super.getDelegate());
	}

	/** source node of this relation. **/
	protected S source = null;

	/**
	 * {@inheritDoc Relation#getSource()}
	 */
	public S getSource() {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			return (getDelegate().getSource());
		}

		return source;
	}

	/**
	 * {@inheritDoc Relation#setSource(Node)} Notifies the graph, about the
	 * change of the source.
	 */
	public void setSource(S source) {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			getDelegate().setSource(source);
			return;
		}

		S oldValue = getSource();
		this.source = source;
		// notify graph about change of target
		if (getGraph() != null && getGraph() instanceof GraphImpl) {
			((GraphImpl<?,?,?>) getGraph()).update(oldValue, this, UPDATE_TYPE.RELATION_SOURCE);
		}
	}
	
	@Override
	public void setSourceUnsafe(Node source) throws SaltParameterException {
		if(getSourceClass().isInstance(source)) {
			setSource(getSourceClass().cast(source));
		} else {
			throw new SaltParameterException("source", "setSourceUnsafe", getClass(), 
					"Must be of type " + getSourceClass().getSimpleName());
		}
	}
	

	/** target node of this relation. **/
	private T target = null;

	/**
	 * {@inheritDoc Relation#getTarget()}
	 */
	public T getTarget() {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			return (getDelegate().getTarget());
		}

		return target;
	}

	/**
	 * {@inheritDoc Relation#setTarget(Node)} Notifies the graph, about the
	 * change of the target.
	 */
	public void setTarget(T target) {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			getDelegate().setTarget(target);
			return;
		}

		T oldValue = this.getTarget();
		this.target = target;
		// notify graph about change of target
		if (getGraph() != null && getGraph() instanceof GraphImpl) {
			((GraphImpl<?,?,?>) getGraph()).update(oldValue, this, UPDATE_TYPE.RELATION_TARGET);
		}
	}
	
	@Override
	public void setTargetUnsafe(Node source) throws SaltParameterException {
		if(getTargetClass().isInstance(source)) {
			setTarget(getTargetClass().cast(source));
		} else {
			throw new SaltParameterException("source", "setTargetUnsafe", getClass(), 
					"Must be of type " + getTargetClass().getSimpleName());
		}
	}
	

	/** container graph **/
	protected Graph<?,?,?> graph = null;

	/** {@inheritDoc Relation#getGraph()} **/
	@Override
	public Graph<?,?,?> getGraph() {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			return getDelegate().getGraph();
		}

		return (graph);
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
	protected void basicSetGraph(Graph<?,?,?> graph) {
		// delegate method to delegate if set
		if (getDelegate() != null && getDelegate() instanceof RelationImpl) {
			((RelationImpl<?,?>) getDelegate()).basicSetGraph(graph);
			return;
		}

		// remove from old graph if it was changed
		if (getGraph() != graph && getGraph() instanceof GraphImpl) {
			((GraphImpl<?,?,?>) getGraph()).basicRemoveRelation(this);
		}
		this.graph = graph;
	}

	/**
	 * Same as {@link #basicSetGraph(Graph)} but does not remove this relation
	 * from old graph, if it was not equal to the passed graph.
	 * 
	 * @param graph
	 */
	protected void basicSetGraph_WithoutRemoving(Graph<?,?,?> graph) {
		if (getDelegate() != null && getDelegate() instanceof RelationImpl) {
			((RelationImpl<?,?>) getDelegate()).basicSetGraph_WithoutRemoving(graph);
			return;
		}
		this.graph = graph;
	}

	/** {@inheritDoc} **/
	@Override
	public Set<? extends Layer<?,?>> getLayers() {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			return (getDelegate().getLayers());
		}

		Set<Layer<?,?>> layers = new HashSet<>();
		if (getGraph() != null) {
			Set<? extends Layer<?,?>> allLayers = getGraph().getLayers();
			if ((allLayers != null) && (allLayers.size() > 0)) {
				for (Layer<?,?> layer : allLayers) {
					if (layer.getRelations().contains(this)) {
						layers.add(layer);
					}
				}
			}
		}
		return (layers);
	}
	
	@Override
	public Class<S> getSourceClass() {
		return sourceClass;
	}

	@Override
	public Class<T> getTargetClass() {
		return targetClass;
	}
}
