/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.saltCore.impl;

import de.util.graph.ComplexIndex;
import de.util.graph.Edge;
import de.util.graph.GraphFactory;
import de.util.graph.Node;
import de.util.graph.TRAVERSAL_MODE;
import de.util.graph.impl.GraphImpl;

import de.corpling.salt.model.saltCore.SCoreProject;
import de.corpling.salt.model.saltCore.SElement;
import de.corpling.salt.model.saltCore.SGraph;
import de.corpling.salt.model.saltCore.SRelation;
import de.corpling.salt.model.saltCore.SStereotype;
import de.corpling.salt.model.saltCore.STRAVERSAL_MODE;
import de.corpling.salt.model.saltCore.STraversalObject;
import de.corpling.salt.model.saltCore.SaltCorePackage;

import java.util.Collection;
import java.util.Stack;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SGraph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SGraphImpl#getSElements <em>SElements</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SGraphImpl#getSRelations <em>SRelations</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SGraphImpl#getSCoreProject <em>SCore Project</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SGraphImpl extends GraphImpl implements SGraph 
{
	private static final String MSG_ERR=	"Error("+SGraphImpl.class+"): ";

	private boolean isTesting= false;
	/**
	 * sets testing mode on true, means, that no consistency of stereotypes is checked.
	 */
	public void setTesting()
	{
		this.isTesting= true;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected SGraphImpl() {
		super();
		init();
	}
	
	/**
	 * Index for getting elements by stereotype
	 */
	protected static final String IDX_STEREOTYPE_ELEMENT= "IDX_STEREOTYPE_ELEMENT";
	/**
	 * Index for getting relations by stereotype
	 */
	protected static final String IDX_STEREOTYPE_RELATION= "IDX_STEREOTYPE_RELATION";
//	/**
//	 * Index for getting roots by relation stereotypes
//	 */
//	protected static final String IDX_ROOTS_REL_STEREOTYPE= "IDX_ROOTS_REL_STEREOTYPE";
//	/**
//	 * Index for getting src elements of stereotyped edge
//	 */
//	protected static final String IDX_SRC_ELEMENTS_OF_RELATION= "IDX_SRC_ELEMENTS_OF_RELATION";
//	/**
//	 * Index for getting src elements of stereotyped edge
//	 */
//	protected static final String IDX_DST_ELEMENTS_OF_RELATION= "IDX_DST_ELEMENTS_OF_RELATION";
	/**
	 * Initializes this object:
	 * creating indexes
	 */
	private void init()
	{
		ComplexIndex index= null;
		//initialize index for getting elements by stereotype
		index= GraphFactory.eINSTANCE.createComplexIndex();
		index.setId(IDX_STEREOTYPE_ELEMENT);
		super.addIndex(index);
		
		//initialize index for getting relations by stereotype
		index= GraphFactory.eINSTANCE.createComplexIndex();
		index.setId(IDX_STEREOTYPE_RELATION);
		super.addIndex(index);
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
	 */
	@SuppressWarnings("unchecked")
	public EList<SElement> getSElements() 
	{
		EList<SElement> sElements= (((EList<SElement>)(EList<? extends Node>)super.getNodes()));
		return(new EcoreEList.UnmodifiableEList(this, SaltCorePackage.eINSTANCE.getSGraph_SRelations(), sElements.size(), sElements.toArray()));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	public EList<SRelation> getSRelations() 
	{
		EList<SRelation> sRelations= (((EList<SRelation>)(EList<? extends Edge>)super.getEdges()));
		return(new EcoreEList.UnmodifiableEList(this, SaltCorePackage.eINSTANCE.getSGraph_SRelations(), sRelations.size(), sRelations.toArray()));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCoreProject getSCoreProject() {
		if (eContainerFeatureID != SaltCorePackage.SGRAPH__SCORE_PROJECT) return null;
		return (SCoreProject)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSCoreProject(SCoreProject newSCoreProject, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSCoreProject, SaltCorePackage.SGRAPH__SCORE_PROJECT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSCoreProject(SCoreProject newSCoreProject) {
		if (newSCoreProject != eInternalContainer() || (eContainerFeatureID != SaltCorePackage.SGRAPH__SCORE_PROJECT && newSCoreProject != null)) {
			if (EcoreUtil.isAncestor(this, newSCoreProject))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSCoreProject != null)
				msgs = ((InternalEObject)newSCoreProject).eInverseAdd(this, SaltCorePackage.SCORE_PROJECT__SGRAPHS, SCoreProject.class, msgs);
			msgs = basicSetSCoreProject(newSCoreProject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SGRAPH__SCORE_PROJECT, newSCoreProject, newSCoreProject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addSElement(SElement sElement) 
	{
		if (sElement== null)
			throw new NullPointerException(MSG_ERR+ "Cannot add an empty element.");
		if (sElement.getSStereotype()==  null)
			throw new NullPointerException(MSG_ERR+ "Cannot add an element without an stereotype: "+sElement);
		if ((sElement.getSStereotype().getName()==  null) || (sElement.getSStereotype().getName().equalsIgnoreCase("")))
			throw new NullPointerException(MSG_ERR+ "Error in stereotype of given element, because the stereotypes name is empty: "+sElement);
		
		//checking some constraints if testing is false
		if (!isTesting)
		{
			//checking if sProject is set 
			if (this.getSCoreProject()== null)
				throw new NullPointerException(MSG_ERR+ "Cannot add an element, because the SCoreProject is not set.");
			
			//checking if stereotype exists
			if (this.getSCoreProject().getSStereotypeByName(sElement.getSStereotype().getName())== null)
				throw new NullPointerException(MSG_ERR+ "Cannot add an element, because the stereotype of element is not registered in SProject: "+sElement.getSStereotype().getName());
		}
		
		
		//simple adding
		//adding if an element with same id doesn´exists
		if ((sElement.getId()!= null) && (this.getSElementById(sElement.getId())!= null))
				throw new NullPointerException(MSG_ERR + "Cannot add the given element, because one with same id already exists in graph: "+ sElement.getId());
		super.addNode(sElement);
		
		//adding into indexes
		
		//adding into stereotype index
		super.getIndex(IDX_STEREOTYPE_ELEMENT).addElement(sElement.getSStereotype().getName(), sElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SElement getSElementById(Object sElementId) 
	{
		return((SElement)super.getNode(sElementId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	public EList<SElement> getSElementsByStereotype(SStereotype stereotype) 
	{
		EList<SElement> sElements= (EList<SElement>)(EList<? extends Object>)((ComplexIndex)super.getIndex(IDX_STEREOTYPE_ELEMENT)).getSlot(stereotype.getName());
		if (sElements== null)
			return(null);
		else 
			return(new EcoreEList.UnmodifiableEList(this, SaltCorePackage.eINSTANCE.getSGraph_SElements(), sElements.size(), sElements.toArray()));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addSRelation(SRelation sRelation) 
	{
		if (sRelation.getSStereotype()==  null)
			throw new NullPointerException(MSG_ERR+ "Cannot add an Relation without an stereotype: "+sRelation);
		if ((sRelation.getSStereotype().getName()==  null) || (sRelation.getSStereotype().getName().equalsIgnoreCase("")))
			throw new NullPointerException(MSG_ERR+ "Error in stereotype of given Relation, because the stereotypes name is empty: "+sRelation);
		
		//checking some constraints if testing is false
		if (!isTesting)
		{
			//checking if sProject is set 
			if (this.getSCoreProject()== null)
				throw new NullPointerException(MSG_ERR+ "Cannot add an element, because the SCoreProject is not set.");
			
			//checking if stereotype exists
			if (this.getSCoreProject().getSStereotypeByName(sRelation.getSStereotype().getName())== null)
				throw new NullPointerException(MSG_ERR+ "Cannot add an element, because the stereotype of element is not registered in SProject.");
		}
		
		//simple adding
		super.addEdge(sRelation);
		
		//adding into index
		
		//adding into stereotype index
		super.getIndex(IDX_STEREOTYPE_RELATION).addElement(sRelation.getSStereotype().getName(), sRelation);
//		adding into root by rel stereotype index
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SRelation getSRelationById(Object sRelationId) 
	{
		return((SRelation)super.getEdge(sRelationId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	public EList<SRelation> getSRelationsByStereotype(SStereotype sStereotype) 
	{
		EList<SRelation> retList= null;
		EList<SRelation> sRelations= (EList<SRelation>)(EList<? extends Object>)((ComplexIndex)super.getIndex(IDX_STEREOTYPE_RELATION)).getSlot(sStereotype.getName());
		if (sRelations!= null)
			retList= new EcoreEList.UnmodifiableEList(this, SaltCorePackage.eINSTANCE.getSGraph_SElements(), sRelations.size(), sRelations.toArray());
		return(retList);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	public EList<SElement> getSRoots() 
	{
		return((EList<SElement>) (EList<? extends Node>)super.getRoots());
	}

	/**
	 * Returns all elements which refer to other elements over a relation which has given
	 * stereotype. 
	 * algorithm:<br/>
	 * - run threw all relations of given stereotype
	 * - store all destination elements in a list
	 * - if source element is in list it is not a root
	 */
	public EList<SElement> getSRootsBySStereotypeRelation(SStereotype sStereotype) 
	{
		if (sStereotype== null)
			throw new NullPointerException(MSG_ERR + "Cannot search roots for empty stereotypes.");
		
		EList<SElement> retList= null;
		EList<SRelation> relations= this.getSRelationsByStereotype(sStereotype);
		if (relations!= null)
		{
			retList= new BasicEList<SElement>();
			EList<SElement> notRootElements= new BasicEList<SElement>();
			for (SRelation relation: relations)
			{
				//mark destination as no root
				if (!notRootElements.contains(relation.getSDestinationElement()))
					notRootElements.add(relation.getSDestinationElement());
				//if source is not also a destination
				if (	(!notRootElements.contains(relation.getSSourceElement())) &&
						(!retList.contains(relation.getSSourceElement())))
					retList.add(relation.getSSourceElement());
				//remove wrong stored nodes in retList
				if (retList.contains(relation.getSDestinationElement()))
					retList.remove(relation.getSDestinationElement());
			}
		}
		return(retList);
	}

// --------------------------------------------- start: travering graph
	
	/**
	 * stereotype which is currently used for travaersing
	 */
	private SStereotype currStereotype= null;
	
	/**
	 * 
	 * MODE who shows which kind of traversing is currently made
	 *
	 */
	enum INTERNAL_STRAVERSAL_MODE {ALL, STEREOTYPE};
	/**
	 * current internal kind of traversasion
	 */
	private INTERNAL_STRAVERSAL_MODE internalStraversalMode= INTERNAL_STRAVERSAL_MODE.ALL;
	
	/**
	 * stack which stores current traversal object (for call back) at top
	 */
	private Stack<STraversalObject> sTraversalStack= null;
	
	/**
	 * Starts traversing graph beginning by start element. While Traversing the algorithm 
	 * only uses relations of given stereotype. If no stereotype is given, it uses
	 * all relations.
	 */
	@SuppressWarnings("unchecked")
	public void traverseSGraph(STRAVERSAL_MODE sTraversalMode, EList<SElement> startSElements, STraversalObject sTraversalObject, SStereotype sStereotype) 
	{
		if (sTraversalObject== null)
			throw new NullPointerException("Cannot start traversing graph, because the given traversal object is empty.");
		if ((startSElements== null) || (startSElements.isEmpty()))
			throw new NullPointerException("Cannot start traversing graph, because the list of elements to start from is empty.");
		
		//compute traversal mode for de.util.graph.Graph
		TRAVERSAL_MODE traversalMode= null;
		if (sTraversalMode== STRAVERSAL_MODE.DEPTH_FIRST) traversalMode= TRAVERSAL_MODE.DEPTH_FIRST;
		else if (sTraversalMode== STRAVERSAL_MODE.BOTTOM_UP) traversalMode= TRAVERSAL_MODE.BOTTOM_UP;
		
		if (sStereotype!= null)
		{	
			this.internalStraversalMode= INTERNAL_STRAVERSAL_MODE.STEREOTYPE;
			//init stack of traversal objects
			if (this.currStereotype== null)
				this.sTraversalStack= new Stack<STraversalObject>();
			this.sTraversalStack.push(sTraversalObject);
			this.currStereotype= sStereotype;
			super.traverseGraph(traversalMode, ((EList<Node>)(EList<? extends Node>)startSElements), this);
			this.sTraversalStack.pop();
		}
		else 
		{
			//init stack of traversal objects
			if (this.currStereotype== null)
				this.sTraversalStack= new Stack<STraversalObject>();
			this.currStereotype= sStereotype;
			this.internalStraversalMode= INTERNAL_STRAVERSAL_MODE.ALL;
			this.sTraversalStack.push(sTraversalObject);
			super.traverseGraph(traversalMode, ((EList<Node>)(EList<? extends Node>)startSElements), this);
			this.sTraversalStack.pop();
		}
	}

	/**
	 * Starts traversing graph beginning by start elements. While Traversing the algorithm 
	 * only uses relations of given stereotype. If no stereotype is given, it uses
	 * all relations.
	 */
	public void traverseSGraph(STRAVERSAL_MODE sTraversalMode, SElement startSElement, STraversalObject sTraversalObject, SStereotype sStereotype) 
	{
		EList<SElement> startSElements= new BasicEList<SElement>();
		startSElements.add(startSElement);
		this.traverseSGraph(sTraversalMode, startSElements, sTraversalObject, sStereotype);
	}

	public boolean checkConstraint(TRAVERSAL_MODE traversalMode, Edge edge,
			Node currNode, long order) 
	{
		boolean retVal= false;
		
		SElement currSElement= (SElement) currNode;
		SRelation sRelation= (SRelation) edge;
		
		//compute traversal mode for STraversalObject
		STRAVERSAL_MODE sTraversalMode= null;
		if (traversalMode== TRAVERSAL_MODE.DEPTH_FIRST) sTraversalMode= STRAVERSAL_MODE.DEPTH_FIRST;
		else if (traversalMode== TRAVERSAL_MODE.BOTTOM_UP) sTraversalMode= STRAVERSAL_MODE.BOTTOM_UP;
		
		if (this.internalStraversalMode== INTERNAL_STRAVERSAL_MODE.ALL)
		{
			retVal= this.sTraversalStack.peek().checkConstraint(sTraversalMode, sRelation, currSElement, order);
		}
		else if (this.internalStraversalMode== INTERNAL_STRAVERSAL_MODE.STEREOTYPE)
		{
			//if stereotype is same as stored current stereotype return true, false else
			if (sRelation== null)
			{	
				retVal= true;
			}
			else if (sRelation.getSStereotype().getName().equalsIgnoreCase(this.currStereotype.getName()))
			{
				retVal= true;
			}
			else 
			{
				retVal= false;
			}
			
			if (retVal)
				retVal= this.sTraversalStack.peek().checkConstraint(sTraversalMode, sRelation, currSElement, order);
		}
		return(retVal);		
	}
	
	public void nodeLeft(TRAVERSAL_MODE traversalMode, Node currNode,
			Edge edge, Node fromNode, long order) 
	{
		SElement currSElement= (SElement) currNode;
		SRelation sRelation= (SRelation) edge;
		SElement fromSElement= (SElement) fromNode;
		
		//compute traversal mode for STraversalObject
		STRAVERSAL_MODE sTraversalMode= null;
		if (traversalMode== TRAVERSAL_MODE.DEPTH_FIRST) sTraversalMode= STRAVERSAL_MODE.DEPTH_FIRST;
		else if (traversalMode== TRAVERSAL_MODE.BOTTOM_UP) sTraversalMode= STRAVERSAL_MODE.BOTTOM_UP;
		
		this.sTraversalStack.peek().sElementLeft(sTraversalMode, currSElement, sRelation, fromSElement, order);
	}

	public void nodeReached(TRAVERSAL_MODE traversalMode, Node currNode,
			Edge edge, Node fromNode, long order) 
	{
		SElement currSElement= (SElement) currNode;
		SRelation sRelation= (SRelation) edge;
		SElement fromSElement= (SElement) fromNode;
		
		//compute traversal mode for STraversalObject
		STRAVERSAL_MODE sTraversalMode= null;
		if (traversalMode== TRAVERSAL_MODE.DEPTH_FIRST) sTraversalMode= STRAVERSAL_MODE.DEPTH_FIRST;
		else if (traversalMode== TRAVERSAL_MODE.BOTTOM_UP) sTraversalMode= STRAVERSAL_MODE.BOTTOM_UP;
		
		this.sTraversalStack.peek().sElementReached(sTraversalMode, currSElement, sRelation, fromSElement, order);
	}
// --------------------------------------------- end: travering graph
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SaltCorePackage.SGRAPH__SCORE_PROJECT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSCoreProject((SCoreProject)otherEnd, msgs);
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
			case SaltCorePackage.SGRAPH__SELEMENTS:
				return ((InternalEList<?>)getSElements()).basicRemove(otherEnd, msgs);
			case SaltCorePackage.SGRAPH__SRELATIONS:
				return ((InternalEList<?>)getSRelations()).basicRemove(otherEnd, msgs);
			case SaltCorePackage.SGRAPH__SCORE_PROJECT:
				return basicSetSCoreProject(null, msgs);
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
		switch (eContainerFeatureID) {
			case SaltCorePackage.SGRAPH__SCORE_PROJECT:
				return eInternalContainer().eInverseRemove(this, SaltCorePackage.SCORE_PROJECT__SGRAPHS, SCoreProject.class, msgs);
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
			case SaltCorePackage.SGRAPH__SELEMENTS:
				return getSElements();
			case SaltCorePackage.SGRAPH__SRELATIONS:
				return getSRelations();
			case SaltCorePackage.SGRAPH__SCORE_PROJECT:
				return getSCoreProject();
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
			case SaltCorePackage.SGRAPH__SELEMENTS:
				getSElements().clear();
				getSElements().addAll((Collection<? extends SElement>)newValue);
				return;
			case SaltCorePackage.SGRAPH__SCORE_PROJECT:
				setSCoreProject((SCoreProject)newValue);
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
			case SaltCorePackage.SGRAPH__SELEMENTS:
				getSElements().clear();
				return;
			case SaltCorePackage.SGRAPH__SCORE_PROJECT:
				setSCoreProject((SCoreProject)null);
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
			case SaltCorePackage.SGRAPH__SELEMENTS:
				return !getSElements().isEmpty();
			case SaltCorePackage.SGRAPH__SRELATIONS:
				return !getSRelations().isEmpty();
			case SaltCorePackage.SGRAPH__SCORE_PROJECT:
				return getSCoreProject() != null;
		}
		return super.eIsSet(featureID);
	}
} //SGraphImpl
