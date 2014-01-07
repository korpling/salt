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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GRAPH_TRAVERSE_TYPE;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphTraverseHandler;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.exceptions.GraphTraverserException;


/**
 * Handles the traversal of a graph.
 * @author Florian Zipser
 *
 */
public class GraphTraverserModule extends GraphModule
{
	/**
	 * Stores all used traverseIds to the corresponding traverse callback handler. This is used, to check, that an id is not used
	 * twice.
	 */
	private volatile HashMap<GraphTraverseHandler, EList<String>> traverseIdTable= new HashMap<GraphTraverseHandler, EList<String>>();
	
	/**
	 * Traverses a graph in the given order traverseType and starts traversing with the given startNodes. When a node is reached, 
	 * first this method will invoke the method {@link GraphTraverseHandler#checkConstraint(GRAPH_TRAVERSE_TYPE, String, Edge, Node, long)} 
	 * of the given callback handler traverseHandler, second the method {@link GraphTraverseHandler#nodeReached(GRAPH_TRAVERSE_TYPE, String, Node, Edge, Node, long)}
	 * is invoked. When a node was left, the method {@link GraphTraverseHandler#nodeLeft(GRAPH_TRAVERSE_TYPE, String, Node, Edge, Node, long)} 
	 * is invoked. When calling these methods, the traverseId will be passed, so that the callback handler knows which traversal is meant.
	 * This is helpful, in case of a single callback handler is used for more than one traversal at  the same time.
	 * This method throws a {@link GraphTraverserException} in case of the graph contains a cycle. A cycle means a path containing the same 
	 * node twice.
	 * Cycle safe breadth first traversing could consume a lot of memory because the algorithm keeps a map of all visited Nodes for every start node.
	 * 
	 * @param startNodes list of nodes at which the traversal shall start
	 * @param traverseType type of traversing
	 * @param traverseId identification for callback handler, in case of more than one traversal is running at the same time with the same callback handler
	 * @param traverseHandler callback handler, on which the three methods will be invoked
	 */
	public void traverse(	EList<Node> startNodes,
							GRAPH_TRAVERSE_TYPE traverseType, 
							String traverseId,
							GraphTraverseHandler traverseHandler)
	{
		this.traverse(startNodes, traverseType, traverseId, traverseHandler, true);
	}
	
