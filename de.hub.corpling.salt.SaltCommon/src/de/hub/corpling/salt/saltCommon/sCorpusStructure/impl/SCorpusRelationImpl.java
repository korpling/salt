/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sCorpusStructure.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage;
import de.hub.corpling.salt.saltCore.impl.SRelationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SCorpus Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusRelationImpl#getSSuperCorpus <em>SSuper Corpus</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusRelationImpl#getSSubCorpus <em>SSub Corpus</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusRelationImpl#getSCorpusGraph <em>SCorpus Graph</em>}</li>
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
		return SCorpusStructurePackage.Literals.SCORPUS_RELATION;
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
		SCorpus retVal= null;
		if (super.getSSource() instanceof SCorpus)
			retVal= (SCorpus) super.getSource();
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSSuperCorpus(SCorpus newSSuperCorpus) 
	{
		super.setSource(newSSuperCorpus);
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
		SCorpus retVal= null;
		if (super.getSTarget() instanceof SCorpus)
			retVal= (SCorpus) super.getTarget();
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSSubCorpus(SCorpus newSSubCorpus) 
	{
		super.setSTarget(newSSubCorpus);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SCorpusGraph getSCorpusGraph() 
	{
		SCorpusGraph retVal= null;
		if (super.getSGraph() instanceof SCorpusGraph)
			retVal= (SCorpusGraph) super.getSGraph();
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSCorpusGraph(SCorpusGraph newSCorpusGraph) 
	{
		super.setSGraph(newSCorpusGraph);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SCorpusStructurePackage.SCORPUS_RELATION__SCORPUS_GRAPH:
				return eInternalContainer().eInverseRemove(this, SCorpusStructurePackage.SCORPUS_GRAPH__SCORPUS_RELATIONS, SCorpusGraph.class, msgs);
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
			case SCorpusStructurePackage.SCORPUS_RELATION__SSUPER_CORPUS:
				if (resolve) return getSSuperCorpus();
				return basicGetSSuperCorpus();
			case SCorpusStructurePackage.SCORPUS_RELATION__SSUB_CORPUS:
				if (resolve) return getSSubCorpus();
				return basicGetSSubCorpus();
			case SCorpusStructurePackage.SCORPUS_RELATION__SCORPUS_GRAPH:
				return getSCorpusGraph();
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
			case SCorpusStructurePackage.SCORPUS_RELATION__SSUPER_CORPUS:
				setSSuperCorpus((SCorpus)newValue);
				return;
			case SCorpusStructurePackage.SCORPUS_RELATION__SSUB_CORPUS:
				setSSubCorpus((SCorpus)newValue);
				return;
			case SCorpusStructurePackage.SCORPUS_RELATION__SCORPUS_GRAPH:
				setSCorpusGraph((SCorpusGraph)newValue);
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
			case SCorpusStructurePackage.SCORPUS_RELATION__SSUPER_CORPUS:
				setSSuperCorpus((SCorpus)null);
				return;
			case SCorpusStructurePackage.SCORPUS_RELATION__SSUB_CORPUS:
				setSSubCorpus((SCorpus)null);
				return;
			case SCorpusStructurePackage.SCORPUS_RELATION__SCORPUS_GRAPH:
				setSCorpusGraph((SCorpusGraph)null);
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
			case SCorpusStructurePackage.SCORPUS_RELATION__SSUPER_CORPUS:
				return basicGetSSuperCorpus() != null;
			case SCorpusStructurePackage.SCORPUS_RELATION__SSUB_CORPUS:
				return basicGetSSubCorpus() != null;
			case SCorpusStructurePackage.SCORPUS_RELATION__SCORPUS_GRAPH:
				return getSCorpusGraph() != null;
		}
		return super.eIsSet(featureID);
	}

} //SCorpusRelationImpl
