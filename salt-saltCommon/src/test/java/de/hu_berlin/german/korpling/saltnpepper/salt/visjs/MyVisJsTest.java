package de.hu_berlin.german.korpling.saltnpepper.salt.visjs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.junit.Test;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
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
import de.hu_berlin.german.korpling.saltnpepper.salt.samples.SampleGenerator;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.events.*;

import org.json.*;




public class MyVisJsTest implements SGraphTraverseHandler{
		
	private  int currHigh;
	private  int maxHigh;
	private long maxLevel;
	private  int currHighFromToken;
	boolean graphContainsSpans = false;
	
	private SDocument doc;
	private XMLOutputFactory outputFactory;
	private OutputStream os;
	private XMLStreamWriter writer;
	private BufferedWriter out;
	private JSONWriter jsonWriter;
	private StringBuilder strBuilder;
	private static final String TRAV_MODE_CALC_LEVEL = "calcLevel";
	private static final String TRAV_MODE_READ_NODES = "readNodes";
	
	
	private HashSet <SNode> readRoots;
	private EList<SNode> roots;
	private int nGroupsId = 0;
	
	
	// JSON output
	private String id = "id";
	private String label = "label";
	private String color = "color";
	private String x = "x";
	private String level = "level";
	private String group = "group";
	
	private String from = "{from: ";
	private String to = "to: ";
	
	private int xValue = 0;	
	private String tokColorValue = "#CCFF99";
	//private int groupValue;
	
	
	// HTML output
	private  final String visJsSrc = "../../../dist/vis.js";
	private final String visCss = "../../../dist/vis.css";
	private final String visJsSrcGA = "../../googleAnalytics.js";
	
    private final String textStyle = "width:700px; font-size:14px; text-align: justify;";
    
    //HTML tags
    private final String html = "html";
    private final String head = "head";
    private final String body = "body";
    private final String title = "title";
    private final String p = "p";
    private final String div = "div";
    private final String script = "script";
    private final String style = "style";
    private final String link = "link";
    private final String h2 = "h2";
    private final String input = "input";
    
