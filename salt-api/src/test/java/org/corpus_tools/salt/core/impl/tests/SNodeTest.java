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
