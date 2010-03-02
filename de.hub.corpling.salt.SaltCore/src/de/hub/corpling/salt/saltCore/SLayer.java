/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore;

import de.hub.corpling.graph.Layer;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SLayer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SLayer#getSRelations <em>SRelations</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SLayer#getSNodes <em>SNodes</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SLayer#getSGraph <em>SGraph</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSLayer()
 * @model
 * @generated
 */
public interface SLayer extends Layer, SNamedElement, SIdentifiableElement, SProcessingAnnotatableElement, SAnnotatableElement, SMetaAnnotatableElement, SFeaturableElement {
	/**
	 * Returns the value of the '<em><b>SRelations</b></em>' reference list.
	 * The list contents are of type {@link de.hub.corpling.salt.saltCore.SRelation}.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCore.SRelation#getSLayers <em>SLayers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SRelations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SRelations</em>' reference list.
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSLayer_SRelations()
	 * @see de.hub.corpling.salt.saltCore.SRelation#getSLayers
	 * @model opposite="sLayers" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SRelation> getSRelations();

	/**
	 * Returns the value of the '<em><b>SNodes</b></em>' reference list.
	 * The list contents are of type {@link de.hub.corpling.salt.saltCore.SNode}.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCore.SNode#getSLayers <em>SLayers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SNodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SNodes</em>' reference list.
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSLayer_SNodes()
	 * @see de.hub.corpling.salt.saltCore.SNode#getSLayers
	 * @model opposite="sLayers" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SNode> getSNodes();

	/**
	 * Returns the value of the '<em><b>SGraph</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCore.SGraph#getSLayers <em>SLayers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SGraph</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SGraph</em>' reference.
	 * @see #setSGraph(SGraph)
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSLayer_SGraph()
	 * @see de.hub.corpling.salt.saltCore.SGraph#getSLayers
	 * @model opposite="sLayers" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	SGraph getSGraph();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCore.SLayer#getSGraph <em>SGraph</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SGraph</em>' reference.
	 * @see #getSGraph()
	 * @generated
	 */
	void setSGraph(SGraph value);

} // SLayer
