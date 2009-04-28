/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.salt;

import de.corpling.salt.model.saltCore.SElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SData Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.corpling.salt.model.salt.SDataSource#getSDataSource <em>SData Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.corpling.salt.model.salt.SaltPackage#getSDataSource()
 * @model
 * @generated
 */
public interface SDataSource extends SElement {
	/**
	 * Returns the value of the '<em><b>SData Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SData Source</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SData Source</em>' attribute.
	 * @see #setSDataSource(Object)
	 * @see de.corpling.salt.model.salt.SaltPackage#getSDataSource_SDataSource()
	 * @model volatile="true" derived="true"
	 * @generated
	 */
	Object getSDataSource();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.salt.SDataSource#getSDataSource <em>SData Source</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SData Source</em>' attribute.
	 * @see #getSDataSource()
	 * @generated
	 */
	void setSDataSource(Object value);

} // SDataSource
