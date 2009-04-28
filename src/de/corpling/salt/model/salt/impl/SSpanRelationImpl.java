/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.salt.impl;


import de.corpling.salt.model.saltCore.impl.SRelationImpl;
import de.corpling.salt.model.salt.SDocumentGraph;
import de.corpling.salt.model.salt.SSpanRelation;
import de.corpling.salt.model.salt.SStructure;
import de.corpling.salt.model.salt.SToken;
import de.corpling.salt.model.salt.SaltPackage;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SSpan Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.corpling.salt.model.salt.impl.SSpanRelationImpl#getSDocumentGraph <em>SDocument Graph</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.impl.SSpanRelationImpl#getSStructure <em>SStructure</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.impl.SSpanRelationImpl#getSToken <em>SToken</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SSpanRelationImpl extends SRelationImpl implements SSpanRelation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SSpanRelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltPackage.Literals.SSPAN_RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SDocumentGraph getSDocumentGraph() 
	{
		return((SDocumentGraph) super.getSGraph());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSDocumentGraph(SDocumentGraph newSDocumentGraph) 
	{
		super.setSGraph(newSDocumentGraph);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SStructure getSStructure() {
		SStructure sStructure = basicGetSStructure();
		return sStructure != null && sStructure.eIsProxy() ? (SStructure)eResolveProxy((InternalEObject)sStructure) : sStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SStructure basicGetSStructure() 
	{
		return((SStructure) super.getSSourceElement());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSStructure(SStructure newSStructure) 
	{
		super.setSSourceElement(newSStructure);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SToken getSToken() {
		SToken sToken = basicGetSToken();
		return sToken != null && sToken.eIsProxy() ? (SToken)eResolveProxy((InternalEObject)sToken) : sToken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SToken basicGetSToken() 
	{
		return((SToken)super.getSDestinationElement());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSToken(SToken newSToken) 
	{
		super.setSDestinationElement(newSToken);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case SaltPackage.SSPAN_RELATION__SDOCUMENT_GRAPH:
				return eInternalContainer().eInverseRemove(this, SaltPackage.SDOCUMENT_GRAPH__SPAN_RELATIONS, SDocumentGraph.class, msgs);
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
			case SaltPackage.SSPAN_RELATION__SDOCUMENT_GRAPH:
				return getSDocumentGraph();
			case SaltPackage.SSPAN_RELATION__SSTRUCTURE:
				if (resolve) return getSStructure();
				return basicGetSStructure();
			case SaltPackage.SSPAN_RELATION__STOKEN:
				if (resolve) return getSToken();
				return basicGetSToken();
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
			case SaltPackage.SSPAN_RELATION__SDOCUMENT_GRAPH:
				setSDocumentGraph((SDocumentGraph)newValue);
				return;
			case SaltPackage.SSPAN_RELATION__SSTRUCTURE:
				setSStructure((SStructure)newValue);
				return;
			case SaltPackage.SSPAN_RELATION__STOKEN:
				setSToken((SToken)newValue);
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
			case SaltPackage.SSPAN_RELATION__SDOCUMENT_GRAPH:
				setSDocumentGraph((SDocumentGraph)null);
				return;
			case SaltPackage.SSPAN_RELATION__SSTRUCTURE:
				setSStructure((SStructure)null);
				return;
			case SaltPackage.SSPAN_RELATION__STOKEN:
				setSToken((SToken)null);
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
			case SaltPackage.SSPAN_RELATION__SDOCUMENT_GRAPH:
				return getSDocumentGraph() != null;
			case SaltPackage.SSPAN_RELATION__SSTRUCTURE:
				return basicGetSStructure() != null;
			case SaltPackage.SSPAN_RELATION__STOKEN:
				return basicGetSToken() != null;
		}
		return super.eIsSet(featureID);
	}

} //SSpanRelationImpl
