package de.hu_berlin.u.saltnpepper.salt.saltCommon.sDocumentStructure.tests;

import org.junit.Test;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDominanceRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SMedialRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SOrderRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SPointingRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSpanningRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STextualRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STimelineRelation;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;

/**
 * This is an abstract test class for testing {@link SRelation} types.
 * 
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
	public void testGetGraph() {
		if (getFixture() instanceof SSpanningRelation) {
			((SSpanningRelation) getFixture()).setSource(SaltFactory.createSSpan());
			((SSpanningRelation) getFixture()).setTarget(SaltFactory.createSToken());
		} else if (getFixture() instanceof SDominanceRelation) {
			((SDominanceRelation) getFixture()).setSource(SaltFactory.createSStructure());
			((SDominanceRelation) getFixture()).setTarget(SaltFactory.createSToken());
		} else if (getFixture() instanceof SPointingRelation) {
			((SPointingRelation) getFixture()).setSource(SaltFactory.createSStructure());
			((SPointingRelation) getFixture()).setTarget(SaltFactory.createSToken());
		} else if (getFixture() instanceof SOrderRelation) {
			((SOrderRelation) getFixture()).setSource(SaltFactory.createSToken());
			((SOrderRelation) getFixture()).setTarget(SaltFactory.createSToken());
		} else if (getFixture() instanceof STextualRelation) {
			((STextualRelation) getFixture()).setSource(SaltFactory.createSToken());
			((STextualRelation) getFixture()).setTarget(SaltFactory.createSTextualDS());
		} else if (getFixture() instanceof STimelineRelation) {
			((STimelineRelation) getFixture()).setSource(SaltFactory.createSToken());
			((STimelineRelation) getFixture()).setTarget(SaltFactory.createSTimeline());
		} else if (getFixture() instanceof SMedialRelation) {
			((SMedialRelation) getFixture()).setSource(SaltFactory.createSToken());
			((SMedialRelation) getFixture()).setTarget(SaltFactory.createSMedialDS());
		}
		TestUtils.testSetGetGraph(getFixture());
	}
}
