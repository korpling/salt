package de.hu_berlin.german.korpling.saltnpepper.salt.graph.tests.util;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;
import junit.framework.TestCase;

public class ParentNotifyTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testNotification()
	{
		Graph graph= GraphFactory.eINSTANCE.createGraph();
		Node node= GraphFactory.eINSTANCE.createNode();
		graph.addNode(node);
		Label label= GraphFactory.eINSTANCE.createLabel();
		label.setName("anyName");
		node.addLabel(label);
		label.setValue("anyValue");
	}
}
