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

import de.hu_berlin.u.saltnpepper.graph.Relation;
import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.graph.Layer;
import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.graph.impl.RelationImpl;
import de.hu_berlin.u.saltnpepper.graph.impl.GraphFactory;
import de.hu_berlin.u.saltnpepper.graph.impl.GraphImpl;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltInsertionException;

public class GraphTest {
	protected Graph<Node, Relation<Node, Node>> fixture = null;

	public Graph<Node, Relation<Node, Node>> getFixture() {
		return fixture;
	}

	public void setFixture(Graph<Node, Relation<Node, Node>> fixture) {
		this.fixture = fixture;
	}

	@Before
	public void setUp() throws Exception {
		setFixture(new GraphImpl<Node, Relation<Node, Node>>());
	}

	/**
	 * Adds a set of nodes and relations to the graph and returns the lists of nodes and relations.
	 * r1: n1 --> n2
	 * r2: n2 --> n3 
	 * r3: n1 --> n4
	 * r4: n4 --> n5
	 * r5: n2 --> n6
	 * r6: n1 --> n7
	 */
	private Pair<List<Node>,List<Relation<Node, Node>>> createSampleGraph() {
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
		
		List<Relation<Node,Node>> relations = new ArrayList<>();
		Relation<Node, Node> relation1= GraphFactory.createRelation();
		relation1.setSource(node1);
		relation1.setTarget(node2);
		getFixture().addRelation(relation1);
		relations.add(relation1);
		
		Relation<Node, Node> relation2= GraphFactory.createRelation();
		relation2.setSource(node2);
		relation2.setTarget(node3);
		getFixture().addRelation(relation2);
		relations.add(relation2);
		
		Relation<Node, Node> relation3= GraphFactory.createRelation();
		relation3.setSource(node1);
		relation3.setTarget(node4);
		getFixture().addRelation(relation3);
		relations.add(relation3);
		
		Relation<Node, Node> relation4= GraphFactory.createRelation();
		relation4.setSource(node4);
		relation4.setTarget(node5);
		getFixture().addRelation(relation4);
		relations.add(relation4);
		
		Relation<Node, Node> relation5= GraphFactory.createRelation();
		relation5.setSource(node2);
		relation5.setTarget(node6);
		getFixture().addRelation(relation5);
		relations.add(relation5);
		
		Relation<Node, Node> relation6= GraphFactory.createRelation();
		relation6.setSource(node1);
		relation6.setTarget(node7);
		getFixture().addRelation(relation6);
		relations.add(relation6);
		
		return(new ImmutablePair<>(nodes, relations));
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
	 * Checks that no {@link Node}, {@link Relation} or {@link Layer} can be added
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

		// test adding of relation
		try {
			getFixture().getRelations().add(GraphFactory.createRelation());
			fail("An relation shall not be added by the list");
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
		Layer<Node, Relation<Node, Node>> layer = GraphFactory.createLayer();
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

	// ==========================================================> test relations
	/**
	 * <ul>
	 * <li>checks that an empty relation could not be inserted</li>
	 * <li>checks that an relation with no source could not be inserted</li>
	 * <li>checks that an relation with no target could not be inserted</li>
	 * <li>checks that a correct relation is inserted correctly</li>
	 * </ul>
	 */
	@Test
	public void testAddRelation() {
		try {
			getFixture().addRelation(null);
			fail("Null should not have been added as a node. ");
		} catch (SaltInsertionException e) {
		}

		Relation<Node, Node> relation = new RelationImpl<Node, Node>();
		Node source = null;
		Node target = null;
		try {
			getFixture().addRelation(relation);
			// no source node is set
			fail();
		} catch (SaltInsertionException e) {
		}
		source = GraphFactory.createNode();
		relation.setSource(source);
		try {
			getFixture().addRelation(relation);
			// no target node is set
			fail();
		} catch (SaltInsertionException e) {
		}
		target = GraphFactory.createNode();
		relation.setTarget(target);
		try {
			getFixture().addRelation(relation);
			// target and source does not belong to graph
			fail("Cannot add relation, whose source and target does not belong to graph");
		} catch (SaltInsertionException e) {
		}
		getFixture().addNode(source);
		getFixture().addNode(target);
		getFixture().addRelation(relation);
		assertTrue(getFixture().getRelations().contains(relation));
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
	public void testAddRelation_Id() {
		Node node = GraphFactory.createNode();
		getFixture().addNode(node);
		Relation<Node, Node> relation = GraphFactory.createRelation();
		relation.setSource(node);
		relation.setTarget(node);

		assertEquals(0, getFixture().getRelations().size());
		getFixture().addRelation(relation);
		assertEquals(1, getFixture().getRelations().size());
		assertEquals(relation, getFixture().getRelations().get(0));

		Set<String> ids = new HashSet<String>();
		for (int i = 0; i < 50; i++) {
			relation = GraphFactory.createRelation();
			relation.setSource(node);
			relation.setTarget(node);

			getFixture().addRelation(relation);
			assertNotNull(relation.getId());
			if (ids.contains(relation.getId())) {
				fail("An id was given twice");
			}
			ids.add(relation.getId());
			assertTrue(getFixture().getRelations().contains(relation));
		}
		relation = GraphFactory.createRelation();
		relation.setId("hello");
		relation.setSource(node);
		relation.setTarget(node);
		getFixture().addRelation(relation);
		relation = GraphFactory.createRelation();
		relation.setId("hello");
		relation.setSource(node);
		relation.setTarget(node);
		getFixture().addRelation(relation);
		assertNotEquals("hello", relation.getId());
	}

	/**
	 * Tests adding an relation to the graph and if it could be accessed by its id.
	 */
	@Test
	public void testGetRelation__String() {
		Node node1 = GraphFactory.createNode();
		node1.setId("node1");
		Node node2 = GraphFactory.createNode();
		node2.setId("node2");

		Relation<Node, Node> relation1 = GraphFactory.createRelation();
		relation1.setId("relation1");
		relation1.setSource(node1);
		relation1.setTarget(node2);

		assertNull(this.getFixture().getRelation(relation1.getId()));
		this.getFixture().addNode(node1);
		this.getFixture().addNode(node2);
		this.getFixture().addRelation(relation1);
		assertEquals(relation1, this.getFixture().getRelation(relation1.getId()));
	}

	/**
	 * Checks that all relations between two nodes are returned correctly.
	 */
	@Test
	public void testGetRelations__String_String() {
		Node node1 = GraphFactory.createNode();
		getFixture().addNode(node1);
		Node node2 = GraphFactory.createNode();
		getFixture().addNode(node2);
		Node node3 = GraphFactory.createNode();
		getFixture().addNode(node3);

		Relation<Node, Node> relation1 = GraphFactory.createRelation();
		relation1.setSource(node2);
		relation1.setTarget(node3);
		getFixture().addRelation(relation1);

		Relation<Node, Node> relation2 = GraphFactory.createRelation();
		relation2.setSource(node2);
		relation2.setTarget(node3);
		getFixture().addRelation(relation2);

		assertEquals(2, getFixture().getRelations(node2.getId(), node3.getId()).size());
		assertEquals(relation1, getFixture().getRelations(node2.getId(), node3.getId()).get(0));
		assertEquals(relation2, getFixture().getRelations(node2.getId(), node3.getId()).get(1));

		assertEquals(0, getFixture().getRelations(node1.getId(), node3.getId()).size());
	}
	
	/**
	 * Checks that all incoming relations are returned correctly.
	 */
	@Test
	public void testGetInRelations__String() {
		Pair<List<Node>, List<Relation<Node, Node>>> pair= createSampleGraph();
		for (Relation<Node, Node> relation : pair.getRight()) {
			assertTrue("this inserted relation '"+relation.getId()+"' should be in getInRelations: "+ this.getFixture().getInRelations(relation.getTarget().getId()), this.getFixture().getInRelations(relation.getTarget().getId()).contains(relation));
		}
	}

	/**
	 * Checks that all outgoing relations are returned correctly.
	 */
	@Test
	public void testGetOutRelations__String() {
		Pair<List<Node>, List<Relation<Node, Node>>> pair= createSampleGraph();
		for (Relation<Node, Node> relation : pair.getRight()) {
			assertTrue("this inserted relation '"+relation.getId()+"' should be in getOutRelations: "+this.getFixture().getOutRelations(relation.getSource().getId()), this.getFixture().getOutRelations(relation.getSource().getId()).contains(relation));
		}
	}
	// ==========================================================< test nodes
}
