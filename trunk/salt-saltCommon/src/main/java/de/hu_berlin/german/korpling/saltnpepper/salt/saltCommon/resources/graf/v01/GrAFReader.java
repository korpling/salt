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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DefaultHandler2;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SFEATURE_NAMES;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;

public class GrAFReader extends DefaultHandler2
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
	
// ========================================== start: fileResource
	/**
	 * the resource, from where the data shall be loaded.
	 */
	private File fileResource= null;
	/**
	 * Sets the resource, from where the data shall be loaded.
	 * @param destination the destination to set
	 */
	public void setFileResource(File destination) {
		this.fileResource = destination;
	}

	/**
	 * Returns the resource, from where the data shall be loaded.
	 * @return the destination
	 */
	public File getFileResource() {
		return fileResource;
	}
// ========================================== end: fileResource

	/**
	 * The SAXParserFactory
	 */
	private static SAXParserFactory factory= SAXParserFactory.newInstance();
	
	/**
	 * Initializes this object to load GrAF-Data.
	 */
	private void init()
	{
		this.currentSLayer= null;
		this.currentSRelation= null;
		this.currentSNode= null;
		
		this.nodeId2SRelation= new Hashtable<String, SRelation>();
		this.nodeId2SNode= new Hashtable<String, SNode>();
	}
	
	/**
	 * Loads data from given GrAF-file into the given SDocument-Graph-object
	 */
	public void load()
	{
		if (this.getFileResource()== null)
			throw new SaltException("Cannot load data, because no resource is given.");
		if (this.getsDocumentGraph()== null)
			throw new SaltException("Cannot load data, because no SDocumentGraph is given.");
		
		this.init();
		{//read text file
			String[] parts= this.getFileResource().getAbsolutePath().split("[.]");
			String ending= "."+parts[parts.length-1];
			File textFile= new File(this.getFileResource().getAbsolutePath().replace(ending, ".txt"));
			if (!textFile.exists())
				throw new SaltException("Cannot import the document '"+this.getFileResource().getAbsolutePath()+"', because its corresponding text-file '"+textFile.getAbsolutePath()+"' does not exist.");
			StringBuffer sText= new StringBuffer();
			try 
			{
				BufferedReader inReader = new BufferedReader(new InputStreamReader(new FileInputStream(textFile), "UTF8"));
				String input = "";
				while((input = inReader.readLine()) != null) 
				{
					sText.append(input);
				}
				inReader.close();
			} catch (IOException e) {
				throw new SaltException("Cannot import the document '"+this.getFileResource().getAbsolutePath()+"', because its corresponding text-file '"+textFile.getAbsolutePath()+"' does not exist.");
			}
			STextualDS sTextualDS= SaltCommonFactory.eINSTANCE.createSTextualDS();
			sTextualDS.setSName(textFile.getName());
			sTextualDS.setSText(sText.toString());
			this.getsDocumentGraph().addSNode(sTextualDS);
			
		}//read text file
		
		{//SAX-Parser
			SAXParser parser;
	        XMLReader xmlReader;
	        try {
	        	parser= factory.newSAXParser();
			    xmlReader= parser.getXMLReader();
		        //create and set content handler
		        xmlReader.setContentHandler(this);
		        
		        //setting LexicalHandler to read DTD
		        xmlReader.setProperty("http://xml.org/sax/properties/lexical-handler", this);
		        xmlReader.setContentHandler(this);
		        
		        xmlReader.parse(this.getFileResource().getAbsolutePath());
		        
		    } catch (ParserConfigurationException e) {
	        	throw new SaltException("Cannot load exmaralda from resource '"+this.getFileResource().getAbsolutePath()+"'.", e);
	        } catch (SAXException e) {
	        	throw new SaltException("Cannot load exmaralda from resource '"+this.getFileResource().getAbsolutePath()+"'.", e);
			} catch (IOException e) {
				throw new SaltException("Cannot load exmaralda from resource '"+this.getFileResource().getAbsolutePath()+"'.", e);
			}
		}//SAX-Parser
	}

