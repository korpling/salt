package org.corpus_tools.salt.extensions.notification.graph.Tests;

import static org.junit.Assert.assertTrue;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SCorpusGraph;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.common.SaltProject;
import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.extensions.notification.Listener;
import org.corpus_tools.salt.extensions.notification.SaltNotificationFactory;
import org.corpus_tools.salt.graph.GRAPH_ATTRIBUTES;
import org.corpus_tools.salt.impl.SaltFactoryImpl;
import org.corpus_tools.salt.samples.SampleGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests if certain assumptions about the type hierarchy are still valid when
 * using Salt Common (and Core) classes with notification delegates.
 */
public class SaltCommonsNotificationTest {

    private SaltNotificationFactory factory;

    @Before
    public void setUp() {
        factory = new SaltNotificationFactory();
        SaltFactory.setFactory(factory);

    }

    /**
     * When adding nodes to a document graph, the graph linked with the resulting
     * nodes should be of type {@link SDocumentGraph} (and not of the delegates
     * type).
     */
    @Test
    public void testLinkedGraph() {
        factory.addListener(new Listener() {
            @Override
            public void notify(NOTIFICATION_TYPE type, GRAPH_ATTRIBUTES attribute, Object oldValue, Object newValue,
                    Object container) {
                if (newValue instanceof SNode) {
                    // Check that we can get the graph of the value without errors in the
                    // notification callback
                    ((SNode) newValue).getGraph();
                }
            }
        });
        SaltProject project = SampleGenerator.createSaltProject();
        for (SCorpusGraph cg : project.getCorpusGraphs()) {
            for (SDocument doc : cg.getDocuments()) {

                assertTrue(doc.getGraph() instanceof SCorpusGraph);

                for (SNode n : doc.getDocumentGraph().getNodes()) {
                    assertTrue(n.getGraph() instanceof SDocumentGraph);
                }
            }
        }

    }

    @After
    public void after() {
        // Reset to default factory
        SaltFactory.setFactory(new SaltFactoryImpl());
    }

}