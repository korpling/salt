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
import java.util.Properties;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltResourceException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.graf.v09.reader.GrAFFileDelegator;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;

public class GrAFResource extends ResourceImpl{
	public enum GRAF_MAPPING_TYPE {HIERARCHIE, SPAN, POINTER};
	
	/**
	 * The property to map a layer in GrAF to a SNode or SRelation type in salt.
	 */
	public static final String PROP_GRAF_LAYER_TO_TYPE="saltnpepper.salt.graf.layer2type";
	/**
	 * The property to map a layer in GrAF to a SNode or SRelation type in salt.
	 */
	public static final String PROP_GRAF_HEADER_FILE_ENDING="saltnpepper.salt.graf.HeaderFsileEnding";
	/**
	 * Name of the key to get the options for utilizing th emapping.
	 */
	public static final String OPTION_GRAF_MAPPING="saltnpepper.salt.graf.options";
	
	/**
	 * Stores a SDocumentGraph-object in GrAF-format.
	 */
	public void save(java.util.Map<?,?> options) throws java.io.IOException
	{
	}
	
	private EList<File> grafFiles= null;
	
	public EList<File> getGrafFiles() 
	{
		if (grafFiles== null)
		{
			synchronized (this) {
				if (grafFiles== null)
					grafFiles= new BasicEList<File>();
			}
		}
		return grafFiles;
	}
	
	/**
	 * Contains a list of all endings for primary data files.
	 */
	private EList<String> primaryDataResourceEndings= null;
	public EList<String> getPrimaryDataResourceEndings() {
		if (primaryDataResourceEndings== null)
		{
			synchronized (this) {
				if (primaryDataResourceEndings== null)
				{
					primaryDataResourceEndings= new BasicEList<String>();
					primaryDataResourceEndings.add("txt");
					primaryDataResourceEndings.add("html");
					primaryDataResourceEndings.add("tab");
				}
			}
		}
		return primaryDataResourceEndings;
	}


	/**
	 * Loads a SDocumentGraph-object from file in  GrAF-format.
	 */
	public void load(java.util.Map<?,?> options) throws java.io.IOException
	{
		if (this.getURI()== null)
			throw new SaltResourceException("Cannot write resource, because no uri is given.");
		
		File resourceFile= new File(this.getURI().toFileString());
		if (!resourceFile.exists())
			throw new SaltResourceException("Cannot not load from GrAF resource, because the uri '"+this.getURI()+"' does  not exists.");
		if (!resourceFile.isDirectory())
			throw new SaltResourceException("Cannot not load from GrAF resource, because the uri '"+this.getURI()+"' is not a directory.");
		
		Object obj= options.get(OPTION_GRAF_MAPPING);
		Properties grafMappingProps= null;
		if (obj!= null)
		{
			if (obj instanceof Properties)
				grafMappingProps= (Properties) obj;
		}
		String grafHeaderFileEnding= null;
		if (grafMappingProps!= null)
		{
			grafHeaderFileEnding= grafMappingProps.getProperty(PROP_GRAF_HEADER_FILE_ENDING);
		}
		if (grafHeaderFileEnding== null)
			throw new SaltResourceException("Cannot not find the grafHeader file, because no ending for that file is set. Please set it in property '"+PROP_GRAF_HEADER_FILE_ENDING+"'");
		
		File grafHeaderFile= null;
		{//search for graf header file and read it
			for (File subFile: resourceFile.listFiles())
			{
				if (!subFile.isDirectory())
				{
					String[] parts= subFile.getName().split("[.]");
					if (parts.length> 0)
					{
						String ending= parts[parts.length-1];
						if (grafHeaderFileEnding.equalsIgnoreCase(ending))
							grafHeaderFile= subFile;
					}
				}
			}
			if (grafHeaderFile== null)
				throw new SaltResourceException("Cannot not find the grafHeader file with ending '"+grafHeaderFileEnding+"' in resource '"+resourceFile+"'.");
			
		}//search for graf header file and read it
		
		{//collect all files having the ending graf
			boolean hasGrafFiles= false;
			for (File subFile: resourceFile.listFiles())
			{
				if (!subFile.isDirectory())
				{
					String[] parts= subFile.getName().split("[.]");
					if (parts.length> 0)
					{
						String ending= parts[parts.length-1];
						if (SaltFactory.GRAF_FILE_ENDING.equalsIgnoreCase(ending))
						{
							hasGrafFiles= true;
							this.getGrafFiles().add(subFile);
						}
					}
				}
			}
			if (!hasGrafFiles)
				throw new SaltResourceException("Cannot load GrAF resource, because the directory does not have files with ending '"+SaltFactory.GRAF_FILE_ENDING+"'.");
		}//collect all files having the ending graf
		
		SDocumentGraph sDocumentGraph= SaltFactory.eINSTANCE.createSDocumentGraph();
		GrAFFileDelegator grafFileDelegator= new GrAFFileDelegator();
		grafFileDelegator.setsDocumentGraph(sDocumentGraph);
		grafFileDelegator.setGrafPath(resourceFile);
		grafFileDelegator.getGrafFilesToProcess().addAll(this.getGrafFiles());
		grafFileDelegator.setMappingProps(grafMappingProps);
		EList<File> primaryDataFiles= grafFileDelegator.readGrAFExternalHeader(grafHeaderFile);
		
		{//read primary data file
			for (File primaryDataFile: primaryDataFiles)
				grafFileDelegator.readPrimaryDataFile(primaryDataFile);
		}//read primary data file
		
		{//read all graf files
			for (File grafFile: this.getGrafFiles())
				grafFileDelegator.start(grafFile);
		}//read all graf files
		this.getContents().add(sDocumentGraph);
	}
}
