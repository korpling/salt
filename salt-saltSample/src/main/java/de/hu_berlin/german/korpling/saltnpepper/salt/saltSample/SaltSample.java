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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltSample;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.xml.sax.SAXException;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SOrderRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeline;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimelineRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SLemmaAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SPOSAnnotation;


/**
 * This class shows the usage of the linguistic meta model Salt. 
 * Therefore we create a linguistic corpus with direct use of the Salt object model. We here demonstrate how to store this model 
 * to disk and how to load a model from disk into main memory. After that we demonstrate how to access model
 * elements in a Salt model. 
 * 
 * The sample is divided into two main parts, the handling of the corpus-structure and the handling of the document-structure:
 * <ol>
 * <li>The method {@link #createCorpusStructure(SaltProject)}shows how to create a corpus structure.</li>
 * <li>The method {@link #createSDocumentStructure(SDocument)} shows how to create a document structure.</li>
 * <ol>
 * Both of them are again divided into parts creating the different layers of an annotation graph. Please see the javadoc
 * of the named methods to get more information. 
 *  
 * @author Florian Zipser
 * @author Andreas Hildebrandt
 * @author Mario Frank
 *
 */
public class SaltSample 
{
	private SCorpusGraph sCorpusGraph=null;
	
	
	public SaltSample(){
		//Creating a new salt project, this is the main object and contains all the others. 
		SaltProject saltProject= SaltFactory.eINSTANCE.createSaltProject();
		{//creating a corpus structure for salt project
			System.out.print("creating a corpus structure for salt project...");
			createCorpusStructure(saltProject);
			System.out.println("OK");
		}//creating a corpus structure for salt project

		{//filling all of the documents in the corpus structure with document structure data
			System.out.print("filling all of the documents in the corpus structure with document structure data...");
			//this works, because after createCorpusStructure() was called, only one graph exists in salt project
			sCorpusGraph= saltProject.getSCorpusGraphs().get(0);
			for (SDocument sDocument: sCorpusGraph.getSDocuments())
			{//filling all of the documents in the corpus structure with document structure data	
				createSDocumentStructure(sDocument);
			}//filling all of the documents in the corpus structure with document structure data
			System.out.println("OK");
			
		}//filling all of the documents in the corpus structure with document structure data
	}
	
	/**
	 * Creates the following corpus structure and adds it to the given salt project.
	 * 
	 * 				rootCorpus
	 * 		/					\
	 * 	subCorp1				subCorp2
	 * 	/		\				/		\
	 * doc1		doc2		doc3		doc4
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public static SCorpusGraph createCorpusStructure(SaltProject saltProject) 
	{
		SCorpusGraph sCorpGraph= SaltFactory.eINSTANCE.createSCorpusGraph();
		saltProject.getSCorpusGraphs().add(sCorpGraph);
		SCorpus sCorpus1= SaltFactory.eINSTANCE.createSCorpus();
		sCorpus1.setSName("rootCorpus");
		sCorpGraph.addSNode(sCorpus1);
		SCorpus sCorpus2= SaltFactory.eINSTANCE.createSCorpus();
		sCorpus2.setSName("subCorpus1");
		SCorpus sCorpus3= SaltFactory.eINSTANCE.createSCorpus();
		sCorpus3.setSName("subCorpus2");
		
		sCorpGraph.addSSubCorpus(sCorpus1, sCorpus2);
		sCorpGraph.addSSubCorpus(sCorpus1, sCorpus3);
		
		SDocument sDoc= null;
		
		sDoc= SaltFactory.eINSTANCE.createSDocument();
		sDoc.setSName("doc1");
		sCorpGraph.addSDocument(sCorpus2, sDoc);
		
		sDoc= SaltFactory.eINSTANCE.createSDocument();
		sDoc.setSName("doc2");
		sCorpGraph.addSDocument(sCorpus2, sDoc);
		
		sDoc= SaltFactory.eINSTANCE.createSDocument();
		sDoc.setSName("doc3");
		sCorpGraph.addSDocument(sCorpus2, sDoc);
		
		sDoc= SaltFactory.eINSTANCE.createSDocument();
		sDoc.setSName("doc4");
		sCorpGraph.addSDocument(sCorpus2, sDoc);
		
		return(sCorpGraph);
	}
	
	/**
	 * The primary text, which is used for the samples.
	 */
	public static String PRIMARY_TEXT_EN= "Is this example more complicated than it appears to be?";
	/** Primary text of speaker1**/
	public static String PRIMARY_TEXT_EN_SPK1=PRIMARY_TEXT_EN;
	/** Primary text of speaker2**/
	public static String PRIMARY_TEXT_EN_SPK2="Uhm oh yes!";
	/**
	 * The primary text, which is used for the samples.
	 */
	public static String PRIMARY_TEXT_DE= "Ist dieses Beispiel komplizierter als es zu sein scheint?";
	/**
	 * The name of the morphologic layer containing the tokens. 
	 */
	public static String MORPHOLOGY_LAYER="morphology";
	/** iso  639-1 language code for english**/
	public static final String LANG_EN="en";
	/** iso  639-1 language code for german**/
	public static final String LANG_DE="de";
	
	/**
	 * Creates a {@link SDocumentGraph} containing to texts of two different speakers, who are aligned via 
	 * the {@link STimeline} related to the {@link SToken} objects. The texts are {@value #PRIMARY_TEXT_EN_SPK1}
	 * and {@value #PRIMARY_TEXT_EN_SPK2}, which are tokeized by words. The words 'to' and 'Oh' have been said
	 * simultaneously and are overlapping via the timeline.  
	 * @param sDocument
	 */
	public static void createDialogue(SDocument sDocument)
	{
		sDocument.setSDocumentGraph(SaltFactory.eINSTANCE.createSDocumentGraph());
		sDocument.getSDocumentGraph().createSTextualDS(PRIMARY_TEXT_EN_SPK1);
		createTokens(sDocument);
		STextualDS sText1= sDocument.getSDocumentGraph().getSTextualDSs().get(0);
		sDocument.getSDocumentGraph().createSTimeline();
		EList<String> timelineRelationsToDelete = new BasicEList<String>();
		for (STimelineRelation timelineRelation : sDocument.getSDocumentGraph().getSTimelineRelations()){
			timelineRelationsToDelete.add(timelineRelation.getSId());
		}
		
		for (String timelineRelId : timelineRelationsToDelete){
			sDocument.getSDocumentGraph().removeEdgeById(timelineRelId);
		}
		
		//add SOrderRelations for speaker 1
		SToken lastSTok= null;
		int lastPointOfTime=0;
		for (SToken sTok: sDocument.getSDocumentGraph().getSTokens())
		{
			if (lastSTok!= null)
			{
				SOrderRelation sOrd= SaltFactory.eINSTANCE.createSOrderRelation();
				sOrd.setSSource(lastSTok);
				sOrd.setSTarget(sTok);
				sDocument.getSDocumentGraph().addSRelation(sOrd);
			}
			
			// set timeline
			STimelineRelation sTimeRel= SaltFactory.eINSTANCE.createSTimelineRelation();
			sTimeRel.setSSource(sTok);
			sTimeRel.setSTarget(sDocument.getSDocumentGraph().getSTimeline());
			sTimeRel.setSStart(lastPointOfTime);
			lastPointOfTime += 1;
			if (lastPointOfTime == 10){
				lastPointOfTime += 1;
			}
			sTimeRel.setSEnd(lastPointOfTime);
			sDocument.getSDocumentGraph().addSRelation(sTimeRel);
			
			lastSTok= sTok;
		}
		
		//create text of speaker2
		STextualDS sText2= sDocument.getSDocumentGraph().createSTextualDS(PRIMARY_TEXT_EN_SPK2);
		
		SToken spk2_tok0= createToken(0, 3, sText2, sDocument, null);
		STimelineRelation sTimeRel0= SaltFactory.eINSTANCE.createSTimelineRelation();
		sTimeRel0.setSSource(spk2_tok0);
		sTimeRel0.setSTarget(sDocument.getSDocumentGraph().getSTimeline());
		sTimeRel0.setSStart(7);
		sTimeRel0.setSEnd(9);
		sDocument.getSDocumentGraph().addSRelation(sTimeRel0);
		
		SToken spk2_tok1= createToken(4, 6, sText2, sDocument, null);
		STimelineRelation sTimeRel1= SaltFactory.eINSTANCE.createSTimelineRelation();
		sTimeRel1.setSSource(spk2_tok1);
		sTimeRel1.setSTarget(sDocument.getSDocumentGraph().getSTimeline());
		sTimeRel1.setSStart(9);
		sTimeRel1.setSEnd(10);
		sDocument.getSDocumentGraph().addSRelation(sTimeRel1);
		
		SToken spk2_tok2= createToken(7, 11, sText2, sDocument, null);
		STimelineRelation sTimeRel2= SaltFactory.eINSTANCE.createSTimelineRelation();
		sTimeRel2.setSSource(spk2_tok2);
		sTimeRel2.setSTarget(sDocument.getSDocumentGraph().getSTimeline());
		sTimeRel2.setSStart(10);
		sTimeRel2.setSEnd(11);
		sDocument.getSDocumentGraph().addSRelation(sTimeRel2);
		
		//add SOrderRelations for speaker 2
		SOrderRelation sOrd1= SaltFactory.eINSTANCE.createSOrderRelation();
		sOrd1.setSSource(spk2_tok0);
		sOrd1.setSTarget(spk2_tok1);
		sDocument.getSDocumentGraph().addSRelation(sOrd1);
		
		SOrderRelation sOrd2= SaltFactory.eINSTANCE.createSOrderRelation();
		sOrd2.setSSource(spk2_tok1);
		sOrd2.setSTarget(spk2_tok2);
		sDocument.getSDocumentGraph().addSRelation(sOrd2);
	}
	
