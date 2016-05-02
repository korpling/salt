package org.corpus_tools.salt.util;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
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
import javax.xml.stream.XMLStreamWriter;


/**
 * <p>
 * This class provides a possibility to create a html file, which visualizes a salt graph,
 * created from an {@link SDocument} or from an {@link org.eclipse.emf.common.util.URI} of a salt file, using the vis.js library.
 *
 * 
 * Also it can be used to get both nodes and relations of a salt document in JSON format.
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
 * For simplicity, the created JSON objects will be written to the standard output.
 *<pre>
 * URI uri = URI.createFileURI("path_to_the_input_salt_file");	
*	VisJsVisualizer VisJsVisualizer = new VisJsVisualizer(uri);
*	 	
*	VisJsVisualizer.setNodeWriter(System.out);
*	VisJsVisualizer.setEdgeWriter(System.out);
*	VisJsVisualizer.buildJSON();
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
	public String docId;
	private OutputStream jsonOutputStream;
	public  BufferedWriter jsonWriter;
	public  BufferedWriter nodeWriter;
	public  BufferedWriter edgeWriter;
	public  BufferedWriter optionWriter;

	
	private  JSONWriter jsonWriterNodes;
	private  JSONWriter jsonWriterEdges;

	
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
    private static final String ATT_CLASS = "class";
    
  
	
	private static final String TEXT_STYLE = "width:700px; font-size:14px; text-align: justify;";
	
	
	
		
	private  int bufferSizeEdges;

	private static final String TRAV_MODE_CALC_LEVEL = "calcLevel";
	private static final String TRAV_MODE_READ_NODES = "readNodes";
	
	
	private final HashSet <SNode> readSpanNodes;
	private final HashSet <SNode> readStructNodes;
	private final HashSet <SRelation> readRelations;
	private final List<SNode> roots;
	private Map<SNode, Integer> rootToMinLevel;
	
	/*
	 * identifies, which kinds of nodes (unless token nodes) the graph possesses
	 * 3 = spanning nodes and structure nodes
	 * 2 = structure nodes
	 * 1 = spanning nodes
	 * 0 = neither spanning nodes nor structure nodes
	 */
	private int nGroupsId = 0;
	
	
	// JSON output
	private static final String JSON_ID = "id";
	private static final String JSON_LABEL = "label";
	private static final String JSON_COLOR = "color";
	private static final String JSON_X = "x";
	private static final String JSON_LEVEL = "level";
	private static final String JSON_GROUP = "group";
	private static final String JSON_PHYSICS = "physics";
	private static final String JSON_SMOOTH  = "smooth";
	private static final String JSON_TYPE  = "type";
	private static final String JSON_ROUNDNESS = "roundness";
	private static final String JSON_WIDTH  = "width";
	private static final String JSON_FONT  = "font";
	private static final String JSON_ALIGN  = "align";
	
	
	
	private  int xPosition = 0;	
	private  int nTokens = 0;	
	private  static final int NODE_DIST = 150; 
	private static final String TOK_COLOR_VALUE = "#CCFF99";
	private static final String SPAN_COLOR_VALUE = "#A9D0F5";
	private static final String STRUCTURE_COLOR_VALUE = "#FFCC00";
	private static final String ALIGN = "left";	
	
 
   
    private static final int JSON_EDGE_LINE_LENGTH = 60;    
    private static final String NEWLINE = System.lineSeparator();    
    private final ExportFilter exportFilter;
    
    private boolean writeNodeImmediately = false;
    
    public static final String NODES_AND_EDGES_FILE = "saltNodesAndEdges.json";
    public static final String CSS_FOLDER_OUT = "css";
    public static final String IMG_FOLDER_OUT = CSS_FOLDER_OUT + System.getProperty("file.separator") + "img" + System.getProperty("file.separator") + "network";
    public static final String JS_FOLDER_OUT = "js";
    public static final String JSON_FOLDER_OUT = "json";
    
    public static final String CSS_FILE = "vis.min.css";
    public static final String JS_FILE = "vis.min.js";
    public static final String JQUERY_FILE = "jquery.js";
    public static final String HTML_FILE = "saltVisJs.html";
    
	
	
	private final static String JQUERY_SRC = JS_FOLDER_OUT + System.getProperty("file.separator") + JQUERY_FILE;
	private final static String VIS_JS_SRC = JS_FOLDER_OUT + System.getProperty("file.separator") + JS_FILE;
	private final static String VIS_CSS_SRC = CSS_FOLDER_OUT + System.getProperty("file.separator") + CSS_FILE;    
        
    private static final String RESOURCE_FOLDER = System.getProperty("file.separator") + "visjs"; 
    private static final String RESOURCE_FOLDER_IMG_NETWORK = "visjs"  + System.getProperty("file.separator")+ "img" + System.getProperty("file.separator")  + "network";
    
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
    	docId = doc.getId();
    	roots = doc.getDocumentGraph().getRoots();	    
    	rootToMinLevel = new HashMap<SNode, Integer>();
    	readSpanNodes = new HashSet <SNode>();
    	readStructNodes = new HashSet <SNode>();
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
      * @param exportFilter an ExportFilter to exclude selected nodes and/or relations from the visualization
      * 
      * @throws SaltParameterException if the inputFileUri is null 
      * @throws SaltResourceException if a problem occurred while loading salt project from the inputFileUri
      */
      
      public VisJsVisualizer (URI inputFileUri, ExportFilter exportFilter){  
      	if(inputFileUri == null) throw new SaltParameterException("inputUri", "VisJsVisualizer", this.getClass());
       	
      	try{
      		this.doc= SaltFactory.createSDocument();	
          	doc.loadDocumentGraph(inputFileUri);
          	docId = doc.getId();
      	}catch (SaltResourceException e){
      		throw new SaltResourceException("A problem occurred while loading salt project from '" + inputFileUri + "'.", e);
      	}
      	
      	roots = doc.getDocumentGraph().getRoots();	  
      	rootToMinLevel = new HashMap<SNode, Integer>();
      	readSpanNodes = new HashSet <SNode>();
      	readStructNodes = new HashSet <SNode>();
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
     * The output folder structure will be created, if not yet exists. The output html file as well as the 
     * auxiliary files will be written.
     * </p>
     * 
     * The whole output structure will look like following: </br>
     * <pre>
     * outputFolder </br>
     *  --> css </br>
     * 		-->vis.min.css </br>
     *  --> js </br>
     * 		-->vis.min.js </br> 
     * 		-->jquery.js  </br>
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
		        	}catch(SaltParameterException e){
						 throw new 	SaltParameterException(e.getMessage());
					}catch(SaltException e){
					 throw new 	SaltException(e.getMessage());
					}    	
				 }
				 else{		
					 try{
						 writeHTML(outputFolder);		    
					 }catch(SaltParameterException e){
						 throw new 	SaltParameterException(e.getMessage());
					}catch(SaltException e){
					 throw new 	SaltException(e.getMessage());
					}    										
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
			 int sprLength = 100;
			 double sprConstant = 0.0;
			
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
			xmlWriter.writeCharacters(NEWLINE);
			xmlWriter.writeCharacters("body {" + NEWLINE 
					+ "font: 10pt sans;" + NEWLINE
					+ "}" + NEWLINE
					+ "#mynetwork {" + NEWLINE
					+ "height: 90%;" + NEWLINE
					+ "width: 90%;" + NEWLINE
					+ "border: 1px solid lightgray; " + NEWLINE
					+ "text-align: center;" + NEWLINE
   					+ "}" + NEWLINE
   					+ "#loadingBar {" + NEWLINE
   					+ "position:absolute;" + NEWLINE
   					+ "top:0px;" + NEWLINE
		            + "left:0px;" + NEWLINE
		            + "width: 0px;" + NEWLINE
		            + "height: 0px;" + NEWLINE
		            + "background-color:rgba(200,200,200,0.8);" + NEWLINE
		            + "-webkit-transition: all 0.5s ease;" + NEWLINE
		            + "-moz-transition: all 0.5s ease;" + NEWLINE
		            + "-ms-transition: all 0.5s ease;" + NEWLINE
		            + "-o-transition: all 0.5s ease;" + NEWLINE
		            + "transition: all 0.5s ease;" + NEWLINE
		            + "opacity:1;" + NEWLINE
		        	+ "}" + NEWLINE
			        + "#wrapper {" + NEWLINE
			        + "position:absolute;" + NEWLINE    
			        + "width: 1200px;"  + NEWLINE 
					+ "height: 90%;"  + NEWLINE 
			        + "}" + NEWLINE	        
			        + "#text {" + NEWLINE
			        + "position:absolute;" + NEWLINE
		            + "top:8px;" + NEWLINE
		            + "left:530px;" + NEWLINE
		            + "width:30px;" + NEWLINE
		            + "height:50px;" + NEWLINE
		            + "margin:auto auto auto auto;" + NEWLINE
		            + "font-size:16px;" + NEWLINE
		            + "color: #000000;" + NEWLINE
			        + "}" + NEWLINE
			        + "div.outerBorder {" + NEWLINE
		            + "position:relative;" + NEWLINE
		            + "top:400px;" + NEWLINE
		            + "width:600px;" + NEWLINE
		            + "height:44px;" + NEWLINE
		            + "margin:auto auto auto auto;" + NEWLINE
		            + "border:8px solid rgba(0,0,0,0.1);" + NEWLINE
		            + "background: rgb(252,252,252); /* Old browsers */" + NEWLINE
		            + "background: -moz-linear-gradient(top,  rgba(252,252,252,1) 0%, rgba(237,237,237,1) 100%); /* FF3.6+ */" + NEWLINE
		            + "background: -webkit-gradient(linear, left top, left bottom, color-stop(0%,rgba(252,252,252,1)), color-stop(100%,rgba(237,237,237,1))); /* Chrome,Safari4+ */" + NEWLINE
		            + "background: -webkit-linear-gradient(top,  rgba(252,252,252,1) 0%,rgba(237,237,237,1) 100%); /* Chrome10+,Safari5.1+ */" + NEWLINE
		            + "background: -o-linear-gradient(top,  rgba(252,252,252,1) 0%,rgba(237,237,237,1) 100%); /* Opera 11.10+ */" + NEWLINE
		            + "background: -ms-linear-gradient(top,  rgba(252,252,252,1) 0%,rgba(237,237,237,1) 100%); /* IE10+ */" + NEWLINE
		            + "background: linear-gradient(to bottom,  rgba(252,252,252,1) 0%,rgba(237,237,237,1) 100%); /* W3C */" + NEWLINE
		            + "filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#fcfcfc', endColorstr='#ededed',GradientType=0 ); /* IE6-9 */" + NEWLINE
		            + "border-radius:72px;" + NEWLINE
		            + "box-shadow: 0px 0px 10px rgba(0,0,0,0.2);" + NEWLINE
		            + "}" + NEWLINE
		            + "#border {" + NEWLINE
		             + "position:absolute;" + NEWLINE
		             + "top:10px;" + NEWLINE
		             + "left:10px;" + NEWLINE
		             + "width:500px;" + NEWLINE
		             + "height:23px;" + NEWLINE
		             + "margin:auto auto auto auto;" + NEWLINE
		             + "box-shadow: 0px 0px 4px rgba(0,0,0,0.2);" + NEWLINE
		             + "border-radius:10px;" + NEWLINE
		             + "}" + NEWLINE
			         + "#bar {" + NEWLINE
			         + "position:absolute;" + NEWLINE
		            + "top:0px;" + NEWLINE
		            + "left:0px;" + NEWLINE
		            + "width:20px;" + NEWLINE
		            + "height:20px;" + NEWLINE
		            + "margin:auto auto auto auto;" + NEWLINE
		            + "border-radius:6px;" + NEWLINE
		            + "border:1px solid rgba(30,30,30,0.05);" + NEWLINE
		            + "background: rgb(0, 173, 246); /* Old browsers */" + NEWLINE
		            + "box-shadow: 2px 0px 4px rgba(0,0,0,0.4);" + NEWLINE
		            + "}" + NEWLINE);
			xmlWriter.writeEndElement();
			xmlWriter.writeCharacters(NEWLINE);
			
			xmlWriter.writeStartElement(TAG_SCRIPT);
			xmlWriter.writeAttribute(ATT_SRC,VIS_JS_SRC);
			xmlWriter.writeAttribute(ATT_TYPE, "text/javascript");			
			xmlWriter.writeCharacters(NEWLINE);
			xmlWriter.writeEndElement();
			xmlWriter.writeCharacters(NEWLINE);
			
			xmlWriter.writeStartElement(TAG_SCRIPT);
			xmlWriter.writeAttribute(ATT_SRC,JQUERY_SRC);
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
					+ "function frameSize() {" + NEWLINE
					+ "$(document).ready(function() {" + NEWLINE
					+ "function elementResize() {" + NEWLINE
			        + "var browserWidth = $(window).width()*0.98;" + NEWLINE
					+ "document.getElementById('mynetwork').style.width = browserWidth;" + NEWLINE
					+ "}" + NEWLINE
					+ "elementResize();" + NEWLINE
					+ "$(window).bind(\"resize\", function(){" + NEWLINE
					+ "elementResize();" + NEWLINE
					+ "});" + NEWLINE
					+ "});" + NEWLINE
					+ "}" + NEWLINE);
					xmlWriter.writeEndElement();
					xmlWriter.writeCharacters(NEWLINE);

			
			
			
			
			xmlWriter.writeStartElement(TAG_SCRIPT);
			xmlWriter.writeAttribute(ATT_TYPE, "text/javascript");			
			xmlWriter.writeCharacters(NEWLINE 
					+ "function start(){" + NEWLINE
					+ "loadSaltObjectAndDraw();" + NEWLINE
					+ "frameSize();" + NEWLINE
					+ "}" + NEWLINE
					+ "var nodesJson = [];" + NEWLINE
					+ "var edgesJson = [];" + NEWLINE
					+ "var network = null;" + NEWLINE					
					+ "function loadSaltObjectAndDraw() {" + NEWLINE
					+ "var nodesJson = " + NEWLINE);
			xmlWriter.flush();
			
				try{
					buildJSON();	
				}catch(SaltParameterException e){
				 throw new 	SaltParameterException(e.getMessage());
				}catch(SaltException e){
				 throw new 	SaltException(e.getMessage());
				}

					
				
			if (nNodes < 20){
			nodeDist = 100;
			sprConstant = 1.2;
			} else if (nNodes >=20 && nNodes < 100){
			nodeDist = 120;
			sprConstant = 1.0;
			} else if (nNodes >= 100 && nNodes < 400) {
			nodeDist = 150;
			sprConstant = 0.8;
			} else {
				nodeDist = 180;
				sprConstant = 0.6;
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
			+ "interaction: {" + NEWLINE
			+ "navigationButtons: true," + NEWLINE
			+ "keyboard: true" + NEWLINE
			+ "}," + NEWLINE
			+ "layout: {" + NEWLINE
			+ "hierarchical:{" + NEWLINE
			+ "direction: directionInput.value" + NEWLINE
			+ "}" + NEWLINE
			+ "}," + NEWLINE
			+ "physics: {" + NEWLINE
			+ "hierarchicalRepulsion: {" + NEWLINE
			+ "centralGravity: 0.8," + NEWLINE
			+ "springLength: " + sprLength + "," + NEWLINE
			+ "springConstant: " + sprConstant + "," + NEWLINE
			+ "nodeDistance: nodeDist," + NEWLINE
			+ "damping: 0.04" + NEWLINE
			+ "}," + NEWLINE
			+ "maxVelocity: 50," + NEWLINE
			+ "minVelocity: 1," + NEWLINE
			+ "solver: 'hierarchicalRepulsion'," + NEWLINE
			+ "timestep: 0.5," + NEWLINE
			+ "stabilization: {" + NEWLINE
			+ "iterations: 1000" + NEWLINE
			+ "}" + NEWLINE
			+ "}" + NEWLINE
			+ "}" + NEWLINE
			+ ";" + NEWLINE
			+ "network = new vis.Network(container, data, options);" + NEWLINE
			+ "network.on(\"stabilizationProgress\", function(params) {" + NEWLINE
			+ "var maxWidth = 496;" + NEWLINE
			+ "var minWidth = 20;" + NEWLINE
            + "var widthFactor = params.iterations/params.total;" + NEWLINE
            + "var width = Math.max(minWidth,maxWidth * widthFactor);" + NEWLINE			
			+ "document.getElementById('loadingBar').style.opacity = 1;" + NEWLINE
            + "document.getElementById('bar').style.width = width + 'px';" + NEWLINE
            + "document.getElementById('text').innerHTML = Math.round(widthFactor*100) + '%';" + NEWLINE             
            + "});" + NEWLINE
            + "network.on(\"stabilizationIterationsDone\", function() {" + NEWLINE	
            + "document.getElementById('text').innerHTML = '100%';" + NEWLINE	
            + "document.getElementById('bar').style.width = '496px';" + NEWLINE	
            + "document.getElementById('loadingBar').style.opacity = 0;" + NEWLINE
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
			xmlWriter.writeStartElement(TAG_DIV);
			xmlWriter.writeAttribute(ATT_ID, "wrapper");
			xmlWriter.writeCharacters(NEWLINE);
			
			xmlWriter.writeStartElement(TAG_DIV);
			xmlWriter.writeAttribute(ATT_ID, "loadingBar");
			xmlWriter.writeCharacters(NEWLINE);
			
			xmlWriter.writeStartElement(TAG_DIV);
			xmlWriter.writeAttribute(ATT_CLASS, "outerBorder");
			xmlWriter.writeCharacters(NEWLINE);
			
			xmlWriter.writeStartElement(TAG_DIV);
			xmlWriter.writeAttribute(ATT_ID, "text");
			xmlWriter.writeCharacters("0%");
			xmlWriter.writeEndElement();
			xmlWriter.writeCharacters(NEWLINE);
			
			xmlWriter.writeStartElement(TAG_DIV);
			xmlWriter.writeAttribute(ATT_ID, "border");
			xmlWriter.writeCharacters(NEWLINE);
			
			xmlWriter.writeStartElement(TAG_DIV);
			xmlWriter.writeAttribute(ATT_ID, "bar");
			xmlWriter.writeCharacters(NEWLINE);
			xmlWriter.writeEndElement();
			xmlWriter.writeCharacters(NEWLINE);
			
			
			xmlWriter.writeEndElement();
			xmlWriter.writeCharacters(NEWLINE);
			xmlWriter.writeEndElement();
			xmlWriter.writeCharacters(NEWLINE);
			xmlWriter.writeEndElement();
			xmlWriter.writeCharacters(NEWLINE);
						
			
			xmlWriter.writeStartElement(TAG_H2);
			xmlWriter.writeCharacters("Dokument-Id: " + docId);
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
					);
			xmlWriter.writeEndElement();
			xmlWriter.writeCharacters(NEWLINE);		
			
			//div
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
		  
		/*  File imgFolderOut = new File(outputFolder, IMG_FOLDER_OUT);
		  if(!imgFolderOut.exists()){
			  imgFolderOut.mkdirs();
		  }*/
		  
		  if(loadJSON){
			  File jsonFolderOut = new File(outputFolder, JSON_FOLDER_OUT);
			  if(!jsonFolderOut.exists()){
				  jsonFolderOut.mkdir();
			  }
		  }
		 
		  
		  copyResourceFile(RESOURCE_FOLDER, CSS_FILE, outputFolder.getPath(), CSS_FOLDER_OUT, CSS_FILE);
		  copyResourceFile(RESOURCE_FOLDER, JS_FILE, outputFolder.getPath(), JS_FOLDER_OUT, JS_FILE);
		  copyResourceFile(RESOURCE_FOLDER, JQUERY_FILE, outputFolder.getPath(), JS_FOLDER_OUT, JQUERY_FILE); 
		  copyResourceFile(RESOURCE_FOLDER, HTML_FILE, outputFolder.getPath(), null, HTML_FILE);	
			
		  
		
		/*  ClassLoader classLoader = getClass().getClassLoader();
		  File imgFolder = new File(classLoader.getResource(RESOURCE_FOLDER_IMG_NETWORK).getFile());*/
		  
		  
		//  System.out.println(imgFolder.getAbsolutePath());
		  
		 /* final String path = "visjs/img/network";
		  final File jarFile = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
		  System.out.println("jarFile: " +jarFile);
		  
		  if(jarFile.isDirectory())
		  {  
			  System.out.println("is dir");
		      final JarFile jar = new JarFile(jarFile);
		      final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
		      while(entries.hasMoreElements()) {
		          final String name = entries.nextElement().getName();
		          if (name.startsWith(path + "/")) { //filter according to the path
		              System.out.println(name);
		          }
		      }
		      jar.close();
		  }*/
		
		  
		  
		  
		/* File resourceFolderImgNetwork = new File(RESOURCE_FOLDER);
		 System.out.println(resourceFolderImgNetwork.getPath()); */
		
		/*  if (!imgFolder.exists()){
			 throw new SaltResourceException("visjs image resources does not exist!");
		  }
		  
		  if (!imgFolder.canRead()){
			  throw new SaltResourceException("No read permit for visjs image folder!");
		  }*/
		  
		/* File[] imgFiles = imgFolder.listFiles();
		// System.out.println(imgFiles.length);
		 
		 for(File imgFile : imgFiles){			 
			 System.out.println(imgFile.getName());
			 copyResourceImage(System.getProperty("file.separator") + RESOURCE_FOLDER_IMG_NETWORK, imgFile.getName(), outputFolder.getPath(), IMG_FOLDER_OUT, imgFile.getName());
		 }*/
		  
		  
		  return outputFolder;
	}
	
	
