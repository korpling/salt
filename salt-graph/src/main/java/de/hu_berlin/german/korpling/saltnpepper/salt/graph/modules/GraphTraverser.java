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

import java.util.Collections;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.osgi.service.log.LogService;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.exceptions.GraphModuleException;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.exceptions.GraphException;


/**
 * This class offers some methods to traverse a given graph.
 * @author Florian Zipser
 *
 */
public class GraphTraverser extends GraphModule
{
// ================================================ start: LogService	
	private LogService logService;

	public void setLogService(LogService logService) 
	{
		this.logService = logService;
	}
	
	public LogService getLogService() 
	{
		return(this.logService);
	}
	
	public void unsetLogService(LogService logService) {
		logService= null;
	}
// ================================================ end: LogService
	
	/**
	 * Some different supported modes to traverse the given graph.
	 * <ul>
	 * 	<li>DEPTH_FIRST, traverses through all targets of an edge.</li>
	 * 	<li>BOTTOM_UP, traverses through all sources of an edge.</li>
	 * </ul> 
	 * @author Florian Zipser
	 *
	 */
	public enum GRAPH_TRAVERSE_MODE {DEPTH_FIRST, BOTTOM_UP};
	
	/**
	 * Returns all root nodes, if exists. A root node is an node, 
	 * which has no ingoing edges.
	 */
	public EList<Node> getRoots() 
	{
		EList<Node> retList= null;
		retList= new BasicEList<Node>();
		if (this.getGraph().getNodes().size()==1)
		{//if corpusGraph only contains one corpus it shall not need to be traversed
			retList.add(this.getGraph().getNodes().get(0)); 
		}//if corpusGraph only contains one corpus it shall not need to be traversed
		else
		{	
			for (Node node: Collections.synchronizedCollection(this.getGraph().getNodes()))
			{
				//checking if node has ingoing edges
				EList<Edge> inEdges= this.getGraph().getInEdges(node.getId());
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
	 * Returns a new GraphTraverser Object. This Objects covers the real traversing and creates the call 
	 * back methods. Just call start() at the returne object. It also contains a unique id, to which the
	 * caller can refer to (interesting in multithreading). 
	 * @param tMode
	 * @param traversalObject
	 * @return
	 */
	public GraphTraverserObject getTraverserObject(	GRAPH_TRAVERSE_MODE tMode, 
													TraversalObject traversalObject)
	{
		if (this.getGraph()== null)
			throw new GraphModuleException("Cannot start traversing, because the graph is empty.");
		if (tMode== null)
			throw new GraphModuleException("Cannot start traversing, because the tMode is empty.");
		if (traversalObject== null)
			throw new GraphModuleException("Cannot start traversing, because the traversal object is empty.");
			
		GraphTraverserObject traverserObject= null;
		try {
			traverserObject= new GraphTraverserObject();
			traverserObject.setLogService(this.getLogService());
			traverserObject.setTMode(tMode);
			traverserObject.setGraph(this.getGraph());
			traverserObject.setTraversalObject(traversalObject);
		} catch (Exception e) 
		{
			throw new GraphException("Cannot create a GraphTraverserObject.", e);
		}
		return(traverserObject);
	}
}
