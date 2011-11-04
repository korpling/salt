/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.tests;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltValidateException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructureFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;

import junit.framework.TestCase;

import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SData Source Sequence</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence#validate() <em>Validate</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SDataSourceSequenceTest extends TestCase {

	/**
	 * The fixture for this SData Source Sequence test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDataSourceSequence fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SDataSourceSequenceTest.class);
	}

	/**
	 * Constructs a new SData Source Sequence test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDataSourceSequenceTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SData Source Sequence test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SDataSourceSequence fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SData Source Sequence test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDataSourceSequence getFixture() {
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
		setFixture(SDocumentStructureFactory.eINSTANCE.createSDataSourceSequence());
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence#validate() <em>Validate</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence#validate()
	 */
	public void testValidate() 
	{
		String text= "A sample text.";
		STextualDS sText= SaltFactory.eINSTANCE.createSTextualDS();
		sText.setSText(text);
		this.getFixture().setSSequentialDS(sText);
		
		try {
			this.getFixture().validate();
			fail("this should not be valide.");
		} catch (SaltValidateException e) {
		}
		this.getFixture().setSStart(1);
		try{
			this.getFixture().validate();
			fail("this should not be valide.");
		} catch (SaltValidateException e) {
		}
		this.getFixture().setSEnd(2);
		assertTrue(this.getFixture().validate());
		
		this.getFixture().setSEnd(text.length()+ 3);
		try {
			this.getFixture().validate();
			fail("this should not be valide.");
		} catch (SaltValidateException e) {
		}
	}
	

} //SDataSourceSequenceTest
