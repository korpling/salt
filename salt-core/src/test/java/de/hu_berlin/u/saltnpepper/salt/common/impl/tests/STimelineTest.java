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
package de.hu_berlin.u.saltnpepper.salt.common.impl.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.common.STimeline;

public class STimelineTest extends SSequentialDSTest<Integer, Integer> {

	public STimeline getFixture() {
		return (STimeline) fixture;
	}

	@Before
	public void setUp() {
		setFixture(SaltFactory.createSTimeline());
	}

	@Override
	public void testSetGetData() {
		getFixture().setData(5);
		assertEquals(Integer.valueOf(5), getFixture().getData());
	}

	/**
	 * Tests the methods {@link STimeline#getStart()} and
	 * {@link STimeline#increasePointOfTime()}.
	 */
	@Override
	public void testGetStart() {
		assertEquals(null, getFixture().getStart());
		getFixture().increasePointOfTime();
		assertEquals(Integer.valueOf(0), getFixture().getStart());
	}

	/**
	 * Tests the methods {@link STimeline#getStart()} and
	 * {@link STimeline#increasePointOfTime()}.
	 */
	@Override
	public void testGetEnd() {
		assertEquals(null, getFixture().getEnd());
		getFixture().increasePointOfTime();
		assertEquals(Integer.valueOf(1), getFixture().getEnd());
		getFixture().increasePointOfTime();
		assertEquals(Integer.valueOf(2), getFixture().getEnd());
	}

	/**
	 * Tests the increasing of points of time for a passed number
	 * {@link STimeline#increasePointOfTime(Integer)}
	 **/
	@Test
	public void testIncreasePointOfTime_INTEGER() {
		getFixture().increasePointOfTime(5);
		assertEquals(Integer.valueOf(5), getFixture().getData());
		getFixture().increasePointOfTime(10);
		assertEquals(Integer.valueOf(15), getFixture().getData());
	}
} // STimelineTest
