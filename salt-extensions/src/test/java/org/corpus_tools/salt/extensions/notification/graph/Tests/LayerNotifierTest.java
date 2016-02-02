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

import org.corpus_tools.salt.extensions.notification.graph.impl.LayerNotifierImpl;
import org.corpus_tools.salt.graph.GRAPH_ATTRIBUTES;
import org.junit.Before;
import org.junit.Test;

public class LayerNotifierTest {

	private LayerNotifierImpl fixture = null;

	public LayerNotifierImpl getFixture() {
		return fixture;
	}

	public void setFixture(LayerNotifierImpl fixture) {
		this.fixture = fixture;
	}

	@Before
	public void setUp() throws Exception {
		setFixture(new LayerNotifierImpl());
	}

	/** Checks whether the notification about name change is correct. **/
	@Test
	public void testNotificationAddRemoveValue() {
		Helper.testNotificationAddRemoveValue(fixture, GRAPH_ATTRIBUTES.LAYER_LABELS);
	}
}