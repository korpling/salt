package de.hu_berlin.u.saltnpepper.graph.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import de.hu_berlin.u.saltnpepper.graph.Relation;
import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.graph.Layer;
import de.hu_berlin.u.saltnpepper.graph.NamedElement;
import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltInsertionException;

@SuppressWarnings("serial")
public class GraphImpl<N extends Node, R extends Relation<N, N>> extends IdentifiableElementImpl implements Graph<N, R>, NamedElement {
	public GraphImpl() {
		init();
	}

	/**
	 * Instantiates a new graph object and sets the initial capacity for all
	 * indexes to the passed ones
	 */
	public GraphImpl(int expectedNodes, int expectedRelations) {
		init();
		this.expectedNodes = expectedNodes;
		this.expectedRelations = expectedRelations;
		approximatedNodeDegree = expectedRelations / expectedNodes;
	}

	/** Number of expected nodes to initialize indexes **/
	private int expectedNodes = 1000;
	/** Number of expected relations to initialize indexes **/
	private int expectedRelations = 5000;
	/**
	 * Approximated node degree, which is {@link #expectedRelations} /
	 * {@link #expectedNodes}
	 **/
	private int approximatedNodeDegree = expectedRelations / expectedNodes;

	/**
	 * Initializes an object of type {@link GraphImpl}.
	 * <ul>
	 * <li>Initializes nodes list</li>
	 * <li>Initializes relations list</li>
	 * <li>Initializes layers set</li>
	 * <li>Initializes index {@link #idx_node_id}</li>
	 * <li>Initializes index {@link #idx_relation_id}</li>
	 * <li>Initializes index {@link #idx_layer_id}</li>
	 * <li>Initializes index {@link #idx_out_relation_id}</li>
	 * <li>Initializes index {@link #idx_in_relation_id}</li>
	 * </ul>
	 */
	private void init() {
		layers = Collections.synchronizedSet(new HashSet<Layer<N, R>>());
		nodes = Collections.synchronizedList(new ArrayList<N>(expectedNodes));
		relations = Collections.synchronizedList(new ArrayList<R>(expectedNodes));

		idx_node_id = new ConcurrentHashMap<>(expectedNodes);
		idx_relation_id = new ConcurrentHashMap<>(expectedRelations);
		idx_layer_id = new ConcurrentHashMap<>();
		idx_out_relation_id = ArrayListMultimap.create(expectedNodes, approximatedNodeDegree);
		idx_in_relation_id = ArrayListMultimap.create(expectedNodes, approximatedNodeDegree);
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setName(String name) {
		// TODO Auto-generated method stub

	}

	// =========================================================== > Indexes
	/**
	 * An index storing all nodes and their corresponding ids (key: id; value:
	 * node)
	 **/
	private Map<String, N> idx_node_id = null;
	/**
	 * An index storing all relations and their corresponding ids (key: id;
	 * value: relation)
	 **/
	private Map<String, R> idx_relation_id = null;
	/**
	 * An index storing all layers and their corresponding ids (key: id; value:
	 * layer)
	 **/
	private Map<String, Layer<N, R>> idx_layer_id = null;
	/**
	 * An index storing all node ids and the corresponding outgoing relations
	 * (key: node id; value: relation)
	 **/
	private ListMultimap<String, R> idx_out_relation_id = null;
	/**
	 * An index storing all node ids and the corresponding incoming relations
	 * (key: node id; value: relation)
	 **/
	private ListMultimap<String, R> idx_in_relation_id = null;
	// =========================================================== < Indexes

	// =========================================================== > Nodes
	/** internal list of all contained nodes **/
	private List<N> nodes = null;

	/** {@inheritDoc Graph#getNodes()} **/
	@Override
	public List<N> getNodes() {
		return (Collections.unmodifiableList(nodes));
	}

	/** {@inheritDoc Graph#getNode(String)} **/
	@Override
	public N getNode(String nodeId) {
		return (idx_node_id.get(nodeId));
	}

	/** {@inheritDoc Graph#addNode(Node)} **/
	@Override
	public void addNode(N node) {
		basicAddNode(node);
		if (node != null) {
			if (node instanceof NodeImpl) {
				((NodeImpl) node).basicSetGraph(this);
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
			throw new SaltInsertionException(this, node, "A null value is not allowed. ");
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
		}// if node already exists, create new Id
			// add node to internal list
		nodes.add(node);
		// add node to id index
		idx_node_id.put(node.getId(), node);
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
	protected void basicRemoveNode(N node) {
		// remove node from internal list
		nodes.remove(node);
		// remove node from internal index
		idx_node_id.remove(node.getId());
		// TODO remove all relations and update index outgoing and incoming
		// indexes
		// remove node also from layers
		for (Layer<N, R> layer : layers) {
			layer.removeNode(node);
		}
	}

	/** {@inheritDoc Graph#containsNode(String)} **/
	@Override
	public boolean containsNode(String nodeId) {
		return (idx_node_id.containsKey(nodeId));
	}

	// =========================================================== < Nodes

	// =========================================================== > Relations

	/** internal list of all contained relations **/
	private List<R> relations = null;

	/** {@inheritDoc Graph#getRelations()} **/
	@Override
	public List<R> getRelations() {
		return (Collections.unmodifiableList(relations));
	}

	/** {@inheritDoc Graph#getRelation(String)} **/
	@Override
	public R getRelation(String relationId) {
		return (idx_relation_id.get(relationId));
	}

	/** {@inheritDoc} **/
	public List<R> getRelations(String nodeId1, String nodeId2) {
		List<R> retList = new ArrayList<>();
		// searching for all relations going out from nodeId1
		List<R> outRelations = getOutRelations(nodeId1);

		if (outRelations != null) {
			for (R relation : outRelations) {// searching if relation goes to
												// nodeId2
				if (relation.getTarget().getId().equals(nodeId2)) {
					// adding relation to list of matching relations
					retList.add(relation);
				}
			}// searching if relation goes to nodeId2
		}
		return (retList);
	}

	/** {@inheritDoc} **/
	@Override
	public List<R> getInRelations(String nodeId) {
		return (idx_in_relation_id.get(nodeId));
	}

	/** {@inheritDoc} **/
	@Override
	public List<R> getOutRelations(String nodeId) {
		return (idx_out_relation_id.get(nodeId));
	}

	/** {@inheritDoc Graph#addRelation(Relation)} **/
	@Override
	public void addRelation(R relation) {
		basicAddRelation(relation);
		if (relation != null) {
			if (relation instanceof RelationImpl) {
				((RelationImpl<N, N>) relation).basicSetGraph(this);
			}
		}
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
		if (relation == null) {
			throw new SaltInsertionException(this, relation, "A null value is not allowed. ");
		}
		if (relation.getSource() == null) {
			throw new SaltInsertionException(this, relation, "The source node is empty. ");
		}
		if (relation.getTarget() == null) {
			throw new SaltInsertionException(this, relation, "The target node is empty. ");
		}
		if ((relation.getSource().getId() == null) || (!containsNode(relation.getSource().getId()))) {
			throw new SaltInsertionException(this, relation, "The source node of the passed relation does not belong to this graph. ");
		}
		if ((relation.getTarget().getId() == null) || (!containsNode(relation.getTarget().getId()))) {
			throw new SaltInsertionException(this, relation, "The target node of the passed relation does not belong to this graph. ");
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
		relations.add(relation);
		// add relation to indexes
		idx_relation_id.put(relation.getId(), relation);
		idx_out_relation_id.put(relation.getSource().getId(), relation);
		idx_in_relation_id.put(relation.getTarget().getId(), relation);
	}

	/** {@inheritDoc} **/
	@Override
	public void removeRelation(R rel) {
		if (rel != null) {
			if (rel instanceof NodeImpl) {
				((RelationImpl<N, N>) rel).basicSetGraph(null);
			}
			basicRemoveRelation(rel);
		}
	}

	/** {@inheritDoc} **/
	@Override
	public void removeRelations() {
		relations.clear();
		idx_relation_id.clear();
		idx_in_relation_id.clear();
		idx_out_relation_id.clear();
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
	protected void basicRemoveRelation(R rel) {
		// remove relation from internal index
		if (idx_relation_id.remove(rel.getId()) != null) {
			//if relation exists in graph remove it from other indexes
			idx_in_relation_id.get(rel.getTarget().getId()).remove(rel);
			idx_out_relation_id.get(rel.getSource().getId()).remove(rel);
		}
		// remove relation also from layers
		for (Layer<N, R> layer : layers) {
			layer.removeRelation(rel);
		}
		// remove relation from internal list
		relations.remove(rel);
	}

	/** {@inheritDoc Graph#containsRelation(String)} **/
	@Override
	public boolean containsRelation(String relationId) {
		return (idx_relation_id.containsKey(relationId));
	}

	// =========================================================== < Relations

	// =========================================================== > Layers
	private Set<Layer<N, R>> layers = null;

	@Override
	public Set<Layer<N, R>> getLayers() {
		return (Collections.unmodifiableSet(layers));
	}

	/** {@inheritDoc Graph#containsLayer(String)} **/
	@Override
	public boolean containsLayer(String layerId) {
		return (idx_relation_id.containsKey(layerId));
	}

	@Override
	public void addLayer(Layer<N, R> layer) {
		if (layer != null) {
			basicAddLayer(layer);
			if (layer instanceof LayerImpl) {
				((LayerImpl<N, R>) layer).basicSetGraph(this);
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
	protected void basicAddLayer(Layer<N, R> layer) {
		if (layer != null) {
			if (!layers.contains(layer)) {
				layers.add(layer);
			}
		}
	}

	@Override
	public void removeLayer(Layer<N, R> layer) {
		if (layer instanceof LayerImpl) {
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
	protected void basicRemoveLayer(Layer<N, R> layer) {
		if (layer != null) {
			if (layers.contains(layer)) {
				layers.remove(layer);
			}
		}
	}
	// =========================================================== < Layers
}
