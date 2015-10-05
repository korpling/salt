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
package de.hu_berlin.german.korpling.saltnpepper.salt.graph.tests;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.tests.IndexTests;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.tests.ModuleTests;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.storing.tests.StoringTests;
import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>Graph</b></em>' model.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphAllTests extends TestSuite {

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
	*/
	public static Test suite() {
		TestSuite suite = new GraphAllTests("Graph Tests");
		suite.addTest(GraphTests.suite());
		suite.addTest(IndexTests.suite());
		suite.addTest(StoringTests.suite());
		suite.addTest(ModuleTests.suite());
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphAllTests(String name) {
		super(name);
	}

} //GraphAllTests
