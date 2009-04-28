/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.saltFW;

import de.corpling.salt.model.salt.SProject;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Salt Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.corpling.salt.saltFW.SaltProject#getSaltGraphs <em>Salt Graphs</em>}</li>
 *   <li>{@link de.corpling.salt.saltFW.SaltProject#getSModules <em>SModules</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.corpling.salt.saltFW.SaltFWPackage#getSaltProject()
 * @model
 * @generated
 */
public interface SaltProject extends SProject {
	/**
	 * Returns the value of the '<em><b>Salt Graphs</b></em>' containment reference list.
	 * The list contents are of type {@link de.corpling.salt.saltFW.SaltGraph}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Salt Graphs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Salt Graphs</em>' containment reference list.
	 * @see de.corpling.salt.saltFW.SaltFWPackage#getSaltProject_SaltGraphs()
	 * @model containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SaltGraph> getSaltGraphs();

	/**
	 * Returns the value of the '<em><b>SModules</b></em>' containment reference list.
	 * The list contents are of type {@link de.corpling.salt.saltFW.SaltModule}.
	 * It is bidirectional and its opposite is '{@link de.corpling.salt.saltFW.SaltModule#getSaltProject <em>Salt Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SModules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SModules</em>' containment reference list.
	 * @see de.corpling.salt.saltFW.SaltFWPackage#getSaltProject_SModules()
	 * @see de.corpling.salt.saltFW.SaltModule#getSaltProject
	 * @model opposite="saltProject" containment="true"
	 * @generated
	 */
	EList<SaltModule> getSModules();

} // SaltProject
