package org.corpus_tools.salt.core.impl.tests;

import org.corpus_tools.salt.SaltFactory;
import org.junit.Before;

public class SAnnotationTest extends SAbstractAnnotationTest {

	@Before
	@Override
	public void setUp() throws Exception {
		setFixture(SaltFactory.createSAnnotation());
	}

}
