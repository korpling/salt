/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.salt.impl;

import de.corpling.salt.model.saltCore.SStereotype;
import de.corpling.salt.model.saltCore.impl.SCoreProjectImpl;
import de.corpling.salt.model.salt.SCorpusGraph;
import de.corpling.salt.model.salt.SDocumentGraph;
import de.corpling.salt.model.salt.SProject;
import de.corpling.salt.model.salt.SSTEREOTYPES;
import de.corpling.salt.model.salt.SaltPackage;
import de.corpling.salt.model.saltCore.SaltCorePackage;
import de.corpling.salt.model.saltCore.SGraph;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SProject</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.corpling.salt.model.salt.impl.SProjectImpl#getSCorpusGraphs <em>SCorpus Graphs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SProjectImpl extends SCoreProjectImpl implements SProject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltPackage.Literals.SPROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	public EList<SCorpusGraph> getSCorpusGraphs() 
	{
		return((EList<SCorpusGraph>) (EList<? extends SGraph>)this.getSGraphs());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SStereotype getSStereotypeByEnum(SSTEREOTYPES sStereotypeEnum) 
	{
		SStereotype retVal= null;
		for (SStereotype sStereotype: this.getSStereotypes())
		{
			if (sStereotype.getName().equalsIgnoreCase(sStereotypeEnum.toString()))
			{
				retVal= sStereotype;
				break;
			}
		}
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SaltPackage.SPROJECT__SCORPUS_GRAPHS:
				return ((InternalEList<?>)getSCorpusGraphs()).basicRemove(otherEnd, msgs);
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
			case SaltPackage.SPROJECT__SCORPUS_GRAPHS:
				return getSCorpusGraphs();
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
			case SaltPackage.SPROJECT__SCORPUS_GRAPHS:
				getSCorpusGraphs().clear();
				getSCorpusGraphs().addAll((Collection<? extends SCorpusGraph>)newValue);
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
			case SaltPackage.SPROJECT__SCORPUS_GRAPHS:
				getSCorpusGraphs().clear();
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
			case SaltPackage.SPROJECT__SCORPUS_GRAPHS:
				return !getSCorpusGraphs().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EList<SDocumentGraph> getSDocumentGraphs() 
	{
		EList<SDocumentGraph> retList= null;
		EList<SDocumentGraph> sDocumentGraphs= new BasicEList<SDocumentGraph>();
		for (SGraph sGraph: super.getSGraphs())
		{
			if (SDocumentGraph.class.isInstance(sGraph))
				sDocumentGraphs.add((SDocumentGraph)sGraph);
		}
		retList= new EcoreEList.UnmodifiableEList<SDocumentGraph>(this, SaltCorePackage.eINSTANCE.getSGraph_SCoreProject(), sDocumentGraphs.size(), sDocumentGraphs.toArray());
		return(retList);
	}

} //SProjectImpl
