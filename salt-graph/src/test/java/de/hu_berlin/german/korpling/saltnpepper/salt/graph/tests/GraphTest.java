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

import java.util.Collection;
import java.util.Vector;

import junit.textui.TestRunner;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.exceptions.GraphException;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.tests.GraphTraverserModuleTest;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getIndexMgr() <em>Index Mgr</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getNumOfNodes() <em>Num Of Nodes</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getNumOfEdges() <em>Num Of Edges</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getNumOfLayers() <em>Num Of Layers</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#addNode(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node) <em>Add Node</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getNode(java.lang.String) <em>Get Node</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#removeNode(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node) <em>Remove Node</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#removeNodeById(java.lang.String) <em>Remove Node By Id</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#addEdge(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge) <em>Add Edge</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getEdge(java.lang.String) <em>Get Edge</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getEdges(java.lang.String, java.lang.String) <em>Get Edges</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getInEdges(java.lang.String) <em>Get In Edges</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getOutEdges(java.lang.String) <em>Get Out Edges</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#removeEdgeById(java.lang.String) <em>Remove Edge By Id</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#removeEdges() <em>Remove Edges</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#removeNodes() <em>Remove Nodes</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#removeEdge(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge) <em>Remove Edge</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#changeEdgeSource(java.lang.String, java.lang.String) <em>Change Edge Source</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#changeEdgeTarget(java.lang.String, java.lang.String) <em>Change Edge Target</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#addNode(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node, de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer) <em>Add Node</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#addEdge(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge, de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer) <em>Add Edge</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#addLayer(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer) <em>Add Layer</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getLayer(java.lang.String) <em>Get Layer</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getRoots() <em>Get Roots</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getLeafs() <em>Get Leafs</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#traverse(org.eclipse.emf.common.util.EList, de.hu_berlin.german.korpling.saltnpepper.salt.graph.GRAPH_TRAVERSE_TYPE, java.lang.String, de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphTraverseHandler) <em>Traverse</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#traverse(org.eclipse.emf.common.util.EList, de.hu_berlin.german.korpling.saltnpepper.salt.graph.GRAPH_TRAVERSE_TYPE, java.lang.String, de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphTraverseHandler, boolean) <em>Traverse</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class GraphTest extends IdentifiableElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(GraphTest.class);
	}

	/**
	 * Constructs a new Graph test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Graph getFixture() {
		return (Graph)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(GraphFactory.eINSTANCE.createGraph());
		this.getFixture().setId("graph1");
		//Knotenliste erstellen
		nodes= new Vector<Node>();
		for (String nodeName: nodeNames)
		{
			Node node= GraphFactory.eINSTANCE.createNode();
			node.setId(nodeName);
			nodes.add((node));
		}
		
		//Kantenliste erstellen
		edges= new BasicEList<Edge>();
		Edge edge= null;
		for (int i= 0; i < edgeNames.length; i++)
		{
			for (Node srcNode: nodes)
			{
				if (((String)srcNode.getId()).equalsIgnoreCase(edgeNames[i][0]))
				{
					for (Node dstNode: nodes)
					{
						if (((String)dstNode.getId()).equalsIgnoreCase(edgeNames[i][1]))
						{
							edge= GraphFactory.eINSTANCE.createEdge();
							edge.setId(edgeNames[i][2]);
							edge.setSource(srcNode);
							edge.setTarget(dstNode);
							edges.add(edge);
							break;
						}
					}
					break;
				}
			}
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
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getIndexMgr() <em>Index Mgr</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getIndexMgr()
	 */
	public void testGetIndexMgr() 
	{
		assertNotNull(this.getFixture().getIndexMgr());
		this.testSetIndexMgr();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#setIndexMgr(de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr) <em>Index Mgr</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#setIndexMgr(de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr)
	 */
	public void testSetIndexMgr() 
	{
		IndexMgr indexMgr= IndexFactory.eINSTANCE.createIndexMgr();
		this.getFixture().setIndexMgr(indexMgr);
		assertEquals(indexMgr, this.getFixture().getIndexMgr());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getNumOfNodes() <em>Num Of Nodes</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getNumOfNodes()
	 */
	public void testGetNumOfNodes() 
	{
		int i= 0;
		assertEquals(new Long(i), this.getFixture().getNumOfNodes());
		//adding nodes
		for (Node node: this.nodes)
		{
			this.getFixture().addNode(node);
			i++;
			assertEquals(new Long(i), this.getFixture().getNumOfNodes());
		}
		//removing nodes
		for (Node node: this.nodes)
		{
			this.getFixture().removeNodeById(node.getId());
			i--;
			assertEquals(new Long(i), this.getFixture().getNumOfNodes());
		}
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getNumOfEdges() <em>Num Of Edges</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getNumOfEdges()
	 */
	public void testGetNumOfEdges() 
	{
		int i= 0;
		assertEquals(new Long(i), this.getFixture().getNumOfEdges());
		this.insertNodes(this.nodes);
		//adding nodes
		for (Edge edge: this.edges)
		{
			this.getFixture().addEdge(edge);
			i++;
			assertEquals(new Long(i), this.getFixture().getNumOfEdges());
		}
		//removing nodes
		for (Edge edge: this.edges)
		{
			this.getFixture().removeEdgeById(edge.getId());
			i--;
			assertEquals(new Long(i), this.getFixture().getNumOfEdges());
		}
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getNumOfLayers() <em>Num Of Layers</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getNumOfLayers()
	 */
	public void testGetNumOfLayers() 
	{
		assertEquals(new Long(0), this.getFixture().getNumOfLayers());
		
		Layer layer= GraphFactory.eINSTANCE.createLayer();
		this.getFixture().addLayer(layer);
		
		assertEquals(new Long(1), this.getFixture().getNumOfLayers());
		layer= GraphFactory.eINSTANCE.createLayer();
		this.getFixture().addLayer(layer);
		assertEquals(new Long(2), this.getFixture().getNumOfLayers());
		
		this.getFixture().getLayers().remove(0);
		assertEquals(new Long(1), this.getFixture().getNumOfLayers());
	}

	/**
	 * Tested die verschiedenen Konstruktoren der Klasse Graph
	 * @throws Exception
	 */
	public void testCreate() throws Exception
	{
			//gerichteten, georderten Graph mit Namen erzeugen
			this.getFixture().setId("graph1");
			assertEquals("graph1", this.getFixture().getId());
	}
	
	/**
	 * Knotennamen f�r zu erstellende Knoten als String
	 */
	private String[] nodeNames= {"node1", "node2", "node3", "node4", "node5", "node6", "node7"};
	
	/**
	 * Liste von Knoten
	 */
	private Collection<Node> nodes= null;
	
	/**
	 * Knotennamen f�r zu erstellende Knoten als String
	 */
	private String[][] edgeNames= {	{"node1", "node2", "edge1"}, {"node2", "node3","edge2"}, 
									{"node1", "node4", "edge3"},{"node4", "node5", "edge4"},
									{"node2", "node6", "edge5"}, {"node1", "node7", "edge6"}};
	
	/**
	 * Liste von Knoten
	 */
	private EList<Edge> edges= null;
	
	/**
	 * F�gt die �bergebenen Knoten in den Graphen ein
	 * @param nodes in den Graphen einzuf�genden Knoten
	 * @throws Exception
	 */
	private void insertNodes(Collection<Node> nodes)
	{
		for (Node node: nodes)
		{
			this.getFixture().addNode(node);
		}
	}
	
	/**
	 * F�gt die �bergebenen Kanten in den Graphen ein
	 * @param modeNames zweidimensionaler String, in dem die Namen der Quell- und Zielknoten stehen (Quelle, Ziel)
	 * @throws Exception
	 */
	private void insertEdges(Collection<Edge> edges)
	{
		for (Edge edge: edges)
		{
			this.getFixture().addEdge(edge);
		}
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#addNode(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node) <em>Add Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#addNode(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node)
	 */
	public void testAddNode__Node() 
	{
		//Knoten in den Graphen einf�gen
		for (Node node: nodes)
		{
			this.getFixture().addNode(node);
		}
		
		for (Node node: this.nodes)
		{	
			assertEquals("the graph should have the node '"+node.getId()+"' ", node, this.getFixture().getNode(node.getId()));
			
		}
		//Knoten suchen, der nicht im Graph ist
		assertNull("this node shouln�t exist",this.getFixture().getNode("not there"));
	}
	
	public void testAddNodeByAddingInList() 
	{
		//Knoten in den Graphen einf�gen
		for (Node node: nodes)
		{
			this.getFixture().getNodes().add(node);
		}
		
		for (Node node: this.nodes)
		{	
			assertEquals("the graph should have the node '"+node.getId()+"' ", node, this.getFixture().getNode(node.getId()));
			
		}
		//Knoten suchen, der nicht im Graph ist
		assertNull("this node shouln�t exist",this.getFixture().getNode("not there"));
	}

	

	/**
	 * Testet das Einf�gen von Knoten in den Graphen.
	 * @throws Exception
	 */
	public void testInsertNodes() throws Exception
	{
		
			//Knoten in den Graphen einf�gen
			this.insertNodes(nodes);
			for (Node node: this.nodes)
			{	
				assertEquals("the graph should have the node '"+node.getId()+"' ", node, this.getFixture().getNode(node.getId()));
				
			}
			//Knoten suchen, der nicht im Graph ist
			assertNull("this node shouln�t exist",this.getFixture().getNode("not there"));
	}

	/**
	 * Diese Methode pr�ft ob alle eingef�gten Knoten auch zur�ckbekommen werden k�nnen.
	 * @throws Exception
	 */
	public void testGettingNodes() throws Exception
	{
			
		//Knoten in den Graphen einf�gen
		this.insertNodes(nodes);
		assertNotNull(nodes);
		assertNotSame(0, nodes.size());
		//Knoten aus dem Graph auslesen
		for(Node node: nodes)
		{
			assertNotNull(this.getFixture().getNode(node.getId()));
			assertEquals(node, this.getFixture().getNode(node.getId()));
		}
	}
	/**
	 * Testet das Einf�gen von Knoten in den Graphen.
	 * @throws Exception
	 */
	public void testGettingAllNodes() throws Exception
	{
		this.insertNodes(nodes);
		Collection<Node> returnedNodes= this.getFixture().getNodes();
		boolean hasAllNodes= true;
		for (Node node: nodes)
		{
			if (!returnedNodes.contains(node))
			 hasAllNodes= false;
		}
		assertTrue("not all nodes are returned back by getNodes()", hasAllNodes);
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getNode(java.lang.String) <em>Get Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getNode(java.lang.String)
	 */
	public void testGetNode__String() 
	{
		for (Node node: this.nodes )
		{
			this.getFixture().addNode(node);
			assertEquals(node, this.getFixture().getNode(node.getId()));
		}
		for (Node node: this.nodes )
		{
			assertEquals(node, this.getFixture().getNode(node.getId()));
		}
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#removeNodeById(java.lang.String) <em>Remove Node By Id</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#removeNodeById(java.lang.String)
	 */
	public void testRemoveNodeById__String() 
	{
		for (Node node: this.nodes )
		{
			this.getFixture().addNode(node);
			assertEquals(node, this.getFixture().getNode(node.getId()));
		}
		for (String nodeName: nodeNames)
		{
			assertNotNull(this.getFixture().getNode(nodeName));
			this.getFixture().removeNodeById(nodeName);
			assertNull("node '"+nodeName+"' should be removed", this.getFixture().getNode(nodeName));
		}
	}
	
		/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#removeNode(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node) <em>Remove Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#removeNode(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node)
	 */
	public void testRemoveNode__Node() 
	{
		for (Node node: this.nodes )
		{
			this.getFixture().addNode(node);
			assertEquals(node, this.getFixture().getNode(node.getId()));
		}
		for (Node node: this.nodes)
		{
			assertNotNull(this.getFixture().getNode(node.getId()));
			this.getFixture().removeNode(node);
			assertNull("node '"+node+"' should be removed", this.getFixture().getNode(node.getId()));
		}
	}
	
	public void testRemoveNodeByRemovingFromList() 
	{
		for (Node node: this.nodes )
		{
			this.getFixture().addNode(node);
			assertEquals(node, this.getFixture().getNode(node.getId()));
		}
		for (String nodeName: nodeNames)
		{
			assertNotNull(this.getFixture().getNode(nodeName));
			this.getFixture().getNodes().remove(this.getFixture().getNode(nodeName));
			assertNull("node '"+nodeName+"' should be removed", this.getFixture().getNode(nodeName));
		}
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#removeNodes() <em>Remove Nodes</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#removeNodes()
	 */
	public void testRemoveNodes() 
	{
		//insert node into graph
		this.insertNodes(nodes);
		//check if node is there
		for (Node node: nodes)
		{
			assertSame("this node '"+node.getId()+"' should be there", node, this.getFixture().getNode(node.getId()));
		}
		//remove node
		assertTrue(this.getFixture().removeNodes());
		for (Node node: nodes)
		{	
			assertNull("this node '"+node.getId()+"' shouldn�t be there", this.getFixture().getNode(node.getId()));
		}
		//insert nodes into graph
		this.insertNodes(nodes);
		//check if nodes are there
		for (Node node: nodes)
		{
			assertSame("this node '"+node.getId()+"' should be there", node, this.getFixture().getNode(node.getId()));
		}
		//remove nodes
		assertTrue(this.getFixture().removeNodes());
		for (Node node: nodes)
		{	
			assertNull("this node '"+node.getId()+"' shouldn�t be there", this.getFixture().getNode(node.getId()));
		}
		//try to remove node which is not there
		Node node= GraphFactory.eINSTANCE.createNode();
		node.setId("not there");
		assertFalse(this.getFixture().removeNodeById(node.getId()));
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#addEdge(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge) <em>Add Edge</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#addEdge(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge)
	 */
	public void testAddEdge__Edge() 
	{
		Node node1 = GraphFactory.eINSTANCE.createNode();
		node1.setId("node1");
		Node node2 = GraphFactory.eINSTANCE.createNode();
		node2.setId("node2");
		
		Edge edge1= GraphFactory.eINSTANCE.createEdge();
		edge1.setId("edge1");
		edge1.setSource(node1);
		edge1.setTarget(node2);
		//adding edge, shall not be ok (source and destination does not belong to graph)
		try {
			this.getFixture().addEdge(edge1);
			fail("Shall not add edge, if source and destination isn�t contained in the graph.");
		} catch (Exception e) 
		{}
		this.getFixture().addNode(node1);
		this.getFixture().addNode(node2);
		//adding edge, shall be ok 
		this.getFixture().addEdge(edge1);
		assertEquals(edge1, this.getFixture().getEdge("edge1"));
		//adding edge, shall be not ok
		try {
			this.getFixture().addEdge(edge1);
			fail("Shall not add edge, because edge is already added.");
		} catch (Exception e) {
		}
	}
	
	public void testAddEdge__Edge2() 
	{
		setFixture(GraphFactory.eINSTANCE.createGraph());
		
		Node node1 = GraphFactory.eINSTANCE.createNode();
		Node node2 = GraphFactory.eINSTANCE.createNode();
		Edge edge1 = GraphFactory.eINSTANCE.createEdge();
		
		this.getFixture().addEdge(edge1);
		this.getFixture().addNode(node1);		
		this.getFixture().addNode(node2);		
		
		edge1.setSource(node1);
		edge1.setTarget(node2);
		
//		assertTrue(this.getFixture().getOutEdges(node1.getId()).contains(edge1));
//		assertTrue(this.getFixture().getInEdges(node2.getId()).contains(edge1));		
		
//		System.out.println("node1 contains these InEdges:\t" + this.getFixture().getInEdges(node1.getId()));
		System.out.println("node1 contains these OutEdges:\t" + this.getFixture().getOutEdges(node1.getId()));
		System.out.println("node2 contains these InEdges:\t" + this.getFixture().getInEdges(node2.getId()));
//		System.out.println("node2 contains these OutEdges:\t" + this.getFixture().getOutEdges(node2.getId()));
		
		edge1.setSource(node2);
		edge1.setTarget(node1);

//		assertTrue(this.getFixture().getInEdges(node1.getId()).contains(edge1));
//		assertTrue(this.getFixture().getOutEdges(node2.getId()).contains(edge1));		
		
		System.out.println("node1 contains these InEdges:\t" + this.getFixture().getInEdges(node1.getId()));
//		System.out.println("node1 contains these OutEdges:\t" + this.getFixture().getOutEdges(node1.getId()));
//		System.out.println("node2 contains these InEdges:\t" + this.getFixture().getInEdges(node2.getId()));
		System.out.println("node2 contains these OutEdges:\t" + this.getFixture().getOutEdges(node2.getId()));
	}
		
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#addEdge(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge) <em>Add Edge</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#addEdge(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge)
	 */
	public void testAddEdge__EdgeByListAdding() 
	{
		Node node1 = GraphFactory.eINSTANCE.createNode();
		node1.setId("node1");
		Node node2 = GraphFactory.eINSTANCE.createNode();
		node2.setId("node2");
		
		Edge edge1= GraphFactory.eINSTANCE.createEdge();
		edge1.setId("edge1");
		edge1.setSource(node1);
		edge1.setTarget(node2);
		//adding edge, shall not be ok (source and destination does not belong to graph)
		try {
			this.getFixture().getEdges().add(edge1);
			fail("Shall not add edge, if source and destination isn�t contained in the graph.");
		} catch (Exception e) 
		{}
		this.getFixture().getNodes().add(node1);
		this.getFixture().getNodes().add(node2);
		//adding edge, shall be ok 
		this.getFixture().getEdges().add(edge1);
		assertEquals(edge1, this.getFixture().getEdge("edge1"));
		
		//adding edge, shall be not ok
		EList<Edge> edges= new BasicEList<Edge>();
		edges.addAll(this.getFixture().getEdges());
		
		this.getFixture().getEdges().add(edge1);
		assertTrue("Shall not add edge, because edge is already added.", this.getFixture().getEdges().containsAll(edges));
		assertTrue("Shall not add edge, because edge is already added.", edges.containsAll(this.getFixture().getEdges()));
	}

	/**
	 * Testet das Einf�gen von Kanten in den Graphen.
	 * @TODO hier m�ssen noch die ganzen anderen createEdge()-Methoden getestet werden
	 * @throws Exception
	 */
	public void testInsertEdges() throws Exception
	{
		
		//Knoten in den Graphen einf�gen
		this.insertNodes(nodes);
		//Kanten in den Graphen einf�gen
		this.insertEdges(edges);
		//Pr�fen ob Kanten eingef�gt wurden
		for (Edge edge: edges)
		{
			assertSame("this edge '"+edge.getId()+"' should be there", edge, this.getFixture().getEdge(edge.getId()));
		}
		//Kante einf�gen, deren Knoten es nicht gibt
		try
		{
			Node node= GraphFactory.eINSTANCE.createNode();
			node.setId("not there");
			Edge edge= GraphFactory.eINSTANCE.createEdge();
			edge.setSource(node);
			edge.setTarget(node);
			this.getFixture().addEdge(edge);
			fail("an edge between not existing nodes is not possible");
		}
		catch (Exception e)
		{}
		
		//alle Kanten l�schen
		this.getFixture().removeEdges();
		//neue Kanten einf�gen
		for (Edge edge: edges )
		{
			//Kante einf�gen
			this.getFixture().addEdge(edge);
			//Pr�fen ob Kante da ist
			assertEquals("created edge has to be there", this.getFixture().getEdge(edge.getId()), edge);
		}
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getEdge(java.lang.String) <em>Get Edge</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getEdge(java.lang.String)
	 */
	public void testGetEdge__String() 
	{
		Node node1 = GraphFactory.eINSTANCE.createNode();
		node1.setId("node1");
		Node node2 = GraphFactory.eINSTANCE.createNode();
		node2.setId("node2");
		
		Edge edge1= GraphFactory.eINSTANCE.createEdge();
		edge1.setId("edge1");
		edge1.setSource(node1);
		edge1.setTarget(node2);
		
		assertNull(this.getFixture().getEdge(edge1.getId()));
		this.getFixture().addNode(node1);
		this.getFixture().addNode(node2);
		this.getFixture().addEdge(edge1);
		assertEquals(edge1, this.getFixture().getEdge(edge1.getId()));
	}

		/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getEdge(java.lang.String, java.lang.String) <em>Get Edge</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getEdge(java.lang.String, java.lang.String)
	 */
	public void testGetEdges__String_String() 
	{
		//Knoten in den Graphen einf�gen
		this.insertNodes(nodes);
		//Kanten in den Graphen einf�gen
		this.insertEdges(edges);
		//Pr�fen ob Kanten eingef�gt wurden
		for (Edge edge: edges)
		{
			assertSame("this edge '"+edge.getId()+"' should be there", edge, this.getFixture().getEdge(edge.getId()));
			//removing edge
			EList<Edge> edgeList= this.getFixture().getEdges(edge.getSource().getId(), edge.getTarget().getId());
			assertTrue(edgeList.contains(edge));
		}
	}

		/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getInEdges(java.lang.String) <em>Get In Edges</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getInEdges(java.lang.String)
	 */
	public void testGetInEdges__String() 
	{
		//Knoten in den Graphen einf�gen
		this.insertNodes(nodes);
		//Kanten in den Graphen einf�gen
		this.insertEdges(edges);
		for(Edge edge: this.edges)
		{
			//check if node belongs to toNode
			assertTrue("this inserted edge should be in getInEdges",this.getFixture().getInEdges(edge.getTarget().getId()).contains(edge));
		}	
	}

		/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getOutEdges(java.lang.String) <em>Get Out Edges</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getOutEdges(java.lang.String)
	 */
	public void testGetOutEdges__String() 
	{
		//Knoten in den Graphen einf�gen
		this.insertNodes(nodes);
		//Kanten in den Graphen einf�gen
		this.insertEdges(edges);
		for(Edge edge: this.edges)
		{
			//check if node belongs to toNodes
			assertTrue("this inserted edge should be in getOutEdges",this.getFixture().getOutEdges(edge.getSource().getId()).contains(edge));
		}		
	}

		/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#removeEdgeById(java.lang.String) <em>Remove Edge By Id</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#removeEdgeById(java.lang.String)
	 */
	public void testRemoveEdgeById__String() 
	{
		//Knoten in den Graphen einf�gen
		this.insertNodes(nodes);
		//Kanten in den Graphen einf�gen
		this.insertEdges(edges);
		//Pr�fen ob Kanten eingef�gt wurden
		for (Edge edge: edges)
		{
			assertSame("this edge '"+edge.getId()+"' should be there", edge, this.getFixture().getEdge(edge.getId()));
		}
		//Kante l�schen
		for (Edge edge: edges)
		{
			if (this.getFixture().getEdge(edge.getId())!= null)
			{
				assertSame("this edge '"+edge.getId()+"' should be there", edge, this.getFixture().getEdge(edge.getId()));	
				assertTrue(this.getFixture().removeEdgeById(edge.getId()));
				assertNull("this edge '"+edge.getId()+"' shouldn�t be there", this.getFixture().getEdge(edge.getId()));
			}
		}
		//Kante entfernen, deren Knoten es nicht gibt
		Edge edge= GraphFactory.eINSTANCE.createEdge();
		edge.setId("not there");
		assertFalse(this.getFixture().removeEdgeById(edge.getId()));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#removeEdges() <em>Remove Edges</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#removeEdges()
	 */
	public void testRemoveEdges() 
	{
		//Knoten in den Graphen einf�gen
		this.insertNodes(nodes);
		//Kanten in den Graphen einf�gen
		this.insertEdges(edges);
		//Pr�fen ob Kanten eingef�gt wurden
		for (Edge edge: edges)
		{
			assertSame("this edge '"+edge.getId()+"' should be there", edge, this.getFixture().getEdge(edge.getId()));
		}
		//Kante l�schen
		assertTrue(this.getFixture().removeEdges());
		for (Edge edge: edges)
		{	
			assertNull("this edge '"+edge.getId()+"' shouldn�t be there", this.getFixture().getEdge(edge.getId()));
		}
		//Kante entfernen, deren Knoten es nicht gibt
		Edge edge= GraphFactory.eINSTANCE.createEdge();
		edge.setId("not there");
		assertFalse(this.getFixture().removeEdgeById(edge.getId()));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#removeEdge(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge) <em>Remove Edge</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#removeEdge(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge)
	 */
	public void testRemoveEdge__Edge() 
	{
		//Knoten in den Graphen einf�gen
		this.insertNodes(nodes);
		//Kanten in den Graphen einf�gen
		this.insertEdges(edges);
		//Pr�fen ob Kanten eingef�gt wurden
		for (Edge edge: edges)
		{
			assertSame("this edge '"+edge.getId()+"' should be there", edge, this.getFixture().getEdge(edge.getId()));
		}
		//Kante l�schen
		for (Edge edge: edges)
		{
			if (this.getFixture().getEdge(edge.getId())!= null)
			{
				assertSame("this edge '"+edge.getId()+"' should be there", edge, this.getFixture().getEdge(edge.getId()));	
				assertTrue(this.getFixture().removeEdge(edge));
				assertNull("this edge '"+edge.getId()+"' shouldn�t be there", this.getFixture().getEdge(edge.getId()));
			}
		}
		//Kante entfernen, deren Knoten es nicht gibt
		Edge edge= GraphFactory.eINSTANCE.createEdge();
		edge.setId("not there");
		assertFalse(this.getFixture().removeEdge(edge));
	}
	
	public void testIncompleteEdge()
	{
		Edge edge= GraphFactory.eINSTANCE.createEdge();
		edge.setId("edge1");
		this.getFixture().addEdge(edge);
		
		Node node1= GraphFactory.eINSTANCE.createNode();
		node1.setId("node1");
		this.getFixture().addNode(node1);
		
		Node node2= GraphFactory.eINSTANCE.createNode();
		node2.setId("node2");
		this.getFixture().addNode(node2);
		
		edge.setSource(node1);
		edge.setTarget(node2);
		
		assertTrue(this.getFixture().getOutEdges(node1.getId()).contains(edge));
		assertTrue(this.getFixture().getInEdges(node2.getId()).contains(edge));
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#changeEdgeSource(java.lang.String, java.lang.String) <em>Change Edge Source</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#changeEdgeSource(java.lang.String, java.lang.String)
	 */
	public void testChangeEdgeSource__String_String() 
	{
		Edge edge= GraphFactory.eINSTANCE.createEdge();
		edge.setId("edge1");
		this.getFixture().addEdge(edge);
		
		Node node1= GraphFactory.eINSTANCE.createNode();
		node1.setId("node1");
		this.getFixture().addNode(node1);
		
		Node node2= GraphFactory.eINSTANCE.createNode();
		node2.setId("node2");
		this.getFixture().addNode(node2);
		
		edge.setSource(node1);
		edge.setTarget(node2);
		
		assertTrue(this.getFixture().getOutEdges(node1.getId()).contains(edge));
		assertTrue(this.getFixture().getInEdges(node2.getId()).contains(edge));
		
		Node node3= GraphFactory.eINSTANCE.createNode();
		node3.setId("node3");
		this.getFixture().addNode(node3);
		
		//redirect source
		edge.setSource(node3);
		assertTrue(this.getFixture().getOutEdges(node3.getId()).contains(edge));
		assertTrue(this.getFixture().getOutEdges(node1.getId()).isEmpty());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#changeEdgeTarget(java.lang.String, java.lang.String) <em>Change Edge Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#changeEdgeTarget(java.lang.String, java.lang.String)
	 */
	public void testChangeEdgeTarget__String_String() 
	{
		Edge edge= GraphFactory.eINSTANCE.createEdge();
		edge.setId("edge1");
		this.getFixture().addEdge(edge);
		
		Node node1= GraphFactory.eINSTANCE.createNode();
		node1.setId("node1");
		this.getFixture().addNode(node1);
		
		Node node2= GraphFactory.eINSTANCE.createNode();
		node2.setId("node2");
		this.getFixture().addNode(node2);
		
		edge.setSource(node1);
		edge.setTarget(node2);
		
		assertTrue(this.getFixture().getOutEdges(node1.getId()).contains(edge));
		assertTrue(this.getFixture().getInEdges(node2.getId()).contains(edge));
		
		Node node3= GraphFactory.eINSTANCE.createNode();
		node3.setId("node3");
		this.getFixture().addNode(node3);
		//redirect source
		edge.setTarget(node3);
		assertTrue(this.getFixture().getInEdges(node3.getId()).contains(edge));
		assertTrue(this.getFixture().getInEdges(node2.getId()).isEmpty());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#addNode(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node, de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer) <em>Add Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#addNode(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node, de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer)
	 */
	public void testAddNode__Node_Layer() 
	{
		EList<Node> nodesOflayer1= null;
		Layer layer1= null;
		EList<Node> nodesOflayer2= null;
		Layer layer2= null;
		
		layer1= GraphFactory.eINSTANCE.createLayer();
		layer2= GraphFactory.eINSTANCE.createLayer();
		
		{//adding null node to layer
			this.getFixture().addNode(null, layer1);
		}//adding null node to layer
		
		nodesOflayer1= new BasicEList<Node>();
		for (int i= 1; i< 5; i++)
			nodesOflayer1.add(GraphFactory.eINSTANCE.createNode());
		
		{//adding nodes to non existing layer
			layer1= GraphFactory.eINSTANCE.createLayer();
			
			Node node= GraphFactory.eINSTANCE.createNode();
			this.getFixture().addNode(node, layer1);
			assertTrue(layer1.getNodes().contains(node));
			assertEquals(node, this.getFixture().getNode(node.getId()));
		}//adding nodes to non existing layer
		
		this.getFixture().addLayer(layer1);
		for (Node node: nodesOflayer1)
			this.getFixture().addNode(node, layer1);
		
		nodesOflayer2= new BasicEList<Node>();
		for (int i= 1; i< 5; i++)
			nodesOflayer2.add(GraphFactory.eINSTANCE.createNode());
		this.getFixture().addLayer(layer2);
		for (Node node: nodesOflayer2)
			this.getFixture().addNode(node, layer2);
		
		{//checking if layer 1 and 2 contains all nodes
			assertTrue(layer1.getNodes().containsAll(nodesOflayer1));
			for (Node node: nodesOflayer1)
				assertTrue(node.getLayers().contains(layer1));
			for (Node node: nodesOflayer2)
				assertTrue(node.getLayers().contains(layer2));
			assertTrue(layer2.getNodes().containsAll(nodesOflayer2));
		}//checking if layer 1 and 2 contains all nodes
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#addEdge(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge, de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer) <em>Add Edge</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#addEdge(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge, de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer)
	 */
	public void testAddEdge__Edge_Layer() 
	{
		EList<Edge> edgesOflayer1= null;
		Layer layer1= null;
		EList<Edge> edgesOflayer2= null;
		Layer layer2= null;
		
		layer1= GraphFactory.eINSTANCE.createLayer();
		layer2= GraphFactory.eINSTANCE.createLayer();
		
		{//adding null edge to layer
			this.getFixture().addEdge(null, layer1);
		}//adding null edge to layer
		
		edgesOflayer1= new BasicEList<Edge>();
		for (int i= 1; i< 5; i++)
			edgesOflayer1.add(GraphFactory.eINSTANCE.createEdge());
		
		{//adding edges to non existing layer
			layer1= GraphFactory.eINSTANCE.createLayer();
			
			Edge edge= GraphFactory.eINSTANCE.createEdge();
			this.getFixture().addEdge(edge, layer1);
			assertTrue(layer1.getEdges().contains(edge));
			assertEquals(edge, this.getFixture().getEdge(edge.getId()));
		}//adding edges to non existing layer
		
		this.getFixture().addLayer(layer1);
		for (Edge edge: edgesOflayer1)
			this.getFixture().addEdge(edge, layer1);
		
		edgesOflayer2= new BasicEList<Edge>();
		for (int i= 1; i< 5; i++)
			edgesOflayer2.add(GraphFactory.eINSTANCE.createEdge());
		this.getFixture().addLayer(layer2);
		for (Edge edge: edgesOflayer2)
			this.getFixture().addEdge(edge, layer2);
		
		{//checking if layer 1 and 2 contains all edges
			assertTrue(layer1.getEdges().containsAll(edgesOflayer1));
			for (Edge edge: edgesOflayer1)
				assertTrue(edge.getLayers().contains(layer1));
			for (Edge edge: edgesOflayer2)
				assertTrue(edge.getLayers().contains(layer2));
			assertTrue(layer2.getEdges().containsAll(edgesOflayer2));
		}//checking if layer 1 and 2 contains all edges
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#addLayer(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer) <em>Add Layer</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#addLayer(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer)
	 */
	public void testAddLayer__Layer() 
	{
		Layer layer= null;
		{//adding null layer
			try {
				this.getFixture().addLayer(layer);
				fail("shall not add a null layer");
			} catch (GraphException e) {	}
		}//adding null layer
		
		{//adding layer
			layer= GraphFactory.eINSTANCE.createLayer();
			this.getFixture().addLayer(layer);
			assertTrue(this.getFixture().getLayers().contains(layer));
		}//adding layer
		
		{//adding layer second time shall fail
			try {
				this.getFixture().addLayer(layer);
				assertTrue(this.getFixture().getLayers().contains(layer));
				fail("shall not add a layer two times");
			} catch (GraphException e) {	}
			
		}//adding layer second time shall fail
		
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getLayer(java.lang.String) <em>Get Layer</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getLayer(java.lang.String)
	 */
	public void testGetLayer__String() 
	{
		Layer layer= null;
		String id= "id";
		
		layer= GraphFactory.eINSTANCE.createLayer();
		layer.setId(id);
		this.getFixture().addLayer(layer);
		assertEquals(layer, this.getFixture().getLayer(id));
	}

// ============================================== start: create dummy graphs
	/**
	 * Fills the given graph, containing nodes having the names as given in nodeNames list and connects them with edges as
	 * given in the edgeNames list.
	 * The edge names list contains of entries as follows:
	 * [[SOURCE_NODE_NAME, TARGET_NODE_NAME, EDGE_NAME],...]
	 * @param nodeNames
	 * @param edgeNames
	 */
	public static void createGraph(	Graph graph,
								String[] nodeNames,
								String[][] edgeNames)
	{
		Vector<Node> nodes= new Vector<Node>();
		for (String nodeName: nodeNames)
		{
			Node node= GraphFactory.eINSTANCE.createNode();
			node.setId(nodeName);
			nodes.add((node));
			graph.addNode(node);
		}
		
		//Kantenliste erstellen
		Vector<Edge> edges= new Vector<Edge>();
		Edge edge= null;
		for (int i= 0; i < edgeNames.length; i++)
		{
			for (Node srcNode: nodes)
			{
				if (((String)srcNode.getId()).equalsIgnoreCase(edgeNames[i][0]))
				{
					for (Node dstNode: nodes)
					{
						if (((String)dstNode.getId()).equalsIgnoreCase(edgeNames[i][1]))
						{
							edge= GraphFactory.eINSTANCE.createEdge();
							edge.setId(edgeNames[i][2]);
							edge.setSource(srcNode);
							edge.setTarget(dstNode);
							edges.add(edge);
							graph.addEdge(edge);
							break;
						}
					}
					break;
				}
			}
		}	
	}
	
	/**
	 * Creates the following graph: <br/>
	 * 				node1					<br/>
	 *			/		\		\			<br/>
	 *		node2		node4	node7		<br/>
	 *		/		\	|					<br/>
	 *	node3	node6	node5				<br/>
	 **/
	public static Graph createGraph_Tree()
	{
		Graph graph= GraphFactory.eINSTANCE.createGraph();
		graph.setId("createGraph_Tree");
		String[] nodeNames= {"node1", "node2", "node3", "node4", "node5", "node6", "node7"};
		String[][] edgeNames= {	{"node1", "node2", "edge1"}, {"node2", "node3","edge2"}, 
								{"node1", "node4", "edge3"},{"node4", "node5", "edge4"},
								{"node2", "node6", "edge5"}, {"node1", "node7", "edge6"}};
	
		createGraph(graph, nodeNames, edgeNames);
		return(graph);
	}
	
	/**
	 * Creates the following graph: <br/>
	 * 	node1	node4				<br/>
	 *		\	/					<br/>
	 *		node2					<br/>
	 *		/	\					<br/>
	 *	node3	node6				<br/>
	 **/
	public static Graph createGraph_DAG()
	{
		Graph graph= GraphFactory.eINSTANCE.createGraph();
		graph.setId("createGraph_DAG");
		
		String[] nodeNames= {"node1", "node2", "node3", "node4","node6",};
		String[][] edgeNames= {	{"node1", "node2", "edge1"}, {"node2", "node3","edge2"}, 
								{"node2", "node6", "edge3"}, {"node4", "node2", "edge4"}};
	
		createGraph(graph, nodeNames, edgeNames);
		return(graph);
	}
	
	/**
	 * Creates the following graph including a cycle: <br/>
	 * 	node1	node4					<br/>
	 *		\	/						<br/>
	 *		node2						<br/>
	 *		/	\						<br/>
	 *	node3	node6 					<br/>
	 *				\					<br/>
	 *				 node 7				<br/>
	 * node 7 -> node2					<br/>
	 **/
	public static Graph createGraph_Cycle()
	{
		Graph graph= GraphFactory.eINSTANCE.createGraph();
		graph.setId("createGraph_Cycle");
		String[] nodeNames= {"node1", "node2", "node3", "node4","node6", "node7"};
		String[][] edgeNames= {	{"node1", "node2", "edge1"}, {"node2", "node3","edge2"}, 
								{"node2", "node6", "edge3"}, {"node4", "node2", "edge4"},
								{"node6", "node7", "edge5"}, {"node7", "node2", "edge6"}};
	
		createGraph(graph, nodeNames, edgeNames);
		return(graph);
	}	
	
	/**
	 * Creates the following graph including a cycle: <br/>
	 * 	node1							<br/>
	 *		\							<br/>
	 *		node2						<br/>
	 *		/	\						<br/>
	 *	node3	node6 					<br/>
	 *				\					<br/>
	 *				 node 7				<br/>
	 * node 7 -> node2					<br/>
	 **/
	public static Graph createGraph_SimpleCycle()
	{
		Graph graph= GraphFactory.eINSTANCE.createGraph();
		graph.setId("createGraph_Cycle");
		String[] nodeNames= {"node1", "node2", "node3", "node6", "node7"};
		String[][] edgeNames= {	{"node1", "node2", "edge1"}, {"node2", "node3","edge2"}, 
								{"node2", "node6", "edge3"}, {"node6", "node7", "edge5"}, 
								{"node7", "node2", "edge6"}};
	
		createGraph(graph, nodeNames, edgeNames);
		return(graph);
	}	
// ============================================== end: create dummy graphs	
	
	/**
 	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getRoots() <em>Get Roots</em>}' operation.
	 * Tests the method {@link GraphTraverserModule#getRoots()} and checks if the correct roots are returned, using the several graph types.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getRoots()
	 */
	public void testGetRoots()
	{
		EList<Node> expectedRoots= null;
		EList<Node> roots= null;
		Graph graph= null;
		
		{//test 1
			graph= createGraph_Tree();
			this.setFixture(graph);
			expectedRoots= new BasicEList<Node>();
			expectedRoots.add(graph.getNode("node1"));
			roots= this.getFixture().getRoots();
			assertEquals("The expected number of roots are not the same, as the returned number", expectedRoots.size(), roots.size());
			for (Node expectedRoot: expectedRoots)
			{
				assertTrue("The list of returned roots does not contain expected root '"+expectedRoot.getId()+"'.", roots.contains(expectedRoot));
			}
		}//test 1
		
		{//test 2
			graph= createGraph_DAG();
			this.setFixture(graph);
			expectedRoots= new BasicEList<Node>();
			expectedRoots.add(graph.getNode("node1"));
			expectedRoots.add(graph.getNode("node4"));
			roots= this.getFixture().getRoots();
			assertEquals("The expected number of roots are not the same, as the returned number", expectedRoots.size(), roots.size());
			for (Node expectedRoot: expectedRoots)
			{
				assertTrue("The list of returned roots does not contain expected root '"+expectedRoot.getId()+"'.", roots.contains(expectedRoot));
			}
		}//test 2
		
		{//test 3
			graph= createGraph_Cycle();
			this.setFixture(graph);
			expectedRoots= new BasicEList<Node>();
			expectedRoots.add(graph.getNode("node1"));
			expectedRoots.add(graph.getNode("node4"));
			roots= this.getFixture().getRoots();
			assertEquals("The expected number of roots are not the same, as the returned number", expectedRoots.size(), roots.size());
			for (Node expectedRoot: expectedRoots)
			{
				assertTrue("The list of returned roots does not contain expected root '"+expectedRoot.getId()+"'.", roots.contains(expectedRoot));
			}
		}//test 3
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getLeafs() <em>Get Leafs</em>}' operation.
	 * Tests the method {@link GraphTraverserModule#getLeafs()} and checks if the correct leafs are returned, using the several graph types.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getLeafs()
	 */
	public void testGetLeafs()
	{
		EList<Node> expectedLeafs= null;
		EList<Node> leafs= null;
		Graph graph= null;
		
		{//test 1
			graph= createGraph_Tree();
			this.setFixture(graph);
			expectedLeafs= new BasicEList<Node>();
			expectedLeafs.add(graph.getNode("node3"));
			expectedLeafs.add(graph.getNode("node6"));
			expectedLeafs.add(graph.getNode("node5"));
			expectedLeafs.add(graph.getNode("node7"));
			leafs= this.getFixture().getLeafs();
			assertEquals("The expected number of leafs are not the same, as the returned number", expectedLeafs.size(), leafs.size());
			for (Node expectedLeaf: expectedLeafs)
			{
				assertTrue("The list of returned roots does not contain expected leaf '"+expectedLeaf.getId()+"'.", leafs.contains(expectedLeaf));
			}
		}//test 1
		
		{//test 2
			graph= createGraph_DAG();
			this.setFixture(graph);
			expectedLeafs= new BasicEList<Node>();
			expectedLeafs.add(graph.getNode("node3"));
			expectedLeafs.add(graph.getNode("node6"));
			leafs= this.getFixture().getLeafs();
			assertEquals("The expected number of leafs are not the same, as the returned number", expectedLeafs.size(), leafs.size());
			for (Node expectedLeaf: expectedLeafs)
			{
				assertTrue("The list of returned leafs does not contain expected leaf '"+expectedLeaf.getId()+"'.", leafs.contains(expectedLeaf));
			}
		}//test 2
		
		{//test 3
			graph= createGraph_Cycle();
			this.setFixture(graph);
			expectedLeafs= new BasicEList<Node>();
			expectedLeafs.add(graph.getNode("node3"));
			leafs= this.getFixture().getLeafs();
			assertEquals("The expected number of leafs are not the same, as the returned number", expectedLeafs.size(), leafs.size());
			for (Node expectedLeaf: expectedLeafs)
			{
				assertTrue("The list of returned roots does not contain expected leaf '"+expectedLeaf.getId()+"'.", leafs.contains(expectedLeaf));
			}
		}//test 3
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#traverse(org.eclipse.emf.common.util.EList, de.hu_berlin.german.korpling.saltnpepper.salt.graph.GRAPH_TRAVERSE_TYPE, java.lang.String, de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphTraverseHandler) <em>Traverse</em>}' operation.
	 * This method do not check anything, instead of using these pleasse the traverse test methods in {@link GraphTraverserModuleTest}
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#traverse(org.eclipse.emf.common.util.EList, de.hu_berlin.german.korpling.saltnpepper.salt.graph.GRAPH_TRAVERSE_TYPE, java.lang.String, de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphTraverseHandler)
	 */
	public void testTraverse__EList_GRAPH_TRAVERSE_TYPE_String_GraphTraverseHandler() 
	{
		//delegated 
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#traverse(org.eclipse.emf.common.util.EList, de.hu_berlin.german.korpling.saltnpepper.salt.graph.GRAPH_TRAVERSE_TYPE, java.lang.String, de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphTraverseHandler, boolean) <em>Traverse</em>}' operation.
	 * This method do not check anything, instead of using these pleasse the traverse test methods in {@link GraphTraverserModuleTest}
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#traverse(org.eclipse.emf.common.util.EList, de.hu_berlin.german.korpling.saltnpepper.salt.graph.GRAPH_TRAVERSE_TYPE, java.lang.String, de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphTraverseHandler, boolean)
	 */
	public void testTraverse__EList_GRAPH_TRAVERSE_TYPE_String_GraphTraverseHandler_boolean() {
		//delegated
	}

	public void testRemoveEdge__EdgeByList() 
	{
		//Knoten in den Graphen einf�gen
		this.insertNodes(nodes);
		//Kanten in den Graphen einf�gen
		this.insertEdges(edges);
		//Pr�fen ob Kanten eingef�gt wurden
		for (Edge edge: edges)
		{
			assertSame("this edge '"+edge.getId()+"' should be there", edge, this.getFixture().getEdge(edge.getId()));
		}
		//Kante l�schen
		for (Edge edge: edges)
		{
			if (this.getFixture().getEdge(edge.getId())!= null)
			{
				assertSame("this edge '"+edge.getId()+"' should be there", edge, this.getFixture().getEdge(edge.getId()));	
				assertTrue(this.getFixture().getEdges().remove(edge));
				assertNull("this edge '"+edge.getId()+"' shouldn�t be there", this.getFixture().getEdge(edge.getId()));
			}
		}
		//Kante entfernen, deren Knoten es nicht gibt
		Edge edge= GraphFactory.eINSTANCE.createEdge();
		edge.setId("not there");
		assertFalse(this.getFixture().getEdges().remove(edge));
	}
	
	/**
	 * Testet das Entfernen aller Kanten des Graphen.
	 * @throws Exception
	 */
	public void testRemoveAllEdge() throws Exception
	{
		//add node to graph
		this.insertNodes(nodes);
		//add edges to graph
		this.insertEdges(edges);
		//check if edges have been added
		for (Edge edge: edges)
		{
			assertSame("this edge '"+edge.getId()+"' should be there", edge, this.getFixture().getEdge(edge.getId()));
		}
		//remove old edge
		this.getFixture().removeEdges();
		//add new edge
		for (Edge edge: edges )
		{
			//add edge
			this.getFixture().addEdge(edge);
			//check if edge exists
			assertEquals("created edge has to be there", this.getFixture().getEdge(edge.getId()), edge);
		}
	}
	
	/**
	 * Diese Methode tested das Anlegen, Zur�ckerhalten und L�schen eines benutzer-
	 * defienierten Index.
	 */
	public void testUserSimpleIndex() throws Exception
	{
		String idxNames[] = {"idx1", "idx2", "idx3", "idx4"};
		Index idx= null;
		//creating index
		for (String idxName: idxNames)
		{
			idx= IndexFactory.eINSTANCE.createSimpleIndex();
			idx.setId(idxName);
			this.getFixture().getIndexMgr().addIndex(idx);
			assertSame("the index '"+idxName+"' should exist", this.getFixture().getIndexMgr().getIndex(idxName), idx);
			assertTrue("the index '"+idxName+"' should exist", this.getFixture().getIndexMgr().hasIndex(idxName));
		}
		//removing index
		for (String idxName: idxNames)
		{
			idx= IndexFactory.eINSTANCE.createSimpleIndex();
			idx.setId(idxName);
			this.getFixture().getIndexMgr().removeIndex(idxName);
			assertNull("the index '"+idxName+"' should not exist", this.getFixture().getIndexMgr().getIndex(idxName));
			assertFalse("the index '"+idxName+"' should not exist", this.getFixture().getIndexMgr().hasIndex(idxName));
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
		long i= this.getFixture().getIndexMgr().getNumOfIndexes();
		String[] indexNames= {"index1", "index2", "index3", "index4", "index5"};
		for (String indexName: indexNames)
		{
			Index simpleIndex= IndexFactory.eINSTANCE.createSimpleIndex();
			simpleIndex.setId(indexName);
			this.getFixture().getIndexMgr().addIndex(simpleIndex);
		}
		assertEquals(indexNames.length, this.getFixture().getIndexMgr().getNumOfIndexes()-i);
	}
	public void testReverseGetLabel()
	{
		Label label= GraphFactory.eINSTANCE.createLabel();
		label.setName("labelName");
		this.getFixture().addLabel(label);
		
		assertEquals(this.getFixture(), label.getLabelableElement());
	}

	/**
	 * Tests the methods equals() and hachCode().
	 */
	public void testEquals()
	{
		this.basicTestEquals(GraphFactory.eINSTANCE.createGraph());
		
		Graph other= GraphFactory.eINSTANCE.createGraph();
		this.setFixture(GraphFactory.eINSTANCE.createGraph());
		{//check nodes
			Node node1= GraphFactory.eINSTANCE.createNode();
			node1.setId("id");
			Node node2= GraphFactory.eINSTANCE.createNode();
			node2.setId("id");
			
			assertEquals(this.getFixture(), other);
			assertEquals(this.getFixture().hashCode(), other.hashCode());
			
			this.getFixture().addNode(node1);
			assertFalse(this.getFixture().equals(other));
			assertTrue(this.getFixture().hashCode()== other.hashCode());
			other.addNode(node2);
			assertEquals(this.getFixture(), other);
			assertEquals(this.getFixture().hashCode(), other.hashCode());
		}//check nodes
		
		{//check edges
			Edge edge1= GraphFactory.eINSTANCE.createEdge();
			edge1.setId("id");
			Edge edge2= GraphFactory.eINSTANCE.createEdge();
			edge2.setId("id");
			
			assertEquals(this.getFixture(), other);
			assertEquals(this.getFixture().hashCode(), other.hashCode());
			
			this.getFixture().addEdge(edge1);
			assertFalse(this.getFixture().equals(other));
			assertTrue(this.getFixture().hashCode()== other.hashCode());
			other.addEdge(edge2);
			assertEquals(this.getFixture(), other);
			assertEquals(this.getFixture().hashCode(), other.hashCode());
		}//check edges
	}
	
} //GraphTest
