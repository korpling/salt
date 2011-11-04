/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure;

import org.eclipse.emf.ecore.EObject;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltValidateException;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SData Source Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence#getSStart <em>SStart</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence#getSEnd <em>SEnd</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence#getSSequentialDS <em>SSequential DS</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDataSourceSequence()
 * @model
 * @generated
 */
public interface SDataSourceSequence extends EObject {
	/**
	 * Returns the value of the '<em><b>SStart</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SStart</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SStart</em>' attribute.
	 * @see #setSStart(Integer)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDataSourceSequence_SStart()
	 * @model
	 * @generated
	 */
	Integer getSStart();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence#getSStart <em>SStart</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SStart</em>' attribute.
	 * @see #getSStart()
	 * @generated
	 */
	void setSStart(Integer value);

	/**
	 * Returns the value of the '<em><b>SEnd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SEnd</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SEnd</em>' attribute.
	 * @see #setSEnd(Integer)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDataSourceSequence_SEnd()
	 * @model
	 * @generated
	 */
	Integer getSEnd();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence#getSEnd <em>SEnd</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SEnd</em>' attribute.
	 * @see #getSEnd()
	 * @generated
	 */
	void setSEnd(Integer value);

	/**
	 * Returns the value of the '<em><b>SSequential DS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SSequential DS</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SSequential DS</em>' reference.
	 * @see #setSSequentialDS(SSequentialDS)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSDataSourceSequence_SSequentialDS()
	 * @model
	 * @generated
	 */
	SSequentialDS getSSequentialDS();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence#getSSequentialDS <em>SSequential DS</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SSequential DS</em>' reference.
	 * @see #getSSequentialDS()
	 * @generated
	 */
	void setSSequentialDS(SSequentialDS value);

	/**
	 * Checks if this object is valid. Means, that the given start and end points are inside the borders 
	 * of the set data source. This method throws an {@link SaltValidateException} if this object is not
	 * valid and returns true, if it is.
	 * @return true, if and only if the object is valid 
	 * @model
	 */
	Boolean validate();

} // SDataSourceSequence
