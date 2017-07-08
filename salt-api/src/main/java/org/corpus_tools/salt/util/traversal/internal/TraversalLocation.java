package org.corpus_tools.salt.util.traversal.internal;

import java.util.Optional;

import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.util.traversal.TraversalStrategy;

public class TraversalLocation {
	private final TraversalStrategy strategy;
	private final SNode currentNode;
	private final SRelation<? extends SNode, ? extends SNode> fromRelation;
	private final int relationOrder;
	private final SNode fromNode;
	private final String id;

	public TraversalLocation(TraversalStrategy strategy, String id, SNode currentNode,
			SRelation<? extends SNode, ? extends SNode> fromRelation, SNode fromNode, int relationOrder) {
		this.strategy = strategy;
		this.id = id;
		this.currentNode = currentNode;
		this.fromRelation = fromRelation;
		this.fromNode = fromNode;
		this.relationOrder = relationOrder;
	}

	public TraversalStrategy getStrategy() {
		return strategy;
	}

	public SNode getCurrentNode() {
		return currentNode;
	}

	public long getRelationOrder() {
		return relationOrder;
	}

	public Optional<String> getId() {
		return Optional.ofNullable(id);
	}

	public Optional<SRelation<? extends SNode, ? extends SNode>> getFromRelation() {
		return Optional.ofNullable(fromRelation);
	}

	public Optional<SNode> getFromNode() {
		return Optional.ofNullable(fromNode);
	}

	public static CurrentNodeBuilder createWithStrategy(TraversalStrategy strategy) {
		return new CurrentNodeBuilder(strategy);
	}

	public static class CurrentNodeBuilder {
		private final TraversalStrategy strategy;

		public CurrentNodeBuilder(TraversalStrategy strategy) {
			this.strategy = strategy;
		}

		public Builder withCurrentNode(SNode currentNode) {
			return new Builder(strategy, currentNode);
		}
	}

	public static class Builder {
		private final TraversalStrategy strategy;
		private final SNode currentNode;
		private SRelation<? extends SNode, ? extends SNode> fromRelation;
		private int relationOrder;
		private SNode fromNode;
		private String id;

		public Builder(TraversalStrategy strategy, SNode currentNode) {
			this.strategy = strategy;
			this.currentNode = currentNode;
		}

		public Builder withFromRelation(SRelation<? extends SNode, ? extends SNode> fromRelation) {
			this.fromRelation = fromRelation;
			return this;
		}

		public Builder withRelationOrder(int relationOrder) {
			this.relationOrder = relationOrder;
			return this;
		}

		public Builder withFromNode(SNode fromNode) {
			this.fromNode = fromNode;
			return this;
		}

		public Builder withId(String id) {
			this.id = id;
			return this;
		}

		public TraversalLocation build() {
			return new TraversalLocation(strategy, id, currentNode, fromRelation, fromNode, relationOrder);
		}
	}
}
