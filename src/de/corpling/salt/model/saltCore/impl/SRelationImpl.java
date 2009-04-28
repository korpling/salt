/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.saltCore.impl;

import de.corpling.salt.model.saltCore.SaltCoreFactory;
import de.corpling.salt.model.saltCore.SaltCorePackage;
import de.corpling.salt.model.saltCore.SAnnotatableElement;
import de.corpling.salt.model.saltCore.SAnnotation;
import de.corpling.salt.model.saltCore.SElement;
import de.corpling.salt.model.saltCore.SFeature;
import de.corpling.salt.model.saltCore.SGraph;
import de.corpling.salt.model.saltCore.SIdentifiableElement;
import de.corpling.salt.model.saltCore.SNamedElement;
import de.corpling.salt.model.saltCore.SProcessingAnnotatableElement;
import de.corpling.salt.model.saltCore.SProcessingAnnotation;
import de.corpling.salt.model.saltCore.SRelation;
import de.corpling.salt.model.saltCore.SStereotype;
import de.corpling.salt.model.saltCore.SStereotypeableElement;

import de.util.graph.impl.EdgeImpl;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SRelation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SRelationImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SRelationImpl#getSAnnotations <em>SAnnotations</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SRelationImpl#getSStereotype <em>SStereotype</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SRelationImpl#getSFeatures <em>SFeatures</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SRelationImpl#getSProcessingAnnotations <em>SProcessing Annotations</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SRelationImpl#getSSourceElement <em>SSource Element</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SRelationImpl#getSDestinationElement <em>SDestination Element</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SRelationImpl#getSStereotypableElement <em>SStereotypable Element</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SRelationImpl#getSAnnotatableElement <em>SAnnotatable Element</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SRelationImpl#getSProcessingAnnotatableElement <em>SProcessing Annotatable Element</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SRelationImpl#getSGraph <em>SGraph</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SRelationImpl#getSType <em>SType</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SRelationImpl extends EdgeImpl implements SRelation 
{
	private static final String MSG_ERR=	"Error("+SRelationImpl.class+"): ";
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSStereotype() <em>SStereotype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSStereotype()
	 * @generated
	 * @ordered
	 */
	protected SStereotype sStereotype;

	/**
	 * The cached value of the '{@link #getSStereotypableElement() <em>SStereotypable Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSStereotypableElement()
	 * @generated
	 * @ordered
	 */
	protected SStereotypeableElement sStereotypableElement;

	/**
	 * The cached value of the '{@link #getSAnnotatableElement() <em>SAnnotatable Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSAnnotatableElement()
	 * @generated
	 * @ordered
	 */
	protected SAnnotatableElement sAnnotatableElement;
	/**
	 * The cached value of the '{@link #getSProcessingAnnotatableElement() <em>SProcessing Annotatable Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSProcessingAnnotatableElement()
	 * @generated
	 * @ordered
	 */
	protected SProcessingAnnotatableElement sProcessingAnnotatableElement;

	/**
	 * The default value of the '{@link #getSType() <em>SType</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSType()
	 * @generated
	 * @ordered
	 */
	protected static final String STYPE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getSType() <em>SType</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSType()
	 * @generated
	 * @ordered
	 */
	protected String sType = STYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected SRelationImpl() 
	{
		super();
		this.init();
	}
	
	/**
	 * initializes this object.
	 * sets all properties:
	 * 	sannotatableElement
	 *  sProcessingAnnotatableElement
	 *  sStereotypableElement
	 */
	private void init()
	{
		this.sAnnotatableElement= SaltCoreFactory.eINSTANCE.createSAnnotatableElement();
		this.sProcessingAnnotatableElement= SaltCoreFactory.eINSTANCE.createSProcessingAnnotatableElement();
		this.sStereotypableElement= SaltCoreFactory.eINSTANCE.createSStereotypeableElement();
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SRELATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EList<SAnnotation> getSAnnotations() 
	{
		return(this.sAnnotatableElement.getSAnnotations());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SStereotype getSStereotype() {
		if (sStereotype != null && sStereotype.eIsProxy()) {
			InternalEObject oldSStereotype = (InternalEObject)sStereotype;
			sStereotype = (SStereotype)eResolveProxy(oldSStereotype);
			if (sStereotype != oldSStereotype) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SaltCorePackage.SRELATION__SSTEREOTYPE, oldSStereotype, sStereotype));
			}
		}
		return sStereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SStereotype basicGetSStereotype() {
		return sStereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSStereotype(SStereotype newSStereotype) {
		SStereotype oldSStereotype = sStereotype;
		sStereotype = newSStereotype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SRELATION__SSTEREOTYPE, oldSStereotype, sStereotype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EList<SFeature> getSFeatures() 
	{
		return(this.sStereotypableElement.getSFeatures());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EList<SProcessingAnnotation> getSProcessingAnnotations() 
	{
		return(this.sProcessingAnnotatableElement.getSProcessingAnnotations());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SElement getSSourceElement() {
		SElement sSourceElement = basicGetSSourceElement();
		return sSourceElement != null && sSourceElement.eIsProxy() ? (SElement)eResolveProxy((InternalEObject)sSourceElement) : sSourceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SElement basicGetSSourceElement() 
	{
		return((SElement)super.getSource());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSSourceElement(SElement newSSourceElement) 
	{
		if (newSSourceElement== null)
			throw new NullPointerException(MSG_ERR + "Cannot set an empty element as source.");
		super.setSource(newSSourceElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SElement getSDestinationElement() {
		SElement sDestinationElement = basicGetSDestinationElement();
		return sDestinationElement != null && sDestinationElement.eIsProxy() ? (SElement)eResolveProxy((InternalEObject)sDestinationElement) : sDestinationElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SElement basicGetSDestinationElement() 
	{
		return((SElement)super.getDestination());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSDestinationElement(SElement newSDestinationElement) 
	{
		if (newSDestinationElement== null)
			throw new NullPointerException(MSG_ERR + "Cannot set an empty element as destination.");
		super.setDestination(newSDestinationElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SStereotypeableElement getSStereotypableElement() {
		return sStereotypableElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSStereotypableElement(SStereotypeableElement newSStereotypableElement, NotificationChain msgs) {
		SStereotypeableElement oldSStereotypableElement = sStereotypableElement;
		sStereotypableElement = newSStereotypableElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SaltCorePackage.SRELATION__SSTEREOTYPABLE_ELEMENT, oldSStereotypableElement, newSStereotypableElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSStereotypableElement(SStereotypeableElement newSStereotypableElement) {
		if (newSStereotypableElement != sStereotypableElement) {
			NotificationChain msgs = null;
			if (sStereotypableElement != null)
				msgs = ((InternalEObject)sStereotypableElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SaltCorePackage.SRELATION__SSTEREOTYPABLE_ELEMENT, null, msgs);
			if (newSStereotypableElement != null)
				msgs = ((InternalEObject)newSStereotypableElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SaltCorePackage.SRELATION__SSTEREOTYPABLE_ELEMENT, null, msgs);
			msgs = basicSetSStereotypableElement(newSStereotypableElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SRELATION__SSTEREOTYPABLE_ELEMENT, newSStereotypableElement, newSStereotypableElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SAnnotatableElement getSAnnotatableElement() {
		return sAnnotatableElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSAnnotatableElement(SAnnotatableElement newSAnnotatableElement, NotificationChain msgs) {
		SAnnotatableElement oldSAnnotatableElement = sAnnotatableElement;
		sAnnotatableElement = newSAnnotatableElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SaltCorePackage.SRELATION__SANNOTATABLE_ELEMENT, oldSAnnotatableElement, newSAnnotatableElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSAnnotatableElement(SAnnotatableElement newSAnnotatableElement) {
		if (newSAnnotatableElement != sAnnotatableElement) {
			NotificationChain msgs = null;
			if (sAnnotatableElement != null)
				msgs = ((InternalEObject)sAnnotatableElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SaltCorePackage.SRELATION__SANNOTATABLE_ELEMENT, null, msgs);
			if (newSAnnotatableElement != null)
				msgs = ((InternalEObject)newSAnnotatableElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SaltCorePackage.SRELATION__SANNOTATABLE_ELEMENT, null, msgs);
			msgs = basicSetSAnnotatableElement(newSAnnotatableElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SRELATION__SANNOTATABLE_ELEMENT, newSAnnotatableElement, newSAnnotatableElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SProcessingAnnotatableElement getSProcessingAnnotatableElement() {
		return sProcessingAnnotatableElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSProcessingAnnotatableElement(SProcessingAnnotatableElement newSProcessingAnnotatableElement, NotificationChain msgs) {
		SProcessingAnnotatableElement oldSProcessingAnnotatableElement = sProcessingAnnotatableElement;
		sProcessingAnnotatableElement = newSProcessingAnnotatableElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SaltCorePackage.SRELATION__SPROCESSING_ANNOTATABLE_ELEMENT, oldSProcessingAnnotatableElement, newSProcessingAnnotatableElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSProcessingAnnotatableElement(SProcessingAnnotatableElement newSProcessingAnnotatableElement) {
		if (newSProcessingAnnotatableElement != sProcessingAnnotatableElement) {
			NotificationChain msgs = null;
			if (sProcessingAnnotatableElement != null)
				msgs = ((InternalEObject)sProcessingAnnotatableElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SaltCorePackage.SRELATION__SPROCESSING_ANNOTATABLE_ELEMENT, null, msgs);
			if (newSProcessingAnnotatableElement != null)
				msgs = ((InternalEObject)newSProcessingAnnotatableElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SaltCorePackage.SRELATION__SPROCESSING_ANNOTATABLE_ELEMENT, null, msgs);
			msgs = basicSetSProcessingAnnotatableElement(newSProcessingAnnotatableElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SRELATION__SPROCESSING_ANNOTATABLE_ELEMENT, newSProcessingAnnotatableElement, newSProcessingAnnotatableElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SGraph getSGraph() 
	{
		return((SGraph) super.getGraph());
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
	 * @generated
	 */
	public String getSType() {
		return sType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSType(String newSType) {
		String oldSType = sType;
		sType = newSType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SRELATION__STYPE, oldSType, sType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addSProcessingAnnotation(SProcessingAnnotation sProcessingAnnotation) 
	{
		this.sProcessingAnnotatableElement.addSProcessingAnnotation(sProcessingAnnotation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SProcessingAnnotation getSProcessingAnnotation(String fullName) 
	{
		return(this.sProcessingAnnotatableElement.getSProcessingAnnotation(fullName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addSFeature(String featureName, Object featureValue) 
	{
		this.sStereotypableElement.addSFeature(featureName, featureValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SFeature getSFeature(String featureName) 
	{
		return(this.sStereotypableElement.getSFeature(featureName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public boolean removeSFeature(String featureName) 
	{
		return(this.sStereotypableElement.removeSFeature(featureName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addSFeature(SFeature feature) 
	{
		this.sStereotypableElement.addSFeature(feature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addSAnnotation(SAnnotation sAnnotation) 
	{
		this.sAnnotatableElement.addSAnnotation(sAnnotation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SAnnotation getSAnnotation(String fullName) 
	{
		return(this.sAnnotatableElement.getSAnnotation(fullName));
	}

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
			case SaltCorePackage.SRELATION__SSTEREOTYPABLE_ELEMENT:
				return basicSetSStereotypableElement(null, msgs);
			case SaltCorePackage.SRELATION__SANNOTATABLE_ELEMENT:
				return basicSetSAnnotatableElement(null, msgs);
			case SaltCorePackage.SRELATION__SPROCESSING_ANNOTATABLE_ELEMENT:
				return basicSetSProcessingAnnotatableElement(null, msgs);
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
			case SaltCorePackage.SRELATION__SGRAPH:
				return eInternalContainer().eInverseRemove(this, SaltCorePackage.SGRAPH__SRELATIONS, SGraph.class, msgs);
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
			case SaltCorePackage.SRELATION__NAME:
				return getName();
			case SaltCorePackage.SRELATION__SANNOTATIONS:
				return getSAnnotations();
			case SaltCorePackage.SRELATION__SSTEREOTYPE:
				if (resolve) return getSStereotype();
				return basicGetSStereotype();
			case SaltCorePackage.SRELATION__SFEATURES:
				return getSFeatures();
			case SaltCorePackage.SRELATION__SPROCESSING_ANNOTATIONS:
				return getSProcessingAnnotations();
			case SaltCorePackage.SRELATION__SSOURCE_ELEMENT:
				if (resolve) return getSSourceElement();
				return basicGetSSourceElement();
			case SaltCorePackage.SRELATION__SDESTINATION_ELEMENT:
				if (resolve) return getSDestinationElement();
				return basicGetSDestinationElement();
			case SaltCorePackage.SRELATION__SSTEREOTYPABLE_ELEMENT:
				return getSStereotypableElement();
			case SaltCorePackage.SRELATION__SANNOTATABLE_ELEMENT:
				return getSAnnotatableElement();
			case SaltCorePackage.SRELATION__SPROCESSING_ANNOTATABLE_ELEMENT:
				return getSProcessingAnnotatableElement();
			case SaltCorePackage.SRELATION__SGRAPH:
				return getSGraph();
			case SaltCorePackage.SRELATION__STYPE:
				return getSType();
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
			case SaltCorePackage.SRELATION__NAME:
				setName((String)newValue);
				return;
			case SaltCorePackage.SRELATION__SANNOTATIONS:
				getSAnnotations().clear();
				getSAnnotations().addAll((Collection<? extends SAnnotation>)newValue);
				return;
			case SaltCorePackage.SRELATION__SSTEREOTYPE:
				setSStereotype((SStereotype)newValue);
				return;
			case SaltCorePackage.SRELATION__SFEATURES:
				getSFeatures().clear();
				getSFeatures().addAll((Collection<? extends SFeature>)newValue);
				return;
			case SaltCorePackage.SRELATION__SPROCESSING_ANNOTATIONS:
				getSProcessingAnnotations().clear();
				getSProcessingAnnotations().addAll((Collection<? extends SProcessingAnnotation>)newValue);
				return;
			case SaltCorePackage.SRELATION__SSOURCE_ELEMENT:
				setSSourceElement((SElement)newValue);
				return;
			case SaltCorePackage.SRELATION__SDESTINATION_ELEMENT:
				setSDestinationElement((SElement)newValue);
				return;
			case SaltCorePackage.SRELATION__SSTEREOTYPABLE_ELEMENT:
				setSStereotypableElement((SStereotypeableElement)newValue);
				return;
			case SaltCorePackage.SRELATION__SANNOTATABLE_ELEMENT:
				setSAnnotatableElement((SAnnotatableElement)newValue);
				return;
			case SaltCorePackage.SRELATION__SPROCESSING_ANNOTATABLE_ELEMENT:
				setSProcessingAnnotatableElement((SProcessingAnnotatableElement)newValue);
				return;
			case SaltCorePackage.SRELATION__SGRAPH:
				setSGraph((SGraph)newValue);
				return;
			case SaltCorePackage.SRELATION__STYPE:
				setSType((String)newValue);
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
			case SaltCorePackage.SRELATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SaltCorePackage.SRELATION__SANNOTATIONS:
				getSAnnotations().clear();
				return;
			case SaltCorePackage.SRELATION__SSTEREOTYPE:
				setSStereotype((SStereotype)null);
				return;
			case SaltCorePackage.SRELATION__SFEATURES:
				getSFeatures().clear();
				return;
			case SaltCorePackage.SRELATION__SPROCESSING_ANNOTATIONS:
				getSProcessingAnnotations().clear();
				return;
			case SaltCorePackage.SRELATION__SSOURCE_ELEMENT:
				setSSourceElement((SElement)null);
				return;
			case SaltCorePackage.SRELATION__SDESTINATION_ELEMENT:
				setSDestinationElement((SElement)null);
				return;
			case SaltCorePackage.SRELATION__SSTEREOTYPABLE_ELEMENT:
				setSStereotypableElement((SStereotypeableElement)null);
				return;
			case SaltCorePackage.SRELATION__SANNOTATABLE_ELEMENT:
				setSAnnotatableElement((SAnnotatableElement)null);
				return;
			case SaltCorePackage.SRELATION__SPROCESSING_ANNOTATABLE_ELEMENT:
				setSProcessingAnnotatableElement((SProcessingAnnotatableElement)null);
				return;
			case SaltCorePackage.SRELATION__SGRAPH:
				setSGraph((SGraph)null);
				return;
			case SaltCorePackage.SRELATION__STYPE:
				setSType(STYPE_EDEFAULT);
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
			case SaltCorePackage.SRELATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SaltCorePackage.SRELATION__SANNOTATIONS:
				return !getSAnnotations().isEmpty();
			case SaltCorePackage.SRELATION__SSTEREOTYPE:
				return sStereotype != null;
			case SaltCorePackage.SRELATION__SFEATURES:
				return !getSFeatures().isEmpty();
			case SaltCorePackage.SRELATION__SPROCESSING_ANNOTATIONS:
				return !getSProcessingAnnotations().isEmpty();
			case SaltCorePackage.SRELATION__SSOURCE_ELEMENT:
				return basicGetSSourceElement() != null;
			case SaltCorePackage.SRELATION__SDESTINATION_ELEMENT:
				return basicGetSDestinationElement() != null;
			case SaltCorePackage.SRELATION__SSTEREOTYPABLE_ELEMENT:
				return sStereotypableElement != null;
			case SaltCorePackage.SRELATION__SANNOTATABLE_ELEMENT:
				return sAnnotatableElement != null;
			case SaltCorePackage.SRELATION__SPROCESSING_ANNOTATABLE_ELEMENT:
				return sProcessingAnnotatableElement != null;
			case SaltCorePackage.SRELATION__SGRAPH:
				return getSGraph() != null;
			case SaltCorePackage.SRELATION__STYPE:
				return STYPE_EDEFAULT == null ? sType != null : !STYPE_EDEFAULT.equals(sType);
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
				case SaltCorePackage.SRELATION__NAME: return SaltCorePackage.SNAMED_ELEMENT__NAME;
				default: return -1;
			}
		}
		if (baseClass == SIdentifiableElement.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == SAnnotatableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SRELATION__SANNOTATIONS: return SaltCorePackage.SANNOTATABLE_ELEMENT__SANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == SStereotypeableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SRELATION__SSTEREOTYPE: return SaltCorePackage.SSTEREOTYPEABLE_ELEMENT__SSTEREOTYPE;
				case SaltCorePackage.SRELATION__SFEATURES: return SaltCorePackage.SSTEREOTYPEABLE_ELEMENT__SFEATURES;
				default: return -1;
			}
		}
		if (baseClass == SProcessingAnnotatableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SRELATION__SPROCESSING_ANNOTATIONS: return SaltCorePackage.SPROCESSING_ANNOTATABLE_ELEMENT__SPROCESSING_ANNOTATIONS;
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
				case SaltCorePackage.SNAMED_ELEMENT__NAME: return SaltCorePackage.SRELATION__NAME;
				default: return -1;
			}
		}
		if (baseClass == SIdentifiableElement.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == SAnnotatableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SANNOTATABLE_ELEMENT__SANNOTATIONS: return SaltCorePackage.SRELATION__SANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == SStereotypeableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SSTEREOTYPEABLE_ELEMENT__SSTEREOTYPE: return SaltCorePackage.SRELATION__SSTEREOTYPE;
				case SaltCorePackage.SSTEREOTYPEABLE_ELEMENT__SFEATURES: return SaltCorePackage.SRELATION__SFEATURES;
				default: return -1;
			}
		}
		if (baseClass == SProcessingAnnotatableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SPROCESSING_ANNOTATABLE_ELEMENT__SPROCESSING_ANNOTATIONS: return SaltCorePackage.SRELATION__SPROCESSING_ANNOTATIONS;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", sType: ");
		result.append(sType);
		result.append(')');
		return result.toString();
	}
} //SRelationImpl
