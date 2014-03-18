/**
 * Copyright 2009 Humboldt University of Berlin, INRIA.
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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.tests;

import java.util.List;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.hamcrest.core.Every;

import com.google.common.collect.ImmutableList;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltElementNotContainedInGraphException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDSRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDataSource;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructureFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SOrderRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructuredNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeline;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimelineRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.tokenizer.Tokenizer;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SDocument Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualDSs() <em>STextual DSs</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualRelations() <em>STextual Relations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTokens() <em>STokens</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimeline() <em>STimeline</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimelineRelations() <em>STimeline Relations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSSpanningRelations() <em>SSpanning Relations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSSpans() <em>SSpans</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSStructures() <em>SStructures</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSDominanceRelations() <em>SDominance Relations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSPointingRelations() <em>SPointing Relations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSAudioDSRelations() <em>SAudio DS Relations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSAudioDataSources() <em>SAudio Data Sources</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSOrderRelations() <em>SOrder Relations</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#addSNode(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME) <em>Add SNode</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSSpanBySequence(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence) <em>Get SSpan By Sequence</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#createSTextualDS(java.lang.String) <em>Create STextual DS</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#createSToken(org.eclipse.emf.common.util.EList) <em>Create SToken</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#createSToken(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence) <em>Create SToken</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#createSTimeline() <em>Create STimeline</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTokensBySequence(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence) <em>Get STokens By Sequence</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSStructureBySequence(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence) <em>Get SStructure By Sequence</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSNodeBySequence(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence) <em>Get SNode By Sequence</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getOverlappedDSSequences(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode, org.eclipse.emf.common.util.EList) <em>Get Overlapped DS Sequences</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getOverlappedDSSequences(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Get Overlapped DS Sequences</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#isContinuousByText(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Is Continuous By Text</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#isContinuousByText(org.eclipse.emf.common.util.EList) <em>Is Continuous By Text</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSortedSTokenByText(org.eclipse.emf.common.util.EList) <em>Get Sorted SToken By Text</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSortedSTokenByText() <em>Get Sorted SToken By Text</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#createSSpan(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken) <em>Create SSpan</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#createSSpan(org.eclipse.emf.common.util.EList) <em>Create SSpan</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#createSStructure(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructuredNode) <em>Create SStructure</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#sortSTokenByText() <em>Sort SToken By Text</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#createSStructure(org.eclipse.emf.common.util.EList) <em>Create SStructure</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getRootsBySRelation(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME) <em>Get Roots By SRelation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getRootsBySRelationSType(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME) <em>Get Roots By SRelation SType</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#createSToken(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialDS, java.lang.Integer, java.lang.Integer) <em>Create SToken</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#tokenize() <em>Tokenize</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#createTokenizer() <em>Create Tokenizer</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#insertSTokenAt(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS, java.lang.Integer, java.lang.String, java.lang.Boolean) <em>Insert SToken At</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#insertSTokensAt(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS, java.lang.Integer, org.eclipse.emf.common.util.EList, java.lang.Boolean) <em>Insert STokens At</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#createSRelation(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME, java.lang.String) <em>Create SRelation</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getOverlappedSTokens(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode, org.eclipse.emf.common.util.EList) <em>Get Overlapped STokens</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSText(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode) <em>Get SText</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SDocumentGraphTest extends TestCase {

	/**
	 * The fixture for this SDocument Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDocumentGraph fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SDocumentGraphTest.class);
	}

	/**
	 * Constructs a new SDocument Graph test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDocumentGraphTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SDocument Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SDocumentGraph fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SDocument Graph test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDocumentGraph getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(SDocumentStructureFactory.eINSTANCE.createSDocumentGraph());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualDSs() <em>STextual DSs</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualDSs()
	 */
	public void testGetSTextualDSs() 
	{
		String[] ids= {"salt:/graph1#text1", "salt:/graph1#text2", "salt:/graph1#text3", "salt:/graph1#text4"};
		EList<STextualDS> textDSs= new BasicEList<STextualDS>();
		for (String id: ids)
		{
			STextualDS textDs= SaltFactory.eINSTANCE.createSTextualDS();
			textDs.setSId(id);
			this.getFixture().addSNode(textDs);
			textDSs.add(textDs);
		}	
		
		assertTrue(textDSs.containsAll(this.getFixture().getSTextualDSs()));
		assertTrue(this.getFixture().getSTextualDSs().containsAll(textDSs));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualRelations() <em>STextual Relations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualRelations()
	 */
	public void testGetSTextualRelations() 
	{
		String[] ids= {"salt:/graph1#textRel1", "salt:/graph1#textRel2", "salt:/graph1#textRel3", "salt:/graph1#textRel4"};
		EList<STextualRelation> textRels= new BasicEList<STextualRelation>();
		for (String id: ids)
		{
			STextualRelation textRel= SaltFactory.eINSTANCE.createSTextualRelation();
			textRel.setSId(id);
			this.getFixture().addSRelation(textRel);
			textRels.add(textRel);
		}	
		assertTrue(textRels.containsAll(this.getFixture().getSTextualRelations()));
		assertTrue(this.getFixture().getSTextualRelations().containsAll(textRels));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTokens() <em>STokens</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTokens()
	 */
	public void testGetSTokens() 
	{
		String[] ids= {"salt:/graph1#tok1", "salt:/graph1#tok2", "salt:/graph1#tok3", "salt:/graph1#tok4"};
		EList<SToken> toks= new BasicEList<SToken>();
		for (String id: ids)
		{
			SToken tok= SaltFactory.eINSTANCE.createSToken();
			tok.setSId(id);
			this.getFixture().addSNode(tok);
			toks.add(tok);
		}	
		
		assertTrue(toks.containsAll(this.getFixture().getSTokens()));
		assertTrue(this.getFixture().getSTokens().containsAll(toks));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimeline() <em>STimeline</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimeline()
	 */
	public void testGetSTimeline() 
	{
		STimeline sTimeline= SaltFactory.eINSTANCE.createSTimeline();
		EList<String> timeline= new BasicEList<String>();
		timeline.add("1.0");
		timeline.add("1.1");
		timeline.add("1.2");
		timeline.add("1.3");
		timeline.add("1.4");
		for (String point: timeline)
			sTimeline.addSPointOfTime(point);
		this.getFixture().setSTimeline(sTimeline);
		assertNotNull(this.getFixture().getSTimeline());
		assertNotNull(this.getFixture().getSTimeline().getSPointsOfTime());
		for (String point1: timeline)
		{
			boolean hasOpponend= false;
			for (String point2: this.getFixture().getSTimeline().getSPointsOfTime())
			{
				if (point1.equals(point2))
					hasOpponend= true;
			}
			assertTrue(hasOpponend);
		}
		assertTrue(timeline.containsAll(this.getFixture().getSTimeline().getSPointsOfTime()));
		assertTrue(this.getFixture().getSTimeline().getSPointsOfTime().containsAll(timeline));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#setSTimeline(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeline) <em>STimeline</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#setSTimeline(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeline)
	 */
	public void testSetSTimeline() 
	{
		this.testGetSTimeline();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimelineRelations() <em>STimeline Relations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimelineRelations()
	 */
	public void testGetSTimelineRelations() 
	{
		EList<STimelineRelation> timeRels= new BasicEList<STimelineRelation>();
		for (int i= 0; i< 10; i++)
		{
			STimelineRelation sTimeRel= SaltFactory.eINSTANCE.createSTimelineRelation();
			timeRels.add(sTimeRel);
			this.getFixture().addSRelation(sTimeRel);
		}	
		assertTrue(timeRels.containsAll(this.getFixture().getSTimelineRelations()));
		assertTrue(this.getFixture().getSTimelineRelations().containsAll(timeRels));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSSpanningRelations() <em>SSpanning Relations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSSpanningRelations()
	 */
	public void testGetSSpanningRelations() 
	{
		EList<SSpanningRelation> spanRels= new BasicEList<SSpanningRelation>();
		for (int i= 0; i< 10; i++)
		{
			SSpanningRelation sSpanRel= SaltFactory.eINSTANCE.createSSpanningRelation();
			spanRels.add(sSpanRel);
			this.getFixture().addSRelation(sSpanRel);
		}	
		assertTrue(spanRels.containsAll(this.getFixture().getSSpanningRelations()));
		assertTrue(this.getFixture().getSSpanningRelations().containsAll(spanRels));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSSpans() <em>SSpans</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSSpans()
	 */
	public void testGetSSpans() 
	{
		String[] names= {"salt:/graph1#span1", "salt:/graph1#span2", "salt:/graph1#span3", "salt:/graph1#span4"};
		EList<SSpan> spans= new BasicEList<SSpan>();
		for (String name: names)
		{
			SSpan span= SaltFactory.eINSTANCE.createSSpan();
			span.setSName(name);
			this.getFixture().addSNode(span);
			spans.add(span);
		}	
		
		assertTrue(spans.containsAll(this.getFixture().getSSpans()));
		assertTrue(this.getFixture().getSSpans().containsAll(spans));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSStructures() <em>SStructures</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSStructures()
	 */
	public void testGetSStructures() 
	{
		String[] names= {"salt:/graph1#structure1", "salt:/graph1#structure2", "salt:/graph1#structure3", "salt:/graph1#structure4"};
		EList<SStructure> structures= new BasicEList<SStructure>();
		for (String name: names)
		{
			SStructure structure= SaltFactory.eINSTANCE.createSStructure();
			structure.setSName(name);
			this.getFixture().addSNode(structure);
			structures.add(structure);
		}	
		
		assertTrue(structures.containsAll(this.getFixture().getSStructures()));
		assertTrue(this.getFixture().getSStructures().containsAll(structures));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSDominanceRelations() <em>SDominance Relations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSDominanceRelations()
	 */
	public void testGetSDominanceRelations() 
	{
		EList<SDominanceRelation> domRels= new BasicEList<SDominanceRelation>();
		for (int i= 0; i< 10; i++)
		{
			SDominanceRelation sDomRel= SaltFactory.eINSTANCE.createSDominanceRelation();
			domRels.add(sDomRel);
			this.getFixture().addSRelation(sDomRel);
		}	
		assertTrue(domRels.containsAll(this.getFixture().getSDominanceRelations()));
		assertTrue(this.getFixture().getSDominanceRelations().containsAll(domRels));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSPointingRelations() <em>SPointing Relations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSPointingRelations()
	 */
	public void testGetSPointingRelations() 
	{
		EList<SPointingRelation> pointingRels= new BasicEList<SPointingRelation>();
		for (int i= 0; i< 10; i++)
		{
			SPointingRelation sPointRel= SaltFactory.eINSTANCE.createSPointingRelation();
			pointingRels.add(sPointRel);
			this.getFixture().addSRelation(sPointRel);
		}	
		assertTrue(pointingRels.containsAll(this.getFixture().getSPointingRelations()));
		assertTrue(this.getFixture().getSPointingRelations().containsAll(pointingRels));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSAudioDSRelations() <em>SAudio DS Relations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSAudioDSRelations()
	 */
	public void testGetSAudioDSRelations() 
	{
		EList<SAudioDSRelation> sAudioRels= new BasicEList<SAudioDSRelation>();
		for (int i= 0; i< 10; i++)
		{
			SAudioDSRelation sAudioRel= SaltFactory.eINSTANCE.createSAudioDSRelation();
			sAudioRels.add(sAudioRel);
			this.getFixture().addSRelation(sAudioRel);
		}	
		assertTrue(sAudioRels.containsAll(this.getFixture().getSAudioDSRelations()));
		assertTrue(this.getFixture().getSAudioDSRelations().containsAll(sAudioRels));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSAudioDataSources() <em>SAudio Data Sources</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSAudioDataSources()
	 */
	public void testGetSAudioDataSources() 
	{
		SAudioDataSource sAudioDS= SaltFactory.eINSTANCE.createSAudioDataSource();
		this.getFixture().addSNode(sAudioDS);
		assertTrue(this.getFixture().getSAudioDataSources().contains(sAudioDS));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSOrderRelations() <em>SOrder Relations</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSOrderRelations()
	 */
	public void testGetSOrderRelations() {
		EList<SOrderRelation> orderRels= new BasicEList<SOrderRelation>();
		for (int i= 0; i< 10; i++)
		{
			SOrderRelation sOrderRel= SaltFactory.eINSTANCE.createSOrderRelation();
			orderRels.add(sOrderRel);
			this.getFixture().addSRelation(sOrderRel);
		}	
		assertTrue(orderRels.containsAll(this.getFixture().getSOrderRelations()));
		assertTrue(this.getFixture().getSOrderRelations().containsAll(orderRels));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#addSNode(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME) <em>Add SNode</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#addSNode(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode, de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME)
	 */
	public void testAddSNode__SNode_SNode_STYPE_NAME() {

		// test for SPOINTING_RELATION
		{
			SToken source = SaltFactory.eINSTANCE.createSToken();
			SToken target = SaltFactory.eINSTANCE.createSToken();
			//calling addSNode now should throw an SaltElementNotContainedInGraphException
			try { this.getFixture().addSNode(source, target, STYPE_NAME.SPOINTING_RELATION); fail(); } 
			catch (SaltElementNotContainedInGraphException e) {}
			this.getFixture().addSNode(source);
			SRelation sRelation = this.getFixture().addSNode(source, target, STYPE_NAME.SPOINTING_RELATION);
			assertTrue(sRelation instanceof SPointingRelation);
		}

		// test for STEXTUAL_RELATION
		{
			SToken     source = SaltFactory.eINSTANCE.createSToken();
			STextualDS target = SaltFactory.eINSTANCE.createSTextualDS();
			//calling addSNode now should throw an SaltElementNotContainedInGraphException
			try { this.getFixture().addSNode(source, target, STYPE_NAME.STEXTUAL_RELATION); fail(); } 
			catch (SaltElementNotContainedInGraphException e) {}
			this.getFixture().addSNode(source);
			SRelation sRelation = this.getFixture().addSNode(source, target, STYPE_NAME.STEXTUAL_RELATION);
			assertTrue(sRelation instanceof STextualRelation);
		}

		// test for SDOMINANCE_RELATION
		{
			SStructure source = SaltFactory.eINSTANCE.createSStructure();
			SToken     target = SaltFactory.eINSTANCE.createSToken();
			//calling addSNode now should throw an SaltElementNotContainedInGraphException
			try { this.getFixture().addSNode(source, target, STYPE_NAME.SDOMINANCE_RELATION); fail(); } 
			catch (SaltElementNotContainedInGraphException e) {}
			this.getFixture().addSNode(source);
			SRelation sRelation = this.getFixture().addSNode(source, target, STYPE_NAME.SDOMINANCE_RELATION);
			assertTrue(sRelation instanceof SDominanceRelation);
		}

		// test for SSPANNING_RELATION
		{
			SSpan  source = SaltFactory.eINSTANCE.createSSpan();
			SToken target = SaltFactory.eINSTANCE.createSToken();
			//calling addSNode now should throw an SaltElementNotContainedInGraphException
			try { this.getFixture().addSNode(source, target, STYPE_NAME.SSPANNING_RELATION); fail(); } 
			catch (SaltElementNotContainedInGraphException e) {}
			this.getFixture().addSNode(source);
			SRelation sRelation = this.getFixture().addSNode(source, target, STYPE_NAME.SSPANNING_RELATION);
			assertTrue(sRelation instanceof SSpanningRelation);
		}

	}

/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#createSTextualDS(java.lang.String) <em>Add SText</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#createSTextualDS(java.lang.String)
	 */
	public void testCreateSTextualDS__String() 
	{
		String sText= "This is a new primary text.";
		STextualDS sTextualDS= this.getFixture().createSTextualDS(sText);
		assertNotNull(sTextualDS);
		assertEquals(sText, sTextualDS.getSText());
		assertTrue(this.getFixture().getSTextualDSs().contains(sTextualDS));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#createSToken(org.eclipse.emf.common.util.EList) <em>Add SToken</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#createSToken(org.eclipse.emf.common.util.EList)
	 */
	public void testCreateSToken__EList() 
	{
		String text= "This is a sample text.";
		STextualDS stext= this.getFixture().createSTextualDS(text);
		
		EList<SDataSourceSequence> sequences= null;
		
		try {
			this.getFixture().createSToken(sequences);
			fail("empty param");
		} catch (Exception e) {
		}
		
		sequences= new BasicEList<SDataSourceSequence>();
		SDataSourceSequence sequence= null;
		
		sequences.add(sequence);
		try {
			this.getFixture().createSToken(sequences);
			fail("empty data-source value");
		} catch (Exception e) {
		}
		sequences= new BasicEList<SDataSourceSequence>();
		sequence= SaltFactory.eINSTANCE.createSDataSourceSequence();
		sequences.add(sequence);
		sequence.setSSequentialDS(stext);

		try {
			this.getFixture().createSToken(sequences);
			fail("empty start value");
		} catch (Exception e) {
		}
		sequence.setSStart(0);
		try {
			this.getFixture().createSToken(sequences);
			fail("empty end value");
		} catch (Exception e) {
		}
		sequence.setSEnd(4);
		
		SToken sToken= this.getFixture().createSToken(sequences);
		
		assertNotNull(sToken);
		assertEquals(sToken,this.getFixture().getSNode(sToken.getSId()));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#createSToken(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence) <em>Add SToken</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#createSToken(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence)
	 */
	public void testCreateSToken__SDataSourceSequence() 
	{
		String text= "This is a sample text.";
		SDataSourceSequence sequence= null;
		STextualDS stext= this.getFixture().createSTextualDS(text);
		
		try {
			this.getFixture().createSToken(sequence);
			fail("empty data-source value");
		} catch (Exception e) {
		}
		sequence= SaltFactory.eINSTANCE.createSDataSourceSequence();
		sequence.setSSequentialDS(stext);

		try {
			this.getFixture().createSToken(sequence);
			fail("empty start value");
		} catch (Exception e) {
		}
		sequence.setSStart(0);
		try {
			this.getFixture().createSToken(sequence);
			fail("empty end value");
		} catch (Exception e) {
		}
		sequence.setSEnd(4);
		
		SToken sToken= this.getFixture().createSToken(sequence);
		
		assertNotNull(sToken);
		assertEquals(sToken,this.getFixture().getSNode(sToken.getSId()));
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#createSTimeline() <em>Create STimeline</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#createSTimeline()
	 */
	public void testCreateSTimeline() 
	{
		{//text 1
			STextualDS sText1= SDocumentStructureFactory.eINSTANCE.createSTextualDS();
			sText1.setSText("Hello, text1.");
			this.getFixture().addSNode(sText1);
			SToken sToken= null;
			STextualRelation sTextRel= null;
			
			sToken= SDocumentStructureFactory.eINSTANCE.createSToken();
			this.getFixture().addSNode(sToken);
			sTextRel= SDocumentStructureFactory.eINSTANCE.createSTextualRelation();
			sTextRel.setSTextualDS(sText1);
			sTextRel.setSToken(sToken);
			sTextRel.setSStart(0);
			sTextRel.setSEnd(5);
			this.getFixture().addSRelation(sTextRel);
			
			sToken= SDocumentStructureFactory.eINSTANCE.createSToken();
			this.getFixture().addSNode(sToken);
			sTextRel= SDocumentStructureFactory.eINSTANCE.createSTextualRelation();
			sTextRel.setSTextualDS(sText1);
			sTextRel.setSToken(sToken);
			sTextRel.setSStart(5);
			sTextRel.setSEnd(6);
			this.getFixture().addSRelation(sTextRel);
			
			sToken= SDocumentStructureFactory.eINSTANCE.createSToken();
			this.getFixture().addSNode(sToken);
			sTextRel= SDocumentStructureFactory.eINSTANCE.createSTextualRelation();
			sTextRel.setSTextualDS(sText1);
			sTextRel.setSToken(sToken);
			sTextRel.setSStart(7);
			sTextRel.setSEnd(12);
			this.getFixture().addSRelation(sTextRel);
			
			sToken= SDocumentStructureFactory.eINSTANCE.createSToken();
			this.getFixture().addSNode(sToken);
			sTextRel= SDocumentStructureFactory.eINSTANCE.createSTextualRelation();
			sTextRel.setSTextualDS(sText1);
			sTextRel.setSToken(sToken);
			sTextRel.setSStart(12);
			sTextRel.setSEnd(13);
			this.getFixture().addSRelation(sTextRel);
			
		}
		
		{//text 1
			STextualDS sText2= SDocumentStructureFactory.eINSTANCE.createSTextualDS();
			sText2.setSText("Hello, Text2.");
			this.getFixture().addSNode(sText2);
			SToken sToken= null;
			STextualRelation sTextRel= null;
			
			sToken= SDocumentStructureFactory.eINSTANCE.createSToken();
			this.getFixture().addSNode(sToken);
			sTextRel= SDocumentStructureFactory.eINSTANCE.createSTextualRelation();
			sTextRel.setSTextualDS(sText2);
			sTextRel.setSToken(sToken);
			sTextRel.setSStart(0);
			sTextRel.setSEnd(5);
			this.getFixture().addSRelation(sTextRel);
			
			sToken= SDocumentStructureFactory.eINSTANCE.createSToken();
			this.getFixture().addSNode(sToken);
			sTextRel= SDocumentStructureFactory.eINSTANCE.createSTextualRelation();
			sTextRel.setSTextualDS(sText2);
			sTextRel.setSToken(sToken);
			sTextRel.setSStart(5);
			sTextRel.setSEnd(6);
			this.getFixture().addSRelation(sTextRel);
			
			sToken= SDocumentStructureFactory.eINSTANCE.createSToken();
			this.getFixture().addSNode(sToken);
			sTextRel= SDocumentStructureFactory.eINSTANCE.createSTextualRelation();
			sTextRel.setSTextualDS(sText2);
			sTextRel.setSToken(sToken);
			sTextRel.setSStart(7);
			sTextRel.setSEnd(12);
			this.getFixture().addSRelation(sTextRel);
			
			sToken= SDocumentStructureFactory.eINSTANCE.createSToken();
			this.getFixture().addSNode(sToken);
			sTextRel= SDocumentStructureFactory.eINSTANCE.createSTextualRelation();
			sTextRel.setSTextualDS(sText2);
			sTextRel.setSToken(sToken);
			sTextRel.setSStart(12);
			sTextRel.setSEnd(13);
			this.getFixture().addSRelation(sTextRel);
		}
		
		this.getFixture().createSTimeline();
		assertNotNull(this.getFixture().getSTimeline());
		assertEquals(8, this.getFixture().getSTimelineRelations().size());
		
		for (Integer i= 0; i <= 8; i++)
		{
			assertTrue(this.getFixture().getSTimeline().getSPointsOfTime().contains(i.toString()));
		}
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTokensBySequence(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence) <em>Get STokens By Sequence</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTokensBySequence(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence)
	 */
	public void testGetSTokensBySequence__SDataSourceSequence() {
		//TODO more to come a simple tests in SDataSourceAccessorTest
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSStructureBySequence(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence) <em>Get SStructure By Sequence</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSStructureBySequence(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence)
	 */
	public void testGetSStructureBySequence__SDataSourceSequence() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSSpanBySequence(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence) <em>Get SSpan By Sequence</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSSpanBySequence(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence)
	 */
	public void testGetSSpanBySequence__SDataSourceSequence() {
		//TODO more to come a simple testis in SDataSourceAccessorTest
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSStructureBySequence(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence) <em>Get SStructure By Sequence</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSStructureBySequence(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence)
	 */
	public void testGetSStructureBySequence__EList_EList() {
		//TODO more to come a simple testis in SDataSourceAccessorTest
	}

	/**
	 * Tests if tokens are correctly returned to corresponding {@link SDataSourceSequence} objects.
	 * text1: tok2, tok6, tok1, tok4, tok5, tok3
	 * text2: tok3, tok2, tok1
	 * 
	 * test11: covers tok1 of text 1
	 * test12: covers tok2, tok3, tok4 of text 1
	 * test13: covers all tokens of text 1
	 * test14: covers all tokens of text 2
	 */
	public void testGetSNodeBySequence__SDataSourceSequence() {
		String text1= "This is a sample text.";
		String text2= "A sample text.";
		SDataSourceSequence dsSequence= SaltFactory.eINSTANCE.createSDataSourceSequence();
		
		//start: create sample graph
			//start: sTokens for sText1
				STextualDS sText1= this.getFixture().createSTextualDS(text1);
				dsSequence.setSSequentialDS(sText1);
	
				SToken tok2= this.getFixture().createSToken(sText1, 5, 7);
				tok2.setSName("tok2");
				
				SToken tok6= this.getFixture().createSToken(sText1, 21, 22);
				tok6.setSName("tok6");
				
				SToken tok1= this.getFixture().createSToken(sText1, 0, 4);
				tok1.setSName("tok1");
				
				SToken tok4= this.getFixture().createSToken(sText1, 10, 16);
				tok4.setSName("tok4");
				
				SToken tok5= this.getFixture().createSToken(sText1, 17, 21);
				tok5.setSName("tok5");
				
				SToken tok3= this.getFixture().createSToken(sText1, 8, 9);
				tok3.setSName("tok3");
			//end: sTokens for sText1
			//start: sTokens for sText2
				STextualDS sText2= this.getFixture().createSTextualDS(text2);
				dsSequence.setSSequentialDS(sText2);
	
				SToken tok3_1= this.getFixture().createSToken(sText2, 9, 13);
				tok3_1.setSName("tok3_1");
				
				SToken tok2_1= this.getFixture().createSToken(sText2, 2, 8);
				tok2_1.setSName("tok2_1");
				
				SToken tok1_1= this.getFixture().createSToken(sText2, 0, 1);
				tok1_1.setSName("tok1_1");
			//end: sTokens for sText1	
		//end: create sample graph
		
		SDataSourceSequence sequence= null;
		EList<SNode> coveredSTokens= null;
		
		//start: test1 
			sequence= SaltFactory.eINSTANCE.createSDataSourceSequence();
			sequence.setSSequentialDS(sText1);
			sequence.setSStart(0);
			sequence.setSEnd(4);
			
			coveredSTokens= this.getFixture().getSNodeBySequence(sequence);
			assertNotNull(coveredSTokens);
			assertEquals("covered tokens are: "+ coveredSTokens, 1, coveredSTokens.size());
			assertTrue(coveredSTokens.contains(tok1));
		//end: test 1
			
		//start: test2 
			sequence= SaltFactory.eINSTANCE.createSDataSourceSequence();
			sequence.setSSequentialDS(sText1);
			sequence.setSStart(5);
			sequence.setSEnd(16);
			
			coveredSTokens= this.getFixture().getSNodeBySequence(sequence);
			assertNotNull(coveredSTokens);
			assertEquals(3, coveredSTokens.size());
			assertTrue(coveredSTokens.contains(tok2));
			assertTrue(coveredSTokens.contains(tok3));
			assertTrue(coveredSTokens.contains(tok4));
		//end: test 2
			
		//start: test3 
			sequence= SaltFactory.eINSTANCE.createSDataSourceSequence();
			sequence.setSSequentialDS(sText1);
			sequence.setSStart(0);
			sequence.setSEnd(sText1.getSText().length());
			
			coveredSTokens= this.getFixture().getSNodeBySequence(sequence);
			assertNotNull(coveredSTokens);
			assertEquals(6, coveredSTokens.size());
			assertTrue(coveredSTokens.contains(tok1));
			assertTrue(coveredSTokens.contains(tok2));
			assertTrue(coveredSTokens.contains(tok3));
			assertTrue(coveredSTokens.contains(tok4));
			assertTrue(coveredSTokens.contains(tok5));
			assertTrue(coveredSTokens.contains(tok6));
		//end: test 3
		
		//start: test3 
			sequence= SaltFactory.eINSTANCE.createSDataSourceSequence();
			sequence.setSSequentialDS(sText2);
			sequence.setSStart(0);
			sequence.setSEnd(sText2.getSText().length());
			
			coveredSTokens= this.getFixture().getSNodeBySequence(sequence);
			assertNotNull(coveredSTokens);
			assertEquals(3, coveredSTokens.size());
			assertTrue(coveredSTokens.contains(tok1_1));
			assertTrue(coveredSTokens.contains(tok2_1));
			assertTrue(coveredSTokens.contains(tok3_1));
		//end: test 3
	}
	
	
	/**
	 * Tests the following graph, and checks if the correct sequences are overlapped:
	 * 		struct1			struct3
	 * 		/		\		/		\
	 * 	struct2			span1			\
	 * 		|		/		\				\
	 * 		tok1	tok2	tok3	tok4	tok5
	 * 
	 * 
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getOverlappedDSSequences(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode)
	 */
	public void testGetOverlappedDSSequences__SNode_EList() {
		String text= "This is a sample text.";
		SDataSourceSequence dsSequence= SaltFactory.eINSTANCE.createSDataSourceSequence();
		//start: create sample graph
			STextualDS sText= this.getFixture().createSTextualDS(text);
			dsSequence.setSSequentialDS(sText);
	
			dsSequence.setSStart(0);
			dsSequence.setSEnd(4);
			SToken tok1= this.getFixture().createSToken(dsSequence);
			tok1.setSName("tok1");
			
			dsSequence.setSStart(5);
			dsSequence.setSEnd(7);
			SToken tok2= this.getFixture().createSToken(dsSequence);
			tok2.setSName("tok2");

			dsSequence.setSStart(8);
			dsSequence.setSEnd(9);
			SToken tok3= this.getFixture().createSToken(dsSequence);
			tok3.setSName("tok3");
			
			dsSequence.setSStart(10);
			dsSequence.setSEnd(16);
			SToken tok4= this.getFixture().createSToken(dsSequence);
			tok4.setSName("tok4");
			
			dsSequence.setSStart(17);
			dsSequence.setSEnd(21);
			SToken tok5= this.getFixture().createSToken(dsSequence);
			tok5.setSName("tok5");
			
			dsSequence.setSStart(21);
			dsSequence.setSEnd(22);
			SToken tok6= this.getFixture().createSToken(dsSequence);
			tok6.setSName("tok6");
			
			EList<SStructuredNode> overlappedNodes= null;
			EList<SToken> overlappedTokens= null;
			
			overlappedNodes= new BasicEList<SStructuredNode>();
			overlappedNodes.add(tok1);
			SStructure struct2= this.getFixture().createSStructure(tok1);
			struct2.setSName("struct2");
			
			overlappedTokens= new BasicEList<SToken>();
			overlappedTokens.add(tok2);
			overlappedTokens.add(tok3);
			SSpan span1= this.getFixture().createSSpan(overlappedTokens);
			span1.setSName("span1");
			
			overlappedNodes= new BasicEList<SStructuredNode>();
			overlappedNodes.add(struct2);
			overlappedNodes.add(span1);
			SStructure struct1= this.getFixture().createSStructure(overlappedNodes);
			struct1.setSName("struct1");
			
			overlappedNodes= new BasicEList<SStructuredNode>();
			overlappedNodes.add(span1);
			overlappedNodes.add(tok5);
			SStructure struct3= this.getFixture().createSStructure(overlappedNodes);
			struct3.setSName("struct3");
		//end: create sample graph
			
		SDataSourceSequence sequence= null;
		EList<STYPE_NAME> saltTypes= new BasicEList<STYPE_NAME>();
		saltTypes.add(STYPE_NAME.STEXT_OVERLAPPING_RELATION);
		sequence= this.getFixture().getOverlappedDSSequences(struct2, saltTypes).get(0);
		assertNotNull(sequence);
		assertEquals((Integer)0, sequence.getSStart());
		assertEquals((Integer)4, sequence.getSEnd());

		sequence= this.getFixture().getOverlappedDSSequences(struct1, saltTypes).get(0);
		assertNotNull(sequence);
		assertEquals((Integer)0, sequence.getSStart());
		assertEquals((Integer)9, sequence.getSEnd());
		
		sequence= this.getFixture().getOverlappedDSSequences(span1, saltTypes).get(0);
		assertNotNull(sequence);
		assertEquals((Integer)5, sequence.getSStart());
		assertEquals((Integer)9, sequence.getSEnd());
		
		sequence= this.getFixture().getOverlappedDSSequences(struct3, saltTypes).get(0);
		assertNotNull(sequence);
		assertEquals((Integer)5, sequence.getSStart());
		assertEquals((Integer)21, sequence.getSEnd());
	}

	/**
	 * Checks that when given a {@link STextualDS} as node, if the entire data source is returned. 
	 */
	public void testGetOverlappedDSSequences__STextualDS_EList() {
		STextualDS sTextualDs= SaltFactory.eINSTANCE.createSTextualDS();
		this.getFixture().addSNode(sTextualDs);
		EList<STYPE_NAME> relations= new BasicEList<STYPE_NAME>();
		relations.add(STYPE_NAME.STEXT_OVERLAPPING_RELATION);
		SDataSourceSequence sequence= this.getFixture().getOverlappedDSSequences(sTextualDs, relations).get(0);
		assertEquals(sTextualDs, sequence.getSSequentialDS());
		
		sTextualDs.setSText("This is a sample text.");
		
		sequence= this.getFixture().getOverlappedDSSequences(sTextualDs, relations).get(0);
		assertEquals(sTextualDs, sequence.getSSequentialDS());
		assertEquals(sTextualDs, sequence.getSSequentialDS());
		assertEquals(Integer.valueOf(0), sequence.getSStart());
		assertEquals(Integer.valueOf(sTextualDs.getSText().length()), sequence.getSEnd());
	}
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getOverlappedDSSequences(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList) <em>Get Overlapped DS Sequences</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getOverlappedDSSequences(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList)
	 */
	public void testGetOverlappedDSSequences__EList_EList() {
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
	}

	/**
	 * Tests the graph:
	 * tok1		tok2	tok3	tok4
	 * 
	 * with the set {tok1}, {tok2, tok4}, {tok2, tok4, tok3}
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#isContinuousByText(org.eclipse.emf.common.util.EList)
	 */
	@SuppressWarnings("unchecked")
	public void testIsContinuousByText__EList()
	{
		String text= "This is a sample text.";
		SDataSourceSequence dsSequence= SaltFactory.eINSTANCE.createSDataSourceSequence();
		
		//start: create sample graph
			STextualDS sText= this.getFixture().createSTextualDS(text);
			dsSequence.setSSequentialDS(sText);
	
			dsSequence.setSStart(5);
			dsSequence.setSEnd(7);
			SToken tok2= this.getFixture().createSToken(dsSequence);
			tok2.setSName("tok2");
			
			dsSequence.setSStart(21);
			dsSequence.setSEnd(22);
			SToken tok6= this.getFixture().createSToken(dsSequence);
			tok6.setSName("tok6");
			
			dsSequence.setSStart(0);
			dsSequence.setSEnd(4);
			SToken tok1= this.getFixture().createSToken(dsSequence);
			tok1.setSName("tok1");
			
			dsSequence.setSStart(10);
			dsSequence.setSEnd(16);
			SToken tok4= this.getFixture().createSToken(dsSequence);
			tok4.setSName("tok4");
			
			dsSequence.setSStart(17);
			dsSequence.setSEnd(21);
			SToken tok5= this.getFixture().createSToken(dsSequence);
			tok5.setSName("tok5");
			
			dsSequence.setSStart(8);
			dsSequence.setSEnd(9);
			SToken tok3= this.getFixture().createSToken(dsSequence);
			tok3.setSName("tok3");
		//end: create sample graph
		
		EList<SToken> sTokens= null;
		
		sTokens= new BasicEList<SToken>();
		sTokens.add(tok1);
		assertTrue(this.getFixture().isContinuousByText((EList<SNode>)((EList<? extends SNode>) sTokens)));
		
		sTokens= new BasicEList<SToken>();
		sTokens.add(tok2);
		sTokens.add(tok4);
		assertFalse(this.getFixture().isContinuousByText((EList<SNode>)((EList<? extends SNode>) sTokens)));
		sTokens= new BasicEList<SToken>();
		sTokens.add(tok2);
		sTokens.add(tok4);
		sTokens.add(tok3);
		assertTrue(this.getFixture().isContinuousByText((EList<SNode>)((EList<? extends SNode>) sTokens)));
	}

 
	/**
	 * Tests the graph:
	 * 		span1		span2
	 * 		/	\	/			\
	 * tok1		tok2	tok3	tok4
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#isContinuousByText(org.eclipse.emf.common.util.EList, org.eclipse.emf.common.util.EList)
	 */
	@SuppressWarnings("unchecked")
	public void testIsContinuousByText__EList_EList()
	{
		String text= "This is a sample text.";
		SDataSourceSequence dsSequence= SaltFactory.eINSTANCE.createSDataSourceSequence();
		
		//start: create sample graph
			STextualDS sText= this.getFixture().createSTextualDS(text);
			dsSequence.setSSequentialDS(sText);
	
			dsSequence.setSStart(5);
			dsSequence.setSEnd(7);
			SToken tok2= this.getFixture().createSToken(dsSequence);
			tok2.setSName("tok2");
			
			dsSequence.setSStart(21);
			dsSequence.setSEnd(22);
			SToken tok6= this.getFixture().createSToken(dsSequence);
			tok6.setSName("tok6");
			
			dsSequence.setSStart(0);
			dsSequence.setSEnd(4);
			SToken tok1= this.getFixture().createSToken(dsSequence);
			tok1.setSName("tok1");
			
			dsSequence.setSStart(10);
			dsSequence.setSEnd(16);
			SToken tok4= this.getFixture().createSToken(dsSequence);
			tok4.setSName("tok4");
			
			dsSequence.setSStart(17);
			dsSequence.setSEnd(21);
			SToken tok5= this.getFixture().createSToken(dsSequence);
			tok5.setSName("tok5");
			
			dsSequence.setSStart(8);
			dsSequence.setSEnd(9);
			SToken tok3= this.getFixture().createSToken(dsSequence);
			tok3.setSName("tok3");
		//end: create sample graph
		EList<SNode> fullList= new BasicEList<SNode>();
		fullList.add(tok1);
		fullList.add(tok2);
		fullList.add(tok3);
		fullList.add(tok4);
		
		EList<SToken> sTokens= null;
		
		sTokens= new BasicEList<SToken>();
		sTokens.add(tok1);
		assertTrue(this.getFixture().isContinuousByText((EList<SNode>)((EList<? extends SNode>) sTokens), fullList));
		
		sTokens= new BasicEList<SToken>();
		sTokens.add(tok2);
		sTokens.add(tok4);
		assertFalse(this.getFixture().isContinuousByText((EList<SNode>)((EList<? extends SNode>) sTokens),fullList));
		sTokens= new BasicEList<SToken>();
		sTokens.add(tok2);
		sTokens.add(tok4);
		sTokens.add(tok3);
		assertTrue(this.getFixture().isContinuousByText((EList<SNode>)((EList<? extends SNode>) sTokens), fullList));
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#isContinuousByText(org.eclipse.emf.common.util.EList) <em>Is Continuous By Text</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#isContinuousByText(org.eclipse.emf.common.util.EList)
	 */
	public void testIsContinuousByText__SNode() 
	{
		// TODO: implement this operation test method
		// Ensure that you remove @generated or mark it @generated NOT
//		fail();
	}

	/**
	 * Tests the sorting of tokens: tok2, tok6, tok1, tok4, tok5, tok3 
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#sortSTokenByText()
	 */
	public void testSortSTokenByText() {
		EList<SToken> sTokens= new BasicEList<SToken>();
		String text1= "This is a sample text.";
		SDataSourceSequence dsSequence= SaltFactory.eINSTANCE.createSDataSourceSequence();
		
		//start: create sample graph
			STextualDS sText1= this.getFixture().createSTextualDS(text1);
			dsSequence.setSSequentialDS(sText1);
	
			SToken tok2= this.getFixture().createSToken(sText1, 5, 7);
			tok2.setSName("tok2");
			
			SToken tok6= this.getFixture().createSToken(sText1, 21, 22);
			tok6.setSName("tok6");
			
			SToken tok1= this.getFixture().createSToken(sText1, 0, 4);
			tok1.setSName("tok1");
			
			SToken tok4= this.getFixture().createSToken(sText1, 10, 16);
			tok4.setSName("tok4");
			
			SToken tok5= this.getFixture().createSToken(sText1, 17, 21);
			tok5.setSName("tok5");
			
			SToken tok3= this.getFixture().createSToken(sText1, 8, 9);
			tok3.setSName("tok3");
		//end: create sample graph
		sTokens.add(tok1);
		sTokens.add(tok2);
		sTokens.add(tok3);
		sTokens.add(tok4);
		sTokens.add(tok5);
		sTokens.add(tok6);
		
		
		this.getFixture().sortSTokenByText();
		assertNotNull(this.getFixture().getSTokens());
		assertEquals(sTokens.size(), this.getFixture().getSTokens().size());
		List<SToken> controllSTokens= ImmutableList.copyOf(this.getFixture().getSTokens());
	
		
		for (int i=0; i< 6; i++)
		{
			assertEquals("tokens of index '"+i+"' aren't equal", sTokens.get(i), controllSTokens.get(i));
		}
		
		int prevStart = -1;
		for (STextualRelation curSTextRel : this.getFixture().getSTextualRelations()){
			assertTrue("this textrel does not follow previous texrel: " + this.getFixture().getSTextualRelations(), curSTextRel.getSStart() > prevStart);
			prevStart = curSTextRel.getSStart();
		}
	}

	/**
	 * Tests the sorting of tokens: tok2, tok6, tok1, tok4, tok5, tok3
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#sortSTokenByText(org.eclipse.emf.common.util.EList)
	 */
	public void testGetSortedSTokenByText__EList() {
		String text1= "This is a sample text.";
		SDataSourceSequence dsSequence= SaltFactory.eINSTANCE.createSDataSourceSequence();
		
		//start: create sample graph
			STextualDS sText1= this.getFixture().createSTextualDS(text1);
			dsSequence.setSSequentialDS(sText1);
	
			SToken tok2= this.getFixture().createSToken(sText1, 5, 7);
			tok2.setSName("tok2");
			
			SToken tok6= this.getFixture().createSToken(sText1, 21, 22);
			tok6.setSName("tok6");
			
			SToken tok1= this.getFixture().createSToken(sText1, 0, 4);
			tok1.setSName("tok1");
			
			SToken tok4= this.getFixture().createSToken(sText1, 10, 16);
			tok4.setSName("tok4");
			
			SToken tok5= this.getFixture().createSToken(sText1, 17, 21);
			tok5.setSName("tok5");
			
			SToken tok3= this.getFixture().createSToken(sText1, 8, 9);
			tok3.setSName("tok3");
		//end: create sample graph
		
		EList<SToken> sTokens2Sort= new BasicEList<SToken>();
		sTokens2Sort.add(tok5);
		sTokens2Sort.add(tok3);
		sTokens2Sort.add(tok4);
		
		EList<SToken> sortedSTokens= this.getFixture().getSortedSTokenByText(sTokens2Sort);
		
		assertNotNull(sortedSTokens);
		assertEquals(sTokens2Sort.size(), sortedSTokens.size());
		assertEquals(sTokens2Sort.get(1), sortedSTokens.get(0));
		assertEquals(sTokens2Sort.get(2), sortedSTokens.get(1));
		assertEquals(sTokens2Sort.get(0), sortedSTokens.get(2));
	}

	/**
	 * Tests the sorting of tokens: tok2, tok6, tok1, tok4, tok5, tok3
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#sortSTokenByText()
	 */
	public void testGetSortedSTokenByText() { 
		EList<SToken> sTokens= new BasicEList<SToken>();
		String text1= "This is a sample text.";
		SDataSourceSequence dsSequence= SaltFactory.eINSTANCE.createSDataSourceSequence();
		
		//start: create sample graph
			STextualDS sText1= this.getFixture().createSTextualDS(text1);
			dsSequence.setSSequentialDS(sText1);
	
			SToken tok2= this.getFixture().createSToken(sText1, 5, 7);
			tok2.setSName("tok2");
			
			SToken tok6= this.getFixture().createSToken(sText1, 21, 22);
			tok6.setSName("tok6");
			
			SToken tok1= this.getFixture().createSToken(sText1, 0, 4);
			tok1.setSName("tok1");
			
			SToken tok4= this.getFixture().createSToken(sText1, 10, 16);
			tok4.setSName("tok4");
			
			SToken tok5= this.getFixture().createSToken(sText1, 17, 21);
			tok5.setSName("tok5");
			
			SToken tok3= this.getFixture().createSToken(sText1, 8, 9);
			tok3.setSName("tok3");
		//end: create sample graph
		sTokens.add(tok1);
		sTokens.add(tok2);
		sTokens.add(tok3);
		sTokens.add(tok4);
		sTokens.add(tok5);
		sTokens.add(tok6);
		
		
		EList<SToken> sortedSTokens= this.getFixture().getSortedSTokenByText();
		
		assertNotNull(sortedSTokens);
		assertEquals(sTokens.size(), sortedSTokens.size());
		for (int i=0; i< 6; i++)
		{
			assertEquals(sTokens.get(i), sortedSTokens.get(i));
		}
	}
	
	/**
	 * Tests the sorting of tokens covering different {@link STextualDS} objcts
	 * text1: tok2, tok6, tok1, tok4, tok5, tok3
	 * text2: tok3, tok2, tok1
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#sortSTokenByText()
	 */
	public void testGetSortedSTokenByText_2() { 
		EList<SToken> sTokens= new BasicEList<SToken>();
		String text1= "This is a sample text.";
		String text2= "A sample text.";
		SDataSourceSequence dsSequence= SaltFactory.eINSTANCE.createSDataSourceSequence();
		
		//start: create sample graph
			//start: sTokens for sText1
				STextualDS sText1= this.getFixture().createSTextualDS(text1);
				dsSequence.setSSequentialDS(sText1);
	
				SToken tok2= this.getFixture().createSToken(sText1, 5, 7);
				tok2.setSName("tok2");
				
				SToken tok6= this.getFixture().createSToken(sText1, 21, 22);
				tok6.setSName("tok6");
				
				SToken tok1= this.getFixture().createSToken(sText1, 0, 4);
				tok1.setSName("tok1");
				
				SToken tok4= this.getFixture().createSToken(sText1, 10, 16);
				tok4.setSName("tok4");
				
				SToken tok5= this.getFixture().createSToken(sText1, 17, 21);
				tok5.setSName("tok5");
				
				SToken tok3= this.getFixture().createSToken(sText1, 8, 9);
				tok3.setSName("tok3");
			//end: sTokens for sText1
			//start: sTokens for sText2
				STextualDS sText2= this.getFixture().createSTextualDS(text2);
				dsSequence.setSSequentialDS(sText2);
	
				SToken tok3_1= this.getFixture().createSToken(sText2, 9, 13);
				tok3_1.setSName("tok3_1");
				
				SToken tok2_1= this.getFixture().createSToken(sText2, 2, 8);
				tok2_1.setSName("tok2_1");
				
				SToken tok1_1= this.getFixture().createSToken(sText2, 0, 1);
				tok1_1.setSName("tok1_1");
			//end: sTokens for sText1	
		//end: create sample graph
				
		sTokens.add(tok1);
		sTokens.add(tok2);
		sTokens.add(tok3);
		sTokens.add(tok4);
		sTokens.add(tok5);
		sTokens.add(tok6);
		sTokens.add(tok1_1);
		sTokens.add(tok2_1);
		sTokens.add(tok3_1);
		
		
		EList<SToken> sortedSTokens= this.getFixture().getSortedSTokenByText();
		
		assertNotNull(sortedSTokens);
		assertEquals(sTokens.size(), sortedSTokens.size());
		for (int i=0; i< 6; i++)
		{
			assertEquals(sTokens.get(i), sortedSTokens.get(i));
		}
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#addSSpan(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken) <em>Add SSpan</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#addSSpan(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken)
	 */
	public void testCreateSSpan__SToken() 
	{
		String text= "a sample";
		STextualDS sText= this.getFixture().createSTextualDS(text);
		SDataSourceSequence sequence= SaltFactory.eINSTANCE.createSDataSourceSequence();
		sequence.setSSequentialDS(sText);
		sequence.setSStart(0);
		sequence.setSEnd(1);
		SToken tok1= this.getFixture().createSToken(sequence);
		SSpan sSpan= this.getFixture().createSSpan(tok1);
		
		assertNotNull(sSpan);
		assertEquals(sSpan, this.getFixture().getSNode(sSpan.getSId()));
		EList<Edge> edges= this.getFixture().getEdges(sSpan.getSId(), tok1.getSId());
		assertNotNull(edges);
		assertEquals(1, edges.size());
		assertTrue(edges.get(0) instanceof SSpanningRelation);
		SSpanningRelation sSpanRel= (SSpanningRelation) edges.get(0);
		assertEquals(tok1, sSpanRel.getSToken());
		assertEquals(sSpan, sSpanRel.getSSpan());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#createSSpan(org.eclipse.emf.common.util.EList) <em>Add SSpan</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#createSSpan(org.eclipse.emf.common.util.EList)
	 */
	public void testCreateSSpan__EList() 
	{
		String text= "a sample text";
		STextualDS sText= this.getFixture().createSTextualDS(text);
		SDataSourceSequence sequence= SaltFactory.eINSTANCE.createSDataSourceSequence();
		sequence.setSSequentialDS(sText);
		
		sequence.setSStart(0);
		sequence.setSEnd(1);
		SToken tok1= this.getFixture().createSToken(sequence);
		
		sequence.setSStart(2);
		sequence.setSEnd(8);
		SToken tok2= this.getFixture().createSToken(sequence);
		
		sequence.setSStart(9);
		sequence.setSEnd(13);
		SToken tok3= this.getFixture().createSToken(sequence);
		
		EList<SToken> sTokens= new BasicEList<SToken>();
		sTokens.add(tok1);
		sTokens.add(tok2);
		sTokens.add(tok3);
		SSpan sSpan= this.getFixture().createSSpan(sTokens);
		
		assertNotNull(sSpan);
		assertEquals(sSpan, this.getFixture().getSNode(sSpan.getSId()));
		
		EList<Edge> edges= this.getFixture().getEdges(sSpan.getSId(), tok1.getSId());
		assertNotNull(edges);
		assertEquals(1, edges.size());
		assertTrue(edges.get(0) instanceof SSpanningRelation);
		SSpanningRelation sSpanRel= (SSpanningRelation) edges.get(0);
		assertEquals(tok1, sSpanRel.getSToken());
		assertEquals(sSpan, sSpanRel.getSSpan());
		
		edges= this.getFixture().getEdges(sSpan.getSId(), tok2.getSId());
		assertNotNull(edges);
		assertEquals(1, edges.size());
		assertTrue(edges.get(0) instanceof SSpanningRelation);
		sSpanRel= (SSpanningRelation) edges.get(0);
		assertEquals(tok2, sSpanRel.getSToken());
		assertEquals(sSpan, sSpanRel.getSSpan());
		
		edges= this.getFixture().getEdges(sSpan.getSId(), tok3.getSId());
		assertNotNull(edges);
		assertEquals(1, edges.size());
		assertTrue(edges.get(0) instanceof SSpanningRelation);
		sSpanRel= (SSpanningRelation) edges.get(0);
		assertEquals(tok3, sSpanRel.getSToken());
		assertEquals(sSpan, sSpanRel.getSSpan());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#createSStructure(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructuredNode) <em>Add SStructure</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#createSStructure(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructuredNode)
	 */
	public void testCreateSStructure__SStructuredNode() 
	{
		String text= "a sample";
		STextualDS sText= this.getFixture().createSTextualDS(text);
		SDataSourceSequence sequence= SaltFactory.eINSTANCE.createSDataSourceSequence();
		sequence.setSSequentialDS(sText);
		sequence.setSStart(0);
		sequence.setSEnd(1);
		
		SToken tok1= this.getFixture().createSToken(sequence);
		SStructure sStruct= this.getFixture().createSStructure(tok1);
		
		assertNotNull(sStruct);
		assertEquals(sStruct, this.getFixture().getSNode(sStruct.getSId()));
		EList<Edge> edges= this.getFixture().getEdges(sStruct.getSId(), tok1.getSId());
		assertNotNull(edges);
		assertEquals(1, edges.size());
		assertTrue(edges.get(0) instanceof SDominanceRelation);
		SDominanceRelation sDomRel= (SDominanceRelation) edges.get(0);
		assertEquals(tok1, sDomRel.getSStructuredTarget());
		assertEquals(sStruct, sDomRel.getSStructure());
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#createSStructure(org.eclipse.emf.common.util.EList) <em>Add SStructure</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#createSStructure(org.eclipse.emf.common.util.EList)
	 */
	public void testCreateSStructure__EList() 
	{
		String text= "a sample text";
		STextualDS sText= this.getFixture().createSTextualDS(text);
		SDataSourceSequence sequence= SaltFactory.eINSTANCE.createSDataSourceSequence();
		sequence.setSSequentialDS(sText);
		
		sequence.setSStart(0);
		sequence.setSEnd(1);
		SToken tok1= this.getFixture().createSToken(sequence);
		
		sequence.setSStart(2);
		sequence.setSEnd(8);
		SToken tok2= this.getFixture().createSToken(sequence);
		
		sequence.setSStart(9);
		sequence.setSEnd(13);
		SToken tok3= this.getFixture().createSToken(sequence);
		
		EList<SStructuredNode> sTokens= new BasicEList<SStructuredNode>();
		sTokens.add(tok1);
		sTokens.add(tok2);
		sTokens.add(tok3);
		SStructure sStruct= this.getFixture().createSStructure(sTokens);
		
		assertNotNull(sStruct);
		assertEquals(sStruct, this.getFixture().getSNode(sStruct.getSId()));
		
		EList<Edge> edges= this.getFixture().getEdges(sStruct.getSId(), tok1.getSId());
		assertNotNull(edges);
		assertEquals(1, edges.size());
		assertTrue(edges.get(0) instanceof SDominanceRelation);
		SDominanceRelation sDomRel= (SDominanceRelation) edges.get(0);
		assertEquals(tok1, sDomRel.getSStructuredTarget());
		assertEquals(sStruct, sDomRel.getSStructure());
		
		edges= this.getFixture().getEdges(sStruct.getSId(), tok2.getSId());
		assertNotNull(edges);
		assertEquals(1, edges.size());
		assertTrue(edges.get(0) instanceof SDominanceRelation);
		sDomRel= (SDominanceRelation) edges.get(0);
		assertEquals(tok2, sDomRel.getSStructuredTarget());
		assertEquals(sStruct, sDomRel.getSStructure());
		
		edges= this.getFixture().getEdges(sStruct.getSId(), tok3.getSId());
		assertNotNull(edges);
		assertEquals(1, edges.size());
		assertTrue(edges.get(0) instanceof SDominanceRelation);
		sDomRel= (SDominanceRelation) edges.get(0);
		assertEquals(tok3, sDomRel.getSStructuredTarget());
		assertEquals(sStruct, sDomRel.getSStructure());
	}

	/**
	 * tests graph:
	 * 			struct2			
	 * 		/	/			\
	 * 	struct1	/			|		
	 * 	/	|	/			|
	 * 	|	span1			span2		
	 * 	|	/	\	/					\
	 * tok1		tok2		tok3		tok4		tok5
	 * 
	 * PR's tok1-> tok2; tok3-> tok4; tok4->tok2
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getRootsBySRelation(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME)
	 */
	public void testGetRootsBySRelation__STYPE_NAME(){
		SToken tok1= null;
		SToken tok2= null;
		SToken tok3= null;
		SToken tok4= null;
		SToken tok5= null;
		
		SSpan span1= null;
		SSpan span2= null;
		
		SStructure struct1= null;
		SStructure struct2= null;
		{//Token
			tok1= SaltFactory.eINSTANCE.createSToken();
			tok1.setSName("tok1");
			this.getFixture().addSNode(tok1);
			assertEquals(tok1, this.getFixture().getSNode(tok1.getSId()));
			
			tok2= SaltFactory.eINSTANCE.createSToken();
			tok2.setSName("tok2");
			this.getFixture().addSNode(tok2);
			assertEquals(tok2, this.getFixture().getSNode(tok2.getSId()));
			
			tok3= SaltFactory.eINSTANCE.createSToken();
			tok3.setSName("tok3");
			this.getFixture().addSNode(tok3);
			assertEquals(tok3, this.getFixture().getSNode(tok3.getSId()));
			
			tok4= SaltFactory.eINSTANCE.createSToken();
			tok4.setSName("tok4");
			this.getFixture().addSNode(tok4);
			assertEquals(tok4, this.getFixture().getSNode(tok4.getSId()));
			
			tok5= SaltFactory.eINSTANCE.createSToken();
			tok5.setSName("tok5");
			this.getFixture().addSNode(tok5);
			assertEquals(tok5, this.getFixture().getSNode(tok5.getSId()));
		}//SToken
		{//SSpan
			span1= SaltFactory.eINSTANCE.createSSpan();
			span1.setSName("span1");
			this.getFixture().addSNode(span1);
			assertEquals(span1, this.getFixture().getSNode(span1.getSId()));
			
			span2= SaltFactory.eINSTANCE.createSSpan();
			span2.setSName("span2");
			this.getFixture().addSNode(span2);
			assertEquals(span2, this.getFixture().getSNode(span2.getSId()));
		}//SSpan
		
		{//SStructure
			struct1= SaltFactory.eINSTANCE.createSStructure();
			struct1.setSName("struct1");
			this.getFixture().addSNode(struct1);
			assertEquals(struct1, this.getFixture().getSNode(struct1.getSId()));
			
			struct2= SaltFactory.eINSTANCE.createSStructure();
			struct2.setSName("struct2");
			this.getFixture().addSNode(struct2);
			assertEquals(struct2, this.getFixture().getSNode(struct2.getSId()));
		}//SStructure
		
		{//SSpanningRelation
			SSpanningRelation sSpanRel= null;
			sSpanRel= SaltFactory.eINSTANCE.createSSpanningRelation();
			sSpanRel.setSToken(tok1);
			sSpanRel.setSSpan(span1);
			this.getFixture().addSRelation(sSpanRel);
			assertEquals(sSpanRel, this.getFixture().getSRelation(sSpanRel.getSId()));
			
			sSpanRel= SaltFactory.eINSTANCE.createSSpanningRelation();
			sSpanRel.setSToken(tok2);
			sSpanRel.setSSpan(span1);
			this.getFixture().addSRelation(sSpanRel);
			assertEquals(sSpanRel, this.getFixture().getSRelation(sSpanRel.getSId()));
			
			sSpanRel= SaltFactory.eINSTANCE.createSSpanningRelation();
			sSpanRel.setSToken(tok2);
			sSpanRel.setSSpan(span2);
			this.getFixture().addSRelation(sSpanRel);
			assertEquals(sSpanRel, this.getFixture().getSRelation(sSpanRel.getSId()));
			
			sSpanRel= SaltFactory.eINSTANCE.createSSpanningRelation();
			sSpanRel.setSToken(tok4);
			sSpanRel.setSSpan(span2);
			this.getFixture().addSRelation(sSpanRel);
			assertEquals(sSpanRel, this.getFixture().getSRelation(sSpanRel.getSId()));
		}//SSpanningRelation
		
		{//SDominanceRelation
			SDominanceRelation sDomRel= null;
			sDomRel= SaltFactory.eINSTANCE.createSDominanceRelation();
			sDomRel.setSStructure(struct1);
			sDomRel.setSStructuredTarget(tok1);
			this.getFixture().addSRelation(sDomRel);
			assertEquals(sDomRel, this.getFixture().getSRelation(sDomRel.getSId()));
			
			sDomRel= SaltFactory.eINSTANCE.createSDominanceRelation();
			sDomRel.setSStructure(struct1);
			sDomRel.setSStructuredTarget(span1);
			this.getFixture().addSRelation(sDomRel);
			assertEquals(sDomRel, this.getFixture().getSRelation(sDomRel.getSId()));
			
			sDomRel= SaltFactory.eINSTANCE.createSDominanceRelation();
			sDomRel.setSStructure(struct2);
			sDomRel.setSStructuredTarget(struct1);
			this.getFixture().addSRelation(sDomRel);
			assertEquals(sDomRel, this.getFixture().getSRelation(sDomRel.getSId()));
			
			sDomRel= SaltFactory.eINSTANCE.createSDominanceRelation();
			sDomRel.setSStructure(struct2);
			sDomRel.setSStructuredTarget(span1);
			this.getFixture().addSRelation(sDomRel);
			assertEquals(sDomRel, this.getFixture().getSRelation(sDomRel.getSId()));
			
			sDomRel= SaltFactory.eINSTANCE.createSDominanceRelation();
			sDomRel.setSStructure(struct2);
			sDomRel.setSStructuredTarget(span2);
			this.getFixture().addSRelation(sDomRel);
			assertEquals(sDomRel, this.getFixture().getSRelation(sDomRel.getSId()));
		}//SDominanceRelation
		
		{//SPointingRelation
			SPointingRelation sPRel= null;
			sPRel= SaltFactory.eINSTANCE.createSPointingRelation();
			sPRel.setSStructuredSource(tok1);
			sPRel.setSStructuredTarget(tok2);
			this.getFixture().addSRelation(sPRel);
			assertEquals(sPRel, this.getFixture().getSRelation(sPRel.getSId()));
			
			sPRel= SaltFactory.eINSTANCE.createSPointingRelation();
			sPRel.setSStructuredSource(tok3);
			sPRel.setSStructuredTarget(tok4);
			this.getFixture().addSRelation(sPRel);
			assertEquals(sPRel, this.getFixture().getSRelation(sPRel.getSId()));
			
			sPRel= SaltFactory.eINSTANCE.createSPointingRelation();
			sPRel.setSStructuredSource(tok4);
			sPRel.setSStructuredTarget(tok2);
			this.getFixture().addSRelation(sPRel);
			assertEquals(sPRel, this.getFixture().getSRelation(sPRel.getSId()));
		}//SPointingRelation
		
		{//print saltGraph to dot (just for testing)
//				Salt2DOT salt2Dot= new Salt2DOT();
//				salt2Dot.salt2Dot(this.getFixture().getSDocumentGraph(), URI.createFileURI("_TMP" + "/doc1.dot"));
		}
		
		EList<SNode> roots= null;
		{//check SSpanningRelation
			roots= new BasicEList<SNode>();
			roots.add(span1);
			roots.add(span2);
			assertTrue(roots.containsAll(this.getFixture().getRootsBySRelation(STYPE_NAME.SSPANNING_RELATION)));
			assertTrue(this.getFixture().getRootsBySRelation(STYPE_NAME.SSPANNING_RELATION).containsAll(roots));
		}//check SSpanningRelation
		
		{//check SDominanceRelation
			roots= new BasicEList<SNode>();
			roots.add(struct2);
			assertTrue(roots.containsAll(this.getFixture().getRootsBySRelation(STYPE_NAME.SDOMINANCE_RELATION)));
			assertTrue(this.getFixture().getRootsBySRelation(STYPE_NAME.SDOMINANCE_RELATION).containsAll(roots));
		}//check SDominanceRelation
		
		{//check SPointingRelation
			roots= new BasicEList<SNode>();
			roots.add(tok1);
			roots.add(tok3);
			assertTrue(roots.containsAll(this.getFixture().getRootsBySRelation(STYPE_NAME.SPOINTING_RELATION)));
			assertTrue(this.getFixture().getRootsBySRelation(STYPE_NAME.SPOINTING_RELATION).containsAll(roots));
		}//check SPointingRelation
	}
		
	/**
	 * Checks the method getRootsBySRelationSType().
	 * Just for SPointingRelation
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getRootsBySRelationSType(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME)
	 */
	public void testGetRootsBySRelationSType__STYPE_NAME() {
		//checking for SPointingRelation
			SNode node1= SaltFactory.eINSTANCE.createSToken();
			this.getFixture().addSNode(node1);
			SNode node2= SaltFactory.eINSTANCE.createSToken();
			this.getFixture().addSNode(node2);
			SNode node3= SaltFactory.eINSTANCE.createSToken();
			this.getFixture().addSNode(node3);
			
			String type1= "type1";
			String type2= "type2";
			
			SPointingRelation rel1= SaltFactory.eINSTANCE.createSPointingRelation();
			rel1.addSType(type1);
			rel1.setSSource(node1);
			rel1.setSTarget(node2);
			this.getFixture().addSRelation(rel1);
			
			SPointingRelation rel2= SaltFactory.eINSTANCE.createSPointingRelation();
			rel2.addSType(type2);
			rel2.setSSource(node2);
			rel2.setSTarget(node1);
			this.getFixture().addSRelation(rel2);
			
			assertTrue(this.getFixture().getRootsBySRelationSType(STYPE_NAME.SPOINTING_RELATION).containsKey(type1));
			assertTrue(this.getFixture().getRootsBySRelationSType(STYPE_NAME.SPOINTING_RELATION).containsKey(type2));
			assertEquals(1, this.getFixture().getRootsBySRelationSType(STYPE_NAME.SPOINTING_RELATION).get(type1).size());
			assertEquals(1, this.getFixture().getRootsBySRelationSType(STYPE_NAME.SPOINTING_RELATION).get(type2).size());
			assertTrue(this.getFixture().getRootsBySRelationSType(STYPE_NAME.SPOINTING_RELATION).get(type1).contains(node1));
			assertTrue(this.getFixture().getRootsBySRelationSType(STYPE_NAME.SPOINTING_RELATION).get(type2).contains(node2));
		//checking for SPointingRelation
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#createSToken(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialDS, java.lang.Integer, java.lang.Integer) <em>Create SToken</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#createSToken(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialDS, java.lang.Integer, java.lang.Integer)
	 */
	public void testCreateSToken__SSequentialDS_Integer_Integer() 
	{
		String sampleText= "This is a sample.";
		STextualDS primaryText= this.getFixture().createSTextualDS(sampleText);
		SToken tok1= this.getFixture().createSToken(primaryText, 0, 4);
		SToken tok2= this.getFixture().createSToken(primaryText, 5, 7);
		SToken tok3= this.getFixture().createSToken(primaryText, 8, 9);
		SToken tok4= this.getFixture().createSToken(primaryText, 10, 16);
		SToken tok5= this.getFixture().createSToken(primaryText, 16, 17);
		
		EList<STYPE_NAME> relations= new BasicEList<STYPE_NAME>();
		relations.add(STYPE_NAME.STEXT_OVERLAPPING_RELATION);
		SDataSourceSequence sequence= null;
		
		sequence= this.getFixture().getOverlappedDSSequences(tok1, relations).get(0);
		assertEquals(Integer.valueOf(0), sequence.getSStart());
		assertEquals(Integer.valueOf(4), sequence.getSEnd());
		assertEquals(primaryText, sequence.getSSequentialDS());
		
		sequence= this.getFixture().getOverlappedDSSequences(tok2, relations).get(0);
		assertEquals(Integer.valueOf(5), sequence.getSStart());
		assertEquals(Integer.valueOf(7), sequence.getSEnd());
		assertEquals(primaryText, sequence.getSSequentialDS());
		
		sequence= this.getFixture().getOverlappedDSSequences(tok3, relations).get(0);
		assertEquals(Integer.valueOf(8), sequence.getSStart());
		assertEquals(Integer.valueOf(9), sequence.getSEnd());
		assertEquals(primaryText, sequence.getSSequentialDS());
		
		sequence= this.getFixture().getOverlappedDSSequences(tok4, relations).get(0);
		assertEquals(Integer.valueOf(10), sequence.getSStart());
		assertEquals(Integer.valueOf(16), sequence.getSEnd());
		assertEquals(primaryText, sequence.getSSequentialDS());
		
		sequence= this.getFixture().getOverlappedDSSequences(tok5, relations).get(0);
		assertEquals(Integer.valueOf(16), sequence.getSStart());
		assertEquals(Integer.valueOf(17), sequence.getSEnd());
		assertEquals(primaryText, sequence.getSSequentialDS());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#tokenize() <em>Tokenize</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#tokenize()
	 */
	public void testTokenize() 
	{
		String text1="This is a sample.";
		String text2="This is the second sample.";
		
		STextualDS sText1= this.getFixture().createSTextualDS(text1);
		STextualDS sText2= this.getFixture().createSTextualDS(text2);
		
		this.getFixture().tokenize();
		
		assertEquals(11, this.getFixture().getSTokens().size());
		assertEquals(11, this.getFixture().getSTextualRelations().size());
		
		int relTosText1=0;
		int relTosText2=0;
		for (STextualRelation textRel: this.getFixture().getSTextualRelations())
		{
			if (textRel.getSTarget().equals(sText2))
				relTosText2++;
			else if (textRel.getSTarget().equals(sText1))
				relTosText1++;
		}
		
		assertEquals(5, relTosText1);
		assertEquals(6, relTosText2);
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#createTokenizer() <em>Create Tokenizer</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#createTokenizer()
	 */
	public void testCreateTokenizer() 
	{
		Tokenizer tokenizer= this.getFixture().createTokenizer();
		assertNotNull(tokenizer);
		assertEquals(this.getFixture(), tokenizer.getsDocumentGraph());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#insertSTokenAt(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS, java.lang.Integer, java.lang.String) <em>Insert SToken At</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#insertSTokenAt(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS, java.lang.Integer, java.lang.String)
	 */
	public void testInsertSTokenAt__STextualDS_Integer_String_Boolean() {
		EList<String> origText= new BasicEList<String>();
		origText.add("This");
		origText.add("is");
		origText.add("the");
		origText.add("original");
		origText.add("Text");
		
		StringBuilder str= new StringBuilder();
		STextualDS sTextualDS= SaltFactory.eINSTANCE.createSTextualDS();
		this.getFixture().addSNode(sTextualDS);
		for (String text: origText)
		{
			int start= str.length();
			str.append(text);
			int end= str.length();
			str.append(" ");
			getFixture().createSToken(sTextualDS, start, end);
		}
		
		sTextualDS.setSText(str.toString());
		
		
		String text="addition";
		
		SToken token=  this.getFixture().insertSTokenAt(sTextualDS, 5, text, true);
		assertNotNull(token);
		
		assertEquals(6, getFixture().getSTokens().size());
		assertEquals("This addition is the original Text ", sTextualDS.getSText());
		assertEquals(6, getFixture().getSTextualRelations().size());
		
		//This
		assertEquals(new Integer(0), getFixture().getSTextualRelations().get(0).getSStart());
		assertEquals(new Integer(4), getFixture().getSTextualRelations().get(0).getSEnd());
		
		//addition
		assertEquals(new Integer(5), getFixture().getSTextualRelations().get(5).getSStart());
		assertEquals(new Integer(13), getFixture().getSTextualRelations().get(5).getSEnd());
		
		//is
		assertEquals(new Integer(14), getFixture().getSTextualRelations().get(1).getSStart());
		assertEquals(new Integer(16), getFixture().getSTextualRelations().get(1).getSEnd());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#insertSTokensAt(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS, java.lang.Integer, org.eclipse.emf.common.util.EList) <em>Insert STokens At</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#insertSTokensAt(de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS, java.lang.Integer, org.eclipse.emf.common.util.EList)
	 */
	public void testInsertSTokensAt__STextualDS_Integer_EList_Boolean() {
		EList<String> origText= new BasicEList<String>();
		origText.add("This");
		origText.add("is");
		origText.add("the");
		origText.add("original");
		origText.add("Text");
		
		StringBuilder str= new StringBuilder();
		STextualDS sTextualDS= SaltFactory.eINSTANCE.createSTextualDS();
		this.getFixture().addSNode(sTextualDS);
		for (String text: origText)
		{
			int start= str.length();
			str.append(text);
			int end= str.length();
			str.append(" ");
			getFixture().createSToken(sTextualDS, start, end);
		}
		
		sTextualDS.setSText(str.toString());
		
		
		EList<String> text= new BasicEList<String>();
		text.add("is");
		text.add("the");
		text.add("text");
		text.add("to");
		text.add("be");
		text.add("added");

		EList<SToken> tokens= this.getFixture().insertSTokensAt(sTextualDS, 5, text, true);
		assertNotNull(tokens);
		assertEquals(6, tokens.size());
		
		assertEquals(11, getFixture().getSTokens().size());
		assertEquals("This is the text to be added is the original Text ", sTextualDS.getSText());
		assertEquals(11, getFixture().getSTextualRelations().size());
		
		//This
		assertEquals(new Integer(0), getFixture().getSTextualRelations().get(0).getSStart());
		assertEquals(new Integer(4), getFixture().getSTextualRelations().get(0).getSEnd());
		
		//is
		assertEquals(new Integer(5), getFixture().getSTextualRelations().get(5).getSStart());
		assertEquals(new Integer(7), getFixture().getSTextualRelations().get(5).getSEnd());
		
		//added
		assertEquals(new Integer(23), getFixture().getSTextualRelations().get(10).getSStart());
		assertEquals(new Integer(28), getFixture().getSTextualRelations().get(10).getSEnd());
		
		// second is
		assertEquals(new Integer(29), getFixture().getSTextualRelations().get(1).getSStart());
		assertEquals(new Integer(31), getFixture().getSTextualRelations().get(1).getSEnd());
	}

	/**
	 * Creates some {@link SNode} objects and checks if connecting them
	 * with the method {@link SDocumentGraph#createSRelation(SNode, SNode, STYPE_NAME, String)}
	 * works correctly. 
	 */
	public void testCreateSRelation__SNode_SNode_STYPE_NAME_String() 
	{
		STextualDS sText= getFixture().createSTextualDS("This is a sample text");
		SToken tok1= getFixture().createSToken(sText, 0, 4);
		SToken tok2= getFixture().createSToken(sText, 5, 7);
		SSpan sSpan= SaltFactory.eINSTANCE.createSSpan();
		getFixture().addSNode(sSpan);
		SStructure sStruct= SaltFactory.eINSTANCE.createSStructure();
		getFixture().addSNode(sStruct);
		SRelation sRel= null;
		
		assertEquals(new Long(2), getFixture().getNumOfEdges());
		
		sRel= getFixture().createSRelation(tok1, tok2, STYPE_NAME.SPOINTING_RELATION, "myNS::coref=anaphor;anotherNS::foo=bar");
		assertEquals(new Long(3), getFixture().getNumOfEdges());
		assertEquals(tok1, sRel.getSSource());
		assertEquals(tok2, sRel.getSTarget());
		assertEquals(2, sRel.getSAnnotations().size());
		SAnnotation sAnno= sRel.getSAnnotations().get(0);
		assertEquals("myNS", sAnno.getSNS());
		assertEquals("coref", sAnno.getSName());
		assertEquals("anaphor", sAnno.getSValue());
		sAnno= sRel.getSAnnotations().get(1);
		assertEquals("anotherNS", sAnno.getSNS());
		assertEquals("foo", sAnno.getSName());
		assertEquals("bar", sAnno.getSValue());
		
		sRel= getFixture().createSRelation(sSpan, tok2, STYPE_NAME.SSPANNING_RELATION, null);
		assertEquals(new Long(4), getFixture().getNumOfEdges());
		assertEquals(sSpan, sRel.getSSource());
		assertEquals(tok2, sRel.getSTarget());
		assertEquals(0, sRel.getSAnnotations().size());
		
		sRel= getFixture().createSRelation(sStruct, tok2, STYPE_NAME.SDOMINANCE_RELATION, null);
		assertEquals(new Long(5), getFixture().getNumOfEdges());
		assertEquals(sStruct, sRel.getSSource());
		assertEquals(tok2, sRel.getSTarget());
		assertEquals(0, sRel.getSAnnotations().size());
		
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getOverlappedSTokens(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode, org.eclipse.emf.common.util.EList) <em>Get Overlapped STokens</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getOverlappedSTokens(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode, org.eclipse.emf.common.util.EList)
	 */
	public void testGetOverlappedSTokens__SNode_EList() {
		STextualDS sText= getFixture().createSTextualDS("This is a sample text");
		SToken tok1= getFixture().createSToken(sText, 0, 4);
		SToken tok2= getFixture().createSToken(sText, 5, 7);
		SToken tok3= getFixture().createSToken(sText, 8, 9);
		SToken tok4= getFixture().createSToken(sText, 10, 15);
		SToken tok5= getFixture().createSToken(sText, 16, 20);
		EList<SToken> tokenList = new BasicEList<SToken>();
		tokenList.add(tok1);
		tokenList.add(tok2);
		tokenList.add(tok3);
		SSpan sSpan= fixture.createSSpan(tokenList);
		SRelation pointingRel = this.getFixture().createSRelation(sSpan, tok4, STYPE_NAME.SPOINTING_RELATION, null);
		
		EList<SStructuredNode> nodeList = new BasicEList<SStructuredNode>();
		nodeList.add(sSpan);
		nodeList.add(tok4);
		nodeList.add(tok5);
		SStructure sStructure = fixture.createSStructure(nodeList);
		
		// test whether the span overlaps tok1, tok2 and tok3
		EList<STYPE_NAME> typeList = new BasicEList<STYPE_NAME>();
		typeList.add(STYPE_NAME.SSPANNING_RELATION);
		//typeList.add(STYPE_NAME.SPOINTING_RELATION);
		System.out.println("Getting the tokens which are overlapped by the span. Those should be tok1,tok2 and tok3");
		System.out.println("There is a pointing relation from the span to tok4. tok4 is not allowed to be in the overlappedTokenList");
		
		for (Edge rel : fixture.getOutEdges(sSpan.getSId())){
			if (rel instanceof SPointingRelation){
				System.out.println("Found pointing relation from "+rel.getSource().getId() + " to "+rel.getTarget().getId());
			}
		}
		
		EList<SToken> overlappedTokenList1 = fixture.getOverlappedSTokens(sSpan, typeList);
		assertNotNull(overlappedTokenList1);
		System.out.println("TokenList contains:");
		for (SToken token : tokenList){
			System.out.print(token.getSId()+"\t");
		}
		System.out.println();
		System.out.println("OverlappedTokenList1 contains:");
		for (SToken token : overlappedTokenList1){
			System.out.print(token.getSId()+"\t");
		}
		System.out.println();
		assertTrue(overlappedTokenList1.containsAll(tokenList));
		assertFalse(overlappedTokenList1.contains(tok4));
		
		System.out.println("Getting the tokens which are overlapped by the span by the SSpanningRelation and the SPointingRelation."); 
		System.out.println("Those should be tok1,tok2,tok3 and tok4");
		EList<STYPE_NAME> typeList2 = new BasicEList<STYPE_NAME>();
		typeList2.add(STYPE_NAME.SSPANNING_RELATION);
		typeList2.add(STYPE_NAME.SPOINTING_RELATION);
		tokenList.add(tok4);
		EList<SToken> overlappedTokenListWithPointing = fixture.getOverlappedSTokens(sSpan, typeList2);
		assertNotNull(overlappedTokenListWithPointing);
		System.out.println("TokenList contains:");
		for (SToken token : tokenList){
			System.out.print(token.getSId()+"\t");
		}
		System.out.println();
		System.out.println("overlappedTokenListWithPointing contains:");
		for (SToken token : overlappedTokenListWithPointing){
			System.out.print(token.getSId()+"\t");
		}
		System.out.println();
		assertTrue(overlappedTokenListWithPointing.containsAll(tokenList));
		
		EList<SToken> allTokenList = new BasicEList<SToken>();
		allTokenList.add(tok1);
		allTokenList.add(tok2);
		allTokenList.add(tok3);
		allTokenList.add(tok4);
		allTokenList.add(tok5);
		typeList.add(STYPE_NAME.SDOMINANCE_RELATION);
		System.out.println("Getting the tokens which are overlapped by the structures. Those should be tok1 to tok5 since the struct overlaps the span and tok4 and tok5");
		EList<SToken> overlappedTokenList2 = fixture.getOverlappedSTokens(sStructure, typeList);
		assertNotNull(overlappedTokenList2);
		System.out.println("AllTokenList contains:");
		for (SToken token : allTokenList){
			System.out.print(token.getSId()+"\t");
		}
		System.out.println();
		System.out.println("OverlappedTokenList2 contains:");
		for (SToken token : overlappedTokenList2){
			System.out.print(token.getSId()+"\t");
		}
		System.out.println();
		assertTrue(overlappedTokenList2.containsAll(allTokenList));
		
		System.out.println("Now, we make something special:");
		System.out.println("The stucture overlapps the span, tok4, tok5 and tok2 directly.");
		System.out.println("In this case, tok2 is only allowed to occur once");
		nodeList.add(tok2);
		SStructure sStructure2 = fixture.createSStructure(nodeList);
		System.out.println("Getting the tokens which are overlapped by the structures. Those should be tok1 to tok5 since the struct overlaps the span and tok4 and tok5");
		EList<SToken> overlappedTokenList3 = fixture.getOverlappedSTokens(sStructure2, typeList);
		assertNotNull(overlappedTokenList3);
		System.out.println("The node list contains:");
		for (SNode node : nodeList){
			System.out.print(node.getSId()+"\t");
		}
		System.out.println();
		System.out.println("OverlappedTokenList3 contains:");
		for (SToken token : overlappedTokenList3){
			System.out.print(token.getSId()+"\t");
		}
		System.out.println();
		System.out.print("Checking whether all tokens are contained in the overlapped token list");
		assertTrue(overlappedTokenList3.containsAll(allTokenList));
		System.out.println(" ... SUCCESS");
		System.out.println("Removing first occurence of tok1,tok2,tok3,tok4 and tok5 from the overlapped token list");
		for (SToken token : allTokenList){
			overlappedTokenList3.remove(token);
		}
		System.out.print("The overlapped token list must be empty now. Checking");
		assertTrue(overlappedTokenList3.isEmpty());
		System.out.println("... SUCCESS");
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSText(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode) <em>Get SText</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSText(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode)
	 */
	public void testGetSText__SNode() {		
		SDocumentGraph fixGraph = this.getFixture();
		assertNull(fixGraph.getSText(null));
		String testText = "Is this example more complicated than it appears to be";
		fixGraph.createSTextualDS(testText);
		fixGraph.tokenize();
		String sText = fixGraph.getSText(fixGraph.getSTokens().get(4));
		assertNotNull(sText);
		assertFalse(sText.isEmpty());
		assertEquals("complicated", sText);
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSText(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode) <em>Get SText</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSText(de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode)
	 */
	public void testGetSText__SNode__withDiscontinuesSpan() {
		SDocumentGraph fixGraph = this.getFixture();
		String testText = "Is this example more complicated than it appears to be";
		fixGraph.createSTextualDS(testText);
		fixGraph.tokenize();
		/* collect tokens for discontinues span */
		EList<SToken> sTokens = new BasicEList<SToken>();		
		sTokens.add(fixGraph.getSTokens().get(0));
		sTokens.add(fixGraph.getSTokens().get(1));
		sTokens.add(fixGraph.getSTokens().get(fixGraph.getSTokens().size()-1));
		/* create discontinues span */
		String sText = fixGraph.getSText(fixGraph.createSSpan(sTokens));
		assertNotNull(sText);
		assertFalse(sText.isEmpty());
		assertEquals(testText, sText);
	}
} //SDocumentGraphTest
