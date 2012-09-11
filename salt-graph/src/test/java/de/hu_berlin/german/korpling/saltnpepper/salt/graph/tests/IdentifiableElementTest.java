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
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Identifiable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement#getId() <em>Id</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement#getIdentifier() <em>Identifier</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class IdentifiableElementTest extends LabelableElementTest {

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static void main(String[] args) {
        TestRunner.run(IdentifiableElementTest.class);
    }

	/**
     * Constructs a new Identifiable Element test case with the given name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public IdentifiableElementTest(String name) {
        super(name);
    }

	/**
     * Returns the fixture for this Identifiable Element test case.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	protected IdentifiableElement getFixture() {
        return (IdentifiableElement)fixture;
    }

	
	public void testSettingGettingId()
	{
		//test 1
		String[] idsOk= {"id1", "id 1", "\nid", "\tid", "::id1"};
		for (String id: idsOk)
		{
			this.getFixture().setId(id);
			assertEquals(id, this.getFixture().getId());
		}
	}
	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see junit.framework.TestCase#setUp()
     * @generated
     */
	@Override
	protected void setUp() throws Exception {
        setFixture(GraphFactory.eINSTANCE.createIdentifiableElement());
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement#getIdentifier() <em>Identifier</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement#getIdentifier()
	 */
	public void testGetIdentifier() 
	{
		assertNotNull(this.getFixture().getIdentifier());
		assertEquals(Identifier.NAMESPACE_DEFAULT, this.getFixture().getIdentifier().getNamespace());
		assertEquals(Identifier.NAME_DEFAULT, this.getFixture().getIdentifier().getName());
		Identifier identifier= GraphFactory.eINSTANCE.createIdentifier();
		this.getFixture().setIdentifier(identifier);
		assertEquals(identifier, this.getFixture().getIdentifier());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement#setIdentifier(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier) <em>Identifier</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement#setIdentifier(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier)
	 */
	public void testSetIdentifier() 
	{
		this.testGetIdentifier();
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
		
		//test 2 remove all labels
		for (String labelName: labelNames)
		{
			labelableElement.removeLabel(labelName);
		}
		
		//adding one, because of the identifier
		numOfLabels= 1;
		
		assertEquals(numOfLabels, labelableElement.getNumOfLabels());
		for (String labelName: labelNames)
		{
			label= GraphFactory.eINSTANCE.createLabel();
			label.setName(labelName);
			labelableElement.addLabel(label);
		}
		//adding one, because of the identifier
		numOfLabels= labelNames.length +1;
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
		//adding one, because of the identifier
		numOfLabels= labelNames.length +1;
		assertEquals(numOfLabels, labelableElement.getNumOfLabels());
		labelableElement.removeLabel(label1);
		numOfLabels= numOfLabels-1;
		assertEquals(numOfLabels, labelableElement.getNumOfLabels());
		label= GraphFactory.eINSTANCE.createLabel();
		label.setName(label1);
		labelableElement.addLabel(label);
		assertEquals(label, labelableElement.getLabel(label1));
	}
	
	/**
	 * Tests the methods equals() and hachCode().
	 */
	public void basicTestEquals(IdentifiableElement other)
	{
		assertEquals(this.getFixture(), this.getFixture());
		
		//testing the identifier
		Identifier otherIdentifier= GraphFactory.eINSTANCE.createIdentifier();
		otherIdentifier.setId(this.getFixture().getId());
		
		other.setIdentifier(otherIdentifier);
		assertEquals(this.getFixture(), other);
		assertEquals(this.getFixture().hashCode(), other.hashCode());

		//tests all the labels
		String name= "name";
		String namespace= "namespace";
		String value= "value";
		Label label1= GraphFactory.eINSTANCE.createLabel();
		Label label2= GraphFactory.eINSTANCE.createLabel();
		
		label1.setName(name);
		this.getFixture().addLabel(label1);
		assertFalse(this.getFixture().equals(other));
		assertTrue(this.getFixture().hashCode()== other.hashCode());
		label2.setName(name);
		other.addLabel(label2);
		assertEquals(this.getFixture(), other);
		assertEquals(this.getFixture().hashCode(), other.hashCode());
		
		label1.setNamespace(namespace);
		assertFalse(this.getFixture().equals(other));
		assertTrue(this.getFixture().hashCode()== other.hashCode());
		label2.setNamespace(namespace);
		assertEquals(this.getFixture(), other);
		assertEquals(this.getFixture().hashCode(), other.hashCode());
		
		label1.setValue(value);
		assertFalse(this.getFixture().equals(other));
		assertTrue(this.getFixture().hashCode()== other.hashCode());
		label2.setValue(value);
		assertEquals(this.getFixture(), other);
		assertEquals(this.getFixture().hashCode(), other.hashCode());
	}
	
	/**
	 * Tests the methods equals() and hachCode().
	 */
	public void testEquals()
	{
		this.basicTestEquals(GraphFactory.eINSTANCE.createIdentifiableElement());
	}
	
} //IdentifiableElementTest
