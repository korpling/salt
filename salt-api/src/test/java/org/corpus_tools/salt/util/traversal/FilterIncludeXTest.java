package org.corpus_tools.salt.util.traversal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.corpus_tools.salt.util.traversal.TraversalFilter.includeSpans;
import static org.corpus_tools.salt.util.traversal.TraversalFilter.includeStructures;
import static org.corpus_tools.salt.util.traversal.TraversalFilter.includeTextualDs;
import static org.corpus_tools.salt.util.traversal.TraversalFilter.includeTokens;

import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.common.SSpan;
import org.corpus_tools.salt.common.SStructure;
import org.corpus_tools.salt.common.STextualDS;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.samples.SampleGenerator;
import org.corpus_tools.salt.util.SaltUtil;
import org.junit.Test;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

public class FilterIncludeXTest {
	private Multimap<Class<? extends SNode>, SNode> visitedNodes = HashMultimap.create();
	private SDocumentGraph documentStructure = SampleGenerator.createDocumentStructure().getDocumentGraph();
	private final BackAndForthTraverseHandler traversalHandler = new BackAndForthTraverseHandler() {
		@Override
		public boolean shouldTraversalGoOn(TraversalLocation location) {
			return true;
		}

		@Override
		public void nodeReachedOnWayForth(TraversalLocation location) {
			if (location.getCurrentNode() instanceof STextualDS) {
				visitedNodes.put(STextualDS.class, location.getCurrentNode());
			} else if (location.getCurrentNode() instanceof SToken) {
				visitedNodes.put(SToken.class, location.getCurrentNode());
			} else if (location.getCurrentNode() instanceof SSpan) {
				visitedNodes.put(SSpan.class, location.getCurrentNode());
			} else if (location.getCurrentNode() instanceof SStructure) {
				visitedNodes.put(SStructure.class, location.getCurrentNode());
			}
		}

		@Override
		public void nodeReachedOnWayBack(TraversalLocation location) {
		}
	};

	@Test
	public void whenFilteringForStructures_onlyStructuresShouldBeVisited() {
		SaltUtil.traverse(documentStructure)
				.startFrom(documentStructure.getRoots())
				.useStrategy(TraversalStrategy.TOP_DOWN_DEPTH_FIRST)
				.filter(includeStructures())
				.andCall(traversalHandler);
		assertThat(visitedNodes.get(SStructure.class)).hasSize(12);
		assertThat(visitedNodes.get(SSpan.class)).isEmpty();
		assertThat(visitedNodes.get(SToken.class)).isEmpty();
		assertThat(visitedNodes.get(STextualDS.class)).isEmpty();
	}

	@Test
	public void whenFilteringForSpans_onlySpansShouldBeVisited() {
		SaltUtil.traverse(documentStructure)
				.startFrom(documentStructure.getRoots())
				.useStrategy(TraversalStrategy.TOP_DOWN_DEPTH_FIRST)
				.filter(includeSpans())
				.andCall(traversalHandler);
		assertThat(visitedNodes.get(SStructure.class)).isEmpty();
		assertThat(visitedNodes.get(SSpan.class)).hasSize(2);
		assertThat(visitedNodes.get(SToken.class)).isEmpty();
		assertThat(visitedNodes.get(STextualDS.class)).isEmpty();
	}

	@Test
	public void whenFilteringForTextualDs_onlyTextualDsShouldBeVisited() {
		SaltUtil.traverse(documentStructure)
				.startFrom(documentStructure.getLeafs())
				.useStrategy(TraversalStrategy.BOTTOM_UP_DEPTH_FIRST)
				.filter(includeTextualDs())
				.andCall(traversalHandler);
		assertThat(visitedNodes.get(SStructure.class)).isEmpty();
		assertThat(visitedNodes.get(SSpan.class)).isEmpty();
		assertThat(visitedNodes.get(SToken.class)).isEmpty();
		assertThat(visitedNodes.get(STextualDS.class)).hasSize(1);
	}

	@Test
	public void whenFilteringForTextualDsAndTokens_onlyTextualDsAndTokensShouldBeVisited() {
		SaltUtil.traverse(documentStructure)
				.startFrom(documentStructure.getLeafs())
				.useStrategy(TraversalStrategy.BOTTOM_UP_DEPTH_FIRST)
				.filter(includeTextualDs())
				.filter(includeTokens())
				.andCall(traversalHandler);
		assertThat(visitedNodes.get(SStructure.class)).isEmpty();
		assertThat(visitedNodes.get(SSpan.class)).isEmpty();
		assertThat(visitedNodes.get(SToken.class)).hasSize(11);
		assertThat(visitedNodes.get(STextualDS.class)).hasSize(1);
	}

	@Test
	public void whenFilteringForAllNodes_allNodesShouldBeVisited() {
		SaltUtil.traverse(documentStructure)
				.startFrom(documentStructure.getLeafs())
				.useStrategy(TraversalStrategy.BOTTOM_UP_DEPTH_FIRST)
				.filter(includeStructures())
				.filter(includeTextualDs())
				.filter(includeTokens())
				.filter(includeSpans())
				.andCall(traversalHandler);
		assertThat(visitedNodes.get(STextualDS.class)).hasSize(1);
		assertThat(visitedNodes.get(SToken.class)).hasSize(11);
		assertThat(visitedNodes.get(SSpan.class)).hasSize(3);
		assertThat(visitedNodes.get(SStructure.class)).hasSize(12);
	}
}
