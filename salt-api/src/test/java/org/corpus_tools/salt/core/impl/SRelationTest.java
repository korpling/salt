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
package org.corpus_tools.salt.core.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.core.SAnnotationContainer;
import org.corpus_tools.salt.core.SNamedElement;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.core.STypedElement;
import org.corpus_tools.salt.util.SaltUtil;
import org.junit.Before;
import org.junit.Test;

public class SRelationTest extends SAnnotationContainerTest {

	@SuppressWarnings("unchecked")
	@Override
	public SRelation<SNode, SNode> getFixture() {
		return (SRelation<SNode, SNode>) super.getFixture();
	}

	@Before
	@Override
	public void setUp() throws Exception {
		setFixture(SaltFactory.createSRelation());
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
	 * Tests the methods {@link STypedElement#getType()} and
	 * {@link STypedElement#setType(String)}.
	 */
	@Test
	public void testGetType() {
		assertNull(getFixture().getType());
		getFixture().setType("myType");
		assertEquals("myType", getFixture().getType());
		getFixture().setType(null);
		assertNull(getFixture().getType());

		((SAnnotationContainer) getFixture()).removeLabel(SaltUtil.FEAT_TYPE_QNAME);
		assertNull(getFixture().getType());
		((SAnnotationContainer) getFixture()).createFeature(SaltUtil.SALT_NAMESPACE, SaltUtil.FEAT_TYPE, "myType2");
		assertEquals("myType2", getFixture().getType());
	}

}