	/**
	 * Traverses a graph in the given order traverseType and starts traversing with the given startNodes. When a node is reached, 
	 * first this method will invoke the method {@link GraphTraverseHandler#checkConstraint(GRAPH_TRAVERSE_TYPE, String, Edge, Node, long)} 
	 * of the given callback handler traverseHandler, second the method {@link GraphTraverseHandler#nodeReached(GRAPH_TRAVERSE_TYPE, String, Node, Edge, Node, long)}
	 * is invoked. When a node was left, the method {@link GraphTraverseHandler#nodeLeft(GRAPH_TRAVERSE_TYPE, String, Node, Edge, Node, long)} 
	 * is invoked. When calling these methods, the traverseId will be passed, so that the callback handler knows which traversal is meant.
	 * This is helpful, in case of a single callback handler is used for more than one traversal at  the same time.
	 * This method throws a {@link GraphTraverserException} in case of the graph contains a cycle. A cycle means a path containing the same 
	 * node twice.
	 * Cycle safe breadth first traversing could consume a lot of memory because the algorithm keeps a map of all visited Nodes for every start node.
	 * 
	 * @param startNodes list of nodes at which the traversal shall start
	 * @param traverseType type of traversing
	 * @param traverseId identification for callback handler, in case of more than one traversal is running at the same time with the same callback handler
	 * @param traverseHandler callback handler, on which the three methods will be invoked
	 * @param isCycleSafe if this value is false, this method does not take care about cycles. This can invoke endless loops.
	 */
	public void traverse(	EList<Node> startNodes,
							GRAPH_TRAVERSE_TYPE traverseType, 
							String traverseId,
							GraphTraverseHandler traverseHandler,
							boolean isCycleSafe)
	{
		if (this.getGraph()== null)
			throw new GraphTraverserException("Cannot start traversing graph, because the graph is null.");
		if (	(startNodes== null)||
				(startNodes.size()== 0))
			throw new GraphTraverserException("Cannot start traversing graph '"+this.getGraph().getId()+"', because the given start nodes are empty.");
		if (traverseType== null)
			throw new GraphTraverserException("Cannot start traversing graph '"+this.getGraph().getId()+"', because the given traverseType is empty.");
		if (traverseHandler== null)
			throw new GraphTraverserException("Cannot start traversing graph '"+this.getGraph().getId()+"', because the given callback handler 'traverseHandler' is empty.");
		
		{//check if traverseId is already in use
			 synchronized (traverseIdTable) 
			 {
				if (traverseIdTable.containsKey(traverseHandler))
				{
					EList<String> ids= traverseIdTable.get(traverseHandler);
					if (ids.contains(traverseId))
					{
						throw new GraphTraverserException("Cannot start traversing graph '"+this.getGraph().getId()+"', because the traverse id '"+traverseId+"' is already registered for the given callback handler '"+traverseHandler+"'.");
					}
					else ids.add(traverseId);
				}
				else
				{
					//TODO replace this with HashEList
					EList<String> ids= new BasicEList<String>();
					ids.add(traverseId);
					traverseIdTable.put(traverseHandler, ids);
				}
			}
		}//check if traverseId is already in use
		Traverser traverser= new Traverser();
		traverser.startNodes= startNodes;
		traverser.traverseType= traverseType;
		traverser.traverseId= traverseId;
		traverser.traverseHandler= traverseHandler;
		traverser.isCycleSafe= isCycleSafe;
		traverser.setGraph(this.getGraph());
		Thread traverserThread= new Thread(traverser, "GraphTraverserThread_"+ traverseId);

		
		traverser.traverselock.lock();
		
		traverserThread.start();
		//traverserThread.join();
		try {
			traverser.traverseFinished.await();
		} catch (InterruptedException e) {
			throw new GraphTraverserException("An exception occurs while traversing the graph '"+this.getGraph().getId()+"'." ,e);
		} finally
		{
			traverser.traverselock.unlock();
		}
		
		{//clean up traverseIdTable
			synchronized (traverseIdTable) {
				if (this.traverseIdTable.get(traverseHandler).size()>1)
				{//only remove id
					this.traverseIdTable.get(traverseHandler).remove(traverseId);
				}//only remove id
				else
				{//remove whole entry 
					this.traverseIdTable.remove(traverseHandler);
				}//remove whole entry
			}
		}//clean up traverseIdTable

		if (traverser.getException()!= null)
		{//ckecks if an error occurs while traversal and throws it
			throw new GraphTraverserException("Traversal of graph produced an exception. ", traverser.getException());
		}//ckecks if an error occurs while traversal and throws it
	}
	
	/**
	 * A threadable class, which traverses the graph and invokes methods of the given callback handler during the traversal.
	 * @author Florian Zipser
	 *
	 */
	class Traverser implements Runnable
	{
		/**
		 * list of nodes where traversal starts
		 */
		EList<Node> startNodes= null;
		/**
		 * kind of traversal
		 */
		GRAPH_TRAVERSE_TYPE traverseType= null;
		/**
		 * an identifier for identifying the current traversal process
		 */
		String traverseId= null;
		/**
		 * The callback handler on which the methods while traversal will be invoked.
		 */
		GraphTraverseHandler traverseHandler= null;
		
		/**
		 * If value is false, this object does not take care about cycles in traversion.
		 */
		boolean isCycleSafe= true;
		
		/**
		 * In Case of an exception occurs during traversal, it will be stored here, so that the calling method can check if the 
		 * traversal finished successfully or with an error.
		 */
		private GraphTraverserException exception= null;
		private void setException(GraphTraverserException exception) {
			this.exception = exception;
		}

		/**
		 * In Case of an exception occurs during traversal, it will be stored here, so that the calling method can check if the 
		 * traversal finished successfully or with an error.
		 * @return
		 */
		public GraphTraverserException getException() {
			return exception;
		}
		
		/**
		 * The graph to traverse.
		 */
		private Graph graph= null;
		public void setGraph(Graph graph) {
			this.graph = graph;
		}

		public Graph getGraph() {
			return graph;
		}
		
