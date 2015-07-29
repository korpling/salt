package de.hu_berlin.u.saltnpepper.graph.impl.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.graph.Relation;
import de.hu_berlin.u.saltnpepper.graph.impl.GraphFactory;

public class NodeTest {
	protected Node fixture = null;

	public Node getFixture() {
		return fixture;
	}

	public void setFixture(Node fixture) {
		this.fixture = fixture;
	}

	@Before
	public void setUp() throws Exception {
		setFixture(GraphFactory.createNode());
	}

	/**
	 * Tests the double chaining with Graph.
	 */
	@Test
	public void testDoubleChaining() {
		Graph<Node, Relation<Node, Node>> graph = GraphFactory.createGraph();
		getFixture().setGraph(graph);
		assertTrue("only contains " + graph.getNodes(), graph.getNodes().contains(getFixture()));
	}
}
