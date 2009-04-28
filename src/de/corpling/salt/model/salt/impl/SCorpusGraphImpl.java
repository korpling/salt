/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.salt.impl;


import de.corpling.salt.model.saltCore.SElement;
import de.corpling.salt.model.saltCore.SStereotype;
import de.corpling.salt.model.saltCore.impl.SGraphImpl;
import de.corpling.salt.model.salt.SCorpus;
import de.corpling.salt.model.salt.SCorpusGraph;
import de.corpling.salt.model.salt.SCorpusRelation;
import de.corpling.salt.model.salt.SDocument;
import de.corpling.salt.model.salt.SSTEREOTYPES;
import de.corpling.salt.model.salt.SaltPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SCorpus Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.corpling.salt.model.salt.impl.SCorpusGraphImpl#getSCorpora <em>SCorpora</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.impl.SCorpusGraphImpl#getSDocuments <em>SDocuments</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.impl.SCorpusGraphImpl#getSCorpusRelations <em>SCorpus Relations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SCorpusGraphImpl extends SGraphImpl implements SCorpusGraph 
{
	private static final String MSG_ERR=	"Error("+SCorpusGraphImpl.class+"): ";
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SCorpusGraphImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltPackage.Literals.SCORPUS_GRAPH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	public EList<SCorpus> getSCorpora() 
	{
		if (this.getSCoreProject()== null)
			throw new NullPointerException(MSG_ERR + "Cannot return corpora, because project isn´t set.");
		EList<SCorpus> retList= null;
		SStereotype sStereotype= this.getSCoreProject().getSStereotypeByName(SSTEREOTYPES.SCORPUS.getName());
		retList= (EList<SCorpus>)(EList<? extends SElement>)this.getSElementsByStereotype(sStereotype);
		return(retList);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	public EList<SDocument> getSDocuments() 
	{
		if (this.getSCoreProject()== null)
			throw new NullPointerException(MSG_ERR + "Cannot return documents, because project isn´t set.");
		EList<SDocument> retList= null;
		SStereotype sStereotype= this.getSCoreProject().getSStereotypeByName(SSTEREOTYPES.SDOCUMENT.getName());
		retList= (EList<SDocument>)(EList<? extends SElement>)this.getSElementsByStereotype(sStereotype);
		return(retList);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SCorpusRelation> getSCorpusRelations() {
		// TODO: implement this method to return the 'SCorpus Relations' containment reference list
		// Ensure that you remove @generated or mark it @generated NOT
		// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
		// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SaltPackage.SCORPUS_GRAPH__SCORPORA:
				return ((InternalEList<?>)getSCorpora()).basicRemove(otherEnd, msgs);
			case SaltPackage.SCORPUS_GRAPH__SDOCUMENTS:
				return ((InternalEList<?>)getSDocuments()).basicRemove(otherEnd, msgs);
			case SaltPackage.SCORPUS_GRAPH__SCORPUS_RELATIONS:
				return ((InternalEList<?>)getSCorpusRelations()).basicRemove(otherEnd, msgs);
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
			case SaltPackage.SCORPUS_GRAPH__SCORPORA:
				return getSCorpora();
			case SaltPackage.SCORPUS_GRAPH__SDOCUMENTS:
				return getSDocuments();
			case SaltPackage.SCORPUS_GRAPH__SCORPUS_RELATIONS:
				return getSCorpusRelations();
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
			case SaltPackage.SCORPUS_GRAPH__SCORPORA:
				getSCorpora().clear();
				getSCorpora().addAll((Collection<? extends SCorpus>)newValue);
				return;
			case SaltPackage.SCORPUS_GRAPH__SDOCUMENTS:
				getSDocuments().clear();
				getSDocuments().addAll((Collection<? extends SDocument>)newValue);
				return;
			case SaltPackage.SCORPUS_GRAPH__SCORPUS_RELATIONS:
				getSCorpusRelations().clear();
				getSCorpusRelations().addAll((Collection<? extends SCorpusRelation>)newValue);
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
			case SaltPackage.SCORPUS_GRAPH__SCORPORA:
				getSCorpora().clear();
				return;
			case SaltPackage.SCORPUS_GRAPH__SDOCUMENTS:
				getSDocuments().clear();
				return;
			case SaltPackage.SCORPUS_GRAPH__SCORPUS_RELATIONS:
				getSCorpusRelations().clear();
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
			case SaltPackage.SCORPUS_GRAPH__SCORPORA:
				return !getSCorpora().isEmpty();
			case SaltPackage.SCORPUS_GRAPH__SDOCUMENTS:
				return !getSDocuments().isEmpty();
			case SaltPackage.SCORPUS_GRAPH__SCORPUS_RELATIONS:
				return !getSCorpusRelations().isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SCorpusGraphImpl
