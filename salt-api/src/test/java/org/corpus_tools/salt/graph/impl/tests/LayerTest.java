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

import org.corpus_tools.salt.exceptions.SaltException;
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
		setFixture(GraphFactory.createLayer());
	}

	public Layer<Node, Relation<Node, Node>> getFixture() {
		return fixture;
	}

	public void setFixture(Layer<Node, Relation<Node, Node>> fixture) {
		this.fixture = fixture;
	}

	/**
	 * Tests the double chaining between graph and layer, the methods
	 * {@link Layer#setGraph(Graph)} and {@link Layer#getGraph()}.
	 */
	@Test
	public void testSetGetGraph() {
		assertNull(getFixture().getGraph());

		Graph<Node, Relation<Node, Node>, Layer<Node, Relation<Node, Node>>> graph = GraphFactory.createGraph();
		getFixture().setGraph(graph);
		assertEquals(getFixture().getGraph(), graph);

		getFixture().setGraph(null);
		assertNull(this.getFixture().getGraph());
		assertEquals(0, graph.getLayers().size());
	}

	/**
	 * Tests the double chaining with Graph.
	 */
	@Test
	public void testDoubleChaining() {
		Graph<Node, Relation<Node, Node>, Layer<Node, Relation<Node, Node>>> graph = GraphFactory.createGraph();
		getFixture().setGraph(graph);
		assertTrue("only contains " + graph.getLayers(), graph.getLayers().contains(getFixture()));
	}

	/**
	 * Tests the setting and getting of id.
	 */
	public void testGetId() {
		String id = null;

		// shall not add an empty id
		try {
			this.getFixture().setId(id);
			fail("Shall not set the id to null.");
		} catch (SaltException e) {
		}

		// add correct id
		id = "id";
		this.getFixture().setId(id);
		assertEquals(id, this.getFixture().getId());
	}

	/**
	 * Tests that all inserted nodes are returned again.
	 */
	public void testGetNodes() {
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
	 * Tests that all nodes added to layer also contains the layer.
	 */
	public void testDoubleChainingAddNode() {
		List<Node> nodes = new ArrayList<>();

		for (int i = 0; i < 50; i++) {
			Node node = GraphFactory.createNode();
			nodes.add(node);
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
	public void testDoubleChainingRemoveNode() {
		List<Node> nodes = new ArrayList<>();

		for (int i = 0; i < 50; i++) {
			Node node = GraphFactory.createNode();
			nodes.add(node);
			getFixture().addNode(node);
		}
		assertEquals(nodes.size(), getFixture().getNodes().size());
		for (Node node : nodes) {
			node.removeLayer(getFixture());
		}
		assertEquals(0, getFixture().getNodes().size());
	}

	/**
	 * Tests that all inserted relations are returned again.
	 */
	public void testGetRelations() {
		List<Relation<Node, Node>> relations = new ArrayList<>();
		Node node = GraphFactory.createNode();

		for (int i = 0; i < 50; i++) {
			Relation<Node, Node> relation = GraphFactory.createRelation();
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

	// /**
	// * Checks that a layer cannot contain itself.
	// */
	// public void testSelfContainment() {
	// try {
	// this.getFixture().getSubLayers().add(getFixture());
	// fail("A layer shall not contain itself");
	// } catch (Exception e) {
	// }
	// }
	//
	// /**
	// * Tests the '
	// * {@link
	// de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer#getAllSubLayers()
	// * <em>Get All Sub Layers</em>}' operation. <!-- begin-user-doc --> <!--
	// * end-user-doc --> layer1 / \ layer2 layer3 | layer4
	// *
	// * @see
	// de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer#getAllSubLayers()
	// */
	// public void testGetAllSubLayers() {
	// Layer layer1 = GraphFactory.createLayer();
	// layer1.setId("layer1");
	// Layer layer2 = GraphFactory.createLayer();
	// layer2.setId("layer2");
	// Layer layer3 = GraphFactory.createLayer();
	// layer3.setId("layer3");
	// Layer layer4 = GraphFactory.createLayer();
	// layer4.setId("layer4");
	//
	// assertNull(layer1.getAllSubLayers());
	// assertNull(layer1.getSuperLayer());
	//
	// assertNull(layer2.getAllSubLayers());
	// assertNull(layer2.getSuperLayer());
	//
	// assertNull(layer3.getAllSubLayers());
	// assertNull(layer3.getSuperLayer());
	//
	// assertNull(layer4.getAllSubLayers());
	// assertNull(layer4.getSuperLayer());
	//
	// // adding layer2 to layer1
	// layer1.getSubLayers().add(layer2);
	// assertTrue(layer1.getAllSubLayers().contains(layer2));
	// assertEquals(layer1, layer2.getSuperLayer());
	//
	// // adding layer3 to layer1
	// layer1.getSubLayers().add(layer3);
	// assertTrue(layer1.getAllSubLayers().contains(layer3));
	// assertEquals(layer1, layer3.getSuperLayer());
	//
	// // recursive part
	// layer2.getSubLayers().add(layer4);
	// assertTrue(layer2.getAllSubLayers().contains(layer4));
	//
	// assertTrue(layer1.getAllSubLayers().contains(layer2));
	// assertTrue(layer1.getAllSubLayers().contains(layer4));
	// assertEquals(layer2, layer4.getSuperLayer());
	// }

	// /**
	// * Tests the '
	// * {@link
	// de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer#getAllIncludedNodes()
	// * <em>Get All Included Nodes</em>}' operation. <!-- begin-user-doc -->
	// <!--
	// * end-user-doc -->
	// *
	// * @see
	// de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer#getAllIncludedNodes()
	// * layer1 (n1) / \ layer2(n2.1, n2.2) layer3(n3) | layer4(n4)
	// */
	// public void testGetAllIncludedNodes() {
	// Layer layer1 = GraphFactory.createLayer();
	// layer1.setId("layer1");
	// Node n1 = GraphFactory.createNode();
	// n1.setId("n1");
	// layer1.getNodes().add(n1);
	//
	// Layer layer2 = GraphFactory.createLayer();
	// layer2.setId("layer2");
	// Node n21 = GraphFactory.createNode();
	// n21.setId("n2.1");
	// layer2.getNodes().add(n21);
	// Node n22 = GraphFactory.createNode();
	// n22.setId("n2.2");
	// layer2.getNodes().add(n22);
	//
	// Layer layer3 = GraphFactory.createLayer();
	// layer3.setId("layer3");
	// Node n3 = GraphFactory.createNode();
	// n3.setId("n3");
	// layer3.getNodes().add(n3);
	//
	// Layer layer4 = GraphFactory.createLayer();
	// layer4.setId("layer4");
	// Node n4 = GraphFactory.createNode();
	// n4.setId("n4");
	// layer4.getNodes().add(n4);
	//
	// // connect layers
	// layer1.getSubLayers().add(layer2);
	// layer1.getSubLayers().add(layer3);
	// layer2.getSubLayers().add(layer4);
	//
	// {// check node containment
	// assertNotNull(layer1.getAllIncludedNodes());
	// assertNotNull(layer2.getAllIncludedNodes());
	// assertNotNull(layer3.getAllIncludedNodes());
	// assertNotNull(layer4.getAllIncludedNodes());
	//
	// assertEquals(1, layer4.getAllIncludedNodes().size());
	// assertTrue(layer4.getAllIncludedNodes().contains(n4));
	//
	// assertEquals(1, layer3.getAllIncludedNodes().size());
	// assertTrue(layer3.getAllIncludedNodes().contains(n3));
	//
	// assertEquals(3, layer2.getAllIncludedNodes().size());
	// assertTrue(layer2.getAllIncludedNodes().contains(n4));
	// assertTrue(layer2.getAllIncludedNodes().contains(n21));
	// assertTrue(layer2.getAllIncludedNodes().contains(n22));
	//
	// assertEquals(5, layer1.getAllIncludedNodes().size());
	// assertTrue(layer1.getAllIncludedNodes().contains(n4));
	// assertTrue(layer1.getAllIncludedNodes().contains(n3));
	// assertTrue(layer1.getAllIncludedNodes().contains(n21));
	// assertTrue(layer1.getAllIncludedNodes().contains(n22));
	// assertTrue(layer1.getAllIncludedNodes().contains(n1));
	// }// check node containment
	// }
	//
	// /**
	// * Tests the '
	// * {@link
	// de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer#getAllIncludedRelations()
	// * <em>Get All Included Relations</em>}' operation. <!-- begin-user-doc
	// -->
	// <!--
	// * end-user-doc -->
	// *
	// * @see
	// de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer#getAllIncludedRelations()
	// * layer1 (e1) / \ layer2(e2.1, e2.2) layer3(e3) | layer4(e4)
	// */
	// public void testGetAllIncludedRelations() {
	// Layer layer1 = GraphFactory.createLayer();
	// layer1.setId("layer1");
	// Relation e1 = GraphFactory.createRelation();
	// e1.setId("e1");
	// layer1.getRelations().add(e1);
	//
	// Layer layer2 = GraphFactory.createLayer();
	// layer2.setId("layer2");
	// Relation e21 = GraphFactory.createRelation();
	// e21.setId("e2.1");
	// layer2.getRelations().add(e21);
	// Relation e22 = GraphFactory.createRelation();
	// e22.setId("e2.2");
	// layer2.getRelations().add(e22);
	//
	// Layer layer3 = GraphFactory.createLayer();
	// layer3.setId("layer3");
	// Relation e3 = GraphFactory.createRelation();
	// e3.setId("e3");
	// layer3.getRelations().add(e3);
	//
	// Layer layer4 = GraphFactory.createLayer();
	// layer4.setId("layer4");
	// Relation e4 = GraphFactory.createRelation();
	// e4.setId("e4");
	// layer4.getRelations().add(e4);
	//
	// // connect layers
	// layer1.getSubLayers().add(layer2);
	// layer1.getSubLayers().add(layer3);
	// layer2.getSubLayers().add(layer4);
	//
	// {// check relation containment
	// assertNotNull(layer1.getAllIncludedRelations());
	// assertNotNull(layer2.getAllIncludedRelations());
	// assertNotNull(layer3.getAllIncludedRelations());
	// assertNotNull(layer4.getAllIncludedRelations());
	//
	// assertEquals(1, layer4.getAllIncludedRelations().size());
	// assertTrue(layer4.getAllIncludedRelations().contains(e4));
	//
	// assertEquals(1, layer3.getAllIncludedRelations().size());
	// assertTrue(layer3.getAllIncludedRelations().contains(e3));
	//
	// assertEquals(3, layer2.getAllIncludedRelations().size());
	// assertTrue(layer2.getAllIncludedRelations().contains(e4));
	// assertTrue(layer2.getAllIncludedRelations().contains(e21));
	// assertTrue(layer2.getAllIncludedRelations().contains(e22));
	//
	// assertEquals(5, layer1.getAllIncludedRelations().size());
	// assertTrue(layer1.getAllIncludedRelations().contains(e4));
	// assertTrue(layer1.getAllIncludedRelations().contains(e3));
	// assertTrue(layer1.getAllIncludedRelations().contains(e21));
	// assertTrue(layer1.getAllIncludedRelations().contains(e22));
	// assertTrue(layer1.getAllIncludedRelations().contains(e1));
	// }// check node containment
	// }
}
