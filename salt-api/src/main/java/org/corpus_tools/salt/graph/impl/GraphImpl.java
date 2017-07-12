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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.corpus_tools.salt.exceptions.SaltException;
import org.corpus_tools.salt.exceptions.SaltInsertionException;
import org.corpus_tools.salt.exceptions.SaltParameterException;
import org.corpus_tools.salt.graph.Graph;
import org.corpus_tools.salt.graph.Layer;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.graph.Relation;
import org.corpus_tools.salt.index.IndexMgr;
import org.corpus_tools.salt.index.IndexMgrImpl;
import org.corpus_tools.salt.util.SaltUtil;

public class GraphImpl<N extends Node, R extends Relation<? extends N, ? extends N>, L extends Layer<N, R>>
		extends IdentifiableElementImpl implements Graph<N, R, L> {
	private static final long serialVersionUID = 523300417198828629L;
	private final Class<N> nodeClass;
	private final Class<R> relationClass;
	private final Class<L> layerClass;

	/**
	 * Initializes an object of type {@link Graph}. If {@link #delegate} is not
	 * null, all functions of this method are delegated to the delegate object.
	 * Setting {@link #delegate} makes this object to a container.
	 * 
	 * @param a
	 *            delegate object of the same type.
	 */
	public GraphImpl(Graph<N, R, L> delegate, Class<N> nodeClass, Class<R> relationClass, Class<L> layerClass) {
		super(delegate);
		this.nodeClass = nodeClass;
		this.relationClass = relationClass;
		this.layerClass = layerClass;
		init();
	}

	@Override
	@SuppressWarnings("unchecked") // in sync with constructor (and delegate is
									// final)
	protected Graph<N, R, L> getDelegate() {
		return (Graph<N, R, L>) super.getDelegate();
	}

	public GraphImpl(Class<N> nodeClass, Class<R> relationClass, Class<L> layerClass) {
		this(null, nodeClass, relationClass, layerClass);
		init();
	}

	/** Index manager **/
	protected IndexMgr indexMgr = null;

	/**
	 * Returns the index manager. The index manager is used to register indexes
	 * for sets of nodes, relations, layers etc. or single values. The manager
	 * contains all indexes used by the {@link Graph} class. These indexes are:
	 * 
	 * <ul>
	 * <li>{@link SaltUtil#IDX_ID_NODES}</li>
	 * <li>{@link SaltUtil#IDX_ID_RELATIONS}</li>
	 * </ul>
	 * Even further indexes can be added to the index manager.
	 * 
	 * @return the index manager
	 */
	public IndexMgr getIndexMgr() {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			return getDelegate().getIndexMgr();
		}
		return indexMgr;
	}

	/**
	 * Instantiates a new graph object and sets the initial capacity for all
	 * indexes to the passed ones
	 * 
	 * @param expectedNodes
	 *            expected upper bound of nodes in the graph, used for
	 *            optimization
	 * @param expectedRelations
	 *            expected upper bound of relations in the graph, used for
	 *            optimization
	 */
	public GraphImpl(int expectedNodes, int expectedRelations, Class<N> nodeClass, Class<R> relationClass,
			Class<L> layerClass) {
		this(null, nodeClass, relationClass, layerClass);
		init();
		this.expectedNodes = expectedNodes;
		this.expectedRelations = expectedRelations;
		approximatedNodeDegree = expectedRelations / expectedNodes;
	}

	/** Number of expected nodes to initialize indexes **/
	// protected int expectedNodes = 1000;
	protected int expectedNodes = 16;
	/** Number of expected relations to initialize indexes **/
	// protected int expectedRelations = 5000;
	protected int expectedRelations = 16;
	/**
	 * Approximated node degree, which is {@link #expectedRelations} /
	 * {@link #expectedNodes}
	 **/
	protected int approximatedNodeDegree = expectedRelations / expectedNodes;

	/**
	 * Initializes an object of type {@link GraphImpl}.
	 * <ul>
	 * <li>{@link SaltUtil#IDX_ID_NODES}</li>
	 * <li>{@link SaltUtil#IDX_ID_RELATIONS}</li>
	 * <li>{@link SaltUtil#IDX_ID_LAYER}</li>
	 * <li>{@link SaltUtil#IDX_OUT_RELATIONS}</li>
	 * <li>{@link SaltUtil#IDX_IN_RELATIONS}</li>
	 * </ul>
	 */
	protected void init() {
		layers = Collections.synchronizedSet(new HashSet<L>());
		nodes = Collections.synchronizedList(new ArrayList<N>(expectedNodes));
		relations = Collections.synchronizedList(new ArrayList<R>(expectedNodes));
		indexMgr = new IndexMgrImpl();
		indexMgr.createIndex(SaltUtil.IDX_ID_NODES, expectedNodes, expectedNodes);
		indexMgr.createIndex(SaltUtil.IDX_ID_NODES_INVERSE, expectedNodes, expectedNodes);
		indexMgr.createIndex(SaltUtil.IDX_ID_RELATIONS, expectedRelations, expectedRelations);
		indexMgr.createIndex(SaltUtil.IDX_ID_RELATIONS_INVERSE, expectedRelations, expectedRelations);
		indexMgr.createIndex(SaltUtil.IDX_ID_LAYER);
		indexMgr.createIndex(SaltUtil.IDX_OUT_RELATIONS, expectedNodes, approximatedNodeDegree);
		indexMgr.createIndex(SaltUtil.IDX_IN_RELATIONS, expectedNodes, approximatedNodeDegree);
	}

	// =========================================================== > Nodes
	/** internal list of all contained nodes **/
	private List<N> nodes = null;

	/** {@inheritDoc Graph#getNodes()} **/
	@Override
	public List<N> getNodes() {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			return getDelegate().getNodes();
		}
		return (Collections.unmodifiableList(nodes));
	}

	/** {@inheritDoc Graph#getNode(String)} **/
	@Override
	public N getNode(String nodeId) {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			return getDelegate().getNode(nodeId);
		}

		if (nodeId == null) {
			return (null);
		}
		Node n = getIndexMgr().get(SaltUtil.IDX_ID_NODES, nodeId);
		if (nodeClass != null && nodeClass.isInstance(n)) {
			return nodeClass.cast(n);
		} else {
			return null;
		}
	}

	/** {@inheritDoc Graph#addNode(Node)} **/
	@Override
	public void add(N node) {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			getDelegate().add(node);
			if (node instanceof NodeImpl) {
				((NodeImpl) node).basicSetGraph_WithoutRemoving(this);
			}
			return;
		}
		basicAddNode(node);
		if (node instanceof NodeImpl) {
			((NodeImpl) node).basicSetGraph(this);
		}
	}

	/**
	 * This is an internally used method. To implement a double chaining of
	 * {@link Graph} and {@link Node} object when an node is inserted into this
	 * graph and to avoid an endless invocation the insertion of an relation is
	 * split into the two methods {@link #addNode(node)} and
	 * {@link #basicAddNode(Node)}. The invocation of methods is implement as
	 * follows:
	 * 
	 * <pre>
	 * {@link #addNode(node)}                      {@link Node#setGraph(Graph)}
	 *         ||             \ /                   ||
	 *         ||              X                    ||
	 *         \/             / \                   \/
	 * {@link #basicAddNode(Node)}            {@link Node#basicSetGraph(Graph)}
	 * </pre>
	 * 
	 * That means method {@link #addNode(Node)} calls
	 * {@link #basicAddNode(Node)} and {@link Node#basicSetGraph(Graph)}. And
	 * method {@link Node#setGraph(Graph)} calls {@link #basicAddNode(Node)} and
	 * {@link Node#basicSetGraph(Graph)}.
	 * 
	 * @param node
	 *            node to be inserted
	 */
	protected void basicAddNode(N node) {
		if (node == null) {
			throw new SaltParameterException("node", "basicAddNode", GraphImpl.class, "A null value is not allowed. ");
		}

		// check if node already exists
		if (getIndexMgr().containsKey(SaltUtil.IDX_ID_NODES_INVERSE, node)) {
			// do nothing, node is already added
			return;
		}

		// if node has no id a new id will be given to node
		if (node.getId() == null) {
			node.setId("n" + getNodes().size());
		}
		int i = 0;
		// the given id, which eventually has to be extended for artificial
		// counter
		String idBase = node.getId();
		while (getNode(node.getId()) != null) {
			// if node already exists, create new Id
			node.setId(idBase + "_" + (getNodes().size() + i));
			i++;
		} // if node Id already exists, create new Id

		// add node to internal list
		nodes.add(node);
		// add node to id indexes
		getIndexMgr().put(SaltUtil.IDX_ID_NODES, node.getId(), node);
		getIndexMgr().put(SaltUtil.IDX_ID_NODES_INVERSE, node, node.getId());
	}

	/** {@inheritDoc Graph#removeNode(Node)} **/
	@Override
	public void removeNode(N node) {
		if (node != null) {
			if (node instanceof NodeImpl) {
				((NodeImpl) node).basicSetGraph(null);
			}
			basicRemoveNode(node);
		}
	}

	/**
	 * This is an internally used method. To realize the cut of the double
	 * chaining, the removal is split in two methods {@link #removeNode(Node)}
	 * and {@link #basicRemoveNode(Node)}. which are connected as follows:
	 * 
	 * <pre>
	 * {@link #removeNode(node)}                      {@link Node#setGraph(null)}
	 *         ||             \ /                   ||
	 *         ||              X                    ||
	 *         \/             / \                   \/
	 * {@link #basicRemoveNode(Node)}            {@link Node#basicSetGraph(null)}
	 * </pre>
	 * 
	 * @param node
	 *            the node to be removed
	 */
	protected void basicRemoveNode(Node node) {
		// remove node from internal list
		nodes.remove(node);
		// remove the node object from the inverse index
		getIndexMgr().remove(SaltUtil.IDX_ID_NODES_INVERSE, node);
		// remove node from all internal indexes
		getIndexMgr().removeValue(node, Node.class);
		// remove all relations having the removed node as source or target and
		// update index outgoing and incoming indexes
		Collection<R> rels = new ArrayList<>(getInRelations(node.getId()));
		for (R r : rels) {
			removeRelation(r);
		}
		rels = new ArrayList<>(getOutRelations(node.getId()));
		for (R r : rels) {
			removeRelation(r);
		}

		// remove node also from layers
		for (L layer : layers) {
			layer.removeNode(node);
		}
	}

	/** {@inheritDoc Graph#containsNode(String)} **/
	@Override
	public boolean containsNode(String nodeId) {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			return getDelegate().containsNode(nodeId);
		}

		if (nodeId == null) {
			return (false);
		}
		return (getIndexMgr().containsKey(SaltUtil.IDX_ID_NODES, nodeId));
	}

	// =========================================================== < Nodes

	// =========================================================== > Relations

	/** internal list of all contained relations **/
	private List<R> relations = null;

	/** {@inheritDoc Graph#getRelations()} **/
	@Override
	public List<R> getRelations() {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			return getDelegate().getRelations();
		}
		return (Collections.unmodifiableList(relations));
	}

	/** {@inheritDoc Graph#getRelation(String)} **/
	@Override
	public R getRelation(String relationId) {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			return getDelegate().getRelation(relationId);
		}

		if (relationId == null) {
			return (null);
		}
		Relation<?, ?> rel = getIndexMgr().get(SaltUtil.IDX_ID_RELATIONS, relationId);
		if (relationClass != null && relationClass.isInstance(rel)) {
			return relationClass.cast(rel);
		} else {
			return null;
		}
	}

	/** {@inheritDoc} **/
	public List<R> getRelations(String sourceNodeId, String targetNodeId) {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			return getDelegate().getRelations(sourceNodeId, targetNodeId);
		}

		List<R> retList = new ArrayList<>();
		// searching for all relations going out from nodeId1
		List<R> outRelations = getOutRelations(sourceNodeId);

		if (outRelations != null) {
			for (R relation : outRelations) {// searching if relation goes to
												// nodeId2
				if (relation.getTarget().getId().equals(targetNodeId)) {
					// adding relation to list of matching relations
					retList.add(relation);
				}
			} // searching if relation goes to nodeId2
		}
		return (retList);
	}

	/** {@inheritDoc} **/
	@Override
	public List<R> getInRelations(String nodeId) {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			return getDelegate().getInRelations(nodeId);
		}

		List<Relation<?, ?>> relations = getIndexMgr().getAll(SaltUtil.IDX_IN_RELATIONS, nodeId);
		List<R> result = new ArrayList<>(relations.size());
		if (relationClass != null) {
			for (Relation<?, ?> rel : relations) {
				if (relationClass.isInstance(rel)) {
					result.add(relationClass.cast(rel));
				}
			}
		}
		return result;
	}

	/** {@inheritDoc} **/
	@Override
	public List<R> getOutRelations(String nodeId) {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			return getDelegate().getOutRelations(nodeId);
		}

		List<Relation<?, ?>> relations = getIndexMgr().getAll(SaltUtil.IDX_OUT_RELATIONS, nodeId);
		List<R> result = new ArrayList<>(relations.size());
		if (relationClass != null) {
			for (Relation<?, ?> rel : relations) {
				if (relationClass.isInstance(rel)) {
					result.add(relationClass.cast(rel));
				}
			}
		}
		return result;
	}

	/** {@inheritDoc Graph#addRelation(Relation)} **/
	@Override
	public void add(R relation) {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			getDelegate().add(relation);
			if (relation instanceof RelationImpl) {
				((RelationImpl<? extends N, ? extends N>) relation).basicSetGraph_WithoutRemoving(this);
			}
			return;
		}
		if (relation instanceof RelationImpl) {
			((RelationImpl<? extends N, ? extends N>) relation).basicSetGraph(this);
		}
		basicAddRelation(relation);
	}

	/**
	 * This is an internally used method. To implement a double chaining of
	 * {@link Graph} and {@link Relation} object when an relation is inserted
	 * into this graph and to avoid an endless invocation the insertion of an
	 * relation is split into the two methods {@link #addRelation(Relation)} and
	 * {@link #basicAddRelation(Relation)}. The invocation of methods is
	 * implement as follows:
	 * 
	 * <pre>
	 * {@link #addRelation(Relation)}                      {@link Relation#setGraph(Graph)}
	 *         ||             \ /                   ||
	 *         ||              X                    ||
	 *         \/             / \                   \/
	 * {@link #basicAddRelation(Relation)}            {@link Relation#basicSetGraph(Graph)}
	 * </pre>
	 * 
	 * That means method {@link #addRelation(Relation)} calls
	 * {@link #basicAddRelation(Relation)} and
	 * {@link Relation#basicSetGraph(Graph)}. And method
	 * {@link Relation#setGraph(Graph)} calls
	 * {@link #basicAddRelation(Relation)} and
	 * {@link Relation#basicSetGraph(Graph)}.
	 * 
	 * @param relation
	 *            relation to be inserted
	 */
	protected void basicAddRelation(R relation) {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			if (getDelegate() instanceof GraphImpl) {
				((GraphImpl<N, R, L>) getDelegate()).basicAddRelation(relation);
			}
			return;
		}

		if (relation == null) {
			throw new SaltParameterException("relation", "basicAddRelation", GraphImpl.class,
					"A null value is not allowed. ");
		}
		if (relation.getSource() == null) {
			throw new SaltInsertionException(this, relation, "The source node is empty. ");
		}
		if (relation.getTarget() == null) {
			throw new SaltInsertionException(this, relation, "The target node is empty. ");
		}
		if ((relation.getSource().getId() == null) || (!containsNode(relation.getSource().getId()))) {
			throw new SaltInsertionException(this, relation,
					"The source node of the passed relation does not belong to this graph. ");
		}
		if ((relation.getTarget().getId() == null) || (!containsNode(relation.getTarget().getId()))) {
			throw new SaltInsertionException(this, relation,
					"The target node of the passed relation does not belong to this graph. ");
		}

		if (getIndexMgr().containsKey(SaltUtil.IDX_ID_RELATIONS_INVERSE, relation)) {
			return;
		}

		// if relation has no id a new id will be given to relation
		if (relation.getId() == null) {
			relation.setId("r" + getRelations().size());
		}
		int i = 0;
		// the given id, which eventually has to be extended for artificial
		// counter
		String idBase = relation.getId();
		while (getRelation(relation.getId()) != null) {
			// if relation already exists, create new Id
			relation.setId(idBase + "_" + (getRelations().size() + i));
			i++;
		}
		// add relation to internal list
		relations.add((R) relation);
		// add relation to indexes
		getIndexMgr().put(SaltUtil.IDX_ID_RELATIONS, relation.getId(), (R) relation);
		getIndexMgr().put(SaltUtil.IDX_ID_RELATIONS_INVERSE, relation, relation.getId());
		update(null, relation, UPDATE_TYPE.RELATION_SOURCE);
		update(null, relation, UPDATE_TYPE.RELATION_TARGET);
	}

	enum UPDATE_TYPE {
		RELATION_TARGET, RELATION_SOURCE
	}

	/**
	 * Updates all graph internal indexes, concerning the kind of the update
	 * which has been made. If the update could not be performed, false is
	 * returned. True otherwise.
	 * 
	 * @param oldValue
	 *            old value
	 * @param container
	 *            the object which has been updated
	 * @param updateType
	 *            type of update to be performed
	 * @throws SaltException
	 *             in case the update could not be performed
	 */
	protected void update(Object oldValue, Object container, UPDATE_TYPE updateType) throws SaltException {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			if (getDelegate() instanceof GraphImpl) {
				((GraphImpl<N, R, L>) getDelegate()).update(oldValue, container, updateType);
				return;
			}
		}

		if (UPDATE_TYPE.RELATION_SOURCE.equals(updateType)) {
			// as long as R extends Relation, this check is valid
			if (container instanceof Relation) {
				Relation<?, ?> relation = (Relation<?, ?>) container;
				getIndexMgr().put(SaltUtil.IDX_OUT_RELATIONS, relation.getSource().getId(), relation);
				// as long as N extends Node, this check is valid
				if (oldValue != null && oldValue instanceof Node) {
					Node node = (Node) oldValue;
					getIndexMgr().remove(SaltUtil.IDX_OUT_RELATIONS, node.getId(), relation);
				}
			}
		} else if (UPDATE_TYPE.RELATION_TARGET.equals(updateType)) {
			// as long as R extends Relation, this check is valid
			if (container instanceof Relation) {
				Relation<?, ?> relation = (Relation<?, ?>) container;
				getIndexMgr().put(SaltUtil.IDX_IN_RELATIONS, relation.getTarget().getId(), relation);
				if (oldValue != null && oldValue instanceof Node) {
					Node node = (Node) oldValue;
					getIndexMgr().remove(SaltUtil.IDX_IN_RELATIONS, node.getId(), relation);
				}
			}
		}
	}

	/** {@inheritDoc} **/
	@Override
	public void removeRelation(R rel) {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			getDelegate().removeRelation(rel);
			return;
		}
		if (rel != null) {
			if (rel instanceof RelationImpl) {
				((RelationImpl<? extends N, ? extends N>) rel).basicSetGraph(null);
			}
			basicRemoveRelation(rel);
		}
	}

	/** {@inheritDoc} **/
	@Override
	public void removeRelations() {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			getDelegate().removeRelations();
			return;
		}
		relations.clear();
		getIndexMgr().clearIndex(SaltUtil.IDX_ID_RELATIONS);
		getIndexMgr().clearIndex(SaltUtil.IDX_ID_RELATIONS_INVERSE);
		getIndexMgr().clearIndex(SaltUtil.IDX_IN_RELATIONS);
		getIndexMgr().clearIndex(SaltUtil.IDX_OUT_RELATIONS);
	}

	/**
	 * This is an internally used method. To realize the cut of the double
	 * chaining, the removal is split in two methods
	 * {@link #removeRelation(Relation)} and
	 * {@link #basicRemoveRelation(Relation)}. which are connected as follows:
	 * 
	 * <pre>
	 * {@link #removeRelation(relation)}                      {@link Relation#setGraph(null)}
	 *         ||             \ /                   ||
	 *         ||              X                    ||
	 *         \/             / \                   \/
	 * {@link #basicRemoveRelation(Relation)}            {@link Relation#basicSetGraph(null)}
	 * </pre>
	 * 
	 * @param relation
	 *            the relation to be removed
	 */
	protected void basicRemoveRelation(Relation<?, ?> rel) {
		// remove relation from all indexes
		getIndexMgr().removeValue(rel, Relation.class);
		getIndexMgr().remove(SaltUtil.IDX_ID_RELATIONS_INVERSE, rel);
		// remove relation also from layers
		for (L layer : layers) {
			layer.removeRelation(rel);
		}
		// remove relation from internal list
		relations.remove(rel);
	}

	/** {@inheritDoc Graph#containsRelation(String)} **/
	@Override
	public boolean containsRelation(String relationId) {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			return (getDelegate().containsRelation(relationId));
		}
		if (relationId == null) {
			return (false);
		}
		return (getIndexMgr().containsKey(SaltUtil.IDX_ID_RELATIONS, relationId));
	}

	// =========================================================== < Relations

	// =========================================================== > Layers
	private Set<L> layers = null;

	/** {@inheritDoc} **/
	@Override
	public Set<L> getLayers() {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			return getDelegate().getLayers();
		}

		return (Collections.unmodifiableSet(layers));
	}

	/** {@inheritDoc} **/
	@Override
	public L getLayer(String layerId) {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			return getDelegate().getLayer(layerId);
		}

		if (layerId == null) {
			return (null);
		}
		Layer<?, ?> layer = getIndexMgr().get(SaltUtil.IDX_ID_LAYER, layerId);
		if (layerClass != null && layerClass.isInstance(layer)) {
			return layerClass.cast(layer);
		} else {
			return null;
		}
	}

	/** {@inheritDoc Graph#containsLayer(String)} **/
	@Override
	public boolean containsLayer(String layerId) {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			return getDelegate().containsLayer(layerId);
		}

		return (getIndexMgr().containsKey(SaltUtil.IDX_ID_LAYER, layerId));
	}

	/** {@inheritDoc} **/
	@Override
	public void add(L layer) {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			getDelegate().add(layer);
			if (layer instanceof LayerImpl<?, ?>) {
				((LayerImpl<N, R>) layer).basicSetGraph_WithoutRemoving(this);
			}
			return;
		}

		if (layer != null && !layers.contains(layer)) {
			basicAddLayer(layer);
			if (layer instanceof LayerImpl<?, ?>) {
				((LayerImpl<N, R>) layer).basicSetGraph(this);
			}
			// check whether graph contains nodes in layer, if not, add them
			for (N node : layer.getNodes()) {
				if (!containsNode(node.getId())) {
					add(node);
				}
			}

			// check whether graph contains relations in layer, if not, add them
			for (R rel : layer.getRelations()) {
				if (!containsRelation(rel.getId())) {
					add(rel);
				}
			}
		}
	}

	/**
	 * This is an internally used method. To implement a double chaining of
	 * {@link Graph} and {@link Node} object when an node is inserted into this
	 * graph and to avoid an endless invocation the insertion of an relation is
	 * split into the two methods {@link #addNode(node)} and
	 * {@link #basicAddNode(Node)}. The invocation of methods is implement as
	 * follows:
	 * 
	 * <pre>
	 * {@link #addLayer(layer)}                      {@link Layer#setGraph(Graph)}
	 *         ||             \ /                   ||
	 *         ||              X                    ||
	 *         \/             / \                   \/
	 * {@link #basicAddLayer(Layer)}            {@link Layer#basicSetGraph(Graph)}
	 * </pre>
	 * 
	 * That means method {@link #addLayer(Layer)} calls
	 * {@link #basicAddLayer(Layer)} and {@link Node#basicSetGraph(Graph)}. And
	 * method {@link Layer#setGraph(Graph)} calls {@link #basicAddLayer(Layer)}
	 * and {@link Layer#basicSetGraph(Graph)}.
	 * 
	 * @param node
	 *            node to be inserted
	 */
	protected void basicAddLayer(L layer) {
		if (layer != null) {
			if (!layers.contains(layer)) {
				// if layers has no id a new id will be given to layer
				if (layer.getId() == null) {
					layer.setId("l" + getLayers().size());
				}
				int i = 0;
				// the given id, which eventually has to be extended for
				// artificial counter
				String idBase = layer.getId();
				while (getLayer(layer.getId()) != null) {
					// if layer already exists, create new Id
					layer.setId(idBase + "_" + (getLayers().size() + i));
					i++;
				}
				layers.add(layer);
				getIndexMgr().put(SaltUtil.IDX_ID_LAYER, layer.getId(), layer);
			}
		}
	}

	/** {@inheritDoc} **/
	@Override
	public void removeLayer(L layer) {
		// delegate method to delegate if set
		if (getDelegate() != null) {
			getDelegate().removeLayer(layer);
			return;
		}
		if (layer instanceof LayerImpl<?, ?>) {
			((LayerImpl<N, R>) layer).basicSetGraph(null);
		}
		basicRemoveLayer(layer);
	}

	/**
	 * This is an internally used method. To realize the cut of the double
	 * chaining, the removal is split in two methods {@link #removeLayer(Layer)}
	 * and {@link #basicRemoveLayer(Layer)}. which are connected as follows:
	 * 
	 * <pre>
	 * {@link #removeLayer(layer)}                      {@link Layer#setGraph(null)}
	 *         ||             \ /                   ||
	 *         ||              X                    ||
	 *         \/             / \                   \/
	 * {@link #basicRemoveLayer(Layer)}            {@link Layer#basicSetGraph(null)}
	 * </pre>
	 * 
	 * @param node
	 *            the node to be removed
	 */
	protected void basicRemoveLayer(Layer<?, ?> layer) {
		if (layer != null) {
			if (layers.contains(layer)) {
				layers.remove(layer);
				getIndexMgr().removeValue(layer, Layer.class);
			}
		}
	}
	// =========================================================== < Layers
}
