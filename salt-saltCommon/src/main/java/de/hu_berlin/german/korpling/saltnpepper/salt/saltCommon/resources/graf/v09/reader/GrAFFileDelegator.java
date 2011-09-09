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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltResourceException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.graf.v09.GrAFExternalHeaderReader;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.graf.v09.GrAFResource;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.graf.v09.GrAFResource.GRAF_MAPPING_TYPE;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;

/**
 * This method is the entry point to load salt data from a file in GrAF v0.9 format. This method will create a GrAFHeaderReader object and
 * a GrAFReader object for each given file. An object of this class can also be used as callback for GrAFHeaderReader, to load a file which
 * is a dependency for the current read one.
 * @author Florian Zipser
 *
 */
public class GrAFFileDelegator {
	/**
	 * A table containing the types given by the GrAF project and the corresponding files.
	 */
	private Hashtable<File, String> file2Type= null;
	public void setFile2Type(Hashtable<File, String> file2Type) {
		this.file2Type = file2Type;
	}

	public Hashtable<File, String> getFile2Type() {
		return file2Type;
	}
	
//	================================== start: type2grafMappingType	
	/**
	 * Contains a mapping between GrAF type (layer name) and the type of how data of this layer shall be mapped 
	 */
	private Hashtable<String, GRAF_MAPPING_TYPE> type2grafMappingType= null;
	public void setType2grafMappingType(Hashtable<String, GRAF_MAPPING_TYPE> type2grafMappingType) {
		this.type2grafMappingType = type2grafMappingType;
	}

	public Hashtable<String, GRAF_MAPPING_TYPE> getType2grafMappingType() {
		return type2grafMappingType;
	}
//	================================== end: type2grafMappingType	
// =================================== start: mapping properties
	private Properties mappingProps= null;
	public void setMappingProps(Properties mappingProps) 
	{
		this.mappingProps= mappingProps;
		System.out.println("----> setMappingProps: "+ mappingProps);
		if (mappingProps!= null)
		{//extract type to GrAF_MAPPING_TYPE mapping
			Enumeration<Object> keys= mappingProps.keys();
			while(keys.hasMoreElements())
			{
				String key= keys.nextElement().toString();
				if (key.contains(GrAFResource.PROP_GRAF_LAYER_TO_TYPE))
				{
					String value= mappingProps.get(key).toString();
					System.out.println("key: "+ key);
					System.out.println("value: "+ value);
					if (value== null)
						throw new SaltResourceException("Cannot read resource, because a property with key '"+GrAFResource.PROP_GRAF_LAYER_TO_TYPE+"' is not matchable to '"+GRAF_MAPPING_TYPE.class+"' for value '"+value+"'.");
					key= key.replace(GrAFResource.PROP_GRAF_LAYER_TO_TYPE+".", "");
					if (type2grafMappingType== null)
						type2grafMappingType= new Hashtable<String, GrAFResource.GRAF_MAPPING_TYPE>();
					try{
						type2grafMappingType.put(key, GRAF_MAPPING_TYPE.valueOf(value));
					}
					catch (Exception e) {
						throw new SaltResourceException("Cannot read resource, because a property with key '"+GrAFResource.PROP_GRAF_LAYER_TO_TYPE+"' is not matchable to '"+GRAF_MAPPING_TYPE.class+"' for value '"+value+"'.");
					}
				}
			}
			System.out.println("type2grafMappingType: "+ type2grafMappingType);
		}//extract type to GrAF_MAPPING_TYPE mapping
		System.out.println("<---- setMappingProps");
	}

	public Properties getMappingProps() {
		return mappingProps;
	}
// =================================== end: mapping properties
	
//	================================== start: SDocumentGraph
	/**
	 * the SDocumentGraph object, where all nodes, relations annotations etc. are supposed to be mapped in.
	 */
	private SDocumentGraph sDocumentGraph= null;

	public void setsDocumentGraph(SDocumentGraph sDocumentGraph) {
		this.sDocumentGraph = sDocumentGraph;
	}

	public SDocumentGraph getsDocumentGraph() {
		return sDocumentGraph;
	}
//	================================== end: SDocumentGraph	
	
