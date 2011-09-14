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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.modules.tests;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.modules.SDocumentDataEnricher;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructureFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;

public class SDocumentDataEnricherTest extends SDocumentStructureModuleTest
{
	
	@Override
	protected void setUp() throws Exception 
	{
		this.setFixture(new SDocumentDataEnricher());
		SDocumentGraph sDocGraph= SaltCommonFactory.eINSTANCE.createSDocumentGraph();
		this.getFixture().setSDocumentGraph(sDocGraph);
	}

	public void testCreateTimeline()
	{
		{//text 1
			STextualDS sText1= SDocumentStructureFactory.eINSTANCE.createSTextualDS();
			sText1.setSText("Hello, text1.");
			this.getFixture().getSDocumentGraph().addSNode(sText1);
			SToken sToken= null;
			STextualRelation sTextRel= null;
			
			sToken= SDocumentStructureFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(sToken);
			sTextRel= SDocumentStructureFactory.eINSTANCE.createSTextualRelation();
			sTextRel.setSTextualDS(sText1);
			sTextRel.setSToken(sToken);
			sTextRel.setSStart(0);
			sTextRel.setSEnd(5);
			this.getFixture().getSDocumentGraph().addSRelation(sTextRel);
			
			sToken= SDocumentStructureFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(sToken);
			sTextRel= SDocumentStructureFactory.eINSTANCE.createSTextualRelation();
			sTextRel.setSTextualDS(sText1);
			sTextRel.setSToken(sToken);
			sTextRel.setSStart(5);
			sTextRel.setSEnd(6);
			this.getFixture().getSDocumentGraph().addSRelation(sTextRel);
			
			sToken= SDocumentStructureFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(sToken);
			sTextRel= SDocumentStructureFactory.eINSTANCE.createSTextualRelation();
			sTextRel.setSTextualDS(sText1);
			sTextRel.setSToken(sToken);
			sTextRel.setSStart(7);
			sTextRel.setSEnd(12);
			this.getFixture().getSDocumentGraph().addSRelation(sTextRel);
			
			sToken= SDocumentStructureFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(sToken);
			sTextRel= SDocumentStructureFactory.eINSTANCE.createSTextualRelation();
			sTextRel.setSTextualDS(sText1);
			sTextRel.setSToken(sToken);
			sTextRel.setSStart(12);
			sTextRel.setSEnd(13);
			this.getFixture().getSDocumentGraph().addSRelation(sTextRel);
			
		}
		
		{//text 1
			STextualDS sText2= SDocumentStructureFactory.eINSTANCE.createSTextualDS();
			sText2.setSText("Hello, Text2.");
			this.getFixture().getSDocumentGraph().addSNode(sText2);
			SToken sToken= null;
			STextualRelation sTextRel= null;
			
			sToken= SDocumentStructureFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(sToken);
			sTextRel= SDocumentStructureFactory.eINSTANCE.createSTextualRelation();
			sTextRel.setSTextualDS(sText2);
			sTextRel.setSToken(sToken);
			sTextRel.setSStart(0);
			sTextRel.setSEnd(5);
			this.getFixture().getSDocumentGraph().addSRelation(sTextRel);
			
			sToken= SDocumentStructureFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(sToken);
			sTextRel= SDocumentStructureFactory.eINSTANCE.createSTextualRelation();
			sTextRel.setSTextualDS(sText2);
			sTextRel.setSToken(sToken);
			sTextRel.setSStart(5);
			sTextRel.setSEnd(6);
			this.getFixture().getSDocumentGraph().addSRelation(sTextRel);
			
			sToken= SDocumentStructureFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(sToken);
			sTextRel= SDocumentStructureFactory.eINSTANCE.createSTextualRelation();
			sTextRel.setSTextualDS(sText2);
			sTextRel.setSToken(sToken);
			sTextRel.setSStart(7);
			sTextRel.setSEnd(12);
			this.getFixture().getSDocumentGraph().addSRelation(sTextRel);
			
			sToken= SDocumentStructureFactory.eINSTANCE.createSToken();
			this.getFixture().getSDocumentGraph().addSNode(sToken);
			sTextRel= SDocumentStructureFactory.eINSTANCE.createSTextualRelation();
			sTextRel.setSTextualDS(sText2);
			sTextRel.setSToken(sToken);
			sTextRel.setSStart(12);
			sTextRel.setSEnd(13);
			this.getFixture().getSDocumentGraph().addSRelation(sTextRel);
		}
		
		((SDocumentDataEnricher)this.getFixture()).createSTimeline();
		assertNotNull(this.getFixture().getSDocumentGraph().getSTimeline());
		assertEquals(8, this.getFixture().getSDocumentGraph().getSTimelineRelations().size());
		
		for (Integer i= 0; i <= 8; i++)
		{
			assertTrue(this.getFixture().getSDocumentGraph().getSTimeline().getSPointsOfTime().contains(i.toString()));
		}
	}
}
