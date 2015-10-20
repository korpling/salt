package org.corpus_tools.salt.util;

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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.stream.XMLStreamException;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.common.SDominanceRelation;
import org.corpus_tools.salt.common.SPointingRelation;
import org.corpus_tools.salt.common.SSpan;
import org.corpus_tools.salt.common.SSpanningRelation;
import org.corpus_tools.salt.common.SStructure;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.core.GraphTraverseHandler;
import org.corpus_tools.salt.core.SAnnotation;
import org.corpus_tools.salt.core.SGraph.GRAPH_TRAVERSE_TYPE;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.exceptions.SaltException;
import org.corpus_tools.salt.exceptions.SaltParameterException;
import org.corpus_tools.salt.exceptions.SaltResourceException;
import org.eclipse.emf.common.util.URI;
import org.json.JSONException;
import org.json.JSONWriter;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.json.*;
import org.eclipse.emf.common.util.EList;

/**
 * <p>
 * This class provides a possibility to create a html file, which visualizes a salt graph,
 * created from an {@link SDocument} or from an {@link org.eclipse.emf.common.util.URI} of a salt file, using the vis.js library.
 *
 * 
 * Also it can be used to get both nodes and relations of a salt document in JSON format 
 * as well as vis.js-options. 
 * Note, if no export filter used, all nodes and all relations but textual relations will be visualized.
 * </p>
 * 
 * <p>A simple way to use this class for writing the html file is shown in the following example code.</p>
 * 
 * <pre>
 * String inputSaltFile = "path_to_your_salt_file";  </br>
 * String outputFolder = "path_to_your_output_folder"; </br>
 * URI uri = URI.createFileURI(inputSaltFile);</br>
 *	VisJsVisualizer visJsVisualizer = new VisJsVisualizer(uri); </br>
 *	try { </br>
 *		 URI outputFileUri = URI.createFileURI(outputFolder);</br>
 *		 visJsVisualizer.visualize(outputFileUri, false); </br>
 *	} catch (IOException | XMLStreamException e) { </br>
 *		e.printStackTrace(); </br>
 *	}</br>
 *
 *</pre> 
 *
 *<p>The next listing shows how to get the nodes and the relations of an input salt file in JSON format by use of this class. 
 * For simplicity, the created JSON objects and the options for vis.js-visualization will be written to the standard output.
 *<pre>
 * URI uri = URI.createFileURI("path_to_the_input_salt_file");	
*	VisJsVisualizer VisJsVisualizer = new VisJsVisualizer(uri);
*	 	
*	VisJsVisualizer.setNodeWriter(System.out);
*	VisJsVisualizer.setEdgeWriter(System.out);
*	VisJsVisualizer.setOptionsWriter(System.out);
*	VisJsVisualizer.buildJSON();
*	try {
*		VisJsVisualizer.buildOptions();
*	} catch (IOException e1) {
*		e1.printStackTrace();
*	}
*		
*	BufferedWriter bw;
*				
*	try {
*		bw = VisJsVisualizer.getNodeWriter();
*		bw.newLine();
*		bw.flush();	
*		
*		bw = VisJsVisualizer.getEdgeWriter();		
*		bw.newLine();
*		bw.flush();	
*	
*		bw = VisJsVisualizer.getOptionsWriter();
*		bw.flush();
*		bw.close();
*			
*	} catch (IOException e) {
*		e.printStackTrace();
*	}		
 *</pre>
 *
 *
 *@author irina
 */

public class VisJsVisualizer implements GraphTraverseHandler{
		
	private  long maxHeight;
	private  int currHeight;
	private  int maxLevel;
	private  int currHeightFromToken;

	
	public  SDocument doc;
	private OutputStream jsonOutputStream;
	public  BufferedWriter jsonWriter;
	public  BufferedWriter nodeWriter;
	public  BufferedWriter edgeWriter;
	public  BufferedWriter optionsWriter;
	
	private  JSONWriter jsonWriterNodes;
	private  JSONWriter jsonWriterEdges;
	//private  JSONWriter jsonWriterCommon;
	
	private  XMLOutputFactory outputFactory;
	private  OutputStream os;
	private  XMLStreamWriter xmlWriter;
	
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
    
    private static final String VISJS_WIDTH = "1200px";
	private static final String VISJS_HEIGHT = "900px";
	
	private static final String TEXT_STYLE = "width:700px; font-size:14px; text-align: justify;";
	
	private final static String VIS_JS_SRC = "js/vis.min.js";
	private final static String VIS_CSS_SRC = "css/vis.min.css";
	
		
	private  int bufferSizeEdges;

	private static final String TRAV_MODE_CALC_LEVEL = "calcLevel";
	private static final String TRAV_MODE_READ_NODES = "readNodes";
	
	
	private final HashSet <SNode> readRoots;
	private final HashSet <SRelation> readRelations;
	private final List<SNode> roots;
	private int nGroupsId = 0;
	
	
	// JSON output
	private static final String JSON_ID = "id";
	private static final String JSON_LABEL = "label";
	private static final String JSON_COLOR = "color";
	private static final String JSON_X = "x";
	private static final String JSON_LEVEL = "level";
	private static final String JSON_GROUP = "group";
	
