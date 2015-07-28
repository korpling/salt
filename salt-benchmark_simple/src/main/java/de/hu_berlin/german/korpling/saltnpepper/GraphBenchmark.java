/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package de.hu_berlin.german.korpling.saltnpepper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.graph.Layer;
import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.graph.Relation;
import de.hu_berlin.u.saltnpepper.graph.impl.GraphFactory;
import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SGraph;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;

public class GraphBenchmark {

	public static final int NUM_OF_NODES = 10000;
	public static final int NUM_OF_RELATIONS = 10000;
	public static final int NUM_OF_LAYERS = 5;
	/** Number of nodes in layers relative to {@link #NUM_OF_NODES} **/
	public static final double NUM_OF_NODES_IN_LAYERS = 0.8;
	/** Number of relations in layers relative to {@link #NUM_OF_RELATIONS} **/
	public static final double NUM_OF_RELS_IN_LAYERS = 0.8;
	/** Number of labels per node/relation **/
	public static final double NUM_OF_LABELS = 3;

	/**
	 * Creates {@value #NUM_OF_NODES} nodes and adds them to the passed graph.
	 * Further each node gets {@value #NUM_OF_LABELS} labels.
	 * 
	 * @param graph
	 * @return
	 */
	protected List<Node> createNodes(Graph<Node, Relation<Node, Node>> graph) {
		List<Node> nodes = new ArrayList<>(NUM_OF_NODES);
		Node node = null;
		for (int i = 0; i < NUM_OF_NODES; i++) {
			node = GraphFactory.createNode();
			nodes.add(node);
			graph.addNode(node);

			// add labels
			for (int k = 0; k < NUM_OF_LABELS; k++) {
				Label<String> label = GraphFactory.createLabel();
				label.setNamespace("ns");
				label.setName("label_" + k);
				label.setValue("val_" + k);
				node.addLabel(label);
			}
		}
		return (nodes);
	}

	/**
	 * Creates {@value #NUM_OF_RELATIONS} relations and adds them to the passed
	 * graph. The source and target node is determined randomly by using the
	 * passed list of nodes. This method uses the extra list, to make the method
	 * independent on changes in the method {@link Graph#getNodes()}. Further
	 * each node gets {@value #NUM_OF_LABELS} labels.
	 * 
	 * @param graph
	 * @return
	 */
	protected List<Relation<Node, Node>> createRelations(Graph<Node, Relation<Node, Node>> graph, List<Node> nodes) {
		List<Relation<Node, Node>> rels = new ArrayList<>();

		Random random = new Random();
		Relation<Node, Node> rel = null;
		for (int i = 0; i < NUM_OF_RELATIONS; i++) {
			// TODO make this deterministic, by perhaps scrambling an array of
			// nodes
			int sourceNo = random.nextInt(NUM_OF_NODES);
			int targetNo = random.nextInt(NUM_OF_NODES);
			Node source = nodes.get(sourceNo);
			Node target = nodes.get(targetNo);
			rel = GraphFactory.createRelation();
			rel.setSource(source);
			rel.setTarget(target);
			rels.add(rel);
			graph.addRelation(rel);

			// add labels
			for (int k = 0; k < NUM_OF_LABELS; k++) {
				Label<String> label = GraphFactory.createLabel();
				label.setNamespace("ns");
				label.setName("label_" + k);
				label.setValue("val_" + k);
				rel.addLabel(label);
			}
		}
		return (rels);
	}

	/**
	 * Creates layers and inserts a number of nodes and edges.
	 * @param graph
	 * @param nodes
	 * @param rels
	 * @return
	 */
	protected List<Layer<Node, Relation<Node, Node>>> createLayers(Graph<Node, Relation<Node, Node>> graph, List<Node> nodes, List<Relation<Node, Node>> rels) {
		List<Layer<Node, Relation<Node, Node>>> layers = new ArrayList<>();
		Layer<Node, Relation<Node, Node>> layer = null;
		for (int i = 0; i < NUM_OF_LAYERS; i++) {
			layer = GraphFactory.createLayer();
			layers.add(layer);
			graph.addLayer(layer);

			// add nodes to layers
			int numLayers = new Double(NUM_OF_NODES * NUM_OF_NODES_IN_LAYERS / NUM_OF_LAYERS).intValue();
			for (int j = 0; j < numLayers; j++) {
				layer.addNode(nodes.get(j));
			}

			// add relations to layers
			numLayers = new Double(NUM_OF_RELATIONS * NUM_OF_RELS_IN_LAYERS / NUM_OF_LAYERS).intValue();
			for (int j = 0; j < numLayers; j++) {
				layer.addRelation(rels.get(j));
			}
		}
		return (layers);
	}

