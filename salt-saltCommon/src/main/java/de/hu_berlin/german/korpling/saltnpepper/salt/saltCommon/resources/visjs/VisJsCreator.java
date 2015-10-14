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
import java.util.HashMap;
import java.util.HashSet;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GRAPH_TRAVERSE_TYPE;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;
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
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltEmptyParameterException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltResourceException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltResourceNotFoundException;

import org.json.*;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.EList;

/**
 * <p>
 * This class provides a possibility to create a html file, which visualizes a salt graph,
 * created from an {@link SDocument} or from an {@link org.eclipse.emf.common.util.URI} of a salt file, using the vis.js library.
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
 *	VisJsCreator visJsCreator = new VisJsCreator(uri); </br>
 *	try { </br>
 *		 URI outputFileUri = URI.createFileURI(outputFolder);</br>
 *		 visJsCreator.writeHTML(outputFileUri); </br>
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
*	VisJsCreator visJsCreator = new VisJsCreator(uri);
*	 	
*	visJsCreator.setNodeWriter(System.out);
*	visJsCreator.setEdgeWriter(System.out);
*	visJsCreator.setOptionsWriter(System.out);
*	visJsCreator.buildJSON();
*	try {
*		visJsCreator.buildOptions();
*	} catch (IOException e1) {
*		e1.printStackTrace();
*	}
*		
*	BufferedWriter bw;
*				
*	try {
*		bw = visJsCreator.getNodeWriter();
*		bw.newLine();
*		bw.flush();	
*		
*		bw = visJsCreator.getEdgeWriter();		
*		bw.newLine();
*		bw.flush();	
*	
*		bw = visJsCreator.getOptionsWriter();
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

public class VisJsCreator implements SGraphTraverseHandler{
		
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
    													
    		 

    
  /**
   * Creates a new VisJsCreator instance for specified salt document.
   * 
   * @param doc an {@link SDocument}, which have to be visualized
   * 
   * @throws SaltEmptyParameterException if the doc is null 
   */
    public VisJsCreator(SDocument doc){
  	  this(doc, null);
    }
    
    /**
     * Creates a new VisJsCreator instance with specified export filter for specified salt document.
     * 
     * @param doc an SDocument, which have to be visualized
     * @param exportFilter an ExportFilter to exclude selected nodes and/or relations from the visualizing 
     * 
     * @throws SaltEmptyParameterException if the doc is null 
     */
    
    public VisJsCreator (SDocument doc, ExportFilter exportFilter){  
    	
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
    	
    	this.exportFilter = exportFilter;
    	spanClasses =new HashMap<String, Integer>();
    	
    }
    
    
    /**
     * Creates a new VisJsCreator instance for a salt file specified by the uri.
     * 
     * @param inputFileUri a hierarchical URI of a salt file, which have to be visualized. 
     * 		The constructor will create a new {@link SDocument} from this.
     * 
     * @throws SaltEmptyParameterException - if the inputFileUri is null 
     */
      public VisJsCreator(URI inputFileUri){
    	  this(inputFileUri, null);
      }
  	
     /**
      * Creates a new VisJsCreator instance with specified export filter for a salt file specified by the uri.
      * 
      * @param inputFileUri a hierarchical URI of a salt file, which have to be visualized. 
      * 			The constructor will create a new  {@link SDocument} from this.
      * @param exportFilter an ExportFilter to exclude selected nodes and/or relations from the visualizing
      * 
      * @throws SaltEmptyParameterException if the inputFileUri is null 
      * @throws SaltResourceNotFoundException if a problem occurred while loading salt project from the inputFileUri
      */
      
      public VisJsCreator (URI inputFileUri, ExportFilter exportFilter){  
      	if(inputFileUri == null) throw new SaltEmptyParameterException("inputUri", "VisJsCreator", this.getClass());
       	
      	try{
      		this.doc= SaltFactory.eINSTANCE.createSDocument();	
          	doc.loadSDocumentGraph(inputFileUri);
      	}catch (SaltResourceNotFoundException e){
      		throw new SaltResourceNotFoundException("A problem occurred while loading salt project from '" + inputFileUri + "'.", e);
      	}
      	catch (SaltResourceException e){
  			throw new SaltResourceException("A problem occurred while loading salt project from '" + inputFileUri + "'.", e);
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
     * 
     * @throws SaltEmptyParameterException if the outputFolderUri is null
     * @throws SaltResourceNotFoundException if the output auxiliary files cannot have been created
     * @throws SaltException if the output folders cannot have been created or permission denied 
     * @throws SaltResourceException if a problem occurred while copying the auxiliary files  
     * @throws XMLStreamException if a problem occurred while writing the output html file
     * @throws IOException if a problem occurred while writing the output file
     */


public void writeHTML(URI outputFolderUri) throws SaltEmptyParameterException,  SaltResourceNotFoundException, SaltException,
															SaltResourceException, IOException{
			
		try {
			File outputFolder = createOutputResources(outputFolderUri);	
			 File jsonOutputFolder = new File(outputFolder+ System.getProperty("file.separator") + JSON_FOLDER_OUT);
			 if(!jsonOutputFolder.exists() || !jsonOutputFolder.isDirectory()) 
				 throw new SaltException("Either the output folder cannot be created or permission denied.");
			 
			 this.jsonOutputStream =new FileOutputStream(new File(jsonOutputFolder, NODES_AND_EDGES_FILE));			 
		
			}
			catch (SaltEmptyParameterException e){
				throw new SaltEmptyParameterException("outputFileUri", "writeHTML", this.getClass());
			}
			catch (FileNotFoundException e) {
				throw new SaltResourceNotFoundException("The output auxiliary files cannot be created.");
			}	
			catch (SecurityException e) {
			 throw new SaltException("Either the output folder cannot be created or permission denied.");
			}
			catch (IOException e) {
			 throw new SaltResourceException("A problem occurred while copying the vis-js ressource files");
			}	
	
		
		setJsonWriter(jsonOutputStream);
		setNodeWriter(jsonOutputStream);
		setEdgeWriter(jsonOutputStream);
		
    	writeNodeImmediately = true;
    	
    	try{
    		writeJSON();
    	}
    	catch(IOException e){
    		throw new SaltException("A problem occurred while writing JSON resources.");
    	}    	
		
		writeNodeImmediately = false;
	  
	}

/*
 * Organizes the output folder structure and invokes the method for copying of auxiliary files. 
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
		  
		  File jsonFolderOut = new File(outputFolder, JSON_FOLDER_OUT);
		  if(!jsonFolderOut.exists()) jsonFolderOut.mkdir();
		  
		  copyResourceFile(CSS_FILE, outputFolder.getPath(), CSS_FOLDER_OUT, CSS_FILE);
		  copyResourceFile(JS_FILE, outputFolder.getPath(), JS_FOLDER_OUT, JS_FILE);
		  copyResourceFile(JQUERY_FILE, outputFolder.getPath(), JS_FOLDER_OUT, JQUERY_FILE);
		  copyResourceFile(HTML_FILE, outputFolder.getPath(), null, HTML_FILE);
	     
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
	 * @throws SaltEmptyParameterException if the node writer and/or the edge writer not set
	 */
	public void buildJSON () throws SaltException, SaltEmptyParameterException{		
	maxLevel = getMaxLevel(doc);

	doc.getSDocumentGraph().sortSTokenByText();	  		 
	 EList <SToken> sTokens = doc.getSDocumentGraph().getSTokens();
	
	 if(nodeWriter == null || jsonWriterNodes == null){
		 throw new SaltEmptyParameterException("A problem occurred while building JSON objects. Probably the node writer is not set.");
	 }
	 if(edgeWriter == null || jsonWriterEdges == null){
		 throw new SaltEmptyParameterException("A problem occurred while building JSON objects. Probably the edge writer is not set.");
	 }
	 
	 try{
	
	//create node array
	jsonWriterNodes.array();
	// write tokens
	 for (SToken token : sTokens){			
			writeJsonNode(token, maxLevel, exportFilter);
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
	
	
	private void writeJsonNode (SNode node, long levelValue, ExportFilter filter) throws IOException
	{
		if (filter == null || !filter.excludeNode(node))	
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
			  jsonWriterEdges.value(fromNode.getSElementPath().fragment());
			  jsonWriterEdges.key("to");
			  jsonWriterEdges.value(toNode.getSElementPath().fragment());
			  jsonWriterEdges.key("label");
			  jsonWriterEdges.value(relation.getSElementPath().fragment());
			  jsonWriterEdges.endObject();
			  
			  
			  edgeWriter.newLine();
			  }
	}
	
	/**
	 * The invoking of this method induces the optionsWriter to write the options for the vis.js to the associated output stream. 
	 */
	public void buildOptions() throws IOException, SaltEmptyParameterException{
		if (optionsWriter == null){
			throw new SaltEmptyParameterException("A problem occurred while building options. Probably the option writer is not set.");
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
	 *  If the graph has no spans, it is maxHeight+1, else maxHeight+2.
	 */
	private int getMaxLevel(SDocument doc)
	{
		maxLevel = getMaxHeightOfSDocGraph(doc) + 1;
		int nSpanClasses = spanClasses.size();
		
	//	System.out.println("spanClasses: " + spanClasses);
	/*	EList <SSpan> sSpans = doc.getSDocumentGraph().getSSpans();
		 if (sSpans != null && sSpans.size() != 0) 
		 {
			 maxLevel++;			 
		 }*/
		
		 maxLevel += nSpanClasses;
		 return maxLevel;
	}
	
	
	 //traverse the graph in depth first top down mode beginning with its roots and calculate the max. height of the salt graph
	private  int  getMaxHeightOfSDocGraph(SDocument doc)
	{
		doc.getSDocumentGraph().traverse(doc.getSDocumentGraph().getSRoots(), GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, TRAV_MODE_CALC_LEVEL, this);		
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
				//	if (traversalType == GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST)
				//	{				
					//	if (traversalId.equals(TRAV_MODE_CALC_LEVEL))
					//	{
						currHeight++;
						if (maxHeight < currHeight) maxHeight = currHeight;
					//	}					
					//}		
				}	
			
				  if ((currNode instanceof SSpan))
				  {
					  String annClass = "";
					  
					  EList<SAnnotation> sAnnotations = currNode.getSAnnotations();
					   if (sAnnotations.size() > 0)
					   {	
						   // use the first annotation
						   annClass = sAnnotations.get(0).getSName();					   
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
						  EList<SAnnotation>  annotations = fromNode.getSAnnotations();
						  if (annotations.size() > 0){
							  annotation = annotations.get(0).getSName();
						  }						  
						  
						  int spanOffset = spanClasses.get(annotation);						  
						  						  
						  if(spanOffset == -1){
							  maxSpanOffset = Math.max(spanOffset, maxSpanOffset) + 1;
							  spanClasses.put(annotation, maxSpanOffset);
						  }
						  try {
							writeJsonNode(fromNode, maxLevel - currHeightFromToken - maxSpanOffset, exportFilter);
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
						} catch (IOException e) {
							throw new SaltException("A problem occurred while building JSON objects.");
						}						 
						 
						 if (roots.contains(fromNode) && !readRoots.contains(fromNode))
						 {
							 try {
								writeJsonNode(fromNode, maxLevel - currHeightFromToken - spanClasses.size() - 1, exportFilter);
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
