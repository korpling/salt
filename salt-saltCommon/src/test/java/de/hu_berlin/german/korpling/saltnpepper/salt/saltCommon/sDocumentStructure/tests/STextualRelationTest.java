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

import junit.textui.TestRunner;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltImproperSTypeException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructureFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>STextual Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation#getSToken() <em>SToken</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation#getSTextualDS() <em>STextual DS</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation#getSDocumentGraph() <em>SDocument Graph</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextOverlappingRelation#isSTextOverlapping() <em>Is SText Overlapping</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class STextualRelationTest extends SSequentialRelationTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(STextualRelationTest.class);
	}

	/**
	 * Constructs a new STextual Relation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STextualRelationTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this STextual Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected STextualRelation getFixture() {
		return (STextualRelation)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SDocumentStructureFactory.eINSTANCE.createSTextualRelation());
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation#getSToken() <em>SToken</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation#getSToken()
	 */
	public void testGetSToken() 
	{
		SToken sToken= SaltCommonFactory.eINSTANCE.createSToken();
		this.getFixture().setSToken(sToken);
		assertEquals(sToken, this.getFixture().getSToken());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation#setSToken(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken) <em>SToken</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation#setSToken(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken)
	 */
	public void testSetSToken() 
	{
		this.testGetSToken();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation#getSTextualDS() <em>STextual DS</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation#getSTextualDS()
	 */
	public void testGetSTextualDS() 
	{
		STextualDS sSTextualDS= SaltCommonFactory.eINSTANCE.createSTextualDS();
		this.getFixture().setSTextualDS(sSTextualDS);
		assertEquals(sSTextualDS, this.getFixture().getSTextualDS());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation#setSTextualDS(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS) <em>STextual DS</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation#setSTextualDS(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS)
	 */
	public void testSetSTextualDS() 
	{
		this.testGetSTextualDS();
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
				SaltCommonFactory.eINSTANCE.createSSpan(),
				SaltCommonFactory.eINSTANCE.createSStructure(),
//				SaltCommonFactory.eINSTANCE.createSToken()
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
		this.getFixture().setSSource(SaltCommonFactory.eINSTANCE.createSToken());
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
//				SaltCommonFactory.eINSTANCE.createSTextualDS(),
				SaltCommonFactory.eINSTANCE.createSTimeline(),
				SaltCommonFactory.eINSTANCE.createSSpan(),
				SaltCommonFactory.eINSTANCE.createSStructure(),
				SaltCommonFactory.eINSTANCE.createSToken()
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
		this.getFixture().setSTarget(SaltCommonFactory.eINSTANCE.createSTextualDS());
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation#getSDocumentGraph() <em>SDocument Graph</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation#getSDocumentGraph()
	 */
	public void testGetSDocumentGraph() 
	{
		SDocumentGraph sSDocumentGraph= SaltCommonFactory.eINSTANCE.createSDocumentGraph();
		this.getFixture().setSDocumentGraph(sSDocumentGraph);
		assertEquals(sSDocumentGraph, this.getFixture().getSDocumentGraph());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation#setSDocumentGraph(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph) <em>SDocument Graph</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation#setSDocumentGraph(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph)
	 */
	public void testSetSDocumentGraph() 
	{
		this.testGetSDocumentGraph();
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

} //STextualRelationTest
