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

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>saltCore</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class SaltCoreTests extends TestSuite {

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
		TestSuite suite = new SaltCoreTests("saltCore Tests");
		suite.addTestSuite(SNodeTest.class);
		suite.addTestSuite(SRelationTest.class);
		suite.addTestSuite(SAnnotatableElementTest.class);
		suite.addTestSuite(SAnnotationTest.class);
		suite.addTestSuite(SGraphTest.class);
		suite.addTestSuite(SIdentifiableElementTest.class);
		suite.addTestSuite(SProcessingAnnotationTest.class);
		suite.addTestSuite(SProcessingAnnotatableElementTest.class);
		suite.addTestSuite(SElementIdTest.class);
		suite.addTestSuite(SFeatureTest.class);
		suite.addTestSuite(SFeaturableElementTest.class);
		suite.addTestSuite(SMetaAnnotatableElementTest.class);
		suite.addTestSuite(SMetaAnnotationTest.class);
		suite.addTestSuite(SLayerTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltCoreTests(String name) {
		super(name);
	}

} //SaltCoreTests
