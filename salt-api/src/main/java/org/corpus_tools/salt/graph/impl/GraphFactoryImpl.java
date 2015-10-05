package org.corpus_tools.salt.graph.impl;

import org.corpus_tools.salt.graph.Graph;
import org.corpus_tools.salt.graph.IGraphFactory;
import org.corpus_tools.salt.graph.IdentifiableElement;
import org.corpus_tools.salt.graph.Identifier;
import org.corpus_tools.salt.graph.Label;
import org.corpus_tools.salt.graph.Layer;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.graph.Relation;

public class GraphFactoryImpl implements IGraphFactory {

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hu_berlin.u.saltnpepper.graph.impl.IGraphFactory#createGraph()
	 */
	@Override
	public Graph<Node, Relation<Node, Node>, Layer<Node, Relation<Node, Node>>> createGraph() {
		return (new GraphImpl<Node, Relation<Node, Node>, Layer<Node, Relation<Node, Node>>>());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hu_berlin.u.saltnpepper.graph.impl.IGraphFactory#createNode()
	 */
	@Override
	public Node createNode() {
		return (new NodeImpl());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hu_berlin.u.saltnpepper.graph.impl.IGraphFactory#createRelation()
	 */
	@Override
	public Relation<Node, Node> createRelation() {
		return (new RelationImpl<Node, Node>());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hu_berlin.u.saltnpepper.graph.impl.IGraphFactory#createLabel()
	 */
	@Override
	public Label createLabel() {
		return (new LabelImpl());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hu_berlin.u.saltnpepper.graph.impl.IGraphFactory#createIdentifier(
	 * de.hu_berlin.u.saltnpepper.graph.IdentifiableElement, java.lang.String)
	 */
	@Override
	public Identifier createIdentifier(IdentifiableElement container, String id) {
		return (new IdentifierImpl(container, id));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hu_berlin.u.saltnpepper.graph.impl.IGraphFactory#createLayer()
	 */
	@Override
	public Layer<Node, Relation<Node, Node>> createLayer() {
		return (new LayerImpl<Node, Relation<Node, Node>>());
	}
}