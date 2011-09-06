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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SProcessing Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation#getSProcessingAnnotatableElement <em>SProcessing Annotatable Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage#getSProcessingAnnotation()
 * @model
 * @generated
 */
public interface SProcessingAnnotation extends SAbstractAnnotation {
	/**
	 * Returns the value of the '<em><b>SProcessing Annotatable Element</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotations <em>SProcessing Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SProcessing Annotatable Element</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SProcessing Annotatable Element</em>' container reference.
	 * @see #setSProcessingAnnotatableElement(SProcessingAnnotatableElement)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage#getSProcessingAnnotation_SProcessingAnnotatableElement()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotations
	 * @model opposite="sProcessingAnnotations" volatile="true" derived="true"
	 * @generated
	 */
	SProcessingAnnotatableElement getSProcessingAnnotatableElement();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation#getSProcessingAnnotatableElement <em>SProcessing Annotatable Element</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SProcessing Annotatable Element</em>' container reference.
	 * @see #getSProcessingAnnotatableElement()
	 * @generated
	 */
	void setSProcessingAnnotatableElement(SProcessingAnnotatableElement value);

} // SProcessingAnnotation
