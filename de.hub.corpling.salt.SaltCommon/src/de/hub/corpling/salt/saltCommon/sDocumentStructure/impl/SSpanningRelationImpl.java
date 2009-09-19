/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure.impl;

import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SSpan;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SSpanningRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken;

import de.hub.corpling.salt.saltCore.impl.SRelationImpl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SSpanning Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SSpanningRelationImpl#getSToken <em>SToken</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SSpanningRelationImpl#getSSpan <em>SSpan</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SSpanningRelationImpl#getSDocumentGraph <em>SDocument Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SSpanningRelationImpl extends SRelationImpl implements SSpanningRelation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SSpanningRelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDocumentStructurePackage.Literals.SSPANNING_RELATION;
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
		SToken retVal= null;
		if (super.getSTarget() instanceof SToken)
			retVal= (SToken) super.getTarget();
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSToken(SToken newSToken) 
	{
		super.setSTarget(newSToken);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SSpan getSSpan() {
		SSpan sSpan = basicGetSSpan();
		return sSpan != null && sSpan.eIsProxy() ? (SSpan)eResolveProxy((InternalEObject)sSpan) : sSpan;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SSpan basicGetSSpan() 
	{
		SSpan retVal= null;
		if (super.getSSource() instanceof SSpan)
			retVal= (SSpan) super.getSource();
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSSpan(SSpan newSSpan) 
	{
		super.setSSource(newSSpan);
	}

	/**
	 * Returns the document-graph, to which this object contains.
	 * @return containing document graph 
	 */
	public SDocumentGraph getSDocumentGraph() 
	{
		SDocumentGraph retVal= null;
		if (super.getSGraph() instanceof SDocumentGraph)
			retVal= (SDocumentGraph) super.getSGraph();
		return(retVal);
	}

	/**
	 * Sets the document graph, to which this object contains.
	 * @param newSDocumentGraph the document graph
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
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SDocumentStructurePackage.SSPANNING_RELATION__SDOCUMENT_GRAPH:
				return eInternalContainer().eInverseRemove(this, SDocumentStructurePackage.SDOCUMENT_GRAPH__SSPANNING_RELATIONS, SDocumentGraph.class, msgs);
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
			case SDocumentStructurePackage.SSPANNING_RELATION__STOKEN:
				if (resolve) return getSToken();
				return basicGetSToken();
			case SDocumentStructurePackage.SSPANNING_RELATION__SSPAN:
				if (resolve) return getSSpan();
				return basicGetSSpan();
			case SDocumentStructurePackage.SSPANNING_RELATION__SDOCUMENT_GRAPH:
				return getSDocumentGraph();
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
			case SDocumentStructurePackage.SSPANNING_RELATION__STOKEN:
				setSToken((SToken)newValue);
				return;
			case SDocumentStructurePackage.SSPANNING_RELATION__SSPAN:
				setSSpan((SSpan)newValue);
				return;
			case SDocumentStructurePackage.SSPANNING_RELATION__SDOCUMENT_GRAPH:
				setSDocumentGraph((SDocumentGraph)newValue);
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
			case SDocumentStructurePackage.SSPANNING_RELATION__STOKEN:
				setSToken((SToken)null);
				return;
			case SDocumentStructurePackage.SSPANNING_RELATION__SSPAN:
				setSSpan((SSpan)null);
				return;
			case SDocumentStructurePackage.SSPANNING_RELATION__SDOCUMENT_GRAPH:
				setSDocumentGraph((SDocumentGraph)null);
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
			case SDocumentStructurePackage.SSPANNING_RELATION__STOKEN:
				return basicGetSToken() != null;
			case SDocumentStructurePackage.SSPANNING_RELATION__SSPAN:
				return basicGetSSpan() != null;
			case SDocumentStructurePackage.SSPANNING_RELATION__SDOCUMENT_GRAPH:
				return getSDocumentGraph() != null;
		}
		return super.eIsSet(featureID);
	}

} //SSpanningRelationImpl
