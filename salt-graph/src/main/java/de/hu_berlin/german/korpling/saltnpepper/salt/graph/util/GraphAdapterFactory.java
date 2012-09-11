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
package de.hu_berlin.german.korpling.saltnpepper.salt.graph.util;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage
 * @generated
 */
public class GraphAdapterFactory extends AdapterFactoryImpl {
	/**
     * The cached model package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static GraphPackage modelPackage;

	/**
     * Creates an instance of the adapter factory.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public GraphAdapterFactory() {
        if (modelPackage == null)
        {
            modelPackage = GraphPackage.eINSTANCE;
        }
    }

	/**
     * Returns whether this factory is applicable for the type of the object.
     * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
	@Override
	public boolean isFactoryForType(Object object) {
        if (object == modelPackage)
        {
            return true;
        }
        if (object instanceof EObject)
        {
            return ((EObject)object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

	/**
     * The switch that delegates to the <code>createXXX</code> methods.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected GraphSwitch<Adapter> modelSwitch =
		new GraphSwitch<Adapter>()
        {
            @Override
            public Adapter caseNode(Node object)
            {
                return createNodeAdapter();
            }
            @Override
            public Adapter caseLabelableElement(LabelableElement object)
            {
                return createLabelableElementAdapter();
            }
            @Override
            public Adapter caseEdge(Edge object)
            {
                return createEdgeAdapter();
            }
            @Override
            public Adapter caseIdentifiableElement(IdentifiableElement object)
            {
                return createIdentifiableElementAdapter();
            }
            @Override
            public Adapter caseLabel(Label object)
            {
                return createLabelAdapter();
            }
            @Override
            public Adapter caseGraph(Graph object)
            {
                return createGraphAdapter();
            }
            @Override
            public Adapter caseIdentifier(Identifier object)
            {
                return createIdentifierAdapter();
            }
            @Override
            public Adapter caseLayer(Layer object)
            {
                return createLayerAdapter();
            }
            @Override
            public Adapter defaultCase(EObject object)
            {
                return createEObjectAdapter();
            }
        };

	/**
     * Creates an adapter for the <code>target</code>.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param target the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
	@Override
	public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject)target);
    }


	/**
     * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node <em>Node</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node
     * @generated
     */
	public Adapter createNodeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement <em>Labelable Element</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement
     * @generated
     */
	public Adapter createLabelableElementAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge <em>Edge</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge
     * @generated
     */
	public Adapter createEdgeAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement <em>Identifiable Element</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement
     * @generated
     */
	public Adapter createIdentifiableElementAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label <em>Label</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label
     * @generated
     */
	public Adapter createLabelAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph <em>Graph</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph
     * @generated
     */
	public Adapter createGraphAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier <em>Identifier</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier
     * @generated
     */
	public Adapter createIdentifierAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer <em>Layer</em>}'.
     * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer
     * @generated
     */
	public Adapter createLayerAdapter() {
        return null;
    }

	/**
     * Creates a new adapter for the default case.
     * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
     * @return the new adapter.
     * @generated
     */
	public Adapter createEObjectAdapter() {
        return null;
    }

} //GraphAdapterFactory
