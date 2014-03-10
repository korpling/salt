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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl;

import com.google.common.collect.ImmutableList;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonPackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.exceptions.SaltCoreException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SGraphImpl;

import org.eclipse.emf.ecore.util.DelegatingEcoreEList;

/**
 * 
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusGraphImpl#getSDocuments <em>SDocuments</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusGraphImpl#getSaltProject <em>Salt Project</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusGraphImpl#getSCorpora <em>SCorpora</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusGraphImpl#getSCorpusRelations <em>SCorpus Relations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusGraphImpl#getSCorpusDocumentRelations <em>SCorpus Document Relations</em>}</li>
 * </ul>
 * </p>
 *
 * @author Florian Zipser
 */
public class SCorpusGraphImpl extends SGraphImpl implements SCorpusGraph {
	/**
	 * name of index for node-types
	 */
	protected static final String IDX_SNODETYPE=	"idx_sNodeType";
	/**
	 * name of index for relation-types
	 */
	protected static final String IDX_SRELATIONTYPE=	"idx_sRelationType";
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected SCorpusGraphImpl() {
		super();
		this.init();
	}
	
	private void init()
	{
		{//creating indexes
			
			//creating node-type index
			getCentralIndex().addIndex(IDX_SNODETYPE, Class.class, Node.class);
			//creating relation-type index
			getCentralIndex().addIndex(IDX_SRELATIONTYPE, Class.class, Edge.class);
		}
	}
	
	/**
	 * Finds all differences between this and the given object. 
	 * @param differences if given parameter is not null all differences will be written in that list
	 * @param obj 
	 * @return
	 */
	@Override
	public boolean equals(EList<String> differences, Object obj)
	{
		if (differences!= null)
		{
			super.equals(differences, obj);
		}
		else
		{
			if (!super.equals(differences, obj))
				return(false);
		}
		if (differences!= null)
		{//needs only to be checked if differences shall be found, because in that case, super returned with false, but method goes on
			if (obj.getClass()!= getClass())
				return(false);
		}//needs only to be checked if differences shall be found, because in that case, super returned with false, but method goes on
		SCorpusGraph othersCorpusGraph= (SCorpusGraph) obj;
		if (this.getSDocuments().size()!= othersCorpusGraph.getSDocuments().size())
		{
			if (differences!= null)
				differences.add("The number of the SDocument nodes are not the the same for both graphs (number for this: "+this.getSDocuments().size()+", number for given graph: "+othersCorpusGraph.getSDocuments().size()+")");
			else
				return(false);
		}
		else
		{
			boolean containsAllSDocumentGraphs= false;
			if (	(this.getSDocuments().size()== othersCorpusGraph.getSDocuments().size())&&
					(this.getSDocuments().size()==0))
			{//if no sDocumentGraphs exists in both corpus graphs
				containsAllSDocumentGraphs= true;
			}//if no sDocumentGraphs exists in both corpus graphs
			else
			{//if sDocumentGraphs exists in both corpus graphs
				for (SDocument sDocument: this.getSDocuments())
				{
					if (sDocument.getSDocumentGraph()!= null)
					{
						//TODO: remember which graphs of other have a corresponding graph in this, they do not have to be checked again, this will increase speed because of they do not need to be doublechecked 
						boolean foundEqualGraph= false;
						for (SDocument otherSDocument: othersCorpusGraph.getSDocuments())
						{//run through all SCorpusGraph objects belonging to other
							if (otherSDocument.getSDocumentGraph()!= null){
								if (differences!= null)
								{
									sDocument.getSDocumentGraph().equals(differences, otherSDocument.getSDocumentGraph());
									foundEqualGraph= true;
									break;
								}
								else 
								{
									if (sDocument.getSDocumentGraph().equals(differences, otherSDocument.getSDocumentGraph()))
									{
										foundEqualGraph= true;
										break;
									}
								}
							}
						}//run through all SCorpusGraph objects belonging to other
						if (!foundEqualGraph)
						{
							containsAllSDocumentGraphs= false;
						}
						else
						{
							containsAllSDocumentGraphs= true;
						}
						if (!containsAllSDocumentGraphs)
						{
							break;
						}
					}
					else 
					{//TODO this is not correct, because if the documentGraph of this.getSDocuments contains only null values, this method will return true, with no matter, what the document-graphs of the other objects are 
						containsAllSDocumentGraphs= true;
					}//TODO this is not correct, because if the documentGraph of this.getSDocuments contains only null values, this method will return true, with no matter, what the document-graphs of the other objects are
				}
				return(containsAllSDocumentGraphs);
			}//if sDocumentGraphs exists in both corpus graphs
		}
		return(true);
	}
	
