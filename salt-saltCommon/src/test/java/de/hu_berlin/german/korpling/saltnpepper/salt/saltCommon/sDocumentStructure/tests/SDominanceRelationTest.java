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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.tests;

import junit.textui.TestRunner;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltImproperSTypeException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructureFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructuredNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.tests.STextOverlappingRelationTest;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SDominance Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSStructure() <em>SStructure</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSStructuredTarget() <em>SStructured Target</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSDocumentGraph() <em>SDocument Graph</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeOverlappingRelation#isSTimeOverlapping() <em>Is STime Overlapping</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SDominanceRelationTest extends STextOverlappingRelationTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SDominanceRelationTest.class);
	}

	/**
	 * Constructs a new SDominance Relation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDominanceRelationTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this SDominance Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SDominanceRelation getFixture() {
		return (SDominanceRelation)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SDocumentStructureFactory.eINSTANCE.createSDominanceRelation());
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSStructure() <em>SStructure</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSStructure()
	 */
	public void testGetSStructure() 
	{
		SStructure struct= SaltCommonFactory.eINSTANCE.createSStructure();
		this.getFixture().setSStructure(struct);
		assertEquals(struct, this.getFixture().getSStructure());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation#setSStructure(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure) <em>SStructure</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation#setSStructure(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure)
	 */
	public void testSetSStructure() 
	{
		this.testGetSStructure();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSStructuredTarget() <em>SStructured Target</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSStructuredTarget()
	 */
	public void testGetSStructuredTarget() 
	{
		SStructuredNode sStructTarget= null;
		
		//test for token
		sStructTarget= SaltCommonFactory.eINSTANCE.createSToken();
		this.getFixture().setSStructuredTarget(sStructTarget);
		assertEquals(sStructTarget, this.getFixture().getSStructuredTarget());
		
		//test for span
		sStructTarget= SaltCommonFactory.eINSTANCE.createSSpan();
		this.getFixture().setSStructuredTarget(sStructTarget);
		assertEquals(sStructTarget, this.getFixture().getSStructuredTarget());
		
		//test for structure
		sStructTarget= SaltCommonFactory.eINSTANCE.createSStructure();
		this.getFixture().setSStructuredTarget(sStructTarget);
		assertEquals(sStructTarget, this.getFixture().getSStructuredTarget());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation#setSStructuredTarget(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructuredNode) <em>SStructured Target</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation#setSStructuredTarget(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructuredNode)
	 */
	public void testSetSStructuredTarget() 
	{
		this.testGetSStructuredTarget();
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
//				SaltCommonFactory.eINSTANCE.createSStructure(),
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
		this.getFixture().setSSource(SaltCommonFactory.eINSTANCE.createSStructure());
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
//				SaltCommonFactory.eINSTANCE.createSSpan(),
//				SaltCommonFactory.eINSTANCE.createSStructure(),
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
		this.getFixture().setSTarget(SaltCommonFactory.eINSTANCE.createSSpan());
		this.getFixture().setSTarget(SaltCommonFactory.eINSTANCE.createSStructure());		
		this.getFixture().setSTarget(SaltCommonFactory.eINSTANCE.createSToken());		
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSDocumentGraph() <em>SDocument Graph</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSDocumentGraph()
	 */
	public void testGetSDocumentGraph() 
	{
		SDocumentGraph sSDocumentGraph= SaltCommonFactory.eINSTANCE.createSDocumentGraph();
		this.getFixture().setSDocumentGraph(sSDocumentGraph);
		assertEquals(sSDocumentGraph, this.getFixture().getSDocumentGraph());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation#setSDocumentGraph(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph) <em>SDocument Graph</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation#setSDocumentGraph(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph)
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

} //SDominanceRelationTest
