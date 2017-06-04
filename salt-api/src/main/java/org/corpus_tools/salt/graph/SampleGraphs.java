package org.corpus_tools.salt.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;

public class SampleGraphs {
	private final Map<String, SNode> nameToNode = new HashMap<>();
	private final SGraph graph = SaltFactory.createSGraph();

	private void createFromPaths(String... paths) {
		if (paths == null || paths.length == 0) {
			return;
		}
		Arrays.asList(paths).stream().forEach(path -> createFromPath(path.split("/")));
		return;
	}

	private void createFromPath(String... nodes) {
		Optional<SNode> lastNode = Optional.empty();
		for (String nodeName : nodes) {
			SNode currNode = Optional.ofNullable(nameToNode.get(nodeName))
					.orElseGet(() -> createAndAddNodeWithName(nodeName));
			lastNode.ifPresent(from -> graph.add(createEdge(from, currNode)));
			lastNode = Optional.ofNullable(currNode);
		}

	}

	private SRelation<SNode, SNode> createEdge(SNode from, SNode to) {
		SRelation<SNode, SNode> rel = SaltFactory.createSRelation();
		rel.setSource(from);
		rel.setTarget(to);
		return rel;
	}

	private SNode createAndAddNodeWithName(String name) {
		SNode node = SaltFactory.createSNode();
		node.setName(name);
		nameToNode.put(name, node);
		graph.add(node);
		return node;
	}

	private static Builder create() {
		return new Builder();
	}

	private static class Builder {
		private SampleGraphs sampleGraph = new SampleGraphs();

		private Builder withName(String name) {
			sampleGraph.graph.setName(name);
			return this;
		}

		private Builder fromPath(String... paths) {
			sampleGraph.createFromPaths(paths);
			return this;
		}

		private SGraph build() {
			return sampleGraph.graph;
		}
	}

	/**
	 * <pre>
	 *              n1             
	 *          /   |  \  
	 *        n2    n5  n7
	 *       / \    |         
	 *    n3    n4  n6
	 * </pre>
	 **/
	public static SGraph createTree() {
		return create().withName("tree").fromPath("n1/n2/n3", "n2/n4", "n1/n5/n6", "n1/n7").build();
	}

	/**
	 * <pre>
	 *    n1    n4
	 *     \   /
	 *       n2      
	 *     /   \
	 *    n3    n6
	 * </pre>
	 **/
	public static SGraph createDag() {
		return create().withName("dag").fromPath("n1/n2/n3", "n4/n2/n6").build();
	}

	/**
	 * <pre>
	 *    n1    n4
	 *     \   /
	 *       n2      
	 *     /   \
	 *    n3    n6
	 *           \ 
	 *           n7
	 *           
	 * n7 -> n2
	 * </pre>
	 **/
	public static SGraph createCycledDag() {
		return create().withName("cycled-dag").fromPath("n1/n2/n3", "n4/n2/n6/n7/n2").build();
	}

	/**
	 * <pre>
	 *       n1
	 *       |
	 *       n2      
	 *     /   \
	 *    n3    n6
	 *           \ 
	 *           n7
	 *           
	 * n7 -> n2
	 * </pre>
	 **/
	public static SGraph createCycledTree() {
		return create().withName("cycled-tree").fromPath("n1/n2/n3", "n2/n6/n7/n2").build();
	}

	/**
	 * <pre>
	 *        n1
	 *        ^ \
	 *       /   V
	 *     n3 <- n2
	 * 
	 * </pre>
	 **/
	public static SGraph createPureCycle() {
		return create().withName("pure-cycle").fromPath("n1/n2/n3/n1").build();
	}
}
