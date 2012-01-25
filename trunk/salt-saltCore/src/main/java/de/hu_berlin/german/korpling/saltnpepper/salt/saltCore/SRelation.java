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

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SRelation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation#getSSource <em>SSource</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation#getSTarget <em>STarget</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation#getSGraph <em>SGraph</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation#getSTypes <em>STypes</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation#getSLayers <em>SLayers</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage#getSRelation()
 * @model
 * @generated
 */
public interface SRelation extends Edge, SAnnotatableElement, SNamedElement, SIdentifiableElement, SProcessingAnnotatableElement, SFeaturableElement, SMetaAnnotatableElement {
	/**
	 * Returns the value of the '<em><b>SSource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SSource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SSource</em>' reference.
	 * @see #setSSource(SNode)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage#getSRelation_SSource()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	SNode getSSource();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation#getSSource <em>SSource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SSource</em>' reference.
	 * @see #getSSource()
	 * @generated
	 */
	void setSSource(SNode value);

	/**
	 * Returns the value of the '<em><b>STarget</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>STarget</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>STarget</em>' reference.
	 * @see #setSTarget(SNode)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage#getSRelation_STarget()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	SNode getSTarget();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation#getSTarget <em>STarget</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>STarget</em>' reference.
	 * @see #getSTarget()
	 * @generated
	 */
	void setSTarget(SNode value);

	/**
	 * Returns the value of the '<em><b>SGraph</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraph#getSRelations <em>SRelations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SGraph</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SGraph</em>' reference.
	 * @see #setSGraph(SGraph)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage#getSRelation_SGraph()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraph#getSRelations
	 * @model opposite="sRelations" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	SGraph getSGraph();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation#getSGraph <em>SGraph</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SGraph</em>' reference.
	 * @see #getSGraph()
	 * @generated
	 */
	void setSGraph(SGraph value);

	/**
	 * Returns the value of the '<em><b>STypes</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>STypes</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>STypes</em>' attribute list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage#getSRelation_STypes()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<String> getSTypes();

	/**
	 * Returns the value of the '<em><b>SLayers</b></em>' reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSRelations <em>SRelations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SLayers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SLayers</em>' reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage#getSRelation_SLayers()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSRelations
	 * @model opposite="sRelations" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SLayer> getSLayers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addSType(String sType);
	
	/**
	 * Sets the identifier of this node SRelation object. Note, that an identifier must be unique inside the graph 
	 * which contains the node. The id can also be used as an uri and therefore has to respect some syntax 
	 * restrictions. In general the identifier will be set by the graph when adding the SRelation object to 
	 * the graph, therefore in most cases it would be better to take the identifier given by the graph and not
	 * to change it. To have an influence on the id set the name of the SRelation object by calling
	 * setSName().  
	 * @param value the new value of the '<em>SElement Id</em>' reference.
	 * @see #getSElementId()
	 */
	@Override
	void setSElementId(SElementId value);

} // SRelation
