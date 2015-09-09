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
package de.hu_berlin.u.saltnpepper.salt.saltCommon.sDocumentStructure.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STextualDS;

public class STextualDSTest extends SSequentialDSTest<String, Integer> {

	public STextualDS getFixture() {
		return (STextualDS) fixture;
	}
	
	@Before
	public void setUp() {
		setFixture(SaltFactory.createSTextualDS());
	}
	/** Tests if {@link STextualDS#getData()} returns the same text as passed in {@link STextualDS#setData(String)}**/
	@Override
	@Test
	public void testSetGetData() {
		String text= "text";
		this.getFixture().setData(text);
		assertEquals(text, getFixture().getData());
	}
	
	/** Tests if {@link STextualDS#getStart()} returns the same text as passed in {@link STextualDS#setText(String)}**/
	@Test
	public void testSetGetText() {
		String text= "text";
		this.getFixture().setText(text);
		assertEquals(text, getFixture().getText());
	}

	@Override
	@Test
	public void testGetStart() {
		assertEquals(null, getFixture().getStart());
		getFixture().setData("Test");
		assertEquals(Integer.valueOf(0), getFixture().getStart());
	}

	@Override
	@Test
	public void testGetEnd() {
		assertEquals(null, getFixture().getEnd());
		getFixture().setData("Test");
		assertEquals(Integer.valueOf(4), getFixture().getEnd());
	}
} //STextualDSTest
