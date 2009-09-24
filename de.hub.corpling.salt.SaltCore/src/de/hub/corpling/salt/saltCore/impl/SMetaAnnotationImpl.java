/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import de.hub.corpling.graph.LabelableElement;
import de.hub.corpling.graph.impl.LabelImpl;
import de.hub.corpling.salt.saltCore.SMetaAnnotatableElement;
import de.hub.corpling.salt.saltCore.SMetaAnnotation;
import de.hub.corpling.salt.saltCore.SaltCorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SMeta Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SMetaAnnotationImpl#getSMetaAnnotatableElement <em>SMeta Annotatable Element</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SMetaAnnotationImpl#getSNS <em>SNS</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SMetaAnnotationImpl#getSName <em>SName</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SMetaAnnotationImpl#getSValue <em>SValue</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SMetaAnnotationImpl extends LabelImpl implements SMetaAnnotation {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SMetaAnnotationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltCorePackage.Literals.SMETA_ANNOTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SMetaAnnotatableElement getSMetaAnnotatableElement() 
	{
		SMetaAnnotatableElement retVal= null;
		LabelableElement labelableElement= super.getLabelableElement();
		if (labelableElement instanceof SMetaAnnotatableElement)
			retVal= (SMetaAnnotatableElement) labelableElement;
		return(retVal);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSMetaAnnotatableElement(SMetaAnnotatableElement newSMetaAnnotatableElement) 
	{
		super.setLabelableElement(newSMetaAnnotatableElement);
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
			case SaltCorePackage.SMETA_ANNOTATION__SMETA_ANNOTATABLE_ELEMENT:
				return eInternalContainer().eInverseRemove(this, SaltCorePackage.SMETA_ANNOTATABLE_ELEMENT__SMETA_ANNOTATIONS, SMetaAnnotatableElement.class, msgs);
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
			case SaltCorePackage.SMETA_ANNOTATION__SMETA_ANNOTATABLE_ELEMENT:
				return getSMetaAnnotatableElement();
			case SaltCorePackage.SMETA_ANNOTATION__SNS:
				return getSNS();
			case SaltCorePackage.SMETA_ANNOTATION__SNAME:
				return getSName();
			case SaltCorePackage.SMETA_ANNOTATION__SVALUE:
				return getSValue();
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
			case SaltCorePackage.SMETA_ANNOTATION__SMETA_ANNOTATABLE_ELEMENT:
				setSMetaAnnotatableElement((SMetaAnnotatableElement)newValue);
				return;
			case SaltCorePackage.SMETA_ANNOTATION__SNS:
				setSNS((String)newValue);
				return;
			case SaltCorePackage.SMETA_ANNOTATION__SNAME:
				setSName((String)newValue);
				return;
			case SaltCorePackage.SMETA_ANNOTATION__SVALUE:
				setSValue(newValue);
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
			case SaltCorePackage.SMETA_ANNOTATION__SMETA_ANNOTATABLE_ELEMENT:
				setSMetaAnnotatableElement((SMetaAnnotatableElement)null);
				return;
			case SaltCorePackage.SMETA_ANNOTATION__SNS:
				setSNS(SNS_EDEFAULT);
				return;
			case SaltCorePackage.SMETA_ANNOTATION__SNAME:
				setSName(SNAME_EDEFAULT);
				return;
			case SaltCorePackage.SMETA_ANNOTATION__SVALUE:
				setSValue(SVALUE_EDEFAULT);
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
			case SaltCorePackage.SMETA_ANNOTATION__SMETA_ANNOTATABLE_ELEMENT:
				return getSMetaAnnotatableElement() != null;
			case SaltCorePackage.SMETA_ANNOTATION__SNS:
				return SNS_EDEFAULT == null ? getSNS() != null : !SNS_EDEFAULT.equals(getSNS());
			case SaltCorePackage.SMETA_ANNOTATION__SNAME:
				return SNAME_EDEFAULT == null ? getSName() != null : !SNAME_EDEFAULT.equals(getSName());
			case SaltCorePackage.SMETA_ANNOTATION__SVALUE:
				return SVALUE_EDEFAULT == null ? getSValue() != null : !SVALUE_EDEFAULT.equals(getSValue());
		}
		return super.eIsSet(featureID);
	}

} //SMetaAnnotationImpl
