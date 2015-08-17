package de.hu_berlin.u.saltnpepper.salt.core.impl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.core.SGraph;
import de.hu_berlin.u.saltnpepper.salt.core.SNamedElement;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;

public class SGraphTest extends SAnnotationContainerTest {
	public SGraph getFixture() {
		return ((SGraph) super.getFixture());
	}

	@Before
	public void setUp() throws Exception {
		setFixture(SaltFactory.createSGraph());
	}

	/**
	 * Tests the methods {@link SNamedElement#getName()} and
	 * {@link SNamedElement#setName(String)}.
	 */
	@Test
	public void testGetName() {
		TestHelper.testGetName(getFixture());
	}

	/**
	 * Tests that the root nodes are returned correctly.
	 */
	@Test
	public void testGetRoots() {
		List<SNode> expectedRoots = null;
		List<SNode> roots = null;
		SGraph graph = null;

		// test 1
		graph = TestHelper.createGraph_Tree();
		setFixture(graph);
		expectedRoots = new ArrayList<>();
		expectedRoots.add(graph.getNode("node1"));
		roots = getFixture().getRoots();
		assertEquals("The expected number of roots are not the same, as the returned number", expectedRoots.size(), roots.size());
		for (SNode expectedRoot : expectedRoots) {
			assertTrue("The list of returned roots does not contain expected root '" + expectedRoot.getId() + "'.", roots.contains(expectedRoot));
		}

		// test 2
		graph = TestHelper.createGraph_DAG();
		setFixture(graph);
		expectedRoots = new ArrayList<>();
		expectedRoots.add(graph.getNode("node1"));
		expectedRoots.add(graph.getNode("node4"));
		roots = getFixture().getRoots();
		assertEquals("The expected number of roots are not the same, as the returned number", expectedRoots.size(), roots.size());
		for (SNode expectedRoot : expectedRoots) {
			assertTrue("The list of returned roots does not contain expected root '" + expectedRoot.getId() + "'.", roots.contains(expectedRoot));
		}

		// test 3
		graph = TestHelper.createGraph_Cycle();
		setFixture(graph);
		expectedRoots = new ArrayList<>();
		expectedRoots.add(graph.getNode("node1"));
		expectedRoots.add(graph.getNode("node4"));
		roots = getFixture().getRoots();
		assertEquals("The expected number of roots are not the same, as the returned number", expectedRoots.size(), roots.size());
		for (SNode expectedRoot : expectedRoots) {
			assertTrue("The list of returned roots does not contain expected root '" + expectedRoot.getId() + "'.", roots.contains(expectedRoot));
		}
	}

	/**
	 * Tests that the leaf nodes are returned correctly.
	 */
	@Test
	public void testGetLeafs() {
		List<SNode> expectedLeafs = null;
		List<SNode> leafs = null;
		SGraph graph = null;

		// test 1
		graph = TestHelper.createGraph_Tree();
		setFixture(graph);
		expectedLeafs = new ArrayList<>();
		expectedLeafs.add(graph.getNode("node3"));
		expectedLeafs.add(graph.getNode("node6"));
		expectedLeafs.add(graph.getNode("node5"));
		expectedLeafs.add(graph.getNode("node7"));
		leafs = getFixture().getLeafs();
		assertEquals("The expected number of leafs are not the same, as the returned number", expectedLeafs.size(), leafs.size());
		for (SNode expectedLeaf : expectedLeafs) {
			assertTrue("The list of returned roots does not contain expected leaf '" + expectedLeaf.getId() + "'.", leafs.contains(expectedLeaf));
		}

		// test 2
		graph = TestHelper.createGraph_DAG();
		setFixture(graph);
		expectedLeafs = new ArrayList<>();
		expectedLeafs.add(graph.getNode("node3"));
		expectedLeafs.add(graph.getNode("node6"));
		leafs = getFixture().getLeafs();
		assertEquals("The expected number of leafs are not the same, as the returned number", expectedLeafs.size(), leafs.size());
		for (SNode expectedLeaf : expectedLeafs) {
			assertTrue("The list of returned leafs does not contain expected leaf '" + expectedLeaf.getId() + "'.", leafs.contains(expectedLeaf));
		}

		// test 3
		graph = TestHelper.createGraph_Cycle();
		this.setFixture(graph);
		expectedLeafs = new ArrayList<>();
		expectedLeafs.add(graph.getNode("node3"));
		leafs = getFixture().getLeafs();
		assertEquals("The expected number of leafs are not the same, as the returned number", expectedLeafs.size(), leafs.size());
		for (SNode expectedLeaf : expectedLeafs) {
			assertTrue("The list of returned roots does not contain expected leaf '" + expectedLeaf.getId() + "'.", leafs.contains(expectedLeaf));
		}
	}
}
