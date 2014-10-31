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
package de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules;

import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.exceptions.GraphException;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.GraphTraverser.GRAPH_TRAVERSE_MODE;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.exceptions.GraphModuleException;
@Deprecated
public class GraphTraverserObject implements Runnable
{
	private static Long idCounter= 0l;
	/**
	 * Creates a new unused id.
	 * @return a unique id
	 */
	private static Long getNewId()
	{
		synchronized (idCounter) 
		{
			Long id= idCounter;
			idCounter++;
			return(id);
		}
	}
	
	private Long id= null;

	/**
	 * Returns a unique identifier for this object. This is neccassary in case of threading, 
	 * if one traversal object calls more than one time traversing of graph.
	 * @return unique id
	 */
	public Long getId() {
		return id;
	}
// ================================================ start exception handling
// ================================================ end exception handling
	/**
	 * Says if traversing shall be cycle safed.
	 */
	private Boolean isCycleSafe= true;
	
	/**
	 * If cycleSafe is set to false, the calling application has to take a look, if traversion runs into a 
	 * cycle by itself. Else every edge is traversed only one time.
	 * @param isCycleSafe the isCycleSafe to set
	 */
	public void setCycleSafe(Boolean isCycleSafe) {
		this.isCycleSafe = isCycleSafe;
	}

	/**
	 * If cycleSafe is set to false, the calling application has to take a look, if traversion runs into a 
	 * cycle by itself. Else every edge is traversed only one time.
	 * @return the isCycleSafe
	 */
	public Boolean getCycleSafe() {
		return isCycleSafe;
	}
	
	private TraversalObject traversalObj= null;
	
	/**
	 * The current object which shall be notified.
	 */
	public TraversalObject getTraversalObj() {
		return traversalObj;
	}
	
	public GraphTraverserObject()
	{
		init();
	}
	
	private void init()
	{
		this.id= getNewId();
//		visitedEdges= new BasicEList<Edge>();
		visitedEdges= new HashMap<Edge, Object>();
	}
	
	/**
	 * Sets the object which shall be notified while traversing.
	 * @param traversalObj
	 */
	protected void setTraversalObject(TraversalObject traversalObj)
	{
		if (traversalObj== null)
			throw new GraphModuleException("Cannot create a GraphTraverserObject-object, because the given 'traversalObject' is null.");
		this.traversalObj= traversalObj;
	}
	
	private GRAPH_TRAVERSE_MODE tMode= null;
	/**
	 * Sets the current traversal mode.
	 * @param tMode
	 */
	protected void setTMode(GRAPH_TRAVERSE_MODE tMode) {
		this.tMode = tMode;
	}

	/**
	 * Returns the current traversal mode.
	 * @return
	 */
	public GRAPH_TRAVERSE_MODE getTMode() {
		return tMode;
	}
	
	/**
	 * the current graph
	 */
	private Graph graph= null;
	
	/**
	 * Sets the graph on which shall be traversed.
	 * @param graph current graph
	 */
	protected void setGraph(Graph graph) 
	{
		if (graph== null)
			throw new GraphModuleException("Cannot set an empty graph.");
		this.graph = graph;
	}

	/**
	 * Returns the graph, on which shall be traversed.
	 * @return current graph
	 */
	public Graph getGraph() {
		return graph;
	}
	
	/**
	 * This method traverses the graph beginning from startnode. The kind of traversion
	 * is determined by tMode. All reached nodes will messaged to the given TraversalObject
	 * by callback.<br/> 
	 * @param node the node, from which the traversion shall start.
	 */
	public void start(Node startNode)
	{
		EList<Node> startNodes= new BasicEList<Node>();
		startNodes.add(startNode);
		this.start(startNodes);
	}
	
	/**
	 * list of already visited nodes
	 */
	private EList<Node> visitedNodes= null;					
	
	/**
	 * Says if the start method was called
	 */
	private Boolean isStarted= false;
	/**
	 * This method traverses the graph beginning from startnode. The kind of traversion
	 * is determined by tMode. All reached nodes will messaged to the given TraversalObject
	 * by callback.<br/>  
	 * @param nodes the nodes, from which the traversion shall start.
	 */
	public void start(EList<Node> startNodes)
	{
		synchronized (isStarted) 
		{
			if (isStarted)
				throw new GraphModuleException("Cannot start traversion for two times");
			isStarted= true;
			if (this.getGraph()== null)
				throw new GraphModuleException("Cannot start traversing, because the graph is empty.");
			if (this.getTMode()== null)
				throw new GraphModuleException("Cannot start traversing, because the tMode is empty.");
			if (this.getTraversalObj()== null)
				throw new GraphModuleException("Cannot start traversing, because the traversal object is empty.");
			if (	(startNodes== null) ||
					(startNodes.size()== 0))
				throw new GraphModuleException("Cannot start traversing, because no start nodes are given.");
			this.startNodes= startNodes;
			Thread traverseThread= new Thread(this, "GraphTraverserObject_"+this.getGraph().getId());
			traverseThread.start();
		}
	}
	
