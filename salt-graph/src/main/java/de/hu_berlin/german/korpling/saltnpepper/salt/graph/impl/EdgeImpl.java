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

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.EdgeImpl#getGraph <em>Graph</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.EdgeImpl#getSource <em>Source</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.EdgeImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.EdgeImpl#getLayers <em>Layers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EdgeImpl extends IdentifiableElementImpl implements Edge {
	
	//TODO to delete
	public static Long equalTime= 0l;
	public static Long eTrues= 0l;
	public static Long eFalses= 0l;
	
	/**
     * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getSource()
     * @generated
     * @ordered
     */
	protected Node source;
	/**
     * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see #getTarget()
     * @generated
     * @ordered
     */
	protected Node target;

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
	protected EdgeImpl() {
		super();
		this.init();
	}
	
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
        return GraphPackage.Literals.EDGE;
    }
	
	/**
	 * Finds all differences between this and the given object. 
	 * @param differences if given parameter is not null all differences will be written in that list
	 * @param obj 
	 * @return
	 */
	@Override
	public boolean equals(EList<String> differences, Object obj)
	{
		if (differences!= null)
		{
//			EList<String> diffs= super.differences(obj);
//			if (	(diffs!= null)&&
//					(diffs.size()>0))
//				differences.addAll(diffs);
			super.equals(differences, obj);
		}
		else
		{
			if (!super.equals(differences, obj))
				return(false);
		}
		{//check source and target node
			Edge other= (Edge) obj;
			{//source
				if (this.getSource() == null) 
				{
					if (other.getSource() != null)
					{
						if (differences!= null)
							differences.add("Both "+this.getClass().getName()+" objects differs. This one does not have a source, but the given one does.");
						else return false;
					}
				} 
				else if (other.getSource()== null)
				{
					if (differences!= null)
						differences.add("Both "+this.getClass().getName()+" objects differs. This one has a source, but the given one does not.");
					else return(false);
				}
				else
				{
					if (differences!= null)
					{
//						EList<String> diffs= this.getSource().differences(other.getSource());
//						if (diffs!= null)
//							differences.addAll(diffs);
						this.getSource().equals(differences, other.getSource());
					}
					else
					{
						if (!this.getSource().equals(differences, other.getSource()))
							return false;
					}
				}
			}//source
			{//target
				if (this.getTarget() == null) 
				{
					if (other.getTarget() != null)
					{
						if (differences!= null)
							differences.add("Both "+this.getClass().getName()+" objects differs. This one does not have a Target, but the given one does.");
						else return false;
					}
				} 
				else if (other.getTarget()== null)
				{
					if (differences!= null)
						differences.add("Both "+this.getClass().getName()+" objects differs. This one has a Target, but the given one does not.");
					else return(false);
				}
				else
				{
					if (differences!= null)
					{
//						EList<String> diffs= this.getTarget().differences(other.getTarget());
//						if (diffs!= null)
//							differences.addAll(diffs);
						this.getTarget().equals(differences, other.getTarget());
					}
					else
					{
						if (!this.getTarget().equals(differences, other.getTarget()))
							return false;
					}
				}
			}//target
		}//check source and target node
		
		return(true);
	}
	
	/**
	 * Checks the equality of this object and a given one basing on the identifier, the labels, 
	 * source and target node. 
	 * 
	 * @return true if both objects are equal respecting to the named values.
	 */
	@Override
	public boolean equals(Object obj)
	{
		boolean retVal= this.equals(null, obj); 
		return(retVal);
//		boolean superVal= super.equals(obj);
//		if (superVal)
//		{//check source and target node
//			Edge other= (Edge) obj;
//			{//source
//				if (this.getSource() == null) 
//				{
//					if (other.getSource() != null)
//						return false;
//				} 
//				else if (other.getSource()== null)
//					return(false);
//				else if (!this.getSource().equals(other.getSource()))
//					return false;
//			}//source
//			{//target
//				if (this.getTarget() == null) 
//				{
//					if (other.getTarget() != null)
//						return false;
//				} 
//				else if (other.getTarget()== null)
//					return(false);
//				else if (!this.getTarget().equals(other.getTarget()))
//					return false;
//			}//target
//			
//			return(true);
//		}//check source and target node
//		else return(superVal);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.getIdentifier() == null) ? 0 : this.getIdentifier().hashCode());
		return result;
	}

