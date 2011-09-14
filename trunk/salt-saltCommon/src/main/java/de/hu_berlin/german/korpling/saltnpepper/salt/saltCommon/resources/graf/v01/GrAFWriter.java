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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.graf.v01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SFEATURE_NAMES;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.exceptions.SaltCoreException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;

public class GrAFWriter 
{
// ========================================== start: SDocumentGraph	
	private SDocumentGraph sDocumentGraph= null;
	/**
	 * @param sDocumentGraph the sDocumentGraph to set
	 */
	public void setsDocumentGraph(SDocumentGraph sDocumentGraph) {
		this.sDocumentGraph = sDocumentGraph;
	}

	/**
	 * @return the sDocumentGraph
	 */
	public SDocumentGraph getsDocumentGraph() {
		return sDocumentGraph;
	}
// ========================================== end: SDocumentGraph
	
// ========================================== start: destination
	
	private File destination= null;
	/**
	 * @param destination the destination to set
	 */
	public void setDestination(File destination) {
		this.destination = destination;
	}

	/**
	 * @return the destination
	 */
	public File getDestination() {
		return destination;
	}
// ========================================== end: destination
// ========================================== start: encoding
	private String encoding= "utf-8";
	
	
	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
// ========================================== end: encoding
// ========================================== start: xsdFile
	private String xsdName= null;
	
	
	public String getXSDName() {
		return xsdName;
	}

	public void setXSDName(String xsdName) {
		this.xsdName = xsdName;
	}
// ========================================== end: xsdFile	
// ========================================== start: encoding
	/**
	 * the file to where the primary data shall be stored.
	 */
	private File textFile= null;
	
	/**
	 * Sets a file to where the primary data shall be stored.
	 * @return
	 */
	public File getTextFile() {
		return textFile;
	}

	/**
	 * Returns a file to where the primary data shall be stored.
	 * @param textFile
	 */
	public void setTextFile(File textFile) {
		this.textFile = textFile;
	}
// ========================================== end: encoding	
	
	/**
	 * Level of nesting of xml-output-document
	 */
	private int nestingLevel= 0;
	/**
	 * general StringB uffer for storing the whole document 
	 */
	private StringBuffer outBuffer= null;
	
	/**
	 * StringBuffer just for saving all edges
	 */
	private StringBuffer edgeStringBuffer= null;
	
	/**
	 * StringBuffer just for saving all nodes
	 */
	private StringBuffer nodeStringBuffer= null;
	
	/**
	 * StringBuffer just for saving all spans
	 */
	private StringBuffer spanStringBuffer= null;
	
	/**
	 * Saves the given SDocumentGraph to the given destination.
	 */
	public void save()
	{
		if (this.getsDocumentGraph()== null)
			throw new SaltCoreException("Cannot save an empty SDocumentGraph.");
		if (this.getDestination()== null)
			throw new SaltCoreException("Cannot save SDocumentGraph to empty destination.");
		
		if (this.getsDocumentGraph().getSTextualDSs().size()> 1)
			throw new SaltCoreException("Cannot save SDocumentGraph to GrAF-format, because more than one primary data layer is given.");
		
		this.outBuffer= new StringBuffer();
		saveHeader();
		saveGraph();
		
		{//write buffer to file
			PrintStream fileWriter= null;
			try {
				fileWriter= new PrintStream(new FileOutputStream(this.getDestination()), true, this.encoding);
				fileWriter.print(this.outBuffer.toString());
				fileWriter.flush();
			} catch (UnsupportedEncodingException e) 
			{
				throw new SaltCoreException("Cannot write to resource '"+this.getDestination()+"'. ",e);
			} catch (FileNotFoundException e) 
			{
				throw new SaltCoreException("Cannot write to resource '"+this.getDestination()+"'. ",e);
			}
			finally
			{
				if (fileWriter!= null)
					fileWriter.close();
			}
		}//write buffer to file
		{//write textFile
			STextualDS sTextualDS= this.getsDocumentGraph().getSTextualDSs().get(0);
			PrintStream fileWriter= null;
			try {
				fileWriter= new PrintStream(new FileOutputStream(this.getTextFile()), true, this.encoding);
				fileWriter.print(sTextualDS.getSText());
				fileWriter.flush();
			} catch (UnsupportedEncodingException e) 
			{
				throw new SaltCoreException("Cannot write to resource '"+this.getDestination()+"'. ",e);
			} catch (FileNotFoundException e) 
			{
				throw new SaltCoreException("Cannot write to resource '"+this.getDestination()+"'. ",e);
			}
			finally
			{
				if (fileWriter!= null)
					fileWriter.close();
			}
		}//write textFile
	}
	
