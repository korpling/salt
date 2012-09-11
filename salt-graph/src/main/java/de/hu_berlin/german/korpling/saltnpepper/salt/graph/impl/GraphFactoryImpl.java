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
package de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphFactoryImpl extends EFactoryImpl implements GraphFactory {
	/**
     * Creates the default factory implementation.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public static GraphFactory init() {
        try
        {
            GraphFactory theGraphFactory = (GraphFactory)EPackage.Registry.INSTANCE.getEFactory("graph"); 
            if (theGraphFactory != null)
            {
                return theGraphFactory;
            }
        }
        catch (Exception exception)
        {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new GraphFactoryImpl();
    }

	/**
     * Creates an instance of the factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public GraphFactoryImpl() {
        super();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public EObject create(EClass eClass) {
        switch (eClass.getClassifierID())
        {
            case GraphPackage.NODE: return createNode();
            case GraphPackage.LABELABLE_ELEMENT: return createLabelableElement();
            case GraphPackage.EDGE: return createEdge();
            case GraphPackage.IDENTIFIABLE_ELEMENT: return createIdentifiableElement();
            case GraphPackage.LABEL: return createLabel();
            case GraphPackage.GRAPH: return createGraph();
            case GraphPackage.IDENTIFIER: return createIdentifier();
            case GraphPackage.LAYER: return createLayer();
            default:
                throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
        switch (eDataType.getClassifierID())
        {
            case GraphPackage.GRAPH_TRAVERSE_TYPE:
                return createGRAPH_TRAVERSE_TYPEFromString(eDataType, initialValue);
            case GraphPackage.GRAPH_TRAVERSE_HANDLER:
                return createGraphTraverseHandlerFromString(eDataType, initialValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
        switch (eDataType.getClassifierID())
        {
            case GraphPackage.GRAPH_TRAVERSE_TYPE:
                return convertGRAPH_TRAVERSE_TYPEToString(eDataType, instanceValue);
            case GraphPackage.GRAPH_TRAVERSE_HANDLER:
                return convertGraphTraverseHandlerToString(eDataType, instanceValue);
            default:
                throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
        }
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Node createNode() {
        NodeImpl node = new NodeImpl();
        return node;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public LabelableElement createLabelableElement() {
        LabelableElementImpl labelableElement = new LabelableElementImpl();
        return labelableElement;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Edge createEdge() {
        EdgeImpl edge = new EdgeImpl();
        return edge;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public IdentifiableElement createIdentifiableElement() {
        IdentifiableElementImpl identifiableElement = new IdentifiableElementImpl();
        return identifiableElement;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Label createLabel() {
        LabelImpl label = new LabelImpl();
        return label;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Graph createGraph() {
        GraphImpl graph = new GraphImpl();
        return graph;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Identifier createIdentifier() {
        IdentifierImpl identifier = new IdentifierImpl();
        return identifier;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Layer createLayer() {
        LayerImpl layer = new LayerImpl();
        return layer;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public GRAPH_TRAVERSE_TYPE createGRAPH_TRAVERSE_TYPEFromString(EDataType eDataType, String initialValue) {
        GRAPH_TRAVERSE_TYPE result = GRAPH_TRAVERSE_TYPE.get(initialValue);
        if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
        return result;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertGRAPH_TRAVERSE_TYPEToString(EDataType eDataType, Object instanceValue) {
        return instanceValue == null ? null : instanceValue.toString();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public GraphTraverseHandler createGraphTraverseHandlerFromString(EDataType eDataType, String initialValue) {
        return (GraphTraverseHandler)super.createFromString(eDataType, initialValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public String convertGraphTraverseHandlerToString(EDataType eDataType, Object instanceValue) {
        return super.convertToString(eDataType, instanceValue);
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public GraphPackage getGraphPackage() {
        return (GraphPackage)getEPackage();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @deprecated
     * @generated
     */
	@Deprecated
	public static GraphPackage getPackage() {
        return GraphPackage.eINSTANCE;
    }
	

} //GraphFactoryImpl
