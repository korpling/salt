/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hub.corpling.salt.saltCore.SaltCorePackage
 * @generated
 */
public interface SaltCoreFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SaltCoreFactory eINSTANCE = de.hub.corpling.salt.saltCore.impl.SaltCoreFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>SNode</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SNode</em>'.
	 * @generated
	 */
	SNode createSNode();

	/**
	 * Returns a new object of class '<em>SRelation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SRelation</em>'.
	 * @generated
	 */
	SRelation createSRelation();

	/**
	 * Returns a new object of class '<em>SAnnotatable Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SAnnotatable Element</em>'.
	 * @generated
	 */
	SAnnotatableElement createSAnnotatableElement();

	/**
	 * Returns a new object of class '<em>SAnnotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SAnnotation</em>'.
	 * @generated
	 */
	SAnnotation createSAnnotation();

	/**
	 * Returns a new object of class '<em>SGraph</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SGraph</em>'.
	 * @generated
	 */
	SGraph createSGraph();

	/**
	 * Returns a new object of class '<em>SNamed Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SNamed Element</em>'.
	 * @generated
	 */
	SNamedElement createSNamedElement();

	/**
	 * Returns a new object of class '<em>SIdentifiable Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SIdentifiable Element</em>'.
	 * @generated
	 */
	SIdentifiableElement createSIdentifiableElement();

	/**
	 * Returns a new object of class '<em>SProcessing Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SProcessing Annotation</em>'.
	 * @generated
	 */
	SProcessingAnnotation createSProcessingAnnotation();

	/**
	 * Returns a new object of class '<em>SProcessing Annotatable Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SProcessing Annotatable Element</em>'.
	 * @generated
	 */
	SProcessingAnnotatableElement createSProcessingAnnotatableElement();

	/**
	 * Returns a new object of class '<em>SElement Id</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SElement Id</em>'.
	 * @generated
	 */
	SElementId createSElementId();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SaltCorePackage getSaltCorePackage();

} //SaltCoreFactory
