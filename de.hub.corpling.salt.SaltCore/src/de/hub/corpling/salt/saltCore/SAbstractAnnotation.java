/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore;

import de.hub.corpling.graph.Label;
import org.eclipse.emf.common.util.URI;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SAbstract Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.SAbstractAnnotation#getSNS <em>SNS</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SAbstractAnnotation#getSName <em>SName</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SAbstractAnnotation#getSValue <em>SValue</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.SAbstractAnnotation#getSValueType <em>SValue Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSAbstractAnnotation()
 * @model abstract="true"
 * @generated
 */
public interface SAbstractAnnotation extends Label {
	/**
	 * Returns the value of the '<em><b>SNS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SNS</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SNS</em>' attribute.
	 * @see #setSNS(String)
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSAbstractAnnotation_SNS()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	String getSNS();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCore.SAbstractAnnotation#getSNS <em>SNS</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SNS</em>' attribute.
	 * @see #getSNS()
	 * @generated
	 */
	void setSNS(String value);

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
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSAbstractAnnotation_SName()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	String getSName();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCore.SAbstractAnnotation#getSName <em>SName</em>}' attribute.
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
	 * @see #setSValue(Object)
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSAbstractAnnotation_SValue()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	Object getSValue();

	/**
	 * Sets the value of the '{@link de.hub.corpling.salt.saltCore.SAbstractAnnotation#getSValue <em>SValue</em>}' attribute.
	 * This method also sets the sValueType attribute to one of the supported Datatypes in SDATATYPE.
	 * null--> SOBJECT
	 * String --> STEXT
	 * Boolean --> SBOOLEAN
	 * Integer --> SNUMERIC
	 * Long --> SNUMERIC
	 * Double --> SFLOAT
	 * Float --> SFLOAT
	 * URI --> SURI
	 * else --> SOBJECT
	 * @param value the new value of the '<em>SValue</em>' attribute.
	 * @see #getSValue()
	 * @generated
	 */
	void setSValue(Object value);

	/**
	 * Returns the value of the '<em><b>SValue Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.hub.corpling.salt.saltCore.SDATATYPE}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SValue Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SValue Type</em>' attribute.
	 * @see de.hub.corpling.salt.saltCore.SDATATYPE
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSAbstractAnnotation_SValueType()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	SDATATYPE getSValueType();

	/**
	 * Returns the sValue attribute of this object as String representation. If the sValue is of
	 * type String it will be returned, else the toString()-method will be called. If no value is given,
	 * null will be returned.
	 * @return String representation of the sValue attribute.
	 * @generated  
	 */
	String getSValueSTEXT();

	/**
	 * Returns the sValue attribute of this object as Boolean if possible. If the value is
	 * not of type Boolean or is empty, null will be returned.
	 * @return Boolean representation of the sValue attribute.
	 * @generated 
	 */
	Boolean getSValueSBOOLEAN();

	/**
	 * Returns the sValue attribute of this object as Long if possible. If the value is
	 * not of type Long or is empty, null will be returned.
	 * @return Long representation of the sValue attribute. 
	 * @generated
	 */
	Long getSValueSNUMERIC();

	/**
	 * Returns the sValue attribute of this object as Float if possible. If the value is
	 * not of type Float or is empty, null will be returned.
	 * @return Float representation of the sValue attribute. 
	 * @generated
	 */
	Double getSValueSFLOAT();

	/**
	 * Returns the sValue attribute of this object as URI if possible. If the value is
	 * not of type URI or is empty, null will be returned.
	 * @return URI representation of the sValue attribute. 
	 * @generated
	 */
	URI getSValueSURI();

	/**
	 * Returns the the sValue attribute of this object as the original object. This will always work
	 * as long as sValue is not empty. If the sValue attribute is empty null will be returned. 
	 * @return Object representation of the sValue attribute
	 * @generated
	 */
	Object getSValueSOBJECT();
} // SAbstractAnnotation
