package org.corpus_tools.salt.util.internal.traversal;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SGraph.GRAPH_TRAVERSE_TYPE;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.graph.SampleGraphs;
import org.junit.Test;

public class MultiThreadedTraverseTest {
	private SGraph graph;
	private List<SNode> startNodes;
	private GRAPH_TRAVERSE_TYPE traverseType;
	private boolean isCycleSafe = false;
	private List<String> expectedNodeOrderWayThere = new ArrayList<>();
	private List<String> expectedNodeOrderWayBack = new ArrayList<>();
	private static final int NUM_OF_THREADS = 20;
	private final List<MyTraverseHandler> traverseHandlers = new ArrayList<>();

	private void when() {
		for (int i = 0; i < NUM_OF_THREADS; i++) {
			traverseHandlers.add(new MyTraverseHandler());
		}
		traverseHandlers.parallelStream()
				.forEach(handler -> graph.traverse(startNodes, traverseType, "thred-test", handler, isCycleSafe));
	}

	private void then() {
		traverseHandlers.forEach(handler -> assertThat(handler.nodeOrderWayThere)
				.containsExactly(expectedNodeOrderWayThere.toArray(new String[expectedNodeOrderWayThere.size()])));
		traverseHandlers.forEach(handler -> assertThat(handler.nodeOrderWayBack)
				.containsExactly(expectedNodeOrderWayBack.toArray(new String[expectedNodeOrderWayBack.size()])));
	}

	@Test
	public void whenTraversingTreeMultithreadedInTopDownDepthFirstOrder() {
		// GIVEN
		graph = SampleGraphs.createTree();
		startNodes = graph.getRoots();
		traverseType = GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST;
		expectedNodeOrderWayThere = Arrays.asList("n1", "n2", "n3", "n4", "n5", "n6", "n7");
		expectedNodeOrderWayBack = Arrays.asList("n3", "n4", "n2", "n6", "n5", "n7", "n1");

		when();
		then();
	}

	@Test
	public void whenTraversingTreeMultithreadedInTopDownBreadthFirstOrder() {
		// GIVEN
		graph = SampleGraphs.createTree();
		startNodes = graph.getRoots();
		traverseType = GRAPH_TRAVERSE_TYPE.TOP_DOWN_BREADTH_FIRST;
		expectedNodeOrderWayThere = Arrays.asList("n1", "n2", "n5", "n7", "n3", "n4", "n6");
		expectedNodeOrderWayBack = Arrays.asList("n1", "n2", "n5", "n7", "n3", "n4", "n6");

		when();
		then();
	}

	@Test
	public void whenTraversingDagMultithreadedInBottomUpDepthFirstOrder() {
		// GIVEN
		graph = SampleGraphs.createDag();
		startNodes = graph.getLeafs();
		traverseType = GRAPH_TRAVERSE_TYPE.BOTTOM_UP_DEPTH_FIRST;
		expectedNodeOrderWayThere = Arrays.asList("n3", "n2", "n1", "n4", "n6", "n2", "n1", "n4");
		expectedNodeOrderWayBack = Arrays.asList("n1", "n4", "n2", "n3", "n1", "n4", "n2", "n6");

		when();
		then();
	}

	@Test
	public void whenTraversingTreeMultithreadedInBottomUpBreadthFirstOrder() {
		// GIVEN
		graph = SampleGraphs.createTree();
		startNodes = graph.getLeafs();
		traverseType = GRAPH_TRAVERSE_TYPE.BOTTOM_UP_BREADTH_FIRST;
		expectedNodeOrderWayThere = Arrays.asList("n3", "n4", "n6", "n7", "n2", "n2", "n5", "n1", "n1", "n1", "n1");
		expectedNodeOrderWayBack = Arrays.asList("n3", "n4", "n6", "n7", "n2", "n2", "n5", "n1", "n1", "n1", "n1");

		when();
		then();
	}
}
