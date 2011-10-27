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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.graf.v09.reader;

import java.io.File;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltResourceException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.graf.v09.GrAFResource.GRAF_MAPPING_TYPE;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;

public class GrAFReader extends DefaultHandler2
{
	/**
	 * XML-element graph
	 */
	private static final String ELEMENT_GRAPH= "graph";
	/**
	 * XML-element region
	 */
	private static final String ELEMENT_REGION= "region";
	/**
	 * XML-element link
	 */
	private static final String ELEMENT_LINK= "link";
	/**
	 * XML-element node
	 */
	private static final String ELEMENT_NODE= "node";
	/**
	 * XML-element edge
	 */
	private static final String ELEMENT_EDGE= "edge";
	/**
	 * XML-element a
	 */
	private static final String ELEMENT_ANNOTATION= "a";
	/**
	 * XML-element fs
	 */
	private static final String ELEMENT_FEATURE_STRUCTURE= "fs";
	/**
	 * XML-element f
	 */
	private static final String ELEMENT_FEATURE= "f";
	/**
	 * Stores node, for links
	 */
//	private SNode currentSNode= null;
	/**
	 * Stack for current nodes
	 */
	private Stack<SNode> node_stack= new Stack<SNode>();
	/**
	 * Stack for current a element
	 */
	private Stack<SAnnotation> a_stack= new Stack<SAnnotation>();
	/**
	 * Stack for current fs element
	 */
	private Stack<SAnnotation> fs_stack= new Stack<SAnnotation>();
	/**
	 * Stack for current f element
	 */
	private Stack<SAnnotation> f_stack= new Stack<SAnnotation>();
	/**
	 * Hashtable containing link relations and their target identifier
	 */
	private Hashtable<SRelation,String> link_table= new Hashtable<SRelation,String>();
	/**
	 * Hashtable containing edge relations and their start identifier
	 */
	private Hashtable<SRelation,String> edge_from = new Hashtable<SRelation,String>();
	/**
	 * Hashtable containing edge relations and their target identifier
	 */
	private Hashtable<SRelation,String> edge_to = new Hashtable<SRelation,String>();
	/**
	 * Hashtable containing annotations and their reference identifier
	 */
	private Hashtable<SAnnotation,String> annot_table = new Hashtable<SAnnotation,String>();
	/**
	 * Hashtable containing mapping from GrAF xml:id of regions, nodes and edges to internal id
	 */
	private static Hashtable<String,String> grafId2Id = new Hashtable<String,String>();
	/**
	 * the SDocumentGraph object, where all nodes, relations annotations etc. are supposed to be mapped in.
	 */
	private SDocumentGraph sDocumentGraph= null;

	public void setsDocumentGraph(SDocumentGraph sDocumentGraph) {
		this.sDocumentGraph = sDocumentGraph;
	}

	public SDocumentGraph getsDocumentGraph() {
		return sDocumentGraph;
	}
//	================================ start: currentSTextualDS
	/**
	 * If this GrAF document depends on a primary data file, {@link GrAFReader#currentSTextualDS}} will contain the correct STextualDS object
	 * corresponding the created primary data.
	 */
	private STextualDS currentSTextualDS= null;
	public void setCurrentSTextualDS(STextualDS currentSTextualDS) {
		this.currentSTextualDS = currentSTextualDS;
	}

	public STextualDS getCurrentSTextualDS() {
		return currentSTextualDS;
	}
//	================================ end: currentSTextualDS
	
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

// ========================================== start: grafType
	/**
	 * The name of the layer or the type, which is set by header file for this file.
	 */
	private String grafType= null; 
	
	public String getGrAFType() {
		return grafType;
	}

	public void setGrAFType(String grafType) {
		this.grafType = grafType;
	}
// ========================================== end: mappingType
	
// ========================================== start: mappingType
	/**
	 * The type of how to map data belonging to a GrAF type (layer) to Salt-elements. For the current layer file
	 */
	private GRAF_MAPPING_TYPE mappingType= null; 
	
	public GRAF_MAPPING_TYPE getMappingType() {
		return mappingType;
	}

	public void setMappingType(GRAF_MAPPING_TYPE mappingType) {
		this.mappingType = mappingType;
	}
// ========================================== end: mappingType

// =================================== start: mapping properties
	private Properties mappingProps= null;
	public void setMappingProps(Properties mappingProps) {
		this.mappingProps = mappingProps;
	}

