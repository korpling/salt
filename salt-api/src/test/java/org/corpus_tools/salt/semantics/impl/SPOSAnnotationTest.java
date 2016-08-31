package org.corpus_tools.salt.semantics.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.semantics.SPOSAnnotation;
import org.corpus_tools.salt.util.SaltUtil;
import org.junit.Test;

public class SPOSAnnotationTest {

	@Test
	public void whenInitializing_thenAllNamespaceNameAndValueShouldMatchExpected() {
		SPOSAnnotation fixture = SaltFactory.createSPOSAnnotation();
		assertThat(fixture.getNamespace()).isEqualTo(SaltUtil.SALT_NAMESPACE);
		assertThat(fixture.getName()).isEqualTo(SaltUtil.SEMANTICS_POS);
	}

}
