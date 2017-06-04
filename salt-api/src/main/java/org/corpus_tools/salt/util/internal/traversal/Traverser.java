package org.corpus_tools.salt.util.internal.traversal;

import org.corpus_tools.salt.core.SGraph.GRAPH_TRAVERSE_TYPE;
import org.corpus_tools.salt.core.SNode;

public class Traverser {

	public class Builder {
		private GRAPH_TRAVERSE_TYPE traverseStrategy;

		public Builder useStrategy(GRAPH_TRAVERSE_TYPE traverseStrategy) {
			return this;
		}

		public Builder cycleSafe(boolean isCycleSafe) {
			return this;
		}

		public Builder useId(String traverseId) {
			return this;
		}

		public Builder startFrom(SNode... startNodes) {
			return this;
		}

		public void andCall(SimpleTraverseHandler traverseHandler) {
		}

		public void andCall(BackAndForthTraverseHandler traverseHandler) {
		}
	}
}
