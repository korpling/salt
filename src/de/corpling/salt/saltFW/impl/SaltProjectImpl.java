/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.saltFW.impl;

import de.corpling.salt.model.salt.impl.SProjectImpl;
import de.corpling.salt.model.saltCore.SGraph;
import de.corpling.salt.saltFW.SaltFWPackage;
import de.corpling.salt.saltFW.SaltGraph;
import de.corpling.salt.saltFW.SaltModule;
import de.corpling.salt.saltFW.SaltProject;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.corpling.salt.saltFW.impl.SaltProjectImpl#getSaltGraphs <em>Salt Graphs</em>}</li>
 *   <li>{@link de.corpling.salt.saltFW.impl.SaltProjectImpl#getSModules <em>SModules</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SaltProjectImpl extends SProjectImpl implements SaltProject {
	/**
	 * The cached value of the '{@link #getSModules() <em>SModules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSModules()
	 * @generated
	 * @ordered
	 */
	protected EList<SaltModule> sModules;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected SaltProjectImpl() 
	{
		super();
		this.init();
	}
	
	private void init()
	{
		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltFWPackage.Literals.SALT_PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	public EList<SaltGraph> getSaltGraphs() 
	{
		return((EList<SaltGraph>)(EList<? extends SGraph>)super.getSGraphs());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SaltModule> getSModules() {
		if (sModules == null) {
			sModules = new EObjectContainmentWithInverseEList<SaltModule>(SaltModule.class, this, SaltFWPackage.SALT_PROJECT__SMODULES, SaltFWPackage.SALT_MODULE__SALT_PROJECT);
		}
		return sModules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) 
	{
		switch (featureID) {
			case SaltFWPackage.SALT_PROJECT__SMODULES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSModules()).basicAdd(otherEnd, msgs);
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
			case SaltFWPackage.SALT_PROJECT__SALT_GRAPHS:
				return ((InternalEList<?>)getSaltGraphs()).basicRemove(otherEnd, msgs);
			case SaltFWPackage.SALT_PROJECT__SMODULES:
				return ((InternalEList<?>)getSModules()).basicRemove(otherEnd, msgs);
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
			case SaltFWPackage.SALT_PROJECT__SALT_GRAPHS:
				return getSaltGraphs();
			case SaltFWPackage.SALT_PROJECT__SMODULES:
				return getSModules();
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
			case SaltFWPackage.SALT_PROJECT__SALT_GRAPHS:
				getSaltGraphs().clear();
				getSaltGraphs().addAll((Collection<? extends SaltGraph>)newValue);
				return;
			case SaltFWPackage.SALT_PROJECT__SMODULES:
				getSModules().clear();
				getSModules().addAll((Collection<? extends SaltModule>)newValue);
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
			case SaltFWPackage.SALT_PROJECT__SALT_GRAPHS:
				getSaltGraphs().clear();
				return;
			case SaltFWPackage.SALT_PROJECT__SMODULES:
				getSModules().clear();
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
			case SaltFWPackage.SALT_PROJECT__SALT_GRAPHS:
				return !getSaltGraphs().isEmpty();
			case SaltFWPackage.SALT_PROJECT__SMODULES:
				return sModules != null && !sModules.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SaltProjectImpl
