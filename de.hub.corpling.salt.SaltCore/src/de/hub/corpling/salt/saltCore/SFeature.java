/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore;

import de.hub.corpling.graph.Label;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SFeature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SFeature#getSName <em>SName</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SFeature#getSValue <em>SValue</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SFeature#getSFeaturableElement <em>SFeaturable Element</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SFeature#getSNS <em>SNS</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSFeature()
 * @model
 * @generated
 */
public interface SFeature extends Label {
	/**
	 * Returns the value of the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SName</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SName</em>' attribute.
	 * @see #setSName(String)
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSFeature_SName()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	String getSName();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCore.SFeature#getSName <em>SName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SName</em>' attribute.
	 * @see #getSName()
	 * @generated
	 */
	void setSName(String value);

	/**
	 * Returns the value of the '<em><b>SValue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SValue</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SValue</em>' attribute.
	 * @see #setSValue(Object)
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSFeature_SValue()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	Object getSValue();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCore.SFeature#getSValue <em>SValue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SValue</em>' attribute.
	 * @see #getSValue()
	 * @generated
	 */
	void setSValue(Object value);

	/**
	 * Returns the value of the '<em><b>SFeaturable Element</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCore.SFeaturableElement#getSFeatures <em>SFeatures</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SFeaturable Element</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SFeaturable Element</em>' container reference.
	 * @see #setSFeaturableElement(SFeaturableElement)
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSFeature_SFeaturableElement()
	 * @see de.hub.corpling.salt.saltCore.SFeaturableElement#getSFeatures
	 * @model opposite="sFeatures" volatile="true" derived="true"
	 * @generated
	 */
	SFeaturableElement getSFeaturableElement();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCore.SFeature#getSFeaturableElement <em>SFeaturable Element</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SFeaturable Element</em>' container reference.
	 * @see #getSFeaturableElement()
	 * @generated
	 */
	void setSFeaturableElement(SFeaturableElement value);

	/**
	 * Returns the value of the '<em><b>SNS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SNS</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SNS</em>' attribute.
	 * @see #setSNS(String)
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSFeature_SNS()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	String getSNS();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCore.SFeature#getSNS <em>SNS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SNS</em>' attribute.
	 * @see #getSNS()
	 * @generated
	 */
	void setSNS(String value);

} // SFeature
