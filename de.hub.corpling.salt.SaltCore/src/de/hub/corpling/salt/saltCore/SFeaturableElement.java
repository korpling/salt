/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore;

import org.eclipse.emf.common.util.EList;

import de.hub.corpling.graph.LabelableElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SFeaturable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SFeaturableElement#getSFeatures <em>SFeatures</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSFeaturableElement()
 * @model
 * @generated
 */
public interface SFeaturableElement extends LabelableElement {
	/**
	 * Returns the value of the '<em><b>SFeatures</b></em>' containment reference list.
	 * The list contents are of type {@link de.hub.corpling.salt.saltCore.SFeature}.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCore.SFeature#getSFeaturableElement <em>SFeaturable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SFeatures</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SFeatures</em>' containment reference list.
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSFeaturableElement_SFeatures()
	 * @see de.hub.corpling.salt.saltCore.SFeature#getSFeaturableElement
	 * @model opposite="sFeaturableElement" containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SFeature> getSFeatures();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addSFeature(SFeature sFeature);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	SFeature getSFeature(String sFeatureName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	SFeature getSFeature(String sNamespace, String sFeatureName);

} // SFeaturableElement
