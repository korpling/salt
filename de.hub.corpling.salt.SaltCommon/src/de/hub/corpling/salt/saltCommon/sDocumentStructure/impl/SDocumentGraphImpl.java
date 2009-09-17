/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.hub.corpling.graph.Edge;
import de.hub.corpling.graph.Node;
import de.hub.corpling.graph.index.ComplexIndex;
import de.hub.corpling.graph.index.Index;
import de.hub.corpling.graph.index.IndexFactory;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SDocument;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeline;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken;
import de.hub.corpling.salt.saltCore.SNode;
import de.hub.corpling.salt.saltCore.SRelation;
import de.hub.corpling.salt.saltCore.impl.SGraphImpl;
import de.hub.corpling.salt.saltExceptions.SaltException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SDocument Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentGraphImpl#getSDocument <em>SDocument</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentGraphImpl#getSTextualDSs <em>STextual DSs</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentGraphImpl#getSTextualRelations <em>STextual Relations</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentGraphImpl#getSTokens <em>STokens</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentGraphImpl#getSTimeline <em>STimeline</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SDocumentGraphImpl extends SGraphImpl implements SDocumentGraph {
	/**
	 * name of index for node-types
	 */
	protected static final String IDX_SNODETYPE=	"idx_sNodeType";
	/**
	 * name of index for relation-types
	 */
	protected static final String IDX_SRELATIONTYPE=	"idx_sRelationType";
	
	/**
	 * The cached value of the '{@link #getSDocument() <em>SDocument</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSDocument()
	 * @generated
	 * @ordered
	 */
	protected SDocument sDocument;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected SDocumentGraphImpl() {
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDocumentStructurePackage.Literals.SDOCUMENT_GRAPH;
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
		super.basicAddEdge(edge);
		String slotId= null;
		{//compute slot id
			if (edge instanceof STextualRelation)
				slotId= STextualRelation.class.getName();
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
		super.basicAddNode(node);
		
		String slotId= null;
		{//compute slot id
			if (node instanceof SToken)
				slotId= SToken.class.getName();
			else if (node instanceof STextualDS)
				slotId= STextualDS.class.getName();
			else if (node instanceof STimeline)
				slotId= STimeline.class.getName();
			else
				slotId= (String) node.getClass().getName();
		}
		
		this.getIndexMgr().getIndex(IDX_SNODETYPE).addElement(slotId, node);
	}
// ============================ end: handling nodes
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDocument getSDocument() {
		if (sDocument != null && sDocument.eIsProxy()) {
			InternalEObject oldSDocument = (InternalEObject)sDocument;
			sDocument = (SDocument)eResolveProxy(oldSDocument);
			if (sDocument != oldSDocument) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SDocumentStructurePackage.SDOCUMENT_GRAPH__SDOCUMENT, oldSDocument, sDocument));
			}
		}
		return sDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDocument basicGetSDocument() {
		return sDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSDocument(SDocument newSDocument, NotificationChain msgs) {
		SDocument oldSDocument = sDocument;
		sDocument = newSDocument;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SDocumentStructurePackage.SDOCUMENT_GRAPH__SDOCUMENT, oldSDocument, newSDocument);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSDocument(SDocument newSDocument) {
		if (newSDocument != sDocument) {
			NotificationChain msgs = null;
			if (sDocument != null)
				msgs = ((InternalEObject)sDocument).eInverseRemove(this, SCorpusStructurePackage.SDOCUMENT__SDOCUMENT_GRAPH, SDocument.class, msgs);
			if (newSDocument != null)
				msgs = ((InternalEObject)newSDocument).eInverseAdd(this, SCorpusStructurePackage.SDOCUMENT__SDOCUMENT_GRAPH, SDocument.class, msgs);
			msgs = basicSetSDocument(newSDocument, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SDocumentStructurePackage.SDOCUMENT_GRAPH__SDOCUMENT, newSDocument, newSDocument));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	public EList<STextualDS> getSTextualDSs() 
	{
		EList<STextualDS> retVal= null;
		EList<Node> nodes= (EList<Node>)(EList<? extends Node>)((ComplexIndex)this.getIndexMgr().getIndex(IDX_SNODETYPE)).getSlot(STextualDS.class.getName());
		if (nodes!= null)
			retVal= new EcoreEList.UnmodifiableEList(this,
					SDocumentStructurePackage.eINSTANCE.getSDocumentGraph_STextualDSs(),
					nodes.size(), nodes.toArray());
		else retVal= new EcoreEList.UnmodifiableEList(this,
				SDocumentStructurePackage.eINSTANCE.getSDocumentGraph_STextualDSs(), 0, (Object[]) null);
		
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	public EList<STextualRelation> getSTextualRelations() 
	{
		EList<STextualRelation> retVal= null;
		EList<Node> nodes= (EList<Node>)(EList<? extends Node>)((ComplexIndex)this.getIndexMgr().getIndex(IDX_SRELATIONTYPE)).getSlot(STextualRelation.class.getName());
		
		if (nodes!= null)
			retVal= new EcoreEList.UnmodifiableEList(this,
					SDocumentStructurePackage.eINSTANCE.getSDocumentGraph_STextualRelations(),
					nodes.size(), nodes.toArray());
		else retVal= new EcoreEList.UnmodifiableEList(this,
				SDocumentStructurePackage.eINSTANCE.getSDocumentGraph_STextualRelations(), 0, (Object[]) null);
		
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	public EList<SToken> getSTokens() 
	{
		EList<SToken> retVal= null;
		EList<Node> nodes= (EList<Node>)(EList<? extends Node>)((ComplexIndex)this.getIndexMgr().getIndex(IDX_SNODETYPE)).getSlot(SToken.class.getName());
		if (nodes!= null)
			retVal= new EcoreEList.UnmodifiableEList(this,
					SDocumentStructurePackage.eINSTANCE.getSDocumentGraph_STokens(),
					nodes.size(), nodes.toArray());
		else retVal= new EcoreEList.UnmodifiableEList(this,
				SDocumentStructurePackage.eINSTANCE.getSDocumentGraph_STokens(), 0, (Object[]) null);
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STimeline getSTimeline() {
		STimeline sTimeline = basicGetSTimeline();
		return sTimeline != null && sTimeline.eIsProxy() ? (STimeline)eResolveProxy((InternalEObject)sTimeline) : sTimeline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	public STimeline basicGetSTimeline() 
	{
		STimeline retVal= null;
		EList<Node> nodes= (EList<Node>)(EList<? extends Node>)((ComplexIndex)this.getIndexMgr().getIndex(IDX_SNODETYPE)).getSlot(STimeline.class.getName());
		if (	(nodes!= null)&&
				(nodes.size()> 0))
		{	
			retVal= (STimeline)nodes.get(0);
		}
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSTimeline(STimeline newSTimeline) 
	{
		this.addSNode(newSTimeline);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__SDOCUMENT:
				if (sDocument != null)
					msgs = ((InternalEObject)sDocument).eInverseRemove(this, SCorpusStructurePackage.SDOCUMENT__SDOCUMENT_GRAPH, SDocument.class, msgs);
				return basicSetSDocument((SDocument)otherEnd, msgs);
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
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__SDOCUMENT:
				return basicSetSDocument(null, msgs);
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__STEXTUAL_DSS:
				return ((InternalEList<?>)getSTextualDSs()).basicRemove(otherEnd, msgs);
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__STEXTUAL_RELATIONS:
				return ((InternalEList<?>)getSTextualRelations()).basicRemove(otherEnd, msgs);
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__STOKENS:
				return ((InternalEList<?>)getSTokens()).basicRemove(otherEnd, msgs);
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
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__SDOCUMENT:
				if (resolve) return getSDocument();
				return basicGetSDocument();
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__STEXTUAL_DSS:
				return getSTextualDSs();
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__STEXTUAL_RELATIONS:
				return getSTextualRelations();
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__STOKENS:
				return getSTokens();
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__STIMELINE:
				if (resolve) return getSTimeline();
				return basicGetSTimeline();
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
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__SDOCUMENT:
				setSDocument((SDocument)newValue);
				return;
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__STEXTUAL_DSS:
				getSTextualDSs().clear();
				getSTextualDSs().addAll((Collection<? extends STextualDS>)newValue);
				return;
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__STEXTUAL_RELATIONS:
				getSTextualRelations().clear();
				getSTextualRelations().addAll((Collection<? extends STextualRelation>)newValue);
				return;
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__STOKENS:
				getSTokens().clear();
				getSTokens().addAll((Collection<? extends SToken>)newValue);
				return;
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__STIMELINE:
				setSTimeline((STimeline)newValue);
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
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__SDOCUMENT:
				setSDocument((SDocument)null);
				return;
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__STEXTUAL_DSS:
				getSTextualDSs().clear();
				return;
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__STEXTUAL_RELATIONS:
				getSTextualRelations().clear();
				return;
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__STOKENS:
				getSTokens().clear();
				return;
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__STIMELINE:
				setSTimeline((STimeline)null);
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
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__SDOCUMENT:
				return sDocument != null;
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__STEXTUAL_DSS:
				return !getSTextualDSs().isEmpty();
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__STEXTUAL_RELATIONS:
				return !getSTextualRelations().isEmpty();
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__STOKENS:
				return !getSTokens().isEmpty();
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__STIMELINE:
				return basicGetSTimeline() != null;
		}
		return super.eIsSet(featureID);
	}

} //SDocumentGraphImpl
