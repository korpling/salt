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
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.InternalEList;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.EdgeImpl;
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
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCoreFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.accessors.SAnnotatableElementAccessor;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.accessors.SFeaturableElementAccessor;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.accessors.SIdentifiableElementAccessor;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.accessors.SMetaAnnotatableElementAccessor;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.accessors.SProcessingAnnotatableElementAccessor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SRelation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SRelationImpl#getSAnnotations <em>SAnnotations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SRelationImpl#getSFeatures <em>SFeatures</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SRelationImpl#getSName <em>SName</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SRelationImpl#getSElementId <em>SElement Id</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SRelationImpl#getSId <em>SId</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SRelationImpl#getSElementPath <em>SElement Path</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SRelationImpl#getSProcessingAnnotations <em>SProcessing Annotations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SRelationImpl#getSMetaAnnotations <em>SMeta Annotations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SRelationImpl#getSSource <em>SSource</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SRelationImpl#getSTarget <em>STarget</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SRelationImpl#getSGraph <em>SGraph</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SRelationImpl#getSTypes <em>STypes</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SRelationImpl#getSLayers <em>SLayers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SRelationImpl extends EdgeImpl implements SRelation {
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
	protected SRelationImpl() {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltCorePackage.Literals.SRELATION;
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
	 * Adds this object to the list of to be notified objects for all possible notifiers. 
	 */
	@Override
	public boolean eNotificationRequired() {
		return true;
	}
	
	/**
	 * Delegates the notification to others
	 * {@inheritDoc SNamedElementImpl#eNotify(SNamedElement, Notification)}
	 */
	@Override
	public void eNotify(Notification notification) 
	{
		SNamedElementImpl.eNotify(this, notification);
		super.eNotify(notification);
	}
	//=================== start: handling SIdentifiableElement	
	/**
	 * Delegatee for SIdentifiableElement
	 */
	private SIdentifiableElementAccessor sIdentAccessor= null;
	
	/**
	 * Delegates setting of id to {@link SIdentifiableElementAccessor#setSElementId(SIdentifiableElement, SElementId)}
	 */
	@Override
	public void setId(String newSId) 
	{
		this.sIdentAccessor.setSId(this, newSId);
	}
	
	/**
	 * Delegates getting of id to {@link SIdentifiableElementAccessor#getSId(SIdentifiableElement)}
	 */
	@Override
	public String getSId() 
	{
		return(this.sIdentAccessor.getSId(this));
	}

	
	/**
	 * Delegates setting of id to {@link SIdentifiableElementAccessor#setSElementId(SIdentifiableElement, SElementId)}
	 */
	@Override
	public void setSId(String newSId) 
	{
		this.sIdentAccessor.setSId(this, newSId);
	}

	/**
	 * Delegates getting of id to {@link SIdentifiableElementAccessor#getSElementPath(SIdentifiableElement)}
	 */
	@Override
	public URI getSElementPath() 
	{
		return(this.sIdentAccessor.getSElementPath(this));
	}

	/**
	 * Delegates setting of id to {@link SIdentifiableElementAccessor#setSElementPath(SIdentifiableElement, URI)}
	 */
	@Override
	public void setSElementPath(URI newSElementPath) 
	{
		this.sIdentAccessor.setSElementPath(this, newSElementPath);
	}
	
	/**
	 * Delegates getting of id to {@link SIdentifiableElementAccessor#getSElementId(SIdentifiableElement)}
	 */
	public SElementId basicGetSElementId() 
	{
		return(sIdentAccessor.getSElementId(this));
	}

	/**
	 * Delegates setting of id to {@link SIdentifiableElementAccessor#setSElementId(SIdentifiableElement, SElementId)}
	 */
	public void setSElementId(SElementId newSElementId) 
	{
		sIdentAccessor.setSElementId(this, newSElementId);
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
	public SAnnotation getSAnnotation(String qName) 
	{
		return(this.sAnnoAccessor.getSAnnotation(this, qName));
	}
/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SAnnotation createSAnnotation(String sNS, String sName, Object sValue, SDATATYPE sValueType) {
		return this.sAnnoAccessor.createSAnnotation(this, sNS, sName, sValue, sValueType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SAnnotation createSAnnotation(String sNS, String sName, String sValueString) {
		return this.createSAnnotation(sNS, sName, sValueString, SDATATYPE.STEXT);
	}

	/**
	 * {@inheritDoc SAnnotatableElement#createSAnnotations(String)}
	 */
	@Override
	public EList<SAnnotation> createSAnnotations(String annotationString) {
		return(sAnnoAccessor.createSAnnotations(this, annotationString));
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
		return (this.sMetaAnnoAccessor.createSMetaAnnotation(this, sNS, sName, sValueString, SDATATYPE.STEXT));
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SNode getSSource() {
		SNode sSource = basicGetSSource();
		return sSource != null && sSource.eIsProxy() ? (SNode)eResolveProxy((InternalEObject)sSource) : sSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SNode basicGetSSource() 
	{
		SNode retVal= null;
		Node node= super.getSource();
		if (node instanceof SNode)
			retVal= (SNode) node;
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSSource(SNode newSSource) 
	{
		super.setSource(newSSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SNode getSTarget() {
		SNode sTarget = basicGetSTarget();
		return sTarget != null && sTarget.eIsProxy() ? (SNode)eResolveProxy((InternalEObject)sTarget) : sTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SNode basicGetSTarget() 
	{
		SNode retVal= null;
		Node node= super.getTarget();
		if (node instanceof SNode)
			retVal= (SNode) node;
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSTarget(SNode newSTarget) 
	{
		super.setTarget(newSTarget);
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

	
//---------------------------- start sTypes	
//	public static String KW_STYPE= "STYPE";
	public static String KW_STYPE_SEP= "::";
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EList<String> getSTypes() 
	{
		EList<String> retVal= null;
		SFeature sFeature= this.getSFeature(SaltCorePackage.eNS_PREFIX, SaltCoreFactory.SALT_CORE_SFEATURES.STYPE.toString());
		if (sFeature!= null)
		{
			String parts[]=sFeature.getSValue().toString().split(KW_STYPE_SEP); 
			retVal = new BasicEList<String>();
			for (String part: parts)
				retVal.add(part);
				
		}
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
	 * Adds a type for the relation. If no tapes are still set, it will create a new list for
	 * types also.
	 * @param sType the relation type to add
	 */
	public void addSType(String sType) 
	{
		if (	(sType!= null) &&
				(!sType.equals("")))
		{	
			SFeature sFeature= this.getSFeature(SaltCorePackage.eNS_PREFIX, SaltCoreFactory.SALT_CORE_SFEATURES.STYPE.toString());
			if (sFeature== null)
			{
				sFeature= SaltCoreFactory.eINSTANCE.createSFeature();
				sFeature.setSNS(SaltCorePackage.eNS_PREFIX);
				sFeature.setSName(SaltCoreFactory.SALT_CORE_SFEATURES.STYPE.toString());
				this.addSFeature(sFeature);
			}
			if (sFeature.getSValue()== null)
			{	
				sFeature.setSValue(sType);
			}
			else 
				sFeature.setSValue(sFeature.getSValue() + KW_STYPE_SEP + sType);
		}
	}
//---------------------------- end sTypes
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SaltCorePackage.SRELATION__SANNOTATIONS:
				return ((InternalEList<?>)getSAnnotations()).basicRemove(otherEnd, msgs);
			case SaltCorePackage.SRELATION__SFEATURES:
				return ((InternalEList<?>)getSFeatures()).basicRemove(otherEnd, msgs);
			case SaltCorePackage.SRELATION__SPROCESSING_ANNOTATIONS:
				return ((InternalEList<?>)getSProcessingAnnotations()).basicRemove(otherEnd, msgs);
			case SaltCorePackage.SRELATION__SMETA_ANNOTATIONS:
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
			case SaltCorePackage.SRELATION__SANNOTATIONS:
				return getSAnnotations();
			case SaltCorePackage.SRELATION__SFEATURES:
				return getSFeatures();
			case SaltCorePackage.SRELATION__SNAME:
				return getSName();
			case SaltCorePackage.SRELATION__SELEMENT_ID:
				if (resolve) return getSElementId();
				return basicGetSElementId();
			case SaltCorePackage.SRELATION__SID:
				return getSId();
			case SaltCorePackage.SRELATION__SELEMENT_PATH:
				return getSElementPath();
			case SaltCorePackage.SRELATION__SPROCESSING_ANNOTATIONS:
				return getSProcessingAnnotations();
			case SaltCorePackage.SRELATION__SMETA_ANNOTATIONS:
				return getSMetaAnnotations();
			case SaltCorePackage.SRELATION__SSOURCE:
				if (resolve) return getSSource();
				return basicGetSSource();
			case SaltCorePackage.SRELATION__STARGET:
				if (resolve) return getSTarget();
				return basicGetSTarget();
			case SaltCorePackage.SRELATION__SGRAPH:
				if (resolve) return getSGraph();
				return basicGetSGraph();
			case SaltCorePackage.SRELATION__STYPES:
				return getSTypes();
			case SaltCorePackage.SRELATION__SLAYERS:
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
			case SaltCorePackage.SRELATION__SANNOTATIONS:
				getSAnnotations().clear();
				getSAnnotations().addAll((Collection<? extends SAnnotation>)newValue);
				return;
			case SaltCorePackage.SRELATION__SFEATURES:
				getSFeatures().clear();
				getSFeatures().addAll((Collection<? extends SFeature>)newValue);
				return;
			case SaltCorePackage.SRELATION__SNAME:
				setSName((String)newValue);
				return;
			case SaltCorePackage.SRELATION__SELEMENT_ID:
				setSElementId((SElementId)newValue);
				return;
			case SaltCorePackage.SRELATION__SID:
				setSId((String)newValue);
				return;
			case SaltCorePackage.SRELATION__SELEMENT_PATH:
				setSElementPath((URI)newValue);
				return;
			case SaltCorePackage.SRELATION__SMETA_ANNOTATIONS:
				getSMetaAnnotations().clear();
				getSMetaAnnotations().addAll((Collection<? extends SMetaAnnotation>)newValue);
				return;
			case SaltCorePackage.SRELATION__SSOURCE:
				setSSource((SNode)newValue);
				return;
			case SaltCorePackage.SRELATION__STARGET:
				setSTarget((SNode)newValue);
				return;
			case SaltCorePackage.SRELATION__SGRAPH:
				setSGraph((SGraph)newValue);
				return;
			case SaltCorePackage.SRELATION__SLAYERS:
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
			case SaltCorePackage.SRELATION__SANNOTATIONS:
				getSAnnotations().clear();
				return;
			case SaltCorePackage.SRELATION__SFEATURES:
				getSFeatures().clear();
				return;
			case SaltCorePackage.SRELATION__SNAME:
				setSName(SNAME_EDEFAULT);
				return;
			case SaltCorePackage.SRELATION__SELEMENT_ID:
				setSElementId((SElementId)null);
				return;
			case SaltCorePackage.SRELATION__SID:
				setSId(SID_EDEFAULT);
				return;
			case SaltCorePackage.SRELATION__SELEMENT_PATH:
				setSElementPath(SELEMENT_PATH_EDEFAULT);
				return;
			case SaltCorePackage.SRELATION__SMETA_ANNOTATIONS:
				getSMetaAnnotations().clear();
				return;
			case SaltCorePackage.SRELATION__SSOURCE:
				setSSource((SNode)null);
				return;
			case SaltCorePackage.SRELATION__STARGET:
				setSTarget((SNode)null);
				return;
			case SaltCorePackage.SRELATION__SGRAPH:
				setSGraph((SGraph)null);
				return;
			case SaltCorePackage.SRELATION__SLAYERS:
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
			case SaltCorePackage.SRELATION__SANNOTATIONS:
				return !getSAnnotations().isEmpty();
			case SaltCorePackage.SRELATION__SFEATURES:
				return !getSFeatures().isEmpty();
			case SaltCorePackage.SRELATION__SNAME:
				return SNAME_EDEFAULT == null ? getSName() != null : !SNAME_EDEFAULT.equals(getSName());
			case SaltCorePackage.SRELATION__SELEMENT_ID:
				return basicGetSElementId() != null;
			case SaltCorePackage.SRELATION__SID:
				return SID_EDEFAULT == null ? getSId() != null : !SID_EDEFAULT.equals(getSId());
			case SaltCorePackage.SRELATION__SELEMENT_PATH:
				return SELEMENT_PATH_EDEFAULT == null ? getSElementPath() != null : !SELEMENT_PATH_EDEFAULT.equals(getSElementPath());
			case SaltCorePackage.SRELATION__SPROCESSING_ANNOTATIONS:
				return !getSProcessingAnnotations().isEmpty();
			case SaltCorePackage.SRELATION__SMETA_ANNOTATIONS:
				return !getSMetaAnnotations().isEmpty();
			case SaltCorePackage.SRELATION__SSOURCE:
				return basicGetSSource() != null;
			case SaltCorePackage.SRELATION__STARGET:
				return basicGetSTarget() != null;
			case SaltCorePackage.SRELATION__SGRAPH:
				return basicGetSGraph() != null;
			case SaltCorePackage.SRELATION__STYPES:
				return !getSTypes().isEmpty();
			case SaltCorePackage.SRELATION__SLAYERS:
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
				case SaltCorePackage.SRELATION__SANNOTATIONS: return SaltCorePackage.SANNOTATABLE_ELEMENT__SANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == SFeaturableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SRELATION__SFEATURES: return SaltCorePackage.SFEATURABLE_ELEMENT__SFEATURES;
				default: return -1;
			}
		}
		if (baseClass == SNamedElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SRELATION__SNAME: return SaltCorePackage.SNAMED_ELEMENT__SNAME;
				default: return -1;
			}
		}
		if (baseClass == SIdentifiableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SRELATION__SELEMENT_ID: return SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_ID;
				case SaltCorePackage.SRELATION__SID: return SaltCorePackage.SIDENTIFIABLE_ELEMENT__SID;
				case SaltCorePackage.SRELATION__SELEMENT_PATH: return SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_PATH;
				default: return -1;
			}
		}
		if (baseClass == SProcessingAnnotatableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SRELATION__SPROCESSING_ANNOTATIONS: return SaltCorePackage.SPROCESSING_ANNOTATABLE_ELEMENT__SPROCESSING_ANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == SMetaAnnotatableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SRELATION__SMETA_ANNOTATIONS: return SaltCorePackage.SMETA_ANNOTATABLE_ELEMENT__SMETA_ANNOTATIONS;
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
				case SaltCorePackage.SANNOTATABLE_ELEMENT__SANNOTATIONS: return SaltCorePackage.SRELATION__SANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == SFeaturableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SFEATURABLE_ELEMENT__SFEATURES: return SaltCorePackage.SRELATION__SFEATURES;
				default: return -1;
			}
		}
		if (baseClass == SNamedElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SNAMED_ELEMENT__SNAME: return SaltCorePackage.SRELATION__SNAME;
				default: return -1;
			}
		}
		if (baseClass == SIdentifiableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_ID: return SaltCorePackage.SRELATION__SELEMENT_ID;
				case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SID: return SaltCorePackage.SRELATION__SID;
				case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_PATH: return SaltCorePackage.SRELATION__SELEMENT_PATH;
				default: return -1;
			}
		}
		if (baseClass == SProcessingAnnotatableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SPROCESSING_ANNOTATABLE_ELEMENT__SPROCESSING_ANNOTATIONS: return SaltCorePackage.SRELATION__SPROCESSING_ANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == SMetaAnnotatableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SMETA_ANNOTATABLE_ELEMENT__SMETA_ANNOTATIONS: return SaltCorePackage.SRELATION__SMETA_ANNOTATIONS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //SRelationImpl
