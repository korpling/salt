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
	
	private String id = "id";
	private String label = "label";
	private String color = "color";
	private String x = "x";
	private String level = "level";
	
	private String from = "{from: ";
	private String to = "to: ";
	
	private int xValue = 0;	
	private String tokColorValue = "#CCFF99";
	
	
	
	
public MyVisJsTest (){
	 this.doc= SaltFactory.eINSTANCE.createSDocument();
	SampleGenerator.createSDocumentStructure(doc);
	roots = doc.getSDocumentGraph().getSRoots();
	// this.os = new FileOutputStream(new File ("outputHTMLTest.html"));	
	readRoots = new HashSet <SNode>();
	this.outputFactory = XMLOutputFactory.newInstance();
	try {
		this.writer = outputFactory.createXMLStreamWriter(System.out);
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
		
	
	


		
	/*	writer.writeStartDocument();
		writer.setPrefix("c","http://c");
		writer.setDefaultNamespace("http://c");
		writer.writeCharacters("\n");     
		
        writer.writeCharacters("\n");
		writer.writeStartElement("http://c","a");
		writer.writeAttribute("b","blah");
		writer.writeNamespace("c","http://c");
		writer.writeDefaultNamespace("http://c");
		writer.setPrefix("d","http://c");
		writer.writeCharacters("\n");
		writer.writeEmptyElement("http://c","d");
		writer.writeAttribute("http://c","chris","fry");
		writer.writeNamespace("d","http://c");
		writer.writeCharacters("Jean Arp");
		writer.writeEndElement();
		writer.flush();
		writer.close();
		
		out.close();*/
		
		
	/*   EList <SToken> sTokens = doc.getSDocumentGraph().getSTokens();	   
	   doc.getSDocumentGraph().sortSTokenByText();	  
	   
	  for(SToken sToken : sTokens ){
		   System.out.println("Token: " + sToken );
		   EList<SAnnotation> annotations = sToken.getSAnnotations();
		   for (SAnnotation ann : annotations) {
			   System.out.println(ann.getSName() + ":  " + ann.getSValue());
		   }
	   }
	   System.out.println("\n");
	  
	   EList <SNode> sNodes = doc.getSDocumentGraph().getSNodes();
	
	   for(SNode sNode : sNodes ){
		   System.out.println("Node: " +sNode +"; " + doc.getSDocumentGraph().getSText(sNode));
		  
	   }*/	
	  
	  
	
	  writeJSON();
	   
	  
	   
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
		
	
		 
		 doc.getSDocumentGraph().traverse(doc.getSDocumentGraph().getSRoots(), GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, TRAV_MODE_READ_NODES, this);		
		 		 
		 jsonWriter.endArray();			   
		 out.append(");\n");
		 out.flush();
		
		
		 int commaIndex = strBuilder.lastIndexOf(",");
		 strBuilder.deleteCharAt(commaIndex);
		 strBuilder.append("]");
		 strBuilder.append(");\n");
		 
		 out.append(strBuilder.toString());
		 out.append("\n");
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
				   allLabels += (annotation.getSName() + "=" + annotation.getSValue().toString() + "\n");								   
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
		 
		 
		 jsonWriter.endObject();		

		out.append("\n");
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
				  strBuilder.append("\n");
				
				  
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
