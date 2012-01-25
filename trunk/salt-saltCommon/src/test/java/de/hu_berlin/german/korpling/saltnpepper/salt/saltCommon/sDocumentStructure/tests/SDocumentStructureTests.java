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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.tests;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.tests.SDocumentGraphTest;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.tests.SDocumentStructureTests;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.tests.SDominanceRelationTest;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.tests.SPointingRelationTest;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.tests.SSpanTest;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.tests.SSpanningRelationTest;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.tests.SStructureTest;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.tests.STextualDSTest;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.tests.STextualRelationTest;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.tests.STimelineRelationTest;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.tests.STimelineTest;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.tests.STokenTest;
import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>sDocumentStructure</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class SDocumentStructureTests extends TestSuite {

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
		TestSuite suite = new SDocumentStructureTests("sDocumentStructure Tests");
		suite.addTestSuite(SDocumentGraphTest.class);
		suite.addTestSuite(STextualDSTest.class);
		suite.addTestSuite(STokenTest.class);
		suite.addTestSuite(STextualRelationTest.class);
		suite.addTestSuite(STimelineTest.class);
		suite.addTestSuite(STimelineRelationTest.class);
		suite.addTestSuite(SSpanTest.class);
		suite.addTestSuite(SSpanningRelationTest.class);
		suite.addTestSuite(SStructureTest.class);
		suite.addTestSuite(SPointingRelationTest.class);
		suite.addTestSuite(SDominanceRelationTest.class);
		suite.addTestSuite(SDataSourceSequenceTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDocumentStructureTests(String name) {
		super(name);
	}

} //SDocumentStructureTests
