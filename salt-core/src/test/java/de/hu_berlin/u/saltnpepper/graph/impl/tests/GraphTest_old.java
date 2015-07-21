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
//	protected Graph<Node, Relation<Node, Node>> fixture = null;
//
//	public Graph<Node, Relation<Node, Node>> getFixture() {
//		return fixture;
//	}
//
//	public void setFixture(Graph<Node, Relation<Node, Node>> fixture) {
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
//		getFixture().setId("graph1");
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
//		relations= new ArrayList<Relation>();
//		Relation<Node, Node> relation= null;
//		for (int i= 0; i < relationNames.length; i++)
//		{
//			for (Node srcNode: nodes)
//			{
//				if (((String)srcNode.getId()).equalsIgnoreCase(relationNames[i][0]))
//				{
//					for (Node dstNode: nodes)
//					{
//						if (((String)dstNode.getId()).equalsIgnoreCase(relationNames[i][1]))
//						{
//							relation= GraphFactory.createRelation();
//							relation.setId(relationNames[i][2]);
//							relation.setSource(srcNode);
//							relation.setTarget(dstNode);
//							relations.add(relation);
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
//	private String[][] relationNames= {	{"node1", "node2", "relation1"}, {"node2", "node3","relation2"}, 
//									{"node1", "node4", "relation3"},{"node4", "node5", "relation4"},
//									{"node2", "node6", "relation5"}, {"node1", "node7", "relation6"}};
//	
//	/**
//	 * Liste von Knoten
//	 */
//	private List<Relation> relations= null;
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
//			getFixture().addNode(node);
//		}
//	}
//	
//	/**
//	 * F�gt die �bergebenen Kanten in den Graphen ein
//	 * @param modeNames zweidimensionaler String, in dem die Namen der Quell- und Zielknoten stehen (Quelle, Ziel)
//	 * @throws Exception
//	 */
//	private void insertRelations(Collection<Relation> relations)
//	{
//		for (Relation relation: relations)
//		{
//			getFixture().addRelation(relation);
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
//			getFixture().addNode(node);
//			assertEquals(node, getFixture().getNode(node.getId()));
//		}
//		for (String nodeName: nodeNames)
//		{
//			assertNotNull(getFixture().getNode(nodeName));
//			getFixture().removeNodeById(nodeName);
//			assertNull("node '"+nodeName+"' should be removed", getFixture().getNode(nodeName));
//		}
//	}
//	
//
//	





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
//			getFixture().addNode(null, layer1);
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
//			getFixture().addNode(node, layer1);
//			assertTrue(layer1.getNodes().contains(node));
//			assertEquals(node, getFixture().getNode(node.getId()));
//		}//adding nodes to non existing layer
//		
//		getFixture().addLayer(layer1);
//		for (Node node: nodesOflayer1)
//			getFixture().addNode(node, layer1);
//		
//		nodesOflayer2= new BasicList<Node>();
//		for (int i= 1; i< 5; i++)
//			nodesOflayer2.add(GraphFactory.createNode());
//		getFixture().addLayer(layer2);
//		for (Node node: nodesOflayer2)
//			getFixture().addNode(node, layer2);
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
//	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#addRelation(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Relation, de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer) <em>Add Relation</em>}' operation.
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#addRelation(de.hu_berlin.german.korpling.saltnpepper.salt.graph.Relation, de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer)
//	 */
//	public void testAddRelation__Relation_Layer() 
//	{
//		List<Relation> relationsOflayer1= null;
//		Layer layer1= null;
//		List<Relation> relationsOflayer2= null;
//		Layer layer2= null;
//		
//		layer1= GraphFactory.createLayer();
//		layer2= GraphFactory.createLayer();
//		
//		{//adding null relation to layer
//			getFixture().addRelation(null, layer1);
//		}//adding null relation to layer
//		
//		relationsOflayer1= new BasicList<Relation>();
//		for (int i= 1; i< 5; i++)
//			relationsOflayer1.add(GraphFactory.createRelation());
//		
//		{//adding relations to non existing layer
//			layer1= GraphFactory.createLayer();
//			
//			Relation relation= GraphFactory.createRelation();
//			getFixture().addRelation(relation, layer1);
//			assertTrue(layer1.getRelations().contains(relation));
//			assertEquals(relation, getFixture().getRelation(relation.getId()));
//		}//adding relations to non existing layer
//		
//		getFixture().addLayer(layer1);
//		for (Relation relation: relationsOflayer1)
//			getFixture().addRelation(relation, layer1);
//		
//		relationsOflayer2= new BasicList<Relation>();
//		for (int i= 1; i< 5; i++)
//			relationsOflayer2.add(GraphFactory.createRelation());
//		getFixture().addLayer(layer2);
//		for (Relation relation: relationsOflayer2)
//			getFixture().addRelation(relation, layer2);
//		
//		{//checking if layer 1 and 2 contains all relations
//			assertTrue(layer1.getRelations().containsAll(relationsOflayer1));
//			for (Relation relation: relationsOflayer1)
//				assertTrue(relation.getLayers().contains(layer1));
//			for (Relation relation: relationsOflayer2)
//				assertTrue(relation.getLayers().contains(layer2));
//			assertTrue(layer2.getRelations().containsAll(relationsOflayer2));
//		}//checking if layer 1 and 2 contains all relations
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
//				getFixture().addLayer(layer);
//				fail("shall not add a null layer");
//			} catch (GraphException e) {	}
//		}//adding null layer
//		
//		{//adding layer
//			layer= GraphFactory.createLayer();
//			getFixture().addLayer(layer);
//			assertTrue(getFixture().getLayers().contains(layer));
//		}//adding layer
//		
//		{//adding layer second time shall fail
//			try {
//				getFixture().addLayer(layer);
//				assertTrue(getFixture().getLayers().contains(layer));
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
//		getFixture().addLayer(layer);
//		assertEquals(layer, getFixture().getLayer(id));
//	}
//
//// ============================================== start: create dummy graphs
//	/**
//	 * Fills the given graph, containing nodes having the names as given in nodeNames list and connects them with relations as
//	 * given in the relationNames list.
//	 * The relation names list contains of entries as follows:
//	 * [[SOURCE_NODE_NAME, TARGET_NODE_NAME, EDGE_NAME],...]
//	 * @param nodeNames
//	 * @param relationNames
//	 */
//	public static void createGraph(	Graph graph,
//								String[] nodeNames,
//								String[][] relationNames)
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
//		List<Relation> relations= new ArrayList<Relation>();
//		Relation relation= null;
//		for (int i= 0; i < relationNames.length; i++)
//		{
//			for (Node srcNode: nodes)
//			{
//				if (((String)srcNode.getId()).equalsIgnoreCase(relationNames[i][0]))
//				{
//					for (Node dstNode: nodes)
//					{
//						if (((String)dstNode.getId()).equalsIgnoreCase(relationNames[i][1]))
//						{
//							relation= GraphFactory.createRelation();
//							relation.setId(relationNames[i][2]);
//							relation.setSource(srcNode);
//							relation.setTarget(dstNode);
//							relations.add(relation);
//							graph.addRelation(relation);
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
//		String[][] relationNames= {	{"node1", "node2", "relation1"}, {"node2", "node3","relation2"}, 
//								{"node1", "node4", "relation3"},{"node4", "node5", "relation4"},
//								{"node2", "node6", "relation5"}, {"node1", "node7", "relation6"}};
//	
//		createGraph(graph, nodeNames, relationNames);
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
//		String[][] relationNames= {	{"node1", "node2", "relation1"}, {"node2", "node3","relation2"}, 
//								{"node2", "node6", "relation3"}, {"node4", "node2", "relation4"}};
//	
//		createGraph(graph, nodeNames, relationNames);
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
//		String[][] relationNames= {	{"node1", "node2", "relation1"}, {"node2", "node3","relation2"}, 
//								{"node2", "node6", "relation3"}, {"node4", "node2", "relation4"},
//								{"node6", "node7", "relation5"}, {"node7", "node2", "relation6"}};
//	
//		createGraph(graph, nodeNames, relationNames);
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
//		String[][] relationNames= {	{"node1", "node2", "relation1"}, {"node2", "node3","relation2"}, 
//								{"node2", "node6", "relation3"}, {"node6", "node7", "relation5"}, 
//								{"node7", "node2", "relation6"}};
//	
//		createGraph(graph, nodeNames, relationNames);
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
//		String[][] relationNames= {	{"node1", "node2", "relation1"}, {"node2", "node3","relation2"}, 
//								{"node3", "node1", "relation3"}};
//	
//		createGraph(graph, nodeNames, relationNames);
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
//			roots= getFixture().getRoots();
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
//			roots= getFixture().getRoots();
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
//			roots= getFixture().getRoots();
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
//			leafs= getFixture().getLeafs();
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
//			leafs= getFixture().getLeafs();
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
//			leafs= getFixture().getLeafs();
//			assertEquals("The expected number of leafs are not the same, as the returned number", expectedLeafs.size(), leafs.size());
//			for (Node expectedLeaf: expectedLeafs)
//			{
//				assertTrue("The list of returned roots does not contain expected leaf '"+expectedLeaf.getId()+"'.", leafs.contains(expectedLeaf));
//			}
//		}//test 3
//	}
//	
//
//	public void testRemoveRelation__RelationByList() 
//	{
//		//Knoten in den Graphen einf�gen
//		this.insertNodes(nodes);
//		//Kanten in den Graphen einf�gen
//		this.insertRelations(relations);
//		//Pr�fen ob Kanten eingef�gt wurden
//		for (Relation relation: relations)
//		{
//			assertSame("this relation '"+relation.getId()+"' should be there", relation, getFixture().getRelation(relation.getId()));
//		}
//		//Kante l�schen
//		for (Relation relation: relations)
//		{
//			if (getFixture().getRelation(relation.getId())!= null)
//			{
//				assertSame("this relation '"+relation.getId()+"' should be there", relation, getFixture().getRelation(relation.getId()));	
//				assertTrue(getFixture().getRelations().remove(relation));
//				assertNull("this relation '"+relation.getId()+"' shouldn�t be there", getFixture().getRelation(relation.getId()));
//			}
//		}
//		//Kante entfernen, deren Knoten es nicht gibt
//		Relation relation= GraphFactory.createRelation();
//		relation.setId("not there");
//		assertFalse(getFixture().getRelations().remove(relation));
//	}
//	
//	/**
//	 * Testet das Entfernen aller Kanten des Graphen.
//	 * @throws Exception
//	 */
//	public void testRemoveAllRelation() throws Exception
//	{
//		//add node to graph
//		this.insertNodes(nodes);
//		//add relations to graph
//		this.insertRelations(relations);
//		//check if relations have been added
//		for (Relation relation: relations)
//		{
//			assertSame("this relation '"+relation.getId()+"' should be there", relation, getFixture().getRelation(relation.getId()));
//		}
//		//remove old relation
//		getFixture().removeRelations();
//		//add new relation
//		for (Relation relation: relations )
//		{
//			//add relation
//			getFixture().addRelation(relation);
//			//check if relation exists
//			assertEquals("created relation has to be there", getFixture().getRelation(relation.getId()), relation);
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
//		long i= getFixture().getIndexMgr().getNumOfIndexes();
//		String[] indexNames= {"index1", "index2", "index3", "index4", "index5"};
//		for (String indexName: indexNames)
//		{
//			Index simpleIndex= IndexFactory.eINSTANCE.createSimpleIndex();
//			simpleIndex.setId(indexName);
//			getFixture().getIndexMgr().addIndex(simpleIndex);
//		}
//		assertEquals(indexNames.length, getFixture().getIndexMgr().getNumOfIndexes()-i);
//	}
//	public void testReverseGetLabel()
//	{
//		Label<String> label= GraphFactory.createLabel();
//		label.setName("labelName");
//		getFixture().addLabel(label);
//		
//		assertEquals(getFixture(), label.getLabelableElement());
//	}
}
