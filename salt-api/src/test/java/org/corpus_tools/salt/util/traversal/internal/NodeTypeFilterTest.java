package org.corpus_tools.salt.util.traversal.internal;

import static org.assertj.core.api.Assertions.assertThat;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SSpan;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.util.traversal.TraversalLocation;
import org.corpus_tools.salt.util.traversal.TraversalStrategy;
import org.corpus_tools.salt.util.traversal.internal.NodeTypeFilter;
import org.junit.Test;

public class NodeTypeFilterTest {
	private final TraversalLocation location = TraversalLocation
			.createWithStrategy(TraversalStrategy.BOTTOM_UP_BREADTH_FIRST)
			.withCurrentNode(SaltFactory.createSToken())
			.build();

	@Test(expected = IllegalArgumentException.class)
	public void whenTraversalLocationIsEmpty_returnFalse() {
		NodeTypeFilter nodeTypeFilter = new NodeTypeFilter(SToken.class);
		nodeTypeFilter.test(null);
	}

	@Test
	public void whenTestingSupportedNodeType_returnTrue() {
		NodeTypeFilter nodeTypeFilter = new NodeTypeFilter(SToken.class);
		assertThat(nodeTypeFilter.test(location)).isTrue();
	}

	@Test
	public void whenTestingUnSupportedNodeType_returnFalse() {
		NodeTypeFilter nodeTypeFilter = new NodeTypeFilter(SSpan.class);
		assertThat(nodeTypeFilter.test(location)).isFalse();
	}
}
