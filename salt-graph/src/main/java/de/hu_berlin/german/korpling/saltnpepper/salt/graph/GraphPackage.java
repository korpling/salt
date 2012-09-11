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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphFactory
 * @model kind="package"
 * @generated
 */
public interface GraphPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "graph";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "graph";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "graph";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	GraphPackage eINSTANCE = de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphPackageImpl.init();

	/**
     * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.IdentifiableElementImpl <em>Identifiable Element</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.IdentifiableElementImpl
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphPackageImpl#getIdentifiableElement()
     * @generated
     */
	int IDENTIFIABLE_ELEMENT = 3;

	/**
     * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.NodeImpl <em>Node</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.NodeImpl
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphPackageImpl#getNode()
     * @generated
     */
	int NODE = 0;

	/**
     * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.LabelableElementImpl <em>Labelable Element</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.LabelableElementImpl
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphPackageImpl#getLabelableElement()
     * @generated
     */
	int LABELABLE_ELEMENT = 1;

	/**
     * The feature id for the '<em><b>Labels</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LABELABLE_ELEMENT__LABELS = 0;

	/**
     * The number of structural features of the '<em>Labelable Element</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LABELABLE_ELEMENT_FEATURE_COUNT = 1;

	/**
     * The feature id for the '<em><b>Labels</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IDENTIFIABLE_ELEMENT__LABELS = LABELABLE_ELEMENT__LABELS;

	/**
     * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.EdgeImpl <em>Edge</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.EdgeImpl
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphPackageImpl#getEdge()
     * @generated
     */
	int EDGE = 2;

	/**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IDENTIFIABLE_ELEMENT__ID = LABELABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Identifier</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IDENTIFIABLE_ELEMENT__IDENTIFIER = LABELABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Identifiable Element</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IDENTIFIABLE_ELEMENT_FEATURE_COUNT = LABELABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Labels</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NODE__LABELS = IDENTIFIABLE_ELEMENT__LABELS;

	/**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NODE__ID = IDENTIFIABLE_ELEMENT__ID;

	/**
     * The feature id for the '<em><b>Identifier</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NODE__IDENTIFIER = IDENTIFIABLE_ELEMENT__IDENTIFIER;

	/**
     * The feature id for the '<em><b>Graph</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NODE__GRAPH = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Layers</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NODE__LAYERS = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Node</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int NODE_FEATURE_COUNT = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Labels</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EDGE__LABELS = IDENTIFIABLE_ELEMENT__LABELS;

	/**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EDGE__ID = IDENTIFIABLE_ELEMENT__ID;

	/**
     * The feature id for the '<em><b>Identifier</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EDGE__IDENTIFIER = IDENTIFIABLE_ELEMENT__IDENTIFIER;

	/**
     * The feature id for the '<em><b>Graph</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EDGE__GRAPH = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Source</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EDGE__SOURCE = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Target</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EDGE__TARGET = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Layers</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EDGE__LAYERS = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
     * The number of structural features of the '<em>Edge</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int EDGE_FEATURE_COUNT = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 4;


	/**
     * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.LabelImpl <em>Label</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.LabelImpl
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphPackageImpl#getLabel()
     * @generated
     */
	int LABEL = 4;

	/**
     * The feature id for the '<em><b>Labels</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LABEL__LABELS = LABELABLE_ELEMENT__LABELS;

	/**
     * The feature id for the '<em><b>Namespace</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LABEL__NAMESPACE = LABELABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LABEL__NAME = LABELABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>QName</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LABEL__QNAME = LABELABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LABEL__VALUE = LABELABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Labelable Element</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LABEL__LABELABLE_ELEMENT = LABELABLE_ELEMENT_FEATURE_COUNT + 4;

	/**
     * The feature id for the '<em><b>Value String</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LABEL__VALUE_STRING = LABELABLE_ELEMENT_FEATURE_COUNT + 5;

	/**
     * The number of structural features of the '<em>Label</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LABEL_FEATURE_COUNT = LABELABLE_ELEMENT_FEATURE_COUNT + 6;


	/**
     * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphImpl <em>Graph</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphImpl
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphPackageImpl#getGraph()
     * @generated
     */
	int GRAPH = 5;

	/**
     * The feature id for the '<em><b>Labels</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GRAPH__LABELS = IDENTIFIABLE_ELEMENT__LABELS;

	/**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GRAPH__ID = IDENTIFIABLE_ELEMENT__ID;

	/**
     * The feature id for the '<em><b>Identifier</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GRAPH__IDENTIFIER = IDENTIFIABLE_ELEMENT__IDENTIFIER;

	/**
     * The feature id for the '<em><b>Index Mgr</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GRAPH__INDEX_MGR = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GRAPH__NODES = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Edges</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GRAPH__EDGES = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Num Of Nodes</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GRAPH__NUM_OF_NODES = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Num Of Edges</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GRAPH__NUM_OF_EDGES = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 4;

	/**
     * The feature id for the '<em><b>Layers</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GRAPH__LAYERS = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 5;

	/**
     * The feature id for the '<em><b>Num Of Layers</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GRAPH__NUM_OF_LAYERS = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 6;

	/**
     * The number of structural features of the '<em>Graph</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int GRAPH_FEATURE_COUNT = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 7;


	/**
     * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.IdentifierImpl <em>Identifier</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.IdentifierImpl
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphPackageImpl#getIdentifier()
     * @generated
     */
	int IDENTIFIER = 6;

	/**
     * The feature id for the '<em><b>Labels</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IDENTIFIER__LABELS = LABEL__LABELS;

	/**
     * The feature id for the '<em><b>Namespace</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IDENTIFIER__NAMESPACE = LABEL__NAMESPACE;

	/**
     * The feature id for the '<em><b>Name</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IDENTIFIER__NAME = LABEL__NAME;

	/**
     * The feature id for the '<em><b>QName</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IDENTIFIER__QNAME = LABEL__QNAME;

	/**
     * The feature id for the '<em><b>Value</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IDENTIFIER__VALUE = LABEL__VALUE;

	/**
     * The feature id for the '<em><b>Labelable Element</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IDENTIFIER__LABELABLE_ELEMENT = LABEL__LABELABLE_ELEMENT;

	/**
     * The feature id for the '<em><b>Value String</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IDENTIFIER__VALUE_STRING = LABEL__VALUE_STRING;

	/**
     * The feature id for the '<em><b>Identifiable Element</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IDENTIFIER__IDENTIFIABLE_ELEMENT = LABEL_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IDENTIFIER__ID = LABEL_FEATURE_COUNT + 1;

	/**
     * The number of structural features of the '<em>Identifier</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int IDENTIFIER_FEATURE_COUNT = LABEL_FEATURE_COUNT + 2;


	/**
     * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.LayerImpl <em>Layer</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.LayerImpl
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphPackageImpl#getLayer()
     * @generated
     */
	int LAYER = 7;

	/**
     * The feature id for the '<em><b>Labels</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LAYER__LABELS = IDENTIFIABLE_ELEMENT__LABELS;

	/**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LAYER__ID = IDENTIFIABLE_ELEMENT__ID;

	/**
     * The feature id for the '<em><b>Identifier</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LAYER__IDENTIFIER = IDENTIFIABLE_ELEMENT__IDENTIFIER;

	/**
     * The feature id for the '<em><b>Graph</b></em>' container reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LAYER__GRAPH = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Nodes</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LAYER__NODES = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Edges</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LAYER__EDGES = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
     * The feature id for the '<em><b>Super Layer</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LAYER__SUPER_LAYER = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
     * The feature id for the '<em><b>Sub Layers</b></em>' reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LAYER__SUB_LAYERS = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 4;

	/**
     * The number of structural features of the '<em>Layer</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int LAYER_FEATURE_COUNT = IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 5;


	/**
     * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.GRAPH_TRAVERSE_TYPE <em>GRAPH TRAVERSE TYPE</em>}' enum.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GRAPH_TRAVERSE_TYPE
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphPackageImpl#getGRAPH_TRAVERSE_TYPE()
     * @generated
     */
	int GRAPH_TRAVERSE_TYPE = 8;

	/**
     * The meta object id for the '<em>Traverse Handler</em>' data type.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphTraverseHandler
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphPackageImpl#getGraphTraverseHandler()
     * @generated
     */
	int GRAPH_TRAVERSE_HANDLER = 9;


	/**
     * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node <em>Node</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Node</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node
     * @generated
     */
	EClass getNode();

	/**
     * Returns the meta object for the container reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node#getGraph <em>Graph</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Graph</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node#getGraph()
     * @see #getNode()
     * @generated
     */
	EReference getNode_Graph();

	/**
     * Returns the meta object for the reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node#getLayers <em>Layers</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Layers</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node#getLayers()
     * @see #getNode()
     * @generated
     */
	EReference getNode_Layers();

	/**
     * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement <em>Labelable Element</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Labelable Element</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement
     * @generated
     */
	EClass getLabelableElement();

	/**
     * Returns the meta object for the containment reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement#getLabels <em>Labels</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Labels</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement#getLabels()
     * @see #getLabelableElement()
     * @generated
     */
	EReference getLabelableElement_Labels();

	/**
     * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge <em>Edge</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Edge</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge
     * @generated
     */
	EClass getEdge();

	/**
     * Returns the meta object for the container reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge#getGraph <em>Graph</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Graph</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge#getGraph()
     * @see #getEdge()
     * @generated
     */
	EReference getEdge_Graph();

	/**
     * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge#getSource <em>Source</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Source</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge#getSource()
     * @see #getEdge()
     * @generated
     */
	EReference getEdge_Source();

	/**
     * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge#getTarget <em>Target</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Target</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge#getTarget()
     * @see #getEdge()
     * @generated
     */
	EReference getEdge_Target();

	/**
     * Returns the meta object for the reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge#getLayers <em>Layers</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Layers</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge#getLayers()
     * @see #getEdge()
     * @generated
     */
	EReference getEdge_Layers();

	/**
     * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement <em>Identifiable Element</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Identifiable Element</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement
     * @generated
     */
	EClass getIdentifiableElement();

	/**
     * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement#getId()
     * @see #getIdentifiableElement()
     * @generated
     */
	EAttribute getIdentifiableElement_Id();

	/**
     * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement#getIdentifier <em>Identifier</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Identifier</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement#getIdentifier()
     * @see #getIdentifiableElement()
     * @generated
     */
	EReference getIdentifiableElement_Identifier();

	/**
     * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label <em>Label</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Label</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label
     * @generated
     */
	EClass getLabel();

	/**
     * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#getNamespace <em>Namespace</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Namespace</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#getNamespace()
     * @see #getLabel()
     * @generated
     */
	EAttribute getLabel_Namespace();

	/**
     * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#getName <em>Name</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Name</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#getName()
     * @see #getLabel()
     * @generated
     */
	EAttribute getLabel_Name();

	/**
     * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#getQName <em>QName</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>QName</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#getQName()
     * @see #getLabel()
     * @generated
     */
	EAttribute getLabel_QName();

	/**
     * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#getValue <em>Value</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#getValue()
     * @see #getLabel()
     * @generated
     */
	EAttribute getLabel_Value();

	/**
     * Returns the meta object for the container reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#getLabelableElement <em>Labelable Element</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Labelable Element</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#getLabelableElement()
     * @see #getLabel()
     * @generated
     */
	EReference getLabel_LabelableElement();

	/**
     * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#getValueString <em>Value String</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Value String</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label#getValueString()
     * @see #getLabel()
     * @generated
     */
	EAttribute getLabel_ValueString();

	/**
     * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph <em>Graph</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Graph</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph
     * @generated
     */
	EClass getGraph();

	/**
     * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getIndexMgr <em>Index Mgr</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Index Mgr</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getIndexMgr()
     * @see #getGraph()
     * @generated
     */
	EReference getGraph_IndexMgr();

	/**
     * Returns the meta object for the containment reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getEdges <em>Edges</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Edges</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getEdges()
     * @see #getGraph()
     * @generated
     */
	EReference getGraph_Edges();

	/**
     * Returns the meta object for the containment reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getNodes <em>Nodes</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Nodes</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getNodes()
     * @see #getGraph()
     * @generated
     */
	EReference getGraph_Nodes();

	/**
     * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getNumOfNodes <em>Num Of Nodes</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Num Of Nodes</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getNumOfNodes()
     * @see #getGraph()
     * @generated
     */
	EAttribute getGraph_NumOfNodes();

	/**
     * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getNumOfEdges <em>Num Of Edges</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Num Of Edges</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getNumOfEdges()
     * @see #getGraph()
     * @generated
     */
	EAttribute getGraph_NumOfEdges();

	/**
     * Returns the meta object for the containment reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getLayers <em>Layers</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Layers</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getLayers()
     * @see #getGraph()
     * @generated
     */
	EReference getGraph_Layers();

	/**
     * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getNumOfLayers <em>Num Of Layers</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Num Of Layers</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph#getNumOfLayers()
     * @see #getGraph()
     * @generated
     */
	EAttribute getGraph_NumOfLayers();

	/**
     * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier <em>Identifier</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Identifier</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier
     * @generated
     */
	EClass getIdentifier();

	/**
     * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier#getId <em>Id</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Id</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier#getId()
     * @see #getIdentifier()
     * @generated
     */
	EAttribute getIdentifier_Id();

	/**
     * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier#getIdentifiableElement <em>Identifiable Element</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Identifiable Element</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier#getIdentifiableElement()
     * @see #getIdentifier()
     * @generated
     */
	EReference getIdentifier_IdentifiableElement();

	/**
     * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer <em>Layer</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Layer</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer
     * @generated
     */
	EClass getLayer();

	/**
     * Returns the meta object for the container reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer#getGraph <em>Graph</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the container reference '<em>Graph</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer#getGraph()
     * @see #getLayer()
     * @generated
     */
	EReference getLayer_Graph();

	/**
     * Returns the meta object for the reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer#getNodes <em>Nodes</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Nodes</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer#getNodes()
     * @see #getLayer()
     * @generated
     */
	EReference getLayer_Nodes();

	/**
     * Returns the meta object for the reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer#getEdges <em>Edges</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Edges</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer#getEdges()
     * @see #getLayer()
     * @generated
     */
	EReference getLayer_Edges();

	/**
     * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer#getSuperLayer <em>Super Layer</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Super Layer</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer#getSuperLayer()
     * @see #getLayer()
     * @generated
     */
	EReference getLayer_SuperLayer();

	/**
     * Returns the meta object for the reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer#getSubLayers <em>Sub Layers</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference list '<em>Sub Layers</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer#getSubLayers()
     * @see #getLayer()
     * @generated
     */
	EReference getLayer_SubLayers();

	/**
     * Returns the meta object for enum '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.GRAPH_TRAVERSE_TYPE <em>GRAPH TRAVERSE TYPE</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for enum '<em>GRAPH TRAVERSE TYPE</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GRAPH_TRAVERSE_TYPE
     * @generated
     */
	EEnum getGRAPH_TRAVERSE_TYPE();

	/**
     * Returns the meta object for data type '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphTraverseHandler <em>Traverse Handler</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for data type '<em>Traverse Handler</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphTraverseHandler
     * @model instanceClass="de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphTraverseHandler"
     * @generated
     */
	EDataType getGraphTraverseHandler();

	/**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	GraphFactory getGraphFactory();

	/**
     * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
     * @generated
     */
	interface Literals {
		/**
         * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.NodeImpl <em>Node</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.NodeImpl
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphPackageImpl#getNode()
         * @generated
         */
		EClass NODE = eINSTANCE.getNode();

		/**
         * The meta object literal for the '<em><b>Graph</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference NODE__GRAPH = eINSTANCE.getNode_Graph();

		/**
         * The meta object literal for the '<em><b>Layers</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference NODE__LAYERS = eINSTANCE.getNode_Layers();

		/**
         * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.LabelableElementImpl <em>Labelable Element</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.LabelableElementImpl
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphPackageImpl#getLabelableElement()
         * @generated
         */
		EClass LABELABLE_ELEMENT = eINSTANCE.getLabelableElement();

		/**
         * The meta object literal for the '<em><b>Labels</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference LABELABLE_ELEMENT__LABELS = eINSTANCE.getLabelableElement_Labels();

		/**
         * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.EdgeImpl <em>Edge</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.EdgeImpl
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphPackageImpl#getEdge()
         * @generated
         */
		EClass EDGE = eINSTANCE.getEdge();

		/**
         * The meta object literal for the '<em><b>Graph</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EDGE__GRAPH = eINSTANCE.getEdge_Graph();

		/**
         * The meta object literal for the '<em><b>Source</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EDGE__SOURCE = eINSTANCE.getEdge_Source();

		/**
         * The meta object literal for the '<em><b>Target</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EDGE__TARGET = eINSTANCE.getEdge_Target();

		/**
         * The meta object literal for the '<em><b>Layers</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference EDGE__LAYERS = eINSTANCE.getEdge_Layers();

		/**
         * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.IdentifiableElementImpl <em>Identifiable Element</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.IdentifiableElementImpl
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphPackageImpl#getIdentifiableElement()
         * @generated
         */
		EClass IDENTIFIABLE_ELEMENT = eINSTANCE.getIdentifiableElement();

		/**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute IDENTIFIABLE_ELEMENT__ID = eINSTANCE.getIdentifiableElement_Id();

		/**
         * The meta object literal for the '<em><b>Identifier</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference IDENTIFIABLE_ELEMENT__IDENTIFIER = eINSTANCE.getIdentifiableElement_Identifier();

		/**
         * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.LabelImpl <em>Label</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.LabelImpl
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphPackageImpl#getLabel()
         * @generated
         */
		EClass LABEL = eINSTANCE.getLabel();

		/**
         * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute LABEL__NAMESPACE = eINSTANCE.getLabel_Namespace();

		/**
         * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute LABEL__NAME = eINSTANCE.getLabel_Name();

		/**
         * The meta object literal for the '<em><b>QName</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute LABEL__QNAME = eINSTANCE.getLabel_QName();

		/**
         * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute LABEL__VALUE = eINSTANCE.getLabel_Value();

		/**
         * The meta object literal for the '<em><b>Labelable Element</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference LABEL__LABELABLE_ELEMENT = eINSTANCE.getLabel_LabelableElement();

		/**
         * The meta object literal for the '<em><b>Value String</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute LABEL__VALUE_STRING = eINSTANCE.getLabel_ValueString();

		/**
         * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphImpl <em>Graph</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphImpl
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphPackageImpl#getGraph()
         * @generated
         */
		EClass GRAPH = eINSTANCE.getGraph();

		/**
         * The meta object literal for the '<em><b>Index Mgr</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference GRAPH__INDEX_MGR = eINSTANCE.getGraph_IndexMgr();

		/**
         * The meta object literal for the '<em><b>Edges</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference GRAPH__EDGES = eINSTANCE.getGraph_Edges();

		/**
         * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference GRAPH__NODES = eINSTANCE.getGraph_Nodes();

		/**
         * The meta object literal for the '<em><b>Num Of Nodes</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute GRAPH__NUM_OF_NODES = eINSTANCE.getGraph_NumOfNodes();

		/**
         * The meta object literal for the '<em><b>Num Of Edges</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute GRAPH__NUM_OF_EDGES = eINSTANCE.getGraph_NumOfEdges();

		/**
         * The meta object literal for the '<em><b>Layers</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference GRAPH__LAYERS = eINSTANCE.getGraph_Layers();

		/**
         * The meta object literal for the '<em><b>Num Of Layers</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute GRAPH__NUM_OF_LAYERS = eINSTANCE.getGraph_NumOfLayers();

		/**
         * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.IdentifierImpl <em>Identifier</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.IdentifierImpl
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphPackageImpl#getIdentifier()
         * @generated
         */
		EClass IDENTIFIER = eINSTANCE.getIdentifier();

		/**
         * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute IDENTIFIER__ID = eINSTANCE.getIdentifier_Id();

		/**
         * The meta object literal for the '<em><b>Identifiable Element</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference IDENTIFIER__IDENTIFIABLE_ELEMENT = eINSTANCE.getIdentifier_IdentifiableElement();

		/**
         * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.LayerImpl <em>Layer</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.LayerImpl
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphPackageImpl#getLayer()
         * @generated
         */
		EClass LAYER = eINSTANCE.getLayer();

		/**
         * The meta object literal for the '<em><b>Graph</b></em>' container reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference LAYER__GRAPH = eINSTANCE.getLayer_Graph();

		/**
         * The meta object literal for the '<em><b>Nodes</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference LAYER__NODES = eINSTANCE.getLayer_Nodes();

		/**
         * The meta object literal for the '<em><b>Edges</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference LAYER__EDGES = eINSTANCE.getLayer_Edges();

		/**
         * The meta object literal for the '<em><b>Super Layer</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference LAYER__SUPER_LAYER = eINSTANCE.getLayer_SuperLayer();

		/**
         * The meta object literal for the '<em><b>Sub Layers</b></em>' reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference LAYER__SUB_LAYERS = eINSTANCE.getLayer_SubLayers();

		/**
         * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.GRAPH_TRAVERSE_TYPE <em>GRAPH TRAVERSE TYPE</em>}' enum.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GRAPH_TRAVERSE_TYPE
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphPackageImpl#getGRAPH_TRAVERSE_TYPE()
         * @generated
         */
		EEnum GRAPH_TRAVERSE_TYPE = eINSTANCE.getGRAPH_TRAVERSE_TYPE();

		/**
         * The meta object literal for the '<em>Traverse Handler</em>' data type.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphTraverseHandler
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphPackageImpl#getGraphTraverseHandler()
         * @generated
         */
		EDataType GRAPH_TRAVERSE_HANDLER = eINSTANCE.getGraphTraverseHandler();

	}

} //GraphPackage
