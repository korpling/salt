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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.tests;

import java.io.File;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.util.URI;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.info.tests.InfoModuleTest;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusStructureFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.samples.SampleGenerator;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SDocument</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument#getSCorpusGraph() <em>SCorpus Graph</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument#getSDocumentGraphLocation() <em>SDocument Graph Location</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument#saveSDocumentGraph(org.eclipse.emf.common.util.URI) <em>Save SDocument Graph</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument#loadSDocumentGraph() <em>Load SDocument Graph</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument#loadSDocumentGraph(org.eclipse.emf.common.util.URI) <em>Load SDocument Graph</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument#printInfo(org.eclipse.emf.common.util.URI) <em>Print Info</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SDocumentTest extends TestCase {

	/**
	 * The fixture for this SDocument test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDocument fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SDocumentTest.class);
	}

	/**
	 * Constructs a new SDocument test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDocumentTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SDocument test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SDocument fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SDocument test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDocument getFixture() {
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
		setFixture(SCorpusStructureFactory.eINSTANCE.createSDocument());
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSCorpusGraph() <em>SCorpus Graph</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSCorpusGraph()
	 */
	public void testGetSCorpusGraph() 
	{
		SCorpusGraph sSCorpusGraph= SaltCommonFactory.eINSTANCE.createSCorpusGraph();
		this.getFixture().setSCorpusGraph(sSCorpusGraph);
		assertEquals(sSCorpusGraph, this.getFixture().getSCorpusGraph());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusRelation#setSCorpusGraph(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph) <em>SCorpus Graph</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusRelation#setSCorpusGraph(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph)
	 */
	public void testSetSCorpusGraph() 
	{
		this.testGetSCorpusGraph();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument#getSDocumentGraphLocation() <em>SDocument Graph Location</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument#getSDocumentGraphLocation()
	 */
	public void testGetSDocumentGraphLocation() 
	{
		assertNull(this.getFixture().getSDocumentGraphLocation());
		File file= new File("/home/saltnpepper/bla.salt");
		URI graphLocation= URI.createFileURI(file.getAbsolutePath());
		this.getFixture().setSDocumentGraphLocation(graphLocation);
		
		assertEquals(graphLocation, this.getFixture().getSDocumentGraphLocation());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument#setSDocumentGraphLocation(org.eclipse.emf.common.util.URI) <em>SDocument Graph Location</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument#setSDocumentGraphLocation(org.eclipse.emf.common.util.URI)
	 */
	public void testSetSDocumentGraphLocation() {
		this.testGetSDocumentGraphLocation();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument#saveSDocumentGraph(org.eclipse.emf.common.util.URI) <em>Save SDocument Graph</em>}' operation.
	 * Tests the persisting of a sample {@link SDocumentGraph} object created by {@link SampleGenerator#createSDocumentStructure(SDocument)} and checks correct
	 * storing, by calling {@link SDocument#loadSDocumentGraph()}
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument#saveSDocumentGraph(org.eclipse.emf.common.util.URI)
	 */
	public void testSaveSDocumentGraph__URI() 
	{
		SampleGenerator.createSDocumentStructure(this.getFixture());
		File tmpFile = new File(System.getProperty("java.io.tmpdir")+"/testDoc."+ SaltFactory.FILE_ENDING_SALT);
		
		System.out.println(tmpFile);
		URI tmpUri = URI.createFileURI(tmpFile.getAbsolutePath());
		SDocumentGraph template= this.getFixture().getSDocumentGraph();
		this.getFixture().saveSDocumentGraph(tmpUri);
		
		SDocument sDocument= SaltFactory.eINSTANCE.createSDocument();
		sDocument.loadSDocumentGraph(tmpUri);
		assertEquals("differences: "+template.differences(sDocument.getSDocumentGraph()), template, sDocument.getSDocumentGraph());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument#loadSDocumentGraph() <em>Load SDocument Graph</em>}' operation.
	 * Implementation at @see {@link #testSaveSDocumentGraph__URI()}
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument#loadSDocumentGraph()
	 */
	public void testLoadSDocumentGraph() {
		this.testSaveSDocumentGraph__URI();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument#loadSDocumentGraph(org.eclipse.emf.common.util.URI) <em>Load SDocument Graph</em>}' operation.
	 * Implementation at @see {@link #testSaveSDocumentGraph__URI()}
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument#loadSDocumentGraph(org.eclipse.emf.common.util.URI)
	 */
	public void testLoadSDocumentGraph__URI() {
		this.testSaveSDocumentGraph__URI();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument#printInfo(org.eclipse.emf.common.util.URI) <em>Print Info</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument#printInfo(org.eclipse.emf.common.util.URI)
	 * 
	 */
	public void testPrintInfo__URI() {
		SampleGenerator.createSDocumentStructure(this.getFixture());
		SampleGenerator.createSDocumentSLayered(this.getFixture());
		this.getFixture().setSId("tempSDocument");
		File tmpFile = new File(System.getProperty("java.io.tmpdir")+"/testDocInfo.xml");
		URI tmpUri = URI.createFileURI(tmpFile.getAbsolutePath());
		this.getFixture().printInfo(tmpUri);
		
		InfoModuleTest imt = new InfoModuleTest();
		try {
			// TODO: header or no header
			imt.validate(tmpFile);
		} catch (Exception e) {
			fail();
		}
	}

} //SDocumentTest
