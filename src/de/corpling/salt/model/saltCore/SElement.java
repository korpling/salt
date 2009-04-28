/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.saltCore;

import de.util.graph.Node;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SElement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.corpling.salt.model.saltCore.SElement#getSSterotypeableElement <em>SSterotypeable Element</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.SElement#getSAnnotatableElement <em>SAnnotatable Element</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.SElement#getSProcessingAnnotatableElement <em>SProcessing Annotatable Element</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.SElement#getSGraph <em>SGraph</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSElement()
 * @model
 * @generated
 */
public interface SElement extends SIdentifiableElement, SAnnotatableElement, SStereotypeableElement, SProcessingAnnotatableElement, Node {

	/**
	 * Returns the value of the '<em><b>SSterotypeable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SSterotypeable Element</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SSterotypeable Element</em>' containment reference.
	 * @see #setSSterotypeableElement(SStereotypeableElement)
	 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSElement_SSterotypeableElement()
	 * @model containment="true" required="true"
	 * @generated
	 */
	SStereotypeableElement getSSterotypeableElement();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.saltCore.SElement#getSSterotypeableElement <em>SSterotypeable Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SSterotypeable Element</em>' containment reference.
	 * @see #getSSterotypeableElement()
	 * @generated
	 */
	void setSSterotypeableElement(SStereotypeableElement value);

	/**
	 * Returns the value of the '<em><b>SAnnotatable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SAnnotatable Element</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SAnnotatable Element</em>' containment reference.
	 * @see #setSAnnotatableElement(SAnnotatableElement)
	 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSElement_SAnnotatableElement()
	 * @model containment="true"
	 * @generated
	 */
	SAnnotatableElement getSAnnotatableElement();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.saltCore.SElement#getSAnnotatableElement <em>SAnnotatable Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SAnnotatable Element</em>' containment reference.
	 * @see #getSAnnotatableElement()
	 * @generated
	 */
	void setSAnnotatableElement(SAnnotatableElement value);

	/**
	 * Returns the value of the '<em><b>SProcessing Annotatable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SProcessing Annotatable Element</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SProcessing Annotatable Element</em>' containment reference.
	 * @see #setSProcessingAnnotatableElement(SProcessingAnnotatableElement)
	 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSElement_SProcessingAnnotatableElement()
	 * @model containment="true"
	 * @generated
	 */
	SProcessingAnnotatableElement getSProcessingAnnotatableElement();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.saltCore.SElement#getSProcessingAnnotatableElement <em>SProcessing Annotatable Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SProcessing Annotatable Element</em>' containment reference.
	 * @see #getSProcessingAnnotatableElement()
	 * @generated
	 */
	void setSProcessingAnnotatableElement(SProcessingAnnotatableElement value);

	/**
	 * Returns the value of the '<em><b>SGraph</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.corpling.salt.model.saltCore.SGraph#getSElements <em>SElements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SGraph</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SGraph</em>' container reference.
	 * @see #setSGraph(SGraph)
	 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSElement_SGraph()
	 * @see de.corpling.salt.model.saltCore.SGraph#getSElements
	 * @model opposite="sElements" volatile="true" derived="true"
	 * @generated
	 */
	SGraph getSGraph();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.saltCore.SElement#getSGraph <em>SGraph</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SGraph</em>' container reference.
	 * @see #getSGraph()
	 * @generated
	 */
	void setSGraph(SGraph value);
} // SElement
