package de.hu_berlin.u.saltnpepper.graph.impl;

import de.hu_berlin.u.saltnpepper.graph.Edge;
import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.graph.IdentifiableElement;
import de.hu_berlin.u.saltnpepper.graph.Identifier;
import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.graph.Layer;
import de.hu_berlin.u.saltnpepper.graph.Node;

public class GraphFactory {

	/**
	 * Creates a new {@link Graph} object of type {@link GraphImpl}.
	 * 
	 * @return new {@link Graph} object
	 */
	public static Graph<Node, Edge<Node, Node>> createGraph() {
		return (new GraphImpl<Node, Edge<Node, Node>>());
	}

	/**
	 * Creates a new {@link Node} object of type {@link NodeImpl}.
	 * 
	 * @return new {@link Node} object
	 */
	public static Node createNode() {
		return (new NodeImpl());
	}

	/**
	 * Creates a new {@link Edge} object of type {@link EdgeImpl}.
	 * 
	 * @return new {@link Edge} object
	 */
	public static Edge<Node, Node> createEdge() {
		return (new EdgeImpl<Node, Node>());
	}

	/**
	 * Creates a new {@link Label} object of type {@link LabelImpl}. The value
	 * of this label is defined to be of type {@link String}. To use another
	 * value type, use one of the other create methods createLabelXXX() or the
	 * generic method {@link #createLabel(Class)}.
	 * 
	 * @return new {@link Label} object
	 */
	public static Label<String> createLabel() {
		return (createLabel_String());
	}

	/**
	 * Creates a new {@link Label} object of type {@link LabelImpl}. The value
	 * of this label is defined to be of type {@link String}. To use another
	 * value type, use one of the other create methods createLabelXXX() or the
	 * generic method {@link #createLabel(Class)}.
	 * 
	 * @return new {@link Label} object
	 */
	public static Label<String> createLabel_String() {
		return (new LabelImpl<String>());
	}

	/**
	 * Creates a new {@link Label} object of type {@link LabelImpl}. The type of
	 * the value of this label can freely be defined.
	 * 
	 * @return new {@link Label} object
	 */
	public static <V extends Object> Label<V> createLabel(Class<V> clazz) {
		return (new LabelImpl<V>());
	}

	/**
	 * Creates a new {@link Identifier} object of type {@link IdentifierImpl}.
	 * Its {@link IdentifiableElement} is set to the passed container and its id
	 * value is set to passed id.
	 * 
	 * @param container
	 *            {@link IdentifiableElement} which contains this
	 *            {@link Identifier}
	 * @param id
	 *            the id value of the {@link Identifier}
	 * @return new {@link Identifier} object
	 */
	public static Identifier createIdentifier(IdentifiableElement container, String id) {
		return (new IdentifierImpl(container, id));
	}

	/**
	 * Creates a new {@link Layer} object. A layer is a kind of a subgraph,
	 * which can contain nodes, edges and other layers.
	 * 
	 * @return new layer object
	 */
	public static Layer<Node, Edge<Node, Node>> createLayer() {
		return (new LayerImpl<Node, Edge<Node, Node>>());
	}
}