	private void saveHeader()
	{
		outBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		outBuffer.append("\n");
	}
	
	private void saveGraph()
	{
		outBuffer.append("<graph");
		outBuffer.append(" id=\""+this.getsDocumentGraph().getSName()+"\"");
		outBuffer.append(" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"");
		outBuffer.append(" xmlns=\"http://www.tc37sc4.org/graf/v1.0.4b\"");
		outBuffer.append(" xmlns:graf=\"http://www.tc37sc4.org/graf/v1.0.4b\"");
		outBuffer.append(" xsi:schemaLocation=\"http://www.tc37sc4.org/graf/v1.0.4b "+this.getXSDName()+"\"");
		outBuffer.append(">");
		outBuffer.append("\n");
		if (	(this.getsDocumentGraph().getSLayers()!= null) &&
				(this.getsDocumentGraph().getSLayers().size()> 0))
		{
			for (SLayer sLayer: this.getsDocumentGraph().getSLayers())
			{//save all nodes and edges belonging to a sLayer
				saveSLayerAsNodeSetNEdgeSet(sLayer);
			}//save all nodes and edges belonging to a sLayer
			{//save all nodes and edges not belonging to a sLayer
				EList<SNode> singleSNodes= new BasicEList<SNode>();
				for (SNode sNode: this.getsDocumentGraph().getSNodes())
				{
					if (sNode.getSLayers()== null)
					{
						singleSNodes.add(sNode);
					}
				}
				this.edgeStringBuffer= new StringBuffer();
				this.nodeStringBuffer= new StringBuffer();
				this.spanStringBuffer= new StringBuffer();
				this.saveSNodesAsNodesNSpans(singleSNodes);
				singleSNodes= null;
				this.outBuffer.append(nodeStringBuffer);
				
				EList<SRelation> singleSRelations= new BasicEList<SRelation>();
				for (SRelation sRelation: this.getsDocumentGraph().getSRelations())
				{
					if (sRelation.getSLayers()== null)
					{
						singleSRelations.add(sRelation);
					}
				}
				this.edgeStringBuffer= new StringBuffer();
				this.nodeStringBuffer= new StringBuffer();
				this.spanStringBuffer= new StringBuffer();
				this.saveSRelationAsNodesNEdges(singleSRelations);
				singleSRelations= null;
				this.outBuffer.append(edgeStringBuffer);
			}//save all nodes and edges not belonging to a sLayer
		}
		outBuffer.append("</graph>");
	}
	
	private void saveSLayerAsNodeSetNEdgeSet(SLayer sLayer)
	{
		if (sLayer!= null)
		{//a layer is given	
			this.spanStringBuffer= new StringBuffer();
			this.nodeStringBuffer= new StringBuffer();
			this.edgeStringBuffer= new StringBuffer();
			
			nestingLevel++;
			
			{//save SNode-objects
				this.saveSNodesAsNodesNSpans(sLayer.getSNodes());
			}//save SNode-objects
			
			{//save SRelation-objects
				this.saveSRelationAsNodesNEdges(sLayer.getSRelations());
			}//save SRelation-objects
			//create nesting for xml
			if (	(this.nodeStringBuffer.length()> 0) ||
					(this.spanStringBuffer.length()> 0))
			{	
				this.printNesting(outBuffer);
				this.outBuffer.append("<nodeSet id=\""+sLayer.getSName()+"\">");
				this.outBuffer.append("\n");
				this.outBuffer.append(spanStringBuffer);
				this.outBuffer.append(nodeStringBuffer);
				this.printNesting(outBuffer);
				this.outBuffer.append("</nodeSet>");
				this.outBuffer.append("\n");
				this.nestingLevel--;
			}
			if (this.edgeStringBuffer.length()> 0)
			{	
				this.nestingLevel++;
				//create nesting for xml
				this.printNesting(outBuffer);
				this.outBuffer.append("<edgeSet id=\""+sLayer.getSName()+"\">");
				this.outBuffer.append("\n");
				this.outBuffer.append(edgeStringBuffer);
				this.outBuffer.append("</edgeSet>");
				this.outBuffer.append("\n");
				this.nestingLevel--;
			}
		}//a layer is given
	}
	
	/**
	 * Saves a list of SNode-objects.
	 * Used buffers: spanStringBuffer, edgeStringBuffer
	 * @param sNodes
	 */
	private void saveSNodesAsNodesNSpans(EList<SNode> sNodes)
	{
		for (SNode sNode: sNodes)
		{
			if (sNode instanceof SToken)
			{//save SToken-object
				STextualRelation sTextRel= null;
				for (Edge edge: this.getsDocumentGraph().getOutEdges(sNode.getSId()))
				{
					if (edge instanceof STextualRelation)
					{
						sTextRel= (STextualRelation) edge;
						break;
					}
				}
				if (sTextRel== null)
					throw new SaltCoreException("Cannot export SDocument, because a STextualRelation-object is empty.");
				this.saveSTokenAsSpan((SToken) sNode, sTextRel);
				this.saveSNodeAsNode(sNode);
			}//save SToken-object
			else if (	(sNode instanceof SSpan) ||
						(sNode instanceof SStructure))
			{//save SSpan-object or SStructure-object
				this.saveSNodeAsNode(sNode);
			}//save SSpan-object or SStructure-object
		}
	}
	
	/**
	 * Saves a list of SRelation-objects
	 * @param srelations
	 */
	private void saveSRelationAsNodesNEdges(EList<SRelation> sRelations)
	{
		for (SRelation sRelation: sRelations)
		{
			if (	(sRelation instanceof SSpanningRelation) ||
					(sRelation instanceof SDominanceRelation) ||
					(sRelation instanceof SPointingRelation))
			{//save SSpanRelation-object, SDominanceRelation-object or SPointingRelation-object
				this.saveSRelationAsNode(sRelation);
			}//save SSpanRelation-object, SDominanceRelation-object or SPointingRelation-object
		}
//		this.outBuffer.append(this.edgeStringBuffer.toString());
	}
	
	/**
	 * Number of spans.
	 */
	private Long numOfSpans= 0l;
	
	/**
	 * Writes the data of an SToken-object and its STextualRelation-object as a span to
	 * the String-buffer.
	 * Used buffers: spanStringBuffer, edgeStringBuffer
	 * @param sToken
	 * @param sTextRel
	 */
	private void saveSTokenAsSpan(SToken sToken, STextualRelation sTextRel)
	{
		nestingLevel++;
		
		if (sTextRel== null)
			throw new SaltCoreException("Cannot export document, because a STextualRelation is empty.");
		
		StringBuffer spanId= new StringBuffer();
		spanId.append("span_");
		spanId.append(numOfSpans);
		
		StringBuffer spanRelId= new StringBuffer();
		spanRelId.append("spanRel_");
		spanRelId.append(numOfSpans);
		
		//create nesting
		{//save SToken-object as node to StringBuffer
			this.printNesting(this.spanStringBuffer);
			this.spanStringBuffer.append("<span");
			this.spanStringBuffer.append(" id=\""+spanId.toString()+"\"");
			this.numOfSpans++;
			this.spanStringBuffer.append(" start=\""+sTextRel.getSStart()+"\"");
			this.spanStringBuffer.append(" end=\""+sTextRel.getSEnd()+"\"");
			this.spanStringBuffer.append("/>");
			this.spanStringBuffer.append("\n");
		}//save SToken-object as node to StringBuffer
		
		{//print Edge to StringBuffer
			this.printNesting(edgeStringBuffer);
			this.edgeStringBuffer.append("<edge id=\""+spanRelId.toString()+"\"");
			this.edgeStringBuffer.append(" from=\""+sToken.getSName()+"\"");
			this.edgeStringBuffer.append(" to=\""+spanId.toString()+"\"");
			this.edgeStringBuffer.append("/>");
			this.edgeStringBuffer.append("\n");
		}//print Edge to StringBuffer
		nestingLevel--;
	}
	
	/**
	 * Saves the given SNode.
	 * Used buffers: nodeStringBuffer
	 * @param sNode node to be saved
	 */
	private void saveSNodeAsNode(SNode sNode)
	{
		nestingLevel++;
		//create nesting
		this.printNesting(this.nodeStringBuffer);
		String type= null;
		if (sNode instanceof SToken)
			type= STYPE_NAME.STOKEN.toString();
		else if (sNode instanceof SSpan)
			type= STYPE_NAME.SSPAN.toString();
		else if (sNode instanceof SStructure)
			type= STYPE_NAME.SSTRUCTURE.toString();
		this.nodeStringBuffer.append("<node id=\""+sNode.getSName()+"\"");
		this.nodeStringBuffer.append(" type=\""+type+"\"");
		if (	(sNode.getSAnnotations()== null) ||
				(sNode.getSAnnotations().size()== 0))
		{//save unary tag
			this.nodeStringBuffer.append("/>");
			this.nodeStringBuffer.append("\n");
		}//save unary tag
		else
		{//binary tag
			this.nodeStringBuffer.append(">");
			this.nodeStringBuffer.append("\n");
			this.saveFS(sNode);
			//create nesting
			this.printNesting(this.nodeStringBuffer);
			
			this.nodeStringBuffer.append("</node>");
			this.nodeStringBuffer.append("\n");
		}//binary tag
		nestingLevel--;
	}
	
	/**
	 * Writes the given sRelation as node-element and corresponding edge-elements.
	 * Used buffers: nodeStringBuffer, edgeStringBuffer
	 * @param sRelation sRelation-object to write
	 */
	private void saveSRelationAsNode(SRelation sRelation)
	{
		nestingLevel++;
		{//print SRelation as Node to StringBuffer
			//create nesting for xml
			this.printNesting(this.nodeStringBuffer);
			this.nodeStringBuffer.append("<node id=\""+sRelation.getSName()+"\"");
			String type= null;
			if (sRelation instanceof STextualRelation)
				type= STYPE_NAME.STEXTUAL_RELATION.toString();
			else if (sRelation instanceof SSpanningRelation)
				type= STYPE_NAME.SSPANNING_RELATION.toString();
			else if (sRelation instanceof SDominanceRelation)
				type= STYPE_NAME.SDOMINANCE_RELATION.toString();
			else if (sRelation instanceof SPointingRelation)
				type= STYPE_NAME.SPOINTING_RELATION.toString();
			this.nodeStringBuffer.append(" type=\""+type+"\"");
			if (	(sRelation.getSAnnotations()== null) ||
					(sRelation.getSAnnotations().size()== 0))
			{//save unary tag
				this.nodeStringBuffer.append("/>");
				this.nodeStringBuffer.append("\n");
			}//save unary tag
			else
			{//binary tag
				this.nodeStringBuffer.append(">");
				this.nodeStringBuffer.append("\n");
				nestingLevel++;
				this.saveFS(sRelation);
				nestingLevel--;
				//create nesting for xml
				this.printNesting(this.nodeStringBuffer);
				this.nodeStringBuffer.append("</node>");
				this.nodeStringBuffer.append("\n");
			}//binary tag
		}//print SRelation as Node to StringBuffer
		{//print SRelation as Edge to StringBuffer
			{//edge for SRelation.source-> SRelation 
				this.printNesting(this.edgeStringBuffer);
				this.edgeStringBuffer.append("<edge id=\""+sRelation.getSName()+"_1"+"\"");
				this.edgeStringBuffer.append(" from=\""+sRelation.getSSource().getSName()+"\"");
				this.edgeStringBuffer.append(" to=\""+sRelation.getSName()+"\"");
				this.edgeStringBuffer.append("/>");
				this.edgeStringBuffer.append("\n");
			}//edge for SRelation.source-> SRelation
			{//edge for SRelation -> SRelation.target 
				this.printNesting(this.edgeStringBuffer);
				this.edgeStringBuffer.append("<edge id=\""+sRelation.getSName()+"_2"+"\"");
				this.edgeStringBuffer.append(" from=\""+sRelation.getSName()+"\"");
				this.edgeStringBuffer.append(" to=\""+sRelation.getSTarget().getSName()+"\"");
				this.edgeStringBuffer.append("/>");
				this.edgeStringBuffer.append("\n");
			}//edge for SRelation -> SRelation.target
		}//print SRelation as Edge to StringBuffer
		nestingLevel--;
	}
	
	/**
	 * Saves all SAnnotations of the given element as feature structures. 
	 * @param sAnnotatable
	 */
	private void saveFS(SAnnotatableElement sAnnotatable)
	{
		if (	(sAnnotatable.getSAnnotations()!= null) &&
				(sAnnotatable.getSAnnotations().size()> 0))
		{	
			nestingLevel++;
			this.printNesting(this.nodeStringBuffer);
			this.nodeStringBuffer.append("<fs>");
			this.nodeStringBuffer.append("\n");
			nestingLevel++;
			{//if annotatable is SRelation also print SType as Annotation
				if (sAnnotatable instanceof SRelation)
				{
					if (	(((SRelation) sAnnotatable).getSTypes()!= null) &&
							(((SRelation) sAnnotatable).getSTypes().size()!= 0))
					{
						StringBuffer sTypes= new StringBuffer();
						for (String sType: ((SRelation) sAnnotatable).getSTypes())
						{
							if (sTypes.length()== 0)
								sTypes.append(sType);
							else
							{
								sTypes.append(";");
								sTypes.append(sType);
							}
						}
						
						this.printNesting(this.nodeStringBuffer);
						this.nodeStringBuffer.append("<f");
						this.nodeStringBuffer.append(" n=\""+SFEATURE_NAMES.STYPE_SRELATION.toString()+"\"");
						this.nodeStringBuffer.append(" v=\""+this.conformingToXML(((SRelation) sAnnotatable).getSTypes().toString())+"\"/>");
						this.nodeStringBuffer.append("\n");
					}
				}
			}//if annotatable is SRelation also print SType as Annotation
			
			for (SAnnotation sAnnotation:sAnnotatable.getSAnnotations())
			{
				//create nesting for xml
				this.printNesting(this.nodeStringBuffer);
				this.nodeStringBuffer.append("<f");
				this.nodeStringBuffer.append(" n=\""+this.conformingToXML(sAnnotation.getSName())+"\"");
				this.nodeStringBuffer.append(" v=\""+this.conformingToXML(sAnnotation.getSValueSTEXT())+"\"/>");
				this.nodeStringBuffer.append("\n");
			}
			nestingLevel--;
			//create nesting for xml
			this.printNesting(this.nodeStringBuffer);
			this.nodeStringBuffer.append("</fs>");
			this.nodeStringBuffer.append("\n");
			nestingLevel--;
		}
	}
	
	/**
	 * Prints the nesting for xml-output. This is done by appending tabs to the output-String-buffer.
	 */
	private void printNesting(StringBuffer buffer)
	{
		for (int i= 0; i< nestingLevel; i++)
			buffer.append("\t");
	}
	
	private static final String KW_AMP= "&";
	private static final String KW_AMP_XML= "&amp;";
	private static final String KW_APOS="'";
	private static final String KW_APOS_XML= "&apos;";
	private static final String KW_LT="<";
	private static final String KW_LT_XML= "&lt;";
	private static final String KW_GT=">";
	private static final String KW_GT_XML= "&gt;";
	private static final String KW_QUOT="\"";
	private static final String KW_QUOT_XML= "&quot;";
	
	private static final String KW_AE_BIG="�";
	private static final String KW_AE_BIG_XML= "&#196;";
	private static final String KW_OE_BIG="�";
	private static final String KW_OE_BIG_XML= "&#214;";
	private static final String KW_UE_BIG="�";
	private static final String KW_UE_BIG_XML= "&#220;";
	private static final String KW_AE="�";
	private static final String KW_AE_XML= "&#228;";
	private static final String KW_OE="�";
	private static final String KW_OE_XML= "&#246;";
	private static final String KW_UE="�";
	private static final String KW_UE_XML= "&#252;";
	private static final String KW_SS="�";
	private static final String KW_SS_XML= "&#223;";
	
	private String conformingToXML(String text)
	{
		StringBuffer retStr= new StringBuffer();
		retStr.append(text);
		if (	(text.contains("<")) ||
				(text.contains(">")))
		{
			retStr.insert(0, "<![CDATA[");
			retStr.append("]]");
		}
		Integer index= null;
		if ((index= retStr.indexOf(KW_AMP))!= -1)
			retStr= retStr.replace(index, index + KW_AMP.length(), KW_AMP_XML);
		if ((index= retStr.indexOf(KW_APOS))!= -1)
			retStr= retStr.replace(index, index + KW_APOS.length(), KW_APOS_XML);
		if ((index= retStr.indexOf(KW_LT))!= -1)
			retStr= retStr.replace(index, index + KW_LT.length(), KW_LT_XML);
		if ((index= retStr.indexOf(KW_GT))!= -1)
			retStr= retStr.replace(index, index + KW_GT.length(), KW_GT_XML);
		if ((index= retStr.indexOf(KW_QUOT))!= -1)
			retStr= retStr.replace(index, index + KW_QUOT.length(), KW_QUOT_XML);
	
		if ((index= retStr.indexOf(KW_AE_BIG))!= -1)
			retStr= retStr.replace(index, index + KW_AE_BIG.length(), KW_AE_BIG_XML);
		if ((index= retStr.indexOf(KW_OE_BIG))!= -1)
			retStr= retStr.replace(index, index + KW_OE_BIG.length(), KW_OE_BIG_XML);
		if ((index= retStr.indexOf(KW_UE_BIG))!= -1)
			retStr= retStr.replace(index, index + KW_UE_BIG.length(), KW_UE_BIG_XML);
		if ((index= retStr.indexOf(KW_AE))!= -1)
			retStr= retStr.replace(index, index + KW_AE.length(), KW_AE_XML);
		if ((index= retStr.indexOf(KW_OE))!= -1)
			retStr= retStr.replace(index, index + KW_OE.length(), KW_OE_XML);
		if ((index= retStr.indexOf(KW_UE))!= -1)
			retStr= retStr.replace(index, index + KW_UE.length(), KW_UE_XML);
		if ((index= retStr.indexOf(KW_SS))!= -1)
			retStr= retStr.replace(index, index + KW_SS.length(), KW_SS_XML);
		
		return(retStr.toString());
	}
}
