package org.corpus_tools.salt.core.impl.tests;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.core.SLayer;
import org.corpus_tools.salt.core.SNamedElement;
import org.junit.Before;
import org.junit.Test;

public class SLayerTest extends SAnnotationContainerTest {

	@Override
	public SLayer getFixture() {
		// TODO Auto-generated method stub
		return (SLayer) super.getFixture();
	}

	@Before
	@Override
	public void setUp() throws Exception {
		setFixture(SaltFactory.createSLayer());
	}

	/**
	 * Tests the methods {@link SNamedElement#getName()} and
	 * {@link SNamedElement#setName(String)}.
	 */
	@Test
	public void testGetName() {
		TestHelper.testGetName(getFixture());
	}
}
