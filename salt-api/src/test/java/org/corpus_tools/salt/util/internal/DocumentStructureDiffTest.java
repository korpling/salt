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
package org.corpus_tools.salt.util.internal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.common.SDominanceRelation;
import org.corpus_tools.salt.common.SPointingRelation;
import org.corpus_tools.salt.common.SSpan;
import org.corpus_tools.salt.common.SStructure;
import org.corpus_tools.salt.common.STextualDS;
import org.corpus_tools.salt.common.STextualRelation;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.core.SLayer;
import org.corpus_tools.salt.samples.SampleGenerator;
import org.corpus_tools.salt.util.DiffOptions;
import org.corpus_tools.salt.util.Difference;
import org.junit.Before;
import org.junit.Test;

/**
 * This class tests the isomorphy check of the {@link SDocumentGraph}.
 * 
 * @author André Röhrig
 */
public class DocumentStructureDiffTest {

	protected DocumentStructureDiff fixture = null;

	protected void setFixture(DocumentStructureDiff fixture) {
		this.fixture = fixture;
	}

	protected DocumentStructureDiff getFixture() {
		return fixture;
	}

	private SDocumentGraph template = null;
	private SDocumentGraph other = null;

	@Before
	public void setUp() throws Exception {
		template = SaltFactory.createSDocumentGraph();
		template.setDocument(SaltFactory.createSDocument());
		template.getDocument().setId("doc1");
		template.getDocument().getDocumentGraph().setId("doc1");

		other = SaltFactory.createSDocumentGraph();
		other.setDocument(SaltFactory.createSDocument());
		other.getDocument().setId("doc2");
		other.getDocument().getDocumentGraph().setId("doc2");

		setFixture(new DocumentStructureDiff(template, other));
	}

	/**
	 * Tests two graphs containing
	 * <ul>
	 * <li>same primary date</li>
	 * <li>different primary date</li>
	 * <li>two primary data</li>
	 * </ul>
	 **/
	@Test
	public void testSize() {
		SampleGenerator.createPrimaryData(template.getDocument());
		SampleGenerator.createPrimaryData(other.getDocument());

		assertTrue(getFixture().isIsomorph());

		other.createToken(other.getTextualDSs().get(0), 1, 20);
		assertFalse(getFixture().isIsomorph());
	}

	/**
	 * Tests same and different textual data sources
	 */
	@Test
	public void testTextualDS_iso() {
		SampleGenerator.createPrimaryData(template.getDocument());
		STextualDS otherText = SampleGenerator.createPrimaryData(other.getDocument());
		assertTrue(getFixture().isIsomorph());

		otherText.setText("a template text");
		assertFalse(getFixture().isIsomorph());
	}

	/**
	 * Tests same and different textual data sources
	 */
	@Test
	public void testTextualDS_diff() {
		SampleGenerator.createPrimaryData(template.getDocument());
		STextualDS otherText = SampleGenerator.createPrimaryData(other.getDocument());
		Set<Difference> diffs = getFixture().findDiffs();
		assertEquals("" + diffs, 0, diffs.size());

		otherText.setText("a template text");
		diffs = getFixture().findDiffs();
		assertEquals("" + diffs, 2, diffs.size());
	}

	/**
	 * Tests for two tokens whether their annotations are isomorph.
	 */
	@Test
	public void testCompareAnnotationContainer() {
		STextualDS text1 = template.createTextualDS("Test");
		SToken templateTok = template.createToken(text1, 0, 5);

		STextualDS otherText = other.createTextualDS("Test");
		SToken otherTok = other.createToken(otherText, 0, 5);

		// no annotations
		Set<Difference> diffs = new HashSet<>();
		getFixture().compareAnnotationContainers(templateTok, otherTok, diffs);
		assertEquals("" + diffs, 0, diffs.size());

		// template has one annotation, other none
		templateTok.createAnnotation(null, "anno", "annoVal");
		diffs = new HashSet<>();
		getFixture().compareAnnotationContainers(templateTok, otherTok, diffs);
		assertEquals("" + diffs, 1, diffs.size());

		// both have one annotation
		otherTok.createAnnotation(null, "anno", "annoVal");
		diffs = new HashSet<>();
		getFixture().compareAnnotationContainers(templateTok, otherTok, diffs);
		assertEquals("" + diffs, 0, diffs.size());

		// template has two annotation, other has one
		templateTok.createAnnotation("namespace", "anno", "annoVal");
		diffs = new HashSet<>();
		getFixture().compareAnnotationContainers(templateTok, otherTok, diffs);
		assertEquals("" + diffs, 1, diffs.size());
	}

