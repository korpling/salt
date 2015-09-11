package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.visjs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashSet;

import org.eclipse.emf.common.util.EList;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GRAPH_TRAVERSE_TYPE;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraphTraverseHandler;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.samples.SampleGenerator;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltEmptyParameterException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltResourceException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltResourceNotFoundException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.visjs.*;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.events.*;

import org.json.*;
import org.eclipse.emf.common.util.URI;


public class VisJsCreator implements SGraphTraverseHandler{
		
	private  long maxHeight;
	private  int currHeight;
	private  int maxLevel;
	private  int currHeightFromToken;

	
	private  SDocument doc;
	private  XMLOutputFactory outputFactory;
	private  OutputStream os;
	private  XMLStreamWriter writer;
	private  BufferedWriter outNodes;
	private  BufferedWriter outEdges;
	private  BufferedWriter outOptions;
	
	private  JSONWriter jsonWriterNodes;
	private  JSONWriter jsonWriterEdges;	
		
	private  int bufferSizeEdges;

	private static final String TRAV_MODE_CALC_LEVEL = "calcLevel";
	private static final String TRAV_MODE_READ_NODES = "readNodes";
	
	
	private final HashSet <SNode> readRoots;
	private final HashSet <SRelation> readRelations;
	private final EList<SNode> roots;
	private int nGroupsId = 0;
	
	
	// JSON output
	private static final String JSON_ID = "id";
	private static final String JSON_LABEL = "label";
	private static final String JSON_COLOR = "color";
	private static final String JSON_X = "x";
	private static final String JSON_LEVEL = "level";
	private static final String JSON_GROUP = "group";
	
	private  int xValue = 0;	
	private static final String TOK_COLOR_VALUE = "#CCFF99";
	private static final String VISJS_WIDTH = "1400px";
	private static final String VISJS_HEIGHT = "1000px";
	
	
	// HTML resources output
	private final static String VIS_JS_SRC = "js/vis.min.js";
	private final static String VIS_CSS_SRC = "css/vis.min.css";
	//private final String visJsSrcGA = "../../googleAnalytics.js";
	
    private final String textStyle = "width:700px; font-size:14px; text-align: justify;";
    
    //HTML tags
    private static final String TAG_HTML = "html";
    private static final String TAG_HEAD = "head";
    private static final String TAG_BODY = "body";
    private static final String TAG_TITLE = "title";
    private static final String TAG_P = "p";
    private static final String TAG_DIV = "div";
    private static final String TAG_SCRIPT = "script";
    private static final String TAG_STYLE = "style";
    private static final String TAG_LINK = "link";
    private static final String TAG_H2 = "h2";
    private static final String TAG_INPUT = "input";
    
    //HTML attributes
    private static final String ATT_TYPE = "type";
    private static final String ATT_ID = "id";
    private static final String ATT_VALUE = "value";
    private static final String ATT_SRC = "src";
    private static final String ATT_HREF = "href";
    private static final String ATT_REL = "rel";
    private static final String ATT_STYLE = "style";
    private static final String ATT_LANG = "language";
    
    
    private static final int JSON_EDGE_LINE_LENGTH = 60;    
    private static final String NEWLINE = System.lineSeparator();    
    private final Filter filter;
    
    private boolean writeNodeImmediately = false;
    
    private static final String OUTPUT_FILE = "saltVisJs.html";	
    private static final String CSS_FOLDER_OUT = "css";
    private static final String JS_FOLDER_OUT = "js";
    private static final String CSS_FILE = "vis.min.css";
    private static final String JS_FILE = "vis.min.js";
        
    private static final String RESOURCES_FOLDER = System.getProperty("file.separator") + "visjs"; 
    													
    		
    
  
    public VisJsCreator(URI inputUri){
  	  this(inputUri, null);
    }
	
    
    
