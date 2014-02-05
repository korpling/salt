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

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.info.tests.InfoModuleTest;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusStructureFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.samples.SampleGenerator;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SCorpus</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus#getSCorpusGraph() <em>SCorpus Graph</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus#printInfo(org.eclipse.emf.common.util.URI) <em>Print Info</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus#printInfo(org.eclipse.emf.common.util.URI, org.eclipse.emf.common.util.URI) <em>Print Info</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SCorpusTest extends TestCase {

	public static final String FILE_TMP_DIR= "_TMP/";

	/**
	 * The fixture for this SCorpus test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SCorpus fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SCorpusTest.class);
	}

	/**
	 * Constructs a new SCorpus test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCorpusTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SCorpus test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SCorpus fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SCorpus test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SCorpus getFixture() {
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
		setFixture(SCorpusStructureFactory.eINSTANCE.createSCorpus());
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus#printInfo(org.eclipse.emf.common.util.URI) <em>Print Info</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus#printInfo(org.eclipse.emf.common.util.URI)
	 * 
	 */
	public void testPrintInfo__URI() {
		SaltProject sp = SampleGenerator.createCompleteSaltproject();
		SampleGenerator.createSDocumentSLayered(sp.getSCorpusGraphs().get(0).getSDocuments().get(0));
		SCorpus c = sp.getSCorpusGraphs().get(0).getSRootCorpus().get(0);
		File tmpFile = new File(FILE_TMP_DIR + "SCorpusPrintInfo__URI.xml");
		System.out.println("Writing test file: " + tmpFile.getAbsolutePath());
		URI res = URI.createFileURI(tmpFile.toURI().getRawPath());
		c.printInfo(res);
		InfoModuleTest imt = new InfoModuleTest();
		try {
			imt.validate(res);
		} catch (Exception e) {
			fail(e.getMessage());
		} 
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus#printInfo(org.eclipse.emf.common.util.URI, org.eclipse.emf.common.util.URI) <em>Print Info</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus#printInfo(org.eclipse.emf.common.util.URI, org.eclipse.emf.common.util.URI)
	 * 
	 */
	public void testPrintInfo__URI_URI() {
		SaltProject sp = SampleGenerator.createCompleteSaltproject();
		SCorpus c = sp.getSCorpusGraphs().get(0).getSRootCorpus().get(0);
		File tmpFile = new File(FILE_TMP_DIR + "SCorpusPrintInfo__URI.xml");
		File tmpFolder = new File(FILE_TMP_DIR + "SCorpusPrintInfo__URI_tempFolder/");
		URI res = URI.createFileURI(tmpFile.toURI().getRawPath());
		URI resFolder = URI.createFileURI(tmpFolder.toURI().getRawPath());
		c.printInfo(res,resFolder);
		InfoModuleTest imt = new InfoModuleTest();
		try {
			imt.validate(res);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

} //SCorpusTest
