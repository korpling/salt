package org.corpus_tools.salt.util.internal.traversal.backandforth;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.corpus_tools.salt.exceptions.SaltException;
import org.corpus_tools.salt.graph.SampleGraphs;
import org.corpus_tools.salt.util.traversal.TraversalStrategy;
import org.junit.Before;
import org.junit.Test;

public class BottomUpBreadthFirstTest extends TraverserTest {
	@Before
	public void beforeEach() {
		strategy = TraversalStrategy.BOTTOM_UP_BREADTH_FIRST;
	}

	@Test
	public void whenGraphIsTree() {
		// GIVEN
		graph = SampleGraphs.createTree();
		startNodes = graph.getLeafs();
		// WHEN
		when();
		// THEN
		assertThat(nodeOrderWayThere).containsExactly("n3", "n4", "n6", "n7", "n2", "n2", "n5", "n1", "n1", "n1", "n1");
		assertThat(nodeOrderWayBack).containsExactly("n3", "n4", "n6", "n7", "n2", "n2", "n5", "n1", "n1", "n1", "n1");
	}

	@Test
	public void whenGraphIsDag() {
		// GIVEN
		graph = SampleGraphs.createDag();
		startNodes = graph.getLeafs();
		// WHEN
		when();
		// THEN
		assertThat(nodeOrderWayThere).containsExactly("n3", "n6", "n2", "n2", "n1", "n4", "n1", "n4");
		assertThat(nodeOrderWayBack).containsExactly("n3", "n6", "n2", "n2", "n1", "n4", "n1", "n4");
	}

	@Test(expected = SaltException.class)
	public void whenCycleSafeIsEnabled() {
		// GIVEN
		graph = SampleGraphs.createCycledDag();
		startNodes = graph.getLeafs();
		isCycleSafe = true;
		// WHEN
		when();
	}

	@Test
	public void whenGraphIsCycledTree() {
		// GIVEN
		graph = SampleGraphs.createCycledTree();
		startNodes = Arrays.asList(graph.getNodeByName("n3").get(), graph.getNodeByName("n7").get());
		preventRunInCycle = true;
		// WHEN
		when();
		// THEN
		assertThat(nodeOrderWayThere).containsExactly("n3", "n7", "n2", "n6", "n1");
		assertThat(nodeOrderWayBack).containsExactly("n3", "n7", "n2", "n6", "n1");
	}
}
