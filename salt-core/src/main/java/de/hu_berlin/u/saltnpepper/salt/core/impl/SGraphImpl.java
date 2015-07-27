package de.hu_berlin.u.saltnpepper.salt.core.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.hu_berlin.u.saltnpepper.graph.impl.GraphImpl;
import de.hu_berlin.u.saltnpepper.salt.core.GraphTraverseHandler;
import de.hu_berlin.u.saltnpepper.salt.core.SGraph;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;

@SuppressWarnings("serial")
public class SGraphImpl extends GraphImpl<SNode, SRelation<SNode, SNode>> implements SGraph {

	/** {@inheritDoc} */
	@Override
	public List<SNode> getRoots() {
		List<SNode> retList = new ArrayList<>();
		if (this.getNodes().size() == 1) {
			// if corpusGraph only contains one corpus it shall not need to be
			// traversed
			retList.add(this.getNodes().get(0));
		} else {
			for (SNode node : Collections.synchronizedCollection(this.getNodes())) {
				// checking if node has incoming edges
				List<SRelation<SNode, SNode>> inEdges = getInRelations(node.getId());
				if ((inEdges == null) || (inEdges.size() == 0)) {
					retList.add(node);
				}
			}
		}
		if (retList.size() == 0)
			retList = null;
		return (retList);
	}

	/** {@inheritDoc} */
	@Override
	public List<SNode> getLeafs() {
		List<SNode> retList = new ArrayList<>();
		if (this.getNodes().size() == 1) {
			// if corpusGraph only contains one corpus it shall not need to
			// be traversed
			retList.add(this.getNodes().get(0));
		} else {
			for (SNode node : Collections.synchronizedCollection(this.getNodes())) {
				// checking if node has outgoing edges
				List<SRelation<SNode, SNode>> outEdges = getOutRelations(node.getId());
				if ((outEdges == null) || (outEdges.size() == 0)) {
					retList.add(node);
				}
			}
		}
		if (retList.size() == 0)
			retList = null;
		return (retList);
	}

	/** {@inheritDoc} */
	@Override
	public void traverse(List<SNode> startNodes, GRAPH_TRAVERSE_TYPE traverseType, String traverseId, GraphTraverseHandler traverseHandler) {
		this.traverse(startNodes, traverseType, traverseId, traverseHandler, true);
	}

	/** {@inheritDoc} */
	@Override
	public void traverse(List<SNode> startNodes, GRAPH_TRAVERSE_TYPE traverseType, String traverseId, GraphTraverseHandler traverseHandler, boolean isCycleSafe) {
		GraphTraverserModule traverserModule = new GraphTraverserModule();
		traverserModule.setGraph(this);
		traverserModule.traverse(startNodes, traverseType, traverseId, traverseHandler, isCycleSafe);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}
}
