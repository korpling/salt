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

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;
import junit.textui.TestRunner;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class NodeTest extends IdentifiableElementTest 
{
	protected GraphFactory factory= null;
	
	protected IdentifiableElementTest identifiableElementTest= null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(NodeTest.class);
	}

	/**
	 * Constructs a new Node test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Node test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Node getFixture() {
		return (Node)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * 
	 */
	@Override
	protected void setUp() throws Exception 
	{
		super.setUp();
		setFixture(GraphFactory.eINSTANCE.createNode());
		this.factory= GraphFactory.eINSTANCE;
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

	
	/**
	 * Tests handling of labels in node.
	 */
	public void testLabelHandling()
	{
		Node node= this.getFixture();
		Label label= this.factory.createLabel();
		
		//adding normal Label
		String name= "name";
		String namespace= "ns1::ns2::ns3";
		String QName= namespace + "::" + name;
		String value= "val1";
		
		label.setQName(QName);
		label.setValue(value);
		node.addLabel(label);
		//adding two attributes with same full names should fail
		try 
		{
			node.addLabel(label);
			fail("adding two attributes with same full names should fail");
		} catch (Exception e) 
		{}
		
		Label retLabel= node.getLabel(QName);
		assertEquals(label, retLabel);
		assertEquals(name, (String)retLabel.getName());
		assertEquals(value, retLabel.getValue());
		assertEquals(QName, (String)retLabel.getQName());	
	}
	
	public void testReverseGetLabel()
	{
		Label label= this.factory.createLabel();
		label.setName("labelName");
		this.getFixture().addLabel(label);
		
		assertEquals(this.getFixture(), label.getLabelableElement());
	}
	
	/**
	 * Tests the methods equals() and hachCode().
	 */
	public void testEquals()
	{
		this.basicTestEquals(GraphFactory.eINSTANCE.createNode());
	}

} //NodeTest