	/**
	 * Creates a {@link STextualDS} object containing the primary text {@link SaltSample#PRIMARY_TEXT_EN} and adds the object
	 * to the {@link SDocumentGraph} being contained by the given {@link SDocument} object.
	 * 
	 * @param sDocument the document, to which the created {@link STextualDS} object will be added
	 */
	public static void createPrimaryData(SDocument sDocument){
		createPrimaryData(sDocument, LANG_EN);
	}
	
	/**
	 * Creates a {@link STextualDS} object containing the primary text {@link SaltSample#PRIMARY_TEXT_EN}, which is either
	 * an english text or its german translation and adds the object
	 * to the {@link SDocumentGraph} being contained by the given {@link SDocument} object.
	 * 
	 * @param sDocument the document, to which the created {@link STextualDS} object will be added
	 * @param language the language of the resource to be created, {@link #LANG_EN} for english, {@link #LANG_DE} for german
	 * @return returns the created {@link STextualDS} object
	 */
	public static STextualDS createPrimaryData(SDocument sDocument, String language){
		if (sDocument== null)
			throw new SaltSampleException("Cannot create example, because the given sDocument is empty.");
		if (sDocument.getSDocumentGraph()== null)
			throw new SaltSampleException("Cannot create example, because the given sDocument does not contain an SDocumentGraph.");
		STextualDS sTextualDS = null;
		//creating the primary text depending on the language
			sTextualDS= SaltFactory.eINSTANCE.createSTextualDS();
			if (LANG_EN.equalsIgnoreCase(language))
				sTextualDS.setSText(PRIMARY_TEXT_EN);
			else if (LANG_DE.equalsIgnoreCase(language))
				sTextualDS.setSText(PRIMARY_TEXT_DE);
			//adding the text to the document-graph
			sDocument.getSDocumentGraph().addSNode(sTextualDS);
		//creating the primary text depending on the language
		return(sTextualDS);
	}
	
	/**
	 * Creates a set of {@link SToken} objects tokenizing the primary text {@link SaltSample#PRIMARY_TEXT_EN} in to the 
	 * following tokens:
	 * <ul>
	 *	<li>Is</li>
	 *	<li>this</li>
	 *	<li>example</li>
	 * 	<li>more</li>
	 * 	<li>complicated</li>
	 *	<li>than</li>
	 * 	<li>it</li>
	 * 	<li>appears</li>
	 * 	<li>to</li>
	 * 	<li>be</li>
	 * 	<li>?</li>
	 * </ul>
	 * The created {@link SToken} objects and corresponding {@link STextualRelation} objects are added to the given {@link SDocument} object.
	 * @param sDocument the document, to which the created {@link SToken} objects will be added
	 */
	public static void createTokens(SDocument sDocument){
		createTokens(sDocument, sDocument.getSDocumentGraph().getSTextualDSs().get(0));
	}
	
	/**
	 * temporarily used method
	 * @param sDocument
	 */
	public static void createTokens2(SDocument sDocument){
		createTokens2(sDocument, sDocument.getSDocumentGraph().getSTextualDSs().get(0));
	}
	
	/**
	 * Creates a set of {@link SToken} objects tokenizing the primary text {@link SaltSample#PRIMARY_TEXT_EN} or 
	 * {@link SaltSample#PRIMARY_TEXT_DE} depending on the given {@link STextualDS} object in to the 
	 * following tokens:
	 * <ul>
	 *	<li>Is</li>
	 *	<li>this</li>
	 *	<li>example</li>
	 * 	<li>more</li>
	 * 	<li>complicated</li>
	 *	<li>than</li>
	 * 	<li>it</li>
	 * 	<li>appears</li>
	 * 	<li>to</li>
	 * 	<li>be</li>
	 * 	<li>?</li>
	 * </ul>
	 * or
	 * <ul>
	 *	<li>Ist</li>
	 *	<li>dieses</li>
	 *	<li>Beispiel</li>
	 * 	<li>komplizierter</li>
	 * 	<li>als</li>
	 *	<li>es</li>
	 * 	<li>zu</li>
	 * 	<li>sein</li>
	 * 	<li>scheint</li>
	 * 	<li>?</li>
	 * </ul>
	 * The created {@link SToken} objects and corresponding {@link STextualRelation} objects are added to the given {@link SDocument} object.
	 * @param sDocument the document, to which the created {@link SToken} objects will be added
	 * @return list of created {@link SToken} objects
	 */
	public static List<SToken> createTokens(SDocument sDocument, STextualDS sTextualDS){
		//as a means to group elements, layers (SLayer) can be used. here, a layer
		//named "morphology" is created and the tokens will be added to it
		SLayer morphLayer = SaltFactory.eINSTANCE.createSLayer();
		morphLayer.setSName(MORPHOLOGY_LAYER);
		sDocument.getSDocumentGraph().addSLayer(morphLayer);
		
		List<SToken> retVal= new Vector<SToken>();
		
		if (sTextualDS.getSText().equals(PRIMARY_TEXT_EN))
		{
			retVal.add(createToken(0,2,sTextualDS,sDocument,morphLayer));		//Is
			retVal.add(createToken(3,7,sTextualDS,sDocument,morphLayer));		//this
			retVal.add(createToken(8,15,sTextualDS,sDocument,morphLayer));		//example
			retVal.add(createToken(16,20,sTextualDS,sDocument,morphLayer));		//more
			retVal.add(createToken(21,32,sTextualDS,sDocument,morphLayer));		//complicated
			retVal.add(createToken(33,37,sTextualDS,sDocument,morphLayer));		//than
			retVal.add(createToken(38,40,sTextualDS,sDocument,morphLayer));		//it
			retVal.add(createToken(41,48,sTextualDS,sDocument,morphLayer));		//supposed
			retVal.add(createToken(49,51,sTextualDS,sDocument,morphLayer));		//to
			retVal.add(createToken(52,55,sTextualDS,sDocument,morphLayer));		//be?
		}else if (sTextualDS.getSText().equals(PRIMARY_TEXT_DE))
		{
			retVal.add(createToken(0,3,sTextualDS,sDocument,morphLayer));	//Ist	
			retVal.add(createToken(4,10,sTextualDS,sDocument,morphLayer));	//dieses	
			retVal.add(createToken(11,19,sTextualDS,sDocument,morphLayer));	//Beipsiel
			retVal.add(createToken(20,33,sTextualDS,sDocument,morphLayer));	//komplizierter
			retVal.add(createToken(34,37,sTextualDS,sDocument,morphLayer));	//als
			retVal.add(createToken(38,40,sTextualDS,sDocument,morphLayer));	//es
			retVal.add(createToken(41,43,sTextualDS,sDocument,morphLayer));	//zu
			retVal.add(createToken(44,48,sTextualDS,sDocument,morphLayer));	//sein
			retVal.add(createToken(49,57,sTextualDS,sDocument,morphLayer));	//scheint?
		}
		return(retVal);
	}
	
