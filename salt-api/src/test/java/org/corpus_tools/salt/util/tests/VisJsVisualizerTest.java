package org.corpus_tools.salt.util.tests;

import java.io.BufferedWriter;
import java.io.File;
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
//import junit.framework.Assert;

public class VisJsVisualizerTest {
	private final static String FSEP = System.getProperty("file.separator");
	private final static String OUTPUT_FOLDER = SaltTestsUtil.getTempTestFolder().getAbsolutePath();
	
	private final static String INPUT_FOLDER =  "src"	+ FSEP+"test"	+ FSEP+ "resources" + FSEP + "VisJsTest" + FSEP + "sources";
	private final static String INPUT_FILE_MAIN_TEST = INPUT_FOLDER + FSEP + "pcc2_salt" + FSEP + "pcc2" + FSEP  + "11299.salt";
	
	  
	
	@Test
	public void testHtmlWriterWholeDocLoadJson() {
	//	String inputFilePath = INPUT_FOLDER + FSEP + "pcc2_salt" + FSEP + "pcc2" + FSEP  + "11299.salt";
		String inputFilePath = INPUT_FILE_MAIN_TEST;		
		String outputFolderPath = OUTPUT_FOLDER + FSEP + "pcc_whole_doc_11299_load_json";	   
		
		URI uri = URI.createFileURI(inputFilePath);	
		VisJsVisualizer visJsVisualizer = new VisJsVisualizer(uri);
		
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
	public void testHtmlWriterWholeDoc() {
	//	String inputFilePath = INPUT_FOLDER + FSEP + "pcc2_salt" + FSEP + "pcc2" + FSEP  + "11299.salt";
		String inputFilePath = INPUT_FILE_MAIN_TEST;		
		String outputFolderPath = OUTPUT_FOLDER + FSEP + "pcc_whole_doc_11299";	   
		
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
	
	
	//@Test
	public void testJsonWholeCorpus(){
	//	String inputFilePath = INPUT_FOLDER + FSEP + "pcc2_salt" + FSEP	+ "pcc2" + FSEP  + "11299.salt";
		String inputFilePath = INPUT_FILE_MAIN_TEST;		
		URI uri = URI.createFileURI(inputFilePath);	
		VisJsVisualizer visJsVisualizer = new VisJsVisualizer(uri);
		
		visJsVisualizer.setNodeWriter(System.out);
		visJsVisualizer.setEdgeWriter(System.out);
		visJsVisualizer.setOptionsWriter(System.out);
		visJsVisualizer.buildJSON();
		try {
			visJsVisualizer.buildOptions();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		BufferedWriter ow;
				
		try {
			ow = visJsVisualizer.getNodeWriter();
			ow.newLine();
			ow.flush();	
			
			//ow = visJsVisualizer.getEdgeWriter();		
		//	ow.newLine();
		//	ow.flush();	
	
			ow = visJsVisualizer.getOptionsWriter();
			ow.flush();
			ow.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	@Test
	public void testHtmlWriterSampleLoadJson() {
		SDocument doc = SaltFactory.createSDocument();
		SampleGenerator.createDocumentStructure(doc);	
		VisJsVisualizer visJsVisualizer = new VisJsVisualizer(doc);
		String outputFolderPath = OUTPUT_FOLDER + FSEP + "sample_doc_load_json";	  
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
	public void testHtmlWriterSample() {
		SDocument doc = SaltFactory.createSDocument();
		SampleGenerator.createDocumentStructure(doc);	
		VisJsVisualizer visJsVisualizer = new VisJsVisualizer(doc);
		String outputFolderPath = OUTPUT_FOLDER + FSEP + "sample_doc";	  
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
		String outputFolderPath = OUTPUT_FOLDER + FSEP + "sample_doc_anaphoric_ann_load_json";	  
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
		String outputFolderPath = OUTPUT_FOLDER + FSEP + "sample_doc_dependencies";	  
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
		String outputFolderPath = OUTPUT_FOLDER + FSEP + "sample_doc_syntax_structure";	  
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
		String outputFolderPath = OUTPUT_FOLDER + FSEP + "sample_doc_tokens";	  
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
		String outputFolderPath = OUTPUT_FOLDER + FSEP + "sample_doc_morphology_ann";	  
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