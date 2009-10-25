package de.hub.corpling.salt.saltCommon.modules.tests;

import de.hub.corpling.salt.saltCommon.SaltCommonFactory;
import de.hub.corpling.salt.saltCommon.modules.SDocumentDataEnricher;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructureFactory;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken;

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
