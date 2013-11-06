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

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCoreFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SAnnotatable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#getSAnnotations() <em>SAnnotations</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#addSAnnotation(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation) <em>Add SAnnotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#getSAnnotation(java.lang.String) <em>Get SAnnotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#createSAnnotation(java.lang.String, java.lang.String, java.lang.Object, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE) <em>Create SAnnotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#createSAnnotation(java.lang.String, java.lang.String, java.lang.String) <em>Create SAnnotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#createSAnnotations(java.lang.String) <em>Create SAnnotations</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SAnnotatableElementTest extends TestCase {

	/**
	 * The fixture for this SAnnotatable Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SAnnotatableElement fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SAnnotatableElementTest.class);
	}

	/**
	 * Constructs a new SAnnotatable Element test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SAnnotatableElementTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SAnnotatable Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SAnnotatableElement fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SAnnotatable Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SAnnotatableElement getFixture() {
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
		setFixture(SaltCoreFactory.eINSTANCE.createSAnnotatableElement());
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#getSAnnotations() <em>SProcessing Annotations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#getSAnnotations()
	 */
	public void testGetSAnnotations() 
	{
		String[] QNames= {"ns::name1", "ns::name2", "ns::name3", "ns::name4"};
		EList<SAnnotation> sProcAnnos= new BasicEList<SAnnotation>();
		for (String QName: QNames)
		{	
			SAnnotation sProcAnno1= SaltCoreFactory.eINSTANCE.createSAnnotation();
			sProcAnno1.setQName(QName);
			this.getFixture().addSAnnotation(sProcAnno1);
			sProcAnnos.add(sProcAnno1);
		}
		
		assertTrue(sProcAnnos.containsAll(this.getFixture().getSAnnotations()));
		assertTrue(this.getFixture().getSAnnotations().containsAll(sProcAnnos));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#addSAnnotation(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation) <em>Add SProcessing Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#addSAnnotation(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation)
	 */
	public void testAddSAnnotation__SAnnotation() 
	{
		String QName= "ns::name";
		SAnnotation sProcAnno= SaltCoreFactory.eINSTANCE.createSAnnotation();
		sProcAnno.setQName(QName);
		this.getFixture().addSAnnotation(sProcAnno);
		assertEquals(sProcAnno, this.getFixture().getSAnnotation(QName));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#getSAnnotation(java.lang.String) <em>Get SProcessing Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#getSAnnotation(java.lang.String)
	 */
	public void testGetSAnnotation__String() 
	{
		this.testAddSAnnotation__SAnnotation();
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#createSAnnotation(java.lang.String, java.lang.String, java.lang.Object, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE) <em>Create SAnnotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#createSAnnotation(java.lang.String, java.lang.String, java.lang.Object, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE)
	 */
	public void testCreateSAnnotation__String_String_Object_SDATATYPE() {
		this.testCreateSAnnotation__String_String_String();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#createSAnnotation(java.lang.String, java.lang.String, java.lang.String) <em>Create SAnnotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#createSAnnotation(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void testCreateSAnnotation__String_String_String() {
		//TODO: finish
//		String sNS = "ns";
//		String sName = "name";
//		String sValueString = "valuestring"; 
//		this.getFixture().createSAnnotation(sNS, sName, sValueString);
	}
	
	/**
	 * Tests if the extraction of an annotations string works quite well.
	 */
	public void testCreateSAnnotations__String() {
		String annotationString="blub";
		getFixture().createSAnnotations(annotationString);
		assertNotNull(getFixture().getSAnnotation("blub"));
		
		annotationString="myNS::bla=blub;foo;x=y";
		getFixture().createSAnnotations(annotationString);
		assertEquals(4, getFixture().getSAnnotations().size());
		assertNotNull(getFixture().getSAnnotation("myNS::bla"));
		assertEquals("blub", getFixture().getSAnnotation("myNS::bla").getSValue());
		assertNotNull(getFixture().getSAnnotation("foo"));
		assertNotNull(getFixture().getSAnnotation("x"));
		assertEquals("y", getFixture().getSAnnotation("x").getSValue());
	}

	public void testReverseGetSAnnotation()
	{
		SAnnotation procAnno= SaltCoreFactory.eINSTANCE.createSAnnotation();
		procAnno.setName("labelName");
		this.getFixture().addLabel(procAnno);
		
		assertEquals(this.getFixture(), procAnno.getLabelableElement());
	}

} //SAnnotatableElementTest
