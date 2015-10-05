/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.tests;

import junit.framework.TestCase;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructureFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SSequentialDSImpl;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SSequential DS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialDS#getSData() <em>SData</em>}</li>
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(new SSequentialDSInstance());
	}
	/**
	 * A Dummy class just for testing some methods of the fixture.
	 * @author Florian Zipser
	 *
	 */
	class SSequentialDSInstance extends SSequentialDSImpl{
		
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialDS#getSData() <em>SData</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialDS#getSData()
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialDS#setSData(java.lang.Object) <em>SData</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialDS#setSData(java.lang.Object)
	 */
	public void testSetSData() 
	{
		this.testGetSData();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialDS#getSStart() <em>SStart</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialDS#getSStart()
	 */
	public void testGetSStart() {
		try
		{
			this.getFixture().getSStart();
			fail("Calling this method shall invoke an unsupported operation exception");
		}catch (UnsupportedOperationException e) {
		}
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialDS#getSEnd() <em>SEnd</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialDS#getSEnd()
	 */
	public void testGetSEnd() {
		try
		{
			this.getFixture().getSEnd();
			fail("Calling this method shall invoke an unsupported operation exception");
		}catch (UnsupportedOperationException e) {
		}
	}
} //SSequentialDSTest
