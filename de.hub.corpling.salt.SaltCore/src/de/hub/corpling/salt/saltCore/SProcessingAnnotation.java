/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SProcessing Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SProcessingAnnotation#getSProcessingAnnotatableElement <em>SProcessing Annotatable Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSProcessingAnnotation()
 * @model
 * @generated
 */
public interface SProcessingAnnotation extends SAbstractAnnotation {
	/**
	 * Returns the value of the '<em><b>SProcessing Annotatable Element</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotations <em>SProcessing Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SProcessing Annotatable Element</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SProcessing Annotatable Element</em>' container reference.
	 * @see #setSProcessingAnnotatableElement(SProcessingAnnotatableElement)
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSProcessingAnnotation_SProcessingAnnotatableElement()
	 * @see de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotations
	 * @model opposite="sProcessingAnnotations" volatile="true" derived="true"
	 * @generated
	 */
	SProcessingAnnotatableElement getSProcessingAnnotatableElement();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCore.SProcessingAnnotation#getSProcessingAnnotatableElement <em>SProcessing Annotatable Element</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SProcessing Annotatable Element</em>' container reference.
	 * @see #getSProcessingAnnotatableElement()
	 * @generated
	 */
	void setSProcessingAnnotatableElement(SProcessingAnnotatableElement value);

} // SProcessingAnnotation
