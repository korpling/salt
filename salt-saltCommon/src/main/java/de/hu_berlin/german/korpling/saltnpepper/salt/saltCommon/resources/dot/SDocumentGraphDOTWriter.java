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

import org.eclipse.emf.common.util.BasicEList;
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
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltResourceException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.modules.SDocumentStructureAccessor;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.dot.model.DOTEdge;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.dot.model.DOTNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeline;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimelineRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;

public class SDocumentGraphDOTWriter implements TraversalObject
{
	private URI outputURI= null;
	public void setOutputURI(URI outputURI) {
		this.outputURI = outputURI;
	}

	public URI getOutputURI() {
		return outputURI;
	}
	
	private SDocumentGraph sDocumentGraph= null;
	public void setSDocumentGraph(SDocumentGraph sDocumentGraph) {
		this.sDocumentGraph = sDocumentGraph;
	}

	public SDocumentGraph getSDocumentGraph() {
		return sDocumentGraph;
	}
	
	private PrintStream currOutputStream= null; 
	
	/**
	 * This list contains all nodes, which are visited.
	 */
	private EList<Node> visitedNodes= null;
	
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
		
		//if documentgraph isn't  null print it 
		if (this.getSDocumentGraph()!= null)
		{
			GraphTraverser graphTraverser= new GraphTraverser();
			graphTraverser.setGraph(this.getSDocumentGraph());
			GraphTraverserObject travObj= graphTraverser.getTraverserObject(GRAPH_TRAVERSE_MODE.DEPTH_FIRST, this);
			this.visitedNodes= new BasicEList<Node>(); 
			EList<Node> startNodes= graphTraverser.getRoots();
			if (startNodes== null)
			{
				startNodes= new BasicEList<Node>();
				if (	(this.getSDocumentGraph().getSTokens()!= null) &&
						(this.getSDocumentGraph().getSTokens().size()>0))
						startNodes.add(this.getSDocumentGraph().getSTokens().get(0));
			}
			if (	(startNodes!= null)&&
					(startNodes.size() >0))
				travObj.start(startNodes);
			travObj.waitUntilFinished();
			{//some nodes have no roots for example if they are part of a cycle, they have to be still stored
				if (visitedNodes.size() != this.getSDocumentGraph().getSNodes().size())
				{//if both lists doesn't have the same size create difference
					//contains all nodes, which wasn' t visited while first traversal
					EList<Node> forgottenNodes= new BasicEList<Node>();
					for (Node node: this.getSDocumentGraph().getSNodes())
					{
						if (!visitedNodes.contains(node))
							forgottenNodes.add(node);
					}
					if (forgottenNodes.size()== 0)
						throw new SaltResourceException("There are some nodes, which hasn' t been printed because of an unknown reason.");
					else
					{//traverse again
						graphTraverser= new GraphTraverser();
						graphTraverser.setGraph(this.getSDocumentGraph());
						travObj= graphTraverser.getTraverserObject(GRAPH_TRAVERSE_MODE.DEPTH_FIRST, this);
						travObj.start(forgottenNodes);
						travObj.waitUntilFinished();
					}//traverse again
				}//if both lists doesn't have the same size create difference
			}//some nodes have no roots for example if they are part of a cycle, they have to be still stored
			//callback to traverse graph 
//			this.getSDocumentGraph().traverseSGraph(GRAPH_TRAVERSE_MODE.DEPTH_FIRST, this.getSDocumentGraph().getSRoots(), this, null);
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
	private String createAnnotations(SAnnotation sAnno)
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
		{
			anno= sAnno.getSValue().toString().replace("\"", "\\\"");
			anno= anno.replace("\n", "\\n");
			anno= anno.replace("\r", "\\r");
		}
		System.out.println("-----> anno: "+ anno);
		
		
		if ((retStr!= null) && (!retStr.isEmpty()))		
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
		return(true);
	}