	/**
	 * Tests same and different tokens
	 */
	@Test
	public void testTokenCompare() {
		SampleGenerator.createPrimaryData(template.getDocument());
		SampleGenerator.createPrimaryData(other.getDocument());

		template.createToken(template.getTextualDSs().get(0), 0, 1);
		other.createToken(other.getTextualDSs().get(0), 0, 1);
		template.createToken(template.getTextualDSs().get(0), 2, 11);
		other.createToken(other.getTextualDSs().get(0), 2, 11);

		assertTrue(getFixture().isIsomorph());

		template.createToken(template.getTextualDSs().get(0), 12, 20);
		other.createToken(other.getTextualDSs().get(0), 12, 15);

		assertFalse(getFixture().isIsomorph());
		assertEquals(3, getFixture().getIsoNodes().size());
	}

	/**
	 * Tests the mapping table {@link Diff#getIsoNodes()} whether it contains
	 * the correct correspondence of token objects.
	 */
	@Test
	public void testTokenCompareIsoObjects() {
		SampleGenerator.createTokens(template.getDocument());
		SampleGenerator.createTokens(other.getDocument());

		assertTrue(getFixture().isIsomorph());
		int i = 0;
		for (SToken tok : template.getDocument().getDocumentGraph().getTokens()) {
			assertNotNull(getFixture().getIsoNodes().get(tok));
			assertEquals(tok, template.getDocument().getDocumentGraph().getTokens().get(i));
			i++;
		}
	}

	@Test
	public void testSNodeCompare() {
		SampleGenerator.createPrimaryData(template.getDocument());
		SampleGenerator.createPrimaryData(other.getDocument());

		template.createToken(template.getTextualDSs().get(0), 0, 1);
		other.createToken(other.getTextualDSs().get(0), 0, 1);
		template.createToken(template.getTextualDSs().get(0), 2, 5);
		other.createToken(other.getTextualDSs().get(0), 2, 5);
		template.createToken(template.getTextualDSs().get(0), 6, 8);
		other.createToken(other.getTextualDSs().get(0), 6, 8);
		template.createToken(template.getTextualDSs().get(0), 9, 11);
		other.createToken(other.getTextualDSs().get(0), 9, 11);

		SDominanceRelation sDominatingRelation = SaltFactory.createSDominanceRelation();
		SStructure templ_struc = SaltFactory.createSStructure();
		sDominatingRelation.setSource(templ_struc);
		sDominatingRelation.setTarget(template.getTokens().get(0));
		template.addNode(templ_struc);
		template.addRelation(sDominatingRelation);

		SDominanceRelation sDominatingRelation2 = SaltFactory.createSDominanceRelation();
		SStructure other_struc = SaltFactory.createSStructure();
		sDominatingRelation2.setSource(other_struc);
		sDominatingRelation2.setTarget(other.getTokens().get(0));
		other.addNode(other_struc);
		other.addRelation(sDominatingRelation2);

		assertTrue(getFixture().isIsomorph());

		SDominanceRelation sDominatingRelation3 = SaltFactory.createSDominanceRelation();
		sDominatingRelation3.setSource(templ_struc);
		sDominatingRelation3.setTarget(template.getTokens().get(1));
		template.addRelation(sDominatingRelation3);

		SDominanceRelation sDominatingRelation4 = SaltFactory.createSDominanceRelation();
		sDominatingRelation4.setSource(other_struc);
		sDominatingRelation4.setTarget(other.getTokens().get(2));
		other.addRelation(sDominatingRelation4);

		assertFalse(getFixture().isIsomorph());

	}

	@Test
	public void testPrimaryData() {
		SampleGenerator.createPrimaryData(template.getDocument());
		SampleGenerator.createPrimaryData(other.getDocument());

		// same primary date
		assertTrue(getFixture().isIsomorph());

		assertEquals(0, getFixture().findDiffs().size());

		// different primary date
		SampleGenerator.createPrimaryData(other.getDocument());
		other.getTextualDSs().get(0).setText("a different text");
		assertFalse(getFixture().isIsomorph());

		// two primary date
		SampleGenerator.createPrimaryData(other.getDocument());
		assertFalse(getFixture().isIsomorph());
	}

