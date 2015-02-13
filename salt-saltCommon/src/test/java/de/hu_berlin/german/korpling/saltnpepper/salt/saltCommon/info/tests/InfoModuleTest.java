/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.info.tests;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.Charset;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.info.InfoModule;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.samples.SampleGenerator;

public class InfoModuleTest extends TestCase {
	
	private Logger log = LoggerFactory.getLogger(InfoModule.class);
	

	static final String JAXP_SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";
	static final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
	static final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
	public static final String FILE_TMP_DIR = System.getProperty("java.io.tmpdir");
	public static final File TMP_DIR = new File(FILE_TMP_DIR);
	public static URI TMP_DIR_URI = null;
	private static final String SCHEMA_PATH_SALT_PROJECT = "./src/main/resources/schema/saltProjectInfo.xsd";
	private static final String SCHEMA_PATH_SDOCUMENT = "./src/main/resources/schema/sDocumentInfo.xsd";

	public InfoModuleTest() {
		/*
		 * The path  may end with a with a path separator nor not depending on the operating system.
		 * Since we deal with URIs we need to add a separator if necessary.
		 * see http://bugs.java.com/bugdatabase/view_bug.do?bug_id=4391434
		 */
		TMP_DIR_URI = URI.createFileURI(TMP_DIR.getPath());
		if (!TMP_DIR_URI.hasTrailingPathSeparator()) {
			TMP_DIR_URI = TMP_DIR_URI.appendSegment("");
		}
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
			URI tDir = URI.createFileURI("testWriteInfoFile_SaltProject_File_URI_dir/").resolve(TMP_DIR_URI);
//			tempDir.mkdir();

			SaltProject sp = SampleGenerator.createSaltProject();
			sp.setSName("Test-SaltProject");
			createSDocumentSLayered(sp.getSCorpusGraphs()
					.get(0).getSDocuments().get(0));

			InfoModule infoAdapter = new InfoModule();			
			infoAdapter.setOverwriting(true);
			infoAdapter.writeInfoFile(sp,f, tDir);

			File spInfoFile = f;
//			log.debug("Validating: " + spInfoFile.getName());
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
			createSDocumentSLayered(sdoc);
			addMetaAnnotation(sdoc,"doc-author", "Hans Würst");
			sdoc.setSId("sampleSDocumentID" + i);
			sdoc.setSName("sampleSDocName" + i);
			InfoModule infoAdapter = new InfoModule();
			infoAdapter.setOverwriting(true);
			File sdocFile = new File(sdoctempdir,sdoc.getSName() + ".xml");
			infoAdapter.writeInfoFile(sdoc, sdocFile,null);
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
	 * WARNING: removed due to maven problems 
	 * @throws Exception
	 */
	public void testUnicode() throws Exception {
//		SaltProject sp = SaltFactory.eINSTANCE.createSaltProject();
//		String testString = "Testing «ταБЬℓσ»";
//		sp.setSName(testString);
////		sp.getSCorpusGraphs().add(SaltFactory.eINSTANCE.createSCorpusGraph());
//		URI out = TMP_DIR_URI.appendSegment("unicode").appendFileExtension("xml");
//		sp.printInfo(out);
//		FileReader fr = new FileReader(out.toFileString());
//		char [] buffer = new char[2048];
//		StringBuffer result = new StringBuffer();
//		int len = 0;
//		while((len =fr.read(buffer)) != -1){
//			result.append(buffer, 0, len);
//		}
//		fr.close();
//		log.debug("Result=" +result);
//		assertTrue(result.toString().contains(testString));
		
	}
	public void testPrintInfoFileSCorpus() throws SAXException, IOException, ParserConfigurationException {
		SaltProject sp = SampleGenerator.createSaltProject();
		sp.setSName("Test-SaltProject");
		SDocument first = sp.getSCorpusGraphs().get(0).getSDocuments().get(0);
		
		createSDocumentSLayered(first);
		addMetaAnnotation(first,"doc-author", "Hans Würst");
		SCorpus c = sp.getSCorpusGraphs().get(0).getSRootCorpus().get(0);
		addMetaAnnotation(c.getSCorpusGraph(),"corpus-author", "Hans Würst");
		InfoModule im = new InfoModule();
		im.setOverwriting(true);
		File corpusinfo = new File(FILE_TMP_DIR, "corpusInfo.xml");
//		File tempFolder = new File(FILE_TMP_DIR, );
		URI tFolder = URI.createFileURI("tempCorpInfo/").resolve(TMP_DIR_URI);

		im.writeInfoFile(c, corpusinfo, tFolder);
		validate(corpusinfo,SCHEMA_PATH_SALT_PROJECT);
	}
	
	public void testPrintInfoDocumentXMLStreamWriter() throws XMLStreamException, FactoryConfigurationError, IOException, SAXException, ParserConfigurationException {
		StringWriter buffer = new StringWriter();
		InfoModule im = new InfoModule();
		im.setOverwriting(true);
		SaltProject sp = SampleGenerator.createSaltProject();
		sp.setSName("Test-SaltProject");
		SDocument first = sp.getSCorpusGraphs().get(0).getSDocuments().get(0);
		createSDocumentSLayered(first);
		addMetaAnnotation(first,"doc-author", "Hans Würst");
		
		XMLStreamWriter writer = XMLOutputFactory.newInstance().createXMLStreamWriter(buffer);
//		URI tFolder = (URI.createFileURI(FILE_TMP_DIR).appendSegment("xmlStreamTestTempDir"));
		URI tFolder = URI.createFileURI("InfoModuleTestData/").resolve(TMP_DIR_URI);
		im.writeInfoStream(sp, writer,tFolder);
//		im.createSDocumentInfo(sp);
		validate(buffer,SCHEMA_PATH_SALT_PROJECT);
	}
	
	public void testOmitMetaDataInfo() throws Exception {
		StringWriter buffer = new StringWriter();
		XMLStreamWriter writer = XMLOutputFactory.newInstance().createXMLStreamWriter(buffer);
		InfoModule im = new InfoModule();
		SDocument emptyDocument = SaltFactory.eINSTANCE.createSDocument();
		im.writeInfoStream(emptyDocument, writer);
		assertFalse(buffer.toString().contains("metaDataInfo"));
	}
	
	public void testDocumentStructure() throws Exception {
		StringWriter buffer = new StringWriter();
		XMLStreamWriter writer = XMLOutputFactory.newInstance().createXMLStreamWriter(buffer);
		InfoModule im = new InfoModule();
		SaltProject sproject = SampleGenerator.createSaltProject();
		URI tempUri = URI.createURI("testDocumentStructure").resolve(TMP_DIR_URI);
		im.setWriteAll(true);
		im.writeInfoStream(sproject, writer, tempUri);
		
		 DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		 DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
		 InputStream in = new ByteArrayInputStream(buffer.toString().getBytes(Charset.defaultCharset()));
		 Document doc = docBuilder.parse(in);
		 
		 //TODO: structure test
	}
	
	public void testPrintInfoDocumentXMLStreamWriter__Scorpus() throws XMLStreamException, FactoryConfigurationError, IOException, SAXException, ParserConfigurationException {
		StringWriter buffer = new StringWriter();
		InfoModule im = new InfoModule();
		im.setOverwriting(true);
		SaltProject sp = SampleGenerator.createSaltProject();
		sp.setSName("Test-SaltProject");
		SDocument first = sp.getSCorpusGraphs().get(0).getSDocuments().get(0);
		createSDocumentSLayered(first);
		addMetaAnnotation(first,"doc-author", "Hans Würst");
		
		XMLStreamWriter writer = XMLOutputFactory.newInstance().createXMLStreamWriter(buffer);
//		URI tFolder = (URI.createFileURI(FILE_TMP_DIR).appendSegment("xmlStreamTestTempDir"));
		URI tFolder = URI.createFileURI("InfoModuleTestData/").resolve(TMP_DIR_URI);
		im.writeInfoStream((SCorpus) sp.getSCorpusGraphs().get(0).getRoots().get(0), writer,tFolder);
//		im.createSDocumentInfo(sp);
		validate(buffer,SCHEMA_PATH_SALT_PROJECT);
	}
	
	/**
	 * creates a document with layers
	 * <pre>
	 * 
	 * </pre>
	 */
	private SDocument createSDocumentSLayered(SDocument sDocument) {
		if (sDocument.getSDocumentGraph() == null){
			SampleGenerator.createSDocumentStructure(sDocument);
		}
		SLayer sLayer1 = SaltFactory.eINSTANCE.createSLayer();
		SLayer sLayer2 = SaltFactory.eINSTANCE.createSLayer();
		sLayer1.setSName("sLayer1 mit SRelations");
		sLayer2.setSName("sLayer2 mit STokens");
		sLayer1.setId("sLayer1 mit Annotations:id");
		sLayer2.setId("sLayer2 mit STokens:id");
		for (SRelation sAnno : sDocument.getSDocumentGraph().getSRelations()) {
			sLayer1.getSRelations().add(sAnno);
		}
		for (SToken sToken : sDocument.getSDocumentGraph().getSTokens()) {
			sLayer2.getSNodes().add(sToken);
		}
		sLayer2.setSSuperLayer(sLayer1);
		
		sDocument.getSDocumentGraph().addSLayer(sLayer1);
		sDocument.getSDocumentGraph().addSLayer(sLayer2);

		return sDocument;
	}
	
	public static void addMetaAnnotation(final SMetaAnnotatableElement annotatable, final String name, final String value) {
		SMetaAnnotation sMetaAnno = SaltFactory.eINSTANCE.createSMetaAnnotation();
		sMetaAnno.setName(name);
		sMetaAnno.setSValue(value);
		annotatable.addSMetaAnnotation(sMetaAnno);
	}
	
	public void testPrintInfoComplete() throws Exception{
		SaltProject sp = SampleGenerator.createSaltProject();
		sp.setSName("Test-SaltProject");
		SDocument first = sp.getSCorpusGraphs().get(0).getSDocuments().get(0);
		createSDocumentSLayered(first);
		addMetaAnnotation(first,"doc-author", "Hans Würst");
		SCorpus c = sp.getSCorpusGraphs().get(0).getSRootCorpus().get(0);
		addMetaAnnotation(c.getSCorpusGraph(),"corpus-author", "Hans Würst");
		InfoModule im = new InfoModule();
		URI tFolder = URI.createFileURI("InfoModuleTestData/").resolve(TMP_DIR_URI);
		log.debug("Test folder: " + tFolder);
		URI out = tFolder.appendSegment("SampleInfo").appendFileExtension("xml");
//		sp.printInfo(out);
		im.setCaching(true);
		im.setWriteAll(true);
		im.writeInfoFile(sp, new File(out.toFileString()), tFolder);
	}
	

	public void testPrintInfo_NO_SDOCUMENT_GRAPH(){
		SDocument emptySDoc = SaltFactory.eINSTANCE.createSDocument();
		URI out = URI.createFileURI("emptySDoc.xml").resolve(TMP_DIR_URI);
		try {
			emptySDoc.printInfo(out);
			fail();
		} catch (SaltException e) {
			// TODO: handle exception
		}
	}
	
	public void testGetDocumentLocationURI() throws Exception {
		SDocument sdoc = SaltFactory.eINSTANCE.createSDocument();
		sdoc.setSElementPath(URI.createURI("salt:/rootCorpus/doc1"));
		URI root = URI.createFileURI("/InfoXMLOutput");
		URI res = InfoModule.getDocumentLocationURI(sdoc, root);
		assertEquals("file:/InfoXMLOutput/rootCorpus/doc1", res.toString());
		
		URI relative = InfoModule.getDocumentLocationURI(sdoc, null);
		assertEquals("rootCorpus/doc1", relative.toString());
	}

	private void validate(final File f, final String schema) throws SAXException, IOException,
			ParserConfigurationException {
		log.debug("Validating: " + f.getName());
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
				log.error(exception.getMessage());
				throw new SAXParseException("XML not valid", null);
			}
			
			@Override
			public void fatalError(SAXParseException exception) throws SAXException {
				log.error(exception.getMessage());
				throw new SAXParseException("XML not valid", null);
			}
			
			@Override
			public void error(SAXParseException exception) throws SAXException {
				log.error(exception.getMessage());
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
}
