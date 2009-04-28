/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.saltCore;

import de.util.graph.IdentifiableElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SIdentifiable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.corpling.salt.model.saltCore.SIdentifiableElement#getSElementPath <em>SElement Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSIdentifiableElement()
 * @model
 * @generated
 */
public interface SIdentifiableElement extends SNamedElement, STypedElement, IdentifiableElement {
	/**
	 * Returns the value of the '<em><b>SElement Path</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link de.corpling.salt.model.saltCore.SElementPath#getSElement <em>SElement</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SElement Path</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SElement Path</em>' containment reference.
	 * @see #setSElementPath(SElementPath)
	 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSIdentifiableElement_SElementPath()
	 * @see de.corpling.salt.model.saltCore.SElementPath#getSElement
	 * @model opposite="sElement" containment="true" required="true"
	 * @generated
	 */
	SElementPath getSElementPath();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.saltCore.SIdentifiableElement#getSElementPath <em>SElement Path</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SElement Path</em>' containment reference.
	 * @see #getSElementPath()
	 * @generated
	 */
	void setSElementPath(SElementPath value);

} // SIdentifiableElement
