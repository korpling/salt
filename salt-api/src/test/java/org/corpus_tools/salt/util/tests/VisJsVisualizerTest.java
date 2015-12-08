package org.corpus_tools.salt.util.tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;

import javax.xml.stream.XMLStreamException;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.exceptions.SaltException;
import org.corpus_tools.salt.exceptions.SaltParameterException;
import org.corpus_tools.salt.exceptions.SaltResourceException;
import org.corpus_tools.salt.samples.SampleGenerator;
import org.corpus_tools.salt.tests.SaltTestsUtil;
import org.corpus_tools.salt.util.VisJsVisualizer;
import org.eclipse.emf.common.util.URI;
import org.junit.Test;

import com.google.common.io.Files;
//import junit.framework.Assert;

public class VisJsVisualizerTest {
	private final static String FSEP = System.getProperty("file.separator");
	private final static String OUTPUT_FOLDER = SaltTestsUtil.getTempTestFolder().getAbsolutePath();
	
	private final static String INPUT_FOLDER =  "src"	+ FSEP+"test"	+ FSEP+ "resources" + FSEP + "VisJsTest" + FSEP + "sources";
	private final static String INPUT_FILE_MAIN_TEST = INPUT_FOLDER + FSEP + "pcc2_salt" + FSEP + "pcc2" + FSEP  + "11299.salt";
	
