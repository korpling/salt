/**
 * Copyright 2009 Humboldt-Universität zu Berlin.
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
package org.corpus_tools.salt.core.impl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SLayer;
import org.corpus_tools.salt.core.SNamedElement;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.junit.Before;
import org.junit.Test;

public class SGraphTest extends SAnnotationContainerTest {
	public SGraph getFixture() {
		return ((SGraph) super.getFixture());
	}

	@Before
	public void setUp() throws Exception {
		setFixture(SaltFactory.createSGraph());
	}

	/**
	 * Tests the methods {@link SNamedElement#getName()} and
	 * {@link SNamedElement#setName(String)}.
	 */
	@Test
	public void testGetName() {
		TestHelper.testGetName(getFixture());
	}

	/**
	 * Tests that the root nodes are returned correctly.
	 */
	@Test
	public void testGetRoots() {
		List<SNode> expectedRoots = null;
		List<SNode> roots = null;
		SGraph graph = null;

		// test 1
		graph = TestHelper.createGraph_Tree();
		setFixture(graph);
		expectedRoots = new ArrayList<>();
		expectedRoots.add(graph.getNode("node1"));
		roots = getFixture().getRoots();
		assertEquals("The expected number of roots are not the same, as the returned number", expectedRoots.size(),
				roots.size());
		for (SNode expectedRoot : expectedRoots) {
			assertTrue("The list of returned roots does not contain expected root '" + expectedRoot.getId() + "'.",
					roots.contains(expectedRoot));
		}

		// test 2
		graph = TestHelper.createGraph_DAG();
		setFixture(graph);
		expectedRoots = new ArrayList<>();
		expectedRoots.add(graph.getNode("node1"));
		expectedRoots.add(graph.getNode("node4"));
		roots = getFixture().getRoots();
		assertEquals("The expected number of roots are not the same, as the returned number", expectedRoots.size(),
				roots.size());
		for (SNode expectedRoot : expectedRoots) {
			assertTrue("The list of returned roots does not contain expected root '" + expectedRoot.getId() + "'.",
					roots.contains(expectedRoot));
		}

		// test 3
		graph = TestHelper.createGraph_Cycle();
		setFixture(graph);
		expectedRoots = new ArrayList<>();
		expectedRoots.add(graph.getNode("node1"));
		expectedRoots.add(graph.getNode("node4"));
		roots = getFixture().getRoots();
		assertEquals("The expected number of roots are not the same, as the returned number", expectedRoots.size(),
				roots.size());
		for (SNode expectedRoot : expectedRoots) {
			assertTrue("The list of returned roots does not contain expected root '" + expectedRoot.getId() + "'.",
					roots.contains(expectedRoot));
		}
	}

	/**
	 * Tests that the leaf nodes are returned correctly.
	 */
	@Test
	public void testGetLeafs() {
		List<SNode> expectedLeafs = null;
		List<SNode> leafs = null;
		SGraph graph = null;

		// test 1
		graph = TestHelper.createGraph_Tree();
		setFixture(graph);
		expectedLeafs = new ArrayList<>();
		expectedLeafs.add(graph.getNode("node3"));
		expectedLeafs.add(graph.getNode("node6"));
		expectedLeafs.add(graph.getNode("node5"));
		expectedLeafs.add(graph.getNode("node7"));
		leafs = getFixture().getLeafs();
		assertEquals("The expected number of leafs are not the same, as the returned number", expectedLeafs.size(),
				leafs.size());
		for (SNode expectedLeaf : expectedLeafs) {
			assertTrue("The list of returned roots does not contain expected leaf '" + expectedLeaf.getId() + "'.",
					leafs.contains(expectedLeaf));
		}

		// test 2
		graph = TestHelper.createGraph_DAG();
		setFixture(graph);
		expectedLeafs = new ArrayList<>();
		expectedLeafs.add(graph.getNode("node3"));
		expectedLeafs.add(graph.getNode("node6"));
		leafs = getFixture().getLeafs();
		assertEquals("The expected number of leafs are not the same, as the returned number", expectedLeafs.size(),
				leafs.size());
		for (SNode expectedLeaf : expectedLeafs) {
			assertTrue("The list of returned leafs does not contain expected leaf '" + expectedLeaf.getId() + "'.",
					leafs.contains(expectedLeaf));
		}

		// test 3
		graph = TestHelper.createGraph_Cycle();
		this.setFixture(graph);
		expectedLeafs = new ArrayList<>();
		expectedLeafs.add(graph.getNode("node3"));
		leafs = getFixture().getLeafs();
		assertEquals("The expected number of leafs are not the same, as the returned number", expectedLeafs.size(),
				leafs.size());
		for (SNode expectedLeaf : expectedLeafs) {
			assertTrue("The list of returned roots does not contain expected leaf '" + expectedLeaf.getId() + "'.",
					leafs.contains(expectedLeaf));
		}
	}

	/**
	 * Tests whether the method {@link SGraph#getLayerByName(String)} returns
	 * the corrct values.
	 **/
	@Test
	public void testGetLayersByName() {
		SLayer layer = SaltFactory.createSLayer();
		layer.setName("one");
		getFixture().addLayer(layer);
		layer = SaltFactory.createSLayer();
		layer.setName("two");
		getFixture().addLayer(layer);
		layer = SaltFactory.createSLayer();
		layer.setName("one");
		getFixture().addLayer(layer);
		layer = SaltFactory.createSLayer();
		layer.setName("three");
		getFixture().addLayer(layer);
		assertEquals(2, getFixture().getLayerByName("one").size());
		assertEquals(1, getFixture().getLayerByName("two").size());
		assertEquals(1, getFixture().getLayerByName("three").size());
	}

	/**
	 * Tests whether the method {@link SGraph#getLayerByName(String)} returns
	 * the corrct values.
	 **/
	@Test
	public void testGetNodesByName() {
		SNode node = SaltFactory.createSNode();
		node.setName("one");
		getFixture().addNode(node);
		node = SaltFactory.createSNode();
		node.setName("two");
		getFixture().addNode(node);
		node = SaltFactory.createSNode();
		node.setName("one");
		getFixture().addNode(node);
		node = SaltFactory.createSNode();
		node.setName("three");
		getFixture().addNode(node);
		assertEquals(2, getFixture().getNodesByName("one").size());
		assertEquals(1, getFixture().getNodesByName("two").size());
		assertEquals(1, getFixture().getNodesByName("three").size());
	}

	/**
	 * Tests whether the method {@link SGraph#getLayerByName(String)} returns
	 * the corrct values.
	 **/
	@Test
	public void testGetRelationsByName() {
		SNode node = SaltFactory.createSNode();
		getFixture().addNode(node);

		SRelation rel = SaltFactory.createSRelation();
		rel.setSource(node);
		rel.setTarget(node);
		rel.setName("one");
		getFixture().addRelation(rel);

		rel = SaltFactory.createSRelation();
		rel.setName("two");
		rel.setSource(node);
		rel.setTarget(node);
		getFixture().addRelation(rel);

		rel = SaltFactory.createSRelation();
		rel.setSource(node);
		rel.setTarget(node);
		rel.setName("one");
		getFixture().addRelation(rel);

		rel = SaltFactory.createSRelation();
		rel.setSource(node);
		rel.setTarget(node);
		rel.setName("three");
		getFixture().addRelation(rel);

		assertEquals(2, getFixture().getRelationsByName("one").size());
		assertEquals(1, getFixture().getRelationsByName("two").size());
		assertEquals(1, getFixture().getRelationsByName("three").size());
	}
}
