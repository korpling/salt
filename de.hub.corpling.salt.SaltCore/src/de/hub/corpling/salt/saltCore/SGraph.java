/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SGraph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SGraph#getSRelations <em>SRelations</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SGraph#getSNodes <em>SNodes</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSGraph()
 * @model
 * @generated
 */
public interface SGraph extends SNamedElement, SAnnotatableElement, SIdentifiableElement {
	/**
	 * Returns the value of the '<em><b>SRelations</b></em>' containment reference list.
	 * The list contents are of type {@link de.hub.corpling.salt.saltCore.SRelation}.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCore.SRelation#getSGraph <em>SGraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SRelations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SRelations</em>' containment reference list.
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSGraph_SRelations()
	 * @see de.hub.corpling.salt.saltCore.SRelation#getSGraph
	 * @model opposite="sGraph" containment="true"
	 * @generated
	 */
	EList<SRelation> getSRelations();

	/**
	 * Returns the value of the '<em><b>SNodes</b></em>' containment reference list.
	 * The list contents are of type {@link de.hub.corpling.salt.saltCore.SNode}.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCore.SNode#getSGraph <em>SGraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SNodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SNodes</em>' containment reference list.
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSGraph_SNodes()
	 * @see de.hub.corpling.salt.saltCore.SNode#getSGraph
	 * @model opposite="sGraph" containment="true"
	 * @generated
	 */
	EList<SNode> getSNodes();

} // SGraph
