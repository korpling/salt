package org.corpus_tools.salt.semantics.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.semantics.SSentenceAnnotation;
import org.corpus_tools.salt.util.SaltUtil;
import org.junit.Test;

public class SSentenceAnnotationTest {

	@Test
	public void whenInitializing_thenAllNamespaceNameAndValueShouldMatchExpected() {
		SSentenceAnnotation fixture = SaltFactory.createSSentenceAnnotation();
		assertThat(fixture.getNamespace()).isEqualTo(SaltUtil.SALT_NAMESPACE);
		assertThat(fixture.getName()).isEqualTo(SaltUtil.SEMANTICS_UNIT);
		assertThat(fixture.getValue()).isEqualTo(SaltUtil.SEMANTICS_SENTENCE);
	}

}