	/**
	 * List which contains start nodes
	 */
	private EList<Node> startNodes= new BasicEList<Node>();
	
	@Override
	public void run() 
	{
		//if sMode= BottomUp
		try
		{
			if (tMode== GRAPH_TRAVERSE_MODE.BOTTOM_UP)
			{
				//traverse all nodes via bottom up
				for (Node startNode: startNodes)
				{	
					if (this.getTraversalObj().checkConstraint(GRAPH_TRAVERSE_MODE.BOTTOM_UP, this.getId(), null, startNode, 0l))
						this.bottomUpRec(startNode, null, null, 0);
				}
				this.visitedNodes= null;
			}
			//if sMode= DepthFirst
			else if (tMode== GRAPH_TRAVERSE_MODE.DEPTH_FIRST)
			{
				//traverse all nodes via depthFirst
				for (Node startNode: startNodes)
				{	
					if (this.getTraversalObj().checkConstraint(GRAPH_TRAVERSE_MODE.DEPTH_FIRST, this.getId(), null, startNode, 0l))
						this.depthFirstRec(startNode, null, null, 0);
				}
				this.visitedNodes= null;
				
			}
		}
		catch (Exception e) {
			this.getExceptions().add(new GraphModuleException("An exception occured while traversing graph '"+this.getGraph().getId()+"' ",e));
		}
		finally
		{
			this.finish();
		}
	}
	
	/**
	 * Rekursiver Aufruf f�r die Methode depthFirst
	 * @param currNode Node - aktueller Knoten
	 * @param edge Edge - Kante, die die beiden Knoten verbindet
	 * @param father - Vater des aktuellen Knotens
	 * @param order - Reihenfolge in der der aktuelle Knoten in der Kinderliste des Vaters vorkommt (beginnend bei null)
	 * @throws Exception
	 */
	protected void depthFirstRec(	Node currNode,
									Edge edge,
									Node father,
									long order)
	{
			
			if (currNode== null)
				throw new GraphModuleException("Cannot traverse node starting at empty start node.");
//			if (this.logService!= null) 
//				this.logService.log(LogService.LOG_DEBUG, "start depthFirstRec() in node: "+ currNode.getId());	
			this.getTraversalObj().nodeReached(GRAPH_TRAVERSE_MODE.DEPTH_FIRST, this.getId(), currNode, edge, father, order);
			
			//durch alle Kinder dieses Knotens gehen
			EList<Edge> childEdges= this.getGraph().getOutEdges(currNode.getId());
			//wenn Knoten Kinder hat
			if (childEdges != null)
			{
				//gehe durch alle Kinder des aktuellen Knoten
				int i= 0;
				for(Edge childEdge: childEdges)
				{
					if (	(!this.getCycleSafe()) ||
							(!this.hasVisited(childEdge)))
					{//if is not cycle safe or  the edge has not been visited	
						this.markAsVisited(childEdge);
						Node childNode= childEdge.getTarget();
						if (this.getTraversalObj().checkConstraint(GRAPH_TRAVERSE_MODE.DEPTH_FIRST, this.getId(), childEdge, childNode, order))
						{
							try
							{
								this.depthFirstRec(childNode, childEdge, currNode, i);
							} catch (StackOverflowError e) 
							{
								System.out.println("\n\nCycle detected, cannot raise an error\n\n");
								System.exit(-1);
							}
							i++;
						}
					}
				}
			}
			this.getTraversalObj().nodeLeft(GRAPH_TRAVERSE_MODE.DEPTH_FIRST, this.getId(), currNode, edge, father,  order);
			
//			if (this.logService!= null) 
//				this.logService.log(LogService.LOG_DEBUG, "end depthFirstRec(currNode: "+currNode+", edge: "+ edge+ ", fatcher: "+ father+ ", order: "+ order+")");
	}
	
