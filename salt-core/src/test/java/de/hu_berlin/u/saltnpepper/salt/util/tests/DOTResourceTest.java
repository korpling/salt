/**
 * Copyright 2009 Humboldt University of Berlin, INRIA.
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
package de.hu_berlin.u.saltnpepper.salt.util.tests;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.common.SaltProject;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusGraph;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SDocument;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.samples.SampleGenerator;
import de.hu_berlin.u.saltnpepper.salt.util.SaltUtil;

public class DOTResourceTest {

	private URI getTmpDir() {
		File tmpDir = new File(System.getProperty("java.io.tmpdir") + "/saltTest/DOTResourceTest/");
		tmpDir.mkdirs();
		URI tmpUri = URI.createFileURI(tmpDir.getAbsolutePath());
		return (tmpUri);
	}

	/**
	 * Test the storing of a {@link SDocumentGraph}. Only tests, if a file at
	 * correct location was created.
	 */
	@Test
	public void testSave_SDocumentGraph() {
		URI uri = getTmpDir().appendSegment("sDocument");

		String docName = "doc1";
		SDocument sDocument = SaltFactory.createSDocument();
		sDocument.setName(docName);
		SampleGenerator.createSDocumentStructure(sDocument);

		SaltUtil.save_DOT(sDocument, uri);
		assertTrue(new File(uri.toFileString()).exists());
		assertTrue(new File(uri.toFileString()).isDirectory());
		assertTrue(new File(uri.appendSegment(docName).appendFileExtension(SaltUtil.FILE_ENDING_DOT).toFileString()).exists());

		uri = getTmpDir().appendSegment(docName).appendFileExtension(SaltUtil.FILE_ENDING_DOT);
		SaltUtil.save_DOT(sDocument, uri);
		assertTrue(new File(uri.toFileString()).exists());
	}

	/**
	 * Test the storing of a {@link SCorpusGraph}. Only tests, if a file at
	 * correct location was created.
	 */
	@Test
	public void testSave_SCorpusGraph() {
		URI uri = getTmpDir().appendSegment("sCorpusGraph");

		SCorpusGraph sCorpGraph = SampleGenerator.createCorpusStructure();

		SaltUtil.save_DOT(sCorpGraph, uri);
		assertTrue(new File(uri.appendSegment("rootCorpus").appendFileExtension(SaltUtil.FILE_ENDING_DOT).toFileString()).exists());
	}

	/**
	 * Test the storing of a {@link SCorpusGraph}. Only tests, if a file at
	 * correct location was created.
	 */
	@Test
	public void testSave_SProject() {
		URI uri = getTmpDir().appendSegment("sProject");

		SaltProject saltProject = SampleGenerator.createSaltProject();

		SaltUtil.save_DOT(saltProject, uri);
		assertTrue(new File(uri.appendSegment("rootCorpus").appendFileExtension(SaltUtil.FILE_ENDING_DOT).toFileString()).exists());
		assertTrue(new File(uri.appendSegment("rootCorpus").appendSegment("subCorpus1").appendSegment("doc1").appendFileExtension(SaltUtil.FILE_ENDING_DOT).toFileString()).exists());
		assertTrue(new File(uri.appendSegment("rootCorpus").appendSegment("subCorpus1").appendSegment("doc2").appendFileExtension(SaltUtil.FILE_ENDING_DOT).toFileString()).exists());
		assertTrue(new File(uri.appendSegment("rootCorpus").appendSegment("subCorpus2").appendSegment("doc3").appendFileExtension(SaltUtil.FILE_ENDING_DOT).toFileString()).exists());
		assertTrue(new File(uri.appendSegment("rootCorpus").appendSegment("subCorpus2").appendSegment("doc4").appendFileExtension(SaltUtil.FILE_ENDING_DOT).toFileString()).exists());
	}

	/**
	 * Test the storing of a {@link SaltProject} with 2 {@link SCorpusGraph}
	 * objects. Only tests, if a file at correct location. was created.
	 */
	@Test
	public void testSave_SProject2() {
		URI uri = getTmpDir().appendSegment("sProject2");

		SaltProject saltProject = SampleGenerator.createSaltProject();
		saltProject.addCorpusGraph(SampleGenerator.createCorpusStructure());
		SaltUtil.save_DOT(saltProject, uri);
		assertTrue(new File(uri.appendSegment("0").appendFileExtension(SaltUtil.FILE_ENDING_DOT).toFileString()).exists());
		assertTrue(new File(uri.appendSegment("0").appendSegment("rootCorpus").appendSegment("subCorpus1").appendSegment("doc1").appendFileExtension(SaltUtil.FILE_ENDING_DOT).toFileString()).exists());
		assertTrue(new File(uri.appendSegment("0").appendSegment("rootCorpus").appendSegment("subCorpus1").appendSegment("doc2").appendFileExtension(SaltUtil.FILE_ENDING_DOT).toFileString()).exists());
		assertTrue(new File(uri.appendSegment("0").appendSegment("rootCorpus").appendSegment("subCorpus2").appendSegment("doc3").appendFileExtension(SaltUtil.FILE_ENDING_DOT).toFileString()).exists());
		assertTrue(new File(uri.appendSegment("0").appendSegment("rootCorpus").appendSegment("subCorpus2").appendSegment("doc4").appendFileExtension(SaltUtil.FILE_ENDING_DOT).toFileString()).exists());
	}
}
