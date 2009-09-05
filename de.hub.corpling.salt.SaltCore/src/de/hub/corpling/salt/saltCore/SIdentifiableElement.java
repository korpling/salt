/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SIdentifiable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SIdentifiableElement#getSElementId <em>SElement Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSIdentifiableElement()
 * @model
 * @generated
 */
public interface SIdentifiableElement extends EObject {
	/**
	 * Returns the value of the '<em><b>SElement Id</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCore.SElementId#getSIdentifiableElement <em>SIdentifiable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SElement Id</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SElement Id</em>' containment reference.
	 * @see #setSElementId(SElementId)
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSIdentifiableElement_SElementId()
	 * @see de.hub.corpling.salt.saltCore.SElementId#getSIdentifiableElement
	 * @model opposite="sIdentifiableElement" containment="true"
	 * @generated
	 */
	SElementId getSElementId();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCore.SIdentifiableElement#getSElementId <em>SElement Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SElement Id</em>' containment reference.
	 * @see #getSElementId()
	 * @generated
	 */
	void setSElementId(SElementId value);

} // SIdentifiableElement
