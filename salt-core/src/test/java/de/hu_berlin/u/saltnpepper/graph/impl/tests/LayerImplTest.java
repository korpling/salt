package de.hu_berlin.u.saltnpepper.graph.impl.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.graph.Edge;
import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.graph.Layer;
import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.graph.impl.GraphFactory;

public class LayerImplTest {

	private Layer<Node, Edge<Node,Node>> fixture= null; 
	
	@Before
	public void setUp() throws Exception {
		setFixture(GraphFactory.createLayer());
	}

	public Layer<Node, Edge<Node,Node>> getFixture() {
		return fixture;
	}

	public void setFixture(Layer<Node, Edge<Node,Node>> fixture) {
		this.fixture = fixture;
	}
	
	/**
	 * Tests {@link Layer#setGraph(Graph)} and {@link Layer#getGraph()}. 
	 */
	@Test
	public void testSetGetGraph() {
		Graph<Node, Edge<Node,Node>> graph= GraphFactory.createGraph();
		getFixture().setGraph(graph);
		assertEquals(getFixture().getGraph(), graph);
	}
	
	/**
	 * Tests the double chaining with Graph.
	 */
	@Test
	public void testDoubleChaining() {
		Graph<Node, Edge<Node,Node>> graph= GraphFactory.createGraph();
		getFixture().setGraph(graph);
		assertTrue("only contains "+graph.getLayers(), graph.getLayers().contains(getFixture()));
	}
}
