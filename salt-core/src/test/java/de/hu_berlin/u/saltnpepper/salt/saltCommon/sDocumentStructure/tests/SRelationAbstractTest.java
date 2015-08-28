package de.hu_berlin.u.saltnpepper.salt.saltCommon.sDocumentStructure.tests;

import org.junit.Test;

import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;

/**
 * This is an abstract test class for testing {@link SRelation} types.
 * @author florian
 *
 */
public abstract class SRelationAbstractTest {

	protected SRelation<? extends SNode, ? extends SNode> fixture = null;

	protected void setFixture(SRelation<? extends SNode, ? extends SNode> fixture) {
		this.fixture = fixture;
	}

	protected SRelation<? extends SNode, ? extends SNode> getFixture() {
		return fixture;
	}
	
	/** Tests whether returned graph is of type {@link SDocumentGraph}. **/
	@Test
	public void testGetGraph(){
		TestUtils.testSetGetGraph(getFixture());
	}
}
