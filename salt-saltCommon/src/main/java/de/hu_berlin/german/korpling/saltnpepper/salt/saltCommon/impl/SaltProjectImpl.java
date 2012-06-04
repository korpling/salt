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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.impl;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.xmi.XMLResource;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.GraphTraverser;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.GraphTraverser.GRAPH_TRAVERSE_MODE;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.GraphTraverserObject;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.TraversalObject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonPackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltResourceException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltResourceNotFoundException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.dot.Salt2DOT;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.graf.v09.GrAFResource;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.graf.v09.GrAFResource.GRAF_MAPPING_TYPE;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.graf.v09.GrAFResourceFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Salt Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.impl.SaltProjectImpl#getSCorpusGraphs <em>SCorpus Graphs</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.impl.SaltProjectImpl#getSName <em>SName</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SaltProjectImpl extends EObjectImpl implements SaltProject {
	/**
	 * The cached value of the '{@link #getSCorpusGraphs() <em>SCorpus Graphs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSCorpusGraphs()
	 * @generated
	 * @ordered
	 */
	protected EList<SCorpusGraph> sCorpusGraphs;

	/**
	 * The default value of the '{@link #getSName() <em>SName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSName()
	 * @generated
	 * @ordered
	 */
	protected static final String SNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSName() <em>SName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSName()
	 * @generated
	 * @ordered
	 */
	protected String sName = SNAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SaltProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltCommonPackage.Literals.SALT_PROJECT;
	}

	private static final String KW_SCORPUS_GRAPH_ID="corpusGraph";
	private int numOfSCorpusGraphs= 0;
	@Override
	public void eNotify(Notification notification) 
	{
		super.eNotify(notification);		
		if (notification.getFeature() instanceof EReference) 
		{
			switch (notification.getEventType()) {
			case Notification.ADD:
				if (notification.getNewValue() instanceof SCorpusGraph)
				{
					SCorpusGraph sCorpusGraph= (SCorpusGraph)notification.getNewValue();
					if (sCorpusGraph.getSElementId()== null)
						sCorpusGraph.setSElementId(SaltCommonFactory.eINSTANCE.createSElementId());
					if (	(sCorpusGraph.getSId()== null)||
							(sCorpusGraph.getSId().isEmpty()))
					{
						this.numOfSCorpusGraphs++;
						sCorpusGraph.setSId(KW_SCORPUS_GRAPH_ID + numOfSCorpusGraphs);
					}
				}
			}
		}
	}
	
	private volatile Boolean differencesInProcess= false; 
	/**
	 * Returns all the differences between this object and the given one as a list of strings. This method uses the same
	 * comparisons as the equals method. 
	 * @param obj object to compare with
	 * @return a list of differences, null if both objects are equal
	 * @model
	 * TODO take care, that the flag differences does not allow to get the differences by two separate threads at one time
	 */
	@Override
	public EList<String> differences(Object obj)
	{
		if (!differencesInProcess)
		{
			synchronized (differencesInProcess) {
				differencesInProcess= true;
				EList<String> retVal= new BasicEList<String>();
				this.equals(retVal, obj);
				differencesInProcess= false;
				if (retVal.size()== 0)
					return(null);
				else return(retVal);
			}
		}
		else return(null);
	}
	
		/**
	 * Finds all differences between this and the given object. 
	 * @param differences if given parameter is not null all differences will be written in that list
	 * @param obj 
	 * @return
	 */
	protected boolean equals(EList<String> differences, Object obj)
	{
		if (obj== null)
		{
			if (differences!= null)
				differences.add("The given object is null.");
			else return false;
		}
		else
		{
			if (this== obj)
				return(true);
			if (getClass() != obj.getClass())
			{
				if (differences!= null)
					differences.add("The given object is not of type '"+getClass()+"'.");
				else return false;
			}
			SaltProject other= (SaltProject)obj;
			if (this.getSName()!= null)
			{
				if (!this.getSName().equals(other.getSName()))
				{
					if (differences!= null)
						differences.add("The names of the SaltProjects are not the same 'this.name="+this.getSName()+"', 'other.name="+other.getSName()+"'.");
					else return false;
				}
			}
			else 
			{
				if (other.getSName()!= null)
				{
					if (differences!= null)
						differences.add("The names of the SaltProjects are not the same 'this.name="+this.getSName()+"', 'other.name="+other.getSName()+"'.");
					else return false;
				}
			}
			if (this.getSCorpusGraphs()!= null)
			{
				if (this.getSCorpusGraphs().size()!= other.getSCorpusGraphs().size())
				{
					if (differences!= null)
						differences.add("The size of corpus graphs does not match, this object contains "+this.getSCorpusGraphs().size()+" corpus-graps, whereas the other object "+other.getSCorpusGraphs().size()+" contains.");
					else return false;
				}
				else
				{
					boolean containsAllSubGraphs= false;
					{//this is a workaround, because containsAll() and contains does not seem to work
						for (SCorpusGraph sCorpusGraph: Collections.synchronizedCollection(this.getSCorpusGraphs()))
						{//run through all SCorpusGraph objects belonging to this and check if there is an equal one in other graph
							if (sCorpusGraph!= null)
							{
								//TODO: remember which graphs of other have a corresponding graph in this, they do not have to be checked again, this will increase speed because of they do not need to be doublechecked 
								boolean foundEqualGraph= false;
								for (SCorpusGraph otherGraph: Collections.synchronizedCollection(other.getSCorpusGraphs()))
								{//run through all SCorpusGraph objects belonging to other
									if (differences!= null)
									{
//										EList<String> diffs=sCorpusGraph.differences(otherGraph);
//										if (diffs!= null)
//											differences.addAll(diffs);
										sCorpusGraph.equals(differences, otherGraph);
										foundEqualGraph= true;
										break;
									}
									else 
									{
										if (sCorpusGraph.equals(differences, otherGraph))
										{
											foundEqualGraph= true;
											break;
										}
									}
								}//run through all SCorpusGraph objects belonging to other
								if (!foundEqualGraph)
									containsAllSubGraphs= false;
								else
									containsAllSubGraphs= true;
								if (!containsAllSubGraphs)
									break;
							}
						}//run through all SCorpusGraph objects belonging to this and check if there is an equal one in other graph
					}//this is a workaround, because containsAll() and contains does not seem to work
					return(containsAllSubGraphs);
				}
			}
			else 
			{
				if (other.getSCorpusGraphs()== null)
					return(true);
				else
				{
					if (differences!= null)
						differences.add("This saltproject contains corpus graphs, but the given one does not.");
					else return(false);
				}
			}
		}
		return(true);
	}
	
	/**
	 * Checks if both objects have the same list of corpus graphs and delegates the comparison to SCorpusGraphs.equals().
	 * @param obj
	 * @return
	 */
	@Override
	public boolean equals(Object obj)
	{
		boolean retVal= this.equals(null, obj); 
		return(retVal);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SCorpusGraph> getSCorpusGraphs() 
	{
		if (sCorpusGraphs == null) {
			sCorpusGraphs = new EObjectContainmentWithInverseEList<SCorpusGraph>(SCorpusGraph.class, this, SaltCommonPackage.SALT_PROJECT__SCORPUS_GRAPHS, SCorpusStructurePackage.SCORPUS_GRAPH__SALT_PROJECT);
		}
		return sCorpusGraphs;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSName() {
		return sName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSName(String newSName) {
		String oldSName = sName;
		sName = newSName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCommonPackage.SALT_PROJECT__SNAME, oldSName, sName));
	}

// ====================================================== start: saving to SaltXML resource	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public synchronized void saveSaltProject(URI saltProjectURI) 
	{
		if (saltProjectURI== null)
			throw new SaltResourceNotFoundException("Cannot save SaltProject, because the given uri is null.");
		File saltProjectPath= null;
		try
		{
			saltProjectPath= new File(saltProjectURI.toFileString());
		}catch (Exception e) {
			throw new SaltResourceNotFoundException("Cannot save SaltProject.",e);
		}
		if (!saltProjectPath.exists())
			saltProjectPath.mkdirs();
		
		URI saltProjectFileURI= URI.createFileURI(saltProjectPath.getAbsolutePath() +"/"+ "saltProject"+"."+ SaltFactory.FILE_ENDING_SALT);
		
		Resource resource= SaltFactory.resourceSet.createResource(saltProjectFileURI);
		
		if (resource== null)
			throw new SaltResourceException("Cannot save salt project to given uri '"+saltProjectURI+"'.");
		if (!(resource instanceof XMLResource))
			throw new SaltResourceException("Cannot save salt project to given uri '"+saltProjectURI+"'.");
		XMLResource xmlProjectResource= null;
		xmlProjectResource= (XMLResource)resource;
		xmlProjectResource.getContents().add(this);
		xmlProjectResource.setEncoding("UTF-8");
		
		XMLResource xmlResource= null;
		
		if (	(this.getSCorpusGraphs()!= null)&&
				(this.getSCorpusGraphs().size()> 0))
		{//store all documents if exist
			URI sDocumentFileURI= null;
			for (SCorpusGraph sCorpusGraph: Collections.synchronizedList(this.getSCorpusGraphs()))
			{
				if (	(sCorpusGraph.getSDocuments()!= null) &&
						(sCorpusGraph.getSDocuments().size()> 0))
				{
					for (SDocument sDocument: Collections.synchronizedList(sCorpusGraph.getSDocuments()))
					{
						if (sDocument.getSDocumentGraph()!= null)
						{//only store sDocument, when there is some content in sDocumentGraph corresponding to sDocument
							SCorpus fatherCorpus= sCorpusGraph.getSCorpus(sDocument);
							if (	(fatherCorpus!= null) &&
									(fatherCorpus.getSId()!= null))
							{
								//as long as sId starts with scheme, replace(...) must be there
								String corpusPath= fatherCorpus.getSId().replace("salt:", "");
								sDocumentFileURI= URI.createFileURI(saltProjectPath.getAbsolutePath() +"/"+ corpusPath+"/"+ sDocument.getSName()+"."+ SaltFactory.FILE_ENDING_SALT);
								
								//resource= this.getResourceSet().createResource(sDocumentFileURI);
								resource= SaltFactory.resourceSet.createResource(sDocumentFileURI);
								
								if (resource== null)
									throw new SaltResourceException("Cannot save the SDocument object '"+sDocument.getSElementId()+"' to given uri '"+sDocumentFileURI+"'.");
								if (!(resource instanceof XMLResource))
									throw new SaltResourceException("Cannot save the SDocument object '"+sDocument.getSElementId()+"' to given uri '"+sDocumentFileURI+"'.");
								xmlResource= null;
								xmlResource= (XMLResource)resource;
								xmlResource.getContents().add(sDocument.getSDocumentGraph());
								xmlResource.setEncoding("UTF-8");	
								try {
									xmlResource.save(null);
								} catch (IOException e) 
								{
									throw new SaltResourceException("Cannot save salt project to given uri '"+sDocumentFileURI+"'.", e);
								}
							}
						}//only store sDocument, when there is some content in sDocumentGraph corresponding to sDocument
					}
				}
			}
		}//store all documents if exist
		
		try 
		{//must be done after all, because it doesn't work, if not all SDocumentGraph objects 
			xmlProjectResource.save(null);
		}//must be done after all, because it doesn't work, if not all SDocumentGraph objects  
		catch (IOException e) 
		{
			throw new SaltResourceException("Cannot save salt project to given uri '"+saltProjectURI+"'.", e);
		}
	}
// ====================================================== end: saving to SaltXML resource	
// ====================================================== start: loading SaltXML resource	
	
	/**
	 * {@inheritDoc SaltProject#loadSCorpusStructure(URI)}
	 */
	public synchronized Map<SDocument, URI> loadSCorpusStructure(URI saltProjectURI) 
	{
		File saltProjectPath= new File(saltProjectURI.toFileString());

		if (!saltProjectURI.toFileString().endsWith(SaltFactory.FILE_SALT_PROJECT))
			saltProjectURI= saltProjectURI.appendSegment(SaltFactory.FILE_SALT_PROJECT);
		
		Object obj= null;
		try 
		{
			obj= SaltFactory.eINSTANCE.load(saltProjectURI);
		}catch (SaltResourceException e) {
			throw new SaltResourceException("Cannot load salt-project from given uri '"+saltProjectURI+"', because of "+e.getMessage()+".", e);
		}
		if (obj== null)
			throw new SaltResourceException("Cannot load salt-project from given uri '"+saltProjectURI+"', because it seems to be empty.");
		if (!(obj instanceof SaltProject))
			throw new SaltResourceException("Cannot load salt-project from given uri '"+saltProjectURI+"', because the loaded object is not of type SaltProject.");
		else
		{
			SaltProject saltProject= (SaltProject) obj;
			this.getSCorpusGraphs().addAll(saltProject.getSCorpusGraphs());
		}
		
		
		Map<SDocument, URI> sDocumentMap= null;
		{//load SDocumentGraph-objects belonging to the SDocument objects of all SCorpusGraphs
			//TODO this is a workaround, because the mechanism of EMF does not work correctly here, but it would be better to do this automatically by EMF, because the given approach uses the SElementId for retrieval, which can be incorrect!!! But when using EMF take care for relative pathes.
			if (	(this.getSCorpusGraphs()!= null)&&
					(this.getSCorpusGraphs().size()>0))
			{
				for (SCorpusGraph sCorpusGraph: Collections.synchronizedCollection(this.getSCorpusGraphs()))
				{
					GraphTraverser graphTraverser= new GraphTraverser();
					graphTraverser.setGraph(sCorpusGraph);
					SaltLoadingTraverser loadingTraverser= new SaltLoadingTraverser();
					loadingTraverser.saltProjectPath= saltProjectPath.getAbsolutePath();
					GraphTraverserObject traverser= graphTraverser.getTraverserObject(GRAPH_TRAVERSE_MODE.DEPTH_FIRST, loadingTraverser);
					traverser.start((EList<Node>)(EList<? extends Node>)sCorpusGraph.getSRootCorpus());
					while(!traverser.isFinished())
					{ try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						throw new SaltResourceException("This seems to be a bug, it is not possible to wait for a thread.");
					}}
					if (sDocumentMap== null)
						sDocumentMap= loadingTraverser.sDocumentMap;
					else
						sDocumentMap.putAll(loadingTraverser.sDocumentMap);
				}
			}
		}//load SDocumentGraph-objects belonging to the SDocument objects of all SCorpusGraphs
		return(sDocumentMap);
	}

	/**
	 * {@inheritDoc SaltProject#loadSDocumentStructure(SDocument, URI)}
	 */
	public void loadSDocumentStructure(SDocument sDocument, URI sDocumentURI) 
	{
//		Resource resource= getResourceSet().createResource(sDocumentURI);
		Resource resource= SaltFactory.resourceSet.createResource(sDocumentURI);
		if (resource== null)
			throw new SaltResourceException("Cannot load "+SDocument.class.getName()+" object to given uri '"+sDocumentURI+"'.");
		if (!(resource instanceof XMLResource))
			throw new SaltResourceException("Cannot load "+SDocument.class.getName()+" object to given uri '"+sDocumentURI+"'.");
		XMLResource xmlResource= null;
		xmlResource= (XMLResource)resource;
		xmlResource.setEncoding("UTF-8");	
		try 
		{//must be done after all, because it doesn't work, if not all SDocumentGraph objects 
			xmlResource.load(null);
		}//must be done after all, because it doesn't work, if not all SDocumentGraph objects  
		catch (IOException e) 
		{
			throw new SaltResourceException("Cannot load "+SDocument.class.getName()+" object from given uri '"+sDocumentURI+"'.", e);
		}
		Object obj= xmlResource.getContents().get(0);
		if (obj== null)
			throw new SaltResourceException("Cannot load "+SDocument.class.getName()+" object from given uri '"+sDocumentURI+"', because it seems to be empty.");
		else if (!(obj instanceof SDocumentGraph))
			throw new SaltResourceException("Cannot load "+SDocument.class.getName()+" object from given uri '"+sDocumentURI+"', because the loaded object is not of type "+SaltProject.class.getName()+".");
		else
		{
			SDocumentGraph sDocumentGraph= (SDocumentGraph) xmlResource.getContents().get(0);
			sDocument.setSDocumentGraph(sDocumentGraph);
		}
	}

	/**
	 * {@inheritDoc SaltProject#loadSaltProject(URI)}
	 */
	public synchronized void loadSaltProject(URI saltProjectURI) 
	{
		Map<SDocument, URI> sDocumentMap= this.loadSCorpusStructure(saltProjectURI);
		for (SDocument sDoc:sDocumentMap.keySet())
		{
			this.loadSDocumentStructure(sDoc, sDocumentMap.get(sDoc));
		}		
	}

	/**
	 * Loads the document structure into the given {@link SDocument} object coming from file located at the given
	 * {@link URI}. 
	 * @param sDocument
	 * @param sDocumentURI
	 */
	public void loadSaltProject_SDocumentStructure(SDocument sDocument, URI sDocumentURI)
	{
//		Resource resource= getResourceSet().createResource(sDocumentURI);
		Resource resource= SaltFactory.resourceSet.createResource(sDocumentURI);
		
		if (resource== null)
			throw new SaltResourceException("Cannot load SDocument object to given uri '"+sDocumentURI+"'.");
		if (!(resource instanceof XMLResource))
			throw new SaltResourceException("Cannot load SDocument object to given uri '"+sDocumentURI+"'.");
		XMLResource xmlResource= null;
		xmlResource= (XMLResource)resource;
		xmlResource.setEncoding("UTF-8");	
		try 
		{//must be done after all, because it doesn't work, if not all SDocumentGraph objects 
			xmlResource.load(null);
		}//must be done after all, because it doesn't work, if not all SDocumentGraph objects  
		catch (IOException e) 
		{
			throw new SaltResourceException("Cannot load SDocument object from given uri '"+sDocumentURI+"'.", e);
		}
		Object obj= xmlResource.getContents().get(0);
		if (obj== null)
			throw new SaltResourceException("Cannot load SDocument object from given uri '"+sDocumentURI+"', because it seems to be empty.");
		else if (!(obj instanceof SDocumentGraph))
			throw new SaltResourceException("Cannot load SDocument object from given uri '"+sDocumentURI+"', because the loaded object is not of type SaltProject.");
		else
		{
			SDocumentGraph sDocumentGraph= (SDocumentGraph) xmlResource.getContents().get(0);
			sDocument.setSDocumentGraph(sDocumentGraph);
		}
	}

	private class SaltLoadingTraverser implements TraversalObject
	{
		private Stack<String> pathStack= null;
		private String saltProjectPath= null;
		public Map<SDocument, URI> sDocumentMap= null;
		
		public SaltLoadingTraverser()
		{
			this.pathStack= new Stack<String>();
			this.sDocumentMap= new HashMap<SDocument, URI>();
		}
		
		@Override
		public void nodeReached(GRAPH_TRAVERSE_MODE traversalMode,
								Long traversalId, Node currNode, Edge edge, Node fromNode,
								long order) 
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
				File sDocumentPath= new File(this.pathStack.peek()+"/"+sDocument.getSName()+ "."+SaltFactory.FILE_ENDING_SALT);
				if (!sDocumentPath.exists())
				{
					//TODO put a log message (debug), that no document graph was found for document 
//					throw new SaltResourceException("Cannot load SDocument object '"+sDocument.getSName()+"', because resource '"+sDocumentPath.getAbsolutePath()+"' does not exists.");
				}
				else
				{
					URI sDocumentURI= URI.createFileURI(sDocumentPath.getAbsolutePath());
					this.sDocumentMap.put(sDocument, sDocumentURI);
				}
			}
		}

		@Override
		public void nodeLeft(GRAPH_TRAVERSE_MODE traversalMode,
				Long traversalId, Node currNode, Edge edge, Node fromNode,
				long order) 
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
		public boolean checkConstraint(GRAPH_TRAVERSE_MODE traversalMode,
				Long traversalId, Edge edge, Node currNode, long order) {
			return true;
		}
	}
