package org.corpus_tools.salt.semantics.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.semantics.SLemmaAnnotation;
import org.corpus_tools.salt.util.SaltUtil;
import org.junit.Test;

public class SLemmaAnnotationTest {

	@Test
	public void whenInitializing_thenAllNamespaceNameAndValueShouldMatchExpected() {
		SLemmaAnnotation fixture = SaltFactory.createSLemmaAnnotation();
		assertThat(fixture.getNamespace()).isEqualTo(SaltUtil.SALT_NAMESPACE);
		assertThat(fixture.getName()).isEqualTo(SaltUtil.SEMANTICS_LEMMA);
	}

}
