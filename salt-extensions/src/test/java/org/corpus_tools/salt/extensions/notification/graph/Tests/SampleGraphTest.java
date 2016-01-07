package org.corpus_tools.salt.extensions.notification.graph.Tests;

import static org.junit.Assert.*;

import org.corpus_tools.salt.extensions.notification.Listener;
import org.corpus_tools.salt.extensions.notification.SaltNotificationFactory;
import org.junit.Before;
import org.junit.Test;

import org.corpus_tools.salt.graph.GRAPH_ATTRIBUTES;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.samples.SampleGenerator;

public class SampleGraphTest implements Listener {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		SaltNotificationFactory factory= new SaltNotificationFactory();
		SaltFactory.setFactory(new SaltNotificationFactory());
		factory.addListener(this);
		SDocument doc= SaltFactory.createSDocument();
		SampleGenerator.createPrimaryData(doc);
		
		System.out.println("all nodes: "+ doc.getDocumentGraph().getNodes());
		System.out.println("prim nodes: "+ doc.getDocumentGraph().getTextualDSs());
		System.out.println("graph opposite: "+ doc.getDocumentGraph().getNodes().get(0).getGraph());
		
		System.out.println("first text: "+ doc.getDocumentGraph().getTextualDSs().get(0));
		
		
		SampleGenerator.createSyntaxStructure(doc);		
	}

	@Override
	public void notify(NOTIFICATION_TYPE type, GRAPH_ATTRIBUTES attribute, Object oldValue, Object newValue, Object container) {
		System.out.println(type + ", " + attribute + ", " + oldValue + ", " + newValue + ", " + container);
	}

}
