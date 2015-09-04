package de.hu_berlin.u.saltnpepper.salt.common.impl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.common.SaltProject;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusGraph;

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

		getFixture().addCorpusGraph(graph1);
		assertEquals(1, getFixture().getCorpusGraphs().size());
		getFixture().addCorpusGraph(graph2);
		assertEquals(2, getFixture().getCorpusGraphs().size());
	}

	/**
	 * Checks whether a {@link SCorpusGraph} object is correctly removed.
	 */
	@Test
	public void testRemoveCorpusGraph() {
		SCorpusGraph graph1 = SaltFactory.createSCorpusGraph();
		SCorpusGraph graph2 = SaltFactory.createSCorpusGraph();

		getFixture().addCorpusGraph(graph1);
		assertEquals(1, getFixture().getCorpusGraphs().size());
		getFixture().addCorpusGraph(graph2);
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
		getFixture().addCorpusGraph(graph1);
		assertEquals(getFixture(), graph1.getSaltProject());
		getFixture().addCorpusGraph(graph2);
		assertEquals(getFixture(), graph2.getSaltProject());
		getFixture().removeCorpusGraph(graph1);
		assertNull(graph1.getSaltProject());
		assertEquals(getFixture(), graph2.getSaltProject());
		getFixture().removeCorpusGraph(graph2);
		assertNull(graph2.getSaltProject());
	}
}
