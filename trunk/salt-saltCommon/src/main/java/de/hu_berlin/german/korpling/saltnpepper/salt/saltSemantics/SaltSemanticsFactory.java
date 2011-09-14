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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hub.corpling.salt.saltSemantics.SaltSemanticsPackage
 * @generated
 */
public interface SaltSemanticsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SaltSemanticsFactory eINSTANCE = de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SaltSemanticsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>SPOS Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SPOS Annotation</em>'.
	 * @generated
	 */
	SPOSAnnotation createSPOSAnnotation();

	/**
	 * Returns a new object of class '<em>SLemma Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SLemma Annotation</em>'.
	 * @generated
	 */
	SLemmaAnnotation createSLemmaAnnotation();

	/**
	 * Returns a new object of class '<em>SCat Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCat Annotation</em>'.
	 * @generated
	 */
	SCatAnnotation createSCatAnnotation();

	/**
	 * Returns a new object of class '<em>SType Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SType Annotation</em>'.
	 * @generated
	 */
	STypeAnnotation createSTypeAnnotation();

	/**
	 * Returns a new object of class '<em>SWord Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SWord Annotation</em>'.
	 * @generated
	 */
	SWordAnnotation createSWordAnnotation();

	/**
	 * Returns a new object of class '<em>SSentence Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SSentence Annotation</em>'.
	 * @generated
	 */
	SSentenceAnnotation createSSentenceAnnotation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SaltSemanticsPackage getSaltSemanticsPackage();

} //SaltSemanticsFactory