	/**
	 * temporarily used method
	 * @param sDocument
	 * @param sTextualDS
	 * @return
	 */
	public static List<SToken> createTokens2(SDocument sDocument, STextualDS sTextualDS){
		//as a means to group elements, layers (SLayer) can be used. here, a layer
		//named "morphology" is created and the tokens will be added to it
		SLayer morphLayer = SaltFactory.eINSTANCE.createSLayer();
		morphLayer.setSName(MORPHOLOGY_LAYER);
		sDocument.getSDocumentGraph().addSLayer(morphLayer);
		
		List<SToken> retVal= new Vector<SToken>();
		
		if (sTextualDS.getSText().equals(PRIMARY_TEXT_EN))
		{
			retVal.add(createToken(0,2,sTextualDS,sDocument,morphLayer));		//Is
			retVal.add(createToken(3,7,sTextualDS,sDocument,morphLayer));		//this
			retVal.add(createToken(8,15,sTextualDS,sDocument,morphLayer));		//example
			retVal.add(createToken(16,20,sTextualDS,sDocument,morphLayer));		//more
			retVal.add(createToken(21,32,sTextualDS,sDocument,morphLayer));		//complicated
			retVal.add(createToken(33,37,sTextualDS,sDocument,morphLayer));		//than
			retVal.add(createToken(38,40,sTextualDS,sDocument,morphLayer));		//it
			retVal.add(createToken(41,48,sTextualDS,sDocument,morphLayer));		//supposed
			retVal.add(createToken(49,51,sTextualDS,sDocument,morphLayer));		//to
			retVal.add(createToken(52,54,sTextualDS,sDocument,morphLayer));		//be
			retVal.add(createToken(54,55,sTextualDS,sDocument,morphLayer));		//?
		}else if (sTextualDS.getSText().equals(PRIMARY_TEXT_DE))
		{
			retVal.add(createToken(0,3,sTextualDS,sDocument,morphLayer));	//Ist	
			retVal.add(createToken(4,10,sTextualDS,sDocument,morphLayer));	//dieses	
			retVal.add(createToken(11,19,sTextualDS,sDocument,morphLayer));	//Beipsiel
			retVal.add(createToken(20,33,sTextualDS,sDocument,morphLayer));	//komplizierter
			retVal.add(createToken(34,37,sTextualDS,sDocument,morphLayer));	//als
			retVal.add(createToken(38,40,sTextualDS,sDocument,morphLayer));	//es
			retVal.add(createToken(41,43,sTextualDS,sDocument,morphLayer));	//zu
			retVal.add(createToken(44,48,sTextualDS,sDocument,morphLayer));	//sein
			retVal.add(createToken(49,56,sTextualDS,sDocument,morphLayer));	//scheint
			retVal.add(createToken(56,57,sTextualDS,sDocument,morphLayer));	//?
		}
		return(retVal);
	}
	
	
	/**
	 * Creates a {@link SToken} covering the passed poition and returns it.
	 * @param start
	 * @param end
	 * @param sTextualDS
	 * @param sDocument
	 * @param layer
	 * @return created {@link SToken} object
	 */
	public static SToken createToken(int start, int end, STextualDS sTextualDS, SDocument sDocument, SLayer layer){
		SToken sToken= SaltFactory.eINSTANCE.createSToken();
		sDocument.getSDocumentGraph().addSNode(sToken);
		if (layer != null)
			layer.getSNodes().add(sToken);
		STextualRelation sTextRel= SaltFactory.eINSTANCE.createSTextualRelation();
		sTextRel.setSToken(sToken);
		sTextRel.setSTextualDS(sTextualDS);
		sTextRel.setSStart(start);
		sTextRel.setSEnd(end);
		sDocument.getSDocumentGraph().addSRelation(sTextRel);
		return(sToken);
	}
	
	public static void createParallelData(SDocument sDocument){
		createParallelData(sDocument,true);
	}
	
	/**
	 * Creates a small parallel corpus, containing an english and a german text.
	 * The english text is {@value #PRIMARY_TEXT_EN}, the german text is {@value #PRIMARY_TEXT_DE}. 
	 * Both are tokenized by word borders.
	 * 
	 * @param sDocument he document containing the {@link STextualDS} objects
	 */
	public static void createParallelData(SDocument sDocument,boolean addSTypeForPointRel){
		STextualDS pd_EN= createPrimaryData(sDocument, LANG_EN);
		STextualDS pd_DE= createPrimaryData(sDocument, LANG_DE);
		
		List<SToken> englishToks= createTokens(sDocument, pd_EN);
		List<SToken> germanToks= createTokens(sDocument, pd_DE);
		
		SPointingRelation pointRel = null;
		
		pointRel = (SPointingRelation) sDocument.getSDocumentGraph().createSRelation(englishToks.get(0), germanToks.get(0), STYPE_NAME.SPOINTING_RELATION, "align=en_de");
		if (addSTypeForPointRel)
			pointRel.addSType("align");
		pointRel = (SPointingRelation) sDocument.getSDocumentGraph().createSRelation(englishToks.get(1), germanToks.get(1), STYPE_NAME.SPOINTING_RELATION, "align=en_de");
		if (addSTypeForPointRel)
			pointRel.addSType("align");
		pointRel = (SPointingRelation) sDocument.getSDocumentGraph().createSRelation(englishToks.get(2), germanToks.get(2), STYPE_NAME.SPOINTING_RELATION, "align=en_de");
		if (addSTypeForPointRel)
			pointRel.addSType("align");
		pointRel = (SPointingRelation) sDocument.getSDocumentGraph().createSRelation(englishToks.get(5), germanToks.get(4), STYPE_NAME.SPOINTING_RELATION, "align=en_de");
		if (addSTypeForPointRel)
			pointRel.addSType("align");
		pointRel = (SPointingRelation) sDocument.getSDocumentGraph().createSRelation(englishToks.get(6), germanToks.get(5), STYPE_NAME.SPOINTING_RELATION, "align=en_de");
		if (addSTypeForPointRel)
			pointRel.addSType("align");
		pointRel = (SPointingRelation) sDocument.getSDocumentGraph().createSRelation(englishToks.get(7), germanToks.get(6), STYPE_NAME.SPOINTING_RELATION, "align=en_de");
		if (addSTypeForPointRel)
			pointRel.addSType("align");
		pointRel = (SPointingRelation) sDocument.getSDocumentGraph().createSRelation(englishToks.get(8), germanToks.get(7), STYPE_NAME.SPOINTING_RELATION, "align=en_de");
		if (addSTypeForPointRel)
			pointRel.addSType("align");
		pointRel = (SPointingRelation) sDocument.getSDocumentGraph().createSRelation(englishToks.get(9), germanToks.get(8), STYPE_NAME.SPOINTING_RELATION, "align=en_de");
		if (addSTypeForPointRel)
			pointRel.addSType("align");
		EList<SToken> sTokens= new BasicEList<SToken>();
		sTokens.add(englishToks.get(3));
		sTokens.add(englishToks.get(4));
		SSpan sSpan= sDocument.getSDocumentGraph().createSSpan(sTokens);
		pointRel = (SPointingRelation) sDocument.getSDocumentGraph().createSRelation(sSpan, germanToks.get(3), STYPE_NAME.SPOINTING_RELATION, "align=en_de");
		if (addSTypeForPointRel)
			pointRel.addSType("align");
	}
	
