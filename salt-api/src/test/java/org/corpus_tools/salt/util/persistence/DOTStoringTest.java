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
package org.corpus_tools.salt.util.persistence;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.SaltTestsUtil;
import org.corpus_tools.salt.common.SCorpusGraph;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.common.SaltProject;
import org.corpus_tools.salt.samples.SampleGenerator;
import org.corpus_tools.salt.util.SaltUtil;
import org.eclipse.emf.common.util.URI;
import org.junit.Test;

public class DOTStoringTest {

	/**
	 * Test the storing of a {@link SDocumentGraph}. Only tests, if a file at
	 * correct location was created.
	 */
	@Test
	public void testSave_SDocumentGraph() {
		URI uri = URI.createFileURI(SaltTestsUtil.getTempTestFolder("document").getAbsolutePath());

		String docName = "doc1";
		SDocument sDocument = SaltFactory.createSDocument();
		sDocument.setName(docName);
		SampleGenerator.createDocumentStructure(sDocument);

		SaltUtil.save_DOT(sDocument, uri);
		assertTrue(new File(uri.toFileString()).exists());
		assertTrue(new File(uri.toFileString()).isDirectory());
		assertTrue(new File(uri.appendSegment(docName).appendFileExtension(SaltUtil.FILE_ENDING_DOT).toFileString())
				.exists());

		uri = URI.createFileURI(SaltTestsUtil.getTempTestFolder().getAbsolutePath()).appendSegment(docName)
				.appendFileExtension(SaltUtil.FILE_ENDING_DOT);
		SaltUtil.save_DOT(sDocument, uri);
		assertTrue(new File(uri.toFileString()).exists());
	}

	/**
	 * Test the storing of a {@link SCorpusGraph}. Only tests, if a file at
	 * correct location was created.
	 */
	@Test
	public void testSave_SCorpusGraph() {
		URI uri = URI.createFileURI(SaltTestsUtil.getTempTestFolder("corpusGraph").getAbsolutePath());

		SCorpusGraph sCorpGraph = SampleGenerator.createCorpusStructure();

		SaltUtil.save_DOT(sCorpGraph, uri);
		assertTrue(
				new File(uri.appendSegment("rootCorpus").appendFileExtension(SaltUtil.FILE_ENDING_DOT).toFileString())
						.exists());
	}

	/**
	 * Test the storing of a {@link SCorpusGraph}. Only tests, if a file at
	 * correct location was created.
	 */
	@Test
	public void testSave_SProject() {
		URI uri = URI.createFileURI(SaltTestsUtil.getTempTestFolder("salt_project").getAbsolutePath());

		SaltProject saltProject = SampleGenerator.createSaltProject();

		SaltUtil.save_DOT(saltProject, uri);
		assertTrue(
				new File(uri.appendSegment("rootCorpus").appendFileExtension(SaltUtil.FILE_ENDING_DOT).toFileString())
						.exists());
		assertTrue(new File(uri.appendSegment("rootCorpus").appendSegment("subCorpus1").appendSegment("doc1")
				.appendFileExtension(SaltUtil.FILE_ENDING_DOT).toFileString()).exists());
		assertTrue(new File(uri.appendSegment("rootCorpus").appendSegment("subCorpus1").appendSegment("doc2")
				.appendFileExtension(SaltUtil.FILE_ENDING_DOT).toFileString()).exists());
		assertTrue(new File(uri.appendSegment("rootCorpus").appendSegment("subCorpus2").appendSegment("doc3")
				.appendFileExtension(SaltUtil.FILE_ENDING_DOT).toFileString()).exists());
		assertTrue(new File(uri.appendSegment("rootCorpus").appendSegment("subCorpus2").appendSegment("doc4")
				.appendFileExtension(SaltUtil.FILE_ENDING_DOT).toFileString()).exists());
	}

	/**
	 * Test the storing of a {@link SaltProject} with 2 {@link SCorpusGraph}
	 * objects. Only tests, if a file at correct location. was created.
	 */
	@Test
	public void testSave_SProject2() {
		URI uri = URI.createFileURI(SaltTestsUtil.getTempTestFolder("salt_project2").getAbsolutePath());

		SaltProject saltProject = SampleGenerator.createSaltProject();
		saltProject.addCorpusGraph(SampleGenerator.createCorpusStructure());
		SaltUtil.save_DOT(saltProject, uri);
		assertTrue(
				new File(uri.appendSegment("0").appendFileExtension(SaltUtil.FILE_ENDING_DOT).toFileString()).exists());
		assertTrue(new File(uri.appendSegment("0").appendSegment("rootCorpus").appendSegment("subCorpus1")
				.appendSegment("doc1").appendFileExtension(SaltUtil.FILE_ENDING_DOT).toFileString()).exists());
		assertTrue(new File(uri.appendSegment("0").appendSegment("rootCorpus").appendSegment("subCorpus1")
				.appendSegment("doc2").appendFileExtension(SaltUtil.FILE_ENDING_DOT).toFileString()).exists());
		assertTrue(new File(uri.appendSegment("0").appendSegment("rootCorpus").appendSegment("subCorpus2")
				.appendSegment("doc3").appendFileExtension(SaltUtil.FILE_ENDING_DOT).toFileString()).exists());
		assertTrue(new File(uri.appendSegment("0").appendSegment("rootCorpus").appendSegment("subCorpus2")
				.appendSegment("doc4").appendFileExtension(SaltUtil.FILE_ENDING_DOT).toFileString()).exists());
	}
}
