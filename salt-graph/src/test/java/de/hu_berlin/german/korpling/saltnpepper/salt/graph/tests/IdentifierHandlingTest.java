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

import junit.framework.TestCase;
import junit.textui.TestRunner;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Identifiable Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement#getId() <em>Id</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class IdentifierHandlingTest extends TestCase
{

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(IdentifierHandlingTest.class);
	}

	protected IdentifiableElement fixture = null;

	protected void setFixture(IdentifiableElement fixture) {
		this.fixture = fixture;
	}
	
	protected IdentifiableElement getFixture() {
		return (IdentifiableElement)fixture;
	}

	protected void setUp() throws Exception 
	{
		this.setFixture(GraphFactory.eINSTANCE.createIdentifiableElement());
	}
	
	/**
	 * Checks if the references from Identifier to IdentifiableElment and vice versa are set correct when calling
	 * IdentifiableElement.setIdentifier().
	 */
	public void testInverseSetIdentifier_1()
	{
		Identifier identifier= GraphFactory.eINSTANCE.createIdentifier();
		identifier.setId("id1");
		this.getFixture().setIdentifier(identifier);
		assertEquals(identifier, this.getFixture().getIdentifier());
		assertEquals(this.getFixture(), identifier.getIdentifiableElement());
		assertEquals(this.getFixture(), identifier.getLabelableElement());
		
		//reset identifier
		identifier= GraphFactory.eINSTANCE.createIdentifier();
		identifier.setId("id2");
		this.getFixture().setIdentifier(identifier);
		assertEquals(identifier, this.getFixture().getIdentifier());
		assertEquals(this.getFixture(), identifier.getIdentifiableElement());
		assertEquals(this.getFixture(), identifier.getLabelableElement());
	}
	
	/**
	 * Checks if the references from Identifier to IdentifiableElment and vice versa are set correct when calling
	 * IdentifiableElement.getLabels().add().
	 */
	public void testInverseSetIdentifier_2()
	{
		Identifier identifier= GraphFactory.eINSTANCE.createIdentifier();
		identifier.setId("id1");
		this.getFixture().getLabels().add(identifier);
		assertEquals(identifier, this.getFixture().getIdentifier());
		assertEquals(this.getFixture(), identifier.getIdentifiableElement());
		assertEquals(this.getFixture(), identifier.getLabelableElement());
		
		//reset identifier
		identifier= GraphFactory.eINSTANCE.createIdentifier();
		identifier.setId("id2");
		this.getFixture().getLabels().add(identifier);
		assertEquals(identifier, this.getFixture().getIdentifier());
		assertEquals(this.getFixture(), identifier.getIdentifiableElement());
		assertEquals(this.getFixture(), identifier.getLabelableElement());
	}
	
	/**
	 * Checks if the references from Identifier to IdentifiableElment and vice versa are set correct when calling
	 * IdentifiableElement.addLabel().
	 */
	public void testInverseSetIdentifier_3()
	{
		Identifier identifier= GraphFactory.eINSTANCE.createIdentifier();
		identifier.setId("id1");
		
		this.getFixture().addLabel((Identifier)identifier);
		assertEquals(identifier, this.getFixture().getIdentifier());
		assertEquals(this.getFixture(), identifier.getIdentifiableElement());
		assertEquals(this.getFixture(), identifier.getLabelableElement());
		
		//reset identifier
		identifier= GraphFactory.eINSTANCE.createIdentifier();
		identifier.setId("id2");
		this.getFixture().addLabel((Identifier)identifier);
		assertEquals(identifier, this.getFixture().getIdentifier());
		assertEquals(this.getFixture(), identifier.getIdentifiableElement());
		assertEquals(this.getFixture(), identifier.getLabelableElement());
	}
	
	/**
	 * Checks if the references from Identifier to IdentifiableElment and vice versa are set correct when calling
	 * Identifier.setIdentifiableElement().
	 */
	public void testInverseSetIdentifiableElement_1()
	{
		Identifier identifier= GraphFactory.eINSTANCE.createIdentifier();
		identifier.setId("id1");
		identifier.setIdentifiableElement(getFixture());
		assertEquals(this.getFixture(), identifier.getIdentifiableElement());
		assertEquals(this.getFixture(), identifier.getLabelableElement());
		
		//reset IdentifiableElement
		this.setFixture(GraphFactory.eINSTANCE.createIdentifiableElement());
		identifier.setIdentifiableElement(getFixture());
		assertEquals(this.getFixture(), identifier.getIdentifiableElement());
		assertEquals(this.getFixture(), identifier.getLabelableElement());
	}
	
	/**
	 * Checks if the references from Identifier to IdentifiableElment and vice versa are set correct when calling
	 * Identifier.setLabelableElement().
	 */
	public void testInverseSetIdentifiableElement_2()
	{
		Identifier identifier= GraphFactory.eINSTANCE.createIdentifier();
		identifier.setId("id1");
		identifier.setIdentifiableElement(getFixture());
		assertEquals(this.getFixture(), identifier.getIdentifiableElement());
		assertEquals(this.getFixture(), identifier.getLabelableElement());
		
		//reset IdentifiableElement
		this.setFixture(GraphFactory.eINSTANCE.createIdentifiableElement());
		identifier.setLabelableElement(this.getFixture());
		assertEquals(this.getFixture(), identifier.getIdentifiableElement());
		assertEquals(this.getFixture(), identifier.getLabelableElement());
	}
	
} //IdentifiableElementTest