	private volatile SAXParserFactory factory= null;
	public SAXParser getSaxParser() throws ParserConfigurationException, SAXException
	{
		if (factory== null)
		{
			synchronized (this) {
				if (factory== null)
					factory= SAXParserFactory.newInstance();
			}
		}
		return(this.factory.newSAXParser());
	}
//	================================== start: path of GrAF corpus (document)	
	/**
	 * Current path, which contains the graf files.
	 */
	private File grafPath= null;
	public File getGrafPath() {
		return grafPath;
	}

	public void setGrafPath(File grafPath) {
		this.grafPath = grafPath;
	}
//	================================== end: path of GrAF corpus (document)
	/**
	 * Starts reading the given GrAF file and recursively calls reading dependency files of the given one.
	 * @param type can either be just the type or a filename.
	 */
	public void startAnnLoc(String type)
	{
		File grafFile= null;
		grafFile= new File(this.getGrafPath()+ "/"+ type);
		if (!grafFile.exists())
			throw new SaltResourceException("Cannot read graf resource '"+grafFile.getAbsolutePath()+"', because file does not exists.");
		this.start(grafFile);
	}
	
	/**
	 * A list of GrAF files which are currently not processed.
	 */
	private EList<File> grafFilesToProcess= null;

	public EList<File> getGrafFilesToProcess() 
	{
		if (grafFilesToProcess== null)
		{
			synchronized (this) {
				if (grafFilesToProcess== null)
					grafFilesToProcess= new BasicEList<File>();
			}
		}
		return grafFilesToProcess;
	}
	
	/**
	 * A list of GrAF files which are currently not processed.
	 */
	private EList<File> grafFilesAlreadyProcessed= null;

	public EList<File> getGrafFilesAlreadyProcessed() 
	{
		if (grafFilesAlreadyProcessed== null)
		{
			synchronized (this) {
				if (grafFilesAlreadyProcessed== null)
					grafFilesAlreadyProcessed= new BasicEList<File>();
			}
		}
		return grafFilesAlreadyProcessed;
	}
	
	/**
	 * Reads the external header file of graf and returns a list of all primary data files.
	 * @param externalHeaderFile
	 * @return
	 */
	public EList<File> readGrAFExternalHeader(File externalHeaderFile)
	{
		GrAFExternalHeaderReader grafExternalHeaderReader= new GrAFExternalHeaderReader();
		grafExternalHeaderReader.setCurrentPath(externalHeaderFile.getParentFile());
		XMLReader xmlReader;
        
        try {
	        SAXParser parser= this.getSaxParser();
	        xmlReader= parser.getXMLReader();

	        xmlReader.setContentHandler(grafExternalHeaderReader);
	        xmlReader.setProperty("http://xml.org/sax/properties/lexical-handler", grafExternalHeaderReader);
			xmlReader.setDTDHandler(grafExternalHeaderReader);
			
			InputStream inputStream= new FileInputStream(externalHeaderFile.getAbsoluteFile());
			Reader reader = new InputStreamReader(inputStream,"UTF-8");
			InputSource is = new InputSource(reader);
			is.setEncoding("UTF-8");
	        xmlReader.parse(is);
		} catch (SAXNotRecognizedException e) {
			e.printStackTrace();
		} catch (SAXNotSupportedException e) 
		{
			throw new SaltResourceException("Cannot read GrAF file '"+externalHeaderFile.getAbsolutePath()+"'.",e);
		} catch (ParserConfigurationException e) 
		{
			throw new SaltResourceException("Cannot read GrAF file '"+externalHeaderFile.getAbsolutePath()+"'.",e);
		} catch (SAXException e) 
		{
			throw new SaltResourceException("Cannot read GrAF file '"+externalHeaderFile.getAbsolutePath()+"'.",e);
		} catch (IOException e) 
		{
			throw new SaltResourceException("Cannot read GrAF file '"+externalHeaderFile.getAbsolutePath()+"'.",e);
		}
		this.setFile2Type(grafExternalHeaderReader.getFile2Type());
		return(grafExternalHeaderReader.getPrimaryDataFiles());
	}
	
