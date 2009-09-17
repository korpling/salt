/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure.impl;

import org.eclipse.emf.ecore.EClass;

import de.hub.corpling.salt.saltCommon.SaltCommonFactory;
import de.hub.corpling.salt.saltCommon.SaltCommonPackage;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialDS;
import de.hub.corpling.salt.saltCore.SFeature;
import de.hub.corpling.salt.saltCore.impl.SNodeImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SSequential DS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SSequentialDSImpl#getSData <em>SData</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SSequentialDSImpl extends SNodeImpl implements SSequentialDS {
	/**
	 * The default value of the '{@link #getSData() <em>SData</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSData()
	 * @generated
	 * @ordered
	 */
	protected static final Object SDATA_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SSequentialDSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDocumentStructurePackage.Literals.SSEQUENTIAL_DS;
	}

	public String KW_SDATA= "SDATA";
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Object getSData() 
	{
		Object retVal= null;
		String name= SaltCommonPackage.eNS_PREFIX + "::" + KW_SDATA;
		SFeature sFeature= this.getSFeature(name);
		if (sFeature!= null)
		{
			retVal= sFeature.getSValue();
		}
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSData(Object newSData) 
	{
		String name= SaltCommonPackage.eNS_PREFIX + "::" + KW_SDATA; 
		SFeature sFeature= this.getSFeature(name);
		if (sFeature== null)
		{//create a new sFeature
			sFeature= SaltCommonFactory.eINSTANCE.createSFeature();
			sFeature.setSNS(SaltCommonPackage.eNS_PREFIX);
			sFeature.setSName(KW_SDATA);
			this.addSFeature(sFeature);
		}	
		sFeature.setSValue(newSData);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SDocumentStructurePackage.SSEQUENTIAL_DS__SDATA:
				return getSData();
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
			case SDocumentStructurePackage.SSEQUENTIAL_DS__SDATA:
				setSData(newValue);
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
			case SDocumentStructurePackage.SSEQUENTIAL_DS__SDATA:
				setSData(SDATA_EDEFAULT);
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
			case SDocumentStructurePackage.SSEQUENTIAL_DS__SDATA:
				return SDATA_EDEFAULT == null ? getSData() != null : !SDATA_EDEFAULT.equals(getSData());
		}
		return super.eIsSet(featureID);
	}

} //SSequentialDSImpl
