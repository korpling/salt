package org.corpus_tools.salt.common.impl.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.exceptions.SaltParameterException;

public class TestUtils {

	/** Tests whether returned graph is of type {@link SDocumentGraph}. **/
	public static void testSetGetGraph(SNode fixture) {
		try {
			fixture.setGraph(SaltFactory.createSCorpusGraph());
			fail();
		} catch (SaltParameterException e) {
		}
		fixture.setGraph(SaltFactory.createSDocumentGraph());
		assertTrue(fixture.getGraph() instanceof SDocumentGraph);
	}

	/** Tests whether returned graph is of type {@link SDocumentGraph}. **/
	public static void testSetGetGraph(SRelation<? extends SNode, ? extends SNode> fixture) {
		try {
			fixture.setGraph(SaltFactory.createSCorpusGraph());
			fail();
		} catch (SaltParameterException e) {
		}
		SDocumentGraph graph = SaltFactory.createSDocumentGraph();
		if (fixture.getSource() != null) {
			graph.addNode(fixture.getSource());
		}
		if (fixture.getTarget() != null) {
			graph.addNode(fixture.getTarget());
		}
		fixture.setGraph(graph);
		assertTrue(fixture.getGraph() instanceof SDocumentGraph);
	}
}
