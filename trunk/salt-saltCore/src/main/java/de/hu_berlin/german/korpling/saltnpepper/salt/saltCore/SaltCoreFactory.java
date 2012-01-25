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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage
 * @generated
 */
public interface SaltCoreFactory extends EFactory {
	
	/**
	 * An enumeration of all fields in SaltCore represented by a {@link SFeature} object.
	 * 
	 * @author Florian Zipser
	 */
	public enum SALT_CORE_SFEATURES {SNAME, STYPE};
	
	/**
	 * The namespace used for {@link SFeature} objects. 
	 */
	public final String SALT_CORE_NAMESPACE="salt";
	
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SaltCoreFactory eINSTANCE = de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCoreFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>SNode</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SNode</em>'.
	 * @generated
	 */
	SNode createSNode();

	/**
	 * Returns a new object of class '<em>SRelation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SRelation</em>'.
	 * @generated
	 */
	SRelation createSRelation();

	/**
	 * Returns a new object of class '<em>SAnnotatable Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SAnnotatable Element</em>'.
	 * @generated
	 */
	SAnnotatableElement createSAnnotatableElement();

	/**
	 * Returns a new object of class '<em>SAnnotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SAnnotation</em>'.
	 * @generated
	 */
	SAnnotation createSAnnotation();

	/**
	 * Returns a new object of class '<em>SGraph</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SGraph</em>'.
	 * @generated
	 */
	SGraph createSGraph();

	/**
	 * Returns a new object of class '<em>SNamed Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SNamed Element</em>'.
	 * @generated
	 */
	SNamedElement createSNamedElement();

	/**
	 * Returns a new object of class '<em>SIdentifiable Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SIdentifiable Element</em>'.
	 * @generated
	 */
	SIdentifiableElement createSIdentifiableElement();

	/**
	 * Returns a new object of class '<em>SProcessing Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SProcessing Annotation</em>'.
	 * @generated
	 */
	SProcessingAnnotation createSProcessingAnnotation();

	/**
	 * Returns a new object of class '<em>SProcessing Annotatable Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SProcessing Annotatable Element</em>'.
	 * @generated
	 */
	SProcessingAnnotatableElement createSProcessingAnnotatableElement();

	/**
	 * Returns a new object of class '<em>SElement Id</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SElement Id</em>'.
	 * @generated
	 */
	SElementId createSElementId();

	/**
	 * Returns a new object of class '<em>SFeature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SFeature</em>'.
	 * @generated
	 */
	SFeature createSFeature();

	/**
	 * Returns a new object of class '<em>SFeaturable Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SFeaturable Element</em>'.
	 * @generated
	 */
	SFeaturableElement createSFeaturableElement();

	/**
	 * Returns a new object of class '<em>SMeta Annotatable Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SMeta Annotatable Element</em>'.
	 * @generated
	 */
	SMetaAnnotatableElement createSMetaAnnotatableElement();

	/**
	 * Returns a new object of class '<em>SMeta Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SMeta Annotation</em>'.
	 * @generated
	 */
	SMetaAnnotation createSMetaAnnotation();

	/**
	 * Returns a new object of class '<em>SLayer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SLayer</em>'.
	 * @generated
	 */
	SLayer createSLayer();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SaltCorePackage getSaltCorePackage();

} //SaltCoreFactory
