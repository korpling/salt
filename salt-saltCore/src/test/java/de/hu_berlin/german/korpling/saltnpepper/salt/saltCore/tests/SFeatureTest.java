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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.tests;

import junit.textui.TestRunner;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCoreFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SFeature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature#getSFeaturableElement() <em>SFeaturable Element</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SFeatureTest extends SAbstractAnnotationTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SFeatureTest.class);
	}

	/**
	 * Constructs a new SFeature test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SFeatureTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this SFeature test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SFeature getFixture() {
		return (SFeature)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SaltCoreFactory.eINSTANCE.createSFeature());
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature#getSFeaturableElement() <em>SFeaturable Element</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature#getSFeaturableElement()
	 */
	public void testGetSFeaturableElement() 
	{
		SFeaturableElement featElem= SaltCoreFactory.eINSTANCE.createSFeaturableElement();
		this.getFixture().setSFeaturableElement(featElem);
		assertEquals(featElem, this.getFixture().getSFeaturableElement());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature#setSFeaturableElement(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement) <em>SFeaturable Element</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature#setSFeaturableElement(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement)
	 */
	public void testSetSFeaturableElement() 
	{
		this.testGetSFeaturableElement();
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature#getSNS() <em>SNS</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature#getSNS()
	 */
	public void testGetSNS() 
	{
		assertNull(this.getFixture().getSNS());
		
		String ns= "ns";
		this.getFixture().setSNS(ns);
		assertEquals(ns, this.getFixture().getSNS());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature#setSNS(java.lang.String) <em>SNS</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature#setSNS(java.lang.String)
	 */
	public void testSetSNS() 
	{
		this.testGetSNS();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation#getSName() <em>SName</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation#getSName()
	 */
	public void testGetSName() 
	{
		assertNull(this.getFixture().getSName());
		
		String name= "name";
		this.getFixture().setSName(name);
		assertEquals(name, this.getFixture().getSName());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation#setSName(java.lang.String) <em>SName</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation#setSName(java.lang.String)
	 */
	public void testSetSName() 
	{
		this.testGetSName();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation#getSValue() <em>SValue</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation#getSValue()
	 */
	public void testGetSValue() 
	{
		assertNull(this.getFixture().getSValue());
		
		String value= "value";
		this.getFixture().setSValue(value);
		assertEquals(value, this.getFixture().getSValue());
		
		Object valueObj= new Object();
		this.getFixture().setSValue(valueObj);
		assertEquals(valueObj, this.getFixture().getSValue());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation#setSValue(java.lang.Object) <em>SValue</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation#setSValue(java.lang.Object)
	 */
	public void testSetSValue() 
	{
		this.testGetSValue();
	}

} //SFeatureTest