	/**
	 * Reads a primary data file and adds it to the SDocumentGraph
	 * @return returns the created STextualDS file
	 */
	public STextualDS readPrimaryDataFile(File primaryDataFile)
	{
		{//read text files
			STextualDS sText= null;
			StringBuffer primaryText= new StringBuffer();
			try
			{
				BufferedReader inReader = new BufferedReader(new InputStreamReader(new FileInputStream(primaryDataFile), "UTF8"));
				String input = "";
				try
				{
					while((input = inReader.readLine()) != null) 
						primaryText.append(input);
				}
				finally
				{
					inReader.close();
				}
			}
			catch (Exception e) 
			{
				throw new SaltResourceException("Cannot read a primary data file '"+primaryDataFile.getAbsolutePath()+"'.",e);
			}
			sText= SaltFactory.eINSTANCE.createSTextualDS();
			sText.setSText(primaryText.toString());
			sText.setSName(primaryDataFile.getName());
			this.getsDocumentGraph().addSNode(sText);
			return(sText);
		}//read text files
	}
	
	/**
	 * Starts reading the given GrAF file and recursively calls reading dependency files of the given one.
	 * @return returns an STextualDS object, if dependency was a primary data file, which was created for the primary data file
	 */
	public STextualDS start(File grafFile)
	{
		STextualDS retVal= null;
		if (!grafFile.getName().endsWith(SaltFactory.GRAF_FILE_ENDING))
		{//file must be a primary data file
			retVal= this.readPrimaryDataFile(grafFile);
		}//file must be a primary data file
		else
		{//file is GrAF file
			if (!this.getGrafFilesAlreadyProcessed().contains(grafFile))
			{
				this.getGrafFilesToProcess().remove(grafFile);
				this.getGrafFilesAlreadyProcessed().add(grafFile);
		
				if (this.getFile2Type()== null)
					throw new SaltResourceException("Cannot start reading file '"+grafFile+"', because a table for mapping from file to GrAF type (layer) is null. This might be a bug.");
				if (this.getType2grafMappingType()== null)
					throw new SaltResourceException("Cannot start reading file '"+grafFile+"', because a table for mapping GrAF type (layer) to mapping type for Salt objects is null. This might be a bug.");
				GrAFHeaderReader grafHeaderReader= new GrAFHeaderReader();
				grafHeaderReader.setGrafFileDelegator(this);
				
				grafHeaderReader.setFileResource(grafFile);
				grafHeaderReader.setsDocumentGraph(this.getsDocumentGraph());
				
				XMLReader xmlReader;
		        
		        try {
			        SAXParser parser= this.getSaxParser();
			        xmlReader= parser.getXMLReader();
		
			        xmlReader.setContentHandler(grafHeaderReader);
			        xmlReader.setProperty("http://xml.org/sax/properties/lexical-handler", grafHeaderReader);
					xmlReader.setDTDHandler(grafHeaderReader);
					
					InputStream inputStream= new FileInputStream(grafFile.getAbsoluteFile());
					Reader reader = new InputStreamReader(inputStream,"UTF-8");
					InputSource is = new InputSource(reader);
					is.setEncoding("UTF-8");
			        xmlReader.parse(is);
				} catch (SAXNotRecognizedException e) {
					e.printStackTrace();
				} catch (SAXNotSupportedException e) 
				{
					throw new SaltResourceException("Cannot read GrAF file '"+grafFile.getAbsolutePath()+"'.",e);
				} catch (ParserConfigurationException e) 
				{
					throw new SaltResourceException("Cannot read GrAF file '"+grafFile.getAbsolutePath()+"'.",e);
				} catch (SAXException e) 
				{
					throw new SaltResourceException("Cannot read GrAF file '"+grafFile.getAbsolutePath()+"'.",e);
				} catch (IOException e) 
				{
					throw new SaltResourceException("Cannot read GrAF file '"+grafFile.getAbsolutePath()+"'.",e);
				}
			}//file is GrAF file
		}
		return(retVal);
	}
}
