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

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.graph.Edge;
import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.graph.Layer;
import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.graph.impl.EdgeImpl;
import de.hu_berlin.u.saltnpepper.graph.impl.GraphFactory;
import de.hu_berlin.u.saltnpepper.graph.impl.GraphImpl;
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

	/**
	 * Adds a set of nodes and edges to the graph and returns the lists of nodes and edges.
	 * r1: n1 --> n2
	 * r2: n2 --> n3 
	 * r3: n1 --> n4
	 * r4: n4 --> n5
	 * r5: n2 --> n6
	 * r6: n1 --> n7
	 */
	private Pair<List<Node>,List<Edge<Node, Node>>> createSampleGraph() {
		List<Node> nodes = new ArrayList<Node>();
		
		Node node1 = GraphFactory.createNode();
		getFixture().addNode(node1);
		nodes.add(node1);
		
		Node node2 = GraphFactory.createNode();
		getFixture().addNode(node2);
		nodes.add(node2);
		
		Node node3 = GraphFactory.createNode();
		getFixture().addNode(node3);
		nodes.add(node3);
		
		Node node4 = GraphFactory.createNode();
		getFixture().addNode(node4);
		nodes.add(node4);
		
		Node node5 = GraphFactory.createNode();
		getFixture().addNode(node5);
		nodes.add(node5);
		
		Node node6 = GraphFactory.createNode();
		getFixture().addNode(node6);
		nodes.add(node6);
		
		Node node7 = GraphFactory.createNode();
		getFixture().addNode(node7);
		nodes.add(node7);
		
		List<Edge<Node,Node>> edges = new ArrayList<>();
		Edge<Node, Node> edge1= GraphFactory.createEdge();
		edge1.setSource(node1);
		edge1.setTarget(node2);
		getFixture().addEdge(edge1);
		edges.add(edge1);
		
		Edge<Node, Node> edge2= GraphFactory.createEdge();
		edge2.setSource(node2);
		edge2.setTarget(node3);
		getFixture().addEdge(edge2);
		edges.add(edge2);
		
		Edge<Node, Node> edge3= GraphFactory.createEdge();
		edge3.setSource(node1);
		edge3.setTarget(node4);
		getFixture().addEdge(edge3);
		edges.add(edge3);
		
		Edge<Node, Node> edge4= GraphFactory.createEdge();
		edge4.setSource(node4);
		edge4.setTarget(node5);
		getFixture().addEdge(edge4);
		edges.add(edge4);
		
		Edge<Node, Node> edge5= GraphFactory.createEdge();
		edge5.setSource(node2);
		edge5.setTarget(node6);
		getFixture().addEdge(edge5);
		edges.add(edge5);
		
		Edge<Node, Node> edge6= GraphFactory.createEdge();
		edge6.setSource(node1);
		edge6.setTarget(node7);
		getFixture().addEdge(edge6);
		edges.add(edge6);
		
		return(new ImmutablePair<>(nodes, edges));
	}
	
	@Test
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

		// test adding of node
		try {
			getFixture().getNodes().add(GraphFactory.createNode());
			fail("A node shall not be added by the list");
		} catch (UnsupportedOperationException e) {
		}

		// test adding of edge
		try {
			getFixture().getEdges().add(GraphFactory.createEdge());
			fail("An edge shall not be added by the list");
		} catch (UnsupportedOperationException e) {
		}

		// test adding of layer
		try {
			getFixture().getLayers().add(GraphFactory.createLayer());
			fail("A layer shall not be added by the list");
		} catch (UnsupportedOperationException e) {
		}
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

	/**
	 * Tests adding an edge to the graph and if it could be accessed by its id.
	 */
	@Test
	public void testGetEdge__String() {
		Node node1 = GraphFactory.createNode();
		node1.setId("node1");
		Node node2 = GraphFactory.createNode();
		node2.setId("node2");

		Edge<Node, Node> edge1 = GraphFactory.createEdge();
		edge1.setId("edge1");
		edge1.setSource(node1);
		edge1.setTarget(node2);

		assertNull(this.getFixture().getEdge(edge1.getId()));
		this.getFixture().addNode(node1);
		this.getFixture().addNode(node2);
		this.getFixture().addEdge(edge1);
		assertEquals(edge1, this.getFixture().getEdge(edge1.getId()));
	}

	/**
	 * Checks that all edges between two nodes are returned correctly.
	 */
	@Test
	public void testGetEdges__String_String() {
		Node node1 = GraphFactory.createNode();
		getFixture().addNode(node1);
		Node node2 = GraphFactory.createNode();
		getFixture().addNode(node2);
		Node node3 = GraphFactory.createNode();
		getFixture().addNode(node3);

		Edge<Node, Node> edge1 = GraphFactory.createEdge();
		edge1.setSource(node2);
		edge1.setTarget(node3);
		getFixture().addEdge(edge1);

		Edge<Node, Node> edge2 = GraphFactory.createEdge();
		edge2.setSource(node2);
		edge2.setTarget(node3);
		getFixture().addEdge(edge2);

		assertEquals(2, getFixture().getEdges(node2.getId(), node3.getId()).size());
		assertEquals(edge1, getFixture().getEdges(node2.getId(), node3.getId()).get(0));
		assertEquals(edge2, getFixture().getEdges(node2.getId(), node3.getId()).get(1));

		assertEquals(0, getFixture().getEdges(node1.getId(), node3.getId()).size());
	}
	
	/**
	 * Checks that all incoming edges are returned correctly.
	 */
	@Test
	public void testGetInEdges__String() {
		Pair<List<Node>, List<Edge<Node, Node>>> pair= createSampleGraph();
		System.out.println(getFixture().getEdges());
		for (Edge<Node, Node> edge : pair.getRight()) {
			assertTrue("this inserted edge '"+edge.getId()+"' should be in getInEdges: "+ this.getFixture().getInEdges(edge.getTarget().getId()), this.getFixture().getInEdges(edge.getTarget().getId()).contains(edge));
		}
	}

	/**
	 * Checks that all outgoing edges are returned correctly.
	 */
	@Test
	public void testGetOutEdges__String() {
		Pair<List<Node>, List<Edge<Node, Node>>> pair= createSampleGraph();
		for (Edge<Node, Node> edge : pair.getRight()) {
			assertTrue("this inserted edge '"+edge.getId()+"' should be in getOutEdges: "+this.getFixture().getOutEdges(edge.getSource().getId()), this.getFixture().getOutEdges(edge.getSource().getId()).contains(edge));
		}
	}
	// ==========================================================< test nodes
}
