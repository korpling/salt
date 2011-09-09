/**
 * Copyright 2009 Humboldt University of Berlin, INRIA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory
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
	SaltCommonPackage eINSTANCE = de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.impl.SaltCommonPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.impl.SaltProjectImpl <em>Salt Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.impl.SaltProjectImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.impl.SaltCommonPackageImpl#getSaltProject()
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
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_PROJECT__SNAME = 1;

	/**
	 * The number of structural features of the '<em>Salt Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_PROJECT_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '<em>Properties</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Properties
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.impl.SaltCommonPackageImpl#getProperties()
	 * @generated
	 */
	int PROPERTIES = 1;


	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject <em>Salt Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Salt Project</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject
	 * @generated
	 */
	EClass getSaltProject();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#getSCorpusGraphs <em>SCorpus Graphs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SCorpus Graphs</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#getSCorpusGraphs()
	 * @see #getSaltProject()
	 * @generated
	 */
	EReference getSaltProject_SCorpusGraphs();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#getSName <em>SName</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SName</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject#getSName()
	 * @see #getSaltProject()
	 * @generated
	 */
	EAttribute getSaltProject_SName();

	/**
	 * Returns the meta object for data type '{@link java.util.Properties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Properties</em>'.
	 * @see java.util.Properties
	 * @model instanceClass="java.util.Properties"
	 * @generated
	 */
	EDataType getProperties();

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
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.impl.SaltProjectImpl <em>Salt Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.impl.SaltProjectImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.impl.SaltCommonPackageImpl#getSaltProject()
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

		/**
		 * The meta object literal for the '<em><b>SName</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SALT_PROJECT__SNAME = eINSTANCE.getSaltProject_SName();

		/**
		 * The meta object literal for the '<em>Properties</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Properties
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.impl.SaltCommonPackageImpl#getProperties()
		 * @generated
		 */
		EDataType PROPERTIES = eINSTANCE.getProperties();

	}

} //SaltCommonPackage