    public VisJsCreator (URI inputUri, Filter filter){  
    	if(inputUri == null) throw new SaltEmptyParameterException("inputUri", "VisJsCreator", this.getClass());
     	
    	try{
    		this.doc= SaltFactory.eINSTANCE.createSDocument();	
        	doc.loadSDocumentGraph(inputUri);
    	}catch (SaltResourceNotFoundException e){
    		throw new SaltResourceNotFoundException("A problem occurred while loading salt project from '" + inputUri + "'.", e);
    	}
    	catch (SaltResourceException e){
			throw new SaltResourceException("A problem occurred while loading salt project from '" + inputUri + "'.", e);
		}
    	
    	roots = doc.getSDocumentGraph().getSRoots();	
    	EList<SSpan>  sSpans = doc.getSDocumentGraph().getSSpans();	
    	if (sSpans != null && (sSpans.size() > 0))
    	{
    		nGroupsId += 1;
    	}	
    	EList<SStructure>  sStructures = doc.getSDocumentGraph().getSStructures();
    	
    	if (sStructures != null && (sStructures.size() > 0))
    	{
    		nGroupsId += 2;
    	}
    	
    	readRoots = new HashSet <SNode>();
    	readRelations = new HashSet <SRelation>();       	
    	
    	long nEdges = doc.getSDocumentGraph().getNumOfEdges();
    	if (nEdges > Math.floor(((double)Integer.MAX_VALUE/(double)JSON_EDGE_LINE_LENGTH)))
    	{
    		throw new SaltException("The specified document cannot be visualized. It contains too many edges.");    		
    	}
    	else
    	{
    		bufferSizeEdges = (int) (nEdges) * JSON_EDGE_LINE_LENGTH;	
    	}
    	
    	this.filter = filter;
    	
    }
    

    public VisJsCreator(SDocument doc){
  	  this(doc, null);
    }
    
