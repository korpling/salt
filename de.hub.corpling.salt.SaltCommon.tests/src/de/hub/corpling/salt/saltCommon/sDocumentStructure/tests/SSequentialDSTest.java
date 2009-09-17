/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure.tests;

import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructureFactory;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialDS;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SSequential DS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialDS#getSData() <em>SData</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SSequentialDSTest extends TestCase {

	/**
	 * The fixture for this SSequential DS test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SSequentialDS fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SSequentialDSTest.class);
	}

	/**
	 * Constructs a new SSequential DS test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SSequentialDSTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SSequential DS test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SSequentialDS fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SSequential DS test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SSequentialDS getFixture() {
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
		setFixture(SDocumentStructureFactory.eINSTANCE.createSSequentialDS());
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
	
	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS#getSText() <em>SText</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS#getSText()
	 */
	public void testGetSData() 
	{
		Object data= new Object();
		this.getFixture().setSData(data);
		assertEquals(data, this.getFixture().getSData());
		
		String text= "text";
		this.getFixture().setSData(text);
		assertEquals(text, this.getFixture().getSData());
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS#setSText(java.lang.String) <em>SText</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS#setSText(java.lang.String)
	 */
	public void testSetSData() 
	{
		this.testGetSData();
	}

} //SSequentialDSTest
