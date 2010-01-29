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
import de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement;
import de.hub.corpling.salt.saltCore.SProcessingAnnotation;
import de.hub.corpling.salt.saltCore.SaltCorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SProcessing Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SProcessingAnnotationImpl#getSProcessingAnnotatableElement <em>SProcessing Annotatable Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SProcessingAnnotationImpl extends SAbstractAnnotationImpl implements SProcessingAnnotation {
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
		}
		return super.eIsSet(featureID);
	}

} //SProcessingAnnotationImpl
