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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.tests;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCoreFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SALT_SEMANTIC_NAMES;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SCatAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SaltSemanticsFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SaltSemanticsPackage;
import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SCat Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SCatAnnotation#isSCatAnnotation(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation) <em>Is SCat Annotation</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SCatAnnotationTest extends TestCase {

	/**
	 * The fixture for this SCat Annotation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SCatAnnotation fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SCatAnnotationTest.class);
	}

	/**
	 * Constructs a new SCat Annotation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCatAnnotationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SCat Annotation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SCatAnnotation fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SCat Annotation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SCatAnnotation getFixture() {
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
		setFixture(SaltSemanticsFactory.eINSTANCE.createSCatAnnotation());
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
	 * Tests the '{@link de.hub.corpling.salt.saltSemantics.SCatAnnotation#isSCatAnnotation(de.hub.corpling.salt.saltCore.SAnnotation) <em>Is SCat Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltSemantics.SCatAnnotation#isSCatAnnotation(de.hub.corpling.salt.saltCore.SAnnotation)
	 */
	public void testIsSCatAnnotation__SAnnotation() 
	{
		SAnnotation sAnno= null;
		
		sAnno= SaltCoreFactory.eINSTANCE.createSAnnotation();
		sAnno.setSNS(SaltSemanticsPackage.eNS_PREFIX);
		sAnno.setSName(SALT_SEMANTIC_NAMES.CAT.toString());
		sAnno.setSValue("");
		assertTrue("This shall be identified as CatAnnotation.", this.getFixture().isSCatAnnotation(sAnno));
		
		sAnno= SaltCoreFactory.eINSTANCE.createSAnnotation();
		sAnno.setSNS("any");
		sAnno.setSName(SALT_SEMANTIC_NAMES.CAT.toString());
		sAnno.setSValue("");
		assertFalse("This isn�t a CatAnnotation, because of ns.", this.getFixture().isSCatAnnotation(sAnno));
		
		sAnno= SaltCoreFactory.eINSTANCE.createSAnnotation();
		sAnno.setSNS(SaltSemanticsPackage.eNS_PREFIX);
		sAnno.setSName("any");
		sAnno.setSValue("");
		assertFalse("This isn�t a CatAnnotation, because of name.", this.getFixture().isSCatAnnotation(sAnno));
	}
		
	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SProcessingAnnotation#getSName() <em>SName</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SProcessingAnnotation#getSName()
	 */
	public void testGetSName() 
	{
		assertNotNull(this.getFixture().getSName());
		assertEquals(SALT_SEMANTIC_NAMES.CAT.toString(), this.getFixture().getSName());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SProcessingAnnotation#setSName(java.lang.String) <em>SName</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SProcessingAnnotation#setSName(java.lang.String)
	 */
	public void testSetSName() 
	{
		try {
			this.getFixture().setSName("");
			fail("Shall not reset annotation-name.");
		} catch (Exception e) 
		{}
	}
	
	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SProcessingAnnotation#getSName() <em>SName</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SProcessingAnnotation#getSName()
	 */
	public void testGetSNS() 
	{
		assertNotNull(this.getFixture().getSName());
		assertEquals(SaltSemanticsPackage.eNS_PREFIX, this.getFixture().getSNS());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCore.SProcessingAnnotation#setSName(java.lang.String) <em>SName</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.SProcessingAnnotation#setSName(java.lang.String)
	 */
	public void testSetSNS() 
	{
		try {
			this.getFixture().setSNS("");
			fail("Shall not reset annotation-ns.");
		} catch (Exception e) 
		{}
	}

} //SCatAnnotationTest
