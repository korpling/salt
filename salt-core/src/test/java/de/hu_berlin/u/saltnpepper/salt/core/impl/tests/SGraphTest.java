package de.hu_berlin.u.saltnpepper.salt.core.impl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.core.SGraph;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;

public class SGraphTest extends SAnnotationContainerTest{
	public SGraph getFixture() {
		return((SGraph)super.getFixture());
	}
	@Before
	public void setUp() throws Exception {
		setFixture(SaltFactory.createSGraph());
	}

	// ============================================== start: create dummy graphs
	/**
	 * Fills the given graph, containing nodes having the names as given in
	 * nodeNames list and connects them with relations as given in the
	 * relationNames list. The relation names list contains of entries as
	 * follows: [[SOURCE_NODE_NAME, TARGET_NODE_NAME, EDGE_NAME],...]
	 * 
	 * @param nodeNames
	 * @param relationNames
	 */
	public static void createGraph(SGraph graph, String[] nodeNames, String[][] relationNames) {
		List<SNode> nodes = new ArrayList<>();
		for (String nodeName : nodeNames) {
			SNode node = SaltFactory.createSNode();
			node.setId(nodeName);
			nodes.add((node));
			graph.addNode(node);
		}

		// Kantenliste erstellen
		List<SRelation<SNode, SNode>> relations = new ArrayList<>();
		SRelation<SNode, SNode> relation = null;
		for (int i = 0; i < relationNames.length; i++) {
			for (SNode srcNode : nodes) {
				if (((String) srcNode.getId()).equalsIgnoreCase(relationNames[i][0])) {
					for (SNode dstNode : nodes) {
						if (((String) dstNode.getId()).equalsIgnoreCase(relationNames[i][1])) {
							relation = SaltFactory.createSRelation();
							relation.setId(relationNames[i][2]);
							relation.setSource(srcNode);
							relation.setTarget(dstNode);
							relations.add(relation);
							graph.addRelation(relation);
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
	 * 
	 * <pre>
	 *                 node1             
	 *            /        \        \  
	 *           V          V        V
	 *        node2        node4    node7
	 *        /    \        |         
	 *       V      V       V
	 *    node3    node6   node5
	 * </pre>
	 **/
	public static SGraph createGraph_Tree() {
		SGraph graph = SaltFactory.createSGraph();
		graph.setId("createGraph_Tree");
		String[] nodeNames = { "node1", "node2", "node3", "node4", "node5", "node6", "node7" };
		String[][] relationNames = { { "node1", "node2", "relation1" }, { "node2", "node3", "relation2" }, { "node1", "node4", "relation3" }, { "node4", "node5", "relation4" }, { "node2", "node6", "relation5" }, { "node1", "node7", "relation6" } };

		createGraph(graph, nodeNames, relationNames);
		return (graph);
	}

	/**
	 * Creates the following graph: <br/>
	 * 
	 * <pre>
	 *     node1    node4
	 *        \    /
	 *         V  V  
	 *        node2      
	 *        /    \
	 *       V      V
	 *    node3    node6
	 * </pre>
	 **/
	public static SGraph createGraph_DAG() {
		SGraph graph = SaltFactory.createSGraph();
		graph.setId("createGraph_DAG");

		String[] nodeNames = { "node1", "node2", "node3", "node4", "node6", };
		String[][] relationNames = { { "node1", "node2", "relation1" }, { "node2", "node3", "relation2" }, { "node2", "node6", "relation3" }, { "node4", "node2", "relation4" } };

		createGraph(graph, nodeNames, relationNames);
		return (graph);
	}

	/**
	 * Creates the following graph including a cycle: <br/>
	 * 
	 * <pre>
	 *     node1    node4
	 *        \    /   
	 *         V  V    
	 *        node2          
	 *        /    \
	 *        V     V     
	 *    node3    node6
	 *                \ 
	 *                 V     
	 *              node 7
	 * node 7 -> node2
	 * </pre>
	 **/
	public static SGraph createGraph_Cycle() {
		SGraph graph = SaltFactory.createSGraph();
		graph.setId("createGraph_Cycle");
		String[] nodeNames = { "node1", "node2", "node3", "node4", "node6", "node7" };
		String[][] relationNames = { { "node1", "node2", "relation1" }, { "node2", "node3", "relation2" }, { "node2", "node6", "relation3" }, { "node4", "node2", "relation4" }, { "node6", "node7", "relation5" }, { "node7", "node2", "relation6" } };

		createGraph(graph, nodeNames, relationNames);
		return (graph);
	}

	/**
	 * Creates the following graph including a cycle: <br/>
	 * 
	 * <pre>
	 *     node1                
	 *        \ 
	 *         V               
	 *        node2            
	 *        /    \
	 *       V      V      
	 *    node3    node6         
	 *                \ 
	 *                 V       
	 *                 node 7    
	 * node 7 -> node2
	 * </pre>
	 **/
	public static SGraph createGraph_SimpleCycle() {
		SGraph graph = SaltFactory.createSGraph();
		graph.setId("createGraph_SimpleCycle");
		String[] nodeNames = { "node1", "node2", "node3", "node6", "node7" };
		String[][] relationNames = { { "node1", "node2", "relation1" }, { "node2", "node3", "relation2" }, { "node2", "node6", "relation3" }, { "node6", "node7", "relation5" }, { "node7", "node2", "relation6" } };

		createGraph(graph, nodeNames, relationNames);
		return (graph);
	}

	/**
	 * Creates the following graph including a cycle: <br/>
	 * 
	 * <pre>
	 *       node1
	 *        ^ \
	 *       /   V
	 *  node3 <- node2
	 * 
	 * </pre>
	 **/
	public static SGraph createGraph_PureCycle() {
		SGraph graph = SaltFactory.createSGraph();
		graph.setId("createGraph_PureCycle");
		String[] nodeNames = { "node1", "node2", "node3" };
		String[][] relationNames = { { "node1", "node2", "relation1" }, { "node2", "node3", "relation2" }, { "node3", "node1", "relation3" } };

		createGraph(graph, nodeNames, relationNames);
		return (graph);
	}

	// ============================================== end: create dummy graphs

	/**
	 * Tests that the root nodes are returned correctly.
	 */
	@Test
	public void testGetRoots() {
		List<SNode> expectedRoots = null;
		List<SNode> roots = null;
		SGraph graph = null;

		// test 1
		graph = createGraph_Tree();
		setFixture(graph);
		expectedRoots = new ArrayList<>();
		expectedRoots.add(graph.getNode("node1"));
		roots = getFixture().getRoots();
		assertEquals("The expected number of roots are not the same, as the returned number", expectedRoots.size(), roots.size());
		for (SNode expectedRoot : expectedRoots) {
			assertTrue("The list of returned roots does not contain expected root '" + expectedRoot.getId() + "'.", roots.contains(expectedRoot));
		}

		// test 2
		graph = createGraph_DAG();
		setFixture(graph);
		expectedRoots = new ArrayList<>();
		expectedRoots.add(graph.getNode("node1"));
		expectedRoots.add(graph.getNode("node4"));
		roots = getFixture().getRoots();
		assertEquals("The expected number of roots are not the same, as the returned number", expectedRoots.size(), roots.size());
		for (SNode expectedRoot : expectedRoots) {
			assertTrue("The list of returned roots does not contain expected root '" + expectedRoot.getId() + "'.", roots.contains(expectedRoot));
		}

		// test 3
		graph = createGraph_Cycle();
		setFixture(graph);
		expectedRoots = new ArrayList<>();
		expectedRoots.add(graph.getNode("node1"));
		expectedRoots.add(graph.getNode("node4"));
		roots = getFixture().getRoots();
		assertEquals("The expected number of roots are not the same, as the returned number", expectedRoots.size(), roots.size());
		for (SNode expectedRoot : expectedRoots) {
			assertTrue("The list of returned roots does not contain expected root '" + expectedRoot.getId() + "'.", roots.contains(expectedRoot));
		}
	}

	/**
	 * Tests that the leaf nodes are returned correctly.
	 */
	@Test
	public void testGetLeafs() {
		List<SNode> expectedLeafs = null;
		List<SNode> leafs = null;
		SGraph graph = null;

		// test 1
		graph = createGraph_Tree();
		setFixture(graph);
		expectedLeafs = new ArrayList<>();
		expectedLeafs.add(graph.getNode("node3"));
		expectedLeafs.add(graph.getNode("node6"));
		expectedLeafs.add(graph.getNode("node5"));
		expectedLeafs.add(graph.getNode("node7"));
		leafs = getFixture().getLeafs();
		assertEquals("The expected number of leafs are not the same, as the returned number", expectedLeafs.size(), leafs.size());
		for (SNode expectedLeaf : expectedLeafs) {
			assertTrue("The list of returned roots does not contain expected leaf '" + expectedLeaf.getId() + "'.", leafs.contains(expectedLeaf));
		}

		// test 2
		graph = createGraph_DAG();
		setFixture(graph);
		expectedLeafs = new ArrayList<>();
		expectedLeafs.add(graph.getNode("node3"));
		expectedLeafs.add(graph.getNode("node6"));
		leafs = getFixture().getLeafs();
		assertEquals("The expected number of leafs are not the same, as the returned number", expectedLeafs.size(), leafs.size());
		for (SNode expectedLeaf : expectedLeafs) {
			assertTrue("The list of returned leafs does not contain expected leaf '" + expectedLeaf.getId() + "'.", leafs.contains(expectedLeaf));
		}

		// test 3
		graph = createGraph_Cycle();
		this.setFixture(graph);
		expectedLeafs = new ArrayList<>();
		expectedLeafs.add(graph.getNode("node3"));
		leafs = getFixture().getLeafs();
		assertEquals("The expected number of leafs are not the same, as the returned number", expectedLeafs.size(), leafs.size());
		for (SNode expectedLeaf : expectedLeafs) {
			assertTrue("The list of returned roots does not contain expected leaf '" + expectedLeaf.getId() + "'.", leafs.contains(expectedLeaf));
		}
	}
}
