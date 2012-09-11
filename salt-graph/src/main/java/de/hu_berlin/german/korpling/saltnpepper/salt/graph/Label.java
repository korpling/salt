/**
 * Copyright 2009 Humboldt University of Berlin, INRIA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
package de.hu_berlin.german.korpling.saltnpepper.salt.graph;

import javax.xml.stream.events.Namespace;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Label</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#getName <em>Name</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#getQName <em>QName</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#getValue <em>Value</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#getLabelableElement <em>Labelable Element</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#getValueString <em>Value String</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage#getLabel()
 * @model
 * @generated
 */
public interface Label extends LabelableElement 
{
	/**
	 * Seperator for namespaces and and between namespace and name.
	 */
	public static final String NS_SEPERATOR= "::";
	
	/**
     * Returns the value of the '<em><b>Namespace</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Namespace</em>' attribute.
     * @see #setNamespace(String)
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage#getLabel_Namespace()
     * @model
     * @generated
     */
	String getNamespace();

	/**
     * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#getNamespace <em>Namespace</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Namespace</em>' attribute.
     * @see #getNamespace()
     * @generated
     */
	void setNamespace(String value);

	/**
     * Returns the value of the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Name</em>' attribute.
     * @see #setName(String)
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage#getLabel_Name()
     * @model
     * @generated
     */
	String getName();

	/**
     * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#getName <em>Name</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Name</em>' attribute.
     * @see #getName()
     * @generated
     */
	void setName(String value);

	/**
     * Returns the value of the '<em><b>QName</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * Returns the full qualified name of this {@link Label} object. A full qualified name contains of the following:
	 * {@link #getNamespace()})+{@value #NS_SEPERATOR}+{@link #getName()}
	 * 
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>QName</em>' attribute.
     * @see #setQName(String)
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage#getLabel_QName()
     * @model transient="true" volatile="true" derived="true"
     * @generated
     */
	String getQName();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#getQName <em>QName</em>}' attribute.
	 * Sets the full qualified name of this {@link Label} object. A full qualified name contains of the following:
	 * {@link #getNamespace()})+{@link #NS_SEPERATOR}+{@link #getName()}
	 * Therefore the two parts of it are set via {@link #setNamespace(String)} and {@link #setName(String)}.
	 * @param value the new value of the '<em>QName</em>' attribute.
	 * @see #getQName()
	 * @generated
	 */
	void setQName(String value);

	/**
     * Returns the value of the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Value</em>' attribute.
     * @see #setValue(Object)
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage#getLabel_Value()
     * @model
     * @generated
     */
	Object getValue();

	/**
     * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#getValue <em>Value</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Value</em>' attribute.
     * @see #getValue()
     * @generated
     */
	void setValue(Object value);

	/**
     * Returns the value of the '<em><b>Labelable Element</b></em>' container reference.
     * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement#getLabels <em>Labels</em>}'.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Labelable Element</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Labelable Element</em>' container reference.
     * @see #setLabelableElement(LabelableElement)
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage#getLabel_LabelableElement()
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement#getLabels
     * @model opposite="labels" transient="false"
     * @generated
     */
	LabelableElement getLabelableElement();

	/**
     * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#getLabelableElement <em>Labelable Element</em>}' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Labelable Element</em>' container reference.
     * @see #getLabelableElement()
     * @generated
     */
	void setLabelableElement(LabelableElement value);

	/**
	 * Returns the value of {@link #getValue()} as its string representation. The value valueString only exists
	 * for persisting the model. 
	 * @return the value of the '<em>Value String</em>' attribute.
	 * @see #setValueString(String)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage#getLabel_ValueString()
	 * @model volatile="true" derived="true"
	 * @generated
	 */
	String getValueString();

	/**
	 * Attention this method does nothing, the given value will not be stored anyway. This method only exists 
	 * for persisting the model.
	 * @param value the new value of the '<em>Value String</em>' attribute.
	 * @see #getValueString()
	 * @generated
	 */
	void setValueString(String value);

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @model kind="operation"
     * @generated
     */
	String getNSSeperator();

	/**
	 * Returns a new object of type {@link Label}, which has the same properties like this. 
	 * @generated
	 */
	Object clone();

} // Label
