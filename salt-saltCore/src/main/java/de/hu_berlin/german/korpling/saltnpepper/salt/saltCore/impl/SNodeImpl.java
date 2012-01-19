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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.InternalEList;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.NodeImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNamedElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCoreFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.accessors.SAnnotatableElementAccessor;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.accessors.SFeaturableElementAccessor;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.accessors.SIdentifiableElementAccessor;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.accessors.SMetaAnnotatableElementAccessor;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.accessors.SProcessingAnnotatableElementAccessor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SNode</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SNodeImpl#getSAnnotations <em>SAnnotations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SNodeImpl#getSFeatures <em>SFeatures</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SNodeImpl#getSName <em>SName</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SNodeImpl#getSElementId <em>SElement Id</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SNodeImpl#getSId <em>SId</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SNodeImpl#getSElementPath <em>SElement Path</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SNodeImpl#getSProcessingAnnotations <em>SProcessing Annotations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SNodeImpl#getSMetaAnnotations <em>SMeta Annotations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SNodeImpl#getSGraph <em>SGraph</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SNodeImpl#getSLayers <em>SLayers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SNodeImpl extends NodeImpl implements SNode {
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
	protected SNodeImpl() {
		super();
		init();
	}
	
	private void init()
	{
		this.sAnnoAccessor= new SAnnotatableElementAccessor();
		this.sMetaAnnoAccessor= new SMetaAnnotatableElementAccessor();
		this.sProcAnnoAccessor= new SProcessingAnnotatableElementAccessor();
		this.sIdentAccessor= new SIdentifiableElementAccessor();
		this.sFeatAccessor= new SFeaturableElementAccessor();
	}

	/**
	 * Adds this object to the list of to be notified objects for all possible notifiers. 
	 */
	@Override
	public boolean eNotificationRequired() {
		return true;
	}
	
	/**
	 * {@inheritDoc SNamedElementImpl#eNotify(SNamedElement, Notification)}
	 */
	@Override
	public void eNotify(Notification notification) 
	{
		SNamedElementImpl.eNotify(this, notification);
		super.eNotify(notification);
	}
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltCorePackage.Literals.SNODE;
	}

	/**
	 * {@inheritDoc SNamedElement#getSName()}
	 */
	public String getSName() {
		return(SNamedElementImpl.getSName(this));
	}

	/**
	 * {@inheritDoc SNamedElement#setSName(String)}
	 */
	public void setSName(String newSName) 
	{
		SNamedElementImpl.setSName(this, newSName);
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SGraph getSGraph() {
		SGraph sGraph = basicGetSGraph();
		return sGraph != null && sGraph.eIsProxy() ? (SGraph)eResolveProxy((InternalEObject)sGraph) : sGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SGraph basicGetSGraph() 
	{
		SGraph sGraph= null;
		Graph graph= super.getGraph();
		if (graph instanceof SGraph)
			sGraph = (SGraph) graph;
		return(sGraph);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSGraph(SGraph newSGraph) 
	{
		super.setGraph(newSGraph);
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

	//=================== start: handling SIdentifiableElement	
	/**
	 * Delegatee for SIdentifiableElement
	 */
	private SIdentifiableElementAccessor sIdentAccessor= null;
	
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
	public SAnnotation getSAnnotation(String qName) 
	{
		return(this.sAnnoAccessor.getSAnnotation(this, qName));
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
	public SMetaAnnotation getSMetaAnnotation(String qName) 
	{
		return(this.sMetaAnnoAccessor.getSMetaAnnotation(this, qName));
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
	public SProcessingAnnotation getSProcessingAnnotation(String qName) 
	{
		return(this.sProcAnnoAccessor.getSProcessingAnnotation(this, qName));
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
	 * {@inheritDoc}
	 */
	@Override
	public Object clone() 
	{
		return(this.clone(SaltCoreFactory.eINSTANCE.createSNode()));
	}

	/**
	 * This method returns the given object. It adds all properties of this to the given object.
	 * @param clone the clone to which all properties of this shall be copied to
	 * @return the extended given object
	 */
	public Object clone(SNode clone)
	{
		super.clone(clone);
		return(clone);
	}
	
	/**
	 * Checks if a given SNode has the same entries as this SNode-object. 
	 * @return if all values are equals.
	 */
	@Override
	public boolean equals(Object obj)
	{
		return(super.equals(obj));
		//TODO outcommented on 26th of June 2010
//		if (!(obj instanceof SNode))
//			return(false);
//		SNode sNode2= (SNode) obj;
//		{//check ids
//			if (this.getSId()!= null)
//			{	
//				if (sNode2.getSId()== null)
//					return(false);
//				if (!this.getSId().equalsIgnoreCase(sNode2.getSId()))
//					return(false);
//			}
//		}
//		{//check SProcessingAnnotations
//			for(SProcessingAnnotation sProcAnno1: this.getSProcessingAnnotations())
//			{
//				boolean hasOpponend= false;
//				for(SProcessingAnnotation sProcAnno2: sNode2.getSProcessingAnnotations())
//				{
//					if (sProcAnno1. equals(sProcAnno2))
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
//				for(SAnnotation sAnno2: sNode2.getSAnnotations())
//				{
//					if (sAnno1. equals(sAnno2))
//						hasOpponend= true;
//				}
//				if (!hasOpponend)
//					return(false);
//			}	
//		}
//		return(true);
	}
	
//	public boolean equals(SNode sNode2)
//	{
//		{//check SProcessingAnnotations
//			for(SProcessingAnnotation sProcAnno1: this.getSProcessingAnnotations())
//			{
//				boolean hasOpponend= false;
//				for(SProcessingAnnotation sProcAnno2: sNode2.getSProcessingAnnotations())
//				{
//					if (sProcAnno1. equals(sProcAnno2))
//						hasOpponend= true;
//				}
//				if (!hasOpponend)
//					return(false);
//			}	
//		}
//		return(true);
//	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SaltCorePackage.SNODE__SANNOTATIONS:
				return ((InternalEList<?>)getSAnnotations()).basicRemove(otherEnd, msgs);
			case SaltCorePackage.SNODE__SFEATURES:
				return ((InternalEList<?>)getSFeatures()).basicRemove(otherEnd, msgs);
			case SaltCorePackage.SNODE__SPROCESSING_ANNOTATIONS:
				return ((InternalEList<?>)getSProcessingAnnotations()).basicRemove(otherEnd, msgs);
			case SaltCorePackage.SNODE__SMETA_ANNOTATIONS:
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
			case SaltCorePackage.SNODE__SANNOTATIONS:
				return getSAnnotations();
			case SaltCorePackage.SNODE__SFEATURES:
				return getSFeatures();
			case SaltCorePackage.SNODE__SNAME:
				return getSName();
			case SaltCorePackage.SNODE__SELEMENT_ID:
				if (resolve) return getSElementId();
				return basicGetSElementId();
			case SaltCorePackage.SNODE__SID:
				return getSId();
			case SaltCorePackage.SNODE__SELEMENT_PATH:
				return getSElementPath();
			case SaltCorePackage.SNODE__SPROCESSING_ANNOTATIONS:
				return getSProcessingAnnotations();
			case SaltCorePackage.SNODE__SMETA_ANNOTATIONS:
				return getSMetaAnnotations();
			case SaltCorePackage.SNODE__SGRAPH:
				if (resolve) return getSGraph();
				return basicGetSGraph();
			case SaltCorePackage.SNODE__SLAYERS:
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
			case SaltCorePackage.SNODE__SANNOTATIONS:
				getSAnnotations().clear();
				getSAnnotations().addAll((Collection<? extends SAnnotation>)newValue);
				return;
			case SaltCorePackage.SNODE__SFEATURES:
				getSFeatures().clear();
				getSFeatures().addAll((Collection<? extends SFeature>)newValue);
				return;
			case SaltCorePackage.SNODE__SNAME:
				setSName((String)newValue);
				return;
			case SaltCorePackage.SNODE__SELEMENT_ID:
				setSElementId((SElementId)newValue);
				return;
			case SaltCorePackage.SNODE__SID:
				setSId((String)newValue);
				return;
			case SaltCorePackage.SNODE__SELEMENT_PATH:
				setSElementPath((URI)newValue);
				return;
			case SaltCorePackage.SNODE__SMETA_ANNOTATIONS:
				getSMetaAnnotations().clear();
				getSMetaAnnotations().addAll((Collection<? extends SMetaAnnotation>)newValue);
				return;
			case SaltCorePackage.SNODE__SGRAPH:
				setSGraph((SGraph)newValue);
				return;
			case SaltCorePackage.SNODE__SLAYERS:
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
			case SaltCorePackage.SNODE__SANNOTATIONS:
				getSAnnotations().clear();
				return;
			case SaltCorePackage.SNODE__SFEATURES:
				getSFeatures().clear();
				return;
			case SaltCorePackage.SNODE__SNAME:
				setSName(SNAME_EDEFAULT);
				return;
			case SaltCorePackage.SNODE__SELEMENT_ID:
				setSElementId((SElementId)null);
				return;
			case SaltCorePackage.SNODE__SID:
				setSId(SID_EDEFAULT);
				return;
			case SaltCorePackage.SNODE__SELEMENT_PATH:
				setSElementPath(SELEMENT_PATH_EDEFAULT);
				return;
			case SaltCorePackage.SNODE__SMETA_ANNOTATIONS:
				getSMetaAnnotations().clear();
				return;
			case SaltCorePackage.SNODE__SGRAPH:
				setSGraph((SGraph)null);
				return;
			case SaltCorePackage.SNODE__SLAYERS:
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
			case SaltCorePackage.SNODE__SANNOTATIONS:
				return !getSAnnotations().isEmpty();
			case SaltCorePackage.SNODE__SFEATURES:
				return !getSFeatures().isEmpty();
			case SaltCorePackage.SNODE__SNAME:
				return SNAME_EDEFAULT == null ? getSName() != null : !SNAME_EDEFAULT.equals(getSName());
			case SaltCorePackage.SNODE__SELEMENT_ID:
				return basicGetSElementId() != null;
			case SaltCorePackage.SNODE__SID:
				return SID_EDEFAULT == null ? getSId() != null : !SID_EDEFAULT.equals(getSId());
			case SaltCorePackage.SNODE__SELEMENT_PATH:
				return SELEMENT_PATH_EDEFAULT == null ? getSElementPath() != null : !SELEMENT_PATH_EDEFAULT.equals(getSElementPath());
			case SaltCorePackage.SNODE__SPROCESSING_ANNOTATIONS:
				return !getSProcessingAnnotations().isEmpty();
			case SaltCorePackage.SNODE__SMETA_ANNOTATIONS:
				return !getSMetaAnnotations().isEmpty();
			case SaltCorePackage.SNODE__SGRAPH:
				return basicGetSGraph() != null;
			case SaltCorePackage.SNODE__SLAYERS:
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
		if (baseClass == SAnnotatableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SNODE__SANNOTATIONS: return SaltCorePackage.SANNOTATABLE_ELEMENT__SANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == SFeaturableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SNODE__SFEATURES: return SaltCorePackage.SFEATURABLE_ELEMENT__SFEATURES;
				default: return -1;
			}
		}
		if (baseClass == SNamedElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SNODE__SNAME: return SaltCorePackage.SNAMED_ELEMENT__SNAME;
				default: return -1;
			}
		}
		if (baseClass == SIdentifiableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SNODE__SELEMENT_ID: return SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_ID;
				case SaltCorePackage.SNODE__SID: return SaltCorePackage.SIDENTIFIABLE_ELEMENT__SID;
				case SaltCorePackage.SNODE__SELEMENT_PATH: return SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_PATH;
				default: return -1;
			}
		}
		if (baseClass == SProcessingAnnotatableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SNODE__SPROCESSING_ANNOTATIONS: return SaltCorePackage.SPROCESSING_ANNOTATABLE_ELEMENT__SPROCESSING_ANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == SMetaAnnotatableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SNODE__SMETA_ANNOTATIONS: return SaltCorePackage.SMETA_ANNOTATABLE_ELEMENT__SMETA_ANNOTATIONS;
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
		if (baseClass == SAnnotatableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SANNOTATABLE_ELEMENT__SANNOTATIONS: return SaltCorePackage.SNODE__SANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == SFeaturableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SFEATURABLE_ELEMENT__SFEATURES: return SaltCorePackage.SNODE__SFEATURES;
				default: return -1;
			}
		}
		if (baseClass == SNamedElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SNAMED_ELEMENT__SNAME: return SaltCorePackage.SNODE__SNAME;
				default: return -1;
			}
		}
		if (baseClass == SIdentifiableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_ID: return SaltCorePackage.SNODE__SELEMENT_ID;
				case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SID: return SaltCorePackage.SNODE__SID;
				case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_PATH: return SaltCorePackage.SNODE__SELEMENT_PATH;
				default: return -1;
			}
		}
		if (baseClass == SProcessingAnnotatableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SPROCESSING_ANNOTATABLE_ELEMENT__SPROCESSING_ANNOTATIONS: return SaltCorePackage.SNODE__SPROCESSING_ANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == SMetaAnnotatableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SMETA_ANNOTATABLE_ELEMENT__SMETA_ANNOTATIONS: return SaltCorePackage.SNODE__SMETA_ANNOTATIONS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //SNodeImpl
