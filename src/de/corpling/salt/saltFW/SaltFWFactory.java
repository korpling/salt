/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.saltFW;

import org.eclipse.emf.ecore.EFactory;

import de.corpling.salt.model.salt.SaltFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.corpling.salt.saltFW.SaltFWPackage
 * @generated NOT
 */
public interface SaltFWFactory extends SaltFactory 
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SaltFWFactory eINSTANCE = de.corpling.salt.saltFW.impl.SaltFWFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Salt Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Salt Project</em>'.
	 * @generated
	 */
	SaltProject createSaltProject();

	/**
	 * Returns a new object of class '<em>Salt Graph</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Salt Graph</em>'.
	 * @generated
	 */
	SaltGraph createSaltGraph();

	/**
	 * Returns a new object of class '<em>Salt Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Salt Module</em>'.
	 * @generated
	 */
	SaltModule createSaltModule();

	/**
	 * Returns a new object of class '<em>Salt Accessor Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Salt Accessor Module</em>'.
	 * @generated
	 */
	SaltAccessorModule createSaltAccessorModule();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SaltFWPackage getSaltFWPackage();

} //SaltFWFactory