	/**
	 * Creates a small parallel corpus, containing an english and a german text.
	 * The english text is {@value #PRIMARY_TEXT_EN}, the german text is {@value #PRIMARY_TEXT_DE}. 
	 * Both are tokenized by word borders.
	 * 
	 * @param sDocument he document containing the {@link STextualDS} objects
	 */
	public static void createUntypedParallelData(SDocument sDocument){
		STextualDS pd_EN= createPrimaryData(sDocument, LANG_EN);
		STextualDS pd_DE= createPrimaryData(sDocument, LANG_DE);
		
		List<SToken> englishToks= createTokens(sDocument, pd_EN);
		List<SToken> germanToks= createTokens(sDocument, pd_DE);
		
		SPointingRelation pointRel = null;
		
		pointRel = (SPointingRelation) sDocument.getSDocumentGraph().createSRelation(englishToks.get(0), germanToks.get(0), STYPE_NAME.SPOINTING_RELATION, "align=en_de");
		pointRel = (SPointingRelation) sDocument.getSDocumentGraph().createSRelation(englishToks.get(1), germanToks.get(1), STYPE_NAME.SPOINTING_RELATION, "align=en_de");
		pointRel = (SPointingRelation) sDocument.getSDocumentGraph().createSRelation(englishToks.get(2), germanToks.get(2), STYPE_NAME.SPOINTING_RELATION, "align=en_de");
		pointRel = (SPointingRelation) sDocument.getSDocumentGraph().createSRelation(englishToks.get(5), germanToks.get(4), STYPE_NAME.SPOINTING_RELATION, "align=en_de");
		pointRel = (SPointingRelation) sDocument.getSDocumentGraph().createSRelation(englishToks.get(6), germanToks.get(5), STYPE_NAME.SPOINTING_RELATION, "align=en_de");
		pointRel = (SPointingRelation) sDocument.getSDocumentGraph().createSRelation(englishToks.get(7), germanToks.get(6), STYPE_NAME.SPOINTING_RELATION, "align=en_de");
		pointRel = (SPointingRelation) sDocument.getSDocumentGraph().createSRelation(englishToks.get(8), germanToks.get(7), STYPE_NAME.SPOINTING_RELATION, "align=en_de");
		pointRel = (SPointingRelation) sDocument.getSDocumentGraph().createSRelation(englishToks.get(9), germanToks.get(8), STYPE_NAME.SPOINTING_RELATION, "align=en_de");
		EList<SToken> sTokens= new BasicEList<SToken>();
		sTokens.add(englishToks.get(3));
		sTokens.add(englishToks.get(4));
		SSpan sSpan= sDocument.getSDocumentGraph().createSSpan(sTokens);
		pointRel = (SPointingRelation) sDocument.getSDocumentGraph().createSRelation(sSpan, germanToks.get(3), STYPE_NAME.SPOINTING_RELATION, "align=en_de");
	}
	
	/**
	 * Creates morphological annotations (pos and lemma) for the tokenized sample and adds them to each {@link SToken} object as
	 * {@link SPOSAnnotation} or {@link SLemmaAnnotation} object.
	 * <table>
	 * 	<tr><td>token</td><td>pos</td><td>lemma</td></tr>
	 * 	<tr><td>Is</td><td>VBZ</td><td>be</td></tr>
	 * 	<tr><td>this</td><td>DT</td><td>this</td></tr>
	 * 	<tr><td>example</td><td>NN</td><td>example</td></tr>
	 * 	<tr><td>more</td><td>ABR</td><td>more</td></tr>
	 * 	<tr><td>complicated</td><td>JJ</td><td>complicated</td></tr>
	 * 	<tr><td>than</td><td>IN</td><td>than</td></tr>
	 * 	<tr><td>it</td><td>PRP</td><td>it</td></tr>
	 * 	<tr><td>appears</td><td>VBZ</td><td>appear</td></tr>
	 * 	<tr><td>to</td><td>TO</td><td>to</td></tr>
	 * 	<tr><td>be</td><td>VB</td><td>be</td></tr>
	 * </table>
	 * @param sDocument the document containing the {@link SToken} and {@link STextualDS} objects
	 */
	public static void createMorphologyAnnotations(SDocument sDocument){
		List<SToken> sTokens= Collections.synchronizedList(sDocument.getSDocumentGraph().getSTokens());
		
		{//adding part-of speech annotations
			SPOSAnnotation sPOSAnno= null;
				
			//a list of all part-of-speech annotations for the words Is (VBZ), this (DT) ... be (VB)
			String[] posAnnotations={"VBZ", "DT", "NN", "ABR", "JJ", "IN", "PRP", "VBZ", "TO", "VB"}; 
			for (int i= 0; i< sTokens.size();i++)
			{
				sPOSAnno= SaltFactory.eINSTANCE.createSPOSAnnotation();
				sPOSAnno.setSValue(posAnnotations[i]);
				sTokens.get(i).addSAnnotation(sPOSAnno);
			}
		}//adding part-of speech annotations
			
		{//adding lemma annotations
			SLemmaAnnotation sLemmaAnno= null;
			
			//a list of all lemma annotations for the words Is (be), this (this) ... be (be)
			String[] posAnnotations={"be", "this", "example", "more", "complicated", "than", "it", "appear", "to", "be"}; 
			for (int i= 0; i< sTokens.size();i++)
			{
				sLemmaAnno= SaltFactory.eINSTANCE.createSLemmaAnnotation();
				sLemmaAnno.setSValue(posAnnotations[i]);
				sTokens.get(i).addSAnnotation(sLemmaAnno);
			}
		}//adding lemma annotations
				
	}
	
	public static void createMorphologyAnnotations2(SDocument sDocument){
		List<SToken> sTokens= Collections.synchronizedList(sDocument.getSDocumentGraph().getSTokens());
		
		{//adding part-of speech annotations
			SPOSAnnotation sPOSAnno= null;
				
			//a list of all part-of-speech annotations for the words Is (VBZ), this (DT) ... be (VB)
			String[] posAnnotations={"VBZ", "DT", "NN", "RBR", "JJ", "IN", "PRP", "VBZ", "TO", "VB", "."}; 
			for (int i= 0; i< sTokens.size();i++)
			{
				sPOSAnno= SaltFactory.eINSTANCE.createSPOSAnnotation();
				sPOSAnno.setSValue(posAnnotations[i]);
				sTokens.get(i).addSAnnotation(sPOSAnno);
			}
		}//adding part-of speech annotations
			
		{//adding lemma annotations
			SLemmaAnnotation sLemmaAnno= null;
			
			//a list of all lemma annotations for the words Is (be), this (this) ... be (be)
			String[] posAnnotations={"be", "this", "example", "more", "complicated", "than", "it", "appear", "to", "be", "?"}; 
			for (int i= 0; i< sTokens.size();i++)
			{
				sLemmaAnno= SaltFactory.eINSTANCE.createSLemmaAnnotation();
				sLemmaAnno.setSValue(posAnnotations[i]);
				sTokens.get(i).addSAnnotation(sLemmaAnno);
			}
		}//adding lemma annotations
				
	}
	