		Lock traverselock= new ReentrantLock();
		/**
		 * a condition which is signaled, when a traversion has been finished.
		 */
		private Condition traverseFinished= traverselock.newCondition();
		
		/**
		 * Currently only used for {@link GRAPH_TRAVERSE_TYPE#TOP_DOWN_DEPTH_FIRST}.
		 * Single entries for a stack to stores the path, which has been used in traversal.
		 * Contains a node, a counter for the edge and order, in which child node the traversal currently is.
		 * @author florian
		 *
		 */
		private class NodeEntry
		{
			private final Node node;
			private int order;
			private Edge edge;
			
			public NodeEntry(Node node, int order)
			{
				this.node = node;
				this.order = order;
			}
			public String toString(){
				return(((node!= null)? node.toString() : "")+": "+order);
			}
			@Override
			public boolean equals(Object obj){
				if (obj== null) 
					return false;
				if (obj== this)
					return true;
				if (obj instanceof NodeEntry){
					return(node.equals(((NodeEntry) obj).node));
				}
				else return(false);
			}
		}
		
		/**
		 * Currently only used for {@link GRAPH_TRAVERSE_TYPE#TOP_DOWN_DEPTH_FIRST}.
		 * Basing on the given order in the passed {@link NodeEntry} element, this method checks if
		 * further children exist. If true, the next child is returned and the order counter of the 
		 * passed element is increased by 1.
		 * @param entry
		 * @return
		 */
		protected Node nextChild(NodeEntry entry){
			Node retVal= null;
			List<Edge> outEdges= getGraph().getOutEdges(entry.node.getId());
			if (	(outEdges!= null)&&
					(!outEdges.isEmpty())){
				if (entry.order<outEdges.size()){
					entry.edge= outEdges.get(entry.order);
					retVal= entry.edge.getTarget();
					entry.order++;
				}
			}
			return(retVal);
		}
		
