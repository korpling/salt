package de.hu_berlin.u.saltnpepper.graph.impl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.graph.Edge;
import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.graph.Layer;
import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.graph.impl.EdgeImpl;
import de.hu_berlin.u.saltnpepper.graph.impl.GraphFactory;
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

	// ==========================================================> test nodes
	/**
	 * Checks that nodes are added correctly and null is not a valid node.
	 */
	@Test
	public void testAddNode() {
		assertEquals(0, getFixture().getNodes().size());
		try {
			getFixture().addNode(null);
			fail("Null should not have been added as a node. ");
		} catch (SaltInsertionException e) {
		}

		Node node = GraphFactory.createNode();
		getFixture().addNode(node);
		assertEquals(1, getFixture().getNodes().size());
		assertEquals(node, getFixture().getNodes().get(0));
		for (int i = 0; i < 50; i++) {
			node = GraphFactory.createNode();
			getFixture().addNode(node);
			assertTrue(getFixture().getNodes().contains(node));
		}
	}

	/**
	 * Checks that
	 * <ul>
	 * <li>each added node got an id</li>
	 * <li>that an id is not used twice</li>
	 * <li>that when an id is already given to the node, it is changed, when the
	 * graph already contains such a node</li>
	 * </ul>
	 */
	@Test
	public void testAddNode_Id() {
		Node node = GraphFactory.createNode();
		getFixture().addNode(node);
		assertEquals(1, getFixture().getNodes().size());
		assertEquals(node, getFixture().getNodes().get(0));
		Set<String> ids = new HashSet<String>();
		for (int i = 0; i < 50; i++) {
			node = GraphFactory.createNode();
			getFixture().addNode(node);
			assertNotNull(node.getId());
			if (ids.contains(node.getId())) {
				fail("AN id was given twice");
			}
			ids.add(node.getId());
			assertTrue(getFixture().getNodes().contains(node));
		}
		node = GraphFactory.createNode();
		node.setId("hello");
		getFixture().addNode(node);
		node = GraphFactory.createNode();
		node.setId("hello");
		getFixture().addNode(node);
		assertNotEquals("hello", node.getId());
	}
	
	/**
	 * Checks that no {@link Node}, {@link Edge} or {@link Layer} can be added
	 * by adding them into the list returned by the graph
	 */
	@Test
	public void testAddXInList() {
		
		//test adding of node
		try{
			getFixture().getNodes().add(GraphFactory.createNode());
			fail("A node shall not be added by the list");
		}catch (UnsupportedOperationException e){}
		
		//test adding of edge
		try{
			getFixture().getEdges().add(GraphFactory.createEdge());
			fail("An edge shall not be added by the list");
		}catch (UnsupportedOperationException e){}
		
		//test adding of layer
		try{
			getFixture().getLayers().add(GraphFactory.createLayer());
			fail("A layer shall not be added by the list");
		}catch (UnsupportedOperationException e){}
	}

	/**
	 * Checks that method {@link Graph#getNodes()} returns a list containing all
	 * nodes.
	 */
	@Test
	public void testGetNodes() throws Exception {
		List<Node> nodes = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			Node node = GraphFactory.createNode();
			nodes.add(node);
			getFixture().addNode(node);
		}
		assertEquals(nodes.size(), getFixture().getNodes().size());
		for (Node node : nodes) {
			getFixture().getNodes().contains(node);
		}
	}

	/**
	 * Checks that nodes are added correctly and null is not a valid node.
	 */
	@Test
	public void testGetNode() {
		List<Node> nodes = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			Node node = GraphFactory.createNode();
			nodes.add(node);
			getFixture().addNode(node);
		}

		for (Node node : nodes) {
			assertEquals(node, this.getFixture().getNode(node.getId()));
		}
	}

	/**
	 * Checks that a node is removed correctly.
	 */
	@Test
	public void testRemoveNode() {
		List<Node> nodes = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			Node node = GraphFactory.createNode();
			nodes.add(node);
			getFixture().addNode(node);
			assertEquals(node, getFixture().getNode(node.getId()));
		}
		for (Node node : nodes) {
			assertNotNull(this.getFixture().getNode(node.getId()));
			getFixture().removeNode(node);
			assertNull("node '" + node + "' should be removed", getFixture().getNode(node.getId()));
		}
		assertEquals(0, getFixture().getNodes().size());
	}

	/**
	 * Tests if nodes are also removed from layers, when they are removed from
	 * graph.
	 */
	@Test
	public void testRemoveNodeAlsoFromLayer() {
		Layer<Node, Edge<Node, Node>> layer = GraphFactory.createLayer();
		getFixture().addLayer(layer);

		List<Node> nodes = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			Node node = GraphFactory.createNode();
			nodes.add(node);
			getFixture().addNode(node);
			layer.addNode(node);
		}
		assertEquals(nodes.size(), layer.getNodes().size());
		for (Node node : nodes) {
			getFixture().removeNode(node);
		}
		assertEquals(0, layer.getNodes().size());

	}

	// ==========================================================< test nodes

	// ==========================================================> test edges
	/**
	 * <ul>
	 * <li>checks that an empty edge could not be inserted</li>
	 * <li>checks that an edge with no source could not be inserted</li>
	 * <li>checks that an edge with no target could not be inserted</li>
	 * <li>checks that a correct edge is inserted correctly</li>
	 * </ul>
	 */
	@Test
	public void testAddEdge() {
		try {
			getFixture().addEdge(null);
			fail("Null should not have been added as a node. ");
		} catch (SaltInsertionException e) {
		}

		Edge<Node, Node> edge = new EdgeImpl<Node, Node>();
		Node source = null;
		Node target = null;
		try {
			getFixture().addEdge(edge);
			// no source node is set
			fail();
		} catch (SaltInsertionException e) {
		}
		source = GraphFactory.createNode();
		edge.setSource(source);
		try {
			getFixture().addEdge(edge);
			// no target node is set
			fail();
		} catch (SaltInsertionException e) {
		}
		target = GraphFactory.createNode();
		edge.setTarget(target);
		try {
			getFixture().addEdge(edge);
			// target and source does not belong to graph
			fail("Cannot add edge, whose source and target does not belong to graph");
		} catch (SaltInsertionException e) {
		}
		getFixture().addNode(source);
		getFixture().addNode(target);
		getFixture().addEdge(edge);
		assertTrue(getFixture().getEdges().contains(edge));
	}

	/**
	 * Checks that
	 * <ul>
	 * <li>each added node got an id</li>
	 * <li>that an id is not used twice</li>
	 * <li>that when an id is already given to the node, it is changed, when the
	 * graph already contains such a node</li>
	 * </ul>
	 */
	@Test
	public void testAddEdge_Id() {
		Node node = GraphFactory.createNode();
		getFixture().addNode(node);
		Edge<Node, Node> edge = GraphFactory.createEdge();
		edge.setSource(node);
		edge.setTarget(node);

		assertEquals(0, getFixture().getEdges().size());
		getFixture().addEdge(edge);
		assertEquals(1, getFixture().getEdges().size());
		assertEquals(edge, getFixture().getEdges().get(0));

		Set<String> ids = new HashSet<String>();
		for (int i = 0; i < 50; i++) {
			edge = GraphFactory.createEdge();
			edge.setSource(node);
			edge.setTarget(node);

			getFixture().addEdge(edge);
			assertNotNull(edge.getId());
			if (ids.contains(edge.getId())) {
				fail("An id was given twice");
			}
			ids.add(edge.getId());
			assertTrue(getFixture().getEdges().contains(edge));
		}
		edge = GraphFactory.createEdge();
		edge.setId("hello");
		edge.setSource(node);
		edge.setTarget(node);
		getFixture().addEdge(edge);
		edge = GraphFactory.createEdge();
		edge.setId("hello");
		edge.setSource(node);
		edge.setTarget(node);
		getFixture().addEdge(edge);
		assertNotEquals("hello", edge.getId());
	}
	// ==========================================================< test nodes
}
