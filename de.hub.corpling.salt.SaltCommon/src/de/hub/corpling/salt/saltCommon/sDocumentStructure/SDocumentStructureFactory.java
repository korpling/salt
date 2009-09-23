/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage
 * @generated
 */
public interface SDocumentStructureFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SDocumentStructureFactory eINSTANCE = de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructureFactoryImpl.init();

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
	 * Returns a new object of class '<em>SSequential Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SSequential Relation</em>'.
	 * @generated
	 */
	SSequentialRelation createSSequentialRelation();

	/**
	 * Returns a new object of class '<em>SSequential DS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SSequential DS</em>'.
	 * @generated
	 */
	SSequentialDS createSSequentialDS();

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
	 * Returns a new object of class '<em>SText Overlapping Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SText Overlapping Relation</em>'.
	 * @generated
	 */
	STextOverlappingRelation createSTextOverlappingRelation();

	/**
	 * Returns a new object of class '<em>STime Overlapping Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>STime Overlapping Relation</em>'.
	 * @generated
	 */
	STimeOverlappingRelation createSTimeOverlappingRelation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SDocumentStructurePackage getSDocumentStructurePackage();

} //SDocumentStructureFactory