	@Override
	public void nodeLeft(GRAPH_TRAVERSE_MODE traversalMode, Long traversalId,
			Node currNode, Edge edge, Node fromNode, long order) {
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
		for (SAnnotation sAnno: currSNode.getSAnnotations())
		{
			dotNode.labels.add(this.createAnnotations(sAnno));
		}
		//------------------------------- Elements of a document
		//STEXTUAL_DATASOURCE
		if (currSNode instanceof STextualDS)
		{
			dotNode.color= "yellow"; 
			dotNode.style= "filled";
			dotNode.shape= "Mrecord";
			String text= ((STextualDS)currSNode).getSText();
			if (text!= null)
			{//preparing text for dot
				//replace " with \"
				text= text.replace("\"", "\\\"");
				//replace " with \n"
				text= text.replace("\n", "");
				text= text.replace("\r", "");
			}//preparing text for dot
			dotNode.labels.add("text= "+ text);
		}
		//STIMELINE
		else if (currSNode instanceof STimeline)
		{
			dotNode.color= "gray"; 
			dotNode.style= "filled";
			dotNode.shape= "Mrecord";
			dotNode.labels.add("time= "+ ((STimeline)currSNode).getSPointsOfTime());
		}
		//STOKEN
		else if (currSNode instanceof SToken)
		{
			dotNode.color= "turquoise"; 
			dotNode.style= "filled";
			dotNode.shape= "Mrecord";
			//dotNode.labels.add("textPos= ("+currSNode.getSFeature("left").getValue()+".."+")");
//			dotNode.labels.add("textPos= ("+this.accessor.getSLeftPos(currSNode)+".."+this.accessor.getSRightPos(currSNode)+")");
			SDocumentStructureAccessor sdAccessor= new SDocumentStructureAccessor();
			sdAccessor.setSDocumentGraph(this.getSDocumentGraph());
//			String text= sdAccessor.getSOverlappedText(currSNode).replace("\"", "\\\"");;
//			String text=this.accessor.getOverlapedText(currSNode).replace("\"", "\\\"");
//			dotNode.labels.add("text= "+ text);
		}
		//SSpan
		else if (currSNode instanceof SSpan)
		{
			dotNode.color= "dodgerblue3"; 
			dotNode.style= "filled";
			dotNode.shape= "Mrecord";
		}
		//SSTRUCTURE
		else if (currSNode instanceof SStructure)
		{
			dotNode.color= "seagreen"; 
			dotNode.style= "filled";
			dotNode.shape= "Mrecord";
		}
		else 
		{
			dotNode.color= "red"; 
			dotNode.shape= "Mrecord";
			dotNode.style= "filled";
		}		
		//if element is already stored don't store again
		if (currSNode.getSProcessingAnnotation(KW_DOT_STORED)!= null);
		else
		{
			this.visitedNodes.add(currNode);
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
						if (dotString.isEmpty())
							dotString= sType;
						else dotString= dotString + sType+ ", ";
					}
					dotString= "sTypes= ["+ dotString +"]";
					
					dotEdge.labels.add(dotString);
				}
			}
			for (SAnnotation sAnno: relation.getSAnnotations())
			{
				dotEdge.labels.add(sAnno.getQName()+"= "+sAnno.getSValueSTEXT());
			}
						
			//STEXTUAL_RELATION
			if (relation instanceof STextualRelation)
			{
				dotEdge.color= "yellow";
				dotEdge.style= "filled";
			}
			//STimelineRelation
			else if (relation instanceof STimelineRelation)
			{
				dotEdge.color= "gray";
				dotEdge.style= "filled";
			}
			//SPANNING_RELATION
			else if (relation instanceof SSpanningRelation)
			{
				dotEdge.color= "dodgerblue3";
				dotEdge.style= "filled";
			}
			//SDOMINANCE_RELATION
			else if (relation instanceof SDominanceRelation)
			{
				dotEdge.color= "seagreen";
				dotEdge.style= "filled";
			}
			//SPOINTING_RELATION
			else if (relation instanceof SPointingRelation)
			{
				dotEdge.color= "blue";
				dotEdge.style= "filled";
			}
			//if relation is already stored don't store again
			if (relation.getSProcessingAnnotation(KW_DOT_STORED)!= null);
			else
			{
				this.currOutputStream.println(dotEdge.toString());
//				this.currOutputStream.println("<" + fromElement.getId() + "> -> <" + currSNode.getId() +">");
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