/*
 * Copies the specified auxiliary file to the according output subfolder.
 */
	
	private void copyResourceFile (String resourceFolder, String inFile, String outputFolder, String outSubFolder, String outFile) 
			throws FileNotFoundException, IOException{

InputStream inputStream = getClass().getResourceAsStream(resourceFolder 
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
	


	
	
	
	
	private void setJsonWriter (OutputStream os)
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

	
	   
	private void writeJSON () throws IOException, SaltParameterException, SaltException {	
			jsonWriter.write("{");
			jsonWriter.newLine();
			jsonWriter.write("\"nodes\":");
			jsonWriter.newLine();
			jsonWriter.flush();
			
			try{
				buildJSON();	
			}catch(SaltParameterException e){
			 throw new 	SaltParameterException(e.getMessage());
			}catch(SaltException e){
			 throw new 	SaltException(e.getMessage());
			}
			
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
	//  token must always be outputted
	 for (SToken token : sTokens){			
			writeJsonNode(token, maxLevel);
			
			nNodes++;
	 }
	 
	nTokens = sTokens.size();
	 
	
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
	
	
	private static List<Map.Entry<String, String>> sortAnnotations(Set<SAnnotation> sAnnotations)
	{
		Map<String, String> annotationMap = new HashMap<String, String>();
		
		for(SAnnotation sAnnotation: sAnnotations) {
			annotationMap.put(sAnnotation.getName(), sAnnotation.getValue().toString());
		}	
		
		List<Map.Entry<String, String>>  sortedAnnotations = sortByKey(annotationMap);
		
		return sortedAnnotations;		
	}
	
		
	private static <K, V> List<Map.Entry<K, V>> sortByKey(Map<K, V> map) {
		List<Map.Entry<K, V>> entries = new ArrayList<Map.Entry<K, V>>(map.size());
		entries.addAll(map.entrySet());
		
		Comparator<Map.Entry<K, V>> comparator = new Comparator<Map.Entry<K, V>>() {
			public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
				return e1.getKey().toString().compareToIgnoreCase(e2.getKey().toString());
						
			}
		};
		// sort  key values lexicographically
		Collections.sort(entries, comparator);

		return entries;
	}

	
	
	
	private void writeJsonNode (SNode node, long levelValue) throws IOException
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
			   allLabels += NEWLINE;
			   List<Map.Entry<String, String>>  sortedAnnotations = sortAnnotations(sAnnotations);		   	   
			  
			   
			   int i=1;
			   for (Map.Entry<String, String> annotation : sortedAnnotations) 
			   {
				   allLabels += (annotation.getKey() + "=" + annotation.getValue());
				   
				   if (i < sortedAnnotations.size()){
					   allLabels+= NEWLINE;
				   }
				   i++;
			   }
		   }
		   
		   if (node instanceof SToken)
		   {
			   String text = doc.getDocumentGraph().getText(node);
				  if (text != null && !text.isEmpty())
				  {	
					  allLabels+= (NEWLINE + NEWLINE);			
					  allLabels += doc.getDocumentGraph().getText(node);
				  }
		   } 
		  
		   				
		 jsonWriterNodes.value(allLabels);	
		 
		 if (node instanceof SToken)
		 {
			 jsonWriterNodes.key(JSON_COLOR);
			 jsonWriterNodes.value(TOK_COLOR_VALUE);
			 jsonWriterNodes.key(JSON_X);
			 jsonWriterNodes.value((xPosition++)*NODE_DIST);
			 jsonWriterNodes.key(JSON_PHYSICS);
			 jsonWriterNodes.value("false");			 
			 
		 }
		 
		 	 jsonWriterNodes.key(JSON_LEVEL);
			 jsonWriterNodes.value(levelValue);
			 
		if (node instanceof SSpan)
		{
			if (nGroupsId == 3)
			{
				 jsonWriterNodes.key(JSON_GROUP);
				 jsonWriterNodes.value("1");
				 jsonWriterNodes.key(JSON_COLOR);
				 jsonWriterNodes.value(SPAN_COLOR_VALUE);
			}
			else if (nGroupsId == 1)
			{
				jsonWriterNodes.key(JSON_GROUP);
				jsonWriterNodes.value("0");
			}
			//initial x-value in center
			jsonWriterNodes.key(JSON_X);
			jsonWriterNodes.value((nTokens/2)*NODE_DIST);
	
		}
		
		else if (node instanceof SStructure)
		{
			if (nGroupsId == 3 || nGroupsId == 2)
			{
				jsonWriterNodes.key(JSON_GROUP);
				jsonWriterNodes.value("0");
				jsonWriterNodes.key(JSON_COLOR);
				jsonWriterNodes.value(STRUCTURE_COLOR_VALUE);
			}
			//initial x-value in center
			 jsonWriterNodes.key(JSON_X);
			 jsonWriterNodes.value((nTokens/2)*NODE_DIST);
	
		}		 
		 
		jsonWriterNodes.endObject();	
		nodeWriter.newLine();	
		
		if(writeNodeImmediately) 
		{
			nodeWriter.flush();
		}
		
}
		 
	private void writeJsonEdge (SNode fromNode, SNode toNode, SRelation relation) throws IOException
	{
			  jsonWriterEdges.object();
			  jsonWriterEdges.key("from");
			  jsonWriterEdges.value(fromNode.getPath().fragment());
			  jsonWriterEdges.key("to");
			  jsonWriterEdges.value(toNode.getPath().fragment());

				  
			  
				  Set<SAnnotation> sAnnotations = relation.getAnnotations();
				  if (sAnnotations.size() > 0)
				   {		
					   String allLabels = "";
					   List<Map.Entry<String, String>>  sortedAnnotations = sortAnnotations(sAnnotations);		
					   
					   int i= 0;
					   for (Map.Entry<String, String> annotation : sortedAnnotations) 
					   {
						   allLabels += (annotation.getKey() + "=" + annotation.getValue());					
						   
						   if (i < sAnnotations.size()){
							   allLabels+= NEWLINE;
						   }
						   i++;
					   }
					   
					   jsonWriterEdges.key("label");
					   jsonWriterEdges.value(allLabels);
				   }
			 
			if (relation instanceof SPointingRelation){			  
				 jsonWriterEdges.key(JSON_WIDTH); 
				 jsonWriterEdges.value("2");
				 jsonWriterEdges.key(JSON_SMOOTH); 
				  	jsonWriterEdges.object();
				    jsonWriterEdges.key(JSON_TYPE); 
				  	jsonWriterEdges.value("curvedCW");
				  	jsonWriterEdges.key(JSON_ROUNDNESS); 
				  	jsonWriterEdges.value("0.5");
				    jsonWriterEdges.endObject();
			  }
			  
			  jsonWriterEdges.endObject();
			  
			  
			  edgeWriter.newLine();
			 
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
	
		
		
	
	/*
	 *  Determine the max. level for JSON node objects.
	 */
	private int getMaxLevel(SDocument doc)
	{
		maxLevel = getMaxHeightOfSDocGraph(doc);
		int nSpanClasses = spanClasses.size();		
		
		// set nGroupsId
		if (readSpanNodes != null && (readSpanNodes.size() > 0))
    	{
    		nGroupsId += 1;
    	}	
    	
    	
    	if (readStructNodes != null && (readStructNodes.size() > 0))
    	{
    		nGroupsId += 2;
    	}
    	
    	
    	// maxLevel depends on node groups
    	if (nGroupsId == 3) {
			maxLevel += nSpanClasses;
		}
		else if (nGroupsId == 1){
			maxLevel += (nSpanClasses - 1);
		}
		
		readSpanNodes.clear();
		readStructNodes.clear();		
		return maxLevel;
	}
	
	
	 //traverse the graph in depth first top down mode beginning with its roots and calculate the max. height of the salt graph
	private  int  getMaxHeightOfSDocGraph(SDocument doc)
	{
		doc.getDocumentGraph().traverse(doc.getDocumentGraph().getRoots(), GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, TRAV_MODE_CALC_LEVEL, this);		
		if (maxHeight > (Integer.MAX_VALUE - 100)) 
		{
			throw new SaltException("The specified document cannot be visualized. It is too complex.");    
		}
		else 
		{
			return (int) maxHeight;
		}
		
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
			if (traversalId.equals(TRAV_MODE_CALC_LEVEL) && (exportFilter == null || !exportFilter.excludeNode(currNode)))
			{
			
				if (sRelation!= null && !(sRelation instanceof SPointingRelation) && !(fromNode instanceof SToken))
				{			
						currHeight++;
						if (maxHeight < currHeight)
						{
							maxHeight = currHeight;
						}

				}	
			
				  if ((currNode instanceof SSpan))
				  {
					  String annClass = "";
					  
					  Set<SAnnotation> sAnnotations = currNode.getAnnotations();
					   if (sAnnotations.size() > 0)
					   {	
							   List<Map.Entry<String, String>> sortedAnnotations = sortAnnotations(sAnnotations);
							   // use the first annotation
							   annClass = sortedAnnotations.iterator().next().getKey();
								  					    
					   }
				 
					  if (!spanClasses.containsKey(annClass)) 
					  {
						  spanClasses.put(annClass, -1);				  
					  }
					  
					  readSpanNodes.add(currNode);
				  }
				  
				  
				  
				  if ((currNode instanceof SStructure))
				  {
					readStructNodes.add(currNode);  
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
			if (traversalType == GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST)
			{				
				if (traversalId.equals(TRAV_MODE_CALC_LEVEL) && !(edge instanceof SPointingRelation) && !(fromNode instanceof SToken) &&
						(exportFilter == null  || !exportFilter.excludeNode(currNode)) && (edge!= null))
				{
				currHeight--;	
				}
			
				else if (traversalId.equals(TRAV_MODE_READ_NODES))
				{ 
				  if (currNode instanceof SToken) 
				  {
					  currHeightFromToken = 1;				  
					  // write SSpan-Nodes					  
					  if ((fromNode instanceof SSpan) && (!readSpanNodes.contains(fromNode)) && 
							  (exportFilter == null  || !exportFilter.excludeNode(fromNode)))
					  { 
						
						  
						  String annotation = "";
						  Set<SAnnotation>  sAnnotations = fromNode.getAnnotations();
						  
						  if (sAnnotations.size() > 0)
						  {
							  List<Map.Entry<String, String>> sortedAnnotations = sortAnnotations(sAnnotations);
							  // use first annotation
							  annotation = sortedAnnotations.iterator().next().getKey();
						  }						  
						  
						  int spanOffset = spanClasses.get(annotation);						  
						  											  
						  if(spanOffset == -1)
						  {
							  maxSpanOffset = Math.max(spanOffset, maxSpanOffset) + 1;
							  spanClasses.put(annotation, maxSpanOffset);
						  }
						  spanOffset = spanClasses.get(annotation);	
						  
						  try {
							writeJsonNode(fromNode, maxLevel - currHeightFromToken - spanOffset);
							nNodes++;
						} catch (IOException e) {
							throw new SaltException("A problem occurred while building JSON objects.");
						}						
					      readSpanNodes.add(fromNode);					
						  	
					  }
					
				  }
				  else if (currNode instanceof SStructure)
				  {	 
					  
					  if ((exportFilter == null  || !exportFilter.excludeNode(currNode)) && !readStructNodes.contains(currNode))
					  {		
						  currHeightFromToken++;
						  int currLevel = maxLevel - currHeightFromToken - spanClasses.size() + 1;
							try 
							{ 								
								//if currNode is a root
								if(roots.contains(currNode))
								{
									int minRootLevel;								 
								 
									 if (rootToMinLevel.containsKey(currNode))
									 {
										 minRootLevel = Math.min(rootToMinLevel.get(currNode), currLevel);
				
									 }
									 else{
										 minRootLevel = currLevel;
									 }
									 // write root node with min level
									writeJsonNode(currNode, minRootLevel);
								}
								else
								{
									writeJsonNode(currNode, currLevel);
									
								}
							
								
							} catch (IOException e) {
								throw new SaltException("A problem occurred while building JSON objects.");
							}	
							  nNodes++;
							  readStructNodes.add(currNode);
					  }
					  
					// if fromNode is a root, store its min level
					 if (fromNode instanceof SStructure && roots.contains(fromNode) && !readStructNodes.contains(fromNode) && 
							 (exportFilter == null  || !exportFilter.excludeNode(fromNode)))
					 { 
						 int thisRootLevel =  maxLevel - currHeightFromToken - spanClasses.size();
						 if (rootToMinLevel.containsKey(fromNode))
						 {
							 int oldLevel = rootToMinLevel.get(fromNode);
							 rootToMinLevel.put(fromNode, Math.min(oldLevel, thisRootLevel)) ;
						 }
						 else{
							 rootToMinLevel.put(fromNode, thisRootLevel) ;
						 }
					 }					  				  
					  
					}
					 
		  if (edge!= null )
				{
				  if (!readRelations.contains(edge) && (exportFilter == null  || !exportFilter.excludeRelation(edge)))
				  {					  
					try 
					{
					  writeJsonEdge(fromNode, currNode, edge);
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
		if(edge instanceof SDominanceRelation || edge instanceof SSpanningRelation || 
				edge instanceof SPointingRelation || edge == null)  
		{
			return true;
		}
		else 
		{
			return false;
		}
		
	}
	
	

	
}
