/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure.tests.storing;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>sDocumentStructure</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class SDocumentStructureStoringTests extends TestSuite {

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
		TestSuite suite = new SDocumentStructureStoringTests("sDocumentStructure Tests");
		suite.addTestSuite(SDocumentGraphStoringTest.class);
		suite.addTestSuite(STimelineStoringTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDocumentStructureStoringTests(String name) {
		super(name);
	}

} //SDocumentStructureTests
