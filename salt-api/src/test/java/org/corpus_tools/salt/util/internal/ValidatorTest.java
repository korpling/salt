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
package org.corpus_tools.salt.util.internal;

import static org.assertj.core.api.Assertions.assertThat;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SCorpusGraph;
import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.common.SPointingRelation;
import org.corpus_tools.salt.common.STextualDS;
import org.corpus_tools.salt.common.STextualRelation;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.util.SaltUtil;
import org.eclipse.emf.common.util.URI;
import org.junit.Before;
import org.junit.Test;

public class ValidatorTest {

	private SDocumentGraph fixture = null;

	@Before
	public void beforeEach() {
		fixture = SaltFactory.createSDocumentGraph();
	}

	@Test
	public void whenValidatingCorpusAndACorpusContainsDocumentAndCorpus_thenInvalid() {
		final SCorpusGraph graph = SaltFactory.createSCorpusGraph();
		graph.createCorpus(URI.createURI("/corpus1/corpus2"));
		graph.createDocument(URI.createURI("/corpus1/doc1"));

		assertThat(SaltUtil.validate(graph).andFindInvalidities().getInvalidities()).hasSize(1);

		// checking the way around (same logical test)
		final SCorpusGraph graph1 = SaltFactory.createSCorpusGraph();
		graph1.createDocument(URI.createURI("/corpus1/doc1"));
		graph1.createCorpus(URI.createURI("/corpus1/corpus2"));

		assertThat(SaltUtil.validate(graph1).andFindInvalidities().getInvalidities()).hasSize(1);
	}

	@Test
	public void whenValidatingAndRelationHasSameSourceAndtarget_thenInvalid() {
		final SPointingRelation rel = SaltFactory.createSPointingRelation();
		final SToken tok = SaltFactory.createSToken();
		rel.setTarget(tok);
		rel.setSource(tok);

		fixture.addNode(tok);
		fixture.addRelation(rel);
		assertThat(SaltUtil.validate(fixture).andFindInvalidities().getInvalidities()).hasSize(1);
	}

	@Test
	public void whenValidatingAndSTextualDSHasNoText_thenInvalid() {
		final STextualDS text = SaltFactory.createSTextualDS();
		text.setText(null);
		fixture.addNode(text);
		assertThat(SaltUtil.validate(fixture).andFindInvalidities().getInvalidities()).hasSize(1);
	}

	@Test
	public void whenValidatingSTextualRelationAndStartIsNotSet_thenThereShouldInvalid() {
		final STextualDS text = SaltFactory.createSTextualDS();
		text.setText("");
		final SToken tok = SaltFactory.createSToken();
		fixture.addNode(text);
		fixture.addNode(tok);

		final STextualRelation rel = SaltFactory.createSTextualRelation();
		rel.setSource(tok);
		rel.setTarget(text);
		fixture.addRelation(rel);

		assertThat(SaltUtil.validate(fixture).andFindInvalidities().getInvalidities()).hasSize(2);
	}

	@Test
	public void whenValidatingSTextualRelationAndStartIsSmallerThanTextSize_thenInvalid() {
		final STextualDS text = SaltFactory.createSTextualDS();
		text.setText("");
		final SToken tok = SaltFactory.createSToken();
		fixture.addNode(text);
		fixture.addNode(tok);

		final STextualRelation rel = SaltFactory.createSTextualRelation();
		rel.setStart(-1);
		rel.setSource(tok);
		rel.setTarget(text);
		fixture.addRelation(rel);

		assertThat(SaltUtil.validate(fixture).andFindInvalidities().getInvalidities()).hasSize(2);
	}