	private  int xPosition = 0;	
	private static final String TOK_COLOR_VALUE = "#CCFF99";
	
	
 
   
    private static final int JSON_EDGE_LINE_LENGTH = 60;    
    private static final String NEWLINE = System.lineSeparator();    
    private final ExportFilter exportFilter;
    
    private boolean writeNodeImmediately = false;
    
   // private static final String OUTPUT_FILE = "saltVisJs.html";	
    private static final String NODES_AND_EDGES_FILE = "saltNodesAndEdges.json";
    private static final String CSS_FOLDER_OUT = "css";
    private static final String JS_FOLDER_OUT = "js";
    private static final String JSON_FOLDER_OUT = "json";
    
    private static final String CSS_FILE = "vis.min.css";
    private static final String JS_FILE = "vis.min.js";
    private static final String JQUERY_FILE = "jquery.js";
    private static final String HTML_FILE = "saltVisJs.html";
    
        
    private static final String RESOURCE_FOLDER = System.getProperty("file.separator") + "visjs"; 
    
    private HashMap <String, Integer> spanClasses;
    private int maxSpanOffset = -1;
    private int nNodes = 0;
  
    													
    		 

    
  /**
   * Creates a new VisJsVisualizer instance for specified salt document.
   * 
   * @param doc an {@link SDocument}, which have to be visualized
   * 
   * @throws SaltParameterException if the doc is null 
   */
    public VisJsVisualizer(SDocument doc){
  	  this(doc, null);
    }
    
    /**
     * Creates a new VisJsVisualizer instance with specified export filter for specified salt document.
     * 
     * @param doc an SDocument, which have to be visualized
     * @param exportFilter an ExportFilter to exclude selected nodes and/or relations from the visualizing 
     * 
     * @throws SaltParameterException if the doc is null 
     */
    
    public VisJsVisualizer (SDocument doc, ExportFilter exportFilter){  
    	
    	if(doc == null) throw new SaltParameterException("doc", "VisJsVisualizer", this.getClass());
    
    	this.doc = doc;    	
    	roots = doc.getDocumentGraph().getRoots();	
    	List<SSpan>  sSpans = doc.getDocumentGraph().getSpans();	
    	if (sSpans != null && (sSpans.size() > 0))
    	{
    		nGroupsId += 1;
    	}	
    	List<SStructure>  sStructures = doc.getDocumentGraph().getStructures();
    	
    	if (sStructures != null && (sStructures.size() > 0))
    	{
    		nGroupsId += 2;
    	}
    	
    	readRoots = new HashSet <SNode>();
    	readRelations = new HashSet <SRelation>();       	
    	
    	long nEdges = doc.getDocumentGraph().getRelations().size();
    	if (nEdges > Math.floor(((double)Integer.MAX_VALUE/(double)JSON_EDGE_LINE_LENGTH)))
    	{
    		throw new SaltException("The specified document cannot be visualized. It contains too many edges.");    		
    	}
    	else
    	{
    		bufferSizeEdges = (int) (nEdges) * JSON_EDGE_LINE_LENGTH;	
    	}
    	
    	this.exportFilter = exportFilter;
    	spanClasses =new HashMap<String, Integer>();
    	
    }
    
    
    /**
     * Creates a new VisJsVisualizer instance for a salt file specified by the uri.
     * 
     * @param inputFileUri a hierarchical URI of a salt file, which have to be visualized. 
     * 		The constructor will create a new {@link SDocument} from this.
     * 
     * @throws SaltParameterException - if the inputFileUri is null 
     */
      public VisJsVisualizer(URI inputFileUri){
    	  this(inputFileUri, null);
      }
  	
     /**
      * Creates a new VisJsVisualizer instance with specified export filter for a salt file specified by the uri.
      * 
      * @param inputFileUri a hierarchical URI of a salt file, which have to be visualized. 
      * 			The constructor will create a new  {@link SDocument} from this.
      * @param exportFilter an ExportFilter to exclude selected nodes and/or relations from the visualizing
      * 
      * @throws SaltParameterException if the inputFileUri is null 
      * @throws SaltResourceException if a problem occurred while loading salt project from the inputFileUri
      */
      
      public VisJsVisualizer (URI inputFileUri, ExportFilter exportFilter){  
      	if(inputFileUri == null) throw new SaltParameterException("inputUri", "VisJsVisualizer", this.getClass());
       	
      	try{
      		this.doc= SaltFactory.createSDocument();	
          	doc.loadDocumentGraph(inputFileUri);
      	}catch (SaltResourceException e){
      		throw new SaltResourceException("A problem occurred while loading salt project from '" + inputFileUri + "'.", e);
      	}
      	
      	roots = doc.getDocumentGraph().getRoots();	
      	List<SSpan>  sSpans = doc.getDocumentGraph().getSpans();	
      	if (sSpans != null && (sSpans.size() > 0))
      	{
      		nGroupsId += 1;
      	}	
      	List<SStructure>  sStructures = doc.getDocumentGraph().getStructures();
      	
      	if (sStructures != null && (sStructures.size() > 0))
      	{
      		nGroupsId += 2;
      	}
      	
      	readRoots = new HashSet <SNode>();
      	readRelations = new HashSet <SRelation>();       	
      	
      	long nEdges = doc.getDocumentGraph().getRelations().size();
      	if (nEdges > Math.floor(((double)Integer.MAX_VALUE/(double)JSON_EDGE_LINE_LENGTH)))
      	{
      		throw new SaltException("The specified document cannot be visualized. It contains too many edges.");    		
      	}
      	else
      	{
      		bufferSizeEdges = (int) (nEdges) * JSON_EDGE_LINE_LENGTH;	
      	}
      	
      	this.exportFilter = exportFilter;
      	spanClasses =new HashMap<String, Integer>();
      	
      }
     
