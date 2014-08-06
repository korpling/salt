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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.modules;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.exceptions.SaltCoreModuleException;

/**
 * This class provides some accessor methods for a given SGraph-object. It makes it easier to get some data
 * just by one method.
 * 
 * @author Florian Zipser
 * @deprecated since Salt 1.1.3
 */
@Deprecated
public class SGraphAccessorModule 
{
	// ---------------- start: SGraph to work on
	private SGraph sGraph= null;
	/**
	 * Sets the SGraph-object to work on.
	 * @param sGraph SGraph-object to work on
	 */
	public void setSGraph(SGraph sGraph) {
		this.sGraph = sGraph;
	}

	/**
	 * Returns the SGraph-object to work on.
	 * @return SGraph-object to work on
	 */
	public SGraph getSGraph() {
		return sGraph;
	}
// ---------------- end: SGraph to work on
	
	/**
	 * Returns all root nodes as a list of SNode- objects of the settedt SGraphobject. A root
	 * node is a node without incoming edges. 
	 * @return a list of root nodes
	 */
	@Deprecated
	public EList<SNode> getSRoots()
	{
		EList<SNode> retVal= null;
		if (this.getSGraph()== null)
			throw new SaltCoreModuleException("Cannot return roots, because the SGraph-object to work on is not set.");
		for (SNode sNode: this.getSGraph().getSNodes())
		{
			EList<Edge> inEdges= this.getSGraph().getInEdges(sNode.getSId()); 
			if (	(inEdges== null) ||
					(inEdges.size()== 0))
			{	
				if (retVal== null)
					retVal= new BasicEList<SNode>();
				retVal.add(sNode);
			}
		}
		return(retVal);
	}
}
