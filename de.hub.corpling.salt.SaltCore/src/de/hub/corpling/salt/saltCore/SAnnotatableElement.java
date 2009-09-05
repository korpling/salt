/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

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
public interface SAnnotatableElement extends EObject {
	/**
	 * Returns the value of the '<em><b>SAnnotations</b></em>' containment reference list.
	 * The list contents are of type {@link de.hub.corpling.salt.saltCore.SAnnotation}.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCore.SAnnotation#getSAnnotatbaleElement <em>SAnnotatbale Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SAnnotations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SAnnotations</em>' containment reference list.
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSAnnotatableElement_SAnnotations()
	 * @see de.hub.corpling.salt.saltCore.SAnnotation#getSAnnotatbaleElement
	 * @model opposite="sAnnotatbaleElement" containment="true"
	 * @generated
	 */
	EList<SAnnotation> getSAnnotations();

} // SAnnotatableElement
