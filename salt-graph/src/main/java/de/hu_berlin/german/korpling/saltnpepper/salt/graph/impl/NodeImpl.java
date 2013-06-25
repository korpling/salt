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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.exceptions.GraphException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.NodeImpl#getGraph <em>Graph</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.NodeImpl#getLayers <em>Layers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NodeImpl extends IdentifiableElementImpl implements Node 
{
	//TODO to delete
	public static Long equalTime= 0l;
	public static Long eTrues= 0l;
	public static Long eFalses= 0l;
	
	/**
         * The cached value of the '{@link #getLayers() <em>Layers</em>}' reference list.
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @see #getLayers()
         * @generated
         * @ordered
         */
	protected EList<Layer> layers;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected NodeImpl() {
		super();
		this.init();
	}
	

	/**
	 * Initializes objects of this class. 
	 */
	private void init()
	{
	}
	
	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	@Override
	protected EClass eStaticClass() {
                return GraphPackage.Literals.NODE;
        }
		
	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public Graph getGraph() {
                if (eContainerFeatureID() != GraphPackage.NODE__GRAPH) return null;
                return (Graph)eContainer();
        }
	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public NotificationChain basicSetGraph(Graph newGraph, NotificationChain msgs) {
                msgs = eBasicSetContainer((InternalEObject)newGraph, GraphPackage.NODE__GRAPH, msgs);
                return msgs;
        }
	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public void setGraph(Graph newGraph) {
                if (newGraph != eInternalContainer() || (eContainerFeatureID() != GraphPackage.NODE__GRAPH && newGraph != null)) {
                        if (EcoreUtil.isAncestor(this, newGraph))
                                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
                        NotificationChain msgs = null;
                        if (eInternalContainer() != null)
                                msgs = eBasicRemoveFromContainer(msgs);
                        if (newGraph != null)
                                msgs = ((InternalEObject)newGraph).eInverseAdd(this, GraphPackage.GRAPH__NODES, Graph.class, msgs);
                        msgs = basicSetGraph(newGraph, msgs);
                        if (msgs != null) msgs.dispatch();
                }
                else if (eNotificationRequired())
                        eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.NODE__GRAPH, newGraph, newGraph));
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	public EList<Layer> getLayers() {
                if (layers == null) {
                        layers = new EObjectWithInverseResolvingEList.ManyInverse<Layer>(Layer.class, this, GraphPackage.NODE__LAYERS, GraphPackage.LAYER__NODES);
                }
                return layers;
        }

	

	/**
	 * {@inheritDoc}
	 */
	public Object clone() 
	{
		return(this.clone(GraphFactory.eINSTANCE.createNode()));
	}

	/**
	 * This method returns the given object. It adds all properties of this to the given object.
	 * @param clone the clone to which all properties of this shall be copied to
	 * @return
	 */
	protected Object clone(Node clone)
	{
		if (clone== null)
			throw new GraphException("Cannot clone node '"+this.getId()+"', because the given object is null and its not possible to copy values into a null object.");
		
		for (Label label: this.getLabels())
		{
			if (! (label instanceof Identifier))
			clone.addLabel((Label)label.clone());
		}
		return(clone);
	}


	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
                switch (featureID) {
                        case GraphPackage.NODE__GRAPH:
                                if (eInternalContainer() != null)
                                        msgs = eBasicRemoveFromContainer(msgs);
                                return basicSetGraph((Graph)otherEnd, msgs);
                        case GraphPackage.NODE__LAYERS:
                                return ((InternalEList<InternalEObject>)(InternalEList<?>)getLayers()).basicAdd(otherEnd, msgs);
                }
                return super.eInverseAdd(otherEnd, featureID, msgs);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
                switch (featureID) {
                        case GraphPackage.NODE__GRAPH:
                                return basicSetGraph(null, msgs);
                        case GraphPackage.NODE__LAYERS:
                                return ((InternalEList<?>)getLayers()).basicRemove(otherEnd, msgs);
                }
                return super.eInverseRemove(otherEnd, featureID, msgs);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
                switch (eContainerFeatureID()) {
                        case GraphPackage.NODE__GRAPH:
                                return eInternalContainer().eInverseRemove(this, GraphPackage.GRAPH__NODES, Graph.class, msgs);
                }
                return super.eBasicRemoveFromContainerFeature(msgs);
        }
	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
                switch (featureID) {
                        case GraphPackage.NODE__GRAPH:
                                return getGraph();
                        case GraphPackage.NODE__LAYERS:
                                return getLayers();
                }
                return super.eGet(featureID, resolve, coreType);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
                switch (featureID) {
                        case GraphPackage.NODE__GRAPH:
                                setGraph((Graph)newValue);
                                return;
                        case GraphPackage.NODE__LAYERS:
                                getLayers().clear();
                                getLayers().addAll((Collection<? extends Layer>)newValue);
                                return;
                }
                super.eSet(featureID, newValue);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	@Override
	public void eUnset(int featureID) {
                switch (featureID) {
                        case GraphPackage.NODE__GRAPH:
                                setGraph((Graph)null);
                                return;
                        case GraphPackage.NODE__LAYERS:
                                getLayers().clear();
                                return;
                }
                super.eUnset(featureID);
        }

	/**
         * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
         * @generated
         */
	@Override
	public boolean eIsSet(int featureID) {
                switch (featureID) {
                        case GraphPackage.NODE__GRAPH:
                                return getGraph() != null;
                        case GraphPackage.NODE__LAYERS:
                                return layers != null && !layers.isEmpty();
                }
                return super.eIsSet(featureID);
        }

} //NodeImpl
