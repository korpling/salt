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
package de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.impl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SDocument;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;

public class SDocumentTest {

	protected SDocument fixture = null;

	public void setFixture(SDocument fixture) {
		this.fixture = fixture;
	}

	protected SDocument getFixture() {
		return fixture;
	}

	@Before
	public void setUp() throws Exception {
		setFixture(SaltFactory.createSDocument());
	}

	@Test
	public void testGetSDocumentGraphLocation() {
		assertNull(getFixture().getDocumentGraphLocation());
		File file = new File("/home/saltnpepper/bla.salt");
		URI graphLocation = URI.createFileURI(file.getAbsolutePath());
		this.getFixture().setDocumentGraphLocation(graphLocation);

		assertEquals(graphLocation, this.getFixture().getDocumentGraphLocation());
	}
	
	/**
	 * Tests whether the getter and setter of document structure are correct.
	 */
	@Test
	public void testSetGetDocumentStructure(){
		assertNull(getFixture().getDocumentGraph());
		SDocumentGraph graph= SaltFactory.createSDocumentGraph();
		getFixture().setDocumentGraph(graph);
		assertEquals(graph, getFixture().getDocumentGraph());
	}

	// @Test
	// public void testSaveSDocumentGraph__URI() {
	// SampleGenerator.createSDocumentStructure(this.getFixture());
	// File tmpFile = new File(System.getProperty("java.io.tmpdir") +
	// "/testDoc." + SaltUtil.FILE_ENDING_SALT_XML);
	//
	// URI tmpUri = URI.createFileURI(tmpFile.getAbsolutePath());
	// SDocumentGraph template = this.getFixture().getDocumentGraph();
	// this.getFixture().saveDocumentGraph(tmpUri);
	//
	// SDocument sDocument = SaltFactory.createSDocument();
	// sDocument.loadDocumentGraph(tmpUri);
	// assertEquals("differences: " +
	// template.differences(sDocument.getDocumentGraph()), template,
	// sDocument.getDocumentGraph());
	// }
} // SDocumentTest
