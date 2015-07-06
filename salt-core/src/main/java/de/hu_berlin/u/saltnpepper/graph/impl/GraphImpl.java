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
import de.hu_berlin.u.saltnpepper.graph.Layer;
import de.hu_berlin.u.saltnpepper.graph.NamedElement;
import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltInsertionException;

@SuppressWarnings("serial")
public class GraphImpl<N extends Node, E extends Edge<N, N>> extends IdentifiableElementImpl implements Graph<N, E>, NamedElement {
	public GraphImpl() {
		init();
	}

	/**
	 * Initializes an object of type {@link GraphImpl}.
	 * <ul>
	 * <li>Initializes index {@link #idx_node_id}</li>
	 * <li>Initializes index {@link #idx_edge_id}</li>
	 * <li>Initializes index {@link #idx_layer_id}</li>
	 * <li>Initializes index {@link #idx_out_edge_id}</li>
	 * <li>Initializes index {@link #idx_in_edge_id}</li>
	 * </ul>
	 */
	private void init() {
		idx_node_id = new ConcurrentHashMap<>();
		idx_edge_id = new ConcurrentHashMap<>();
		idx_layer_id = new ConcurrentHashMap<>();
		idx_out_edge_id = HashMultimap.create();
		idx_in_edge_id = HashMultimap.create();
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
	 * An index storing all edges and their corresponding ids (key: id; value:
	 * edge)
	 **/
	private Map<String, E> idx_edge_id = null;
	/**
	 * An index storing all layers and their corresponding ids (key: id; value:
	 * layer)
	 **/
	private Map<String, Layer> idx_layer_id = null;
	/**
	 * An index storing all node ids and the corresponding outgoing edges (key:
	 * node id; value: edge)
	 **/
	private Multimap<String, E> idx_out_edge_id = null;
	/**
	 * An index storing all node ids and the corresponding incomming edges (key:
	 * node id; value: edge)
	 **/
	private Multimap<String, E> idx_in_edge_id = null;
	// =========================================================== < Indexes

	// =========================================================== > Nodes
	/** internal list of all contained nodes **/
	private List<N> nodes = null;

	/** {@inheritDoc Graph#getNodes()} **/
	@Override
	public List<N> getNodes() {
		if (nodes == null) {
			nodes = Collections.synchronizedList(new ArrayList<N>());
		}
		return (nodes);
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
			node.basicSetGraph(this);
		}
	}

	/** {@inheritDoc Graph#basicAddNode(Node)} **/
	@Override
	public void basicAddNode(N node) {
		if (node == null) {
			throw new SaltInsertionException(this, node, "A null value is not allowed. ");
		}
		// if node has no id a new id will be given to node
		if (node.getId() == null) {
			node.setId("node" + getNodes().size());
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
		getNodes().add(node);
		// add node to id index
		idx_node_id.put(node.getId(), node);
	}

	/** {@inheritDoc Graph#removeNode(Node)} **/
	@Override
	public void removeNode(N node) {
		if (node != null) {
			node.basicSetGraph(null);
			basicRemoveNode(node);
		}
	}

	/** {@inheritDoc Graph#basicRemoveNode(Node)} **/
	@Override
	public void basicRemoveNode(N node) {
		getNodes().remove(node);
	}

	/** {@inheritDoc Graph#containsNode(String)} **/
	@Override
	public boolean containsNode(String nodeId) {
		return (idx_node_id.containsKey(nodeId));
	}

	// =========================================================== < Nodes

	// =========================================================== > Edges

	/** internal list of all contained edges **/
	private List<E> edges = null;

	/** {@inheritDoc Graph#getEdges()} **/
	@Override
	public List<E> getEdges() {
		if (edges == null) {
			edges = Collections.synchronizedList(new ArrayList<E>());
		}
		return (edges);
	}
	/** {@inheritDoc Graph#getedge(String)} **/
	@Override
	public E getEdge(String edgeId) {
		return (idx_edge_id.get(edgeId));
	}

	/** {@inheritDoc Graph#addEdge(Edge)} **/
	@Override
	public void addEdge(E edge) {
		basicAddEdge(edge);
		if (edge != null) {
			edge.basicSetGraph(this);
		}
	}

	/** {@inheritDoc Graph#basicAddEdge(Edge)} **/
	@Override
	public void basicAddEdge(E edge) {
		if (edge == null) {
			throw new SaltInsertionException(this, edge, "A null value is not allowed. ");
		}
		if (edge.getSource() == null) {
			throw new SaltInsertionException(this, edge, "The source node is empty. ");
		}
		if (edge.getTarget() == null) {
			throw new SaltInsertionException(this, edge, "The target node is empty. ");
		}
		// if node has no id a new id will be given to node
		if (edge.getId() == null) {
			edge.setId("node" + getNodes().size());
		}
		int i = 0;
		// the given id, which eventually has to be extended for artificial
		// counter
		String idBase = edge.getId();
		while (getEdge(edge.getId()) != null) {
		// if node already exists, create new Id
			edge.setId(idBase + "_" + (getNodes().size() + i));
			i++;
		}
			// add node to internal list
		getEdges().add(edge);
		// add node to id index
		idx_edge_id.put(edge.getId(), edge);
	}

	/** {@inheritDoc Graph#containsEdge(String)} **/
	@Override
	public boolean containsEdge(String edgeId) {
		return (idx_edge_id.containsKey(edgeId));
	}

	// =========================================================== < Edges

	// =========================================================== > Layers
	private List<LayerImpl> layers = null;

	public List<LayerImpl> getLayers() {
		if (layers == null) {
			layers = Collections.synchronizedList(new ArrayList<LayerImpl>());
		}
		return (Collections.unmodifiableList(layers));
	}

	/** {@inheritDoc Graph#containsLayer(String)} **/
	@Override
	public boolean containsLayer(String layerId) {
		return (idx_edge_id.containsKey(layerId));
	}
	// =========================================================== < Layers
}
