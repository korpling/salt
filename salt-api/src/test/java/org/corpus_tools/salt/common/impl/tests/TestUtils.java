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
