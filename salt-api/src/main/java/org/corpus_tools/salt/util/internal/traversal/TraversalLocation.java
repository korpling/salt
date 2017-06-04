package org.corpus_tools.salt.util.internal.traversal;

import java.util.Optional;

import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;

public class TraversalLocation {
	private final TraversalStrategy traversalStrategy;
	private final SNode currentNode;
	private final SRelation<? extends SNode, ? extends SNode> fromRelation;
	private final long relationOrder;
	private final SNode fromNode;
	private final String traversalId;

	public TraversalLocation(TraversalStrategy traversalStrategy, String traversalId, SNode currentNode,
			SRelation<? extends SNode, ? extends SNode> fromRelation, SNode fromNode, long relationOrder) {
		this.traversalStrategy = traversalStrategy;
		this.traversalId = traversalId;
		this.currentNode = currentNode;
		this.fromRelation = fromRelation;
		this.fromNode = fromNode;
		this.relationOrder = relationOrder;
	}

	public TraversalStrategy getTraversalStrategy() {
		return traversalStrategy;
	}

	public SNode getCurrentNode() {
		return currentNode;
	}

	public long getRelationOrder() {
		return relationOrder;
	}

	public Optional<String> getTraversalId() {
		return Optional.ofNullable(traversalId);
	}

	public Optional<SRelation<? extends SNode, ? extends SNode>> getFromRelation() {
		return Optional.ofNullable(fromRelation);
	}

	public Optional<SNode> getFromNode() {
		return Optional.ofNullable(fromNode);
	}

	public static StrategyBuilder create() {
		return new StrategyBuilder();
	}

	public static class StrategyBuilder {
		public CurrentNodeBuilder withTraversalStrategy(TraversalStrategy traversalStrategy) {
			return new CurrentNodeBuilder(traversalStrategy);
		}
	}

	public static class CurrentNodeBuilder {
		private final TraversalStrategy traversalStrategy;

		public CurrentNodeBuilder(TraversalStrategy traversalStrategy) {
			this.traversalStrategy = traversalStrategy;
		}

		public Builder withCurrentNode(SNode currentNode) {
			return new Builder(traversalStrategy, currentNode);
		}
	}

	public static class Builder {
		private final TraversalStrategy traversalStrategy;
		private final SNode currentNode;
		private SRelation<? extends SNode, ? extends SNode> fromRelation;
		private long relationOrder;
		private SNode fromNode;
		private String traversalId;

		public Builder(TraversalStrategy traversalStrategy, SNode currentNode) {
			this.traversalStrategy = traversalStrategy;
			this.currentNode = currentNode;
		}

		public Builder withFromRelation(SRelation<? extends SNode, ? extends SNode> fromRelation) {
			this.fromRelation = fromRelation;
			return this;
		}

		public Builder withRelationOrder(long relationOrder) {
			this.relationOrder = relationOrder;
			return this;
		}

		public Builder withFromNode(SNode fromNode) {
			this.fromNode = fromNode;
			return this;
		}

		public Builder withTraversalId(String traversalId) {
			this.traversalId = traversalId;
			return this;
		}

		public TraversalLocation build() {
			return new TraversalLocation(traversalStrategy, traversalId, currentNode, fromRelation, fromNode,
					relationOrder);
		}
	}
}
