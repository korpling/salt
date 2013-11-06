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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCore;

import org.eclipse.emf.common.util.EList;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SAnnotatable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#getSAnnotations <em>SAnnotations</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage#getSAnnotatableElement()
 * @model
 * @generated
 */
public interface SAnnotatableElement extends LabelableElement {
	/**
	 * Returns the value of the '<em><b>SAnnotations</b></em>' containment reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation#getSAnnotatableElement <em>SAnnotatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SAnnotations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SAnnotations</em>' containment reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage#getSAnnotatableElement_SAnnotations()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation#getSAnnotatableElement
	 * @model opposite="sAnnotatableElement" containment="true" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SAnnotation> getSAnnotations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addSAnnotation(SAnnotation sAnnotation);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	SAnnotation getSAnnotation(String qName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	SAnnotation createSAnnotation(String sNS, String sName, Object sValue, SDATATYPE sValueType);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	SAnnotation createSAnnotation(String sNS, String sName, String sValueString);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * This method parses the given annotation String and adds an {@link SAnnotation} object for each 
	 * annotation being contained in that string to the given {@link SAnnotatableElement} object. The
	 * syntax for Annotations is:<br/>
	 * (SNS::)?SNAME(=SVALUE)?(;SNS::SNAME=SVALUE)+ 
	 * <br/>
	 * where SNS is the namespace of the annotation, SNAME is its name and SVALUE is the value of the annotation
	 * @param annotationString String containing the annotations
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	EList<SAnnotation> createSAnnotations(String annottaionString);

} // SAnnotatableElement
