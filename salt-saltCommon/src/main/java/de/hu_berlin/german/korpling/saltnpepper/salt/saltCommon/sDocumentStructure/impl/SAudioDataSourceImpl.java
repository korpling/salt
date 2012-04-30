/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonPackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDataSource;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SAudio Data Source</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SAudioDataSourceImpl#getSDocumentGraph <em>SDocument Graph</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SAudioDataSourceImpl#getSAudioReference <em>SAudio Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SAudioDataSourceImpl extends SSequentialDSImpl implements SAudioDataSource {
	/**
	 * The default value of the '{@link #getSAudioReference() <em>SAudio Reference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSAudioReference()
	 * @generated
	 * @ordered
	 */
	protected static final URI SAUDIO_REFERENCE_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SAudioDataSourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDocumentStructurePackage.Literals.SAUDIO_DATA_SOURCE;
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
	 * {@inheritDoc SAudioDataSource#getSAudioReference()}
	 */
	public URI getSAudioReference() {
		URI retVal= null;
		String name= SaltCommonPackage.eNS_PREFIX + "::" + FEAT_SAUDIO_REFERNCE;
		SFeature sFeature= this.getSFeature(name);
		if (sFeature!= null)
		{
			retVal= URI.createURI(sFeature.getSValue().toString());
		}
		return(retVal);
	}

	/**
	 * {@inheritDoc SAudioDataSource#setSAudioReference(URI)}
	 */
	public void setSAudioReference(URI newSAudioReference) {
		String name= SaltCommonPackage.eNS_PREFIX + "::" + FEAT_SAUDIO_REFERNCE; 
		SFeature sFeature= this.getSFeature(name);
		if (sFeature== null)
		{//create a new sFeature
			sFeature= SaltCommonFactory.eINSTANCE.createSFeature();
			sFeature.setSNS(SaltCommonPackage.eNS_PREFIX);
			sFeature.setSName(FEAT_SAUDIO_REFERNCE);
			this.addSFeature(sFeature);
		}	
		sFeature.setSValue(newSAudioReference);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SDocumentStructurePackage.SAUDIO_DATA_SOURCE__SDOCUMENT_GRAPH:
				return eInternalContainer().eInverseRemove(this, SDocumentStructurePackage.SDOCUMENT_GRAPH__SAUDIO_DATA_SOURCES, SDocumentGraph.class, msgs);
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
			case SDocumentStructurePackage.SAUDIO_DATA_SOURCE__SDOCUMENT_GRAPH:
				return getSDocumentGraph();
			case SDocumentStructurePackage.SAUDIO_DATA_SOURCE__SAUDIO_REFERENCE:
				return getSAudioReference();
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
			case SDocumentStructurePackage.SAUDIO_DATA_SOURCE__SDOCUMENT_GRAPH:
				setSDocumentGraph((SDocumentGraph)newValue);
				return;
			case SDocumentStructurePackage.SAUDIO_DATA_SOURCE__SAUDIO_REFERENCE:
				setSAudioReference((URI)newValue);
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
			case SDocumentStructurePackage.SAUDIO_DATA_SOURCE__SDOCUMENT_GRAPH:
				setSDocumentGraph((SDocumentGraph)null);
				return;
			case SDocumentStructurePackage.SAUDIO_DATA_SOURCE__SAUDIO_REFERENCE:
				setSAudioReference(SAUDIO_REFERENCE_EDEFAULT);
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
			case SDocumentStructurePackage.SAUDIO_DATA_SOURCE__SDOCUMENT_GRAPH:
				return getSDocumentGraph() != null;
			case SDocumentStructurePackage.SAUDIO_DATA_SOURCE__SAUDIO_REFERENCE:
				return SAUDIO_REFERENCE_EDEFAULT == null ? getSAudioReference() != null : !SAUDIO_REFERENCE_EDEFAULT.equals(getSAudioReference());
		}
		return super.eIsSet(featureID);
	}

} //SAudioDataSourceImpl
