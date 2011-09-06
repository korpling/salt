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

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SLayer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSRelations <em>SRelations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSNodes <em>SNodes</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSGraph <em>SGraph</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSSubLayers <em>SSub Layers</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSSuperLayer <em>SSuper Layer</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage#getSLayer()
 * @model
 * @generated
 */
public interface SLayer extends Layer, SNamedElement, SIdentifiableElement, SProcessingAnnotatableElement, SAnnotatableElement, SMetaAnnotatableElement, SFeaturableElement {
	/**
	 * Returns the value of the '<em><b>SRelations</b></em>' reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation#getSLayers <em>SLayers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SRelations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SRelations</em>' reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage#getSLayer_SRelations()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation#getSLayers
	 * @model opposite="sLayers" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SRelation> getSRelations();

	/**
	 * Returns the value of the '<em><b>SNodes</b></em>' reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode#getSLayers <em>SLayers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SNodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SNodes</em>' reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage#getSLayer_SNodes()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode#getSLayers
	 * @model opposite="sLayers" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SNode> getSNodes();

	/**
	 * Returns the value of the '<em><b>SGraph</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraph#getSLayers <em>SLayers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SGraph</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SGraph</em>' reference.
	 * @see #setSGraph(SGraph)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage#getSLayer_SGraph()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraph#getSLayers
	 * @model opposite="sLayers" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	SGraph getSGraph();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSGraph <em>SGraph</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SGraph</em>' reference.
	 * @see #getSGraph()
	 * @generated
	 */
	void setSGraph(SGraph value);

	/**
	 * Returns the value of the '<em><b>SSub Layers</b></em>' reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSSuperLayer <em>SSuper Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SSub Layers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SSub Layers</em>' reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage#getSLayer_SSubLayers()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSSuperLayer
	 * @model opposite="sSuperLayer" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SLayer> getSSubLayers();

	/**
	 * Returns the value of the '<em><b>SSuper Layer</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSSubLayers <em>SSub Layers</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SSuper Layer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SSuper Layer</em>' reference.
	 * @see #setSSuperLayer(SLayer)
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage#getSLayer_SSuperLayer()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSSubLayers
	 * @model opposite="sSubLayers" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	SLayer getSSuperLayer();

	/**
	 * Sets the value of the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSSuperLayer <em>SSuper Layer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SSuper Layer</em>' reference.
	 * @see #getSSuperLayer()
	 * @generated
	 */
	void setSSuperLayer(SLayer value);

} // SLayer
