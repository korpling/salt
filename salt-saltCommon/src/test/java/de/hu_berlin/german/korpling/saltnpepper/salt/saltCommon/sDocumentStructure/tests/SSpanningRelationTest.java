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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.tests;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltImproperSTypeException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructureFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SSpanning Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation#getSToken() <em>SToken</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation#getSSpan() <em>SSpan</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation#getSDocumentGraph() <em>SDocument Graph</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeOverlappingRelation#isSTimeOverlapping() <em>Is STime Overlapping</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextOverlappingRelation#isSTextOverlapping() <em>Is SText Overlapping</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SSpanningRelationTest extends TestCase {

	/**
	 * The fixture for this SSpanning Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SSpanningRelation fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SSpanningRelationTest.class);
	}

	/**
	 * Constructs a new SSpanning Relation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SSpanningRelationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SSpanning Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SSpanningRelation fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SSpanning Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SSpanningRelation getFixture() {
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
		setFixture(SDocumentStructureFactory.eINSTANCE.createSSpanningRelation());
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation#getSToken() <em>SToken</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation#getSToken()
	 */
	public void testGetSToken() 
	{
		SToken sToken= SaltCommonFactory.eINSTANCE.createSToken();
		this.getFixture().setSToken(sToken);
		assertEquals(sToken, this.getFixture().getSToken());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation#setSToken(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken) <em>SToken</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation#setSToken(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken)
	 */
	public void testSetSToken() 
	{
		this.testGetSToken();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation#getSSpan() <em>SSpan</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation#getSSpan()
	 */
	public void testGetSSpan() 
	{
		SSpan SSpan= SaltCommonFactory.eINSTANCE.createSSpan();
		this.getFixture().setSSpan(SSpan);
		assertEquals(SSpan, this.getFixture().getSSpan());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation#setSSpan(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan) <em>SSpan</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation#setSSpan(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan)
	 */
	public void testSetSSpan() 
	{
		this.testGetSSpan();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void testSetSSource() 
	{
		// failing section
		SNode[] failItems = {
				SaltCommonFactory.eINSTANCE.createSNode(),
				SaltCommonFactory.eINSTANCE.createSCorpus(),
				SaltCommonFactory.eINSTANCE.createSDocument(),
				SaltCommonFactory.eINSTANCE.createSTextualDS(),
				SaltCommonFactory.eINSTANCE.createSTimeline(),
//				SaltCommonFactory.eINSTANCE.createSSpan(),
				SaltCommonFactory.eINSTANCE.createSStructure(),
				SaltCommonFactory.eINSTANCE.createSToken()
		};
		
		for (SNode failItem : failItems) {
			try {
				this.getFixture().setSSource(failItem);
				fail();
			}
			catch (SaltImproperSTypeException e) {
			}
		}
		
		// successing section
		this.getFixture().setSSource(SaltCommonFactory.eINSTANCE.createSSpan());
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void testSetSTarget() 
	{
		// failing section
		SNode[] failItems = {
				SaltCommonFactory.eINSTANCE.createSNode(),
				SaltCommonFactory.eINSTANCE.createSCorpus(),
				SaltCommonFactory.eINSTANCE.createSDocument(),
				SaltCommonFactory.eINSTANCE.createSTextualDS(),
				SaltCommonFactory.eINSTANCE.createSTimeline(),
				SaltCommonFactory.eINSTANCE.createSSpan(),
				SaltCommonFactory.eINSTANCE.createSStructure(),
//				SaltCommonFactory.eINSTANCE.createSToken()
		};
		
		for (SNode failItem : failItems) {
			try {
				this.getFixture().setSTarget(failItem);
				fail();
			}
			catch (SaltImproperSTypeException e) {
			}
		}
		
		// successing section
		this.getFixture().setSTarget(SaltCommonFactory.eINSTANCE.createSToken());		
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation#getSDocumentGraph() <em>SDocument Graph</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation#getSDocumentGraph()
	 */
	public void testGetSDocumentGraph() 
	{
		SDocumentGraph sSDocumentGraph= SaltCommonFactory.eINSTANCE.createSDocumentGraph();
		this.getFixture().setSDocumentGraph(sSDocumentGraph);
		assertEquals(sSDocumentGraph, this.getFixture().getSDocumentGraph());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation#setSDocumentGraph(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph) <em>SDocument Graph</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation#setSDocumentGraph(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph)
	 */
	public void testSetSDocumentGraph() 
	{
		this.testGetSDocumentGraph();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeOverlappingRelation#isSTimeOverlapping() <em>Is STime Overlapping</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeOverlappingRelation#isSTimeOverlapping()
	 */
	public void testIsSTimeOverlapping() 
	{
		assertTrue(this.getFixture().isSTimeOverlapping());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextOverlappingRelation#isSTextOverlapping() <em>Is SText Overlapping</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextOverlappingRelation#isSTextOverlapping()
	 */
	public void testIsSTextOverlapping() 
	{
		assertTrue(this.getFixture().isSTextOverlapping());
	}

} //SSpanningRelationTest