	@Test
	public void whenRepairSTextualRelationAndStartIsSmallerThanTextSize_thenValid() {
		final STextualDS text = SaltFactory.createSTextualDS();
		text.setText("");
		final SToken tok = SaltFactory.createSToken();
		fixture.addNode(text);
		fixture.addNode(tok);

		final STextualRelation rel = SaltFactory.createSTextualRelation();
		rel.setStart(-1);
		rel.setEnd(0);
		rel.setSource(tok);
		rel.setTarget(text);
		fixture.addRelation(rel);

		assertThat(SaltUtil.validate(fixture).andRepairInvalidities().getInvalidities()).hasSize(1);
		assertThat(SaltUtil.validate(fixture).andFindInvalidities().getInvalidities()).hasSize(0);
	}

	@Test
	public void whenValidatingSTextualRelationAndStartIsBiggerThanTextSize_thenValid() {
		final STextualDS text = SaltFactory.createSTextualDS();
		text.setText("");
		final SToken tok = SaltFactory.createSToken();
		fixture.addNode(text);
		fixture.addNode(tok);

		final STextualRelation rel = SaltFactory.createSTextualRelation();
		rel.setStart(1);
		rel.setEnd(1);
		rel.setSource(tok);
		rel.setTarget(text);
		fixture.addRelation(rel);

		assertThat(SaltUtil.validate(fixture).andFindInvalidities().getInvalidities()).hasSize(2);
	}

	@Test
	public void whenValidatingSTextualRelationAndStartIsBiggerThanEnd_thenValid() {
		final STextualDS text = SaltFactory.createSTextualDS();
		text.setText("text");
		final SToken tok = SaltFactory.createSToken();
		fixture.addNode(text);
		fixture.addNode(tok);

		final STextualRelation rel = SaltFactory.createSTextualRelation();
		rel.setStart(2);
		rel.setEnd(1);
		rel.setSource(tok);
		rel.setTarget(text);
		fixture.addRelation(rel);

		assertThat(SaltUtil.validate(fixture).andFindInvalidities().getInvalidities()).hasSize(1);
	}

	@Test
	public void whenValidatingSTextualRelationAndEndIsBiggerThanTextSize_thenInvalid() {
		final STextualDS text = SaltFactory.createSTextualDS();
		text.setText("");
		final SToken tok = SaltFactory.createSToken();
		fixture.addNode(text);
		fixture.addNode(tok);

		final STextualRelation rel = SaltFactory.createSTextualRelation();
		rel.setStart(0);
		rel.setEnd(2);
		rel.setSource(tok);
		rel.setTarget(text);
		fixture.addRelation(rel);

		assertThat(SaltUtil.validate(fixture).andFindInvalidities().getInvalidities()).hasSize(1);
	}

	@Test
	public void whenValidatingSTextualRelationAndEndIsSmallerThan0_thenInvalid() {
		final STextualDS text = SaltFactory.createSTextualDS();
		text.setText("");
		final SToken tok = SaltFactory.createSToken();
		fixture.addNode(text);
		fixture.addNode(tok);

		final STextualRelation rel = SaltFactory.createSTextualRelation();
		rel.setStart(0);
		rel.setEnd(-1);
		rel.setSource(tok);
		rel.setTarget(text);
		fixture.addRelation(rel);

		assertThat(SaltUtil.validate(fixture).andFindInvalidities().getInvalidities()).hasSize(2);
	}

	@Test
	public void whenRepairingSTextualRelationAndEndIsBiggerThanTextSize_thenValid() {
		final STextualDS text = SaltFactory.createSTextualDS();
		text.setText("");
		final SToken tok = SaltFactory.createSToken();
		fixture.addNode(text);
		fixture.addNode(tok);

		final STextualRelation rel = SaltFactory.createSTextualRelation();
		rel.setStart(0);
		rel.setEnd(2);
		rel.setSource(tok);
		rel.setTarget(text);
		fixture.addRelation(rel);

		assertThat(SaltUtil.validate(fixture).andRepairInvalidities().getInvalidities()).hasSize(1);
		assertThat(SaltUtil.validate(fixture).andFindInvalidities().getInvalidities()).hasSize(0);
	}
}
