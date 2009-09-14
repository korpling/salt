/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore;

import de.hub.corpling.graph.LabelableElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SProcessing Annotatable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotations <em>SProcessing Annotations</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSProcessingAnnotatableElement()
 * @model
 * @generated
 */
public interface SProcessingAnnotatableElement extends LabelableElement {
	/**
	 * Returns the value of the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * The list contents are of type {@link de.hub.corpling.salt.saltCore.SProcessingAnnotation}.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCore.SProcessingAnnotation#getSProcessingAnnotatableElement <em>SProcessing Annotatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SProcessing Annotations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SProcessing Annotations</em>' containment reference list.
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSProcessingAnnotatableElement_SProcessingAnnotations()
	 * @see de.hub.corpling.salt.saltCore.SProcessingAnnotation#getSProcessingAnnotatableElement
	 * @model opposite="sProcessingAnnotatableElement" containment="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<SProcessingAnnotation> getSProcessingAnnotations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addSProcessingAnnotation(SProcessingAnnotation sProcessingAnnotation);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	SProcessingAnnotation getSProcessingAnnotation(String fullName);

} // SProcessingAnnotatableElement
