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

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;

public class GraphPrinter {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException 
	{
		String outputFileName= "_TMP/example_graph.graph";
		Graph graph= GraphFactory.eINSTANCE.createGraph();
		graph.setId("graph1");
		Label label= GraphFactory.eINSTANCE.createLabel();
		label.setName("hasValue");
		label.setValue("no");
		
		//layers
		Layer layer1= GraphFactory.eINSTANCE.createLayer();
		layer1.setId("layer1");
		graph.addLayer(layer1);
		label= GraphFactory.eINSTANCE.createLabel();
		label.setName("hasValue");
		label.setValue("no");
		
		Layer layer2= GraphFactory.eINSTANCE.createLayer();
		layer2.setId("layer2");
		graph.addLayer(layer2);
		layer2.setSuperLayer(layer1);
		
		//n1 
		Node n1= GraphFactory.eINSTANCE.createNode();
		n1.setId("n1");
		graph.addNode(n1);
		label= GraphFactory.eINSTANCE.createLabel();
		label.setName("color");
		label.setValue("red");
		n1.addLabel(label);
		
		//n2
		Node n2= GraphFactory.eINSTANCE.createNode();
		n2.setId("n2");
		graph.addNode(n2, layer1);
		label= GraphFactory.eINSTANCE.createLabel();
		label.setName("color");
		label.setValue("green");
		n2.addLabel(label);
		
		//n3
		Node n3= GraphFactory.eINSTANCE.createNode();
		n3.setId("n3");
		graph.addNode(n3, layer2);
		label= GraphFactory.eINSTANCE.createLabel();
		label.setName("color");
		label.setValue("red");
		n3.addLabel(label);
		
		//n4
		Node n4= GraphFactory.eINSTANCE.createNode();
		n4.setId("n4");
		graph.addNode(n4, layer2);
		label= GraphFactory.eINSTANCE.createLabel();
		label.setName("color");
		label.setValue("red");
		n4.addLabel(label);
		
		//e1 (n1->n2)
		Edge edge= GraphFactory.eINSTANCE.createEdge();
		edge.setId("e1");
		edge.setSource(n1);
		edge.setTarget(n2);
		graph.addEdge(edge);
		label= GraphFactory.eINSTANCE.createLabel();
		label.setName("costs");
		label.setValue("5");
		edge.addLabel(label);
		
		//e2 (n2->n3)
		edge= GraphFactory.eINSTANCE.createEdge();
		edge.setId("e2");
		edge.setSource(n2);
		edge.setTarget(n3);
		graph.addEdge(edge, layer1);
		
		//e3 (n2->n4)
		edge= GraphFactory.eINSTANCE.createEdge();
		edge.setId("e3");
		edge.setSource(n2);
		edge.setTarget(n4);
		graph.addEdge(edge, layer1);
		{
			ResourceSet resourceSet= new ResourceSetImpl();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("graph",new XMIResourceFactoryImpl());
			
			Resource resource = resourceSet.createResource(URI.createFileURI(outputFileName));
			resource.getContents().add(graph);
			resource.save(null);
		}
	}

}
