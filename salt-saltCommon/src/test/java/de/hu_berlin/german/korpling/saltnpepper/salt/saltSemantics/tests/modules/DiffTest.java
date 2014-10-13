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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.tests.modules;

import junit.framework.TestCase;

import org.junit.Before;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.modules.Diff;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;
import de.hu_berlin.german.korpling.saltnpepper.salt.samples.SampleGenerator;

/**
 * This class tests the ismmorphie check of the {@link SDocumentGraph}. 
 * @author florian  
 */
public class DiffTest extends TestCase {

	protected Diff fixture = null;

	protected void setFixture(Diff fixture) {
		this.fixture = fixture;
	}

	protected Diff getFixture() {
		return fixture;
	}
	private SDocumentGraph template= null;
	private SDocumentGraph other= null;
	
	@Override
	@Before
	protected void setUp() throws Exception {
		template= SaltFactory.eINSTANCE.createSDocumentGraph();
		template.setSDocument(SaltFactory.eINSTANCE.createSDocument());
		
		other= SaltFactory.eINSTANCE.createSDocumentGraph();
		other.setSDocument(SaltFactory.eINSTANCE.createSDocument());
		
		setFixture(new Diff(template, other));
	}
	/** Tests two graphs containing 
	 * <ul>
	 *  <li>same primary date</li>
	 *  <li>different primary date</li>
	 *  <li>two primary data</li>
	 * </ul> 
	 **/
	public void testPrimaryData(){
		SampleGenerator.createPrimaryData(template.getSDocument());
		SampleGenerator.createPrimaryData(other.getSDocument());
		
		//same primary date
		assertTrue(getFixture().findDiffs());
		assertEquals(0, getFixture().getDifferences());
		
		//different primary date
		other= SaltFactory.eINSTANCE.createSDocumentGraph();
		other.getSTextualDSs().get(0).setSText("a different text");
		assertFalse(getFixture().findDiffs());
		assertEquals(1, getFixture().getDifferences());
		
		//two primary date
		other= SaltFactory.eINSTANCE.createSDocumentGraph();
		SampleGenerator.createPrimaryData(other.getSDocument());
		assertFalse(getFixture().findDiffs());
		assertEquals(1, getFixture().getDifferences());
	}
	
	/**
	 * Tests two graphs containing
	 * <ul>
	 * 	<li>same tokenization</li>
	 *  <li>different tokenization - number of tokens</li>
	 *  <li>different tokenization - different offsets</li>
	 * </ul>
	 */
	public void testToken(){
		SampleGenerator.createPrimaryData(template.getSDocument());
		SampleGenerator.createTokens(template.getSDocument());
		SampleGenerator.createPrimaryData(other.getSDocument());
		SampleGenerator.createTokens(other.getSDocument());
		
		//same tokenization
		assertTrue(getFixture().findDiffs());
		assertEquals(0, getFixture().getDifferences());
		
		//different tokenization - number of tokens
		other.createSToken(other.getSTextualDSs().get(0), 1, 3);
		assertFalse(getFixture().findDiffs());
		assertEquals(1, getFixture().getDifferences());
		
		//different tokenization - different offsets 
		other= SaltFactory.eINSTANCE.createSDocumentGraph();
		SampleGenerator.createPrimaryData(other.getSDocument());
		SampleGenerator.createTokens(other.getSDocument());
		other.removeNode(other.getSTokens().get(other.getSTokens().size()-1));
		other.createSToken(other.getSTextualDSs().get(0), 1, 20);
		assertFalse(getFixture().findDiffs());
		assertEquals(1, getFixture().getDifferences());
	}
	/**
	 * Checks the isomorphie for token annotation for listed cases:
	 * <ul>
	 *  <li>same annotations</li>
	 *  <li>different annotations - one additional annotation</li>
	 *  <li>different annotations - different annotation names</li>
	 * </ul>
	 */
	public void testTokenAnnotation(){
		SampleGenerator.createPrimaryData(template.getSDocument());
		SampleGenerator.createTokens(template.getSDocument());
		SampleGenerator.createPrimaryData(other.getSDocument());
		SampleGenerator.createTokens(other.getSDocument());
		
		for (SToken tok: template.getSTokens()){
			tok.createSAnnotation(null, "annoName", "annoVal");
		}
		
		for (SToken tok: other.getSTokens()){
			tok.createSAnnotation(null, "annoName", "annoVal");
		}
		//same annotations
		assertTrue(getFixture().findDiffs());
		assertEquals(0, getFixture().getDifferences());
		
		//different annotations - one additional annotation
		other.getSTokens().get(0).createSAnnotation(null, "annoName2", "annoVal");
		assertFalse(getFixture().findDiffs());
		assertEquals(1, getFixture().getDifferences());
		
		//different annotations - different annotation names
		other= SaltFactory.eINSTANCE.createSDocumentGraph();
		SampleGenerator.createPrimaryData(other.getSDocument());
		SampleGenerator.createTokens(other.getSDocument());
		for (SToken tok: other.getSTokens()){
			tok.createSAnnotation(null, "otherName", "annoVal");
		}
		assertFalse(getFixture().findDiffs());
		assertEquals(other.getSTokens().size(), getFixture().getDifferences());
	}
}
