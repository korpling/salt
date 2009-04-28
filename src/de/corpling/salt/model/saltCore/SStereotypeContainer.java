/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.saltCore;

import java.util.Properties;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SStereotype Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.corpling.salt.model.saltCore.SStereotypeContainer#getSStereotypes <em>SStereotypes</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSStereotypeContainer()
 * @model
 * @generated
 */
public interface SStereotypeContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>SStereotypes</b></em>' containment reference list.
	 * The list contents are of type {@link de.corpling.salt.model.saltCore.SStereotype}.
	 * It is bidirectional and its opposite is '{@link de.corpling.salt.model.saltCore.SStereotype#getSProject <em>SProject</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SStereotypes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SStereotypes</em>' containment reference list.
	 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSStereotypeContainer_SStereotypes()
	 * @see de.corpling.salt.model.saltCore.SStereotype#getSProject
	 * @model opposite="sProject" containment="true"
	 * @generated
	 */
	EList<SStereotype> getSStereotypes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	SStereotype getSStereotypeByName(String sStereotypeName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model propertiesDataType="de.corpling.salt.model.saltCore.Properties"
	 * @generated
	 */
	void setSStereotypes(Properties properties);

} // SStereotypeContainer
