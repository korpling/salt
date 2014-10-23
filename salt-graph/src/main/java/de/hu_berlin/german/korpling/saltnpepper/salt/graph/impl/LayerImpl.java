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
import org.eclipse.emf.common.util.BasicEList;
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
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.accessors.IdentifiableElementAccessor;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.exceptions.GraphException;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.exceptions.GraphInsertException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Layer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.LayerImpl#getGraph <em>Graph</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.LayerImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.LayerImpl#getEdges <em>Edges</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.LayerImpl#getSuperLayer <em>Super Layer</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.LayerImpl#getSubLayers <em>Sub Layers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LayerImpl extends IdentifiableElementImpl implements Layer 
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//TODO to delete
	public static  Long equalTime= 0l;
	
	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> nodes;

	/**
	 * The cached value of the '{@link #getEdges() <em>Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> edges;

	/**
	 * The cached value of the '{@link #getSuperLayer() <em>Super Layer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperLayer()
	 * @generated
	 * @ordered
	 */
	protected Layer superLayer;

	/**
	 * The cached value of the '{@link #getSubLayers() <em>Sub Layers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubLayers()
	 * @generated
	 * @ordered
	 */
	protected EList<Layer> subLayers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected LayerImpl() {
		super();
		this.init();
	}
	

	private void init()
	{
		//create delegator for id-handling
		this.identAccessor= new IdentifiableElementAccessor();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphPackage.Literals.LAYER;
	}

// ================ start id-handling delegation	
	/**
	 * Delegatee for SIdentifiableElement
	 */
	private IdentifiableElementAccessor identAccessor= null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
//	public String getId() 
//	{
//		return(this.identAccessor.getId(this));
//	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setId(String newId) 
	{
		if (	(newId== null)||
				(newId.isEmpty()))
			throw new GraphException("Cannot not add an empty id to an element of type '"+this.getClass()+"'.");
		this.identAccessor.setId(this, newId);
	}