    /**
     * <p>
     * This method writes the html document, which visualizes the Salt document, specified by constructor.
     * The output folder structure will be created, if not yet exists and the output html file as well as the 
     * auxiliary files will be written.
     * </p>
     * 
     * The whole output structure will looks like following: </br>
     * <pre>
     * outputFolder </br>
     *  --> css </br>
     * 		-->vis.min.css </br>
     *  --> js </br>
     * 		-->vis.min.js </br> 
     *  --> saltVisJs.html </br> 
     * </pre>
     * 
     * @param outputFolderUri - a hierarchical URI that specifies the output folder path. Note, that the output folder have not necessarily to be existing.
     * @param loadJSON - a flag to predefine, whether the JSON-Objects must be load from a separate JSON-file (false recommended)  
     * 
     * @throws SaltParameterException if the outputFolderUri is null
     * @throws SaltResourceException if the output auxiliary files cannot have been created
     * @throws SaltException if the output folders cannot have been created or permission denied 
     * @throws SaltResourceException if a problem occurred while copying the auxiliary files  
     * @throws XMLStreamException if a problem occurred while writing the output html file
     * @throws IOException if a problem occurred while writing the output file
     */


public void visualize(URI outputFolderUri, boolean loadJSON) throws SaltParameterException,  SaltResourceException, SaltException,
															SaltResourceException, IOException, XMLStreamException{
			
		try {
			 File outputFolder = createOutputResources(outputFolderUri, loadJSON);	
			 writeNodeImmediately = true;
			 
			 if (loadJSON){
				 File jsonOutputFolder = new File(outputFolder+ System.getProperty("file.separator") + JSON_FOLDER_OUT);
				 if(!jsonOutputFolder.exists() || !jsonOutputFolder.isDirectory()) 
				 	{
					 throw new SaltException("Either the output folder cannot be created or permission denied.");
				 	}
				 
				 this.jsonOutputStream =new FileOutputStream(new File(jsonOutputFolder, NODES_AND_EDGES_FILE));	 
				 setJsonWriter(jsonOutputStream);
				 setNodeWriter(jsonOutputStream);
				 setEdgeWriter(jsonOutputStream);
				 try{
		        		writeJSON();
		        	}
		        	catch(IOException e){
		        		throw new SaltException("A problem occurred while writing JSON resources.");
		        	}    	
			 }
			 else{		    		
						writeHTML(outputFolder);		    		
		    	}		    	
				
				writeNodeImmediately = false;					 
		
			}
			catch (SaltParameterException e){
				throw new SaltParameterException("outputFileUri", "writeHTML", this.getClass());
			}
			catch (FileNotFoundException e) {
				throw new SaltResourceException("The output auxiliary files cannot be created.");
			}	
			catch (SecurityException e) {
			 throw new SaltException("Either the output folder cannot be created or permission denied.");
			}
			catch (IOException e) {
			 throw new SaltResourceException("A problem occurred while copying the vis-js ressource files");
			}	
	  
	}


