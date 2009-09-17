/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>STextual DS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextualDSImpl#getSText <em>SText</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextualDSImpl#getSDocumentGraph <em>SDocument Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class STextualDSImpl extends SSequentialDSImpl implements STextualDS {
	/**
	 * The default value of the '{@link #getSText() <em>SText</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSText()
	 * @generated
	 * @ordered
	 */
	protected static final String STEXT_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected STextualDSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDocumentStructurePackage.Literals.STEXTUAL_DS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public String getSText() 
	{
		String retVal= null;
		if (super.getSData() instanceof String)
			retVal= (String) super.getSData();
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSText(String newSText) 
	{
		super.setSData(newSText);
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
			case SDocumentStructurePackage.STEXTUAL_DS__SDOCUMENT_GRAPH:
				return eInternalContainer().eInverseRemove(this, SDocumentStructurePackage.SDOCUMENT_GRAPH__STEXTUAL_DSS, SDocumentGraph.class, msgs);
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
			case SDocumentStructurePackage.STEXTUAL_DS__STEXT:
				return getSText();
			case SDocumentStructurePackage.STEXTUAL_DS__SDOCUMENT_GRAPH:
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
			case SDocumentStructurePackage.STEXTUAL_DS__STEXT:
				setSText((String)newValue);
				return;
			case SDocumentStructurePackage.STEXTUAL_DS__SDOCUMENT_GRAPH:
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
			case SDocumentStructurePackage.STEXTUAL_DS__STEXT:
				setSText(STEXT_EDEFAULT);
				return;
			case SDocumentStructurePackage.STEXTUAL_DS__SDOCUMENT_GRAPH:
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
			case SDocumentStructurePackage.STEXTUAL_DS__STEXT:
				return STEXT_EDEFAULT == null ? getSText() != null : !STEXT_EDEFAULT.equals(getSText());
			case SDocumentStructurePackage.STEXTUAL_DS__SDOCUMENT_GRAPH:
				return getSDocumentGraph() != null;
		}
		return super.eIsSet(featureID);
	}

} //STextualDSImpl
