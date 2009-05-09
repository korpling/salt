/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.saltCore.impl;

import de.corpling.salt.model.saltCore.SAnnotatableElement;
import de.util.graph.impl.LabelImpl;

import java.io.File;
import java.net.URI;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import de.corpling.salt.model.saltCore.SAnnotation;
import de.corpling.salt.model.saltCore.SDATATYPES;
import de.corpling.salt.model.saltCore.SaltCorePackage;
import de.corpling.salt.saltFW.SaltFWFactory;


import de.util.graph.GraphPackage;
import de.util.graph.Label;
import de.util.graph.LabelableElement;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SAnnotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SAnnotationImpl#getLabels <em>Labels</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SAnnotationImpl#getNumOfLabels <em>Num Of Labels</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SAnnotationImpl#getSAnnotations <em>SAnnotations</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SAnnotationImpl#getSType <em>SType</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SAnnotationImpl#getSuperAnnotatableElement <em>Super Annotatable Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SAnnotationImpl extends LabelImpl implements SAnnotation 
{
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
	private Logger logger= Logger.getLogger(SAnnotationImpl.class);
	private static final String MSG_ERR=	"Error("+SAnnotation.class+")";
	private static final String MSG_WARN=	"Warning("+SAnnotation.class+")";
	/**
	 * The default value of the '{@link #getSType() <em>SType</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSType()
	 * @generated
	 * @ordered
	 */
	protected static final SDATATYPES STYPE_EDEFAULT = SDATATYPES.STEXT;
	/**
	 * The cached value of the '{@link #getSType() <em>SType</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSType()
	 * @generated
	 * @ordered
	 */
	protected SDATATYPES sType = STYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSuperAnnotatableElement() <em>Super Annotatable Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperAnnotatableElement()
	 * @ordered
	 */
	protected SAnnotatableElement superAnnotatableElement= SaltFWFactory.eINSTANCE.createSAnnotatableElement();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SAnnotationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltCorePackage.Literals.SANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Label> getLabels() {
		if (labels == null) {
			labels = new EObjectContainmentWithInverseEList<Label>(Label.class, this, SaltCorePackage.SANNOTATION__LABELS, GraphPackage.LABEL__LABEL_OWNER);
		}
		return labels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public long getNumOfLabels() 
	{
		return(this.getSuperAnnotatableElement().getNumOfLabels());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EList<SAnnotation> getSAnnotations() 
	{
		return(this.getSuperAnnotatableElement().getSAnnotations());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDATATYPES getSType() {
		return sType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSType(SDATATYPES newSType) {
		SDATATYPES oldSType = sType;
		sType = newSType == null ? STYPE_EDEFAULT : newSType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SANNOTATION__STYPE, oldSType, sType));
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SAnnotatableElement getSuperAnnotatableElement() {
		return superAnnotatableElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuperAnnotatableElement(SAnnotatableElement newSuperAnnotatableElement, NotificationChain msgs) {
		SAnnotatableElement oldSuperAnnotatableElement = superAnnotatableElement;
		superAnnotatableElement = newSuperAnnotatableElement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SaltCorePackage.SANNOTATION__SUPER_ANNOTATABLE_ELEMENT, oldSuperAnnotatableElement, newSuperAnnotatableElement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Checks if the datatype of the given value matches the sType attribute. If it is so,
	 * the value will be set.
	 */
	@Override
	public void setValue(Object newValue) 
	{
		if ((this.getSType()!= null) && (newValue!= null))
		{
			//SNUMBER
			if (this.getSType()== SDATATYPES.SNUMBER)
			{
				if (!Long.class.isInstance(newValue))
					throw new NullPointerException(MSG_ERR+"Cannot set the given value for SAnnotation, because it is not compatible with datatype "+SDATATYPES.SNUMBER+ ".");
			}
			//SREAL
			else if (this.getSType()== SDATATYPES.SREAL)
			{
				if (!Double.class.isInstance(newValue))
					throw new NullPointerException(MSG_ERR+"Cannot set the given value for SAnnotation, because it is not compatible with datatype "+SDATATYPES.SREAL+ ".");
			}
			//STEXT
			else if (this.getSType()== SDATATYPES.STEXT)
			{
				if (!String.class.isInstance(newValue))
					throw new NullPointerException(MSG_ERR+"Cannot set the given value for SAnnotation, because it is not compatible with datatype "+SDATATYPES.STEXT+ ".");
			}
			//SURI
			else if (this.getSType()== SDATATYPES.SURI)
			{
				if (!URI.class.isInstance(newValue))
					throw new NullPointerException(MSG_ERR+"Cannot set the given value for SAnnotation, because it is not compatible with datatype "+SDATATYPES.SURI+ ".");
				File sourceFile= new File(((URI)newValue).getPath());
				if (!sourceFile.isAbsolute())
					this.logger.warn(MSG_WARN + "The uri value of this annotation doesn´t have an absolute path: "+newValue);				
			}
			//SOBJECT
			else if (this.getSType()== SDATATYPES.SOBJECT)
			{
				if (!Object.class.isInstance(newValue))
					throw new NullPointerException(MSG_ERR+"Cannot set the given value for SAnnotation, because it is not compatible with datatype "+SDATATYPES.SOBJECT+ ".");
			}
		}
		super.setValue(newValue);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Long getValueSNumber() 
	{
		Long retVal= null;
		
		if (this.sType== SDATATYPES.SNUMBER)
		{
			if (this.getValue()== null)
				retVal= null;
			else if (Long.class.isInstance(this.getValue()))
				retVal= (Long)this.getValue();
			else throw new NullPointerException(MSG_ERR + "The value is not of type long, especially it is of type SNUMBER.");
		}	
		else throw new NullPointerException(MSG_ERR + "The value is not of type SNUMBER.");
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Double getValueSReal() 
	{
		Double retVal= null;
		
		if (this.sType== SDATATYPES.SREAL)
		{
			if (this.getValue()== null)
				retVal= null;
			else if (Double.class.isInstance(this.getValue()))
				retVal= (Double)this.getValue();
			else throw new NullPointerException(MSG_ERR + "The value is not of type long, especially it is of type SNUMBER.");
		}	
		else throw new NullPointerException(MSG_ERR + "The value is not of type SREAL.");
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public String getValueSText() 
	{
		String retVal= null;
		
		if (this.sType== SDATATYPES.STEXT)
			retVal= (String)this.getValue();
		else retVal= this.getValue().toString(); 
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public URI getValueSURI() 
	{
		URI retVal= null;
		
		if (this.sType== SDATATYPES.SURI)
		{
			if (this.getValue()== null)
				retVal= null;
			else if (URI.class.isInstance(this.getValue()))
				retVal= (URI)this.getValue();
			else throw new NullPointerException(MSG_ERR + "The value is not of type long, especially it is of type SNUMBER.");
		}	
		else throw new NullPointerException(MSG_ERR + "The value is not of type SURI.");
		return(retVal);
	}

	/**
	 * Returns the value as an Object.
	 */
	@Override
	public Object getValueSObject() 
	{
		return(this.getValue());	
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addSAnnotation(SAnnotation sAnnotation) 
	{
		this.getSuperAnnotatableElement().addSAnnotation(sAnnotation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SAnnotation getSAnnotation(String fullName) 
	{
		return(this.getSuperAnnotatableElement().getSAnnotation(fullName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addLabel(Label label) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Label getLabel(String fullName) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Label getLabel(String namespace, String name) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean removeLabel(String fullName) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean removeLabel(String namespace, String name) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean hasLabel(String fullName) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean hasLabel(String namespace, String name) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean removeAll() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Label> getLabelsByNamespace(String namespace) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			case SaltCorePackage.SANNOTATION__LABELS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLabels()).basicAdd(otherEnd, msgs);
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
			case SaltCorePackage.SANNOTATION__LABELS:
				return ((InternalEList<?>)getLabels()).basicRemove(otherEnd, msgs);
			case SaltCorePackage.SANNOTATION__SANNOTATIONS:
				return ((InternalEList<?>)getSAnnotations()).basicRemove(otherEnd, msgs);
			case SaltCorePackage.SANNOTATION__SUPER_ANNOTATABLE_ELEMENT:
				return basicSetSuperAnnotatableElement(null, msgs);
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
			case SaltCorePackage.SANNOTATION__LABELS:
				return getLabels();
			case SaltCorePackage.SANNOTATION__NUM_OF_LABELS:
				return new Long(getNumOfLabels());
			case SaltCorePackage.SANNOTATION__SANNOTATIONS:
				return getSAnnotations();
			case SaltCorePackage.SANNOTATION__STYPE:
				return getSType();
			case SaltCorePackage.SANNOTATION__SUPER_ANNOTATABLE_ELEMENT:
				return getSuperAnnotatableElement();
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
			case SaltCorePackage.SANNOTATION__LABELS:
				getLabels().clear();
				getLabels().addAll((Collection<? extends Label>)newValue);
				return;
			case SaltCorePackage.SANNOTATION__SANNOTATIONS:
				getSAnnotations().clear();
				getSAnnotations().addAll((Collection<? extends SAnnotation>)newValue);
				return;
			case SaltCorePackage.SANNOTATION__STYPE:
				setSType((SDATATYPES)newValue);
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
			case SaltCorePackage.SANNOTATION__LABELS:
				getLabels().clear();
				return;
			case SaltCorePackage.SANNOTATION__SANNOTATIONS:
				getSAnnotations().clear();
				return;
			case SaltCorePackage.SANNOTATION__STYPE:
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
			case SaltCorePackage.SANNOTATION__LABELS:
				return labels != null && !labels.isEmpty();
			case SaltCorePackage.SANNOTATION__NUM_OF_LABELS:
				return getNumOfLabels() != NUM_OF_LABELS_EDEFAULT;
			case SaltCorePackage.SANNOTATION__SANNOTATIONS:
				return !getSAnnotations().isEmpty();
			case SaltCorePackage.SANNOTATION__STYPE:
				return sType != STYPE_EDEFAULT;
			case SaltCorePackage.SANNOTATION__SUPER_ANNOTATABLE_ELEMENT:
				return superAnnotatableElement != null;
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
				case SaltCorePackage.SANNOTATION__LABELS: return GraphPackage.LABELABLE_ELEMENT__LABELS;
				case SaltCorePackage.SANNOTATION__NUM_OF_LABELS: return GraphPackage.LABELABLE_ELEMENT__NUM_OF_LABELS;
				default: return -1;
			}
		}
		if (baseClass == SAnnotatableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SANNOTATION__SANNOTATIONS: return SaltCorePackage.SANNOTATABLE_ELEMENT__SANNOTATIONS;
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
				case GraphPackage.LABELABLE_ELEMENT__LABELS: return SaltCorePackage.SANNOTATION__LABELS;
				case GraphPackage.LABELABLE_ELEMENT__NUM_OF_LABELS: return SaltCorePackage.SANNOTATION__NUM_OF_LABELS;
				default: return -1;
			}
		}
		if (baseClass == SAnnotatableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SANNOTATABLE_ELEMENT__SANNOTATIONS: return SaltCorePackage.SANNOTATION__SANNOTATIONS;
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
		result.append(" (sType: ");
		result.append(sType);
		result.append(')');
		return result.toString();
	}
} //SAnnotationImpl
