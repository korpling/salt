/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.hub.corpling.salt.saltCommon.SaltCommonFactory
 * @model kind="package"
 * @generated
 */
public interface SaltCommonPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "saltCommon";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "saltCommon";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "saltCommon";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SaltCommonPackage eINSTANCE = de.hub.corpling.salt.saltCommon.impl.SaltCommonPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCommon.impl.SaltProjectImpl <em>Salt Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.impl.SaltProjectImpl
	 * @see de.hub.corpling.salt.saltCommon.impl.SaltCommonPackageImpl#getSaltProject()
	 * @generated
	 */
	int SALT_PROJECT = 0;

	/**
	 * The feature id for the '<em><b>SCorpus Graphs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_PROJECT__SCORPUS_GRAPHS = 0;

	/**
	 * The number of structural features of the '<em>Salt Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_PROJECT_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCommon.SaltProject <em>Salt Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Salt Project</em>'.
	 * @see de.hub.corpling.salt.saltCommon.SaltProject
	 * @generated
	 */
	EClass getSaltProject();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hub.corpling.salt.saltCommon.SaltProject#getSCorpusGraphs <em>SCorpus Graphs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SCorpus Graphs</em>'.
	 * @see de.hub.corpling.salt.saltCommon.SaltProject#getSCorpusGraphs()
	 * @see #getSaltProject()
	 * @generated
	 */
	EReference getSaltProject_SCorpusGraphs();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SaltCommonFactory getSaltCommonFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCommon.impl.SaltProjectImpl <em>Salt Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCommon.impl.SaltProjectImpl
		 * @see de.hub.corpling.salt.saltCommon.impl.SaltCommonPackageImpl#getSaltProject()
		 * @generated
		 */
		EClass SALT_PROJECT = eINSTANCE.getSaltProject();

		/**
		 * The meta object literal for the '<em><b>SCorpus Graphs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SALT_PROJECT__SCORPUS_GRAPHS = eINSTANCE.getSaltProject_SCorpusGraphs();

	}

} //SaltCommonPackage