    public VisJsCreator (SDocument doc, Filter filter){  
    	
    	if(doc == null) throw new SaltEmptyParameterException("doc", "VisJsCreator", this.getClass());
    
    	this.doc = doc;    	
    	roots = doc.getSDocumentGraph().getSRoots();	
    	EList<SSpan>  sSpans = doc.getSDocumentGraph().getSSpans();	
    	if (sSpans != null && (sSpans.size() > 0))
    	{
    		nGroupsId += 1;
    	}	
    	EList<SStructure>  sStructures = doc.getSDocumentGraph().getSStructures();
    	
    	if (sStructures != null && (sStructures.size() > 0))
    	{
    		nGroupsId += 2;
    	}
    	
    	readRoots = new HashSet <SNode>();
    	readRelations = new HashSet <SRelation>();       	
    	
    	long nEdges = doc.getSDocumentGraph().getNumOfEdges();
    	if (nEdges > Math.floor(((double)Integer.MAX_VALUE/(double)JSON_EDGE_LINE_LENGTH)))
    	{
    		throw new SaltException("The specified document cannot be visualized. It contains too many edges.");    		
    	}
    	else
    	{
    		bufferSizeEdges = (int) (nEdges) * JSON_EDGE_LINE_LENGTH;	
    	}
    	
    	this.filter = filter;
    	
    }
    
    
public void setNodeWriter (OutputStream os)
{
	this.outNodes = new BufferedWriter(new OutputStreamWriter(os));		
	this.jsonWriterNodes = new JSONWriter(outNodes);
}

public void setEdgeWriter (OutputStream os)
{
	this.outEdges = new BufferedWriter (new OutputStreamWriter(os), bufferSizeEdges);	
	this.jsonWriterEdges = new JSONWriter(outEdges);
}

public void setOptionsWriter (OutputStream os){
	this.outOptions = new BufferedWriter(new OutputStreamWriter(os));		
	
}
   
	
/*
 * Creates the output folder from the specified URI if not exists and writes the output html-file into that.
 * Also creates two subfolder for css and visjs resources and writes the resource files 
 * vis.min.css and vis.min.js into the both folder respective.
 */

public void writeHTML(URI outputFileUri) throws SaltEmptyParameterException,  SaltResourceNotFoundException, SaltException,
															SaltResourceException, XMLStreamException, IOException{
	
		try {
			File outputFolder = createOutputResources(outputFileUri);	
			 this.os = new FileOutputStream(new File(outputFolder, OUTPUT_FILE));
		
			} catch (SaltEmptyParameterException e) {
			  throw new SaltEmptyParameterException("outputFileUri", "writeHTML", this.getClass());
			}	
			catch (FileNotFoundException e) {
				throw new SaltResourceNotFoundException("The output file cannot be created.");
			}	
			catch (SecurityException e) {
			 throw new SaltException("Either the output folder cannot be created or permission denied.");
			}
			catch (IOException e) {
			 throw new SaltResourceException("A problem occurred while copying the vis-js resource files");
			}	
	
		
		try {
		this.outputFactory = XMLOutputFactory.newInstance();
		this.writer = outputFactory.createXMLStreamWriter(os, "UTF-8");
		
		setNodeWriter(os);
		setEdgeWriter(os);
		setOptionsWriter(os);
		
    	
    	writeNodeImmediately = true;
		
		writer.writeStartDocument("UTF-8", "1.0");
		writer.writeCharacters(NEWLINE);
		writer.writeStartElement(TAG_HTML);
		writer.writeCharacters(NEWLINE);
		
		writer.writeStartElement(TAG_HEAD);
		writer.writeCharacters(NEWLINE);
		
		writer.writeStartElement(TAG_TITLE);
		writer.writeCharacters("Salt Document Tree");
		writer.writeEndElement();
		writer.writeCharacters(NEWLINE);
		
		writer.writeStartElement(TAG_STYLE);
		writer.writeAttribute(ATT_TYPE, "text/css");
		writer.writeCharacters("body {" + NEWLINE 
				+ "font: 10pt sans;" + NEWLINE 
				+ "}" + NEWLINE 
				+ "#mynetwork {" + NEWLINE 
				+ "width: " + VISJS_WIDTH +";" + NEWLINE 
				+ "height: " + VISJS_HEIGHT + ";" + NEWLINE 
				+ "border: 1px solid lightgray;" + NEWLINE 
				+ "}");
		writer.writeEndElement();
		writer.writeCharacters(NEWLINE);
		
		writer.writeStartElement(TAG_SCRIPT);
		writer.writeAttribute(ATT_TYPE, "text/javascript");
		writer.writeAttribute(ATT_SRC,VIS_JS_SRC);
		writer.writeEndElement();
		writer.writeCharacters(NEWLINE);
		
		writer.writeEmptyElement(TAG_LINK);
		writer.writeAttribute(ATT_HREF, VIS_CSS_SRC);
		writer.writeAttribute(ATT_REL,"stylesheet");
		writer.writeAttribute(ATT_TYPE, "text/css");
		writer.writeCharacters(NEWLINE);
		
		
		writer.writeStartElement(TAG_SCRIPT);
		writer.writeAttribute(ATT_TYPE, "text/javascript");
		writer.writeCharacters("var nodes = null;" + NEWLINE 
						+ "var edges = null;" + NEWLINE 
						+ "var network = null;" + NEWLINE
						+ "var directionInput = document.getElementById(\"direction\");" + NEWLINE 
						+ "function destroy() {" + NEWLINE 
						+ "if (network !== null) {" + NEWLINE 
						+ "network.destroy();" + NEWLINE 
						+ "network = null;" + NEWLINE 
						+ "}" + NEWLINE 
						+ "}" + NEWLINE 
						+ "function draw() {" + NEWLINE 
						+ "destroy();" + NEWLINE 
						+ "var connectionCount = [];" + NEWLINE 
						+ "nodes = [];" + NEWLINE 
						+ "edges = [];" + NEWLINE);
		
		writer.flush();
		
		outNodes.write("var nodes = new vis.DataSet(" + NEWLINE);

		
		outEdges.write("var edges = new vis.DataSet(" + NEWLINE);
		
		buildJSON();
		
		 outNodes.write(");");
		 outNodes.newLine();
		 outNodes.flush();
		 
		 outEdges.write(");");
		 outEdges.newLine();
		 outEdges.flush();
		
		
    	 writer.writeCharacters("var container = document.getElementById('mynetwork');" + NEWLINE
					+ "var data = {" + NEWLINE
					+ "nodes: nodes," + NEWLINE
					+ "edges: edges" + NEWLINE
					+ "};" + NEWLINE
					+ "var options = ");
	
    	 
    	 buildOptions();
		 outOptions.flush();
	

		 
		writer.writeCharacters(";" + NEWLINE
				+ "network = new vis.Network(container, data, options);" + NEWLINE
				+ "network.on('select', function(params) {" + NEWLINE
				+ "document.getElementById('selection').innerHTML = 'Selection: ' + params.nodes;" + NEWLINE
				+ "});" + NEWLINE
				+ "}" + NEWLINE); 

		writer.writeEndElement();
		writer.writeCharacters(NEWLINE);
		
	/*	writer.writeStartElement(script);
		writer.writeAttribute(attSrc, visJsSrcGA);
		writer.writeEndElement();
		writer.writeCharacters(NEWLINE);		*/
		
		//head 
		writer.writeEndElement();
		writer.writeCharacters(NEWLINE);
		
		
		writer.writeStartElement(TAG_BODY);
		writer.writeAttribute("onload", "draw();");
		writer.writeCharacters(NEWLINE);
		
		writer.writeStartElement(TAG_H2);
		writer.writeCharacters("Salt Document Tree");
		writer.writeEndElement();
		writer.writeCharacters(NEWLINE);
		
		writer.writeStartElement(TAG_DIV);
		writer.writeAttribute(ATT_STYLE,textStyle);
		writer.writeEndElement();
		writer.writeCharacters(NEWLINE);
		
		writer.writeStartElement("p");
		
		writer.writeEmptyElement(TAG_INPUT);
		writer.writeAttribute(ATT_TYPE,"button");
		writer.writeAttribute(ATT_ID, "btn-UD");
		writer.writeAttribute(ATT_VALUE, "Up-Down");
		writer.writeCharacters(NEWLINE);
		
		writer.writeEmptyElement(TAG_INPUT);
		writer.writeAttribute(ATT_TYPE,"button");
		writer.writeAttribute(ATT_ID, "btn-DU");
		writer.writeAttribute(ATT_VALUE, "Down-Up");
		writer.writeCharacters(NEWLINE);
		
		writer.writeEmptyElement(TAG_INPUT);
		writer.writeAttribute(ATT_TYPE,"button");
		writer.writeAttribute(ATT_ID, "btn-LR");
		writer.writeAttribute("value", "Left-Right");
		writer.writeCharacters(NEWLINE);
		
		writer.writeEmptyElement(TAG_INPUT);
		writer.writeAttribute(ATT_TYPE,"button");
		writer.writeAttribute(ATT_ID, "btn-RL");
		writer.writeAttribute(ATT_VALUE, "Right-Left");
		writer.writeCharacters(NEWLINE);
		
		writer.writeEmptyElement(TAG_INPUT);
		writer.writeAttribute(ATT_TYPE,"hidden");
		//TODO check the apostrophes
		writer.writeAttribute(ATT_ID, "direction");
		writer.writeAttribute(ATT_VALUE, "UD");
		writer.writeCharacters(NEWLINE);
	
		
		//p
		writer.writeEndElement();
		writer.writeCharacters(NEWLINE);
		
		writer.writeStartElement(TAG_DIV);
		writer.writeAttribute(ATT_ID, "mynetwork");
		writer.writeEndElement();
		writer.writeCharacters(NEWLINE);
		
		writer.writeStartElement(TAG_P);
		writer.writeAttribute(ATT_ID, "selection");
		writer.writeEndElement();
		writer.writeCharacters(NEWLINE);
		
		
		writer.writeStartElement(TAG_SCRIPT);
		writer.writeAttribute(ATT_LANG, "JavaScript");
		writer.writeCharacters(NEWLINE);
		writer.writeCharacters("var directionInput = document.getElementById(\"direction\");" + NEWLINE
				+ "var btnUD = document.getElementById(\"btn-UD\");" + NEWLINE
				+ "btnUD.onclick = function() {" + NEWLINE
				+ "directionInput.value = \"UD\";" + NEWLINE
				+ "draw();" + NEWLINE
				+ "};" + NEWLINE
				+ "var btnDU = document.getElementById(\"btn-DU\");" + NEWLINE
				+ "btnDU.onclick = function() {" + NEWLINE
				+ "directionInput.value = \"DU\";" + NEWLINE
				+ "draw();" + NEWLINE
				+ "};" + NEWLINE
				+ "var btnLR = document.getElementById(\"btn-LR\");" + NEWLINE
				+ "btnLR.onclick = function() {" + NEWLINE
				+ "directionInput.value = \"LR\";" + NEWLINE
				+ "draw();" + NEWLINE
				+ "};" + NEWLINE
				+ "var btnRL = document.getElementById(\"btn-RL\");" + NEWLINE
				+ "btnRL.onclick = function() {" + NEWLINE
				+ "directionInput.value = \"RL\";" + NEWLINE
				+ "draw();" + NEWLINE
				+ "};" + NEWLINE);
		writer.writeEndElement();
		writer.writeCharacters(NEWLINE);			
		
		//body
		writer.writeEndElement();
		writer.writeCharacters(NEWLINE);	
		
		
		//html
		writer.writeEndElement();
		writer.writeCharacters(NEWLINE);	
			
	   
		writer.writeEndDocument();
		writer.flush();
		writer.close();
		
		outEdges.close();
		outNodes.close();
		
		writeNodeImmediately = false;
		} catch (XMLStreamException e) {
			throw new SaltException("A problem occurred while writing the output file.");
		}
	  
	}

/*
 * Organizes the output folder structure and invokes the method for copying of resource files. 
 */
  
