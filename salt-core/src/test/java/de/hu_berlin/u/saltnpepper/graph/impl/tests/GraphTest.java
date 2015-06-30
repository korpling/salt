package de.hu_berlin.u.saltnpepper.graph.impl.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.graph.Edge;
import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.graph.impl.EdgeImpl;
import de.hu_berlin.u.saltnpepper.graph.impl.GraphImpl;
import de.hu_berlin.u.saltnpepper.graph.impl.NodeImpl;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltInsertionException;

public class GraphTest {
	protected Graph<Node, Edge<Node, Node>> fixture = null;

	public Graph<Node, Edge<Node, Node>> getFixture() {
		return fixture;
	}

	public void setFixture(Graph<Node, Edge<Node, Node>> fixture) {
		this.fixture = fixture;
	}

	@Before
	public void setUp() throws Exception {
		setFixture(new GraphImpl<Node, Edge<Node, Node>>());
	}

	public void testGetId() {
		String id = "id1";
		this.getFixture().setId(id);
		assertEquals(id, this.getFixture().getId());
	}

	/**
	 * <ul>
	 * <li>checks that an edge with no source could not be inserted</li>
	 * <li>checks that an edge with no target could not be inserted</li>
	 * <li>checks that a correct edge is inserted correctly</li>
	 * </ul>
	 */
	@Test
	public void testAddEdge() {
		Edge<Node, Node> edge = new EdgeImpl<Node, Node>();
		Node source = null;
		Node target = null;
		try {
			getFixture().addEdge(edge);
			// no source node is set
			fail();
		} catch (SaltInsertionException e) {
		}
		source = new NodeImpl();
		edge.setSource(source);
		try {
			getFixture().addEdge(edge);
			// no target node is set
			fail();
		} catch (SaltInsertionException e) {
		}
		target = new NodeImpl();
		edge.setTarget(target);
		getFixture().addEdge(edge);
		assertTrue(getFixture().getEdges().contains(edge));
	}
}
