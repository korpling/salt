package org.corpus_tools.salt.extensions.notification.graph.Tests;

import static org.junit.Assert.*;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SCorpusGraph;
import org.corpus_tools.salt.common.SaltProject;
import org.corpus_tools.salt.common.impl.SCorpusGraphImpl;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.extensions.notification.SaltNotificationFactory;
import org.corpus_tools.salt.extensions.notification.common.impl.CorpusGraphNotifierImpl;
import org.corpus_tools.salt.extensions.notification.Listener.NOTIFICATION_TYPE;
import org.corpus_tools.salt.extensions.notification.graph.Tests.Helper.MyListener;
import org.corpus_tools.salt.graph.GRAPH_ATTRIBUTES;
import org.corpus_tools.salt.graph.GraphFactory;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.impl.SaltFactoryImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for loading {@link SaltProject}s that notify.
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
public class NotificationLoadTest {
	
	private SaltNotificationFactory fixture = null;

	@SuppressWarnings("javadoc")
	@Before
	public void setUp() throws Exception {
		Helper.ProjectBuilder.buildPersistedTestableSaltProject();
		setFixture(new SaltNotificationFactory());
	}

	/**
	 * Tests loading of a notifiying project, and
	 * regression against https://github.com/korpling/salt/issues/130.
	 * 
	 */
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
		corpusGraph.getDocuments().get(0).loadDocumentGraph();
		assertEquals("This is a birthday pony.", corpusGraph.getDocuments().get(0).getDocumentGraph().getTextualDSs().get(0).getText());
	}
	
	/**
	 * Tests loading of a non-notifiying project.
	 */
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
		corpusGraph.getDocuments().get(0).loadDocumentGraph();
		assertEquals("This is a birthday pony.", corpusGraph.getDocuments().get(0).getDocumentGraph().getTextualDSs().get(0).getText());
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
