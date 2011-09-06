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

import java.util.Hashtable;
import java.util.Vector;

import junit.textui.TestRunner;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.tests.IdentifiableElementTest;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.SimpleIndex;

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
public class SimpleIndexTest extends IdentifiableElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SimpleIndexTest.class);
	}

	/**
	 * Constructs a new Simple Index test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleIndexTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Simple Index test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SimpleIndex getFixture() {
		return (SimpleIndex)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(IndexFactory.eINSTANCE.createSimpleIndex());
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
	public void testGetNumOfElements() 
	{
		String[][] entries= {{"elemId1", "entry1"}, {"elemId2", "entry2"}};
		for (String[] entry: entries)
		{
			this.getFixture().addElement(entry[0], entry[1]);
		}
		assertEquals(new Long(entries.length), this.getFixture().getNumOfElements());
	}

	/**
	 * Tests the '{@link de.util.graph.SimpleIndex#getElement(java.lang.Object) <em>Get Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.SimpleIndex#getElement(java.lang.Object)
	 */
	public void testGetElement__Object() 
	{
		String[][] entries= {{"elemId1", "entry1"}, {"elemId2", "entry2"}};
		for (String[] entry: entries)
		{
			this.getFixture().addElement(entry[0], entry[1]);
		}
		assertEquals(new Long(entries.length), this.getFixture().getNumOfElements());
		for (int i= 0; i < entries.length; i++)
		{
			assertEquals(entries[i][1], this.getFixture().getElement(entries[i][0]));
		}
	}

	/**
	 * Tests explicit handling of strings as identifier.
	 */
	public void testGetElement__String()
	{
		Vector<String> entries= new Vector<String>();
		for (int i=0; i<= 10; i++)
		{
			String entry= "entry"+i;
			entries.add(entry);
			this.getFixture().addElement("id"+i, entry);
		}
		
		for (int i=0; i<= 10; i++)
		{
			assertEquals(entries.get(i), this.getFixture().getElement("id"+i));
		}
	}
	
	/**
	 * Tests the '{@link de.util.graph.SimpleIndex#addElement(java.lang.Object, java.lang.Object) <em>Add Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.SimpleIndex#addElement(java.lang.Object, java.lang.Object)
	 */
	public void testAddElement__Object_Object() 
	{
		String[][] entries= {{"elemId1", "entry1"}, {"elemId2", "entry2"}};
		for (String[] entry: entries)
		{
			this.getFixture().addElement(entry[0], entry[1]);
		}
		
		for (String[] entry: entries)
		{
			this.getFixture().getElement(entry[0]);
		}
	}

	/**
	 * Tests the '{@link de.util.graph.Index#hasElement(java.lang.Object) <em>Has Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.Index#hasElement(java.lang.Object)
	 */
	public void testHasElement__Object() 
	{
		String[][] entries= {{"elemId1", "entry1"}, {"elemId2", "entry2"}};
		for (String[] entry: entries)
		{
			this.getFixture().addElement(entry[0], entry[1]);
		}
		
		for (String[] entry: entries)
		{
			assertTrue(this.getFixture().hasElement(entry[0]));
		}
	}

	/**
	 * Tests the '{@link de.util.graph.Index#removeElement(java.lang.Object) <em>Remove Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.Index#removeElement(java.lang.Object)
	 */
	public void testRemoveElement__Object() 
	{
		String[][] entries= {{"elemId1", "entry1"}, {"elemId2", "entry2"}};
		for (String[] entry: entries)
		{
			this.getFixture().addElement(entry[0], entry[1]);
		}
		
		for (String[] entry: entries)
		{
			assertTrue(this.getFixture().hasElement(entry[0]));
		}
		for (String[] entry: entries)
		{
			assertTrue(this.getFixture().removeElement(entry[1]));
			assertFalse(this.getFixture().hasElement(entry[0]));
		}
		assertEquals(new Long(0), this.getFixture().getNumOfElements());
		
	}

	/**
	 * Tests the '{@link de.util.graph.Index#removeAll() <em>Remove All</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.Index#removeAll()
	 */
	public void testRemoveAll() 
	{
		String[][] entries= {{"elemId1", "entry1"}, {"elemId2", "entry2"}};
		for (String[] entry: entries)
		{
			this.getFixture().addElement(entry[0], entry[1]);
		}
		
		for (String[] entry: entries)
		{
			assertTrue(this.getFixture().hasElement(entry[0]));
		}

		assertTrue(this.getFixture().removeAll());
		
		assertEquals(new Long(0), this.getFixture().getNumOfElements());
		for (String[] entry: entries)
		{
			assertFalse(this.getFixture().hasElement(entry[0]));
		}
	}
	

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index#removeElementById(java.lang.Object) <em>Remove Element By Id</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index#removeElementById(java.lang.Object)
	 */
	public void testRemoveElementById__Object() 
	{
		String[][] entries= {{"elemId1", "entry1"}, {"elemId2", "entry2"}};
		for (String[] entry: entries)
		{
			this.getFixture().addElement(entry[0], entry[1]);
		}
		
		for (String[] entry: entries)
		{
			assertTrue(this.getFixture().hasElement(entry[0]));
		}
		for (String[] entry: entries)
		{
			assertTrue(this.getFixture().removeElementById(entry[0]));
			assertFalse(this.getFixture().hasElement(entry[0]));
		}
		assertEquals(new Long(0), this.getFixture().getNumOfElements());
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index#removeElementById(java.lang.Object) <em>Remove Element By Id</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index#removeElementById(java.lang.Object)
	 */
	public void testRemoveElementById__Object2() 
	{
		String id= "id1";
		String entry= "entry";
		this.getFixture().addElement(id, entry);
		
		assertTrue(this.getFixture().hasElement("id1"));

		assertTrue(this.getFixture().removeElementById("id1"));
		assertFalse(this.getFixture().hasElement("id1"));
		assertEquals(new Long(0), this.getFixture().getNumOfElements());
	}

	public void testRemoveElementById__ObjectForNode() 
	{
		Node node= GraphFactory.eINSTANCE.createNode();
		node.setId("node1");
		this.getFixture().addElement(node.getId(), node);
		assertEquals(1, this.getFixture().getIdxTable().size());
		this.getFixture().removeElementById("node1");
		assertEquals(0, this.getFixture().getIdxTable().size());
		this.getFixture().addElement(node.getId(), node);
		assertEquals(1, this.getFixture().getIdxTable().size());
		String id= "node1";
		this.getFixture().removeElementById(id);
		assertEquals(0, this.getFixture().getIdxTable().size());
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.SimpleIndex#getIdxTable() <em>Idx Table</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.SimpleIndex#getIdxTable()
	 */
	public void testGetIdxTable() 
	{
		Hashtable<Object, Object> idxTable= new Hashtable<Object, Object>();
		this.getFixture().setIdxTable(idxTable);
		assertEquals(idxTable, this.getFixture().getIdxTable());
	}

	/**
	 * Tests the methods equals() and hachCode().
	 */
	public void testEquals()
	{
		this.basicTestEquals(IndexFactory.eINSTANCE.createSimpleIndex());
	}
} //SimpleIndexTest