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

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import junit.framework.TestCase;
import junit.textui.TestRunner;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCoreFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SFeaturable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#getSFeatures() <em>SFeatures</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#addSFeature(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature) <em>Add SFeature</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#getSFeature(java.lang.String) <em>Get SFeature</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#getSFeature(java.lang.String, java.lang.String) <em>Get SFeature</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#createSFeature(java.lang.String, java.lang.String, java.lang.Object, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE) <em>Create SFeature</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#createSFeature(java.lang.String, java.lang.String, java.lang.String) <em>Create SFeature</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SFeaturableElementTest extends TestCase {

	/**
	 * The fixture for this SFeaturable Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SFeaturableElement fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SFeaturableElementTest.class);
	}

	/**
	 * Constructs a new SFeaturable Element test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SFeaturableElementTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SFeaturable Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SFeaturableElement fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SFeaturable Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SFeaturableElement getFixture() {
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
		setFixture(SaltCoreFactory.eINSTANCE.createSFeaturableElement());
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#getSFeature() <em>SFeature</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#getSFeature()
	 */
	public void testGetSFeatures() 
	{
		EList<SFeature> sFeats= new BasicEList<SFeature>();
		for (int i= 0; i < 5; i++)
		{
			SFeature sFeature= SaltCoreFactory.eINSTANCE.createSFeature();
			sFeature.setSName("sFeature"+ i);
			sFeature.setSValue("featVal"+i);
			this.getFixture().addSFeature(sFeature);
			sFeats.add(sFeature);
		}
		assertTrue(sFeats.containsAll(this.getFixture().getSFeatures()));
		assertTrue(this.getFixture().getSFeatures().containsAll(sFeats));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#addSFeature(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature) <em>Add SFeature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#addSFeature(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature)
	 */
	public void testAddSFeature__SFeature() 
	{
		EList<SFeature> sFeats= new BasicEList<SFeature>();
		for (int i= 0; i < 5; i++)
		{
			SFeature sFeature= SaltCoreFactory.eINSTANCE.createSFeature();
			sFeature.setSName("sFeature"+ i);
			sFeature.setSValue("featVal"+i);
			this.getFixture().addSFeature(sFeature);
			sFeats.add(sFeature);
		}
		
		for (SFeature sFeat: sFeats)
		{
			assertEquals(sFeat, this.getFixture().getSFeature(sFeat.getSName()));
		}	
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#getSFeature(java.lang.String) <em>Get SFeature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#getSFeature(java.lang.String)
	 */
	public void testGetSFeature__String() 
	{
		this.testAddSFeature__SFeature();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#getSFeature(java.lang.String, java.lang.String) <em>Get SFeature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#getSFeature(java.lang.String, java.lang.String)
	 */
	public void testGetSFeature__String_String() 
	{
		SFeature sFeature= SaltCoreFactory.eINSTANCE.createSFeature();
		sFeature.setSNS("sNS");
		sFeature.setSName("name");
		this.getFixture().addSFeature(sFeature);
		assertEquals(sFeature, this.getFixture().getSFeature(sFeature.getSNS(), sFeature.getSName()));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#createSFeature(java.lang.String, java.lang.String, java.lang.Object, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE) <em>Create SFeature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#createSFeature(java.lang.String, java.lang.String, java.lang.Object, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE)
	 */
	public void testCreateSFeature__String_String_Object_SDATATYPE() {
		String name = "name";
		String ns = "ns";
		String value = "value";
		SFeature feat = this.getFixture().createSFeature(ns,name,value,SDATATYPE.STEXT);
		assertEquals(feat, this.getFixture().getSFeature(ns,name));
		assertEquals(feat, this.getFixture().getSFeatures().get(this.getFixture().getSFeatures().size()-1));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#createSFeature(java.lang.String, java.lang.String, java.lang.String) <em>Create SFeature</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#createSFeature(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void testCreateSFeature__String_String_String() {
		this.testCreateSFeature__String_String_Object_SDATATYPE();
	}

} //SFeaturableElementTest
