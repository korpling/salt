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
import de.hub.corpling.salt.saltCore.SFeaturableElement;
import de.hub.corpling.salt.saltCore.SFeature;
import de.hub.corpling.salt.saltCore.SaltCorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SFeature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SFeatureImpl#getSName <em>SName</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SFeatureImpl#getSValue <em>SValue</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SFeatureImpl#getSFeaturableElement <em>SFeaturable Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SFeatureImpl extends LabelImpl implements SFeature {
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
	protected SFeatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltCorePackage.Literals.SFEATURE;
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
	public SFeaturableElement getSFeaturableElement() 
	{
		SFeaturableElement retVal= null;
		LabelableElement labelableElement= super.getLabelableElement();
		if (labelableElement instanceof SFeaturableElement)
			retVal= (SFeaturableElement) labelableElement;
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSFeaturableElement(SFeaturableElement newSFeaturableElement) 
	{
		super.setLabelableElement(newSFeaturableElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SaltCorePackage.SFEATURE__SFEATURABLE_ELEMENT:
				return eInternalContainer().eInverseRemove(this, SaltCorePackage.SFEATURABLE_ELEMENT__SFEATURES, SFeaturableElement.class, msgs);
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
			case SaltCorePackage.SFEATURE__SNAME:
				return getSName();
			case SaltCorePackage.SFEATURE__SVALUE:
				return getSValue();
			case SaltCorePackage.SFEATURE__SFEATURABLE_ELEMENT:
				return getSFeaturableElement();
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
			case SaltCorePackage.SFEATURE__SNAME:
				setSName((String)newValue);
				return;
			case SaltCorePackage.SFEATURE__SVALUE:
				setSValue(newValue);
				return;
			case SaltCorePackage.SFEATURE__SFEATURABLE_ELEMENT:
				setSFeaturableElement((SFeaturableElement)newValue);
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
			case SaltCorePackage.SFEATURE__SNAME:
				setSName(SNAME_EDEFAULT);
				return;
			case SaltCorePackage.SFEATURE__SVALUE:
				setSValue(SVALUE_EDEFAULT);
				return;
			case SaltCorePackage.SFEATURE__SFEATURABLE_ELEMENT:
				setSFeaturableElement((SFeaturableElement)null);
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
			case SaltCorePackage.SFEATURE__SNAME:
				return SNAME_EDEFAULT == null ? getSName() != null : !SNAME_EDEFAULT.equals(getSName());
			case SaltCorePackage.SFEATURE__SVALUE:
				return SVALUE_EDEFAULT == null ? getSValue() != null : !SVALUE_EDEFAULT.equals(getSValue());
			case SaltCorePackage.SFEATURE__SFEATURABLE_ELEMENT:
				return getSFeaturableElement() != null;
		}
		return super.eIsSet(featureID);
	}

} //SFeatureImpl
