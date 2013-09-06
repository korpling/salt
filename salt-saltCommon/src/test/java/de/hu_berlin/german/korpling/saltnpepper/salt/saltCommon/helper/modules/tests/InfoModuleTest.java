/**
 * Copyright 2009 Humboldt University of Berlin, INRIA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.helper.modules.tests;

import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.helper.modules.InfoModule;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.samples.SampleGenerator;

public class InfoModuleTest extends TestCase {

	static final String JAXP_SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";
	static final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
	static final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
	public static final String FILE_TMP_DIR = "_TMP/";
	public static final File TMP_DIR = new File(FILE_TMP_DIR);
	public static URI TMP_DIR_URI = null;
	private static final String SCHEMA_PATH_SALT_PROJECT = "./src/main/resources/schema/saltProjectInfo.xsd";
	private static final String SCHEMA_PATH_SDOCUMENT = "./src/main/resources/schema/sDocumentInfo.xsd";

	public InfoModuleTest() {
		TMP_DIR_URI = URI.createFileURI(TMP_DIR.toURI().getRawPath() + File.separator);
	}
	private FilenameFilter xmlFilter = new FilenameFilter() {
		@Override
		public boolean accept(File dir, String name) {
			return (name.endsWith(".xml"));
		}
	};
	
	/**
	 * Test if valid Info files for a SaltProject can be generated without errors
	 * 
	 * @throws Exception
	 */
	public void testWriteInfoFile_SaltProject_File_URI() throws Exception {
			File f = new File(FILE_TMP_DIR, "statTestSaltProject.xml");
//			File tempDir = new File(FILE_TMP_DIR, "testWriteInfoFile_SaltProject_File_URI_dir/");
			URI tDir = URI.createFileURI("testWriteInfoFile_SaltProject_File_URI_dir/").resolve(TMP_DIR_URI);
//			tempDir.mkdir();

			SaltProject sp = SampleGenerator.createCompleteSaltproject();
			sp.setSName("Test-SaltProject");
			SampleGenerator.createSDocumentSLayered(sp.getSCorpusGraphs()
					.get(0).getSDocuments().get(0));

			InfoModule infoAdapter = new InfoModule();			
			infoAdapter.setOverwriting(true);
			infoAdapter.writeInfoFile(sp,f, tDir);

			File spInfoFile = f;
//				System.out.println("Validating: " + spInfoFile.getName());
			validate(spInfoFile,SCHEMA_PATH_SALT_PROJECT);
	}

	/**
	 * TODO: Rewrite this old test
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public void testSDocumentFileWriter() throws IOException, SAXException, ParserConfigurationException {
		EList<File> files = new BasicEList<File>();
		File sdoctempdir = new File(FILE_TMP_DIR, "sDocumentsXMLTestFiles/");
		sdoctempdir.mkdir();
		int n = 1;
		for (int i = 0; i < n; i++) {
			SDocument sdoc = SaltFactory.eINSTANCE.createSDocument();
			SampleGenerator.createSDocumentStructure(sdoc);
			SampleGenerator.createSDocumentSLayered(sdoc);
			SampleGenerator.addMetaAnnotation(sdoc,"doc-author", "Hans W??rst");
			sdoc.setSId("sampleSDocumentID" + i);
			sdoc.setSName("sampleSDocName" + i);
			InfoModule infoAdapter = new InfoModule();
			infoAdapter.setOverwriting(true);
			File sdocFile = new File(sdoctempdir,sdoc.getSName() + ".xml");
			infoAdapter.writeInfoFile(sdoc, sdocFile);
			files.add(sdocFile);
		}

		if(sdoctempdir.listFiles().length == 0){
			fail("Expected one file to be written");
		}
		
		for (File f : files) {
				validate(f,SCHEMA_PATH_SALT_PROJECT);
		}
	}
	
	/**
	 * TODO: proper test, because with JUnit, but not witch Maven
	 * @throws Exception
	 */
	public void testUnicode() throws Exception {
		SaltProject sp = SaltFactory.eINSTANCE.createSaltProject();
		String testString = "??Testing ?????????????????: 13, now 20% off! ??(-??????-??)?? ??(??????????????)?? ??(????????????)?? ??(-???????????).";
		sp.setSName(testString);
//		sp.getSCorpusGraphs().add(SaltFactory.eINSTANCE.createSCorpusGraph());
		URI out = TMP_DIR_URI.appendSegment("unicode").appendFileExtension("xml");
		sp.printInfo(out);
		FileReader fr = new FileReader(out.toFileString());
		char [] buffer = new char[2048];
		StringBuffer result = new StringBuffer();
		int len = 0;
		while((len =fr.read(buffer)) != -1){
			result.append(buffer, 0, len);
		}
		fr.close();
		System.out.println("Result=" +result);
		//assertTrue(result.toString().contains(testString));
		
	}
	public void testPrintInfoFileSCorpus() throws SAXException, IOException, ParserConfigurationException {
		SaltProject sp = SampleGenerator.createCompleteSaltproject();
		sp.setSName("Test-SaltProject");
		SDocument first = sp.getSCorpusGraphs().get(0).getSDocuments().get(0);
		SampleGenerator.createSDocumentSLayered(first);
		SampleGenerator.addMetaAnnotation(first,"doc-author", "Hans W??rst");
//		SaltFactory.eINSTANCE.createSaltProject().getSCorpusGraphs().add(cg);
		SCorpus c = sp.getSCorpusGraphs().get(0).getSRootCorpus().get(0);
		SampleGenerator.addMetaAnnotation(c.getSCorpusGraph(),"corpus-author", "Hans W??rst");
		InfoModule im = new InfoModule();
		im.setOverwriting(true);
		File corpusinfo = new File(FILE_TMP_DIR, "corpusInfo.xml");
//		File tempFolder = new File(FILE_TMP_DIR, );
		URI tFolder = URI.createFileURI("tempCorpInfo/").resolve(TMP_DIR_URI);
//		tempFolder.mkdir();
//		c.setSName("rootCorpus");
//		c.setSId(c.getSName() + "_graph");
		im.writeInfoFile(c, corpusinfo, tFolder);
		validate(corpusinfo,SCHEMA_PATH_SALT_PROJECT);
	}
	
	public void testPrintInfoDocumentXMLStreamWriter() throws XMLStreamException, FactoryConfigurationError, IOException, SAXException, ParserConfigurationException {
		StringWriter buffer = new StringWriter();
		InfoModule im = new InfoModule();
		im.setOverwriting(true);
		SaltProject sp = SampleGenerator.createCompleteSaltproject();
		sp.setSName("Test-SaltProject");
		SDocument first = sp.getSCorpusGraphs().get(0).getSDocuments().get(0);
		SampleGenerator.createSDocumentSLayered(first);
		SampleGenerator.addMetaAnnotation(first,"doc-author", "Hans W??rst");
		
		XMLStreamWriter writer = XMLOutputFactory.newInstance().createXMLStreamWriter(buffer);
//		URI tFolder = (URI.createFileURI(FILE_TMP_DIR).appendSegment("xmlStreamTestTempDir"));
		URI tFolder = URI.createFileURI("xmlStreamTestTempDir/").resolve(TMP_DIR_URI);
		im.writeInfoStream(sp, writer,tFolder);
		validate(buffer,SCHEMA_PATH_SALT_PROJECT);
	}
	

	public void testPrintInfo_NO_SDOCUMENT_GRAPH(){
		SDocument emptySDoc = SaltFactory.eINSTANCE.createSDocument();
		URI out = URI.createFileURI("emptySDoc.xml").resolve(TMP_DIR_URI);
		try {
			emptySDoc.printInfo(out);
		} catch (SaltException e) {
			// TODO: handle exception
		}
	}
	
	public void testGetDocumentLocationURI() throws Exception {
		SDocument sdoc = SaltFactory.eINSTANCE.createSDocument();
		sdoc.setSElementPath(URI.createURI("blablabla:/rootCorpus/doc1"));
		URI root = URI.createFileURI("/InfoXMLOutput").appendSegment(URI.encodeSegment("", false));
		URI res = InfoModule.getDocumentLocationURI(sdoc, root);
		assertEquals("file:/InfoXMLOutput/rootCorpus/doc1.xml", res.toString());
	}

	private void validate(final File f, final String schema) throws SAXException, IOException,
			ParserConfigurationException {
		System.out.println("Validating: " + f.getName());
		XMLReader reader = getXMLParser(schema);
		reader.parse(f.getAbsolutePath());
	}
	
	private void validate(final StringWriter buffer, final String schema) throws SAXException, ParserConfigurationException, IOException {
		XMLReader reader = getXMLParser(schema);
		StringReader sr = new StringReader(buffer.toString());
		InputSource is = new InputSource(sr);
		reader.parse(is);
	}

	/**
	 * @return
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	private XMLReader getXMLParser(final String schemaLocation) throws SAXException,
			ParserConfigurationException {
		SchemaFactory schemafac = SchemaFactory
				.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//		 TODO: Path relative to Ressource
		File schemaF = new File(schemaLocation);
		Source schemaFile = new StreamSource(schemaF);
		Schema schema = schemafac.newSchema(schemaFile);
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setNamespaceAware(true);
		factory.setValidating(false);
		factory.setSchema(schema);
		SAXParser parser =  factory.newSAXParser();
		XMLReader reader = parser.getXMLReader();
		reader.setErrorHandler(new ErrorHandler() {
			
			@Override
			public void warning(SAXParseException exception) throws SAXException {
				System.out.println(exception.getMessage());
				throw new SAXParseException("XML not valid", null);
			}
			
			@Override
			public void fatalError(SAXParseException exception) throws SAXException {
				System.out.println(exception.getMessage());
				throw new SAXParseException("XML not valid", null);
			}
			
			@Override
			public void error(SAXParseException exception) throws SAXException {
				System.out.println(exception.getMessage());
				throw new SAXParseException("XML not valid", null);
			}
		});
		return reader;
	}

	public void validate(final File f) throws SAXException, IOException, ParserConfigurationException {
		validate(f, SCHEMA_PATH_SALT_PROJECT);
	}
	public void validate(URI res) throws SAXException, IOException, ParserConfigurationException {
		// TODO Auto-generated method stub
		validate(new File(res.toFileString()),SCHEMA_PATH_SALT_PROJECT);
	}
	/**
	 * TODO: Actual test data has to be provided by the repository
	 */
	public void testBigFiles(){
//		if(true){
//			PCC2();
//		}
//		if(false){
//			Ridges();
//		}
	}
	public void PCC2() {
//       TODO: Remove this test
		URI pcc2URI = URI.createFileURI("/Developer/SaltNPepper_2012.10.01/workspace/saltxmlppc2/saltProject.salt");
		SCorpusGraph pcc2Graph = SaltFactory.eINSTANCE.loadSCorpusGraph(pcc2URI);
		SaltProject pcc2Project = SaltFactory.eINSTANCE.createSaltProject();
//		pcc2Project.setSName("pp2 Import Test");
		pcc2Project.getSCorpusGraphs().add(pcc2Graph);
		
		File pcc2xml = new File(FILE_TMP_DIR, "pcc2Info.xml");
//		URI res = URI.createFileURI(pcc2xml.getAbsolutePath());
		System.out.println(TMP_DIR_URI);
		URI res = URI.createFileURI("pcc2Info.xml").resolve(TMP_DIR_URI);
		pcc2Project.printInfo(res);
		System.out.println("fin");
	}
			public void Ridges() {
//      TODO: Remove this test
		URI pcc2URI = URI.createFileURI("/Developer/SaltNPepper_2013.05.21/workspace/saltRidges/saltProject.salt");
		SCorpusGraph pcc2Graph = SaltFactory.eINSTANCE.loadSCorpusGraph(pcc2URI);
		SaltProject pcc2Project = SaltFactory.eINSTANCE.createSaltProject();
		pcc2Project.setSName("Ridges Test");
		pcc2Project.getSCorpusGraphs().add(pcc2Graph);
		
		File pcc2xml = new File(FILE_TMP_DIR, "ridges2Info.xml");
		URI res = URI.createFileURI(pcc2xml.getAbsolutePath());
		pcc2Project.printInfo(res);
		System.out.println("fin");
	}
	
	// TODO: Test write to Stream
	// TODO: Test for correct count

}
