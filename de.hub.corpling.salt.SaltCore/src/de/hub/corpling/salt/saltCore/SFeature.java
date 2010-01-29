/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SFeature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SFeature#getSFeaturableElement <em>SFeaturable Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSFeature()
 * @model
 * @generated
 */
public interface SFeature extends SAbstractAnnotation {
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

} // SFeature
