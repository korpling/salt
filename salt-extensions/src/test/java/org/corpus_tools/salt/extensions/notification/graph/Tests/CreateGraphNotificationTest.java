/**
 * Copyright 2009 Humboldt-Universität zu Berlin
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
package org.corpus_tools.salt.extensions.notification.graph.Tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.extensions.notification.Listener;
import org.corpus_tools.salt.extensions.notification.Listener.NOTIFICATION_TYPE;
import org.corpus_tools.salt.extensions.notification.SaltNotificationFactory;
import org.corpus_tools.salt.graph.GRAPH_ATTRIBUTES;
import org.corpus_tools.salt.samples.SampleGenerator;
import org.corpus_tools.salt.util.SaltUtil;
import org.junit.Before;
import org.junit.Test;

public class CreateGraphNotificationTest {

	@Before
	public void setUp() throws Exception {
	}

	public static class TestEvent {
		NOTIFICATION_TYPE type;
		GRAPH_ATTRIBUTES attribute;
		Object oldValue;
		Object newValue;
		Object container;

		public TestEvent(NOTIFICATION_TYPE type, GRAPH_ATTRIBUTES attribute, Object oldValue, Object newValue,
				Object container) {
			this.type = type;
			this.attribute = attribute;
			this.oldValue = oldValue;
			this.newValue = newValue;
			this.container = container;
		}

		@Override
		public String toString() {
			return "Event [type=" + type + ", attribute=" + attribute + ", oldValue=" + oldValue + ", newValue="
					+ newValue + ", container=" + container + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((attribute == null) ? 0 : attribute.hashCode());
			result = prime * result + ((container == null) ? 0 : container.hashCode());
			result = prime * result + ((newValue == null) ? 0 : newValue.hashCode());
			result = prime * result + ((oldValue == null) ? 0 : oldValue.hashCode());
			result = prime * result + ((type == null) ? 0 : type.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			TestEvent other = (TestEvent) obj;
			if (attribute != other.attribute)
				return false;
			if (container == null) {
				if (other.container != null)
					return false;
			} else if (!container.equals(other.container))
				return false;
			if (newValue == null) {
				if (other.newValue != null)
					return false;
			} else if (!newValue.equals(other.newValue))
				return false;
			if (oldValue == null) {
				if (other.oldValue != null)
					return false;
			} else if (!oldValue.equals(other.oldValue))
				return false;
			if (type != other.type)
				return false;
			return true;
		}

	}

	@Test
	public void test_createPrimaryData() {
		SaltNotificationFactory factory = new SaltNotificationFactory();
		SaltFactory.setFactory(factory);
		final List<TestEvent> eventList = new ArrayList<>();

		eventList.add(new TestEvent(NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_NAMESPACE, null,
				SaltUtil.SALT_NAMESPACE, null));
		eventList.add(
				new TestEvent(NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_NAME, null, SaltUtil.FEAT_SDOCUMENT, null));
		eventList.add(new TestEvent(NOTIFICATION_TYPE.ADD, GRAPH_ATTRIBUTES.GRAPH_LABELS, null, null, null));
		eventList.add(new TestEvent(NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_VALUE, null, null, null));
		eventList.add(new TestEvent(NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_NAMESPACE, null,
				SaltUtil.SALT_NAMESPACE, null));
		eventList.add(new TestEvent(NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_NAME, null,
				SaltUtil.FEAT_SDOCUMENT_GRAPH, null));
		eventList.add(new TestEvent(NOTIFICATION_TYPE.ADD, GRAPH_ATTRIBUTES.NODE_LABELS, null, null, null));
		eventList.add(new TestEvent(NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_VALUE, null, null, null));

		eventList.add(new TestEvent(NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_NAMESPACE, null,
				SaltUtil.SALT_NAMESPACE, null));
		eventList.add(
				new TestEvent(NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_NAME, null, SaltUtil.FEAT_SDATA, null));
		eventList.add(new TestEvent(NOTIFICATION_TYPE.ADD, GRAPH_ATTRIBUTES.NODE_LABELS, null, null, null));
		eventList.add(new TestEvent(NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_VALUE, null,
				SampleGenerator.PRIMARY_TEXT_EN, null));
		eventList.add(new TestEvent(NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_NAMESPACE, null,
				SaltUtil.SALT_NAMESPACE, null));
		eventList
				.add(new TestEvent(NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_NAME, null, SaltUtil.FEAT_NAME, null));
		eventList.add(new TestEvent(NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_VALUE, null, null, null));
		eventList.add(new TestEvent(NOTIFICATION_TYPE.ADD, GRAPH_ATTRIBUTES.NODE_LABELS, null, null, null));
		eventList.add(new TestEvent(NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.LABEL_VALUE, null, null, null));
		eventList.add(new TestEvent(NOTIFICATION_TYPE.ADD, GRAPH_ATTRIBUTES.NODE_LABELS, null, null, null));
		eventList.add(new TestEvent(NOTIFICATION_TYPE.ADD, GRAPH_ATTRIBUTES.GRAPH_NODES, null, null, null));

		final List<TestEvent> actualEvents = new ArrayList<>();
		factory.addListener(new Listener() {

			@Override
			public void notify(NOTIFICATION_TYPE type, GRAPH_ATTRIBUTES attribute, Object oldValue, Object newValue,
					Object container) {
				actualEvents.add(new TestEvent(type, attribute, oldValue, newValue, container));
			}
		});
		SDocument doc = SaltFactory.createSDocument();
		SampleGenerator.createPrimaryData(doc);

		assertEquals(eventList.size(), actualEvents.size());
		for (int i = 0; i < eventList.size(); i++) {
			assertEquals("error at index " + i, eventList.get(i).type, actualEvents.get(i).type);
			assertEquals("error at index " + i, eventList.get(i).attribute, actualEvents.get(i).attribute);
			if (eventList.get(i).oldValue != null) {
				assertEquals("error at index " + i, eventList.get(i).oldValue, actualEvents.get(i).oldValue);
			}
			if (eventList.get(i).newValue != null) {
				assertEquals("error at index " + i, eventList.get(i).newValue, actualEvents.get(i).newValue);
			}
		}
	}
}