	/**
	 * Tests two graphs containing
	 * <ul>
	 * <li>same tokenization</li>
	 * <li>different tokenization - number of tokens</li>
	 * <li>different tokenization - different offsets</li>
	 * </ul>
	 */
	@Test
	public void testToken() {
		SampleGenerator.createPrimaryData(template.getDocument());
		SampleGenerator.createTokens(template.getDocument());
		SampleGenerator.createPrimaryData(other.getDocument());
		SampleGenerator.createTokens(other.getDocument());

		// same tokenization
		assertTrue(getFixture().isIsomorph());

		// different tokenization - number of tokens
		other.createToken(other.getTextualDSs().get(0), 1, 3);
		assertFalse(getFixture().isIsomorph());

		// different tokenization - different offsets
		SampleGenerator.createPrimaryData(other.getDocument());
		SampleGenerator.createTokens(other.getDocument());
		other.removeNode(other.getTokens().get(other.getTokens().size() - 1));
		other.createToken(other.getTextualDSs().get(0), 1, 20);
		assertFalse(getFixture().isIsomorph());
	}

	/**
	 * Checks the isomorphie for token annotation for listed cases:
	 * <ul>
	 * <li>same annotations</li>
	 * <li>different annotations - one additional annotation</li>
	 * <li>different annotations - different annotation names</li>
	 * </ul>
	 */
	@Test
	public void testTokenAnnotation() {
		SampleGenerator.createPrimaryData(template.getDocument());
		SampleGenerator.createTokens(template.getDocument());
		SampleGenerator.createPrimaryData(other.getDocument());
		SampleGenerator.createTokens(other.getDocument());

		for (SToken tok : template.getTokens()) {
			tok.createAnnotation(null, "annoName", "annoVal");
		}

		for (SToken tok : other.getTokens()) {
			tok.createAnnotation(null, "annoName", "annoVal");
		}
		// same annotations
		assertTrue(getFixture().isIsomorph());

		// different annotations - one additional annotation
		other.getTokens().get(0).createAnnotation(null, "annoName2", "annoVal");
		assertFalse(getFixture().isIsomorph());

		// different annotations - different annotation names
		SampleGenerator.createPrimaryData(other.getDocument());
		SampleGenerator.createTokens(other.getDocument());
		for (SToken tok : other.getTokens()) {
			tok.createAnnotation(null, "otherName", "annoVal");
		}
		assertFalse(getFixture().isIsomorph());
	}

	@Test
	public void testCheckAnno() throws FileNotFoundException {
		SampleGenerator.createPrimaryData(template.getDocument());
		SampleGenerator.createPrimaryData(other.getDocument());

		template.createToken(template.getTextualDSs().get(0), 0, 1);
		other.createToken(other.getTextualDSs().get(0), 0, 1);
		template.createToken(template.getTextualDSs().get(0), 2, 11);
		other.createToken(other.getTextualDSs().get(0), 2, 11);

		assertTrue(getFixture().isIsomorph());

		template.getTokens().get(0).createAnnotation(null, "A", "B");

		assertFalse(getFixture().isIsomorph());
	}

	@Test
	public void testSPointing() {
		SampleGenerator.createPrimaryData(template.getDocument());
		SampleGenerator.createPrimaryData(other.getDocument());

		template.createToken(template.getTextualDSs().get(0), 0, 1);
		other.createToken(other.getTextualDSs().get(0), 0, 1);
		template.createToken(template.getTextualDSs().get(0), 2, 11);
		other.createToken(other.getTextualDSs().get(0), 2, 11);

		assertTrue(getFixture().isIsomorph());
		SPointingRelation pr1 = SaltFactory.createSPointingRelation();
		pr1.setSource((SToken) template.getNodes().get(1));
		pr1.setTarget((SToken) template.getNodes().get(2));
		template.addRelation(pr1);

		assertFalse(getFixture().isIsomorph());

	}

