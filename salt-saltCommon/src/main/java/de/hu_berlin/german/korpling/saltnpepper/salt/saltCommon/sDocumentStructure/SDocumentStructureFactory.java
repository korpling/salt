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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage
 * @generated
 */
public interface SDocumentStructureFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SDocumentStructureFactory eINSTANCE = de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructureFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>SDocument Graph</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SDocument Graph</em>'.
	 * @generated
	 */
	SDocumentGraph createSDocumentGraph();

	/**
	 * Returns a new object of class '<em>STextual DS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>STextual DS</em>'.
	 * @generated
	 */
	STextualDS createSTextualDS();

	/**
	 * Returns a new object of class '<em>SToken</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SToken</em>'.
	 * @generated
	 */
	SToken createSToken();

	/**
	 * Returns a new object of class '<em>STextual Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>STextual Relation</em>'.
	 * @generated
	 */
	STextualRelation createSTextualRelation();

	/**
	 * Returns a new object of class '<em>STimeline</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>STimeline</em>'.
	 * @generated
	 */
	STimeline createSTimeline();

	/**
	 * Returns a new object of class '<em>STimeline Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>STimeline Relation</em>'.
	 * @generated
	 */
	STimelineRelation createSTimelineRelation();

	/**
	 * Returns a new object of class '<em>SSpan</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SSpan</em>'.
	 * @generated
	 */
	SSpan createSSpan();

	/**
	 * Returns a new object of class '<em>SSpanning Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SSpanning Relation</em>'.
	 * @generated
	 */
	SSpanningRelation createSSpanningRelation();

	/**
	 * Returns a new object of class '<em>SStructure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SStructure</em>'.
	 * @generated
	 */
	SStructure createSStructure();

	/**
	 * Returns a new object of class '<em>SPointing Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SPointing Relation</em>'.
	 * @generated
	 */
	SPointingRelation createSPointingRelation();

	/**
	 * Returns a new object of class '<em>SDominance Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SDominance Relation</em>'.
	 * @generated
	 */
	SDominanceRelation createSDominanceRelation();

	/**
	 * Returns a new object of class '<em>SData Source Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SData Source Sequence</em>'.
	 * @generated
	 */
	SDataSourceSequence createSDataSourceSequence();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SDocumentStructurePackage getSDocumentStructurePackage();

} //SDocumentStructureFactory
