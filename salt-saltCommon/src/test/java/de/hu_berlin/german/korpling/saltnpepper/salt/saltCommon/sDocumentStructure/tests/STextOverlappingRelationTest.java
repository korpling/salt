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

import junit.framework.TestCase;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextOverlappingRelation;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SText Overlapping Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextOverlappingRelation#isSTextOverlapping() <em>Is SText Overlapping</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public abstract class STextOverlappingRelationTest extends TestCase {

	/**
	 * The fixture for this SText Overlapping Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected STextOverlappingRelation fixture = null;

	/**
	 * Constructs a new SText Overlapping Relation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STextOverlappingRelationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SText Overlapping Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(STextOverlappingRelation fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SText Overlapping Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected STextOverlappingRelation getFixture() {
		return fixture;
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

} //STextOverlappingRelationTest
