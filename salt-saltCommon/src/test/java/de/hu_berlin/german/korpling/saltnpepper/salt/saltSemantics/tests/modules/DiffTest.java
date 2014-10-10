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
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructureFactory;
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
	/** Tests two graphs containing same primary data **/
	public void testPrimaryData_same(){
		SampleGenerator.createPrimaryData(template.getSDocument());
		SampleGenerator.createPrimaryData(other.getSDocument());
		
		assertTrue(getFixture().findDiffs());
		assertEquals(0, getFixture().getDifferences());
	}
	
	/** Tests two graphs containing different primary data **/
	public void testPrimaryData_different(){
		SampleGenerator.createPrimaryData(template.getSDocument());
		SampleGenerator.createPrimaryData(other.getSDocument());
		other.getSTextualDSs().get(0).setSText("a different text");
		
		assertFalse(getFixture().findDiffs());
		assertEquals(1, getFixture().getDifferences());
	}
	
	
}
