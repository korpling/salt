/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.saltCore;

import de.util.graph.Edge;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SRelation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.corpling.salt.model.saltCore.SRelation#getSSourceElement <em>SSource Element</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.SRelation#getSDestinationElement <em>SDestination Element</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.SRelation#getSStereotypableElement <em>SStereotypable Element</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.SRelation#getSAnnotatableElement <em>SAnnotatable Element</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.SRelation#getSProcessingAnnotatableElement <em>SProcessing Annotatable Element</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.SRelation#getSGraph <em>SGraph</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.SRelation#getSType <em>SType</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSRelation()
 * @model
 * @generated
 */
public interface SRelation extends Edge, SIdentifiableElement, SAnnotatableElement, SStereotypeableElement, SProcessingAnnotatableElement 
{
	/**
	 * Returns the value of the '<em><b>SSource Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SSource Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SSource Element</em>' reference.
	 * @see #setSSourceElement(SElement)
	 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSRelation_SSourceElement()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	SElement getSSourceElement();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.saltCore.SRelation#getSSourceElement <em>SSource Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SSource Element</em>' reference.
	 * @see #getSSourceElement()
	 * @generated
	 */
	void setSSourceElement(SElement value);

	/**
	 * Returns the value of the '<em><b>SDestination Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SDestination Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SDestination Element</em>' reference.
	 * @see #setSDestinationElement(SElement)
	 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSRelation_SDestinationElement()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	SElement getSDestinationElement();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.saltCore.SRelation#getSDestinationElement <em>SDestination Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SDestination Element</em>' reference.
	 * @see #getSDestinationElement()
	 * @generated
	 */
	void setSDestinationElement(SElement value);

	/**
	 * Returns the value of the '<em><b>SStereotypable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SStereotypable Element</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SStereotypable Element</em>' containment reference.
	 * @see #setSStereotypableElement(SStereotypeableElement)
	 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSRelation_SStereotypableElement()
	 * @model containment="true" required="true"
	 * @generated
	 */
	SStereotypeableElement getSStereotypableElement();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.saltCore.SRelation#getSStereotypableElement <em>SStereotypable Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SStereotypable Element</em>' containment reference.
	 * @see #getSStereotypableElement()
	 * @generated
	 */
	void setSStereotypableElement(SStereotypeableElement value);

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
	 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSRelation_SAnnotatableElement()
	 * @model containment="true"
	 * @generated
	 */
	SAnnotatableElement getSAnnotatableElement();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.saltCore.SRelation#getSAnnotatableElement <em>SAnnotatable Element</em>}' containment reference.
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
	 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSRelation_SProcessingAnnotatableElement()
	 * @model containment="true"
	 * @generated
	 */
	SProcessingAnnotatableElement getSProcessingAnnotatableElement();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.saltCore.SRelation#getSProcessingAnnotatableElement <em>SProcessing Annotatable Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SProcessing Annotatable Element</em>' containment reference.
	 * @see #getSProcessingAnnotatableElement()
	 * @generated
	 */
	void setSProcessingAnnotatableElement(SProcessingAnnotatableElement value);

	/**
	 * Returns the value of the '<em><b>SGraph</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.corpling.salt.model.saltCore.SGraph#getSRelations <em>SRelations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SGraph</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SGraph</em>' container reference.
	 * @see #setSGraph(SGraph)
	 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSRelation_SGraph()
	 * @see de.corpling.salt.model.saltCore.SGraph#getSRelations
	 * @model opposite="sRelations" volatile="true" derived="true"
	 * @generated
	 */
	SGraph getSGraph();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.saltCore.SRelation#getSGraph <em>SGraph</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SGraph</em>' container reference.
	 * @see #getSGraph()
	 * @generated
	 */
	void setSGraph(SGraph value);

	/**
	 * Returns the value of the '<em><b>SType</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SType</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SType</em>' attribute.
	 * @see #setSType(String)
	 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSRelation_SType()
	 * @model
	 * @generated
	 */
	String getSType();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.saltCore.SRelation#getSType <em>SType</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SType</em>' attribute.
	 * @see #getSType()
	 * @generated
	 */
	void setSType(String value);

} // SRelation
