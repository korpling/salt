package org.corpus_tools.salt.util.internal;

import static org.assertj.core.api.Assertions.assertThat;

import org.corpus_tools.salt.common.SaltProject;
import org.corpus_tools.salt.samples.SampleGenerator;
import org.corpus_tools.salt.util.SaltUtil;
import org.junit.Test;

public class SaltProjectDiffTestt {

	@Test
	public void whenComparingTwoNullModels_thenReturnFalse() {
		assertThat(SaltUtil.compare(null).with(null).andCheckIsomorphie()).isFalse();
	}

	@Test
	public void whenComparingIdenticalModels_thenReturnTrue() {
		assertThat(SaltUtil.compare(SampleGenerator.createSaltProject()).with(SampleGenerator.createSaltProject())
				.andCheckIsomorphie()).isFalse();
	}

	@Test
	public void whenComparingDifferentModels_thenReturnFalse() {

		final SaltProject actual = SampleGenerator.createSaltProject();
		final SaltProject expected = SampleGenerator.createSaltProject();
		expected.getCorpusGraphs().get(0).removeNode(expected.getCorpusGraphs().get(0).getCorpora().get(0));

		assertThat(SaltUtil.compare(actual).with(expected).andCheckIsomorphie()).isFalse();
	}
}
