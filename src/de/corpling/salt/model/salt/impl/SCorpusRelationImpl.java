/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.salt.impl;


import de.corpling.salt.model.saltCore.impl.SRelationImpl;
import de.corpling.salt.model.salt.SCorpus;
import de.corpling.salt.model.salt.SCorpusRelation;
import de.corpling.salt.model.salt.SaltPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SCorpus Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.corpling.salt.model.salt.impl.SCorpusRelationImpl#getSSuperCorpus <em>SSuper Corpus</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.impl.SCorpusRelationImpl#getSSubCorpus <em>SSub Corpus</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SCorpusRelationImpl extends SRelationImpl implements SCorpusRelation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SCorpusRelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltPackage.Literals.SCORPUS_RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCorpus getSSuperCorpus() {
		SCorpus sSuperCorpus = basicGetSSuperCorpus();
		return sSuperCorpus != null && sSuperCorpus.eIsProxy() ? (SCorpus)eResolveProxy((InternalEObject)sSuperCorpus) : sSuperCorpus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SCorpus basicGetSSuperCorpus() 
	{
		return((SCorpus)super.getSSourceElement());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSSuperCorpus(SCorpus newSSuperCorpus) 
	{
		super.setSSourceElement(newSSuperCorpus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCorpus getSSubCorpus() {
		SCorpus sSubCorpus = basicGetSSubCorpus();
		return sSubCorpus != null && sSubCorpus.eIsProxy() ? (SCorpus)eResolveProxy((InternalEObject)sSubCorpus) : sSubCorpus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SCorpus basicGetSSubCorpus() 
	{
		return((SCorpus)super.getSDestinationElement());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSSubCorpus(SCorpus newSSubCorpus) 
	{
		super.setSDestinationElement(newSSubCorpus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SaltPackage.SCORPUS_RELATION__SSUPER_CORPUS:
				if (resolve) return getSSuperCorpus();
				return basicGetSSuperCorpus();
			case SaltPackage.SCORPUS_RELATION__SSUB_CORPUS:
				if (resolve) return getSSubCorpus();
				return basicGetSSubCorpus();
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
			case SaltPackage.SCORPUS_RELATION__SSUPER_CORPUS:
				setSSuperCorpus((SCorpus)newValue);
				return;
			case SaltPackage.SCORPUS_RELATION__SSUB_CORPUS:
				setSSubCorpus((SCorpus)newValue);
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
			case SaltPackage.SCORPUS_RELATION__SSUPER_CORPUS:
				setSSuperCorpus((SCorpus)null);
				return;
			case SaltPackage.SCORPUS_RELATION__SSUB_CORPUS:
				setSSubCorpus((SCorpus)null);
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
			case SaltPackage.SCORPUS_RELATION__SSUPER_CORPUS:
				return basicGetSSuperCorpus() != null;
			case SaltPackage.SCORPUS_RELATION__SSUB_CORPUS:
				return basicGetSSubCorpus() != null;
		}
		return super.eIsSet(featureID);
	}

} //SCorpusRelationImpl
