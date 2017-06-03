/**
 * Copyright 2009 Humboldt-Universität zu Berlin.
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
package org.corpus_tools.salt.core.impl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.core.GraphTraverseHandler;
import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SGraph.GRAPH_TRAVERSE_TYPE;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.exceptions.SaltException;
import org.corpus_tools.salt.graph.GraphFactory;
import org.corpus_tools.salt.graph.Label;
import org.corpus_tools.salt.graph.Node;
import org.junit.Before;
import org.junit.Test;

public class GraphTraverserModuleTest {
	private GraphTraverserModule fixture = null;

	public void setFixture(GraphTraverserModule fixture) {
		this.fixture = fixture;
	}

	public GraphTraverserModule getFixture() {
		return fixture;
	}

	@Before
	public void setUp() {
		this.setFixture(new GraphTraverserModule());
	}

	/**
	 * This class checks if a traversing uses the predefined way. The predefined
	 * way can be set via the variables nodeOrderWayThere and nodeOrderWayBack.
	 * This class implements the interface {@link GraphTraverseHandler} and
	 * therefore listens for callbacks of the graph traversal.
	 */
	class TraverserChecker implements GraphTraverseHandler, Runnable {
		// class TraverserChecker
		/**
		 * determines if current run is cyclesafe. If this value is true, each
		 * cycle will be traversed two times, than the method
		 * {@link #checkConstraint(GRAPH_TRAVERSE_TYPE, String, Edge, Node, long)}
		 * will return false;
		 */
		public boolean isCycleSafe = true;

		/**
		 * The names of the nodes in order of how they shall be visited in
		 * current traversal mode on the way there.
		 */
		private String[] nodeOrderWayThere;
		/**
		 * Position in list nodeOrderWayThere, of node to be reached next.
		 */
		private int posInWayThere = 0;

		/**
		 * The names of the nodes in order of how they shall be visited in
		 * current traversal mode on the way back.
		 */
		private String[] nodeOrderWayBack;
		/**
		 * Position in list nodeOrderWayBack, of node to be left next.
		 */
		private int posInWayBack = 0;

		public void nodeReached(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode,
				SRelation<? extends SNode, ? extends SNode> rel, SNode fromNode, long order) {
			currentPath.add(currNode);
			if (!currNode.getId().equalsIgnoreCase(nodeOrderWayThere[posInWayThere])) {
				String path = null;
				for (String nodeName : nodeOrderWayThere) {
					if (path == null)
						path = nodeName;
					else
						path = path + "->" + nodeName;
				}
				throw new RuntimeException(
						"Test fails, another way than expected has been traversed on way there. Expected way was '"
								+ path + "', but instead of node '" + nodeOrderWayThere[posInWayThere]
								+ "' at position '" + posInWayThere + "', node '" + currNode.getId() + "' was found.");
			}
			posInWayThere++;
		}

		public void nodeLeft(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode,
				SRelation<? extends SNode, ? extends SNode> rel, SNode fromNode, long order) {
			if (GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST == traversalType
					|| GRAPH_TRAVERSE_TYPE.BOTTOM_UP_DEPTH_FIRST == traversalType) {
				currentPath.remove(currentPath.size() - 1);
			}
			if (!currNode.getId().equalsIgnoreCase(nodeOrderWayBack[posInWayBack])) {
				String path = null;
				for (String nodeName : nodeOrderWayBack) {
					if (path == null)
						path = nodeName;
					else
						path = path + "->" + nodeName;
				}
				throw new RuntimeException(
						"Test fails, another way than expected has been traversed on way back. Expected way was '"
								+ path + "', but instead of node '" + nodeOrderWayBack[posInWayBack] + "' at position '"
								+ (posInWayBack + 1) + "', node '" + currNode.getId() + "' was found.");
			}
			posInWayBack++;
		}

		/**
		 * Stores the current node path
		 */
		private List<SNode> currentPath = new ArrayList<>();

		public boolean checkConstraint(GRAPH_TRAVERSE_TYPE traversalType, String traversalId,
				SRelation<? extends SNode, ? extends SNode> rel, SNode currNode, long order) {
			boolean retVal = true;

			if (isCycleSafe == false) {// checks if a path in currentPath is
										// contained two times
				Integer numOfOccurences = 0;
				for (int i = 0; i < currentPath.size(); i++) {
					if (currentPath.get(i).equals(currNode)) {
						numOfOccurences++;
					}
				}
				if (numOfOccurences >= 2)
					retVal = false;
			} // checks if a path in currentPath is contained two times

			return retVal;
		}

		public boolean checkNumberOfTraversedNodes() {
			return posInWayThere == nodeOrderWayThere.length && posInWayBack == nodeOrderWayBack.length;
		}

		private List<SNode> startNodes = null;
		private GRAPH_TRAVERSE_TYPE traverseType = null;
		private String traverseId = null;
		private Exception exception = null;
		public int runs = 0;
		Thread traverseThread;

		public void start(List<SNode> startNodes, GRAPH_TRAVERSE_TYPE traverseType, String traverseId) {
			this.startNodes = startNodes;
			this.traverseType = traverseType;
			this.traverseId = traverseId;
			traverseThread = new Thread(this, "traverse_" + traverseId);
			traverseThread.start();
		}

		public void run() {
			try {
				getFixture().traverse(startNodes, traverseType, traverseId, this, isCycleSafe);
			} catch (Exception e) {
				this.exception = e;
			} finally {
				runs++;
			}
		}
	}// class TraverserChecker

	// ==================================================== start: tests

	/**
	 * Checks if wrong parameter calling is detected.
	 */
	@Test
	public void testTraverseParameters() {
		List<SNode> startNodes = null;
		GRAPH_TRAVERSE_TYPE traverseType = null;
		GraphTraverseHandler handler = null;

		{// test 1
			startNodes = null;
			traverseType = GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST;
			handler = new TraverserChecker();

			try {
				getFixture().traverse(startNodes, traverseType, "test_TOP_DOWN_DEPTH_FIRST_Tree", handler);
				fail("null parameters are not allowed");
			} catch (Exception e) {
			}
		} // test 1

		{// test 2
			startNodes = new ArrayList<SNode>();
			startNodes.add(SaltFactory.createSNode());
			traverseType = null;
			handler = new TraverserChecker();

			try {
				getFixture().traverse(startNodes, traverseType, "test_TOP_DOWN_DEPTH_FIRST_Tree", handler);
				fail("null parameters are not allowed");
			} catch (Exception e) {
			}
		} // test 2

		{// test 3
			startNodes = new ArrayList<>();
			startNodes.add(SaltFactory.createSNode());
			traverseType = GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST;
			handler = null;

			try {
				getFixture().traverse(startNodes, traverseType, "test_TOP_DOWN_DEPTH_FIRST_Tree", handler);
				fail("null parameters are not allowed");
			} catch (Exception e) {
			}
		} // test 3
	}

	/**
	 * Starts 3 threads to traverse the graph and checks, that no problem
	 * concerning the use of threads occurs. Uses
	 * {@link GRAPH_TRAVERSE_TYPE#TOP_DOWN_DEPTH_FIRST} as traverse order.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testThreading_TOP_DOWN_DEPTH_FIRST() throws Exception {
		// uses the tree as graph
		getFixture().setGraph(TestHelper.createTree());

		List<SNode> startNodes = null;
		GRAPH_TRAVERSE_TYPE traverseType = null;
		String traverseId = null;
		getFixture().setGraph(TestHelper.createTree());

		startNodes = getFixture().getGraph().getRoots();
		traverseType = GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST;

		TraverserChecker traverseChecker1 = null;
		TraverserChecker traverseChecker2 = null;
		TraverserChecker traverseChecker3 = null;

		String[] nodeOrderWayThere = { "node1", "node2", "node3", "node6", "node4", "node5", "node7" };
		String[] nodeOrderWayBack = { "node3", "node6", "node2", "node5", "node4", "node7", "node1" };

		{// thread 1
			traverseId = "testThreading_1";
			traverseChecker1 = new TraverserChecker();
			traverseChecker1.nodeOrderWayThere = nodeOrderWayThere;
			traverseChecker1.nodeOrderWayBack = nodeOrderWayBack;
			traverseChecker1.start(startNodes, traverseType, traverseId);
		} // thread 1

		{// thread 2
			traverseId = "testThreading_2";
			traverseChecker2 = new TraverserChecker();
			traverseChecker2.nodeOrderWayThere = nodeOrderWayThere;
			traverseChecker2.nodeOrderWayBack = nodeOrderWayBack;
			traverseChecker2.start(startNodes, traverseType, traverseId);
		} // thread 2

		{// thread 3
			traverseId = "testThreading_3";
			traverseChecker3 = new TraverserChecker();
			traverseChecker3.nodeOrderWayThere = nodeOrderWayThere;
			traverseChecker3.nodeOrderWayBack = nodeOrderWayBack;
			traverseChecker3.start(startNodes, traverseType, traverseId);
		} // thread 3

		while ((traverseChecker1.runs < 1) || (traverseChecker2.runs < 1) || (traverseChecker3.runs < 1)) {
			Thread.sleep(100);
		}

		List<TraverserChecker> traverseCheckers = new ArrayList<GraphTraverserModuleTest.TraverserChecker>();
		traverseCheckers.add(traverseChecker1);
		traverseCheckers.add(traverseChecker2);
		traverseCheckers.add(traverseChecker3);

		for (TraverserChecker traverseChecker : traverseCheckers) {
			if ((traverseChecker.exception != null)) {
				throw traverseChecker.exception;
			}
		}
	}

	/**
	 * Starts 3 threads to traverse the graph and checks, that no problem
	 * concerning the use of threads occurs. Uses
	 * {@link GRAPH_TRAVERSE_TYPE#TOP_DOWN_BREADTH_FIRST} as traverse order.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testThreading_TOP_DOWN_BREADTH_FIRST() throws Exception {
		// uses the tree as graph
		getFixture().setGraph(TestHelper.createTree());

		List<SNode> startNodes = null;
		GRAPH_TRAVERSE_TYPE traverseType = null;
		String traverseId = null;
		getFixture().setGraph(TestHelper.createTree());

		startNodes = getFixture().getGraph().getRoots();
		traverseType = GRAPH_TRAVERSE_TYPE.TOP_DOWN_BREADTH_FIRST;

		TraverserChecker traverseChecker1 = null;
		TraverserChecker traverseChecker2 = null;
		TraverserChecker traverseChecker3 = null;

		String[] nodeOrderWayThere = { "node1", "node2", "node4", "node7", "node3", "node6", "node5" };
		String[] nodeOrderWayBack = { "node1", "node2", "node4", "node7", "node3", "node6", "node5" };

		{// thread 1
			traverseId = "testThreading_1";
			traverseChecker1 = new TraverserChecker();
			traverseChecker1.isCycleSafe = false;
			traverseChecker1.nodeOrderWayThere = nodeOrderWayThere;
			traverseChecker1.nodeOrderWayBack = nodeOrderWayBack;
			traverseChecker1.start(startNodes, traverseType, traverseId);
		} // thread 1

		{// thread 2
			traverseId = "testThreading_2";
			traverseChecker2 = new TraverserChecker();
			traverseChecker2.isCycleSafe = false;
			traverseChecker2.nodeOrderWayThere = nodeOrderWayThere;
			traverseChecker2.nodeOrderWayBack = nodeOrderWayBack;
			traverseChecker2.start(startNodes, traverseType, traverseId);
		} // thread 2

		{// thread 3
			traverseId = "testThreading_3";
			traverseChecker3 = new TraverserChecker();
			traverseChecker3.isCycleSafe = false;
			traverseChecker3.nodeOrderWayThere = nodeOrderWayThere;
			traverseChecker3.nodeOrderWayBack = nodeOrderWayBack;
			traverseChecker3.start(startNodes, traverseType, traverseId);
		} // thread 3

		// while ( (traverseChecker1.runs< 1 )||
		// (traverseChecker2.runs< 1 ) ||
		// (traverseChecker3.runs< 1 ))
		// {
		// Thread.sleep(100);
		// }
		traverseChecker3.traverseThread.join();
		traverseChecker2.traverseThread.join();
		traverseChecker1.traverseThread.join();

		List<TraverserChecker> traverseCheckers = new ArrayList<GraphTraverserModuleTest.TraverserChecker>();
		traverseCheckers.add(traverseChecker1);
		traverseCheckers.add(traverseChecker2);
		traverseCheckers.add(traverseChecker3);

		for (TraverserChecker traverseChecker : traverseCheckers) {
			if ((traverseChecker.exception != null)) {
				throw traverseChecker.exception;
			}
		}
	}

	/**
	 * Tests the traversing of top-down, depth first of graph_Tree.
	 */
	@Test
	public void testTraverse_TOP_DOWN_DEPTH_FIRST_Tree() {
		SGraph graph = TestHelper.createTree();
		String[] nodeOrderWayThere = { "node1", "node2", "node3", "node6", "node4", "node5", "node7" };
		String[] nodeOrderWayBack = { "node3", "node6", "node2", "node5", "node4", "node7", "node1" };
		TraverserChecker checker = new TraverserChecker();
		checker.nodeOrderWayThere = nodeOrderWayThere;
		checker.nodeOrderWayBack = nodeOrderWayBack;
		getFixture().setGraph(graph);
		getFixture().traverse(getFixture().getGraph().getRoots(), GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST,
				"test_TOP_DOWN_DEPTH_FIRST_Tree", checker);
		assertTrue(checker.checkNumberOfTraversedNodes());
	}

	/**
	 * Tests the traversing of top-down, depth first of graph_DAG.
	 */
	@Test
	public void testTraverse_TOP_DOWN_DEPTH_FIRST_DAG() {
		SGraph graph = TestHelper.createDag();
		String[] nodeOrderWayThere = { "node1", "node2", "node3", "node6", "node4", "node2", "node3", "node6" };
		String[] nodeOrderWayBack = { "node3", "node6", "node2", "node1", "node3", "node6", "node2", "node4" };
		TraverserChecker checker = new TraverserChecker();
		checker.nodeOrderWayThere = nodeOrderWayThere;
		checker.nodeOrderWayBack = nodeOrderWayBack;
		getFixture().setGraph(graph);
		getFixture().traverse(getFixture().getGraph().getRoots(), GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST,
				"test_TOP_DOWN_DEPTH_FIRST_DAG", checker);
		assertTrue(checker.checkNumberOfTraversedNodes());
	}

	/**
	 * Tests the traversing of top-down, depth first of graph_Cycle.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testTraverse_TOP_DOWN_DEPTH_FIRST_Cycle() throws Exception {
		SGraph graph = TestHelper.createCycledDag();
		String[] nodeOrderWayThere = { "node1", "node2", "node3", "node6", "node7", "node2", "node6", "node7",
				"node2" };
		String[] nodeOrderWayBack = { "node3", "node6", "node2", "node1", "node3", "node6", "node2", "node4" };
		TraverserChecker checker = new TraverserChecker();
		checker.nodeOrderWayThere = nodeOrderWayThere;
		checker.nodeOrderWayBack = nodeOrderWayBack;
		getFixture().setGraph(graph);
		try {
			getFixture().traverse(getFixture().getGraph().getRoots(), GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST,
					"test_TOP_DOWN_DEPTH_FIRST_Cycle", checker);
			assertTrue(checker.checkNumberOfTraversedNodes());
			fail("The graph contains a cycle, that shall invoke an exception.");
		} catch (Exception e) {
		}
	}

	/**
	 * Tests the traversing of top-down, depth first of graph_Cycle.
	 */
	@Test
	public void testTraverse_TOP_DOWN_DEPTH_FIRST_CycleUnsafe() {
		SGraph graph = TestHelper.createCycledTree();
		String[] nodeOrderWayThere = { "node1", "node2", "node3", "node6", "node7", "node2", "node3", "node6",
				"node7" };
		String[] nodeOrderWayBack = { "node3", "node3", "node7", "node6", "node2", "node7", "node6", "node2", "node1" };
		TraverserChecker checker = new TraverserChecker();
		checker.nodeOrderWayThere = nodeOrderWayThere;
		checker.nodeOrderWayBack = nodeOrderWayBack;
		checker.isCycleSafe = false;
		getFixture().setGraph(graph);
		getFixture().traverse(getFixture().getGraph().getRoots(), GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST,
				"test_TOP_DOWN_DEPTH_FIRST_Cycle", checker, false);
		assertTrue(checker.checkNumberOfTraversedNodes());
	}

	/**
	 * Tests the traversing of bottom-up, depth first of graph_Tree.
	 */
	@Test
	public void testTraverse_BOTTOM_UP_DEPTH_FIRST_Tree() {
		SGraph graph = TestHelper.createTree();
		String[] nodeOrderWayThere = { "node3", "node2", "node1", "node5", "node4", "node1", "node6", "node2", "node1",
				"node7", "node1" };
		String[] nodeOrderWayBack = { "node1", "node2", "node3", "node1", "node4", "node5", "node1", "node2", "node6",
				"node1", "node7" };
		TraverserChecker checker = new TraverserChecker();
		checker.nodeOrderWayThere = nodeOrderWayThere;
		checker.nodeOrderWayBack = nodeOrderWayBack;
		getFixture().setGraph(graph);
		getFixture().traverse(getFixture().getGraph().getLeafs(), GRAPH_TRAVERSE_TYPE.BOTTOM_UP_DEPTH_FIRST,
				"test_BOTTOM_UP_DEPTH_FIRST_Tree", checker);
		assertTrue(checker.checkNumberOfTraversedNodes());
	}

	/**
	 * Tests the traversing of bottom-up, depth first of graph_DAG.
	 */
	@Test
	public void testTraverse_BOTTOM_UP_DEPTH_FIRST_DAG() {
		SGraph graph = TestHelper.createDag();
		String[] nodeOrderWayThere = { "node3", "node2", "node1", "node4", "node6", "node2", "node1", "node4" };
		String[] nodeOrderWayBack = { "node1", "node4", "node2", "node3", "node1", "node4", "node2", "node6" };
		TraverserChecker checker = new TraverserChecker();
		checker.nodeOrderWayThere = nodeOrderWayThere;
		checker.nodeOrderWayBack = nodeOrderWayBack;
		getFixture().setGraph(graph);
		getFixture().traverse(getFixture().getGraph().getLeafs(), GRAPH_TRAVERSE_TYPE.BOTTOM_UP_DEPTH_FIRST,
				"test_BOTTOM_UP_DEPTH_FIRST_DAG", checker);
		assertTrue(checker.checkNumberOfTraversedNodes());
	}

	/**
	 * Tests the traversing of bottom-up, depth first of graph_Cycle.
	 */
	@Test
	public void testTraverse_BOTTOM_UP_DEPTH_FIRST_Cycle() {
		SGraph graph = TestHelper.createCycledDag();
		String[] nodeOrderWayThere = { "node3", "node2", "node1", "node4", "node7", "node6", "node2", "node1",
				"node4" };
		String[] nodeOrderWayBack = { "node1", "node4", "node2", "node3", "node1", "node4", "node2", "node6" };
		TraverserChecker checker = new TraverserChecker();
		checker.nodeOrderWayThere = nodeOrderWayThere;
		checker.nodeOrderWayBack = nodeOrderWayBack;
		getFixture().setGraph(graph);
		try {
			getFixture().traverse(getFixture().getGraph().getLeafs(), GRAPH_TRAVERSE_TYPE.BOTTOM_UP_DEPTH_FIRST,
					"test_BOTTOM_UP_DEPTH_FIRST_Cycle", checker);
			assertTrue(checker.checkNumberOfTraversedNodes());
			fail("The graph contains a cycle, that shall invoke an exception.");
		} catch (Exception e) {
			;
		}
	}

	/**
	 * Starts 3 threads to traverse the graph and checks, that no problem
	 * concerning the use of threads occurs. Uses
	 * {@link GRAPH_TRAVERSE_TYPE#BOTTOM_UP_DEPTH_FIRST} as traverse order.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testThreading_BOTTOM_UP_DEPTH_FIRST() throws Exception {
		// uses the tree as graph
		getFixture().setGraph(TestHelper.createTree());

		List<SNode> startNodes = null;
		GRAPH_TRAVERSE_TYPE traverseType = null;
		String traverseId = null;
		getFixture().setGraph(TestHelper.createTree());

		startNodes = getFixture().getGraph().getLeafs();
		traverseType = GRAPH_TRAVERSE_TYPE.BOTTOM_UP_DEPTH_FIRST;

		TraverserChecker traverseChecker1 = null;
		TraverserChecker traverseChecker2 = null;
		TraverserChecker traverseChecker3 = null;
		String[] nodeOrderWayThere = { "node3", "node2", "node1", "node5", "node4", "node1", "node6", "node2", "node1",
				"node7", "node1" };
		String[] nodeOrderWayBack = { "node1", "node2", "node3", "node1", "node4", "node5", "node1", "node2", "node6",
				"node1", "node7" };

		{// thread 1
			traverseId = "testThreading_1";
			traverseChecker1 = new TraverserChecker();
			traverseChecker1.nodeOrderWayThere = nodeOrderWayThere;
			traverseChecker1.nodeOrderWayBack = nodeOrderWayBack;
			traverseChecker1.start(startNodes, traverseType, traverseId);
		} // thread 1

		{// thread 2
			traverseId = "testThreading_2";
			traverseChecker2 = new TraverserChecker();
			traverseChecker2.nodeOrderWayThere = nodeOrderWayThere;
			traverseChecker2.nodeOrderWayBack = nodeOrderWayBack;
			traverseChecker2.start(startNodes, traverseType, traverseId);
		} // thread 2

		{// thread 3
			traverseId = "testThreading_3";
			traverseChecker3 = new TraverserChecker();
			traverseChecker3.nodeOrderWayThere = nodeOrderWayThere;
			traverseChecker3.nodeOrderWayBack = nodeOrderWayBack;
			traverseChecker3.start(startNodes, traverseType, traverseId);
		} // thread 3

		while ((traverseChecker1.runs < 1) || (traverseChecker2.runs < 1) || (traverseChecker3.runs < 1)) {
			Thread.sleep(100);
		}

		List<TraverserChecker> traverseCheckers = new ArrayList<GraphTraverserModuleTest.TraverserChecker>();
		traverseCheckers.add(traverseChecker1);
		traverseCheckers.add(traverseChecker2);
		traverseCheckers.add(traverseChecker3);

		for (TraverserChecker traverseChecker : traverseCheckers) {
			if ((traverseChecker.exception != null)) {
				throw traverseChecker.exception;
			}
		}
		for (TraverserChecker checker : traverseCheckers) {
			assertTrue(checker.checkNumberOfTraversedNodes());
		}
	}

	/**
	 * Tests the traversing of
	 * {@link GRAPH_TRAVERSE_TYPE#TOP_DOWN_BREADTH_FIRST} of graph_Tree, with
	 * tree {@inheritDoc SGraphTest#createGraph_Tree()}.
	 */
	@Test
	public void testTraverse_TOP_DOWN_BREADTH_FIRST_Tree() {
		SGraph graph = TestHelper.createTree();
		String[] nodeOrderWayThere = { "node1", "node2", "node4", "node7", "node3", "node6", "node5" };
		String[] nodeOrderWayBack = { "node1", "node2", "node4", "node7", "node3", "node6", "node5" };
		TraverserChecker checker = new TraverserChecker();
		checker.nodeOrderWayThere = nodeOrderWayThere;
		checker.nodeOrderWayBack = nodeOrderWayBack;
		getFixture().setGraph(graph);
		getFixture().traverse(getFixture().getGraph().getRoots(), GRAPH_TRAVERSE_TYPE.TOP_DOWN_BREADTH_FIRST,
				"test_TOP_DOWN_BREADTH_FIRST_Tree", checker, false);
		assertTrue(checker.checkNumberOfTraversedNodes());
	}

	/**
	 * Tests the traversing of
	 * {@link GRAPH_TRAVERSE_TYPE#TOP_DOWN_BREADTH_FIRST} of graph_DAG, with
	 * graph {@inheritDoc SGraphTest#createGraph_DAG()}.
	 */
	@Test
	public void testTraverse_TOP_DOWN_BREADTH_FIRST_DAG() {
		SGraph graph = TestHelper.createDag();
		String[] nodeOrderWayThere = { "node1", "node4", "node2", "node2", "node3", "node6", "node3", "node6" };
		String[] nodeOrderWayBack = { "node1", "node4", "node2", "node2", "node3", "node6", "node3", "node6" };
		TraverserChecker checker = new TraverserChecker();
		checker.nodeOrderWayThere = nodeOrderWayThere;
		checker.nodeOrderWayBack = nodeOrderWayBack;
		getFixture().setGraph(graph);
		getFixture().traverse(getFixture().getGraph().getRoots(), GRAPH_TRAVERSE_TYPE.TOP_DOWN_BREADTH_FIRST,
				"test_TOP_DOWN_BREADTH_FIRST_DAG", checker, false);
		assertTrue(checker.checkNumberOfTraversedNodes());
	}

	/**
	 * Tests the traversing of
	 * {@link GRAPH_TRAVERSE_TYPE#TOP_DOWN_BREADTH_FIRST} of graph_DAG, with
	 * graph {@inheritDoc SGraphTest#createGraph_DAG()}. Starting with a node
	 * that is not a root node
	 */
	@Test
	public void testTraverse_TOP_DOWN_BREADTH_FIRST_DAG_NON_ROOT_START() {
		SGraph graph = TestHelper.createDag();
		String[] nodeOrderWayThere = { "node2", "node3", "node6" };
		String[] nodeOrderWayBack = { "node2", "node3", "node6" };
		TraverserChecker checker = new TraverserChecker();
		checker.nodeOrderWayThere = nodeOrderWayThere;
		checker.nodeOrderWayBack = nodeOrderWayBack;
		getFixture().setGraph(graph);
		List<SNode> startNodes = (new ArrayList<>());
		startNodes.add(getFixture().getGraph().getNode("node2"));
		getFixture().traverse(startNodes, GRAPH_TRAVERSE_TYPE.TOP_DOWN_BREADTH_FIRST, "test_TOP_DOWN_BREADTH_FIRST_DAG",
				checker, false);
		assertTrue(checker.checkNumberOfTraversedNodes());
	}

	/**
	 * Tests the traversing of
	 * {@link GRAPH_TRAVERSE_TYPE#TOP_DOWN_BREADTH_FIRST} of graph_DAG, with
	 * graph {@inheritDoc SGraphTest#createGraph_DAG()}. Starting with a node
	 * that is not a root node
	 */
	@Test
	public void testTraverse_TOP_DOWN_DEPTH_FIRST_DAG_NON_ROOT_START() {
		SGraph graph = TestHelper.createDag();
		String[] nodeOrderWayThere = { "node2", "node3", "node6" };
		String[] nodeOrderWayBack = { "node3", "node6", "node2" };
		TraverserChecker checker = new TraverserChecker();
		checker.nodeOrderWayThere = nodeOrderWayThere;
		checker.nodeOrderWayBack = nodeOrderWayBack;
		getFixture().setGraph(graph);
		List<SNode> startNode = (new ArrayList<>());
		startNode.add(getFixture().getGraph().getNode("node2"));
		getFixture().traverse(startNode, GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST,
				"test_TOP_DOWN_DEPTH_FIRST_DAG_NON_ROOT_START", checker);
		assertTrue(checker.checkNumberOfTraversedNodes());
	}

	/**
	 * Tests the traversing of
	 * {@link GRAPH_TRAVERSE_TYPE#TOP_DOWN_BREADTH_FIRST} of graph_DAG, with
	 * graph {@inheritDoc SGraphTest#createGraph_DAG()}. Starting with a node
	 * that is not a root node
	 */
	@Test
	public void testTraverse_TOP_DOWN_DEPTH_FIRST_NO_REAL_CYCLES() {
		SGraph graph = SaltFactory.createSGraph();
		graph.setId("graph1");
		SNode node1 = SaltFactory.createSNode();
		graph.add(node1);
		SNode node2 = SaltFactory.createSNode();
		graph.add(node2);
		SNode node3 = SaltFactory.createSNode();
		graph.add(node3);

		SRelation<SNode, SNode> edge1 = SaltFactory.createSRelation();
		edge1.setSource(node1);
		edge1.setTarget(node2);
		graph.add(edge1);
		SRelation<SNode, SNode> edge2 = SaltFactory.createSRelation();
		edge2.setSource(node2);
		edge2.setTarget(node3);
		graph.add(edge2);
		SRelation<SNode, SNode> edge3 = SaltFactory.createSRelation();
		edge3.setSource(node3);
		edge3.setTarget(node2);
		Label label = GraphFactory.createLabel();
		label.setName("name");
		label.setValue("notCheck");
		edge3.add(label);
		graph.add(edge3);

		GraphTraverseHandler graphTraverseHandler = new GraphTraverseHandler() {
			@Override
			public void nodeReached(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode,
					SRelation<? extends SNode, ? extends SNode> relation, SNode fromNode, long order) {
			}

			@Override
			public void nodeLeft(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode,
					SRelation<? extends SNode, ? extends SNode> relation, SNode fromNode, long order) {
			}

			@Override
			public boolean checkConstraint(GRAPH_TRAVERSE_TYPE traversalType, String traversalId,
					SRelation<? extends SNode, ? extends SNode> relation, SNode currNode, long order) {
				if ((relation != null) && (relation.getLabel("name") != null)
						&& (relation.getLabel("name").getValue().equals("notCheck"))) {
					return false;
				} else {
					return true;
				}

			}
		};
		getFixture().setGraph(graph);

		List<SNode> startNode = (new ArrayList<>());
		startNode.add(node1);
		getFixture().traverse(startNode, GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST,
				"test_TOP_DOWN_DEPTH_FIRST_NO_REAL_CYCLES", graphTraverseHandler);
	}

	/**
	 * Tests the traversing of
	 * {@link GRAPH_TRAVERSE_TYPE#TOP_DOWN_BREADTH_FIRST} of graph_Tree, with
	 * graph {@inheritDoc SGraphTest#createGraph_SimpleCycle()}.
	 */
	@Test
	public void testTraverse_TOP_DOWN_BREADTH_FIRST_CycleUnsafe() {
		SGraph graph = TestHelper.createCycledTree();
		String[] nodeOrderWayThere = { "node1", "node2", "node3", "node6", "node7", "node2", "node3", "node6",
				"node7" };
		String[] nodeOrderWayBack = nodeOrderWayThere.clone();
		TraverserChecker checker = new TraverserChecker();
		checker.nodeOrderWayThere = nodeOrderWayThere;
		checker.nodeOrderWayBack = nodeOrderWayBack;
		checker.isCycleSafe = false;
		getFixture().setGraph(graph);
		getFixture().traverse(getFixture().getGraph().getRoots(), GRAPH_TRAVERSE_TYPE.TOP_DOWN_BREADTH_FIRST,
				"test_TOP_DOWN_BREADTH_FIRST_Cycle", checker, false);
		assertTrue(checker.checkNumberOfTraversedNodes());
	}

	/**
	 * Tests the traversing of
	 * {@link GRAPH_TRAVERSE_TYPE#BOTTOM_UP_BREADTH_FIRST} of graph_Tree, with
	 * tree {@inheritDoc SGraphTest#createGraph_Tree()}.
	 */
	@Test
	public void testTraverse_BOTTOM_UP_BREADTH_FIRST_Tree() {
		SGraph graph = TestHelper.createTree();
		String[] nodeOrderWayThere = { "node3", "node5", "node6", "node7", "node2", "node4", "node2", "node1", "node1",
				"node1", "node1" };
		String[] nodeOrderWayBack = nodeOrderWayThere.clone();

		TraverserChecker checker = new TraverserChecker();
		checker.nodeOrderWayThere = nodeOrderWayThere;
		checker.nodeOrderWayBack = nodeOrderWayBack;
		getFixture().setGraph(graph);
		getFixture().traverse(getFixture().getGraph().getLeafs(), GRAPH_TRAVERSE_TYPE.BOTTOM_UP_BREADTH_FIRST,
				"test_BOTTOM_UP_BREADTH_FIRST_Tree", checker, false);
		assertTrue(checker.checkNumberOfTraversedNodes());
	}

	/**
	 * Tests the traversing of
	 * {@link GRAPH_TRAVERSE_TYPE#BOTTOM_UP_BREADTH_FIRST} of graph_DAG, with
	 * graph {@inheritDoc SGraphTest#createGraph_DAG()}.
	 */
	@Test
	public void testTraverse_BOTTOM_UP_BREADTH_FIRST_DAG() {
		SGraph graph = TestHelper.createDag();
		String[] nodeOrderWayThere = { "node3", "node6", "node2", "node2", "node1", "node4", "node1", "node4" };
		String[] nodeOrderWayBack = nodeOrderWayThere.clone();
		TraverserChecker checker = new TraverserChecker();
		checker.nodeOrderWayThere = nodeOrderWayThere;
		checker.nodeOrderWayBack = nodeOrderWayBack;
		getFixture().setGraph(graph);
		getFixture().traverse(getFixture().getGraph().getLeafs(), GRAPH_TRAVERSE_TYPE.BOTTOM_UP_BREADTH_FIRST,
				"test_BOTTOM_UP_BREADTH_FIRST_DAG", checker, false);
		assertTrue(checker.checkNumberOfTraversedNodes());
	}

	/**
	 * Tests the traversing of
	 * {@link GRAPH_TRAVERSE_TYPE#BOTTOM_UP_BREADTH_FIRST} of graph_Cycle, with
	 * graph {@inheritDoc SGraphTest#createGraph_Cycle()}.
	 */
	@Test
	public void testTraverse_BOTTOM_UP_BREADTH_FIRST_Cycle() {
		SGraph graph = TestHelper.createCycledDag();
		{
			String[] nodeOrderWayThere = { "node3", "node2", "node1", "node4" };
			String[] nodeOrderWayBack = { "node3", "node2", "node1", "node4" };
			TraverserChecker checker = new TraverserChecker();
			checker.nodeOrderWayThere = nodeOrderWayThere;
			checker.nodeOrderWayBack = nodeOrderWayBack;
			getFixture().setGraph(graph);
			try {
				getFixture().traverse(getFixture().getGraph().getLeafs(), GRAPH_TRAVERSE_TYPE.BOTTOM_UP_BREADTH_FIRST,
						"test_BOTTOM_UP_BREADTH_FIRST_Cycle", checker);
				assertTrue(checker.checkNumberOfTraversedNodes());
				fail("The graph contains a cycle, that shall invoke an exception.");
			} catch (SaltException e) {
			}
		}
		{
			List<SNode> startNodes = new ArrayList<>();
			startNodes.add(graph.getNode("node3"));
			startNodes.add(graph.getNode("node7"));
			String[] nodeOrderWayThere = { "node3", "node7", "node2", "node6", "node1", "node4", "node7" };
			String[] nodeOrderWayBack = { "node3", "node7", "node2", "node6", "node1", "node4", "node7" };
			TraverserChecker checker = new TraverserChecker();
			checker.nodeOrderWayThere = nodeOrderWayThere;
			checker.nodeOrderWayBack = nodeOrderWayBack;
			getFixture().setGraph(graph);
			getFixture().setGraph(graph);
			try {
				getFixture().traverse(startNodes, GRAPH_TRAVERSE_TYPE.BOTTOM_UP_BREADTH_FIRST,
						"test_BOTTOM_UP_BREADTH_FIRST_Cycle", checker);
				assertTrue(checker.checkNumberOfTraversedNodes());
				fail("The graph contains a cycle, that shall invoke an exception.");
			} catch (SaltException e) {
			}
		}
	}

	/**
	 * Tests the traversing of
	 * {@link GRAPH_TRAVERSE_TYPE#BOTTOM_UP_BREADTH_FIRST} of graph_Tree, with
	 * graph {@inheritDoc SGraphTest#createGraph_SimpleCycle()}.
	 */
	@Test
	public void testTraverse_BOTTOM_UP_BREADTH_FIRST_CycleUnsafe() {
		SGraph graph = TestHelper.createCycledTree();
		List<SNode> startNodes = new ArrayList<>();
		startNodes.add(graph.getNode("node3"));
		startNodes.add(graph.getNode("node7"));
		String[] nodeOrderWayThere = { "node3", "node7", "node2", "node6", "node1", "node7", "node2", "node6",
				"node1" };
		String[] nodeOrderWayBack = nodeOrderWayThere.clone();
		TraverserChecker checker = new TraverserChecker();
		checker.nodeOrderWayThere = nodeOrderWayThere;
		checker.nodeOrderWayBack = nodeOrderWayBack;
		checker.isCycleSafe = false;
		getFixture().setGraph(graph);
		getFixture().traverse(startNodes, GRAPH_TRAVERSE_TYPE.BOTTOM_UP_BREADTH_FIRST,
				"test_BOTTOM_UP_BREADTH_FIRST_Cycle", checker, false);
		assertTrue(checker.checkNumberOfTraversedNodes());
	}
}
