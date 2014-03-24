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
package de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.tests;

import java.util.Collection;
import java.util.Vector;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.GraphTraverser;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.GraphTraverserObject;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.TraversalObject;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.GraphTraverser.GRAPH_TRAVERSE_MODE;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.exceptions.GraphModuleException;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;

@Deprecated
public class GraphTraverserTest extends GraphModuleTest implements TraversalObject 
{
	public GraphTraverser getFixture() {
		return((GraphTraverser)super.getFixture());
	} 

	@Override
	protected void setUp() throws Exception 
	{
		setFixture(new GraphTraverser());
		nodes= new Vector<Node>();
		for (String nodeName: nodeNames)
		{
			Node node= GraphFactory.eINSTANCE.createNode();
			node.setId(nodeName);
			nodes.add((node));
		}
		
		//Kantenliste erstellen
		edges= new Vector<Edge>();
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
	private Collection<Edge> edges= null;
	
	/**
	 * F�gt die �bergebenen Knoten in den Graphen ein
	 * @param nodes in den Graphen einzuf�genden Knoten
	 * @throws Exception
	 */
	private void insertNodes(Graph graph, Collection<Node> nodes)
	{
		for (Node node: nodes)
		{
			graph.addNode(node);
		}
	}
	
	/**
	 * F�gt die �bergebenen Kanten in den Graphen ein
	 * @param modeNames zweidimensionaler String, in dem die Namen der Quell- und Zielknoten stehen (Quelle, Ziel)
	 * @throws Exception
	 */
	private void insertEdges(Graph graph, Collection<Edge> edges)
	{
		for (Edge edge: edges)
		{
			graph.addEdge(edge);
		}
	}
	
	/**
	 * Tests the '{@link de.util.graph.Graph#getRoots() <em>Get Roots</em>}' operation.
	 * 				node1
	 *			/		\		\
	 *		node2		node4	node7	
	 *		/		\	|
	 *	node3	node6	node5
	 * <!-- end-user-doc -->
	 * @see de.util.graph.Graph#getRoots()
	 */
	public void testGetRoots() 
	{
		Graph graph= GraphFactory.eINSTANCE.createGraph();
		this.getFixture().setGraph(graph);
		this.insertNodes(graph, nodes);
		this.insertEdges(graph, edges);
		EList<Node> realRoots= new BasicEList<Node>();
		assertNotNull(graph.getNode("node1"));
		realRoots.add(graph.getNode("node1"));
		assertTrue(realRoots.containsAll(this.getFixture().getRoots()));
		assertTrue(this.getFixture().getRoots().containsAll(realRoots));
	}

	public void testGetTraverserObject()
	{
		GRAPH_TRAVERSE_MODE tMode= null;
		TraversalObject travObj= null;
		try {
			this.getFixture().getTraverserObject(tMode, travObj);
			fail("Shall not return a traverserObject without graph.");
		} catch (GraphModuleException e) 
		{;}
		this.getFixture().setGraph(GraphFactory.eINSTANCE.createGraph());
		try {
			this.getFixture().getTraverserObject(tMode, travObj);
			fail("Shall not return a traverserObject without tMode.");
		} catch (GraphModuleException e) 
		{;}
		tMode= GRAPH_TRAVERSE_MODE.DEPTH_FIRST;
		try {
			this.getFixture().getTraverserObject(tMode, travObj);
			fail("Shall not return a traverserObject without travObj.");
		} catch (GraphModuleException e) 
		{;}
		travObj= this;
		GraphTraverserObject tObj1= this.getFixture().getTraverserObject(tMode, travObj);
		GraphTraverserObject tObj2= this.getFixture().getTraverserObject(tMode, travObj);
		assertFalse(tObj1.getId().equals(tObj2.getId()));
	}
	
	private EList<Node> depthFirstList1= null;
	private int depthFirstList1Idx= 0;
	private EList<Node> depthFirstList1Reverse= null;
	private int depthFirstList1IdxReverse= 0;
	private Long depthFirst1Id= null;
	private EList<Node> depthFirstList2= null;
	private int depthFirstList2Idx= 0;
	private EList<Node> depthFirstList2Reverse= null;
	private int depthFirstList2IdxReverse= 0;
	private Long depthFirst2Id= null;
	
	enum TEST_CASE {CASE1, CASE2, CYCLE_TEST};
	private TEST_CASE currTestCase= null;
	
	/**
	 * Tests the '{@link de.util.graph.Graph#getRoots() <em>Get Roots</em>}' operation.
	 * 				node1
	 *			/		\		\
	 *		node2		node4	node7	
	 *		/		\	|
	 *	node3	node6	node5
	 */
	public void testGetTraverseCase1()
	{
		this.currTestCase= TEST_CASE.CASE1;
		Graph graph= null; 
		{//create graph
			graph= GraphFactory.eINSTANCE.createGraph();
			this.getFixture().setGraph(graph);
			this.insertNodes(graph, nodes);
			this.insertEdges(graph, edges);
		}
		{//create list to check
			this.depthFirstList1= new BasicEList<Node>();
			depthFirstList1.add(graph.getNode("node1"));
			depthFirstList1.add(graph.getNode("node2"));
			depthFirstList1.add(graph.getNode("node3"));
			depthFirstList1.add(graph.getNode("node6"));
			depthFirstList1.add(graph.getNode("node4"));
			depthFirstList1.add(graph.getNode("node5"));
			depthFirstList1.add(graph.getNode("node7"));
			
			this.depthFirstList1Reverse= new BasicEList<Node>();
			depthFirstList1Reverse.add(graph.getNode("node3"));
			depthFirstList1Reverse.add(graph.getNode("node6"));
			depthFirstList1Reverse.add(graph.getNode("node2"));
			depthFirstList1Reverse.add(graph.getNode("node5"));
			depthFirstList1Reverse.add(graph.getNode("node4"));
			depthFirstList1Reverse.add(graph.getNode("node7"));
			depthFirstList1Reverse.add(graph.getNode("node1"));
		}
		GraphTraverserObject gtObj= this.getFixture().getTraverserObject(GRAPH_TRAVERSE_MODE.DEPTH_FIRST, this);
		this.depthFirst1Id= gtObj.getId();
		gtObj.start(graph.getNode("node1"));
		try {
			gtObj.start(graph.getNode("node1"));
			fail("Shal not start two times");
		} catch (Exception e) {
		}
		gtObj.waitUntilFinished();
		assertEquals(7, this.depthFirstList1Idx);
		assertEquals(0, gtObj.getExceptions().size());
	}
	
	/**
	 * Tests the '{@link de.util.graph.Graph#getRoots() <em>Get Roots</em>}' operation.
	 * Runs two times 
	 * 				node1
	 *			/		\		\
	 *		node2		node4	node7	
	 *		/		\	|
	 *	node3	node6	node5
	 */
	public void testGetTraverseCase2()
	{
		this.currTestCase= TEST_CASE.CASE2;
		
		Graph graph= null; 
		{//create graph
			graph= GraphFactory.eINSTANCE.createGraph();
			this.getFixture().setGraph(graph);
			this.insertNodes(graph, nodes);
			this.insertEdges(graph, edges);
		}
		{//create list to check 1
			this.depthFirstList1= new BasicEList<Node>();
			depthFirstList1.add(graph.getNode("node1"));
			depthFirstList1.add(graph.getNode("node2"));
			depthFirstList1.add(graph.getNode("node3"));
			depthFirstList1.add(graph.getNode("node6"));
			depthFirstList1.add(graph.getNode("node4"));
			depthFirstList1.add(graph.getNode("node5"));
			depthFirstList1.add(graph.getNode("node7"));
			
			this.depthFirstList1Reverse= new BasicEList<Node>();
			depthFirstList1Reverse.add(graph.getNode("node3"));
			depthFirstList1Reverse.add(graph.getNode("node6"));
			depthFirstList1Reverse.add(graph.getNode("node2"));
			depthFirstList1Reverse.add(graph.getNode("node5"));
			depthFirstList1Reverse.add(graph.getNode("node4"));
			depthFirstList1Reverse.add(graph.getNode("node7"));
			depthFirstList1Reverse.add(graph.getNode("node1"));
		}
		
		{//create list to check 2
			this.depthFirstList2= new BasicEList<Node>();
			depthFirstList2.add(graph.getNode("node2"));
			depthFirstList2.add(graph.getNode("node3"));
			depthFirstList2.add(graph.getNode("node6"));
			
			this.depthFirstList2Reverse= new BasicEList<Node>();
			depthFirstList2Reverse.add(graph.getNode("node3"));
			depthFirstList2Reverse.add(graph.getNode("node6"));
			depthFirstList2Reverse.add(graph.getNode("node2"));
			
		}
		GraphTraverserObject gtObj1= null;
		GraphTraverserObject gtObj2= null;
		{//create gtObject 1
			gtObj1= this.getFixture().getTraverserObject(GRAPH_TRAVERSE_MODE.DEPTH_FIRST, this);
			this.depthFirst1Id= gtObj1.getId();
			
			
		}
		{//create gtObject 2
			gtObj2= this.getFixture().getTraverserObject(GRAPH_TRAVERSE_MODE.DEPTH_FIRST, this);
			this.depthFirst2Id= gtObj2.getId();
			
		}
		
		gtObj1.start(graph.getNode("node1"));
		gtObj2.start(graph.getNode("node2"));
		
		gtObj1.waitUntilFinished();
		gtObj2.waitUntilFinished();
		assertEquals(7, this.depthFirstList1Idx);
		assertEquals(7, this.depthFirstList1Idx);
		assertEquals(0, gtObj1.getExceptions().size());
	}
	
	@Override
	public boolean checkConstraint(GRAPH_TRAVERSE_MODE traversalMode,
			Long traversalId, Edge edge, Node currNode, long order) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void nodeLeft(GRAPH_TRAVERSE_MODE traversalMode, Long traversalId,
			Node currNode, Edge edge, Node fromNode, long order) 
	{
		if ((this.currTestCase== TEST_CASE.CASE1)	||
				(this.currTestCase== TEST_CASE.CASE2))
			{
			if (	(traversalMode ==GRAPH_TRAVERSE_MODE.DEPTH_FIRST) &&
					(traversalId== depthFirst1Id))
			{
				
				assertEquals(this.depthFirstList1Reverse.get(this.depthFirstList1IdxReverse), currNode);
				this.depthFirstList1IdxReverse++;
			}
			if (	(traversalMode ==GRAPH_TRAVERSE_MODE.DEPTH_FIRST) &&
					(traversalId== depthFirst2Id))
			{
				
				assertEquals(this.depthFirstList2Reverse.get(this.depthFirstList2IdxReverse), currNode);
				this.depthFirstList2IdxReverse++;
			}
		}
	}

	@Override
	public void nodeReached(GRAPH_TRAVERSE_MODE traversalMode,
			Long traversalId, Node currNode, Edge edge, Node fromNode,
			long order) 
	{
		if ((this.currTestCase== TEST_CASE.CASE1)	||
			(this.currTestCase== TEST_CASE.CASE2))
		{	
			if (	(traversalMode ==GRAPH_TRAVERSE_MODE.DEPTH_FIRST) &&
					(traversalId== depthFirst1Id))
			{
				assertEquals(this.depthFirstList1.get(this.depthFirstList1Idx), currNode);
				this.depthFirstList1Idx++;
			}
			
			if (	(traversalMode ==GRAPH_TRAVERSE_MODE.DEPTH_FIRST) &&
					(traversalId== depthFirst2Id))
			{
				assertEquals(this.depthFirstList2.get(this.depthFirstList2Idx), currNode);
				this.depthFirstList2Idx++;
			}
		}
		else if (this.currTestCase== TEST_CASE.CYCLE_TEST)
		{//checks if every edge is visited only one time
			if (edge!= null)
			{	
				if (!edgesList.contains(edge))
					fail("a visited edge does not contain in edge list, or is visited two times");
				edgesList.remove(edge);
			}
		}
	}
	
	/**
	 * Stores nodes from CycleTest.
	 */
	private EList<Edge> edgesList= null;
		
	/**
	 * creates a graph looking like a double linked chain and tests, if every edge is visited 
	 * only one time. 
	 */
	public void testCycleTraversion()
	{
		long time= 0l;
		long millis= System.currentTimeMillis();
		this.cycleTest(false);
		time= time+(System.currentTimeMillis() - millis);
	}
	
	public void cycleTest(boolean visitedByNodes) 
	{	
		this.currTestCase= TEST_CASE.CYCLE_TEST;
		int numOfNodes= 2000;
		Node startNode= null;
		Graph graph= GraphFactory.eINSTANCE.createGraph();
		Node node1= GraphFactory.eINSTANCE.createNode();
		node1.setId("node0");
		startNode= node1;
		graph.addNode(node1);
		//creating a new list
		edgesList= new BasicEList<Edge>();
		for (int i=1; i< numOfNodes; i++)
		{
			Node node2= GraphFactory.eINSTANCE.createNode();
			node2.setId("node"+i);
			graph.addNode(node2);
			
			Edge edge= GraphFactory.eINSTANCE.createEdge();
			edge.setSource(node1);
			edge.setTarget(node2);
			graph.addEdge(edge);
			//adding edge into list for checking if it was visited
			edgesList.add(edge);
			
			edge= GraphFactory.eINSTANCE.createEdge();
			edge.setSource(node2);
			edge.setTarget(node1);
			graph.addEdge(edge);
			//adding edge into list for checking if it was visited
			edgesList.add(edge);
			
			node1= node2;
		}
		this.getFixture().setGraph(graph);
		GraphTraverserObject travObj= this.getFixture().getTraverserObject(GRAPH_TRAVERSE_MODE.DEPTH_FIRST, this);
		travObj.visitedByNode= visitedByNodes;
		travObj.start(startNode);
		travObj.waitUntilFinished();
	}
}