	/**
	 * Rekursiver Aufruf f�r die Methode bottomUp
	 * @param currNode Node - aktueller Knoten
	 * @param edge Edge - Kante, die die beiden Knoten verbindet
	 * @param child - Vater des aktuellen Knotens
	 * @param order - Reihenfolge in der der aktuelle Knoten in der Kinderliste des Vaters vorkommt (beginnend bei null)
	 * @throws Exception
	 */
	protected void bottomUpRec(	Node currNode,
								Edge edge,
								Node child,
								long order)
	{
//		if (this.logService!= null) 
//			this.logService.log(LogService.LOG_DEBUG, "start depthFirstRec()");
		
		//wenn dieser Knoten schon einmal besichtigt wurde, dann abbruch
		if (	(this.visitedNodes!= null) && 
				(this.visitedNodes.contains(currNode)));
		//sonst weiter traversieren
		else
		{
			if (visitedNodes!= null) 
				this.visitedNodes.add(currNode);
			this.getTraversalObj().nodeReached(GRAPH_TRAVERSE_MODE.BOTTOM_UP, this.getId(),  currNode, edge, child, order);
			
			//durch alle Kinder dieses Knotens gehen
			EList<Edge> parentEdges= this.getGraph().getInEdges(currNode.getId());
			//wenn Knoten Kinder hat
			if (parentEdges != null)
			{
				//gehe durch alle Kinder des aktuellen Knoten
				int i= 0;
				for(Edge parentEdge: parentEdges)
				{
					if (	(!this.getCycleSafe()) ||
							(!this.hasVisited(parentEdge)))
					{//if is not cycle safe or  the edge hasn�t been visited	
						this.markAsVisited(parentEdge);
						Node parentNode= parentEdge.getSource();
						if (this.getTraversalObj().checkConstraint(GRAPH_TRAVERSE_MODE.BOTTOM_UP, this.getId(),  parentEdge, parentNode, order))
						{
							this.bottomUpRec(parentNode, parentEdge, currNode, i);
							i++;
						}
					}
				}
			}
			this.getTraversalObj().nodeLeft(GRAPH_TRAVERSE_MODE.BOTTOM_UP, this.getId(),  currNode, edge, child,  order);
		}	
//		if (this.logService!= null) 
//			this.logService.log(LogService.LOG_DEBUG, "end depthFirstRec()");
	}

	private static String KW_NS= "graphTraverseObject";
	private static String KW_VISITED= "visited";
	//private EList<Edge> visitedEdges= null;
	private HashMap<Edge, Object> visitedEdges= null;
	/**
	 * Marks the given node as visited.
	 * Attention: this method is not thread safe
	 * @param edge
	 */
	private void markAsVisited(Edge edge)
	{
		if (edge== null)
			throw new GraphException("Cannot mark an empty Edge-object as vistited.");
		
		//TODO remove this
		if (visitedByNode)
		{	
			String name= KW_VISITED+ this.getId();
			if (edge.getLabel(KW_NS, name)== null)
			{
				Label label= GraphFactory.eINSTANCE.createLabel();
				label.setNamespace(KW_NS);
				label.setName(name);
				label.setValue(true);
				edge.addLabel(label);
			}
		}
		else
		{
			this.visitedEdges.put(edge, true);
		}
		//TODO end remove this
	}
	
	/**
	 * Returns true, if edge already has been visited, false else.
	 * Attention: this method is not thread safe
	 * @param edge the edge which shall be checked
	 * @return
	 */
	private boolean hasVisited(Edge edge)
	{
		Boolean retVal= false;
		
		//TODO remove this
		if (visitedByNode)
		{	
			if (edge== null)
				throw new GraphException("Cannot check if edge has been visited, because it is empty.");
			String name= KW_VISITED+ this.getId();
			if (edge.getLabel(KW_NS, name)!= null)
			{
				retVal= true;
			}
		}
		else
		{
			retVal= this.visitedEdges.containsKey(edge);
		}
		//TODO end remove this
		
		return(retVal);
	}
	
	//TODO remove this
	public boolean visitedByNode= false;
//  =========================== start: stuff for threading
	/**
	 * Lock to tock await and signal methods.
	 */
	protected Lock lock= new ReentrantLock();
	
	/**
	 * Condition, which tells if the monitor don�t have to wait any more.
	 */
	private Condition isFinished=lock.newCondition();
	
	protected boolean finished = false;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void waitUntilFinished() 
	{
		lock.lock();
		try {
		if (!finished)
			isFinished.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new NullPointerException(e.getMessage());
		}
		
		lock.unlock();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void finish() 
	{
		this.lock.lock();
		this.finished= true;
		isFinished.signal();
		this.lock.unlock();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public boolean isFinished() 
	{
		return(this.finished);
	}

	protected EList<GraphModuleException> exceptions;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<GraphModuleException> getExceptions() {
		if (exceptions == null) {
			exceptions = new BasicEList<GraphModuleException>();
		}
		return exceptions;
	}
	
	public void addException(GraphModuleException e) 
	{
		if (exceptions == null) 
			exceptions = new BasicEList<GraphModuleException>();
		exceptions.add(e);
		this.finish();
	}
//  =========================== end: stuff for threading
}
