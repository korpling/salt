/**
 * Copyright 2009 Humboldt-Universität zu Berlin.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
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
 */
public abstract class SRelationAbstractTest<S extends SNode, T extends SNode> {

	protected SRelation<S, T> fixture = null;

	protected void setFixture(SRelation<S, T> fixture) {
		this.fixture = fixture;
	}

	protected SRelation<S, T> getFixture() {
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