		/**
		 * Starts traversal, with set properties. 
		 */
		public void run() 
		{
			this.traverselock.lock();
			try {
				if (GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST.equals(this.traverseType))
				{//TOP_DOWN_DEPTH_FIRST traversal
					for (Node startNode: startNodes)
					{
						if (traverseHandler.checkConstraint(GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, traverseId, null, startNode, 0l))
						{
							Stack<NodeEntry> parentStack= new Stack<NodeEntry>();
							NodeEntry currentEntry= new NodeEntry(startNode, 0);
							while(	(!parentStack.isEmpty())||
									(currentEntry!= null)){
								if (currentEntry!= null){//way down
									if (isCycleSafe){//check if cycle exists
										if (parentStack.contains(currentEntry))
										{
											StringBuffer text= new StringBuffer(); 
											for (Node node: this.currentNodePath)
											{
												text.append(node.getId());
												text.append(" --> ");
											}
											text.append(currentEntry.node.getId());
											throw new GraphTraverserException("A cycle in graph '"+graph.getId()+"' has been detected, while traversing with type '"+traverseType+"'. The cycle has been detected when visiting node '"+currentEntry.node+"' while current path was '"+ text.toString() +"'.");
										}
									}
									NodeEntry peekEntry= null;
									if (!parentStack.isEmpty())
										peekEntry= parentStack.peek();
									parentStack.push(currentEntry);
									Node nextChild= nextChild(currentEntry);
									if (peekEntry== null)
										traverseHandler.nodeReached(GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, traverseId, currentEntry.node, null, null, 0);
									else
										traverseHandler.nodeReached(GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, traverseId, currentEntry.node, peekEntry.edge, (peekEntry.edge!= null)?peekEntry.edge.getSource():null, peekEntry.order);
									if (nextChild!= null){
										if (traverseHandler.checkConstraint(GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, traverseId, currentEntry.edge, nextChild, currentEntry.order))
											currentEntry= new NodeEntry(nextChild, 0);
										else currentEntry= null;
									}
									else currentEntry= null;
								}else{
									NodeEntry peekEntry= parentStack.peek();
									if (peekEntry!= null){
										Node nextChild= nextChild(peekEntry);
										if (nextChild!= null){//way down, another branch was found 
											if (traverseHandler.checkConstraint(GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, traverseId, peekEntry.edge, nextChild, peekEntry.order))
												currentEntry= new NodeEntry(nextChild, 0);
											else currentEntry= null;
										}
										else{//way up
											parentStack.pop();
											
											//collect stuff for notification
											Node peekNode= peekEntry.node; 
											peekEntry= null;
											if (!parentStack.isEmpty())
												peekEntry= parentStack.peek();
											if (peekEntry== null)
												traverseHandler.nodeLeft(GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, traverseId, peekNode, null, null, 0);
											else
												traverseHandler.nodeLeft(GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, traverseId, peekNode, peekEntry.edge, (peekEntry.edge!= null)?peekEntry.edge.getSource():null, peekEntry.order);
										}
									}
								}
							}
							
						}
					}
				}//TOP_DOWN_DEPTH_FIRST traversal
				else if (GRAPH_TRAVERSE_TYPE.BOTTOM_UP_DEPTH_FIRST.equals(this.traverseType))
				{//BOTTOM_UP_DEPTH_FIRST traversal
					for (Node startNode: startNodes)
					{
						//TODO replace EList with HashEList
						this.currentNodePath= new BasicEList<Node>();
						if (traverseHandler.checkConstraint(GRAPH_TRAVERSE_TYPE.BOTTOM_UP_DEPTH_FIRST, traverseId, null, startNode, 0l))
						{
							this.currentNodePath.add(startNode);
							this.bottomUpDepthFirstRec(null, 0);
						}
					}
				}else if (GRAPH_TRAVERSE_TYPE.TOP_DOWN_BREADTH_FIRST.equals(this.traverseType))
				{// TOP_DOWN_BREADTH_FIRST traversal
					for (Node startNode: startNodes)
					{
						//TODO replace EList with HashEList
						this.currentNodePath= new BasicEList<Node>();
						if (traverseHandler.checkConstraint(GRAPH_TRAVERSE_TYPE.TOP_DOWN_BREADTH_FIRST, traverseId, null, startNode, 0l))
						{
							this.currentNodePath.add(startNode);							
						}
					}
					breadthFirst();
				}// TOP_DOWN_BREADTH_FIRST traversal
				else if (GRAPH_TRAVERSE_TYPE.BOTTOM_UP_BREADTH_FIRST.equals(this.traverseType))
				{// BOTTOM_UP_BREADTH_FIRST traversal
					for (Node startNode: startNodes)
					{
						//TODO replace EList with HashEList
						this.currentNodePath= new BasicEList<Node>();
						if (traverseHandler.checkConstraint(GRAPH_TRAVERSE_TYPE.BOTTOM_UP_BREADTH_FIRST, traverseId, null, startNode, 0l))
						{
							this.currentNodePath.add(startNode);							
						}
					}
					breadthFirst();
				}// BOTTOM_UP_BREADTH_FIRST traversal
			} catch (Exception e) 
			{
				GraphTraverserException ex= null;
				if (e instanceof GraphTraverserException)
				{
					ex= (GraphTraverserException)e;
					this.setException(ex);
				}
				else {
					ex= new GraphTraverserException("An exception occured while traversing the graph '"+graph.getId()+"' with path '"+currentNodePath+"'.",e);
					this.setException(ex);
				}
			}
			finally
			{
				//signal all waiting threads in case of no exception until here occurs
				this.traverseFinished.signalAll();
				this.traverselock.unlock();
			}
		}
		

