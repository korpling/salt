/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.saltCore.impl;


import de.corpling.salt.model.saltCore.SStereotype;
import de.corpling.salt.model.saltCore.SStereotypeContainer;
import de.corpling.salt.model.saltCore.SaltCoreFactory;
import de.corpling.salt.model.saltCore.SaltCorePackage;

import java.util.Collection;

import java.util.Properties;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SStereotype Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.corpling.salt.model.saltCore.impl.SStereotypeContainerImpl#getSStereotypes <em>SStereotypes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SStereotypeContainerImpl extends EObjectImpl implements SStereotypeContainer 
{
	private static final String MSG_ERR=		"Error("+SStereotypeContainerImpl.class+"): ";
	/**
	 * The cached value of the '{@link #getSStereotypes() <em>SStereotypes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSStereotypes()
	 * @generated
	 * @ordered
	 */
	protected EList<SStereotype> sStereotypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SStereotypeContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltCorePackage.Literals.SSTEREOTYPE_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SStereotype> getSStereotypes() {
		if (sStereotypes == null) {
			sStereotypes = new EObjectContainmentWithInverseEList<SStereotype>(SStereotype.class, this, SaltCorePackage.SSTEREOTYPE_CONTAINER__SSTEREOTYPES, SaltCorePackage.SSTEREOTYPE__SPROJECT);
		}
		return sStereotypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SStereotype getSStereotypeByName(String sStereotypeName) 
	{
		SStereotype retVal= null;
		for (SStereotype stereotype: this.getSStereotypes())
		{
			if (stereotype.getName().equalsIgnoreCase(sStereotypeName))
			{	
				retVal= stereotype;
				break;
			}
		}
		return(retVal);
	}

	private static final String KW_STEREOTYPE_NAMES=	"salt.stereotypes.names";
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSStereotypes(Properties properties) 
	{
		if (properties== null)
			throw new NullPointerException(MSG_ERR + "Cannot set stereotypes, because the given properties object is empty.");
		
		String stereotypeNamesText= properties.getProperty(KW_STEREOTYPE_NAMES);
		if ((stereotypeNamesText== null) || (stereotypeNamesText.equalsIgnoreCase("")))
			throw new NullPointerException(MSG_ERR + "Cannot set stereotypes, because the name definition ("+KW_STEREOTYPE_NAMES+") is empty.");
		
		String[] stereotypeNames= stereotypeNamesText.trim().split(",");
		if (stereotypeNames.length== 0)
			throw new NullPointerException(MSG_ERR + "Cannot set stereotypes, because the name definition ("+KW_STEREOTYPE_NAMES+") is empty.");
		
		SStereotype sStereotype= null;
		for (String stereoTypeName : stereotypeNames)
		{
			sStereotype= SaltCoreFactory.eINSTANCE.createSStereotype();
			sStereotype.setName(stereoTypeName.trim());
			this.getSStereotypes().add(sStereotype);
		}
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
			case SaltCorePackage.SSTEREOTYPE_CONTAINER__SSTEREOTYPES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSStereotypes()).basicAdd(otherEnd, msgs);
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
			case SaltCorePackage.SSTEREOTYPE_CONTAINER__SSTEREOTYPES:
				return ((InternalEList<?>)getSStereotypes()).basicRemove(otherEnd, msgs);
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
			case SaltCorePackage.SSTEREOTYPE_CONTAINER__SSTEREOTYPES:
				return getSStereotypes();
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
			case SaltCorePackage.SSTEREOTYPE_CONTAINER__SSTEREOTYPES:
				getSStereotypes().clear();
				getSStereotypes().addAll((Collection<? extends SStereotype>)newValue);
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
			case SaltCorePackage.SSTEREOTYPE_CONTAINER__SSTEREOTYPES:
				getSStereotypes().clear();
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
			case SaltCorePackage.SSTEREOTYPE_CONTAINER__SSTEREOTYPES:
				return sStereotypes != null && !sStereotypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SStereotypeContainerImpl
