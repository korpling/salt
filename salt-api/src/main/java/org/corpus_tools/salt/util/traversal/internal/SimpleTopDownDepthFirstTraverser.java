package org.corpus_tools.salt.util.traversal.internal;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.exceptions.SaltInvalidModelException;
import org.corpus_tools.salt.util.traversal.SimpleTraverseHandler;
import org.corpus_tools.salt.util.traversal.TraversalFilter;
import org.corpus_tools.salt.util.traversal.TraversalLocation;
import org.corpus_tools.salt.util.traversal.TraversalStrategy;

public class SimpleTopDownDepthFirstTraverser extends SimpleTraverser {

	public SimpleTopDownDepthFirstTraverser(List<? extends SNode> startNodes, TraversalStrategy strategy, String id,
			SimpleTraverseHandler handler, boolean isCycleSafe, SGraph graph, Collection<TraversalFilter> filters) {
		super(startNodes, strategy, id, handler, isCycleSafe, graph, filters);
	}

	@Override
	public void traverse() {
		startNodes.stream().forEach(this::traverseNode);
	}

	public void traverseNode(SNode startNode) {
		final Set<SNode> visitedNodes = new LinkedHashSet<>();
		List<TraversalLocation> nodesToVisit = new LinkedList<>();
		nodesToVisit.add(TraversalLocation.createWithStrategy(strategy).withCurrentNode(startNode).build());
		while (!nodesToVisit.isEmpty()) {
			TraversalLocation currentLocation = nodesToVisit.get(0);
			nodesToVisit.remove(0);
			if (!filter(currentLocation)) {
				continue;
			}
			if (isCycleSafe) {
				whenGraphContainsCycleThrowExcpetion(currentLocation.getCurrentNode(), visitedNodes);
				visitedNodes.add(currentLocation.getCurrentNode());
			}
			handler.nodeReached(currentLocation);
			List<SRelation<? extends SNode, ? extends SNode>> outrelations = graph
					.getOutRelations(currentLocation.getCurrentNode().getId());
			List<TraversalLocation> locations = outrelations.stream()
					.map(relation -> TraversalLocation.createWithStrategy(strategy)
							.withCurrentNode(relation.getTarget())
							.withFromNode(relation.getSource())
							.withFromRelation(relation)
							.withRelationOrder(outrelations.indexOf(relation))
							.withId(id)
							.build())
					.collect(Collectors.toList());
			nodesToVisit.addAll(0, locations);
		}
	}

	private void whenGraphContainsCycleThrowExcpetion(SNode currentNode, Set<SNode> visitedNodes) {
		if (visitedNodes.contains(currentNode)) {
			StringJoiner joiner = new StringJoiner(" -> ");
			visitedNodes.stream().map(SNode::getId).forEach(joiner::add);
			joiner.add(currentNode.getId());
			throw new SaltInvalidModelException(
					"A cycle in graph '" + graph.getId() + "' has been detected, while traversing with type '"
							+ strategy + "'. The cycle has been detected when visiting node '" + currentNode
							+ "' while current path was '" + joiner.toString() + "'.");
		}
	}
}
