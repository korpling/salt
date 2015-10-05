package org.corpus_tools.salt.graph;

import org.corpus_tools.salt.graph.impl.GraphImpl;
import org.corpus_tools.salt.graph.impl.IdentifierImpl;
import org.corpus_tools.salt.graph.impl.LabelImpl;
import org.corpus_tools.salt.graph.impl.NodeImpl;
import org.corpus_tools.salt.graph.impl.RelationImpl;

public interface IGraphFactory {

	/**
	 * Creates a new {@link Graph} object of type {@link GraphImpl}.
	 * 
	 * @return new {@link Graph} object
	 */
	public abstract Graph<Node, Relation<Node, Node>, Layer<Node, Relation<Node, Node>>> createGraph();

	/**
	 * Creates a new {@link Node} object of type {@link NodeImpl}.
	 * 
	 * @return new {@link Node} object
	 */
	public abstract Node createNode();

	/**
	 * Creates a new {@link Relation} object of type {@link RelationImpl}.
	 * 
	 * @return new {@link Relation} object
	 */
	public abstract Relation<Node, Node> createRelation();

	/**
	 * Creates a new {@link Label} object of type {@link LabelImpl}. The value
	 * of this label is defined to be of type {@link String}. To use another
	 * value type, use one of the other create methods createLabelXXX() or the
	 * generic method {@link #createLabel(Class)}.
	 * 
	 * @return new {@link Label} object
	 */
	public abstract Label createLabel();

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
	public abstract Identifier createIdentifier(IdentifiableElement container, String id);

	/**
	 * Creates a new {@link Layer} object. A layer is a kind of a subgraph,
	 * which can contain nodes, relations and other layers.
	 * 
	 * @return new layer object
	 */
	public abstract Layer<Node, Relation<Node, Node>> createLayer();

}