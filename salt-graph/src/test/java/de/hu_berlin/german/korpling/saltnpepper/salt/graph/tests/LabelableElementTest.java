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
package de.hu_berlin.german.korpling.saltnpepper.salt.graph.tests;

import java.util.Arrays;
import java.util.Vector;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.util.EList;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Labeled Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement#addLabel(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label) <em>Add Label</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement#getLabel(java.lang.String, java.lang.String) <em>Get Label</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement#getLabel(java.lang.String) <em>Get Label</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement#removeLabel(java.lang.String) <em>Remove Label</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement#getNumOfLabels() <em>Get Num Of Labels</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement#removeAll() <em>Remove All</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement#getLabelsByNamespace(java.lang.String) <em>Get Labels By Namespace</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement#hasLabel(java.lang.String) <em>Has Label</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement#removeLabel(java.lang.String, java.lang.String) <em>Remove Label</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement#differences(java.lang.Object) <em>Differences</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class LabelableElementTest extends TestCase {

	/**
	 * The fixture for this Labelable Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LabelableElement fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(LabelableElementTest.class);
	}

	/**
	 * Constructs a new Labelable Element test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LabelableElementTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Labelable Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(LabelableElement fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Labelable Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LabelableElement getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		this.setFixture(GraphFactory.eINSTANCE.createLabelableElement());
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

	
	public void testAddingGettingLabels()
	{
		LabelableElement labelableElement= this.getFixture();
		Label label= null; 
		
		//test 1 - should fail
		try {
			labelableElement.addLabel(null);
			fail("shouldn't add an empty label");
		} catch (Exception e) {
		}
		
		//test 2 - add all
		String[] labelNames= {"label1", "label2", "label3", "label4", "label5"};
		
		for (String labelName: labelNames)
		{
			label= GraphFactory.eINSTANCE.createLabel();
			label.setName(labelName);
			labelableElement.addLabel(label);
			assertEquals(label, labelableElement.getLabel(labelName));
		}
	}
		
	public void testAddingRemovingLabels()
	{
		LabelableElement labelableElement= this.getFixture();
		Label label= null; 
		
		String[] labelNames= {"label1", "label2", "label3", "label4", "label5"};
		String label1= "label1";
		int numOfLabels= labelNames.length + labelableElement.getNumOfLabels();
		
		//test 1 - should fail
		for (String labelName: labelNames)
		{
			label= GraphFactory.eINSTANCE.createLabel();
			label.setName(labelName);
			labelableElement.addLabel(label);
		}
		assertEquals(numOfLabels, labelableElement.getNumOfLabels());
		try 
		{
			for (String labelName: labelNames)
			{
				label= GraphFactory.eINSTANCE.createLabel();
				label.setName(labelName);
				labelableElement.addLabel(label);
				fail("You should not add two labels with same name");
			}
			
		} catch (Exception e) {
		}
		
		//test 2 remove all
		for (String labelName: labelNames)
		{
			labelableElement.removeLabel(labelName);
		}
		numOfLabels= 0;
		
		assertEquals(numOfLabels, labelableElement.getNumOfLabels());
		for (String labelName: labelNames)
		{
			label= GraphFactory.eINSTANCE.createLabel();
			label.setName(labelName);
			labelableElement.addLabel(label);
		}
		numOfLabels= labelNames.length;
		assertEquals(numOfLabels, labelableElement.getNumOfLabels());
		for (String labelName: labelNames)
		{
			labelableElement.removeLabel(labelName);
		}
		
		//test removing one element and adding again
		for (String labelName: labelNames)
		{
			label= GraphFactory.eINSTANCE.createLabel();
			label.setName(labelName);
			labelableElement.addLabel(label);
		}
		numOfLabels= labelNames.length;
		assertEquals(numOfLabels, labelableElement.getNumOfLabels());
		labelableElement.removeLabel(label1);
		numOfLabels= numOfLabels-1;
		assertEquals(numOfLabels, labelableElement.getNumOfLabels());
		label= GraphFactory.eINSTANCE.createLabel();
		label.setName(label1);
		labelableElement.addLabel(label);
		assertEquals(label, labelableElement.getLabel(label1));
	}
	
	public void testRemoveAll()   throws Exception
	{
		LabelableElement labelableElement= this.getFixture();
		Label label= null; 
		String[] labelNames= {"label1", "label2", "label3", "label4", "label5"};
		int numOfLabels= labelNames.length + labelableElement.getNumOfLabels();
		
		//testing removing all elements by removeAll()
		for (String labelName: labelNames)
		{
			label= GraphFactory.eINSTANCE.createLabel();
			label.setName(labelName);
			labelableElement.addLabel(label);
			assertEquals(label, labelableElement.getLabel(labelName));
		}
		assertEquals(numOfLabels, labelableElement.getNumOfLabels());
		labelableElement.removeAll();
		assertEquals(0, labelableElement.getNumOfLabels());
		for (String labelName: labelNames)
		{
			assertNull(labelableElement.getLabel(labelName));
		}
	}
	
	/**
	 * Tests the '{@link de.util.graph.LabelableElement#getLabelsByNamespace(java.lang.String) <em>Get Labels By Namespace</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.LabelableElement#getLabelsByNamespace(java.lang.String)
	 */
	public void testGetLabelsByNamespace__String() 
	{
		LabelableElement labelableElement= this.getFixture();
		Label label= null; 
		String ns1= "ns1";
		String ns2= null;
		String ns3= "ns2";
		String[] labelNames1= {"ns1::label1", "ns1::label2"};
		String[] labelNames2= {"label3"};
		String[] labelNames3= {"ns2::label2", "ns2::label3", "ns2::label4"};
		Vector<String> labelNames= new Vector<String>();
		labelNames.addAll(new Vector<String>(Arrays.asList(labelNames1)));
		labelNames.addAll(new Vector<String>(Arrays.asList(labelNames2)));
		labelNames.addAll(new Vector<String>(Arrays.asList(labelNames3)));
		for (String labelName: labelNames)
		{
			label= GraphFactory.eINSTANCE.createLabel();
			label.setQName(labelName);
			labelableElement.addLabel(label);
		}
		
		//searching for ns1
		EList<Label> labels= labelableElement.getLabelsByNamespace(ns1);
		assertEquals(labelNames1.length, labels.size());
		boolean found= false;
		for (String labelName: labelNames1)
		{
			found= false;
			for (Label searchLabel: labels)
			{
				if (searchLabel.getQName().equalsIgnoreCase(labelName))
					found= true;
			}	
			assertTrue("the searched value should be found", found);
		}
		
		//searching for ns2
		labels= labelableElement.getLabelsByNamespace(ns2);
		assertEquals(labelNames2.length, labels.size());
		found= false;
		for (String labelName: labelNames2)
		{
			found= false;
			for (Label searchLabel: labels)
			{
				if (searchLabel.getQName().equalsIgnoreCase(labelName))
					found= true;
			}	
			assertTrue("the searched value should be found", found);
		}
		
		//searching for ns3
		labels= labelableElement.getLabelsByNamespace(ns3);
		assertEquals(labelNames3.length, labels.size());
		found= false;
		for (String labelName: labelNames3)
		{
			found= false;
			for (Label searchLabel: labels)
			{
				if (searchLabel.getQName().equalsIgnoreCase(labelName))
					found= true;
			}	
			assertTrue("the searched value should be found", found);
		}
	
	}
	
	/**
	 * Tests the '{@link de.util.graph.LabelableElement#hasLabel(java.lang.String) <em>Has Label</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.LabelableElement#hasLabel(java.lang.String)
	 */
	public void testHasLabel__String() 
	{
		LabelableElement labelableElement= this.getFixture();
		Label label= null; 
		String[] labelNamesOK= {"ns1::label1", "ns1::label2", "label1", "ns:label4", "label6"};
		String[] labelNamesNOTOK= {"label2", "ns1::label6"};
		//add labels
		for (String labelName: labelNamesOK)
		{
			label= GraphFactory.eINSTANCE.createLabel();
			label.setQName(labelName);
			labelableElement.addLabel(label);
		}
		//checking existing labels
		for (String labelName: labelNamesOK)
		{
			assertTrue(this.getFixture().hasLabel(labelName));
		}
		//checking not existing labels
		for (String labelName: labelNamesNOTOK)
		{
			assertFalse(this.getFixture().hasLabel(labelName));
		}
		
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement#removeLabel(java.lang.String, java.lang.String) <em>Remove Label</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement#removeLabel(java.lang.String, java.lang.String)
	 */
	public void testRemoveLabel__String_String() 
	{
		Label label= GraphFactory.eINSTANCE.createLabel();
		label.setNamespace("ns1");
		label.setName("name1");
		
		this.getFixture().addLabel(label);
		
		assertTrue(this.getFixture().hasLabel(label.getQName()));
		this.getFixture().removeLabel(label.getNamespace(), label.getName());
		assertFalse(this.getFixture().hasLabel(label.getQName()));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement#differences(java.lang.Object) <em>Differences</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement#differences(java.lang.Object)
	 */
	public void testDifferences__Object() 
	{
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link de.util.graph.LabelableElement#addLabel(de.util.graph.Label) <em>Add Label</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.LabelableElement#addLabel(de.util.graph.Label)
	 */
	public void testAddLabel__Label() 
	{
	}

	/**
	 * Tests the '{@link de.util.graph.LabelableElement#getLabel(java.lang.String, java.lang.String) <em>Get Label</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.LabelableElement#getLabel(java.lang.String, java.lang.String)
	 */
	public void testGetLabel__String_String() 
	{
		Label label= GraphFactory.eINSTANCE.createLabel();
		label.setNamespace("sNS");
		label.setName("name");
		this.getFixture().addLabel(label);
		assertEquals(label, this.getFixture().getLabel(label.getNamespace(), label.getName()));
	}

	/**
	 * Tests the '{@link de.util.graph.LabelableElement#getLabel(java.lang.String) <em>Get Label</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.LabelableElement#getLabel(java.lang.String)
	 */
	public void testGetLabel__String() {
	}

	/**
	 * Tests the '{@link de.util.graph.LabelableElement#getLabelString(java.lang.String, java.lang.String) <em>Get Label String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.LabelableElement#getLabelString(java.lang.String, java.lang.String)
	 */
	public void testGetLabelString__String_String() {
	}

	/**
	 * Tests the '{@link de.util.graph.LabelableElement#getLabelString(java.lang.String) <em>Get Label String</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.LabelableElement#getLabelString(java.lang.String)
	 */
	public void testGetLabelString__String() {
	}

	/**
	 * Tests the '{@link de.util.graph.LabelableElement#removeLabel(java.lang.String) <em>Remove Label</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.LabelableElement#removeLabel(java.lang.String)
	 */
	public void testRemoveLabel__String() {
	}

	/**
	 * Tests the '{@link de.util.graph.LabelableElement#getNumOfLabels() <em>Get Num Of Labels</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.LabelableElement#getNumOfLabels()
	 */
	public void testGetNumOfLabels() {
	}
	
	/**
	 * Checks the method equals() and hashCode()
	 */
	public void testEquals()
	{
		LabelableElement other= GraphFactory.eINSTANCE.createLabelableElement();
		
		assertEquals(this.getFixture(), other);
		assertEquals(this.getFixture().hashCode(), other.hashCode());
		
		String name= "name";
		String namespace= "namespace";
		String value= "value";
		Label label1= GraphFactory.eINSTANCE.createLabel();
		Label label2= GraphFactory.eINSTANCE.createLabel();
		
		label1.setName(name);
		this.getFixture().addLabel(label1);
		assertFalse(this.getFixture().equals(other));
		assertFalse(this.getFixture().hashCode()== other.hashCode());
		label2.setName(name);
		other.addLabel(label2);
		assertEquals(this.getFixture(), other);
		assertEquals(this.getFixture().hashCode(), other.hashCode());
		
		label1.setNamespace(namespace);
		assertFalse(this.getFixture().equals(other));
		assertFalse(this.getFixture().hashCode()== other.hashCode());
		label2.setNamespace(namespace);
		assertEquals(this.getFixture(), other);
		assertEquals(this.getFixture().hashCode(), other.hashCode());
		
		label1.setValue(value);
		assertFalse(this.getFixture().equals(other));
		assertFalse(this.getFixture().hashCode()== other.hashCode());
		label2.setValue(value);
		assertEquals(this.getFixture(), other);
		assertEquals(this.getFixture().hashCode(), other.hashCode());
	}

	public void testDifferences()
	{		
		assertNull(this.getFixture().differences(this.getFixture()));
	}
} //LabelableElementTest
