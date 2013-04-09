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

import java.util.Collection;
import java.util.Vector;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.util.EList;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.SimpleIndex;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Mgr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr#getNumOfIndexes() <em>Num Of Indexes</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr#getGraph() <em>Graph</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr#addIndex(de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index) <em>Add Index</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr#hasIndex(java.lang.Object) <em>Has Index</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr#getIndex(java.lang.Object) <em>Get Index</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr#removeIndex(java.lang.Object) <em>Remove Index</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr#removeAll() <em>Remove All</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr#removeElement(java.lang.Object) <em>Remove Element</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class IndexMgrTest extends TestCase {

	/**
	 * The fixture for this Mgr test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IndexMgr fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(IndexMgrTest.class);
	}

	/**
	 * Constructs a new Mgr test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndexMgrTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Mgr test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(IndexMgr fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Mgr test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IndexMgr getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(IndexFactory.eINSTANCE.createIndexMgr());
		Index idx= null;
		this.indexes= new Vector<Index>();
		for (String idxName: simpleIndexNames)
		{
			idx= IndexFactory.eINSTANCE.createSimpleIndex();
			idx.setId(idxName);
			this.indexes.add(idx);
		}
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
	 * Namen der einzuf�genden Indexe
	 */
	private String[] simpleIndexNames= {"index1", "index2", "index3", "index4"};
	
	/**
	 * Eintr�ge f�r die verschiedenen indexes
	 */
	private String[][] entries= 	{{"index1", "id11", "entry11"}, {"index1", "id12", "entry12"}, 
									{"index2", "id12", "entry12"}, {"index2", "id11", "entry11"}, {"index2", "id13", "entry13"}};
	
	/**
	 * einzuf�gende Indexe
	 */
	private Collection<Index> indexes= null;

	/**
	 * f�gt alle Indexe aus indexes in den IndexMgr ein
	 */
	private void fillIndexMgr()
	{
		for (Index idx: indexes)
		{
			this.getFixture().addIndex(idx);
		}
	}
	
	/**
	 * F�gt ein paar Eintr�ge in die Indizes des index Managers ein
	 */
	private void insertEntries() throws Exception
	{
		for (int i= 0; i< entries.length; i++)
		{
			this.getFixture().getIndex(entries[i][0]).addElement(entries[i][1], entries[i][2]);
		}
	}
	
	/**
	 * Pr�ft ob ein Index im Indexmanager vorhanden ist.
	 * @throws Exception
	 */
	public void testHasIndex() throws Exception
	{
			this.fillIndexMgr();
			for (Index idx: indexes)
			{
				assertTrue("an index with name '"+idx.getId()+"' has to be in the index manager", this.getFixture().hasIndex(idx.getId()));
			}
			//Indexes anfragen, die es nicht gibt
			assertFalse("there should be no index with the name 'not there'", this.getFixture().hasIndex("not there"));
	}
	
	/**
	 * Pr�ft ob ein Index im Indexmanager vorhanden ist
	 * @throws Exception
	 */
	public void testGetIndex() throws Exception
	{
			this.fillIndexMgr();
			for (Index idx: indexes)
			{
				assertSame("index '"+idx.getId()+"'has to be there", idx, this.getFixture().getIndex(idx.getId()));
			}
			assertNull("an index with name 'not there' shouldn�t be there", this.getFixture().getIndex("not there"));
	}
	
	/**
	 * Testet ob ein Index aus dem IndexManager entfernt werden kann.
	 * @throws Exception
	 */
	public void testRemoveIndex() throws Exception
	{
		
			this.fillIndexMgr();
			for (Index idx: indexes)
			{
				this.getFixture().removeIndex(idx.getId());
				assertFalse("this index should have been removed", this.getFixture().hasIndex(idx.getId()));
			}
			//einen Index l�schen, den es nicht gibt
			assertFalse("this index does not exist and cannot be removed", this.getFixture().removeIndex("not there"));
	}
	
	/**
	 * Testing if correct number of indexes is returned
	 * @throws Exception
	 */
	public void testNumOfIndexes() throws Exception
	{
			int i= 0;
			for (Index index: indexes)
			{
				i++;
				this.getFixture().addIndex(index);
				assertEquals(new Long(i), this.getFixture().getNumOfIndexes());
			}
	}
	
	/**
	 * Testet ob ein Eintrag aus allen vorhandenen Indizes gel�scht werden kann.
	 * @throws Exception
	 */
	public void testRemoveEntry() throws Exception
	{
			this.fillIndexMgr();
			this.insertEntries();
			Index idx= null;
			for(int i= 0; i< entries.length; i++)
			{
				idx= this.getFixture().getIndex(entries[i][0]);
				if (idx.hasElement(entries[i][2]))
				{
					this.getFixture().removeElement(entries[i][2]);
					assertFalse("this entry '"+entries[i][2]+ "' should have been removed", idx.hasElement(entries[i][2]));
				}
			}
			//einen Eintrag l�schen, den es nicht gibt
			assertFalse("this entry 'not there' should have been removed", idx.hasElement("not there"));
	}

	/**
	 * Tests the '{@link de.noName.graph.IndexMgr#getIndexes() <em>Get Index</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.noName.graph.IndexMgr#getIndex(java.lang.String)
	 */
	public void testGetIndexes() throws Exception
	{
			this.fillIndexMgr();
			EList<Index> indexList= this.getFixture().getIndexes();
			assertEquals(new Long(indexes.size()), this.getFixture().getNumOfIndexes());
			for (Index index: indexes)
			{
				assertTrue(indexList.contains(index));
			}
	}
	

	/**
	 * Tests the '{@link de.util.graph.IndexMgr#getNumOfIndexes() <em>Num Of Indexes</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.IndexMgr#getNumOfIndexes()
	 */
	public void testGetNumOfIndexes() 
	{
		String[] indexNames= {"index1", "index2", "index3"};
		Index index= null;
		int i= 0;
		assertEquals(new Long(i), this.getFixture().getNumOfIndexes());
		for (String indexName: indexNames)
		{
			index= IndexFactory.eINSTANCE.createSimpleIndex();
			index.setId(indexName);
			this.getFixture().addIndex(index);
			i++;
			assertEquals(new Long(i), this.getFixture().getNumOfIndexes());
		}
	}
	
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr#getGraph() <em>Graph</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr#getGraph()
	 */
	public void testGetGraph() 
	{
		Graph graph= GraphFactory.eINSTANCE.createGraph();
		this.getFixture().setGraph(graph);
		assertEquals(graph, this.getFixture().getGraph());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr#setGraph(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph) <em>Graph</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr#setGraph(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph)
	 */
	public void testSetGraph() 
	{
		this.testGetGraph();
	}

	/**
	 * Testet das einf�gen von Index-Objekten in den Index-Manager.
	 * @throws Exception
	 */
	public void testAddIndex__Index()
	{
		
		this.fillIndexMgr();
		//Index einf�gen, den es schon gibt
		try
		{
			this.fillIndexMgr();
			fail("indexes are already added");
		}
		catch (Exception e)
		{}
	}

	/**
	 * Tests the '{@link de.util.graph.IndexMgr#hasIndex(java.lang.Object) <em>Has Index</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.IndexMgr#hasIndex(java.lang.Object)
	 */
	public void testHasIndex__Object() 
	{
		String[] indexNames= {"index1", "index2", "index3"};
		Index index= null;
		for (String indexName: indexNames)
		{
			index= IndexFactory.eINSTANCE.createSimpleIndex();
			index.setId(indexName);
			this.getFixture().addIndex(index);
			assertTrue(this.getFixture().hasIndex(indexName));
		}
		
		String[] unknownIndexNames= {"index5", "index6", "index7"};
		for (String indexName: unknownIndexNames)
		{
			assertFalse(this.getFixture().hasIndex(indexName));
		}
	}

	/**
	 * Tests the '{@link de.util.graph.IndexMgr#getIndex(java.lang.Object) <em>Get Index</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.IndexMgr#getIndex(java.lang.Object)
	 */
	public void testGetIndex__Object() 
	{
		String[] indexNames= {"index1", "index2", "index3"};
		Index index= null;
		for (String indexName: indexNames)
		{
			index= IndexFactory.eINSTANCE.createSimpleIndex();
			index.setId(indexName);
			this.getFixture().addIndex(index);
			assertEquals(index, this.getFixture().getIndex(indexName));
		}
		
		String[] unknownIndexNames= {"index5", "index6", "index7"};
		for (String indexName: unknownIndexNames)
		{
			assertNull(this.getFixture().getIndex(indexName));
		}
		
	}

	/**
	 * Tests the '{@link de.util.graph.IndexMgr#removeIndex(java.lang.Object) <em>Remove Index</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.IndexMgr#removeIndex(java.lang.Object)
	 */
	public void testRemoveIndex__Object() 
	{
	}

	/**
	 * Tests the '{@link de.util.graph.IndexMgr#removeAll() <em>Remove All</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.util.graph.IndexMgr#removeAll()
	 */
	public void testRemoveAll() 
	{
		String[] indexNames= {"index1", "index2", "index3"};
		Index index= null;
		for (String indexName: indexNames)
		{
			index= IndexFactory.eINSTANCE.createSimpleIndex();
			index.setId(indexName);
			this.getFixture().addIndex(index);
			assertEquals(index, this.getFixture().getIndex(indexName));
		}
	
		this.getFixture().removeAll();
		for (String indexName: indexNames)
		{
			assertNull(this.getFixture().getIndex(indexName));
		}
	}

	/**
	 * Tests the '{@link de.noName.graph.IndexMgr#removeElement(java.lang.Object) <em>Remove Element</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.noName.graph.IndexMgr#removeElement(java.lang.Object)
	 */
	public void testRemoveElement__Object() 
	{	
		String elemId= "id1";
		String elem= "elem1";
		String idxId= "idx1";
		SimpleIndex index= IndexFactory.eINSTANCE.createSimpleIndex();
		index.setId(idxId);
		index.addElement(elemId, elem);
		this.getFixture().addIndex(index);
		assertTrue(this.getFixture().removeElement(elem));
		assertNull(((SimpleIndex)this.getFixture().getIndex(idxId)).getElement(elemId));
	}
} //IndexMgrTest