//	@Override
//	public boolean equals(Object obj) 
//	{
//		//TODO to remove
//		Long eTime= System.nanoTime();
//		
//		Boolean retVal= true;
//		
//		if (this == obj)
//			retVal= true;
//		else
//		{	
//			if (obj == null)
//				retVal= false;
//			if (	(retVal) &&
//					(getClass() != obj.getClass()))
//				retVal= false;
//			EdgeImpl other = (EdgeImpl) obj;
//			if (	(retVal) &&
//					(layers == null)) 
//			{
//				if  (	(retVal) &&
//						(other.layers != null))
//					retVal= false;
//			} 
//			else if  (	(retVal) &&
//						(!layers.equals(other.layers)))
//				retVal= false;
//			
//			if  (	(retVal) &&
//					(source == null)) 
//			{
//				if (other.source != null)
//					retVal= false;
//			} 
//			else if  (	(retVal) &&
//						(!source.equals(other.source)))
//				retVal= false;
//			if  (	(retVal) &&
//					(target == null)) 
//			{
//				if (other.target != null)
//					retVal= false;
//			} else if  (	(retVal) &&
//							(!target.equals(other.target)))
//				retVal= false;
//		}
//		
//		//TODO to remove
//		equalTime= equalTime + (System.nanoTime() -eTime);
//		return(retVal);
//	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Graph getGraph() {
        if (eContainerFeatureID() != GraphPackage.EDGE__GRAPH) return null;
        return (Graph)eContainer();
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public NotificationChain basicSetGraph(Graph newGraph, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newGraph, GraphPackage.EDGE__GRAPH, msgs);
        return msgs;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public void setGraph(Graph newGraph) {
        if (newGraph != eInternalContainer() || (eContainerFeatureID() != GraphPackage.EDGE__GRAPH && newGraph != null))
        {
            if (EcoreUtil.isAncestor(this, newGraph))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newGraph != null)
                msgs = ((InternalEObject)newGraph).eInverseAdd(this, GraphPackage.GRAPH__EDGES, Graph.class, msgs);
            msgs = basicSetGraph(newGraph, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.EDGE__GRAPH, newGraph, newGraph));
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Node getSource() {
        if (source != null && source.eIsProxy())
        {
            InternalEObject oldSource = (InternalEObject)source;
            source = (Node)eResolveProxy(oldSource);
            if (source != oldSource)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphPackage.EDGE__SOURCE, oldSource, source));
            }
        }
        return source;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Node basicGetSource() {
        return source;
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSource(Node newSource) {
		Node oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.EDGE__SOURCE, oldSource, source));
		}
		//redirect the edge in graph
//		if (this.getGraph()!= null)
//			this.getGraph().changeEdgeSource(this.getId(), newSource.getId());
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Node getTarget() {
        if (target != null && target.eIsProxy())
        {
            InternalEObject oldTarget = (InternalEObject)target;
            target = (Node)eResolveProxy(oldTarget);
            if (target != oldTarget)
            {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphPackage.EDGE__TARGET, oldTarget, target));
            }
        }
        return target;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public Node basicGetTarget() {
        return target;
    }

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setTarget(Node newTarget) {
		Node oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.EDGE__TARGET, oldTarget, target));
		//redirect the edge in graph
//		if (this.getGraph()!= null)
//			this.getGraph().changeEdgeTarget(this.getId(), newTarget.getId());
	}

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public EList<Layer> getLayers() {
        if (layers == null)
        {
            layers = new EObjectWithInverseResolvingEList.ManyInverse<Layer>(Layer.class, this, GraphPackage.EDGE__LAYERS, GraphPackage.LAYER__EDGES);
        }
        return layers;
    }

	/**
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID)
        {
            case GraphPackage.EDGE__GRAPH:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetGraph((Graph)otherEnd, msgs);
            case GraphPackage.EDGE__LAYERS:
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
        switch (featureID)
        {
            case GraphPackage.EDGE__GRAPH:
                return basicSetGraph(null, msgs);
            case GraphPackage.EDGE__LAYERS:
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
        switch (eContainerFeatureID())
        {
            case GraphPackage.EDGE__GRAPH:
                return eInternalContainer().eInverseRemove(this, GraphPackage.GRAPH__EDGES, Graph.class, msgs);
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
        switch (featureID)
        {
            case GraphPackage.EDGE__GRAPH:
                return getGraph();
            case GraphPackage.EDGE__SOURCE:
                if (resolve) return getSource();
                return basicGetSource();
            case GraphPackage.EDGE__TARGET:
                if (resolve) return getTarget();
                return basicGetTarget();
            case GraphPackage.EDGE__LAYERS:
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
        switch (featureID)
        {
            case GraphPackage.EDGE__GRAPH:
                setGraph((Graph)newValue);
                return;
            case GraphPackage.EDGE__SOURCE:
                setSource((Node)newValue);
                return;
            case GraphPackage.EDGE__TARGET:
                setTarget((Node)newValue);
                return;
            case GraphPackage.EDGE__LAYERS:
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
        switch (featureID)
        {
            case GraphPackage.EDGE__GRAPH:
                setGraph((Graph)null);
                return;
            case GraphPackage.EDGE__SOURCE:
                setSource((Node)null);
                return;
            case GraphPackage.EDGE__TARGET:
                setTarget((Node)null);
                return;
            case GraphPackage.EDGE__LAYERS:
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
        switch (featureID)
        {
            case GraphPackage.EDGE__GRAPH:
                return getGraph() != null;
            case GraphPackage.EDGE__SOURCE:
                return source != null;
            case GraphPackage.EDGE__TARGET:
                return target != null;
            case GraphPackage.EDGE__LAYERS:
                return layers != null && !layers.isEmpty();
        }
        return super.eIsSet(featureID);
    }
} //EdgeImpl