	/**
	 * Creates {@link SSpan} object above the tokenization.
	 * <table border="1">
	 * 	<tr>
	 * 	 	<td>contrast-focus</td>
	 * 		<td colspan="9">topic</td>
	 * </tr>
	 *  <tr>
	 *  	<td>Is</td>
	 *  	<td>this</td>
	 *   	<td>example</td>
	 *    	<td>more</td>
	 *     	<td>complicated</td>
	 *  	<td>than</td>
	 *   	<td>it</td>
	 *    	<td>appears</td>
	 *     	<td>to</td>
	 *     	<td>be</td>
	 *  </tr>
	 * </table>
	 * @param sDocument
	 */
	public static void createInformationStructureSpan(SDocument sDocument){
		if (sDocument.getSDocumentGraph()== null)
			sDocument.setSDocumentGraph(SaltFactory.eINSTANCE.createSDocumentGraph());
		
		if (	(sDocument.getSDocumentGraph().getSTokens()== null)||
				(sDocument.getSDocumentGraph().getSTokens().size()== 0))
		{
			if (	(sDocument.getSDocumentGraph().getSTextualDSs()== null)||
					(sDocument.getSDocumentGraph().getSTextualDSs().size()==0))
				SaltSample.createPrimaryData(sDocument);
			SaltSample.createTokens(sDocument);
		}
		
		List<SToken> sTokens= Collections.synchronizedList(sDocument.getSDocumentGraph().getSTokens());
		
		SSpan sSpan= null;
		SSpanningRelation sSpanRel= null;
		//creating a span node as placeholder for information-structure annotation
		sSpan= SaltFactory.eINSTANCE.createSSpan();
		//adding the created span to the document-graph
		sDocument.getSDocumentGraph().addSNode(sSpan);
		//creating an annotation for information-structure
		//creating a relation to connect a token with the span
		sSpanRel= SaltFactory.eINSTANCE.createSSpanningRelation();
		//setting the span as source of the relation
		sSpanRel.setSSpan(sSpan);
		//setting the first token as target of the relation
		sSpanRel.setSToken(sTokens.get(0));
		//adding the created relation to the document-graph
		sDocument.getSDocumentGraph().addSRelation(sSpanRel);
			
		sSpan= SaltFactory.eINSTANCE.createSSpan();
		sDocument.getSDocumentGraph().addSNode(sSpan);
		for (int i= 1; i< sTokens.size(); i++)
		{
			sSpanRel= SaltFactory.eINSTANCE.createSSpanningRelation();
			sSpanRel.setSSpan(sSpan);
			sSpanRel.setSToken(sTokens.get(i));
			sDocument.getSDocumentGraph().addSRelation(sSpanRel);
		}
	}
	
	/**
	 * Annotates the {@link SSpan} objects above the tokenization with information structural annotations.
	 * @param sDocument
	 */
	public static void createInformationStructureAnnotations(SDocument sDocument){
		SAnnotation sAnno= null;
		
		sAnno= SaltFactory.eINSTANCE.createSAnnotation();
		//setting the name of the annotation
		sAnno.setSName("Inf-Struct");
		//setting the value of the annotation
		sAnno.setSValue("contrast-focus");
		//adding the annotation to the placeholder span
		sDocument.getSDocumentGraph().getSSpans().get(0).addSAnnotation(sAnno);
		
		sAnno= SaltFactory.eINSTANCE.createSAnnotation();
		sAnno.setSName("Inf-Struct");
		sAnno.setSValue("topic");
		sDocument.getSDocumentGraph().getSSpans().get(1).addSAnnotation(sAnno);
	}
	
	/**
	 * Creates a syntax structure for the given {@link SDocument} object. If it does not already 
	 * contain a primary text and a tokenization, this method calls {@link #createPrimaryData(SDocument)} and
	 * {@link #createTokens(SDocument)}. 
	 * @param sDocument
	 */
	public static void createSyntaxStructure(SDocument sDocument){
		if (sDocument.getSDocumentGraph()== null)
			sDocument.setSDocumentGraph(SaltFactory.eINSTANCE.createSDocumentGraph());
		
		if (	(sDocument.getSDocumentGraph().getSTokens()== null)||
				(sDocument.getSDocumentGraph().getSTokens().size()== 0))
		{
			if (	(sDocument.getSDocumentGraph().getSTextualDSs()== null)||
					(sDocument.getSDocumentGraph().getSTextualDSs().size()==0))
				SaltSample.createPrimaryData(sDocument);
			SaltSample.createTokens(sDocument);
		}
		List<SToken> sTokens= Collections.synchronizedList(sDocument.getSDocumentGraph().getSTokens());
		
		// creating variables for the eInstance of the SaltFactory and for the SDocumentGraph 
		// (this is just for convenience)
		SaltFactory sf = SaltFactory.eINSTANCE;
		SDocumentGraph docGraph = sDocument.getSDocumentGraph();
		
		// creating the constituent nodes of the syntax tree
		// these nodes are of the type SStructure
		SStructure sq    = sf.createSStructure();
		SStructure np1   = sf.createSStructure();
		SStructure adjp1 = sf.createSStructure();
		SStructure adjp2 = sf.createSStructure();
		SStructure sbar  = sf.createSStructure();
		SStructure s1    = sf.createSStructure();
		SStructure np2   = sf.createSStructure();
		SStructure vp1   = sf.createSStructure();
		SStructure s2    = sf.createSStructure();
		SStructure vp2   = sf.createSStructure();
		SStructure vp3   = sf.createSStructure();
		
		// there are two methods named "addSNode" for a SDocumentGraph
		// the first one simply adds the single parameter of the type SNode to the SDocumentGraph
		// the second one requires three arguments: two SNodes and a STYPE_NAME
		// this method will create a SRelation between the two SNodes. The type of the SRelation is determined by
		// the STYPE_NAME, but only four STYPE_NAMEs are allowed: SDOMINANCE_RELATION, SPOINTING_RELATION,
		// SSPANNING_RELATION and STEXTUAL_RELATION. For the hierarchical structure that is intended to build, SDOMINANCE_RELATION is used.
		// the first SNode (the source of the relation) is required to be contained in the SDocumentGraph already, so when building such
		// a tree, the root node has to be added to the SDocumentGraph before establishing the relations between the other nodes.
			
		// creating a variable for the type of relation between the constituents (dominance relation)
		// (this is just for convenience)
		STYPE_NAME domRel = STYPE_NAME.SDOMINANCE_RELATION;

		// adding the root SNode to the SDocumentGraph
		docGraph.addSNode(sq);				
		
		// adding the target nodes to the SDocumentGraph and creating SDominanceRelations between the respective nodes
		// (addSNode returns the created SDominanceRelation, but it it not used here)
		docGraph.addSNode(sq,    sTokens.get(0),  domRel); // "Is"
		docGraph.addSNode(sq,    np1,             domRel);
		docGraph.addSNode(np1,   sTokens.get(1),  domRel); // "this"
		docGraph.addSNode(np1,   sTokens.get(2),  domRel); // "example"
		docGraph.addSNode(sq,    adjp1,           domRel);
		docGraph.addSNode(adjp1, adjp2,           domRel);
		docGraph.addSNode(adjp2, sTokens.get(3),  domRel); // "more"
		docGraph.addSNode(adjp2, sTokens.get(4),  domRel); // "complicated"				
		docGraph.addSNode(adjp1, sbar,            domRel);
		docGraph.addSNode(sbar,  sTokens.get(5),  domRel); // "than"
		docGraph.addSNode(sbar,  s1,              domRel);				
		docGraph.addSNode(s1,    np2,             domRel);				
		docGraph.addSNode(np2,   sTokens.get(6),  domRel); // "it"
		docGraph.addSNode(s1,    vp1,             domRel);
		docGraph.addSNode(vp1,   sTokens.get(7),  domRel); // "appears"				
		docGraph.addSNode(vp1,   s2,              domRel);				
		docGraph.addSNode(s2,    vp2,             domRel);
		docGraph.addSNode(vp2,   sTokens.get(8),  domRel); // "to"				
		docGraph.addSNode(vp2,   vp3,             domRel);
		docGraph.addSNode(vp3,   sTokens.get(9),  domRel); // "be"
			
		// creating a layer named "syntax" for the constituents of the tree
		SLayer syntaxLayer = SaltFactory.eINSTANCE.createSLayer();
		syntaxLayer.setSName("syntax");
		docGraph.addSLayer(syntaxLayer);

		// adding the constituents to the syntax layer
		syntaxLayer.getSNodes().add(sq);
		syntaxLayer.getSNodes().add(np1);
		syntaxLayer.getSNodes().add(adjp1);				
		syntaxLayer.getSNodes().add(adjp2);
		syntaxLayer.getSNodes().add(sbar);				
		syntaxLayer.getSNodes().add(s1);
		syntaxLayer.getSNodes().add(np2);				
		syntaxLayer.getSNodes().add(vp1);
		syntaxLayer.getSNodes().add(s2);				
		syntaxLayer.getSNodes().add(vp2);
		syntaxLayer.getSNodes().add(vp3);				
	}
	
