/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.saltCore;

import de.util.graph.Graph;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SGraph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.corpling.salt.model.saltCore.SGraph#getSElements <em>SElements</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.SGraph#getSRelations <em>SRelations</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.SGraph#getSCoreProject <em>SCore Project</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSGraph()
 * @model
 * @generated
 */
public interface SGraph extends Graph {
	/**
	 * Returns the value of the '<em><b>SElements</b></em>' containment reference list.
	 * The list contents are of type {@link de.corpling.salt.model.saltCore.SElement}.
	 * It is bidirectional and its opposite is '{@link de.corpling.salt.model.saltCore.SElement#getSGraph <em>SGraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SElements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SElements</em>' containment reference list.
	 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSGraph_SElements()
	 * @see de.corpling.salt.model.saltCore.SElement#getSGraph
	 * @model opposite="sGraph" containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SElement> getSElements();

	/**
	 * Returns the value of the '<em><b>SRelations</b></em>' containment reference list.
	 * The list contents are of type {@link de.corpling.salt.model.saltCore.SRelation}.
	 * It is bidirectional and its opposite is '{@link de.corpling.salt.model.saltCore.SRelation#getSGraph <em>SGraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SRelations</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SRelations</em>' containment reference list.
	 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSGraph_SRelations()
	 * @see de.corpling.salt.model.saltCore.SRelation#getSGraph
	 * @model opposite="sGraph" containment="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<SRelation> getSRelations();

	/**
	 * Returns the value of the '<em><b>SCore Project</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.corpling.salt.model.saltCore.SCoreProject#getSGraphs <em>SGraphs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SCore Project</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SCore Project</em>' container reference.
	 * @see #setSCoreProject(SCoreProject)
	 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSGraph_SCoreProject()
	 * @see de.corpling.salt.model.saltCore.SCoreProject#getSGraphs
	 * @model opposite="sGraphs" transient="false"
	 * @generated
	 */
	SCoreProject getSCoreProject();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.saltCore.SGraph#getSCoreProject <em>SCore Project</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SCore Project</em>' container reference.
	 * @see #getSCoreProject()
	 * @generated
	 */
	void setSCoreProject(SCoreProject value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addSElement(SElement sElement);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	SElement getSElementById(Object sElementId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<SElement> getSElementsByStereotype(SStereotype sStereotype);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addSRelation(SRelation sRelation);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	SRelation getSRelationById(Object sRelationId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<SRelation> getSRelationsByStereotype(SStereotype sStereotype);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<SElement> getSRoots();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<SElement> getSRootsBySStereotypeRelation(SStereotype sStereotype);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model startSElementsMany="false"
	 */
	void traverseSGraph(STRAVERSAL_MODE sTraversalMode, EList<SElement> startSElements, STraversalObject sTraversalObject, SStereotype sStereotype);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void traverseSGraph(STRAVERSAL_MODE sTraversalMode, SElement startSElements, STraversalObject sTraversalObject, SStereotype sStereotype);

} // SGraph
