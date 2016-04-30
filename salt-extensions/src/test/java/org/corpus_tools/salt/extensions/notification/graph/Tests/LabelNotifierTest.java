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

import org.corpus_tools.salt.extensions.notification.Listener.NOTIFICATION_TYPE;
import org.corpus_tools.salt.extensions.notification.SaltNotificationFactory;
import org.corpus_tools.salt.extensions.notification.graph.Tests.Helper.MyListener;
import org.corpus_tools.salt.extensions.notification.graph.impl.LabelNotifierImpl;
import org.corpus_tools.salt.graph.GRAPH_ATTRIBUTES;
import org.corpus_tools.salt.graph.Label;
import org.corpus_tools.salt.graph.impl.tests.LabelTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LabelNotifierTest extends LabelTest {

	private LabelNotifierImpl fixture = null;

	public LabelNotifierImpl getFixture() {
		return fixture;
	}

	public void setNotifyingFixture(LabelNotifierImpl fixture) {
		this.fixture = fixture;
	}

	@Before
	@Override
	public void setUp() throws Exception {
		setNotifyingFixture(new LabelNotifierImpl());
		super.setFixture(fixture);
	}

	@Override
	public void setFixture(Label fixture) {
		Assert.assertTrue("Label in test must be of instance LabelNotifierImpl", fixture instanceof LabelNotifierImpl);
		this.fixture = (LabelNotifierImpl) fixture;
		super.setFixture(fixture);
	}

	/**
	 * Checks whether the notification about name change is correct. *
	 */
	@Test
	public void testNotificationNamespace() {
		MyListener listener = new MyListener();
		getFixture().addListener(listener);
		getFixture().setNamespace("myNamespace");
		assertEquals(NOTIFICATION_TYPE.SET, listener.lastEvent.type);
		assertEquals(GRAPH_ATTRIBUTES.LABEL_NAMESPACE, listener.lastEvent.attribute);
		assertEquals(null, listener.lastEvent.oldValue);
		assertEquals("myNamespace", listener.lastEvent.newValue);
		assertEquals(getFixture(), listener.lastEvent.container);
	}

	/**
	 * Checks whether the notification about name change is correct. *
	 */
	@Test
	public void testNotificationName() {
		MyListener listener = new MyListener();
		getFixture().addListener(listener);

		getFixture().setName("myName");
		assertEquals(NOTIFICATION_TYPE.SET, listener.lastEvent.type);
		assertEquals(GRAPH_ATTRIBUTES.LABEL_NAME, listener.lastEvent.attribute);
		assertEquals(null, listener.lastEvent.oldValue);
		assertEquals("myName", listener.lastEvent.newValue);
		assertEquals(getFixture(), listener.lastEvent.container);
	}

	/**
	 * Checks whether the notification about name change is correct. *
	 */
	@Test
	public void testNotificationValue() {
		MyListener listener = new MyListener();
		getFixture().addListener(listener);
		getFixture().setValue("myValue");
		assertEquals(NOTIFICATION_TYPE.SET, listener.lastEvent.type);
		assertEquals(GRAPH_ATTRIBUTES.LABEL_VALUE, listener.lastEvent.attribute);
		assertEquals(null, listener.lastEvent.oldValue);
		assertEquals("myValue", listener.lastEvent.newValue);
		assertEquals(getFixture(), listener.lastEvent.container);
	}

	/**
	 * Checks whether the notification about name change is correct. *
	 */
	@Test
	public void testNotificationAddRemoveValue() {
		Helper.testNotificationAddRemoveValue(fixture, GRAPH_ATTRIBUTES.LABEL_LABELS);
	}

	@Override
	protected Label createLabel() {
		return new LabelNotifierImpl();
	}

}
