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

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCoreFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SMeta Annotatable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#getSMetaAnnotations() <em>SMeta Annotations</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#addSMetaAnnotation(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation) <em>Add SMeta Annotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#getSMetaAnnotation(java.lang.String) <em>Get SMeta Annotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#createSMetaAnnotation(java.lang.String, java.lang.String, java.lang.Object, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE) <em>Create SMeta Annotation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#createSMetaAnnotation(java.lang.String, java.lang.String, java.lang.String) <em>Create SMeta Annotation</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SMetaAnnotatableElementTest extends TestCase {

	/**
	 * The fixture for this SMeta Annotatable Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SMetaAnnotatableElement fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SMetaAnnotatableElementTest.class);
	}

	/**
	 * Constructs a new SMeta Annotatable Element test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SMetaAnnotatableElementTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SMeta Annotatable Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SMetaAnnotatableElement fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SMeta Annotatable Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SMetaAnnotatableElement getFixture() {
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
		setFixture(SaltCoreFactory.eINSTANCE.createSMetaAnnotatableElement());
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#getSMetaAnnotations() <em>SProcessing MetaAnnotations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#getSMetaAnnotations()
	 */
	public void testGetSMetaAnnotations() 
	{
		String[] QNames= {"ns::name1", "ns::name2", "ns::name3", "ns::name4"};
		EList<SMetaAnnotation> sProcMetaAnnos= new BasicEList<SMetaAnnotation>();
		for (String QName: QNames)
		{	
			SMetaAnnotation sProcMetaAnno1= SaltCoreFactory.eINSTANCE.createSMetaAnnotation();
			sProcMetaAnno1.setQName(QName);
			this.getFixture().addSMetaAnnotation(sProcMetaAnno1);
			sProcMetaAnnos.add(sProcMetaAnno1);
		}
		
		assertTrue(sProcMetaAnnos.containsAll(this.getFixture().getSMetaAnnotations()));
		assertTrue(this.getFixture().getSMetaAnnotations().containsAll(sProcMetaAnnos));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#addSMetaAnnotation(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation) <em>Add SProcessing MetaAnnotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#addSMetaAnnotation(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation)
	 */
	public void testAddSMetaAnnotation__SMetaAnnotation() 
	{
		String QName= "ns::name";
		SMetaAnnotation sProcMetaAnno= SaltCoreFactory.eINSTANCE.createSMetaAnnotation();
		sProcMetaAnno.setQName(QName);
		this.getFixture().addSMetaAnnotation(sProcMetaAnno);
		assertEquals(sProcMetaAnno, this.getFixture().getSMetaAnnotation(QName));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#getSMetaAnnotation(java.lang.String) <em>Get SProcessing MetaAnnotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#getSMetaAnnotation(java.lang.String)
	 */
	public void testGetSMetaAnnotation__String() 
	{
		this.testAddSMetaAnnotation__SMetaAnnotation();
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#createSMetaAnnotation(java.lang.String, java.lang.String, java.lang.Object, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE) <em>Create SMeta Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#createSMetaAnnotation(java.lang.String, java.lang.String, java.lang.Object, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE)
	 */
	public void testCreateSMetaAnnotation__String_String_Object_SDATATYPE() {
		String name = "name";
		String namespace = "namespace";
		String value = "value";
		SMetaAnnotation metaAnno = this.getFixture().createSMetaAnnotation(namespace, name, value, SDATATYPE.STEXT);
		assertEquals(metaAnno, this.getFixture().getSMetaAnnotations().get(this.getFixture().getSMetaAnnotations().size()-1));
		assertEquals(metaAnno, this.getFixture().getSMetaAnnotation(namespace+"::"+name));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#createSMetaAnnotation(java.lang.String, java.lang.String, java.lang.String) <em>Create SMeta Annotation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#createSMetaAnnotation(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void testCreateSMetaAnnotation__String_String_String() {
		this.testCreateSMetaAnnotation__String_String_Object_SDATATYPE();
	}

	public void testReverseGetSMetaAnnotation()
	{
		SMetaAnnotation procMetaAnno= SaltCoreFactory.eINSTANCE.createSMetaAnnotation();
		procMetaAnno.setSName("labelName");
		this.getFixture().addLabel(procMetaAnno);
		
		assertEquals(this.getFixture(), procMetaAnno.getLabelableElement());
	}

} //SMetaAnnotatableElementTest
