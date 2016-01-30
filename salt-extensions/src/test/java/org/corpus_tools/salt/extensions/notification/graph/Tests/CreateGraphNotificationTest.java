package org.corpus_tools.salt.extensions.notification.graph.Tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.extensions.notification.Listener;
import org.corpus_tools.salt.extensions.notification.SaltNotificationFactory;
import org.corpus_tools.salt.graph.GRAPH_ATTRIBUTES;
import org.corpus_tools.salt.samples.SampleGenerator;
import org.corpus_tools.salt.util.SaltUtil;
import org.junit.Before;
import org.junit.Test;

public class CreateGraphNotificationTest implements Listener {

	@Before
	public void setUp() throws Exception {
	}

	public class Event {
		NOTIFICATION_TYPE type;
		GRAPH_ATTRIBUTES attribute;
		Object oldValue;
		Object newValue;
		Object container;

		public Event(NOTIFICATION_TYPE type, GRAPH_ATTRIBUTES attribute, Object oldValue, Object newValue, Object container) {
			this.type = type;
			this.attribute = attribute;
			this.oldValue = oldValue;
			this.newValue = newValue;
			this.container = container;
		}
	}

	@Test
	public void test_createPrimaryData() {
		SaltNotificationFactory factory = new SaltNotificationFactory();
		SaltFactory.setFactory(factory);
		final List<Event> eventList = new ArrayList<>(2);
		eventList.add(new Event(NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_NAMESPACE, null, SaltUtil.SALT_NAMESPACE, null));
		eventList.add(new Event(NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_NAME, null, SaltUtil.FEAT_SDOCUMENT, null));
		eventList.add(new Event(NOTIFICATION_TYPE.ADD, GRAPH_ATTRIBUTES.GRAPH_LABELS, null, null, null));
		eventList.add(new Event(NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_VALUE, null, null, null));
		eventList.add(new Event(NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_NAMESPACE, null, SaltUtil.SALT_NAMESPACE, null));
		eventList.add(new Event(NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_NAME, null, SaltUtil.FEAT_SDOCUMENT_GRAPH, null));
		eventList.add(new Event(NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_VALUE, null, null, null));
		
		eventList.add(new Event(NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_NAMESPACE, null, SaltUtil.SALT_NAMESPACE, null));
		eventList.add(new Event(NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_NAME, null, SaltUtil.FEAT_SDATA, null));
		eventList.add(new Event(NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_VALUE, null, SampleGenerator.PRIMARY_TEXT_EN, null));
		eventList.add(new Event(NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_NAMESPACE, null, SaltUtil.SALT_NAMESPACE, null));
		eventList.add(new Event(NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_NAME, null, SaltUtil.FEAT_NAME, null));
		eventList.add(new Event(NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_VALUE, null, null, null));
		eventList.add(new Event(NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_VALUE, null, null, null));

		eventList.add(new Event(NOTIFICATION_TYPE.ADD, GRAPH_ATTRIBUTES.GRAPH_NODES, null, null, null));
		
		factory.addListener(new Listener() {
			private int eventCounter = 0;

			@Override
			public void notify(NOTIFICATION_TYPE type, GRAPH_ATTRIBUTES attribute, Object oldValue, Object newValue, Object container) {
				assertEquals("error at index "+ eventCounter, eventList.get(eventCounter).type, type);
				assertEquals("error at index "+ eventCounter, eventList.get(eventCounter).attribute, attribute);
				if (eventList.get(eventCounter).oldValue != null) {
					assertEquals("error at index "+ eventCounter, eventList.get(eventCounter).oldValue, oldValue);
				}
				if (eventList.get(eventCounter).newValue != null) {
					assertEquals("error at index "+ eventCounter, eventList.get(eventCounter).newValue, newValue);
				}
				eventCounter++;
			}
		});
		SDocument doc = SaltFactory.createSDocument();
		SampleGenerator.createPrimaryData(doc);

	}

//	@Test
//	public void test() {
//		SaltNotificationFactory factory = new SaltNotificationFactory();
//		SaltFactory.setFactory(new SaltNotificationFactory());
//		factory.addListener(this);
//		SDocument doc = SaltFactory.createSDocument();
//		SampleGenerator.createPrimaryData(doc);
//
//		System.out.println("all nodes: " + doc.getDocumentGraph().getNodes());
//		System.out.println("prim nodes: " + doc.getDocumentGraph().getTextualDSs());
//
//		System.out.println("first text: " + doc.getDocumentGraph().getTextualDSs().get(0));
//
//		SampleGenerator.createSyntaxStructure(doc);
//
//		System.out.println("Nodes: " + doc.getDocumentGraph().getNodes().size());
//		System.out.println("Text: " + doc.getDocumentGraph().getTextualDSs().size());
//		System.out.println("Token: " + doc.getDocumentGraph().getTokens().size());
//		System.out.println("Spans: " + doc.getDocumentGraph().getSpans().size());
//		System.out.println("Structures: " + doc.getDocumentGraph().getStructures().size());
//		System.out.println("Rels: " + doc.getDocumentGraph().getRelations().size());
//		System.out.println("text Rels: " + doc.getDocumentGraph().getTextualRelations().size());
//		System.out.println("dominance Rels: " + doc.getDocumentGraph().getDominanceRelations().size());
//
//		System.out.println("text: " + doc.getDocumentGraph().getNodes().get(0));
//
//		System.out.println("-----> Index: " + doc.getDocumentGraph().getIndexMgr());
//		System.out.println("graph opposite: " + doc.getDocumentGraph().getNodes().get(0).getGraph());
//	}

	@Override
	public void notify(NOTIFICATION_TYPE type, GRAPH_ATTRIBUTES attribute, Object oldValue, Object newValue, Object container) {
		System.out.println(type + ", " + attribute + ", " + oldValue + ", " + newValue + ", " + container);
	}

}
