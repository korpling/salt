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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.ComplexIndex;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltElementNotContainedInGraphException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltImproperSTypeException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeline;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimelineRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SGraphImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SDocument Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentGraphImpl#getSDocument <em>SDocument</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentGraphImpl#getSTextualDSs <em>STextual DSs</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentGraphImpl#getSTextualRelations <em>STextual Relations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentGraphImpl#getSTokens <em>STokens</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentGraphImpl#getSTimeline <em>STimeline</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentGraphImpl#getSTimelineRelations <em>STimeline Relations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentGraphImpl#getSSpanningRelations <em>SSpanning Relations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentGraphImpl#getSSpans <em>SSpans</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentGraphImpl#getSStructures <em>SStructures</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentGraphImpl#getSDominanceRelations <em>SDominance Relations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentGraphImpl#getSPointingRelations <em>SPointing Relations</em>}</li>
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
		
		{//create a name if none exists
			if (	(((SRelation)edge).getSName()== null)||
					(((SRelation)edge).getSName().equals("")))
			{
				if ( edge instanceof STextualRelation)
					((SRelation)edge).setSName("sTextRel"+ (this.getSTextualRelations().size()+1));
				else if ( edge instanceof STimelineRelation)
					((SRelation)edge).setSName("sTimeRel"+ (this.getSTimelineRelations().size()+1));
				else if ( edge instanceof SSpanningRelation)
					((SRelation)edge).setSName("sSpanRel"+ (this.getSSpanningRelations().size()+1));
				else if ( edge instanceof SPointingRelation)
					((SRelation)edge).setSName("sPointingRel"+ (this.getSPointingRelations().size()+1));
				else if ( edge instanceof SDominanceRelation)
					((SRelation)edge).setSName("sDomRel"+ (this.getSDominanceRelations().size()+1));
				else ((SRelation)edge).setSName("sRel"+ (this.getSRelations().size()+1));
			}
		}	
		
		super.basicAddEdge(edge);
		
		String slotId= null;
		{//compute slot id
			if (edge instanceof STextualRelation)
				slotId= STextualRelation.class.getName();
			else if (edge instanceof STimelineRelation)
				slotId= STimelineRelation.class.getName();
			else if (edge instanceof SSpanningRelation)
				slotId= SSpanningRelation.class.getName();
			else if (edge instanceof SPointingRelation)
				slotId= SPointingRelation.class.getName();
			else if (edge instanceof SDominanceRelation)
				slotId= SDominanceRelation.class.getName();
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
					(((SNode)node).getSName().equals("")))
			{
				if ( node instanceof STextualDS)
					((SNode)node).setSName("sText"+ (this.getSTextualDSs().size()+1));
				else if ( node instanceof SToken)
					((SNode)node).setSName("sTok"+ (this.getSTokens().size()+1));
				else if ( node instanceof STimeline)
					((SNode)node).setSName("sTimeline"+ (this.getSTokens().size()+1));
				else if ( node instanceof SSpan)
					((SNode)node).setSName("sSpan"+ (this.getSSpans().size()+1));
				else if ( node instanceof SStructure)
					((SNode)node).setSName("structure"+ (this.getSStructures().size()+1));
				else ((SNode)node).setSName("sNode"+ (this.getSNodes().size()+1));
			}
		}	
		
		if (	(((SNode)node).getSId()== null)||
				(((SNode)node).getSId().equals("")))
			((SNode)node).setSId(this.getSId() + "#"+ ((SNode)node).getSName());
		super.basicAddNode(node);
		
		String slotId= null;
		{//compute slot id
			if (node instanceof SToken)
				slotId= SToken.class.getName();
			else if (node instanceof STextualDS)
				slotId= STextualDS.class.getName();
			else if (node instanceof STimeline)
				slotId= STimeline.class.getName();
			else if (node instanceof SSpan)
				slotId= SSpan.class.getName();
			else if (node instanceof SStructure)
				slotId= SStructure.class.getName();
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
	 * calls setSName and sets Id for SElementId of this. 
	 */
	public void basicSetSElementId() {
		this.setSName(null);
		if (this.getSElementId()==null) {
			this.setSElementId(SaltFactory.eINSTANCE.createSElementId());
		}
		if (this.getSDocument()!= null)
			this.getSElementId().setId(this.getSDocument().getSId() + "/" + this.getSName());
		else this.getSElementId().setId("/" + this.getSName());
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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

		this.basicSetSElementId();
	}

// ============================ start: handling specific nodes
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EList<STextualDS> getSTextualDSs() 
	{
		EList<STextualDS> retVal= null;
		EList<Node> nodes= (EList<Node>)(EList<? extends Object>)((ComplexIndex)this.getIndexMgr().getIndex(IDX_SNODETYPE)).getSlot(STextualDS.class.getName());
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EList<SToken> getSTokens() 
	{
		EList<SToken> retVal= null;
		EList<Node> nodes= (EList<Node>)(EList<? extends Object>)((ComplexIndex)this.getIndexMgr().getIndex(IDX_SNODETYPE)).getSlot(SToken.class.getName());
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
		EList<Node> nodes= (EList<Node>)(EList<? extends Object>)((ComplexIndex)this.getIndexMgr().getIndex(IDX_SNODETYPE)).getSlot(STimeline.class.getName());
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
	public void addSNode(SNode sNode) 
	{
		super.addNode(sNode);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SRelation addSNode(SNode sourceSNode, SNode targetSNode, STYPE_NAME sRelationType) {
		if (!this.getSNodes().contains(sourceSNode)) {
			throw new SaltElementNotContainedInGraphException("Given SNode cannot be used as source node, because it is not contained in the SDocumentGraph");
		}
		SRelation retVal = null;
		switch (sRelationType) {
		  case STEXTUAL_RELATION:   retVal = SaltCommonFactory.eINSTANCE.createSTextualRelation(); 	 break;
	      case SPOINTING_RELATION:  retVal = SaltCommonFactory.eINSTANCE.createSPointingRelation();  break;
	      case SSPANNING_RELATION:  retVal = SaltCommonFactory.eINSTANCE.createSSpanningRelation();	 break;
	      case SDOMINANCE_RELATION: retVal = SaltCommonFactory.eINSTANCE.createSDominanceRelation(); break;
	      default:;
		}
		if (retVal==null) {
			throw new SaltImproperSTypeException("Improper STYPE_NAME for this method; must be one of STEXTUAL_RELATION, SPOINTING_RELATION, SSPANNING_RELATION and SDOMINANCE_RELATION.");
		}
		retVal.setSSource(sourceSNode);
	    retVal.setSTarget(targetSNode);
	    if (!this.getSNodes().contains(targetSNode)) {
	    	this.addSNode(targetSNode);
	    }
	    this.addSRelation(retVal);
	    return retVal;
	}
	
	/**
	 * Sets the SName of the SDocumentGraphImpl, but the parameter newSName is just a dummy. The SName of the corresponding SDocument plus "_graph" will be the SName.
	 */
	public void setSName(String newSName) {
		if (this.getSDocument()!=null) {
			this.sName = this.getSDocument().getSName() + SDocumentStructurePackage.SDOCUMENTGRAPH_ENDING;
		}
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
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EList<SSpan> getSSpans() 
	{
		EList<SSpan> retVal= null;
		EList<Node> nodes= (EList<Node>)(EList<? extends Object>)((ComplexIndex)this.getIndexMgr().getIndex(IDX_SNODETYPE)).getSlot(SSpan.class.getName());
		if (nodes!= null)
			retVal= new EcoreEList.UnmodifiableEList(this,
					SDocumentStructurePackage.eINSTANCE.getSDocumentGraph_SSpans(),
					nodes.size(), nodes.toArray());
		else retVal= new EcoreEList.UnmodifiableEList(this,
				SDocumentStructurePackage.eINSTANCE.getSDocumentGraph_SSpans(), 0, (Object[]) null);
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EList<SStructure> getSStructures() 
	{
		EList<SStructure> retVal= null;
		EList<Node> nodes= (EList<Node>)(EList<? extends Object>)((ComplexIndex)this.getIndexMgr().getIndex(IDX_SNODETYPE)).getSlot(SStructure.class.getName());
		if (nodes!= null)
			retVal= new EcoreEList.UnmodifiableEList(this,
					SDocumentStructurePackage.eINSTANCE.getSDocumentGraph_SStructures(),
					nodes.size(), nodes.toArray());
		else retVal= new EcoreEList.UnmodifiableEList(this,
				SDocumentStructurePackage.eINSTANCE.getSDocumentGraph_SStructures(), 0, (Object[]) null);
		return(retVal);
	}

// ============================ end: handling specific nodes
// ============================ start: handling specific relations
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EList<STextualRelation> getSTextualRelations() 
	{
		EList<STextualRelation> retVal= null;
		EList<Edge> edges= (EList<Edge>)(EList<? extends Object>)((ComplexIndex)this.getIndexMgr().getIndex(IDX_SRELATIONTYPE)).getSlot(STextualRelation.class.getName());
		
		if (edges!= null)
			retVal= new EcoreEList.UnmodifiableEList(this,
					SDocumentStructurePackage.eINSTANCE.getSDocumentGraph_STextualRelations(),
					edges.size(), edges.toArray());
		else retVal= new EcoreEList.UnmodifiableEList(this,
				SDocumentStructurePackage.eINSTANCE.getSDocumentGraph_STextualRelations(), 0, (Object[]) null);
		
		return(retVal);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EList<STimelineRelation> getSTimelineRelations() 
	{

		EList<STimelineRelation> retVal= null;
		EList<Edge> edges= (EList<Edge>)(EList<? extends Object>)((ComplexIndex)this.getIndexMgr().getIndex(IDX_SRELATIONTYPE)).getSlot(STimelineRelation.class.getName());
		
		if (edges!= null)
			retVal= new EcoreEList.UnmodifiableEList(this,
					SDocumentStructurePackage.eINSTANCE.getSDocumentGraph_STimelineRelations(),
					edges.size(), edges.toArray());
		else retVal= new EcoreEList.UnmodifiableEList(this,
				SDocumentStructurePackage.eINSTANCE.getSDocumentGraph_STimelineRelations(), 0, (Object[]) null);
		
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EList<SSpanningRelation> getSSpanningRelations() 
	{
		EList<SSpanningRelation> retVal= null;
		EList<Edge> edges= (EList<Edge>)(EList<? extends Object>)((ComplexIndex)this.getIndexMgr().getIndex(IDX_SRELATIONTYPE)).getSlot(SSpanningRelation.class.getName());
		
		if (edges!= null)
			retVal= new EcoreEList.UnmodifiableEList(this,
					SDocumentStructurePackage.eINSTANCE.getSDocumentGraph_SSpanningRelations(),
					edges.size(), edges.toArray());
		else retVal= new EcoreEList.UnmodifiableEList(this,
				SDocumentStructurePackage.eINSTANCE.getSDocumentGraph_SSpanningRelations(), 0, (Object[]) null);
		
		return(retVal);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EList<SDominanceRelation> getSDominanceRelations() 
	{
		EList<SDominanceRelation> retVal= null;
		EList<Edge> edges= (EList<Edge>)(EList<? extends Object>)((ComplexIndex)this.getIndexMgr().getIndex(IDX_SRELATIONTYPE)).getSlot(SDominanceRelation.class.getName());
		
		if (edges!= null)
			retVal= new EcoreEList.UnmodifiableEList(this,
					SDocumentStructurePackage.eINSTANCE.getSDocumentGraph_SDominanceRelations(),
					edges.size(), edges.toArray());
		else retVal= new EcoreEList.UnmodifiableEList(this,
				SDocumentStructurePackage.eINSTANCE.getSDocumentGraph_SDominanceRelations(), 0, (Object[]) null);
		
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EList<SPointingRelation> getSPointingRelations() 
	{
		EList<SPointingRelation> retVal= null;
		EList<Edge> edges= (EList<Edge>)(EList<? extends Object>)((ComplexIndex)this.getIndexMgr().getIndex(IDX_SRELATIONTYPE)).getSlot(SPointingRelation.class.getName());
		
		if (edges!= null)
			retVal= new EcoreEList.UnmodifiableEList(this,
					SDocumentStructurePackage.eINSTANCE.getSDocumentGraph_SPointingRelations(),
					edges.size(), edges.toArray());
		else retVal= new EcoreEList.UnmodifiableEList(this,
				SDocumentStructurePackage.eINSTANCE.getSDocumentGraph_SPointingRelations(), 0, (Object[]) null);
		
		return(retVal);
	}

	// ============================ end: handling specific relations
	
	protected void finalize() throws Throwable 
	{
	    try {
	    } finally {
	        super.finalize();
	    }
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__SDOCUMENT:
				if (sDocument != null) {
					msgs = ((InternalEObject)sDocument).eInverseRemove(this, SCorpusStructurePackage.SDOCUMENT__SDOCUMENT_GRAPH, SDocument.class, msgs);
					this.basicSetSElementId();
				}
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
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__STIMELINE_RELATIONS:
				return ((InternalEList<?>)getSTimelineRelations()).basicRemove(otherEnd, msgs);
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__SSPANNING_RELATIONS:
				return ((InternalEList<?>)getSSpanningRelations()).basicRemove(otherEnd, msgs);
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__SSPANS:
				return ((InternalEList<?>)getSSpans()).basicRemove(otherEnd, msgs);
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__SSTRUCTURES:
				return ((InternalEList<?>)getSStructures()).basicRemove(otherEnd, msgs);
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__SDOMINANCE_RELATIONS:
				return ((InternalEList<?>)getSDominanceRelations()).basicRemove(otherEnd, msgs);
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__SPOINTING_RELATIONS:
				return ((InternalEList<?>)getSPointingRelations()).basicRemove(otherEnd, msgs);
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
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__STIMELINE_RELATIONS:
				return getSTimelineRelations();
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__SSPANNING_RELATIONS:
				return getSSpanningRelations();
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__SSPANS:
				return getSSpans();
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__SSTRUCTURES:
				return getSStructures();
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__SDOMINANCE_RELATIONS:
				return getSDominanceRelations();
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__SPOINTING_RELATIONS:
				return getSPointingRelations();
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
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__STIMELINE_RELATIONS:
				getSTimelineRelations().clear();
				getSTimelineRelations().addAll((Collection<? extends STimelineRelation>)newValue);
				return;
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__SSPANNING_RELATIONS:
				getSSpanningRelations().clear();
				getSSpanningRelations().addAll((Collection<? extends SSpanningRelation>)newValue);
				return;
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__SSPANS:
				getSSpans().clear();
				getSSpans().addAll((Collection<? extends SSpan>)newValue);
				return;
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__SSTRUCTURES:
				getSStructures().clear();
				getSStructures().addAll((Collection<? extends SStructure>)newValue);
				return;
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__SDOMINANCE_RELATIONS:
				getSDominanceRelations().clear();
				getSDominanceRelations().addAll((Collection<? extends SDominanceRelation>)newValue);
				return;
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__SPOINTING_RELATIONS:
				getSPointingRelations().clear();
				getSPointingRelations().addAll((Collection<? extends SPointingRelation>)newValue);
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
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__STIMELINE_RELATIONS:
				getSTimelineRelations().clear();
				return;
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__SSPANNING_RELATIONS:
				getSSpanningRelations().clear();
				return;
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__SSPANS:
				getSSpans().clear();
				return;
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__SSTRUCTURES:
				getSStructures().clear();
				return;
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__SDOMINANCE_RELATIONS:
				getSDominanceRelations().clear();
				return;
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__SPOINTING_RELATIONS:
				getSPointingRelations().clear();
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
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__STIMELINE_RELATIONS:
				return !getSTimelineRelations().isEmpty();
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__SSPANNING_RELATIONS:
				return !getSSpanningRelations().isEmpty();
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__SSPANS:
				return !getSSpans().isEmpty();
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__SSTRUCTURES:
				return !getSStructures().isEmpty();
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__SDOMINANCE_RELATIONS:
				return !getSDominanceRelations().isEmpty();
			case SDocumentStructurePackage.SDOCUMENT_GRAPH__SPOINTING_RELATIONS:
				return !getSPointingRelations().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SDocumentGraphImpl
