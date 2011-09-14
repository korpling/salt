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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.dot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.GraphTraverser;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.GraphTraverser.GRAPH_TRAVERSE_MODE;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.GraphTraverserObject;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.TraversalObject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltModuleException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.dot.model.DOTEdge;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.dot.model.DOTNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAbstractAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;

/**
 * This class writes the corpus structure in dot format to file.
 * @author Florian Zipser
 *
 */
public class SCorpusGraphDOTWriter implements TraversalObject
{
	private URI outputURI= null;
	public void setOutputURI(URI outputURI) {
		this.outputURI = outputURI;
	}

	public URI getOutputURI() {
		return outputURI;
	}
	
	private SCorpusGraph sCorpusGraph= null;
	public void setSCorpusGraph(SCorpusGraph sCorpusGraph) {
		this.sCorpusGraph = sCorpusGraph;
	}

	public SCorpusGraph getSCorpusGraph() {
		return sCorpusGraph;
	}
	
	private PrintStream currOutputStream= null; 
	
	public void save()
	{
		if (outputURI == null)
			throw new SaltModuleException("Cannot print the given model to dot, because no output file is given.");
		
		File outputFile= new File(this.getOutputURI().toFileString());
		File outputDir= null;
		if (!outputFile.isDirectory())
			outputDir= outputFile.getParentFile();
		else outputDir= outputFile;
		outputDir.mkdirs();
		try {
			this.currOutputStream= new PrintStream(outputFile, "UTF-8");
			}
		catch (FileNotFoundException e) {
			throw new NullPointerException(e.getMessage());
		}
		catch (UnsupportedEncodingException e) 
		{ throw new NullPointerException(e.getMessage()); }
		this.currOutputStream.println("digraph G {");
		this.currOutputStream.println("ordering= out;");
		
		//if documentgraph isn�t  null print it 
		if (this.getSCorpusGraph()!= null)
		{
			GraphTraverser graphTraverser= new GraphTraverser();
			graphTraverser.setGraph(this.getSCorpusGraph());
			GraphTraverserObject travObj= graphTraverser.getTraverserObject(GRAPH_TRAVERSE_MODE.DEPTH_FIRST, this);
			EList<Node> startNodes= graphTraverser.getRoots();
							
			travObj.start(startNodes);
			travObj.waitUntilFinished();
		}
		else 
		{
			this.currOutputStream.println("<empty>[color= red, style = filled]");
		}	
		this.currOutputStream.println("}");
		//close and flusch stream
		this.currOutputStream.flush();
		this.currOutputStream.close();
	}

	/**
	 * Creates all annotation for dotNode comming from SAnnotation. This methode also
	 * includes traversing recursive Annotations (meta annotations).
	 * @param sAnno salt object form which all annotations come
	 * @return returns a label for dot node
	 */
	private String createAnnotations(SAbstractAnnotation sAnno)
	{
		String retStr= null;
		
		//checks if sAnno has metaAnnos
		//TODO Label has to be of superType LabelableElement
//		EList<SAnnotation> metaAnnos= sAnno.getSAnnotations();
//		if (metaAnnos!= null)
//		{	
//			for (SAnnotation metaAnno: metaAnnos)
//			{
//				retStr= this.createAnnotations(metaAnno);
//			}	
//		}
		String anno= null;
		if (sAnno.getSValue()!= null)
			anno= sAnno.getSValue().toString().replace("\"", "\\\"");
		if ((retStr!= null) && (!retStr.equalsIgnoreCase("")))		
				retStr= (sAnno.getQName()+"= "+anno+"\\{"+retStr+"\\}");
		else	retStr= (sAnno.getQName()+"= "+anno);
		
		return(retStr);
	}
	
	/**
	 * Namespace for dot flags
	 */
	protected static final String KW_DOT_NS=	"dot::";
	/**
	 * String to identify a flag in salt elements or relations, which say that the current 
	 * element or relation has already been stored or not
	 */
	protected static final String KW_DOT_STORED=	KW_DOT_NS+"stored";
	
