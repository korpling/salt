package de.hu_berlin.u.saltnpepper.salt.core.impl.tests;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.core.SNamedElement;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.util.SaltUtil;

public class SNodeTest extends SAnnotationContainerTest {

	public SNode getFixture(){
		return((SNode)super.getFixture());
	}
	
	@Before
	@Override
	public void setUp() throws Exception {
		setFixture(SaltFactory.createSNode());
	}

	/**
	 * Tests the methods {@link SNamedElement#getName()} and
	 * {@link SNamedElement#setName(String)}.
	 */
	@Test
	public void testGetName() {
		assertNull(getFixture().getName());
		getFixture().setName("myName");
		assertEquals("myName", getFixture().getName());
		getFixture().setName(null);
		assertNull(getFixture().getName());
		
		getFixture().removeLabel(SaltUtil.KW_QNAME_NAME);
		assertNull(getFixture().getName());
		getFixture().createFeature(SaltUtil.SALT_NAMESPACE, SaltUtil.KW_NAME, "myName2");
		assertEquals("myName2", getFixture().getName());
	}
}
