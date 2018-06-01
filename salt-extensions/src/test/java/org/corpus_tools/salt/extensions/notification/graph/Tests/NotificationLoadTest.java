package org.corpus_tools.salt.extensions.notification.graph.Tests;

import static org.junit.Assert.*;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SCorpusGraph;
import org.corpus_tools.salt.common.SaltProject;
import org.corpus_tools.salt.common.impl.SCorpusGraphImpl;
import org.corpus_tools.salt.extensions.notification.SaltNotificationFactory;
import org.corpus_tools.salt.impl.SaltFactoryImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NotificationLoadTest {
	
	private SaltNotificationFactory fixture = null;

	@Before
	public void setUp() throws Exception {
		Helper.ProjectBuilder.buildPersistedTestableSaltProject();
		setFixture(new SaltNotificationFactory());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testLoadNotificationProject() {
		// Set SaltFactory to use fixture
		SaltFactory.setFactory(getFixture());
		assertTrue(SaltFactory.getFactory() == getFixture());
		SaltProject project = SaltFactory.createSaltProject();
		project.loadCorpusStructure(Helper.ProjectBuilder.getProjectURI());
		assertEquals(1, project.getCorpusGraphs().size());
		SCorpusGraph corpusGraph = project.getCorpusGraphs().get(0);
		assertTrue(corpusGraph instanceof SCorpusGraphImpl);
		assertEquals(3, corpusGraph.getDocuments().size());
	}
	
	@Test
	public final void testLoadDefaultProject() {
		assertTrue(SaltFactory.getFactory() instanceof SaltFactoryImpl);
		assertFalse(SaltFactory.getFactory() == getFixture());
		SaltProject project = SaltFactory.createSaltProject();
		project.loadCorpusStructure(Helper.ProjectBuilder.getProjectURI());
		assertEquals(1, project.getCorpusGraphs().size());
		SCorpusGraph corpusGraph = project.getCorpusGraphs().get(0);
		assertTrue(corpusGraph instanceof SCorpusGraphImpl);
		assertEquals(3, corpusGraph.getDocuments().size());
	}

	/**
	 * @return the fixture
	 */
	private final SaltNotificationFactory getFixture() {
		return fixture;
	}

	/**
	 * @param fixture the fixture to set
	 */
	private final void setFixture(SaltNotificationFactory fixture) {
		this.fixture = fixture;
	}

}
