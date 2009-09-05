/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon;

import org.eclipse.emf.ecore.EFactory;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructureFactory;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructureFactory;
import de.hub.corpling.salt.saltCore.SaltCoreFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hub.corpling.salt.saltCommon.SaltCommonPackage
 */
public interface SaltCommonFactory extends EFactory, SaltCoreFactory, SCorpusStructureFactory, SDocumentStructureFactory
{
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SaltCommonFactory eINSTANCE = de.hub.corpling.salt.saltCommon.impl.SaltCommonFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Salt Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Salt Project</em>'.
	 * @generated
	 */
	SaltProject createSaltProject();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SaltCommonPackage getSaltCommonPackage();

} //SaltCommonFactory
