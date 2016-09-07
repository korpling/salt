/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
package org.corpus_tools.salt.graph.impl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.corpus_tools.salt.graph.Graph;
import org.corpus_tools.salt.graph.GraphFactory;
import org.corpus_tools.salt.graph.Layer;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.graph.Relation;
import org.junit.Before;
import org.junit.Test;

public class NodeTest {
	protected Node fixture = null;

	public Node getFixture() {
		return fixture;
	}

	public void setFixture(Node fixture) {
		this.fixture = fixture;
	}
	
	public Graph createGraph() {
		return GraphFactory.createGraph();
	}
	
	public Layer createLayer() {
		return GraphFactory.createLayer();
	}
	
	public Node createNode() {
		return GraphFactory.createNode();
	}

	@Before
	public void setUp() throws Exception {
		setFixture(createNode());
	}

	/**
	 * Tests the double chaining with Graph.
	 */
	@Test
	public void testDoubleChaining() {
		Graph<Node, Relation<Node, Node>, Layer<Node, Relation<Node, Node>>> graph = createGraph();
		getFixture().setGraph(graph);
		assertTrue("only contains " + graph.getNodes(), graph.getNodes().contains(getFixture()));
	}

	/**
	 * Tests whether a relation is removed correctly form graph, when the graph
	 * is set to null or to a new graph.
	 */
	@Test
	public void testDoubleChaining_SetGraph_remove() {
		Graph<Node, Relation<Node, Node>, Layer<Node, Relation<Node, Node>>> graph = createGraph();

		getFixture().setGraph(graph);
		assertEquals(graph, getFixture().getGraph());
		getFixture().setGraph(null);
		assertNull(getFixture().getGraph());

		getFixture().setGraph(graph);
		assertEquals(graph, getFixture().getGraph());

		Graph<Node, Relation<Node, Node>, Layer<Node, Relation<Node, Node>>> graph2 = createGraph();

		getFixture().setGraph(graph2);
		assertEquals(graph2, getFixture().getGraph());
	}

	/**
	 * tests the adding and getting of a layer to a node
	 */
	@Test
	public void testAddGetLayers() {
		Layer layer = createLayer();

		// prerequirements
		Graph graph = createGraph();
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
		Layer layer = createLayer();

		// prerequirements
		Graph graph = createGraph();
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
		Layer layer = createLayer();

		// prerequirements
		Graph graph = createGraph();
		graph.addNode(getFixture());
		graph.addLayer(layer);

		getFixture().addLayer(layer);
		assertTrue(layer.getNodes().contains(getFixture()));
		getFixture().removeLayer(layer);
		assertFalse(layer.getNodes().contains(getFixture()));
	}
}