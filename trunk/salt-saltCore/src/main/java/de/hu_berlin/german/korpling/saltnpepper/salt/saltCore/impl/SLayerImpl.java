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
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.InternalEList;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.LayerImpl;
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
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.accessors.SAnnotatableElementAccessor;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.accessors.SFeaturableElementAccessor;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.accessors.SIdentifiableElementAccessor;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.accessors.SMetaAnnotatableElementAccessor;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.accessors.SProcessingAnnotatableElementAccessor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SLayer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SLayerImpl#getSName <em>SName</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SLayerImpl#getSElementId <em>SElement Id</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SLayerImpl#getSId <em>SId</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SLayerImpl#getSElementPath <em>SElement Path</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SLayerImpl#getSProcessingAnnotations <em>SProcessing Annotations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SLayerImpl#getSAnnotations <em>SAnnotations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SLayerImpl#getSMetaAnnotations <em>SMeta Annotations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SLayerImpl#getSFeatures <em>SFeatures</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SLayerImpl#getSRelations <em>SRelations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SLayerImpl#getSNodes <em>SNodes</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SLayerImpl#getSGraph <em>SGraph</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SLayerImpl#getSSubLayers <em>SSub Layers</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SLayerImpl#getSSuperLayer <em>SSuper Layer</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SLayerImpl extends LayerImpl implements SLayer {
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
	protected SLayerImpl() {
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
		return SaltCorePackage.Literals.SLAYER;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SLAYER__SNAME, oldSName, sName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	public EList<SRelation> getSRelations() 
	{
		return((EList<SRelation>) (EList<? extends Object>) super.getEdges());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	public EList<SNode> getSNodes() 
	{
		return((EList<SNode>) (EList<? extends Object>) super.getNodes());
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
	public SGraph basicGetSGraph() {
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
	public EList<SLayer> getSSubLayers() 
	{
		return((EList<SLayer>) (EList<? extends Object>) super.getSubLayers());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SLayer getSSuperLayer() {
		SLayer sSuperLayer = basicGetSSuperLayer();
		return sSuperLayer != null && sSuperLayer.eIsProxy() ? (SLayer)eResolveProxy((InternalEObject)sSuperLayer) : sSuperLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SLayer basicGetSSuperLayer() 
	{
		return((SLayer)super.getSuperLayer());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSSuperLayer(SLayer newSSuperLayer) 
	{
		super.setSuperLayer(newSSuperLayer);
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
	 * @generated
	 */
	public SProcessingAnnotation createSProcessingAnnotation(String sNS, String sName, String sValueString) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			case SaltCorePackage.SLAYER__SPROCESSING_ANNOTATIONS:
				return ((InternalEList<?>)getSProcessingAnnotations()).basicRemove(otherEnd, msgs);
			case SaltCorePackage.SLAYER__SANNOTATIONS:
				return ((InternalEList<?>)getSAnnotations()).basicRemove(otherEnd, msgs);
			case SaltCorePackage.SLAYER__SMETA_ANNOTATIONS:
				return ((InternalEList<?>)getSMetaAnnotations()).basicRemove(otherEnd, msgs);
			case SaltCorePackage.SLAYER__SFEATURES:
				return ((InternalEList<?>)getSFeatures()).basicRemove(otherEnd, msgs);
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
			case SaltCorePackage.SLAYER__SNAME:
				return getSName();
			case SaltCorePackage.SLAYER__SELEMENT_ID:
				if (resolve) return getSElementId();
				return basicGetSElementId();
			case SaltCorePackage.SLAYER__SID:
				return getSId();
			case SaltCorePackage.SLAYER__SELEMENT_PATH:
				return getSElementPath();
			case SaltCorePackage.SLAYER__SPROCESSING_ANNOTATIONS:
				return getSProcessingAnnotations();
			case SaltCorePackage.SLAYER__SANNOTATIONS:
				return getSAnnotations();
			case SaltCorePackage.SLAYER__SMETA_ANNOTATIONS:
				return getSMetaAnnotations();
			case SaltCorePackage.SLAYER__SFEATURES:
				return getSFeatures();
			case SaltCorePackage.SLAYER__SRELATIONS:
				return getSRelations();
			case SaltCorePackage.SLAYER__SNODES:
				return getSNodes();
			case SaltCorePackage.SLAYER__SGRAPH:
				if (resolve) return getSGraph();
				return basicGetSGraph();
			case SaltCorePackage.SLAYER__SSUB_LAYERS:
				return getSSubLayers();
			case SaltCorePackage.SLAYER__SSUPER_LAYER:
				if (resolve) return getSSuperLayer();
				return basicGetSSuperLayer();
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
			case SaltCorePackage.SLAYER__SNAME:
				setSName((String)newValue);
				return;
			case SaltCorePackage.SLAYER__SELEMENT_ID:
				setSElementId((SElementId)newValue);
				return;
			case SaltCorePackage.SLAYER__SID:
				setSId((String)newValue);
				return;
			case SaltCorePackage.SLAYER__SELEMENT_PATH:
				setSElementPath((URI)newValue);
				return;
			case SaltCorePackage.SLAYER__SANNOTATIONS:
				getSAnnotations().clear();
				getSAnnotations().addAll((Collection<? extends SAnnotation>)newValue);
				return;
			case SaltCorePackage.SLAYER__SMETA_ANNOTATIONS:
				getSMetaAnnotations().clear();
				getSMetaAnnotations().addAll((Collection<? extends SMetaAnnotation>)newValue);
				return;
			case SaltCorePackage.SLAYER__SFEATURES:
				getSFeatures().clear();
				getSFeatures().addAll((Collection<? extends SFeature>)newValue);
				return;
			case SaltCorePackage.SLAYER__SRELATIONS:
				getSRelations().clear();
				getSRelations().addAll((Collection<? extends SRelation>)newValue);
				return;
			case SaltCorePackage.SLAYER__SNODES:
				getSNodes().clear();
				getSNodes().addAll((Collection<? extends SNode>)newValue);
				return;
			case SaltCorePackage.SLAYER__SGRAPH:
				setSGraph((SGraph)newValue);
				return;
			case SaltCorePackage.SLAYER__SSUB_LAYERS:
				getSSubLayers().clear();
				getSSubLayers().addAll((Collection<? extends SLayer>)newValue);
				return;
			case SaltCorePackage.SLAYER__SSUPER_LAYER:
				setSSuperLayer((SLayer)newValue);
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
			case SaltCorePackage.SLAYER__SNAME:
				setSName(SNAME_EDEFAULT);
				return;
			case SaltCorePackage.SLAYER__SELEMENT_ID:
				setSElementId((SElementId)null);
				return;
			case SaltCorePackage.SLAYER__SID:
				setSId(SID_EDEFAULT);
				return;
			case SaltCorePackage.SLAYER__SELEMENT_PATH:
				setSElementPath(SELEMENT_PATH_EDEFAULT);
				return;
			case SaltCorePackage.SLAYER__SANNOTATIONS:
				getSAnnotations().clear();
				return;
			case SaltCorePackage.SLAYER__SMETA_ANNOTATIONS:
				getSMetaAnnotations().clear();
				return;
			case SaltCorePackage.SLAYER__SFEATURES:
				getSFeatures().clear();
				return;
			case SaltCorePackage.SLAYER__SRELATIONS:
				getSRelations().clear();
				return;
			case SaltCorePackage.SLAYER__SNODES:
				getSNodes().clear();
				return;
			case SaltCorePackage.SLAYER__SGRAPH:
				setSGraph((SGraph)null);
				return;
			case SaltCorePackage.SLAYER__SSUB_LAYERS:
				getSSubLayers().clear();
				return;
			case SaltCorePackage.SLAYER__SSUPER_LAYER:
				setSSuperLayer((SLayer)null);
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
			case SaltCorePackage.SLAYER__SNAME:
				return SNAME_EDEFAULT == null ? sName != null : !SNAME_EDEFAULT.equals(sName);
			case SaltCorePackage.SLAYER__SELEMENT_ID:
				return basicGetSElementId() != null;
			case SaltCorePackage.SLAYER__SID:
				return SID_EDEFAULT == null ? getSId() != null : !SID_EDEFAULT.equals(getSId());
			case SaltCorePackage.SLAYER__SELEMENT_PATH:
				return SELEMENT_PATH_EDEFAULT == null ? getSElementPath() != null : !SELEMENT_PATH_EDEFAULT.equals(getSElementPath());
			case SaltCorePackage.SLAYER__SPROCESSING_ANNOTATIONS:
				return !getSProcessingAnnotations().isEmpty();
			case SaltCorePackage.SLAYER__SANNOTATIONS:
				return !getSAnnotations().isEmpty();
			case SaltCorePackage.SLAYER__SMETA_ANNOTATIONS:
				return !getSMetaAnnotations().isEmpty();
			case SaltCorePackage.SLAYER__SFEATURES:
				return !getSFeatures().isEmpty();
			case SaltCorePackage.SLAYER__SRELATIONS:
				return !getSRelations().isEmpty();
			case SaltCorePackage.SLAYER__SNODES:
				return !getSNodes().isEmpty();
			case SaltCorePackage.SLAYER__SGRAPH:
				return basicGetSGraph() != null;
			case SaltCorePackage.SLAYER__SSUB_LAYERS:
				return !getSSubLayers().isEmpty();
			case SaltCorePackage.SLAYER__SSUPER_LAYER:
				return basicGetSSuperLayer() != null;
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
				case SaltCorePackage.SLAYER__SNAME: return SaltCorePackage.SNAMED_ELEMENT__SNAME;
				default: return -1;
			}
		}
		if (baseClass == SIdentifiableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SLAYER__SELEMENT_ID: return SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_ID;
				case SaltCorePackage.SLAYER__SID: return SaltCorePackage.SIDENTIFIABLE_ELEMENT__SID;
				case SaltCorePackage.SLAYER__SELEMENT_PATH: return SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_PATH;
				default: return -1;
			}
		}
		if (baseClass == SProcessingAnnotatableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SLAYER__SPROCESSING_ANNOTATIONS: return SaltCorePackage.SPROCESSING_ANNOTATABLE_ELEMENT__SPROCESSING_ANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == SAnnotatableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SLAYER__SANNOTATIONS: return SaltCorePackage.SANNOTATABLE_ELEMENT__SANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == SMetaAnnotatableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SLAYER__SMETA_ANNOTATIONS: return SaltCorePackage.SMETA_ANNOTATABLE_ELEMENT__SMETA_ANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == SFeaturableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SLAYER__SFEATURES: return SaltCorePackage.SFEATURABLE_ELEMENT__SFEATURES;
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
				case SaltCorePackage.SNAMED_ELEMENT__SNAME: return SaltCorePackage.SLAYER__SNAME;
				default: return -1;
			}
		}
		if (baseClass == SIdentifiableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_ID: return SaltCorePackage.SLAYER__SELEMENT_ID;
				case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SID: return SaltCorePackage.SLAYER__SID;
				case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_PATH: return SaltCorePackage.SLAYER__SELEMENT_PATH;
				default: return -1;
			}
		}
		if (baseClass == SProcessingAnnotatableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SPROCESSING_ANNOTATABLE_ELEMENT__SPROCESSING_ANNOTATIONS: return SaltCorePackage.SLAYER__SPROCESSING_ANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == SAnnotatableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SANNOTATABLE_ELEMENT__SANNOTATIONS: return SaltCorePackage.SLAYER__SANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == SMetaAnnotatableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SMETA_ANNOTATABLE_ELEMENT__SMETA_ANNOTATIONS: return SaltCorePackage.SLAYER__SMETA_ANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == SFeaturableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SFEATURABLE_ELEMENT__SFEATURES: return SaltCorePackage.SLAYER__SFEATURES;
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

} //SLayerImpl
