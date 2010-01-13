package de.hub.corpling.salt.saltCommon.modules;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.hub.corpling.graph.Edge;
import de.hub.corpling.graph.Node;
import de.hub.corpling.graph.modules.TraversalObject;
import de.hub.corpling.graph.modules.GraphTraverser.GRAPH_TRAVERSE_MODE;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hub.corpling.salt.saltCore.SNode;
import de.hub.corpling.salt.saltCore.modules.SGraphAccessorModule;
import de.hub.corpling.salt.saltExceptions.SaltModuleException;

public class SCorpusStructureAccessor extends SCorpusStructureModule implements TraversalObject
{
	/**
	 * Returns all SCorpus-objects which are root corpora.
	 * @return root corpora
	 */
	public EList<SCorpus> getSRootCorpora()
	{
		if (this.getSCorpusGraph()== null)
			throw new SaltModuleException("Cannot return root corpora, because no corpus graph is set. Please call setSCorpusGraph() first.");
		EList<SCorpus> retVal= null;
		SGraphAccessorModule acc= new SGraphAccessorModule();
		acc.setSGraph(this.getSCorpusGraph());
		
		for (SNode sNode: acc.getSRoots())
		{
			if (retVal== null)
				retVal= new BasicEList<SCorpus>();
			retVal.add((SCorpus) sNode);
		}
		return(retVal);
	}

	@Override
	public boolean checkConstraint(GRAPH_TRAVERSE_MODE traversalMode,
			Long traversalId, Edge edge, Node currNode, long order) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void nodeLeft(GRAPH_TRAVERSE_MODE traversalMode, Long traversalId,
			Node currNode, Edge edge, Node fromNode, long order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nodeReached(GRAPH_TRAVERSE_MODE traversalMode,
			Long traversalId, Node currNode, Edge edge, Node fromNode,
			long order) {
		// TODO Auto-generated method stub
		
	}
}
