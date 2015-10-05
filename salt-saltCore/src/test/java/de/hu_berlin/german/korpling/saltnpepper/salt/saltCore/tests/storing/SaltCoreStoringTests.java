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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.tests.storing;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.tests.storing.SAnnotationStoringTest;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.tests.storing.SGraphStoringTest;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.tests.storing.SIdentifiableElementStoringTest;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.tests.storing.SNodeStoringTest;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.tests.storing.SRelationStoringTest;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.tests.storing.SaltCoreStoringTests;
import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>saltCore</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class SaltCoreStoringTests extends TestSuite {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Test suite() {
		TestSuite suite = new SaltCoreStoringTests("saltCoreStoring Tests");
		suite.addTestSuite(SAnnotationStoringTest.class);
		suite.addTestSuite(SGraphStoringTest.class);
		suite.addTestSuite(SIdentifiableElementStoringTest.class);
		suite.addTestSuite(SNodeStoringTest.class);
		suite.addTestSuite(SRelationStoringTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltCoreStoringTests(String name) {
		super(name);
	}

} //SaltCoreTests
