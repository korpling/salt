/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.saltCore.impl;

import de.util.graph.Graph;
import de.util.graph.GraphPackage;
import de.util.graph.Label;
import de.util.graph.LabelableElement;
import de.util.graph.Node;
import de.corpling.salt.model.saltCore.SAnnotatableElement;
import de.corpling.salt.model.saltCore.SAnnotation;
import de.corpling.salt.model.saltCore.SElement;
import de.corpling.salt.model.saltCore.SFeature;
import de.corpling.salt.model.saltCore.SGraph;
import de.corpling.salt.model.saltCore.SProcessingAnnotatableElement;
import de.corpling.salt.model.saltCore.SProcessingAnnotation;
import de.corpling.salt.model.saltCore.SStereotype;
import de.corpling.salt.model.saltCore.SStereotypeableElement;
import de.corpling.salt.model.saltCore.SaltCoreFactory;
import de.corpling.salt.model.saltCore.SaltCorePackage;


import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SElement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SElementImpl#getLabels <em>Labels</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SElementImpl#getNumOfLabels <em>Num Of Labels</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SElementImpl#getSAnnotations <em>SAnnotations</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SElementImpl#getSStereotype <em>SStereotype</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SElementImpl#getSFeatures <em>SFeatures</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SElementImpl#getSProcessingAnnotations <em>SProcessing Annotations</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SElementImpl#getGraph <em>Graph</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SElementImpl#getLabelableElement <em>Labelable Element</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SElementImpl#getSSterotypeableElement <em>SSterotypeable Element</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SElementImpl#getSAnnotatableElement <em>SAnnotatable Element</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SElementImpl#getSProcessingAnnotatableElement <em>SProcessing Annotatable Element</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SElementImpl#getSGraph <em>SGraph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SElementImpl extends SIdentifiableElementImpl implements SElement {
	/**
	 * The cached value of the '{@link #getLabels() <em>Labels</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabels()
	 * @generated
	 * @ordered
	 */
	protected EList<Label> labels;

	/**
	 * The default value of the '{@link #getNumOfLabels() <em>Num Of Labels</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumOfLabels()
	 * @generated
	 * @ordered
	 */
	protected static final long NUM_OF_LABELS_EDEFAULT = 0L;

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
	 * The cached value of the '{@link #getLabelableElement() <em>Labelable Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabelableElement()
	 * @generated
	 * @ordered
	 */
	protected LabelableElement labelableElement;

	/**
	 * The cached value of the '{@link #getSSterotypeableElement() <em>SSterotypeable Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSterotypeableElement()
	 * @generated
	 * @ordered
	 */
	protected SStereotypeableElement sSterotypeableElement;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected SElementImpl() 
	{
		super();
		this.init();
	}
	
	private void init()
	{
		this.sSterotypeableElement= SaltCoreFactory.eINSTANCE.createSStereotypeableElement();
		this.sAnnotatableElement= SaltCoreFactory.eINSTANCE.createSAnnotatableElement();
		this.sProcessingAnnotatableElement= SaltCoreFactory.eINSTANCE.createSProcessingAnnotatableElement(); 
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltCorePackage.Literals.SELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 */
	public EList<Label> getLabels() {
		if (labels == null) {
			labels = new EObjectContainmentWithInverseEList<Label>(Label.class, this, SaltCorePackage.SELEMENT__LABELS, GraphPackage.LABEL__LABEL_OWNER);
		}
		return labels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 */
	public long getNumOfLabels() {
		// TODO: implement this method to return the 'Num Of Labels' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
	public Graph getGraph() {
		if (eContainerFeatureID != SaltCorePackage.SELEMENT__GRAPH) return null;
		return (Graph)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGraph(Graph newGraph, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newGraph, SaltCorePackage.SELEMENT__GRAPH, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGraph(Graph newGraph) {
		if (newGraph != eInternalContainer() || (eContainerFeatureID != SaltCorePackage.SELEMENT__GRAPH && newGraph != null)) {
			if (EcoreUtil.isAncestor(this, newGraph))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newGraph != null)
				msgs = ((InternalEObject)newGraph).eInverseAdd(this, GraphPackage.GRAPH__NODES, Graph.class, msgs);
			msgs = basicSetGraph(newGraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SELEMENT__GRAPH, newGraph, newGraph));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 */
	public LabelableElement getLabelableElement() {
		return labelableElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 */
	public NotificationChain basicSetLabelableElement(LabelableElement newLabelableElement, NotificationChain msgs) {
		LabelableElement oldLabelableElement = labelableElement;
		labelableElement = newLabelableElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SaltCorePackage.SELEMENT__LABELABLE_ELEMENT, oldLabelableElement, newLabelableElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 */
	public void setLabelableElement(LabelableElement newLabelableElement) {
		if (newLabelableElement != labelableElement) {
			NotificationChain msgs = null;
			if (labelableElement != null)
				msgs = ((InternalEObject)labelableElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SaltCorePackage.SELEMENT__LABELABLE_ELEMENT, null, msgs);
			if (newLabelableElement != null)
				msgs = ((InternalEObject)newLabelableElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SaltCorePackage.SELEMENT__LABELABLE_ELEMENT, null, msgs);
			msgs = basicSetLabelableElement(newLabelableElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SELEMENT__LABELABLE_ELEMENT, newLabelableElement, newLabelableElement));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SaltCorePackage.SELEMENT__SSTEREOTYPE, oldSStereotype, sStereotype));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SELEMENT__SSTEREOTYPE, oldSStereotype, sStereotype));
	}

//------------------- Start feature-Handling	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EList<SFeature> getSFeatures() 
	{
		return(this.sSterotypeableElement.getSFeatures());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SProcessingAnnotation> getSProcessingAnnotations() {
		// TODO: implement this method to return the 'SProcessing Annotations' containment reference list
		// Ensure that you remove @generated or mark it @generated NOT
		// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
		// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addSFeature(String featureName, Object featureValue) {
		this.sSterotypeableElement.addSFeature(featureName, featureValue);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SFeature getSFeature(String featureName) 
	{
		return(this.sSterotypeableElement.getSFeature(featureName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public boolean removeSFeature(String featureName) 
	{
		return(this.sSterotypeableElement.removeSFeature(featureName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addSFeature(SFeature feature) 
	{
		this.sSterotypeableElement.addSFeature(feature);
	}
/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addSAnnotation(SAnnotation sAnnotation) 
	{
		this.getSAnnotatableElement().addSAnnotation(sAnnotation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SAnnotation getSAnnotation(String fullName) 
	{
		return(this.getSAnnotatableElement().getSAnnotation(fullName));
	}

	//------------------- End feature-Handling
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SStereotypeableElement getSSterotypeableElement() {
		return sSterotypeableElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSSterotypeableElement(SStereotypeableElement newSSterotypeableElement, NotificationChain msgs) {
		SStereotypeableElement oldSSterotypeableElement = sSterotypeableElement;
		sSterotypeableElement = newSSterotypeableElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SaltCorePackage.SELEMENT__SSTEROTYPEABLE_ELEMENT, oldSSterotypeableElement, newSSterotypeableElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSSterotypeableElement(SStereotypeableElement newSSterotypeableElement) {
		if (newSSterotypeableElement != sSterotypeableElement) {
			NotificationChain msgs = null;
			if (sSterotypeableElement != null)
				msgs = ((InternalEObject)sSterotypeableElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SaltCorePackage.SELEMENT__SSTEROTYPEABLE_ELEMENT, null, msgs);
			if (newSSterotypeableElement != null)
				msgs = ((InternalEObject)newSSterotypeableElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SaltCorePackage.SELEMENT__SSTEROTYPEABLE_ELEMENT, null, msgs);
			msgs = basicSetSSterotypeableElement(newSSterotypeableElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SELEMENT__SSTEROTYPEABLE_ELEMENT, newSSterotypeableElement, newSSterotypeableElement));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SaltCorePackage.SELEMENT__SANNOTATABLE_ELEMENT, oldSAnnotatableElement, newSAnnotatableElement);
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
				msgs = ((InternalEObject)sAnnotatableElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SaltCorePackage.SELEMENT__SANNOTATABLE_ELEMENT, null, msgs);
			if (newSAnnotatableElement != null)
				msgs = ((InternalEObject)newSAnnotatableElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SaltCorePackage.SELEMENT__SANNOTATABLE_ELEMENT, null, msgs);
			msgs = basicSetSAnnotatableElement(newSAnnotatableElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SELEMENT__SANNOTATABLE_ELEMENT, newSAnnotatableElement, newSAnnotatableElement));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SaltCorePackage.SELEMENT__SPROCESSING_ANNOTATABLE_ELEMENT, oldSProcessingAnnotatableElement, newSProcessingAnnotatableElement);
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
				msgs = ((InternalEObject)sProcessingAnnotatableElement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SaltCorePackage.SELEMENT__SPROCESSING_ANNOTATABLE_ELEMENT, null, msgs);
			if (newSProcessingAnnotatableElement != null)
				msgs = ((InternalEObject)newSProcessingAnnotatableElement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SaltCorePackage.SELEMENT__SPROCESSING_ANNOTATABLE_ELEMENT, null, msgs);
			msgs = basicSetSProcessingAnnotatableElement(newSProcessingAnnotatableElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SELEMENT__SPROCESSING_ANNOTATABLE_ELEMENT, newSProcessingAnnotatableElement, newSProcessingAnnotatableElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SGraph getSGraph() 
	{
		return((SGraph)this.getGraph());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSGraph(SGraph newSGraph) 
	{
		this.setGraph(newSGraph);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addSProcessingAnnotation(SProcessingAnnotation sProcessingAnnotation) 
	{
		this.getSProcessingAnnotatableElement().addSProcessingAnnotation(sProcessingAnnotation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SProcessingAnnotation getSProcessingAnnotation(String fullName) 
	{
		return(this.getSProcessingAnnotatableElement().getSProcessingAnnotation(fullName));
	}

	// --------------------------------- Start Label-Handling	
	/**
	 * IDEE: das label-handling kann auf das ANNotation handling umgebogen werden,
	 * dann sind diese methoden nicht unnütz, sondern haben gleiche funktion wie
	 * annotationshandling 
	 */
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 */
	public void addLabel(Label label) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 */
	public Label getLabel(String fullName) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 */
	public Label getLabel(String namespace, String name) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 */
	public boolean removeLabel(String fullName) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 */
	public boolean removeLabel(String namespace, String name) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 */
	public boolean hasLabel(String fullName) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 */
	public boolean hasLabel(String namespace, String name) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 */
	public boolean removeAll() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 */
	public EList<Label> getLabelsByNamespace(String namespace) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}
// --------------------------------- End Label-Handling
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SaltCorePackage.SELEMENT__LABELS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLabels()).basicAdd(otherEnd, msgs);
			case SaltCorePackage.SELEMENT__GRAPH:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetGraph((Graph)otherEnd, msgs);
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
			case SaltCorePackage.SELEMENT__LABELS:
				return ((InternalEList<?>)getLabels()).basicRemove(otherEnd, msgs);
			case SaltCorePackage.SELEMENT__SANNOTATIONS:
				return ((InternalEList<?>)getSAnnotations()).basicRemove(otherEnd, msgs);
			case SaltCorePackage.SELEMENT__SFEATURES:
				return ((InternalEList<?>)getSFeatures()).basicRemove(otherEnd, msgs);
			case SaltCorePackage.SELEMENT__SPROCESSING_ANNOTATIONS:
				return ((InternalEList<?>)getSProcessingAnnotations()).basicRemove(otherEnd, msgs);
			case SaltCorePackage.SELEMENT__GRAPH:
				return basicSetGraph(null, msgs);
			case SaltCorePackage.SELEMENT__LABELABLE_ELEMENT:
				return basicSetLabelableElement(null, msgs);
			case SaltCorePackage.SELEMENT__SSTEROTYPEABLE_ELEMENT:
				return basicSetSSterotypeableElement(null, msgs);
			case SaltCorePackage.SELEMENT__SANNOTATABLE_ELEMENT:
				return basicSetSAnnotatableElement(null, msgs);
			case SaltCorePackage.SELEMENT__SPROCESSING_ANNOTATABLE_ELEMENT:
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
			case SaltCorePackage.SELEMENT__GRAPH:
				return eInternalContainer().eInverseRemove(this, GraphPackage.GRAPH__NODES, Graph.class, msgs);
			case SaltCorePackage.SELEMENT__SGRAPH:
				return eInternalContainer().eInverseRemove(this, SaltCorePackage.SGRAPH__SELEMENTS, SGraph.class, msgs);
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
			case SaltCorePackage.SELEMENT__LABELS:
				return getLabels();
			case SaltCorePackage.SELEMENT__NUM_OF_LABELS:
				return new Long(getNumOfLabels());
			case SaltCorePackage.SELEMENT__SANNOTATIONS:
				return getSAnnotations();
			case SaltCorePackage.SELEMENT__SSTEREOTYPE:
				if (resolve) return getSStereotype();
				return basicGetSStereotype();
			case SaltCorePackage.SELEMENT__SFEATURES:
				return getSFeatures();
			case SaltCorePackage.SELEMENT__SPROCESSING_ANNOTATIONS:
				return getSProcessingAnnotations();
			case SaltCorePackage.SELEMENT__GRAPH:
				return getGraph();
			case SaltCorePackage.SELEMENT__LABELABLE_ELEMENT:
				return getLabelableElement();
			case SaltCorePackage.SELEMENT__SSTEROTYPEABLE_ELEMENT:
				return getSSterotypeableElement();
			case SaltCorePackage.SELEMENT__SANNOTATABLE_ELEMENT:
				return getSAnnotatableElement();
			case SaltCorePackage.SELEMENT__SPROCESSING_ANNOTATABLE_ELEMENT:
				return getSProcessingAnnotatableElement();
			case SaltCorePackage.SELEMENT__SGRAPH:
				return getSGraph();
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
			case SaltCorePackage.SELEMENT__LABELS:
				getLabels().clear();
				getLabels().addAll((Collection<? extends Label>)newValue);
				return;
			case SaltCorePackage.SELEMENT__SANNOTATIONS:
				getSAnnotations().clear();
				getSAnnotations().addAll((Collection<? extends SAnnotation>)newValue);
				return;
			case SaltCorePackage.SELEMENT__SSTEREOTYPE:
				setSStereotype((SStereotype)newValue);
				return;
			case SaltCorePackage.SELEMENT__SFEATURES:
				getSFeatures().clear();
				getSFeatures().addAll((Collection<? extends SFeature>)newValue);
				return;
			case SaltCorePackage.SELEMENT__SPROCESSING_ANNOTATIONS:
				getSProcessingAnnotations().clear();
				getSProcessingAnnotations().addAll((Collection<? extends SProcessingAnnotation>)newValue);
				return;
			case SaltCorePackage.SELEMENT__GRAPH:
				setGraph((Graph)newValue);
				return;
			case SaltCorePackage.SELEMENT__LABELABLE_ELEMENT:
				setLabelableElement((LabelableElement)newValue);
				return;
			case SaltCorePackage.SELEMENT__SSTEROTYPEABLE_ELEMENT:
				setSSterotypeableElement((SStereotypeableElement)newValue);
				return;
			case SaltCorePackage.SELEMENT__SANNOTATABLE_ELEMENT:
				setSAnnotatableElement((SAnnotatableElement)newValue);
				return;
			case SaltCorePackage.SELEMENT__SPROCESSING_ANNOTATABLE_ELEMENT:
				setSProcessingAnnotatableElement((SProcessingAnnotatableElement)newValue);
				return;
			case SaltCorePackage.SELEMENT__SGRAPH:
				setSGraph((SGraph)newValue);
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
			case SaltCorePackage.SELEMENT__LABELS:
				getLabels().clear();
				return;
			case SaltCorePackage.SELEMENT__SANNOTATIONS:
				getSAnnotations().clear();
				return;
			case SaltCorePackage.SELEMENT__SSTEREOTYPE:
				setSStereotype((SStereotype)null);
				return;
			case SaltCorePackage.SELEMENT__SFEATURES:
				getSFeatures().clear();
				return;
			case SaltCorePackage.SELEMENT__SPROCESSING_ANNOTATIONS:
				getSProcessingAnnotations().clear();
				return;
			case SaltCorePackage.SELEMENT__GRAPH:
				setGraph((Graph)null);
				return;
			case SaltCorePackage.SELEMENT__LABELABLE_ELEMENT:
				setLabelableElement((LabelableElement)null);
				return;
			case SaltCorePackage.SELEMENT__SSTEROTYPEABLE_ELEMENT:
				setSSterotypeableElement((SStereotypeableElement)null);
				return;
			case SaltCorePackage.SELEMENT__SANNOTATABLE_ELEMENT:
				setSAnnotatableElement((SAnnotatableElement)null);
				return;
			case SaltCorePackage.SELEMENT__SPROCESSING_ANNOTATABLE_ELEMENT:
				setSProcessingAnnotatableElement((SProcessingAnnotatableElement)null);
				return;
			case SaltCorePackage.SELEMENT__SGRAPH:
				setSGraph((SGraph)null);
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
			case SaltCorePackage.SELEMENT__LABELS:
				return labels != null && !labels.isEmpty();
			case SaltCorePackage.SELEMENT__NUM_OF_LABELS:
				return getNumOfLabels() != NUM_OF_LABELS_EDEFAULT;
			case SaltCorePackage.SELEMENT__SANNOTATIONS:
				return !getSAnnotations().isEmpty();
			case SaltCorePackage.SELEMENT__SSTEREOTYPE:
				return sStereotype != null;
			case SaltCorePackage.SELEMENT__SFEATURES:
				return !getSFeatures().isEmpty();
			case SaltCorePackage.SELEMENT__SPROCESSING_ANNOTATIONS:
				return !getSProcessingAnnotations().isEmpty();
			case SaltCorePackage.SELEMENT__GRAPH:
				return getGraph() != null;
			case SaltCorePackage.SELEMENT__LABELABLE_ELEMENT:
				return labelableElement != null;
			case SaltCorePackage.SELEMENT__SSTEROTYPEABLE_ELEMENT:
				return sSterotypeableElement != null;
			case SaltCorePackage.SELEMENT__SANNOTATABLE_ELEMENT:
				return sAnnotatableElement != null;
			case SaltCorePackage.SELEMENT__SPROCESSING_ANNOTATABLE_ELEMENT:
				return sProcessingAnnotatableElement != null;
			case SaltCorePackage.SELEMENT__SGRAPH:
				return getSGraph() != null;
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
		if (baseClass == LabelableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SELEMENT__LABELS: return GraphPackage.LABELABLE_ELEMENT__LABELS;
				case SaltCorePackage.SELEMENT__NUM_OF_LABELS: return GraphPackage.LABELABLE_ELEMENT__NUM_OF_LABELS;
				default: return -1;
			}
		}
		if (baseClass == SAnnotatableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SELEMENT__SANNOTATIONS: return SaltCorePackage.SANNOTATABLE_ELEMENT__SANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == SStereotypeableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SELEMENT__SSTEREOTYPE: return SaltCorePackage.SSTEREOTYPEABLE_ELEMENT__SSTEREOTYPE;
				case SaltCorePackage.SELEMENT__SFEATURES: return SaltCorePackage.SSTEREOTYPEABLE_ELEMENT__SFEATURES;
				default: return -1;
			}
		}
		if (baseClass == SProcessingAnnotatableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SELEMENT__SPROCESSING_ANNOTATIONS: return SaltCorePackage.SPROCESSING_ANNOTATABLE_ELEMENT__SPROCESSING_ANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == Node.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SELEMENT__GRAPH: return GraphPackage.NODE__GRAPH;
				case SaltCorePackage.SELEMENT__LABELABLE_ELEMENT: return GraphPackage.NODE__LABELABLE_ELEMENT;
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
		if (baseClass == LabelableElement.class) {
			switch (baseFeatureID) {
				case GraphPackage.LABELABLE_ELEMENT__LABELS: return SaltCorePackage.SELEMENT__LABELS;
				case GraphPackage.LABELABLE_ELEMENT__NUM_OF_LABELS: return SaltCorePackage.SELEMENT__NUM_OF_LABELS;
				default: return -1;
			}
		}
		if (baseClass == SAnnotatableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SANNOTATABLE_ELEMENT__SANNOTATIONS: return SaltCorePackage.SELEMENT__SANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == SStereotypeableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SSTEREOTYPEABLE_ELEMENT__SSTEREOTYPE: return SaltCorePackage.SELEMENT__SSTEREOTYPE;
				case SaltCorePackage.SSTEREOTYPEABLE_ELEMENT__SFEATURES: return SaltCorePackage.SELEMENT__SFEATURES;
				default: return -1;
			}
		}
		if (baseClass == SProcessingAnnotatableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SPROCESSING_ANNOTATABLE_ELEMENT__SPROCESSING_ANNOTATIONS: return SaltCorePackage.SELEMENT__SPROCESSING_ANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == Node.class) {
			switch (baseFeatureID) {
				case GraphPackage.NODE__GRAPH: return SaltCorePackage.SELEMENT__GRAPH;
				case GraphPackage.NODE__LABELABLE_ELEMENT: return SaltCorePackage.SELEMENT__LABELABLE_ELEMENT;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //SElementImpl