	/**
	 * Creates a syntax structure for the given {@link SDocument} object. If it does not already 
	 * contain a primary text and a tokenization, this method calls {@link #createPrimaryData(SDocument)} and
	 * {@link #createTokens(SDocument)}. 
	 * @param sDocument
	 */
	public static void createSyntaxStructure2(SDocument sDocument){
		if (sDocument.getSDocumentGraph()== null)
			sDocument.setSDocumentGraph(SaltFactory.eINSTANCE.createSDocumentGraph());
		
		if (	(sDocument.getSDocumentGraph().getSTokens()== null)||
				(sDocument.getSDocumentGraph().getSTokens().size()== 0))
		{
			if (	(sDocument.getSDocumentGraph().getSTextualDSs()== null)||
					(sDocument.getSDocumentGraph().getSTextualDSs().size()==0))
				SaltSample.createPrimaryData(sDocument);
			SaltSample.createTokens(sDocument);
		}
		List<SToken> sTokens= Collections.synchronizedList(sDocument.getSDocumentGraph().getSTokens());
		
		// creating variables for the eInstance of the SaltFactory and for the SDocumentGraph 
		// (this is just for convenience)
		SaltFactory sf = SaltFactory.eINSTANCE;
		SDocumentGraph docGraph = sDocument.getSDocumentGraph();
		
		// creating the constituent nodes of the syntax tree
		// these nodes are of the type SStructure
		SStructure root  = sf.createSStructure();
		SStructure sq    = sf.createSStructure();
		SStructure np1   = sf.createSStructure();
		SStructure adjp1 = sf.createSStructure();
		SStructure adjp2 = sf.createSStructure();
		SStructure sbar  = sf.createSStructure();
		SStructure s1    = sf.createSStructure();
		SStructure np2   = sf.createSStructure();
		SStructure vp1   = sf.createSStructure();
		SStructure s2    = sf.createSStructure();
		SStructure vp2   = sf.createSStructure();
		SStructure vp3   = sf.createSStructure();
		
		// there are two methods named "addSNode" for a SDocumentGraph
		// the first one simply adds the single parameter of the type SNode to the SDocumentGraph
		// the second one requires three arguments: two SNodes and a STYPE_NAME
		// this method will create a SRelation between the two SNodes. The type of the SRelation is determined by
		// the STYPE_NAME, but only four STYPE_NAMEs are allowed: SDOMINANCE_RELATION, SPOINTING_RELATION,
		// SSPANNING_RELATION and STEXTUAL_RELATION. For the hierarchical structure that is intended to build, SDOMINANCE_RELATION is used.
		// the first SNode (the source of the relation) is required to be contained in the SDocumentGraph already, so when building such
		// a tree, the root node has to be added to the SDocumentGraph before establishing the relations between the other nodes.
			
		// creating a variable for the type of relation between the constituents (dominance relation)
		// (this is just for convenience)
		STYPE_NAME domRel = STYPE_NAME.SDOMINANCE_RELATION;

		// adding the root SNode to the SDocumentGraph
		docGraph.addSNode(root);				
		
		// adding the target nodes to the SDocumentGraph and creating SDominanceRelations between the respective nodes
		// (addSNode returns the created SDominanceRelation, but it it not used here)
		docGraph.addSNode(root,	 sq,			  domRel);
		docGraph.addSNode(sq,    sTokens.get(0),  domRel); // "Is"
		docGraph.addSNode(sq,    np1,             domRel);
		docGraph.addSNode(np1,   sTokens.get(1),  domRel); // "this"
		docGraph.addSNode(np1,   sTokens.get(2),  domRel); // "example"
		docGraph.addSNode(sq,    adjp1,           domRel);
		docGraph.addSNode(adjp1, adjp2,           domRel);
		docGraph.addSNode(adjp2, sTokens.get(3),  domRel); // "more"
		docGraph.addSNode(adjp2, sTokens.get(4),  domRel); // "complicated"				
		docGraph.addSNode(adjp1, sbar,            domRel);
		docGraph.addSNode(sbar,  sTokens.get(5),  domRel); // "than"
		docGraph.addSNode(sbar,  s1,              domRel);				
		docGraph.addSNode(s1,    np2,             domRel);				
		docGraph.addSNode(np2,   sTokens.get(6),  domRel); // "it"
		docGraph.addSNode(s1,    vp1,             domRel);
		docGraph.addSNode(vp1,   sTokens.get(7),  domRel); // "appears"				
		docGraph.addSNode(vp1,   s2,              domRel);				
		docGraph.addSNode(s2,    vp2,             domRel);
		docGraph.addSNode(vp2,   sTokens.get(8),  domRel); // "to"				
		docGraph.addSNode(vp2,   vp3,             domRel);
		docGraph.addSNode(vp3,   sTokens.get(9),  domRel); // "be"
		docGraph.addSNode(root,  sTokens.get(10), domRel); // "?"
			
		// creating a layer named "syntax" for the constituents of the tree
		SLayer syntaxLayer = SaltFactory.eINSTANCE.createSLayer();
		syntaxLayer.setSName("syntax");
		docGraph.addSLayer(syntaxLayer);

		// adding the constituents to the syntax layer
		syntaxLayer.getSNodes().add(root);
		syntaxLayer.getSNodes().add(sq);
		syntaxLayer.getSNodes().add(np1);
		syntaxLayer.getSNodes().add(adjp1);				
		syntaxLayer.getSNodes().add(adjp2);
		syntaxLayer.getSNodes().add(sbar);				
		syntaxLayer.getSNodes().add(s1);
		syntaxLayer.getSNodes().add(np2);				
		syntaxLayer.getSNodes().add(vp1);
		syntaxLayer.getSNodes().add(s2);				
		syntaxLayer.getSNodes().add(vp2);
		syntaxLayer.getSNodes().add(vp3);				
	}
	
	/**
	 * 
	 * @param sDocument
	 */
	public static void createSyntaxAnnotations2(SDocument sDocument){
		List<SStructure> sStructures= Collections.synchronizedList(sDocument.getSDocumentGraph().getSStructures());
		String [] annotations = {"ROOT","SQ","NP","ADJP","ADJP","SBar","S","NP","VP","S","VP","VP"};
		String annoNS   = null;     // no namespace used in this example
		String annoName = "const";  // our name for a constituent
		SAnnotation sAnno= null;
		int i = 0;
		for (SStructure sStructure : sStructures){
			sAnno= SaltFactory.eINSTANCE.createSAnnotation();
			sAnno.setNamespace(annoNS);
			sAnno.setSName(annoName);
			sAnno.setSValue(annotations[i]);
			i++;
			sStructure.addSAnnotation(sAnno);
		}
	
	}
	