	@Test
	public void testTwoLayers() {
		SampleGenerator.createPrimaryData(template.getDocument());
		SampleGenerator.createPrimaryData(other.getDocument());

		template.createToken(template.getTextualDSs().get(0), 0, 1);
		other.createToken(other.getTextualDSs().get(0), 0, 1);
		template.createToken(template.getTextualDSs().get(0), 2, 11);
		other.createToken(other.getTextualDSs().get(0), 2, 11);

		SLayer tempLayer = SaltFactory.createSLayer();
		template.addLayer(tempLayer);
		SLayer otherLayer = SaltFactory.createSLayer();
		other.addLayer(otherLayer);

		tempLayer.addNode(template.getTokens().get(0));
		otherLayer.addNode(other.getTokens().get(0));

		assertTrue(getFixture().isIsomorph());
		tempLayer.addNode(template.getTokens().get(1));
		assertFalse(getFixture().isIsomorph());
	}

	/**
	 * Checks differences between to graphs, which are isomorph. The here tested
	 * structure is
	 * {@link SampleGenerator#createSyntaxAnnotations(de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SDocument)}
	 */
	@Test
	public void test_SyntaxAnnotation() {
		SampleGenerator.createSyntaxAnnotations(template.getDocument());
		SampleGenerator.createSyntaxAnnotations(other.getDocument());
		Set<Difference> diffs = getFixture().findDiffs();
		assertEquals("" + diffs, 0, diffs.size());
	}

	/**
	 * Checks differences between to graphs, which are isomorph. The here tested
	 * structure is
	 * {@link SampleGenerator#createInformationStructureAnnotations(de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SDocument)}
	 * .
	 */
	@Test
	public void test_InformationStructureAnnotations() {
		SampleGenerator.createInformationStructureAnnotations(template.getDocument());
		SampleGenerator.createInformationStructureAnnotations(other.getDocument());

		Set<Difference> diffs = getFixture().findDiffs();
		assertEquals("" + diffs, 0, diffs.size());
	}

	/**
	 * Checks differences between to graphs, which are isomorph. The here tested
	 * structure is
	 * {@link SampleGenerator#createInformationStructureAnnotations(de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SDocument)}
	 * .
	 */
	@Test
	public void test_InformationStructureAnnotations_Fail() {
		SampleGenerator.createInformationStructureAnnotations(template.getDocument());
		SampleGenerator.createInformationStructureAnnotations(other.getDocument());
		other.getDocument().getDocumentGraph().removeNode(other.getDocument().getDocumentGraph().getSpans().get(0));
		Set<Difference> diffs = getFixture().findDiffs();
		assertEquals("" + diffs, 1, diffs.size());
	}

	/**
	 * Checks differences between to graphs, which are isomorph. The here tested
	 * structure is
	 * {@link SampleGenerator#createDependencies(de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SDocument)}
	 */
	@Test
	public void test_Dependencies() {
		SampleGenerator.createDependencies(template.getDocument());
		SampleGenerator.createDependencies(other.getDocument());
		Set<Difference> diffs = getFixture().findDiffs();
		assertEquals(0, diffs.size());
	}

	/**
	 * Checks differences between to graphs, which are isomorph. The here tested
	 * structure is:
	 * <ul>
	 * <li>
	 * {@link SampleGenerator#createInformationStructureAnnotations(de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SDocument)}
	 * </li>
	 * <li>
	 * {@link SampleGenerator#createSyntaxAnnotations(de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SDocument)}
	 * </li>
	 * <li>
	 * {@link SampleGenerator#createDependencies(de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SDocument)
	 * </li>
	 * </ul>
	 */
	@Test
	public void test_AllSamples() {
		SampleGenerator.createInformationStructureAnnotations(template.getDocument());
		SampleGenerator.createSyntaxAnnotations(template.getDocument());
		SampleGenerator.createDependencies(template.getDocument());
		SampleGenerator.createInformationStructureAnnotations(other.getDocument());
		SampleGenerator.createSyntaxAnnotations(other.getDocument());
		SampleGenerator.createDependencies(other.getDocument());

		Set<Difference> diffs = getFixture().findDiffs();
		assertEquals("" + diffs, 0, diffs.size());
	}

