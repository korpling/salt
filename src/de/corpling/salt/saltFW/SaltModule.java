/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.saltFW;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Salt Module</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.corpling.salt.saltFW.SaltModule#getSaltProject <em>Salt Project</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.corpling.salt.saltFW.SaltFWPackage#getSaltModule()
 * @model
 * @generated
 */
public interface SaltModule extends EObject {
	/**
	 * Returns the value of the '<em><b>Salt Project</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.corpling.salt.saltFW.SaltProject#getSModules <em>SModules</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Salt Project</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Salt Project</em>' container reference.
	 * @see #setSaltProject(SaltProject)
	 * @see de.corpling.salt.saltFW.SaltFWPackage#getSaltModule_SaltProject()
	 * @see de.corpling.salt.saltFW.SaltProject#getSModules
	 * @model opposite="sModules" transient="false"
	 * @generated
	 */
	SaltProject getSaltProject();

	/**
	 * Sets the value of the '{@link de.corpling.salt.saltFW.SaltModule#getSaltProject <em>Salt Project</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Salt Project</em>' container reference.
	 * @see #getSaltProject()
	 * @generated
	 */
	void setSaltProject(SaltProject value);

} // SaltModule
