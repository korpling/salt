/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure.tests;

import junit.framework.TestCase;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextOverlappingRelation;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SText Overlapping Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextOverlappingRelation#isSTextOverlapping() <em>Is SText Overlapping</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public abstract class STextOverlappingRelationTest extends TestCase {

	/**
	 * The fixture for this SText Overlapping Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected STextOverlappingRelation fixture = null;

	/**
	 * Constructs a new SText Overlapping Relation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STextOverlappingRelationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SText Overlapping Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(STextOverlappingRelation fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SText Overlapping Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected STextOverlappingRelation getFixture() {
		return fixture;
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextOverlappingRelation#isSTextOverlapping() <em>Is SText Overlapping</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STextOverlappingRelation#isSTextOverlapping()
	 */
	public void testIsSTextOverlapping() 
	{
		assertTrue(this.getFixture().isSTextOverlapping());
	}

} //STextOverlappingRelationTest
