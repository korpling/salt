package org.corpus_tools.salt.util.internal;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.common.SSpan;
import org.corpus_tools.salt.common.SStructure;
import org.corpus_tools.salt.common.STextualDS;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.samples.SampleGenerator;
import org.corpus_tools.salt.util.DataSourceSequence;
import org.junit.Before;
import org.junit.Test;

public class GetXBySequenceTest {
	private GetXBySequence fixture;
	private SDocumentGraph documentGraph;

	@Before
	public void beforeEach() {
		final SDocument document = SaltFactory.createSDocument();
		SampleGenerator.createDocumentStructure(document);
		documentGraph = document.getDocumentGraph();
		fixture = new GetXBySequence(documentGraph);
	}

	@Test
	public void whenGettingAllNodesOverlappingAText_thenReturnAllNodes() {
		final List<SNode> expectedNodes = new ArrayList<>();
		expectedNodes.addAll(documentGraph.getTokens());
		expectedNodes.addAll(documentGraph.getSpans());
		expectedNodes.addAll(documentGraph.getStructures());
		final STextualDS overlappedText = documentGraph.getTextualDSs().get(0);

		final List<SNode> actualNodes = fixture.getNodeBySequence(
				new DataSourceSequence.Builder().on(overlappedText).from(0).to(overlappedText.getEnd()).build());

		assertThat(actualNodes).containsExactlyInAnyOrder(expectedNodes.toArray(new SNode[expectedNodes.size()]));
	}

	@Test
	public void whenGettingAllTokensOverlappingAText_thenReturnAllTokens() {
		final List<SToken> expectedTokens = new ArrayList<>();
		expectedTokens.addAll(documentGraph.getTokens());
		final STextualDS overlappedText = documentGraph.getTextualDSs().get(0);

		final List<SToken> actualNodes = fixture.getTokensBySequence(
				new DataSourceSequence.Builder().on(overlappedText).from(0).to(overlappedText.getEnd()).build());

		assertThat(actualNodes).containsExactlyInAnyOrder(expectedTokens.toArray(new SToken[expectedTokens.size()]));
	}

	@Test
	public void whenGettingAllSpansOverlappingAText_thenReturnAllSpans() {
		final List<SSpan> expectedSpans = new ArrayList<>();
		expectedSpans.addAll(documentGraph.getSpans());
		final STextualDS overlappedText = documentGraph.getTextualDSs().get(0);

		final List<SSpan> actualNodes = fixture.getSpanBySequence(
				new DataSourceSequence.Builder().on(overlappedText).from(0).to(overlappedText.getEnd()).build());

		assertThat(actualNodes).containsExactlyInAnyOrder(expectedSpans.toArray(new SSpan[expectedSpans.size()]));
	}

	@Test
	public void whenGettingAllStructuresOverlappingAText_thenReturnAllStructures() {
		final List<SStructure> expectedStructures = new ArrayList<>();
		expectedStructures.addAll(documentGraph.getStructures());
		final STextualDS overlappedText = documentGraph.getTextualDSs().get(0);

		final List<SStructure> actualNodes = fixture.getStructureBySequence(
				new DataSourceSequence.Builder().on(overlappedText).from(0).to(overlappedText.getEnd()).build());

		assertThat(actualNodes)
				.containsExactlyInAnyOrder(expectedStructures.toArray(new SStructure[expectedStructures.size()]));
	}
}
