package de.hu_berlin.german.korpling.saltnpepper.salt.visjs;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.stream.XMLStreamException;

import org.eclipse.emf.common.util.URI;
import org.junit.Test;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.visjs.VisJsCreator;

public class VisJsCreatorTest extends TestCase{
	String inputFilePath;
	String outputFolderPath;
	
	static int NODES = 0;
	static int EDGES = 1;
	static int OPTIONS = 2;
	
	
	 @Override public void setUp() throws Exception
	  {
		 inputFilePath = "../pcc2_random_sentence/pcc2/match_0.salt";
		 outputFolderPath = ".." + System.getProperty("file.separator") + "visJsOutput";	    
		
	  }

	@Test
	public void testHtmlWriter() {
		
		URI uri = URI.createFileURI(inputFilePath);	
		VisJsCreator visJsCreator = new VisJsCreator(uri);
		
		try {
			 URI outputFileUri = URI.createFileURI(outputFolderPath);	
			 visJsCreator.writeHTML(outputFileUri);
		} catch (IOException | XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
//	@Test
	public void testJson(){
		URI uri = URI.createFileURI(inputFilePath);	
		VisJsCreator visJsCreator = new VisJsCreator(uri);
		
		visJsCreator.setNodeWriter(System.out);
		visJsCreator.setEdgeWriter(System.out);
		visJsCreator.setOptionsWriter(System.out);
		visJsCreator.buildJSON();
		visJsCreator.buildOptions();
		
		BufferedWriter ow;
		
		
		try {
			ow = visJsCreator.getJsonNodes();
			ow.flush();		
			ow = visJsCreator.getJsonEdges();		
			ow.flush();				
			ow = visJsCreator.getOptions();
			ow.flush();
			ow.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
	}

}
