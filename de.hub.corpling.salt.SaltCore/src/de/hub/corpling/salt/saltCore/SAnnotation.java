/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SAnnotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SAnnotation#getSName <em>SName</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SAnnotation#getSValue <em>SValue</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SAnnotation#getSAnnotatbaleElement <em>SAnnotatbale Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSAnnotation()
 * @model
 * @generated
 */
public interface SAnnotation extends EObject {

	/**
	 * Returns the value of the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SName</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SName</em>' attribute.
	 * @see #setSName(String)
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSAnnotation_SName()
	 * @model
	 * @generated
	 */
	String getSName();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCore.SAnnotation#getSName <em>SName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SName</em>' attribute.
	 * @see #getSName()
	 * @generated
	 */
	void setSName(String value);

	/**
	 * Returns the value of the '<em><b>SValue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SValue</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SValue</em>' attribute.
	 * @see #setSValue(String)
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSAnnotation_SValue()
	 * @model
	 * @generated
	 */
	String getSValue();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCore.SAnnotation#getSValue <em>SValue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SValue</em>' attribute.
	 * @see #getSValue()
	 * @generated
	 */
	void setSValue(String value);

	/**
	 * Returns the value of the '<em><b>SAnnotatbale Element</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hub.corpling.salt.saltCore.SAnnotatableElement#getSAnnotations <em>SAnnotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SAnnotatbale Element</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SAnnotatbale Element</em>' container reference.
	 * @see #setSAnnotatbaleElement(SAnnotatableElement)
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSAnnotation_SAnnotatbaleElement()
	 * @see de.hub.corpling.salt.saltCore.SAnnotatableElement#getSAnnotations
	 * @model opposite="sAnnotations" transient="false"
	 * @generated
	 */
	SAnnotatableElement getSAnnotatbaleElement();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCore.SAnnotation#getSAnnotatbaleElement <em>SAnnotatbale Element</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SAnnotatbale Element</em>' container reference.
	 * @see #getSAnnotatbaleElement()
	 * @generated
	 */
	void setSAnnotatbaleElement(SAnnotatableElement value);
} // SAnnotation
