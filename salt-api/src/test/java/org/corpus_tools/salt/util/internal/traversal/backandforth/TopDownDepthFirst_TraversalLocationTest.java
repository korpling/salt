package org.corpus_tools.salt.util.internal.traversal.backandforth;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.graph.SampleGraphs;
import org.corpus_tools.salt.util.SaltUtil;
import org.corpus_tools.salt.util.traversal.BackAndForthTraverseHandler;
import org.corpus_tools.salt.util.traversal.TraversalLocation;
import org.corpus_tools.salt.util.traversal.TraversalStrategy;
import org.junit.Test;

public class TopDownDepthFirst_TraversalLocationTest {
	@Test
	public void whenGraphIsTree_TraversalLocaationMustMatchExpected() {
		// GIVEN
		SGraph graph = SampleGraphs.createTree();
		SNode n1 = graph.getNodeByName("n1").get();
		SNode n2 = graph.getNodeByName("n2").get();
		SNode n3 = graph.getNodeByName("n3").get();
		SNode n4 = graph.getNodeByName("n4").get();
		SNode n5 = graph.getNodeByName("n5").get();
		SNode n6 = graph.getNodeByName("n6").get();
		SNode n7 = graph.getNodeByName("n7").get();
		List<TraversalLocation> locationsForGoOn = new ArrayList<>();
		locationsForGoOn.add(TraversalLocation.createWithStrategy(TraversalStrategy.TOP_DOWN_DEPTH_FIRST)
				.withCurrentNode(n1)
				.withId("depth-first")
				.build());
		locationsForGoOn.add(TraversalLocation.createWithStrategy(TraversalStrategy.TOP_DOWN_DEPTH_FIRST)
				.withCurrentNode(n2)
				.withFromNode(n1)
				.withFromRelation(graph.getRelations(n1.getId(), n2.getId()).get(0))
				.withRelationOrder(1)
				.withId("depth-first")
				.build());
		locationsForGoOn.add(TraversalLocation.createWithStrategy(TraversalStrategy.TOP_DOWN_DEPTH_FIRST)
				.withCurrentNode(n3)
				.withFromNode(n2)
				.withFromRelation(graph.getRelations(n2.getId(), n3.getId()).get(0))
				.withRelationOrder(1)
				.withId("depth-first")
				.build());
		locationsForGoOn.add(TraversalLocation.createWithStrategy(TraversalStrategy.TOP_DOWN_DEPTH_FIRST)
				.withCurrentNode(n4)
				.withFromNode(n2)
				.withFromRelation(graph.getRelations(n2.getId(), n4.getId()).get(0))
				.withRelationOrder(2)
				.withId("depth-first")
				.build());
		locationsForGoOn.add(TraversalLocation.createWithStrategy(TraversalStrategy.TOP_DOWN_DEPTH_FIRST)
				.withCurrentNode(n5)
				.withFromNode(n1)
				.withFromRelation(graph.getRelations(n1.getId(), n5.getId()).get(0))
				.withRelationOrder(2)
				.withId("depth-first")
				.build());
		locationsForGoOn.add(TraversalLocation.createWithStrategy(TraversalStrategy.TOP_DOWN_DEPTH_FIRST)
				.withCurrentNode(n6)
				.withFromNode(n5)
				.withFromRelation(graph.getRelations(n5.getId(), n6.getId()).get(0))
				.withRelationOrder(1)
				.withId("depth-first")
				.build());
		locationsForGoOn.add(TraversalLocation.createWithStrategy(TraversalStrategy.TOP_DOWN_DEPTH_FIRST)
				.withCurrentNode(n7)
				.withFromNode(n1)
				.withFromRelation(graph.getRelations(n1.getId(), n7.getId()).get(0))
				.withRelationOrder(3)
				.withId("depth-first")
				.build());
		List<TraversalLocation> locationsOnWayForth = new ArrayList<>();
		locationsOnWayForth.add(TraversalLocation.createWithStrategy(TraversalStrategy.TOP_DOWN_DEPTH_FIRST)
				.withCurrentNode(n1)
				.withId("depth-first")
				.build());
		locationsOnWayForth.add(TraversalLocation.createWithStrategy(TraversalStrategy.TOP_DOWN_DEPTH_FIRST)
				.withCurrentNode(n2)
				.withFromNode(n1)
				.withFromRelation(graph.getRelations(n1.getId(), n2.getId()).get(0))
				.withRelationOrder(1)
				.withId("depth-first")
				.build());
		locationsOnWayForth.add(TraversalLocation.createWithStrategy(TraversalStrategy.TOP_DOWN_DEPTH_FIRST)
				.withCurrentNode(n3)
				.withFromNode(n2)
				.withFromRelation(graph.getRelations(n2.getId(), n3.getId()).get(0))
				.withRelationOrder(1)
				.withId("depth-first")
				.build());
		locationsOnWayForth.add(TraversalLocation.createWithStrategy(TraversalStrategy.TOP_DOWN_DEPTH_FIRST)
				.withCurrentNode(n4)
				.withFromNode(n2)
				.withFromRelation(graph.getRelations(n2.getId(), n4.getId()).get(0))
				.withRelationOrder(2)
				.withId("depth-first")
				.build());
		locationsOnWayForth.add(TraversalLocation.createWithStrategy(TraversalStrategy.TOP_DOWN_DEPTH_FIRST)
				.withCurrentNode(n5)
				.withFromNode(n1)
				.withFromRelation(graph.getRelations(n1.getId(), n5.getId()).get(0))
				.withRelationOrder(2)
				.withId("depth-first")
				.build());
		locationsOnWayForth.add(TraversalLocation.createWithStrategy(TraversalStrategy.TOP_DOWN_DEPTH_FIRST)
				.withCurrentNode(n6)
				.withFromNode(n5)
				.withFromRelation(graph.getRelations(n5.getId(), n6.getId()).get(0))
				.withRelationOrder(1)
				.withId("depth-first")
				.build());
		locationsOnWayForth.add(TraversalLocation.createWithStrategy(TraversalStrategy.TOP_DOWN_DEPTH_FIRST)
				.withCurrentNode(n7)
				.withFromNode(n1)
				.withFromRelation(graph.getRelations(n1.getId(), n7.getId()).get(0))
				.withRelationOrder(3)
				.withId("depth-first")
				.build());
		List<TraversalLocation> locationsOnWayBack = new ArrayList<>();
		locationsOnWayBack.add(TraversalLocation.createWithStrategy(TraversalStrategy.TOP_DOWN_DEPTH_FIRST)
				.withCurrentNode(n3)
				.withFromNode(n2)
				.withFromRelation(graph.getRelations(n2.getId(), n3.getId()).get(0))
				.withRelationOrder(1)
				.withId("depth-first")
				.build());
		locationsOnWayBack.add(TraversalLocation.createWithStrategy(TraversalStrategy.TOP_DOWN_DEPTH_FIRST)
				.withCurrentNode(n4)
				.withFromNode(n2)
				.withFromRelation(graph.getRelations(n2.getId(), n4.getId()).get(0))
				.withRelationOrder(2)
				.withId("depth-first")
				.build());
		locationsOnWayBack.add(TraversalLocation.createWithStrategy(TraversalStrategy.TOP_DOWN_DEPTH_FIRST)
				.withCurrentNode(n2)
				.withFromNode(n1)
				.withFromRelation(graph.getRelations(n1.getId(), n2.getId()).get(0))
				.withRelationOrder(1)
				.withId("depth-first")
				.build());
		locationsOnWayBack.add(TraversalLocation.createWithStrategy(TraversalStrategy.TOP_DOWN_DEPTH_FIRST)
				.withCurrentNode(n6)
				.withFromNode(n5)
				.withFromRelation(graph.getRelations(n5.getId(), n6.getId()).get(0))
				.withRelationOrder(1)
				.withId("depth-first")
				.build());
		locationsOnWayBack.add(TraversalLocation.createWithStrategy(TraversalStrategy.TOP_DOWN_DEPTH_FIRST)
				.withCurrentNode(n5)
				.withFromNode(n1)
				.withFromRelation(graph.getRelations(n1.getId(), n5.getId()).get(0))
				.withRelationOrder(2)
				.withId("depth-first")
				.build());
		locationsOnWayBack.add(TraversalLocation.createWithStrategy(TraversalStrategy.TOP_DOWN_DEPTH_FIRST)
				.withCurrentNode(n7)
				.withFromNode(n1)
				.withFromRelation(graph.getRelations(n1.getId(), n7.getId()).get(0))
				.withRelationOrder(3)
				.withId("depth-first")
				.build());
		locationsOnWayBack.add(TraversalLocation.createWithStrategy(TraversalStrategy.TOP_DOWN_DEPTH_FIRST)
				.withCurrentNode(n1)
				.withId("depth-first")
				.build());
		// WHEN AND THEN
		SaltUtil.traverse(graph)
				.startFrom(graph.getRoots())
				.useStrategy(TraversalStrategy.TOP_DOWN_DEPTH_FIRST)
				.cycleSafe(false)
				.useId("depth-first")
				.andCall(new BackAndForthTraverseHandler() {
					private int wayForthCounter = 0;
					private int wayBackCounter = 0;
					private int shouldGoOnCounter = 0;

					@Override
					public boolean shouldTraversalGoOn(TraversalLocation location) {
						assertThat(shouldGoOnCounter).isLessThan(locationsForGoOn.size());
						assertThat(location).isEqualTo(locationsForGoOn.get(shouldGoOnCounter));
						shouldGoOnCounter++;
						return true;
					}

					@Override
					public void nodeReachedOnWayForth(TraversalLocation location) {
						assertThat(wayForthCounter).isLessThan(locationsOnWayForth.size());
						assertThat(location).isEqualTo(locationsOnWayForth.get(wayForthCounter));
						wayForthCounter++;
					}

					@Override
					public void nodeReachedOnWayBack(TraversalLocation location) {
						assertThat(wayBackCounter).isLessThan(locationsOnWayBack.size());
						assertThat(location).isEqualTo(locationsOnWayBack.get(wayBackCounter));
						wayBackCounter++;
					}
				});
	}
}
