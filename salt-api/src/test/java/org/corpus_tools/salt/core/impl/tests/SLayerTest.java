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
package org.corpus_tools.salt.core.impl.tests;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.core.SLayer;
import org.corpus_tools.salt.core.SNamedElement;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.exceptions.SaltInsertionException;
import org.corpus_tools.salt.graph.Relation;
import org.corpus_tools.salt.graph.impl.RelationImpl;
import org.junit.Before;
import org.junit.Test;

public class SLayerTest extends SAnnotationContainerTest {

	@Override
	public SLayer getFixture() {
		// TODO Auto-generated method stub
		return (SLayer) super.getFixture();
	}

	@Before
	@Override
	public void setUp() throws Exception {
		setFixture(SaltFactory.createSLayer());
	}

	/**
	 * Tests the methods {@link SNamedElement#getName()} and
	 * {@link SNamedElement#setName(String)}.
	 */
	@Test
	public void testGetName() {
		TestHelper.testGetName(getFixture());
	}
	
	@Test(expected=SaltInsertionException.class)
	public void testInvalidRelationType() {
		class InvalidRelation extends RelationImpl<SNode, SNode> {

		}
		Relation<SNode, SNode> rel = new InvalidRelation();
		rel.setSource(SaltFactory.createSNode());
		rel.setTarget(SaltFactory.createSNode());

		// this compiles but should throw an exception
		getFixture().addRelation(rel);
	}
}
