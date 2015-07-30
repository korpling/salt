package de.hu_berlin.u.saltnpepper.salt.core.impl.tests;

import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.core.SLayer;
import de.hu_berlin.u.saltnpepper.salt.core.SNamedElement;

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
