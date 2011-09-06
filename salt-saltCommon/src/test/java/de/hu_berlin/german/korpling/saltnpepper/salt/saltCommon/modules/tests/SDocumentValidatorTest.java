package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.modules.tests;

import java.io.File;

import org.eclipse.emf.common.util.URI;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.modules.SDocumentValidator;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;
import junit.framework.TestCase;

public class SDocumentValidatorTest extends TestCase 
{
	private SDocumentValidator fixture= null;

	public void setFixture(SDocumentValidator fixture) {
		this.fixture = fixture;
	}

	public SDocumentValidator getFixture() {
		return fixture;
	}
	
	public void setUp()
	{
		this.setFixture(new SDocumentValidator());
	}
	
	/**
	 * 		struct1
	 *		/	\
	 * 	tok1	tok2
	 */
	public void testValidSRelations_OK()
	{
		SDocument sDoc= SaltFactory.eINSTANCE.createSDocument();
		this.getFixture().setSDocument(sDoc);
		sDoc.setSDocumentGraph(SaltFactory.eINSTANCE.createSDocumentGraph());
		SStructure sStruct= SaltFactory.eINSTANCE.createSStructure();
		sDoc.getSDocumentGraph().addSNode(sStruct);
		
		SToken sTok1= SaltFactory.eINSTANCE.createSToken();
		sDoc.getSDocumentGraph().addSNode(sTok1);
		
		SToken sTok2= SaltFactory.eINSTANCE.createSToken();
		sDoc.getSDocumentGraph().addSNode(sTok2);
		
		SDominanceRelation sDomRel1= SaltFactory.eINSTANCE.createSDominanceRelation();
		sDomRel1.setSSource(sStruct);
		sDomRel1.setSTarget(sTok1);
		sDoc.getSDocumentGraph().addSRelation(sDomRel1);
		
		SDominanceRelation sDomRel2= SaltFactory.eINSTANCE.createSDominanceRelation();
		sDomRel2.setSSource(sStruct);
		sDomRel2.setSTarget(sTok2);
		sDoc.getSDocumentGraph().addSRelation(sDomRel2);
		
		assertNull(this.getFixture().validSRelations());
	}
	
	/**
	 * 		struct1
	 *		/	\
	 * 	tok1	tok2
	 */
	public void testValidSRelations_NOT_OK()
	{
		SDocument sDoc= SaltFactory.eINSTANCE.createSDocument();
		this.getFixture().setSDocument(sDoc);
		sDoc.setSDocumentGraph(SaltFactory.eINSTANCE.createSDocumentGraph());
		
		SDominanceRelation sDomRel1= SaltFactory.eINSTANCE.createSDominanceRelation();
		sDoc.getSDocumentGraph().addSRelation(sDomRel1);
		//checking relation without source and target
		assertEquals("expecting 2 errors", 2, this.getFixture().validSRelations().size());
		
		SStructure sStruct= SaltFactory.eINSTANCE.createSStructure();
		sDoc.getSDocumentGraph().addSNode(sStruct);
		sDomRel1.setSSource(sStruct);
		//checking relation without target
		assertEquals("expecting 1 error", 1, this.getFixture().validSRelations().size());
		
		SToken sTok1= SaltFactory.eINSTANCE.createSToken();
		sDoc.getSDocumentGraph().addSNode(sTok1);
		sDomRel1.setSTarget(sTok1);
		//checking relation without target
		assertNull("expecting no error", this.getFixture().validSRelations());
		
		SDominanceRelation sDomRel2= SaltFactory.eINSTANCE.createSDominanceRelation();
		sDoc.getSDocumentGraph().addSRelation(sDomRel2);
		assertEquals("expecting 2 errors", 2, this.getFixture().validSRelations().size());
		
		sDomRel2.setSSource(sStruct);
		assertEquals("expecting 1 error", 1, this.getFixture().validSRelations().size());
		
		SToken sTok2= SaltFactory.eINSTANCE.createSToken();
		sDoc.getSDocumentGraph().addSNode(sTok2);
		sDomRel2.setSTarget(sTok2);
		assertNull("expecting no error", this.getFixture().validSRelations());
	}
	