// ====================================================== end: loading SaltXML resource
// ====================================================== start: loading GrAF resource
	/**
	 * Loads a corpus structure from a given uri, using the GrAF format. 
	 * Possible values for properties:
	 * <ul>
	 * 	<li>{@link GrAFResource#PROP_GRAF_HEADER_FILE_ENDING} the file ending of the GrAF header file</li>
	 * <li>{@link GrAFResource#PROP_GRAF_LAYER_TO_TYPE}.type A description, how the data concerning to the layer type shall be matched, possible values are: {@link GRAF_MAPPING_TYPE}</li>
	 * </ul>
	 * @param saltProjectUri the uri of the root folder which contains the GrAF corpus. 
	 * @param properties a {@link Properties}} object which contains a utilization for the load process 
	 * @model saltProjectUriDataType="de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.URI"
	 */
	public synchronized void loadSaltProject_GrAF(URI saltProjectUri, Properties properties) {
//		if (saltProjectUri== null)
//			throw new SaltResourceNotFoundException("Cannot load SaltProject, because the given uri is null.");
//		File saltProjectPath= null;
//		try
//		{
//			saltProjectPath= new File(saltProjectUri.toFileString());
//		}catch (Exception e) {
//			throw new SaltResourceNotFoundException("Cannot load SaltProject.",e);
//		}
//		SCorpusGraph sCorpusGraph= SaltFactory.eINSTANCE.createSCorpusGraph();
//		this.getSCorpusGraphs().add(sCorpusGraph);
//		loadSaltProjectFromGrAF_rec(properties, sCorpusGraph, null, saltProjectPath);
		
		Hashtable<SDocument, URI> sDocument2Resource= this.loadSCorpusGraph_GrAF(saltProjectUri, properties);
		Enumeration<SDocument> keys=sDocument2Resource.keys(); 
		while (keys.hasMoreElements())
		{
			SDocument sDocument= keys.nextElement();
			URI sDocumentGraphURI= sDocument2Resource.get(sDocument);
			this.loadSDocumentGraph_GrAF(sDocumentGraphURI, sDocument, properties);
		}
	}
	
	/**
	 * Loads an object of type {@link SCorpusGraph} from given URI in GrAF format into this object. The {@link SDocumentGraph} objects
	 * will not be loaded, but a map containing created {@link SDocument} objects and corresponding files will be returned.
	 * @param sCorpusGraphURI the uri where the resource is located
	 * @param properties properties to utilize the loading
	 * @return  map containing created {@link SDocument} objects and corresponding files will be returned.
	 */
	public synchronized Hashtable<SDocument, URI> loadSCorpusGraph_GrAF(URI sCorpusGraphURI, Properties properties) 
	{
		if (sCorpusGraphURI== null)
			throw new SaltResourceNotFoundException("Cannot load SCorpusGraph, because the given uri is null.");
		
		File saltProjectPath= null;
		try
		{
			saltProjectPath= new File(sCorpusGraphURI.toFileString());
		}catch (Exception e) {
			throw new SaltResourceNotFoundException("Cannot load SaltProject.",e);
		}
		SCorpusGraph sCorpusGraph= SaltFactory.eINSTANCE.createSCorpusGraph();
		this.getSCorpusGraphs().add(sCorpusGraph);
		this.sDocument2Resource= new Hashtable<SDocument, URI>();
		loadSaltProjectFromGrAF_rec(properties, sCorpusGraph, null, saltProjectPath);
		Hashtable<SDocument, URI> sDocument2Resource= this.sDocument2Resource;
		//clean up
		this.sDocument2Resource= null;
		return(sDocument2Resource);
	}
	/**
	 * Needed for loading SCorpusGraph, stores the correspondence between SDocument and uri.
	 */
	private volatile Hashtable<SDocument, URI> sDocument2Resource= null;
	
	/**
	 * Loads an {@link SDocumentGraph} object from given uri (in GrAF format) and adds it to the given {@link SDocument} object.
	 * Possible values for properties:
	 * <ul>
	 * 	<li>{@link GrAFResource#PROP_GRAF_HEADER_FILE_ENDING} the file ending of the GrAF header file</li>
	 * <li>{@link GrAFResource#PROP_GRAF_LAYER_TO_TYPE}.type A description, how the data concerning to the layer type shall be matched, possible values are: {@link GRAF_MAPPING_TYPE}</li>
	 * </ul>
	 * @param sDocumentGraphURI the uri where the resource is located
	 * @param sDocument the document to which the graph shall be set 
	 * @param properties properties to utilize the loading
	 */
	public synchronized void loadSDocumentGraph_GrAF(	URI sDocumentGraphURI, 
														SDocument sDocument, 
														Properties properties) 
	{
		if (sDocumentGraphURI== null)
			throw new SaltResourceNotFoundException("Cannot load SDocumentGraph, because the given uri is null.");
		if (sDocument== null)
			throw new SaltResourceNotFoundException("Cannot load SDocument, because the given SDocument object is null.");
		
		File sDocumentGraphPath= new File(sDocumentGraphURI.toFileString());
		if (!sDocumentGraphPath.exists())
			throw new SaltResourceNotFoundException("Cannot load SDocument, because the given uri '"+sDocumentGraphPath.getAbsolutePath()+"' does not exists..");
		
		Resource resource= GrAFResourceFactory.newInstance().createResource(URI.createFileURI(sDocumentGraphPath.getAbsolutePath()));
		if (resource== null)
			throw new SaltResourceException("Cannot load salt project from given uri '"+sDocumentGraphPath.getAbsolutePath()+"'.");
		try 
		{//must be done after all, because it doesn't work, if not all SDocumentGraph objects 
			Hashtable<String, Object> options= new Hashtable<String, Object>();
			options.put(GrAFResource.OPTION_GRAF_MAPPING, properties);
			resource.load(options);
		}//must be done after all, because it doesn't work, if not all SDocumentGraph objects  
		catch (IOException e) 
		{
			throw new SaltResourceException("Cannot load salt-project from given uri '"+sDocumentGraphPath.getAbsolutePath()+"'.", e);
		}
		Object obj= resource.getContents().get(0);
		if (obj== null)
			throw new SaltResourceException("Cannot load salt-project from given uri '"+sDocumentGraphPath.getAbsolutePath()+"', because it seems to be empty.");
		if (!(obj instanceof SDocumentGraph))
			throw new SaltResourceException("Cannot load salt-project from given uri '"+sDocumentGraphPath.getAbsolutePath()+"', because the loaded object is not of type SaltProject.");
		else
		{
			SDocumentGraph sDocumentGarph= (SDocumentGraph) resource.getContents().get(0);
			sDocument.setSDocumentGraph(sDocumentGarph);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void saveSaltProject_DOT(URI uri) {
		Salt2DOT salt2dot = new Salt2DOT();
		salt2dot.salt2Dot(this, uri);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void saveSCorpusGraph_DOT(URI uri, SElementId sElementID) {
		Salt2DOT salt2dot = new Salt2DOT();
		salt2dot.salt2Dot(sElementID, uri);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void saveSDocumentGraph_DOT(URI uri, SElementId sElementID) {
		Salt2DOT salt2dot = new Salt2DOT();
		salt2dot.salt2Dot(sElementID, uri);
	}

	/**
	 * Reads the given file, if it is a directory, it will read it recursively. If it contains files, they will be read as
	 * GrAF files.
	 * Possible values for properties:
	 * <ul>
	 * 	<li>{@link GrAFResource#PROP_GRAF_HEADER_FILE_ENDING} the file ending of the GrAF header file</li>
	 * <li>{@link GrAFResource#PROP_GRAF_LAYER_TO_TYPE}.type A description, how the data concerning to the layer type shall be matched, possible values are: {@link GRAF_MAPPING_TYPE}</li>
	 * </ul> 
	 * @param superCorpus
	 * @param saltProjectPath the super corpus
	 * @param sCorpusGraph the graph where the nodes shall be added to 
	 */
	private void loadSaltProjectFromGrAF_rec( 	Properties properties,
												SCorpusGraph sCorpusGraph, 
												SCorpus superCorpus, 
												File saltProjectPath)
	{
		if (!saltProjectPath.exists())
			throw new SaltResourceNotFoundException("Cannot load SaltProject, because the given uri '"+saltProjectPath.getAbsolutePath()+"' does not exists.");
		
		boolean hasGrafFiles= false;
		EList<File> subFolders= new BasicEList<File>();
		for (File subFile: saltProjectPath.listFiles())
		{
			if (!subFile.isDirectory())
			{//if file is not a directory, map it to SDocument
				if (subFile.getName().endsWith("."+SaltFactory.FILE_ENDING_GRAF))
					hasGrafFiles= true;
			}//if file is not a directory, map it to SDocument
			else
				subFolders.add(subFile);
			
		}
		SCorpus sCorpus= null;
		if (subFolders.size()!= 0)
		{//folder contains sub folders
			sCorpus= SaltFactory.eINSTANCE.createSCorpus();
			sCorpus.setSName(saltProjectPath.getName());
			if (superCorpus== null)
				sCorpusGraph.addSNode(sCorpus);
			else
				sCorpusGraph.addSSubCorpus(superCorpus, sCorpus);
		}//folder contains sub folders
		if (hasGrafFiles)
		{//folder contains graf files
			SDocument sDocument= SaltFactory.eINSTANCE.createSDocument();
			sDocument.setSName(saltProjectPath.getName());
			if (superCorpus== null)
				sCorpusGraph.addSNode(sDocument);
			else
				sCorpusGraph.addSDocument(superCorpus, sDocument);
			if (this.sDocument2Resource!= null)
			{
				this.sDocument2Resource.put(sDocument, URI.createFileURI(saltProjectPath.getAbsolutePath()));
			}
		}//folder contains graf files
		{//recursive call for sub folders
			for (File subFolder: subFolders)
			{
				this.loadSaltProjectFromGrAF_rec(properties, sCorpusGraph, sCorpus, subFolder);
			}
		}//recursive call for sub folders
	}
	
// ====================================================== end: loading GrAF resource	
	
	@Override
	public boolean eNotificationRequired() {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SaltCommonPackage.SALT_PROJECT__SCORPUS_GRAPHS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSCorpusGraphs()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SaltCommonPackage.SALT_PROJECT__SCORPUS_GRAPHS:
				return ((InternalEList<?>)getSCorpusGraphs()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SaltCommonPackage.SALT_PROJECT__SCORPUS_GRAPHS:
				return getSCorpusGraphs();
			case SaltCommonPackage.SALT_PROJECT__SNAME:
				return getSName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SaltCommonPackage.SALT_PROJECT__SCORPUS_GRAPHS:
				getSCorpusGraphs().clear();
				getSCorpusGraphs().addAll((Collection<? extends SCorpusGraph>)newValue);
				return;
			case SaltCommonPackage.SALT_PROJECT__SNAME:
				setSName((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SaltCommonPackage.SALT_PROJECT__SCORPUS_GRAPHS:
				getSCorpusGraphs().clear();
				return;
			case SaltCommonPackage.SALT_PROJECT__SNAME:
				setSName(SNAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SaltCommonPackage.SALT_PROJECT__SCORPUS_GRAPHS:
				return sCorpusGraphs != null && !sCorpusGraphs.isEmpty();
			case SaltCommonPackage.SALT_PROJECT__SNAME:
				return SNAME_EDEFAULT == null ? sName != null : !SNAME_EDEFAULT.equals(sName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (sName: ");
		result.append(sName);
		result.append(')');
		return result.toString();
	}
} //SaltProjectImpl
