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

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNamedElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCoreFactory;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SNamed Element</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SNamedElementTest extends TestCase {

	/**
	 * The fixture for this SNamed Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SNamedElement fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SNamedElementTest.class);
	}

	/**
	 * Constructs a new SNamed Element test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SNamedElementTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SNamed Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SNamedElement fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SNamed Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SNamedElement getFixture() {
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
		setFixture(SaltCoreFactory.eINSTANCE.createSNamedElement());
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
	
	public void testGetName()
	{
		String name= "name";
		this.getFixture().setSName(name);
		assertEquals(name, this.getFixture().getSName());
	}

} //SNamedElementTest
