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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.graf.v09;

import java.io.File;
import java.util.Hashtable;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltResourceException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.graf.v09.GrAFResource.GRAF_MAPPING_TYPE;

public class GrAFExternalHeaderReader extends DefaultHandler2 
{
	/**
	 * table containing types and corresponding files.
	 */
	private Hashtable<File, String> file2type= null;

	public Hashtable<File, String> getFile2Type() {
		if (file2type== null)
		{
			synchronized (this) {
				if (file2type== null)
					file2type= new Hashtable<File, String>();
			}
		}
		return file2type;
	}
// ========================================== start: type2MappingType		
	/**
	 * Stores a mapping between the type name (layer) given by graf and the type of the mapping, which shall be used for a layer.
	 */
	private Hashtable<String, GRAF_MAPPING_TYPE> type2MappingType= null;
	public void setType2MappingType(Hashtable<String, GRAF_MAPPING_TYPE> type2MappingType) {
		this.type2MappingType = type2MappingType;
	}

	public Hashtable<String, GRAF_MAPPING_TYPE> getType2MappingType() {
		return type2MappingType;
	}
// ========================================== end: type2MappingType	
// ========================================== start: fileResource
	/**
	 * the resource, from where the data shall be loaded.
	 */
	private File currentPath= null;
	/**
	 * Sets the resource, from where the data shall be loaded.
	 * @param destination the destination to set
	 */
	public void setCurrentPath(File destination) {
		this.currentPath = destination;
	}

	/**
	 * Returns the resource, from where the data shall be loaded.
	 * @return the destination
	 */
	public File getCurrentPath() {
		return currentPath;
	}
// ========================================== end: fileResource
	
	/**
	 * Contains all primary data files
	 */
	private EList<File> primaryDataFiles= null;
	public EList<File> getPrimaryDataFiles() {
		if (primaryDataFiles== null)
		{
			synchronized (this) {
				if (primaryDataFiles== null)
					primaryDataFiles= new BasicEList<File>();
			}
		}
		return primaryDataFiles;
	}
	public static final String ELEMENT_PRIMARY_DATA= "primaryData";
	public static final String ATT_PRIMARY_DATA_ATT_LOC= "loc";
	public static final String ELEMENT_ANNOTATION= "annotation";
	public static final String ATT_ANNOTATION_ANNLOC= "ann.loc";
	public static final String ATT_ANNOTATION_TYPE= "type";
	@Override
	public void startElement(	String uri,
            					String localName,
            					String qName,
            					Attributes attributes) throws SAXException
    {
		try
		{
			if (ELEMENT_PRIMARY_DATA.equalsIgnoreCase(qName))
			{
				String loc= attributes.getValue(ATT_PRIMARY_DATA_ATT_LOC);
				if (loc!= null)
					this.getPrimaryDataFiles().add(new File(this.getCurrentPath().getAbsolutePath()+"/"+ loc));
			}
			else if (ELEMENT_ANNOTATION.equalsIgnoreCase(qName))
			{
				String type= attributes.getValue(ATT_ANNOTATION_TYPE);
				String annLoc= attributes.getValue(ATT_ANNOTATION_ANNLOC);
				if (	(type!= null)&&
						(annLoc!= null))
				{
					if (this.getCurrentPath()== null)
						throw new SaltResourceException("Cannot create absolute uri for file '"+annLoc+"', because the current path is not given for '"+this.getClass()+"'.");
					this.getFile2Type().put(new File(this.getCurrentPath().getAbsolutePath()+"/"+ annLoc), type);
				}
			}
		}
		catch (Exception e)
		{
			throw new SAXException(e);
		}
    }
	
	@Override
	public void endElement(	String uri,
            					String localName,
            					String qName) throws SAXException
    {
		try
		{
			
		}
		catch (Exception e)
		{
			throw new SAXException(e);
		}
    }
}
