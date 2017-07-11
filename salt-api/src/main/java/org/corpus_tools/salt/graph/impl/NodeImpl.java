/**
 * Copyright 2009 Humboldt-Universität zu Berlin.
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

@SuppressWarnings("serial")
public class NodeImpl extends IdentifiableElementImpl implements Node {

	/**
	 * Initializes an object of type {@link Node}.
	 */
	public NodeImpl() {

	}

	/**
	 * Initializes an object of type {@link Node}. If {@link #delegate} is not
	 * null, all functions of this method are delegated to the delegate object.
	 * Setting {@link #delegate} makes this object to a container.
	 * 
	 * @param a
	 *            delegate object of the same type.
	 */
	public NodeImpl(Node delegate) {
		super(delegate);
	}

	/**
	 * Returns the delegate object. If {@link #delegate} is not null, all
	 * functions of this method are delegated to the delegate object. Setting
	 * {@link #delegate} makes this object to a container.
	 * 
	 * @return the delegate object
	 */
	protected Node getDelegate() {
		return ((Node) super.getDelegate());
	}

	/** container graph **/
	protected Graph graph = null;

	/** {@inheritDoc Relation#getGraph()} **/
	@Override
	public Graph getGraph() {
		if (getDelegate() != null) {
			return (getDelegate().getGraph());
		}
		return (graph);
	}

	/** {@inheritDoc Relation#setGraph(Graph)} **/
	@Override
	public void setGraph(Graph graph) {
		if (getDelegate() != null) {
			getDelegate().setGraph(graph);
			return;
		}
		Graph oldGraph = getGraph();
		if (graph != null) {
			graph.addNode(this);
		}
		if (oldGraph != null && oldGraph != graph && oldGraph instanceof GraphImpl) {
			// remove relation from old graph
			((GraphImpl) oldGraph).basicRemoveNode(this);
		}
		basicSetGraph(graph);
	}

	/**
	 * This is an internally used method. To implement a double chaining of
	 * {@link Graph} and {@link Node} object when an node is inserted into this
	 * graph and to avoid an endless invocation the insertion of an node is
	 * split into the two methods {@link #setGraph(Graph)} and
	 * {@link #basicSetGraph(Graph)}. The invocation of methods is implement as
	 * follows:
	 * 
	 * <pre>
	 * {@link Graph#addNode(Node)}                      {@link Node#setGraph(Graph)}
	 *         ||             \ /                   ||
	 *         ||              X                    ||
	 *         \/             / \                   \/
	 * {@link Graph#basicAddNode(Node)}            {@link Node#basicSetGraph(Graph)}
	 * </pre>
	 * 
	 * That means method {@link #setGraph(Graph)} calls
	 * {@link #basicSetGraph(Graph)} and {@link Graph#basicAddNode(Node)}. And
	 * method {@link #setGraph(Graph)} calls {@link Graph#basicAddNode(Node)}
	 * and {@link Node#basicSetGraph(Graph)}.
	 * 
	 * @param graph
	 *            graph which contains this node
	 */
	protected void basicSetGraph(Graph graph) {
		if (getDelegate() != null && getDelegate() instanceof NodeImpl) {
			((NodeImpl) getDelegate()).basicSetGraph(graph);
			return;
		}
		// remove from old graph if it was changed
		if (this.graph != graph && this.graph instanceof GraphImpl) {
			((GraphImpl) this.graph).basicRemoveNode(this);
		}
		this.graph = graph;
	}

	/**
	 * Same as {@link #basicSetGraph(Graph)} but does not remove this node from
	 * old graph, if it was not equal to the passed graph.
	 * 
	 * @param graph
	 */
	protected void basicSetGraph_WithoutRemoving(Graph graph) {
		if (getDelegate() != null && getDelegate() instanceof NodeImpl) {
			((NodeImpl) getDelegate()).basicSetGraph_WithoutRemoving(graph);
			return;
		}

		this.graph = graph;
	}

	/** {@inheritDoc} **/
	@Override
	public Set<? extends Layer> getLayers() {
		if (getDelegate() != null) {
			return (getDelegate().getLayers());
		}
		Set<Layer> layers = new HashSet<>();
		if (getGraph() != null) {
			Set<Layer> allLayers = getGraph().getLayers();
			if ((allLayers != null) && (allLayers.size() > 0)) {
				for (Layer layer : allLayers) {
					if (layer.getNodes().contains(this)) {
						layers.add(layer);
					}
				}
			}
		}
		return (Collections.unmodifiableSet(layers));
	}

	/**
	 * {@inheritDoc} <br/>
	 * Since the method {@link #getLayers()} retrieves all layers by accessing
	 * the layers in graph, this class does not contain an own collection of
	 * layers.
	 **/
	@Override
	public void addLayer(Layer layer) {
		if (getDelegate() != null) {
			getDelegate().addLayer(layer);
			return;
		}
		if (layer != null) {
			layer.addNode(this);
		}
	}

	/**
	 * {@inheritDoc}<br/>
	 * Since the method {@link #getLayers()} retrieves all layers by accessing
	 * the layers in graph, this class does not contain an own collection of
	 * layers.
	 **/
	@Override
	public void removeLayer(Layer layer) {
		if (getDelegate() != null) {
			getDelegate().removeLayer(layer);
			return;
		}
		if (layer != null) {
			layer.removeNode(this);
		}
	}
}
