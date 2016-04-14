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
import org.corpus_tools.salt.common.SSpan;
import org.corpus_tools.salt.common.SSpanningRelation;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.exceptions.SaltInsertionException;
import org.junit.Before;
import org.junit.Test;

public class SSpanningRelationTest extends SRelationAbstractTest {

	@Before
	public void setUp() throws Exception {
		setFixture(SaltFactory.createSSpanningRelation());
	}
	
	@Test(expected=SaltInsertionException.class)
	public void testTypeCheckTarget() {
		SDocumentGraph docGraph = SaltFactory.createSDocumentGraph();
		SSpan spanNode = SaltFactory.createSSpan();
		SToken tokNode = SaltFactory.createSToken();
		docGraph.addNode(spanNode);
		docGraph.addNode(tokNode);
		
		SSpanningRelation spanRel = SaltFactory.createSSpanningRelation();
		spanRel.setTarget(tokNode);
		spanRel.setSource(spanNode);
		
		docGraph.addRelation(spanRel);
		
		SNode anyNode = SaltFactory.createSNode();
		
		SRelation<SNode, SNode> retrievedRel =  docGraph.getRelation(spanRel.getId());
		// this should work
		SToken secondToken = SaltFactory.createSToken();
		retrievedRel.setTarget(secondToken);
		// this should fail
		retrievedRel.setTarget(anyNode);
	}

}
