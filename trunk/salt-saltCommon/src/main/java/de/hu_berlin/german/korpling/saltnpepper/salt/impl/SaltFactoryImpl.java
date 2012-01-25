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
package de.hu_berlin.german.korpling.saltnpepper.salt.impl;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltResourceException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltResourceNotFoundException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.impl.SaltCommonFactoryImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextOverlappingRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeOverlappingRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SCatAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SLemmaAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SPOSAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SSentenceAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.STypeAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SWordAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SaltSemanticsFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SaltSemanticsPackage;

public class SaltFactoryImpl extends SaltCommonFactoryImpl implements SaltFactory{

	private static volatile SaltFactory saltFactory= null;
	
	/**
	 * This object shall never be set, it only exists to create a monitor on, to synchronize the saltFactory object.
	 */
	private static volatile Object monitor= new Object();
	
	/**
	 * Creates the SaltFactory object. this method is thread-safe.
	 */
	public static SaltFactory init() {
		if (saltFactory== null)
		{
			synchronized (monitor) {
				if (saltFactory== null)
				{
					saltFactory= new SaltFactoryImpl();
				}
			}
		}
		return(saltFactory);
	}
	
	private SaltFactoryImpl()
	{
		super();
	}

	@Override
	public SaltProject loadSaltProject(URI saltProjectURI) 
	{
		SaltProject saltProject= null;
		if (saltProjectURI== null)
			throw new SaltResourceNotFoundException("Can not load SaltProject, because the given uri is null.");
		File saltProjectPath= null;
		try
		{
			saltProjectPath= new File(saltProjectURI.toFileString());
		}catch (Exception e) {
			throw new SaltResourceNotFoundException("Can not load SaltProject.",e);
		}
		if (saltProjectPath.exists())
			throw new SaltResourceException("Can not load SaltProject, because path '"+saltProjectPath+"' does not exists.");
		if (saltProjectPath.isDirectory())
			throw new SaltResourceException("Can not load SaltProject, because path '"+saltProjectPath+"' is not a directory.");
		
		
		return(saltProject);
	}
	
	/**
	 * Delegator for methods from SaltSemanticsFactory
	 */
	private SaltSemanticsFactory saltSemanticsFactory= null;
	
	public void setSaltSemanticsFactory(SaltSemanticsFactory saltSemanticsFactory) {
		this.saltSemanticsFactory = saltSemanticsFactory;
	}

	public SaltSemanticsFactory getSaltSemanticsFactory() 
	{
		if (saltSemanticsFactory== null)
		{
			synchronized (this) {
				if (saltSemanticsFactory== null)
					saltSemanticsFactory= SaltSemanticsFactory.eINSTANCE;
			}
		}
		return saltSemanticsFactory;
	}

	@Override
	public SPOSAnnotation createSPOSAnnotation() {
		return(this.getSaltSemanticsFactory().createSPOSAnnotation());
	}

	@Override
	public SLemmaAnnotation createSLemmaAnnotation() {
		return(this.getSaltSemanticsFactory().createSLemmaAnnotation());
	}

	@Override
	public SCatAnnotation createSCatAnnotation() {
		return(this.getSaltSemanticsFactory().createSCatAnnotation());
	}

	@Override
	public STypeAnnotation createSTypeAnnotation() {
		return(this.getSaltSemanticsFactory().createSTypeAnnotation());
	}

	@Override
	public SWordAnnotation createSWordAnnotation() {
		return(this.getSaltSemanticsFactory().createSWordAnnotation());
	}

	@Override
	public SSentenceAnnotation createSSentenceAnnotation() {
		return(this.getSaltSemanticsFactory().createSSentenceAnnotation());
	}

	@Override
	public SaltSemanticsPackage getSaltSemanticsPackage() {
		return(SaltSemanticsPackage.eINSTANCE);
	}
	
	/**
	 * Initializes the map of {@link STYPE_NAME} and {@link Class}.
	 */
	private void initSType2ClazzMap()
	{
		this.sType2clazzMap= Collections.synchronizedMap(new HashMap<STYPE_NAME, Class<? extends EObject>>());
		sType2clazzMap.put(STYPE_NAME.SDOMINANCE_RELATION, SDominanceRelation.class);
		sType2clazzMap.put(STYPE_NAME.SPOINTING_RELATION, SPointingRelation.class);
		sType2clazzMap.put(STYPE_NAME.SSPANNING_RELATION, SSpanningRelation.class);
		sType2clazzMap.put(STYPE_NAME.STEXT_OVERLAPPING_RELATION, STextOverlappingRelation.class);
		sType2clazzMap.put(STYPE_NAME.STIME_OVERLAPPING_RELATION, STimeOverlappingRelation.class);
		sType2clazzMap.put(STYPE_NAME.SSEQUENTIAL_RELATION, SSequentialRelation.class);
	}
	/**
	 * the map of {@link STYPE_NAME} and {@link Class}.
	 */
	private Map<STYPE_NAME, Class<? extends EObject>> sType2clazzMap= null;
	
	@Override
	public STYPE_NAME convertClazzToSTypeName(Class<? extends EObject> clazz) 
	{
		if (this.sType2clazzMap== null)
			this.initSType2ClazzMap();
		
		Set<STYPE_NAME> keys= this.sType2clazzMap.keySet();
		for (STYPE_NAME sType: keys)
		{
			Class<? extends EObject> clazz1= sType2clazzMap.get(sType); 
			if (clazz1.equals(clazz))
				return(sType);
		}
		return null;
	}

	@Override
	public Class<? extends EObject> convertSTypeNameToClazz(STYPE_NAME sType) {
		if (this.sType2clazzMap== null)
			this.initSType2ClazzMap();
		return(this.sType2clazzMap.get(sType));
	}
}
