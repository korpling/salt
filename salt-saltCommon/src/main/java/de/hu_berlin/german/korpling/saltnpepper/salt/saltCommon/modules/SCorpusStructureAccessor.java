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

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltModuleException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.modules.SGraphAccessorModule;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.TraversalObject;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.modules.GraphTraverser.GRAPH_TRAVERSE_MODE;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.modules.SCorpusStructureModule;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus;

/**
 * 
 * @author Florian Zipser
 * @deprecated since Salt 1.1.3
 */
@Deprecated
public class SCorpusStructureAccessor extends SCorpusStructureModule implements TraversalObject
{
	/**
	 * Returns all SCorpus-objects which are root corpora.
	 * @return root corpora
	 * @deprecated since Salt 1.1.3
	 */
	@Deprecated
	public EList<SCorpus> getSRootCorpora()
	{
		if (this.getSCorpusGraph()== null)
			throw new SaltModuleException("Cannot return root corpora, because no corpus graph is set. Please call setSCorpusGraph() first.");
		if (	(this.getSCorpusGraph().getSCorpora()== null)||
				(this.getSCorpusGraph().getSCorpora().size()== 0))
			return(null);
			
		EList<SCorpus> retVal= null;
		SGraphAccessorModule acc= new SGraphAccessorModule();
		acc.setSGraph(this.getSCorpusGraph());
		
		if (acc.getSRoots()!= null)
		{//if graph contains nodes 	
			for (SNode sNode: acc.getSRoots())
			{
				if (retVal== null)
					retVal= new BasicEList<SCorpus>();
				if (sNode instanceof SCorpus)
					retVal.add((SCorpus) sNode);
//				else
//					throw new SaltException("Cannot convert the SDocument-object '"+sNode.getSName()+"' into an SCorpus-object. This exception can be caused by a document which has no corpus as parent. ");
			}
		}
		return(retVal);
	}

	/**
	 * @deprecated since Salt 1.1.3
	 */
	@Override
	public boolean checkConstraint(GRAPH_TRAVERSE_MODE traversalMode,
			Long traversalId, Edge edge, Node currNode, long order) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @deprecated since Salt 1.1.3
	 */
	@Override
	public void nodeLeft(GRAPH_TRAVERSE_MODE traversalMode, Long traversalId,
			Node currNode, Edge edge, Node fromNode, long order) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @deprecated since Salt 1.1.3
	 */
	@Override
	public void nodeReached(GRAPH_TRAVERSE_MODE traversalMode,
			Long traversalId, Node currNode, Edge edge, Node fromNode,
			long order) {
		// TODO Auto-generated method stub
		
	}
}
