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
package de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.tests;

import junit.textui.TestRunner;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.IdentifiableElementIndex;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.tests.IdentifiableElementTest;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Simple Index</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index#getNumOfElements() <em>Num Of Elements</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.SimpleIndex#getIdxTable() <em>Idx Table</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.SimpleIndex#getElement(java.lang.Object) <em>Get Element</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.SimpleIndex#removeElementById(java.lang.Object) <em>Remove Element By Id</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index#addElement(java.lang.Object, java.lang.Object) <em>Add Element</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index#hasElement(java.lang.Object) <em>Has Element</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index#removeElement(java.lang.Object) <em>Remove Element</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class IdentifiableElementIndexTest extends IdentifiableElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(IdentifiableElementIndexTest.class);
	}

	/**
	 * Constructs a new Simple Index test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifiableElementIndexTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Simple Index test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected IdentifiableElementIndex<IdentifiableElement> getFixture() {
		return (IdentifiableElementIndex<IdentifiableElement>)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(IndexFactory.eINSTANCE.createIdentifiableElementIndex());
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
	 * Tests the '{@link de.util.graph.Index#getNumOfElements() <em>Num Of Elements</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.Index#getNumOfElements()
	 */
	public void testRemoveElement() 
	{
		IdentifiableElement elem1= GraphFactory.eINSTANCE.createIdentifiableElement();
		elem1.setId("elem1");
		IdentifiableElement elem2= GraphFactory.eINSTANCE.createIdentifiableElement();
		elem2.setId("elem2");
		IdentifiableElement elem3= GraphFactory.eINSTANCE.createIdentifiableElement();
		elem3.setId("elem3");
		IdentifiableElement elem4= GraphFactory.eINSTANCE.createIdentifiableElement();
		elem4.setId("elem4");
		IdentifiableElement elem5= GraphFactory.eINSTANCE.createIdentifiableElement();
		elem5.setId("elem5");
		
		this.getFixture().addElement(elem1.getId(), elem1);
		this.getFixture().addElement(elem2.getId(), elem2);
		this.getFixture().addElement(elem3.getId(), elem3);
		this.getFixture().addElement(elem4.getId(), elem4);
		this.getFixture().addElement(elem5.getId(), elem5);
		
		assertEquals(Long.valueOf(5), this.getFixture().getNumOfElementIds());
		assertEquals(Long.valueOf(5), this.getFixture().getNumOfElements());
		
		this.getFixture().removeElement(elem3);
		assertEquals(Long.valueOf(4), this.getFixture().getNumOfElementIds());
		assertFalse(this.getFixture().hasKey(elem3.getId()));
		
		this.getFixture().removeElement(elem5);
		assertEquals(Long.valueOf(3), this.getFixture().getNumOfElementIds());
		assertFalse(this.getFixture().hasKey(elem5.getId()));
		
		this.getFixture().removeElement(elem1);
		assertEquals(Long.valueOf(2), this.getFixture().getNumOfElementIds());
		assertFalse(this.getFixture().hasKey(elem1.getId()));
		
		this.getFixture().removeElement(elem2);
		assertEquals(Long.valueOf(1), this.getFixture().getNumOfElementIds());
		assertFalse(this.getFixture().hasKey(elem2.getId()));
		
		this.getFixture().removeElement(elem4);
		assertEquals(Long.valueOf(0), this.getFixture().getNumOfElementIds());
		assertFalse(this.getFixture().hasKey(elem4.getId()));
	}
	
	/**
	 * Tests the '{@link de.util.graph.Index#removeAll() <em>Remove All</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.Index#removeAll()
	 */
	public void testRemoveAll() 
	{
		IdentifiableElement elem1= GraphFactory.eINSTANCE.createIdentifiableElement();
		elem1.setId("elem1");
		IdentifiableElement elem2= GraphFactory.eINSTANCE.createIdentifiableElement();
		elem2.setId("elem2");
		IdentifiableElement elem3= GraphFactory.eINSTANCE.createIdentifiableElement();
		elem3.setId("elem3");
		IdentifiableElement elem4= GraphFactory.eINSTANCE.createIdentifiableElement();
		elem4.setId("elem4");
		IdentifiableElement elem5= GraphFactory.eINSTANCE.createIdentifiableElement();
		elem5.setId("elem5");
		
		this.getFixture().addElement(elem1.getId(), elem1);
		this.getFixture().addElement(elem2.getId(), elem2);
		this.getFixture().addElement(elem3.getId(), elem3);
		this.getFixture().addElement(elem4.getId(), elem4);
		this.getFixture().addElement(elem5.getId(), elem5);
		
		assertEquals(Long.valueOf(5), this.getFixture().getNumOfElementIds());
		assertEquals(Long.valueOf(5), this.getFixture().getNumOfElements());
		
		this.getFixture().removeAll();
		assertEquals(Long.valueOf(0), this.getFixture().getNumOfElementIds());
		assertEquals(Long.valueOf(0), this.getFixture().getNumOfElements());
	}
} //SimpleIndexTest