	/**
	 * 
	 * @param sDocument
	 */
	public static void createSyntaxAnnotations(SDocument sDocument){
		List<SStructure> sStructures= Collections.synchronizedList(sDocument.getSDocumentGraph().getSStructures());
		String [] annotations = {"SQ","NP","ADJP","ADJP","SBar","S","NP","VP","S","VP","VP"};
		String annoNS   = null;     // no namespace used in this example
		String annoName = "const";  // our name for a constituent
		SAnnotation sAnno= null;
		int i = 0;
		for (SStructure sStructure : sStructures){
			sAnno= SaltFactory.eINSTANCE.createSAnnotation();
			sAnno.setNamespace(annoNS);
			sAnno.setSName(annoName);
			sAnno.setSValue(annotations[i]);
			i++;
			sStructure.addSAnnotation(sAnno);
		}
	
	}
	
	/** 
	 * This method creates the sample's dependency annotation
	 * @param sDocument
	 */
	public static void createDependencies(SDocument sDocument){
		/* is there a document graph? */
		if(sDocument.getSDocumentGraph()==null){
			sDocument.setSDocumentGraph(SaltFactory.eINSTANCE.createSDocumentGraph());
		}
		SDocumentGraph docGraph = sDocument.getSDocumentGraph();
		/* is there primary data? */
		if((docGraph.getSTextualDSs()==null) || (docGraph.getSTextualDSs().size()==0)){
			SaltSample.createPrimaryData(sDocument);
		}
		/* is there a tokenization of the primary data? */
		if((docGraph.getSTokens()==null) || (docGraph.getSTokens().size()==0)){
			SaltSample.createTokens(sDocument);
		}
		
		List<SToken> sTokens = docGraph.getSortedSTokenByText();
		SLayer depLayer = SaltFactory.eINSTANCE.createSLayer();
		depLayer.setSName("dependencies");
		depLayer.createSMetaAnnotation(null, "tagset", "penn treebank");
		sDocument.getSDocumentGraph().addLayer(depLayer);		
		
		/* -- create dependency annotation (PennTreebank scheme) for EXPECTED tokens -- */		
		
		//	cop(complicated-5, Is-1) "Is"
		SPointingRelation depRel = SaltFactory.eINSTANCE.createSPointingRelation();
		depRel.setSSource(sTokens.get(4));
		depRel.setSTarget(sTokens.get(0));		
		depRel.createSAnnotation(null, "dependency", "cop");
		docGraph.addSRelation(depRel);
		depLayer.getEdges().add(depRel);
		
		//	det(example-3, this-2) "this"
		depRel = SaltFactory.eINSTANCE.createSPointingRelation();
		depRel.setSSource(sTokens.get(2));
		depRel.setSTarget(sTokens.get(1));		
		depRel.createSAnnotation(null, "dependency", "det");
		docGraph.addSRelation(depRel);
		depLayer.getEdges().add(depRel);
		
		//	nsubj(complicated-5, example-3) "example"
		depRel = SaltFactory.eINSTANCE.createSPointingRelation();
		depRel.setSSource(sTokens.get(4));
		depRel.setSTarget(sTokens.get(2));		
		depRel.createSAnnotation(null, "dependency", "nsubj");
		docGraph.addSRelation(depRel);
		depLayer.getEdges().add(depRel);
		
		//	advmod(complicated-5, more-4) "more"
		depRel = SaltFactory.eINSTANCE.createSPointingRelation();
		depRel.setSSource(sTokens.get(4));
		depRel.setSTarget(sTokens.get(3));		
		depRel.createSAnnotation(null, "dependency", "advmod");	
		docGraph.addSRelation(depRel);
		depLayer.getEdges().add(depRel);
		
		//	mark(appears-8, than-6) "than"
		depRel = SaltFactory.eINSTANCE.createSPointingRelation();
		depRel.setSSource(sTokens.get(7));
		depRel.setSTarget(sTokens.get(5));		
		depRel.createSAnnotation(null, "dependency", "mark");
		docGraph.addSRelation(depRel);
		depLayer.getEdges().add(depRel);
		
		//	nsubj(appears-8, it-7) "it"
		depRel = SaltFactory.eINSTANCE.createSPointingRelation();
		depRel.setSSource(sTokens.get(7));
		depRel.setSTarget(sTokens.get(6));		
		depRel.createSAnnotation(null, "dependency", "nsubj");
		docGraph.addSRelation(depRel);
		depLayer.getEdges().add(depRel);
		
		//	advcl(complicated-5, appears-8) "appears"
		depRel = SaltFactory.eINSTANCE.createSPointingRelation();
		depRel.setSSource(sTokens.get(4));
		depRel.setSTarget(sTokens.get(7));		
		depRel.createSAnnotation(null, "dependency", "advcl");
		docGraph.addSRelation(depRel);
		depLayer.getEdges().add(depRel);
		
		//	aux(be-10, to-9) "to"
		depRel = SaltFactory.eINSTANCE.createSPointingRelation();
		depRel.setSSource(sTokens.get(9));
		depRel.setSTarget(sTokens.get(8));		
		depRel.createSAnnotation(null, "dependency", "aux");
		docGraph.addSRelation(depRel);
		depLayer.getEdges().add(depRel);
		
		//	xcomp(appears-8, be-10) "be"
		depRel = SaltFactory.eINSTANCE.createSPointingRelation();
		depRel.setSSource(sTokens.get(7));
		depRel.setSTarget(sTokens.get(9));		
		depRel.createSAnnotation(null, "dependency", "xcomp");
		docGraph.addSRelation(depRel);		
		depLayer.getEdges().add(depRel);		
	}
	
	/**
	 * 
	 * @param sDocument
	 */
	public static void createAnaphoricAnnotations(SDocument sDocument){
		List<SToken> sTokens= Collections.synchronizedList(sDocument.getSDocumentGraph().getSTokens());
		
		//creating a span as placeholder, which contains the tokens for "this" and "example"
		SSpan sSpan= SaltFactory.eINSTANCE.createSSpan();
		//adding the created span to the document-graph
		sDocument.getSDocumentGraph().addSNode(sSpan);
		
		//creating a relation between the span and the tokens
		SSpanningRelation sSpanRel= null;
		sSpanRel= SaltFactory.eINSTANCE.createSSpanningRelation();
		sSpanRel.setSSpan(sSpan);
		sSpanRel.setSToken(sTokens.get(1));
		sDocument.getSDocumentGraph().addSRelation(sSpanRel);
		sSpanRel= SaltFactory.eINSTANCE.createSSpanningRelation();
		sSpanRel.setSSpan(sSpan);
		sSpanRel.setSToken(sTokens.get(2));
		sDocument.getSDocumentGraph().addSRelation(sSpanRel);
		
		//creating a pointing relations
		SPointingRelation sPointingRelation= SaltFactory.eINSTANCE.createSPointingRelation();
		//setting token "it" as source of this relation
		sPointingRelation.setSStructuredSource(sTokens.get(6));
		//setting span "this example" as target of this relation
		sPointingRelation.setSStructuredTarget(sSpan);
		//adding the created relation to the document-graph
		sDocument.getSDocumentGraph().addSRelation(sPointingRelation);
		//adding the type to the relation
		sPointingRelation.addSType("anaphoric");
		//creating an anaphoric relation with the use of pointing relations between the Tokens {"it"} and {"this", "example"}
		
	}
	
