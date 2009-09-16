/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore.tests;

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
