/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SMeta Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SMetaAnnotation#getSMetaAnnotatableElement <em>SMeta Annotatable Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSMetaAnnotation()
 * @model
 * @generated
 */
public interface SMetaAnnotation extends SAbstractAnnotation {
	/**
	 * Returns the value of the '<em><b>SMeta Annotatable Element</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCore.SMetaAnnotatableElement#getSMetaAnnotations <em>SMeta Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SMeta Annotatable Element</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SMeta Annotatable Element</em>' container reference.
	 * @see #setSMetaAnnotatableElement(SMetaAnnotatableElement)
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSMetaAnnotation_SMetaAnnotatableElement()
	 * @see de.hub.corpling.salt.saltCore.SMetaAnnotatableElement#getSMetaAnnotations
	 * @model opposite="sMetaAnnotations" volatile="true" derived="true"
	 * @generated
	 */
	SMetaAnnotatableElement getSMetaAnnotatableElement();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCore.SMetaAnnotation#getSMetaAnnotatableElement <em>SMeta Annotatable Element</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SMeta Annotatable Element</em>' container reference.
	 * @see #getSMetaAnnotatableElement()
	 * @generated
	 */
	void setSMetaAnnotatableElement(SMetaAnnotatableElement value);

} // SMetaAnnotation