		/**
		 * Traverses the graph in breadth first order. Edges are followed from source to target.
		 * If the {@link Traverser#traverseType} is ({@link GRAPH_TRAVERSE_TYPE#BOTTOM_UP_BREADTH_FIRST})
		 * edges are followed in their opposite direction. 
		 * <br/>
		 * During the BFS {@link Traverser#currentNodePath} will only contain one node at most. 
		 * The node most recently visited node.
		 * <br/>
		 * This function isn't able to detect cycles.
		 *  
		 * @param edge is the edge, via which the current node (last one in currentPath) was reached
		 * @param order number of current edge in list of all outgoing edges of the parent node
		 */
		private void breadthFirst() {
			if(isCycleSafe){
				throw new GraphTraverserException("Not able to detect cycles with breadth first search");
			}
			if (	(this.currentNodePath== null)||
					(this.currentNodePath.isEmpty()))
				throw new GraphTraverserException("Cannot traverse node starting at empty start node.");
			final boolean isTopDown = traverseType != GRAPH_TRAVERSE_TYPE.BOTTOM_UP_BREADTH_FIRST;
			Node fromNode = null;
			Edge fromEdge = null;
			//TODO replace EList with HashEList
			EList<Node> queuedNodes = new BasicEList<Node>();
			EList<Node> queueReachedFrom = new BasicEList<Node>();
			EList<Edge> queueReachedFromEdge = new BasicEList<Edge>();
			EList<Integer> queueReachedOrder = new BasicEList<Integer>();
//			EMap<Node, EMap<Node, Integer>> distanceFromStartNode = new BasicEMap<Node, EMap<Node,Integer>>();
			
			queuedNodes.addAll(startNodes);
			for (Node startNode : startNodes) {
				queueReachedFrom.add(startNode);
				queueReachedFromEdge.add(null);
				queueReachedOrder.add(0);
//				distanceFromStartNode.put(startNode, new BasicEMap<Node, Integer>());
//				distanceFromStartNode.get(startNode).put(startNode, 0);
			}
			currentNodePath.clear();
			while(!queuedNodes.isEmpty()){
				Node tNode = queuedNodes.remove(0);
				fromNode = queueReachedFrom.remove(0);
				fromEdge = queueReachedFromEdge.remove(0);
				Integer order = queueReachedOrder.remove(0);
//				EMap<Node, Integer> distance = distanceFromStartNode.get(fromNode);
				
				EList<Edge> edgesIn  = this.getGraph().getInEdges(tNode.getId());
				EList<Edge> edgesOut = this.getGraph().getOutEdges(tNode.getId());
				EList<Edge> edges    = null;
				currentNodePath.add(tNode);
				traverseHandler.nodeReached(traverseType, traverseId, tNode, fromEdge, fromNode, order);
				if (isTopDown) {//Switching in and out nodes list
					edges = edgesOut;
				}else{
					edges    = edgesIn;
					edgesIn  = edgesOut;
					edgesOut = edges;
				}
				if (edges != null)
				{//in case of node has childs
					int orderCount = 0;
					for(Edge e: edges){
						Node n = null;
						n = (isTopDown)? e.getTarget() : e.getSource();				
//						if(!this.isCycleSafe ){
//							Do Nothing
//						}else if(!(distance.containsKey(n))){
//							distance.put(n, distance.get(tNode) + 1);
//						} else if (distance.get(n) < distance.get(tNode)){
//							throw new GraphTraverserException("A cycle in graph '"+graph.getId()+"' has been detected, while traversing with type '"+traverseType+"'. The cycle has been detected when visiting node '"+tNode+"' while current path was '"+ this.currentNodePath+"'.");									
//						}
						
						if (traverseHandler.checkConstraint(traverseType, traverseId, e, n, order))
						{
							queuedNodes.add(n);
							queueReachedFrom.add(fromNode);
							queueReachedFromEdge.add(e);
							queueReachedOrder.add(orderCount);
						}
						++orderCount;
					}
				}
				traverseHandler.nodeLeft(traverseType, traverseId, tNode, fromEdge, fromNode, order);
				currentNodePath.remove(0);
			}
		}
	

		/**
		 * Contains the path beginning from root node to current node.
		 */
		private EList<Node> currentNodePath= null;
		