	/**
	 * Checks if the given object equals to this. Means, each field has to be exactly the same.
	 */
	@Override
	public boolean equals(Object obj)
	{
		boolean retVal= this.equals(null, obj); 
		return(retVal);
	}
	
// ============================ start: handling relations
	/**
	 * Calls the super method an puts the given relation into a relation type index.
	 * an exception will be thrown.
	 * @param edge to add
	 */
	protected void basicAddEdge(Edge edge)
	{
		if (!(edge instanceof SRelation))
			throw new SaltCoreException("Cannot insert an edge, which is not a SRelation object: "+ edge);
		
		//start: create a name if none exists
			if (	(((SRelation)edge).getSName()== null)||
					(((SRelation)edge).getSName().isEmpty()))
			{
				if ( edge instanceof SCorpusRelation)
					((SRelation)edge).setSName("corpRel"+ (this.getSCorpusRelations().size()+1));
				else if ( edge instanceof SCorpusDocumentRelation)
					((SRelation)edge).setSName("corpDocRel"+ (this.getSCorpusDocumentRelations().size()+1));
				else ((SRelation)edge).setSName("rel"+ (this.getSRelations().size()+1));
			}
		//end: create a name if none exists	
		if (	(((SRelation)edge).getSId()== null)||
				(((SRelation)edge).getSId().isEmpty()))
		{	
			((SRelation)edge).setSId("salt:/"+((SRelation)edge).getSName());
		}
		super.basicAddEdge(edge);
		
		// map some implementation types to the matching interfaces
		Class key;
		if (edge instanceof SCorpusRelation)
			key= SCorpusRelation.class;
		else if (edge instanceof SCorpusDocumentRelation)
			key= SCorpusDocumentRelation.class;
		else
			key= edge.getClass();

		getCentralIndex().put(IDX_SRELATIONTYPE, key, edge);
	}
// ============================ end: handling relations
// ============================ start: handling nodes
	