// ========================================== start: SAX-stuff	
	/**
	 * XML-element nodeSet
	 */
	private final static String KW_NODESET="nodeSet";
	/**
	 * XML-element span
	 */
	private final static String KW_SPAN="span";
	/**
	 * XML-element node
	 */
	private final static String KW_EDGE="edge";
	/**
	 * XML-element edge
	 */
	private final static String KW_NODE="node";
	/**
	 * XML-element featureStructure
	 */
	private final static String KW_FEATURE_STRUCTURE="fs";
	/**
	 * XML-element feature
	 */
	private final static String KW_FEATURE="f";
	
	/**
	 * Stores the current layer
	 */
	private SLayer currentSLayer= null;
	/**
	 * Stores the current node, for features
	 */
	private SNode currentSNode= null;
	/**
	 * Stores the current SRelation for features
	 */
	private SRelation currentSRelation= null;
	
	/**
	 * This table stores the textualRelation corresonding to its span-id.
	 */
	private Hashtable<String, SRelation> nodeId2SRelation= null;
	
	/**
	 * This table stores the textualRelation corresonding to its span-id.
	 */
	private Hashtable<String, SNode> nodeId2SNode= null;
	/**
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(	String uri,
            					String localName,
            					String qName,
            					Attributes attributes) throws SAXException
    {
		if (qName.equalsIgnoreCase(KW_NODESET))
		{//xml-element is nodeSet
			SLayer sLayer= SaltCommonFactory.eINSTANCE.createSLayer();
			sLayer.setSName(attributes.getValue("id"));
			this.getsDocumentGraph().addSLayer(sLayer);
			this.currentSLayer= sLayer;
		}//xml-element is nodeSet
		else if (qName.equalsIgnoreCase(KW_SPAN))
		{//xml-element is span
			Integer start= null;
			Integer end= null;
			try {
				start= new Integer(attributes.getValue("start"));
				end= new Integer(attributes.getValue("end"));
			} catch (NumberFormatException e) 
			{
				throw new SaltException("Cannot read given GrAF-file '"+this.getFileResource().getAbsolutePath()+"', because the start and end position of span is not convertable to a number.", e);
			}
			STextualRelation sTextRel= null;
			{//create STextualRelation
				sTextRel= SaltCommonFactory.eINSTANCE.createSTextualRelation();
				sTextRel.setSStart(start);
				sTextRel.setSStart(end);
				sTextRel.setSTextualDS(this.getsDocumentGraph().getSTextualDSs().get(0));
				this.getsDocumentGraph().addSRelation(sTextRel);
				this.nodeId2SRelation.put(attributes.getValue("id"), sTextRel);
			}//create STextualRelation
			{//adding STextualRelation to SLayer if one exists
				if (this.currentSLayer!= null)
				{
					this.currentSLayer.getSRelations().add(sTextRel);
				}
			}//adding STextualRelation to SLayer if one exists
		}//xml-element is span
		else if (qName.equalsIgnoreCase(KW_NODE))
		{//xml-element is node
			SNode sNode= null;
			{//xml-element node will be mapped to SNode
				if (attributes.getValue("type").equalsIgnoreCase(STYPE_NAME.STOKEN.toString()))
				{//xml-element has to be mapped to a SToken
					sNode= SaltCommonFactory.eINSTANCE.createSToken();
				}//xml-element has to be mapped to a SToken
				else if (attributes.getValue("type").equalsIgnoreCase(STYPE_NAME.SSPAN.toString()))
				{//xml-element has to be mapped to a SSpan
					sNode= SaltCommonFactory.eINSTANCE.createSSpan();
				}//xml-element node will be mapped to SSpan
				else if (attributes.getValue("type").equalsIgnoreCase(STYPE_NAME.SSTRUCTURE.toString()))
				{//xml-element has to be mapped to a SStructure
					sNode= SaltCommonFactory.eINSTANCE.createSStructure();
				}//xml-element has to be mapped to a SStructure
				if (sNode!= null)
				{//to some general things for every node
					sNode.setSName(attributes.getValue("id"));
					if (this.currentSLayer!= null)
						this.currentSLayer.getSNodes().add(sNode);
					this.currentSNode= sNode;
					this.getsDocumentGraph().addSNode(sNode);
					this.nodeId2SNode.put(attributes.getValue("id"), sNode);
				}//to some general things for every node
			}//xml-element node will be mapped to SNode
			{//xml-element node will be mapped to SRelation
				if (sNode== null)
				{	
					SRelation sRelation= null;
					if (attributes.getValue("type").equalsIgnoreCase(STYPE_NAME.SSPANNING_RELATION.toString()))
					{//xml-element has to be mapped to a SSpanningRelation
						sRelation= SaltCommonFactory.eINSTANCE.createSSpanningRelation(); 
					}//xml-element has to be mapped to a SSpanningRelation
					else if (attributes.getValue("type").equalsIgnoreCase(STYPE_NAME.SDOMINANCE_RELATION.toString()))
					{//xml-element has to be mapped to a SDominanceRelation
						sRelation= SaltCommonFactory.eINSTANCE.createSDominanceRelation(); 
					}//xml-element has to be mapped to a SDominanceRelation
					else if (attributes.getValue("type").equalsIgnoreCase(STYPE_NAME.SPOINTING_RELATION.toString()))
					{//xml-element has to be mapped to a SPointingRelation
						sRelation= SaltCommonFactory.eINSTANCE.createSPointingRelation(); 
					}//xml-element has to be mapped to a SPointingRelation
					if (sRelation!= null)
					{
						sRelation.setSName(attributes.getValue("id"));
						if (this.currentSLayer!= null)
							this.currentSLayer.getSRelations().add(sRelation);
						this.currentSRelation= sRelation;
						this.getsDocumentGraph().addSRelation(sRelation);
						this.nodeId2SRelation.put(attributes.getValue("id"), sRelation);
					}
				}
			}//xml-element node will be mapped to SRelation
		}//xml-element is node
		else if (qName.equalsIgnoreCase(KW_EDGE))
		{//xml-element is edge on direction has to be a node, the other direction has to be a relation
			String fromId= attributes.getValue("from");
			String toId= attributes.getValue("to");
			//the SRelation part of the ede-element
			SRelation sRelation=null; 
			//the SNode part of the ede-element
			SNode sNode=null;
			
			sRelation= this.nodeId2SRelation.get(fromId);
			if (sRelation!= null)
			{//from is a SRelation, to is a SNode
				sNode= this.nodeId2SNode.get(toId);
				sRelation.setSTarget(sNode);
			}//from is a SRelation, to is a SNode
			else
			{
				sRelation= this.nodeId2SRelation.get(toId);
				if (sRelation!= null)
				{//to is a SRelation, from is a SNode	
					sNode= this.nodeId2SNode.get(fromId);
					sRelation.setSSource(sNode);
				}//to is a SRelation, from is a SNode
				else 
				{
					System.out.println("read SNodes: "+this.nodeId2SNode);
					System.out.println("read SRelations: "+this.nodeId2SRelation);
					System.out.println("read result: "+this.nodeId2SRelation.get(toId));
					System.out.println("read result: "+this.nodeId2SRelation.get("sSpanRel1"));
					System.out.println("read result: #"+toId+"#");
					throw new SaltException("Cannot read document from Graf-file, because a SRelation-object was refered by an edge (from='"+fromId+"' to='"+toId+"'), but it wasn�t still defined by a node-element.");
				}
			}
			
			
		}//xml-element is edge
		else if (qName.equalsIgnoreCase(KW_FEATURE_STRUCTURE))
		{//xml-element is feature-structure
			
		}//xml-element is feature-structure
		else if (qName.equalsIgnoreCase(KW_FEATURE))
		{//xml-element is feature
			SAnnotatableElement sAnnotatableElement= null;
			if (this.currentSNode!= null)
				sAnnotatableElement= this.currentSNode;
			else
				sAnnotatableElement= this.currentSRelation;
			
			if (((SIdentifiableElement)sAnnotatableElement).getId().equalsIgnoreCase("null#const_85"))
				System.out.println("adding: "+attributes.getValue("n")+ "="+attributes.getValue("v"));
			SAnnotation sAnno= SaltCommonFactory.eINSTANCE.createSAnnotation();
			String featureName=attributes.getValue("n");
			String featureValue=attributes.getValue("v");
			if (featureName.equalsIgnoreCase(SFEATURE_NAMES.STYPE_SRELATION.toString()))
			{
				if (sAnnotatableElement instanceof SRelation)
				{	
					String[] sTypes= featureValue.split(";");
					for (String sType: sTypes)
					{
						((SRelation) sAnnotatableElement).addSType(sType);
					}	
				}
			}
			else
			{	
				sAnno.setSName(attributes.getValue("n"));
				sAnno.setSValue(attributes.getValue("v"));
				sAnnotatableElement.addSAnnotation(sAnno);
			}
		}//xml-element is feature
    }
	
	@Override
	public void endElement(		String uri,
            					String localName,
            					String qName) throws SAXException
    {
		if (qName.equalsIgnoreCase(KW_NODESET))
			this.currentSLayer= null;
		else if (qName.equalsIgnoreCase(KW_NODE))
			this.currentSNode= null;
		else if (qName.equalsIgnoreCase(KW_EDGE))
			this.currentSRelation= null;
    }
// ========================================== end: SAX-stuff
}