	private File createOutputResources(URI outputFileUri) 
			throws SaltEmptyParameterException, SecurityException, FileNotFoundException, IOException{
		  File outputFolder = null;
		  if (outputFileUri == null) throw new SaltEmptyParameterException();			
		  outputFolder = new File (outputFileUri.path());
		 if(!outputFolder.exists()) outputFolder.mkdirs();
		 
		  File cssFolderOut = new File(outputFolder, CSS_FOLDER_OUT);
		  if(!cssFolderOut.exists()) cssFolderOut.mkdir();
		  
		  File jsFolderOut = new File(outputFolder, JS_FOLDER_OUT);
		  if(!jsFolderOut.exists()) jsFolderOut.mkdir();
		  
		  copyResourceFile(CSS_FILE, outputFolder.getPath(), CSS_FOLDER_OUT, CSS_FILE);
		  copyResourceFile(JS_FILE, outputFolder.getPath(), JS_FOLDER_OUT, JS_FILE);
	     
		  return outputFolder;
	}
	
	
/*
 * Copies the specified resource file to the output resource subfolder.
 */
	private void copyResourceFile (String inFile, String outputFolder, String outSubFolder, String outFile) 
					throws FileNotFoundException, IOException{
	
		InputStream inputStream = getClass( ).getResourceAsStream(RESOURCES_FOLDER 
				  + System.getProperty("file.separator") 
				  + inFile);		  
		  BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		  BufferedWriter writer;
	
			writer = new BufferedWriter ( new OutputStreamWriter(new FileOutputStream(new File (outputFolder
					  + System.getProperty("file.separator")
					  + outSubFolder 
					  + System.getProperty("file.separator")
					  + outFile))));
		
		  
		  int bufferSize = 512*1024;		  
		  char [] buffer = new char [bufferSize];
		  int readChars = 0;		  		  

			while ((readChars=reader.read(buffer, 0, bufferSize)) != -1) 
			  {		
						writer.write(buffer, 0, readChars);
			  }	
			    
		  	inputStream.close();
		    reader.close();
		    writer.flush();
		    writer.close();     
	}
	
	
	
