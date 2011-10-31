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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GRAPH_TRAVERSE_TYPE;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphTraverseHandler;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraphTraverseHandler;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNamedElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCoreFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.accessors.SAnnotatableElementAccessor;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.accessors.SFeaturableElementAccessor;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.accessors.SIdentifiableElementAccessor;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.accessors.SMetaAnnotatableElementAccessor;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.accessors.SProcessingAnnotatableElementAccessor;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.exceptions.SaltCoreException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SGraph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SGraphImpl#getSName <em>SName</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SGraphImpl#getSAnnotations <em>SAnnotations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SGraphImpl#getSElementId <em>SElement Id</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SGraphImpl#getSId <em>SId</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SGraphImpl#getSElementPath <em>SElement Path</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SGraphImpl#getSProcessingAnnotations <em>SProcessing Annotations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SGraphImpl#getSFeatures <em>SFeatures</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SGraphImpl#getSMetaAnnotations <em>SMeta Annotations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SGraphImpl#getSRelations <em>SRelations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SGraphImpl#getSNodes <em>SNodes</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SGraphImpl#getSLayers <em>SLayers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SGraphImpl extends GraphImpl implements SGraph {
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
	 * The default value of the '{@link #getSId() <em>SId</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSId()
	 * @generated
	 * @ordered
	 */
	protected static final String SID_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getSElementPath() <em>SElement Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSElementPath()
	 * @generated
	 * @ordered
	 */
	protected static final URI SELEMENT_PATH_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected SGraphImpl() {
		super();
		init();
	}
	
	/**
	 * Initializes an object of this class. This method will be called from the constructor.
	 */
	private void init()
	{
		this.sAnnoAccessor= new SAnnotatableElementAccessor();
		this.sMetaAnnoAccessor= new SMetaAnnotatableElementAccessor();
		this.sProcAnnoAccessor= new SProcessingAnnotatableElementAccessor();
		this.sIdentAccessor= new SIdentifiableElementAccessor();
		this.sFeatAccessor= new SFeaturableElementAccessor();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltCorePackage.Literals.SGRAPH;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SGRAPH__SNAME, oldSName, sName));
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
//			EList<String> diffs= super.differences(obj);
//			if (diffs!= null)
//				differences.addAll(diffs);
			super.equals(differences, obj);
		}
		else return(super.equals(differences, obj));
		return(true);
	}
	
	/**
	 * Checks if a given SGraph has the same entries as this SNode-object. 
	 * @return if all values are equals.
	 */
	@Override
	public boolean equals(Object obj)
	{
		boolean retVal= this.equals(null, obj); 
		return(retVal);

		//TODO outcommented on 26th of June 2010
//		if (!(obj instanceof SGraph))
//			return(false);
//		SGraph sGraph2= (SGraph) obj;
//		{//check ids
//			if (this.getSId()!= null)
//			{	
//				if (sGraph2.getSId()== null)
//					return(false);
//				if (!this.getSId().equalsIgnoreCase(sGraph2.getSId()))
//					return(false);
//			}
//		}
//		{//check SProcessingAnnotations
//			for(SProcessingAnnotation sProcAnno1: this.getSProcessingAnnotations())
//			{
//				boolean hasOpponend= false;
//				for(SProcessingAnnotation sProcAnno2: sGraph2.getSProcessingAnnotations())
//				{
//					if (sProcAnno1.equals(sProcAnno2))
//						hasOpponend= true;
//				}
//				if (!hasOpponend)
//					return(false);
//			}	
//		}
//		{//check SAnnotations
//			for(SAnnotation sAnno1: this.getSAnnotations())
//			{
//				boolean hasOpponend= false;
//				for(SAnnotation sAnno2: sGraph2.getSAnnotations())
//				{
//					if (sAnno1.equals(sAnno2))
//						hasOpponend= true;
//				}
//				if (!hasOpponend)
//					return(false);
//			}	
//		}
//		{//check nodes
//			for (SNode sNode1: this.getSNodes())
//			{
//				boolean hasOpponend= false;
//				for (SNode sNode2: sGraph2.getSNodes())
//				{
//					if (sNode1.equals(sNode2))
//						hasOpponend= true;
//				}	
//				if (!hasOpponend)
//					return(false);
//			}	
//		}
//		{//check relations
//			for (SRelation sRel1: this.getSRelations())
//			{
//				boolean hasOpponend= false;
//				for (SRelation sRel2: sGraph2.getSRelations())
//				{
//					if (sRel1.equals(sRel2))
//						hasOpponend= true;
//				}	
//				if (!hasOpponend)
//					return(false);
//			}	
//		}
//		return(true);
	}
	
