package org.corpus_tools.salt.core.impl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SNamedElement;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.util.SaltUtil;
import org.junit.Before;
import org.junit.Test;

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
	public void testGetPath() {
		assertNull(getFixture().getPath());
		getFixture().setId("node1");
		assertNotNull(getFixture().getPath());
		assertEquals(SaltUtil.createSaltURI("node1"), getFixture().getPath());

		SGraph graph = SaltFactory.createSGraph();
		graph.addNode(getFixture());
		assertEquals(SaltUtil.createSaltURI(getFixture().getId()), getFixture().getPath());
	}
}
