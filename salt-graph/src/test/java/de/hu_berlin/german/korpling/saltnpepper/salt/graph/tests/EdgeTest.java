/**
 * Copyright 2009 Humboldt University of Berlin, INRIA.
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
package de.hu_berlin.german.korpling.saltnpepper.salt.graph.tests;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class EdgeTest extends IdentifiableElementTest {

	protected IdentifiableElementTest identifiableElementTest= null;
	
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static void main(String[] args) {
        TestRunner.run(EdgeTest.class);
    }

	/**
     * Constructs a new Edge test case with the given name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EdgeTest(String name) {
        super(name);
    }

	/**
     * Returns the fixture for this Edge test case.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected Edge getFixture() {
        return (Edge)fixture;
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GraphFactory.eINSTANCE.createEdge());
		this.identifiableElementTest= new IdentifiableElementTest(this.getName());
		this.identifiableElementTest.setUp();
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement#getId() <em>Id</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement#getId()
	 */
	public void testGetId() 
	{
		String id= "id1";
		this.getFixture().setId(id);
		assertEquals(id, this.getFixture().getId());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement#setId(java.lang.String) <em>Id</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement#setId(java.lang.String)
	 */
	public void testSetId() 
	{
		this.testGetId();
	}

	/**
	 * Tests the '{@link de.util.graph.LabeledElement#getLabel(java.lang.String, java.lang.String) <em>Get Label</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.LabeledElement#getLabel(java.lang.String, java.lang.String)
	 */
	public void testGetLabel__String_String() 
	{
		this.identifiableElementTest.testGetLabel__String_String();
	}

	/**
	 * Tests the '{@link de.util.graph.LabeledElement#addLabel(de.util.graph.Label) <em>Add Label</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.LabeledElement#addLabel(de.util.graph.Label)
	 */
	public void testAddLabel__Label() 
	{
		this.identifiableElementTest.testAddLabel__Label();
	}

	/**
	 * Tests the '{@link de.util.graph.LabeledElement#getLabelString(java.lang.String, java.lang.String) <em>Get Label String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.LabeledElement#getLabelString(java.lang.String, java.lang.String)
	 */
	public void testGetLabelString__String_String() 
	{
		this.identifiableElementTest.testGetLabelString__String_String();
	}

	/**
	 * Tests the '{@link de.util.graph.LabeledElement#getLabelString(java.lang.String) <em>Get Label String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.LabeledElement#getLabelString(java.lang.String)
	 */
	public void testGetLabelString__String() 
	{
		this.identifiableElementTest.testGetLabelString__String();
	}

	/**
	 * Tests the '{@link de.util.graph.LabeledElement#removeLabel(java.lang.String) <em>Remove Label</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.LabeledElement#removeLabel(java.lang.String)
	 */
	public void testRemoveLabel__String() 
	{
		this.identifiableElementTest.testRemoveLabel__String();
	}

	/**
	 * Tests the '{@link de.util.graph.LabeledElement#getNumOfLabels() <em>Get Num Of Labels</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.LabeledElement#getNumOfLabels()
	 */
	public void testGetNumOfLabels() 
	{
		this.identifiableElementTest.testGetNumOfLabels();
	}

	/**
	 * Tests the '{@link de.util.graph.LabeledElement#removeAll() <em>Remove All</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.LabeledElement#removeAll()
	 */
	public void testRemoveAll()   throws Exception
	{
		this.identifiableElementTest.testRemoveAll();
	}

	/**
	 * Tests the '{@link de.util.graph.LabeledElement#getLabelsByNamespace(java.lang.String) <em>Get Labels By Namespace</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.LabeledElement#getLabelsByNamespace(java.lang.String)
	 */
	public void testGetLabelsByNamespace__String() 
	{
		this.identifiableElementTest.testGetLabelsByNamespace__String();
	}

	/**
	 * Tests the '{@link de.util.graph.LabeledElement#hasLabel(java.lang.String) <em>Has Label</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.LabeledElement#hasLabel(java.lang.String)
	 */
	public void testHasLabel__String() 
	{
		this.identifiableElementTest.testHasLabel__String();
	}

	/**
	 * Tests the '{@link de.util.graph.LabeledElement#getLabel(java.lang.String) <em>Get Label</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.LabeledElement#getLabel(java.lang.String)
	 */
	public void testGetLabel__String() 
	{
		this.identifiableElementTest.testGetLabel__String();
	}
	
	public void testReverseGetLabel()
	{
		Label label= GraphFactory.eINSTANCE.createLabel();
		label.setName("labelName");
		this.getFixture().addLabel(label);
		
		assertEquals(this.getFixture(), label.getLabelableElement());
	}
	
	/**
	 * Checks the method equals() and hashCode()
	 */
	public void testEquals()
	{
		Edge edge2= null;
		
		edge2= this.getFixture();
		assertTrue(this.getFixture().equals(edge2));
		
		edge2= null;
		assertFalse(this.getFixture().equals(edge2));
		
		//two edge objects with nothing
		edge2= GraphFactory.eINSTANCE.createEdge();
		assertEquals(this.getFixture(), edge2);
		
		edge2.setIdentifier(this.getFixture().getIdentifier());
		assertFalse(this.getFixture().equals(edge2));
	}

} //EdgeTest
