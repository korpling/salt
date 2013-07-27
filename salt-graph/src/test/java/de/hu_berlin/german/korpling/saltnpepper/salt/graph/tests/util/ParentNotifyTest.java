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
