package de.hu_berlin.u.saltnpepper.graph.impl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.graph.GraphFactory;
import de.hu_berlin.u.saltnpepper.graph.Layer;
import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.graph.Relation;
import de.hu_berlin.u.saltnpepper.graph.impl.GraphImpl;
import de.hu_berlin.u.saltnpepper.graph.impl.RelationImpl;
import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltInsertionException;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltParameterException;

public class GraphTest {
	protected Graph<Node, Relation<Node, Node>, Layer<Node, Relation<Node, Node>>> fixture = null;

	public Graph<Node, Relation<Node, Node>, Layer<Node, Relation<Node, Node>>> getFixture() {
		return fixture;
	}

	public void setFixture(Graph<Node, Relation<Node, Node>, Layer<Node, Relation<Node, Node>>> fixture) {
		this.fixture = fixture;
	}

	@Before
	public void setUp() throws Exception {
		setFixture(new GraphImpl<Node, Relation<Node, Node>, Layer<Node, Relation<Node, Node>>>());
	}

	/**
	 * Adds a set of nodes and relations to the graph and returns the lists of
	 * nodes and relations. r1: n1 --> n2 r2: n2 --> n3 r3: n1 --> n4 r4: n4 -->
	 * n5 r5: n2 --> n6 r6: n1 --> n7
	 */
	private Pair<List<Node>, List<Relation<Node, Node>>> createSampleGraph() {
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

		List<Relation<Node, Node>> relations = new ArrayList<>();
		Relation<Node, Node> relation1 = GraphFactory.createRelation();
		relation1.setSource(node1);
		relation1.setTarget(node2);
		getFixture().addRelation(relation1);
		relations.add(relation1);

		Relation<Node, Node> relation2 = GraphFactory.createRelation();
		relation2.setSource(node2);
		relation2.setTarget(node3);
		getFixture().addRelation(relation2);
		relations.add(relation2);

		Relation<Node, Node> relation3 = GraphFactory.createRelation();
		relation3.setSource(node1);
		relation3.setTarget(node4);
		getFixture().addRelation(relation3);
		relations.add(relation3);

		Relation<Node, Node> relation4 = GraphFactory.createRelation();
		relation4.setSource(node4);
		relation4.setTarget(node5);
		getFixture().addRelation(relation4);
		relations.add(relation4);

		Relation<Node, Node> relation5 = GraphFactory.createRelation();
		relation5.setSource(node2);
		relation5.setTarget(node6);
		getFixture().addRelation(relation5);
		relations.add(relation5);

		Relation<Node, Node> relation6 = GraphFactory.createRelation();
		relation6.setSource(node1);
		relation6.setTarget(node7);
		getFixture().addRelation(relation6);
		relations.add(relation6);

		return (new ImmutablePair<>(nodes, relations));
	}

	@Test
	public void testGetId() {
		String id = "id1";
		getFixture().setId(id);
		assertEquals(id, getFixture().getId());
	}

	// ================================================> test doubleChaining
	/**
	 * Tests the double chaining with {@link Node}.
	 */
	@Test
	public void testDoubleChainingNode() {
		Node node = GraphFactory.createNode();
		getFixture().addNode(node);
		assertEquals(getFixture(), node.getGraph());
	}

	/**
	 * Tests the double chaining with {@link Relation}.
	 */
	@Test
	public void testDoubleChainingRelation() {
		Relation<Node, Node> rel = GraphFactory.createRelation();
		Node source = GraphFactory.createNode();
		Node target = GraphFactory.createNode();
		getFixture().addNode(source);
		getFixture().addNode(target);
		rel.setSource(source);
		rel.setTarget(target);
		getFixture().addRelation(rel);
		assertEquals(getFixture(), rel.getGraph());
	}

	/**
	 * Tests the double chaining with {@link Layer}.
	 */
	@Test
	public void testDoubleChainingLayer() {
		Layer<Node, Relation<Node, Node>> layer = GraphFactory.createLayer();
		getFixture().addLayer(layer);
		assertEquals(getFixture(), layer.getGraph());
	}

