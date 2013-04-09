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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.DifferenceListener;
import org.custommonkey.xmlunit.IgnoreTextAndAttributeValuesDifferenceListener;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.xml.sax.SAXException;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Salt Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSaltProject(org.eclipse.emf.common.util.URI) <em>Load Salt Project</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSaltProject_GrAF(org.eclipse.emf.common.util.URI, java.util.Properties) <em>Load Salt Project Gr AF</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#differences(java.lang.Object) <em>Differences</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSCorpusGraph_GrAF(org.eclipse.emf.common.util.URI, java.util.Properties) <em>Load SCorpus Graph Gr AF</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSDocumentGraph_GrAF(org.eclipse.emf.common.util.URI, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument, java.util.Properties) <em>Load SDocument Graph Gr AF</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#saveSCorpusGraph_DOT(org.eclipse.emf.common.util.URI, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId) <em>Save SCorpus Graph DOT</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#saveSaltProject(org.eclipse.emf.common.util.URI) <em>Save Salt Project</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#saveSaltProject_DOT(org.eclipse.emf.common.util.URI) <em>Save Salt Project DOT</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#saveSDocumentGraph_DOT(org.eclipse.emf.common.util.URI, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId) <em>Save SDocument Graph DOT</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSCorpusStructure(org.eclipse.emf.common.util.URI) <em>Load SCorpus Structure</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#getSDocumentGraphLocations() <em>Get SDocument Graph Locations</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SaltProjectTest extends TestCase {

	
	public static final String FILE_RESOURCE_DIR= "./src/test/resources/SaltProjectTest/";
	public static final String FILE_TMP_DIR= "./_TMP/";
	
	
	/**
	 * The fixture for this Salt Project test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SaltProject fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SaltProjectTest.class);
	}

	/**
	 * Constructs a new Salt Project test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltProjectTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Salt Project test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SaltProject fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Salt Project test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SaltProject getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SaltCommonFactory.eINSTANCE.createSaltProject());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#saveSaltProject(org.eclipse.emf.common.util.URI) <em>Save Salt Project</em>}' operation.
	 * Checks storing and loading of a {@link SaltProject}.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#saveSaltProject(org.eclipse.emf.common.util.URI)
	 */
	public void testSaveSaltProject__URI() 
	{
		SCorpusGraph template_sCorpusGraph= SampleGenerator.createCorpusStructure();
		this.getFixture().getSCorpusGraphs().add(template_sCorpusGraph);
		for (SDocument sDoc: template_sCorpusGraph.getSDocuments())
		{
			SampleGenerator.createSDocumentStructure(sDoc);
		}
		
		File tmpDir = new File(FILE_TMP_DIR+this.getClass().getName());
		URI tmpURI= URI.createFileURI(tmpDir.getAbsolutePath());
		this.getFixture().saveSaltProject(tmpURI);
		for (SDocument sDoc: template_sCorpusGraph.getSDocuments())
		{
			sDoc.loadSDocumentGraph();
		}
		
		SaltProject saltProject= SaltFactory.eINSTANCE.createSaltProject();
		saltProject.loadSaltProject(tmpURI);
		assertEquals(this.getFixture(), saltProject);
	}
	

		/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSaltProject_SCorpusStructure(org.eclipse.emf.common.util.URI) <em>Load Salt Project SCorpus Structure</em>}' operation.
	 * Implementation is found in {@link #testLoadSaltProject_SCorpusStructure__URI_simple()} and
	 * {@link #testLoadSaltProject_SCorpusStructure__URI_complex()}
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSaltProject_SCorpusStructure(org.eclipse.emf.common.util.URI)
	 */
	public void testLoadSaltProject_SCorpusStructure__URI()
	{
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#getSDocumentGraphLocations() <em>Get SDocument Graph Locations</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#getSDocumentGraphLocations()
	 */
	public void testGetSDocumentGraphLocations() {
		//nothing to do, see testLoadSCorpusStructure__URI()
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSCorpusStructure(org.eclipse.emf.common.util.URI) <em>Load SCorpus Structure</em>}' operation.
	 * Only tests, if the created map is correct. Further tests can be found in {@link #testLoadSaltProject_SCorpusStructure__URI_simple()} and
	 * {@link #testLoadSaltProject_SCorpusStructure__URI_complex()}
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSCorpusStructure(org.eclipse.emf.common.util.URI)
	 */
	public void testLoadSCorpusStructure__URI() 
	{
		File saltProjectFile= new File(FILE_RESOURCE_DIR+ "case5/");
		URI saltProjectURI= URI.createFileURI(saltProjectFile.getAbsolutePath());
		this.getFixture().loadSCorpusStructure(saltProjectURI);
		Map<SElementId, URI> sDocumentMap= this.getFixture().getSDocumentGraphLocations();
		
		assertNotNull(this.getFixture().getSCorpusGraphs());
		assertEquals(1, this.getFixture().getSCorpusGraphs().size());
		assertNotNull(this.getFixture().getSCorpusGraphs().get(0));
		assertNotNull(this.getFixture().getSCorpusGraphs().get(0).getSDocuments());
		assertEquals(4, this.getFixture().getSCorpusGraphs().get(0).getSDocuments().size());
		
		assertNotNull(this.getFixture().getSCorpusGraphs().get(0).getSDocuments().get(0));
		assertNotNull(this.getFixture().getSCorpusGraphs().get(0).getSDocuments().get(1));
		assertNotNull(this.getFixture().getSCorpusGraphs().get(0).getSDocuments().get(2));
		assertNotNull(this.getFixture().getSCorpusGraphs().get(0).getSDocuments().get(3));
		
		SDocument sDoc1= this.getFixture().getSCorpusGraphs().get(0).getSDocuments().get(0);
		SDocument sDoc2= this.getFixture().getSCorpusGraphs().get(0).getSDocuments().get(1);
		SDocument sDoc3= this.getFixture().getSCorpusGraphs().get(0).getSDocuments().get(2);
		SDocument sDoc4= this.getFixture().getSCorpusGraphs().get(0).getSDocuments().get(3);
		
		File sDoc1File= new File(saltProjectFile.getAbsoluteFile()+"/rootCorpus/subCorpus1/doc1."+SaltFactory.FILE_ENDING_SALT);
		File sDoc2File= new File(saltProjectFile.getAbsoluteFile()+"/rootCorpus/subCorpus1/doc2."+SaltFactory.FILE_ENDING_SALT);
		File sDoc3File= new File(saltProjectFile.getAbsoluteFile()+"/rootCorpus/subCorpus1/doc3."+SaltFactory.FILE_ENDING_SALT);
		File sDoc4File= new File(saltProjectFile.getAbsoluteFile()+"/rootCorpus/subCorpus1/doc4."+SaltFactory.FILE_ENDING_SALT);
				
		assertNotNull(sDocumentMap.get(sDoc1.getSElementId()));
		assertNotNull(sDocumentMap.get(sDoc2.getSElementId()));
		assertNotNull(sDocumentMap.get(sDoc3.getSElementId()));
		assertNotNull(sDocumentMap.get(sDoc4.getSElementId()));
		
		assertEquals(sDoc1File, new File(sDocumentMap.get(sDoc1.getSElementId()).toFileString()));
		assertEquals(sDoc2File, new File(sDocumentMap.get(sDoc2.getSElementId()).toFileString()));
		assertEquals(sDoc3File, new File(sDocumentMap.get(sDoc3.getSElementId()).toFileString()));
		assertEquals(sDoc4File, new File(sDocumentMap.get(sDoc4.getSElementId()).toFileString()));
	}
	
	/**
	 * Tests the loading of the corpus structure as created by {@link SampleGenerator#createSimpleCorpusStructure(SaltProject)}.
	 */
	public void testLoadSaltProject_SCorpusStructure__URI_simple() 
	{
		File saltProjectFile= new File(FILE_RESOURCE_DIR+ "case8/");
		URI saltProjectURI= URI.createFileURI(saltProjectFile.getAbsolutePath());
		this.getFixture().loadSCorpusStructure(saltProjectURI);
		assertNotNull(this.getFixture().getSCorpusGraphs());
		assertEquals(1, this.getFixture().getSCorpusGraphs().size());
		SCorpusGraph sCorpusGraph= this.getFixture().getSCorpusGraphs().get(0);
	
		SCorpusGraph template_sCorpusGraph= SampleGenerator.createCorpusStructure_simple();
		assertEquals("differences:\n"+template_sCorpusGraph.differences(sCorpusGraph), template_sCorpusGraph, sCorpusGraph);
	}
	
	/**
	 * Tests the loading of the corpus structure as created by {@link SampleGenerator#createCorpusStructure(SaltProject)}.
	 */
	public void testLoadSaltProject_SCorpusStructure__URI_complex() 
	{
		File saltProjectFile= new File(FILE_RESOURCE_DIR+ "case9/");
		URI saltProjectURI= URI.createFileURI(saltProjectFile.getAbsolutePath());
		this.getFixture().loadSCorpusStructure(saltProjectURI);
		assertNotNull(this.getFixture().getSCorpusGraphs());
		assertEquals(1, this.getFixture().getSCorpusGraphs().size());
		SCorpusGraph sCorpusGraph= this.getFixture().getSCorpusGraphs().get(0);
		
		SCorpusGraph template_sCorpusGraph= SampleGenerator.createCorpusStructure();
		assertEquals("differences:\n"+template_sCorpusGraph.differences(sCorpusGraph), template_sCorpusGraph, sCorpusGraph);
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSaltProject(org.eclipse.emf.common.util.URI) <em>Load Salt Project</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSaltProject(org.eclipse.emf.common.util.URI)
	 */
	public void testLoadSaltProject__URI() 
	{
		URI saltProjectURI= URI.createFileURI(FILE_RESOURCE_DIR+ "case5/");
		this.getFixture().loadSaltProject(saltProjectURI);
		assertNotNull(this.getFixture().getSCorpusGraphs());
		assertEquals(1, this.getFixture().getSCorpusGraphs().size());
		
		SaltProject template_saltProject= SampleGenerator.createCompleteSaltproject();
		
		assertEquals("differences:\n"+template_saltProject.differences(this.getFixture()), template_saltProject, this.getFixture());
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSaltProject(org.eclipse.emf.common.util.URI) <em>Load Salt Project</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSaltProject(org.eclipse.emf.common.util.URI)
	 */
	public void testLoadSaltProject__URI_simple() 
	{
		URI saltProjectURI= URI.createFileURI(FILE_RESOURCE_DIR+ "case7/");
		this.getFixture().loadSaltProject(saltProjectURI);
		assertNotNull(this.getFixture().getSCorpusGraphs());
		assertEquals(1, this.getFixture().getSCorpusGraphs().size());
		
		//Creating a new salt project, this is the main object and contains all the others. 
		SaltProject template_saltProject= SaltFactory.eINSTANCE.createSaltProject();
	
		{//creating a corpus structure for salt project
			template_saltProject.getSCorpusGraphs().add(SampleGenerator.createCorpusStructure_simple());
		}//creating a corpus structure for salt project
	
		{//filling all of the documents in the corpus structure with document structure data
			//this works, because after createCorpusStructure() was called, only one graph exists in salt project
			SCorpusGraph sCorpusGraph= template_saltProject.getSCorpusGraphs().get(0);
			for (SDocument sDocument: sCorpusGraph.getSDocuments())
			{//filling all of the documents in the corpus structure with document structure data	
				SampleGenerator.createSDocumentStructure(sDocument);
			}//filling all of the documents in the corpus structure with document structure data
		}//filling all of the documents in the corpus structure with document structure data
		
		
		assertEquals("differences:\n"+template_saltProject.differences(this.getFixture()), template_saltProject, this.getFixture());
	}
		
	/**
	 * Tests following structure:
	 * 
	 * 				rootCorpus
	 * 		/					\
	 * 	subCorp1				subCorp2
	 * 	/		\				/		\
	 * doc1		doc2		doc3		doc4
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public void testSaveSaltProject_CorpusGraph() throws IOException, SAXException 
	{
		String saltProjectPathResource= FILE_RESOURCE_DIR+"case1/";
		String saltProjectPathTMP= FILE_TMP_DIR+ "case1/";
		
		SampleGenerator.createCorpusStructure(this.getFixture());
		
		this.getFixture().saveSaltProject(URI.createFileURI(new File(saltProjectPathTMP).getAbsolutePath()));
		
		//compare directories via XMLUnit
		this.compareDirectories(new File(saltProjectPathTMP), new File(saltProjectPathResource));
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSaltProject_GrAF(org.eclipse.emf.common.util.URI, java.util.Properties) <em>Load Salt Project Gr AF</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSaltProject_GrAF(org.eclipse.emf.common.util.URI, java.util.Properties)
	 */
	public void testLoadSaltProject_GrAF__URI_Properties() {
//		// TODO: implement this operation test method
//		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#differences(java.lang.Object) <em>Differences</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#differences(java.lang.Object)
	 */
	public void testDifferences__Object() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSCorpusGraph_GrAF(org.eclipse.emf.common.util.URI, java.util.Properties) <em>Load SCorpus Graph Gr AF</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSCorpusGraph_GrAF(org.eclipse.emf.common.util.URI, java.util.Properties)
	 */
	public void testLoadSCorpusGraph_GrAF__URI_Properties() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
	}

		/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSDocumentGraph_GrAF(org.eclipse.emf.common.util.URI, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument, java.util.Properties) <em>Load SDocument Graph Gr AF</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#loadSDocumentGraph_GrAF(org.eclipse.emf.common.util.URI, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument, java.util.Properties)
	 */
	public void testLoadSDocumentGraph_GrAF__URI_SDocument_Properties() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#saveSCorpusGraph_DOT(org.eclipse.emf.common.util.URI, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId) <em>Save SCorpus Graph DOT</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#saveSCorpusGraph_DOT(org.eclipse.emf.common.util.URI, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId)
	 */
	public void testSaveSCorpusGraph_DOT__URI_SElementId() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
	}

		/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#saveSaltProject_DOT(org.eclipse.emf.common.util.URI) <em>Save Salt Project DOT</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#saveSaltProject_DOT(org.eclipse.emf.common.util.URI)
	 */
	public void testSaveSaltProject_DOT__URI() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
	}

		/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#saveSDocumentGraph_DOT(org.eclipse.emf.common.util.URI, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId) <em>Save SDocument Graph DOT</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#saveSDocumentGraph_DOT(org.eclipse.emf.common.util.URI, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId)
	 */
	public void testSaveSDocumentGraph_DOT__URI_SElementId() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
	}

	/**
	 * Tests following structure:
	 * 
	 * 				rootCorpus
	 * 		/					\
	 * 	subCorp1				subCorp2
	 * 	/		\				/		\
	 * doc1		doc2		doc3		doc4
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public void testLoadSaltProject_CorpusGraph() 
	{
		String saltProjectPathResource= FILE_RESOURCE_DIR+"case1/";
		
		SaltProject saltProject2= SaltFactory.eINSTANCE.createSaltProject();
		SampleGenerator.createCorpusStructure(saltProject2);
		File file= new File(saltProjectPathResource);
		assertTrue("cannot run test, because resource '"+file.getAbsolutePath()+"' does not exist.",file.exists());
		this.getFixture().loadSCorpusStructure(URI.createFileURI(file.getAbsolutePath()));
		
		assertEquals(saltProject2, this.getFixture());
	}


	public void testSCorpusGraphs()
	{
		EList<SCorpusGraph> corpGraphs= new BasicEList<SCorpusGraph>();
		for (int i= 0; i < 10; i++)
		{
			SCorpusGraph corpGraph= SaltCommonFactory.eINSTANCE.createSCorpusGraph();
			corpGraphs.add(corpGraph);
			this.getFixture().getSCorpusGraphs().add(corpGraph);
		}
		
		assertTrue(corpGraphs.containsAll(this.getFixture().getSCorpusGraphs()));
		assertTrue(this.getFixture().getSCorpusGraphs().containsAll(corpGraphs));
	}

	
	/**
	 * Compares two directories and their content recursive. All conteined XML files will be checked for equality (via XMLUnit).
	 * @param dir1
	 * @param dir2
	 * @return
	 * @throws IOException 
	 * @throws SAXException 
	 */
	private boolean compareDirectories(File dir1, File dir2) throws IOException, SAXException
	{
		assertNotNull("The given directory dir1 must not be null", dir1);
		assertNotNull("The given directory dir2 must not be null", dir2);
		
		assertTrue("Directory dir1 ("+dir1.getAbsolutePath()+") does not exist.", dir1.exists());
		assertTrue("Directory dir2 ("+dir2.getAbsolutePath()+") does not exist.", dir2.exists());
		assertTrue("Directory dir1 ("+dir1.getAbsolutePath()+") is not a directory.", dir1.isDirectory());
		assertTrue("Directory dir2 ("+dir2.getAbsolutePath()+") is not a directory.", dir2.isDirectory());
		
		//if neccessary, a list of files and directories to ignore are used, in our case ".svn"
		ArrayList<String> ignoredFilenames = new ArrayList<String>();  
		ignoredFilenames.add(".svn");

		ArrayList<File> dir1List = new ArrayList<File>();
		ArrayList<File> dir2List = new ArrayList<File>();		
		
		for (File file : dir1.listFiles())
			if (!ignoredFilenames.contains(file.getName())) 
				dir1List.add(file);
		
		for (File file : dir2.listFiles())
			if (!ignoredFilenames.contains(file.getName())) 
				dir2List.add(file);
		
		assertEquals("Directories do not contain the same number of files and sub directories.", dir1List.size(), dir2List.size());
		
		//compare all files and subdirectories except for those in ignoredFilenames
		for (int i=0; i<dir1List.size(); i++) {
			File file1 = dir1List.get(i);
			File file2 = dir2List.get(i);
			
			assertEquals("The files do not have the same name.", file1.getName(), file2.getName());
			if (file1.isDirectory())
				compareDirectories(file1, file2);
			else
			{//compare salt files
				if (file1.getName().endsWith("salt"))
				{
					BufferedReader in = null;
					StringBuffer controlSequence =new StringBuffer();
					StringBuffer testSequence=new StringBuffer();
					try {
						String line = null;
						
						in = new BufferedReader(new FileReader(file1));
						line = null;
						while ((line = in.readLine()) != null) {
							testSequence.append(line);
						}
						in = new BufferedReader(new FileReader(file2));
						line = null;
						while ((line = in.readLine()) != null) {
							controlSequence.append(line);
						}
					} finally
					{
						if (in!= null)
						{
							in.close();
						}
					}
	
					DifferenceListener myDifferenceListener = new IgnoreTextAndAttributeValuesDifferenceListener();
				    Diff myDiff = new Diff(controlSequence.toString().replace("\r", "").replace("\n", "").replace("\t", ""), testSequence.toString().replace("\r", "").replace("\n", "").replace("\t", "")); 
				    myDiff.overrideDifferenceListener(myDifferenceListener);
				    assertTrue("XML does not matches control skeleton XML of '"+file1.getAbsolutePath()+"' and '"+file2.getAbsolutePath()+"'", myDiff.similar());
				}//compare salt files
			}
		}//compare all files and subdirectories
		return(true);
	}
} //SaltProjectTest