		/**
		 * A recursive method, which traverses through the graph in top down and depth first order. That means, it follows
		 * the direction of the edges and always expands the node i first, before a node i+1 will be expanded. This method
		 * is cyclesafe, therefore the variable currentNodePath is used.
		 * @param edge is the edge, via which the current node (last one in currentPath) was reached
		 * @param order number of current edge in list of all outgoing edges of the parent node
		 */
		private void topDownDepthFirstRec(	Edge edge,
											long order)
		{
			if (	(this.currentNodePath== null)||
					(this.currentNodePath.size()==0))
				throw new GraphTraverserException("Cannot traverse node starting at empty start node.");
			//current node is last element in currentPath
			Node currNode= this.currentNodePath.get(this.currentNodePath.size()-1);
			Node parent= null;
			if (this.currentNodePath.size()>1)
			{//if current path is larger then 1, than a parent node exists
				parent= this.currentNodePath.get(this.currentNodePath.size()-2);
			}//if current path is larger then 1, than a parent node exists
			traverseHandler.nodeReached(GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, traverseId, currNode, edge, parent, order);
			{//walk through all childs of this node
				EList<Edge> childEdges= this.getGraph().getOutEdges(currNode.getId());
				if (childEdges != null)
				{//in case of node has childs
					int i= 0;
					for(Edge childEdge: childEdges)
					{
						Node childNode= childEdge.getTarget();
						
						if (traverseHandler.checkConstraint(GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, traverseId, childEdge, childNode, order))
						{
							if (	(this.isCycleSafe)&&
									(this.currentNodePath.contains(childNode)))
							{
								
								StringBuffer text= new StringBuffer(); 
								for (Node node: this.currentNodePath)
								{
									text.append(node.getId());
									text.append(" --> ");
								}
								text.append(childNode.getId());
								
								throw new GraphTraverserException("A cycle in graph '"+graph.getId()+"' has been detected, while traversing with type '"+traverseType+"'. The cycle has been detected when visiting node '"+childNode+"' while current path was '"+ text.toString() +"'.");
							}
							
							this.currentNodePath.add(childNode);
							this.topDownDepthFirstRec(childEdge, i);
							this.currentNodePath.remove(this.currentNodePath.size()-1);
							
							i++;
						}
						//remove last entry, to update current path
					}//in case of node has childs
				}//walk through all childs of this node
			}
			
			traverseHandler.nodeLeft(GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, traverseId, currNode, edge, parent,  order);
		}
		
		/**
		 * A recursive method, which traverses through the graph in bottom-up and depth-first order. That means, it walk through
		 * the graph in opposite direction of the edges and always expands the node i first, before a node i+1 will be expanded. 
		 * This method is cycle-safe, therefore the variable currentNodePath is used.
		 * @param edge is the edge, via which the current node (last one in currentPath) was reached
		 * @param order number of current edge in list of all outgoing edges of the child node
		 */
		private void bottomUpDepthFirstRec(	Edge edge,
											long order)
		{
			if (	(this.currentNodePath== null)||
					(this.currentNodePath.size()==0))
				throw new GraphTraverserException("Cannot traverse node starting at empty start node.");
			//current node is last element in currentPath
			Node currNode= this.currentNodePath.get(this.currentNodePath.size()-1);
			Node child= null;
			if (this.currentNodePath.size()>1)
			{//if current path is larger then 1, than a parent node exists
				child= this.currentNodePath.get(this.currentNodePath.size()-1);
			}//if current path is larger then 1, than a parent node exists

			traverseHandler.nodeReached(GRAPH_TRAVERSE_TYPE.BOTTOM_UP_DEPTH_FIRST, traverseId, currNode, edge, child, order);
			
			{//walk through all childs of this node
				EList<Edge> parentEdges= this.getGraph().getInEdges(currNode.getId());
				if (parentEdges != null)
				{//in case of node has parents
					int i= 0;
					for(Edge parentEdge: parentEdges)
					{
						Node parentNode= parentEdge.getSource();
						if (	(this.isCycleSafe)&&
								(this.currentNodePath.contains(parentNode)))
							throw new GraphTraverserException("A cycle in graph '"+graph.getId()+"' has been detected, while traversing with type '"+traverseType+"'. The cycle has been detected when visiting node '"+parentNode+"' while current path was '"+ this.currentNodePath+"'.");
						
						this.currentNodePath.add(parentNode);
						if (traverseHandler.checkConstraint(GRAPH_TRAVERSE_TYPE.BOTTOM_UP_DEPTH_FIRST, traverseId, parentEdge, parentNode, order))
						{
							this.bottomUpDepthFirstRec(parentEdge, i);
							i++;
						}
						//remove last entry, to update current path
						this.currentNodePath.remove(this.currentNodePath.size()-1);
					}//in case of node has childs
				}//walk through all childs of this node
			}

			traverseHandler.nodeLeft(GRAPH_TRAVERSE_TYPE.BOTTOM_UP_DEPTH_FIRST, traverseId, currNode, edge, child,  order);
		}
	}
}
