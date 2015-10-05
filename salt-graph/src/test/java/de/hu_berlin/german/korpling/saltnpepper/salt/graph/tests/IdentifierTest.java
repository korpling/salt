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

import junit.textui.TestRunner;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Identifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier#getIdentifiableElement() <em>Identifiable Element</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier#getId() <em>Id</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class IdentifierTest extends LabelTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(IdentifierTest.class);
	}

	/**
	 * Constructs a new Identifier test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Identifier test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Identifier getFixture() 
	{
		return (Identifier)fixture;
	}

	/**
	 * Tests the '{@link de.util.graph.Label#getFullName() <em>Full Name</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.Label#getFullName()
	 */
	public void testQNameHandling() 
	{
		//should be ok
		String name= Identifier.NAME_DEFAULT;
		String fullName= Identifier.NAMESPACE_DEFAULT + Identifier.NS_SEPERATOR+name;
		this.getFixture().setQName(name);
		assertEquals(fullName, this.getFixture().getQName());
	}
	
	public void testSetNamespace()
	{
		String ns= this.getFixture().getNamespace();
		this.getFixture().setNamespace("any");
		assertEquals(ns, this.getFixture().getNamespace());
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GraphFactory.eINSTANCE.createIdentifier());
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
	 * Just to override {@link LabelTest#testGetQName2()}, because case cannot occur in for this fixture.
	 */
	public void testGetQName2()
	{
		//do nothing
	}
	/**
	 * Overrides parent test {@link LabelTest#testGetQName()}.
	 */
	public void testGetQName()
	{
		String qname= Identifier.NAMESPACE_DEFAULT+ Label.NS_SEPERATOR+ Identifier.NAME_DEFAULT;
		assertEquals(qname, this.getFixture().getQName());
		this.getFixture().setName("something");
		assertEquals(qname, this.getFixture().getQName());
	}
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier#getIdentifiableElement() <em>Identifiable Element</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier#getIdentifiableElement()
	 */
	public void testGetIdentifiableElement() 
	{
		assertEquals(null, this.getFixture().getIdentifiableElement());
		Node node= GraphFactory.eINSTANCE.createNode();
		assertNotNull(node.getIdentifier());
		this.getFixture().setIdentifiableElement(node);
		assertEquals(node, this.getFixture().getIdentifiableElement());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier#setIdentifiableElement(de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement) <em>Identifiable Element</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier#setIdentifiableElement(de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement)
	 */
	public void testSetIdentifiableElement() 
	{
		this.testGetIdentifiableElement();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier#getId() <em>Id</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier#getId()
	 */
	public void testGetId() 
	{
		String id= "id1";
		assertNull(this.getFixture().getId());
		
		this.getFixture().setId(id);
		assertTrue(id.equalsIgnoreCase(this.getFixture().getId()));
		
		this.getFixture().setId(null);
		assertNull(this.getFixture().getId());
		assertNull(this.getFixture().getValue());
		
		this.getFixture().setValue(id);
		assertTrue(id.equalsIgnoreCase(this.getFixture().getValue().toString()));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier#setId(java.lang.String) <em>Id</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier#setId(java.lang.String)
	 */
	public void testSetId() 
	{
		testGetId();
	}

	/**
	 * Tests that the name is always the default one.
	 */
	public void testSetName()
	{
		assertEquals(Identifier.NAME_DEFAULT, this.getFixture().getName());
		this.getFixture().setName("somename");
		assertEquals(Identifier.NAME_DEFAULT, this.getFixture().getName());
	}
	
	/**
	 * Tests that the namespace is always the default one.
	 */
	public void testSetNameSpace()
	{
		assertEquals(Identifier.NAMESPACE_DEFAULT, this.getFixture().getNamespace());
		this.getFixture().setNamespace("somename");
		assertEquals(Identifier.NAMESPACE_DEFAULT, this.getFixture().getNamespace());
	}
	
	public void testCheckOpposite()
	{
		Node node= GraphFactory.eINSTANCE.createNode();
		node.setIdentifier(this.getFixture());
		assertEquals(this.getFixture(), node.getIdentifier());
		assertEquals(this.getFixture().getIdentifiableElement(), node);
		
	}
	
	public void testGeneralNameHandling() 
	{
		assertEquals("graph", this.getFixture().getNamespace());
	}
	
	/**
	 * Tests the equals() method and the corresponding hashcode method respecting to if 
	 * a.equals(b) --> a.hashCode() == b.hashCode().
	 */
	public void testEquals()
	{
		assertTrue(this.getFixture().equals(this.getFixture()));
		assertTrue("both shall have the same hashcode", this.getFixture().hashCode()== this.getFixture().hashCode());
		
		Identifier other= GraphFactory.eINSTANCE.createIdentifier();
		String name="name";
		String namespace="namespace";
		Object value="value";
		String id="id";
		
		//setting name
		this.getFixture().setName(name);
		assertTrue("both shall be equal",this.getFixture().equals(other));
		assertTrue("both shall have the same hashcode", this.getFixture().hashCode()== other.hashCode());
		other.setName(name);
		assertTrue("both shall be equal",this.getFixture().equals(other));
		assertTrue("both shall have the same hashcode", this.getFixture().hashCode()== other.hashCode());
		
		//setting namespace
		this.getFixture().setNamespace(namespace);
		assertTrue("both shall be equal",this.getFixture().equals(other));
		assertTrue("both shall have the same hashcode", this.getFixture().hashCode()== other.hashCode());
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
		
		//setting id (String)
		this.getFixture().setId(id);
		assertFalse(this.getFixture().equals(other));
		assertFalse(this.getFixture().hashCode()== other.hashCode());
		other.setId(id);
		assertTrue("both shall be equal",this.getFixture().equals(other));
		assertTrue("both shall have the same hashcode", this.getFixture().hashCode()== other.hashCode());
	}
	
	public void testDifferences()
	{
		String value= "value";
		Identifier identifier= GraphFactory.eINSTANCE.createIdentifier();
		assertNull(this.getFixture().differences(this.getFixture()));
		
		{//value
			this.getFixture().setValue(value);
			assertNull(this.getFixture().differences(this.getFixture()));
			assertNotNull(this.getFixture().differences(identifier));
			identifier.setValue(value);
			assertNull(this.getFixture().differences(identifier));
		}//value
	}
} //IdentifierTest
