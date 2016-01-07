package de.hu_berlin.u.saltnpepper.graph.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.graph.Layer;
import de.hu_berlin.u.saltnpepper.graph.Node;

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
		return ((Node) delegate);
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
		} else {
			if (graph != null) {
				graph.addNode(this);
			} else {
				getGraph().removeNode(this);
			}
			basicSetGraph(graph);
		}
	}

	/**
	 * This is an internally used method. To implement a double chaining of
	 * {@link Graph} and {@link Node} object when an node is inserted into this
	 * graph and to avoid an endless invocation the insertion of an node is
	 * splited into the two methods {@link #setGraph(Graph)} and
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
			((NodeImpl)getDelegate()).basicSetGraph(graph);
		} else {
			this.graph = graph;
		}
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

	/** {@inheritDoc} **/
	@Override
	public void addLayer(Layer layer) {
		if (getDelegate() != null) {
			getDelegate().addLayer(layer);
		} else {
			if (layer != null) {
				layer.addNode(this);
			}
		}
	}

	/** {@inheritDoc} **/
	@Override
	public void removeLayer(Layer layer) {
		if (getDelegate() != null) {
			getDelegate().removeLayer(layer);
		} else {
			if (layer != null) {
				layer.removeNode(this);
			}
		}
	}
}
