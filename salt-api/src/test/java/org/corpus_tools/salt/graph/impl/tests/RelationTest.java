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
import static org.junit.Assert.assertTrue;

import org.corpus_tools.salt.graph.Graph;
import org.corpus_tools.salt.graph.GraphFactory;
import org.corpus_tools.salt.graph.Layer;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.graph.Relation;
import org.junit.Before;
import org.junit.Test;

public class RelationTest {

	protected Relation<Node, Node> fixture = null;

	public Relation<Node, Node> getFixture() {
		return fixture;
	}

	public void setFixture(Relation<Node, Node> fixture) {
		this.fixture = fixture;
	}

	@Before
	public void setUp() throws Exception {
		setFixture(GraphFactory.createRelation());
	}

	/**
	 * Tests the double chaining with Graph.
	 */
	@Test
	public void testDoubleChaining() {
		Graph<Node, Relation<Node, Node>, Layer<Node, Relation<Node, Node>>> graph = GraphFactory.createGraph();
		Node source = GraphFactory.createNode();
		Node target = GraphFactory.createNode();
		graph.addNode(source);
		graph.addNode(target);
		getFixture().setSource(source);
		getFixture().setTarget(target);

		getFixture().setGraph(graph);
		assertTrue("only contains " + graph.getRelations(), graph.getRelations().contains(getFixture()));
	}

	/**
	 * tests the adding and getting of a layer to a relation
	 */
	@Test
	public void testAddGetLayers() {
		Layer layer = GraphFactory.createLayer();
		Node source = GraphFactory.createNode();
		Node target = GraphFactory.createNode();
		getFixture().setSource(source);
		getFixture().setTarget(target);

		// prerequirements
		Graph graph = GraphFactory.createGraph();
		graph.addLayer(layer);
		graph.addNode(source);
		graph.addNode(target);
		graph.addRelation(getFixture());

		getFixture().addLayer(layer);
		assertEquals(1, getFixture().getLayers().size());
		assertTrue(getFixture().getLayers().contains(layer));
	}

	/**
	 * Tests the adding, getting and removing of a layer to a relation
	 */
	@Test
	public void testRemoveLayers() {
		assertNotNull(getFixture().getLayers());
		Layer layer = GraphFactory.createLayer();
		Node source = GraphFactory.createNode();
		Node target = GraphFactory.createNode();
		getFixture().setSource(source);
		getFixture().setTarget(target);

		// prerequirements
		Graph graph = GraphFactory.createGraph();
		graph.addLayer(layer);
		graph.addNode(source);
		graph.addNode(target);
		graph.addRelation(getFixture());

		getFixture().addLayer(layer);
		assertTrue(getFixture().getLayers().contains(layer));
		getFixture().removeLayer(layer);
		assertEquals(0, getFixture().getLayers().size());
	}

	/**
	 * Tests whether adding a layer to a relation, results in adding the
	 * relation to the layer. And the same goes for removing.
	 */
	@Test
	public void testDoubleChainingLayer() {
		Layer layer = GraphFactory.createLayer();
		Node source = GraphFactory.createNode();
		Node target = GraphFactory.createNode();
		getFixture().setSource(source);
		getFixture().setTarget(target);

		// prerequirements
		Graph graph = GraphFactory.createGraph();
		graph.addLayer(layer);
		graph.addNode(source);
		graph.addNode(target);
		graph.addRelation(getFixture());

		getFixture().addLayer(layer);
		assertTrue(layer.getRelations().contains(getFixture()));
		getFixture().removeLayer(layer);
		assertFalse(layer.getRelations().contains(getFixture()));
	}
}
