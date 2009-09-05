/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sCorpusStructure;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage
 * @generated
 */
public interface SCorpusStructureFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SCorpusStructureFactory eINSTANCE = de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusStructureFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>SCorpus Graph</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCorpus Graph</em>'.
	 * @generated
	 */
	SCorpusGraph createSCorpusGraph();

	/**
	 * Returns a new object of class '<em>SDocument</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SDocument</em>'.
	 * @generated
	 */
	SDocument createSDocument();

	/**
	 * Returns a new object of class '<em>SCorpus</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCorpus</em>'.
	 * @generated
	 */
	SCorpus createSCorpus();

	/**
	 * Returns a new object of class '<em>SCorpus Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCorpus Relation</em>'.
	 * @generated
	 */
	SCorpusRelation createSCorpusRelation();

	/**
	 * Returns a new object of class '<em>SCorpus Document Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCorpus Document Relation</em>'.
	 * @generated
	 */
	SCorpusDocumentRelation createSCorpusDocumentRelation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SCorpusStructurePackage getSCorpusStructurePackage();

} //SCorpusStructureFactory
