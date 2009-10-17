/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sCorpusStructure.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.hub.corpling.graph.Edge;
import de.hub.corpling.graph.Node;
import de.hub.corpling.graph.index.ComplexIndex;
import de.hub.corpling.graph.index.Index;
import de.hub.corpling.graph.index.IndexFactory;
import de.hub.corpling.salt.saltCommon.SaltCommonPackage;
import de.hub.corpling.salt.saltCommon.SaltProject;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SDocument;
import de.hub.corpling.salt.saltCore.SElementId;
import de.hub.corpling.salt.saltCore.SNode;
import de.hub.corpling.salt.saltCore.SRelation;
import de.hub.corpling.salt.saltCore.impl.SGraphImpl;
import de.hub.corpling.salt.saltExceptions.SaltException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SCorpus Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusGraphImpl#getSDocuments <em>SDocuments</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusGraphImpl#getSaltProject <em>Salt Project</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusGraphImpl#getSCorpora <em>SCorpora</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusGraphImpl#getSCorpusRelations <em>SCorpus Relations</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusGraphImpl#getSCorpusDocumentRelations <em>SCorpus Document Relations</em>}</li>
 * </ul>
 * </p>
 *
 * @author Florian Zipser
 */
//TODO correct SElementID handling for corpora and documents with relations salt:/corp1/corp2 ... has to be done in addSRelation, in addSNode. roblematically, because it is not clear, that node comes before relation, and that relation always comes with source and target, so notification has to be used
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
			Index index= null;
			
			{//creating node-type index
				index= IndexFactory.eINSTANCE.createComplexIndex();
				index.setId(IDX_SNODETYPE);
				this.getIndexMgr().addIndex(index);
			}
			
			{//creating relation-type index
				index= IndexFactory.eINSTANCE.createComplexIndex();
				index.setId(IDX_SRELATIONTYPE);
				this.getIndexMgr().addIndex(index);
			}
		}
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
			throw new SaltException("Cannot insert an edge, which is not a SRelation object: "+ edge);
		
		{//create a name if none exists
			if (	(((SRelation)edge).getSName()== null)||
					(((SRelation)edge).getSName().equalsIgnoreCase("")))
			{
				if ( edge instanceof SCorpusRelation)
					((SRelation)edge).setSName("corpRel"+ (this.getSCorpusRelations().size()+1));
				else if ( edge instanceof SCorpusDocumentRelation)
					((SRelation)edge).setSName("corpDocRel"+ (this.getSCorpusDocumentRelations().size()+1));
				else ((SRelation)edge).setSName("rel"+ (this.getSRelations().size()+1));
			}
		}	
		
		super.basicAddEdge(edge);
		
		String slotId= null;
		{//compute slot id
			if (edge instanceof SCorpusRelation)
				slotId= SCorpusRelation.class.getName();
			else if (edge instanceof SCorpusDocumentRelation)
				slotId= SCorpusDocumentRelation.class.getName();
			else
				slotId= (String) edge.getClass().getName();
		}
		
		this.getIndexMgr().getIndex(IDX_SRELATIONTYPE).addElement(slotId, edge);
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
			throw new SaltException("Cannot insert a node, which is not a SNode object: "+ node);
		
		{//create a name if none exists
			if (	(((SNode)node).getSName()== null)||
					(((SNode)node).getSName().equalsIgnoreCase("")))
			{
				if ( node instanceof SCorpus)
					((SNode)node).setSName("corp"+ (this.getSCorpora().size()+1));
				else if ( node instanceof SDocument)
					((SNode)node).setSName("doc"+ (this.getSDocuments().size()+1));
				else ((SNode)node).setSName("node"+ (this.getSDocuments().size()+1));
			}
		}	
		
		if (	(((SNode)node).getSId()== null)||
				(((SNode)node).getSId().equalsIgnoreCase("")))
		{	
			((SNode)node).setSId("salt:/"+((SNode)node).getSName());
		}
		super.basicAddNode(node);
		
		String slotId= null;
		{//compute slot id
			if (node instanceof SCorpus)
				slotId= SCorpus.class.getName();
			else if (node instanceof SDocument)
				slotId= SDocument.class.getName();
			else
				slotId= (String) node.getClass().getName();
		}
		
		this.getIndexMgr().getIndex(IDX_SNODETYPE).addElement(slotId, node);
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
		EList<SCorpus> retVal= null;
		EList<Node> nodes= (EList<Node>)(EList<? extends Node>)((ComplexIndex)this.getIndexMgr().getIndex(IDX_SNODETYPE)).getSlot(SCorpus.class.getName());
		if (nodes!= null)
			retVal= new EcoreEList.UnmodifiableEList(this,
					SCorpusStructurePackage.eINSTANCE.getSCorpusGraph_SCorpora(),
					nodes.size(), nodes.toArray());
		else retVal= new EcoreEList.UnmodifiableEList(this,
				SCorpusStructurePackage.eINSTANCE.getSCorpusGraph_SCorpora(), 0, (Object[]) null);
		
		return(retVal);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	public EList<SDocument> getSDocuments() 
	{
		EList<SDocument> retVal= null;
		EList<Node> nodes= (EList<Node>)(EList<? extends Node>)((ComplexIndex)this.getIndexMgr().getIndex(IDX_SNODETYPE)).getSlot(SDocument.class.getName());
		if (nodes!= null)
			retVal= new EcoreEList.UnmodifiableEList(this,
					SCorpusStructurePackage.eINSTANCE.getSCorpusGraph_SDocuments(),
					nodes.size(), nodes.toArray());
		else retVal= new EcoreEList.UnmodifiableEList(this,
				SCorpusStructurePackage.eINSTANCE.getSCorpusGraph_SDocuments(), 0, (Object[]) null);
		
		return(retVal);
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
		EList<SCorpusRelation> retVal= null;
		EList<Edge> edges= (EList<Edge>)(EList<? extends Edge>)((ComplexIndex)this.getIndexMgr().getIndex(IDX_SRELATIONTYPE)).getSlot(SCorpusRelation.class.getName());
		
		if (edges!= null)
			retVal= new EcoreEList.UnmodifiableEList(this,
					SCorpusStructurePackage.eINSTANCE.getSCorpusGraph_SCorpusRelations(),
					edges.size(), edges.toArray());
		else retVal= new EcoreEList.UnmodifiableEList(this,
				SCorpusStructurePackage.eINSTANCE.getSCorpusGraph_SCorpusRelations(), 0, (Object[]) null);
		
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	public EList<SCorpusDocumentRelation> getSCorpusDocumentRelations() 
	{
		EList<SCorpusDocumentRelation> retVal= null;
		EList<Edge> edges= (EList<Edge>)(EList<? extends Edge>)((ComplexIndex)this.getIndexMgr().getIndex(IDX_SRELATIONTYPE)).getSlot(SCorpusDocumentRelation.class.getName());
		
		if (edges!= null)
			retVal= new EcoreEList.UnmodifiableEList(this,
					SCorpusStructurePackage.eINSTANCE.getSCorpusGraph_SCorpusDocumentRelations(),
					edges.size(), edges.toArray());
		else retVal= new EcoreEList.UnmodifiableEList(this,
				SCorpusStructurePackage.eINSTANCE.getSCorpusGraph_SCorpusDocumentRelations(), 0, (Object[]) null);
		
		return(retVal);
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
		return (SaltProject)eContainer();
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