	public void buildJSON () throws SaltException, SaltEmptyParameterException{		
	maxLevel = getMaxLevel(doc);

	doc.getSDocumentGraph().sortSTokenByText();	  		 
	 EList <SToken> sTokens = doc.getSDocumentGraph().getSTokens();
	
	 if(outNodes == null || jsonWriterNodes == null){
		 throw new SaltEmptyParameterException("A problem occurred while building JSON objects. Probably the node writer is not set.");
	 }
	 if(outEdges == null || jsonWriterEdges == null){
		 throw new SaltEmptyParameterException("A problem occurred while building JSON objects. Probably the edge writer is not set.");
	 }
	 
	 try{
		 
	//create node array
	jsonWriterNodes.array();
	// write tokens
	 for (SToken token : sTokens){			
			writeJsonNode(token, maxLevel, filter);
	 }
	
	 //create edge array
	 jsonWriterEdges.array();
	 
	 // traverse the document tree in order to write remained nodes and edges
	 doc.getSDocumentGraph().traverse(doc.getSDocumentGraph().getSRoots(), GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, 
			 												TRAV_MODE_READ_NODES, this);		
	 //close node array		 
	 jsonWriterNodes.endArray();			   
		
	//close edge array
	 jsonWriterEdges.endArray();	
	 
	}catch(JSONException e){
		 throw new SaltException("A problem occurred while building JSON objects.");
	 }
	 catch(IOException e){
		 throw new SaltException("A problem occurred while building JSON objects.");
	 }
			
	}
	
	
	private void writeJsonNode (SNode node, long levelValue, Filter filter) throws IOException
	{
		if (filter == null || filter.outputNode(node))	
		{
		 String idValue = node.getSElementPath().fragment();
		 String idLabel = "id=" + idValue;	
		 String allLabels = idLabel;
			 
		 jsonWriterNodes.object();
		 jsonWriterNodes.key(JSON_ID);		 
		 jsonWriterNodes.value(idValue);
		 jsonWriterNodes.key(JSON_LABEL);
		 
	
		   EList<SAnnotation> sAnnotations = node.getSAnnotations();
		   if (sAnnotations.size() > 0)
		   {		
			   allLabels += "" + NEWLINE;
			   
			   for (SAnnotation annotation : sAnnotations) 
			   {
				   allLabels += (annotation.getSName() + "=" + annotation.getSValue().toString());
				
				   if (sAnnotations.indexOf(annotation) < sAnnotations.size()-1)  allLabels+= NEWLINE;								   
			   }
		   }
		   
		   if (node instanceof SToken)
		   {
			   String text = doc.getSDocumentGraph().getSText(node);
				  if (text != null && !text.isEmpty())
				  {
					  allLabels+= NEWLINE;			
					  allLabels += doc.getSDocumentGraph().getSText(node);
				  }
		   } 
		  
		   				
		 jsonWriterNodes.value(allLabels);	
		 if (node instanceof SToken)
		 {
			 jsonWriterNodes.key(JSON_COLOR);
			 jsonWriterNodes.value(TOK_COLOR_VALUE);
			 jsonWriterNodes.key(JSON_X);
			 jsonWriterNodes.value(++xValue);
		 }
		 
		 	 jsonWriterNodes.key(JSON_LEVEL);
			 jsonWriterNodes.value(levelValue);
			 
		if (node instanceof SSpan)
		{
			if (nGroupsId == 3)
			{
				 jsonWriterNodes.key(JSON_GROUP);
				 jsonWriterNodes.value("1");
			}
			else if (nGroupsId == 1)
			{
				jsonWriterNodes.key(JSON_GROUP);
				jsonWriterNodes.value("0");
			}
	
		}
		
		else if (node instanceof SStructure)
		{
			if (nGroupsId == 3 || nGroupsId == 2)
			{
				jsonWriterNodes.key(JSON_GROUP);
				jsonWriterNodes.value("0");
			}
	
		}		 
		 
		jsonWriterNodes.endObject();	
		outNodes.newLine();	
		
		if(writeNodeImmediately) outNodes.flush();
		
		}
}
		 
