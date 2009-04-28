/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.saltCore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SCore Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.corpling.salt.model.saltCore.SCoreProject#getSGraphs <em>SGraphs</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.SCoreProject#getSStereotypeContainer <em>SStereotype Container</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSCoreProject()
 * @model
 * @generated
 */
public interface SCoreProject extends SStereotypeContainer {
	/**
	 * Returns the value of the '<em><b>SGraphs</b></em>' containment reference list.
	 * The list contents are of type {@link de.corpling.salt.model.saltCore.SGraph}.
	 * It is bidirectional and its opposite is '{@link de.corpling.salt.model.saltCore.SGraph#getSCoreProject <em>SCore Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SGraphs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SGraphs</em>' containment reference list.
	 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSCoreProject_SGraphs()
	 * @see de.corpling.salt.model.saltCore.SGraph#getSCoreProject
	 * @model opposite="sCoreProject" containment="true"
	 * @generated
	 */
	EList<SGraph> getSGraphs();

	/**
	 * Returns the value of the '<em><b>SStereotype Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SStereotype Container</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SStereotype Container</em>' containment reference.
	 * @see #setSStereotypeContainer(SStereotypeContainer)
	 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSCoreProject_SStereotypeContainer()
	 * @model containment="true"
	 * @generated
	 */
	SStereotypeContainer getSStereotypeContainer();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.saltCore.SCoreProject#getSStereotypeContainer <em>SStereotype Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SStereotype Container</em>' containment reference.
	 * @see #getSStereotypeContainer()
	 * @generated
	 */
	void setSStereotypeContainer(SStereotypeContainer value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addSGraph(SGraph sGraph);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	SGraph getSGraphById(Object sGraphId);

} // SCoreProject
