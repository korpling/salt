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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SMedialDS;
import org.corpus_tools.salt.common.SMedialRelation;
import org.corpus_tools.salt.common.SToken;
import org.junit.Before;
import org.junit.Test;

public class SMediaRelationTest extends SSequentialRelationTest<SToken, SMedialDS, Double> {

	@Override
	protected SMedialRelation getFixture() {
		return ((SMedialRelation) super.getFixture());
	}

	@Before
	public void setUp() {
		setFixture(SaltFactory.createSMedialRelation());
	}

	@Override
	@Test
	public void testSetGetStart() {
		assertNull(getFixture().getStart());
		getFixture().setStart(1.0);
		assertEquals(Double.valueOf(1.0), getFixture().getStart());
		getFixture().setStart(2.0);
		assertEquals(Double.valueOf(2.0), getFixture().getStart());
	}

	@Override
	@Test
	public void testSetGetEnd() {
		assertNull(getFixture().getEnd());
		getFixture().setEnd(1.0);
		assertEquals(Double.valueOf(1.0), getFixture().getEnd());
		getFixture().setEnd(2.0);
		assertEquals(Double.valueOf(2.0), getFixture().getEnd());
	}
} // SAudioDSRelationTest