// ================ end id-handling delegation

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Graph getGraph() {
		if (eContainerFeatureID() != GraphPackage.LAYER__GRAPH) return null;
		return (Graph)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGraph(Graph newGraph, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newGraph, GraphPackage.LAYER__GRAPH, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGraph(Graph newGraph) {
		if (newGraph != eInternalContainer() || (eContainerFeatureID() != GraphPackage.LAYER__GRAPH && newGraph != null)) {
			if (EcoreUtil.isAncestor(this, newGraph))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newGraph != null)
				msgs = ((InternalEObject)newGraph).eInverseAdd(this, GraphPackage.GRAPH__LAYERS, Graph.class, msgs);
			msgs = basicSetGraph(newGraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.LAYER__GRAPH, newGraph, newGraph));
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
			super.equals(differences,obj);
//			EList<String> diffs= super.differences(obj);
//			if (	(diffs!= null)&&
//					(diffs.size()>0))
//				differences.addAll(diffs);
		}
		else
		{
			if (!super.equals(differences,obj))
				return(false);
		}
		
		Layer other= (Layer) obj;
		final EList<Node> nodes = this.getNodes();
		final EList<Node> otherNodes = other.getNodes();
		final EList<Edge> edges = this.getEdges();
		final EList<Edge> otherEdges = other.getEdges();
		
		
		
		{//check super-layers
			if (this.getSuperLayer() == null) 
			{
				if (other.getSuperLayer()!= null)
				{
					if (differences!= null)
						differences.add("This layer object '"+this.getId()+"' does not have a super-layer, whereas the given one '"+other.getId()+"' does.");
					else return false;
				}
			}
			else if (other.getSuperLayer()== null)
			{
				if (differences!= null)
					differences.add("This layer object '"+this.getId()+"' has a super-layer, whereas the given one '"+other.getId()+"' does not.");
				else return false;
			}
			else if (this.getSuperLayer().hashCode()!= other.getSuperLayer().hashCode())
			{
				if (differences!= null)
					differences.add("The super-layer objects of this layer object '"+this.getId()+"' and the given layer object '"+other.getId()+"' aren't the same.");
				else return false;
			}
		}//check super-layers
		
		{//check sub-layers
			if (this.getSubLayers() == null) 
			{
				if (other.getSubLayers()!= null)
				{
					if (differences!= null)
						differences.add("This layer object '"+this.getId()+"' does not have a Sub-layer, whereas the given one '"+other.getId()+"' does.");
					else return false;
				}
			}
			else if (other.getSubLayers()== null)
			{
				if (differences!= null)
					differences.add("This layer object '"+this.getId()+"' has a Sub-layer, whereas the given one '"+other.getId()+"' does not.");
				else return false;
			}
			else 
			{
				//check size of sublayers
				if (this.getSubLayers().size()!= other.getSubLayers().size())
				{
					if (differences!= null)
						differences.add("The number of sub-layers of this layer object '"+this.getId()+"' is not the same as the number of sub-layer objects of the given layer object '"+other.getId()+"'.");
					else return false;
				}
				
				for (int i= 0; i< this.getSubLayers().size(); i++)
				{
					if (this.getSubLayers().hashCode()!= other.getSubLayers().hashCode())
					{
						if (differences!= null)
							differences.add("A sub-layer object of this layer object '"+this.getId()+"' is not part of the sub-layer objects of the given layer object '"+other.getId()+"'.");
						else return false;
					}
				}
			}
		}//check sub-layers
		
		{//check nodes
			if (nodes == null) 
			{
				if (otherNodes != null)
				{
					if (differences!= null)
						differences.add("This layer object '"+this.getId()+"' does not have node objects, whereas the given one '"+other.getId()+"' does.");
					else return false;
				}
			}
			else if (otherNodes == null)
			{
				if (differences!= null)
					differences.add("This layer object '"+this.getId()+"' has node objects, whereas the given one '"+other.getId()+"' does not.");
				else return false;
			}
			else 
			{
				//check size of Nodes
				if (nodes.size() != otherNodes.size())
				{
					if (differences!= null)
						differences.add("The number of node objects of this layer object '"+this.getId()+"' is not the same as the number of sub-layer objects of the given layer object '"+other.getId()+"'.");
					else return false;
				}
				for (int i= 0; i < nodes.size(); i++)
				{
					if (differences!= null)
					{
//						EList<String> diffs= this.getNodes().get(i).differences(other.getNodes().get(i));
//						if (diffs!= null)
//							differences.addAll(diffs);
						
						nodes.get(i).equals(differences, otherNodes.get(i));
					}
					else
					{
						if (!nodes.get(i).equals(differences, otherNodes.get(i)))
							return(false);
					}
				}
			}
		}//check nodes
		
		{//check edges
			if (edges == null) 
			{
				if (otherEdges != null)
				{
					if (differences!= null)
						differences.add("This layer object '"+this.getId()+"' does not have edge objects, whereas the given one '"+other.getId()+"' does.");
					else return false;
				}
			}
			else if (otherEdges == null)
			{
				if (differences!= null)
					differences.add("This layer object '"+this.getId()+"' has edge objects, whereas the given one '"+other.getId()+"' does not.");
				else return false;
			}
			else 
			{
				//check size of Edges
				if (edges.size()!= otherEdges.size())
				{
					if (differences!= null)
						differences.add("The number of edges of this layer object '"+this.getId()+"' is not the same as the number of edge objects of the given layer object '"+other.getId()+"'.");
					else return false;
				}
				for (int i = 0; i < edges.size(); i++)
				{
					if (differences!= null)
					{
//						EList<String> diffs= this.getEdges().get(i).differences(other.getEdges().get(i));
//						if (diffs!= null)
//							differences.addAll(diffs);
						edges.get(i).equals(differences, otherEdges.get(i));
					}
					else
					{
						if (!edges.get(i).equals(differences, otherEdges.get(i)))
							return(false);
					}
				}
			}
		}//check edges
		
		return(true);
		
//		if (differences!= null)
//		{
//			EList<String> diffs= super.differences(obj);
//			if (	(diffs!= null)&&
//					(diffs.size()>0))
//				differences.addAll(diffs);
//		}
//		else
//		{
//			if (!super.equals(obj))
//				return(false);
//		}
//		
//		Layer other= (Layer) obj;
//		
//		{//check super-layers
//			if (this.getSuperLayer() == null) 
//			{
//				if (other.getSuperLayer()!= null)
//				{
//					if (differences!= null)
//						differences.add("This layer object '"+this.getId()+"' does not have a super-layer, whereas the given one '"+other.getId()+"' does.");
//					else return false;
//				}
//			}
//			else if (other.getSuperLayer()== null)
//			{
//				if (differences!= null)
//					differences.add("This layer object '"+this.getId()+"' has a super-layer, whereas the given one '"+other.getId()+"' does not.");
//				else return false;
//			}
//			else if (this.getSuperLayer().hashCode()!= other.getSuperLayer().hashCode())
//			{
//				if (differences!= null)
//					differences.add("The super-layer objects of this layer object '"+this.getId()+"' and the given layer object '"+other.getId()+"' aren't the same.");
//				else return false;
//			}
//		}//check super-layers
//		
//		{//check sub-layers
//			if (this.getSubLayers() == null) 
//			{
//				if (other.getSubLayers()!= null)
//				{
//					if (differences!= null)
//						differences.add("This layer object '"+this.getId()+"' does not have a Sub-layer, whereas the given one '"+other.getId()+"' does.");
//					else return false;
//				}
//			}
//			else if (other.getSubLayers()== null)
//			{
//				if (differences!= null)
//					differences.add("This layer object '"+this.getId()+"' has a Sub-layer, whereas the given one '"+other.getId()+"' does not.");
//				else return false;
//			}
//			else 
//			{
//				//check size of sublayers
//				if (this.getSubLayers().size()!= other.getSubLayers().size())
//				{
//					if (differences!= null)
//						differences.add("The number of sub-layers of this layer object '"+this.getId()+"' is not the same as the number of sub-layer objects of the given layer object '"+other.getId()+"'.");
//					else return false;
//				}
//				
//				for (int i= 0; i< this.getSubLayers().size(); i++)
//				{
//					if (this.getSubLayers().hashCode()!= other.getSubLayers().hashCode())
//					{
//						if (differences!= null)
//							differences.add("A sub-layer object of this layer object '"+this.getId()+"' is not part of the sub-layer objects of the given layer object '"+other.getId()+"'.");
//						else return false;
//					}
//				}
//			}
//		}//check sub-layers
//		
//		{//check nodes
//			if (this.getNodes() == null) 
//			{
//				if (other.getNodes()!= null)
//				{
//					if (differences!= null)
//						differences.add("This layer object '"+this.getId()+"' does not have node objects, whereas the given one '"+other.getId()+"' does.");
//					else return false;
//				}
//			}
//			else if (other.getNodes()== null)
//			{
//				if (differences!= null)
//					differences.add("This layer object '"+this.getId()+"' has node objects, whereas the given one '"+other.getId()+"' does not.");
//				else return false;
//			}
//			else 
//			{
//				//check size of Nodes
//				if (this.getNodes().size()!= other.getNodes().size())
//				{
//					if (differences!= null)
//						differences.add("The number of node objects of this layer object '"+this.getId()+"' is not the same as the number of sub-layer objects of the given layer object '"+other.getId()+"'.");
//					else return false;
//				}
//				for (int i= 0; i< this.getNodes().size(); i++)
//				{
//					if (differences!= null)
//					{
//						EList<String> diffs= this.getNodes().get(i).differences(other.getNodes().get(i));
//						if (diffs!= null)
//							differences.addAll(diffs);
//					}
//					else
//					{
//						if (!this.getNodes().get(i).equals(other.getNodes().get(i)))
//							return(false);
//					}
//				}
//			}
//		}//check nodes
//		
//		{//check edges
//			if (this.getEdges() == null) 
//			{
//				if (other.getEdges()!= null)
//				{
//					if (differences!= null)
//						differences.add("This layer object '"+this.getId()+"' does not have edge objects, whereas the given one '"+other.getId()+"' does.");
//					else return false;
//				}
//			}
//			else if (other.getEdges()== null)
//			{
//				if (differences!= null)
//					differences.add("This layer object '"+this.getId()+"' has edge objects, whereas the given one '"+other.getId()+"' does not.");
//				else return false;
//			}
//			else 
//			{
//				//check size of Edges
//				if (this.getEdges().size()!= other.getEdges().size())
//				{
//					if (differences!= null)
//						differences.add("The number of edges of this layer object '"+this.getId()+"' is not the same as the number of edge objects of the given layer object '"+other.getId()+"'.");
//					else return false;
//				}
//				for (int i= 0; i< this.getEdges().size(); i++)
//				{
//					if (differences!= null)
//					{
//						EList<String> diffs= this.getEdges().get(i).differences(other.getEdges().get(i));
//						if (diffs!= null)
//							differences.addAll(diffs);
//					}
//					else
//					{
//						if (!this.getEdges().get(i).equals(other.getEdges().get(i)))
//							return(false);
//					}
//				}
//			}
//		}//check edges
//		
//		return(true);
	}
	
	/**
	 * Checks the equality of this object and a given one basing on the identifier, the labels, the
	 * contained sublayers, the super-layer and the contained nodes and edges as well. 
	 * Note, that a sub-layer and super-layer is not totaly retrieved, because of endless loops, 
	 * only the hashCode of this.getSuperLayer() and other.getSuperLayer() or this.getSubLayer() and
	 * other.getSubLayer() will be compared.
	 * 
	 * @return true if both objects are equal respecting to the named values.
	 */
	@Override
	public boolean equals(Object obj)
	{
		boolean retVal= this.equals(null, obj); 
		return(retVal);
		
//		if (super.equals(obj))
//		{//check list of nodes and edges
//			Layer other= (Layer) obj;
//			//check size of sublayers
//			if (this.getSubLayers().size()!= other.getSubLayers().size())
//				return(false);
//			//check size of nodes
//			if (this.getNodes().size()!= other.getNodes().size())
//				return(false);
//			//check size of edges
//			if (this.getEdges().size()!= other.getEdges().size())
//				return(false);
//			
//			{//check super-layers
//				if (this.getSuperLayer() == null) 
//				{
//					if (other.getSuperLayer()!= null)
//						return false;
//				}
//				else if (other.getSuperLayer()== null)
//					return(false);
//				else if (this.getSuperLayer().hashCode()!= other.getSuperLayer().hashCode())
//					return(false);
//			}//check super-layers
//			
//			{//check sub-layers
//				if (this.getSubLayers() == null) 
//				{
//					if (other.getSubLayers()!= null)
//						return false;
//				}
//				else if (other.getSubLayers()== null)
//					return(false);
//				else 
//				{
//					for (int i= 0; i< this.getSubLayers().size(); i++)
//					{
//						if (this.getSubLayers().hashCode()!= other.getSubLayers().hashCode())
//							return(false);
//					}
//				}
//			}//check sub-layers
//			
//			{//check nodes
//				if (this.getNodes() == null) 
//				{
//					if (other.getNodes()!= null)
//						return false;
//				}
//				else if (other.getNodes()== null)
//					return(false);
//				else 
//				{
//					for (int i= 0; i< this.getNodes().size(); i++)
//					{
//						if (!this.getNodes().get(i).equals(other.getNodes().get(i)))
//							return(false);
//					}
//				}
//			}//check nodes
//			
//			{//check edges
//				if (this.getEdges() == null) 
//				{
//					if (other.getEdges()!= null)
//						return false;
//				}
//				else if (other.getEdges()== null)
//					return(false);
//				else 
//				{
//					for (int i= 0; i< this.getEdges().size(); i++)
//					{
//						if (!this.getEdges().get(i).equals(other.getEdges().get(i)))
//							return(false);
//					}
//				}
//			}//check edges
//			
//			return(true);
//		}//check list of nodes and edges
//		else return(false);
	}
	
