package de.hu_berlin.u.saltnpepper.graph.impl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.graph.GraphFactory;
import de.hu_berlin.u.saltnpepper.graph.Layer;
import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.graph.Relation;

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
		Graph<Node, Relation<Node, Node>, Layer<Node, Relation<Node, Node>>> graph = GraphFactory.createGraph();
		getFixture().setGraph(graph);
		assertTrue("only contains " + graph.getNodes(), graph.getNodes().contains(getFixture()));
	}

	/**
	 * tests the adding and getting of a layer to a node
	 */
	@Test
	public void testAddGetLayers() {
		Layer layer = GraphFactory.createLayer();

		// prerequirements
		Graph graph = GraphFactory.createGraph();
		graph.addNode(getFixture());
		graph.addLayer(layer);

		getFixture().addLayer(layer);
		assertEquals(1, getFixture().getLayers().size());
		assertTrue(getFixture().getLayers().contains(layer));
	}

	/**
	 * Tests the adding, getting and removing of a layer to a node
	 */
	@Test
	public void testRemoveLayers() {
		assertNotNull(getFixture().getLayers());
		Layer layer = GraphFactory.createLayer();

		// prerequirements
		Graph graph = GraphFactory.createGraph();
		graph.addNode(getFixture());
		graph.addLayer(layer);

		getFixture().addLayer(layer);
		assertTrue(getFixture().getLayers().contains(layer));
		getFixture().removeLayer(layer);
		assertEquals(0, getFixture().getLayers().size());
	}

	/**
	 * Tests whether adding a layer to a node, results in adding the node to the
	 * layer. And the same goes for removing.
	 */
	@Test
	public void testDoubleChainingLayer() {
		Layer layer = GraphFactory.createLayer();

		// prerequirements
		Graph graph = GraphFactory.createGraph();
		graph.addNode(getFixture());
		graph.addLayer(layer);

		getFixture().addLayer(layer);
		assertTrue(layer.getNodes().contains(getFixture()));
		getFixture().removeLayer(layer);
		assertFalse(layer.getNodes().contains(getFixture()));
	}
}