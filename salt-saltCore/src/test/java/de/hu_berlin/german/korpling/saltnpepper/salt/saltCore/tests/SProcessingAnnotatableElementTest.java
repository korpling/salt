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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.tests;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCoreFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SProcessing Annotatable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotations() <em>SProcessing Annotations</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#addSProcessingAnnotation(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation) <em>Add SProcessing Annotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotation(java.lang.String) <em>Get SProcessing Annotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#createSProcessingAnnotation(java.lang.String, java.lang.String, java.lang.Object, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE) <em>Create SProcessing Annotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#createSProcessingAnnotation(java.lang.String, java.lang.String, java.lang.String) <em>Create SProcessing Annotation</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SProcessingAnnotatableElementTest extends TestCase {

	/**
	 * The fixture for this SProcessing Annotatable Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SProcessingAnnotatableElement fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SProcessingAnnotatableElementTest.class);
	}

	/**
	 * Constructs a new SProcessing Annotatable Element test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SProcessingAnnotatableElementTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SProcessing Annotatable Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SProcessingAnnotatableElement fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SProcessing Annotatable Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SProcessingAnnotatableElement getFixture() {
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
		setFixture(SaltCoreFactory.eINSTANCE.createSProcessingAnnotatableElement());
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotations() <em>SProcessing Annotations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotations()
	 */
	public void testGetSProcessingAnnotations() 
	{
		String[] QNames= {"ns::name1", "ns::name2", "ns::name3", "ns::name4"};
		EList<SProcessingAnnotation> sProcAnnos= new BasicEList<SProcessingAnnotation>();
		for (String QName: QNames)
		{	
			SProcessingAnnotation sProcAnno1= SaltCoreFactory.eINSTANCE.createSProcessingAnnotation();
			sProcAnno1.setQName(QName);
			this.getFixture().addSProcessingAnnotation(sProcAnno1);
			sProcAnnos.add(sProcAnno1);
		}
		for (String qName: QNames)
		{	
			assertNotNull(this.getFixture().getSProcessingAnnotation(qName));
		}
		assertTrue(sProcAnnos.containsAll(this.getFixture().getSProcessingAnnotations()));
		assertTrue(this.getFixture().getSProcessingAnnotations().containsAll(sProcAnnos));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#addSProcessingAnnotation(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation) <em>Add SProcessing Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#addSProcessingAnnotation(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation)
	 */
	public void testAddSProcessingAnnotation__SProcessingAnnotation() 
	{
		String QName= "ns::name";
		SProcessingAnnotation sProcAnno= SaltCoreFactory.eINSTANCE.createSProcessingAnnotation();
		sProcAnno.setQName(QName);
		this.getFixture().addSProcessingAnnotation(sProcAnno);
		assertEquals(sProcAnno, this.getFixture().getSProcessingAnnotation(QName));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotation(java.lang.String) <em>Get SProcessing Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotation(java.lang.String)
	 */
	public void testGetSProcessingAnnotation__String() 
	{
		this.testAddSProcessingAnnotation__SProcessingAnnotation();
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#createSProcessingAnnotation(java.lang.String, java.lang.String, java.lang.Object, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE) <em>Create SProcessing Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#createSProcessingAnnotation(java.lang.String, java.lang.String, java.lang.Object, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE)
	 */
	public void testCreateSProcessingAnnotation__String_String_Object_SDATATYPE() {
		String name = "name";
		String namespace = "namespace";
		String value = "value";
		SProcessingAnnotation procAnno = this.getFixture().createSProcessingAnnotation(namespace, name, value, SDATATYPE.STEXT);
		assertEquals(procAnno, this.getFixture().getSProcessingAnnotations().get(this.getFixture().getSProcessingAnnotations().size()-1));
		assertEquals(procAnno, this.getFixture().getSProcessingAnnotation(namespace+"::"+name));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#createSProcessingAnnotation(java.lang.String, java.lang.String, java.lang.String) <em>Create SProcessing Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#createSProcessingAnnotation(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void testCreateSProcessingAnnotation__String_String_String() {
		this.testCreateSProcessingAnnotation__String_String_Object_SDATATYPE();
	}

	public void testReverseGetSProcessingAnnotation()
	{
		SProcessingAnnotation procAnno= SaltCoreFactory.eINSTANCE.createSProcessingAnnotation();
		procAnno.setName("labelName");
		this.getFixture().addLabel(procAnno);
		
		assertEquals(this.getFixture(), procAnno.getLabelableElement());
	}

} //SProcessingAnnotatableElementTest
