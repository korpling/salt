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
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GRAPH_TRAVERSE_TYPE;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphTraverseHandler;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonPackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltResourceException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltResourceNotFoundException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.impl.SaltCommonFactoryImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SOrderRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextOverlappingRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeOverlappingRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAbstractAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;
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
	
	/**
	 * {@link ResourceSet} to load data from different resources.
	 */
	private static ResourceSet resourceSet= null;
	
	/**
	 * Sets the internal resource set to load data from different resources to the given one.
	 * @param resourceSet
	 */
	public static void setResourceSet(ResourceSet resourceSet) {
		SaltFactoryImpl.resourceSet = resourceSet;
	}

	/**
	 * Returns an initialized resourceSet object for storing salt-models.
	 * @return
	 */
	public static synchronized ResourceSet getResourceSet() 
	{
		if (resourceSet==  null)
		{
			if (resourceSet==  null)
			{
				resourceSet= new ResourceSetImpl();
				resourceSet.getPackageRegistry().put(SaltCommonPackage.eINSTANCE.getNsURI(), SaltCommonPackage.eINSTANCE);
				resourceSet.getPackageRegistry().put(SaltSemanticsPackage.eINSTANCE.getNsURI(), SaltSemanticsPackage.eINSTANCE);
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(SaltFactory.FILE_ENDING_SALT, new XMIResourceFactoryImpl());
			}
		}
		return resourceSet;
	}
	
	private SaltFactoryImpl()
	{
		super();
	}

	
	/**
	 * {@inheritDoc SaltFactory#load(URI)}
	 */
	@Override
	public EObject load(URI objectURI)
	{
		if (objectURI== null)
			throw new SaltResourceNotFoundException("Cannot load object, because the given uri is null.");
		
		File objectFile= new File((objectURI.toFileString()==null)?objectURI.toString():objectURI.toFileString());
		if (!objectFile.exists())
			throw new SaltResourceNotFoundException("Cannot load Object, because the file '"+objectFile+"' does not exist.");
		
		Resource resource= getResourceSet().createResource(URI.createFileURI(objectFile.getAbsolutePath()));
		if (resource== null)
			throw new SaltResourceException("Cannot load object to given uri '"+objectURI+"', because no handler for resource was found.");
		if (!(resource instanceof XMLResource))
			throw new SaltResourceException("Cannot load object to given uri '"+objectURI+"'.");
		XMLResource xmlResource= null;
		xmlResource= (XMLResource)resource;
		xmlResource.setEncoding("UTF-8");	
		try 
		{//must be done after all, because it doesn't work, if not all SDocumentGraph objects 
			xmlResource.load(null);
		}//must be done after all, because it doesn't work, if not all SDocumentGraph objects  
		catch (IOException e) 
		{
			throw new SaltResourceException("Cannot load salt-project from given uri '"+objectURI+"'.", e);
		}
		EObject obj= xmlResource.getContents().get(0);
		xmlResource.getContents().remove(obj);
		return(obj);
	}
	
	@Override
	public SaltProject loadSaltProject(URI saltProjectURI) 
	{
		if (!saltProjectURI.toFileString().endsWith(SaltFactory.FILE_ENDING_SALT))
		{
			//looks weird, but is necessary in case of uri ends with /
			if (saltProjectURI.toString().endsWith("/"))
				saltProjectURI= saltProjectURI.trimSegments(1);
			saltProjectURI= saltProjectURI.appendSegment(SaltFactory.FILE_SALT_PROJECT);
		}
		
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
			throw new SaltResourceException("Can not load SaltProject, because path '"+saltProjectPath+"' does not exist.");
		if (saltProjectPath.isDirectory())
			throw new SaltResourceException("Can not load SaltProject, because path '"+saltProjectPath+"' is not a directory.");
		
		
		return(saltProject);
	}
	
	/**
	 * {@inheritDoc SaltFactoryt#save(URI)}
	 */
	@Override
	public void saveSDocumentGraph(	SDocumentGraph sDocumentGraph, 
									URI sDocumentGraphLocation) 
	{
		Resource resource= SaltFactory.resourceSet.createResource(sDocumentGraphLocation);
			
		if (resource== null)
			throw new SaltResourceException("Cannot save the "+SDocumentGraph.class.getName()+" object '"+sDocumentGraph.getSElementId()+"' to given uri '"+sDocumentGraphLocation+"', because no resource was found.");
		if (!(resource instanceof XMLResource))
			throw new SaltResourceException("Cannot save the "+SDocumentGraph.class.getName()+" object '"+sDocumentGraph.getSElementId()+"' to given uri '"+sDocumentGraphLocation+"'.");
		else
		{
			SDocument sDoc= sDocumentGraph.getSDocument();
			if (sDoc!= null)
			{//store location of where file is persist  				
				sDoc.setSDocumentGraphLocation(sDocumentGraphLocation);
				sDoc.setSDocumentGraph(null);
			}//store location of where file is persist 
			
			XMLResource xmlResource= (XMLResource) resource;
			xmlResource.getContents().add(sDocumentGraph);
			xmlResource.setEncoding("UTF-8");	
			try {
				xmlResource.save(null);
			} catch (IOException e) 
			{
				throw new SaltResourceException("Cannot save "+SDocumentGraph.class.getName()+" to given uri '"+sDocumentGraphLocation+"'.", e);
			}
			sDoc.setSDocumentGraph(sDocumentGraph);
		}
	}

	/**
	 * {@inheritDoc SaltFactory#loadSDocumentGraph(URI)
	 */
	@Override
	public SDocumentGraph loadSDocumentGraph(URI sDocumentGraphLocation) {
		SDocumentGraph retVal= null;
		EObject obj= this.load(sDocumentGraphLocation);
		if (obj== null)
			throw new SaltResourceException("Cannot load the requested "+SDocumentGraph.class.getName()+", because file located at contains no such object, the returned object was null.");
		else if (obj instanceof SDocumentGraph)
		{
			retVal= (SDocumentGraph) obj; 
		}
		else throw new SaltResourceException("Cannot load the requested "+SDocumentGraph.class.getName()+", because file located at contains no such object. It contains: "+ obj.getClass());
		return(retVal);
	}
	
	/**
	 * {@inheritDoc SaltFactory#loadSCorpusGraph(URI)}
	 */
	public SCorpusGraph loadSCorpusGraph(URI sCorpusGraphUri) {
		return(loadSCorpusGraph(sCorpusGraphUri, 0));
	}

	/**
	 * {@inheritDoc SaltFactory#loadSCorpusGraph(URI, Integer)}
	 */
	public SCorpusGraph loadSCorpusGraph(URI sCorpusGraphUri, Integer idxOfSCorpusGraph) {
		SCorpusGraph retVal= null;
		if (!sCorpusGraphUri.toFileString().endsWith(SaltFactory.FILE_ENDING_SALT))
		{
			//looks weird, but is necessary in case of uri ends with /
			if (sCorpusGraphUri.toString().endsWith("/"))
				sCorpusGraphUri= sCorpusGraphUri.trimSegments(1);
			sCorpusGraphUri= sCorpusGraphUri.appendSegment(SaltFactory.FILE_SALT_PROJECT);
		}
		
		Object obj= load(sCorpusGraphUri);
		if (obj instanceof SCorpusGraph)
			retVal= (SCorpusGraph) obj;
		else if (obj instanceof SaltProject)
		{
			if (	(((SaltProject) obj).getSCorpusGraphs()!= null)&&
					(((SaltProject) obj).getSCorpusGraphs().size()>=idxOfSCorpusGraph))
					retVal= ((SaltProject) obj).getSCorpusGraphs().get(idxOfSCorpusGraph);
		}
		if (retVal== null)
			throw new SaltResourceException("No '"+SCorpusGraph.class.getName()+"' object was found in resource '"+sCorpusGraphUri+"'.");
		{//TODO all this can be removed, when feature request Feature #117 is done
			SaltLoadingTraverser loadingTraverser= new SaltLoadingTraverser();
			loadingTraverser.saltProjectPath= sCorpusGraphUri.toFileString().replace(SaltFactory.FILE_SALT_PROJECT, "");
			EList<Node> startNodes= (EList<Node>)(EList<? extends Node>)retVal.getSRoots();
			if (	(startNodes!= null)&&
					(startNodes.size()>0))
			{
				retVal.traverse(startNodes, GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, "SCOPRUS_GRAPH_LOADING", loadingTraverser);
			}
		}//TODO all this can be removed, when feature request Feature #117 is done
		return(retVal);
	}
	
	/**
	 * {@inheritDoc SaltFactory#move(SCorpusGraph, SCorpusGraph)}
	 */
	public void move(SCorpusGraph source, SCorpusGraph target)
	{
		//copy all sRelations and source and target SNode as well from loaded graph into existing one
		for (SRelation sRelation: source.getSRelations())
		{
			if (target.getNode(sRelation.getSSource().getSId())== null)
				target.addSNode(sRelation.getSSource());
			if (target.getNode(sRelation.getSTarget().getSId())== null)
				target.addSNode(sRelation.getSTarget());
			target.addSRelation(sRelation);
		}
		
		//copy all sNodes from loaded graph into existing one
		for (SNode sNode: source.getSNodes())
		{
			if (target.getNode(sNode.getSId())== null)
				target.addSNode(sNode);
			target.addSNode(sNode);
		}

		//copy all sAnnotation from loaded graph into existing one
		for (SAnnotation sAnno: source.getSAnnotations())
			target.addSAnnotation(sAnno);
	
		//copy all sMetaAnnotation from loaded graph into existing one
		for (SMetaAnnotation sMetaAnno: source.getSMetaAnnotations())
			target.addSMetaAnnotation(sMetaAnno);
		//copy all sProcessingAnnotation from loaded graph into existing one
		for (SProcessingAnnotation sProcAnno: source.getSProcessingAnnotations())
			target.addSProcessingAnnotation(sProcAnno);
		
		//copy all SFeature from loaded graph into existing one
		for (SFeature sfeature: source.getSFeatures())
		{
			target.addSFeature(sfeature);
		}
		
		//copy SElementId
		target.setSElementId(source.getSElementId());
		
		//copy all sLayer from loaded graph into existing one
		for (SLayer sLayer: source.getSLayers())
			target.addSLayer(sLayer);
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
		sType2clazzMap.put(STYPE_NAME.SORDER_RELATION, SOrderRelation.class);
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

// ====================================================== end: loading SaltXML resource
	//TODO all this can be removed, when feature request Feature #117 is done
	private class SaltLoadingTraverser implements GraphTraverseHandler
	{
		private Stack<String> pathStack= null;
		private String saltProjectPath= null;
		
		public SaltLoadingTraverser()
		{
			this.pathStack= new Stack<String>();
		}
		
		@Override
		public void nodeReached(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, Node currNode, Edge edge, Node fromNode, long order) 
		{
			if (pathStack.size()==0)
				pathStack.push(saltProjectPath);
			if (currNode instanceof SCorpus)
			{
				SCorpus sCorpus= (SCorpus) currNode;
				pathStack.push(pathStack.peek()+"/"+sCorpus.getSName());
			}
			else if (currNode instanceof SDocument)
			{
				SDocument sDocument= (SDocument) currNode;
				File sDocumentPath= new File(this.pathStack.peek()+"/"+sDocument.getSElementPath().lastSegment()+ "."+SaltFactory.FILE_ENDING_SALT);
				if (!sDocumentPath.exists())
				{
					//TODO put a log message (debug), that no document graph was found for document 
					throw new SaltResourceException("Cannot load SDocument object '"+sDocument.getSName()+"', because resource '"+sDocumentPath.getAbsolutePath()+"' does not exist.");
				}
				else
				{
					URI sDocumentURI= URI.createFileURI(sDocumentPath.getAbsolutePath());
					sDocument.setSDocumentGraphLocation(sDocumentURI);
				}
			}
		}

		@Override
		public void nodeLeft(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, Node currNode, Edge edge, Node fromNode, long order)
		{
			if (	(currNode != null)&&
					(!(currNode instanceof SDocument)))
			{
				if (	(this.pathStack!= null)&&
						(this.pathStack.size()>0))
					this.pathStack.pop();
			}
		}

		@Override
		public boolean checkConstraint(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, Edge edge, Node currNode, long order)
		{
			return true;
		}
	}
}
