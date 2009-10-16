package de.hub.corpling.salt.saltCore.modules;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.hub.corpling.graph.Edge;
import de.hub.corpling.salt.saltCore.SGraph;
import de.hub.corpling.salt.saltCore.SNode;

/**
 * This class provides some accessor methods for a given SGraph-object. It makes it easier to get some data
 * just by one method.
 * 
 * @author Florian Zipser
 *
 */
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
	public EList<SNode> getSRoots()
	{
		EList<SNode> retVal= null;
		if (this.getSGraph()== null)
			throw new SaltModuleException("Cannot return roots, because the SGraph-object to work on isn´t set.");
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
