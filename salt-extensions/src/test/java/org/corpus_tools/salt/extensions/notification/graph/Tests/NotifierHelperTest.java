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
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.corpus_tools.salt.extensions.notification.Listener;
import org.corpus_tools.salt.extensions.notification.graph.impl.NotifierHelper;
import org.corpus_tools.salt.graph.GRAPH_ATTRIBUTES;
import org.junit.Test;

public class NotifierHelperTest {

	@Test
	public void testAddRemoveGetListener() {
		Listener listener1 = new Listener() {
			@Override
			public void notify(NOTIFICATION_TYPE type, GRAPH_ATTRIBUTES attribute, Object oldValue, Object newValue,
					Object container) {
			}
		};
		Listener listener2 = new Listener() {
			@Override
			public void notify(NOTIFICATION_TYPE type, GRAPH_ATTRIBUTES attribute, Object oldValue, Object newValue,
					Object container) {
			}
		};

		assertNotNull(NotifierHelper.getListener(null));
		assertEquals(0, NotifierHelper.getListener(null).size());

		ArrayList<Listener> listenerList = new ArrayList<>();
		assertEquals(0, NotifierHelper.getListener(listenerList).size());

		NotifierHelper.addListener(listenerList, (Listener) null);
		assertEquals(0, NotifierHelper.getListener(listenerList).size());

		NotifierHelper.addListener(listenerList, listener1);
		assertEquals(1, NotifierHelper.getListener(listenerList).size());

		NotifierHelper.addListener(listenerList, listener2);
		assertEquals(2, NotifierHelper.getListener(listenerList).size());
	}

}
