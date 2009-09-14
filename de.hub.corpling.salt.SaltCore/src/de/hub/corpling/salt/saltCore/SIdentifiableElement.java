/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore;

import de.hub.corpling.graph.IdentifiableElement;

import org.eclipse.emf.common.util.URI;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SIdentifiable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SIdentifiableElement#getSId <em>SId</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SIdentifiableElement#getSElementPath <em>SElement Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSIdentifiableElement()
 * @model
 * @generated
 */
public interface SIdentifiableElement extends IdentifiableElement {
	/**
	 * Returns the value of the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SId</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SId</em>' attribute.
	 * @see #setSId(String)
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSIdentifiableElement_SId()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	String getSId();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCore.SIdentifiableElement#getSId <em>SId</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SId</em>' attribute.
	 * @see #getSId()
	 * @generated
	 */
	void setSId(String value);

	/**
	 * Returns the value of the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SElement Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SElement Path</em>' attribute.
	 * @see #setSElementPath(URI)
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSIdentifiableElement_SElementPath()
	 * @model dataType="de.hub.corpling.salt.saltCore.URI" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	URI getSElementPath();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCore.SIdentifiableElement#getSElementPath <em>SElement Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SElement Path</em>' attribute.
	 * @see #getSElementPath()
	 * @generated
	 */
	void setSElementPath(URI value);

} // SIdentifiableElement