	/**
	 * this test reveals faulty diff testing AND output, when the document's id
	 * is not set the two graphs are identical (except of the document's id).
	 * They look like this:
	 * 
	 * <pre>
	 * SPAN4---SPAN4---SPAN4 <--LABEL[ns::function="all"]
	 * 					SPAN3 <--LABEL[ns::function="tail"]
	 * 			SPAN2---SPAN2 <--LABEL[ns::function="none"]
	 * 	SPAN1 <------------------LABEL[ns::function="being nice"]
	 *  TOK-0	TOK-1	TOK-2
	 * </pre>
	 */
	@Test
	public void testMultipleChildsMultipleParents() {
		SDocument doc1 = SaltFactory.createSDocument();
		SDocument doc2 = SaltFactory.createSDocument();
		doc2.setId("doc");

		SDocumentGraph dg1 = null;
		{// create document graph 1
			dg1 = SaltFactory.createSDocumentGraph();
			doc1.setDocumentGraph(dg1);
			dg1.createTextualDS("hallo hallo hallo");
			dg1.tokenize();
			dg1.createSpan(dg1.getTokens().get(0)).createAnnotation("ns", "function", "being nice");
			List<SToken> tokens = new ArrayList<SToken>();
			tokens.add(dg1.getTokens().get(1));
			tokens.add(dg1.getTokens().get(2));
			dg1.createSpan(tokens).createAnnotation("ns", "function", "none");
			dg1.createSpan(dg1.getTokens().get(2)).createAnnotation("ns", "function", "tail");
			dg1.createSpan(dg1.getTokens()).createAnnotation("ns", "function", "all");
		}

		SDocumentGraph dg2 = null;
		{// create document graph 2
			dg2 = SaltFactory.createSDocumentGraph();
			doc2.setDocumentGraph(dg2);
			dg2.createTextualDS("hallo hallo hallo");
			dg2.tokenize();
			dg2.createSpan(dg2.getTokens().get(0)).createAnnotation("ns", "function", "being nice");
			List<SToken> tokens = new ArrayList<SToken>();
			tokens.add(dg2.getTokens().get(1));
			tokens.add(dg2.getTokens().get(2));
			dg2.createSpan(tokens).createAnnotation("ns", "function", "none");
			dg2.createSpan(dg2.getTokens().get(2)).createAnnotation("ns", "function", "tail");
			dg2.createSpan(dg2.getTokens()).createAnnotation("ns", "function", "all");
		}

		Set<Difference> diffs = dg1.findDiffs(dg2, (new DiffOptions()).setOption(DiffOptions.OPTION_IGNORE_ID, true));
		assertEquals(diffs.toString(), 0, diffs.size());
	}

	/**
	 * Checks whether ids are ignored, when {@link DiffOptions#OPTION_IGNORE_ID}
	 * option is set to true.
	 */
	@Test
	public void test_Options() {
		SDocumentGraph graph1 = SaltFactory.createSDocumentGraph();
		STextualDS text1 = graph1.createTextualDS("This is a sample");
		graph1.addNode(text1);
		SToken tok1 = SaltFactory.createSToken();
		tok1.setName("tok");
		graph1.addNode(tok1);
		STextualRelation rel = SaltFactory.createSTextualRelation();
		rel.setSource(tok1);
		rel.setTarget(text1);
		rel.setStart(0);
		rel.setEnd(4);
		graph1.addRelation(rel);

		SDocumentGraph graph2 = SaltFactory.createSDocumentGraph();
		STextualDS text2 = graph2.createTextualDS("This is a sample");
		graph2.addNode(text2);
		SToken tok2 = SaltFactory.createSToken();
		tok2.setName("other");
		graph2.addNode(tok2);
		rel = SaltFactory.createSTextualRelation();
		rel.setSource(tok2);
		rel.setTarget(text2);
		rel.setStart(0);
		rel.setEnd(4);
		graph2.addRelation(rel);

		// rename name, that the isomorphie check will not find a difference in
		// name
		tok2.setName("tok");

		DiffOptions options = new DiffOptions();
		options.setOption(DiffOptions.OPTION_IGNORE_ID, true);
		Set<Difference> diffs = graph1.findDiffs(graph2, options);
		assertEquals(diffs + "", 0, diffs.size());

		options.setOption(DiffOptions.OPTION_IGNORE_ID, false);
		diffs = graph1.findDiffs(graph2, options);
		assertEquals(diffs + "", 1, diffs.size());
	}

