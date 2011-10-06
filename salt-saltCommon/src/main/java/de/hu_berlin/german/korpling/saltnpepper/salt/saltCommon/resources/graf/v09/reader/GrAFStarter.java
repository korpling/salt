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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.graf.v09.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.graf.v09.GrAFResource;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.graf.v09.GrAFResource.GRAF_MAPPING_TYPE;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;

public class GrAFStarter 
{
	private static Boolean isFlo= true;
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException 
	{
		SaltProject project = SaltFactory.eINSTANCE.createSaltProject();
		String grafPath="d:/projects_work/grAF/graf_test/";
		File file= new File(grafPath);
		if (!file.exists())
			throw new FileNotFoundException("Cannot run test, because file does not exist: "+ file.getAbsolutePath());
		Properties props = new Properties();
		props.put(GrAFResource.PROP_GRAF_HEADER_FILE_ENDING, "pdh");
		props.put(GrAFResource.PROP_GRAF_LAYER_TO_TYPE+".xle", GRAF_MAPPING_TYPE.HIERARCHIE);
		props.put(GrAFResource.PROP_GRAF_LAYER_TO_TYPE+".is", GRAF_MAPPING_TYPE.HIERARCHIE);
		props.put(GrAFResource.PROP_GRAF_LAYER_TO_TYPE+".prosody", GRAF_MAPPING_TYPE.HIERARCHIE);
		
		project.loadSaltProject_GrAF(URI.createFileURI(file.getAbsolutePath()),props);
//		project.loadSaltProjectFromGrAF(URI.createFileURI(new File("d:/projects_work/grAF/graf_test/").getAbsolutePath()));
//		if (isFlo)
//		{
//			File file= new File("d:/projects_work/grAF/graf_test/");
//			GrAFResource grafResource= new GrAFResource();
//			grafResource.setURI(URI.createFileURI(file.getAbsolutePath()));
//			grafResource.load(null);
//		}
//		else
//		{
//			EList<File> files= new BasicEList<File>();
//			files.add(new File("D:/Berlin201104/graf_test/partdlf-nachrichten-200703260000-xle.graf"));
//			files.add(new File("D:/Berlin201104/graf_test/partdlf-nachrichten-200703260000-is.graf"));
//			files.add(new File("D:/Berlin201104/graf_test/partdlf-nachrichten-200703260000-prosody.graf"));
//			//...
//			SDocumentGraph sDocGraph= SaltFactory.eINSTANCE.createSDocumentGraph();
//			STextualDS sText = SaltFactory.eINSTANCE.createSTextualDS(); 
//			sDocGraph.addSNode(sText);
//			sText.setSText("die Kanzlerin zeigte sich zuversichtlich, dass die Mehrheit der EU-Staaten hinter diesem Ziel stehe.");
//			sText = SaltFactory.eINSTANCE.createSTextualDS();
//			sDocGraph.addSNode(sText);
//			sText.setSText("Die Kanzlerin zeigte sich zuversichtlich dass die Mehrheit der EU Staaten hinter diesem Ziel stehe");
//			SAXParserFactory factory= SAXParserFactory.newInstance();
//			for (File file: files)
//			{
//				GrAFHeaderReader grafHeaderReader= new GrAFHeaderReader();
//				grafHeaderReader.setsDocumentGraph(sDocGraph);
//				{//SAX-Parser
//					SAXParser parser;
//			        XMLReader xmlReader;
//			        try {
//			        	parser= factory.newSAXParser();
//					    xmlReader= parser.getXMLReader();
//				        //create and set content handler
//				        xmlReader.setContentHandler(grafHeaderReader);
//				        
//				        //setting LexicalHandler to read DTD
//				        xmlReader.setProperty("http://xml.org/sax/properties/lexical-handler", grafHeaderReader);
//				        xmlReader.setContentHandler(grafHeaderReader);
//				        
//				        xmlReader.parse(file.getAbsolutePath());
//				        
//				    } catch (ParserConfigurationException e) {
//			        	throw new SaltException("Cannot load exmaralda from resource '"+file.getAbsolutePath()+"'.", e);
//			        } catch (SAXException e) {
//			        	throw new SaltException("Cannot load exmaralda from resource '"+file.getAbsolutePath()+"'.", e);
//					} catch (IOException e) {
//						throw new SaltException("Cannot load exmaralda from resource '"+file.getAbsolutePath()+"'.", e);
//					}
//				}//SAX-Parser
//			}
//		}
	}

}
