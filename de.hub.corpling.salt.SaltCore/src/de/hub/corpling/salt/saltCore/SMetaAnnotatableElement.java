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
 * A representation of the model object '<em><b>SMeta Annotatable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SMetaAnnotatableElement#getSMetaAnnotations <em>SMeta Annotations</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSMetaAnnotatableElement()
 * @model
 * @generated
 */
public interface SMetaAnnotatableElement extends LabelableElement {
	/**
	 * Returns the value of the '<em><b>SMeta Annotations</b></em>' containment reference list.
	 * The list contents are of type {@link de.hub.corpling.salt.saltCore.SMetaAnnotation}.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCore.SMetaAnnotation#getSMetaAnnotatableElement <em>SMeta Annotatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SMeta Annotations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SMeta Annotations</em>' containment reference list.
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSMetaAnnotatableElement_SMetaAnnotations()
	 * @see de.hub.corpling.salt.saltCore.SMetaAnnotation#getSMetaAnnotatableElement
	 * @model opposite="sMetaAnnotatableElement" containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SMetaAnnotation> getSMetaAnnotations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addSMetaAnnotation(SMetaAnnotation sMetaAnnotation);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	SMetaAnnotation getSMetaAnnotation(String fullName);

} // SMetaAnnotatableElement
