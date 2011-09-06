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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.modules;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Stack;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.GraphTraverser;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.GraphTraverser.GRAPH_TRAVERSE_MODE;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.GraphTraverserObject;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.TraversalObject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;

/**
 * This class checks if the given {@link SDocumentGraph} is valide against a set of constraints. For instance you
 * can check, if this graph contains a {@link STextualDS} and if all nodes are directly or indirectly connected with it.
 * A list of checkable constraints is given here:
 * <ul>
 * 	<li>HAS_STEXTUALDS - checks if this graph has a {@link STextualDS} object</li>
 * 	<li>CONNECTED_TO_STEXTUALDS - checks if each {@link SNode} ({@link SStructure}, {@link SSpan} or {@link SToken}) is indirectly or directly (in case of {@link SToken}) is connected to the {@link STextualDS} object</li>
 * 	<li>VALID_SRELATIONS - checks if all edges have a source and a target as well</li>
 * </ul>
 * @author Florian Zipser
 *
 */
public class SDocumentValidator extends SAccessorModule implements TraversalObject
{
	/**
	 * Checks if all edges have a source and a target as well.
	 * @return a list of messages with errors to edges, which are not valide
	 */
	public EList<String> validSRelations()
	{
		
		if (this.getSDocument()== null)
			throw new SaltException("Cannot validate relations, because no SDocument object is given.");
		if (this.getSDocument().getSDocumentGraph()== null)
			throw new SaltException("Cannot validate relations, because given SDocument object does not contain a SDocumentGraph object is given.");
		EList<String> msgs= new BasicEList<String>();
		
		if (	(this.getSDocument().getSDocumentGraph().getSRelations()!= null)&&
				(this.getSDocument().getSDocumentGraph().getSRelations().size()>0))
		{
			for (SRelation sRelation: this.getSDocument().getSDocumentGraph().getSRelations())
			{
				if (sRelation.getSSource()== null)
				{
					msgs.add("The SRelation-object '"+sRelation.getSId()+"' does not have a source.");
				}
				if (sRelation.getSTarget()== null)
				{
					msgs.add("The SRelation-object '"+sRelation.getSId()+"' does not have a target.");
				}
			}
		}
		if (msgs.size()>0)
			return(msgs);
		else return(null);
	}
	
	public class Message
	{
		public Message(SElementId sElementId, String message)
		{
			this.sElementId= sElementId;
			this.message= message;
		}
		
		private SElementId sElementId= null;
		/**
		 * Sets the {@link SElementId} of the object invoking the problem.
		 * @param sElementId
		 */
		public void setsElementId(SElementId sElementId) {
			this.sElementId = sElementId;
		}
		/**
		 * Returns the {@link SElementId} of the object invoking the problem.
		 * @return
		 */
		public SElementId getsElementId() {
			return sElementId;
		}
		
		private String message= null;
		/**
		 * Sets the textual message describing the problem. 
		 * @param message
		 */
		public void setMessage(String message) {
			this.message = message;
		}
		/**
		 * Returns the textual message describing the problem.
		 * @return
		 */
		public String getMessage() {
			return message;
		}
		
		public String toString()
		{
			return(this.getsElementId().getSId()+": "+ this.getMessage());
		}
	}
	