	/**
	 * 	struct2
	 * 	|	
	 * 	struct1
	 *	|
	 * 	tok1	tok2
	 * 	\		/
	 * 		sText
	 */
	public void testConnectedToSTextualDS()
	{
		SDocument sDoc= SaltFactory.eINSTANCE.createSDocument();
		this.getFixture().setSDocument(sDoc);
		sDoc.setSDocumentGraph(SaltFactory.eINSTANCE.createSDocumentGraph());
		STextualDS sText= SaltFactory.eINSTANCE.createSTextualDS();
		sDoc.getSDocumentGraph().addSNode(sText);
		assertNull("expected no errors", this.getFixture().connectedToSTextualDS());
		
		SStructure sStruct= SaltFactory.eINSTANCE.createSStructure();
		sDoc.getSDocumentGraph().addSNode(sStruct);
		assertEquals("expected 1 errors", 1, this.getFixture().connectedToSTextualDS().size());
		
		SToken sTok1= SaltFactory.eINSTANCE.createSToken();
		sDoc.getSDocumentGraph().addSNode(sTok1);
		assertEquals("expected 2 errors", 2, this.getFixture().connectedToSTextualDS().size());
		
		SToken sTok2= SaltFactory.eINSTANCE.createSToken();
		sDoc.getSDocumentGraph().addSNode(sTok2);
		assertEquals("expected 3 errors", 3, this.getFixture().connectedToSTextualDS().size());
		
		STextualRelation sTextRel1= SaltFactory.eINSTANCE.createSTextualRelation();
		sTextRel1.setSTextualDS(sText);
		sTextRel1.setSToken(sTok1);
		sDoc.getSDocumentGraph().addSRelation(sTextRel1);
		assertEquals("expected 2 errors", 2, this.getFixture().connectedToSTextualDS().size());
		
		STextualRelation sTextRel2= SaltFactory.eINSTANCE.createSTextualRelation();
		sTextRel2.setSTextualDS(sText);
		sTextRel2.setSToken(sTok2);
		sDoc.getSDocumentGraph().addSRelation(sTextRel2);
		assertEquals("expected 1 errors", 1, this.getFixture().connectedToSTextualDS().size());
		
		SDominanceRelation sDomRel1= SaltFactory.eINSTANCE.createSDominanceRelation();
		sDomRel1.setSSource(sStruct);
		sDomRel1.setSTarget(sTok1);
		sDoc.getSDocumentGraph().addSRelation(sDomRel1);
		
		assertNull("expected no errors", this.getFixture().connectedToSTextualDS());
		
		SStructure sStruct2= SaltFactory.eINSTANCE.createSStructure();
		sDoc.getSDocumentGraph().addSNode(sStruct2);
		assertEquals("expected 1 errors", 1, this.getFixture().connectedToSTextualDS().size());
		
		SDominanceRelation sDomRel2= SaltFactory.eINSTANCE.createSDominanceRelation();
		sDomRel2.setSSource(sStruct2);
		sDomRel2.setSTarget(sStruct);
		sDoc.getSDocumentGraph().addSRelation(sDomRel2);
		assertNull("expected no errors", this.getFixture().connectedToSTextualDS());
	}
	
