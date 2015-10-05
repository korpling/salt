package org.corpus_tools.salt.common.impl.tests;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.common.SDominanceRelation;
import org.corpus_tools.salt.common.SMedialRelation;
import org.corpus_tools.salt.common.SOrderRelation;
import org.corpus_tools.salt.common.SPointingRelation;
import org.corpus_tools.salt.common.SSpanningRelation;
import org.corpus_tools.salt.common.STextualRelation;
import org.corpus_tools.salt.common.STimelineRelation;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.junit.Test;

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
