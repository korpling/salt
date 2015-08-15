package de.hu_berlin.u.saltnpepper.graph.impl;

import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.graph.IGraphFactory;
import de.hu_berlin.u.saltnpepper.graph.IdentifiableElement;
import de.hu_berlin.u.saltnpepper.graph.Identifier;
import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.graph.Layer;
import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.graph.Relation;

public class GraphFactoryImpl implements IGraphFactory{

	/* (non-Javadoc)
	 * @see de.hu_berlin.u.saltnpepper.graph.impl.IGraphFactory#createGraph()
	 */
	@Override
	public Graph<Node, Relation<Node, Node>> createGraph() {
		return (new GraphImpl<Node, Relation<Node, Node>>());
	}

	/* (non-Javadoc)
	 * @see de.hu_berlin.u.saltnpepper.graph.impl.IGraphFactory#createNode()
	 */
	@Override
	public Node createNode() {
		return (new NodeImpl());
	}

	/* (non-Javadoc)
	 * @see de.hu_berlin.u.saltnpepper.graph.impl.IGraphFactory#createRelation()
	 */
	@Override
	public Relation<Node, Node> createRelation() {
		return (new RelationImpl<Node, Node>());
	}

	/* (non-Javadoc)
	 * @see de.hu_berlin.u.saltnpepper.graph.impl.IGraphFactory#createLabel()
	 */
	@Override
	public Label createLabel() {
		return (new LabelImpl());
	}

	/* (non-Javadoc)
	 * @see de.hu_berlin.u.saltnpepper.graph.impl.IGraphFactory#createIdentifier(de.hu_berlin.u.saltnpepper.graph.IdentifiableElement, java.lang.String)
	 */
	@Override
	public Identifier createIdentifier(IdentifiableElement container, String id) {
		return (new IdentifierImpl(container, id));
	}

	/* (non-Javadoc)
	 * @see de.hu_berlin.u.saltnpepper.graph.impl.IGraphFactory#createLayer()
	 */
	@Override
	public Layer<Node, Relation<Node, Node>> createLayer() {
		return (new LayerImpl<Node, Relation<Node, Node>>());
	}
}