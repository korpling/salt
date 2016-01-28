package org.corpus_tools.salt.extensions.notification.graph.Tests;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.extensions.notification.Listener;
import org.corpus_tools.salt.extensions.notification.SaltNotificationFactory;
import org.corpus_tools.salt.graph.GRAPH_ATTRIBUTES;
import org.corpus_tools.salt.samples.SampleGenerator;
import org.junit.Before;
import org.junit.Test;

public class SampleGraphTest implements Listener {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		SaltNotificationFactory factory = new SaltNotificationFactory();
		SaltFactory.setFactory(new SaltNotificationFactory());
		factory.addListener(this);
		SDocument doc = SaltFactory.createSDocument();
		SampleGenerator.createPrimaryData(doc);

		System.out.println("all nodes: " + doc.getDocumentGraph().getNodes());
		System.out.println("prim nodes: " + doc.getDocumentGraph().getTextualDSs());

		System.out.println("first text: " + doc.getDocumentGraph().getTextualDSs().get(0));

		SampleGenerator.createSyntaxStructure(doc);
		
		System.out.println("Nodes: "+ doc.getDocumentGraph().getNodes().size());
		System.out.println("Text: "+ doc.getDocumentGraph().getTextualDSs().size());
		System.out.println("Token: "+ doc.getDocumentGraph().getTokens().size());
		System.out.println("Spans: "+ doc.getDocumentGraph().getSpans().size());
		System.out.println("Structures: "+ doc.getDocumentGraph().getStructures().size());
		System.out.println("Rels: "+ doc.getDocumentGraph().getRelations().size());
		System.out.println("text Rels: "+ doc.getDocumentGraph().getTextualRelations().size());
		System.out.println("dominance Rels: "+ doc.getDocumentGraph().getDominanceRelations().size());
		
		System.out.println("text: " + doc.getDocumentGraph().getNodes().get(0));
		
		System.out.println("-----> Index: "+ doc.getDocumentGraph().getIndexMgr());
		System.out.println("graph opposite: " + doc.getDocumentGraph().getNodes().get(0).getGraph());
	}

	@Override
	public void notify(NOTIFICATION_TYPE type, GRAPH_ATTRIBUTES attribute, Object oldValue, Object newValue, Object container) {
		System.out.println(type + ", " + attribute + ", " + oldValue + ", " + newValue + ", " + container);
	}

}
