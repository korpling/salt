/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.salt.impl;

import de.corpling.salt.model.salt.SDocumentGraph;
import de.corpling.salt.model.salt.STextualDataSource;
import de.corpling.salt.model.salt.SaltPackage;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>STextual Data Source</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.corpling.salt.model.salt.impl.STextualDataSourceImpl#getSText <em>SText</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.impl.STextualDataSourceImpl#getSDocumentGraph <em>SDocument Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class STextualDataSourceImpl extends SDataSourceImpl implements STextualDataSource {
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
	protected STextualDataSourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltPackage.Literals.STEXTUAL_DATA_SOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public String getSText() 
	{
		return((String)super.getSDataSource());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSText(String newText) 
	{
		super.setSDataSource(newText);
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
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case SaltPackage.STEXTUAL_DATA_SOURCE__SDOCUMENT_GRAPH:
				return eInternalContainer().eInverseRemove(this, SaltPackage.SDOCUMENT_GRAPH__STEXTUAL_DATA_SOURCES, SDocumentGraph.class, msgs);
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
			case SaltPackage.STEXTUAL_DATA_SOURCE__STEXT:
				return getSText();
			case SaltPackage.STEXTUAL_DATA_SOURCE__SDOCUMENT_GRAPH:
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
			case SaltPackage.STEXTUAL_DATA_SOURCE__STEXT:
				setSText((String)newValue);
				return;
			case SaltPackage.STEXTUAL_DATA_SOURCE__SDOCUMENT_GRAPH:
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
			case SaltPackage.STEXTUAL_DATA_SOURCE__STEXT:
				setSText(STEXT_EDEFAULT);
				return;
			case SaltPackage.STEXTUAL_DATA_SOURCE__SDOCUMENT_GRAPH:
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
			case SaltPackage.STEXTUAL_DATA_SOURCE__STEXT:
				return STEXT_EDEFAULT == null ? getSText() != null : !STEXT_EDEFAULT.equals(getSText());
			case SaltPackage.STEXTUAL_DATA_SOURCE__SDOCUMENT_GRAPH:
				return getSDocumentGraph() != null;
		}
		return super.eIsSet(featureID);
	}

} //STextualDataSourceImpl
