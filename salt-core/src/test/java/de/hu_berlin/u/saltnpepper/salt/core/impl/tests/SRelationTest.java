package de.hu_berlin.u.saltnpepper.salt.core.impl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.ObjectInputStream.GetField;

import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotationContainer;
import de.hu_berlin.u.saltnpepper.salt.core.SNamedElement;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;
import de.hu_berlin.u.saltnpepper.salt.core.STypedElement;
import de.hu_berlin.u.saltnpepper.salt.util.SaltUtil;

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
	
	/**
	 * Tests the methods {@link STypedElement#getType()} and
	 * {@link STypedElement#setType(String)}.
	 */
	@Test
	public void testGetType() {
		assertNull(getFixture().getType());
		getFixture().setType("myType");
		assertEquals("myType", getFixture().getType());
		getFixture().setType(null);
		assertNull(getFixture().getType());

		if (getFixture() instanceof SAnnotationContainer) {
			((SAnnotationContainer) getFixture()).removeLabel(SaltUtil.KW_QNAME_TYPE);
			assertNull(getFixture().getType());
			((SAnnotationContainer) getFixture()).createFeature(SaltUtil.SALT_NAMESPACE, SaltUtil.KW_TYPE, "myType2");
			assertEquals("myType2", getFixture().getType());
		}
	}
	
}
