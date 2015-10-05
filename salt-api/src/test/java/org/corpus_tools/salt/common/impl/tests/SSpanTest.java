package org.corpus_tools.salt.common.impl.tests;

import org.corpus_tools.salt.SaltFactory;
import org.junit.Before;

public class SSpanTest extends SNodeAbstractTest {

	@Before
	public void setUp() throws Exception {
		setFixture(SaltFactory.createSSpan());
	}

}
