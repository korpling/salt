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

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusStructureFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SCorpus Document Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSCorpus() <em>SCorpus</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSDocument() <em>SDocument</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSCorpusGraph() <em>SCorpus Graph</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SCorpusDocumentRelationTest extends TestCase {

	/**
	 * The fixture for this SCorpus Document Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SCorpusDocumentRelation fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SCorpusDocumentRelationTest.class);
	}

	/**
	 * Constructs a new SCorpus Document Relation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCorpusDocumentRelationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SCorpus Document Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SCorpusDocumentRelation fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SCorpus Document Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SCorpusDocumentRelation getFixture() {
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
		setFixture(SCorpusStructureFactory.eINSTANCE.createSCorpusDocumentRelation());
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSCorpus() <em>SCorpus</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSCorpus()
	 */
	public void testGetSCorpus() 
	{
		SCorpus sCorpus= SaltCommonFactory.eINSTANCE.createSCorpus();
		this.getFixture().setSCorpus(sCorpus);
		assertEquals(sCorpus, this.getFixture().getSCorpus());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#setSCorpus(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus) <em>SCorpus</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#setSCorpus(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus)
	 */
	public void testSetSCorpus() 
	{
		this.testGetSCorpus();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSDocument() <em>SDocument</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSDocument()
	 */
	public void testGetSDocument() 
	{
		SDocument sDoc= SaltCommonFactory.eINSTANCE.createSDocument();
		this.getFixture().setSDocument(sDoc);
		assertEquals(sDoc, this.getFixture().getSDocument());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#setSDocument(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument) <em>SDocument</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#setSDocument(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument)
	 */
	public void testSetSDocument() 
	{
		this.testGetSDocument();
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

} //SCorpusDocumentRelationTest
