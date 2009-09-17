/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure.tests;

import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructureFactory;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialRelation;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SSequential Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialRelation#getSStart() <em>SStart</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialRelation#getSEnd() <em>SEnd</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SSequentialRelationTest extends TestCase {

	/**
	 * The fixture for this SSequential Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SSequentialRelation fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SSequentialRelationTest.class);
	}

	/**
	 * Constructs a new SSequential Relation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SSequentialRelationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SSequential Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SSequentialRelation fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SSequential Relation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SSequentialRelation getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SDocumentStructureFactory.eINSTANCE.createSSequentialRelation());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}
	
	public void testGetSStart() 
	{
		Integer start= 1;
		this.getFixture().setSStart(start);
		assertEquals(start, this.getFixture().getSStart());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS#setSText(java.lang.String) <em>SText</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS#setSText(java.lang.String)
	 */
	public void testSetSStart() 
	{
		this.testGetSStart();
	}
	
	public void testGetSEnd() 
	{
		Integer end= 1;
		this.getFixture().setSEnd(end);
		assertEquals(end, this.getFixture().getSEnd());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS#setSText(java.lang.String) <em>SText</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS#setSText(java.lang.String)
	 */
	public void testSetSEnd() 
	{
		this.testGetSEnd();
	}

} //SSequentialRelationTest
