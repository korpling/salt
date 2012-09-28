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

import java.util.HashMap;
import java.util.Map;

import junit.textui.TestRunner;

import org.eclipse.emf.common.util.EList;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.ComplexIndex;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.tests.IdentifiableElementTest;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Complex Index</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index#getNumOfElements() <em>Num Of Elements</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index#getNumOfElementIds() <em>Num Of Element Ids</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index#getIndexMap() <em>Index Map</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.ComplexIndex#hasSlot(java.lang.Object) <em>Has Slot</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.ComplexIndex#getSlot(java.lang.Object) <em>Get Slot</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.ComplexIndex#getSlotIds() <em>Get Slot Ids</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.ComplexIndex#removeSlot(java.lang.Object) <em>Remove Slot</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index#addElement(java.lang.Object, java.lang.Object) <em>Add Element</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index#hasElement(java.lang.Object) <em>Has Element</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index#removeElement(java.lang.Object) <em>Remove Element</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class ComplexIndexTest extends IdentifiableElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(ComplexIndexTest.class);
	}

	/**
	 * Constructs a new Complex Index test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexIndexTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Complex Index test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	protected ComplexIndex<String, String> getFixture() {
		return (ComplexIndex<String, String>)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(IndexFactory.eINSTANCE.createComplexIndex());
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

	private String idxName= "Index"; 
	private String[] ids=		{"id1", "id2", "id3"};
	private String[][] entries= {	{"id1","entry1"}, {"id1","entry1a"}, 
									{"id2","entry2"}, {"id3","entry3"}};
	
	private void fillIdx() throws Exception
	{
		for (int i= 0; i < entries.length; i++)
		{
			this.getFixture().addElement(entries[i][0], entries[i][1]);
		}
	}
	
	/**
	 * Tests if index can be filled with entries.
	 */
	public void testFillIdx() throws Exception
	{
		this.fillIdx();
		for (int i= 0; i < entries.length; i++)
		{
			assertTrue(this.getFixture().hasSlot(entries[i][0]));
		}
	}
	
	/**
	 * Testet ob der Name des Indexes richtig gesetzt wird
	 */
	public void testGetIdxId() throws Exception
	{
		this.getFixture().setId(this.idxName);
		assertEquals(this.idxName, this.getFixture().getId());
	}
	
	/**
	 * Testet ob der Index alle Indizes, die er enth�lt zur�ckgibt.
	 * korrekt zur�ckkommen.
	 */
	public void testGetSlotIds() throws Exception
	{
		this.fillIdx();
		EList<String> ids= this.getFixture().getSlotIds();
		for (String id: this.ids)
		{
			assertTrue("the index should contain the id '"+id+"'", ids.contains(id));
		}
	}
	

	/**
	 * Testet ob der Index mit Eintr�gen gef�llt werden kann und diese wieder
	 * korrekt zur�ckkommen.
	 */
	public void testGetSlot__Object() throws Exception
	{
		this.fillIdx();
		
		for (int i= 0; i < entries.length; i++)
		{
			assertTrue(this.getFixture().getSlot(entries[i][0]).contains(entries[i][1]));
		}
	}
	
	/**
	 * Tested die Methoden hasEntry() und hasId dieses Indexes.
	 */
	public void testHasEntryOrId() throws Exception
	{
		this.fillIdx();
		for (int i= 0; i< entries.length; i++)
		{
			assertTrue("the index should have the id: " + entries[i][0], this.getFixture().hasSlot(entries[i][0]));
			assertTrue("the index should have the entry: " + entries[i][1], this.getFixture().hasElement(entries[i][1]));
		}
		//nach Eintr�gen suchen, die es nicht gibt
		
		assertFalse("the index should not have the id: " + "not there", this.getFixture().hasSlot("not there"));
		assertFalse("the index should not have the entry: " + "not there", this.getFixture().hasElement("not there"));
	}
	
	/**
	 * Testet das Entfernen eines ganzen Slot aus dem Index. Die Eintr�ge werden mittels
	 * der id identifiziert.
	 * @throws Exception
	 */
	public void testRemoveSlot__Object() throws Exception
	{
		//Index f�llen
		this.fillIdx();
		//Slots des Index mittels id l�schen
		for (int i= 0; i< ids.length; i++)
		{
			//Eintrag l�schen
			this.getFixture().removeSlot(ids[i]);
			//pr�fen ob Eintrag entfernt wurde
			assertFalse("the entry '"+ids[i]+"' should have been removed",this.getFixture().hasElement(entries[i][0]));
		}
		//einen Slot l�schen, den es nicht gibt
		assertFalse("the slot wich is tried to remove shouldn�t be there", this.getFixture().removeSlot(entries[1][0]));
	}
	
	/**
	 * Testet das Entfernen eines einzelnen Eintrages aus dem Index. 
	 * Die Eintr�ge werden �ber den Eintrag selbst identifiziert.
	 * @throws Exception
	 */
	public void testRemoveElement__Object() throws Exception
	{
		//Index f�llen
		this.fillIdx();
		//einzelne Eintr�ge des Index mittels entry l�schen
		for (int i= 0; i< entries.length; i++)
		{
			this.getFixture().removeElement(entries[i][1]);
			assertFalse("entry should have been removed", this.getFixture().hasElement(entries[i][1]));
		}
		//einen Eintrag l�schen, den es nicht gibt
		assertFalse("the entry wich is tried to remove shouldn�t be there", this.getFixture().removeElement(entries[1][1]));
		//Slots sollten auch gel�scht sein
		for (int i= 0; i< entries.length; i++)
		{
			assertFalse("whole slot should have been removed", this.getFixture().hasSlot(entries[i][0]));
		}
	}
	
	/**
	 * Tests the '{@link de.noName.graph.Index#removeAll() <em>Remove All</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.noName.graph.Index#removeAll()
	 */
	public void testRemoveAll()  throws Exception
	{
		//Index f�llen
		this.fillIdx();
		//einzelne Eintr�ge des Index mittels entry l�schen
		assertTrue(this.getFixture().removeAll());
		//trying again
		assertTrue(this.getFixture().removeAll());
		assertEquals(new Long(0), this.getFixture().getNumOfElements());
		assertEquals(new Long(0), this.getFixture().getNumOfElementIds());
		//Slots sollten auch gel�scht sein
		for (int i= 0; i< entries.length; i++)
		{
			assertFalse("whole slot should have been removed", this.getFixture().hasSlot(entries[i][0]));
		}
	}

	/**
	 * Tests the '{@link de.util.graph.Index#getNumOfElements() <em>Num Of Elements</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.util.graph.Index#getNumOfElements()
	 */
	public void testGetNumOfElements() throws Exception 
	{
		assertEquals(new Long(0), this.getFixture().getNumOfElements());
		this.fillIdx();
		assertEquals(new Long(entries.length), this.getFixture().getNumOfElements());
	}

	/**
	 * Tests the '{@link de.util.graph.ComplexIndex#getNumOfSlots() <em>Num Of Slots</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.util.graph.ComplexIndex#getNumOfSlots()
	 */
	public void testGetNumOfElementIds() throws Exception {
		assertEquals(new Long(0), this.getFixture().getNumOfElements());
		this.fillIdx();
		assertEquals(new Long(ids.length), this.getFixture().getNumOfElementIds());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index#getIndexMap() <em>Index Map</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index#getIndexMap()
	 */
	public void testGetIndexMap() {
		HashMap<Object, EList<Object>> idxTable= new HashMap<Object, EList<Object>>();
		this.getFixture().setIndexMap((Map)idxTable);
		assertEquals(idxTable, this.getFixture().getIndexMap());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index#setIndexMap(java.util.Map) <em>Index Map</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index#setIndexMap(java.util.Map)
	 */
	public void testSetIndexMap() {
		this.testGetIndexMap();
	}

	/**
	 * Tests the '{@link de.util.graph.ComplexIndex#hasSlot(java.lang.Object) <em>Has Slot</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.util.graph.ComplexIndex#hasSlot(java.lang.Object)
	 */
	public void testHasSlot__Object() throws Exception 
	{
		for (String id: ids)
			assertFalse(this.getFixture().hasSlot(id));
		this.fillIdx();
		for (String id: ids)
			assertTrue(this.getFixture().hasSlot(id));
		assertFalse(this.getFixture().hasSlot("not there"));
	}


	/**
	 * Tests the '{@link de.util.graph.Index#addElement(java.lang.Object, java.lang.Object) <em>Add Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.util.graph.Index#addElement(java.lang.Object, java.lang.Object)
	 */
	public void testAddElement__Object_Object() throws Exception 
	{
		//checking filling index
		this.fillIdx();
		//checking double filling index
		try {
			this.fillIdx();
			fail("Should not be able to add a pair two times");
		} catch (Exception e) {
		}
	}

	/**
	 * Tests the '{@link de.util.graph.Index#hasElement(java.lang.Object) <em>Has Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @throws Exception 
	 * @see de.util.graph.Index#hasElement(java.lang.Object)
	 */
	public void testHasElement__Object() throws Exception 
	{
		for (String[] entry: entries)
			assertFalse(this.getFixture().hasElement(entry[1]));
		this.fillIdx();
		for (String[] entry: entries)
			assertTrue(this.getFixture().hasElement(entry[1]));
	}
	
	/**
	 * Tests the methods equals() and hachCode().
	 */
	public void testEquals()
	{
		this.basicTestEquals(IndexFactory.eINSTANCE.createComplexIndex());
	}

} //ComplexIndexTest
