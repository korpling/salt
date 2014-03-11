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

import java.io.File;
import java.util.HashSet;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SOrderRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SSpanImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SStructureImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STokenImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.samples.SampleGenerator;

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
	
	public void testGlobalId(){
		SaltProject proj= SaltFactory.eINSTANCE.createSaltProject();
		SCorpusGraph g1= SaltFactory.eINSTANCE.createSCorpusGraph();
		proj.getSCorpusGraphs().add(g1);
		SCorpus c11= SaltFactory.eINSTANCE.createSCorpus();
		c11.setSName("c1");
		g1.addSNode(c11);
		SDocument d11= g1.createSDocument(c11, "d1");
		
		SCorpusGraph g2= SaltFactory.eINSTANCE.createSCorpusGraph();
		proj.getSCorpusGraphs().add(g2);
		SCorpus c21= SaltFactory.eINSTANCE.createSCorpus();
		c21.setSName("c1");
		g2.addSNode(c21);
		SDocument d21=  g2.createSDocument(c21, "d1");
		
		assertEquals("salt:/0/c1/", getFixture().getGlobalId(c11.getSElementId()));
		assertEquals("salt:/1/c1/", getFixture().getGlobalId(c21.getSElementId()));
		
		assertEquals("salt:/0/c1/d1", getFixture().getGlobalId(d11.getSElementId()));
		assertEquals("salt:/1/c1/d1", getFixture().getGlobalId(d21.getSElementId()));
	}
	
	public void testLoadSaltProject()
	{
		
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
	
	/**
	 * Tests if the conversion works correctly
	 */
	public void testConvertClazzToSTypeName(){
		assertTrue(getFixture().convertClazzToSTypeName(SOrderRelation.class).contains(STYPE_NAME.SORDER_RELATION));
		assertTrue(getFixture().convertClazzToSTypeName(SPointingRelation.class).contains(STYPE_NAME.SPOINTING_RELATION));
		assertTrue(getFixture().convertClazzToSTypeName(SDominanceRelation.class).contains(STYPE_NAME.SDOMINANCE_RELATION));
		assertTrue(getFixture().convertClazzToSTypeName(SSpanningRelation.class).contains(STYPE_NAME.SSPANNING_RELATION));
		
		assertFalse(getFixture().convertClazzToSTypeName(SSpanningRelation.class).contains(STYPE_NAME.SDOMINANCE_RELATION));
		assertFalse(getFixture().convertClazzToSTypeName(SDominanceRelation.class).contains(STYPE_NAME.SSPANNING_RELATION));
		
		assertTrue(getFixture().convertClazzToSTypeName(SToken.class).contains(STYPE_NAME.STOKEN));
		assertTrue(getFixture().convertClazzToSTypeName(SSpan.class).contains(STYPE_NAME.SSPAN));
		assertTrue(getFixture().convertClazzToSTypeName(SStructure.class).contains(STYPE_NAME.SSTRUCTURE));
		
		assertTrue(getFixture().convertClazzToSTypeName(STokenImpl.class).contains(STYPE_NAME.STOKEN));
		assertTrue(getFixture().convertClazzToSTypeName(SSpanImpl.class).contains(STYPE_NAME.SSPAN));
		assertTrue(getFixture().convertClazzToSTypeName(SStructureImpl.class).contains(STYPE_NAME.SSTRUCTURE));
	}
}
