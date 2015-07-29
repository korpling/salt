package de.hu_berlin.u.saltnpepper.graph.impl.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.graph.Relation;
import de.hu_berlin.u.saltnpepper.graph.impl.GraphFactory;

public class RelationTest {

	protected Relation<Node, Node> fixture = null;

	public Relation<Node, Node> getFixture() {
		return fixture;
	}

	public void setFixture(Relation<Node, Node> fixture) {
		this.fixture = fixture;
	}

	@Before
	public void setUp() throws Exception {
		setFixture(GraphFactory.createRelation());
	}

	/**
	 * Tests the double chaining with Graph.
	 */
	@Test
	public void testDoubleChaining() {
		Graph<Node, Relation<Node, Node>> graph = GraphFactory.createGraph();
		Node source = GraphFactory.createNode();
		Node target = GraphFactory.createNode();
		graph.addNode(source);
		graph.addNode(target);
		getFixture().setSource(source);
		getFixture().setTarget(target);

		getFixture().setGraph(graph);
		assertTrue("only contains " + graph.getRelations(), graph.getRelations().contains(getFixture()));
	}
}
