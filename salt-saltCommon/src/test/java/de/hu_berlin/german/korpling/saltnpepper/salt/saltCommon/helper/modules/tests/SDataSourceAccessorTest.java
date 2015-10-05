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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.helper.modules.tests;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.helper.modules.SDataSourceAccessor;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;

public class SDataSourceAccessorTest extends SDocumentStructureModuleTest
{
	private SDataSourceAccessor fixture= null;

	public void setFixture(SDataSourceAccessor fixture) {
		this.fixture = fixture;
	}

	public SDataSourceAccessor getFixture() {
		return fixture;
	} 
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception 
	{
		setFixture(new SDataSourceAccessor());
		this.getFixture().setSDocumentGraph(SaltFactory.eINSTANCE.createSDocumentGraph());
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}
	
	public void testGetSTokensBySequence()
	{
		String text= "This is a sample text.";
		
		SDataSourceSequence dsSequence= null;
		
		//start: create sample graph
			dsSequence= SaltFactory.eINSTANCE.createSDataSourceSequence();
			dsSequence.setSSequentialDS(this.getFixture().getSDocumentGraph().createSTextualDS(text));
			
			dsSequence.setSStart(0);
			dsSequence.setSEnd(4);
			SToken tok1= this.getFixture().getSDocumentGraph().createSToken(dsSequence);
		
			dsSequence.setSStart(5);
			dsSequence.setSEnd(7);
			SToken tok2= this.getFixture().getSDocumentGraph().createSToken(dsSequence);
			
			dsSequence.setSStart(8);
			dsSequence.setSEnd(9);
			SToken tok3= this.getFixture().getSDocumentGraph().createSToken(dsSequence);
			
			dsSequence.setSStart(10);
			dsSequence.setSEnd(16);
			SToken tok4= this.getFixture().getSDocumentGraph().createSToken(dsSequence);
			
			dsSequence.setSStart(17);
			dsSequence.setSEnd(21);
			SToken tok5= this.getFixture().getSDocumentGraph().createSToken(dsSequence);
			
			dsSequence.setSStart(21);
			dsSequence.setSEnd(22);
			SToken tok6= this.getFixture().getSDocumentGraph().createSToken(dsSequence);
		//end: create sample graph
		dsSequence.setSStart(0);
		dsSequence.setSEnd(4);
		assertTrue("shall be contained in returned list", this.getFixture().getSTokensBySequence(dsSequence).contains(tok1));
		
		dsSequence.setSStart(5);
		dsSequence.setSEnd(7);
		assertTrue("shall be contained in returned list", this.getFixture().getSTokensBySequence(dsSequence).contains(tok2));
		
		dsSequence.setSStart(8);
		dsSequence.setSEnd(9);
		assertTrue("shall be contained in returned list", this.getFixture().getSTokensBySequence(dsSequence).contains(tok3));
		
		dsSequence.setSStart(10);
		dsSequence.setSEnd(16);
		assertTrue("shall be contained in returned list", this.getFixture().getSTokensBySequence(dsSequence).contains(tok4));
		
		dsSequence.setSStart(17);
		dsSequence.setSEnd(21);
		assertTrue("shall be contained in returned list", this.getFixture().getSTokensBySequence(dsSequence).contains(tok5));
		
		dsSequence.setSStart(21);
		dsSequence.setSEnd(22);
		assertTrue("shall be contained in returned list", this.getFixture().getSTokensBySequence(dsSequence).contains(tok6));
		
		dsSequence.setSStart(5);
		dsSequence.setSEnd(16);
		assertTrue("shall be contained in returned list", this.getFixture().getSTokensBySequence(dsSequence).contains(tok2));
		assertTrue("shall be contained in returned list", this.getFixture().getSTokensBySequence(dsSequence).contains(tok3));
		assertTrue("shall be contained in returned list", this.getFixture().getSTokensBySequence(dsSequence).contains(tok4));
		
	}
}
