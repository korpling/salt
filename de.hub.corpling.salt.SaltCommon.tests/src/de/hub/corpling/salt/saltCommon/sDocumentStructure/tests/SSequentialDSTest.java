/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure.tests;

import junit.framework.TestCase;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialDS;

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
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialDS#getSData() <em>SData</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialDS#getSData()
	 */
	public void testGetSData() 
	{
		Object data= new Object();
		if (this.getFixture()!= null)
		{	
			this.getFixture().setSData(data);
			assertEquals(data, this.getFixture().getSData());
			
			String text= "text";
			this.getFixture().setSData(text);
			assertEquals(text, this.getFixture().getSData());
		}
	}

	/**
	 * Tests the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialDS#setSData(java.lang.Object) <em>SData</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialDS#setSData(java.lang.Object)
	 */
	public void testSetSData() 
	{
		this.testGetSData();
	}

	public void testNothingToTest()
	{
		
	}
} //SSequentialDSTest
