package org.corpus_tools.salt.util.internal.traversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SNode;

public class Traverser {
	protected final SGraph graph;
	protected final List<SNode> startNodes = new ArrayList<>();
	protected final TraversalStrategy strategy;
	protected final boolean isCycleSafe;
	protected final String traverseId;
	protected final BackAndForthTraverseHandler traverseHandler;

	public Traverser(BackAndForthTraverseHandler traverseHandler, SGraph graph, TraversalStrategy strategy,
			boolean isCycleSafe, String traverseId) {
		this.traverseHandler = traverseHandler;
		this.graph = graph;
		this.strategy = strategy;
		this.isCycleSafe = isCycleSafe;
		this.traverseId = traverseId;
	}

	public void traverse() {
	}

	public class Builder {
		private final SGraph graph;
		private final List<SNode> startNodes = new ArrayList<>();
		private TraversalStrategy traverseStrategy;
		boolean isCycleSafeprivate;
		private String traverseId;

		public Builder(SGraph graph) {
			this.graph = graph;
		}

		public Builder useStrategy(TraversalStrategy traverseStrategy) {
			this.traverseStrategy = traverseStrategy;
			return this;
		}

		public Builder cycleSafe(boolean isCycleSafe) {
			this.isCycleSafeprivate = isCycleSafe;
			return this;
		}

		public Builder useId(String traverseId) {
			this.traverseId = traverseId;
			return this;
		}

		public Builder startFrom(SNode... startNodes) {
			this.startNodes.addAll(Arrays.asList(startNodes));
			return this;
		}

		public void andCall(SimpleTraverseHandler traverseHandler) {

		}

		public void andCall(BackAndForthTraverseHandler traverseHandler) {
			new Traverser(traverseHandler, graph, traverseStrategy, isCycleSafeprivate, traverseId).traverse();
		}
	}
}
