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
package org.corpus_tools.salt.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Collection;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SCorpus;
import org.corpus_tools.salt.common.SCorpusGraph;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.common.SaltProject;
import org.corpus_tools.salt.core.SAnnotation;
import org.corpus_tools.salt.core.SMetaAnnotation;
import org.corpus_tools.salt.util.SaltUtil;
import org.eclipse.emf.common.util.URI;
import org.junit.Test;

public class SaltUtilTest {
	/**
	 * Checks if {@link SMetaAnnotation} objects are moved correctly from one
	 * {@link SMetaAnnotatableElement} object to another
	 * {@link SMetaAnnotatableElement} object.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMoveSMetaAnnotations() throws Exception {
		SCorpus sCorp = SaltFactory.createSCorpus();
		SDocument sDoc = SaltFactory.createSDocument();

		String annoName = "metaAnno";
		String annoValue = "metaValue";
		sCorp.createMetaAnnotation(null, annoName, annoValue);

		SaltUtil.moveMetaAnnotations(sCorp, sDoc);

		assertNull(sCorp.getMetaAnnotation(annoName));

		// sDoc contains a SMetaAnnotation
		assertEquals(1, sDoc.getMetaAnnotations().size());
		// the SMetaAnnotation is "metaAnno"
		assertNotNull(sDoc.getMetaAnnotation(annoName));
		assertEquals(annoName, sDoc.getMetaAnnotation(annoName).getName());
		assertEquals(annoValue, sDoc.getMetaAnnotation(annoName).getValue());

		sCorp = SaltFactory.createSCorpus();
		String annoName2 = "metaAnno";
		String annoValue2 = "metaValue_1";
		sCorp.createMetaAnnotation(null, annoName2, annoValue2);

		SaltUtil.moveMetaAnnotations(sCorp, sDoc);

		// assert that there are 2 SMetaAnnotation objects in the target
		// document
		assertEquals(2, sDoc.getMetaAnnotations().size());
		// assert that there is a SMetaAnnotation object with name "metaAnno"
		assertNotNull(sDoc.getMetaAnnotation(annoName2));
		// assert that there is a SMetaAnnotation object with name "metaAnno_1"
		assertEquals(annoName2 + "_1", sDoc.getMetaAnnotation(annoName2 + "_1").getName());
		assertEquals(annoValue2, sDoc.getMetaAnnotation(annoName2 + "_1").getValue());
	}

	/**
	 * Checks if {@link SAnnotation} objects are moved correctly from one
	 * {@link SAnnotatableElement} object to another {@link SAnnotatableElement}
	 * object.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMoveSAnnotations() throws Exception {
		SCorpus sCorp = SaltFactory.createSCorpus();
		SDocument sDoc = SaltFactory.createSDocument();

		String annoName = "anno";
		String annoValue = "value";
		sCorp.createAnnotation(null, annoName, annoValue);

		SaltUtil.moveAnnotations(sCorp, sDoc);

		assertNull(sCorp.getAnnotation(annoName));

		// sDoc contains a SAnnotation
		assertEquals(1, sDoc.getAnnotations().size());
		// the SAnnotation is "metaAnno"
		assertNotNull(sDoc.getAnnotation(annoName));
		assertEquals(annoName, sDoc.getAnnotation(annoName).getName());
		assertEquals(annoValue, sDoc.getAnnotation(annoName).getValue());

		sCorp = SaltFactory.createSCorpus();
		String annoName2 = "anno";
		String annoValue2 = "value_1";
		sCorp.createAnnotation(null, annoName2, annoValue2);

		SaltUtil.moveAnnotations(sCorp, sDoc);

		// assert that there are 2 SAnnotation objects in the target document
		assertEquals(2, sDoc.getAnnotations().size());
		// assert that there is a SAnnotation object with name "metaAnno"
		assertNotNull(sDoc.getAnnotation(annoName2));
		// assert that there is a SAnnotation object with name "metaAnno_1"
		assertEquals(annoName2 + "_1", sDoc.getAnnotation(annoName2 + "_1").getName());
		assertEquals(annoValue2, sDoc.getAnnotation(annoName2 + "_1").getValue());
	}

	/**
	 * Tests whether the path is created correctly
	 */
	@Test
	public void testCreateSaltURI() {
		SaltProject project = SaltFactory.createSaltProject();
		SCorpusGraph graph = SaltFactory.createSCorpusGraph();
		project.addCorpusGraph(graph);

		// test path of corp1
		SCorpus corp1 = SaltFactory.createSCorpus();
		corp1.setName("corp1");
		graph.addNode(corp1);
		URI path = SaltUtil.createSaltURI(corp1.getId());
		assertEquals(URI.createURI("salt:/corp1"), path);

		// test path of corp2
		SCorpus corp2 = graph.createCorpus(corp1, "corp2");
		path = SaltUtil.createSaltURI(corp2.getId());
		assertEquals(URI.createURI("salt:/corp1/corp2"), path);

		// test path of doc1
		SDocument doc1 = graph.createDocument(corp2, "doc1");
		path = SaltUtil.createSaltURI(doc1.getId());
		assertEquals(URI.createURI("salt:/corp1/corp2/doc1"), path);

	}

	/**
	 * Tests whether the unmarahalling of annotations works correctly.
	 */
	@Test
	public void testUnmarshalAnnotation() {
		Collection<String[]> triples = SaltUtil.unmarshalAnnotation("salt::pos=NN");
		assertEquals(1, triples.size());
		assertEquals("salt", triples.iterator().next()[0]);
		assertEquals("pos", triples.iterator().next()[1]);
		assertEquals("NN", triples.iterator().next()[2]);

		triples = SaltUtil.unmarshalAnnotation(" salt  ::  pos  =  NN ");
		assertEquals(1, triples.size());
		assertEquals("salt", triples.iterator().next()[0]);
		assertEquals("pos", triples.iterator().next()[1]);
		assertEquals("NN", triples.iterator().next()[2]);

		triples = SaltUtil.unmarshalAnnotation(" pos  =  NN ");
		assertEquals(1, triples.size());
		assertNull(triples.iterator().next()[0]);
		assertEquals("pos", triples.iterator().next()[1]);
		assertEquals("NN", triples.iterator().next()[2]);

		triples = SaltUtil.unmarshalAnnotation(" pos");
		assertEquals(1, triples.size());
		assertNull(triples.iterator().next()[0]);
		assertEquals("pos", triples.iterator().next()[1]);
		assertNull(triples.iterator().next()[2]);

		triples = SaltUtil.unmarshalAnnotation(" salt :: ");
		assertEquals(1, triples.size());
		assertEquals("salt", triples.iterator().next()[0]);
		assertNull(triples.iterator().next()[1]);
		assertNull(triples.iterator().next()[2]);

		triples = SaltUtil.unmarshalAnnotation(" salt  ::  pos  =  NN ; other  ::  lemma  =  I");
		assertEquals(2, triples.size());
		for (String[] triple : triples) {
			if ("salt".equals(triple[0])) {
				assertEquals("pos", triple[1]);
				assertEquals("NN", triple[2]);
			} else if ("other".equals(triple[0])) {
				assertEquals("lemma", triple[1]);
				assertEquals("I", triple[2]);
			}
		}
	}
}
