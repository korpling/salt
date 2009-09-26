/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltSemantics.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test suite for the '<em><b>saltSemantics</b></em>' package.
 * <!-- end-user-doc -->
 * @generated
 */
public class SaltSemanticsTests extends TestSuite {

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
		TestSuite suite = new SaltSemanticsTests("saltSemantics Tests");
		suite.addTestSuite(SPOSAnnotationTest.class);
		suite.addTestSuite(SLemmaAnnotationTest.class);
		suite.addTestSuite(SCatAnnotationTest.class);
		suite.addTestSuite(STypeAnnotationTest.class);
		suite.addTestSuite(SWordAnnotationTest.class);
		suite.addTestSuite(SSentenceAnnotationTest.class);
		return suite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltSemanticsTests(String name) {
		super(name);
	}

} //SaltSemanticsTests