	private void writeJsonEdge (SNode fromNode, SNode toNode, SRelation relation, Filter filter) throws IOException
	{
			  if(filter == null || filter.outputRelation(relation))
			  {
			  jsonWriterEdges.object();
			  jsonWriterEdges.key("from");
			  jsonWriterEdges.value(fromNode.getSElementPath().fragment());
			  jsonWriterEdges.key("to");
			  jsonWriterEdges.value(toNode.getSElementPath().fragment());
			  jsonWriterEdges.key("label");
			  jsonWriterEdges.value(relation.getSElementPath().fragment());
			  jsonWriterEdges.endObject();
			  
			  
			  outEdges.newLine();
			  }
	}
	
	/*
	 * Writes options for visjs to the output stream.
	 */
	public void buildOptions() throws IOException, SaltEmptyParameterException{
		if (outOptions == null){
			throw new SaltEmptyParameterException("A problem occurred while building options. Probably the option writer is not set.");
		}
		
			outOptions.write("{" + NEWLINE
					+ "nodes:{" + NEWLINE
					+ "shadow: true," + NEWLINE
					+ "shape: \"box\"" + NEWLINE
					+"}," + NEWLINE
					+"edges: {" + NEWLINE
					+"smooth: true," + NEWLINE
					+"arrows: {" + NEWLINE
					+"to: {" + NEWLINE
					+"enabled: true" + NEWLINE
					+"}" + NEWLINE
					+"}" + NEWLINE
					+"}," + NEWLINE
					+"layout: {" + NEWLINE
					+"hierarchical:{" + NEWLINE
					+"direction: directionInput.value" + NEWLINE
					+"}" + NEWLINE
					+"}," + NEWLINE
					+"physics: {" + NEWLINE
					+"hierarchicalRepulsion: {" + NEWLINE
					+"centralGravity: 0.05," + NEWLINE
					+"springLength: 0," + NEWLINE
					+"springConstant: 0.0007," + NEWLINE
					+"nodeDistance: 200," + NEWLINE
					+"damping: 0.04" + NEWLINE
					+"}," + NEWLINE
					+"maxVelocity: 27," + NEWLINE
					+"solver: 'hierarchicalRepulsion'," + NEWLINE
					+"timestep: 0.5," + NEWLINE
					+"stabilization: {" + NEWLINE
					+"iteration: 800" + NEWLINE
					+"}" + NEWLINE
					+"}" + NEWLINE
					+"}" + NEWLINE);
	}
		
		
	
	
	private int getMaxLevel(SDocument doc)
	{
		maxLevel = getMaxHighOfSDocGraph(doc) + 1;
		EList <SSpan> sSpans = doc.getSDocumentGraph().getSSpans();
		 if (sSpans != null && sSpans.size() != 0) 
		 {
			 maxLevel++;			 
		 }
		 return maxLevel;
	}
	
	
	 //traversing the graph in depth first top down mode beginning with its roots
	private  int  getMaxHighOfSDocGraph(SDocument doc)
	{
		doc.getSDocumentGraph().traverse(doc.getSDocumentGraph().getSRoots(), GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, TRAV_MODE_CALC_LEVEL, this);		
		if (maxHeight > (Integer.MAX_VALUE - 100)) throw new SaltException("The specified document cannot be visualized. It is too complex.");    
		else return (int) maxHeight;
		
	}
	
	
	@Override
	public void nodeReached(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode, SRelation sRelation,
														SNode fromNode, long order) 
	{
		
		if (sRelation!= null)
		{			
			if (traversalType == GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST)
			{				
				if (traversalId.equals(TRAV_MODE_CALC_LEVEL))
				{
				currHeight++;
				if (maxHeight < currHeight) maxHeight = currHeight;
				}					
			}		
		}	
	}

	
	
