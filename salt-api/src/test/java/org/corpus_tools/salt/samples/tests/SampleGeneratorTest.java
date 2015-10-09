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
package org.corpus_tools.salt.samples.tests;

import static org.junit.Assert.fail;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SCorpusGraph;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.common.SaltProject;
import org.corpus_tools.salt.samples.SampleGenerator;
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

		try {
			SampleGenerator.createCorpusStructure(fixture);
		} catch (Exception e) {
			fail(e.getMessage() + "\n" + e.getCause());
		}
	}

	@Test
	public void testCreateCorpusStructure() {
		try {
			SampleGenerator.createCorpusStructure();
		} catch (Exception e) {
			fail(e.getMessage() + "\n" + e.getCause());
		}
	}

	@Test
	public void testCreateSaltProject() {
		SampleGenerator.createSaltProject();
	}

	@Test
	public void testCreateCorpusStructure_simple() {
		try {
			SampleGenerator.createCorpusStructure_simple();
		} catch (Exception e) {
			fail(e.getMessage() + "\n" + e.getCause());
		}
	}

	@Test
	public void testCreateDialogue_SDocument() {
		SDocument fixture = SaltFactory.createSDocument();

		try {
			SampleGenerator.createDialogue(fixture);
		} catch (Exception e) {
			fail(e.getMessage() + "\n" + e.getCause());
		}
	}

	@Test
	public void testCreatePrimaryData_SDocument() {
		SDocument fixture = SaltFactory.createSDocument();

		try {
			SampleGenerator.createPrimaryData(fixture);
		} catch (Exception e) {
			fail(e.getMessage() + "\n" + e.getCause());
		}
	}

	@Test
	public void testCreatePrimaryData__SDocument_String() {
		SDocument fixtureEN = SaltFactory.createSDocument();
		SDocument fixtureDE = SaltFactory.createSDocument();

		try {
			SampleGenerator.createPrimaryData(fixtureEN, "en");
			SampleGenerator.createPrimaryData(fixtureDE, "de");
		} catch (Exception e) {
			fail(e.getMessage() + "\n" + e.getCause());
		}
	}

	@Test
	public void testCreateTokens_SDocument() {
		SDocument fixture = SaltFactory.createSDocument();

		try {
			SampleGenerator.createTokens(fixture);
		} catch (Exception e) {
			fail(e.getMessage() + "\n" + e.getCause());
		}
	}

	@Test
	public void testCreateTokens__SDocument_STextualDS() {
		SDocument fixture = SaltFactory.createSDocument();
		SampleGenerator.createTokens(fixture);
	}

	@Test
	public void testCreateToken__int_int_STextualDS_SDocument_SLayer() {
		SDocument fixture = SaltFactory.createSDocument();

		try {
			SampleGenerator.createToken(0, 4, SaltFactory.createSTextualDS(), fixture, null);
		} catch (Exception e) {
			fail(e.getMessage() + "\n" + e.getCause());
		}
	}

	@Test
	public void testCreateParallelData__SDocument_boolean() {
		SDocument fixture = SaltFactory.createSDocument();

		try {
			SampleGenerator.createParallelData(fixture, true);
		} catch (Exception e) {
			fail(e.getMessage() + "\n" + e.getCause());
		}
	}

	@Test
	public void testCreateMorphologyAnnotations_SDocument() {
		SDocument fixture = SaltFactory.createSDocument();

		try {
			SampleGenerator.createMorphologyAnnotations(fixture);
		} catch (Exception e) {
			fail(e.getMessage() + "\n" + e.getCause());
		}
	}

	@Test
	public void testCreateInformationStructureSpan_SDocument() {
		SDocument fixture = SaltFactory.createSDocument();

		try {
			SampleGenerator.createInformationStructureSpan(fixture);
		} catch (Exception e) {
			fail(e.getMessage() + "\n" + e.getCause());
		}
	}

	@Test
	public void testCreateInformationStructureAnnotations_SDocument() {
		SDocument fixture = SaltFactory.createSDocument();

		try {
			SampleGenerator.createInformationStructureAnnotations(fixture);
		} catch (Exception e) {
			fail(e.getMessage() + "\n" + e.getCause());
		}
	}

	@Test
	public void testCreateSyntaxStructure_SDocument() {
		SDocument fixture = SaltFactory.createSDocument();

		try {
			SampleGenerator.createSyntaxStructure(fixture);
		} catch (Exception e) {
			fail(e.getMessage() + "\n" + e.getCause());
		}
	}

	@Test
	public void testCreateSyntaxAnnotations_SDocument() {
		SDocument fixture = SaltFactory.createSDocument();

		try {
			SampleGenerator.createSyntaxAnnotations(fixture);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + "\n" + e.getCause());
		}

	}

	@Test
	public void testCreateDependencies_SDocument() {
		SDocument fixture = SaltFactory.createSDocument();

		try {
			SampleGenerator.createDependencies(fixture);
		} catch (Exception e) {
			fail(e.getMessage() + "\n" + e.getCause());
		}
	}

	@Test
	public void testCreateAnaphoricAnnotations_SDocument() {
		SDocument fixture = SaltFactory.createSDocument();

		try {
			SampleGenerator.createAnaphoricAnnotations(fixture);
		} catch (Exception e) {
			fail(e.getMessage() + "\n" + e.getCause());
		}
	}

	@Test
	public void testCreateSDocumentStructure_SDocument() {
		SDocument fixture = SaltFactory.createSDocument();

		try {
			SampleGenerator.createSDocumentStructure(fixture);
		} catch (Exception e) {
			fail(e.getMessage() + "\n" + e.getCause());
		}
	}
}
