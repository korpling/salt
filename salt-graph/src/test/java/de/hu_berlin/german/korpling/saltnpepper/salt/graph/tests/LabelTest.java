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

import junit.textui.TestRunner;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Label</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#getQName() <em>QName</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#getValueString() <em>Value String</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#getNSSeperator() <em>Get NS Seperator</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#clone() <em>Clone</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class LabelTest extends LabelableElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(LabelTest.class);
	}

	/**
	 * Constructs a new Label test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LabelTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Label test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Label getFixture() 
	{
		return (Label)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GraphFactory.eINSTANCE.createLabel());
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
	 * Tests the '{@link de.util.graph.Label#getQName() <em>Full Name</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.Label#getQName()
	 */
	public void testGetQName() {
	}

	/**
	 * Tests the '{@link de.util.graph.Label#getQName() <em>Full Name</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.Label#getQName()
	 */
	public void testQNameHandling() 
	{
		Label label= this.getFixture();
		String qName= null; 
		qName=label.getQName();
		assertEquals(qName, label.getQName());
		
		//shouldn�t be ok
		label= this.getFixture();
		qName= null;
		try {
			label.setQName(qName);
			fail("should fail if an empty QName is set.");
		} catch (Exception e) 
		{}
		
		//shouldn�t be ok
		label= this.getFixture();
		qName= "";
		try {
			label.setQName(qName);
			fail("should fail if an empty QName is set.");
		} catch (Exception e) 
		{}
		
		//should be ok
//		label= this.getFixture();
		label= GraphFactory.eINSTANCE.createLabel();
		qName= "any name";
		label.setQName(qName);
		assertEquals(qName, label.getQName());
		
		//should be ok
		this.setFixture(GraphFactory.eINSTANCE.createLabel());
		label= this.getFixture();
		qName= "label1";
		label.setQName(qName);
		assertEquals(qName, label.getQName());
		
		//should be ok
		label= this.getFixture();
		qName= "ns::name";
		label.setQName(qName);
		assertEquals(qName, label.getQName());
		
		//should be ok
		label= this.getFixture();
		qName= "ns::ns2::name";
		label.setQName(qName);
		assertEquals(qName, label.getQName());

		//should be ok
		label= this.getFixture();
		qName= "ns::ns::name";
		label.setQName(qName);
		assertEquals(qName, label.getQName());
	}
	
	/**
	 * Tests the '{@link de.util.graph.Label#getQName() <em>Full Name</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.Label#getQName()
	 */
	public void testGeneralNameHandling() 
	{
		Label label= this.getFixture();
		String ns= null;
		String name= null;
		String QName= null;
		
		//test1
		label= this.getFixture();
		ns= null;
		name= "label1";
		QName= name;
		label.setNamespace(ns);
		label.setName(name);
		assertEquals(QName, label.getQName());
		
		//test1
		label= this.getFixture();
		ns= "ns1";
		name= null;
		label.setNamespace(ns);
		try {
			label.setName(name);
			fail("should fail if an empty name was given.");
		} catch (Exception e) 
		{}
		
		//test1
		label= this.getFixture();
		ns= "ns1";
		name= "";
		label.setNamespace(ns);
		try {
			label.setName(name);
			fail("should fail if an empty name was given.");
		} catch (Exception e) 
		{}
		
		//test1
		label= this.getFixture();
		ns= null;
		name= "name1"+ label.getNSSeperator()+"name2";
		QName= ns + label.getNSSeperator() + name;
		label.setNamespace(ns);
		try {
			label.setName(name);
			fail("a name with the namespace sperator is illegal.");
		} catch (Exception e) 
		{
		}
		
		//test1
		label= this.getFixture();
		ns= null;
		name= "label1";
		label.setName(name);
		assertEquals(name, label.getQName());
		
	}


	/**
	 * Tests the '{@link de.util.graph.Label#setQName(java.lang.String) <em>Full Name</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.Label#setQName(java.lang.String)
	 */
	public void testValueHandling() 
	{
		Label label= this.getFixture();
		String value= null;
		
		label.setValue(value);
		assertEquals(value, label.getValue());
		
		//test
		value= "val1";
		label.setValue(value);
		assertEquals(value, label.getValue());
		
		//test
		value= "val1::val2";
		label.setValue(value);
		assertEquals(value, label.getValue());
	}	
	/**
	 * Tests the '{@link de.util.graph.Label#setQName(java.lang.String) <em>Full Name</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.Label#setQName(java.lang.String)
	 * 
	 */
	public void testSetQName() 
	{
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#getValue() <em>Value</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#getValue()
	 */
	public void testGetValue() 
	{
		assertNull(this.getFixture().getValue());
		
		Object obj= new Object();
		this.getFixture().setValue(obj);
		assertEquals(obj, this.getFixture().getValue());
		
		String value= "value";
		this.getFixture().setValue(value);
		assertEquals(value, this.getFixture().getValue());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#setValue(java.lang.Object) <em>Value</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#setValue(java.lang.Object)
	 */
	public void testSetValue() 
	{
		this.testGetValue();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#getValueString() <em>Value String</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#getValueString()
	 */
	public void testGetValueString() 
	{
		assertNull(this.getFixture().getValue());
		
		Object obj= new Object();
		this.getFixture().setValue(obj);
		assertEquals(obj.toString(), this.getFixture().getValueString());
		
		String value= "value";
		this.getFixture().setValue(value);
		assertEquals(value, this.getFixture().getValueString());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#setValueString(java.lang.String) <em>Value String</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#setValueString(java.lang.String)
	 */
	public void testSetValueString() {
		//nothing to test, because method does nothing
	}

	/**
	 * Tests the '{@link de.util.graph.Label#getNSSeperator() <em>Get NS Seperator</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.Label#getNSSeperator()
	 */
	public void testGetNSSeperator() 
	{
		assertEquals(this.getFixture().getNSSeperator(),Label.NS_SEPERATOR);
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#clone() <em>Clone</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#clone()
	 */
	public void testClone() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link de.util.graph.Label#getNamespaces() <em>Get Namespaces</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.Label#getNamespaces()
	 */
	public void testGetNamespaces() {
	}
	
	/**
	 * Tests the equals() method and the corresponding hashcode method respecting to if 
	 * a.equals(b) --> a.hashCode() == b.hashCode().
	 */
	public void testEquals()
	{
		assertTrue(this.getFixture().equals(this.getFixture()));
		assertTrue("both shall have the same hashcode", this.getFixture().hashCode()== this.getFixture().hashCode());
		
		Label other= GraphFactory.eINSTANCE.createLabel();
		String name="name";
		String namespace="namespace";
		Object value="value";
		
		//setting name
		this.getFixture().setName(name);
		assertFalse(this.getFixture().equals(other));
		assertFalse(this.getFixture().hashCode()== other.hashCode());
		other.setName(name);
		assertTrue("both shall be equal",this.getFixture().equals(other));
		assertTrue("both shall have the same hashcode", this.getFixture().hashCode()== other.hashCode());
		
		//setting namespace
		this.getFixture().setNamespace(namespace);
		assertFalse(this.getFixture().equals(other));
		assertFalse(this.getFixture().hashCode()== other.hashCode());
		other.setNamespace(namespace);
		assertTrue("both shall be equal",this.getFixture().equals(other));
		assertTrue("both shall have the same hashcode", this.getFixture().hashCode()== other.hashCode());
		
		//setting value (String)
		this.getFixture().setValue(value);
		assertFalse(this.getFixture().equals(other));
		assertFalse(this.getFixture().hashCode()== other.hashCode());
		other.setValue(value);
		assertTrue("both shall be equal",this.getFixture().equals(other));
		assertTrue("both shall have the same hashcode", this.getFixture().hashCode()== other.hashCode());
		
		//setting value (object)
		value= new Object();
		this.getFixture().setValue(value);
		assertFalse(this.getFixture().equals(other));
		assertFalse(this.getFixture().hashCode()== other.hashCode());
		other.setValue(value);
		assertTrue("both shall be equal",this.getFixture().equals(other));
		assertTrue("both shall have the same hashcode", this.getFixture().hashCode()== other.hashCode());
	}
	
	public void testDifferences()
	{
		String ns= "ns";
		String name= "name";
		String value= "value";
		Label label= GraphFactory.eINSTANCE.createLabel();
		assertNull(this.getFixture().differences(this.getFixture()));
		
		{//namespace
			this.getFixture().setNamespace(ns);
			assertNull(this.getFixture().differences(this.getFixture()));
			assertNotNull(this.getFixture().differences(label));
			label.setNamespace(ns);
			System.out.println("------------>"+ this.getFixture().differences(label));
			assertNull(this.getFixture().differences(label));
		}//namespace
		
		{//name
			this.getFixture().setName(name);
			assertNull(this.getFixture().differences(this.getFixture()));	
			assertNotNull(this.getFixture().differences(label));
			label.setName(name);
			assertNull(this.getFixture().differences(label));
		}//name
		{//value
			this.getFixture().setValue(value);
			assertNull(this.getFixture().differences(this.getFixture()));
			assertNotNull(this.getFixture().differences(label));
			label.setValue(value);
			assertNull(this.getFixture().differences(label));
		}//value
	}

} //LabelTest
