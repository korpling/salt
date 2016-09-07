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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.corpus_tools.salt.graph.Graph;
import org.corpus_tools.salt.graph.GraphFactory;
import org.corpus_tools.salt.graph.Layer;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.graph.Relation;
import org.junit.Before;
import org.junit.Test;

public class LayerTest {

	private Layer<Node, Relation<Node, Node>> fixture = null;

	@Before
	public void setUp() throws Exception {
		setFixture(createLayer());
	}

	public Layer<Node, Relation<Node, Node>> getFixture() {
		return fixture;
	}

	public void setFixture(Layer<Node, Relation<Node, Node>> fixture) {
		this.fixture = fixture;
	}
	
	protected Layer<Node, Relation<Node, Node>> createLayer() {
		return GraphFactory.createLayer();
	}
	
	protected Graph<Node, Relation<Node, Node>, Layer<Node, Relation<Node, Node>>> createGraph() {
		return GraphFactory.createGraph();
	}
	
	protected Node createNode() {
		return GraphFactory.createNode();
	}
	
	protected Relation<Node,Node> createRelation() {
		return GraphFactory.createRelation();
	}

	/**
	 * Tests the double chaining between graph and layer, the methods
	 * {@link Layer#setGraph(Graph)} and {@link Layer#getGraph()}.
	 */
	@Test
	public void testSetGetGraph() {
		assertNull(getFixture().getGraph());

		Graph<Node, Relation<Node, Node>, Layer<Node, Relation<Node, Node>>> graph = createGraph();
		graph.addLayer(getFixture());
		assertEquals(getFixture().getGraph(), graph);

		graph.removeLayer(getFixture());
		assertNull(getFixture().getGraph());
		assertEquals(0, graph.getLayers().size());

	}

	/**
	 * Tests the setting and getting of id.
	 */
	@Test
	public void testGetId() {
		String id = null;

		// // shall not add an empty id
		// try {
		// getFixture().setId(id);
		// fail("Shall not set the id to null.");
		// } catch (SaltException e) {
		// }

		// add correct id
		id = "id";
		getFixture().setId(id);
		assertEquals(id, getFixture().getId());
	}

	/**
	 * Tests that all inserted nodes are returned again.
	 */
	@Test
	public void testGetNodes() {
		List<Node> nodes = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			Node node = createNode();
			nodes.add(node);
			getFixture().addNode(node);
		}
		assertEquals(nodes.size(), getFixture().getNodes().size());
		for (Node node : nodes) {
			assertTrue(getFixture().getNodes().contains(node));
		}
	}

	/**
	 * Checks that nodes can not be added to layer's node list directly.
	 */
	@Test
	public void testAddNode() {
		try {
			getFixture().getNodes().add(createNode());
			fail("Should not add a node in layer's node list directly.");
		} catch (UnsupportedOperationException e) {
		}
	}

	/**
	 * Checks that relations can not be added to layer's relation list directly.
	 */
	@Test
	public void testAddRelation() {
		try {
			getFixture().getRelations().add(createRelation());
			fail("Should not add a node in layer's node list directly.");
		} catch (UnsupportedOperationException e) {
		}
	}

	/**
	 * Tests that all nodes added to layer also contains the layer.
	 */
	@Test
	public void testDoubleChainingAddNode() {
		// prerequirements
		Graph<Node, Relation<Node, Node>, Layer<Node, Relation<Node, Node>>> graph = createGraph();
		graph.addLayer(getFixture());

		List<Node> nodes = new ArrayList<>();

		for (int i = 0; i < 50; i++) {
			Node node = createNode();
			nodes.add(node);
			graph.addNode(node);
			getFixture().addNode(node);
		}
		assertEquals(nodes.size(), getFixture().getNodes().size());
		for (Node node : nodes) {
			assertTrue(node.getLayers().contains(getFixture()));
		}
	}

	/**
	 * Tests that all nodes removed from this layer also contains the layer.
	 */
	@Test
	public void testDoubleChainingRemoveNode() {
		List<Node> nodes = new ArrayList<>();

		for (int i = 0; i < 50; i++) {
			Node node = createNode();
			nodes.add(node);
			getFixture().addNode(node);
		}
		assertEquals(nodes.size(), getFixture().getNodes().size());
		for (Node node : nodes) {
			getFixture().removeNode(node);
		}
		assertEquals(0, getFixture().getNodes().size());
	}

	/**
	 * Tests that all inserted relations are returned again.
	 */
	@Test
	public void testGetRelations() {
		List<Relation<Node, Node>> relations = new ArrayList<>();
		Node node = createNode();

		for (int i = 0; i < 50; i++) {
			Relation<Node, Node> relation = createRelation();
			relation.setSource(node);
			relation.setTarget(node);
			relations.add(relation);
			getFixture().addRelation(relation);
		}
		assertEquals(relations.size(), getFixture().getRelations().size());
		for (Relation<Node, Node> relation : relations) {
			assertTrue(getFixture().getRelations().contains(relation));
		}
	}
}