	/**
	 * 
	 * @param sDocument
	 */
	public static void createSDocumentStructure(SDocument sDocument){
		
		
		//create SDocumentGraph object and set it to SDocument object
		sDocument.setSDocumentGraph(SaltFactory.eINSTANCE.createSDocumentGraph());
		// create the primary text
		createPrimaryData(sDocument);
		// create tokenization
		createTokens(sDocument);
		// create token Annotations
		createMorphologyAnnotations(sDocument);
		// create spans
		createInformationStructureSpan(sDocument);
		// create span annotations
		createInformationStructureAnnotations(sDocument);
		// create Structures
		createSyntaxStructure(sDocument);
		// create Structure annotations
		createSyntaxAnnotations(sDocument);
		// create pointing relations
		createAnaphoricAnnotations(sDocument);
		
	}
	
	
	
	public static String tmpPathName= "./_tmp/";
	
	
	public static String getHello()
	{
		StringBuffer retVal= new StringBuffer();
		retVal.append("****************************************************************************\n");
		retVal.append("***                        Welcome to SaltSample                         ***\n");
		retVal.append("****************************************************************************\n");
		retVal.append("*** SaltSample is a project to demonstrate the usage of the linguistic   ***\n");
		retVal.append("*** metamodel Salt. SaltSample shall give an overview of the features    ***\n");
		retVal.append("*** of Salt and creates a simple salt project, fills the corpus          ***\n"); 
		retVal.append("*** structure, the document structure, stores and loads the project.     ***\n");
		retVal.append("****************************************************************************\n");
		return(retVal.toString());
	}
	
	public static String getBye()
	{
		StringBuffer retVal= new StringBuffer();
		retVal.append("****************************************************************************\n");
		retVal.append("*** Bye from SaltSample.                                                 ***\n");
		retVal.append("****************************************************************************\n");
		return(retVal.toString());
	}
	
	public SCorpusGraph getCorpus(){
		
		
		return sCorpusGraph;
	}
	
	/**
	 * Retrieves some information about a Salt model and returns them as a String. These information
	 * are formated for printing.
	 * @param saltProject
	 * @return
	 */
	public static String retrieveInformation(SaltProject saltProject)
	{
		StringBuffer retStr= new StringBuffer();
		//print all corpora
		retStr.append("all corpora: "+ saltProject.getSCorpusGraphs().get(0).getSCorpora()+"\n");
		//print all documents
		retStr.append("all documents: "+ saltProject.getSCorpusGraphs().get(0).getSDocuments()+"\n");
		//for all documents print some properties
		for (SDocument sDocument: saltProject.getSCorpusGraphs().get(0).getSDocuments())
		{
			retStr.append("============ "+ sDocument.getSName()+ " ============\n");
			retStr.append("root nodes\t: "+ sDocument.getSDocumentGraph().getSRoots()+"\n");
			
			{//print some information for tokens
				for (SToken sToken: sDocument.getSDocumentGraph().getSTokens())
				{
					retStr.append("\ttoken-id\t\t: "+ sToken.getSId()+"\n");
					retStr.append("\ttoken-name\t\t: "+ sToken.getSName()+"\n");
					//only search for sequences by traversing relations inheriting text
					EList<STYPE_NAME> interestingRelations= new BasicEList<STYPE_NAME>();
					interestingRelations.add(STYPE_NAME.STEXT_OVERLAPPING_RELATION);
					//first SDataSource, because in this example, we use only one SDataSource 
					SDataSourceSequence sequence= sDocument.getSDocumentGraph().getOverlappedDSSequences(sToken, interestingRelations).get(0);
					retStr.append("\toverlapping text\t: "+ ((STextualDS)sequence.getSSequentialDS()).getSText().substring(sequence.getSStart(), sequence.getSEnd())+"\n");
				}
			}//print some information for tokens
			
			retStr.append("----------------------------------------\n");
			
			{//print some information for spans
				for (SSpan sSpan: sDocument.getSDocumentGraph().getSSpans())
				{
					retStr.append("\tspan-id\t\t\t: "+ sSpan.getSId()+"\n");
					retStr.append("\tspan-name\t\t: "+ sSpan.getSName()+"\n");
					//only search for sequences by traversing relations inheriting text
					EList<STYPE_NAME> interestingRelations= new BasicEList<STYPE_NAME>();
					interestingRelations.add(STYPE_NAME.STEXT_OVERLAPPING_RELATION);
					//first SDataSource, because in this example, we use only one SDataSource 
					SDataSourceSequence sequence= sDocument.getSDocumentGraph().getOverlappedDSSequences(sSpan, interestingRelations).get(0);
					retStr.append("\toverlapping text\t: "+ ((STextualDS)sequence.getSSequentialDS()).getSText().substring(sequence.getSStart(), sequence.getSEnd())+"\n");
				}
			}//print some information for spans
			
			retStr.append("----------------------------------------\n");
			
			{//print some information for structs
				for (SStructure sStruct: sDocument.getSDocumentGraph().getSStructures())
				{
					retStr.append("\tstructure-id\t\t: "+ sStruct.getSId()+"\n");
					retStr.append("\tstructure-name\t\t: "+ sStruct.getSName()+"\n");
					//only search for sequences by traversing relations inheriting text
					EList<STYPE_NAME> interestingRelations= new BasicEList<STYPE_NAME>();
					interestingRelations.add(STYPE_NAME.STEXT_OVERLAPPING_RELATION);
					//first SDataSource, because in this example, we use only one SDataSource 
					SDataSourceSequence sequence= sDocument.getSDocumentGraph().getOverlappedDSSequences(sStruct, interestingRelations).get(0);
					retStr.append("\toverlapping text\t: "+ ((STextualDS)sequence.getSSequentialDS()).getSText().substring(sequence.getSStart(), sequence.getSEnd())+"\n");
				}
			}//print some information for structs
			retStr.append("================================================\n");
		}
		return(retStr.toString());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println(getHello());
		try
		{
			//Creating a new salt project, this is the main object and contains all the others. 
			SaltProject saltProject= SaltFactory.eINSTANCE.createSaltProject();

			{//creating a corpus structure for salt project
				System.out.print("creating a corpus structure for salt project...");
				createCorpusStructure(saltProject);
				System.out.println("OK");
			}//creating a corpus structure for salt project

			{//filling all of the documents in the corpus structure with document structure data
				System.out.print("filling all of the documents in the corpus structure with document structure data...");
				//this works, because after createCorpusStructure() was called, only one graph exists in salt project
				SCorpusGraph sCorpusGraph= saltProject.getSCorpusGraphs().get(0);
				for (SDocument sDocument: sCorpusGraph.getSDocuments())
				{//filling all of the documents in the corpus structure with document structure data	
					createSDocumentStructure(sDocument);
				}//filling all of the documents in the corpus structure with document structure data
				System.out.println("OK");
			}//filling all of the documents in the corpus structure with document structure data
			
			File tmpPath= new File(tmpPathName);
			if (!tmpPath.exists())
				tmpPath.mkdirs();
			
			{//store salt project to tmp path
				System.out.print("store salt project to tmp path ('"+tmpPath.getAbsolutePath()+"')...");
				saltProject.saveSaltProject(URI.createFileURI(tmpPath.getAbsolutePath()));
				System.out.println("OK");
			}//store salt project to tmp path
			
			{//load salt project from tmp path
				System.out.print("load salt project from tmp path ('"+tmpPath.getAbsolutePath()+"')...");
				saltProject= SaltFactory.eINSTANCE.createSaltProject();
				saltProject.loadSaltProject(URI.createFileURI(tmpPath.getAbsolutePath()));
				System.out.println("OK");
			}//load salt project from tmp path
			
			{//store salt project in DOT format
				System.out.print("store dot representation of salt project to tmp path ('"+tmpPath.getAbsolutePath()+"\\DOT')...");
				URI uri = URI.createFileURI(tmpPath.getAbsolutePath()+"/DOT");
				saltProject.saveSaltProject_DOT(uri);
				System.out.println("OK");
			}//store salt project in DOT format
			
			{//accessing a Salt model
				System.out.println(retrieveInformation(saltProject));
			}//accessing a Salt model	
			
			System.out.println();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			System.out.println(getBye());
		}
	}
}
