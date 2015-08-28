package de.hu_berlin.u.saltnpepper.salt.saltCommon.sDocumentStructure.tests;

import org.junit.Test;

import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;

/**
 * This is an abstract test class for testing {@link SNode} types.
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
	public void testGetGraph(){
		TestUtils.testSetGetGraph(getFixture());
	}
}