   private void writeHTML(File outputFolder) throws XMLStreamException, IOException{
	 
			 int nodeDist = 0;
			
			this.os = new FileOutputStream(new File(outputFolder, HTML_FILE));
			this.outputFactory = XMLOutputFactory.newInstance();			
			this.xmlWriter = outputFactory.createXMLStreamWriter(os, "UTF-8");			
			setNodeWriter(os);
			setEdgeWriter(os);			
			
			xmlWriter.writeStartDocument("UTF-8", "1.0");
			xmlWriter.writeCharacters(NEWLINE);
			xmlWriter.writeStartElement(TAG_HTML);
			xmlWriter.writeCharacters(NEWLINE);
			
			xmlWriter.writeStartElement(TAG_HEAD);
			xmlWriter.writeCharacters(NEWLINE);
			
			xmlWriter.writeStartElement(TAG_TITLE);
			xmlWriter.writeCharacters("Salt Document Tree");
			xmlWriter.writeEndElement();
			xmlWriter.writeCharacters(NEWLINE);
			
			xmlWriter.writeStartElement(TAG_STYLE);
			xmlWriter.writeAttribute(ATT_TYPE, "text/css");
			xmlWriter.writeCharacters("body {" + NEWLINE 
					+ "font: 10pt sans;" + NEWLINE 
					+ "}" + NEWLINE 
					+ "#mynetwork {" + NEWLINE 
					+ "width: " + VISJS_WIDTH +";" + NEWLINE 
					+ "height: " + VISJS_HEIGHT + ";" + NEWLINE 
					+ "border: 1px solid lightgray;" + NEWLINE 
					+ "}");
			xmlWriter.writeEndElement();
			xmlWriter.writeCharacters(NEWLINE);
			
			xmlWriter.writeStartElement(TAG_SCRIPT);
			xmlWriter.writeAttribute(ATT_SRC,VIS_JS_SRC);
			xmlWriter.writeAttribute(ATT_TYPE, "text/javascript");			
			xmlWriter.writeCharacters(NEWLINE);
			xmlWriter.writeEndElement();
			xmlWriter.writeCharacters(NEWLINE);
			
			xmlWriter.writeEmptyElement(TAG_LINK);
			xmlWriter.writeAttribute(ATT_HREF, VIS_CSS_SRC);
			xmlWriter.writeAttribute(ATT_REL,"stylesheet");
			xmlWriter.writeAttribute(ATT_TYPE, "text/css");
			xmlWriter.writeCharacters(NEWLINE);
			
			xmlWriter.writeStartElement(TAG_SCRIPT);
			xmlWriter.writeAttribute(ATT_TYPE, "text/javascript");
			

			
			xmlWriter.writeCharacters(NEWLINE 
					+ "function start(){" + NEWLINE
					+ "loadSaltObjectAndDraw();" + NEWLINE
					+ "}" + NEWLINE
					+ "var nodesJson = [];" + NEWLINE
					+ "var edgesJson = [];" + NEWLINE
					+ "var network = null;" + NEWLINE					
					+ "function loadSaltObjectAndDraw() {" + NEWLINE
					+ "var nodesJson = " + NEWLINE);
			xmlWriter.flush();
			
			buildJSON();	
			
				
			if (nNodes < 20){
			nodeDist = 100;
			} else if (nNodes >=20 && nNodes < 100){
			nodeDist = 150;
			} else if (nNodes >= 100 && nNodes < 400) {
			nodeDist = 200;
			} else {
				nodeDist = 400;
			};
			
			// write nodes as array	
			nodeWriter.flush();
		
		
			xmlWriter.writeCharacters(";" + NEWLINE);
			xmlWriter.writeCharacters("var edgesJson = " + NEWLINE);
			xmlWriter.flush();
			
			// write edges as array
			edgeWriter.flush();
		
			xmlWriter.writeCharacters(";" + NEWLINE);
			
			xmlWriter.writeCharacters("var nodeDist =" +  nodeDist + ";" + NEWLINE);
			
			
			xmlWriter.writeCharacters("draw(nodesJson, edgesJson, nodeDist);" + NEWLINE
			+ "}" + NEWLINE
			+ "var directionInput = document.getElementById(\"direction\");" + NEWLINE
			+ "function destroy() {" + NEWLINE
			+ "if (network !== null) {" + NEWLINE
			+ "network.destroy();" + NEWLINE
			+ "network = null;" + NEWLINE
			+ "}" + NEWLINE
			+ "}" + NEWLINE
			+ NEWLINE
			+ "function draw(nodesJson, edgesJson, nodeDist) {" + NEWLINE
			+ "destroy();" + NEWLINE
			+ "var connectionCount = [];" + NEWLINE
			+ "var nodes = [];" + NEWLINE
			+ "var edges = [];" + NEWLINE
			+ NEWLINE
			+ "nodes = new vis.DataSet(nodesJson);" + NEWLINE
			+ "edges = new vis.DataSet(edgesJson);" + NEWLINE
			+ "var container = document.getElementById('mynetwork');" + NEWLINE
			+ "var data = {" + NEWLINE
			+ "nodes: nodes," + NEWLINE
			+ "edges: edges" + NEWLINE
			+ "};" + NEWLINE
			+ "var options = {" + NEWLINE
			+ "nodes:{" + NEWLINE
			+ "shape: \"box\"" + NEWLINE
			+ "}," + NEWLINE
			+ "edges: {" + NEWLINE
			+ "smooth: true," + NEWLINE
			+ "arrows: {" + NEWLINE
			+ "to: {" + NEWLINE
			+ "enabled: true" + NEWLINE
			+ "}" + NEWLINE
			+ "}" + NEWLINE
			+ "}," + NEWLINE
			+ "layout: {" + NEWLINE
			+ "hierarchical:{" + NEWLINE
			+ "direction: directionInput.value" + NEWLINE
			+ "}" + NEWLINE
			+ "}," + NEWLINE
			+ "physics: {" + NEWLINE
			+ "hierarchicalRepulsion: {" + NEWLINE
			+ "centralGravity: 0.05," + NEWLINE
			+ "springLength: 100," + NEWLINE
			+ "springConstant: 0.0007," + NEWLINE
			+ "nodeDistance: nodeDist," + NEWLINE
			+ "damping: 0.04" + NEWLINE
			+ "}," + NEWLINE
			+ "maxVelocity: 27," + NEWLINE
			+ "solver: 'hierarchicalRepulsion'," + NEWLINE
			+ "timestep: 0.5," + NEWLINE
			+ "stabilization: {" + NEWLINE
			+ "iterations: 800" + NEWLINE
			+ "}" + NEWLINE
			+ "}" + NEWLINE
			+ "}" + NEWLINE
			+ ";" + NEWLINE
			+ "network = new vis.Network(container, data, options);" + NEWLINE
			+ "network.on('select', function(params) {" + NEWLINE
			+ "document.getElementById('selection').innerHTML = 'Selection: ' + params.nodes;" + NEWLINE
			+ "});" + NEWLINE
			+ "}" + NEWLINE);
			//script
			xmlWriter.writeEndElement();
			xmlWriter.writeCharacters(NEWLINE);
			
			//head
			xmlWriter.writeEndElement();
			xmlWriter.writeCharacters(NEWLINE);
			
			xmlWriter.writeStartElement(TAG_BODY);
			xmlWriter.writeAttribute("onload", "start();");
			xmlWriter.writeCharacters(NEWLINE);
			
			xmlWriter.writeStartElement(TAG_H2);
			xmlWriter.writeCharacters("Salt Document Tree");
			xmlWriter.writeEndElement();
			xmlWriter.writeCharacters(NEWLINE);
			
			xmlWriter.writeStartElement(TAG_DIV);
			xmlWriter.writeAttribute(ATT_STYLE,TEXT_STYLE);
			xmlWriter.writeEndElement();
			xmlWriter.writeCharacters(NEWLINE);
			
			xmlWriter.writeStartElement("p");
			
			xmlWriter.writeEmptyElement(TAG_INPUT);
			xmlWriter.writeAttribute(ATT_TYPE,"button");
			xmlWriter.writeAttribute(ATT_ID, "btn-UD");
			xmlWriter.writeAttribute(ATT_VALUE, "Up-Down");
			xmlWriter.writeCharacters(NEWLINE);
			
			xmlWriter.writeEmptyElement(TAG_INPUT);
			xmlWriter.writeAttribute(ATT_TYPE,"button");
			xmlWriter.writeAttribute(ATT_ID, "btn-DU");
			xmlWriter.writeAttribute(ATT_VALUE, "Down-Up");
			xmlWriter.writeCharacters(NEWLINE);
			
			xmlWriter.writeEmptyElement(TAG_INPUT);
			xmlWriter.writeAttribute(ATT_TYPE,"button");
			xmlWriter.writeAttribute(ATT_ID, "btn-LR");
			xmlWriter.writeAttribute("value", "Left-Right");
			xmlWriter.writeCharacters(NEWLINE);
			
			xmlWriter.writeEmptyElement(TAG_INPUT);
			xmlWriter.writeAttribute(ATT_TYPE,"button");
			xmlWriter.writeAttribute(ATT_ID, "btn-RL");
			xmlWriter.writeAttribute(ATT_VALUE, "Right-Left");
			xmlWriter.writeCharacters(NEWLINE);
			
			xmlWriter.writeEmptyElement(TAG_INPUT);
			xmlWriter.writeAttribute(ATT_TYPE,"hidden");
			//TODO check the apostrophes
			xmlWriter.writeAttribute(ATT_ID, "direction");
			xmlWriter.writeAttribute(ATT_VALUE, "UD");
			xmlWriter.writeCharacters(NEWLINE);
		
			
			//p
			xmlWriter.writeEndElement();
			xmlWriter.writeCharacters(NEWLINE);
			
			xmlWriter.writeStartElement(TAG_DIV);
			xmlWriter.writeAttribute(ATT_ID, "mynetwork");
			xmlWriter.writeCharacters(NEWLINE);
			xmlWriter.writeEndElement();
			xmlWriter.writeCharacters(NEWLINE);
			
			xmlWriter.writeStartElement(TAG_P);
			xmlWriter.writeAttribute(ATT_ID, "selection");
			xmlWriter.writeCharacters(NEWLINE);
			xmlWriter.writeEndElement();
			xmlWriter.writeCharacters(NEWLINE);
			
			
			xmlWriter.writeStartElement(TAG_SCRIPT);
			xmlWriter.writeAttribute(ATT_LANG, "JavaScript");
			xmlWriter.writeCharacters(NEWLINE);
			xmlWriter.writeCharacters("var directionInput = document.getElementById(\"direction\");" + NEWLINE
					+ "var btnUD = document.getElementById(\"btn-UD\");" + NEWLINE
					+ "btnUD.onclick = function() {" + NEWLINE
					+ "directionInput.value = \"UD\";" + NEWLINE
					+ "start();" + NEWLINE
					+ "};" + NEWLINE
					+ "var btnDU = document.getElementById(\"btn-DU\");" + NEWLINE
					+ "btnDU.onclick = function() {" + NEWLINE
					+ "directionInput.value = \"DU\";" + NEWLINE
					+ "start();" + NEWLINE
					+ "};" + NEWLINE
					+ "var btnLR = document.getElementById(\"btn-LR\");" + NEWLINE
					+ "btnLR.onclick = function() {" + NEWLINE
					+ "directionInput.value = \"LR\";" + NEWLINE
					+ "start();" + NEWLINE
					+ "};" + NEWLINE
					+ "var btnRL = document.getElementById(\"btn-RL\");" + NEWLINE
					+ "btnRL.onclick = function() {" + NEWLINE
					+ "directionInput.value = \"RL\";" + NEWLINE
					+ "start();" + NEWLINE
					+ "};" + NEWLINE);
			xmlWriter.writeEndElement();
			xmlWriter.writeCharacters(NEWLINE);			
			
			//body
			xmlWriter.writeEndElement();
			xmlWriter.writeCharacters(NEWLINE);	
			
			
			//html
			xmlWriter.writeEndElement();
			xmlWriter.writeCharacters(NEWLINE);	
				
		   
			xmlWriter.writeEndDocument();
			xmlWriter.flush();
			xmlWriter.close();		
			nodeWriter.close();
			edgeWriter.close();			
	   
   }

/*
 * Organizes the output folder structure and invokes the method for copying of auxiliary files. 
 */
  
