package org.corpus_tools.salt.util.tests;

import java.io.BufferedWriter;
import java.io.IOException;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.exceptions.SaltParameterException;
import org.corpus_tools.salt.exceptions.SaltResourceException;
import org.corpus_tools.salt.samples.SampleGenerator;
import org.corpus_tools.salt.util.internal.VisJsCreator;
import org.eclipse.emf.common.util.URI;
import org.junit.Test;
//import junit.framework.Assert;

public class VisJsCreatorTest {
	private final static String FSEP = System.getProperty("file.separator");
	private final static String TEMP_FOLDER = System.getProperty("java.io.tmpdir");
	private final static String OUTPUT_FOLDER = TEMP_FOLDER + FSEP + "salt-test-visjs";
	private final static String OUTPUT_FOLDER_MAIN_TEST = OUTPUT_FOLDER + FSEP + "pcc2_random_sentences";	
	
//	private final static String INPUT_FOLDER = ".." + FSEP	+ "salt-saltCommon" + FSEP + "src"	+ FSEP + "test"	+ FSEP 
//			+ "resources" + FSEP + "VisJsTest" + FSEP + "sources";
	private final static String INPUT_FOLDER = "."+ FSEP + "src"	+ FSEP + "test"	+ FSEP+ "resources" + FSEP + "VisJsTest" + FSEP + "sources";
	private final static String INPUT_FILE_MAIN_TEST = INPUT_FOLDER + FSEP + "pcc2_salt_random_sentence" + FSEP + "pcc2" + FSEP  + "match_0.salt";
	
	  
	
	
	
	//@Rule
	//public ExpectedException exception = ExpectedException.none();
	
	

