/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore.impl;

import de.hub.corpling.graph.LabelableElement;
import de.hub.corpling.graph.impl.LabelImpl;

import de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement;
import de.hub.corpling.salt.saltCore.SProcessingAnnotation;
import de.hub.corpling.salt.saltCore.SaltCorePackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SProcessing Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SProcessingAnnotationImpl#getSProcessingAnnotatableElement <em>SProcessing Annotatable Element</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SProcessingAnnotationImpl#getSName <em>SName</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SProcessingAnnotationImpl#getSValue <em>SValue</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SProcessingAnnotationImpl#getSNS <em>SNS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SProcessingAnnotationImpl extends LabelImpl implements SProcessingAnnotation {
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
	 * The default value of the '{@link #getSValue() <em>SValue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object SVALUE_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getSNS() <em>SNS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSNS()
	 * @generated
	 * @ordered
	 */
	protected static final String SNS_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SProcessingAnnotationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltCorePackage.Literals.SPROCESSING_ANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SProcessingAnnotatableElement getSProcessingAnnotatableElement() 
	{
		SProcessingAnnotatableElement retVal= null;
		LabelableElement labelableElement= super.getLabelableElement();
		if (labelableElement instanceof SProcessingAnnotatableElement)
			retVal= (SProcessingAnnotatableElement) labelableElement;
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSProcessingAnnotatableElement(SProcessingAnnotatableElement newSProcessingAnnotatableElement) 
	{
		super.setLabelableElement(newSProcessingAnnotatableElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public String getSName() 
	{
		return(super.getName());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSName(String newSName) 
	{
		super.setName(newSName);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Object getSValue() 
	{
		return(super.getValue());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSValue(Object newSValue) 
	{
		super.setValue(newSValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public String getSNS() 
	{
		return(super.getNamespace());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSNS(String newSNS) 
	{
		super.setNamespace(newSNS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SaltCorePackage.SPROCESSING_ANNOTATION__SPROCESSING_ANNOTATABLE_ELEMENT:
				return eInternalContainer().eInverseRemove(this, SaltCorePackage.SPROCESSING_ANNOTATABLE_ELEMENT__SPROCESSING_ANNOTATIONS, SProcessingAnnotatableElement.class, msgs);
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
			case SaltCorePackage.SPROCESSING_ANNOTATION__SPROCESSING_ANNOTATABLE_ELEMENT:
				return getSProcessingAnnotatableElement();
			case SaltCorePackage.SPROCESSING_ANNOTATION__SNAME:
				return getSName();
			case SaltCorePackage.SPROCESSING_ANNOTATION__SVALUE:
				return getSValue();
			case SaltCorePackage.SPROCESSING_ANNOTATION__SNS:
				return getSNS();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SaltCorePackage.SPROCESSING_ANNOTATION__SPROCESSING_ANNOTATABLE_ELEMENT:
				setSProcessingAnnotatableElement((SProcessingAnnotatableElement)newValue);
				return;
			case SaltCorePackage.SPROCESSING_ANNOTATION__SNAME:
				setSName((String)newValue);
				return;
			case SaltCorePackage.SPROCESSING_ANNOTATION__SVALUE:
				setSValue(newValue);
				return;
			case SaltCorePackage.SPROCESSING_ANNOTATION__SNS:
				setSNS((String)newValue);
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
			case SaltCorePackage.SPROCESSING_ANNOTATION__SPROCESSING_ANNOTATABLE_ELEMENT:
				setSProcessingAnnotatableElement((SProcessingAnnotatableElement)null);
				return;
			case SaltCorePackage.SPROCESSING_ANNOTATION__SNAME:
				setSName(SNAME_EDEFAULT);
				return;
			case SaltCorePackage.SPROCESSING_ANNOTATION__SVALUE:
				setSValue(SVALUE_EDEFAULT);
				return;
			case SaltCorePackage.SPROCESSING_ANNOTATION__SNS:
				setSNS(SNS_EDEFAULT);
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
			case SaltCorePackage.SPROCESSING_ANNOTATION__SPROCESSING_ANNOTATABLE_ELEMENT:
				return getSProcessingAnnotatableElement() != null;
			case SaltCorePackage.SPROCESSING_ANNOTATION__SNAME:
				return SNAME_EDEFAULT == null ? getSName() != null : !SNAME_EDEFAULT.equals(getSName());
			case SaltCorePackage.SPROCESSING_ANNOTATION__SVALUE:
				return SVALUE_EDEFAULT == null ? getSValue() != null : !SVALUE_EDEFAULT.equals(getSValue());
			case SaltCorePackage.SPROCESSING_ANNOTATION__SNS:
				return SNS_EDEFAULT == null ? getSNS() != null : !SNS_EDEFAULT.equals(getSNS());
		}
		return super.eIsSet(featureID);
	}

} //SProcessingAnnotationImpl
