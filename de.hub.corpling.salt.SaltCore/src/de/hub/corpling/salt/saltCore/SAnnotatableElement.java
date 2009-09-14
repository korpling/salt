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
 * A representation of the model object '<em><b>SAnnotatable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SAnnotatableElement#getSAnnotations <em>SAnnotations</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSAnnotatableElement()
 * @model
 * @generated
 */
public interface SAnnotatableElement extends LabelableElement {
	/**
	 * Returns the value of the '<em><b>SAnnotations</b></em>' containment reference list.
	 * The list contents are of type {@link de.hub.corpling.salt.saltCore.SAnnotation}.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCore.SAnnotation#getSAnnotatableElement <em>SAnnotatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SAnnotations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SAnnotations</em>' containment reference list.
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSAnnotatableElement_SAnnotations()
	 * @see de.hub.corpling.salt.saltCore.SAnnotation#getSAnnotatableElement
	 * @model opposite="sAnnotatableElement" containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SAnnotation> getSAnnotations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addSAnnotation(SAnnotation sAnnotation);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	SAnnotation getSAnnotation(String fullName);

} // SAnnotatableElement
