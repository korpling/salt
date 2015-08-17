package de.hu_berlin.u.saltnpepper.salt.core.impl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotationContainer;
import de.hu_berlin.u.saltnpepper.salt.core.SGraph;
import de.hu_berlin.u.saltnpepper.salt.core.SNamedElement;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;
import de.hu_berlin.u.saltnpepper.salt.util.SaltUtil;

public class TestHelper {
	/**
	 * Tests the methods {@link SNamedElement#getName()} and
	 * {@link SNamedElement#setName(String)}.
	 */
	public static void testGetName(SNamedElement namedElement) {
		assertNull(namedElement.getName());
		namedElement.setName("myName");
		assertEquals("myName", namedElement.getName());
		namedElement.setName(null);
		assertNull(namedElement.getName());

		if (namedElement instanceof SAnnotationContainer) {
			((SAnnotationContainer) namedElement).removeLabel(SaltUtil.FEAT_NAME_QNAME);
			assertNull(namedElement.getName());
			((SAnnotationContainer) namedElement).createFeature(SaltUtil.SALT_NAMESPACE, SaltUtil.FEAT_NAME, "myName2");
			assertEquals("myName2", namedElement.getName());
		}
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
}
