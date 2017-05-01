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
package org.corpus_tools.salt.samples;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SCorpusGraph;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.common.SaltProject;
import org.junit.Test;

public class SampleGeneratorTest {

	@Test
	public void testCreateCorpusStructure_saltProject() {
		SaltProject fixture = SaltFactory.createSaltProject();
		SampleGenerator.createCorpusStructure(fixture);
	}

	@Test
	public void testCreateCorpusStructure_SCorpusGraph() {
		SCorpusGraph fixture = SaltFactory.createSCorpusGraph();
		SampleGenerator.createCorpusStructure(fixture);
	}

	@Test
	public void testCreateCorpusStructure() {
		SampleGenerator.createCorpusStructure();
	}

	@Test
	public void testCreateSaltProject() {
		SampleGenerator.createSaltProject();
	}

	@Test
	public void testCreateCorpusStructure_simple() {
		SampleGenerator.createCorpusStructure_simple();
	}

	@Test
	public void testCreateDialogue_SDocument() {
		SDocument fixture = SaltFactory.createSDocument();
		SampleGenerator.createDialogue(fixture);
	}

	@Test
	public void testCreatePrimaryData_SDocument() {
		SDocument fixture = SaltFactory.createSDocument();
		SampleGenerator.createPrimaryData(fixture);
	}

	@Test
	public void testCreatePrimaryData__SDocument_String() {
		SDocument fixtureEN = SaltFactory.createSDocument();
		SDocument fixtureDE = SaltFactory.createSDocument();
		SampleGenerator.createPrimaryData(fixtureEN, "en");
		SampleGenerator.createPrimaryData(fixtureDE, "de");
	}

	@Test
	public void testCreateTokens_SDocument() {
		SDocument fixture = SaltFactory.createSDocument();
		SampleGenerator.createTokens(fixture);
	}

	@Test
	public void testCreateTokens__SDocument_STextualDS() {
		SDocument fixture = SaltFactory.createSDocument();
		SampleGenerator.createTokens(fixture);
	}

	@Test
	public void testCreateParallelData__SDocument_boolean() {
		SDocument fixture = SaltFactory.createSDocument();
		SampleGenerator.createParallelData(fixture, true);
	}

	@Test
	public void testCreateMorphologyAnnotations_SDocument() {
		SDocument fixture = SaltFactory.createSDocument();
		SampleGenerator.createMorphologyAnnotations(fixture);
	}

	@Test
	public void testCreateInformationStructureSpan_SDocument() {
		SDocument fixture = SaltFactory.createSDocument();
		SampleGenerator.createInformationStructureSpan(fixture);
	}

	@Test
	public void testCreateInformationStructureAnnotations_SDocument() {
		SDocument fixture = SaltFactory.createSDocument();
		SampleGenerator.createInformationStructureAnnotations(fixture);
	}

	@Test
	public void testCreateSyntaxStructure_SDocument() {
		SDocument fixture = SaltFactory.createSDocument();
		SampleGenerator.createSyntaxStructure(fixture);
	}

	@Test
	public void testCreateSyntaxAnnotations_SDocument() {
		SDocument fixture = SaltFactory.createSDocument();
		SampleGenerator.createSyntaxAnnotations(fixture);
	}

	@Test
	public void testCreateDependencies_SDocument() {
		SDocument fixture = SaltFactory.createSDocument();
		SampleGenerator.createDependencies(fixture);
	}

	@Test
	public void testCreateAnaphoricAnnotations_SDocument() {
		SDocument fixture = SaltFactory.createSDocument();
		SampleGenerator.createAnaphoricAnnotations(fixture);
	}

	@Test
	public void testCreateSDocumentStructure_SDocument() {
		SDocument fixture = SaltFactory.createSDocument();
		SampleGenerator.createDocumentStructure(fixture);
	}
}