	/**
	 * 	struct2		struct3
	 * 		|		/
	 * 		struct1
	 *		|
	 * 	tok1	tok2
	 * 	\		/
	 * 		sText
	 */
	public void testConnectedToSTextualDS2()
	{
		SDocument sDoc= SaltFactory.eINSTANCE.createSDocument();
		this.getFixture().setSDocument(sDoc);
		sDoc.setSDocumentGraph(SaltFactory.eINSTANCE.createSDocumentGraph());
		STextualDS sText= SaltFactory.eINSTANCE.createSTextualDS();
		sDoc.getSDocumentGraph().addSNode(sText);
		assertNull("expected no errors", this.getFixture().connectedToSTextualDS());
		
		SStructure sStruct= SaltFactory.eINSTANCE.createSStructure();
		sDoc.getSDocumentGraph().addSNode(sStruct);
		assertEquals("expected 1 errors", 1, this.getFixture().connectedToSTextualDS().size());
		
		SToken sTok1= SaltFactory.eINSTANCE.createSToken();
		sDoc.getSDocumentGraph().addSNode(sTok1);
		assertEquals("expected 2 errors", 2, this.getFixture().connectedToSTextualDS().size());
		
		SToken sTok2= SaltFactory.eINSTANCE.createSToken();
		sDoc.getSDocumentGraph().addSNode(sTok2);
		assertEquals("expected 3 errors", 3, this.getFixture().connectedToSTextualDS().size());
		
		STextualRelation sTextRel1= SaltFactory.eINSTANCE.createSTextualRelation();
		sTextRel1.setSTextualDS(sText);
		sTextRel1.setSToken(sTok1);
		sDoc.getSDocumentGraph().addSRelation(sTextRel1);
		assertEquals("expected 2 errors", 2, this.getFixture().connectedToSTextualDS().size());
		
		STextualRelation sTextRel2= SaltFactory.eINSTANCE.createSTextualRelation();
		sTextRel2.setSTextualDS(sText);
		sTextRel2.setSToken(sTok2);
		sDoc.getSDocumentGraph().addSRelation(sTextRel2);
		assertEquals("expected 1 errors", 1, this.getFixture().connectedToSTextualDS().size());
		
		SDominanceRelation sDomRel1= SaltFactory.eINSTANCE.createSDominanceRelation();
		sDomRel1.setSSource(sStruct);
		sDomRel1.setSTarget(sTok1);
		sDoc.getSDocumentGraph().addSRelation(sDomRel1);
		
		assertNull("expected no errors", this.getFixture().connectedToSTextualDS());
		
		SStructure sStruct2= SaltFactory.eINSTANCE.createSStructure();
		sDoc.getSDocumentGraph().addSNode(sStruct2);
		assertEquals("expected 1 errors", 1, this.getFixture().connectedToSTextualDS().size());
		
		SDominanceRelation sDomRel2= SaltFactory.eINSTANCE.createSDominanceRelation();
		sDomRel2.setSSource(sStruct2);
		sDomRel2.setSTarget(sStruct);
		sDoc.getSDocumentGraph().addSRelation(sDomRel2);
		assertNull("expected no errors", this.getFixture().connectedToSTextualDS());
		
		SStructure sStruct3= SaltFactory.eINSTANCE.createSStructure();
		sDoc.getSDocumentGraph().addSNode(sStruct3);
		assertEquals("expected 1 errors", 1, this.getFixture().connectedToSTextualDS().size());
		
		SDominanceRelation sDomRel3= SaltFactory.eINSTANCE.createSDominanceRelation();
		sDomRel3.setSSource(sStruct3);
		sDomRel3.setSTarget(sStruct);
		sDoc.getSDocumentGraph().addSRelation(sDomRel3);
		
		SaltProject sP= SaltFactory.eINSTANCE.createSaltProject();
		SCorpusGraph scg= SaltFactory.eINSTANCE.createSCorpusGraph();
		SCorpus corpus= SaltFactory.eINSTANCE.createSCorpus(); 
		scg.addSNode(corpus);
		sP.getSCorpusGraphs().add(scg);
		scg.addSDocument(corpus, sDoc);
		sP.saveSaltProject_DOT(URI.createFileURI(new File("D:/Test/tuebadz2/").getAbsolutePath()));
		
		assertNull("expected no errors", this.getFixture().connectedToSTextualDS());
	}
}
