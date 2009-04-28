/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.saltCore;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>STyped Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.corpling.salt.model.saltCore.STypedElement#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSTypedElement()
 * @model
 * @generated
 */
public interface STypedElement extends EObject {

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.corpling.salt.model.saltCore.SELEMENT_TYPE}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see de.corpling.salt.model.saltCore.SELEMENT_TYPE
	 * @see #setType(SELEMENT_TYPE)
	 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSTypedElement_Type()
	 * @model
	 * @generated
	 */
	SELEMENT_TYPE getType();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.saltCore.STypedElement#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see de.corpling.salt.model.saltCore.SELEMENT_TYPE
	 * @see #getType()
	 * @generated
	 */
	void setType(SELEMENT_TYPE value);

} // STypedElement
