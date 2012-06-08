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
import java.util.Collections;
import java.util.HashSet;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.osgi.service.log.LogService;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GRAPH_TRAVERSE_TYPE;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphTraverseHandler;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.exceptions.GraphException;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.exceptions.GraphInsertException;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.ComplexIndex;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.SimpleIndex;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.GraphTraverserModule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphImpl#getIndexMgr <em>Index Mgr</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphImpl#getNodes <em>Nodes</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphImpl#getEdges <em>Edges</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphImpl#getNumOfNodes <em>Num Of Nodes</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphImpl#getNumOfEdges <em>Num Of Edges</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphImpl#getLayers <em>Layers</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphImpl#getNumOfLayers <em>Num Of Layers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GraphImpl extends IdentifiableElementImpl implements Graph 
{
	
	//TODO to delete
	public static Long equalTime= 0l;
	
	private class GraphAdapter extends EContentAdapter
	{
		public Graph graph= null;
		
		/**
		 * Resets the indexes of the global Graph object, in case of an id has changed
		 */
		private void resetIndexes(Notification notification)
		{
			{//id or Identifier of an IdentifiableElement has been changed
				if (	(notification!= null) &&
						(notification.getNotifier()!= null)&&
						(	(notification.getNotifier() instanceof IdentifiableElement) ||
							(notification.getNotifier() instanceof Identifier)))
				{//do only in case of notifier is Identifier or IdentifiableElement		
					String oldId= null;
					Identifier identifier= null;
					IdentifiableElement identifiableElement= null;
					if (notification.getNotifier() instanceof IdentifiableElement)
					{//an Identifier object has changed
						if (	(notification.getOldValue() instanceof Identifier) &&
								(notification.getOldValue()!= null))
							oldId= ((Identifier) notification.getOldValue()).getId();
						identifier= (Identifier) notification.getNewValue();
						identifiableElement= (IdentifiableElement) ((Identifier)notification.getNewValue()).getIdentifiableElement();
					}//an Identifier object has changed
					else if (notification.getNotifier() instanceof Identifier)
					{//an id has changed
						oldId= (String) notification.getOldValue();
						identifier= (Identifier) notification.getNotifier();
						identifiableElement= identifier.getIdentifiableElement();
					}//an id has changed
					else
						throw new GraphException("THIS CAN`T HAPPEN!!!");
					
					if (identifiableElement== null)
					{
						throw new GraphException("An id has changed in an Identifier-object, but this object is not connected to a IdentifiableElement object.");
					}
					if (oldId!= null)
					{//do only if oldId is not null, otherwise there can't be any entry in an index	
						if (identifiableElement instanceof Node)
						{//owner of identifier is a node
							//refresh node name index
							((SimpleIndex)this.graph.getIndexMgr().getIndex(IDX_NODENAME)).removeElementById(oldId);
							((SimpleIndex)this.graph.getIndexMgr().getIndex(IDX_NODENAME)).addElement(identifier.getId(), identifier.getIdentifiableElement());
							
							if (((ComplexIndex)this.graph.getIndexMgr().getIndex(IDX_OUTEDGES)).hasSlot(identifier.getId()))
							{//refresh node outgoing index	
								EList<Object> slotOut= ((ComplexIndex)this.graph.getIndexMgr().getIndex(IDX_OUTEDGES)).getSlot(oldId);
								((ComplexIndex)this.graph.getIndexMgr().getIndex(IDX_OUTEDGES)).removeSlot(oldId);
								((ComplexIndex)this.graph.getIndexMgr().getIndex(IDX_OUTEDGES)).addElement(identifier.getId(), slotOut);
							}
							if (((ComplexIndex)this.graph.getIndexMgr().getIndex(IDX_INEDGES)).hasSlot(identifier.getId()))
							{//refresh node ingoing index
								EList<Object> slotIn= ((ComplexIndex)this.graph.getIndexMgr().getIndex(IDX_INEDGES)).getSlot(oldId);
								((ComplexIndex)this.graph.getIndexMgr().getIndex(IDX_INEDGES)).removeSlot(oldId);
								((ComplexIndex)this.graph.getIndexMgr().getIndex(IDX_INEDGES)).addElement(identifier.getId(), slotIn);
							}
						}
						else if (identifiableElement instanceof Edge)
						{//owner of identifier is an edge
							((SimpleIndex)this.graph.getIndexMgr().getIndex(IDX_EDGENAME)).removeElementById(oldId);
							((SimpleIndex)this.graph.getIndexMgr().getIndex(IDX_EDGENAME)).addElement(identifier.getId(), identifier.getIdentifiableElement());
						}
						else 
						{
							
						}		
					}//do only if oldId is not null, otherwise there can't be any entry in an index
				}//id or Identifier of an IdentifiableElement has been changed
			}//do only in case of notifier is Identifier or IdentifiableElement
		}
		
		/**
		 * This method is called, if any value in one of the observed objects has changed. This method ensures, that all indexes of
		 * the owning graph will be kept up-to-date.
		 */
		public void notifyChanged(Notification notification) 
		{
			if (notification.getFeature() instanceof EAttribute)
			{//if changed object is of type EAttribute
				if (notification.getFeature().equals(GraphPackage.Literals.IDENTIFIER__ID))
				{//if changed value is Identifier.id
					switch (notification.getEventType()) 
					{
						case Notification.SET:
						{//if Identifier.id has been set or reset
							this.resetIndexes(notification);
							break;
						}//if Identifier.id has been set or reset
					}
					
				}//if changed value is Identifier.id
			}//if changed object is of type EAttribute
			
			super.notifyChanged(notification);
			
			
			if (notification.getFeature() instanceof EReference) 
			{
				if  (GraphPackage.Literals.EDGE__SOURCE.equals(notification.getFeature()))						 	
				{
					if (notification.getOldValue()!=null) {
						changeEdgeSource(((Edge)notification.getNotifier()).getId(), ((Node)notification.getNewValue()).getId());
					}
					//create entry in outgoing index
					else graph.getIndexMgr().getIndex(IDX_OUTEDGES).addElement(((Edge)notification.getNotifier()).getSource().getId(), ((Edge)notification.getNotifier()));
				}
				else if (GraphPackage.Literals.EDGE__TARGET.equals(notification.getFeature()))
				{
					if (notification.getOldValue()!=null) 
					{
						String id= null;
						if (((Node)notification.getNewValue())!= null)
							id= ((Node)notification.getNewValue()).getId();
						changeEdgeTarget(((Edge)notification.getNotifier()).getId(), id);
					}
					//create entry in outgoing index
					else graph.getIndexMgr().getIndex(IDX_INEDGES).addElement(((Edge)notification.getNotifier()).getTarget().getId(), ((Edge)notification.getNotifier()));
				}
				else if (notification.getFeature().equals(GraphPackage.Literals.IDENTIFIABLE_ELEMENT__IDENTIFIER))
				{//identifier has changed some value
					switch (notification.getEventType()) 
					{
						case Notification.ADD:
						{//a new value is given
							this.resetIndexes(notification);
							break;
						}
						case Notification.SET:
						{//a new value is given
							this.resetIndexes(notification);
							break;
						}
					}
				}
			}
		}
	}
	/**
	 * name of index for nodes
	 */
	public static final String IDX_NODENAME=	"idx_nodename";
	/**
	 * name of index for edges
	 */
	public static final String IDX_EDGENAME=	"idx_edgename";
	/**
	 * name of index for all outgoing edges ( id= Knotenname, value= all outgoing edges
	 */
	public static final String IDX_OUTEDGES=	"idx_outedges";
	/**
	 * name of index for all ingoing edges ( id= Knotenname, value= all ingoing edges
	 */
	public static final String IDX_INEDGES=	"idx_inedges";
	
	/**
	 * The cached value of the '{@link #getNodes() <em>Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> nodes;
	/**
	 * The cached value of the '{@link #getEdges() <em>Edges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> edges;

	/**
	 * The default value of the '{@link #getNumOfNodes() <em>Num Of Nodes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumOfNodes()
	 * @generated
	 * @ordered
	 */
	protected static final Long NUM_OF_NODES_EDEFAULT = null;
	/**
	 * The default value of the '{@link #getNumOfEdges() <em>Num Of Edges</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumOfEdges()
	 * @generated
	 * @ordered
	 */
	protected static final Long NUM_OF_EDGES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLayers() <em>Layers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLayers()
	 * @generated
	 * @ordered
	 */
	protected EList<Layer> layers;

	/**
	 * The default value of the '{@link #getNumOfLayers() <em>Num Of Layers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumOfLayers()
	 * @generated
	 * @ordered
	 */
	protected static final Long NUM_OF_LAYERS_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected GraphImpl() {
		super();
		this.init();
	}

	private void init()
	{  
		//creates a new adapter for notifying the graph in case of id-changes
		this.graphAdapter = new GraphAdapter();
		this.graphAdapter.graph= this;
		
		//creating index manager and all needed indexes
		this.indexMgr= IndexFactory.eINSTANCE.createIndexMgr();
		
		//node index
		Index index= null;
		index= IndexFactory.eINSTANCE.createSimpleIndex();
		index.setId(IDX_NODENAME);
		this.getIndexMgr().addIndex(index);
		
		//edge index
		index= IndexFactory.eINSTANCE.createSimpleIndex();
		index.setId(IDX_EDGENAME);
		this.getIndexMgr().addIndex(index);
		
		//outgoing edge index
		index= IndexFactory.eINSTANCE.createComplexIndex();
		index.setId(IDX_OUTEDGES);
		this.getIndexMgr().addIndex(index);
		
		//ingoing edge index
		index= IndexFactory.eINSTANCE.createComplexIndex();
		index.setId(IDX_INEDGES);
		this.getIndexMgr().addIndex(index);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GraphPackage.Literals.GRAPH;
	}
// ---------------- start log service for osgi 
	private LogService logService;

	public void setLogService(LogService logService) {
		this.logService = logService;
	}
	
	public LogService getLogService(LogService logService) 
	{
		return(this.logService);
	}
	
	public void unsetLogService(LogService logService) {
		logService= null;
	}
// ---------------- end log service for osgi

// ---------------- start: notifying if nodes or edges list has changed
	@SuppressWarnings("unchecked")
	@Override
	public void eNotify(Notification notification) 
	{
		super.eNotify(notification);		
		
		if (notification.getFeature() instanceof EReference) {
			EReference ref = (EReference) notification.getFeature();
			if(ref.equals(GraphPackage.Literals.GRAPH__NODES)) {
				switch (notification.getEventType()) {
				case Notification.ADD:
					if (notification.getNewValue() instanceof Node)
					{
						try
						{
							this.basicAddNode((Node) notification.getNewValue());
						}
						catch (GraphInsertException e) 
						{
							throw e;
						}
						catch (GraphException e)
						{ 
							this.getNodes().remove((Node) notification.getNewValue());
							throw e;
						}
					}	
					else throw new GraphException("Only a node object can be added into graph.nodes()-list. But added was: "+notification.getNewValue().getClass());
					break;
				case Notification.ADD_MANY:
					throw new GraphException("More than one nodes are added ontime. I don't know what to do. This is an internal error.");
//					break;
				case Notification.REMOVE:
					if (notification.getOldValue() instanceof Node)
					{
						this.removeNodeInternal((Node) notification.getOldValue());
					}	
					else 
					{
						throw new GraphException("Only a node object can be removed from graph.nodes()-list. But removed was: "+notification.getOldValue().getClass());
					}
					break;
				case Notification.REMOVE_MANY:
					//if all nodes shall be removed
					if (this.getNumOfNodes()== 0)
					{//remove all indexes
						this.removeNodesInternal();
					}
					else 
					{//remove step by step
						for (Node node: ((EList<Node>)notification.getNewValue()))
							this.removeNodeInternal(node);
					}	
					break;
				default:
					break;
				}
			}
			else if(ref.equals(GraphPackage.Literals.GRAPH__EDGES)) {
				switch (notification.getEventType()) {
				case Notification.ADD:
					if (notification.getNewValue() instanceof Edge)
					{
						try
						{
							this.basicAddEdge((Edge) notification.getNewValue());
						}
						catch (GraphException e)
						{ 
							this.getEdges().remove((Edge) notification.getNewValue());
							throw e;
						}
					}	
					else throw new GraphException("Only an Edge object can be added into graph.Edges()-list. But added was: "+notification.getNewValue().getClass());
					break;
				case Notification.ADD_MANY:
					throw new GraphException("More than one Edges are added ontime. I don't know what to do. This is an internal error.");
//					break;
				case Notification.REMOVE:
					if (notification.getOldValue() instanceof Edge)
					{
						this.removeEdgeInternal((Edge) notification.getOldValue());
					}	
					else 
					{
						throw new GraphException("Only a Edge object can be removed from graph.Edges()-list. But removed was: "+notification.getOldValue().getClass());
					}
					break;
				case Notification.REMOVE_MANY:
					//if all edges shall be removed
					if (this.getNumOfEdges()== 0)
					{//remove all indexes
						this.removeEdgesInternal();
					}
					else 
					{//remove step by step
						for (Edge edge: ((EList<Edge>)notification.getNewValue()))
							this.removeEdgeInternal(edge);
					}	
					break;
				default:
					break;
				}
			}
			else if(ref.equals(GraphPackage.Literals.GRAPH__LAYERS)) 
			{//when a layers of graph has been changed 
				switch (notification.getEventType()) 
				{
					case Notification.ADD:
						if (notification.getNewValue() instanceof Layer)
						{
							this.basicAddLayer((Layer) notification.getNewValue());
						}	
						else throw new GraphException("Only a Edge object can be added into graph.Edges()-list. But added was: "+notification.getNewValue().getClass());
						break;
					case Notification.ADD_MANY:
						throw new GraphException("More than one Layer are added at one time. I don't know what to do. This is an internal error.");
//						break;
					case Notification.REMOVE:
//						throw new GraphException("One Layer has been removed. I don't know what to do. This is an internal error.");
						break;
					case Notification.REMOVE_MANY:
//						throw new GraphException("More than one Layer has been removed. I don't know what to do. This is an internal error.");
						break;
					default:
						break;
				}
			}//when a layers of graph has been changed
		}		
	}
	@Override
	public boolean eNotificationRequired() {
		return true;
	}
// ---------------- end: notifying if nodes or edges list has changed

	/**
	 * An index manager object, which creates a better access to nodes and edges.
	 */
	protected IndexMgr indexMgr= null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndexMgr getIndexMgr() {
		IndexMgr indexMgr = basicGetIndexMgr();
		return indexMgr != null && indexMgr.eIsProxy() ? (IndexMgr)eResolveProxy((InternalEObject)indexMgr) : indexMgr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public IndexMgr basicGetIndexMgr() 
	{
		return(this.indexMgr);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setIndexMgr(IndexMgr newIndexMgr) 
	{
		this.indexMgr= newIndexMgr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Edge> getEdges()
	{
		if (edges == null) {
			edges = new EObjectContainmentWithInverseEList<Edge>(Edge.class, this, GraphPackage.GRAPH__EDGES, GraphPackage.EDGE__GRAPH);
		}
		return edges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Node> getNodes() {
		if (nodes == null) {
			nodes = new EObjectContainmentWithInverseEList<Node>(Node.class, this, GraphPackage.GRAPH__NODES, GraphPackage.NODE__GRAPH);
		}
		return nodes;
	}

	/**
	 * Returns the number of nodes contained in this graph object.
	 * @return number of nodes
	 */
	public Long getNumOfLayers() 
	{
		return(new Long(this.getLayers().size()));
	}
	
	/**
	 * Returns the number of nodes contained in this graph object.
	 * @return number of nodes
	 */
	public Long getNumOfNodes() 
	{
		return(new Long(this.getNodes().size()));
	}

	/**
	 * Returns the number of edges contained in this graph object.
	 * @return number of nodes
	 */
	public Long getNumOfEdges() 
	{
		return(new Long(this.getEdges().size()));
	}

	/**
	 * An adapter for this object to resolve notifications in case of id changes
	 */
	private GraphAdapter graphAdapter = new GraphAdapter();
	
//====================== start: layer-handling
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Layer> getLayers() {
		if (layers == null) {
			layers = new EObjectContainmentWithInverseEList<Layer>(Layer.class, this, GraphPackage.GRAPH__LAYERS, GraphPackage.LAYER__GRAPH);
		}
		return layers;
	}
	
	/**
	 * Sets an id to the given layer object.
	 * @param layer
	 */
	protected void basicAddLayer(Layer layer)
	{
		//if node has no id a new id will be given to node
		if (layer.getId()== null)
		{	
			layer.setId("layer"+getNumOfLayers());
		}
	}
//====================== end: layer-handling
//====================== start: node-handling
	
	/**
	 * Inserts a Node object into this graph object.
	 */
	protected void basicAddNode(Node node)
	{
		if (node== null)
			throw new GraphInsertException("Cannot add an empty node.");
		//if node has no id a new id will be given to node
		if (node.getId()== null)
		{	
			node.setId("node"+getNumOfNodes());
		}
		int i= 0;
		while(this.getNode(node.getId())!= null)
		{//if node already exists, create new Id
			node.setId(node.getId()+"_"+(getNumOfNodes()+i));
			i++;
		}//if node already exists, create new Id
		
		this.getNodes().add(node);
		this.getIndexMgr().getIndex(IDX_NODENAME).addElement(node.getId(), node);
		{//create a notifier for changes in node
			node.eAdapters().add(this.graphAdapter);
			node.getIdentifier().eAdapters().add(this.graphAdapter);
		}
	}
	
	/**
	 * Adds the given node to list of nodes. 
	 * @param node - node which shall be added
	 * @exception a GraphException will be thrown if node.getId() is null 
	 */
	public void addNode(Node node) 
	{
		if (!this.getNodes().add(node))
		{
			if (this.getNodes().contains(node))
				throw new GraphInsertException("Cannot add the given node with id, because it does already exists in graph '"+this.getId()+"'. node: "+ node.getId() + "("+node+")");
			else
				throw new GraphInsertException("Cannot add the given node, because of unknown reason. Maybe it was already added. node: "+ node.getId() + "("+node+")");
		}
	}

	/**
	 * Searches a node with the given identifier.
	 * @param nodeId identifier for searched node
	 * @return node matching to given id
	 */
	public Node getNode(String nodeId)
	{ 
		Node retNode= null;
		retNode= (Node)((SimpleIndex)this.getIndexMgr().getIndex(IDX_NODENAME)).getElement(nodeId);
		return(retNode);
	}

	/**
	 * Removes a node if such a node exists. Also all outgoing
	 * and incoming edges will be removed. If node does not belong to graph nothing will happen.
	 * @param node which shall be removed
	 * @return true, if node removed successful
	 */
	protected Boolean removeNodeInternal(Node node)
	{
		boolean retVal= false;
		if ( (node!= null) && (node.getId()!= null))
		{
			if (this.getIndexMgr().getIndex(IDX_NODENAME).hasElement(node.getId()))
			{	
				//deleting all outgoing edges
				for (Edge edge: this.getOutEdges(node.getId()))
				{
					this.removeEdgeById(edge.getId());
				}
				//deleting all incoming edges
				for (Edge edge: this.getInEdges(node.getId()))
				{
					this.removeEdgeById(edge.getId());
				}
				
				//removing node from internal list
				this.getNodes().remove(this.getNode(node.getId()));
				//removing node from all indexes
				this.getIndexMgr().removeElement(this.getNode(node.getId()));
				
				//remove observers on edge
				node.eAdapters().remove(this.graphAdapter);
				node.getIdentifier().eAdapters().remove(this.graphAdapter);
			}
			retVal= true;
		}
		return(retVal);
	}
	
	/**
	 * Removes a node matching to given node id if such a node exists. Also all outgoing
	 * and incoming edges will be removed. If node does not belong to graph nothing will happen.
	 * @param nodeId id to node which shall be removed
	 * @return true, if node removed successful
	 */
	public Boolean removeNodeById(String nodeId) 
	{
		return(this.removeNode(this.getNode(nodeId)));
	}

	/**
	 * Removes a node if such a node exists. Also all outgoing
	 * and incoming edges will be removed. If node does not belong to graph nothing will happen.
	 * @param node node which shall be removed
	 * @return true, if node removed successful
	 */
	public Boolean removeNode(Node node) 
	{
		Boolean retVal= false;
		retVal= this.getNodes().remove(node);
		return(retVal);
	}
	
	/**
	 * Removes all nodes contained in this graph
	 * @return true, if all nodes are removed successful
	 */
	protected boolean removeNodesInternal() 
	{
		boolean retVal= true;
		
		//clearing index for edges
		this.getIndexMgr().getIndex(IDX_NODENAME).removeAll();
		
		//clearing other indexes 
		for (Node node: this.getNodes())	
			this.getIndexMgr().removeElement(node);
		
		//remove all Edges, because they can' t exist without nodes
		this.removeEdges();
		
		return(retVal);
	}
	
	/**
	 * Removes all nodes contained in this graph
	 * @return true, if all nodes are removed successful
	 */
	public Boolean removeNodes() 
	{
		//clearing internal node list
		this.getNodes().clear();
		if (this.getNumOfNodes()== 0)
			return(true);
		else return(false);
	}
//====================== end: node-handling	

//====================== start: edge-handling	
	/**
	 * Adds the given edge to graph. If edge is related to nodes which does not belong to graph,
	 * an exception will be thrown.
	 * @param edge to add
	 */
	protected void basicAddEdge(Edge edge)
	{
		if (edge== null) 
			throw new GraphInsertException("Cannot insert the given edge, beaceuse the edge is empty.");
		
		//if edge has no id a new id will be given to edge
		if (edge.getId()== null) 
			edge.setId("edge"+getNumOfEdges());
		int i= 0;
		while(this.getEdge(edge.getId())!= null)
		{//if edge already exists, create new Id
			edge.setId(edge.getId()+"_"+(getNumOfEdges() +i));
			i++;
		}//if edge already exists, create new Id
					
		//put new edge into edge list
		this.getEdges().add(edge);
		//put edge into naming index
		this.getIndexMgr().getIndex(IDX_EDGENAME).addElement(edge.getId(), edge);
				
		//throw exception, if source isn't null, but is not added to graph 
		if (edge.getSource()!= null)
		{
			if ((this.getNode(edge.getSource().getId())== null))
			{
				throw new GraphInsertException("Cannot insert the given edge, because source of edge does not belong to list of nodes in graph: "+ edge.getSource().getId());
			}
			//insert edge into index outEdges
			this.getIndexMgr().getIndex(IDX_OUTEDGES).addElement(edge.getSource().getId(), edge);
		}
		//throw exception, if target isn't null, but is not added to graph
		if (edge.getTarget()!= null)
		{
			if ((this.getNode(edge.getTarget().getId())== null))
				throw new GraphException("Cannot insert the given edge, because destination of edge  does not belong to list of nodes in graph: "+ edge.getTarget());
			//insert edge in index inEdges
			this.getIndexMgr().getIndex(IDX_INEDGES).addElement(edge.getTarget().getId(), edge);
		}	
		
		{//create a notifier for changes in edge
			edge.eAdapters().add(this.graphAdapter);
			edge.getIdentifier().eAdapters().add(this.graphAdapter);
		}//create a notifier for changes in edge
	}
	
	/**
	 * Adds the given edge to graph. If edge is related to nodes which does not belong to graph,
	 * an exception will be thrown.
	 * @param edge to be added
	 */
	public void addEdge(Edge edge) 
	{
		if (!this.getEdges().add(edge))
			throw new GraphException("Cannot add the given edge, because of unknown reason. Maybe it was already added. edge: "+ edge);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Edge getEdge(String edgeId) 
	{
		Edge retEdge= null;
		retEdge= (Edge)((SimpleIndex)this.getIndexMgr().getIndex(IDX_EDGENAME)).getElement(edgeId);
		return(retEdge);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EList<Edge> getEdges(String nodeId1, String nodeId2) 
	{
		EList<Edge> retList= null;
		//searching for all edges going out from nodeId1
		EList<Edge> outEdges= this.getOutEdges(nodeId1);
		
		for (Edge edge: outEdges)
		{//searching if edge goes to nodeId2
			if (edge.getTarget().getId().equals(nodeId2))
			{
				//initialize return list if it is not
				if (retList== null)
					retList= new BasicEList<Edge>();
				//adding edge to list of matching edges
				retList.add(edge);
			}
		}//searching if edge goes to nodeId2	
		return(retList);
	}

	/**
	 * Returns a list of all incoming edges of node matching to  given node identifier.
	 * @param nodeId identifier of node 
	 * @return all incoming edges to node matching to given identifier
	 */
	public EList<Edge> getInEdges(String nodeId) 
	{
		EList<Edge> inEdges= new BasicEList<Edge>();
		if (((ComplexIndex)this.getIndexMgr().getIndex(IDX_INEDGES)).hasSlot(nodeId))
		{
			for (Object edge: ((ComplexIndex)this.getIndexMgr().getIndex(IDX_INEDGES)).getSlot(nodeId))
				inEdges.add((Edge) edge);
		}
		return(inEdges);
	}

	/**
	 * Returns a list of all outgoing edges of node matching to  given node identifier.
	 * @param nodeId identifier of node 
	 * @return all outgoing edges to node matching to given identifier
	 */
	public EList<Edge> getOutEdges(String nodeId) 
	{
		EList<Edge> outEdges= new BasicEList<Edge>();
		if (((ComplexIndex)this.getIndexMgr().getIndex(IDX_OUTEDGES)).hasSlot(nodeId))
		{
			for (Object edge: ((ComplexIndex)this.getIndexMgr().getIndex(IDX_OUTEDGES)).getSlot(nodeId))
				outEdges.add((Edge) edge);
		}
		return(outEdges);
	}

	/**
	 * Removes an edge from graph. If edge is empty nothing will be done.
	 * @param edge which shall be removed
	 * @return true, if edge removed successful
	 */
	protected Boolean removeEdgeInternal(Edge edge)
	{
		boolean retVal= false;
		if (edge!= null)
		{
			//removing edge from all indexes
			this.getIndexMgr().removeElement(edge);
			//removing edge from internal list
			this.getEdges().remove(edge);
			
			//remove observers on edge
			edge.eAdapters().remove(this.graphAdapter);
			edge.getIdentifier().eAdapters().remove(this.graphAdapter);
			
			retVal= true;
		}
		return(retVal);
	}
	
	
	/**
	 * Removes an edge related to given id from graph. If edge is empty nothing will be done.
	 * @param edgeId which shall be removed
	 * @return true, if edge removed successful
	 */
	public Boolean removeEdgeById(String edgeId) 
	{
		Edge edge= this.getEdge(edgeId);
		return(this.getEdges().remove(edge));
	}

	/**
	 * Removes all edges in this graph.
	 * @return true, if edges removed successful
	 */
	protected Boolean removeEdgesInternal() 
	{
		boolean retVal= true;
		
		//clearing index for edges
		this.getIndexMgr().getIndex(IDX_EDGENAME).removeAll();
		this.getIndexMgr().getIndex(IDX_OUTEDGES).removeAll();
		this.getIndexMgr().getIndex(IDX_INEDGES).removeAll();
		
		//clearing other indexes 
		for (Edge edge: this.getEdges())	
			this.getIndexMgr().removeElement(edge);
		
		return(retVal);
	}
	
	/**
	 * Removes all edges in this graph.
	 * @return true, if edges removed successful
	 */
	public Boolean removeEdges() 
	{
		//clearing internal edge list
		this.getEdges().clear();
		if (this.getNumOfEdges()== 0)
			return(true);
		else return(false);
	}

	/**
	 * Removes the given edge from this graph.
	 * @param edge the egde to remove
	 * @return true, if edge is removed successful
	 */
	@Override
	public Boolean removeEdge(Edge edge) 
	{
		return(this.getEdges().remove(edge));
	}

	/**
	 * Redirects the index for outgoing edges.
	 * @param edgeId the edge, which has changed
	 * @param nodeId the new source
	 */
	public void changeEdgeSource(String edgeId, String nodeId) 
	{
		Edge edge= this.getEdge(edgeId);
		
		if (edge.getSource()== null) 
			throw new GraphException("Cannot insert the given edge, the source (node from wich the edge comes) is empty. Edge: "+edge);
		//set new source in edge if it isn't already reset
		if (!edge.getSource().getId().equalsIgnoreCase(nodeId)) 
			edge.setSource(this.getNode(nodeId));
		
		//remove old entry in outgoing index, if exists
		if (((ComplexIndex)this.getIndexMgr().getIndex(IDX_OUTEDGES)).hasElement(edge))
		{
			((ComplexIndex)this.getIndexMgr().getIndex(IDX_OUTEDGES)).removeElement(edge);
		}
		
		//create entry in outgoing index
		this.getIndexMgr().getIndex(IDX_OUTEDGES).addElement(edge.getSource().getId(), edge);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void changeEdgeTarget(String edgeId, String nodeId) 
	{
		Edge edge= this.getEdge(edgeId);
		if (edge== null)
			throw new GraphException("Cannot change target of given edge, because no edge with given id '"+edgeId+"' was found in graph.");
		if (edge.getTarget()== null) 
			throw new GraphException("Cannot insert the given edge, the destination (node to wich the edge goes) is empty. Edge: "+edge);

		if (edge.getTarget().getId()== null) 
			throw new GraphException("Cannot insert the given edge, because the ID of target is null. Edge: "+edge);
		
		//set new target in edge if it isn't already reset
		if (!edge.getTarget().getId().equalsIgnoreCase(nodeId)) 
			edge.setTarget(this.getNode(nodeId));
		
		//remove old entry in ingoing index, if exists
		if (((ComplexIndex)this.getIndexMgr().getIndex(IDX_INEDGES)).hasElement(edge))
			((ComplexIndex)this.getIndexMgr().getIndex(IDX_INEDGES)).removeElement(edge);
		
		//create entry in ingoing index
		this.getIndexMgr().getIndex(IDX_INEDGES).addElement(edge.getTarget().getId(), edge);
	}

	/**
	 * Adds the given node to the graph, as long as it is not null. If the layer is null, the node will be 
	 * added without a layer. The method add(Node) will be called to add the node to the graph. 
	 * If the layer is not contained in this graph object, it will be added. 
	 * After all, the node will be added to the layer, if the layer does not already contains it.
	 * @param node the node to be added
	 * @param layer the layer to which the node shall be added
	 */
	public void addNode(Node node, Layer layer) 
	{
		if (node!= null)
		{
			if (layer!= null)
			{
				if (!layer.getNodes().contains(node))
					layer.getNodes().add(node);
			}
			this.addNode(node);
		}
	}

	/**
	 * Adds the given edge to the graph, as long as it is not null. If the layer is null, the edge will be 
	 * added without a layer. The method add(Node) will be called to add the edge to the graph. 
	 * If the layer is not contained in this graph object, it will be added. 
	 * After all, the edge will be added to the layer, if the layer does not already contains it.
	 * @param edge the edge to be added
	 * @param layer the layer to which the edge shall be added
	 */
	public void addEdge(Edge edge, Layer layer) 
	{
		if (edge!= null)
		{
			if (layer!= null)
			{
				if (!layer.getEdges().contains(edge))
					layer.getEdges().add(edge);
			}
			this.addEdge(edge);
		}
	}

	/**
	 * Adds the given node to the graph, as long as it is not null. If the layer is null, the method
	 * add(Node) will be called. If the layer is not contained in this graph object, it will be added. 
	 * After all, the node will be added to the layer, if the layer does not already contains it.
	 * @param node the node to be added
	 * @param layer the layer to which the node shall be added
	 */
	public void addLayer(Layer layer) 
	{
		if (layer== null)
			throw new GraphException("Cannot add an empty layer");
		if (this.getLayers().contains(layer))
			throw new GraphException("Cannot add the same layer ('"+layer.getId()+"') two times.");
		this.getLayers().add(layer);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public Layer getLayer(String layerId) 
	{
		Layer retVal= null;
		if (this.getLayers()!= null)
		{
			for (Layer layer: this.getLayers())
			{
				if (layer.getId().equalsIgnoreCase(layerId))
				{
					retVal= layer;
					break;
				}
			}
		}
		return(retVal);
	}

	/**
	 * {@inheritDoc Graph#getRoots()}
	 */
	public EList<Node> getRoots() {
		EList<Node> retList= null;
		retList= new BasicEList<Node>();
		if (this.getNodes().size()==1)
		{//if corpusGraph only contains one corpus it shall not need to be traversed
			retList.add(this.getNodes().get(0)); 
		}//if corpusGraph only contains one corpus it shall not need to be traversed
		else
		{	
			for (Node node: Collections.synchronizedCollection(this.getNodes()))
			{
				//checking if node has ingoing edges
				EList<Edge> inEdges= this.getInEdges(node.getId());
				if (	(inEdges == null) ||
						(inEdges.size() == 0))
				{
					retList.add(node);
				}
			}
		}
		if (retList.size()== 0)
			retList= null;
		return(retList);
	}

	/**
	 * {@inheritDoc Graph#getLeafs()}
	 */
	public EList<Node> getLeafs() 
	{
		EList<Node> retList= null;
		retList= new BasicEList<Node>();
		if (this.getNodes().size()==1)
		{//if corpusGraph only contains one corpus it shall not need to be traversed
			retList.add(this.getNodes().get(0)); 
		}//if corpusGraph only contains one corpus it shall not need to be traversed
		else
		{	
			for (Node node: Collections.synchronizedCollection(this.getNodes()))
			{
				//checking if node has ingoing edges
				EList<Edge> outEdges= this.getOutEdges(node.getId());
				if (	(outEdges == null) ||
						(outEdges.size() == 0))
				{
					retList.add(node);
				}
			}
		}
		if (retList.size()== 0)
			retList= null;
		return(retList);
	}

	/**
	 * {@inheritDoc Graph#traverse(EList, GRAPH_TRAVERSE_TYPE, String, GraphTraverseHandler)}
	 */
	public void traverse(	EList<Node> startNodes, 
							GRAPH_TRAVERSE_TYPE traverseType, 
							String traverseId, 
							GraphTraverseHandler traverseHandler) 
	{
		this.traverse(startNodes, traverseType, traverseId, traverseHandler, true);
	}

	/**
	 * {@inheritDoc {@link Graph#traverse(EList, GRAPH_TRAVERSE_TYPE, String, GraphTraverseHandler, boolean)}}
	 */
	public void traverse(EList<Node> startNodes, GRAPH_TRAVERSE_TYPE traverseType, String traverseId, GraphTraverseHandler traverseHandler, boolean isCycleSafe) 
	{
		GraphTraverserModule traverserModule= new GraphTraverserModule();
		traverserModule.setGraph(this);
		traverserModule.traverse(startNodes, traverseType, traverseId, traverseHandler);
	}

	//====================== end: edge-handling
	
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
			super.equals(differences, obj);
		}
		else
		{
			if (!super.equals(differences, obj))
				return(false);
		}
		if (obj== null)
			return(false);
		
		Graph other= (Graph) obj;
		
		//start: check layers
			if (this.getLayers() == null) 
			{
				if (other.getLayers()!= null)
				{	if (differences!= null)
						differences.add(this.getClass().getSimpleName()+": The number of layers of this graph and the given one differs. "+this.getId()+": null, "+other.getId()+": "+other.getLayers().size()+".");
					else return false;
				}
			}
			else if (other.getLayers()== null)
			if (other.getLayers()!= null)
			{	if (differences!= null)
					differences.add(this.getClass().getSimpleName()+": The number of layers of this graph and the given one differs. "+this.getId()+": "+this.getLayers().size()+", "+other.getId()+": null.");
				else return false;
			}
			else if (this.getLayers().hashCode()!= other.getLayers().hashCode())
			{	
				if (differences!= null)
					differences.add(this.getClass().getSimpleName()+": The hashcode of layers is not the same.");
				else return false;
			}
			if (this.getLayers().size()!= other.getLayers().size())
			{//check size of sublayers
				if (differences!= null)
					differences.add(this.getClass().getSimpleName()+": The number of layers of this graph and the given one differs. "+this.getId()+": "+this.getLayers().size()+", "+other.getId()+": "+other.getLayers().size()+".");
				else return(false);
			}//check size of sublayers
		//end: check layers
		//start: check nodes
			if (this.getNodes() == null) 
			{
				if (other.getNodes()!= null)
				{	
					if (differences!= null)
						differences.add(this.getClass().getSimpleName()+": The number of nodes of this graph and the given one differs. "+this.getId()+": null, "+other.getId()+": "+other.getNodes().size()+".");
					else return false;
				}
			}
			else if (other.getNodes()== null)
			{
				if (differences!= null)
					differences.add(this.getClass().getSimpleName()+": The number of nodes of this graph and the given one differs. "+this.getId()+": "+this.getNodes().size()+", "+other.getId()+": null.");
				else return false;
			}
			else 
			{
				if (this.getNodes().size()!= other.getNodes().size())
				{//check size of nodes
					if (differences!= null)
						differences.add(this.getClass().getSimpleName()+": The number of nodes of this graph and the given one differs. "+this.getId()+": "+this.getNodes().size()+", "+other.getId()+": "+other.getNodes().size()+".");
					else return(false);
				}//check size of nodes
				
				// TODO: remove this when hashEList is part of GraphImpl
				HashSet<Node> thisNodes = new HashSet<Node>(this.getNodes());
				for (Node node : other.getNodes()){
					if (! thisNodes.contains(node)){
						if (differences!= null)
							differences.add(this.getClass().getSimpleName()+": Node "+node.getId()+" in "+ other.getId() + " has no equivalent in "+ this.getId());
						else return false;
					}
				}
			}
		//end: check nodes
		
		//start: check edges
			if (this.getEdges() == null) 
			{
				if (other.getEdges()!= null)
				{	
					if (differences!= null)
						differences.add(this.getClass().getSimpleName()+": The number of edges of this graph and the given one differs. "+this.getId()+": null, "+other.getId()+": "+other.getEdges().size()+".");
					else return false;
				}
			}
			else if (other.getEdges()== null)
			{
				if (differences!= null)
					differences.add(this.getClass().getSimpleName()+": The number of edges of this graph and the given one differs. "+this.getId()+": "+this.getEdges().size()+", "+other.getId()+": null.");
				else return false;
			}
			else 
			{
				if (this.getEdges().size()!= other.getEdges().size())
				{//check size of edges
					if (differences!= null)
						differences.add(this.getClass().getSimpleName()+": The number of edges of this graph and the given one differs. "+this.getId()+": "+this.getEdges().size()+", "+other.getId()+": "+other.getEdges().size()+".");
					else return(false);
				}//check size of edges
				// TODO: remove this when hashEList is part of GraphImpl
				HashSet<Edge> thisEdges = new HashSet<Edge>(this.getEdges());
				for (Edge edge: other.getEdges()){
					if (! thisEdges.contains(edge)){


						if (differences!= null)	
							differences.add(this.getClass().getSimpleName()+": Edge "+edge.getId()+" in "+ other.getId() + " has no equivalent in "+ this.getId());
						else return false;
					}
				}
			}
		//end: check edges
		return(true);
	}
	
	/**
	 * Checks the equality of this object and a given one basing on the identifier, the labels, 
	 * the contained nodes, edges and layers as well. 
	 * 
	 * @return true if both objects are equal respecting to the named values.
	 */
	@Override
	public boolean equals(Object obj)
	{
		boolean retVal= this.equals(null, obj); 
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
			case GraphPackage.GRAPH__NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getNodes()).basicAdd(otherEnd, msgs);
			case GraphPackage.GRAPH__EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getEdges()).basicAdd(otherEnd, msgs);
			case GraphPackage.GRAPH__LAYERS:
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
			case GraphPackage.GRAPH__NODES:
				return ((InternalEList<?>)getNodes()).basicRemove(otherEnd, msgs);
			case GraphPackage.GRAPH__EDGES:
				return ((InternalEList<?>)getEdges()).basicRemove(otherEnd, msgs);
			case GraphPackage.GRAPH__LAYERS:
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GraphPackage.GRAPH__INDEX_MGR:
				if (resolve) return getIndexMgr();
				return basicGetIndexMgr();
			case GraphPackage.GRAPH__NODES:
				return getNodes();
			case GraphPackage.GRAPH__EDGES:
				return getEdges();
			case GraphPackage.GRAPH__NUM_OF_NODES:
				return getNumOfNodes();
			case GraphPackage.GRAPH__NUM_OF_EDGES:
				return getNumOfEdges();
			case GraphPackage.GRAPH__LAYERS:
				return getLayers();
			case GraphPackage.GRAPH__NUM_OF_LAYERS:
				return getNumOfLayers();
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
			case GraphPackage.GRAPH__INDEX_MGR:
				setIndexMgr((IndexMgr)newValue);
				return;
			case GraphPackage.GRAPH__NODES:
				getNodes().clear();
				getNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case GraphPackage.GRAPH__EDGES:
				getEdges().clear();
				getEdges().addAll((Collection<? extends Edge>)newValue);
				return;
			case GraphPackage.GRAPH__LAYERS:
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
			case GraphPackage.GRAPH__INDEX_MGR:
				setIndexMgr((IndexMgr)null);
				return;
			case GraphPackage.GRAPH__NODES:
				getNodes().clear();
				return;
			case GraphPackage.GRAPH__EDGES:
				getEdges().clear();
				return;
			case GraphPackage.GRAPH__LAYERS:
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
			case GraphPackage.GRAPH__INDEX_MGR:
				return basicGetIndexMgr() != null;
			case GraphPackage.GRAPH__NODES:
				return nodes != null && !nodes.isEmpty();
			case GraphPackage.GRAPH__EDGES:
				return edges != null && !edges.isEmpty();
			case GraphPackage.GRAPH__NUM_OF_NODES:
				return NUM_OF_NODES_EDEFAULT == null ? getNumOfNodes() != null : !NUM_OF_NODES_EDEFAULT.equals(getNumOfNodes());
			case GraphPackage.GRAPH__NUM_OF_EDGES:
				return NUM_OF_EDGES_EDEFAULT == null ? getNumOfEdges() != null : !NUM_OF_EDGES_EDEFAULT.equals(getNumOfEdges());
			case GraphPackage.GRAPH__LAYERS:
				return layers != null && !layers.isEmpty();
			case GraphPackage.GRAPH__NUM_OF_LAYERS:
				return NUM_OF_LAYERS_EDEFAULT == null ? getNumOfLayers() != null : !NUM_OF_LAYERS_EDEFAULT.equals(getNumOfLayers());
		}
		return super.eIsSet(featureID);
	}

} //GraphImpl