	/**
	 * Creates a graph and inserts {@value #NUM_OF_NODES},
	 * {@value #NUM_OF_RELATIONS} relations and {@value #NUM_OF_LAYERS} layers.
	 * Each node and relation gets {@value #NUM_OF_LABELS} labels. Each layer
	 * gets {@link #NUM_OF_NODES} * {@link #NUM_OF_NODES_IN_LAYERS} /
	 * {@value #NUM_OF_LAYERS} nodes and {@link #NUM_OF_RELATIONS} *
	 * {@link #NUM_OF_RELATIONS_IN_LAYERS} / {@value #NUM_OF_LAYERS} relations. <br/>
	 * This benchmark method benchmarks the methods:
	 * 
	 * <ul>
	 * <li>{@link Graph#addNode(Node)}</li>
	 * <li>{@link Graph#addRelation(Relation)}</li>
	 * <li>{@link Graph#addLayer(Layer)}</li>
	 * <li>{@link Node#addLabel(Label)}</li>
	 * <li>{@link Relation#addLabel(Label)}</li>
	 * </ul>
	 */
	@Benchmark
	public void insert() {
		Graph<Node, Relation<Node, Node>> graph = GraphFactory.createGraph();

		// create nodes
		List<Node> nodes = createNodes(graph);

		// create relations
		List<Relation<Node, Node>> rels = createRelations(graph, nodes);

		// create layers
		createLayers(graph, nodes, rels);
	}

	/**
	 * Benchmarks accessing the graph like getting a number of nodes and relations
	 * 
	 * 
	 * <ul>
	 * <li>{@link Graph#getNode(String)}</li>
	 * <li>{@link Graph#getInRelations(String)}</li>
	 * <li>{@link Graph#getOutRelations(String)}</li>
	 * <li>{@link Graph#getRelation(String)}</li>
	 * <li>{@link Graph#getLayer(String)}</li>
	 * </ul>
	 */
	@Benchmark
	public void access() {
		Graph<Node, Relation<Node, Node>> graph = GraphFactory.createGraph();
		// create nodes
		List<Node> nodes = createNodes(graph);
		// create relations
		List<Relation<Node, Node>> rels = createRelations(graph, nodes);
		// create layers
		List<Layer<Node, Relation<Node, Node>>> layers = createLayers(graph, nodes, rels);
		
		for (Node node: nodes){
			graph.getNode(node.getId());
			graph.getInRelations(node.getId());
			graph.getOutRelations(node.getId());
		}
		for (Relation<Node, Node> rel: rels){
			graph.getRelation(rel.getId());
		}
		for (Layer<Node, Relation<Node, Node>> layer: layers){
			graph.getLayer(layer.getId());
		}
	}
	
	/**
	 * Benchmarks the deletion of nodes, relations and layers in graph.
	 * <ul>
	 * <li>removes the half of all nodes with {@link Graph#removeNode(Node)}</li>
	 * <li>removes all relations with {@link Graph#removeRelation(Relation)}</li>
	 * <li>removes the rest of the nodes with {@link Graph#removeNode(Node)}</li>
	 * <li>removes all layers with {@link Graph#removeLayer(Layer)}</li>
	 * </ul>
	 */
	@Benchmark
	public void delete() {
		Graph<Node, Relation<Node, Node>> graph = GraphFactory.createGraph();
		// create nodes
		List<Node> nodes = createNodes(graph);
		// create relations
		List<Relation<Node, Node>> rels = createRelations(graph, nodes);
		// create layers
		List<Layer<Node, Relation<Node, Node>>> layers = createLayers(graph, nodes, rels);
		
		for (int i = 0; i< nodes.size()/2; i++){
			graph.removeNode(nodes.get(i));
		}
		for (Relation<Node, Node> rel: rels){
			graph.getRelation(rel.getId());
		}
		for (int i = nodes.size()/2; i< nodes.size(); i++){
			graph.removeNode(nodes.get(i));
		}
		for (Layer<Node, Relation<Node, Node>> layer: layers){
			graph.getLayer(layer.getId());
		}
	}
	
	/**
	 * 
	 * ============================== HOW TO RUN THIS TEST:
	 * You are expected to see the different run modes for the same benchmark.
	 * Note the units are different, scores are consistent with each other.
	 * You can run this test:
	 * a) Via the command line:
	 * $ mvn clean install
	 * $ java -jar target/benchmarks.jar GraphBenchmark -wi 5 -i 5 -f 1 -rf csv -rff GraphBenchmark.jmh.csv
	 * (we requested 5 warmup/measurement iterations, single fork)
	 * b) Via the Java API:
	 * (see the JMH homepage for possible caveats when running from IDE:
	 * http://openjdk.java.net/projects/code-tools/jmh/)
	 */

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder().include(GraphBenchmark.class.getSimpleName()).result(GraphBenchmark.class.getSimpleName() + ".jmh.csv").resultFormat(ResultFormatType.CSV).warmupIterations(5).measurementIterations(5).forks(3).build();
		new Runner(opt).run();
	}
}
