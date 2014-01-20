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
package de.hu_berlin.german.korpling.saltnpepper.salt.tests;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.junit.Test;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.samples.SampleGenerator;
import junit.framework.TestCase;

public class SaltFactoryImplTest extends TestCase 
{
	public static final String FILE_RESOURCE_DIR_GENERAL= "./src/test/resources/";
	public static final String FILE_RESOURCE_DIR= "./src/test/resources/SaltFactory/";
	private SaltFactory fixture= null;

	public void setFixture(SaltFactory fixture) {
		this.fixture = fixture;
	}

	public SaltFactory getFixture() {
		return fixture;
	}
	
	@Override
	public void setUp()
	{
		this.setFixture(SaltFactory.eINSTANCE);
	}
	
	public void testLoadSaltProject()
	{
		
	}
	
	/**
	 * Tests whether computation of global id works correctly.
	 */
	@Test
	public void testCreateGetGlobalId(){
		SaltProject project= SaltFactory.eINSTANCE.createSaltProject();
		project.getSCorpusGraphs().add(SaltFactory.eINSTANCE.createSCorpusGraph());
		project.getSCorpusGraphs().add(SaltFactory.eINSTANCE.createSCorpusGraph());
		
		SCorpus sCorpus= SaltFactory.eINSTANCE.createSCorpus();
		sCorpus.setSName("corpus1");
		project.getSCorpusGraphs().get(0).addSNode(sCorpus);
		
		SDocument sDocument = SaltFactory.eINSTANCE.createSDocument();
		sDocument.setSName("document1");
		project.getSCorpusGraphs().get(0).addSDocument(sCorpus, sDocument);

		assertEquals("salt:/0/corpus1/document1", getFixture().createGlobalId(sDocument.getSElementId()));
		assertEquals("salt:/0/corpus1/document1", getFixture().getGlobalId(sDocument.getSElementId()));
	}
	
	/**
	 * Tests the loading of a {@link SCorpusGraph} in a SaltXML file containing a {@link SaltProject} object.
	 * This method tests: 
	 * <ol>
	 * <li>the loading of a graph in a SaltProject file containing no {@link SCorpusGraph} object</li>
	 * <li>the loading of a graph in a SaltProject file containing exactly one empty {@link SCorpusGraph} object</li>
	 * <li>the loading of a graph in a SaltProject file containing more than one empty {@link SCorpusGraph} objects</li>
	 * </ol> 
	*/
	public void testLoadSCorpusGraph__URI() 
	{
		SCorpusGraph sCorpusGraph= null;
		
		//case1
		File testFile= new File(FILE_RESOURCE_DIR+ "case2/"+ SaltFactory.FILE_SALT_PROJECT);
		assertTrue("Cannot run test, because file does not exist '"+testFile.getAbsolutePath()+"'.", testFile.exists());
		try {
			this.getFixture().loadSCorpusGraph(URI.createFileURI(testFile.getAbsolutePath()));
			fail("Shall throw an exception");
		} catch (Exception e) 
		{		}
		
		//case2
		testFile= new File(FILE_RESOURCE_DIR+ "case3/"+ SaltFactory.FILE_SALT_PROJECT);
		assertTrue("Cannot run test, because file does not exist '"+testFile.getAbsolutePath()+"'.", testFile.exists());
		sCorpusGraph= SaltFactory.eINSTANCE.loadSCorpusGraph(URI.createFileURI(testFile.getAbsolutePath()));
		assertEquals("mySCorpusGraph1", sCorpusGraph.getSName());
		
		//case3
		testFile= new File(FILE_RESOURCE_DIR+ "case4/"+ SaltFactory.FILE_SALT_PROJECT);
		assertTrue("Cannot run test, because file does not exist '"+testFile.getAbsolutePath()+"'.", testFile.exists());
		sCorpusGraph= SaltFactory.eINSTANCE.loadSCorpusGraph(URI.createFileURI(testFile.getAbsolutePath()));
		assertEquals("mySCorpusGraph1", sCorpusGraph.getSName());
	}

	/**
	 * Tests the loading of a {@link SCorpusGraph} in a SaltXML file containing a {@link SaltProject} object,
	 * containing three {@link SCorpusGraph} objects.
	 */
	public void testLoadSCorpusGraph__URI_Integer() {
		SCorpusGraph sCorpusGraph= null;
		
		File testFile= new File(FILE_RESOURCE_DIR+ "case4/"+ SaltFactory.FILE_SALT_PROJECT);
		assertTrue("Cannot run test, because file does not exist '"+testFile.getAbsolutePath()+"'.", testFile.exists());
		
		sCorpusGraph= SaltFactory.eINSTANCE.loadSCorpusGraph(URI.createFileURI(testFile.getAbsolutePath()), 0);
		assertEquals("mySCorpusGraph1", sCorpusGraph.getSName());
		
		sCorpusGraph= SaltFactory.eINSTANCE.loadSCorpusGraph(URI.createFileURI(testFile.getAbsolutePath()), 1);
		assertEquals("mySCorpusGraph2", sCorpusGraph.getSName());
		
		sCorpusGraph= SaltFactory.eINSTANCE.loadSCorpusGraph(URI.createFileURI(testFile.getAbsolutePath()), 2);
		assertEquals("mySCorpusGraph3", sCorpusGraph.getSName());
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSDocumentStructure(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument, org.eclipse.emf.common.util.URI) <em>Load SDocument Structure</em>}' operation.
	 * Checks loading of just the document structure of one document.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSDocumentStructure(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument, org.eclipse.emf.common.util.URI)
	 */
	public void testLoadSDocumentGraph_URI() 
	{
		File sDocumentFile= new File(FILE_RESOURCE_DIR+ "case5/doc1."+SaltFactory.FILE_ENDING_SALT);
		URI sDocumentURI= URI.createFileURI(sDocumentFile.getAbsolutePath());
		SDocument sDocument= SaltFactory.eINSTANCE.createSDocument();
		sDocument.setSDocumentGraph(this.getFixture().loadSDocumentGraph(sDocumentURI));
				
		SDocument template_sDocument= SaltFactory.eINSTANCE.createSDocument();
		SampleGenerator.createSDocumentStructure(template_sDocument);
		
		assertEquals("differences: "+ template_sDocument.differences(sDocument),template_sDocument, sDocument);
	}
	
}
