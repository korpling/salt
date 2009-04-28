/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.saltCore;

import de.util.graph.LabelableElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SStereotypeable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.corpling.salt.model.saltCore.SStereotypeableElement#getSStereotype <em>SStereotype</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.SStereotypeableElement#getSFeatures <em>SFeatures</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSStereotypeableElement()
 * @model
 * @generated
 */
public interface SStereotypeableElement extends LabelableElement {
	/**
	 * Returns the value of the '<em><b>SStereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SStereotype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SStereotype</em>' reference.
	 * @see #setSStereotype(SStereotype)
	 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSStereotypeableElement_SStereotype()
	 * @model required="true"
	 * @generated
	 */
	SStereotype getSStereotype();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.saltCore.SStereotypeableElement#getSStereotype <em>SStereotype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SStereotype</em>' reference.
	 * @see #getSStereotype()
	 * @generated
	 */
	void setSStereotype(SStereotype value);

	/**
	 * Returns the value of the '<em><b>SFeatures</b></em>' containment reference list.
	 * The list contents are of type {@link de.corpling.salt.model.saltCore.SFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SFeatures</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SFeatures</em>' containment reference list.
	 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSStereotypeableElement_SFeatures()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SFeature> getSFeatures();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addSFeature(String featureName, Object featureValue);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	SFeature getSFeature(String featureName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean removeSFeature(String featureName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addSFeature(SFeature feature);

} // SStereotypeableElement
