package org.corpus_tools.salt.common.impl.tests;

import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.core.SNode;
import org.junit.Test;

/**
 * This is an abstract test class for testing {@link SNode} types.
 * 
 * @author florian
 *
 */
public abstract class SNodeAbstractTest {

	protected SNode fixture = null;

	protected void setFixture(SNode fixture) {
		this.fixture = fixture;
	}

	protected SNode getFixture() {
		return fixture;
	}

	/** Tests whether returned graph is of type {@link SDocumentGraph}. **/
	@Test
	public void testGetGraph() {
		TestUtils.testSetGetGraph(getFixture());
	}
}