	public Properties getMappingProps() {
		return mappingProps;
	}
// =================================== end: mapping properties
	/**
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	
	@Override
	public void startElement(	String uri,
            					String localName,
            					String qName,
            					Attributes attributes) throws SAXException
    {
		//DEBUG System.out.println("grafType: "+ this.getGrAFType()+ ", mapping type: "+ this.getMappingType());
		// get type of mapping from config file (default: structure)
		String config_map_type = GRAF_MAPPING_TYPE.HIERARCHIE.toString();
		config_map_type = this.getMappingType().toString();
		if(qName.equalsIgnoreCase(ELEMENT_REGION))
		{//xml-element is region
			// map region to sToken
			SToken sToken = SaltFactory.eINSTANCE.createSToken();
			// relate to its primary data resource
			STextualRelation sTextualRelation = SaltFactory.eINSTANCE.createSTextualRelation();
			sTextualRelation.setSToken(sToken);
			sTextualRelation.setSTextualDS(currentSTextualDS);
			// handle region attributes
			int rAttNum = attributes.getLength();
			// Index is zerobased
			for(int i=0; i < rAttNum; i++){
				//TODO local or qualified Attribute Name?
				//String regionAtt = attributes.getQName(i);
				String regionAtt = attributes.getLocalName(i);
				//DEBUG System.out.println(i+" "+regionAtt);
				if(regionAtt.equalsIgnoreCase("xml:id"))
				{// handle region attributes: xml:id - Name 
					sToken.setSName(attributes.getValue("xml:id"));
					//DEBUG System.out.println(attributes.getValue("xml:id"));
				}// handle region attributes: xml:id - Name 
				else if(regionAtt.equalsIgnoreCase("anchors"))
				{// handle region attributes: anchors 
					String[] anchors= attributes.getValue("anchors").split(" ");
					if(anchors.length == 2)
					{// two anchors for region
						//DEBUG System.out.println(anchors[0]+","+anchors[1]);
						Integer start = null;
						Integer end = null;
						try {
							start= new Integer(anchors[0]);
							end= new Integer(anchors[1]);
						}catch (NumberFormatException e) 
						{
							throw new SaltResourceException("Cannot read given GrAF-file '"+this.getFileResource().getAbsolutePath()+"', because the start and end position of region is not convertable to a number.", e);
						}
						sTextualRelation.setSStart(start);
						sTextualRelation.setSEnd(end);
					}//two anchors for region
					else
					{//number of anchors not handled
						throw new SaltResourceException("Only pairs of integer values are supported as region anchors by this version. They are interpreted as character-offsets to start and end position of region.");
					}//number of anchors not handled
				}// handle region attributes: anchors
				else
				{//Warn if other attributes are specified
					System.out.println("Attribute "+regionAtt+" of element "+ELEMENT_REGION+" is not handled by this version.");
				}//Warn if other attributes are specified
			}
			this.getsDocumentGraph().addSNode(sToken);
			//xml:id is a required attribute for regions
			grafId2Id.put(attributes.getValue("xml:id"), sToken.getSId());
			//DEBUG System.out.println("region_xml_id: "+attributes.getValue("xml:id")+" salt_token_id: "+sToken.getSId());
			this.getsDocumentGraph().addSRelation(sTextualRelation);		
		}//xml-element is region
		else if(qName.equalsIgnoreCase(ELEMENT_NODE))
		{//xml-element is node
			SNode sNode= null;
			// map nodes of this file to SSpan or SStructure	
			if (config_map_type.equalsIgnoreCase(GRAF_MAPPING_TYPE.SPAN.toString()))
			{//xml-element has to be mapped to a SSpan
				sNode= SaltCommonFactory.eINSTANCE.createSSpan();
			}//xml-element node will be mapped to SSpan
			else if (config_map_type.equalsIgnoreCase(GRAF_MAPPING_TYPE.HIERARCHIE.toString()))
			{//xml-element has to be mapped to a SStructure
				sNode= SaltCommonFactory.eINSTANCE.createSStructure();
			}//xml-element has to be mapped to a SStructure
			else if (config_map_type.equalsIgnoreCase(GRAF_MAPPING_TYPE.POINTER.toString()))
			{//xml-element cannot be mapped, pointing relations do not specify a node type
				throw new SaltResourceException("Cannot handle mapping type "+config_map_type+" for element "+ELEMENT_NODE+".");
			}//xml-element cannot be mapped, pointing relations do not specify a node type
			else
			{//xml-element cannot be mapped
				throw new SaltResourceException("Cannot handle mapping type "+config_map_type+". Only mapping types "+GRAF_MAPPING_TYPE.SPAN.toString()+", "+GRAF_MAPPING_TYPE.HIERARCHIE.toString()+", "+GRAF_MAPPING_TYPE.POINTER.toString()+" are handled by this version.");
			}//xml-element cannot be mapped
			if (sNode!= null)
			{//to some general things for every node
				// handle node attributes
				int nAttNum = attributes.getLength();
				// Index is zerobased
				for(int i=0; i < nAttNum; i++){
					//TODO local or qualified Attribute Name?
					//String nodeAtt = attributes.getQName(i);
					String nodeAtt = attributes.getLocalName(i);
					//DEBUG System.out.println(i+" "+nodeAtt);
					if(nodeAtt.equalsIgnoreCase("xml:id"))
					{//handle node attributes: xml:id - Name
						sNode.setSName(attributes.getValue("xml:id"));
					}//handle node attributes: xml:id - Name
					else
					{//Warn if other attributes are specified
						System.out.println("Attribute "+nodeAtt+" of element "+ELEMENT_NODE+" is not handled by this version.");
					}//Warn if other attributes are specified
				}
				node_stack.push(sNode);
//TODO: Layer handling needed?
//				if (this.currentSLayer!= null)
//					this.currentSLayer.getSNodes().add(sNode);
//				this.currentSNode= sNode;
//				this.nodeId2SNode.put(attributes.getValue("id"), sNode);
				//DEBUG System.out.println(sNode.getSId()+" "+sNode.getSName());
				this.getsDocumentGraph().addSNode(sNode);
				//xml:id is a required attribute for nodes
				grafId2Id.put(attributes.getValue("xml:id"), sNode.getSId());
			}//to some general things for every node
		}//xml-element is node
		else if(qName.equalsIgnoreCase(ELEMENT_GRAPH))
		{//xml-element is graph
			// do nothing
			// attributes
			int gAttNum = attributes.getLength();
			// Index is zerobased
			for(int i=0; i < gAttNum; i++){
				//TODO local or qualified Attribute Name?
				//String graphAtt = attributes.getQName(i);
				String graphAtt = attributes.getLocalName(i);
				//DEBUG System.out.println(i+" "+graphAtt);		
				//TODO find more appropriate output statement
				System.out.println("Attribute "+graphAtt+" of element "+ELEMENT_GRAPH+" is not processed by this version.");
			}
		}//xml-element is graph
		else if(qName.equalsIgnoreCase(ELEMENT_LINK))
		{//xml-element is link
			//Introduces a Relation (SNode to SToken) for every link target, therefore attributes are handled first
			int lAttNum = attributes.getLength();
			// Index is zerobased
			for(int i=0; i < lAttNum; i++){
				//TODO local or qualified Attribute Name?
				//String linkAtt = attributes.getQName(i);
				String linkAtt = attributes.getLocalName(i);
				//DEBUG System.out.println(i+" "+linkAtt);
				if(linkAtt.equalsIgnoreCase("targets"))
				{//handle link attributes: targets - one relation each 
					String[] targets= attributes.getValue("targets").split(" ");
					for(String target : targets){
						//DEBUG 
						System.out.println("Target:"+target);
						SRelation sRelation = null;
						// map links to SSpanningRelation or SDominanceRelation	
						if (config_map_type.equalsIgnoreCase(GRAF_MAPPING_TYPE.SPAN.toString()))
						{//xml-element has to be mapped to SSpanningRelation
							sRelation= SaltCommonFactory.eINSTANCE.createSSpanningRelation();
						}//xml-element has to be mapped to SSpanningRelation
						else if (config_map_type.equalsIgnoreCase(GRAF_MAPPING_TYPE.HIERARCHIE.toString()))
						{//xml-element has to be mapped to SDominanceRelation
							sRelation= SaltCommonFactory.eINSTANCE.createSDominanceRelation();
						}//xml-element has to be mapped to SDominanceRelation
						else if (config_map_type.equalsIgnoreCase(GRAF_MAPPING_TYPE.POINTER.toString()))
						{//xml-element cannot be mapped to SPointingRelation as links are always embedded in node elements
							throw new SaltResourceException("Cannot handle mapping type "+config_map_type+" for "+ELEMENT_LINK+" elements.");
						}//xml-element cannot be mapped to SPointingRelation
						else
						{//xml-element cannot be mapped
							throw new SaltResourceException("Cannot handle mapping type "+config_map_type+". Only mapping types "+GRAF_MAPPING_TYPE.SPAN.toString()+", "+GRAF_MAPPING_TYPE.HIERARCHIE.toString()+", "+GRAF_MAPPING_TYPE.POINTER.toString()+" are handled by this version.");
						}//xml-element cannot be mapped
						if (sRelation!= null)
						{//to some general things for every link
							//set Source
							sRelation.setSSource(node_stack.peek());
							//push relation and expected target on stack
							//TODO: warning, if two edges have same source: -> same key on hashtable -> overwrite
							link_table.put(sRelation, target);
							System.out.println(link_table.size());
						}//to some general things for every link
					}
				}//handle link attributes: targets - one relation each
				else
				{//Warn if other attributes are specified
					System.out.println("Attribute "+linkAtt+" of element "+ELEMENT_LINK+" is not handled by this version.");
				}//Warn if other attributes are specified
			}		
		}//xml-element is link
		else if(qName.equalsIgnoreCase(ELEMENT_EDGE))
		{//xml-element is edge
			SRelation sRelation = null;
			// map edges of this file to SSpanningRelation, SDominanceRelation or SPointingRelation	
			if (config_map_type.equalsIgnoreCase(GRAF_MAPPING_TYPE.SPAN.toString()))
			{//xml-element has to be mapped to SSpanningRelation
				sRelation= SaltCommonFactory.eINSTANCE.createSSpanningRelation();
			}//xml-element has to be mapped to SSpanningRelation
			else if (config_map_type.equalsIgnoreCase(GRAF_MAPPING_TYPE.HIERARCHIE.toString()))
			{//xml-element has to be mapped to SDominanceRelation
				sRelation= SaltCommonFactory.eINSTANCE.createSDominanceRelation();
			}//xml-element has to be mapped to SDominanceRelation
			else if (config_map_type.equalsIgnoreCase(GRAF_MAPPING_TYPE.POINTER.toString()))
			{//xml-element has to be mapped to SPointingRelation
				sRelation= SaltCommonFactory.eINSTANCE.createSPointingRelation();
			}//xml-element has to be mapped to SPointingRelation
			else
			{//xml-element cannot be mapped
				throw new SaltResourceException("Cannot handle mapping type "+config_map_type+". Only mapping types "+GRAF_MAPPING_TYPE.SPAN.toString()+", "+GRAF_MAPPING_TYPE.HIERARCHIE.toString()+", "+GRAF_MAPPING_TYPE.POINTER.toString()+" are handled by this version.");
			}//xml-element cannot be mapped
			//System.out.println(this.getsDocumentGraph().getSNodes());
			if (sRelation!= null)
			{//to some general things for every edge
				// handle edge attributes
				int eAttNum = attributes.getLength();
				// Index is zerobased
				for(int i=0; i < eAttNum; i++){
					//TODO local or qualified Attribute Name?
					//String edgeAtt = attributes.getQName(i);
					String edgeAtt = attributes.getLocalName(i);
					//DEBUG System.out.println(i+" "+edgeAtt);
					if(edgeAtt.equalsIgnoreCase("xml:id"))
					{//handle edge attributes: xml:id - Name
						//id was optional for edges - it if has one, it might be annotated
						sRelation.setSName(attributes.getValue("xml:id"));
					}//handle edge attributes: xml:id - Name
					else if(edgeAtt.equalsIgnoreCase("from"))
					{//handle edge attributes: start node
						//DEBUG
						System.out.println(attributes.getValue("from"));
						//TODO: overwrites instead of adding -> change
						edge_from.put(sRelation, attributes.getValue("from"));
						//DEBUG
						System.out.println("from size: "+edge_from.size());
					}//handle edge attributes: start node
					else if(edgeAtt.equalsIgnoreCase("to"))
					{//handle edge attributes: target node
						System.out.println("to size_pre: "+edge_to.size());
						//TODO: overwrites instead of adding -> change
						edge_to.put(sRelation, attributes.getValue("to"));
						System.out.println("Relation: "+sRelation.hashCode());
						//DEBUG
						System.out.println("to size: "+edge_to.size());
					}//handle edge attributes: target node
					else
					{//Warn if other attributes are specified
						System.out.println("Attribute "+edgeAtt+" of element "+ELEMENT_EDGE+" is not handled by this version.");
					}//Warn if other attributes are specified
				}
				//DEBUG System.out.println(sRelation.getSId()+" "+sRelation.getSName());
			}//to some general things for every edge
		}//xml-element is edge
		else if(qName.equalsIgnoreCase(ELEMENT_ANNOTATION))
		{//xml-element is annot
			SAnnotation sAnnotation = SaltFactory.eINSTANCE.createSAnnotation();
			//handle a attributes
			int aAttNum = attributes.getLength();
			// Index is zerobased
			for(int i=0; i < aAttNum; i++){
				//TODO local or qualified Attribute Name?
				//String aAtt = attributes.getQName(i);
				String aAtt = attributes.getLocalName(i);
				//DEBUG System.out.println(i+" "+aAtt);
				if(aAtt.equalsIgnoreCase("label"))
				{//handle a attributes: label
					//TODO SNamen and SValue or Name and Value
					sAnnotation.setSName(aAtt);
					sAnnotation.setSValue(attributes.getValue(aAtt));
				}//handle a attributes: label
				else if(aAtt.equalsIgnoreCase("ref"))
				{//handle a attributes: ref
					//TODO
				}//handle a attributes: ref
				else
				{//Warn if other attributes are specified
					System.out.println("Attribute "+aAtt+" of element "+ELEMENT_ANNOTATION+" is not handled by this version.");
				}//Warn if other attributes are specified
			}
			a_stack.push(sAnnotation);
			//DEBUG System.out.println(a_stack.size());
		}//xml-element is annot
		else if(qName.equalsIgnoreCase(ELEMENT_FEATURE_STRUCTURE))
		{//xml-element is fs
			//find father node: a or f
			SAnnotation father = null;
			if(f_stack.empty())
			{//father is a
				father = a_stack.peek();
			}//father is a
			else
			{//father is f
				father = f_stack.peek();
			}//father is f
			if (father!= null)
			{//to some general things for every fs
				SAnnotation fsAnnotation = SaltFactory.eINSTANCE.createSAnnotation();
				//handle fs attributes	
				int fsAttNum = attributes.getLength();
				// Index is zerobased
				for(int i=0; i < fsAttNum; i++){
					//TODO local or qualified Attribute Name?
					//String fsAtt = attributes.getQName(i);
					String fsAtt = attributes.getLocalName(i);
					//DEBUG System.out.println(i+" "+fsAtt);
					//No attributes handled here - warn if any attributes are specified
					System.out.println("Attribute "+fsAtt+" of element "+ELEMENT_FEATURE_STRUCTURE+" is not handled by this version.");
				}
				//TODO SName or Name?
				fsAnnotation.setSName("fs");
				father.addLabel(fsAnnotation); //TODO: addSAnnotation?
				fs_stack.push(fsAnnotation);
			}//to some general things for every fs
		}//xml-element is fs
		else if(qName.equalsIgnoreCase(ELEMENT_FEATURE))
		{//xml-element is feature
			SAnnotation father = fs_stack.peek();
			if (father!= null)
			{//to some general things for every f
				SAnnotation fAnnotation = SaltFactory.eINSTANCE.createSAnnotation();
				//handle f attributes	
				int fAttNum = attributes.getLength();
				// Index is zerobased
				for(int i=0; i < fAttNum; i++){
					//TODO local or qualified Attribute Name?
					//String fAtt = attributes.getQName(i);
					String fAtt = attributes.getLocalName(i);
					//DEBUG System.out.println(i+" "+fAtt);
					if(fAtt.equalsIgnoreCase("name"))
					{//handle f attributes: feature name
						//TODO: SName or Name?
						fAnnotation.setSName(attributes.getValue(fAtt));
					}//handle f attributes: feature name
					else if(fAtt.equalsIgnoreCase("value"))
					{//handle f attributes: feature value
						//TODO: SValue or Value?
						fAnnotation.setSValue(attributes.getValue(fAtt));
					}//handle f attributes: feature value
					else
					{//Warn if other attributes are specified
						System.out.println("Attribute "+fAtt+" of element "+ELEMENT_FEATURE+" is not handled by this version.");
					}//Warn if other attributes are specified
				}		
				father.addLabel(fAnnotation); //TODO: addSAnnotation?
				f_stack.push(fAnnotation);
			}//to some general things for every f
		}//xml-element is feature
		else
		{//xml-element not handled 
			throw new SaltResourceException("Cannot read given GrAF-file '"+this.getFileResource().getAbsolutePath()+"', because this version does not handle <"+qName+"/> elements.");
		}//xml-element not handled
    }
	
	@Override
	public void endElement(		String uri,
            					String localName,
            					String qName) throws SAXException
    {
		if (ELEMENT_NODE.equalsIgnoreCase(qName))
		{//end of xml-element node
			node_stack.pop();
		}//end of xml-element node
		else if (ELEMENT_ANNOTATION.equalsIgnoreCase(qName))
		{//end of xml-element a
			a_stack.pop();
		}//end of xml-element a
		else if (ELEMENT_FEATURE_STRUCTURE.equalsIgnoreCase(qName))
		{//end of xml-element fs
			fs_stack.pop();
		}//end of xml-element fs
		else if (ELEMENT_FEATURE.equalsIgnoreCase(qName))
		{//end of xml-element f
			f_stack.pop();
		}//end of xml-element f
		else if (ELEMENT_GRAPH.equalsIgnoreCase(qName))
		{//end of xml-element graph
			//Insert link relations
			Enumeration<SRelation> l = link_table.keys();
			while(l.hasMoreElements())
			{//loop through pending links, check if target region is available
				//DEBUG System.out.println(link_table.get(l.nextElement()));
				SRelation link = l.nextElement();
				//DEBUG System.out.println(link_table.get(link));
				String regionXmlId = link_table.get(link);
				//DEBUG 
				System.out.println(link.getSSource().getSName()+","+regionXmlId);
				System.out.println(grafId2Id.get(regionXmlId));
				String regionId = grafId2Id.get(regionXmlId);
				if (regionId != null)
				{//region exists in graph
					SNode region = this.getsDocumentGraph().getSNode(regionId);
					link.setSTarget(region);
					this.getsDocumentGraph().addSRelation(link);
					//DEBUG
					System.out.println("Link to region "+regionXmlId+" added.");
				}//region exists in graph
				else
				{//expected region is not available
					throw new SaltResourceException("Cannot insert link because target region ("+regionXmlId+") is missing.");
				}//expected region is not available
			} //loop through pending links, check if target region is available
			//Insert edge relations
			Enumeration<SRelation> r = edge_from.keys();
			//only keys of edge_from: if from-node is not available it is not relevant to check for target node
			while(r.hasMoreElements())
			{//loop through pending edges, check if start and target nodes are available
				//DEBUG
				System.out.println(edge_from.size());
				SRelation edge = r.nextElement();
				String startXmlId = edge_from.get(edge);
				//DEBUG
				System.out.println(startXmlId);
				String targetXmlId = edge_to.get(edge);
				//DEBUG
				System.out.println(targetXmlId);
				String startId = grafId2Id.get(startXmlId);
				String targetId = grafId2Id.get(targetXmlId);
				if ((startId != null) & (targetId != null))
				{//both nodes exist in graph
					SNode start_node = this.getsDocumentGraph().getSNode(startId);
					SNode target_node = this.getsDocumentGraph().getSNode(targetId);
					edge.setSSource(start_node);
					edge.setSTarget(target_node);
					this.getsDocumentGraph().addSRelation(edge);
					//xml:id is a required attribute for edges
					grafId2Id.put(edge.getSName(), edge.getSId());
					//DEBUG
					System.out.println("edgename: "+edge.getSName()+", edgeid: "+edge.getSId());
					//DEBUG
					System.out.println("Relation ("+startXmlId+","+targetXmlId+") added.");
				}//both nodes exist in graph
				else
				{//at least one of the expected nodes is missing
					throw new SaltResourceException("Cannot insert edge because at least one of the connected nodes ("+startXmlId+","+targetXmlId+") is missing.");
				}//at least one of the expected nodes is missing
			}//loop through pending edges, check if start and target nodes are available
			//Insert annotations
			//TODO: Insert annotations
		}//end of xml-element graph
    }

	
	
}
