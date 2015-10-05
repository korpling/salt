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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.graf.v09.reader;

import java.io.File;
import java.util.Hashtable;
import java.util.Properties;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltResourceException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.graf.v09.GrAFResource;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.graf.v09.GrAFResource.GRAF_MAPPING_TYPE;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;

public class GrAFHeaderReader extends DefaultHandler2 
{
	public static final String ELEMENT_HEADER= "header";
	public static final String ELEMENT_DEPENDENCEON= "dependsOn";
	public static final String ELEMENT_DEPENDENCEON_TYPE= "type";
	public static final String ELEMENT_DEPENDENCEON_ANNLOC= "ann.loc";
	
	/**
	 * True if currently processed XML-elements are children of header
	 */
	private boolean isHeader= false;
// =================================== start: mapping properties
	private Properties mappingProps= null;
	public void setMappingProps(Properties mappingProps) {
		this.mappingProps = mappingProps;
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
		if (this.getRealGrafReader()!= null)
			this.getRealGrafReader().setsDocumentGraph(getsDocumentGraph());
	}

	public SDocumentGraph getsDocumentGraph() {
		return sDocumentGraph;
	}
//	================================== end: SDocumentGraph	
	
	/**
	 * The reader object to make the real mapping of document data.
	 */
	private GrAFReader realGrafReader= null;
	public GrAFReader getRealGrafReader() 
	{
		if (realGrafReader== null)
		{
			synchronized (this) 
			{
				if (realGrafReader== null)
					realGrafReader= new GrAFReader();
				realGrafReader.setFileResource(this.getFileResource());
				realGrafReader.setMappingProps(this.getMappingProps());
				if (this.getFileResource()== null)
					throw new SaltResourceException("Cannot load data from GrAF corpus, because the file resource is null.");
				if (this.getGrafFileDelegator()== null)
					throw new SaltResourceException("Cannot load data from GrAF corpus, because the file delegator object is null.");
				if (this.getGrafFileDelegator().getFile2Type()== null)
					throw new SaltResourceException("Cannot load data from GrAF corpus, because the file to type table is null.");
				String type= this.getGrafFileDelegator().getFile2Type().get(this.getFileResource());
				if (type== null)
					throw new SaltResourceException("Cannot load data from GrAF corpus, because the header file does not contain a mapping between file and type for file '"+this.getFileResource().getAbsolutePath()+"'. All known mappings are: "+ this.getGrafFileDelegator().getFile2Type());
				realGrafReader.setGrAFType(type);
				realGrafReader.setMappingType(this.getGrafFileDelegator().getType2grafMappingType().get(type));
			}
		}
		return realGrafReader;
	}
// ============================== start: GrAFFileDelegator
	/**
	 * The GrafFileDelegator to start reading depenencies
	 */
	private GrAFFileDelegator grafFileDelegator= null;
	public GrAFFileDelegator getGrafFileDelegator() {
		return grafFileDelegator;
	}

	public void setGrafFileDelegator(GrAFFileDelegator grafFileDelegator) {
		this.grafFileDelegator = grafFileDelegator;
	}
// ============================== end: GrAFFileDelegator
	
//	public void setRealGrafReader(GrAFReader realGrafReader) 
//	{
//		this.realGrafReader = realGrafReader;
//		if (this.getsDocumentGraph()!= null)
//			this.getRealGrafReader().setsDocumentGraph(getsDocumentGraph());
//	}
// ========================================== start: fileResource
	/**
	 * the resource, from where the data shall be loaded.
	 */
	private File fileResource= null;
	/**
	 * Sets the resource, from where the data shall be loaded.
	 * @param destination the destination to set
	 */
	public void setFileResource(File destination) {
		this.fileResource = destination;
	}

	/**
	 * Returns the resource, from where the data shall be loaded.
	 * @return the destination
	 */
	public File getFileResource() {
		return fileResource;
	}
// ========================================== end: fileResource

	

	/**
	 * Extracts some general information, which can be necessary for all derived specific readers.
	 * If a file has been detected in xml-base, this methods makes sure, that it will be imported before.
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(	String uri,
            					String localName,
            					String qName,
            					Attributes attributes) throws SAXException
    {
		try
		{
			if (qName.equalsIgnoreCase(ELEMENT_HEADER))
			{//element HEADER
				this.isHeader= true;
			}//element HEADER
			if (!isHeader)
			{
				if (this.getRealGrafReader()!= null)
				{
					this.getRealGrafReader().startElement(uri, localName, qName, attributes);
				}
			}
			else
			{//element is part of header
				if (qName.equalsIgnoreCase(ELEMENT_DEPENDENCEON))
				{//element HEADER
					String annLoc= attributes.getValue(ELEMENT_DEPENDENCEON_ANNLOC);
					if (this.getGrafFileDelegator()== null)
						throw new SaltException("Cannot read a dependend resource, because the GrAFFileDelegator is empty. This might be a bug.");
					this.getGrafFileDelegator().startAnnLoc(annLoc);
				}//element HEADER
			}//element is part of header
		}
		catch (Exception e)
		{
			throw new SAXException("An exception occurs while reading file '"+this.getFileResource().getAbsolutePath()+"'.",e);
		}
    }
	
	/**
	 * Extracts some general information, which can be necessary for all derived specific readers.
	 * If a file has been detected in xml-base, this methods makes sure, that it will be imported before.
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void endElement(	String uri,
            					String localName,
            					String qName) throws SAXException
    {
		if (qName.equalsIgnoreCase(ELEMENT_HEADER))
			this.isHeader= false;
		if (!isHeader)
		{
			if (this.getRealGrafReader()!= null)
			{
				this.getRealGrafReader().endElement(uri, localName, qName);
			}
		}
    }
}
