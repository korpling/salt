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
package org.corpus_tools.salt.core.impl;

import static org.junit.Assert.assertEquals;

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
	 * Tests whether the method {@link SGraph#getLayerByName(String)} returns
	 * the corrct values.
	 **/
	@Test
	public void testGetLayersByName() {
		SLayer layer = SaltFactory.createSLayer();
		layer.setName("one");
		getFixture().add(layer);
		layer = SaltFactory.createSLayer();
		layer.setName("two");
		getFixture().add(layer);
		layer = SaltFactory.createSLayer();
		layer.setName("one");
		getFixture().add(layer);
		layer = SaltFactory.createSLayer();
		layer.setName("three");
		getFixture().add(layer);
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
		getFixture().add(node);
		node = SaltFactory.createSNode();
		node.setName("two");
		getFixture().add(node);
		node = SaltFactory.createSNode();
		node.setName("one");
		getFixture().add(node);
		node = SaltFactory.createSNode();
		node.setName("three");
		getFixture().add(node);
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
		getFixture().add(node);

		SRelation<SNode, SNode> rel = SaltFactory.createSRelation();
		rel.setSource(node);
		rel.setTarget(node);
		rel.setName("one");
		getFixture().add(rel);

		rel = SaltFactory.createSRelation();
		rel.setName("two");
		rel.setSource(node);
		rel.setTarget(node);
		getFixture().add(rel);

		rel = SaltFactory.createSRelation();
		rel.setSource(node);
		rel.setTarget(node);
		rel.setName("one");
		getFixture().add(rel);

		rel = SaltFactory.createSRelation();
		rel.setSource(node);
		rel.setTarget(node);
		rel.setName("three");
		getFixture().add(rel);

		assertEquals(2, getFixture().getRelationsByName("one").size());
		assertEquals(1, getFixture().getRelationsByName("two").size());
		assertEquals(1, getFixture().getRelationsByName("three").size());
	}
}
