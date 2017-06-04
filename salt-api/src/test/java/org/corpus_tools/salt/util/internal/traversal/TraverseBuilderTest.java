package org.corpus_tools.salt.util.internal.traversal;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.core.GraphTraverseHandler;
import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SGraph.GRAPH_TRAVERSE_TYPE;
import org.corpus_tools.salt.core.SNode;
import org.junit.Test;

public class TraverseBuilderTest {
	SGraph graph = SaltFactory.createSGraph();

	@Test
	public void testTraverseParameters() {
		List<SNode> startNodes = null;
		GRAPH_TRAVERSE_TYPE traverseType = null;
		GraphTraverseHandler handler = null;

		{// test 1
			startNodes = null;
			traverseType = GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST;
			handler = new MyTraverseHandler();

			try {
				graph.traverse(startNodes, traverseType, "test_TOP_DOWN_DEPTH_FIRST_Tree", handler);
				fail("null parameters are not allowed");
			} catch (Exception e) {
			}
		} // test 1

		{// test 2
			startNodes = new ArrayList<SNode>();
			startNodes.add(SaltFactory.createSNode());
			traverseType = null;
			handler = new MyTraverseHandler();

			try {
				graph.traverse(startNodes, traverseType, "test_TOP_DOWN_DEPTH_FIRST_Tree", handler);
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
				graph.traverse(startNodes, traverseType, "test_TOP_DOWN_DEPTH_FIRST_Tree", handler);
				fail("null parameters are not allowed");
			} catch (Exception e) {
			}
		} // test 3
	}
}
