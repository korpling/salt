package de.hu_berlin.u.saltnpepper.graph;

import de.hu_berlin.u.saltnpepper.graph.impl.GraphFactoryImpl;
import de.hu_berlin.u.saltnpepper.graph.impl.GraphImpl;
import de.hu_berlin.u.saltnpepper.graph.impl.IdentifierImpl;
import de.hu_berlin.u.saltnpepper.graph.impl.LabelImpl;
import de.hu_berlin.u.saltnpepper.graph.impl.NodeImpl;
import de.hu_berlin.u.saltnpepper.graph.impl.RelationImpl;

public class GraphFactory {
	/** Internal factory which is used to create objects. **/
	private static IGraphFactory factory = new GraphFactoryImpl();
	
	/**
	 * Creates a new {@link Graph} object of type {@link GraphImpl}.
	 * 
	 * @return new {@link Graph} object
	 */
	public static Graph<Node, Relation<Node, Node>> createGraph() {
		return(factory.createGraph());
	}

	/**
	 * Creates a new {@link Node} object of type {@link NodeImpl}.
	 * 
	 * @return new {@link Node} object
	 */
	public static Node createNode() {
		return(factory.createNode());
	}

	/**
	 * Creates a new {@link Relation} object of type {@link RelationImpl}.
	 * 
	 * @return new {@link Relation} object
	 */
	public static Relation<Node, Node> createRelation() {
		return(factory.createRelation());
	}

	/**
	 * Creates a new {@link Label} object of type {@link LabelImpl}. The value
	 * of this label is defined to be of type {@link String}. To use another
	 * value type, use one of the other create methods createLabelXXX() or the
	 * generic method {@link #createLabel(Class)}.
	 * 
	 * @return new {@link Label} object
	 */
	public static Label createLabel() {
		return(factory.createLabel());
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
		return (factory.createIdentifier(container, id));
	}

	/**
	 * Creates a new {@link Layer} object. A layer is a kind of a subgraph,
	 * which can contain nodes, relations and other layers.
	 * 
	 * @return new layer object
	 */
	public static Layer<Node, Relation<Node, Node>> createLayer() {
		return (factory.createLayer());
	}
}