//=================== start: handling SNode
	/**
	 * A counter for nodes whose name already exists in graph. This counter gives a new artificial
	 * Postfix for the node id.
	 */
	private long artificialNodeCounter= 0l;
	@Override
	protected void basicAddNode(Node node)
	{
		if (!(node instanceof SNode))
			throw new SaltCoreException("Cannot insert a node, which is not a SNode object: "+ node);
		
		if (((SNode)node).getSElementId()== null)
		{
			StringBuilder nodeId= new StringBuilder(); 
			nodeId.append(node.getId());
			if (this.getSNode(nodeId.toString())!= null)
			{//if node still exists
				nodeId.append("_");
				nodeId.append(this.artificialNodeCounter);
				this.artificialNodeCounter++;
			}//if node still exists
				
			SElementId sElementId= SaltCoreFactory.eINSTANCE.createSElementId();
			((SNode)node).setSElementId(sElementId);
			node.setId(nodeId.toString());
		}
		super.basicAddNode(node);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EList<SNode> getSNodes() 
	{
		EList<SNode> retVal= null;
		EList<Node> nodes= super.getNodes();
		
		if (nodes!= null)
			retVal= new EcoreEList.UnmodifiableEList<SNode>(this,
					SaltCorePackage.eINSTANCE.getSGraph_SNodes(),
					nodes.size(), nodes.toArray());
		else retVal= new EcoreEList.UnmodifiableEList<SNode>(this,
				SaltCorePackage.eINSTANCE.getSGraph_SNodes(), 0, (Object[]) null);
		
		return(retVal);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	public EList<SLayer> getSLayers() 
	{
		return((EList<SLayer>) (EList<? extends Object>)super.getLayers());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addSNode(SNode sNode) 
	{
//		if (	(sNode!= null) &&
//				(sNode.getSName()!= null)&&
//				(!sNode.getSName().equals("")))
//		{
////			sNode.setId(value);
//		}
		super.addNode(sNode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SNode getSNode(String sNodeId) 
	{
		SNode retVal= null;
		Node node= super.getNode(sNodeId);
		if (	(node!= null) &&
				(!(node instanceof SNode)))
			throw new SaltCoreException("Cannot cast a node in SGraph into SNode-object: "+ sNodeId);
		retVal= (SNode) node;
		return(retVal);
	}
//=================== end: handling SNode
//=================== start: handling SRelation
	@Override
	protected void basicAddEdge(Edge edge)
	{
		if (!(edge instanceof SRelation))
			throw new SaltCoreException("Cannot insert a edge, which is not a SRelation object: "+ edge);
		
		if (((SRelation)edge).getSElementId()== null)
		{
			String edgeId= edge.getId();
			SElementId sElementId= SaltCoreFactory.eINSTANCE.createSElementId();
			((SRelation)edge).setSElementId(sElementId);
			edge.setId(edgeId);
		}
		super.basicAddEdge(edge);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EList<SRelation> getSRelations() 
	{
		EList<SRelation> retVal= null;
		EList<Edge> edges= super.getEdges();
		
		if (edges!= null)
			retVal= new EcoreEList.UnmodifiableEList<SRelation>(this,
					SaltCorePackage.eINSTANCE.getSGraph_SRelations(),
					edges.size(), edges.toArray());
		else retVal= new EcoreEList.UnmodifiableEList<SRelation>(this,
				SaltCorePackage.eINSTANCE.getSGraph_SRelations(), 0, (Object[]) null);
		
		return(retVal);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addSRelation(SRelation sRelation) 
	{
		super.addEdge(sRelation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SRelation getSRelation(String sRelationId) 
	{
		SRelation retVal= null;
		Edge edge= super.getEdge(sRelationId);
		if (	(edge!= null) &&
				(!(edge instanceof SRelation)))
			throw new SaltCoreException("Cannot cast a node in SGraph into SNode-object: "+ sRelationId);
		retVal= (SRelation) edge;
		return(retVal);
	}

/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addSLayer(SLayer sLayer) 
	{
		if (sLayer== null)
			throw new SaltCoreException("Cannot add given SLayer-object, because it is null.");
		this.getSLayers().add(sLayer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SLayer getSLayer(String sLayerId) 
	{
		if (sLayerId== null)
			throw new SaltCoreException("Cannot search for SLayer-object, because given sLayer-id is null.");
		
		SLayer retVal= null;
		for (SLayer sLayer : this.getSLayers())
		{
			if (sLayer.getSId().equalsIgnoreCase(sLayerId))
			{
				retVal= sLayer;
			}
		}
		return(retVal);
	}
//=================== end: handling SRelation
	
	/**
	 * {@inheritDoc SGraph#getRoots()}
	 */
	@SuppressWarnings("unchecked")
	public EList<SNode> getSRoots() 
	{
		EList<Node> retVal= super.getRoots();
		if (retVal!= null)
			return((EList<SNode>)(EList<? extends Node>) retVal);
		else return(null);
	}

	/**
	 * {@inheritDoc SGraph#getLeafs()}
	 */
	@SuppressWarnings("unchecked")
	public EList<SNode> getSLeafs() {
		EList<Node> retVal= super.getLeafs();
		if (retVal!= null)
			return((EList<SNode>)(EList<? extends Node>) retVal);
		else return(null);
	}

	/**
	 * {@inheritDoc SGraph#traverse(EList, GRAPH_TRAVERSE_TYPE, String, SGraphTraverseHandler)}
	 */
	public void traverse(EList<? extends SNode> startSNodes, GRAPH_TRAVERSE_TYPE traverseType, String traverseId, SGraphTraverseHandler traverseHandler) 
	{
		this.traverse(startSNodes, traverseType, traverseId, traverseHandler, true);
	}
	
	/**
	 * {@inheritDoc SGraph#traverse(SNode, GRAPH_TRAVERSE_TYPE, String, SGraphTraverseHandler, boolean)}
	 */
	@SuppressWarnings("unchecked")
	public void traverse(EList<? extends  SNode> startSNodes, GRAPH_TRAVERSE_TYPE traverseType, String traverseId, SGraphTraverseHandler traverseHandler, boolean isCycleSafe) 
	{
		TraverseHandlerWrapper wrapper= new TraverseHandlerWrapper();
		wrapper.traverseHandler= traverseHandler;
		super.traverse(((EList<Node>)(EList<? extends Node>)startSNodes), traverseType, traverseId, wrapper);
	}

	class TraverseHandlerWrapper implements GraphTraverseHandler
	{
		SGraphTraverseHandler traverseHandler= null;
		@Override
		public void nodeReached(GRAPH_TRAVERSE_TYPE traversalType,
				String traversalId, Node currNode, Edge edge, Node fromNode,
				long order) 
		{
			traverseHandler.nodeReached(traversalType, traversalId, (SNode)currNode, (SRelation)edge, (SNode)fromNode, order);
		}

		@Override
		public void nodeLeft(GRAPH_TRAVERSE_TYPE traversalType,
				String traversalId, Node currNode, Edge edge, Node fromNode,
				long order) 
		{
			traverseHandler.nodeLeft(traversalType, traversalId, (SNode) currNode, (SRelation) edge, (SNode) fromNode, order);
		}

		@Override
		public boolean checkConstraint(GRAPH_TRAVERSE_TYPE traversalType,
				String traversalId, Edge edge, Node currNode, long order) 
		{
			return (traverseHandler.checkConstraint(traversalType, traversalId, (SRelation) edge, (SNode)currNode, order));
		}
		
	}
	
//=================== start: handling SIdentifiableElement	
	/**
	 * Delegatee for SIdentifiableElement
	 */
	private SIdentifiableElementAccessor sIdentAccessor= null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public String getSId() 
	{
		return(this.sIdentAccessor.getSId(this));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSId(String newSId) 
	{
		this.sIdentAccessor.setSId(this, newSId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public URI getSElementPath() 
	{
		return(this.sIdentAccessor.getSElementPath(this));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSElementPath(URI newSElementPath) 
	{
		this.sIdentAccessor.setSElementPath(this, newSElementPath);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SElementId getSElementId() {
		SElementId sElementId = basicGetSElementId();
		return sElementId != null && sElementId.eIsProxy() ? (SElementId)eResolveProxy((InternalEObject)sElementId) : sElementId;
	}
//=================== end: handling SIdentifiableElement	
//=================== start: handling SAnnotatableElement	
	/**
	 * Delegatee for SAnnotatableElement
	 */
	private SAnnotatableElementAccessor sAnnoAccessor= null;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EList<SAnnotation> getSAnnotations() 
	{
		return(this.sAnnoAccessor.getSAnnotations(this));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addSAnnotation(SAnnotation SAnnotation) 
	{
		this.sAnnoAccessor.addSAnnotation(this, SAnnotation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SAnnotation getSAnnotation(String fullName) 
	{
		return(this.sAnnoAccessor.getSAnnotation(this, fullName));
	}
/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SAnnotation createSAnnotation(String sNS, String sName, Object sValue, SDATATYPE sValueType) {
		return (this.sAnnoAccessor.createSAnnotation(this, sNS, sName, sValue, sValueType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SAnnotation createSAnnotation(String sNS, String sName, String sValueString) {
		return this.createSAnnotation(sNS, sName, sValueString, SDATATYPE.STEXT);
	}

	//=================== end: handling SAnnotatableElement
//=================== start: handling SMetaAnnotatableElement	
	/**
	 * Delegatee for SMetaAnnotatableElement
	 */
	private SMetaAnnotatableElementAccessor sMetaAnnoAccessor= null;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EList<SMetaAnnotation> getSMetaAnnotations() 
	{
		return(this.sMetaAnnoAccessor.getSMetaAnnotations(this));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addSMetaAnnotation(SMetaAnnotation SMetaAnnotation) 
	{
		this.sMetaAnnoAccessor.addSMetaAnnotation(this, SMetaAnnotation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SMetaAnnotation getSMetaAnnotation(String fullName) 
	{
		return(this.sMetaAnnoAccessor.getSMetaAnnotation(this, fullName));
	}
/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SMetaAnnotation createSMetaAnnotation(String sNS, String sName, Object sValue, SDATATYPE sValueType) {
		return (this.sMetaAnnoAccessor.createSMetaAnnotation(this, sNS, sName, sValue, sValueType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SMetaAnnotation createSMetaAnnotation(String sNS, String sName, String sValueString) {
		return this.createSMetaAnnotation(sNS, sName, sValueString, SDATATYPE.STEXT);
	}

	//=================== end: handling SMetaAnnotatableElement
//=================== start: handling SProcessingAnnotatableElement
	/**
	 * Delegatee for SProcessingAnnotatableElement
	 */
	private SProcessingAnnotatableElementAccessor sProcAnnoAccessor= null;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SElementId basicGetSElementId() 
	{
		return(sIdentAccessor.getSElementId(this));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSElementId(SElementId newSElementId) 
	{
		sIdentAccessor.setSElementId(this, newSElementId);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EList<SProcessingAnnotation> getSProcessingAnnotations() 
	{
		return(this.sProcAnnoAccessor.getSProcessingAnnotations(this));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addSProcessingAnnotation(SProcessingAnnotation sProcessingAnnotation) 
	{
		this.sProcAnnoAccessor.addSProcessingAnnotation(this, sProcessingAnnotation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SProcessingAnnotation getSProcessingAnnotation(String fullName) 
	{
		return(this.sProcAnnoAccessor.getSProcessingAnnotation(this, fullName));
	}
/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SProcessingAnnotation createSProcessingAnnotation(String sNS, String sName, Object sValue, SDATATYPE sValueType) {
		return (this.sProcAnnoAccessor.createSProcessingAnnotation(this, sNS, sName, sValue, sValueType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SProcessingAnnotation createSProcessingAnnotation(String sNS, String sName, String sValueString) {
		return this.createSProcessingAnnotation(sNS, sName, sValueString, SDATATYPE.STEXT);
	}

	//=================== end: handling SProcessingAnnotatableElement
//=================== start: handling SFeaturableElement
	/**
	 * Delegatee for SFeaturableElementAccessor
	 */
	private SFeaturableElementAccessor sFeatAccessor= null;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EList<SFeature> getSFeatures() 
	{
		return(this.sFeatAccessor.getSFeatures(this));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addSFeature(SFeature sFeature) 
	{
		this.sFeatAccessor.addSFeature(this, sFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SFeature getSFeature(String sFeatureId) 
	{
		return(this.sFeatAccessor.getSFeature(this, sFeatureId));
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SFeature getSFeature(String sNamespace, String sFeatureName) 
	{
		return(this.sFeatAccessor.getSFeature(this, sNamespace, sFeatureName));
	}

/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SFeature createSFeature(String sNS, String sName, Object sValue, SDATATYPE sValueType) {
		return (this.sFeatAccessor.createSFeature(this, sNS, sName, sValue, sValueType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SFeature createSFeature(String sNS, String sName, String sValueString) {
		return this.createSFeature(sNS, sName, sValueString, SDATATYPE.STEXT);
	}

	//=================== end: handling SFeaturableElement	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SaltCorePackage.SGRAPH__SANNOTATIONS:
				return ((InternalEList<?>)getSAnnotations()).basicRemove(otherEnd, msgs);
			case SaltCorePackage.SGRAPH__SPROCESSING_ANNOTATIONS:
				return ((InternalEList<?>)getSProcessingAnnotations()).basicRemove(otherEnd, msgs);
			case SaltCorePackage.SGRAPH__SFEATURES:
				return ((InternalEList<?>)getSFeatures()).basicRemove(otherEnd, msgs);
			case SaltCorePackage.SGRAPH__SMETA_ANNOTATIONS:
				return ((InternalEList<?>)getSMetaAnnotations()).basicRemove(otherEnd, msgs);
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
			case SaltCorePackage.SGRAPH__SNAME:
				return getSName();
			case SaltCorePackage.SGRAPH__SANNOTATIONS:
				return getSAnnotations();
			case SaltCorePackage.SGRAPH__SELEMENT_ID:
				if (resolve) return getSElementId();
				return basicGetSElementId();
			case SaltCorePackage.SGRAPH__SID:
				return getSId();
			case SaltCorePackage.SGRAPH__SELEMENT_PATH:
				return getSElementPath();
			case SaltCorePackage.SGRAPH__SPROCESSING_ANNOTATIONS:
				return getSProcessingAnnotations();
			case SaltCorePackage.SGRAPH__SFEATURES:
				return getSFeatures();
			case SaltCorePackage.SGRAPH__SMETA_ANNOTATIONS:
				return getSMetaAnnotations();
			case SaltCorePackage.SGRAPH__SRELATIONS:
				return getSRelations();
			case SaltCorePackage.SGRAPH__SNODES:
				return getSNodes();
			case SaltCorePackage.SGRAPH__SLAYERS:
				return getSLayers();
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
			case SaltCorePackage.SGRAPH__SNAME:
				setSName((String)newValue);
				return;
			case SaltCorePackage.SGRAPH__SANNOTATIONS:
				getSAnnotations().clear();
				getSAnnotations().addAll((Collection<? extends SAnnotation>)newValue);
				return;
			case SaltCorePackage.SGRAPH__SELEMENT_ID:
				setSElementId((SElementId)newValue);
				return;
			case SaltCorePackage.SGRAPH__SID:
				setSId((String)newValue);
				return;
			case SaltCorePackage.SGRAPH__SELEMENT_PATH:
				setSElementPath((URI)newValue);
				return;
			case SaltCorePackage.SGRAPH__SFEATURES:
				getSFeatures().clear();
				getSFeatures().addAll((Collection<? extends SFeature>)newValue);
				return;
			case SaltCorePackage.SGRAPH__SMETA_ANNOTATIONS:
				getSMetaAnnotations().clear();
				getSMetaAnnotations().addAll((Collection<? extends SMetaAnnotation>)newValue);
				return;
			case SaltCorePackage.SGRAPH__SLAYERS:
				getSLayers().clear();
				getSLayers().addAll((Collection<? extends SLayer>)newValue);
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
			case SaltCorePackage.SGRAPH__SNAME:
				setSName(SNAME_EDEFAULT);
				return;
			case SaltCorePackage.SGRAPH__SANNOTATIONS:
				getSAnnotations().clear();
				return;
			case SaltCorePackage.SGRAPH__SELEMENT_ID:
				setSElementId((SElementId)null);
				return;
			case SaltCorePackage.SGRAPH__SID:
				setSId(SID_EDEFAULT);
				return;
			case SaltCorePackage.SGRAPH__SELEMENT_PATH:
				setSElementPath(SELEMENT_PATH_EDEFAULT);
				return;
			case SaltCorePackage.SGRAPH__SFEATURES:
				getSFeatures().clear();
				return;
			case SaltCorePackage.SGRAPH__SMETA_ANNOTATIONS:
				getSMetaAnnotations().clear();
				return;
			case SaltCorePackage.SGRAPH__SLAYERS:
				getSLayers().clear();
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
			case SaltCorePackage.SGRAPH__SNAME:
				return SNAME_EDEFAULT == null ? sName != null : !SNAME_EDEFAULT.equals(sName);
			case SaltCorePackage.SGRAPH__SANNOTATIONS:
				return !getSAnnotations().isEmpty();
			case SaltCorePackage.SGRAPH__SELEMENT_ID:
				return basicGetSElementId() != null;
			case SaltCorePackage.SGRAPH__SID:
				return SID_EDEFAULT == null ? getSId() != null : !SID_EDEFAULT.equals(getSId());
			case SaltCorePackage.SGRAPH__SELEMENT_PATH:
				return SELEMENT_PATH_EDEFAULT == null ? getSElementPath() != null : !SELEMENT_PATH_EDEFAULT.equals(getSElementPath());
			case SaltCorePackage.SGRAPH__SPROCESSING_ANNOTATIONS:
				return !getSProcessingAnnotations().isEmpty();
			case SaltCorePackage.SGRAPH__SFEATURES:
				return !getSFeatures().isEmpty();
			case SaltCorePackage.SGRAPH__SMETA_ANNOTATIONS:
				return !getSMetaAnnotations().isEmpty();
			case SaltCorePackage.SGRAPH__SRELATIONS:
				return !getSRelations().isEmpty();
			case SaltCorePackage.SGRAPH__SNODES:
				return !getSNodes().isEmpty();
			case SaltCorePackage.SGRAPH__SLAYERS:
				return !getSLayers().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == SNamedElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SGRAPH__SNAME: return SaltCorePackage.SNAMED_ELEMENT__SNAME;
				default: return -1;
			}
		}
		if (baseClass == SAnnotatableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SGRAPH__SANNOTATIONS: return SaltCorePackage.SANNOTATABLE_ELEMENT__SANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == SIdentifiableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SGRAPH__SELEMENT_ID: return SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_ID;
				case SaltCorePackage.SGRAPH__SID: return SaltCorePackage.SIDENTIFIABLE_ELEMENT__SID;
				case SaltCorePackage.SGRAPH__SELEMENT_PATH: return SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_PATH;
				default: return -1;
			}
		}
		if (baseClass == SProcessingAnnotatableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SGRAPH__SPROCESSING_ANNOTATIONS: return SaltCorePackage.SPROCESSING_ANNOTATABLE_ELEMENT__SPROCESSING_ANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == SFeaturableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SGRAPH__SFEATURES: return SaltCorePackage.SFEATURABLE_ELEMENT__SFEATURES;
				default: return -1;
			}
		}
		if (baseClass == SMetaAnnotatableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SGRAPH__SMETA_ANNOTATIONS: return SaltCorePackage.SMETA_ANNOTATABLE_ELEMENT__SMETA_ANNOTATIONS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == SNamedElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SNAMED_ELEMENT__SNAME: return SaltCorePackage.SGRAPH__SNAME;
				default: return -1;
			}
		}
		if (baseClass == SAnnotatableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SANNOTATABLE_ELEMENT__SANNOTATIONS: return SaltCorePackage.SGRAPH__SANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == SIdentifiableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_ID: return SaltCorePackage.SGRAPH__SELEMENT_ID;
				case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SID: return SaltCorePackage.SGRAPH__SID;
				case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_PATH: return SaltCorePackage.SGRAPH__SELEMENT_PATH;
				default: return -1;
			}
		}
		if (baseClass == SProcessingAnnotatableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SPROCESSING_ANNOTATABLE_ELEMENT__SPROCESSING_ANNOTATIONS: return SaltCorePackage.SGRAPH__SPROCESSING_ANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == SFeaturableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SFEATURABLE_ELEMENT__SFEATURES: return SaltCorePackage.SGRAPH__SFEATURES;
				default: return -1;
			}
		}
		if (baseClass == SMetaAnnotatableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SMETA_ANNOTATABLE_ELEMENT__SMETA_ANNOTATIONS: return SaltCorePackage.SGRAPH__SMETA_ANNOTATIONS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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

} //SGraphImpl
