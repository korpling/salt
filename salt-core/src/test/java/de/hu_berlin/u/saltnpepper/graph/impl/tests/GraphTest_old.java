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

}
