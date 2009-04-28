/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.saltCore;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SStereotype</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.corpling.salt.model.saltCore.SStereotype#getName <em>Name</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.SStereotype#getSFeatureDescriptions <em>SFeature Descriptions</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.SStereotype#getSSuperStereotype <em>SSuper Stereotype</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.SStereotype#getSProject <em>SProject</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSStereotype()
 * @model
 * @generated
 */
public interface SStereotype extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSStereotype_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.saltCore.SStereotype#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>SFeature Descriptions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SFeature Descriptions</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SFeature Descriptions</em>' containment reference.
	 * @see #setSFeatureDescriptions(SFeatureDescription)
	 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSStereotype_SFeatureDescriptions()
	 * @model containment="true"
	 * @generated
	 */
	SFeatureDescription getSFeatureDescriptions();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.saltCore.SStereotype#getSFeatureDescriptions <em>SFeature Descriptions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SFeature Descriptions</em>' containment reference.
	 * @see #getSFeatureDescriptions()
	 * @generated
	 */
	void setSFeatureDescriptions(SFeatureDescription value);

	/**
	 * Returns the value of the '<em><b>SSuper Stereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SSuper Stereotype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SSuper Stereotype</em>' reference.
	 * @see #setSSuperStereotype(SStereotype)
	 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSStereotype_SSuperStereotype()
	 * @model
	 * @generated
	 */
	SStereotype getSSuperStereotype();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.saltCore.SStereotype#getSSuperStereotype <em>SSuper Stereotype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SSuper Stereotype</em>' reference.
	 * @see #getSSuperStereotype()
	 * @generated
	 */
	void setSSuperStereotype(SStereotype value);

	/**
	 * Returns the value of the '<em><b>SProject</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.corpling.salt.model.saltCore.SStereotypeContainer#getSStereotypes <em>SStereotypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SProject</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SProject</em>' container reference.
	 * @see #setSProject(SStereotypeContainer)
	 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSStereotype_SProject()
	 * @see de.corpling.salt.model.saltCore.SStereotypeContainer#getSStereotypes
	 * @model opposite="sStereotypes" transient="false"
	 * @generated
	 */
	SStereotypeContainer getSProject();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.saltCore.SStereotype#getSProject <em>SProject</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SProject</em>' container reference.
	 * @see #getSProject()
	 * @generated
	 */
	void setSProject(SStereotypeContainer value);

} // SStereotype
