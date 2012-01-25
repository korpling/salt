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

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GRAPH_TRAVERSE_TYPE;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;

import org.eclipse.emf.common.util.EList;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SGraph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraph#getSRelations <em>SRelations</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraph#getSNodes <em>SNodes</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraph#getSLayers <em>SLayers</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage#getSGraph()
 * @model
 * @generated
 */
public interface SGraph extends Graph, SNamedElement, SAnnotatableElement, SIdentifiableElement, SProcessingAnnotatableElement, SFeaturableElement, SMetaAnnotatableElement {
	/**
	 * Returns the value of the '<em><b>SRelations</b></em>' reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation#getSGraph <em>SGraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SRelations</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SRelations</em>' reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage#getSGraph_SRelations()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation#getSGraph
	 * @model opposite="sGraph" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<SRelation> getSRelations();

	/**
	 * Returns the value of the '<em><b>SNodes</b></em>' reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode#getSGraph <em>SGraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SNodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SNodes</em>' reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage#getSGraph_SNodes()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode#getSGraph
	 * @model opposite="sGraph" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<SNode> getSNodes();

	/**
	 * Returns the value of the '<em><b>SLayers</b></em>' reference list.
	 * The list contents are of type {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer}.
	 * It is bidirectional and its opposite is '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSGraph <em>SGraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SLayers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SLayers</em>' reference list.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage#getSGraph_SLayers()
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSGraph
	 * @model opposite="sGraph" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<SLayer> getSLayers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addSNode(SNode sNode);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	SNode getSNode(String sNodeId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addSRelation(SRelation sRelation);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	SRelation getSRelation(String sRelationId);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addSLayer(SLayer sLayer);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	SLayer getSLayer(String sLayerId);

	/**
	 * Returns all root nodes, if exists. A root node is a node, which has no ingoing edges.
	 * @return list of nodes being roots in the given graph.
	 * @model kind="operation"
	 * @generated
	 */
	EList<SNode> getSRoots();

	/**
	 * Returns all leaf nodes, if exists. A leaf node is a node, which has no outgoing edges.
	 * @return list of nodes being leafs in the given graph.
	 * @model kind="operation"
	 * @generated
	 */
	EList<SNode> getSLeafs();
	
	/**
	 * Traverses a graph in the given order traverseType and starts traversing with the given startNodes. When a node is reached, 
	 * first this method will invoke the method {@link SGraphTraverseHandler#checkConstraint(GRAPH_TRAVERSE_TYPE, String, SRelation, SNode, long)} 
	 * of the given callback handler traverseHandler, second the method {@link SGraphTraverseHandler#nodeReached(GRAPH_TRAVERSE_TYPE, String, SNode, SRelation, SNode, long)}
	 * is invoked. When a node was left, the method {@link SGraphTraverseHandler#nodeLeft(GRAPH_TRAVERSE_TYPE, String, SNode, SRelation, SNode, long)} 
	 * is invoked. When calling these methods, the traverseId will be passed, so that the callback handler knows which traversal is meant.
	 * This is helpful, in case of a single callback handler is used for more than one traversal at  the same time.
	 * This method throws a {@link GraphTraverserException} in case of the graph contains a cycle. A cycle means a path containing the same 
	 * node twice.
	 * @param startSNodes list of nodes at which the traversal shall start
	 * @param traverseType type of traversing
	 * @param traverseId identification for callback handler, in case of more than one traversal is running at the same time with the same callback handler
	 * @param traverseHandler callback handler, on which the three methods will be invoked
	 * @model startSNodesMany="true" traverseHandlerDataType="de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SSGraphTraverseHandler"
	 */
	void traverse(EList<? extends SNode> startSNodes, GRAPH_TRAVERSE_TYPE traverseType, String traverseId, SGraphTraverseHandler traverseHandler);

	/**
	 * Traverses a graph in the given order traverseType and starts traversing with the given startNodes. When a node is reached, 
	 * first this method will invoke the method {@link SGraphTraverseHandler#checkConstraint(GRAPH_TRAVERSE_TYPE, String, SRelation, SNode, long)} 
	 * of the given callback handler traverseHandler, second the method {@link SGraphTraverseHandler#nodeReached(GRAPH_TRAVERSE_TYPE, String, SNode, SRelation, SNode, long)}
	 * is invoked. When a node was left, the method {@link SGraphTraverseHandler#nodeLeft(GRAPH_TRAVERSE_TYPE, String, SNode, SRelation, SNode, long)} 
	 * is invoked. When calling these methods, the traverseId will be passed, so that the callback handler knows which traversal is meant.
	 * This is helpful, in case of a single callback handler is used for more than one traversal at  the same time.
	 * This method throws a {@link GraphTraverserException} in case of the graph contains a cycle. A cycle means a path containing the same 
	 * node twice.
	 * @param startSNodes list of nodes at which the traversal shall start
	 * @param traverseType type of traversing
	 * @param traverseId identification for callback handler, in case of more than one traversal is running at the same time with the same callback handler
	 * @param traverseHandler callback handler, on which the three methods will be invoked
	 * @param isCycleSafe sets if the traversal mechanism shall take care of cycles or not. If false is set, the calling method has to handle not to run in an endless loop/ recursion.
	 * @model startSNodesMany="true" traverseHandlerDataType="de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraphTraverseHandler"
	 */
	void traverse(EList<? extends SNode> startSNodes, GRAPH_TRAVERSE_TYPE traverseType, String traverseId, SGraphTraverseHandler traverseHandler, boolean isCycleSafe);

	/**
	 * Searches for a layer having the given layer name.
	 * @param layerName Name of the layer to search for
	 * @return A complete list of all matching layers. Is never null.
	 * @model
	 */
	EList<SLayer> getSLayerByName(String layerName);

} // SGraph
