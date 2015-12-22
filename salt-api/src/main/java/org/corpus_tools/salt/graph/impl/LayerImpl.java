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

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.corpus_tools.salt.graph.Graph;
import org.corpus_tools.salt.graph.Layer;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.graph.Relation;

@SuppressWarnings("serial")
public class LayerImpl<N extends Node, R extends Relation<N, N>> extends IdentifiableElementImpl implements Layer<N, R> {

	private Set<N> nodes = null;
	private Set<R> relations = null;

	public LayerImpl() {
		nodes = new HashSet<N>();
		relations = new HashSet<R>();
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
		if (graph != null) {
			if (graph instanceof GraphImpl) {
				((GraphImpl) graph).basicAddLayer(this);
			}
		} else {
			if (getGraph() instanceof GraphImpl) {
				((GraphImpl) getGraph()).basicRemoveLayer(this);
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
	protected void basicSetGraph(Graph graph) {
		this.graph = graph;
	}

	/** {@inheritDoc Layer#getNodes()} **/
	@Override
	public Set<N> getNodes() {
		return (Collections.unmodifiableSet(nodes));
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
		return (Collections.unmodifiableSet(relations));
	}

	/** {@inheritDoc Layer#addRelation(Relation)} **/
	@Override
	public void addRelation(Relation<? extends N, ? extends N> relation) {
		if ((getGraph() != null) && (!getGraph().containsRelation(relation.getId()))) {
			getGraph().addRelation(relation);
		}
		relations.add((R) relation);
	}

	/** {@inheritDoc Layer#removeRelation(Relation)} **/
	@Override
	public void removeRelation(Relation<? extends N, ? extends N> relation) {
		if (relation != null) {
			relations.remove(relation);
		}
	}
}
