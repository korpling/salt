/**
 * Copyright 2009 Humboldt-Universität zu Berlin
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
package org.corpus_tools.salt.extensions.notification.graph.impl;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.corpus_tools.salt.extensions.notification.Listener;
import org.corpus_tools.salt.extensions.notification.graph.Notifier;
import org.corpus_tools.salt.graph.GRAPH_ATTRIBUTES;
import org.corpus_tools.salt.graph.Graph;
import org.corpus_tools.salt.graph.Label;
import org.corpus_tools.salt.graph.Layer;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.graph.Relation;
import org.corpus_tools.salt.graph.impl.GraphImpl;
import org.corpus_tools.salt.graph.impl.NodeImpl;
import org.corpus_tools.salt.graph.impl.RelationImpl;

@SuppressWarnings("serial")
public class GraphNotifierImpl<N extends Node, R extends Relation<N, N>, L extends Layer<N, R>>
		extends GraphImpl<N, R, L> implements Graph<N, R, L>, Notifier {
	// ==========================================> listener list
	protected List<Listener> listenerList = null;

	private Graph<?, ?, ?> owner;

	/** {@inheritDoc} **/
	@Override
	public List<Listener> getListener() {
		return (NotifierHelper.getListener(listenerList));
	}

	/** {@inheritDoc} **/
	@Override
	public synchronized void addListener(Listener listener) {
		listenerList = NotifierHelper.addListener(listenerList, listener);
	}

	/** {@inheritDoc} **/
	@Override
	public void addListener(Collection<Listener> listener) {
		listenerList = NotifierHelper.addListener(listenerList, listener);
	}

	/** {@inheritDoc} **/
	@Override
	public synchronized void removeListener(Listener listener) {
		listenerList = NotifierHelper.removeListener(listenerList, listener);
	}

	/**
	 * @return the owner
	 */
	public Graph<?, ?, ?> getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(Graph<?, ?, ?> owner) {
		this.owner = owner;
	}

	// ==========================================< listener list

	// ==========================================> label handling
	/**
	 * {@inheritDoc} Notifies all registered listeners.
	 **/
	@Override
	public void addLabel(Label label) {
		super.addLabel(label);
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.ADD, GRAPH_ATTRIBUTES.GRAPH_LABELS, null,
					label, this);
		}
	}

	/**
	 * {@inheritDoc} Notifies all registered listeners.
	 **/
	@Override
	public void removeLabel(String qName) {
		Label oldValue = getLabel(qName);
		super.removeLabel(qName);
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.REMOVE, GRAPH_ATTRIBUTES.GRAPH_LABELS,
					oldValue, null, this);
		}
	}

	/**
	 * {@inheritDoc} Notifies all registered listeners.
	 **/
	@Override
	public void removeAll() {
		Collection<Label> oldValue = getLabels();
		super.removeAll();
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.REMOVE_ALL, GRAPH_ATTRIBUTES.GRAPH_LABELS,
					oldValue, null, this);
		}
	}

	// ==========================================< label handling

	@Override
	public void addNode(N node) {
		super.addNode(node);
		// HACK: Reset to the actual owning graph before notifying the listeners.
		// It would be better if the super.addNode() would have an optional parameter for
		// the real graph.
		if (owner != null) {
			if (node instanceof NodeImpl) {
				((NodeImpl) node).basicSetGraph_WithoutRemoving(owner);
			}
		}
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.ADD, GRAPH_ATTRIBUTES.GRAPH_NODES, null,
					node, this);
		}
	}

	@Override
	public void removeNode(N node) {
		super.removeNode(node);
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.REMOVE, GRAPH_ATTRIBUTES.GRAPH_NODES, node,
					null, this);
		}
	}

	@Override
	public void addRelation(Relation<? extends N, ? extends N> relation) {
		super.addRelation(relation);
		// HACK: Reset to the actual owning graph before notifying the listeners.
		// It would be better if the super.addRelation() would have an optional parameter for
		// the real graph.
		if (owner != null) {
			if (relation instanceof RelationImpl) {
				((RelationImpl) relation).basicSetGraph_WithoutRemoving(owner);
			}
		}
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.ADD, GRAPH_ATTRIBUTES.GRAPH_RELATIONS, null,
					relation, this);
		}
	}

	@Override
	public void removeRelation(Relation<? extends N, ? extends N> relation) {
		super.removeRelation(relation);
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.REMOVE, GRAPH_ATTRIBUTES.GRAPH_RELATIONS,
					relation, null, this);
		}
	}

	@Override
	public void removeRelations() {
		List<R> oldValue = getRelations();
		super.removeRelations();
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.REMOVE_ALL, GRAPH_ATTRIBUTES.GRAPH_RELATIONS,
					oldValue, null, this);
		}
	}

	@Override
	public void addLayer(L layer) {
		super.addLayer(layer);
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.ADD, GRAPH_ATTRIBUTES.GRAPH_LAYERS, null,
					layer, this);
		}
	}

	@Override
	public void removeLayer(L layer) {
		Set<L> oldValue = getLayers();
		super.removeLayer(layer);
		if (listenerList != null) {
			NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.REMOVE, GRAPH_ATTRIBUTES.GRAPH_LAYERS,
					oldValue, null, this);
		}
	}

}
