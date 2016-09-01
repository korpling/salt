package org.corpus_tools.salt.semantics.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.semantics.SWordAnnotation;
import org.corpus_tools.salt.util.SaltUtil;
import org.junit.Test;

public class SWordAnnotationTest {

	@Test
	public void whenInitializing_thenAllNamespaceNameAndValueShouldMatchExpected() {
		SWordAnnotation fixture = SaltFactory.createSWordAnnotation();
		assertThat(fixture.getNamespace()).isEqualTo(SaltUtil.SALT_NAMESPACE);
		assertThat(fixture.getName()).isEqualTo(SaltUtil.SEMANTICS_UNIT);
		assertThat(fixture.getValue()).isEqualTo(SaltUtil.SEMANTICS_WORD);
	}

}
