/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SElement Id</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SElementId#getSId <em>SId</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SElementId#getSIdentifiableElement <em>SIdentifiable Element</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SElementId#getSElementPath <em>SElement Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSElementId()
 * @model
 * @generated
 */
public interface SElementId extends EObject {
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
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSElementId_SId()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	String getSId();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCore.SElementId#getSId <em>SId</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SId</em>' attribute.
	 * @see #getSId()
	 * @generated
	 */
	void setSId(String value);

	/**
	 * Returns the value of the '<em><b>SIdentifiable Element</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCore.SIdentifiableElement#getSElementId <em>SElement Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SIdentifiable Element</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SIdentifiable Element</em>' container reference.
	 * @see #setSIdentifiableElement(SIdentifiableElement)
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSElementId_SIdentifiableElement()
	 * @see de.hub.corpling.salt.saltCore.SIdentifiableElement#getSElementId
	 * @model opposite="sElementId" transient="false"
	 * @generated
	 */
	SIdentifiableElement getSIdentifiableElement();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCore.SElementId#getSIdentifiableElement <em>SIdentifiable Element</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SIdentifiable Element</em>' container reference.
	 * @see #getSIdentifiableElement()
	 * @generated
	 */
	void setSIdentifiableElement(SIdentifiableElement value);

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
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSElementId_SElementPath()
	 * @model dataType="de.hub.corpling.salt.saltCore.URI"
	 * @generated
	 */
	URI getSElementPath();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCore.SElementId#getSElementPath <em>SElement Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SElement Path</em>' attribute.
	 * @see #getSElementPath()
	 * @generated
	 */
	void setSElementPath(URI value);

} // SElementId
