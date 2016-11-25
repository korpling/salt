package org.corpus_tools.salt.util.internal;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.common.SSpan;
import org.corpus_tools.salt.common.SStructure;
import org.corpus_tools.salt.common.STextualDS;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.samples.SampleGenerator;
import org.corpus_tools.salt.util.DataSourceSequence;
import org.junit.Test;

public class DataSourceAccessorTest {

	@Test
	public void whenGettingAllNodesOverlappingAText_thenReturnAllNodes() {
		final SDocument document = SaltFactory.createSDocument();
		SampleGenerator.createDocumentStructure(document);
		final List<SNode> expectedNodes = new ArrayList<>();
		expectedNodes.addAll(document.getDocumentGraph().getTokens());
		expectedNodes.addAll(document.getDocumentGraph().getSpans());
		expectedNodes.addAll(document.getDocumentGraph().getStructures());
		final STextualDS overlappedText = document.getDocumentGraph().getTextualDSs().get(0);

		final List<SNode> actualNodes = DataSourceAccessor.getNodeBySequence(document.getDocumentGraph(),
				new DataSourceSequence.Builder().on(overlappedText).from(0).to(overlappedText.getEnd()).build());

		assertThat(actualNodes).containsExactlyInAnyOrder(expectedNodes.toArray(new SNode[expectedNodes.size()]));
	}

	@Test
	public void whenGettingAllTokensOverlappingAText_thenReturnAllTokens() {
		final SDocument document = SaltFactory.createSDocument();
		SampleGenerator.createDocumentStructure(document);
		final List<SToken> expectedTokens = new ArrayList<>();
		expectedTokens.addAll(document.getDocumentGraph().getTokens());
		final STextualDS overlappedText = document.getDocumentGraph().getTextualDSs().get(0);

		final List<SToken> actualNodes = DataSourceAccessor.getTokensBySequence(document.getDocumentGraph(),
				new DataSourceSequence.Builder().on(overlappedText).from(0).to(overlappedText.getEnd()).build());

		assertThat(actualNodes).containsExactlyInAnyOrder(expectedTokens.toArray(new SToken[expectedTokens.size()]));
	}

	@Test
	public void whenGettingAllSpansOverlappingAText_thenReturnAllSpans() {
		final SDocument document = SaltFactory.createSDocument();
		SampleGenerator.createDocumentStructure(document);
		final List<SSpan> expectedSpans = new ArrayList<>();
		expectedSpans.addAll(document.getDocumentGraph().getSpans());
		final STextualDS overlappedText = document.getDocumentGraph().getTextualDSs().get(0);

		final List<SSpan> actualNodes = DataSourceAccessor.getSpanBySequence(document.getDocumentGraph(),
				new DataSourceSequence.Builder().on(overlappedText).from(0).to(overlappedText.getEnd()).build());

		assertThat(actualNodes).containsExactlyInAnyOrder(expectedSpans.toArray(new SSpan[expectedSpans.size()]));
	}

	@Test
	public void whenGettingAllStructuresOverlappingAText_thenReturnAllStructures() {
		final SDocument document = SaltFactory.createSDocument();
		SampleGenerator.createDocumentStructure(document);
		final List<SStructure> expectedStructures = new ArrayList<>();
		expectedStructures.addAll(document.getDocumentGraph().getStructures());
		final STextualDS overlappedText = document.getDocumentGraph().getTextualDSs().get(0);

		final List<SStructure> actualNodes = DataSourceAccessor.getStructureBySequence(document.getDocumentGraph(),
				new DataSourceSequence.Builder().on(overlappedText).from(0).to(overlappedText.getEnd()).build());

		assertThat(actualNodes)
				.containsExactlyInAnyOrder(expectedStructures.toArray(new SStructure[expectedStructures.size()]));
	}
}
