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
 * A representation of the model object '<em><b>SAnnotatable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.corpling.salt.model.saltCore.SAnnotatableElement#getSAnnotations <em>SAnnotations</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSAnnotatableElement()
 * @model
 * @generated
 */
public interface SAnnotatableElement extends LabelableElement {
	/**
	 * Returns the value of the '<em><b>SAnnotations</b></em>' containment reference list.
	 * The list contents are of type {@link de.corpling.salt.model.saltCore.SAnnotation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SAnnotations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SAnnotations</em>' containment reference list.
	 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSAnnotatableElement_SAnnotations()
	 * @model containment="true" volatile="true" derived="true"
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
