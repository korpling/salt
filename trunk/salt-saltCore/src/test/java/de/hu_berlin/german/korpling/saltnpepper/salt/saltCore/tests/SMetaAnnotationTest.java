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
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCoreFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SMeta Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation#getSMetaAnnotatableElement() <em>SMeta Annotatable Element</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SMetaAnnotationTest extends SAbstractAnnotationTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SMetaAnnotationTest.class);
	}

	/**
	 * Constructs a new SMeta Annotation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SMetaAnnotationTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this SMeta Annotation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SMetaAnnotation getFixture() {
		return (SMetaAnnotation)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SaltCoreFactory.eINSTANCE.createSMetaAnnotation());
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation#getSMetaAnnotatableElement() <em>SMetaAnnotatable Element</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation#getSMetaAnnotatableElement()
	 */
	public void testGetSMetaAnnotatableElement() 
	{
		SMetaAnnotatableElement sAElement= SaltCoreFactory.eINSTANCE.createSMetaAnnotatableElement();
		this.getFixture().setSMetaAnnotatableElement(sAElement);
		assertEquals(sAElement, this.getFixture().getSMetaAnnotatableElement());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation#setSMetaAnnotatableElement(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement) <em>SMetaAnnotatable Element</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation#setSMetaAnnotatableElement(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement)
	 */
	public void testSetSMetaAnnotatableElement() 
	{
		this.testGetSMetaAnnotatableElement();
	}
} //SMetaAnnotationTest
