/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
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
package org.corpus_tools.salt.index.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.corpus_tools.salt.index.IndexMgr;
import org.corpus_tools.salt.index.IndexMgrImpl;
import org.junit.Before;
import org.junit.Test;

public class IndexMgrTest {

	protected IndexMgr fixture = null;

	public IndexMgr getFixture() {
		return fixture;
	}

	public void setFixture(IndexMgr fixture) {
		this.fixture = fixture;
	}

	@Before
	public void setUp() throws Exception {
		setFixture(new IndexMgrImpl());
	}

	/**
	 * Creates an index an checks if the index was created successfully.
	 */
	@Test
	public void testCreateIndex() {
		String index1 = "index01";
		String index2 = "index02";

		getFixture().createIndex(index1, String.class, String.class);
		assertTrue(getFixture().containsIndex(index1));
		getFixture().createIndex(index2, Object.class, Object.class);
		assertTrue(getFixture().containsIndex(index1));
		assertTrue(getFixture().containsIndex(index2));
	}

	/**
	 * Tests that only values can be added matching to the class type of value.
	 */
	@Test
	public void testAddValues() {
		String indexId = "index";
		getFixture().createIndex(indexId, String.class, String.class);

		try {
			getFixture().put(indexId, "wrongObject", Integer.valueOf(4));
			fail();
		} catch (ClassCastException e) {
		}

		getFixture().put(indexId, "key", "val1");
		assertEquals("val1", getFixture().get(indexId, "key"));

		getFixture().put(indexId, "key", "val2");
		assertTrue(getFixture().getAll(indexId, "key").contains("val1"));
		assertTrue(getFixture().getAll(indexId, "key").contains("val2"));
	}

	/**
	 * Tests that a value is removed from all indexes at once.
	 */
	@Test
	public void testRemoveValue() {
		String index1 = "index1";
		String index2 = "index2";
		String index3 = "index3";
		String key = "key";
		Object value = new Object();

		getFixture().createIndex(index1, String.class, Object.class);
		getFixture().createIndex(index2, String.class, Object.class);
		getFixture().createIndex(index3, String.class, Object.class);

		getFixture().put(index1, "key1", "val1");
		getFixture().put(index1, key, value);
		getFixture().put(index1, key, "val2");

		getFixture().put(index2, "key1", "val1");
		getFixture().put(index2, key, value);
		getFixture().put(index2, key, "val2");

		getFixture().put(index3, "key1", "val1");
		getFixture().put(index3, key, value);
		getFixture().put(index3, key, "val2");

		assertTrue(getFixture().getAll(index1, key).contains(value));
		assertTrue(getFixture().getAll(index2, key).contains(value));
		assertTrue(getFixture().getAll(index3, key).contains(value));

		getFixture().removeValue(value);

		assertFalse(getFixture().getAll(index1, key).contains(value));
		assertFalse(getFixture().getAll(index2, key).contains(value));
		assertFalse(getFixture().getAll(index3, key).contains(value));
	}
}
