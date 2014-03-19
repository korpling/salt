/**
 * Copyright 2009 Humboldt University of Berlin, INRIA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltImproperSTypeException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructuredNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SRelationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SPointing Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SPointingRelationImpl#getSStructuredSource <em>SStructured Source</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SPointingRelationImpl#getSStructuredTarget <em>SStructured Target</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SPointingRelationImpl#getSDocumentGraph <em>SDocument Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SPointingRelationImpl extends SRelationImpl implements SPointingRelation {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3020513150162819963L;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SPointingRelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDocumentStructurePackage.Literals.SPOINTING_RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SStructuredNode getSStructuredSource() {
		SStructuredNode sStructuredSource = basicGetSStructuredSource();
		return sStructuredSource != null && sStructuredSource.eIsProxy() ? (SStructuredNode)eResolveProxy((InternalEObject)sStructuredSource) : sStructuredSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SStructuredNode basicGetSStructuredSource() 
	{
		SStructuredNode retVal= null;
		if (super.getSSource() instanceof SStructuredNode)
			retVal= (SStructuredNode) super.getSource();
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSStructuredSource(SStructuredNode newSStructuredSource) 
	{
		super.setSSource(newSStructuredSource);
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
	public void setSSource(SNode sSource) {
		if (sSource instanceof SStructuredNode) {
			this.setSStructuredSource((SStructuredNode)sSource);
		}
		else {
			throw new SaltImproperSTypeException("Parameter for SPointingRelation.setSSource must be an instance of a class inherited from SStructuredNode (SToken, SSpan or SStructure).");
		}
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSTarget(SNode sTarget) {
		if (sTarget instanceof SStructuredNode) {
			this.setSStructuredTarget((SStructuredNode)sTarget);
		}
		else {
			throw new SaltImproperSTypeException("Parameter for STextualRelation.setSTarget must be an instance of a class inherited from SStructuredNode (SToken, SSpan or SStructure).");
		}
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
			case SDocumentStructurePackage.SPOINTING_RELATION__SDOCUMENT_GRAPH:
				return eInternalContainer().eInverseRemove(this, SDocumentStructurePackage.SDOCUMENT_GRAPH__SPOINTING_RELATIONS, SDocumentGraph.class, msgs);
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
			case SDocumentStructurePackage.SPOINTING_RELATION__SSTRUCTURED_SOURCE:
				if (resolve) return getSStructuredSource();
				return basicGetSStructuredSource();
			case SDocumentStructurePackage.SPOINTING_RELATION__SSTRUCTURED_TARGET:
				if (resolve) return getSStructuredTarget();
				return basicGetSStructuredTarget();
			case SDocumentStructurePackage.SPOINTING_RELATION__SDOCUMENT_GRAPH:
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
			case SDocumentStructurePackage.SPOINTING_RELATION__SSTRUCTURED_SOURCE:
				setSStructuredSource((SStructuredNode)newValue);
				return;
			case SDocumentStructurePackage.SPOINTING_RELATION__SSTRUCTURED_TARGET:
				setSStructuredTarget((SStructuredNode)newValue);
				return;
			case SDocumentStructurePackage.SPOINTING_RELATION__SDOCUMENT_GRAPH:
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
			case SDocumentStructurePackage.SPOINTING_RELATION__SSTRUCTURED_SOURCE:
				setSStructuredSource((SStructuredNode)null);
				return;
			case SDocumentStructurePackage.SPOINTING_RELATION__SSTRUCTURED_TARGET:
				setSStructuredTarget((SStructuredNode)null);
				return;
			case SDocumentStructurePackage.SPOINTING_RELATION__SDOCUMENT_GRAPH:
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
			case SDocumentStructurePackage.SPOINTING_RELATION__SSTRUCTURED_SOURCE:
				return basicGetSStructuredSource() != null;
			case SDocumentStructurePackage.SPOINTING_RELATION__SSTRUCTURED_TARGET:
				return basicGetSStructuredTarget() != null;
			case SDocumentStructurePackage.SPOINTING_RELATION__SDOCUMENT_GRAPH:
				return getSDocumentGraph() != null;
		}
		return super.eIsSet(featureID);
	}

} //SPointingRelationImpl