	@Override
	public boolean checkConstraint(GRAPH_TRAVERSE_MODE traversalMode,
			Long traversalId, Edge edge, Node currNode, long order) {
		return true;
	}

	@Override
	public void nodeLeft(GRAPH_TRAVERSE_MODE traversalMode, Long traversalId,
			Node currNode, Edge edge, Node fromNode, long order) 
	{
	}

	@Override
	public void nodeReached(GRAPH_TRAVERSE_MODE traversalMode,
			Long traversalId, Node currNode, Edge edge, Node fromNode,
			long order) 
	{
		SRelation relation= null;
		SNode currSNode= (SNode) currNode;
		SNode fromSNode= null;
		if (edge!= null)
			relation= (SRelation) edge;
		if (fromNode!= null)
			fromSNode= (SNode) fromNode;
		
			
		DOTNode dotNode= new DOTNode();
		dotNode.id= currSNode.getId().toString();
		
		//create all annotations incl. meta annotations
		for (SMetaAnnotation sMetaAnno: currSNode.getSMetaAnnotations())
		{
			dotNode.labels.add(this.createAnnotations(sMetaAnno));
		}
		
		for (SAnnotation sAnno: currSNode.getSAnnotations())
		{
			String anno= sAnno.getValue().toString().replace("\"", "\\\"");
			dotNode.labels.add(sAnno.getQName()+"= "+anno);
		}
		//SCORPUS
		if (currSNode instanceof SCorpus)
		{
			dotNode.color= "gray28";
			dotNode.style= "filled";
			dotNode.shape= "Mrecord";
		}
		//SDOCUMENT
		else if (currSNode instanceof SDocument)
		{
			dotNode.color= "gray"; 
			dotNode.style= "filled";
			dotNode.shape= "Mrecord";
		}
		//if element is already stored don�t store again
		if (currSNode.getSProcessingAnnotation(KW_DOT_STORED)!= null);
		else
		{
			this.currOutputStream.println(dotNode.toString());
			
			//flag the current element
			{
				SProcessingAnnotation spAnno= SaltCommonFactory.eINSTANCE.createSProcessingAnnotation();
				spAnno.setQName(KW_DOT_STORED);
				currSNode.addSProcessingAnnotation(spAnno);
			}
		}
		
		//print relation, if exists
		if (relation!= null)
		{
			DOTEdge dotEdge= new DOTEdge();
			dotEdge.fromId= fromSNode.getId().toString();
			dotEdge.toId= currSNode.getId().toString();	
			{//print edge type, if exists
				EList<String> sTypes= relation.getSTypes(); 
				if (	(sTypes!= null) &&
						(sTypes.size() > 0))
				{
					String dotString= "";
					for (String sType: sTypes)
					{	
						if (dotString.equalsIgnoreCase(""))
							dotString= sType;
						else dotString= dotString + sType+ ", ";
					}
					dotString= "sTypes= ["+ dotString +"]";
					
					dotEdge.labels.add(dotString);
				}
			}
			for (SAnnotation sAnno: relation.getSAnnotations())
			{
				dotEdge.labels.add(sAnno.getQName()+"= "+sAnno.getValue().toString());
			}
			
			
			//SCORPUS_RELATION
			if (relation instanceof SCorpusRelation)
			{
				dotEdge.color= "gray28";
				dotEdge.style= "filled";
			}
			//SCORPDOC_RELATION
			else if (relation instanceof SCorpusDocumentRelation)
			{
				dotEdge.color= "gray";
				dotEdge.style= "filled";
			}
			//if relation is already stored don�t store again
			if (relation.getSProcessingAnnotation(KW_DOT_STORED)!= null);
			else
			{
				this.currOutputStream.println(dotEdge.toString());
				//flag the current element
				{
					SProcessingAnnotation spAnno= SaltCommonFactory.eINSTANCE.createSProcessingAnnotation();
					spAnno.setQName(KW_DOT_STORED);
					relation.addSProcessingAnnotation(spAnno);
				}
			}
		}
	}
}
