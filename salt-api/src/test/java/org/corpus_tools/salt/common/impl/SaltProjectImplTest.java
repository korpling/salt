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
package org.corpus_tools.salt.common.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SCorpusGraph;
import org.corpus_tools.salt.common.SaltProject;
import org.junit.Before;
import org.junit.Test;

public class SaltProjectImplTest {

	private SaltProject fixture = null;

	public SaltProject getFixture() {
		return fixture;
	}

	public void setFixture(SaltProject fixture) {
		this.fixture = fixture;
	}

	@Before
	public void setUp() throws Exception {
		setFixture(SaltFactory.createSaltProject());
	}

	/**
	 * Checks whether name is set and get correctly.
	 */
	@Test
	public void testSetGetName() {
		assertNull(getFixture().getName());
		String name = "myProject";
		getFixture().setName(name);
		assertEquals(name, getFixture().getName());
	}

	/**
	 * Checks whether a {@link SCorpusGraph} object is correctly added.
	 */
	@Test
	public void testAddGetCorpusGraph() {
		assertNotNull(getFixture().getCorpusGraphs());
		assertEquals(0, getFixture().getCorpusGraphs().size());

		SCorpusGraph graph1 = SaltFactory.createSCorpusGraph();
		SCorpusGraph graph2 = SaltFactory.createSCorpusGraph();

		getFixture().add(graph1);
		assertEquals(1, getFixture().getCorpusGraphs().size());
		getFixture().add(graph2);
		assertEquals(2, getFixture().getCorpusGraphs().size());
	}

	/**
	 * Checks whether a {@link SCorpusGraph} object is correctly removed.
	 */
	@Test
	public void testRemoveCorpusGraph() {
		SCorpusGraph graph1 = SaltFactory.createSCorpusGraph();
		SCorpusGraph graph2 = SaltFactory.createSCorpusGraph();

		getFixture().add(graph1);
		assertEquals(1, getFixture().getCorpusGraphs().size());
		getFixture().add(graph2);
		assertEquals(2, getFixture().getCorpusGraphs().size());
		getFixture().removeCorpusGraph(graph1);
		assertEquals(1, getFixture().getCorpusGraphs().size());

		// try to remove a graph twice
		getFixture().removeCorpusGraph(graph1);
		assertEquals(1, getFixture().getCorpusGraphs().size());

		getFixture().removeCorpusGraph(graph2);
		assertEquals(0, getFixture().getCorpusGraphs().size());
	}

	/**
	 * Checks the double chaining between corpus graph and Salt project.
	 */
	@Test
	public void testCorpusGraph_DoubleChaining() {
		SCorpusGraph graph1 = SaltFactory.createSCorpusGraph();
		SCorpusGraph graph2 = SaltFactory.createSCorpusGraph();

		assertNull(graph1.getSaltProject());
		getFixture().add(graph1);
		assertEquals(getFixture(), graph1.getSaltProject());
		getFixture().add(graph2);
		assertEquals(getFixture(), graph2.getSaltProject());
		getFixture().removeCorpusGraph(graph1);
		assertNull(graph1.getSaltProject());
		assertEquals(getFixture(), graph2.getSaltProject());
		getFixture().removeCorpusGraph(graph2);
		assertNull(graph2.getSaltProject());
	}

	/** Testst the creation of a corpus graph. **/
	@Test
	public void testCreateCorpusGraph() {
		assertEquals(0, getFixture().getCorpusGraphs().size());
		assertNotNull(getFixture().createCorpusGraph());
		assertEquals(1, getFixture().getCorpusGraphs().size());
	}
}