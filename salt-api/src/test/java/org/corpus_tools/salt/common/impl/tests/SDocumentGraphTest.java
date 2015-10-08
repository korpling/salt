package org.corpus_tools.salt.common.impl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.corpus_tools.salt.SALT_TYPE;
import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.common.SDominanceRelation;
import org.corpus_tools.salt.common.SMedialDS;
import org.corpus_tools.salt.common.SMedialRelation;
import org.corpus_tools.salt.common.SOrderRelation;
import org.corpus_tools.salt.common.SPointingRelation;
import org.corpus_tools.salt.common.SSpan;
import org.corpus_tools.salt.common.SSpanningRelation;
import org.corpus_tools.salt.common.SStructure;
import org.corpus_tools.salt.common.SStructuredNode;
import org.corpus_tools.salt.common.STextualDS;
import org.corpus_tools.salt.common.STextualRelation;
import org.corpus_tools.salt.common.STimeline;
import org.corpus_tools.salt.common.STimelineRelation;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.common.tokenizer.Tokenizer;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.exceptions.SaltElementNotInGraphException;
import org.corpus_tools.salt.graph.Relation;
import org.corpus_tools.salt.util.DataSourceSequence;
import org.corpus_tools.salt.util.SaltUtil;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multimap;

public class SDocumentGraphTest {

	protected SDocumentGraph fixture = null;

	public SDocumentGraph getFixture() {
		return fixture;
	}

	public void setFixture(SDocumentGraph fixture) {
		this.fixture = fixture;
	}

	@Before
	public void setUp() throws Exception {
		setFixture(SaltFactory.createSDocumentGraph());
	}

	@Test
	public void testSetGetDocument() {
		assertNull(getFixture().getDocument());
		SDocument document = SaltFactory.createSDocument();
		getFixture().setDocument(document);
		assertNotNull(getFixture().getDocument());
		assertEquals(document, getFixture().getDocument());

		// test double chaining
		assertEquals(getFixture(), document.getDocumentGraph());
		getFixture().setDocument(null);
		assertNull(document.getDocumentGraph());
		assertNull(getFixture().getDocument());
	}

	@Test
	public void testGetSTextualDSs() {
		String[] ids = { "salt:/graph1#text1", "salt:/graph1#text2", "salt:/graph1#text3", "salt:/graph1#text4" };
		List<STextualDS> textDSs = new ArrayList<>();
		for (String id : ids) {
			STextualDS textDs = SaltFactory.createSTextualDS();
			textDs.setId(id);
			getFixture().addNode(textDs);
			textDSs.add(textDs);
		}

		assertTrue(textDSs.containsAll(getFixture().getTextualDSs()));
		assertTrue(getFixture().getTextualDSs().containsAll(textDSs));
	}

	@Test
	public void testGetSTextualRelations() {
		String[] ids = { "salt:/graph1#textRel1", "salt:/graph1#textRel2", "salt:/graph1#textRel3", "salt:/graph1#textRel4" };
		SToken source = SaltFactory.createSToken();
		getFixture().addNode(source);
		STextualDS target = SaltFactory.createSTextualDS();
		getFixture().addNode(target);
		List<STextualRelation> rels = new ArrayList<>();
		for (String id : ids) {
			STextualRelation rel = SaltFactory.createSTextualRelation();
			rel.setSource(source);
			rel.setTarget(target);
			rel.setId(id);
			getFixture().addRelation(rel);
			rels.add(rel);
		}
		assertTrue(rels.containsAll(getFixture().getTextualRelations()));
		assertTrue(getFixture().getTextualRelations().containsAll(rels));
	}

	@Test
	public void testGetSTokens() {
		String[] ids = { "salt:/graph1#tok1", "salt:/graph1#tok2", "salt:/graph1#tok3", "salt:/graph1#tok4" };
		List<SToken> toks = new ArrayList<>();
		for (String id : ids) {
			SToken tok = SaltFactory.createSToken();
			tok.setId(id);
			getFixture().addNode(tok);
			toks.add(tok);
		}

		assertTrue(toks.containsAll(getFixture().getTokens()));
		assertTrue(getFixture().getTokens().containsAll(toks));
	}

	// @Test
	// public void testGetSTimeline() {
	// STimeline sTimeline = SaltFactory.createSTimeline();
	// List<String> timeline = new ArrayList<String>();
	// timeline.add("1.0");
	// timeline.add("1.1");
	// timeline.add("1.2");
	// timeline.add("1.3");
	// timeline.add("1.4");
	// for (String point : timeline){
	// sTimeline.increasePointOfTime();
	// }
	// getFixture().setTimeline(sTimeline);
	// assertNotNull(getFixture().getTimeline());
	// assertNotNull(getFixture().getTimeline().getEnd());
	// for (String point1 : timeline) {
	// boolean hasOpponend = false;
	// for (String point2 : getFixture().getTimeline().getEnd()) {
	// if (point1.equals(point2))
	// hasOpponend = true;
	// }
	// assertTrue(hasOpponend);
	// }
	// assertTrue(timeline.containsAll(getFixture().getTimeline().getEnd()));
	// assertTrue(getFixture().getTimeline().getEnd().containsAll(timeline));
	// }

	@Test
	public void testGetSTimelineRelations() {
		List<STimelineRelation> timeRels = new ArrayList<>();
		SToken source = SaltFactory.createSToken();
		getFixture().addNode(source);
		STimeline target = SaltFactory.createSTimeline();
		getFixture().addNode(target);
		for (int i = 0; i < 10; i++) {
			STimelineRelation rel = SaltFactory.createSTimelineRelation();
			rel.setSource(source);
			rel.setTarget(target);
			timeRels.add(rel);
			getFixture().addRelation(rel);
		}
		assertTrue(timeRels.containsAll(getFixture().getTimelineRelations()));
		assertTrue(getFixture().getTimelineRelations().containsAll(timeRels));
	}

	@Test
	public void testGetSSpanningRelations() {
		List<SSpanningRelation> spanRels = new ArrayList<>();
		SSpan source = SaltFactory.createSSpan();
		getFixture().addNode(source);
		SToken target = SaltFactory.createSToken();
		getFixture().addNode(target);
		for (int i = 0; i < 10; i++) {
			SSpanningRelation rel = SaltFactory.createSSpanningRelation();
			rel.setSource(source);
			rel.setTarget(target);
			spanRels.add(rel);
			getFixture().addRelation(rel);
		}
		assertTrue(spanRels.containsAll(getFixture().getSpanningRelations()));
		assertTrue(getFixture().getSpanningRelations().containsAll(spanRels));
	}

	@Test
	public void testGetSSpans() {
		String[] names = { "salt:/graph1#span1", "salt:/graph1#span2", "salt:/graph1#span3", "salt:/graph1#span4" };
		List<SSpan> spans = new ArrayList<>();
		for (String name : names) {
			SSpan span = SaltFactory.createSSpan();
			span.setName(name);
			getFixture().addNode(span);
			spans.add(span);
		}

		assertTrue(spans.containsAll(getFixture().getSpans()));
		assertTrue(getFixture().getSpans().containsAll(spans));
	}

	@Test
	public void testGetSStructures() {
		String[] names = { "salt:/graph1#structure1", "salt:/graph1#structure2", "salt:/graph1#structure3", "salt:/graph1#structure4" };
		List<SStructure> structures = new ArrayList<>();
		for (String name : names) {
			SStructure structure = SaltFactory.createSStructure();
			structure.setName(name);
			getFixture().addNode(structure);
			structures.add(structure);
		}

		assertTrue(structures.containsAll(getFixture().getStructures()));
		assertTrue(getFixture().getStructures().containsAll(structures));
	}

