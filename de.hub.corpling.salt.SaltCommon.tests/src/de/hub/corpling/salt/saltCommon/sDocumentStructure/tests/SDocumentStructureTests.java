/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure.tests;

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
		suite.addTestSuite(SSequentialRelationTest.class);
		suite.addTestSuite(SSequentialDSTest.class);
		suite.addTestSuite(STimelineTest.class);
		suite.addTestSuite(STimelineRelationTest.class);
		suite.addTestSuite(SSpanTest.class);
		suite.addTestSuite(SSpanningRelationTest.class);
		suite.addTestSuite(STextOverlappingRelationTest.class);
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
