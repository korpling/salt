/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.salt.impl;


import de.corpling.salt.model.saltCore.SaltCoreFactory;
import de.corpling.salt.model.saltCore.SFeature;
import de.corpling.salt.model.saltCore.impl.SElementImpl;
import de.corpling.salt.model.salt.SDataSource;
import de.corpling.salt.model.salt.SaltPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SData Source</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.corpling.salt.model.salt.impl.SDataSourceImpl#getSDataSource <em>SData Source</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SDataSourceImpl extends SElementImpl implements SDataSource {
	/**
	 * The default value of the '{@link #getSDataSource() <em>SData Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSDataSource()
	 * @generated
	 * @ordered
	 */
	protected static final Object SDATA_SOURCE_EDEFAULT = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected SDataSourceImpl() 
	{
		super();
	}
	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltPackage.Literals.SDATA_SOURCE;
	}

	// --------------------- Start DataSource-Handling
	
	private static final String FEAT_DS= "dataSource";
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Object getSDataSource() 
	{
		SFeature feature= super.getSFeature(FEAT_DS);
		if (feature!= null)
			return(feature.getValue());
		else return(null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSDataSource(Object newDataSource) 
	{
		SFeature feature= super.getSFeature(FEAT_DS);
		if (feature== null)
		{
			feature= SaltCoreFactory.eINSTANCE.createSFeature();
			feature.setFullName(FEAT_DS);
			super.addSFeature(feature);
		}
		feature.setValue(newDataSource);
	}
// --------------------- End DataSource-Handling
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SaltPackage.SDATA_SOURCE__SDATA_SOURCE:
				return getSDataSource();
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
			case SaltPackage.SDATA_SOURCE__SDATA_SOURCE:
				setSDataSource(newValue);
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
			case SaltPackage.SDATA_SOURCE__SDATA_SOURCE:
				setSDataSource(SDATA_SOURCE_EDEFAULT);
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
			case SaltPackage.SDATA_SOURCE__SDATA_SOURCE:
				return SDATA_SOURCE_EDEFAULT == null ? getSDataSource() != null : !SDATA_SOURCE_EDEFAULT.equals(getSDataSource());
		}
		return super.eIsSet(featureID);
	}

} //SDataSourceImpl