	@Test
	public void testGetSDominanceRelations() {
		SStructure source = SaltFactory.createSStructure();
		getFixture().addNode(source);
		SStructure target = SaltFactory.createSStructure();
		getFixture().addNode(target);
		List<SDominanceRelation> rels = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			SDominanceRelation rel = SaltFactory.createSDominanceRelation();
			rel.setSource(source);
			rel.setTarget(target);
			rels.add(rel);
			getFixture().addRelation(rel);
		}
		assertTrue(rels.containsAll(getFixture().getDominanceRelations()));
		assertTrue(getFixture().getDominanceRelations().containsAll(rels));
	}

	@Test
	public void testGetSPointingRelations() {
		SStructure source = SaltFactory.createSStructure();
		getFixture().addNode(source);
		SStructure target = SaltFactory.createSStructure();
		getFixture().addNode(target);
		List<SPointingRelation> rels = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			SPointingRelation rel = SaltFactory.createSPointingRelation();
			rel.setSource(source);
			rel.setTarget(target);
			rels.add(rel);
			getFixture().addRelation(rel);
		}
		assertTrue(rels.containsAll(getFixture().getPointingRelations()));
		assertTrue(getFixture().getPointingRelations().containsAll(rels));
	}

	@Test
	public void testGetSMedialRelations() {
		List<SMedialRelation> sAudioRels = new ArrayList<>();
		SToken source = SaltFactory.createSToken();
		getFixture().addNode(source);
		SMedialDS target = SaltFactory.createSMedialDS();
		getFixture().addNode(target);
		for (int i = 0; i < 10; i++) {
			SMedialRelation rel = SaltFactory.createSMedialRelation();
			rel.setSource(source);
			rel.setTarget(target);
			sAudioRels.add(rel);
			getFixture().addRelation(rel);
		}
		assertTrue(sAudioRels.containsAll(getFixture().getMedialRelations()));
		assertTrue(getFixture().getMedialRelations().containsAll(sAudioRels));
	}

	@Test
	public void testGetSMediaDSs() {
		SMedialDS sAudioDS = SaltFactory.createSMedialDS();
		getFixture().addNode(sAudioDS);
		assertTrue(getFixture().getMedialDSs().contains(sAudioDS));
	}

	@Test
	public void testGetSOrderRelations() {
		List<SOrderRelation> orderRels = new ArrayList<>();
		SToken source = SaltFactory.createSToken();
		getFixture().addNode(source);
		SToken target = SaltFactory.createSToken();
		getFixture().addNode(target);
		for (int i = 0; i < 10; i++) {
			SOrderRelation rel = SaltFactory.createSOrderRelation();
			rel.setSource(source);
			rel.setTarget(target);
			orderRels.add(rel);
			getFixture().addRelation(rel);
		}
		assertTrue(orderRels.containsAll(getFixture().getOrderRelations()));
		assertTrue(getFixture().getOrderRelations().containsAll(orderRels));
	}

	@Test
	public void testAddSNode__SNode_SNode_SALT_TYPE() {

		// test for SPOINTING_RELATION
		{
			SToken source = SaltFactory.createSToken();
			SToken target = SaltFactory.createSToken();
			// calling addNode now should throw an
			// SaltElementNotInGraphException
			try {
				getFixture().addNode(source, target, SALT_TYPE.SPOINTING_RELATION);
				fail();
			} catch (SaltElementNotInGraphException e) {
			}
			getFixture().addNode(source);
			SRelation sRelation = getFixture().addNode(source, target, SALT_TYPE.SPOINTING_RELATION);
			assertTrue(sRelation instanceof SPointingRelation);
		}

		// test for STEXTUAL_RELATION
		{
			SToken source = SaltFactory.createSToken();
			STextualDS target = SaltFactory.createSTextualDS();
			// calling addNode now should throw an
			// SaltElementNotInGraphException
			try {
				getFixture().addNode(source, target, SALT_TYPE.STEXTUAL_RELATION);
				fail();
			} catch (SaltElementNotInGraphException e) {
			}
			getFixture().addNode(source);
			SRelation sRelation = getFixture().addNode(source, target, SALT_TYPE.STEXTUAL_RELATION);
			assertTrue(sRelation instanceof STextualRelation);
		}

		// test for SDOMINANCE_RELATION
		{
			SStructure source = SaltFactory.createSStructure();
			SToken target = SaltFactory.createSToken();
			// calling addNode now should throw an
			// SaltElementNotInGraphException
			try {
				getFixture().addNode(source, target, SALT_TYPE.SDOMINANCE_RELATION);
				fail();
			} catch (SaltElementNotInGraphException e) {
			}
			getFixture().addNode(source);
			SRelation sRelation = getFixture().addNode(source, target, SALT_TYPE.SDOMINANCE_RELATION);
			assertTrue(sRelation instanceof SDominanceRelation);
		}

		// test for SSPANNING_RELATION
		{
			SSpan source = SaltFactory.createSSpan();
			SToken target = SaltFactory.createSToken();
			// calling addNode now should throw an
			// SaltElementNotInGraphException
			try {
				getFixture().addNode(source, target, SALT_TYPE.SSPANNING_RELATION);
				fail();
			} catch (SaltElementNotInGraphException e) {
			}
			getFixture().addNode(source);
			SRelation sRelation = getFixture().addNode(source, target, SALT_TYPE.SSPANNING_RELATION);
			assertTrue(sRelation instanceof SSpanningRelation);
		}

	}

	@Test
	public void testCreateSTextualDS__String() {
		String sText = "This is a new primary text.";
		STextualDS sTextualDS = getFixture().createTextualDS(sText);
		assertNotNull(sTextualDS);
		assertEquals(sText, sTextualDS.getText());
		assertTrue(getFixture().getTextualDSs().contains(sTextualDS));
	}

	@Test
	public void testcreateToken__EList() {
		String text = "This is a sample text.";
		STextualDS stext = getFixture().createTextualDS(text);

		List<DataSourceSequence> sequences = null;

		try {
			getFixture().createToken(sequences);
			fail("empty param");
		} catch (Exception e) {
		}

		sequences = new ArrayList<>();
		DataSourceSequence sequence = null;

		sequences.add(sequence);
		try {
			getFixture().createToken(sequences);
			fail("empty data-source value");
		} catch (Exception e) {
		}
		sequences = new ArrayList<>();
		sequence = new DataSourceSequence();
		sequences.add(sequence);
		sequence.setDataSource(stext);

		try {
			getFixture().createToken(sequences);
			fail("empty start value");
		} catch (Exception e) {
		}
		sequence.setStart(0);
		try {
			getFixture().createToken(sequences);
			fail("empty end value");
		} catch (Exception e) {
		}
		sequence.setEnd(4);

		SToken sToken = getFixture().createToken(sequences);

		assertNotNull(sToken);
		assertEquals(sToken, getFixture().getNode(sToken.getId()));
	}

	@Test
	public void testcreateToken__DataSourceSequence() {
		String text = "This is a sample text.";
		DataSourceSequence sequence = null;
		STextualDS stext = getFixture().createTextualDS(text);

		try {
			getFixture().createToken(sequence);
			fail("empty data-source value");
		} catch (Exception e) {
		}
		sequence = new DataSourceSequence();
		sequence.setDataSource(stext);

		try {
			getFixture().createToken(sequence);
			fail("empty start value");
		} catch (Exception e) {
		}
		sequence.setStart(0);
		try {
			getFixture().createToken(sequence);
			fail("empty end value");
		} catch (Exception e) {
		}
		sequence.setEnd(4);

		SToken sToken = getFixture().createToken(sequence);

		assertNotNull(sToken);
		assertEquals(sToken, getFixture().getNode(sToken.getId()));
	}

	@Test
	public void testCreateSTimeline() {
		{// text 1
			STextualDS sText1 = SaltFactory.createSTextualDS();
			sText1.setText("Hello, text1.");
			getFixture().addNode(sText1);
			SToken sToken = null;
			STextualRelation sTextRel = null;

			sToken = SaltFactory.createSToken();
			getFixture().addNode(sToken);
			sTextRel = SaltFactory.createSTextualRelation();
			sTextRel.setTarget(sText1);
			sTextRel.setSource(sToken);
			sTextRel.setStart(0);
			sTextRel.setEnd(5);
			getFixture().addRelation(sTextRel);

			sToken = SaltFactory.createSToken();
			getFixture().addNode(sToken);
			sTextRel = SaltFactory.createSTextualRelation();
			sTextRel.setTarget(sText1);
			sTextRel.setSource(sToken);
			sTextRel.setStart(5);
			sTextRel.setEnd(6);
			getFixture().addRelation(sTextRel);

			sToken = SaltFactory.createSToken();
			getFixture().addNode(sToken);
			sTextRel = SaltFactory.createSTextualRelation();
			sTextRel.setTarget(sText1);
			sTextRel.setSource(sToken);
			sTextRel.setStart(7);
			sTextRel.setEnd(12);
			getFixture().addRelation(sTextRel);

			sToken = SaltFactory.createSToken();
			getFixture().addNode(sToken);
			sTextRel = SaltFactory.createSTextualRelation();
			sTextRel.setTarget(sText1);
			sTextRel.setSource(sToken);
			sTextRel.setStart(12);
			sTextRel.setEnd(13);
			getFixture().addRelation(sTextRel);

		}

		{// text 1
			STextualDS sText2 = SaltFactory.createSTextualDS();
			sText2.setText("Hello, Text2.");
			getFixture().addNode(sText2);
			SToken sToken = null;
			STextualRelation sTextRel = null;

			sToken = SaltFactory.createSToken();
			getFixture().addNode(sToken);
			sTextRel = SaltFactory.createSTextualRelation();
			sTextRel.setTarget(sText2);
			sTextRel.setSource(sToken);
			sTextRel.setStart(0);
			sTextRel.setEnd(5);
			getFixture().addRelation(sTextRel);

			sToken = SaltFactory.createSToken();
			getFixture().addNode(sToken);
			sTextRel = SaltFactory.createSTextualRelation();
			sTextRel.setTarget(sText2);
			sTextRel.setSource(sToken);
			sTextRel.setStart(5);
			sTextRel.setEnd(6);
			getFixture().addRelation(sTextRel);

			sToken = SaltFactory.createSToken();
			getFixture().addNode(sToken);
			sTextRel = SaltFactory.createSTextualRelation();
			sTextRel.setTarget(sText2);
			sTextRel.setSource(sToken);
			sTextRel.setStart(7);
			sTextRel.setEnd(12);
			getFixture().addRelation(sTextRel);

			sToken = SaltFactory.createSToken();
			getFixture().addNode(sToken);
			sTextRel = SaltFactory.createSTextualRelation();
			sTextRel.setTarget(sText2);
			sTextRel.setSource(sToken);
			sTextRel.setStart(12);
			sTextRel.setEnd(13);
			getFixture().addRelation(sTextRel);
		}

		getFixture().createTimeline();
		assertNotNull(getFixture().getTimeline());
		assertEquals(8, getFixture().getTimelineRelations().size());

		assertEquals(Integer.valueOf(8), getFixture().getTimeline().getEnd());
	}

	/**
	 * Tests if tokens are correctly returned to corresponding
	 * {@link DataSourceSequence} objects. text1: tok2, tok6, tok1, tok4, tok5,
	 * tok3 text2: tok3, tok2, tok1
	 * 
	 * test11: covers tok1 of text 1 test12: covers tok2, tok3, tok4 of text 1
	 * test13: covers all tokens of text 1 test14: covers all tokens of text 2
	 */
	@Test
	public void testGetSNodeBySequence__DataSourceSequence() {
		String text1 = "This is a sample text.";
		String text2 = "A sample text.";

		// start: create sample graph
		// start: sTokens for sText1
		STextualDS sText1 = getFixture().createTextualDS(text1);

		SToken tok2 = getFixture().createToken(sText1, 5, 7);
		tok2.setName("tok2");

		SToken tok6 = getFixture().createToken(sText1, 21, 22);
		tok6.setName("tok6");

		SToken tok1 = getFixture().createToken(sText1, 0, 4);
		tok1.setName("tok1");

		SToken tok4 = getFixture().createToken(sText1, 10, 16);
		tok4.setName("tok4");

		SToken tok5 = getFixture().createToken(sText1, 17, 21);
		tok5.setName("tok5");

		SToken tok3 = getFixture().createToken(sText1, 8, 9);
		tok3.setName("tok3");
		// end: sTokens for sText1
		// start: sTokens for sText2
		STextualDS sText2 = getFixture().createTextualDS(text2);

		SToken tok3_1 = getFixture().createToken(sText2, 9, 13);
		tok3_1.setName("tok3_1");

		SToken tok2_1 = getFixture().createToken(sText2, 2, 8);
		tok2_1.setName("tok2_1");

		SToken tok1_1 = getFixture().createToken(sText2, 0, 1);
		tok1_1.setName("tok1_1");
		// end: sTokens for sText1
		// end: create sample graph

		DataSourceSequence sequence = null;
		List<SNode> coveredSTokens = null;

		// start: test1
		sequence = new DataSourceSequence();
		sequence.setDataSource(sText1);
		sequence.setStart(0);
		sequence.setEnd(4);

		coveredSTokens = getFixture().getNodesBySequence(sequence);
		assertNotNull(coveredSTokens);
		assertEquals("covered tokens are: " + coveredSTokens, 1, coveredSTokens.size());
		assertTrue(coveredSTokens.contains(tok1));
		// end: test 1

		// start: test2
		sequence = new DataSourceSequence();
		sequence.setDataSource(sText1);
		sequence.setStart(5);
		sequence.setEnd(16);

		coveredSTokens = getFixture().getNodesBySequence(sequence);
		assertNotNull(coveredSTokens);
		assertEquals(3, coveredSTokens.size());
		assertTrue(coveredSTokens.contains(tok2));
		assertTrue(coveredSTokens.contains(tok3));
		assertTrue(coveredSTokens.contains(tok4));
		// end: test 2

		// start: test3
		sequence = new DataSourceSequence();
		sequence.setDataSource(sText1);
		sequence.setStart(0);
		sequence.setEnd(sText1.getText().length());

		coveredSTokens = getFixture().getNodesBySequence(sequence);
		assertNotNull(coveredSTokens);
		assertEquals(6, coveredSTokens.size());
		assertTrue(coveredSTokens.contains(tok1));
		assertTrue(coveredSTokens.contains(tok2));
		assertTrue(coveredSTokens.contains(tok3));
		assertTrue(coveredSTokens.contains(tok4));
		assertTrue(coveredSTokens.contains(tok5));
		assertTrue(coveredSTokens.contains(tok6));
		// end: test 3

		// start: test3
		sequence = new DataSourceSequence();
		sequence.setDataSource(sText2);
		sequence.setStart(0);
		sequence.setEnd(sText2.getText().length());

		coveredSTokens = getFixture().getNodesBySequence(sequence);
		assertNotNull(coveredSTokens);
		assertEquals(3, coveredSTokens.size());
		assertTrue(coveredSTokens.contains(tok1_1));
		assertTrue(coveredSTokens.contains(tok2_1));
		assertTrue(coveredSTokens.contains(tok3_1));
		// end: test 3
	}

	/**
	 * Tests the following graph, and checks if the correct sequences are
	 * overlapped: struct1 struct3 / \ / \ struct2 span1 \ | / \ \ tok1 tok2
	 * tok3 tok4 tok5
	 * 
	 * 
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getOverlappedDSSequences(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode)
	 */
	@Test
	public void testGetOverlappedDSSequences__SNode_EList() {
		String text = "This is a sample text.";
		DataSourceSequence dsSequence = new DataSourceSequence();
		// start: create sample graph
		STextualDS sText = getFixture().createTextualDS(text);
		dsSequence.setDataSource(sText);

		dsSequence.setStart(0);
		dsSequence.setEnd(4);
		SToken tok1 = getFixture().createToken(dsSequence);
		tok1.setName("tok1");

		dsSequence.setStart(5);
		dsSequence.setEnd(7);
		SToken tok2 = getFixture().createToken(dsSequence);
		tok2.setName("tok2");

		dsSequence.setStart(8);
		dsSequence.setEnd(9);
		SToken tok3 = getFixture().createToken(dsSequence);
		tok3.setName("tok3");

		dsSequence.setStart(10);
		dsSequence.setEnd(16);
		SToken tok4 = getFixture().createToken(dsSequence);
		tok4.setName("tok4");

		dsSequence.setStart(17);
		dsSequence.setEnd(21);
		SToken tok5 = getFixture().createToken(dsSequence);
		tok5.setName("tok5");

		dsSequence.setStart(21);
		dsSequence.setEnd(22);
		SToken tok6 = getFixture().createToken(dsSequence);
		tok6.setName("tok6");

		List<SStructuredNode> overlappedNodes = null;
		List<SToken> overlappedTokens = null;

		SStructure struct2 = getFixture().createSStructure(tok1);
		struct2.setName("struct2");

		overlappedTokens = new ArrayList<>();
		overlappedTokens.add(tok2);
		overlappedTokens.add(tok3);
		SSpan span1 = getFixture().createSpan(overlappedTokens);
		span1.setName("span1");

		overlappedNodes = new ArrayList<>();
		overlappedNodes.add(struct2);
		overlappedNodes.add(span1);
		SStructure struct1 = getFixture().createStructure(overlappedNodes);
		struct1.setName("struct1");

		overlappedNodes = new ArrayList<>();
		overlappedNodes.add(span1);
		overlappedNodes.add(tok5);
		SStructure struct3 = getFixture().createStructure(overlappedNodes);
		struct3.setName("struct3");
		// end: create sample graph

		DataSourceSequence sequence = null;
		List<SALT_TYPE> saltTypes = new ArrayList<>();
		saltTypes.add(SALT_TYPE.STEXT_OVERLAPPING_RELATION);
		sequence = getFixture().getOverlappedDataSourceSequence(struct2, saltTypes).get(0);
		assertNotNull(sequence);
		assertEquals(0, sequence.getStart());
		assertEquals(4, sequence.getEnd());

		sequence = getFixture().getOverlappedDataSourceSequence(struct1, saltTypes).get(0);
		assertNotNull(sequence);
		assertEquals(0, sequence.getStart());
		assertEquals(9, sequence.getEnd());

		sequence = getFixture().getOverlappedDataSourceSequence(span1, saltTypes).get(0);
		assertNotNull(sequence);
		assertEquals(5, sequence.getStart());
		assertEquals(9, sequence.getEnd());

		sequence = getFixture().getOverlappedDataSourceSequence(struct3, saltTypes).get(0);
		assertNotNull(sequence);
		assertEquals(5, sequence.getStart());
		assertEquals(21, sequence.getEnd());
	}

	/**
	 * Checks that when given a {@link STextualDS} as node, if the entire data
	 * source is returned.
	 */
	@Test
	public void testGetOverlappedDSSequences__STextualDS_EList() {
		STextualDS sTextualDs = SaltFactory.createSTextualDS();
		getFixture().addNode(sTextualDs);
		List<SALT_TYPE> relations = new ArrayList<>();
		relations.add(SALT_TYPE.STEXT_OVERLAPPING_RELATION);
		DataSourceSequence sequence = getFixture().getOverlappedDataSourceSequence(sTextualDs, relations).get(0);
		assertEquals(sTextualDs, sequence.getDataSource());

		sTextualDs.setText("This is a sample text.");

		sequence = getFixture().getOverlappedDataSourceSequence(sTextualDs, relations).get(0);
		assertEquals(sTextualDs, sequence.getDataSource());
		assertEquals(sTextualDs, sequence.getDataSource());
		assertEquals(0, sequence.getStart());
		assertEquals(sTextualDs.getText().length(), sequence.getEnd());
	}

	/**
	 * Tests the graph: tok1 tok2 tok3 tok4
	 * 
	 * with the set {tok1}, {tok2, tok4}, {tok2, tok4, tok3}
	 * 
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#isContinuousByText(org.eclipse.emf.common.util.EList)
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testIsContinuousByText__EList() {
		String text = "This is a sample text.";
		DataSourceSequence dsSequence = new DataSourceSequence();

		// start: create sample graph
		STextualDS sText = getFixture().createTextualDS(text);
		dsSequence.setDataSource(sText);

		dsSequence.setStart(5);
		dsSequence.setEnd(7);
		SToken tok2 = getFixture().createToken(dsSequence);
		tok2.setName("tok2");

		dsSequence.setStart(21);
		dsSequence.setEnd(22);
		SToken tok6 = getFixture().createToken(dsSequence);
		tok6.setName("tok6");

		dsSequence.setStart(0);
		dsSequence.setEnd(4);
		SToken tok1 = getFixture().createToken(dsSequence);
		tok1.setName("tok1");

		dsSequence.setStart(10);
		dsSequence.setEnd(16);
		SToken tok4 = getFixture().createToken(dsSequence);
		tok4.setName("tok4");

		dsSequence.setStart(17);
		dsSequence.setEnd(21);
		SToken tok5 = getFixture().createToken(dsSequence);
		tok5.setName("tok5");

		dsSequence.setStart(8);
		dsSequence.setEnd(9);
		SToken tok3 = getFixture().createToken(dsSequence);
		tok3.setName("tok3");
		// end: create sample graph

		List<SToken> sTokens = null;

		sTokens = new ArrayList<>();
		sTokens.add(tok1);
		assertTrue(getFixture().isContinuousByText((List<SNode>) ((List<? extends SNode>) sTokens)));

		sTokens = new ArrayList<>();
		sTokens.add(tok2);
		sTokens.add(tok4);
		assertFalse(getFixture().isContinuousByText((List<SNode>) ((List<? extends SNode>) sTokens)));
		sTokens = new ArrayList<>();
		sTokens.add(tok2);
		sTokens.add(tok4);
		sTokens.add(tok3);
		assertTrue(getFixture().isContinuousByText((List<SNode>) ((List<? extends SNode>) sTokens)));
	}

	/**
	 * Tests the graph:
	 * 
	 * <pre>
	 *    span1      span2 
	 *     / \       / \ 
	 *  tok1 tok2  tok3 tok4
	 * 
	 * </pre>
	 * 
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#isContinuousByText(org.eclipse.emf.common.util.EList,
	 *      org.eclipse.emf.common.util.EList)
	 */
	@Test
	@SuppressWarnings("unchecked")
	public void testIsContinuousByText__EList_EList() {
		String text = "This is a sample text.";
		DataSourceSequence dsSequence = new DataSourceSequence();

		// start: create sample graph
		STextualDS sText = getFixture().createTextualDS(text);
		dsSequence.setDataSource(sText);

		dsSequence.setStart(5);
		dsSequence.setEnd(7);
		SToken tok2 = getFixture().createToken(dsSequence);
		tok2.setName("tok2");

		dsSequence.setStart(21);
		dsSequence.setEnd(22);
		SToken tok6 = getFixture().createToken(dsSequence);
		tok6.setName("tok6");

		dsSequence.setStart(0);
		dsSequence.setEnd(4);
		SToken tok1 = getFixture().createToken(dsSequence);
		tok1.setName("tok1");

		dsSequence.setStart(10);
		dsSequence.setEnd(16);
		SToken tok4 = getFixture().createToken(dsSequence);
		tok4.setName("tok4");

		dsSequence.setStart(17);
		dsSequence.setEnd(21);
		SToken tok5 = getFixture().createToken(dsSequence);
		tok5.setName("tok5");

		dsSequence.setStart(8);
		dsSequence.setEnd(9);
		SToken tok3 = getFixture().createToken(dsSequence);
		tok3.setName("tok3");
		// end: create sample graph
		List<SNode> fullList = new ArrayList<>();
		fullList.add(tok1);
		fullList.add(tok2);
		fullList.add(tok3);
		fullList.add(tok4);

		List<SToken> sTokens = null;

		sTokens = new ArrayList<>();
		sTokens.add(tok1);
		assertTrue(getFixture().isContinuousByText((List<SNode>) ((List<? extends SNode>) sTokens), fullList));

		sTokens = new ArrayList<>();
		sTokens.add(tok2);
		sTokens.add(tok4);
		assertFalse(getFixture().isContinuousByText((List<SNode>) ((List<? extends SNode>) sTokens), fullList));
		sTokens = new ArrayList<>();
		sTokens.add(tok2);
		sTokens.add(tok4);
		sTokens.add(tok3);
		assertTrue(getFixture().isContinuousByText((List<SNode>) ((List<? extends SNode>) sTokens), fullList));
	}

	/**
	 * Tests the sorting of tokens: tok2, tok6, tok1, tok4, tok5, tok3
	 * 
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#sortTokenByText()
	 */
	@Test
	public void testSortSTokenByText() {
		List<SToken> sTokens = new ArrayList<>();
		String text1 = "This is a sample text.";

		// start: create sample graph
		STextualDS sText1 = getFixture().createTextualDS(text1);

		SToken tok2 = getFixture().createToken(sText1, 5, 7);
		tok2.setName("tok2");

		SToken tok6 = getFixture().createToken(sText1, 21, 22);
		tok6.setName("tok6");

		SToken tok1 = getFixture().createToken(sText1, 0, 4);
		tok1.setName("tok1");

		SToken tok4 = getFixture().createToken(sText1, 10, 16);
		tok4.setName("tok4");

		SToken tok5 = getFixture().createToken(sText1, 17, 21);
		tok5.setName("tok5");

		SToken tok3 = getFixture().createToken(sText1, 8, 9);
		tok3.setName("tok3");
		// end: create sample graph
		sTokens.add(tok1);
		sTokens.add(tok2);
		sTokens.add(tok3);
		sTokens.add(tok4);
		sTokens.add(tok5);
		sTokens.add(tok6);

		getFixture().sortTokenByText();
		assertNotNull(getFixture().getTokens());
		assertEquals(sTokens.size(), getFixture().getTokens().size());
		List<SToken> controllSTokens = ImmutableList.copyOf(getFixture().getTokens());

		for (int i = 0; i < 6; i++) {
			assertEquals("tokens of index '" + i + "' aren't equal", sTokens.get(i), controllSTokens.get(i));
		}

		int prevStart = -1;
		for (STextualRelation curSTextRel : getFixture().getTextualRelations()) {
			assertTrue("this textrel does not follow previous texrel: " + getFixture().getTextualRelations(), curSTextRel.getStart() > prevStart);
			prevStart = curSTextRel.getStart();
		}
	}

	/**
	 * Tests the sorting of tokens: tok2, tok6, tok1, tok4, tok5, tok3
	 * 
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#sortSTokenByText(org.eclipse.emf.common.util.EList)
	 */
	@Test
	public void testGetSortedSTokenByText__EList() {
		String text1 = "This is a sample text.";

		// start: create sample graph
		STextualDS sText1 = getFixture().createTextualDS(text1);

		SToken tok2 = getFixture().createToken(sText1, 5, 7);
		tok2.setName("tok2");

		SToken tok6 = getFixture().createToken(sText1, 21, 22);
		tok6.setName("tok6");

		SToken tok1 = getFixture().createToken(sText1, 0, 4);
		tok1.setName("tok1");

		SToken tok4 = getFixture().createToken(sText1, 10, 16);
		tok4.setName("tok4");

		SToken tok5 = getFixture().createToken(sText1, 17, 21);
		tok5.setName("tok5");

		SToken tok3 = getFixture().createToken(sText1, 8, 9);
		tok3.setName("tok3");
		// end: create sample graph

		List<SToken> sTokens2Sort = new ArrayList<>();
		sTokens2Sort.add(tok5);
		sTokens2Sort.add(tok3);
		sTokens2Sort.add(tok4);

		List<SToken> sortedSTokens = getFixture().getSortedTokenByText(sTokens2Sort);

		assertNotNull(sortedSTokens);
		assertEquals(sTokens2Sort.size(), sortedSTokens.size());
		assertEquals(sTokens2Sort.get(1), sortedSTokens.get(0));
		assertEquals(sTokens2Sort.get(2), sortedSTokens.get(1));
		assertEquals(sTokens2Sort.get(0), sortedSTokens.get(2));
	}

	/**
	 * Tests the sorting of tokens: tok2, tok6, tok1, tok4, tok5, tok3
	 * 
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#sortTokenByText()
	 */
	@Test
	public void testGetSortedSTokenByText() {
		List<SToken> sTokens = new ArrayList<>();
		String text1 = "This is a sample text.";

		// start: create sample graph
		STextualDS sText1 = getFixture().createTextualDS(text1);

		SToken tok2 = getFixture().createToken(sText1, 5, 7);
		tok2.setName("tok2");

		SToken tok6 = getFixture().createToken(sText1, 21, 22);
		tok6.setName("tok6");

		SToken tok1 = getFixture().createToken(sText1, 0, 4);
		tok1.setName("tok1");

		SToken tok4 = getFixture().createToken(sText1, 10, 16);
		tok4.setName("tok4");

		SToken tok5 = getFixture().createToken(sText1, 17, 21);
		tok5.setName("tok5");

		SToken tok3 = getFixture().createToken(sText1, 8, 9);
		tok3.setName("tok3");
		// end: create sample graph
		sTokens.add(tok1);
		sTokens.add(tok2);
		sTokens.add(tok3);
		sTokens.add(tok4);
		sTokens.add(tok5);
		sTokens.add(tok6);

		List<SToken> sortedSTokens = getFixture().getSortedTokenByText();

		assertNotNull(sortedSTokens);
		assertEquals(sTokens.size(), sortedSTokens.size());
		for (int i = 0; i < 6; i++) {
			assertEquals(sTokens.get(i), sortedSTokens.get(i));
		}
	}

	/**
	 * Tests the sorting of tokens covering different {@link STextualDS} objcts
	 * text1: tok2, tok6, tok1, tok4, tok5, tok3 text2: tok3, tok2, tok1
	 * 
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#sortTokenByText()
	 */
	@Test
	public void testGetSortedSTokenByText_2() {
		List<SToken> sTokens = new ArrayList<>();
		String text1 = "This is a sample text.";
		String text2 = "A sample text.";

		// start: create sample graph
		// start: sTokens for sText1
		STextualDS sText1 = getFixture().createTextualDS(text1);

		SToken tok2 = getFixture().createToken(sText1, 5, 7);
		tok2.setName("tok2");

		SToken tok6 = getFixture().createToken(sText1, 21, 22);
		tok6.setName("tok6");

		SToken tok1 = getFixture().createToken(sText1, 0, 4);
		tok1.setName("tok1");

		SToken tok4 = getFixture().createToken(sText1, 10, 16);
		tok4.setName("tok4");

		SToken tok5 = getFixture().createToken(sText1, 17, 21);
		tok5.setName("tok5");

		SToken tok3 = getFixture().createToken(sText1, 8, 9);
		tok3.setName("tok3");
		// end: sTokens for sText1
		// start: sTokens for sText2
		STextualDS sText2 = getFixture().createTextualDS(text2);

		SToken tok3_1 = getFixture().createToken(sText2, 9, 13);
		tok3_1.setName("tok3_1");

		SToken tok2_1 = getFixture().createToken(sText2, 2, 8);
		tok2_1.setName("tok2_1");

		SToken tok1_1 = getFixture().createToken(sText2, 0, 1);
		tok1_1.setName("tok1_1");
		// end: sTokens for sText1
		// end: create sample graph

		sTokens.add(tok1);
		sTokens.add(tok2);
		sTokens.add(tok3);
		sTokens.add(tok4);
		sTokens.add(tok5);
		sTokens.add(tok6);
		sTokens.add(tok1_1);
		sTokens.add(tok2_1);
		sTokens.add(tok3_1);

		List<SToken> sortedSTokens = getFixture().getSortedTokenByText();

		assertNotNull(sortedSTokens);
		assertEquals(sTokens.size(), sortedSTokens.size());
		for (int i = 0; i < 6; i++) {
			assertEquals(sTokens.get(i), sortedSTokens.get(i));
		}
	}

