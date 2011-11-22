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

import org.eclipse.emf.common.util.URI;
import org.xml.sax.SAXException;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SLemmaAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SPOSAnnotation;


/**
 * This class shows the usage of the linguistic meta model Salt. 
 * Therefore we create a linguistic corpus with direct use of the Salt object model. We here show how to store this model to disk and
 * how to load a model from disk into main memory. 
 * 
 * The method creatingSCorpusStructure() shows how to create a corpus structure.
 * The method creatingSDocumentStructure() shows how to create a document structure.
 * 
 * @author Florian Zipser
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
	public static String PRIMARY_TEXT= "Is this example more complicated than it appears to be?";
	/**
	 * The name of the morphologic layer containing the tokens. 
	 */
	public static String MORPHOLOGY_LAYER="morphology";
	
	/**
	 * Creates a {@link STextualDS} object containing the primary text {@link SaltSample#PRIMARY_TEXT} and adds the object
	 * to the {@link SDocumentGraph} being contained by the given {@link SDocument} object.
	 * 
	 * @param sDocument the document, to which the created {@link STextualDS} object will be added
	 */
	public static void createPrimaryData(SDocument sDocument){
		if (sDocument== null)
			throw new SaltSampleException("Cannot create example, because the given sDocument is empty.");
		if (sDocument.getSDocumentGraph()== null)
			throw new SaltSampleException("Cannot create example, because the given sDocument does not contain an SDocumentGraph.");
		STextualDS sTextualDS = null;
		{//creating the primary text
			sTextualDS= SaltFactory.eINSTANCE.createSTextualDS();
			sTextualDS.setSText(PRIMARY_TEXT);
			//sTextualDS.setSText("This is a sample text, which is very short.");
			//adding the text to the document-graph
			sDocument.getSDocumentGraph().addSNode(sTextualDS);
		}//creating the primary text
	}
	
	/**
	 * Creates a set of {@link SToken} objects tokenizing the primary text {@link SaltSample#PRIMARY_TEXT} in to the 
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
		STextualDS sTextualDS = sDocument.getSDocumentGraph().getSTextualDSs().get(0);
		//as a means to group elements, layers (SLayer) can be used. here, a layer
		//named "morphology" is created and the tokens will be added to it
		SLayer morphLayer = SaltFactory.eINSTANCE.createSLayer();
		morphLayer.setSName(MORPHOLOGY_LAYER);
		sDocument.getSDocumentGraph().addSLayer(morphLayer);

		createToken(0,2,sTextualDS,sDocument,morphLayer);	
		//creating tokenization for the token 'this' and adding it to the morphology layer
		createToken(3,7,sTextualDS,sDocument,morphLayer);	
		//creating tokenization for the token 'example' and adding it to the morphology layer
		createToken(8,15,sTextualDS,sDocument,morphLayer);		
		//creating tokenization for the token 'more' and adding it to the morphology layer
		createToken(16,20,sTextualDS,sDocument,morphLayer);		
		//creating tokenization for the token 'complicated' and adding it to the morphology layer
		createToken(21,32,sTextualDS,sDocument,morphLayer);
		//creating tokenization for the token 'than' and adding it to the morphology layer
		createToken(33,37,sTextualDS,sDocument,morphLayer);		
		//creating tokenization for the token 'it' and adding it to the morphology layer
		createToken(38,40,sTextualDS,sDocument,morphLayer);	
		//creating tokenization for the token 'appears' and adding it to the morphology layer
		createToken(41,48,sTextualDS,sDocument,morphLayer);
		//creating tokenization for the token 'to' and adding it to the morphology layer
		createToken(49,51,sTextualDS,sDocument,morphLayer);
		//creating tokenization for the token 'be' and adding it to the morphology layer
		createToken(52,54,sTextualDS,sDocument,morphLayer);
	}
	
	public static void createToken(int start, int end, STextualDS sTextualDS, SDocument sDocument, SLayer layer){
		SToken sToken= SaltFactory.eINSTANCE.createSToken();
		sDocument.getSDocumentGraph().addSNode(sToken);
		layer.getSNodes().add(sToken);
		STextualRelation sTextRel= SaltFactory.eINSTANCE.createSTextualRelation();
		sTextRel.setSToken(sToken);
		sTextRel.setSTextualDS(sTextualDS);
		sTextRel.setSStart(start);
		sTextRel.setSEnd(end);
		sDocument.getSDocumentGraph().addSRelation(sTextRel);
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
	
	/**
	 * Creates {@link SSpan} object above the tokenization.
	 * @param sDocument
	 */
	public static void createInformationStructureSpan(SDocument sDocument){
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
	 * 
	 * @param sDocument
	 */
	public static void createSyntaxStructure(SDocument sDocument){
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
