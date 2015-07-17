package de.hu_berlin.u.saltnpepper.graph.impl.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.graph.Relation;
import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.graph.Layer;
import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.graph.impl.RelationImpl;
import de.hu_berlin.u.saltnpepper.graph.impl.GraphFactory;
import de.hu_berlin.u.saltnpepper.graph.impl.GraphImpl;
import de.hu_berlin.u.saltnpepper.graph.impl.NodeImpl;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltInsertionException;

public class GraphTest_old {
//	protected Graph<Node, Edge<Node, Node>> fixture = null;
//
//	public Graph<Node, Edge<Node, Node>> getFixture() {
//		return fixture;
//	}
//
//	public void setFixture(Graph<Node, Edge<Node, Node>> fixture) {
//		this.fixture = fixture;
//	}
//
//	/**
//	 * Liste von Knoten
//	 */
//	private Collection<Node> nodes= null;
//	
//	@Before
//	protected void setUp() throws Exception {
//		setFixture(GraphFactory.createGraph());
//		this.getFixture().setId("graph1");
//		//Knotenliste erstellen
//		nodes= new ArrayList<Node>();
//		for (String nodeName: nodeNames)
//		{
//			Node node= GraphFactory.createNode();
//			node.setId(nodeName);
//			nodes.add((node));
//		}
//		
//		//Kantenliste erstellen
//		edges= new ArrayList<Edge>();
//		Edge<Node, Node> edge= null;
//		for (int i= 0; i < edgeNames.length; i++)
//		{
//			for (Node srcNode: nodes)
//			{
//				if (((String)srcNode.getId()).equalsIgnoreCase(edgeNames[i][0]))
//				{
//					for (Node dstNode: nodes)
//					{
//						if (((String)dstNode.getId()).equalsIgnoreCase(edgeNames[i][1]))
//						{
//							edge= GraphFactory.createEdge();
//							edge.setId(edgeNames[i][2]);
//							edge.setSource(srcNode);
//							edge.setTarget(dstNode);
//							edges.add(edge);
//							break;
//						}
//					}
//					break;
//				}
//			}
//		}	
//	}
//
//	@After
//	protected void tearDown() throws Exception {
//		setFixture(null);
//	}
//	
//	/**
//	 * Knotennamen f�r zu erstellende Knoten als String
//	 */
//	private String[] nodeNames= {"node1", "node2", "node3", "node4", "node5", "node6", "node7"};
//	
//	/**
//	 * Knotennamen f�r zu erstellende Knoten als String
//	 */
//	private String[][] edgeNames= {	{"node1", "node2", "edge1"}, {"node2", "node3","edge2"}, 
//									{"node1", "node4", "edge3"},{"node4", "node5", "edge4"},
//									{"node2", "node6", "edge5"}, {"node1", "node7", "edge6"}};
//	
//	/**
//	 * Liste von Knoten
//	 */
//	private List<Edge> edges= null;
//	
//	/**
//	 * F�gt die �bergebenen Knoten in den Graphen ein
//	 * @param nodes in den Graphen einzuf�genden Knoten
//	 * @throws Exception
//	 */
//	private void insertNodes(Collection<Node> nodes)
//	{
//		for (Node node: nodes)
//		{
//			this.getFixture().addNode(node);
//		}
//	}
//	
//	/**
//	 * F�gt die �bergebenen Kanten in den Graphen ein
//	 * @param modeNames zweidimensionaler String, in dem die Namen der Quell- und Zielknoten stehen (Quelle, Ziel)
//	 * @throws Exception
//	 */
//	private void insertEdges(Collection<Edge> edges)
//	{
//		for (Edge edge: edges)
//		{
//			this.getFixture().addEdge(edge);
//		}
//	}
//	

//
//	/**
//	 * TODO still necessary???
//	 */
//	public void testRemoveNodeById__String() 
//	{
//		for (Node node: this.nodes )
//		{
//			this.getFixture().addNode(node);
//			assertEquals(node, this.getFixture().getNode(node.getId()));
//		}
//		for (String nodeName: nodeNames)
//		{
//			assertNotNull(this.getFixture().getNode(nodeName));
//			this.getFixture().removeNodeById(nodeName);
//			assertNull("node '"+nodeName+"' should be removed", this.getFixture().getNode(nodeName));
//		}
//	}
//	
//
//	




//
//		/**
//	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#removeEdgeById(java.lang.String) <em>Remove Edge By Id</em>}' operation.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#removeEdgeById(java.lang.String)
//	 */
//	public void testRemoveEdgeById__String() 
//	{
//		//Knoten in den Graphen einf�gen
//		this.insertNodes(nodes);
//		//Kanten in den Graphen einf�gen
//		this.insertEdges(edges);
//		//Pr�fen ob Kanten eingef�gt wurden
//		for (Edge edge: edges)
//		{
//			assertSame("this edge '"+edge.getId()+"' should be there", edge, this.getFixture().getEdge(edge.getId()));
//		}
//		//Kante l�schen
//		for (Edge edge: edges)
//		{
//			if (this.getFixture().getEdge(edge.getId())!= null)
//			{
//				assertSame("this edge '"+edge.getId()+"' should be there", edge, this.getFixture().getEdge(edge.getId()));	
//				assertTrue(this.getFixture().removeEdgeById(edge.getId()));
//				assertNull("this edge '"+edge.getId()+"' shouldn�t be there", this.getFixture().getEdge(edge.getId()));
//			}
//		}
//		//Kante entfernen, deren Knoten es nicht gibt
//		Edge edge= GraphFactory.createEdge();
//		edge.setId("not there");
//		assertFalse(this.getFixture().removeEdgeById(edge.getId()));
//	}
//
//	/**
//	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#removeEdges() <em>Remove Edges</em>}' operation.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#removeEdges()
//	 */
//	public void testRemoveEdges() 
//	{
//		//add node to graph
//		this.insertNodes(nodes);
//		//add node to graph
//		this.insertEdges(edges);
//		//check if edge was inserted
//		for (Edge edge: edges)
//		{
//			assertSame("this edge '"+edge.getId()+"' should be there", edge, this.getFixture().getEdge(edge.getId()));
//		}
//		//remove edge
//		assertTrue(this.getFixture().removeEdges());
//		
//		for (Edge edge: edges)
//		{	
//			assertNull("this edge '"+edge.getId()+"' shouldn't be there", this.getFixture().getEdge(edge.getId()));
//		}
//		//remove edge, whichs node does not exist
//		Edge edge= GraphFactory.createEdge();
//		edge.setId("not there");
//		assertFalse(this.getFixture().removeEdgeById(edge.getId()));
//	}
//
//	/**
//	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#removeEdge(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge) <em>Remove Edge</em>}' operation.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#removeEdge(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge)
//	 */
//	public void testRemoveEdge__Edge() 
//	{
//		//Knoten in den Graphen einf�gen
//		this.insertNodes(nodes);
//		//Kanten in den Graphen einf�gen
//		this.insertEdges(edges);
//		//Pr�fen ob Kanten eingef�gt wurden
//		for (Edge edge: edges)
//		{
//			assertSame("this edge '"+edge.getId()+"' should be there", edge, this.getFixture().getEdge(edge.getId()));
//		}
//		//Kante l�schen
//		for (Edge edge: edges)
//		{
//			if (this.getFixture().getEdge(edge.getId())!= null)
//			{
//				assertSame("this edge '"+edge.getId()+"' should be there", edge, this.getFixture().getEdge(edge.getId()));	
//				assertTrue(this.getFixture().removeEdge(edge));
//				assertNull("this edge '"+edge.getId()+"' shouldn�t be there", this.getFixture().getEdge(edge.getId()));
//			}
//		}
//		//Kante entfernen, deren Knoten es nicht gibt
//		Edge edge= GraphFactory.createEdge();
//		edge.setId("not there");
//		assertFalse(this.getFixture().removeEdge(edge));
//	}
//	
//	/**
//	 * Creates an edge, puts it into graph and a layer and removes it from the graph. Tests if edge is even removed in layer. 
//	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#removeEdge(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge)
//	 */
//	public void testRemoveEdge__Edge2() 
//	{
//		Node node1= GraphFactory.createNode();
//		Node node2= GraphFactory.createNode();
//		this.getFixture().addNode(node1);
//		this.getFixture().addNode(node2);
//		
//		Layer layer1= GraphFactory.createLayer();
//		this.getFixture().getLayers().add(layer1);
//		Collection<Edge> edges= new ArrayList<Edge>();
//		for (int i=0; i< 5; i++)
//		{
//			Edge edge= GraphFactory.createEdge();
//			edge.setSource(node1);
//			edge.setSource(node2);
//			this.getFixture().addEdge(edge);
//			layer1.getEdges().add(edge);
//			edges.add(edge);
//		}
//		assertEquals(new Long(5), this.getFixture().getNumOfEdges());
//		assertEquals(new Long(1), this.getFixture().getNumOfLayers());
//		assertEquals(5, layer1.getEdges().size());
//		
//		for (Edge edge: edges)
//		{
//			this.getFixture().removeEdge(edge);
//		}
//		assertEquals(new Long(0), this.getFixture().getNumOfEdges());
//		assertEquals(new Long(1), this.getFixture().getNumOfLayers());
//		assertEquals(0, layer1.getEdges().size());
//	}
//	
//	public void testIncompleteEdge()
//	{
//		Edge edge= GraphFactory.createEdge();
//		edge.setId("edge1");
//		this.getFixture().addEdge(edge);
//		
//		Node node1= GraphFactory.createNode();
//		node1.setId("node1");
//		this.getFixture().addNode(node1);
//		
//		Node node2= GraphFactory.createNode();
//		node2.setId("node2");
//		this.getFixture().addNode(node2);
//		
//		edge.setSource(node1);
//		edge.setTarget(node2);
//		
//		assertTrue(this.getFixture().getOutEdges(node1.getId()).contains(edge));
//		assertTrue(this.getFixture().getInEdges(node2.getId()).contains(edge));
//	}
//	
//	/**
//	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#changeEdgeSource(java.lang.String, java.lang.String) <em>Change Edge Source</em>}' operation.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#changeEdgeSource(java.lang.String, java.lang.String)
//	 */
//	public void testChangeEdgeSource__String_String() 
//	{
//		Edge edge= GraphFactory.createEdge();
//		edge.setId("edge1");
//		this.getFixture().addEdge(edge);
//		
//		Node node1= GraphFactory.createNode();
//		node1.setId("node1");
//		this.getFixture().addNode(node1);
//		
//		Node node2= GraphFactory.createNode();
//		node2.setId("node2");
//		this.getFixture().addNode(node2);
//		
//		edge.setSource(node1);
//		edge.setTarget(node2);
//		
//		assertTrue(this.getFixture().getOutEdges(node1.getId()).contains(edge));
//		assertTrue(this.getFixture().getInEdges(node2.getId()).contains(edge));
//		
//		Node node3= GraphFactory.createNode();
//		node3.setId("node3");
//		this.getFixture().addNode(node3);
//		
//		//redirect source
//		edge.setSource(node3);
//		assertTrue(this.getFixture().getOutEdges(node3.getId()).contains(edge));
//		assertTrue(this.getFixture().getOutEdges(node1.getId()).isEmpty());
//	}
//
//	/**
//	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#changeEdgeTarget(java.lang.String, java.lang.String) <em>Change Edge Target</em>}' operation.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#changeEdgeTarget(java.lang.String, java.lang.String)
//	 */
//	public void testChangeEdgeTarget__String_String() 
//	{
//		Edge edge= GraphFactory.createEdge();
//		edge.setId("edge1");
//		this.getFixture().addEdge(edge);
//		
//		Node node1= GraphFactory.createNode();
//		node1.setId("node1");
//		this.getFixture().addNode(node1);
//		
//		Node node2= GraphFactory.createNode();
//		node2.setId("node2");
//		this.getFixture().addNode(node2);
//		
//		edge.setSource(node1);
//		edge.setTarget(node2);
//		
//		assertTrue(this.getFixture().getOutEdges(node1.getId()).contains(edge));
//		assertTrue(this.getFixture().getInEdges(node2.getId()).contains(edge));
//		
//		Node node3= GraphFactory.createNode();
//		node3.setId("node3");
//		this.getFixture().addNode(node3);
//		//redirect source
//		edge.setTarget(node3);
//		assertTrue(this.getFixture().getInEdges(node3.getId()).contains(edge));
//		assertTrue(this.getFixture().getInEdges(node2.getId()).isEmpty());
//	}
//
//	/**
//	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#addNode(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node, de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer) <em>Add Node</em>}' operation.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#addNode(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node, de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer)
//	 */
//	public void testAddNode__Node_Layer() 
//	{
//		List<Node> nodesOflayer1= null;
//		Layer layer1= null;
//		List<Node> nodesOflayer2= null;
//		Layer layer2= null;
//		
//		layer1= GraphFactory.createLayer();
//		layer2= GraphFactory.createLayer();
//		
//		{//adding null node to layer
//			this.getFixture().addNode(null, layer1);
//		}//adding null node to layer
//		
//		nodesOflayer1= new BasicList<Node>();
//		for (int i= 1; i< 5; i++)
//			nodesOflayer1.add(GraphFactory.createNode());
//		
//		{//adding nodes to non existing layer
//			layer1= GraphFactory.createLayer();
//			
//			Node node= GraphFactory.createNode();
//			this.getFixture().addNode(node, layer1);
//			assertTrue(layer1.getNodes().contains(node));
//			assertEquals(node, this.getFixture().getNode(node.getId()));
//		}//adding nodes to non existing layer
//		
//		this.getFixture().addLayer(layer1);
//		for (Node node: nodesOflayer1)
//			this.getFixture().addNode(node, layer1);
//		
//		nodesOflayer2= new BasicList<Node>();
//		for (int i= 1; i< 5; i++)
//			nodesOflayer2.add(GraphFactory.createNode());
//		this.getFixture().addLayer(layer2);
//		for (Node node: nodesOflayer2)
//			this.getFixture().addNode(node, layer2);
//		
//		{//checking if layer 1 and 2 contains all nodes
//			assertTrue(layer1.getNodes().containsAll(nodesOflayer1));
//			for (Node node: nodesOflayer1)
//				assertTrue(node.getLayers().contains(layer1));
//			for (Node node: nodesOflayer2)
//				assertTrue(node.getLayers().contains(layer2));
//			assertTrue(layer2.getNodes().containsAll(nodesOflayer2));
//		}//checking if layer 1 and 2 contains all nodes
//	}
//
//	/**
//	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#addEdge(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge, de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer) <em>Add Edge</em>}' operation.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#addEdge(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge, de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer)
//	 */
//	public void testAddEdge__Edge_Layer() 
//	{
//		List<Edge> edgesOflayer1= null;
//		Layer layer1= null;
//		List<Edge> edgesOflayer2= null;
//		Layer layer2= null;
//		
//		layer1= GraphFactory.createLayer();
//		layer2= GraphFactory.createLayer();
//		
//		{//adding null edge to layer
//			this.getFixture().addEdge(null, layer1);
//		}//adding null edge to layer
//		
//		edgesOflayer1= new BasicList<Edge>();
//		for (int i= 1; i< 5; i++)
//			edgesOflayer1.add(GraphFactory.createEdge());
//		
//		{//adding edges to non existing layer
//			layer1= GraphFactory.createLayer();
//			
//			Edge edge= GraphFactory.createEdge();
//			this.getFixture().addEdge(edge, layer1);
//			assertTrue(layer1.getEdges().contains(edge));
//			assertEquals(edge, this.getFixture().getEdge(edge.getId()));
//		}//adding edges to non existing layer
//		
//		this.getFixture().addLayer(layer1);
//		for (Edge edge: edgesOflayer1)
//			this.getFixture().addEdge(edge, layer1);
//		
//		edgesOflayer2= new BasicList<Edge>();
//		for (int i= 1; i< 5; i++)
//			edgesOflayer2.add(GraphFactory.createEdge());
//		this.getFixture().addLayer(layer2);
//		for (Edge edge: edgesOflayer2)
//			this.getFixture().addEdge(edge, layer2);
//		
//		{//checking if layer 1 and 2 contains all edges
//			assertTrue(layer1.getEdges().containsAll(edgesOflayer1));
//			for (Edge edge: edgesOflayer1)
//				assertTrue(edge.getLayers().contains(layer1));
//			for (Edge edge: edgesOflayer2)
//				assertTrue(edge.getLayers().contains(layer2));
//			assertTrue(layer2.getEdges().containsAll(edgesOflayer2));
//		}//checking if layer 1 and 2 contains all edges
//	}
//
//	/**
//	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#addLayer(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer) <em>Add Layer</em>}' operation.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#addLayer(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer)
//	 */
//	public void testAddLayer__Layer() 
//	{
//		Layer layer= null;
//		{//adding null layer
//			try {
//				this.getFixture().addLayer(layer);
//				fail("shall not add a null layer");
//			} catch (GraphException e) {	}
//		}//adding null layer
//		
//		{//adding layer
//			layer= GraphFactory.createLayer();
//			this.getFixture().addLayer(layer);
//			assertTrue(this.getFixture().getLayers().contains(layer));
//		}//adding layer
//		
//		{//adding layer second time shall fail
//			try {
//				this.getFixture().addLayer(layer);
//				assertTrue(this.getFixture().getLayers().contains(layer));
//				fail("shall not add a layer two times");
//			} catch (GraphException e) {	}
//			
//		}//adding layer second time shall fail
//		
//	}
//	
//	/**
//	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getLayer(java.lang.String) <em>Get Layer</em>}' operation.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getLayer(java.lang.String)
//	 */
//	public void testGetLayer__String() 
//	{
//		Layer layer= null;
//		String id= "id";
//		
//		layer= GraphFactory.createLayer();
//		layer.setId(id);
//		this.getFixture().addLayer(layer);
//		assertEquals(layer, this.getFixture().getLayer(id));
//	}
//
//// ============================================== start: create dummy graphs
//	/**
//	 * Fills the given graph, containing nodes having the names as given in nodeNames list and connects them with edges as
//	 * given in the edgeNames list.
//	 * The edge names list contains of entries as follows:
//	 * [[SOURCE_NODE_NAME, TARGET_NODE_NAME, EDGE_NAME],...]
//	 * @param nodeNames
//	 * @param edgeNames
//	 */
//	public static void createGraph(	Graph graph,
//								String[] nodeNames,
//								String[][] edgeNames)
//	{
//		List<Node> nodes= new ArrayList<Node>();
//		for (String nodeName: nodeNames)
//		{
//			Node node= GraphFactory.createNode();
//			node.setId(nodeName);
//			nodes.add((node));
//			graph.addNode(node);
//		}
//		
//		//Kantenliste erstellen
//		List<Edge> edges= new ArrayList<Edge>();
//		Edge edge= null;
//		for (int i= 0; i < edgeNames.length; i++)
//		{
//			for (Node srcNode: nodes)
//			{
//				if (((String)srcNode.getId()).equalsIgnoreCase(edgeNames[i][0]))
//				{
//					for (Node dstNode: nodes)
//					{
//						if (((String)dstNode.getId()).equalsIgnoreCase(edgeNames[i][1]))
//						{
//							edge= GraphFactory.createEdge();
//							edge.setId(edgeNames[i][2]);
//							edge.setSource(srcNode);
//							edge.setTarget(dstNode);
//							edges.add(edge);
//							graph.addEdge(edge);
//							break;
//						}
//					}
//					break;
//				}
//			}
//		}	
//	}
//	
//	/**
//     * Creates the following graph: <br/>
//     * <pre>
//     *                 node1             
//     *            /        \        \  
//     *           V          V        V
//     *        node2        node4    node7
//     *        /    \        |         
//     *       V      V       V
//     *    node3    node6   node5   
//     * </pre>     
//	 **/
//	public static Graph createGraph_Tree()
//	{
//		Graph graph= GraphFactory.createGraph();
//		graph.setId("createGraph_Tree");
//		String[] nodeNames= {"node1", "node2", "node3", "node4", "node5", "node6", "node7"};
//		String[][] edgeNames= {	{"node1", "node2", "edge1"}, {"node2", "node3","edge2"}, 
//								{"node1", "node4", "edge3"},{"node4", "node5", "edge4"},
//								{"node2", "node6", "edge5"}, {"node1", "node7", "edge6"}};
//	
//		createGraph(graph, nodeNames, edgeNames);
//		return(graph);
//	}
//	
//	/**
//     * Creates the following graph: <br/>
//     * <pre>
//     *     node1    node4
//     *        \    /
//     *         V  V  
//     *        node2      
//     *        /    \
//     *       V      V
//     *    node3    node6 
//     * </pre>
//     **/
//	public static Graph createGraph_DAG()
//	{
//		Graph graph= GraphFactory.createGraph();
//		graph.setId("createGraph_DAG");
//		
//		String[] nodeNames= {"node1", "node2", "node3", "node4","node6",};
//		String[][] edgeNames= {	{"node1", "node2", "edge1"}, {"node2", "node3","edge2"}, 
//								{"node2", "node6", "edge3"}, {"node4", "node2", "edge4"}};
//	
//		createGraph(graph, nodeNames, edgeNames);
//		return(graph);
//	}
//	
//	/**
//	 * Creates the following graph including a cycle: <br/>
//     * <pre>
//     *     node1    node4
//     *        \    /   
//     *         V  V    
//     *        node2          
//     *        /    \
//     *        V     V     
//     *    node3    node6
//     *                \ 
//     *                 V     
//     *              node 7
//     * node 7 -> node2       
//     * </pre>
//	 **/
//	public static Graph createGraph_Cycle()
//	{
//		Graph graph= GraphFactory.createGraph();
//		graph.setId("createGraph_Cycle");
//		String[] nodeNames= {"node1", "node2", "node3", "node4","node6", "node7"};
//		String[][] edgeNames= {	{"node1", "node2", "edge1"}, {"node2", "node3","edge2"}, 
//								{"node2", "node6", "edge3"}, {"node4", "node2", "edge4"},
//								{"node6", "node7", "edge5"}, {"node7", "node2", "edge6"}};
//	
//		createGraph(graph, nodeNames, edgeNames);
//		return(graph);
//	}	
//	
//	/**
//	 * Creates the following graph including a cycle: <br/>
//     * <pre>
//     *     node1                
//     *        \ 
//     *         V               
//     *        node2            
//     *        /    \
//     *       V      V      
//     *    node3    node6         
//     *                \ 
//     *                 V       
//     *                 node 7    
//     * node 7 -> node2        
//     * </pre>
//	 **/
//	public static Graph createGraph_SimpleCycle()
//	{
//		Graph graph= GraphFactory.createGraph();
//		graph.setId("createGraph_SimpleCycle");
//		String[] nodeNames= {"node1", "node2", "node3", "node6", "node7"};
//		String[][] edgeNames= {	{"node1", "node2", "edge1"}, {"node2", "node3","edge2"}, 
//								{"node2", "node6", "edge3"}, {"node6", "node7", "edge5"}, 
//								{"node7", "node2", "edge6"}};
//	
//		createGraph(graph, nodeNames, edgeNames);
//		return(graph);
//	}
//	
//	/**
//	 * Creates the following graph including a cycle: <br/>
//     * <pre>
//     *       node1
//     *        ^ \
//     *       /   V
//     *  node3 <- node2  
//     *      
//     * </pre>
//	 **/
//	public static Graph createGraph_PureCycle()
//	{
//		Graph graph= GraphFactory.createGraph();
//		graph.setId("createGraph_PureCycle");
//		String[] nodeNames= {"node1", "node2", "node3"};
//		String[][] edgeNames= {	{"node1", "node2", "edge1"}, {"node2", "node3","edge2"}, 
//								{"node3", "node1", "edge3"}};
//	
//		createGraph(graph, nodeNames, edgeNames);
//		return(graph);
//	}	
//// ============================================== end: create dummy graphs	
//	
//	/**
// 	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getRoots() <em>Get Roots</em>}' operation.
//	 * Tests the method {@link GraphTraverserModule#getRoots()} and checks if the correct roots are returned, using the several graph types.
//	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getRoots()
//	 */
//	public void testGetRoots()
//	{
//		List<Node> expectedRoots= null;
//		List<Node> roots= null;
//		Graph graph= null;
//		
//		{//test 1
//			graph= createGraph_Tree();
//			this.setFixture(graph);
//			expectedRoots= new ArrayList<Node>();
//			expectedRoots.add(graph.getNode("node1"));
//			roots= this.getFixture().getRoots();
//			assertEquals("The expected number of roots are not the same, as the returned number", expectedRoots.size(), roots.size());
//			for (Node expectedRoot: expectedRoots)
//			{
//				assertTrue("The list of returned roots does not contain expected root '"+expectedRoot.getId()+"'.", roots.contains(expectedRoot));
//			}
//		}//test 1
//		
//		{//test 2
//			graph= createGraph_DAG();
//			this.setFixture(graph);
//			expectedRoots= new ArrayList<Node>();
//			expectedRoots.add(graph.getNode("node1"));
//			expectedRoots.add(graph.getNode("node4"));
//			roots= this.getFixture().getRoots();
//			assertEquals("The expected number of roots are not the same, as the returned number", expectedRoots.size(), roots.size());
//			for (Node expectedRoot: expectedRoots)
//			{
//				assertTrue("The list of returned roots does not contain expected root '"+expectedRoot.getId()+"'.", roots.contains(expectedRoot));
//			}
//		}//test 2
//		
//		{//test 3
//			graph= createGraph_Cycle();
//			this.setFixture(graph);
//			expectedRoots= new ArrayList<Node>();
//			expectedRoots.add(graph.getNode("node1"));
//			expectedRoots.add(graph.getNode("node4"));
//			roots= this.getFixture().getRoots();
//			assertEquals("The expected number of roots are not the same, as the returned number", expectedRoots.size(), roots.size());
//			for (Node expectedRoot: expectedRoots)
//			{
//				assertTrue("The list of returned roots does not contain expected root '"+expectedRoot.getId()+"'.", roots.contains(expectedRoot));
//			}
//		}//test 3
//	}
//
//	/**
//	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getLeafs() <em>Get Leafs</em>}' operation.
//	 * Tests the method {@link GraphTraverserModule#getLeafs()} and checks if the correct leafs are returned, using the several graph types.
//	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getLeafs()
//	 */
//	public void testGetLeafs()
//	{
//		List<Node> expectedLeafs= null;
//		List<Node> leafs= null;
//		Graph graph= null;
//		
//		{//test 1
//			graph= createGraph_Tree();
//			this.setFixture(graph);
//			expectedLeafs= new ArrayList<Node>();
//			expectedLeafs.add(graph.getNode("node3"));
//			expectedLeafs.add(graph.getNode("node6"));
//			expectedLeafs.add(graph.getNode("node5"));
//			expectedLeafs.add(graph.getNode("node7"));
//			leafs= this.getFixture().getLeafs();
//			assertEquals("The expected number of leafs are not the same, as the returned number", expectedLeafs.size(), leafs.size());
//			for (Node expectedLeaf: expectedLeafs)
//			{
//				assertTrue("The list of returned roots does not contain expected leaf '"+expectedLeaf.getId()+"'.", leafs.contains(expectedLeaf));
//			}
//		}//test 1
//		
//		{//test 2
//			graph= createGraph_DAG();
//			this.setFixture(graph);
//			expectedLeafs= new ArrayList<Node>();
//			expectedLeafs.add(graph.getNode("node3"));
//			expectedLeafs.add(graph.getNode("node6"));
//			leafs= this.getFixture().getLeafs();
//			assertEquals("The expected number of leafs are not the same, as the returned number", expectedLeafs.size(), leafs.size());
//			for (Node expectedLeaf: expectedLeafs)
//			{
//				assertTrue("The list of returned leafs does not contain expected leaf '"+expectedLeaf.getId()+"'.", leafs.contains(expectedLeaf));
//			}
//		}//test 2
//		
//		{//test 3
//			graph= createGraph_Cycle();
//			this.setFixture(graph);
//			expectedLeafs= new ArrayList<Node>();
//			expectedLeafs.add(graph.getNode("node3"));
//			leafs= this.getFixture().getLeafs();
//			assertEquals("The expected number of leafs are not the same, as the returned number", expectedLeafs.size(), leafs.size());
//			for (Node expectedLeaf: expectedLeafs)
//			{
//				assertTrue("The list of returned roots does not contain expected leaf '"+expectedLeaf.getId()+"'.", leafs.contains(expectedLeaf));
//			}
//		}//test 3
//	}
//	
//
//	public void testRemoveEdge__EdgeByList() 
//	{
//		//Knoten in den Graphen einf�gen
//		this.insertNodes(nodes);
//		//Kanten in den Graphen einf�gen
//		this.insertEdges(edges);
//		//Pr�fen ob Kanten eingef�gt wurden
//		for (Edge edge: edges)
//		{
//			assertSame("this edge '"+edge.getId()+"' should be there", edge, this.getFixture().getEdge(edge.getId()));
//		}
//		//Kante l�schen
//		for (Edge edge: edges)
//		{
//			if (this.getFixture().getEdge(edge.getId())!= null)
//			{
//				assertSame("this edge '"+edge.getId()+"' should be there", edge, this.getFixture().getEdge(edge.getId()));	
//				assertTrue(this.getFixture().getEdges().remove(edge));
//				assertNull("this edge '"+edge.getId()+"' shouldn�t be there", this.getFixture().getEdge(edge.getId()));
//			}
//		}
//		//Kante entfernen, deren Knoten es nicht gibt
//		Edge edge= GraphFactory.createEdge();
//		edge.setId("not there");
//		assertFalse(this.getFixture().getEdges().remove(edge));
//	}
//	
//	/**
//	 * Testet das Entfernen aller Kanten des Graphen.
//	 * @throws Exception
//	 */
//	public void testRemoveAllEdge() throws Exception
//	{
//		//add node to graph
//		this.insertNodes(nodes);
//		//add edges to graph
//		this.insertEdges(edges);
//		//check if edges have been added
//		for (Edge edge: edges)
//		{
//			assertSame("this edge '"+edge.getId()+"' should be there", edge, this.getFixture().getEdge(edge.getId()));
//		}
//		//remove old edge
//		this.getFixture().removeEdges();
//		//add new edge
//		for (Edge edge: edges )
//		{
//			//add edge
//			this.getFixture().addEdge(edge);
//			//check if edge exists
//			assertEquals("created edge has to be there", this.getFixture().getEdge(edge.getId()), edge);
//		}
//	}
//	
//
//	/**
//	 * Tests the '{@link de.util.graph.IndexMgr#getNumOfIndexes() <em>Num Of Indexes</em>}' feature getter.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @see de.util.graph.IndexMgr#getNumOfIndexes()
//	 */
//	public void testGetNumOfIndexes() 
//	{
//		long i= this.getFixture().getIndexMgr().getNumOfIndexes();
//		String[] indexNames= {"index1", "index2", "index3", "index4", "index5"};
//		for (String indexName: indexNames)
//		{
//			Index simpleIndex= IndexFactory.eINSTANCE.createSimpleIndex();
//			simpleIndex.setId(indexName);
//			this.getFixture().getIndexMgr().addIndex(simpleIndex);
//		}
//		assertEquals(indexNames.length, this.getFixture().getIndexMgr().getNumOfIndexes()-i);
//	}
//	public void testReverseGetLabel()
//	{
//		Label<String> label= GraphFactory.createLabel();
//		label.setName("labelName");
//		this.getFixture().addLabel(label);
//		
//		assertEquals(this.getFixture(), label.getLabelableElement());
//	}
}
