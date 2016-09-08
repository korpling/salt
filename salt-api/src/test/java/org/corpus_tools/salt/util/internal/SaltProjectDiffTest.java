/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
package org.corpus_tools.salt.util.internal;

import static org.assertj.core.api.Assertions.assertThat;

import org.corpus_tools.salt.common.SaltProject;
import org.corpus_tools.salt.samples.SampleGenerator;
import org.corpus_tools.salt.util.SaltUtil;
import org.junit.Test;

public class SaltProjectDiffTest {

	@Test
	public void whenComparingTwoNullModels_thenReturnFalse() {
		assertThat(SaltUtil.compare(null).with(null).andCheckIsomorphie()).isFalse();
	}

	@Test
	public void whenComparingIdenticalModels_thenReturnTrue() {
		assertThat(SaltUtil.compare(SampleGenerator.createSaltProject()).with(SampleGenerator.createSaltProject())
				.andCheckIsomorphie()).isTrue();
	}

	@Test
	public void whenComparingDifferentModels_thenReturnFalse() {
		final SaltProject actual = SampleGenerator.createSaltProject();
		final SaltProject expected = SampleGenerator.createSaltProject();
		expected.getCorpusGraphs().get(0).removeNode(expected.getCorpusGraphs().get(0).getCorpora().get(0));

		assertThat(SaltUtil.compare(actual).with(expected).andCheckIsomorphie()).isFalse();
	}
}