//	@Test
//	public void testCreateSSpan__SToken() {
//		String text = "a sample";
//		STextualDS sText = getFixture().createTextualDS(text);
//		DataSourceSequence sequence = new DataSourceSequence();
//		sequence.setDataSource(sText);
//		sequence.setStart(0);
//		sequence.setEnd(1);
//		SToken tok1 = getFixture().createToken(sequence);
//		SSpan sSpan = getFixture().createSpan(tok1);
//
//		assertNotNull(sSpan);
//		assertEquals(sSpan, getFixture().getNode(sSpan.getId()));
//		List<SRelation> relations = getFixture().getRelations(sSpan.getId(), tok1.getId());
//		assertNotNull(relations);
//		assertEquals(1, relations.size());
//		assertTrue(relations.get(0) instanceof SSpanningRelation);
//		SSpanningRelation sSpanRel = (SSpanningRelation) relations.get(0);
//		assertEquals(tok1, sSpanRel.getTarget());
//		assertEquals(sSpan, sSpanRel.getSource());
//	}

	// FIXME
	// @Test
	// public void testCreateSSpan__EList() {
	// String text = "a sample text";
	// STextualDS sText = getFixture().createSTextualDS(text);
	// DataSourceSequence sequence = new DataSourceSequence();
	// sequence.setDataSource(sText);
	//
	// sequence.setStart(0);
	// sequence.setEnd(1);
	// SToken tok1 = getFixture().createToken(sequence);
	//
	// sequence.setStart(2);
	// sequence.setEnd(8);
	// SToken tok2 = getFixture().createToken(sequence);
	//
	// sequence.setStart(9);
	// sequence.setEnd(13);
	// SToken tok3 = getFixture().createToken(sequence);
	//
	// List<SToken> sTokens = new ArrayList<SToken>();
	// sTokens.add(tok1);
	// sTokens.add(tok2);
	// sTokens.add(tok3);
	// SSpan sSpan = getFixture().createSSpan(sTokens);
	//
	// assertNotNull(sSpan);
	// assertEquals(sSpan, getFixture().getNode(sSpan.getId()));
	//
	// List<Relation> relations = getFixture().getRelations(sSpan.getId(),
	// tok1.getId());
	// assertNotNull(relations);
	// assertEquals(1, relations.size());
	// assertTrue(relations.get(0) instanceof SSpanningRelation);
	// SSpanningRelation sSpanRel = (SSpanningRelation) relations.get(0);
	// assertEquals(tok1, sSpanRel.getTarget());
	// assertEquals(sSpan, sSpanRel.getSource());
	//
	// relations = getFixture().getRelations(sSpan.getId(), tok2.getId());
	// assertNotNull(relations);
	// assertEquals(1, relations.size());
	// assertTrue(relations.get(0) instanceof SSpanningRelation);
	// sSpanRel = (SSpanningRelation) relations.get(0);
	// assertEquals(tok2, sSpanRel.getTarget());
	// assertEquals(sSpan, sSpanRel.getSource());
	//
	// relations = getFixture().getRelations(sSpan.getId(), tok3.getId());
	// assertNotNull(relations);
	// assertEquals(1, relations.size());
	// assertTrue(relations.get(0) instanceof SSpanningRelation);
	// sSpanRel = (SSpanningRelation) relations.get(0);
	// assertEquals(tok3, sSpanRel.getTarget());
	// assertEquals(sSpan, sSpanRel.getSource());
	// }

	// FIXME
	// @Test
	// public void testCreateSStructure__SStructuredNode() {
	// String text = "a sample";
	// STextualDS sText = getFixture().createSTextualDS(text);
	// DataSourceSequence sequence = new DataSourceSequence();
	// sequence.setDataSource(sText);
	// sequence.setStart(0);
	// sequence.setEnd(1);
	//
	// SToken tok1 = getFixture().createToken(sequence);
	// SStructure sStruct = getFixture().createSStructure(tok1);
	//
	// assertNotNull(sStruct);
	// assertEquals(sStruct, getFixture().getNode(sStruct.getId()));
	// List<Relation> relations = getFixture().getRelations(sStruct.getId(),
	// tok1.getId());
	// assertNotNull(relations);
	// assertEquals(1, relations.size());
	// assertTrue(relations.get(0) instanceof SDominanceRelation);
	// SDominanceRelation sDomRel = (SDominanceRelation) relations.get(0);
	// assertEquals(tok1, sDomRel.getTarget());
	// assertEquals(sStruct, sDomRel.getTarget());
	// }

	// FIXME
	// @Test
	// public void testCreateSStructure__EList() {
	// String text = "a sample text";
	// STextualDS sText = getFixture().createSTextualDS(text);
	// DataSourceSequence sequence = new DataSourceSequence();
	// sequence.setDataSource(sText);
	//
	// sequence.setStart(0);
	// sequence.setEnd(1);
	// SToken tok1 = getFixture().createToken(sequence);
	//
	// sequence.setStart(2);
	// sequence.setEnd(8);
	// SToken tok2 = getFixture().createToken(sequence);
	//
	// sequence.setStart(9);
	// sequence.setEnd(13);
	// SToken tok3 = getFixture().createToken(sequence);
	//
	// List<SStructuredNode> sTokens = new ArrayList<SStructuredNode>();
	// sTokens.add(tok1);
	// sTokens.add(tok2);
	// sTokens.add(tok3);
	// SStructure sStruct = getFixture().createSStructure(sTokens);
	//
	// assertNotNull(sStruct);
	// assertEquals(sStruct, getFixture().getNode(sStruct.getId()));
	//
	// List<Relation> relations = getFixture().getRelations(sStruct.getId(),
	// tok1.getId());
	// assertNotNull(relations);
	// assertEquals(1, relations.size());
	// assertTrue(relations.get(0) instanceof SDominanceRelation);
	// SDominanceRelation sDomRel = (SDominanceRelation) relations.get(0);
	// assertEquals(tok1, sDomRel.getTarget());
	// assertEquals(sStruct, sDomRel.getTarget());
	//
	// relations = getFixture().getRelations(sStruct.getId(), tok2.getId());
	// assertNotNull(relations);
	// assertEquals(1, relations.size());
	// assertTrue(relations.get(0) instanceof SDominanceRelation);
	// sDomRel = (SDominanceRelation) relations.get(0);
	// assertEquals(tok2, sDomRel.getTarget());
	// assertEquals(sStruct, sDomRel.getTarget());
	//
	// relations = getFixture().getRelations(sStruct.getId(), tok3.getId());
	// assertNotNull(relations);
	// assertEquals(1, relations.size());
	// assertTrue(relations.get(0) instanceof SDominanceRelation);
	// sDomRel = (SDominanceRelation) relations.get(0);
	// assertEquals(tok3, sDomRel.getTarget());
	// assertEquals(sStruct, sDomRel.getTarget());
	// }

	/**
	 * tests graph:
	 * 
	 * <pre>
	 * 	     struct2
	 *       /      \
	 *      /     struct1  
	 *     /     /        \ 
	 *    /    span1    span2 
	 *   /     / \       / \
	 * tok1 tok2 tok3 tok4 tok5
	 * </pre>
	 * 
	 * PR's tok1-> tok2; tok3-> tok4; tok4->tok2
	 * 
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getRootsByRelation(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SALT_TYPE)
	 */
	@Test
	public void testGetRootsBySRelation__SALT_TYPE() {
		SToken tok1 = null;
		SToken tok2 = null;
		SToken tok3 = null;
		SToken tok4 = null;
		SToken tok5 = null;

		SSpan span1 = null;
		SSpan span2 = null;

		SStructure struct1 = null;
		SStructure struct2 = null;
		{// Token
			tok1 = SaltFactory.createSToken();
			tok1.setName("tok1");
			getFixture().addNode(tok1);
			assertEquals(tok1, getFixture().getNode(tok1.getId()));

			tok2 = SaltFactory.createSToken();
			tok2.setName("tok2");
			getFixture().addNode(tok2);
			assertEquals(tok2, getFixture().getNode(tok2.getId()));

			tok3 = SaltFactory.createSToken();
			tok3.setName("tok3");
			getFixture().addNode(tok3);
			assertEquals(tok3, getFixture().getNode(tok3.getId()));

			tok4 = SaltFactory.createSToken();
			tok4.setName("tok4");
			getFixture().addNode(tok4);
			assertEquals(tok4, getFixture().getNode(tok4.getId()));

			tok5 = SaltFactory.createSToken();
			tok5.setName("tok5");
			getFixture().addNode(tok5);
			assertEquals(tok5, getFixture().getNode(tok5.getId()));
		}// SToken
		{// SSpan
			span1 = SaltFactory.createSSpan();
			span1.setName("span1");
			getFixture().addNode(span1);
			assertEquals(span1, getFixture().getNode(span1.getId()));

			span2 = SaltFactory.createSSpan();
			span2.setName("span2");
			getFixture().addNode(span2);
			assertEquals(span2, getFixture().getNode(span2.getId()));
		}// SSpan

		{// SStructure
			struct1 = SaltFactory.createSStructure();
			struct1.setName("struct1");
			getFixture().addNode(struct1);
			assertEquals(struct1, getFixture().getNode(struct1.getId()));

			struct2 = SaltFactory.createSStructure();
			struct2.setName("struct2");
			getFixture().addNode(struct2);
			assertEquals(struct2, getFixture().getNode(struct2.getId()));
		}// SStructure

		{// SSpanningRelation
			SSpanningRelation sSpanRel = null;
			sSpanRel = SaltFactory.createSSpanningRelation();
			sSpanRel.setTarget(tok1);
			sSpanRel.setSource(span1);
			getFixture().addRelation(sSpanRel);
			assertEquals(sSpanRel, getFixture().getRelation(sSpanRel.getId()));

			sSpanRel = SaltFactory.createSSpanningRelation();
			sSpanRel.setTarget(tok2);
			sSpanRel.setSource(span1);
			getFixture().addRelation(sSpanRel);
			assertEquals(sSpanRel, getFixture().getRelation(sSpanRel.getId()));

			sSpanRel = SaltFactory.createSSpanningRelation();
			sSpanRel.setTarget(tok2);
			sSpanRel.setSource(span2);
			getFixture().addRelation(sSpanRel);
			assertEquals(sSpanRel, getFixture().getRelation(sSpanRel.getId()));

			sSpanRel = SaltFactory.createSSpanningRelation();
			sSpanRel.setTarget(tok4);
			sSpanRel.setSource(span2);
			getFixture().addRelation(sSpanRel);
			assertEquals(sSpanRel, getFixture().getRelation(sSpanRel.getId()));
		}// SSpanningRelation

		{// SDominanceRelation
			SDominanceRelation sDomRel = null;
			sDomRel = SaltFactory.createSDominanceRelation();
			sDomRel.setSource(struct1);
			sDomRel.setTarget(tok1);
			getFixture().addRelation(sDomRel);
			assertEquals(sDomRel, getFixture().getRelation(sDomRel.getId()));

			sDomRel = SaltFactory.createSDominanceRelation();
			sDomRel.setSource(struct1);
			sDomRel.setTarget(span1);
			getFixture().addRelation(sDomRel);
			assertEquals(sDomRel, getFixture().getRelation(sDomRel.getId()));

			sDomRel = SaltFactory.createSDominanceRelation();
			sDomRel.setSource(struct2);
			sDomRel.setTarget(struct1);
			getFixture().addRelation(sDomRel);
			assertEquals(sDomRel, getFixture().getRelation(sDomRel.getId()));

			sDomRel = SaltFactory.createSDominanceRelation();
			sDomRel.setSource(struct1);
			sDomRel.setTarget(span1);
			getFixture().addRelation(sDomRel);
			assertEquals(sDomRel, getFixture().getRelation(sDomRel.getId()));

			sDomRel = SaltFactory.createSDominanceRelation();
			sDomRel.setSource(struct1);
			sDomRel.setTarget(span2);
			getFixture().addRelation(sDomRel);
			assertEquals(sDomRel, getFixture().getRelation(sDomRel.getId()));
		}// SDominanceRelation

		{// SPointingRelation
			SPointingRelation sPRel = null;
			sPRel = SaltFactory.createSPointingRelation();
			sPRel.setSource(tok1);
			sPRel.setTarget(tok2);
			getFixture().addRelation(sPRel);
			assertEquals(sPRel, getFixture().getRelation(sPRel.getId()));

			sPRel = SaltFactory.createSPointingRelation();
			sPRel.setSource(tok3);
			sPRel.setTarget(tok4);
			getFixture().addRelation(sPRel);
			assertEquals(sPRel, getFixture().getRelation(sPRel.getId()));

			sPRel = SaltFactory.createSPointingRelation();
			sPRel.setSource(tok4);
			sPRel.setTarget(tok2);
			getFixture().addRelation(sPRel);
			assertEquals(sPRel, getFixture().getRelation(sPRel.getId()));
		}// SPointingRelation

		List<SNode> roots = null;
		{// check SSpanningRelation
			roots = new ArrayList<>();
			roots.add(span1);
			roots.add(span2);
			assertTrue(roots.containsAll(getFixture().getRootsByRelation(SALT_TYPE.SSPANNING_RELATION)));
			assertTrue(getFixture().getRootsByRelation(SALT_TYPE.SSPANNING_RELATION).containsAll(roots));
		}// check SSpanningRelation

		{// check SDominanceRelation
			roots = new ArrayList<>();
			roots.add(struct2);
			assertTrue(roots.containsAll(getFixture().getRootsByRelation(SALT_TYPE.SDOMINANCE_RELATION)));
			assertTrue(getFixture().getRootsByRelation(SALT_TYPE.SDOMINANCE_RELATION).containsAll(roots));
		}// check SDominanceRelation

		{// check SPointingRelation
			roots = new ArrayList<>();
			roots.add(tok1);
			roots.add(tok3);
			assertTrue(roots.containsAll(getFixture().getRootsByRelation(SALT_TYPE.SPOINTING_RELATION)));
			assertTrue(getFixture().getRootsByRelation(SALT_TYPE.SPOINTING_RELATION).containsAll(roots));
		}// check SPointingRelation
	}

	/**
	 * Checks the method getRootsBySRelationSType(). Just for SPointingRelation
	 */
	@Test
	public void testGetRootsBySRelationSType__SALT_TYPE() {
		// checking for SPointingRelation
		SToken node1 = SaltFactory.createSToken();
		getFixture().addNode(node1);
		SToken node2 = SaltFactory.createSToken();
		getFixture().addNode(node2);
		SToken node3 = SaltFactory.createSToken();
		getFixture().addNode(node3);

		String type1 = "type1";
		String type2 = "type2";

		SPointingRelation rel1 = SaltFactory.createSPointingRelation();
		rel1.setType(type1);
		rel1.setSource(node1);
		rel1.setTarget(node2);
		getFixture().addRelation(rel1);

		SPointingRelation rel2 = SaltFactory.createSPointingRelation();
		rel2.setType(type2);
		rel2.setSource(node2);
		rel2.setTarget(node1);
		getFixture().addRelation(rel2);

		Multimap<String, SNode> roots = getFixture().getRootsByRelationType(SALT_TYPE.SPOINTING_RELATION);
		assertTrue(roots.containsKey(type1));
		assertTrue(roots.containsKey(type2));
		assertEquals(1, roots.get(type1).size());
		assertEquals(1, roots.get(type2).size());
		assertTrue(roots.get(type1).contains(node1));
		assertTrue(roots.get(type2).contains(node2));
		// checking for SPointingRelation
	}

	@Test
	public void testcreateToken__SSequentialDS_Integer_Integer() {
		String sampleText = "This is a sample.";
		STextualDS primaryText = getFixture().createTextualDS(sampleText);
		SToken tok1 = getFixture().createToken(primaryText, 0, 4);
		SToken tok2 = getFixture().createToken(primaryText, 5, 7);
		SToken tok3 = getFixture().createToken(primaryText, 8, 9);
		SToken tok4 = getFixture().createToken(primaryText, 10, 16);
		SToken tok5 = getFixture().createToken(primaryText, 16, 17);

		List<SALT_TYPE> relations = new ArrayList<>();
		relations.add(SALT_TYPE.STEXT_OVERLAPPING_RELATION);
		DataSourceSequence sequence = null;

		sequence = getFixture().getOverlappedDataSourceSequence(tok1, relations).get(0);
		assertEquals(0, sequence.getStart());
		assertEquals(4, sequence.getEnd());
		assertEquals(primaryText, sequence.getDataSource());

		sequence = getFixture().getOverlappedDataSourceSequence(tok2, relations).get(0);
		assertEquals(5, sequence.getStart());
		assertEquals(7, sequence.getEnd());
		assertEquals(primaryText, sequence.getDataSource());

		sequence = getFixture().getOverlappedDataSourceSequence(tok3, relations).get(0);
		assertEquals(8, sequence.getStart());
		assertEquals(9, sequence.getEnd());
		assertEquals(primaryText, sequence.getDataSource());

		sequence = getFixture().getOverlappedDataSourceSequence(tok4, relations).get(0);
		assertEquals(10, sequence.getStart());
		assertEquals(16, sequence.getEnd());
		assertEquals(primaryText, sequence.getDataSource());

		sequence = getFixture().getOverlappedDataSourceSequence(tok5, relations).get(0);
		assertEquals(16, sequence.getStart());
		assertEquals(17, sequence.getEnd());
		assertEquals(primaryText, sequence.getDataSource());
	}

	@Test
	public void testTokenize() {
		String text1 = "This is a sample.";
		String text2 = "This is the second sample.";

		STextualDS sText1 = getFixture().createTextualDS(text1);
		STextualDS sText2 = getFixture().createTextualDS(text2);

		getFixture().tokenize();

		assertEquals(11, getFixture().getTokens().size());
		assertEquals(11, getFixture().getTextualRelations().size());

		int relTosText1 = 0;
		int relTosText2 = 0;
		for (STextualRelation textRel : getFixture().getTextualRelations()) {
			if (textRel.getTarget().equals(sText2))
				relTosText2++;
			else if (textRel.getTarget().equals(sText1))
				relTosText1++;
		}

		assertEquals(5, relTosText1);
		assertEquals(6, relTosText2);
	}

	/**
	 * Tests the tokenization of a pre-tokenized text and checks if the old
	 * tokens are removed correctly.
	 */
	@Test
	public void testTokenize2() {
		String text = "This is a sample.";

		STextualDS sText1 = getFixture().createTextualDS(text);
		getFixture().createToken(sText1, 0, 7);
		getFixture().createToken(sText1, 8, 16);

		getFixture().tokenize();

		assertEquals(5, getFixture().getTokens().size());
		assertEquals(5, getFixture().getTextualRelations().size());
		assertEquals(2, getFixture().getSpans().size());
	}

	/**
	 * Tests the tokenization of a pretokenized text and checks if the old
	 * tokens are removed correctly. Further checks, that all annotations are
	 * copied to the new created span node.
	 */
	@Test
	public void testTokenize3() {
		String text = "This is a sample.";

		STextualDS sText1 = getFixture().createTextualDS(text);
		SToken tok1 = getFixture().createToken(sText1, 0, 7);
		tok1.createAnnotation(null, "a", "b");
		tok1.createAnnotation(null, "c", "d");
		SToken tok2 = getFixture().createToken(sText1, 8, 16);
		tok2.createAnnotation(null, "1", "2");
		tok2.createAnnotation(null, "3", "4");

		getFixture().tokenize();

		assertEquals(5, getFixture().getTokens().size());
		assertEquals(5, getFixture().getTextualRelations().size());
		assertEquals(2, getFixture().getSpans().size());
		assertEquals(2, getFixture().getSpans().get(0).getAnnotations().size());
		assertEquals(2, getFixture().getSpans().get(1).getAnnotations().size());
	}

	@Test
	public void testCreateTokenizer() {
		Tokenizer tokenizer = getFixture().createTokenizer();
		assertNotNull(tokenizer);
		assertEquals(getFixture(), tokenizer.getDocumentGraph());
	}

	@Test
	public void testInsertSTokenAt__STextualDS_Integer_String_Boolean() {
		List<String> origText = new ArrayList<>();
		origText.add("This");
		origText.add("is");
		origText.add("the");
		origText.add("original");
		origText.add("Text");

		StringBuilder str = new StringBuilder();
		STextualDS sTextualDS = SaltFactory.createSTextualDS();
		getFixture().addNode(sTextualDS);
		for (String text : origText) {
			int start = str.length();
			str.append(text);
			int end = str.length();
			str.append(" ");
			getFixture().createToken(sTextualDS, start, end);
		}

		sTextualDS.setText(str.toString());

		String text = "addition";

		SToken token = getFixture().insertTokenAt(sTextualDS, 5, text, true);
		assertNotNull(token);

		assertEquals(6, getFixture().getTokens().size());
		assertEquals("This addition is the original Text ", sTextualDS.getText());
		assertEquals(6, getFixture().getTextualRelations().size());

		// This
		assertEquals(Integer.valueOf(0), getFixture().getTextualRelations().get(0).getStart());
		assertEquals(Integer.valueOf(4), getFixture().getTextualRelations().get(0).getEnd());

		// addition
		assertEquals(Integer.valueOf(5), getFixture().getTextualRelations().get(5).getStart());
		assertEquals(Integer.valueOf(13), getFixture().getTextualRelations().get(5).getEnd());

		// is
		assertEquals(Integer.valueOf(14), getFixture().getTextualRelations().get(1).getStart());
		assertEquals(Integer.valueOf(16), getFixture().getTextualRelations().get(1).getEnd());
	}

	@Test
	public void testInsertSTokensAt__STextualDS_Integer_EList_Boolean() {
		List<String> origText = new ArrayList<>();
		origText.add("This");
		origText.add("is");
		origText.add("the");
		origText.add("original");
		origText.add("Text");

		StringBuilder str = new StringBuilder();
		STextualDS sTextualDS = SaltFactory.createSTextualDS();
		getFixture().addNode(sTextualDS);
		for (String text : origText) {
			int start = str.length();
			str.append(text);
			int end = str.length();
			str.append(" ");
			getFixture().createToken(sTextualDS, start, end);
		}

		sTextualDS.setText(str.toString());

		List<String> text = new ArrayList<>();
		text.add("is");
		text.add("the");
		text.add("text");
		text.add("to");
		text.add("be");
		text.add("added");

		List<SToken> tokens = getFixture().insertTokensAt(sTextualDS, 5, text, true);
		assertNotNull(tokens);
		assertEquals(6, tokens.size());

		assertEquals(11, getFixture().getTokens().size());
		assertEquals("This is the text to be added is the original Text ", sTextualDS.getText());
		assertEquals(11, getFixture().getTextualRelations().size());

		// This
		assertEquals(Integer.valueOf(0), getFixture().getTextualRelations().get(0).getStart());
		assertEquals(Integer.valueOf(4), getFixture().getTextualRelations().get(0).getEnd());

		// is
		assertEquals(Integer.valueOf(5), getFixture().getTextualRelations().get(5).getStart());
		assertEquals(Integer.valueOf(7), getFixture().getTextualRelations().get(5).getEnd());

		// added
		assertEquals(Integer.valueOf(23), getFixture().getTextualRelations().get(10).getStart());
		assertEquals(Integer.valueOf(28), getFixture().getTextualRelations().get(10).getEnd());

		// second is
		assertEquals(Integer.valueOf(29), getFixture().getTextualRelations().get(1).getStart());
		assertEquals(Integer.valueOf(31), getFixture().getTextualRelations().get(1).getEnd());
	}

	@Test
	public void testCreateSRelation__SNode_SNode_SALT_TYPE_String() {
		STextualDS sText = getFixture().createTextualDS("This is a sample text");
		SToken tok1 = getFixture().createToken(sText, 0, 4);
		SToken tok2 = getFixture().createToken(sText, 5, 7);
		SSpan sSpan = SaltFactory.createSSpan();
		getFixture().addNode(sSpan);
		SStructure sStruct = SaltFactory.createSStructure();
		getFixture().addNode(sStruct);
		SRelation sRel = null;

		assertEquals(2, getFixture().getRelations().size());

		sRel = getFixture().createSRelation(tok1, tok2, SALT_TYPE.SPOINTING_RELATION, "myNS::coref=anaphor;anotherNS::foo=bar");
		assertEquals(3, getFixture().getRelations().size());
		assertEquals(tok1, sRel.getSource());
		assertEquals(tok2, sRel.getTarget());
		assertEquals(2, sRel.getAnnotations().size());
		assertNotNull(sRel.getAnnotation(SaltUtil.createQName("myNS", "coref")));
		assertEquals("anaphor", sRel.getAnnotation(SaltUtil.createQName("myNS", "coref")).getValue());
		assertNotNull(sRel.getAnnotation(SaltUtil.createQName("anotherNS", "foo")));
		assertEquals("bar", sRel.getAnnotation(SaltUtil.createQName("anotherNS", "foo")).getValue());

		sRel = getFixture().createSRelation(sSpan, tok2, SALT_TYPE.SSPANNING_RELATION, null);
		assertEquals(4, getFixture().getRelations().size());
		assertEquals(sSpan, sRel.getSource());
		assertEquals(tok2, sRel.getTarget());
		assertEquals(0, sRel.getAnnotations().size());

		sRel = getFixture().createSRelation(sStruct, tok2, SALT_TYPE.SDOMINANCE_RELATION, null);
		assertEquals(5, getFixture().getRelations().size());
		assertEquals(sStruct, sRel.getSource());
		assertEquals(tok2, sRel.getTarget());
		assertEquals(0, sRel.getAnnotations().size());

	}

	@Test
	public void testGetOverlappedSTokens__SNode_EList() {
		STextualDS sText = getFixture().createTextualDS("This is a sample text");
		SToken tok1 = getFixture().createToken(sText, 0, 4);
		SToken tok2 = getFixture().createToken(sText, 5, 7);
		SToken tok3 = getFixture().createToken(sText, 8, 9);
		SToken tok4 = getFixture().createToken(sText, 10, 15);
		SToken tok5 = getFixture().createToken(sText, 16, 20);
		List<SToken> tokenList = new ArrayList<>();
		tokenList.add(tok1);
		tokenList.add(tok2);
		tokenList.add(tok3);
		SSpan sSpan = fixture.createSpan(tokenList);
		getFixture().createSRelation(sSpan, tok4, SALT_TYPE.SPOINTING_RELATION, null);

		List<SStructuredNode> nodeList = new ArrayList<>();
		nodeList.add(sSpan);
		nodeList.add(tok4);
		nodeList.add(tok5);
		SStructure sStructure = fixture.createStructure(nodeList);

		// test whether the span overlaps tok1, tok2 and tok3
		List<SALT_TYPE> typeList = new ArrayList<>();
		typeList.add(SALT_TYPE.SSPANNING_RELATION);

		List<SToken> overlappedTokenList1 = fixture.getOverlappedTokens(sSpan, typeList);
		assertNotNull(overlappedTokenList1);
		assertTrue(overlappedTokenList1.containsAll(tokenList));
		assertFalse(overlappedTokenList1.contains(tok4));

		List<SALT_TYPE> typeList2 = new ArrayList<>();
		typeList2.add(SALT_TYPE.SSPANNING_RELATION);
		typeList2.add(SALT_TYPE.SPOINTING_RELATION);
		tokenList.add(tok4);
		List<SToken> overlappedTokenListWithPointing = fixture.getOverlappedTokens(sSpan, typeList2);
		assertNotNull(overlappedTokenListWithPointing);
		assertTrue(overlappedTokenListWithPointing.containsAll(tokenList));

		List<SToken> allTokenList = new ArrayList<>();
		allTokenList.add(tok1);
		allTokenList.add(tok2);
		allTokenList.add(tok3);
		allTokenList.add(tok4);
		allTokenList.add(tok5);
		typeList.add(SALT_TYPE.SDOMINANCE_RELATION);
		List<SToken> overlappedTokenList2 = fixture.getOverlappedTokens(sStructure, typeList);
		assertNotNull(overlappedTokenList2);
		assertTrue(overlappedTokenList2.containsAll(allTokenList));
		nodeList.add(tok2);
		SStructure sStructure2 = fixture.createStructure(nodeList);
		List<SToken> overlappedTokenList3 = fixture.getOverlappedTokens(sStructure2, typeList);
		assertNotNull(overlappedTokenList3);
		assertTrue(overlappedTokenList3.containsAll(allTokenList));
		for (SToken token : allTokenList) {
			overlappedTokenList3.remove(token);
		}
		assertTrue(overlappedTokenList3.isEmpty());
	}

	@Test
	public void testGetSText__SNode() {
		SDocumentGraph fixGraph = getFixture();
		assertNull(fixGraph.getText(null));
		String testText = "Is this example more complicated than it appears to be";
		fixGraph.createTextualDS(testText);
		fixGraph.tokenize();
		String sText = fixGraph.getText(fixGraph.getTokens().get(4));
		assertNotNull(sText);
		assertFalse(sText.isEmpty());
		assertEquals("complicated", sText);
	}

	@Test
	public void testGetSText__SNode__withDiscontinuesSpan() {
		SDocumentGraph fixGraph = getFixture();
		String testText = "Is this example more complicated than it appears to be";
		fixGraph.createTextualDS(testText);
		fixGraph.tokenize();
		/* collect tokens for discontinues span */
		List<SToken> sTokens = new ArrayList<>();
		sTokens.add(fixGraph.getTokens().get(0));
		sTokens.add(fixGraph.getTokens().get(1));
		sTokens.add(fixGraph.getTokens().get(fixGraph.getTokens().size() - 1));
		/* create discontinues span */
		String sText = fixGraph.getText(fixGraph.createSpan(sTokens));
		assertNotNull(sText);
		assertFalse(sText.isEmpty());
		assertEquals(testText, sText);
	}

	@Test
	public void testGetSText__SNode__SStructure() {
		SDocumentGraph fixGraph = getFixture();
		SStructure sStructure = SaltFactory.createSStructure();
		fixGraph.addNode(sStructure);
		assertNull(fixGraph.getText(sStructure));
	}
	
	/**
	 * Tests whether the correct tokens are returned.
	 */
	public void testGetTokens(){
		assertEquals(0, getFixture().getTokens().size());
		
		SToken tok1= SaltFactory.createSToken();
		getFixture().addNode(tok1);
		assertEquals(1, getFixture().getTokens().size());
		assertTrue(getFixture().getTokens().contains(tok1));
		
		SToken tok2= SaltFactory.createSToken();
		getFixture().addNode(tok2);
		assertEquals(2, getFixture().getTokens().size());
		assertTrue(getFixture().getTokens().contains(tok1));
		assertTrue(getFixture().getTokens().contains(tok2));
		
		SToken tok3= SaltFactory.createSToken();
		getFixture().addNode(tok3);
		assertEquals(3, getFixture().getTokens().size());
		assertTrue(getFixture().getTokens().contains(tok3));
		assertTrue(getFixture().getTokens().contains(tok3));
	}
	
	/**
	 * Tests whether the correct spans are returned.
	 */
	public void testGetSpans(){
		assertEquals(0, getFixture().getSpans().size());
		
		SSpan span1= SaltFactory.createSSpan();
		getFixture().addNode(span1);
		assertEquals(1, getFixture().getSpans().size());
		assertTrue(getFixture().getSpans().contains(span1));
		
		SSpan span2= SaltFactory.createSSpan();
		getFixture().addNode(span2);
		assertEquals(2, getFixture().getSpans().size());
		assertTrue(getFixture().getSpans().contains(span1));
		assertTrue(getFixture().getSpans().contains(span2));
		
		SSpan span3= SaltFactory.createSSpan();
		getFixture().addNode(span3);
		assertEquals(3, getFixture().getSpans().size());
		assertTrue(getFixture().getSpans().contains(span3));
		assertTrue(getFixture().getSpans().contains(span3));
	}
	/**
	 * Tests whether the correct structures are returned.
	 */
	public void testGetStructures(){
		assertEquals(0, getFixture().getStructures().size());
		
		SStructure struct1= SaltFactory.createSStructure();
		getFixture().addNode(struct1);
		assertEquals(1, getFixture().getStructures().size());
		assertTrue(getFixture().getStructures().contains(struct1));
		
		SStructure struct2= SaltFactory.createSStructure();
		getFixture().addNode(struct2);
		assertEquals(2, getFixture().getStructures().size());
		assertTrue(getFixture().getStructures().contains(struct1));
		assertTrue(getFixture().getStructures().contains(struct2));
		
		SStructure struct3= SaltFactory.createSStructure();
		getFixture().addNode(struct3);
		assertEquals(3, getFixture().getStructures().size());
		assertTrue(getFixture().getStructures().contains(struct3));
		assertTrue(getFixture().getStructures().contains(struct3));
	}
}