    //HTML attributes
    private final String attType = "type";
    private final String attId = "id";
    private final String attValue = "value";
    private final String attSrc = "src";
    private final String attHref = "href";
    private final String attRel = "rel";
    private final String attStyle = "style";
    private final String attLang = "language";
    
    
    
    
    private final String newline = "\n";
    
 
	
	
	
	
public MyVisJsTest (){
	 this.doc= SaltFactory.eINSTANCE.createSDocument();
	SampleGenerator.createSDocumentStructure(doc);
	roots = doc.getSDocumentGraph().getSRoots();
	
	EList<SSpan>  sSpans = doc.getSDocumentGraph().getSSpans();
	
	
	if (sSpans != null && (sSpans.size() > 0)){
		nGroupsId += 1;
	}
	
	EList<SStructure>  sStructures = doc.getSDocumentGraph().getSStructures();
	
	if (sStructures != null && (sStructures.size() > 0)){
		nGroupsId += 2;
	}
	
	// this.os = new FileOutputStream(new File ("outputHTMLTest.html"));	
	readRoots = new HashSet <SNode>();
	this.outputFactory = XMLOutputFactory.newInstance();
	try {
		this.writer = outputFactory.createXMLStreamWriter(System.out, "UTF-8");
	} catch (XMLStreamException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	this.out = new BufferedWriter(new OutputStreamWriter(System.out));		
	this.jsonWriter = new JSONWriter(out);
	this.strBuilder = new StringBuilder();
	

}
	

	
	
	@Test
	public void test() throws IOException, XMLStreamException{
		
	
	


		
		writer.writeStartDocument();
		writer.writeCharacters(newline);
		writer.writeStartElement(html);
		writer.writeCharacters(newline);
		
		writer.writeStartElement(head);
		writer.writeCharacters(newline);
		
		writer.writeStartElement(title);
		writer.writeCharacters("Network | Hierarchical Layout, userDefined");
		writer.writeEndElement();
		writer.writeCharacters(newline);
		
		writer.writeStartElement(style);
		writer.writeAttribute(attType, "text/css");
		writer.writeCharacters("body {\nfont: 10pt sans;\n}\n#mynetwork {\nwidth: 1000px;\nheight: 1000px;\nborder: 1px solid lightgray;\n}");
		writer.writeEndElement();
		writer.writeCharacters(newline);
		
		writer.writeStartElement(script);
		writer.writeAttribute(attType, "text/javascript");
		writer.writeAttribute(attSrc,visJsSrc);
		writer.writeEndElement();
		writer.writeCharacters(newline);
		
		writer.writeEmptyElement(link);
		writer.writeAttribute(attHref, visCss);
		writer.writeAttribute(attRel,"stylesheet");
		writer.writeAttribute(attType, "text/css");
		writer.writeCharacters(newline);
		
		
		writer.writeStartElement(script);
		writer.writeAttribute(attType, "text/javascript");
		writer.writeCharacters("var nodes = null;\nvar edges = null;\nvar network = null;\n"
						+ "var directionInput = document.getElementById(\"direction\");\n" 
						+ "function destroy() {\n" 
						+ "if (network !== null) {\n" 
						+ "network.destroy();\n" 
						+ "network = null;\n" 
						+ "}\n" 
						+ "}\n" 
						+ "function draw() {\n" 
						+ "destroy();\n" 
						+ "var connectionCount = [];\n" 
						+ "nodes = [];\n" 
						+ "edges = [];);\n");
		
		writer.flush();
		
		  writeJSON();
		
		writer.writeCharacters("var container = document.getElementById('mynetwork');\n +"
				+ "var data = {\n "
				+ "nodes: nodes,\n"
				+ "edges: edges\n"
				+ "};\n"
				+ "var options = {\n"
				+ "nodes:{\n"
				+ "shadow: true,\n"
				+ "shape: \"box\"\n"
				+ "},\n"
				+ "edges: {\n"
				+ "smooth: true\n"
				+ "},\n"
				+ "layout: {\n"
				+ "hierarchical:{\n"
				+ "direction: directionInput.value\n"
				+ "}\n"
				+ "}\n"
				+ "};\n"
				+ "network = new vis.Network(container, data, options);\n"
				+ "network.on('select', function(params) {\n"
				+ "document.getElementById('selection').innerHTML = 'Selection: ' + params.nodes;\n"
				+ "});\n"
				+ "}\n");

		writer.writeEndElement();
		writer.writeCharacters(newline);
		
		writer.writeStartElement(script);
		writer.writeAttribute(attSrc, visJsSrcGA);
		writer.writeEndElement();
		writer.writeCharacters(newline);		
		
		//head 
		writer.writeEndElement();
		writer.writeCharacters(newline);
		
		
		writer.writeStartElement(body);
		writer.writeAttribute("onload", "draw();");
		writer.writeCharacters(newline);
		
		writer.writeStartElement(h2);
		writer.writeCharacters("Hierarchical Layout");
		writer.writeEndElement();
		writer.writeCharacters(newline);
		
		writer.writeStartElement(div);
		writer.writeAttribute(attStyle,textStyle);
		writer.writeCharacters("Ein Beispiel");
		writer.writeEndElement();
		writer.writeCharacters(newline);
		
		writer.writeStartElement("p");
		
		writer.writeEmptyElement(input);
		writer.writeAttribute(attType,"button");
		writer.writeAttribute(attId, "btn-UD");
		writer.writeAttribute(attValue, "Up-Down");
		writer.writeCharacters(newline);
		
		writer.writeEmptyElement(input);
		writer.writeAttribute(attType,"button");
		writer.writeAttribute(attId, "btn-DU");
		writer.writeAttribute(attValue, "Down-Up");
		writer.writeCharacters(newline);
		
		writer.writeEmptyElement(input);
		writer.writeAttribute(attType,"button");
		writer.writeAttribute(attId, "btn-LR");
		writer.writeAttribute("value", "Left-Right");
		writer.writeCharacters(newline);
		
		writer.writeEmptyElement(input);
		writer.writeAttribute(attType,"button");
		writer.writeAttribute(attId, "btn-RL");
		writer.writeAttribute(attValue, "Right-Left");
		writer.writeCharacters(newline);
		
		writer.writeEmptyElement(input);
		writer.writeAttribute(attType,"hidden");
		//TODO check the apostrophes
		writer.writeAttribute(attId, "'direction'");
		writer.writeAttribute(attValue, "UD");
		writer.writeCharacters(newline);
	
		
		//p
		writer.writeEndElement();
		writer.writeCharacters(newline);
		
		writer.writeStartElement(div);
		writer.writeAttribute(attId, "mynetwork");
		writer.writeEndElement();
		writer.writeCharacters(newline);
		
		writer.writeStartElement(p);
		writer.writeAttribute(attId, "selection");
		writer.writeEndElement();
		writer.writeCharacters(newline);
		
		
		writer.writeStartElement(script);
		writer.writeAttribute(attLang, "JavaScript");
		writer.writeCharacters("var directionInput = document.getElementById(\"direction\");\n"
				+ "var btnUD = document.getElementById(\"btn-UD\");\n"
				+ "btnUD.onclick = function() {\n"
				+ "directionInput.value = \"UD\";\n"
				+ "draw();\n"
				+ "};\n"
				+ "var btnDU = document.getElementById(\"btn-DU\");\n"
				+ "btnDU.onclick = function() {\n"
				+ "directionInput.value = \"DU\";\n"
				+ "draw();\n"
				+ "};\n"
				+ "var btnLR = document.getElementById(\"btn-LR\");\n"
				+ "btnLR.onclick = function() {\n"
				+ "directionInput.value = \"LR\";\n"
				+ "draw();\n"
				+ "};\n"
				+ "var btnRL = document.getElementById(\"btn-RL\");\n"
				+ "btnRL.onclick = function() {\n"
				+ "directionInput.value = \"RL\";\n"
				+ "draw();\n"
				+ "};\n");
		writer.writeEndElement();
		writer.writeCharacters(newline);	
		
		
		//body
		writer.writeEndElement();
		writer.writeCharacters(newline);
		
		
		
		
		//html
		writer.writeEndElement();
		writer.writeCharacters(newline);	
		
		
		
	   
		writer.writeEndDocument();
		writer.flush();
		writer.close();
		
		out.close();
		
		
	  
	//   System.out.println("currh: " + currHigh + " maxh: " + maxHigh);
	  
	}
	
	private void writeJSON (){		
	try {
		
		maxLevel = getMaxHighOfSDocGraph(doc) + 1;
		EList <SSpan> sSpans = doc.getSDocumentGraph().getSSpans();
		 if (sSpans != null && sSpans.size() != 0) {
			 graphContainsSpans = true;
			 maxLevel++;			 
		 }
		
	//	 System.out.println("maximales Level: " + maxLevel);
		 strBuilder.append("var edges = new vis.DataSet(\n");
		 strBuilder.append("[");
		 
		 doc.getSDocumentGraph().sortSTokenByText();	  		 
		 EList <SToken> sTokens = doc.getSDocumentGraph().getSTokens();
		 
		 out.append("var nodes = new vis.DataSet(\n");
		 
		jsonWriter.array();
		 for (SToken token : sTokens){			
			 writeJSONObject(token, maxLevel);
		 }
		
	
		 
		 doc.getSDocumentGraph().traverse(doc.getSDocumentGraph().getSRoots(), GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, 
				 												TRAV_MODE_READ_NODES, this);		
		 		 
		 jsonWriter.endArray();			   
		 out.append(");\n");
		 out.flush();
		
		
		 int commaIndex = strBuilder.lastIndexOf(",");
		 strBuilder.deleteCharAt(commaIndex);
		 strBuilder.append("]");
		 strBuilder.append(");\n");
		 
		 out.append(strBuilder.toString());
		 out.append(newline);
		 out.flush();
		

			
		
		 
	
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	private void writeJSONObject (SNode node, long levelValue){
		 try {
			 
		 jsonWriter.object();
		 jsonWriter.key(id);
		 jsonWriter.value(node.getSElementPath().fragment());
		 jsonWriter.key(label);
		 String allLabels = "";
	
		   EList<SAnnotation> sAnnotations = node.getSAnnotations();
		   if (sAnnotations.size() > 0){
			   for (SAnnotation annotation : sAnnotations) {
				   allLabels += (annotation.getSName() + "=" + annotation.getSValue().toString() + newline);								   
			   }
		   }
		   
		   if (node instanceof SToken){
			   String text = doc.getSDocumentGraph().getSText(node);
				  if (text != null && !text.isEmpty()){
					  allLabels += doc.getSDocumentGraph().getSText(node);
				  }
		   } 
		   				
		 jsonWriter.value(allLabels);	
		 if (node instanceof SToken){
			 jsonWriter.key(color);
			 jsonWriter.value(tokColorValue);
			 jsonWriter.key(x);
			 jsonWriter.value(++xValue);
		 }
		 
		 	 jsonWriter.key(level);
			 jsonWriter.value(levelValue);
			 
		if (node instanceof SSpan){
			if (nGroupsId == 3){
				 jsonWriter.key(group);
				 jsonWriter.value("1");
			}
			else if (nGroupsId == 1){
				jsonWriter.key(group);
				jsonWriter.value("0");
			}
			// TODO error handling
			
		}
		
		if (node instanceof SStructure){
			if (nGroupsId == 3 || nGroupsId == 2){
				jsonWriter.key(group);
				jsonWriter.value("0");
			}
			// TODO error handling
		}
		 
		 
		 jsonWriter.endObject();		

		out.append(newline);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	}
	
	
	 //traversing the graph in depth first top down mode beginning with its roots
	private  long getMaxHighOfSDocGraph(SDocument doc){
		 doc.getSDocumentGraph().traverse(doc.getSDocumentGraph().getSRoots(), GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, TRAV_MODE_CALC_LEVEL, this);		
		return maxHigh;
		
	}
	
	
	
	@Override
	public void nodeReached(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode, SRelation sRelation,
														SNode fromNode, long order) {
		
		if (sRelation!= null){
			
			if (traversalType == GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST){
				
				if (traversalId.equals(TRAV_MODE_CALC_LEVEL)){
				currHigh++;
				if (maxHigh < currHigh) maxHigh = currHigh;
			//	System.out.println(currNode +  "  currLevel: " + currHigh + " maxh: " + maxHigh);
				}					
			}		
		}	
	}

	
	
	@Override
	public void nodeLeft(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode, SRelation edge,
			SNode fromNode, long order) {		
		
		if (edge!= null){			
			
			if (traversalType == GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST){
				
				if (traversalId.equals(TRAV_MODE_CALC_LEVEL)){
				currHigh--;		
				}
			
				if (traversalId.equals(TRAV_MODE_READ_NODES)){
			//		System.out.println(fromNode + " --> " +edge + "-->"+currNode);
				  if (currNode instanceof SToken) {
					  currHighFromToken = 1;	
					  
					  // write SSpan-Nodes					  
					  if ((fromNode instanceof SSpan) && (!readRoots.contains(fromNode))){						  
						  
						  writeJSONObject(fromNode, maxLevel - currHighFromToken);
						
						readRoots.add(fromNode);					
						  	
					  }
					
				  }
				  else {
					  
					  currHighFromToken++;				  
					  
					  
					  if (currNode instanceof SStructure){
						 
						  writeJSONObject(currNode, maxLevel - currHighFromToken);
						 
						 
						 if (roots.contains(fromNode) && !readRoots.contains(fromNode)){
							 writeJSONObject(fromNode, maxLevel - currHighFromToken - 1);							 
							 readRoots.add(fromNode);
						 }
						  	
					  }
					  
					  
					  }
					 
				  strBuilder.append(from);
				  strBuilder.append("\"" +fromNode.getSElementPath().fragment() + "\", ");
				  strBuilder.append(to);
				  strBuilder.append("\"" +currNode.getSElementPath().fragment() + "\"}");
				  strBuilder.append(",");
				  strBuilder.append(newline);
				
				  
				}
				
				
			}			
		}		
	}

	@Override
	public boolean checkConstraint(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SRelation edge,
			SNode currNode, long order) {
		if(edge instanceof SDominanceRelation || edge instanceof SSpanningRelation || edge == null)  return true;
		else return false;
		
	}

}
