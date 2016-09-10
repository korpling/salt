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

import static org.junit.Assert.*;

import java.util.List;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.common.STextualDS;
import org.corpus_tools.salt.common.SToken;
import org.junit.Before;
import org.junit.Test;

public class STextualDSTest extends SSequentialDSTest<String, Integer> {

	public STextualDS getFixture() {
		return (STextualDS) fixture;
	}

	@Before
	public void setUp() {
		setFixture(SaltFactory.createSTextualDS());
	}

	/**
	 * Tests if {@link STextualDS#getData()} returns the same text as passed in
	 * {@link STextualDS#setData(String)}
	 **/
	@Override
	@Test
	public void testSetGetData() {
		String text = "text";
		this.getFixture().setData(text);
		assertEquals(text, getFixture().getData());
	}

	/**
	 * Tests if {@link STextualDS#getStart()} returns the same text as passed in
	 * {@link STextualDS#setText(String)}
	 **/
	@Test
	public void testSetGetText() {
		String text = "text";
		this.getFixture().setText(text);
		assertEquals(text, getFixture().getText());
	}

	/**
	 * Tests if {@link STextualDS#getStart()} returns the same text as passed in
	 * {@link STextualDS#setText(String)}
	 **/
	@Test
	public void testSetGetText_SpecialCharacters() {
		String text = "text\n\t text";
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

	@Test
	public void testTokenize() {
		SDocumentGraph graph = SaltFactory.createSDocumentGraph();
		getFixture().setText("This is a birthday pony!");
		getFixture().setGraph(graph);
		List<SToken> tokens = getFixture().tokenize();
		graph = getFixture().getGraph();
		assertNotNull(graph);
		assertTrue(graph instanceof SDocumentGraph);
		tokens = graph.getSortedTokenByText();
		assertNotNull(tokens);
		assertTrue(tokens.size() == 6);
		String[] tokenArray = new String[] { "This", "is", "a", "birthday", "pony", "!" };
		for (int i = 0; i < graph.getTokens().size(); i++) {
			assertEquals(tokenArray[i], graph.getText(tokens.get(i)));
		}
	}
} // STextualDSTest
