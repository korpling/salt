/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sCorpusStructure.tests;

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