	/**
	 * Calls the super method an puts the given node into a node type index.
	 * an exception will be thrown.
	 * @param node to add
	 */
	protected void basicAddNode(Node node)
	{
		if (!(node instanceof SNode))
			throw new SaltCoreException("Cannot insert a node, which is not a SNode object: "+ node);
	
		//start: create a name if none exists
			if (	(((SNode)node).getSName()== null)||
					(((SNode)node).getSName().isEmpty()))
			{
				if ( node instanceof SCorpus)
					((SNode)node).setSName("corp"+ (this.getSCorpora().size()+1));
				else if ( node instanceof SDocument)
					((SNode)node).setSName("doc"+ (this.getSDocuments().size()+1));
				else ((SNode)node).setSName("node"+ (this.getSDocuments().size()+1));
			}
		//end: create a name if none exists
		if (	(((SNode)node).getSId()== null)||
				(((SNode)node).getSId().isEmpty()))
		{//sid a name if none exists	
			((SNode)node).setSId("salt:/"+((SNode)node).getSName());
		}//sid a name if none exists
		
		super.basicAddNode(node);
		
		// map some implementation types to the matching interfaces
		Class key;
		if (node instanceof SCorpus)
			key= SCorpus.class;
		else if (node instanceof SDocument)
			key= SDocument.class;
		else
			key= node.getClass();
		
		//end: compute slot id
		getCentralIndex().put(IDX_SNODETYPE, key, node);
	}
// ============================ end: handling nodes

// ============================ start: handling specific nodes
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	public EList<SCorpus> getSCorpora() 
	{
		return getCentralIndex().getAll(IDX_SNODETYPE, SCorpus.class);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	public EList<SDocument> getSDocuments() 
	{
		return(getCentralIndex().getAll(IDX_SNODETYPE, SDocument.class));
}
// ============================ end: handling specific nodes
// ============================ start: handling specific relations
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	public EList<SCorpusRelation> getSCorpusRelations() 
	{
		return(getCentralIndex().getAll(IDX_SRELATIONTYPE, SCorpusRelation.class));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	public EList<SCorpusDocumentRelation> getSCorpusDocumentRelations() 
	{
		return(getCentralIndex().getAll(IDX_SRELATIONTYPE, SCorpusDocumentRelation.class));
	}
// ============================ end: handling specific relations

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SCorpusStructurePackage.Literals.SCORPUS_GRAPH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltProject getSaltProject() {
		if (eContainerFeatureID() != SCorpusStructurePackage.SCORPUS_GRAPH__SALT_PROJECT) return null;
		return (SaltProject)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSaltProject(SaltProject newSaltProject, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSaltProject, SCorpusStructurePackage.SCORPUS_GRAPH__SALT_PROJECT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSaltProject(SaltProject newSaltProject) {
		if (newSaltProject != eInternalContainer() || (eContainerFeatureID() != SCorpusStructurePackage.SCORPUS_GRAPH__SALT_PROJECT && newSaltProject != null)) {
			if (EcoreUtil.isAncestor(this, newSaltProject))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSaltProject != null)
				msgs = ((InternalEObject)newSaltProject).eInverseAdd(this, SaltCommonPackage.SALT_PROJECT__SCORPUS_GRAPHS, SaltProject.class, msgs);
			msgs = basicSetSaltProject(newSaltProject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SCorpusStructurePackage.SCORPUS_GRAPH__SALT_PROJECT, newSaltProject, newSaltProject));
	}

	
	
	/**
	 * Returns an SCorpus element corresponding to sCorpusId. If non exists, null will be returned. 
	 * Null will also be returned, if sCorpusId is null or the id belongs to a SNode-object, which is
	 * not of type SCorpus. 
	 */
	public SCorpus getSCorpus(SElementId sCorpusId) 
	{
		SCorpus retVal= null;
		SNode sNode= this.getSNode(sCorpusId.getSId());
		if (sNode instanceof SCorpus)
			retVal= (SCorpus) sNode;
		return retVal;
	}

	/**
	 * Returns an SDocument element corresponding to SDocumentId. If non exists, null will be returned. 
	 * Null will also be returned, if SDocumentId is null or the id belongs to a SNode-object, which is
	 * not of type SDocument. 
	 */
	public SDocument getSDocument(SElementId sDocumentId) 
	{
		SDocument retVal= null;
		SNode sNode= this.getSNode(sDocumentId.getSId());
		if (sNode instanceof SDocument)
			retVal= (SDocument) sNode;
		return retVal;
	}
	
	/**
	 * Adds the given sSubCorpus to the SCorpusGraph object and creates an SCorpusRelation between the given sSuperCorpus
	 * and the sSubCorpus, if and only if the sSuperCorpus is already added to this object. Otherwise an exception will
	 * be thrown. The method returns the SElementId for the generated SCorpusRelation object.
	 * @param sSuperCorpus corpus which already has to be added
	 * @param sSubCorpus corpus to add
	 * @return the SElementId for the generated SCorpusRelation object.
	 * @model
	 */
	public SElementId addSSubCorpus(SCorpus sSuperCorpus, SCorpus sSubCorpus) {
		if (sSuperCorpus== null)
			throw new SaltException("Cannot add the given sSubCorpus, because the given sSuperCorpus is null.");
		if (sSubCorpus== null)
			throw new SaltException("Cannot add the given sSubCorpus, because it is null.");
		if (sSuperCorpus.getSId()== null)
			throw new SaltException("Cannot add the given sSubCorpus, because the given sSuperCorpus is not already contained in corpus graph.");
		if (this.getSNode(sSuperCorpus.getSId())== null)
			throw new SaltException("Cannot add the given sSubCorpus, because the given sSuperCorpus is not already contained in corpus graph.");
		
		String namePart= null;
		namePart= sSubCorpus.getSName();
		if (	(namePart== null)||
				(namePart.isEmpty()))
			namePart= "corp_"+this.getSCorpora().size();
		
		SElementId sSubCorpusId= SaltFactory.eINSTANCE.createSElementId();
		sSubCorpusId.setSElementPath(URI.createURI(sSuperCorpus.getSId()+"/"+ namePart));
		sSubCorpus.setSElementId(sSubCorpusId);
		
		this.addSNode(sSubCorpus);
		SCorpusRelation sCorpRel= SaltFactory.eINSTANCE.createSCorpusRelation();
		sCorpRel.setSSuperCorpus(sSuperCorpus);
		sCorpRel.setSSubCorpus(sSubCorpus);
		this.addSRelation(sCorpRel);
		
		SElementId retVal= null;
		retVal= sCorpRel.getSElementId();
		
		return(retVal);
	}

	/**
	 * Adds the given sDocument to the SCorpusGraph object and creates an SCorpusDocumentRelation between the given 
	 * sCorpus and the sDocument, if and only if the sCorpus is already added to this object. Otherwise an exception will
	 * be thrown. The method returns the SElementId for the generated SCorpusDocumentRelation object.
	 * @param sCorpus corpus to which the document has to be added
	 * @param sDocument document to add
	 * @return the SElementId for the generated SCorpusDocumentRelation object
	 * @model
	 */
	public SElementId addSDocument(SCorpus sCorpus, SDocument sDocument) {
		if (sCorpus== null)
			throw new SaltException("Cannot add the given sDocument, because the given sCorpus is null.");
		if (sDocument== null)
			throw new SaltException("Cannot add the given sDocument, because it is null.");
		if (this.getSNode(sCorpus.getSId())== null)
			throw new SaltException("Cannot add the given sDocument, because the given sCorpus is not already contained in corpus graph.");
		
		String namePart= null;
		namePart= sDocument.getSName();
		if (	(namePart== null)||
				(namePart.isEmpty()))
			namePart= "doc_"+this.getSCorpora().size();
		
		SElementId sDocumentId= SaltFactory.eINSTANCE.createSElementId();
		sDocumentId.setSElementPath(URI.createURI(sCorpus.getSId()+"/"+ namePart));
		sDocument.setSElementId(sDocumentId);
		
		this.addSNode(sDocument);
		SCorpusDocumentRelation sCorpDocRel= SaltFactory.eINSTANCE.createSCorpusDocumentRelation();
		sCorpDocRel.setSCorpus(sCorpus);
		sCorpDocRel.setSDocument(sDocument);
		this.addSRelation(sCorpDocRel);
		
		SElementId retVal= null;
		retVal= sCorpDocRel.getSElementId();
		
		return(retVal);
	}

	/**
	 * Returns the SCorpus object, which contains the given SDocument object (means the SCorpus object and the given 
	 * SDocument object must be connected via a SCorpusDocumentRelation object).  
	 * @param sDocument the SDocument object beyond the SCorpus object to be returned
	 * @return the SCorpus object containing sDocument
	 * @model
	 */
	@Override
	public SCorpus getSCorpus(SDocument sDocument) 
	{
		SCorpus retVal= null;
		if (sDocument!= null)
		{
			EList<Edge> inEdges= this.getInEdges(sDocument.getSId());
			for (Edge inEdge: Collections.synchronizedCollection(inEdges))
			{
				if (inEdge instanceof SCorpusDocumentRelation)
				{
					
					retVal= ((SCorpusDocumentRelation) inEdge).getSCorpus();
					break;
				}
			}
		}
		return(retVal);
	}
	
	/**
	 * Returns a list of SCorpus object being the root corpora of this SCorpusGraph object. 
	 * @model kind="operation"
	 * @return a list of corpus objects being root corpora
	 */
	public EList<SCorpus> getSRootCorpus() 
	{
		EList<SCorpus> retVal = new BasicEList<SCorpus>();
		EList<SNode> sRoots = this.getSRoots(); 
		if (sRoots!=null)
			for (Node node : sRoots)
				if (node instanceof SCorpus)
					retVal.add((SCorpus)node);
		return retVal;
	}
	/**
	 * Loads the content of this object by reading the SaltXML file located by the given {@link URI}. 
	 * The SaltXML file can either contain a {@link SaltProject}, than the first {@link SCorpusGraph} 
	 * object is loaded or just a {@link SCorpusGraph} object.
	 * <br/>
	 * The method delegates to {@link SaltFactory#loadSCorpusGraph(URI)}.
	 * <br/>
	 * Caution: The loading is done by creating a new {@link SCorpusGraph} object and copying its values
	 * to this object. This will need longer than a direct load.
	 * @param sCorpusGraphUri location of the SaltXML file
	 */
	public void load(URI sCorpusGraphUri) {
		SCorpusGraph sCorpusGraph= SaltFactory.eINSTANCE.loadSCorpusGraph(sCorpusGraphUri);
		
		//moves content of loaded SCorpusgraph object to this
		SaltFactory.eINSTANCE.move(sCorpusGraph, this);
	}

	/**
	 * {@inheritDoc SCorpusGraph#createSDocument(SCorpus, String)}
	 */
	public SCorpus createSCorpus(SCorpus superSCorpus, String sCorpusName) {
		SCorpus sCorpus= SaltFactory.eINSTANCE.createSCorpus();
		sCorpus.setSName(sCorpusName);
		if (superSCorpus!= null){
			addSSubCorpus(superSCorpus, sCorpus);
		}else{
			addSNode(sCorpus);
		}
		return(sCorpus);
	}

	/**
	 * {@inheritDoc SCorpusGraph#createSDocument(SCorpus, String)}
	 */
	public SDocument createSDocument(SCorpus parentSCorpus, String sDocumentName) {
		SDocument sDoc= SaltFactory.eINSTANCE.createSDocument();
		sDoc.setSName(sDocumentName);
		addSDocument(parentSCorpus, sDoc);
		return(sDoc);
	}

	/**
	 * {@inheritDoc SCorpusGraph#createSCorpus(URI)}
	 */
	public EList<SCorpus> createSCorpus(URI corpusPath) {
		EList<SCorpus> retVal= null;
		if (corpusPath!= null){
			SCorpus parentCorpus= null;
			for (int i= corpusPath.segments().length-1;i >= 0; i--){
				URI currPath= corpusPath.trimSegments(i);
				SNode sNode= getSNode(currPath.toString());
				if (sNode== null){
					parentCorpus= createSCorpus(parentCorpus, currPath.lastSegment());
					if (retVal== null)
						retVal= new BasicEList<SCorpus>();
					retVal.add(parentCorpus);
				}else{
					parentCorpus= (SCorpus) sNode;
				}
			}
		}
		return(retVal);
	}

	/**
	 * {@inheritDoc SCorpusGraph#createSDocument(URI)}
	 */
	public SDocument createSDocument(URI documentPath) {
		SDocument retVal= null;
		List<SCorpus> corpora= createSCorpus(documentPath.trimSegments(1));
		if (	(corpora== null)||
				(corpora.size()== 0)){
			corpora= new Vector<SCorpus>();
			corpora.add((SCorpus)getSNode(documentPath.trimSegments(1).toString()));
		}
		retVal= createSDocument(corpora.get(corpora.size()-1), documentPath.lastSegment());
		return(retVal);
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
			case SCorpusStructurePackage.SCORPUS_GRAPH__SALT_PROJECT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSaltProject((SaltProject)otherEnd, msgs);
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
			case SCorpusStructurePackage.SCORPUS_GRAPH__SDOCUMENTS:
				return ((InternalEList<?>)getSDocuments()).basicRemove(otherEnd, msgs);
			case SCorpusStructurePackage.SCORPUS_GRAPH__SALT_PROJECT:
				return basicSetSaltProject(null, msgs);
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPORA:
				return ((InternalEList<?>)getSCorpora()).basicRemove(otherEnd, msgs);
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPUS_RELATIONS:
				return ((InternalEList<?>)getSCorpusRelations()).basicRemove(otherEnd, msgs);
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPUS_DOCUMENT_RELATIONS:
				return ((InternalEList<?>)getSCorpusDocumentRelations()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SCorpusStructurePackage.SCORPUS_GRAPH__SALT_PROJECT:
				return eInternalContainer().eInverseRemove(this, SaltCommonPackage.SALT_PROJECT__SCORPUS_GRAPHS, SaltProject.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SCorpusStructurePackage.SCORPUS_GRAPH__SDOCUMENTS:
				return getSDocuments();
			case SCorpusStructurePackage.SCORPUS_GRAPH__SALT_PROJECT:
				return getSaltProject();
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPORA:
				return getSCorpora();
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPUS_RELATIONS:
				return getSCorpusRelations();
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPUS_DOCUMENT_RELATIONS:
				return getSCorpusDocumentRelations();
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
			case SCorpusStructurePackage.SCORPUS_GRAPH__SDOCUMENTS:
				getSDocuments().clear();
				getSDocuments().addAll((Collection<? extends SDocument>)newValue);
				return;
			case SCorpusStructurePackage.SCORPUS_GRAPH__SALT_PROJECT:
				setSaltProject((SaltProject)newValue);
				return;
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPORA:
				getSCorpora().clear();
				getSCorpora().addAll((Collection<? extends SCorpus>)newValue);
				return;
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPUS_RELATIONS:
				getSCorpusRelations().clear();
				getSCorpusRelations().addAll((Collection<? extends SCorpusRelation>)newValue);
				return;
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPUS_DOCUMENT_RELATIONS:
				getSCorpusDocumentRelations().clear();
				getSCorpusDocumentRelations().addAll((Collection<? extends SCorpusDocumentRelation>)newValue);
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
			case SCorpusStructurePackage.SCORPUS_GRAPH__SDOCUMENTS:
				getSDocuments().clear();
				return;
			case SCorpusStructurePackage.SCORPUS_GRAPH__SALT_PROJECT:
				setSaltProject((SaltProject)null);
				return;
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPORA:
				getSCorpora().clear();
				return;
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPUS_RELATIONS:
				getSCorpusRelations().clear();
				return;
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPUS_DOCUMENT_RELATIONS:
				getSCorpusDocumentRelations().clear();
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
			case SCorpusStructurePackage.SCORPUS_GRAPH__SDOCUMENTS:
				return !getSDocuments().isEmpty();
			case SCorpusStructurePackage.SCORPUS_GRAPH__SALT_PROJECT:
				return getSaltProject() != null;
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPORA:
				return !getSCorpora().isEmpty();
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPUS_RELATIONS:
				return !getSCorpusRelations().isEmpty();
			case SCorpusStructurePackage.SCORPUS_GRAPH__SCORPUS_DOCUMENT_RELATIONS:
				return !getSCorpusDocumentRelations().isEmpty();
		}
		return super.eIsSet(featureID);
	}
} //SCorpusGraphImpl
