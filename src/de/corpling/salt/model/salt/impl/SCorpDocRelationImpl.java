/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.salt.impl;


import de.corpling.salt.model.saltCore.impl.SRelationImpl;
import de.corpling.salt.model.salt.SCorpDocRelation;
import de.corpling.salt.model.salt.SCorpus;
import de.corpling.salt.model.salt.SDocument;
import de.corpling.salt.model.salt.SaltPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SCorp Doc Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.corpling.salt.model.salt.impl.SCorpDocRelationImpl#getSCorpus <em>SCorpus</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.impl.SCorpDocRelationImpl#getSDocument <em>SDocument</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SCorpDocRelationImpl extends SRelationImpl implements SCorpDocRelation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SCorpDocRelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltPackage.Literals.SCORP_DOC_RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCorpus getSCorpus() {
		SCorpus sCorpus = basicGetSCorpus();
		return sCorpus != null && sCorpus.eIsProxy() ? (SCorpus)eResolveProxy((InternalEObject)sCorpus) : sCorpus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SCorpus basicGetSCorpus() 
	{
		return((SCorpus) super.getSSourceElement());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSCorpus(SCorpus newSCorpus) 
	{
		super.setSSourceElement(newSCorpus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SDocument getSDocument() {
		SDocument sDocument = basicGetSDocument();
		return sDocument != null && sDocument.eIsProxy() ? (SDocument)eResolveProxy((InternalEObject)sDocument) : sDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SDocument basicGetSDocument() 
	{
		return((SDocument) super.getSDestinationElement());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSDocument(SDocument newSDocument) 
	{
		super.setSDestinationElement(newSDocument);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SaltPackage.SCORP_DOC_RELATION__SCORPUS:
				if (resolve) return getSCorpus();
				return basicGetSCorpus();
			case SaltPackage.SCORP_DOC_RELATION__SDOCUMENT:
				if (resolve) return getSDocument();
				return basicGetSDocument();
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
			case SaltPackage.SCORP_DOC_RELATION__SCORPUS:
				setSCorpus((SCorpus)newValue);
				return;
			case SaltPackage.SCORP_DOC_RELATION__SDOCUMENT:
				setSDocument((SDocument)newValue);
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
			case SaltPackage.SCORP_DOC_RELATION__SCORPUS:
				setSCorpus((SCorpus)null);
				return;
			case SaltPackage.SCORP_DOC_RELATION__SDOCUMENT:
				setSDocument((SDocument)null);
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
			case SaltPackage.SCORP_DOC_RELATION__SCORPUS:
				return basicGetSCorpus() != null;
			case SaltPackage.SCORP_DOC_RELATION__SDOCUMENT:
				return basicGetSDocument() != null;
		}
		return super.eIsSet(featureID);
	}

} //SCorpDocRelationImpl
