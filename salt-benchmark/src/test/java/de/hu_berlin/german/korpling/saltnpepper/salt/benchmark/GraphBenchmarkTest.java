package de.hu_berlin.german.korpling.saltnpepper.salt.benchmark;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import com.carrotsearch.junitbenchmarks.annotation.AxisRange;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkHistoryChart;
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkMethodChart;
import com.carrotsearch.junitbenchmarks.annotation.LabelType;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;

/**
 *
 * @author Florian Zipser
 */
@BenchmarkOptions(callgc = false, benchmarkRounds = 5, warmupRounds = 5)
@BenchmarkMethodChart(filePrefix = "graph-benchmark")
@BenchmarkHistoryChart(labelWith = LabelType.RUN_ID, maxRuns = 20)
@AxisRange(min = 0.0)
public class GraphBenchmarkTest {
	Runtime runtime= Runtime.getRuntime();;
	long mem= 0;
	int mb = 1024*1024;
	@Before
	public void setUp(){
		mem= (runtime.totalMemory() - runtime.freeMemory()) / mb;
	}
	@After
	public void tearDown(){
		mem= ((runtime.totalMemory() - runtime.freeMemory()) / mb) - mem;
		System.out.println("used memory: "+ mem +"mb");
	}
	
	@Rule
	public TestRule benchmarkRun = new BenchmarkRule();
	
	@Test
	public void createNodes() {
		Graph graph = GraphFactory.eINSTANCE.createGraph();
		Node node = null;
		for (int i = 0; i < 100000; i++) {
			node = GraphFactory.eINSTANCE.createNode();
			node.setId("node_" + i);
			graph.addNode(node);
		}
	}

	@Test
	public void createNodesLabels() {
		Graph graph = GraphFactory.eINSTANCE.createGraph();
		Node node = null;
		Label label = null;
		for (int i = 0; i < 100000; i++) {
			node = GraphFactory.eINSTANCE.createNode();
			node.setId("node_" + i);
			graph.addNode(node);
			for (int l = 0; l < 2; l++) {
				label = GraphFactory.eINSTANCE.createLabel();
				label.setNamespace("namespace");
				label.setName("name"+l);
				label.setValue("value");
				node.addLabel(label);
			}
		}
	}

	@Test
	public void benchmarkCreateNodesAndEdges() {
		Graph graph = GraphFactory.eINSTANCE.createGraph();
		Node node = null;
		for (int i = 0; i < 100000; i++) {
			node = GraphFactory.eINSTANCE.createNode();
			node.setId("node_" + i);
			graph.addNode(node);
		}

		Random randomGenerator = new Random();
		Edge edge = null;
		for (int i = 0; i < 200000; i++) {
			int source = randomGenerator.nextInt(100000);
			int target = randomGenerator.nextInt(100000);
			Node sourceNode = graph.getNode("node_" + source);
			Node targetNode = graph.getNode("node_" + target);
			edge = GraphFactory.eINSTANCE.createEdge();
			edge.setSource(sourceNode);
			edge.setTarget(targetNode);
			graph.addEdge(edge);
		}
	}
}
