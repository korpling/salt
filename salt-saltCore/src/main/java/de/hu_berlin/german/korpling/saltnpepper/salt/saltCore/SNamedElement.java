/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SNamed Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNamedElement#getSName <em>SName</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage#getSNamedElement()
 * @model
 * @generated
 */
public interface SNamedElement extends SFeaturableElement {
	/**
	 * Returns the given name as name of this object. In a graph environment (when this object is contained in a {@link SGraph} object), 
	 * this name is used to generate the {@link SElementId} of this object. The value sName is a derived value and will
	 * be stored in a {@link SFeature} object. The name of the {@link SFeature} is set to 'sName', the namespace of 
	 * the {@link SFeature} is set to 'salt'.
	 * @return sName of this object.
	 * @see #setSName(String)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage#getSNamedElement_SName()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	String getSName();

	/**
	 * Sets the given name as name of this object. In a graph environment (when this object is contained in a {@link SGraph} object), 
	 * this name is used to generate the {@link SElementId} of this object. The value sName is a derived value and will
	 * be stored in a {@link SFeature} object. The name of the {@link SFeature} is set to 'sName', the namespace of 
	 * the {@link SFeature} is set to 'salt'.
	 * @param value represents the name of this object
	 * @see #getSName()
	 * @generated
	 */
	void setSName(String value);

} // SNamedElement
