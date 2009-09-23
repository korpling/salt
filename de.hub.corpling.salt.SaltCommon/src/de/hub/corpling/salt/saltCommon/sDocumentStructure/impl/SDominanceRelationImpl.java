/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDominanceRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SStructure;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SStructuredNode;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.accessors.STimeOverlappingRelationAccessor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SDominance Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDominanceRelationImpl#getSStructure <em>SStructure</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDominanceRelationImpl#getSStructuredTarget <em>SStructured Target</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDominanceRelationImpl#getSDocumentGraph <em>SDocument Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SDominanceRelationImpl extends STextOverlappingRelationImpl implements SDominanceRelation {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected SDominanceRelationImpl() {
		super();
		init();
	}
	
	private void init()
	{
		this.sTimeOverlappingRelAccessor= new STimeOverlappingRelationAccessor();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDocumentStructurePackage.Literals.SDOMINANCE_RELATION;
	}

// ======================= start: delegating for feature textOverlapping	
	/**
	 * delegatee for textoverlapping
	 */
	private STimeOverlappingRelationAccessor sTimeOverlappingRelAccessor= null; 
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Boolean isSTimeOverlapping() 
	{
		return(this.sTimeOverlappingRelAccessor.isSTimeOverlapping(this));
	}
// ======================= end: delegating for feature textOverlapping
	
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
		SStructure retVal= null;
		if (super.getSource() instanceof SStructure)
			retVal= (SStructure) super.getSource();
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSStructure(SStructure newSStructure) 
	{
		super.setSSource(newSStructure);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SStructuredNode getSStructuredTarget() {
		SStructuredNode sStructuredTarget = basicGetSStructuredTarget();
		return sStructuredTarget != null && sStructuredTarget.eIsProxy() ? (SStructuredNode)eResolveProxy((InternalEObject)sStructuredTarget) : sStructuredTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SStructuredNode basicGetSStructuredTarget() 
	{
		SStructuredNode retVal= null;
		if (super.getSTarget() instanceof SStructuredNode)
			retVal= (SStructuredNode) super.getTarget();
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSStructuredTarget(SStructuredNode newSStructuredTarget) 
	{
		super.setSTarget(newSStructuredTarget);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SDocumentGraph getSDocumentGraph() 
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SDocumentStructurePackage.SDOMINANCE_RELATION__SDOCUMENT_GRAPH:
				return eInternalContainer().eInverseRemove(this, SDocumentStructurePackage.SDOCUMENT_GRAPH__SDOMINANCE_RELATIONS, SDocumentGraph.class, msgs);
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
			case SDocumentStructurePackage.SDOMINANCE_RELATION__SSTRUCTURE:
				if (resolve) return getSStructure();
				return basicGetSStructure();
			case SDocumentStructurePackage.SDOMINANCE_RELATION__SSTRUCTURED_TARGET:
				if (resolve) return getSStructuredTarget();
				return basicGetSStructuredTarget();
			case SDocumentStructurePackage.SDOMINANCE_RELATION__SDOCUMENT_GRAPH:
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
			case SDocumentStructurePackage.SDOMINANCE_RELATION__SSTRUCTURE:
				setSStructure((SStructure)newValue);
				return;
			case SDocumentStructurePackage.SDOMINANCE_RELATION__SSTRUCTURED_TARGET:
				setSStructuredTarget((SStructuredNode)newValue);
				return;
			case SDocumentStructurePackage.SDOMINANCE_RELATION__SDOCUMENT_GRAPH:
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
			case SDocumentStructurePackage.SDOMINANCE_RELATION__SSTRUCTURE:
				setSStructure((SStructure)null);
				return;
			case SDocumentStructurePackage.SDOMINANCE_RELATION__SSTRUCTURED_TARGET:
				setSStructuredTarget((SStructuredNode)null);
				return;
			case SDocumentStructurePackage.SDOMINANCE_RELATION__SDOCUMENT_GRAPH:
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
			case SDocumentStructurePackage.SDOMINANCE_RELATION__SSTRUCTURE:
				return basicGetSStructure() != null;
			case SDocumentStructurePackage.SDOMINANCE_RELATION__SSTRUCTURED_TARGET:
				return basicGetSStructuredTarget() != null;
			case SDocumentStructurePackage.SDOMINANCE_RELATION__SDOCUMENT_GRAPH:
				return getSDocumentGraph() != null;
		}
		return super.eIsSet(featureID);
	}

} //SDominanceRelationImpl
