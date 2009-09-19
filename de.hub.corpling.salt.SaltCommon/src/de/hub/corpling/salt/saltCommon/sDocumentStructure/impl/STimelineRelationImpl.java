/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeline;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STimelineRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>STimeline Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STimelineRelationImpl#getSTimeline <em>STimeline</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STimelineRelationImpl#getSToken <em>SToken</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STimelineRelationImpl#getSDocumentGraph <em>SDocument Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class STimelineRelationImpl extends SSequentialRelationImpl implements STimelineRelation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected STimelineRelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDocumentStructurePackage.Literals.STIMELINE_RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STimeline getSTimeline() {
		STimeline sTimeline = basicGetSTimeline();
		return sTimeline != null && sTimeline.eIsProxy() ? (STimeline)eResolveProxy((InternalEObject)sTimeline) : sTimeline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public STimeline basicGetSTimeline() 
	{
		STimeline retVal= null;
		if (super.getSTarget() instanceof STimeline)
			retVal= (STimeline) super.getSTarget();
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSTimeline(STimeline newSTimeline) 
	{
		super.setSTarget(newSTimeline);
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
		if (super.getSSource() instanceof SToken)
			retVal= (SToken) super.getSSource();
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSToken(SToken newSToken) 
	{
		super.setSSource(newSToken);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDocumentGraph getSDocumentGraph() {
		SDocumentGraph sDocumentGraph = basicGetSDocumentGraph();
		return sDocumentGraph != null && sDocumentGraph.eIsProxy() ? (SDocumentGraph)eResolveProxy((InternalEObject)sDocumentGraph) : sDocumentGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SDocumentGraph basicGetSDocumentGraph() 
	{
		SDocumentGraph retVal= null;
		if (super.getSGraph() instanceof SDocumentGraph)
			retVal= (SDocumentGraph) super.getSGraph();
		return(retVal);
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SDocumentStructurePackage.STIMELINE_RELATION__STIMELINE:
				if (resolve) return getSTimeline();
				return basicGetSTimeline();
			case SDocumentStructurePackage.STIMELINE_RELATION__STOKEN:
				if (resolve) return getSToken();
				return basicGetSToken();
			case SDocumentStructurePackage.STIMELINE_RELATION__SDOCUMENT_GRAPH:
				if (resolve) return getSDocumentGraph();
				return basicGetSDocumentGraph();
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
			case SDocumentStructurePackage.STIMELINE_RELATION__STIMELINE:
				setSTimeline((STimeline)newValue);
				return;
			case SDocumentStructurePackage.STIMELINE_RELATION__STOKEN:
				setSToken((SToken)newValue);
				return;
			case SDocumentStructurePackage.STIMELINE_RELATION__SDOCUMENT_GRAPH:
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
			case SDocumentStructurePackage.STIMELINE_RELATION__STIMELINE:
				setSTimeline((STimeline)null);
				return;
			case SDocumentStructurePackage.STIMELINE_RELATION__STOKEN:
				setSToken((SToken)null);
				return;
			case SDocumentStructurePackage.STIMELINE_RELATION__SDOCUMENT_GRAPH:
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
			case SDocumentStructurePackage.STIMELINE_RELATION__STIMELINE:
				return basicGetSTimeline() != null;
			case SDocumentStructurePackage.STIMELINE_RELATION__STOKEN:
				return basicGetSToken() != null;
			case SDocumentStructurePackage.STIMELINE_RELATION__SDOCUMENT_GRAPH:
				return basicGetSDocumentGraph() != null;
		}
		return super.eIsSet(featureID);
	}

} //STimelineRelationImpl