	private final static String TEST_RESULT_FOLDER =  "src"	+ FSEP+"test"	+ FSEP+ "resources" + FSEP + "VisJsTest" + FSEP + "results";
	
	
		
	
	private String [] getAllFileNames (){
		String []  allFileNames = new String [5];
		allFileNames[0] = VisJsVisualizer.HTML_FILE;
		allFileNames[1] = VisJsVisualizer.JS_FOLDER_OUT + FSEP + VisJsVisualizer.JQUERY_FILE;
		allFileNames[2] = VisJsVisualizer.JS_FOLDER_OUT + FSEP + VisJsVisualizer.JS_FILE;
		allFileNames[3] = VisJsVisualizer.CSS_FOLDER_OUT + FSEP + VisJsVisualizer.CSS_FILE;
		allFileNames[4] = VisJsVisualizer.JSON_FOLDER_OUT + FSEP + VisJsVisualizer.NODES_AND_EDGES_FILE;		
		return allFileNames;
	}
	
	
	@Test
	public void testHtmlWriterWholeDocLoadJson() {
	//	String inputFilePath = INPUT_FOLDER + FSEP + "pcc2_salt" + FSEP + "pcc2" + FSEP  + "11299.salt";
		String inputFilePath = INPUT_FILE_MAIN_TEST;		
		String outputFolderName =  "pcc_whole_doc_11299_load_json";
		String outputFolderPath = OUTPUT_FOLDER + FSEP + outputFolderName;	   
		
		URI uri = URI.createFileURI(inputFilePath);	
		VisJsVisualizer visJsVisualizer = new VisJsVisualizer(uri);
		
		try {
			 URI outputFolderUri = URI.createFileURI(outputFolderPath);	
			 try {
				visJsVisualizer.visualize(outputFolderUri, true);
				File testFolder = new File(outputFolderPath);
				File resultFolder = new File (TEST_RESULT_FOLDER, outputFolderName);
				
				if(folderStructureOk(testFolder, true) && folderStructureOk(resultFolder, true)){
					String [] allFileNames = getAllFileNames();
					boolean equals = true;
					for (int i=0; i<allFileNames.length; i++){
						equals = equals && filesAreEqual(new File(testFolder, allFileNames[i]), new File(resultFolder, allFileNames[i]));
					//	System.out.println("eq: " + equals);
					}
					
					
				}
				
			//	Files.equals(file1, resultFile);
				
				
			} catch (SaltException | XMLStreamException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	private static boolean folderStructureOk (File folder, boolean loadJson){
		int nFiles;
		
		if (loadJson) 
		{
			nFiles = 4;
		}
		else
		{
			nFiles = 3;
		}
		
		if (folder.exists() && folder.isDirectory() && folder.canRead()){
			
			if(folder.listFiles().length == nFiles){
				// TODO more differentiable test
				return true;
				}
			else {
				System.out.println("folderlistsize: " +folder.listFiles().length);
			}
			}		
		return false;
	}
	
	private static boolean filesAreEqual (File testFile, File resultFile) throws IOException{				
			return Files.equal(testFile, resultFile);		
	}
	
	
	@Test
	public void testHtmlWriterWholeDoc() {
	//	String inputFilePath = INPUT_FOLDER + FSEP + "pcc2_salt" + FSEP + "pcc2" + FSEP  + "11299.salt";
		String inputFilePath = INPUT_FILE_MAIN_TEST;	
		String outputFileName = "pcc_whole_doc_11299";	   
		String outputFolderPath = OUTPUT_FOLDER + FSEP + outputFileName;	   
		
		URI uri = URI.createFileURI(inputFilePath);	
		VisJsVisualizer visJsVisualizer = new VisJsVisualizer(uri);
		
		try {
			 URI outputFolderUri = URI.createFileURI(outputFolderPath);	
			 try {
				visJsVisualizer.visualize(outputFolderUri, false);
			} catch (SaltException | XMLStreamException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	
	@Test
	public void testHtmlWriterSample() {
		SDocument doc = SaltFactory.createSDocument();
		SampleGenerator.createDocumentStructure(doc);	
		VisJsVisualizer visJsVisualizer = new VisJsVisualizer(doc);
		String outputFileName = "sample_doc";
		String outputFolderPath = OUTPUT_FOLDER + FSEP + outputFileName;	  
		try {
			 URI outputFolderUri = URI.createFileURI(outputFolderPath);	
			 try {
				visJsVisualizer.visualize(outputFolderUri, false);
			} catch (SaltException | XMLStreamException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	
	}
	
	@Test
	public void testHtmlWriterSampleAnaphoricAnnLoadJson() {
		SDocument doc = SaltFactory.createSDocument();
		SampleGenerator.createAnaphoricAnnotations(doc);
		VisJsVisualizer visJsVisualizer = new VisJsVisualizer(doc);
		String outputFileName =  "sample_doc_anaphoric_ann_load_json";	 
		String outputFolderPath = OUTPUT_FOLDER + FSEP + outputFileName;	  
		try {
			 URI outputFolderUri = URI.createFileURI(outputFolderPath);	
			 try {
				visJsVisualizer.visualize(outputFolderUri, true);
			} catch (SaltException | XMLStreamException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testHtmlWriterSampleDependencies() {
		SDocument doc = SaltFactory.createSDocument();
		SampleGenerator.createDependencies(doc);
		VisJsVisualizer visJsVisualizer = new VisJsVisualizer(doc);
		String outputFileName =  "sample_doc_dependencies";
		String outputFolderPath = OUTPUT_FOLDER + FSEP + outputFileName;	  
		try {
			 URI outputFolderUri = URI.createFileURI(outputFolderPath);	
			 try {
				visJsVisualizer.visualize(outputFolderUri, false);
			} catch (SaltException | XMLStreamException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	
	@Test
	public void testHtmlWriterSampleSyntaxStructure() {
		SDocument doc = SaltFactory.createSDocument();
		SampleGenerator.createSyntaxStructure(doc);
		VisJsVisualizer visJsVisualizer = new VisJsVisualizer(doc);
		String outputFileName = "sample_doc_syntax_structure";
		String outputFolderPath = OUTPUT_FOLDER + FSEP + outputFileName;	  
		try {
			 URI outputFolderUri = URI.createFileURI(outputFolderPath);	
			 try {
				visJsVisualizer.visualize(outputFolderUri, false);
			} catch (SaltException | XMLStreamException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testHtmlWriterSampleTokens() {
		SDocument doc = SaltFactory.createSDocument();
		SampleGenerator.createTokens(doc);
		VisJsVisualizer visJsVisualizer = new VisJsVisualizer(doc);
		String outputFileName = "sample_doc_tokens";
		String outputFolderPath = OUTPUT_FOLDER + FSEP + outputFileName;	  
		try {
			 URI outputFolderUri = URI.createFileURI(outputFolderPath);	
			 try {
				visJsVisualizer.visualize(outputFolderUri, false);
			} catch (SaltException | XMLStreamException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testHtmlWriterSampleMorphologyAnn() {
		SDocument doc = SaltFactory.createSDocument();
		SampleGenerator.createMorphologyAnnotations(doc);
		VisJsVisualizer visJsVisualizer = new VisJsVisualizer(doc);
		String outputFileName = "sample_doc_morphology_ann";	
		String outputFolderPath = OUTPUT_FOLDER + FSEP + outputFileName;	  
		try {
			 URI outputFolderUri = URI.createFileURI(outputFolderPath);	
			 try {
				visJsVisualizer.visualize(outputFolderUri, false);
			} catch (SaltException | XMLStreamException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	
	@Test(expected = SaltParameterException.class)
	public void testInputUrlIsNull(){
		URI uri = null;
		VisJsVisualizer visJsVisualizer = new VisJsVisualizer(uri);
	}
	
	@Test(expected = SaltResourceException.class)
	public void testInvalideSaltFormat(){
		String inputFilePath = INPUT_FOLDER + FSEP + "pcc2_invalid_format" + FSEP + "pcc2" + FSEP + "11299.salt";
		URI uri = URI.createFileURI(inputFilePath);	
		VisJsVisualizer visJsVisualizer = new VisJsVisualizer(uri);
	}
	
	@Test(expected = SaltResourceException.class)
	public void testAbsentSaltResource(){
		String inputFilePath = INPUT_FOLDER + FSEP + "pcc2_absent_resource" + FSEP + "pcc2" + FSEP + "11299.salt";
		URI uri = URI.createFileURI(inputFilePath);	
		VisJsVisualizer visJsVisualizer = new VisJsVisualizer(uri);
	}
	

	@Test(expected = SaltParameterException.class)
	public void testNodeWriterIsNull(){
		URI uri = URI.createFileURI(INPUT_FILE_MAIN_TEST);	
		VisJsVisualizer visJsVisualizer = new VisJsVisualizer(uri);		
		visJsVisualizer.setEdgeWriter(System.out);
		visJsVisualizer.buildJSON();
	}
	
	@Test(expected = SaltParameterException.class)
	public void testEdgeWriterIsNull(){
		URI uri = URI.createFileURI(INPUT_FILE_MAIN_TEST);	
		VisJsVisualizer visJsVisualizer = new VisJsVisualizer(uri);		
		visJsVisualizer.setNodeWriter(System.out);
		visJsVisualizer.buildJSON();
	}	
}