package de.hu_berlin.u.saltnpepper.graph.impl.tests;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.graph.Edge;
import de.hu_berlin.u.saltnpepper.graph.Graph;
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
	 * <li>that when an id is already given to the node, it is changed, when
	 * the graph already contains such a node</li>
	 * </ul>
	 */
	@Test
	public void testAddNode_Id(){
		Node node= GraphFactory.createNode();
		getFixture().addNode(node);
		assertEquals(1, getFixture().getNodes().size());
		assertEquals(node, getFixture().getNodes().get(0));
		Set<String> ids= new HashSet<String>();
		for (int i= 0; i < 50; i++){
			node= GraphFactory.createNode();
			getFixture().addNode(node);
			assertNotNull(node.getId());
			if (ids.contains(node.getId())){
				fail("AN id was given twice");
			}
			ids.add(node.getId());
			assertTrue(getFixture().getNodes().contains(node));
		}
		node= GraphFactory.createNode();
		node.setId("hello");
		getFixture().addNode(node);
		node= GraphFactory.createNode();
		node.setId("hello");
		getFixture().addNode(node);
		assertNotEquals("hello", node.getId());
	}
	
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
	
	/**
	 * Checks that
	 * <ul>
	 * <li>each added node got an id</li>
	 * <li>that an id is not used twice</li>
	 * <li>that when an id is already given to the node, it is changed, when
	 * the graph already contains such a node</li>
	 * </ul>
	 */
	@Test
	public void testAddEdge_Id(){
		Node node= GraphFactory.createNode();
		Edge<Node, Node> edge= GraphFactory.createEdge();
		edge.setSource(node);
		edge.setTarget(node);
		
		assertEquals(0, getFixture().getEdges().size());
		getFixture().addEdge(edge);
		assertEquals(1, getFixture().getEdges().size());
		assertEquals(edge, getFixture().getEdges().get(0));
		
		Set<String> ids= new HashSet<String>();
		for (int i= 0; i < 50; i++){
			edge= GraphFactory.createEdge();
			edge.setSource(node);
			edge.setTarget(node);
			
			getFixture().addEdge(edge);
			assertNotNull(edge.getId());
			if (ids.contains(edge.getId())){
				fail("An id was given twice");
			}
			ids.add(edge.getId());
			assertTrue(getFixture().getEdges().contains(edge));
		}
		edge= GraphFactory.createEdge();
		edge.setId("hello");
		edge.setSource(node);
		edge.setTarget(node);
		getFixture().addEdge(edge);
		edge= GraphFactory.createEdge();
		edge.setId("hello");
		edge.setSource(node);
		edge.setTarget(node);
		getFixture().addEdge(edge);
		assertNotEquals("hello", edge.getId());
	}
}
