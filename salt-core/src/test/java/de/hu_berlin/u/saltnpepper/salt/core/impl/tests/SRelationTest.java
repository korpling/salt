package de.hu_berlin.u.saltnpepper.salt.core.impl.tests;

import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.core.SNamedElement;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;

public class SRelationTest extends SAnnotationContainerTest {

	@SuppressWarnings("unchecked")
	@Override
	public SRelation<SNode, SNode> getFixture() {
		return (SRelation<SNode, SNode>) super.getFixture();
	}

	@Before
	@Override
	public void setUp() throws Exception {
		setFixture(SaltFactory.createSRelation());
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
