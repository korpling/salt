/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
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
import org.corpus_tools.salt.common.SStructure;
import org.corpus_tools.salt.common.STextualRelation;
import org.corpus_tools.salt.common.STimelineRelation;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.junit.Test;

/**
 * This is an abstract test class for testing {@link SRelation} types.
 * 
 * @author florian
 *
 */
public abstract class SRelationAbstractTest<R extends SRelation<? extends SNode, ? extends SNode>> {

	protected R fixture = null;

	protected void setFixture(R fixture) {
		this.fixture = fixture;
	}

	protected R getFixture() {
		return fixture;
	}
	
	protected abstract void setValidSourceAndTarget(R rel);

	/** Tests whether returned graph is of type {@link SDocumentGraph}. **/
	@Test
	public void testGetGraph() {
		setValidSourceAndTarget(getFixture());
		TestUtils.testSetGetGraph(getFixture());
	}
	
	@Test(expected=ClassCastException.class)
	public void testTypeCheckTarget() {
		
		R validRel = getFixture();
		setValidSourceAndTarget(validRel);
		
		SDocumentGraph docGraph = SaltFactory.createSDocumentGraph();
		// these have to be set in the fixture in setUp()
		docGraph.addNode(validRel.getSource());
		docGraph.addNode(validRel.getTarget());
		
		docGraph.addRelation(validRel);
		
		SNode anyNode = SaltFactory.createSNode();
		
		SRelation<SNode, SNode> retrievedRel =  docGraph.getRelation(validRel.getId());
		// this should fail
		retrievedRel.setTarget(anyNode);
	}
	
	@Test(expected=ClassCastException.class)
	public void testTypeCheckSource() {
		
		R validRel = getFixture();
		setValidSourceAndTarget(validRel);
		
		SDocumentGraph docGraph = SaltFactory.createSDocumentGraph();
		// these have to be set in the fixture in setUp()
		docGraph.addNode(validRel.getSource());
		docGraph.addNode(validRel.getTarget());
		
		docGraph.addRelation(validRel);
		
		SNode anyNode = SaltFactory.createSNode();
		
		SRelation<SNode, SNode> retrievedRel =  docGraph.getRelation(validRel.getId());
		// this should fail
		retrievedRel.setSource(anyNode);
	}
}
