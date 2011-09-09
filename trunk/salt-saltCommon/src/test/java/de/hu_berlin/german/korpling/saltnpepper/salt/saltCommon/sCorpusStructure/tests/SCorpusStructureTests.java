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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.tests;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.tests.SCorpusDocumentRelationTest;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.tests.SCorpusGraphTest;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.tests.SCorpusRelationTest;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.tests.SCorpusStructureTests;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.tests.SCorpusTest;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.tests.SDocumentTest;
import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>sCorpusStructure</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class SCorpusStructureTests extends TestSuite {

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
		TestSuite suite = new SCorpusStructureTests("sCorpusStructure Tests");
		suite.addTestSuite(SCorpusGraphTest.class);
		suite.addTestSuite(SDocumentTest.class);
		suite.addTestSuite(SCorpusTest.class);
		suite.addTestSuite(SCorpusRelationTest.class);
		suite.addTestSuite(SCorpusDocumentRelationTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCorpusStructureTests(String name) {
		super(name);
	}

} //SCorpusStructureTests
