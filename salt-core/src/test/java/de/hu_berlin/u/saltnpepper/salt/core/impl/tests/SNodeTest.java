package de.hu_berlin.u.saltnpepper.salt.core.impl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.eclipse.emf.common.util.URI;
import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.core.SGraph;
import de.hu_berlin.u.saltnpepper.salt.core.SNamedElement;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.util.SaltUtil;

public class SNodeTest extends SAnnotationContainerTest {

	public SNode getFixture() {
		return ((SNode) super.getFixture());
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
		TestHelper.testGetName(getFixture());
	}
	/**
	 * Tests the method {@link SNode#getPath()}.
	 */
	@Test
	public void testGetPath(){
		assertNull(getFixture().getPath());
		getFixture().setId("node1");
		assertNotNull(getFixture().getPath());
		assertEquals(SaltUtil.createSaltURI("node1"), getFixture().getPath());
		
		SGraph graph= SaltFactory.createSGraph();
		graph.addNode(getFixture());
		assertEquals(SaltUtil.createSaltURI(getFixture().getId()), getFixture().getPath());
	}
}