//	/**
//	 * Checks if a given Label has the same entries as this Label-object. 
//	 * @return if all values are equals.
//	 */
//	@Override
//	public boolean equals(Object obj)
//	{
//		//TODO to remove
//		Long eTime= System.nanoTime();
//		
//		boolean retVal= true;
//		if (obj== null)
//			retVal= false;
//		if (	(retVal) &&
//				(obj instanceof Layer))
//		{	
//			Layer layer2= (Layer) obj;
//			
//			{//check identifier
//				if (	(this.getId()== null) &&
//						(layer2.getId()!= null))
//				{
//					retVal= false;
//				}
//				else if (	(this.getId()!= null) &&
//							(layer2.getId()== null))
//				{
//					retVal= false;
//				}
//				else if (	(this.getId()!= null) &&
//							(layer2.getId()!= null) &&
//							(!this.getIdentifier().equals(layer2.getIdentifier())))
//				{
//					retVal= false;
//				}
//			}//check identifier
//			
//			
//			if (retVal)
//			{	
//				if (	(	(this.getId()== null) &&
//							(layer2.getId()== null)) ||
//							(this.getIdentifier().equals(layer2.getIdentifier())))
//				{
//					if (retVal)
//					{//check if all labels are equal
//						for (Label label: this.getLabels())
//						{
//							boolean eq= false;
//							for (Label label2: layer2.getLabels())
//							{
//								if (label.equals(label2))
//								{
//									eq= true;
//									break;
//								}
//							}
//							//one label is not equal
//							if (!eq)
//							{	
//								retVal= false;
//								break;
//							}	
//						}
//					}//check if all labels are equal
//					if (retVal)
//					{//check if all nodes are equal
//						for (Node node: this.getNodes())
//						{
//							boolean eq= false;
//							for (Node node2: layer2.getNodes())
//							{
//								if (node.equals(node2))
//								{
//									eq= true;
//									break;
//								}
//							}
//							//one node is not equal
//							if (!eq)
//							{
//								retVal= false;
//								break;
//							}
//						}
//					}//check if all nodes are equal
//					if (retVal)
//					{//check if all edges are equal
//						for (Edge edge: this.getEdges())
//						{
//							boolean eq= false;
//							for (Edge edge2: layer2.getEdges())
//							{
//								if (edge.equals(edge2))
//								{
//									eq= true;
//									break;
//								}
//							}
//							//one edge is not equal
//							if (!eq)
//							{
//								retVal= false;
//								break;
//							}
//						}
//					}//check if all edges are equal
//				}
//				else retVal= true;
//			}
//		}
//		//TODO to remove
//		equalTime= equalTime + (System.nanoTime() -eTime);
//		return(retVal);
//	}
	
	public String toString()
	{
		String retStr= "[";
		retStr= retStr+ "("+this.getId()+"): ";
		retStr= retStr+ "labels:";
		for (Label label: this.getLabels())
			retStr= retStr + label.getQName()+"="+ label.getValue() + ", ";
		retStr= retStr+ "; sub-layers:";		
		for (Layer subLayer: this.getSubLayers())
			retStr= retStr + subLayer.getId() + ",";
		retStr= retStr+ "; nodes:";		
		for (Node node: this.getNodes())
			retStr= retStr + node.getId() + ",";
		retStr= retStr+ "; edges:";
		for (Edge edge: this.getEdges())
			retStr= retStr + edge.getId() + ", ";
		retStr= retStr+ "]";
		
		return(retStr);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Node> getNodes() {
		if (nodes == null) {
			nodes = new EObjectWithInverseResolvingEList.ManyInverse<Node>(Node.class, this, GraphPackage.LAYER__NODES, GraphPackage.NODE__LAYERS);
		}
		return nodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Edge> getEdges() {
		if (edges == null) {
			edges = new EObjectWithInverseResolvingEList.ManyInverse<Edge>(Edge.class, this, GraphPackage.LAYER__EDGES, GraphPackage.EDGE__LAYERS);
		}
		return edges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Layer getSuperLayer() {
		if (superLayer != null && superLayer.eIsProxy()) {
			InternalEObject oldSuperLayer = (InternalEObject)superLayer;
			superLayer = (Layer)eResolveProxy(oldSuperLayer);
			if (superLayer != oldSuperLayer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphPackage.LAYER__SUPER_LAYER, oldSuperLayer, superLayer));
			}
		}
		return superLayer;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Layer basicGetSuperLayer() {
		return superLayer;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSuperLayer(Layer newSuperLayer, NotificationChain msgs) {
		Layer oldSuperLayer = superLayer;
		superLayer = newSuperLayer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GraphPackage.LAYER__SUPER_LAYER, oldSuperLayer, newSuperLayer);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperLayer(Layer newSuperLayer) {
		if (newSuperLayer != superLayer) {
			NotificationChain msgs = null;
			if (superLayer != null)
				msgs = ((InternalEObject)superLayer).eInverseRemove(this, GraphPackage.LAYER__SUB_LAYERS, Layer.class, msgs);
			if (newSuperLayer != null)
				msgs = ((InternalEObject)newSuperLayer).eInverseAdd(this, GraphPackage.LAYER__SUB_LAYERS, Layer.class, msgs);
			msgs = basicSetSuperLayer(newSuperLayer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.LAYER__SUPER_LAYER, newSuperLayer, newSuperLayer));
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Layer> getSubLayers() {
		if (subLayers == null) {
			subLayers = new EObjectWithInverseResolvingEList<Layer>(Layer.class, this, GraphPackage.LAYER__SUB_LAYERS, GraphPackage.LAYER__SUPER_LAYER);
		}
		return subLayers;
	}

	/**
	 * Listen on adding a Layer to the subLayers of this object, and checks, that a layer cannot 
	 * contain itself.
	 */
	@Override
	public void eNotify(Notification notification) 
	{
		if(notification.getFeature().equals(GraphPackage.Literals.LAYER__SUB_LAYERS)) 
		{//if change happens in Layer.getSubLayers()
			switch (notification.getEventType()) 
			{
				case Notification.ADD:
				{//if layer is added
					if (notification.getNewValue() instanceof Layer)
					{//if added object is a Layer
						if (this.equals(notification.getNewValue()))
							throw new GraphInsertException("Cannot add a Layer object to its sub-layer list. A layer cannot be contained by itself.");
					}//if added object is a Layer
				}//if layer is added
			}
		}//if change happens in Layer.getSubLayers()
		super.eNotify(notification);
	}
	
	/**
	 * 
	 */
	@Override
	public boolean eNotificationRequired() {
		return true;
	}

	/**
	 * Returns a list of all sub-layers of this layer recursively. Therefore sub-layers of the sub-layers
	 * of this layer are also contained in the returned list.
	 * @return a list containing all recursive sub-layers
	 */
	public EList<Layer> getAllSubLayers() 
	{
		EList<Layer> retVal= null;
		Layer currentLayer= this;
		if (	(currentLayer.getSubLayers()!= null) &&
				(currentLayer.getSubLayers().size()!= 0))
		{
			EList<Layer> notVisitedLayers= new BasicEList<Layer>();
			boolean start= true;
			retVal= new BasicEList<Layer>();
			while ( start ||
					notVisitedLayers.size() != 0)
			{//go through all sub-layers
				start= false;
				retVal.addAll(currentLayer.getSubLayers());
				notVisitedLayers.addAll(currentLayer.getSubLayers());
				currentLayer= notVisitedLayers.get(0);
				notVisitedLayers.remove(0);
			}//go through all sub-layers
		}
		return(retVal);
	}


	/**
	 * Returns a list of all nodes being contained in this layer or in the list
	 * of all its sub-layers.
	 * @return a list containing all nodes in all recursive sub-layers
	 */
	public EList<Node> getAllIncludedNodes() 
	{
		EList<Node> retVal= null;
		Layer currentLayer= this;
		if (	(currentLayer.getSubLayers()!= null) &&
				(currentLayer.getSubLayers().size()!= 0))
		{
			EList<Layer> notVisitedLayers= new BasicEList<Layer>();
			notVisitedLayers.add(currentLayer);
			retVal= new BasicEList<Node>();
			while ( (currentLayer!= null) &&
					(notVisitedLayers.size() != 0))
			{//go through all sub-layers
				notVisitedLayers.remove(0);
				notVisitedLayers.addAll(currentLayer.getSubLayers());
				retVal.addAll(currentLayer.getNodes());
				if (notVisitedLayers.size()> 0)
					currentLayer= notVisitedLayers.get(0);
				else currentLayer= null;
			}//go through all sub-layers
		}
		else 
		{//return only nodes directly contained in this layer
			retVal= new BasicEList<Node>();
			retVal.addAll(this.getNodes());
		}//return only nodes directly contained in this layer
		return(retVal);
	}


	/**
	 * Returns a list of all edges being contained in this layer or in the list
	 * of all its sub-layers.
	 * @return a list containing all edges in all recursive sub-layers
	 */
	public EList<Edge> getAllIncludedEdges() 
	{
		EList<Edge> retVal= null;
		Layer currentLayer= this;
		if (	(currentLayer.getSubLayers()!= null) &&
				(currentLayer.getSubLayers().size()!= 0))
		{
			EList<Layer> notVisitedLayers= new BasicEList<Layer>();
			notVisitedLayers.add(currentLayer);
			retVal= new BasicEList<Edge>();
			while ( (currentLayer!= null) &&
					(notVisitedLayers.size() != 0))
			{//go through all sub-layers
				notVisitedLayers.remove(0);
				notVisitedLayers.addAll(currentLayer.getSubLayers());
				retVal.addAll(currentLayer.getEdges());
				if (notVisitedLayers.size()> 0)
					currentLayer= notVisitedLayers.get(0);
				else currentLayer= null;
			}//go through all sub-layers
		}
		else 
		{//return only nodes directly contained in this layer
			retVal= new BasicEList<Edge>();
			retVal.addAll(this.getEdges());
		}//return only nodes directly contained in this layer
		return(retVal);
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
			case GraphPackage.LAYER__GRAPH:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetGraph((Graph)otherEnd, msgs);
			case GraphPackage.LAYER__NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNodes()).basicAdd(otherEnd, msgs);
			case GraphPackage.LAYER__EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEdges()).basicAdd(otherEnd, msgs);
			case GraphPackage.LAYER__SUPER_LAYER:
				if (superLayer != null)
					msgs = ((InternalEObject)superLayer).eInverseRemove(this, GraphPackage.LAYER__SUB_LAYERS, Layer.class, msgs);
				return basicSetSuperLayer((Layer)otherEnd, msgs);
			case GraphPackage.LAYER__SUB_LAYERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubLayers()).basicAdd(otherEnd, msgs);
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
			case GraphPackage.LAYER__GRAPH:
				return basicSetGraph(null, msgs);
			case GraphPackage.LAYER__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case GraphPackage.LAYER__EDGES:
				return ((InternalEList<?>)getEdges()).basicRemove(otherEnd, msgs);
			case GraphPackage.LAYER__SUPER_LAYER:
				return basicSetSuperLayer(null, msgs);
			case GraphPackage.LAYER__SUB_LAYERS:
				return ((InternalEList<?>)getSubLayers()).basicRemove(otherEnd, msgs);
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
			case GraphPackage.LAYER__GRAPH:
				return eInternalContainer().eInverseRemove(this, GraphPackage.GRAPH__LAYERS, Graph.class, msgs);
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
			case GraphPackage.LAYER__GRAPH:
				return getGraph();
			case GraphPackage.LAYER__NODES:
				return getNodes();
			case GraphPackage.LAYER__EDGES:
				return getEdges();
			case GraphPackage.LAYER__SUPER_LAYER:
				if (resolve) return getSuperLayer();
				return basicGetSuperLayer();
			case GraphPackage.LAYER__SUB_LAYERS:
				return getSubLayers();
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
			case GraphPackage.LAYER__GRAPH:
				setGraph((Graph)newValue);
				return;
			case GraphPackage.LAYER__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case GraphPackage.LAYER__EDGES:
				getEdges().clear();
				getEdges().addAll((Collection<? extends Edge>)newValue);
				return;
			case GraphPackage.LAYER__SUPER_LAYER:
				setSuperLayer((Layer)newValue);
				return;
			case GraphPackage.LAYER__SUB_LAYERS:
				getSubLayers().clear();
				getSubLayers().addAll((Collection<? extends Layer>)newValue);
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
			case GraphPackage.LAYER__GRAPH:
				setGraph((Graph)null);
				return;
			case GraphPackage.LAYER__NODES:
				getNodes().clear();
				return;
			case GraphPackage.LAYER__EDGES:
				getEdges().clear();
				return;
			case GraphPackage.LAYER__SUPER_LAYER:
				setSuperLayer((Layer)null);
				return;
			case GraphPackage.LAYER__SUB_LAYERS:
				getSubLayers().clear();
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
			case GraphPackage.LAYER__GRAPH:
				return getGraph() != null;
			case GraphPackage.LAYER__NODES:
				return nodes != null && !nodes.isEmpty();
			case GraphPackage.LAYER__EDGES:
				return edges != null && !edges.isEmpty();
			case GraphPackage.LAYER__SUPER_LAYER:
				return superLayer != null;
			case GraphPackage.LAYER__SUB_LAYERS:
				return subLayers != null && !subLayers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LayerImpl