	private File createOutputResources(URI outputFileUri, boolean loadJSON) 
			throws SaltParameterException, SecurityException, FileNotFoundException, IOException{
		  File outputFolder = null;
		  if (outputFileUri == null){
			  throw new SaltParameterException("Cannot store salt-vis, because the passed output uri is empty. ");			
		  }
		  outputFolder = new File (outputFileUri.path());
		 if(!outputFolder.exists()){
			 outputFolder.mkdirs();
		 }
		 
		  File cssFolderOut = new File(outputFolder, CSS_FOLDER_OUT);
		  if(!cssFolderOut.exists()){
			  cssFolderOut.mkdir();
		  }
		  
		  File jsFolderOut = new File(outputFolder, JS_FOLDER_OUT);
		  if(!jsFolderOut.exists()){
			  jsFolderOut.mkdir();
		  }
		  
		  if(loadJSON){
			  File jsonFolderOut = new File(outputFolder, JSON_FOLDER_OUT);
			  if(!jsonFolderOut.exists()){
				  jsonFolderOut.mkdir();
			  }
		  }
		 
		  
		  copyResourceFile(CSS_FILE, outputFolder.getPath(), CSS_FOLDER_OUT, CSS_FILE);
		  copyResourceFile(JS_FILE, outputFolder.getPath(), JS_FOLDER_OUT, JS_FILE);
		  if(loadJSON){
			  copyResourceFile(JQUERY_FILE, outputFolder.getPath(), JS_FOLDER_OUT, JQUERY_FILE); 
			  copyResourceFile(HTML_FILE, outputFolder.getPath(), null, HTML_FILE);	     
		  }
		  
		 
		  return outputFolder;
	}
	
	
/*
 * Copies the specified auxiliary file to the according output subfolder.
 */
	private void copyResourceFile (String inFile, String outputFolder, String outSubFolder, String outFile) 
					throws FileNotFoundException, IOException{
	
		InputStream inputStream = getClass( ).getResourceAsStream(RESOURCE_FOLDER 
				  + System.getProperty("file.separator") 
				  + inFile);		  
		  BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		  BufferedWriter writer;
		  
		  if (outSubFolder != null){
			  writer = new BufferedWriter ( new OutputStreamWriter(new FileOutputStream(new File (outputFolder
					  + System.getProperty("file.separator")
					  + outSubFolder 
					  + System.getProperty("file.separator")
					  + outFile))));
			  }
		  else{
			  writer = new BufferedWriter ( new OutputStreamWriter(new FileOutputStream(new File (outputFolder
					  + System.getProperty("file.separator")
					  + outFile))));
		  }	
		  
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
	
	public void setJsonWriter (OutputStream os)
	{
		this.jsonWriter = new BufferedWriter(new OutputStreamWriter(os));		


	}
	
	/**
	 * Creates a new buffered writer with specified output stream. 
	 * It will contain the nodes in JSON format after invoking of the {@link #buildJSON()} method.
	 * 
	 * @param os OutputStream associated to the node writer. 
	 */
	public void setNodeWriter (OutputStream os)
	{
		this.nodeWriter = new BufferedWriter(new OutputStreamWriter(os));		
		this.jsonWriterNodes = new JSONWriter(nodeWriter);
	}
	
	/**
	 *  Creates a new buffered writer with specified output stream. 
	 *  It will contain the edges in JSON format after invoking of the {@link #buildJSON()} method.
	 * 
	 * @param os OutputStream associated to the edge writer
	 */

	public void setEdgeWriter (OutputStream os)
	{
		this.edgeWriter = new BufferedWriter (new OutputStreamWriter(os), bufferSizeEdges);	
		this.jsonWriterEdges = new JSONWriter(edgeWriter);
	}

	/**
	 *  Creates a new buffered writer with specified output stream. 
	 *  It will contain the options after invoking of the {@link #buildOptions()} method.
	 * 
	 * @param os OutputStream associated to the options writer
	 */
	public void setOptionsWriter (OutputStream os){
		this.optionsWriter = new BufferedWriter(new OutputStreamWriter(os));		
		
	}
	   
	private void writeJSON () throws IOException {	
			jsonWriter.write("{");
			jsonWriter.newLine();
			jsonWriter.write("\"nodes\":");
			jsonWriter.newLine();
			jsonWriter.flush();
			
			buildJSON();
			
			nodeWriter.flush();		
			
			jsonWriter.write(",");
			jsonWriter.newLine();
			jsonWriter.write("\"edges\":");
			jsonWriter.newLine();
			jsonWriter.flush();
			
			edgeWriter.flush();		
			
			jsonWriter.newLine();
			jsonWriter.write("}");
			jsonWriter.flush();
			jsonWriter.close();
			
			nodeWriter.close();
			edgeWriter.close();
		
	}
	
	
	/**
	 * 
	 * By invoking of this method the graph of the salt document specified by the constructor will be traversed. 
	 * Both the nodeWriter and the edgeWriter write nodes and relations 
	 * of this graph respective to the associated output streams.
	 * 
	 * @throws SaltException if a problem occurred while building JSON objects
	 * @throws SaltParameterException if the node writer and/or the edge writer not set
	 */
	public void buildJSON () throws SaltException, SaltParameterException{		
	maxLevel = getMaxLevel(doc);

	doc.getDocumentGraph().sortTokenByText();	  		 
	 List <SToken> sTokens = doc.getDocumentGraph().getTokens();
	
	 if(nodeWriter == null || jsonWriterNodes == null){
		 throw new SaltParameterException("A problem occurred while building JSON objects. Probably the node writer is not set.");
	 }
	 if(edgeWriter == null || jsonWriterEdges == null){
		 throw new SaltParameterException("A problem occurred while building JSON objects. Probably the edge writer is not set.");
	 }
	 
	 try{
	
	//create node array
	jsonWriterNodes.array();
	// write tokens
	 for (SToken token : sTokens){			
			writeJsonNode(token, maxLevel, exportFilter);
			nNodes++;

	 }
	
	 //create edge array
	 jsonWriterEdges.array();
	 
	 // traverse the document tree in order to write remained nodes and edges
	 doc.getDocumentGraph().traverse(doc.getDocumentGraph().getRoots(), GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, 
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
	
	
	private void writeJsonNode (SNode node, long levelValue, ExportFilter filter) throws IOException
	{
		if (filter == null || !filter.excludeNode(node))	
		{
		 String idValue = node.getPath().fragment();
		 String idLabel = "id=" + idValue;	
		 String allLabels = idLabel;
			 
		 jsonWriterNodes.object();
		 jsonWriterNodes.key(JSON_ID);		 
		 jsonWriterNodes.value(idValue);
		 jsonWriterNodes.key(JSON_LABEL);
		 
	
		   Set<SAnnotation> sAnnotations = node.getAnnotations();
		   if (sAnnotations.size() > 0)
		   {		
			   allLabels += "" + NEWLINE;
			   
			   int i= 1;
			   for (SAnnotation annotation : sAnnotations) 
			   {
				   allLabels += (annotation.getName() + "=" + annotation.getValue().toString());
				   i++;
				   
				   if (i < sAnnotations.size()-1){
					   allLabels+= NEWLINE;
				   }
			   }
		   }
		   
		   if (node instanceof SToken)
		   {
			   String text = doc.getDocumentGraph().getText(node);
				  if (text != null && !text.isEmpty())
				  {
					  allLabels+= NEWLINE;			
					  allLabels += doc.getDocumentGraph().getText(node);
				  }
		   } 
		  
		   				
		 jsonWriterNodes.value(allLabels);	
		 if (node instanceof SToken)
		 {
			 jsonWriterNodes.key(JSON_COLOR);
			 jsonWriterNodes.value(TOK_COLOR_VALUE);
			 jsonWriterNodes.key(JSON_X);
			 jsonWriterNodes.value(++xPosition*100);
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
		nodeWriter.newLine();	
		
		if(writeNodeImmediately) nodeWriter.flush();
		
		}
}
		 
	private void writeJsonEdge (SNode fromNode, SNode toNode, SRelation relation, ExportFilter filter) throws IOException
	{
			  if(filter == null || !filter.excludeRelation(relation))
			  {
			  jsonWriterEdges.object();
			  jsonWriterEdges.key("from");
			  jsonWriterEdges.value(fromNode.getPath().fragment());
			  jsonWriterEdges.key("to");
			  jsonWriterEdges.value(toNode.getPath().fragment());
			
			//  jsonWriterEdges.value(relation.getPath().fragment());
			  Set<SAnnotation> sAnnotations = relation.getAnnotations();
			  if (sAnnotations.size() > 0)
			   {		
				   String allLabels = "";
				   
				   int i= 1;
				   for (SAnnotation annotation : sAnnotations) 
				   {
					   allLabels += (annotation.getName() + "=" + annotation.getValue().toString());
					   i++;
					   
					   if (i < sAnnotations.size()-1){
						   allLabels+= NEWLINE;
					   }
				   }
				   
				   jsonWriterEdges.key("label");
				   jsonWriterEdges.value(allLabels);
			   }
			 
			  jsonWriterEdges.endObject();
			  
			  
			  edgeWriter.newLine();
			  }
	}
	
	/**
	 * The invoking of this method induces the optionsWriter to write the options for the vis.js to the associated output stream. 
	 */
	public void buildOptions() throws IOException, SaltParameterException{
		if (optionsWriter == null){
			throw new SaltParameterException("A problem occurred while building options. Probably the option writer is not set.");
		}
		
			optionsWriter.write("{" + NEWLINE
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
					+"iterations: 800" + NEWLINE
					+"}" + NEWLINE
					+"}" + NEWLINE
					+"}" + NEWLINE);
	}
	
	/**
	 * Returns the nodeWriter.
	 * 
	 * @return
	 */
	public BufferedWriter getNodeWriter ()
	{
		return nodeWriter;
	}
	
	/**
	 * Returns the edgeWriter.
	 * 
	 * @return
	 */
	public BufferedWriter getEdgeWriter()
	{
		return edgeWriter;
	}
	
	/**
	 * Returns the optionsWriter.
	 * 
	 * @return
	 */
	public BufferedWriter getOptionsWriter(){
		return optionsWriter;
	}
		
		
	
	/*
	 *  Determine the max. level for JSON node objects.
	 */
	private int getMaxLevel(SDocument doc)
	{
		maxLevel = getMaxHeightOfSDocGraph(doc) + 1;
		int nSpanClasses = spanClasses.size();
		
		 maxLevel += nSpanClasses;
		 return maxLevel;
	}
	
	
	 //traverse the graph in depth first top down mode beginning with its roots and calculate the max. height of the salt graph
	private  int  getMaxHeightOfSDocGraph(SDocument doc)
	{
		doc.getDocumentGraph().traverse(doc.getDocumentGraph().getRoots(), GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, TRAV_MODE_CALC_LEVEL, this);		
		if (maxHeight > (Integer.MAX_VALUE - 100)) throw new SaltException("The specified document cannot be visualized. It is too complex.");    
		else return (int) maxHeight;
		
	}
	
	/**
	 * Implements the nodeReached method of the {@link SGraphTraverseHandler} interface.
	 */
	@Override
	public void nodeReached(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode, SRelation sRelation,
														SNode fromNode, long order) 
	{
		if (traversalType == GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST)
		{				
			if (traversalId.equals(TRAV_MODE_CALC_LEVEL))
			{
			
				if (sRelation!= null)
				{			
						currHeight++;
						if (maxHeight < currHeight) maxHeight = currHeight;

				}	
			
				  if ((currNode instanceof SSpan))
				  {
					  String annClass = "";
					  
					  Set<SAnnotation> sAnnotations = currNode.getAnnotations();
					   if (sAnnotations.size() > 0)
					   {	
						   // use the first annotation
						   annClass = sAnnotations.iterator().next().getName();					   
					   }
				 
					  if (!spanClasses.containsKey(annClass)) spanClasses.put(annClass, -1);				  
				  }
			
			}
		}
		
	}

	
	/**
	 * Implements the nodeLeft method of the {@link SGraphTraverseHandler} interface.
	 */
	@Override
	public void nodeLeft(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode, SRelation edge,
			SNode fromNode, long order) 
	{		
		//TODO calculate new level, depending on amount of different span classes
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
						  String annotation = "";
						  Set<SAnnotation>  annotations = fromNode.getAnnotations();
						  if (annotations.size() > 0){
							  annotation = annotations.iterator().next().getName();
						  }						  
						  
						  int spanOffset = spanClasses.get(annotation);						  
						  						  
						  if(spanOffset == -1){
							  maxSpanOffset = Math.max(spanOffset, maxSpanOffset) + 1;
							  spanClasses.put(annotation, maxSpanOffset);
						  }
						  try {
							writeJsonNode(fromNode, maxLevel - currHeightFromToken - maxSpanOffset, exportFilter);
							nNodes++;
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
							writeJsonNode(currNode, maxLevel - currHeightFromToken - spanClasses.size(), exportFilter);
							nNodes++;
						} catch (IOException e) {
							throw new SaltException("A problem occurred while building JSON objects.");
						}						 
						 
						 if (roots.contains(fromNode) && !readRoots.contains(fromNode))
						 {
							 try {
								writeJsonNode(fromNode, maxLevel - currHeightFromToken - spanClasses.size() - 1, exportFilter);
								nNodes++;
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
						writeJsonEdge(fromNode, currNode, edge,exportFilter );
					} catch (IOException e) {
						throw new SaltException("A problem occurred while building JSON objects.");
					}					  
					  readRelations.add(edge);
				  }			
				  
				}
			}			
		}		
	}

	/**
	 * Implements the checkConstraint method of the {@link SGraphTraverseHandler} interface.
	 */
	@Override
	public boolean checkConstraint(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SRelation edge,
			SNode currNode, long order) 
	{
		if(edge instanceof SDominanceRelation || edge instanceof SSpanningRelation || edge instanceof SPointingRelation || edge == null)  return true;
		else return false;
		
	}
	
	

	
}
