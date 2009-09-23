/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure.tests;

import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructureFactory;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeOverlappingRelation;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>STime Overlapping Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeOverlappingRelation#isSTimeOverlapping() <em>Is STime Overlapping</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public abstract class STimeOverlappingRelationTest extends TestCase {

	/**
	 * The fixture for this STime Overlapping Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected STimeOverlappingRelation fixture = null;

	/**
	 * Constructs a new STime Overlapping Relation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STimeOverlappingRelationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this STime Overlapping Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(STimeOverlappingRelation fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this STime Overlapping Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected STimeOverlappingRelation getFixture() {
		return fixture;
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeOverlappingRelation#isSTimeOverlapping() <em>Is STime Overlapping</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeOverlappingRelation#isSTimeOverlapping()
	 */
	public void testIsSTimeOverlapping() 
	{
		assertTrue(this.getFixture().isSTimeOverlapping());
	}

} //STimeOverlappingRelationTest
