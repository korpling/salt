/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SAnnotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SAnnotation#getSAnnotatableElement <em>SAnnotatable Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSAnnotation()
 * @model
 * @generated
 */
public interface SAnnotation extends SAbstractAnnotation {
	/**
	 * Returns the value of the '<em><b>SAnnotatable Element</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCore.SAnnotatableElement#getSAnnotations <em>SAnnotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SAnnotatable Element</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SAnnotatable Element</em>' container reference.
	 * @see #setSAnnotatableElement(SAnnotatableElement)
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSAnnotation_SAnnotatableElement()
	 * @see de.hub.corpling.salt.saltCore.SAnnotatableElement#getSAnnotations
	 * @model opposite="sAnnotations" volatile="true"
	 * @generated
	 */
	SAnnotatableElement getSAnnotatableElement();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCore.SAnnotation#getSAnnotatableElement <em>SAnnotatable Element</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SAnnotatable Element</em>' container reference.
	 * @see #getSAnnotatableElement()
	 * @generated
	 */
	void setSAnnotatableElement(SAnnotatableElement value);

} // SAnnotation