	/**
	 * Tests the comparison of two equal graphs, which are created in
	 * {@link #createSampleGraph()}.
	 */
	@Test
	public void testTwoIdenticalGraphs() {
		SDocument doc1 = createSampleGraph();
		SDocument doc2 = createSampleGraph();

		Set<Difference> diffs = doc1.getDocumentGraph().findDiffs(doc2.getDocumentGraph(),
				(new DiffOptions()).setOption(DiffOptions.OPTION_IGNORE_ID, true));
		assertEquals(diffs.toString(), 0, diffs.size());
	}

	/**
	 * 
	 * 
	 * 
	 * <table border="1">
	 * <tr>
	 * <td colspan="4"></td>
	 * <td colspan="6">line</td>
	 * <td></td>
	 * </tr>
	 * <tr>
	 * <td colspan="4"></td>
	 * <td colspan="6">page</td>
	 * <td></td>
	 * </tr>
	 * <tr>
	 * <td>t1</td>
	 * <td>t2</td>
	 * <td>t3</td>
	 * <td>t4</td>
	 * <td>t5</td>
	 * <td>t6</td>
	 * <td>t7</td>
	 * <td>t8</td>
	 * <td>t9</td>
	 * <td>t10</td>
	 * <td>t11</td>
	 * </tr>
	 * <tr>
	 * </td>
	 * <td>Is</td>
	 * <td>this</td>
	 * <td>example</td>
	 * <td>more</td>
	 * <td>complicated</td>
	 * <td>than</td>
	 * <td>it</td>
	 * <td>appears</td>
	 * <td>to</td>
	 * <td>be</td>
	 * <td>?</td>
	 * </tr>
	 * </table>
	 * 
	 * @return
	 */
	public SDocument createSampleGraph() {
		String exampleText = "Is this example more complicated than it appears to be?";
		String layerTextStructure = "textstructure";
		String type = "type";

		SDocument doc1 = SaltFactory.createSDocument();
		doc1.setId("doc");
		SDocumentGraph docGraph = SaltFactory.createSDocumentGraph();
		doc1.setDocumentGraph(docGraph);
		docGraph.createTextualDS(exampleText);
		docGraph.tokenize();
		List<SToken> docTokens = docGraph.getTokens();
		SLayer docTextLayer = SaltFactory.createSLayer();
		docTextLayer.setName(layerTextStructure);
		docGraph.addLayer(docTextLayer);
		SSpan sSpan = null;
		List<SToken> spanTokens = new ArrayList<SToken>();

		// page2:
		spanTokens.clear();
		spanTokens.add(docTokens.get(5));
		spanTokens.add(docTokens.get(6));
		spanTokens.add(docTokens.get(7));
		spanTokens.add(docTokens.get(8));
		spanTokens.add(docTokens.get(9));
		spanTokens.add(docTokens.get(10));
		sSpan = docGraph.createSpan(spanTokens);
		sSpan.createAnnotation(layerTextStructure, type, "page");
		docTextLayer.addNode(sSpan);

		// line3:
		spanTokens.clear();
		spanTokens.add(docTokens.get(5));
		spanTokens.add(docTokens.get(6));
		spanTokens.add(docTokens.get(7));
		spanTokens.add(docTokens.get(8));
		spanTokens.add(docTokens.get(9));
		spanTokens.add(docTokens.get(10));
		sSpan = docGraph.createSpan(spanTokens);
		sSpan.createAnnotation(layerTextStructure, type, "line");
		docTextLayer.addNode(sSpan);

		return (doc1);
	}

	/**
	 * Tests the comparison of a graph with itself.
	 */
	@Test
	public void testSameGraph() {
		SDocument doc = SaltFactory.createSDocument();
		SampleGenerator.createSyntaxAnnotations(doc);
		SampleGenerator.createAnaphoricAnnotations(doc);
		SampleGenerator.createInformationStructureAnnotations(doc);
		SampleGenerator.createDependencies(doc);

		Set<Difference> diffs = doc.getDocumentGraph().findDiffs(doc.getDocumentGraph());
		assertEquals(diffs.toString(), 0, diffs.size());
	}
}