	@Test
	public void testHtmlWriter() {		
		URI uri = URI.createFileURI(INPUT_FILE_MAIN_TEST);	
		VisJsCreator visJsCreator = new VisJsCreator(uri);
		
		try {
			 URI outputFolderUri = URI.createFileURI(OUTPUT_FOLDER_MAIN_TEST);	
			 visJsCreator.writeHTML(outputFolderUri);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Test
	public void testHtmlWriterWholeDoc() {
		String inputFilePath = INPUT_FOLDER + FSEP + "pcc2_salt" + FSEP + "pcc2" + FSEP  + "11299.salt";
		
		String outputFolderPath = OUTPUT_FOLDER + FSEP + "pcc_whole_doc_11299";	   
		
		URI uri = URI.createFileURI(inputFilePath);	
		VisJsCreator visJsCreator = new VisJsCreator(uri);
		
		try {
			 URI outputFolderUri = URI.createFileURI(outputFolderPath);	
			 visJsCreator.writeHTML(outputFolderUri);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Test
	public void testJson(){	
		URI uri = URI.createFileURI(INPUT_FILE_MAIN_TEST);	
		VisJsCreator visJsCreator = new VisJsCreator(uri);
		
		visJsCreator.setNodeWriter(System.out);
		visJsCreator.setEdgeWriter(System.out);
		visJsCreator.setOptionsWriter(System.out);
		visJsCreator.buildJSON();
		try {
			visJsCreator.buildOptions();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		BufferedWriter bw;
				
		try {
			bw = visJsCreator.getNodeWriter();
			bw.newLine();
			bw.flush();	
			
			bw = visJsCreator.getEdgeWriter();		
			bw.newLine();
			bw.flush();	
	
			bw = visJsCreator.getOptionsWriter();
			bw.flush();
			bw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	//@Test
	public void testJsonWholeCorpus(){
		String inputFilePath = INPUT_FOLDER + FSEP + "pcc2_salt" + FSEP	+ "pcc2" + FSEP  + "11299.salt";
		URI uri = URI.createFileURI(inputFilePath);	
		VisJsCreator visJsCreator = new VisJsCreator(uri);
		
		visJsCreator.setNodeWriter(System.out);
		visJsCreator.setEdgeWriter(System.out);
		visJsCreator.setOptionsWriter(System.out);
		visJsCreator.buildJSON();
		try {
			visJsCreator.buildOptions();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		BufferedWriter ow;
				
		try {
			ow = visJsCreator.getNodeWriter();
			ow.newLine();
			ow.flush();	
			
			//ow = visJsCreator.getEdgeWriter();		
		//	ow.newLine();
		//	ow.flush();	
	
			ow = visJsCreator.getOptionsWriter();
			ow.flush();
			ow.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testHtmlWriterSample() {
		SDocument doc = SaltFactory.createSDocument();
		SampleGenerator.createSDocumentStructure(doc);	
		VisJsCreator visJsCreator = new VisJsCreator(doc);
		String outputFolderPath = OUTPUT_FOLDER + FSEP + "sample_doc";	  
		try {
			 URI outputFolderUri = URI.createFileURI(outputFolderPath);	
			 visJsCreator.writeHTML(outputFolderUri);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	
	}
	
	@Test
	public void testHtmlWriterSampleAnaphoricAnn() {
		SDocument doc = SaltFactory.createSDocument();
		SampleGenerator.createAnaphoricAnnotations(doc);
		VisJsCreator visJsCreator = new VisJsCreator(doc);
		String outputFolderPath = OUTPUT_FOLDER + FSEP + "sample_doc_anaphoric_ann";	  
		try {
			 URI outputFolderUri = URI.createFileURI(outputFolderPath);	
			 visJsCreator.writeHTML(outputFolderUri);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testHtmlWriterSampleDependencies() {
		SDocument doc = SaltFactory.createSDocument();
		SampleGenerator.createDependencies(doc);
		VisJsCreator visJsCreator = new VisJsCreator(doc);
		String outputFolderPath = OUTPUT_FOLDER + FSEP + "sample_doc_dependencies";	  
		try {
			 URI outputFolderUri = URI.createFileURI(outputFolderPath);	
			 visJsCreator.writeHTML(outputFolderUri);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	
	@Test
	public void testHtmlWriterSampleSyntaxStructure() {
		SDocument doc = SaltFactory.createSDocument();
		SampleGenerator.createSyntaxStructure(doc);
		VisJsCreator visJsCreator = new VisJsCreator(doc);
		String outputFolderPath = OUTPUT_FOLDER + FSEP + "sample_doc_syntax_structure";	  
		try {
			 URI outputFolderUri = URI.createFileURI(outputFolderPath);	
			 visJsCreator.writeHTML(outputFolderUri);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testHtmlWriterSampleTokens() {
		SDocument doc = SaltFactory.createSDocument();
		SampleGenerator.createTokens(doc);
		VisJsCreator visJsCreator = new VisJsCreator(doc);
		String outputFolderPath = OUTPUT_FOLDER + FSEP + "sample_doc_tokens";	  
		try {
			 URI outputFolderUri = URI.createFileURI(outputFolderPath);	
			 visJsCreator.writeHTML(outputFolderUri);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testHtmlWriterSampleMorphologyAnn() {
		SDocument doc = SaltFactory.createSDocument();
		SampleGenerator.createMorphologyAnnotations(doc);
		VisJsCreator visJsCreator = new VisJsCreator(doc);
		String outputFolderPath = OUTPUT_FOLDER + FSEP + "sample_doc_morphology_ann";	  
		try {
			 URI outputFolderUri = URI.createFileURI(outputFolderPath);	
			 visJsCreator.writeHTML(outputFolderUri);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	
	@Test(expected = SaltParameterException.class)
	public void testInputUrlIsNull(){
		URI uri = null;
		VisJsCreator visJsCreator = new VisJsCreator(uri);
	}
	
	@Test(expected = SaltResourceException.class)
	public void testInvalideSaltFormat(){
		String inputFilePath = INPUT_FOLDER + FSEP + "pcc2_random_sentence_invalid_format" + FSEP + "pcc2" + FSEP + "match_0.salt";
		URI uri = URI.createFileURI(inputFilePath);	
		VisJsCreator visJsCreator = new VisJsCreator(uri);
	}
	
	@Test(expected = SaltResourceException.class)
	public void testAbsentSaltResource(){
		String inputFilePath = INPUT_FOLDER + FSEP + "pcc2_random_sentence_absent_resource" + FSEP + "pcc2" + FSEP + "match_0.salt";
		URI uri = URI.createFileURI(inputFilePath);	
		VisJsCreator visJsCreator = new VisJsCreator(uri);
	}
	

	@Test(expected = SaltParameterException.class)
	public void testNodeWriterIsNull(){
		URI uri = URI.createFileURI(INPUT_FILE_MAIN_TEST);	
		VisJsCreator visJsCreator = new VisJsCreator(uri);		
		visJsCreator.setEdgeWriter(System.out);
		visJsCreator.buildJSON();
	}
	
	@Test(expected = SaltParameterException.class)
	public void testEdgeWriterIsNull(){
		URI uri = URI.createFileURI(INPUT_FILE_MAIN_TEST);	
		VisJsCreator visJsCreator = new VisJsCreator(uri);		
		visJsCreator.setNodeWriter(System.out);
		visJsCreator.buildJSON();
	}	
}