	/**
	 * Checks if each {@link SNode} ({@link SStructure}, {@link SSpan} or {@link SToken}) is indirectly or directly (in case of {@link SToken}) is connected to the {@link STextualDS} object
	 * Internal:<br/>
	 * <ul>
	 * 	<li>traverses nodes beginning from all roots</li>
	 * 	<li>remembers the seen node in current path starting from root</li>
	 * 	<li>also remembers all seen nodes, when a node has already been seen, it will not be traversed any further</li>	
	 * 	<li>when a STextualDS is found, all nodes in current path are marked as ok</li>
	 *  <li>at the end, when the list of nodes being ok has the same size as the set of all SStructure-, SSpan and SToken nodes, all nodes are connected to the STextualDS node</li>  
	 * </ul>
	 * @return
	 */
	public EList<Message> connectedToSTextualDS()
	{
		EList<Message> msgs= new BasicEList<Message>();
		this.seenSNodes= new HashSet<SNode>();
		this.currentPath= new Stack<SNode>();
		this.valideSNodes= new HashSet<SNode>();
		
		GraphTraverser traverser= new GraphTraverser();
		traverser.setGraph(this.getSDocument().getSDocumentGraph());
		EList<Node> roots = traverser.getRoots();
		for (int idx=0; idx<roots.size(); idx++) 
		{
			GraphTraverserObject traverserObj= traverser.getTraverserObject(GRAPH_TRAVERSE_MODE.DEPTH_FIRST, this);
			traverserObj.start(roots.get(idx));
			traverserObj.waitUntilFinished();			
		}
		int numOfAllSNodes= this.getSDocument().getSDocumentGraph().getSStructures().size()+ this.getSDocument().getSDocumentGraph().getSSpans().size()+ this.getSDocument().getSDocumentGraph().getSTokens().size(); 
		if (this.valideSNodes.size() != numOfAllSNodes)
		{
			for (SStructure sNode: this.getSDocument().getSDocumentGraph().getSStructures())
			{
				if (!this.valideSNodes.contains(sNode))
					msgs.add(new Message(sNode.getSElementId(), "The "+SStructure.class.getSimpleName()+" node '"+sNode.getSId()+"' is not connected to the STextualDS node."));
			}
			for (SSpan sNode: this.getSDocument().getSDocumentGraph().getSSpans())
			{
				if (!this.valideSNodes.contains(sNode))
					msgs.add(new Message(sNode.getSElementId(), "The "+SSpan.class.getSimpleName()+" node '"+sNode.getSId()+"' is not connected to the STextualDS node."));
			}
			for (SToken sNode: this.getSDocument().getSDocumentGraph().getSTokens())
			{
				if (!this.valideSNodes.contains(sNode))
					msgs.add(new Message(sNode.getSElementId(), "The "+SToken.class.getSimpleName()+" node '"+sNode.getSId()+"' is not connected to the STextualDS node."));
			}
			return(msgs);
		}
		else return(null);
	}

	/**
	 * Stores all {@link SNode} objects, which has already been seen while traversal. 
	 */
	protected HashSet<SNode> seenSNodes= null;
	
	/**
	 * Stores the current traversed path from any node to STextualDS.
	 */
	protected Stack<SNode> currentPath= null;
	
	/**
	 * The list of SNode objects being connected to STextualDS 
	 */
	protected HashSet<SNode> valideSNodes= null;
	
	/**
	 * Fills the set of seen nodes. 
	 */
	@Override
	public void nodeReached(	GRAPH_TRAVERSE_MODE traversalMode,
								Long traversalId, 
								Node currNode, 
								Edge edge, 
								Node fromNode,
								long order) 
	{
		if (currNode instanceof SNode)
		{
			SNode currSNode= (SNode) currNode;
			this.seenSNodes.add(currSNode);
			this.currentPath.push(currSNode);
		}
	}

	@Override
	public void nodeLeft(GRAPH_TRAVERSE_MODE traversalMode, Long traversalId,
			Node currNode, Edge edge, Node fromNode, long order) 
	{
		if (currNode instanceof SNode)
		{
			this.currentPath.pop();
		}
	}

	/**
	 * If a node is contained in seen nodes, the method returns false.
	 */
	@Override
	public boolean checkConstraint(	GRAPH_TRAVERSE_MODE traversalMode,
									Long traversalId, 
									Edge edge, 
									Node currNode, 
									long order) 
	{
		
		Boolean retVal= false;
		if (currNode instanceof SNode)
		{
			SNode currSNode= (SNode) currNode;
			
			if (this.seenSNodes.contains(currSNode))
			{
				retVal= false;
				{//copy current path to list of valide nodes, if current node is valide
					if (valideSNodes.contains(currSNode))
					{
						Enumeration<SNode> pathSNodes= this.currentPath.elements();
						while (pathSNodes.hasMoreElements())
						{
							SNode sNode= pathSNodes.nextElement();
							this.valideSNodes.add(sNode);
						}
						retVal= false;
					}
				}//copy current path to list of valide nodes, if current node is valide
			}
			else
			{
				if (	(currSNode instanceof SStructure)||
						(currSNode instanceof SSpan)||
						(currSNode instanceof SToken))
				{
					
					retVal= true;
				}
				else if (currSNode instanceof STextualDS)
				{
					Enumeration<SNode> pathSNodes= this.currentPath.elements();
					while (pathSNodes.hasMoreElements())
						this.valideSNodes.add(pathSNodes.nextElement());
					retVal= false;
				}
			}
		}
		return(retVal);
	}
}
