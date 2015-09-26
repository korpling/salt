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
package de.hu_berlin.u.saltnpepper.salt.common.tokenizer.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STextualDS;
import de.hu_berlin.u.saltnpepper.salt.common.tokenizer.SimpleTokenizer;

/**
 * 
 * Tests the class TTTokenizer.
 * 
 * @author Florian Zipser
 *
 */
public class SimpleTokenizerTest {
	private SimpleTokenizer fixture = null;

	/**
	 * @param fixture
	 *            the fixture to set
	 */
	public void setFixture(SimpleTokenizer fixture) {
		this.fixture = fixture;
	}

	/**
	 * @return the fixture
	 */
	public SimpleTokenizer getFixture() {
		return fixture;
	}

	@Before
	public void setUp() {
		this.setFixture(new SimpleTokenizer());
	}

	/**
	 * Tests the text "This is a test text.", which has to be tokenized into 5
	 * tokens:
	 * <ul>
	 * <li>This</li>
	 * <li>is</li>
	 * <li>a</li>
	 * <li>test</li>
	 * <li>text.</li>
	 * </ul>
	 */
	@Test
	public void testTokenize_ByBlanks1() {
		SDocumentGraph docGraph = SaltFactory.createSDocumentGraph();
		STextualDS primText = docGraph.createTextualDS("This is a test text.");
		getFixture().setDocumentGraph(docGraph);
		getFixture().tokenize(primText, ' ');

		assertEquals(5, docGraph.getTokens().size());
		assertEquals("This", docGraph.getText(docGraph.getTokens().get(0)));
		assertEquals("is", docGraph.getText(docGraph.getTokens().get(1)));
		assertEquals("a", docGraph.getText(docGraph.getTokens().get(2)));
		assertEquals("test", docGraph.getText(docGraph.getTokens().get(3)));
		assertEquals("text.", docGraph.getText(docGraph.getTokens().get(4)));
	}

	/**
	 * Tests the text "    This   is   a test  text.", which has to be tokenized
	 * into 5 tokens:
	 * <ul>
	 * <li>This</li>
	 * <li>is</li>
	 * <li>a</li>
	 * <li>test</li>
	 * <li>text.</li>
	 * </ul>
	 */
	@Test
	public void testTokenize_ByBlanks2() {
		SDocumentGraph docGraph = SaltFactory.createSDocumentGraph();
		STextualDS primText = docGraph.createTextualDS("    This   is   a test  text.  ");
		getFixture().setDocumentGraph(docGraph);
		getFixture().tokenize(primText, ' ');

		assertEquals(5, docGraph.getTokens().size());
		assertEquals("This", docGraph.getText(docGraph.getTokens().get(0)));
		assertEquals("is", docGraph.getText(docGraph.getTokens().get(1)));
		assertEquals("a", docGraph.getText(docGraph.getTokens().get(2)));
		assertEquals("test", docGraph.getText(docGraph.getTokens().get(3)));
		assertEquals("text.", docGraph.getText(docGraph.getTokens().get(4)));
	}

	/**
	 * Tests the text "    This   is   a test  text.", which has to be tokenized
	 * into 5 tokens:
	 * <ul>
	 * <li>This</li>
	 * <li>is</li>
	 * <li>a</li>
	 * <li>test</li>
	 * <li>text</li>
	 * </ul>
	 */
	@Test
	public void testTokenize_ByBlanksAndPunc() {
		SDocumentGraph docGraph = SaltFactory.createSDocumentGraph();
		STextualDS primText = docGraph.createTextualDS("    This   is   a test  text.  ");
		getFixture().setDocumentGraph(docGraph);
		getFixture().tokenize(primText, ' ', '.');

		assertEquals(5, docGraph.getTokens().size());
		assertEquals("This", docGraph.getText(docGraph.getTokens().get(0)));
		assertEquals("is", docGraph.getText(docGraph.getTokens().get(1)));
		assertEquals("a", docGraph.getText(docGraph.getTokens().get(2)));
		assertEquals("test", docGraph.getText(docGraph.getTokens().get(3)));
		assertEquals("text", docGraph.getText(docGraph.getTokens().get(4)));
	}
}
