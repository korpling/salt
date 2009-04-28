/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.salt;

import java.io.File;
import java.util.Collection;

import de.corpling.salt.model.saltCore.SStereotype;
import de.corpling.salt.model.saltCore.SaltCoreFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.corpling.salt.model.salt.SaltPackage
 * @generated NOT
 */
public interface SaltFactory extends SaltCoreFactory {
	
	/**
	 * Returns a list of all predefined stereotypes.
	 * @return a list of all predefined stereotypes
	 */
	public Collection<SStereotype> getPredefinedStereotypes();
	
	/**
	 * Returns the Stereotype applicable to the given stereotype name
	 * @param sStereotypeName
	 * @return
	 */
	public SStereotype getPredefinedStereotype(String sStereotypeName);
	
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SaltFactory eINSTANCE = de.corpling.salt.model.salt.impl.SaltFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>SToken</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SToken</em>'.
	 * @generated
	 */
	SToken createSToken();

	/**
	 * Returns a new object of class '<em>SData Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SData Source</em>'.
	 * @generated
	 */
	SDataSource createSDataSource();

	/**
	 * Returns a new object of class '<em>STextual Data Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>STextual Data Source</em>'.
	 * @generated
	 */
	STextualDataSource createSTextualDataSource();

	/**
	 * Returns a new object of class '<em>SDocument Graph</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SDocument Graph</em>'.
	 * @generated
	 */
	SDocumentGraph createSDocumentGraph();

	/**
	 * Returns a new object of class '<em>STextual Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>STextual Relation</em>'.
	 * @generated
	 */
	STextualRelation createSTextualRelation();

	/**
	 * Returns a new object of class '<em>SStructure</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SStructure</em>'.
	 * @generated
	 */
	SStructure createSStructure();

	/**
	 * Returns a new object of class '<em>SSpan Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SSpan Relation</em>'.
	 * @generated
	 */
	SSpanRelation createSSpanRelation();

	/**
	 * Returns a new object of class '<em>SProject</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SProject</em>'.
	 * @generated
	 */
	SProject createSProject();

	/**
	 * Returns a new object of class '<em>SCorpus</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCorpus</em>'.
	 * @generated
	 */
	SCorpus createSCorpus();

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
	 * Returns a new object of class '<em>SCorpus Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCorpus Relation</em>'.
	 * @generated
	 */
	SCorpusRelation createSCorpusRelation();

	/**
	 * Returns a new object of class '<em>SCorp Doc Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCorp Doc Relation</em>'.
	 * @generated
	 */
	SCorpDocRelation createSCorpDocRelation();

	/**
	 * Returns a new object of class '<em>SDominance Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SDominance Relation</em>'.
	 * @generated
	 */
	SDominanceRelation createSDominanceRelation();

	/**
	 * Returns a new object of class '<em>SPointing Relation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SPointing Relation</em>'.
	 * @generated
	 */
	SPointingRelation createSPointingRelation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SaltPackage getSaltConcretePackage();

	/**
	 * sets the directory where to find setting files.
	 */
	public void setSettingLocation(File dir);
	
} //SaltConcreteFactory