	// ================================================< test doubleChaining

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
		} catch (SaltParameterException e) {
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
				fail("An id was given twice");
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
	 * Checks that no {@link Node}, {@link Relation} or {@link Layer} can be
	 * added by adding them into the list returned by the graph
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
			assertTrue(getFixture().getNodes().contains(node));
		}
	}

	/**
	 * Checks that nodes are added correctly and null is not a valid node.
	 */
	@Test
	public void testGetNode() {
		assertNull(getFixture().getNode(null));

		List<Node> nodes = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			Node node = GraphFactory.createNode();
			nodes.add(node);
			getFixture().addNode(node);
		}

		for (Node node : nodes) {
			assertEquals(node, getFixture().getNode(node.getId()));
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
			assertNotNull(getFixture().getNode(node.getId()));
			getFixture().removeNode(node);
			assertNull("node '" + node + "' should be removed", getFixture().getNode(node.getId()));
		}
		assertEquals(0, getFixture().getNodes().size());
	}

	/**
	 * Checks that removing nodes from {@link Graph#getNodes()} has no effect.
	 */
	@Test
	public void testRemoveNodeFromList() {
		Pair<List<Node>, List<Relation<Node, Node>>> pair = createSampleGraph();

		for (Node node : pair.getLeft()) {
			if (getFixture().getNode(node.getId()) != null) {
				assertEquals("this node '" + node.getId() + "' should be there", node, getFixture().getNode(node.getId()));
				try {
					getFixture().getNodes().remove(node);
				} catch (Exception e) {
				}
				assertNotNull("this node '" + node.getId() + "' should still be there", getFixture().getNode(node.getId()));
			}
		}
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

	/**
	 * Tests if when a node is deleted even all edges having that node as source
	 * or target are deleted as well. graph.
	 */
	@Test
	public void testRemoveNodeAndAlsoRelations() {
		Node n1 = GraphFactory.createNode();
		getFixture().addNode(n1);
		Node n2 = GraphFactory.createNode();
		getFixture().addNode(n2);

		Relation<Node, Node> r1 = GraphFactory.createRelation();
		r1.setSource(n1);
		r1.setTarget(n2);
		getFixture().addRelation(r1);

		Relation<Node, Node> r2 = GraphFactory.createRelation();
		r2.setSource(n2);
		r2.setTarget(n1);
		getFixture().addRelation(r2);

		// check precondition
		assertEquals(1, getFixture().getOutRelations(n1.getId()).size());
		assertTrue(getFixture().getOutRelations(n1.getId()).contains(r1));
		assertTrue(getFixture().getOutRelations(n2.getId()).contains(r2));
		assertEquals(1, getFixture().getInRelations(n1.getId()).size());
		assertTrue(getFixture().getInRelations(n1.getId()).contains(r2));
		assertTrue(getFixture().getInRelations(n2.getId()).contains(r1));

		getFixture().removeNode(n2);

		assertEquals(0, getFixture().getRelations().size());
		assertEquals(0, getFixture().getInRelations(n1.getId()).size());
		assertEquals(0, getFixture().getOutRelations(n1.getId()).size());
	}
	
	/**
	 * Tests that if a node object is already contained in the graph it not added again.
	 */
	@Test
	public void testAddDuplicatedNode() {
		Node n = GraphFactory.createNode();
		
		getFixture().addNode(n);
		assertEquals(1, getFixture().getNodes().size());
		getFixture().addNode(n);
		assertEquals(1, getFixture().getNodes().size());
	}

	// ==========================================================< test nodes

	// ======================================================> test relations
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
		} catch (SaltParameterException e) {
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
	 * Tests adding an relation to the graph and if it could be accessed by its
	 * id.
	 */
	@Test
	public void testGetRelation() {
		assertNull(getFixture().getRelation(null));

		Node node1 = GraphFactory.createNode();
		node1.setId("node1");
		Node node2 = GraphFactory.createNode();
		node2.setId("node2");

		Relation<Node, Node> relation1 = GraphFactory.createRelation();
		relation1.setId("relation1");
		relation1.setSource(node1);
		relation1.setTarget(node2);

		assertNull(getFixture().getRelation(relation1.getId()));
		getFixture().addNode(node1);
		getFixture().addNode(node2);
		getFixture().addRelation(relation1);
		assertEquals(relation1, getFixture().getRelation(relation1.getId()));
	}

	/**
	 * Checks that all relations between two nodes are returned correctly.
	 */
	@Test
	public void testGetRelationsBetweenNodes() {
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
	public void testGetInRelations() {
		Pair<List<Node>, List<Relation<Node, Node>>> pair = createSampleGraph();
		for (Relation<Node, Node> relation : pair.getRight()) {
			assertTrue("this inserted relation '" + relation.getId() + "' should be in getInRelations: " + getFixture().getInRelations(relation.getTarget().getId()), getFixture().getInRelations(relation.getTarget().getId()).contains(relation));
		}
	}

	/**
	 * Checks that all outgoing relations are returned correctly.
	 */
	@Test
	public void testGetOutRelations() {
		Pair<List<Node>, List<Relation<Node, Node>>> pair = createSampleGraph();
		for (Relation<Node, Node> relation : pair.getRight()) {
			assertTrue("this inserted relation '" + relation.getId() + "' should be in getOutRelations: " + getFixture().getOutRelations(relation.getSource().getId()), getFixture().getOutRelations(relation.getSource().getId()).contains(relation));
		}
	}

	/**
	 * Tests removing a relation by its id.
	 */
	@Test
	public void testRemoveRelation() {
		Pair<List<Node>, List<Relation<Node, Node>>> pair = createSampleGraph();

		for (Relation<Node, Node> rel : pair.getRight()) {
			assertEquals("this edge '" + rel.getId() + "' should be there", rel, getFixture().getRelation(rel.getId()));
		}
		for (Relation<Node, Node> rel : pair.getRight()) {
			if (getFixture().getRelation(rel.getId()) != null) {
				assertEquals("this edge '" + rel.getId() + "' should be there", rel, getFixture().getRelation(rel.getId()));
				getFixture().removeRelation(rel);
				assertNull("this edge '" + rel.getId() + "' shouldn't be there", getFixture().getRelation(rel.getId()));
			}
		}

		Relation<Node, Node> rel = GraphFactory.createRelation();
		rel.setId("not there");
		// should not throw an error
		getFixture().removeRelation(rel);
	}

	/**
	 * Tests removing all relations
	 */
	@Test
	public void testRemoveRelations() {
		Pair<List<Node>, List<Relation<Node, Node>>> pair = createSampleGraph();
		// check if relation was inserted
		for (Relation<Node, Node> rel : pair.getRight()) {
			assertEquals("this relation '" + rel.getId() + "' should be there", rel, getFixture().getRelation(rel.getId()));
		}
		// remove relation
		getFixture().removeRelations();

		for (Relation<Node, Node> rel : pair.getRight()) {
			assertNull("this relation '" + rel.getId() + "' shouldn't be there", getFixture().getRelation(rel.getId()));
		}
	}

	/**
	 * Creates an relation, puts it into graph and a layer and removes it from
	 * the graph. Tests if relation is even removed in layer.
	 */
	@Test
	public void testRemoveRelation2() {
		Node node1 = GraphFactory.createNode();
		Node node2 = GraphFactory.createNode();
		getFixture().addNode(node1);
		getFixture().addNode(node2);

		Layer<Node, Relation<Node, Node>> layer1 = GraphFactory.createLayer();
		getFixture().addLayer(layer1);
		Collection<Relation<Node, Node>> relations = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Relation<Node, Node> relation = GraphFactory.createRelation();
			relation.setSource(node1);
			relation.setTarget(node2);
			getFixture().addRelation(relation);
			layer1.getRelations().add(relation);
			relations.add(relation);
		}
		assertEquals(5, getFixture().getRelations().size());
		assertEquals(1, getFixture().getLayers().size());
		assertEquals(5, layer1.getRelations().size());

		for (Relation<Node, Node> relation : relations) {
			getFixture().removeRelation(relation);
		}
		assertEquals(0, getFixture().getRelations().size());
		assertEquals(1, getFixture().getLayers().size());
		assertEquals(0, layer1.getRelations().size());
	}

	/**
	 * Chechs that removing relations from {@link Graph#getRelations()} has no
	 * effect.
	 */
	@Test
	public void testRemoveRelationFromList() {
		Pair<List<Node>, List<Relation<Node, Node>>> pair = createSampleGraph();

		for (Relation<Node, Node> relation : pair.getRight()) {
			if (getFixture().getRelation(relation.getId()) != null) {
				assertEquals("this relation '" + relation.getId() + "' should be there", relation, getFixture().getRelation(relation.getId()));
				try {
					getFixture().getRelations().remove(relation);
				} catch (UnsupportedOperationException e) {
				}
				assertNotNull("this relation '" + relation.getId() + "' should still be there", getFixture().getRelation(relation.getId()));
			}
		}
	}

	/**
	 * Tests the removing of all relations in graph.
	 */
	@Test
	public void testRemoveAllRelation() throws Exception {
		Pair<List<Node>, List<Relation<Node, Node>>> pair = createSampleGraph();
		// check if relations have been added
		for (Relation<Node, Node> relation : pair.getRight()) {
			assertEquals("this relation '" + relation.getId() + "' should be there", relation, getFixture().getRelation(relation.getId()));
		}
		// remove old relation
		getFixture().removeRelations();
		// add new relation
		for (Relation<Node, Node> relation : pair.getRight()) {
			// add relation
			getFixture().addRelation(relation);
			// check if relation exists
			assertEquals("created relation has to be there", getFixture().getRelation(relation.getId()), relation);
		}
	}

	/**
	 * Tests when the source of a relation has been changed, if the index was
	 * updated correctly.
	 */
	@Test
	public void testChangeRelationSource() {
		Node node1 = GraphFactory.createNode();
		getFixture().addNode(node1);

		Node node2 = GraphFactory.createNode();
		getFixture().addNode(node2);

		Relation<Node, Node> relation = GraphFactory.createRelation();
		relation.setSource(node1);
		relation.setTarget(node2);
		getFixture().addRelation(relation);

		assertTrue(getFixture().getOutRelations(node1.getId()).contains(relation));
		assertTrue(getFixture().getInRelations(node2.getId()).contains(relation));

		Node node3 = GraphFactory.createNode();
		getFixture().addNode(node3);

		// redirect source
		relation.setSource(node3);
		assertTrue("all relations: " + getFixture().getOutRelations(node3.getId()), getFixture().getOutRelations(node3.getId()).contains(relation));
		assertTrue(getFixture().getOutRelations(node1.getId()).isEmpty());
	}

	/**
	 * Tests when the target of a relation has been changed, if the index was
	 * updated correctly.
	 */
	@Test
	public void testChangeRelationTarget() {
		Node node1 = GraphFactory.createNode();
		node1.setId("node1");
		getFixture().addNode(node1);

		Node node2 = GraphFactory.createNode();
		node2.setId("node2");
		getFixture().addNode(node2);

		Relation<Node, Node> relation = GraphFactory.createRelation();
		relation.setId("relation1");
		relation.setSource(node1);
		relation.setTarget(node2);
		getFixture().addRelation(relation);

		assertTrue(getFixture().getOutRelations(node1.getId()).contains(relation));
		assertTrue(getFixture().getInRelations(node2.getId()).contains(relation));

		Node node3 = GraphFactory.createNode();
		node3.setId("node3");
		getFixture().addNode(node3);
		// redirect source
		relation.setTarget(node3);
		assertTrue(getFixture().getInRelations(node3.getId()).contains(relation));
		assertTrue(getFixture().getInRelations(node2.getId()).isEmpty());
	}
	
	/**
	 * Tests that if a relation object is already contained in the graph it not added again.
	 */
	@Test
	public void testAddDuplicatedRelation() {
		Node n1 = GraphFactory.createNode();
		Node n2 = GraphFactory.createNode();
		
		getFixture().addNode(n1);
		getFixture().addNode(n2);
		
		Relation<Node,Node> rel = GraphFactory.createRelation();
		rel.setSource(n1);
		rel.setTarget(n2);
		
		getFixture().addRelation(rel);
		assertEquals(1, getFixture().getRelations().size());
		getFixture().addRelation(rel);
		assertEquals(1, getFixture().getRelations().size());
	}

	// =======================================================< test relations

	// =======================================================> test layers
	/**
	 * Tests whether a layer was added correctly.
	 */
	@Test
	public void testAddLayer() {
		Layer<Node, Relation<Node, Node>> layer = null;
		// adding null layer
		getFixture().addLayer(layer);
		assertEquals("shall not add a null layer", 0, getFixture().getLayers().size());

		// adding layer
		layer = GraphFactory.createLayer();
		getFixture().addLayer(layer);
		assertTrue(getFixture().getLayers().contains(layer));

		// adding layer second time shall fail
		getFixture().addLayer(layer);
		assertTrue(getFixture().getLayers().contains(layer));
		assertEquals("shall not add a layer two times", 1, getFixture().getLayers().size());
	}

	/**
	 * Tests whether the method {@link Graph#getLayer(String)}
	 */
	@Test
	public void testGetLayer() {
		assertNull(getFixture().getLayer(null));

		Layer<Node, Relation<Node, Node>> layer = null;
		// String id = "id";

		layer = GraphFactory.createLayer();
		// layer.setId(id);
		getFixture().addLayer(layer);
		assertEquals(layer, getFixture().getLayer(layer.getId()));
	}

	/**
	 * Tests the removing of a layer
	 */
	@Test
	public void testRemoveLayer() {
		Layer<Node, Relation<Node, Node>> layer = GraphFactory.createLayer();
		getFixture().addLayer(layer);
		assertEquals(layer, getFixture().getLayer(layer.getId()));
		getFixture().removeLayer(layer);
		assertNull(getFixture().getLayer(layer.getId()));
		assertEquals(0, getFixture().getLayers().size());
	}

	/**
	 * Tests that layers cannot be removed from list {@link Graph#getLayers()}
	 */
	@Test
	public void testRemoveLayerFromList() {
		Layer<Node, Relation<Node, Node>> layer = GraphFactory.createLayer();
		getFixture().addLayer(layer);
		assertEquals(layer, getFixture().getLayer(layer.getId()));
		try {
			getFixture().getLayers().remove(layer);
		} catch (UnsupportedOperationException e) {
		}
		assertEquals(layer, getFixture().getLayer(layer.getId()));
		assertEquals(1, getFixture().getLayers().size());
	}

	/**
	 * Tests that when a layer, which contains nodes and relations is added to
	 * the graph, the nodes and relations are also added to the graph.
	 */
	@Test
	public void testAddingLayerContainingNodeAndRelation() {
		Layer<Node, Relation<Node, Node>> layer = GraphFactory.createLayer();
		Node node = GraphFactory.createNode();
		Node node2 = GraphFactory.createNode();
		Relation<Node, Node> relation = GraphFactory.createRelation();
		relation.setSource(node);
		relation.setTarget(node2);

		layer.addNode(node);
		layer.addNode(node2);
		layer.addRelation(relation);

		assertEquals(0, getFixture().getNodes().size());
		assertEquals(0, getFixture().getRelations().size());

		getFixture().addLayer(layer);

		assertEquals(2, getFixture().getNodes().size());
		assertEquals(node, getFixture().getNode(node.getId()));
		assertEquals(node2, getFixture().getNode(node2.getId()));
		assertEquals(1, getFixture().getRelations().size());
		assertEquals(relation, getFixture().getRelation(relation.getId()));
	}

	/**
	 * Tests whether a node and relation added to a layer is also added to the
	 * graph.
	 */
	@Test
	public void testAddNodeAndRelationToLayer() {
		Layer<Node, Relation<Node, Node>> layer = GraphFactory.createLayer();
		getFixture().addLayer(layer);

		Node node = GraphFactory.createNode();
		Node node2 = GraphFactory.createNode();
		Relation<Node, Node> relation = GraphFactory.createRelation();
		relation.setSource(node);
		relation.setTarget(node2);

		assertEquals(0, getFixture().getNodes().size());
		assertEquals(0, getFixture().getRelations().size());

		layer.addNode(node);
		assertEquals(node, getFixture().getNode(node.getId()));
		layer.addNode(node2);
		assertEquals(node2, getFixture().getNode(node2.getId()));
		layer.addRelation(relation);
		assertEquals(relation, getFixture().getRelation(relation.getId()));
	}
	
	/**
	 * Tests that if a layer object is already contained in the graph it not added again.
	 */
	@Test
	public void testAddDuplicatedLayer() {
		Layer<Node, Relation<Node,Node>> l = GraphFactory.createLayer();
		
		getFixture().addLayer(l);
		assertEquals(1, getFixture().getLayers().size());
		getFixture().addLayer(l);
		assertEquals(1, getFixture().getLayers().size());
	}

	// =======================================================< test layers
}