	@Override
	public void nodeLeft(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode, SRelation edge,
			SNode fromNode, long order) 
	{		
		
		if (edge!= null)
		{		
			if (traversalType == GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST)
			{				
				if (traversalId.equals(TRAV_MODE_CALC_LEVEL))
				{
				currHeight--;		
				}
			
				else if (traversalId.equals(TRAV_MODE_READ_NODES))
				{
				  if (currNode instanceof SToken) 
				  {
					  currHeightFromToken = 1;						  
					  // write SSpan-Nodes					  
					  if ((fromNode instanceof SSpan) && (!readRoots.contains(fromNode)))
					  {				  
						  try {
							writeJsonNode(fromNode, maxLevel - currHeightFromToken, filter);
						} catch (IOException e) {
							throw new SaltException("A problem occurred while building JSON objects.");
						}						
					      readRoots.add(fromNode);					
						  	
					  }
					
				  }
				  else 
				  {					  
					  currHeightFromToken++;				  
					  
					  if (currNode instanceof SStructure)
					  {						 
						  try {
							writeJsonNode(currNode, maxLevel - currHeightFromToken, filter);
						} catch (IOException e) {
							throw new SaltException("A problem occurred while building JSON objects.");
						}						 
						 
						 if (roots.contains(fromNode) && !readRoots.contains(fromNode))
						 {
							 try {
								writeJsonNode(fromNode, maxLevel - currHeightFromToken - 1, filter);
							} catch (IOException e) {
								throw new SaltException("A problem occurred while building JSON objects.");
							}							 
							 readRoots.add(fromNode);
						 }						  	
					  }				  
					  
					}
					 
			
				  if (!readRelations.contains(edge))
				  {					  
					  try {
						writeJsonEdge(fromNode, currNode, edge,filter );
					} catch (IOException e) {
						throw new SaltException("A problem occurred while building JSON objects.");
					}					  
					  readRelations.add(edge);
				  }			
				  
				}
			}			
		}		
	}

	@Override
	public boolean checkConstraint(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SRelation edge,
			SNode currNode, long order) 
	{
		if(edge instanceof SDominanceRelation || edge instanceof SSpanningRelation || edge instanceof SPointingRelation || edge == null)  return true;
		else return false;
		
	}
	
	
	public BufferedWriter getJsonNodes ()
	{
		return outNodes;
	}
	
	public BufferedWriter getJsonEdges()
	{
		return outEdges;
	}
	
	public BufferedWriter getOptions(){
		return outOptions;
	}

	
}
