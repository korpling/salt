/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.saltCore;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SElement Path</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.corpling.salt.model.saltCore.SElementPath#getParentPath <em>Parent Path</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.SElementPath#getSElement <em>SElement</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.SElementPath#getName <em>Name</em>}</li>
 *   <li>{@link de.corpling.salt.model.saltCore.SElementPath#getElementType <em>Element Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSElementPath()
 * @model
 * @generated
 */
public interface SElementPath extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Path</em>' attribute.
	 * @see #setParentPath(String)
	 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSElementPath_ParentPath()
	 * @model
	 * @generated
	 */
	String getParentPath();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.saltCore.SElementPath#getParentPath <em>Parent Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Path</em>' attribute.
	 * @see #getParentPath()
	 * @generated
	 */
	void setParentPath(String value);

	/**
	 * Returns the value of the '<em><b>SElement</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.corpling.salt.model.saltCore.SIdentifiableElement#getSElementPath <em>SElement Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SElement</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SElement</em>' container reference.
	 * @see #setSElement(SIdentifiableElement)
	 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSElementPath_SElement()
	 * @see de.corpling.salt.model.saltCore.SIdentifiableElement#getSElementPath
	 * @model opposite="sElementPath" required="true" transient="false"
	 * @generated
	 */
	SIdentifiableElement getSElement();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.saltCore.SElementPath#getSElement <em>SElement</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SElement</em>' container reference.
	 * @see #getSElement()
	 * @generated
	 */
	void setSElement(SIdentifiableElement value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSElementPath_Name()
	 * @model default="" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.saltCore.SElementPath#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Element Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.corpling.salt.model.saltCore.SELEMENT_TYPE}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Type</em>' attribute.
	 * @see de.corpling.salt.model.saltCore.SELEMENT_TYPE
	 * @see #setElementType(SELEMENT_TYPE)
	 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSElementPath_ElementType()
	 * @model transient="true" volatile="true"
	 * @generated
	 */
	SELEMENT_TYPE getElementType();

	/**
	 * Sets the value of the '{@link de.corpling.salt.model.saltCore.SElementPath#getElementType <em>Element Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Type</em>' attribute.
	 * @see de.corpling.salt.model.saltCore.SELEMENT_TYPE
	 * @see #getElementType()
	 * @generated
	 */
	void setElementType(SELEMENT_TYPE value);

} // SElementPath
