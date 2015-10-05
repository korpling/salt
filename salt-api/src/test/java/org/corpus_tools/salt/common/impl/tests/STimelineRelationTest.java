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
import org.corpus_tools.salt.common.STimeline;
import org.corpus_tools.salt.common.STimelineRelation;
import org.corpus_tools.salt.common.SToken;
import org.junit.Before;
import org.junit.Test;

public class STimelineRelationTest extends SSequentialRelationTest<SToken, STimeline, Integer> {

	@Override
	protected STimelineRelation getFixture() {
		return ((STimelineRelation) super.getFixture());
	}

	@Before
	public void setUp() {
		setFixture(SaltFactory.createSTimelineRelation());
	}

	@Override
	@Test
	public void testSetGetStart() {
		assertNull(getFixture().getStart());
		getFixture().setStart(1);
		assertEquals(Integer.valueOf(1), getFixture().getStart());
		getFixture().setStart(2);
		assertEquals(Integer.valueOf(2), getFixture().getStart());
	}

	@Override
	@Test
	public void testSetGetEnd() {
		assertNull(getFixture().getEnd());
		getFixture().setEnd(1);
		assertEquals(Integer.valueOf(1), getFixture().getEnd());
		getFixture().setEnd(2);
		assertEquals(Integer.valueOf(2), getFixture().getEnd());
	}
} // SAudioDSRelationTest
