/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.saltCore;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.corpling.salt.model.saltCore.SaltCorePackage
 * @generated
 */
public interface SaltCoreFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SaltCoreFactory eINSTANCE = de.corpling.salt.model.saltCore.impl.SaltCoreFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>SElement Path</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SElement Path</em>'.
	 * @generated
	 */
	SElementPath createSElementPath();

	/**
	 * Returns a new object of class '<em>SIdentifiable Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SIdentifiable Element</em>'.
	 * @generated
	 */
	SIdentifiableElement createSIdentifiableElement();

	/**
	 * Returns a new object of class '<em>SElement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SElement</em>'.
	 * @generated
	 */
	SElement createSElement();

	/**
	 * Returns a new object of class '<em>SAnnotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SAnnotation</em>'.
	 * @generated
	 */
	SAnnotation createSAnnotation();

	/**
	 * Returns a new object of class '<em>SAnnotatable Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SAnnotatable Element</em>'.
	 * @generated
	 */
	SAnnotatableElement createSAnnotatableElement();

	/**
	 * Returns a new object of class '<em>SRelation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SRelation</em>'.
	 * @generated
	 */
	SRelation createSRelation();

	/**
	 * Returns a new object of class '<em>SNamed Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SNamed Element</em>'.
	 * @generated
	 */
	SNamedElement createSNamedElement();

	/**
	 * Returns a new object of class '<em>STyped Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>STyped Element</em>'.
	 * @generated
	 */
	STypedElement createSTypedElement();

	/**
	 * Returns a new object of class '<em>SStereotypeable Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SStereotypeable Element</em>'.
	 * @generated
	 */
	SStereotypeableElement createSStereotypeableElement();

	/**
	 * Returns a new object of class '<em>SFeature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SFeature</em>'.
	 * @generated
	 */
	SFeature createSFeature();

	/**
	 * Returns a new object of class '<em>SStereotype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SStereotype</em>'.
	 * @generated
	 */
	SStereotype createSStereotype();

	/**
	 * Returns a new object of class '<em>SFeature Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SFeature Description</em>'.
	 * @generated
	 */
	SFeatureDescription createSFeatureDescription();

	/**
	 * Returns a new object of class '<em>SGraph</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SGraph</em>'.
	 * @generated
	 */
	SGraph createSGraph();

	/**
	 * Returns a new object of class '<em>SCore Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SCore Project</em>'.
	 * @generated
	 */
	SCoreProject createSCoreProject();

	/**
	 * Returns a new object of class '<em>SStereotype Container</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SStereotype Container</em>'.
	 * @generated
	 */
	SStereotypeContainer createSStereotypeContainer();

	/**
	 * Returns a new object of class '<em>SProcessing Annotatable Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SProcessing Annotatable Element</em>'.
	 * @generated
	 */
	SProcessingAnnotatableElement createSProcessingAnnotatableElement();

	/**
	 * Returns a new object of class '<em>SProcessing Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SProcessing Annotation</em>'.
	 * @generated
	 */
	SProcessingAnnotation createSProcessingAnnotation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SaltCorePackage getSaltCorePackage();

} //SaltCoreFactory
