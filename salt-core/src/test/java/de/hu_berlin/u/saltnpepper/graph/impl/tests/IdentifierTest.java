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
package de.hu_berlin.u.saltnpepper.graph.impl.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.graph.Identifier;
import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.graph.impl.GraphFactory;
import de.hu_berlin.u.saltnpepper.graph.util.GraphUtil;
import junit.textui.TestRunner;

public class IdentifierTest {

	private Identifier<?> fixture = null;

	protected Identifier<?> getFixture() {
		return (Identifier<?>) fixture;
	}

	protected void setFixture(Identifier<?> fixture) {
		this.fixture = fixture;
	}

	@Before
	public void setUp() throws Exception {
		setFixture(GraphFactory.createIdentifier());
	}

	@Before
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link de.util.graph.Label#getFullName() <em>Full Name</em>}'
	 * feature getter. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see de.util.graph.Label#getFullName()
	 */
	@Test
	public void testQNameHandling() {
		// should be ok
		String name = GraphUtil.IDENTIFIER_NAME;
		String fullName = GraphUtil.IDENTIFIER_NAMESPACE + Identifier.NS_SEPERATOR + name;
		getFixture().setQName(name);
		assertEquals(fullName, getFixture().getQName());
	}

	@Test
	public void testSetNamespace() {
		String ns = getFixture().getNamespace();
		getFixture().setNamespace("any");
		assertEquals(ns, getFixture().getNamespace());
	}

	/**
	 * Overrides parent test {@link LabelTest#testGetQName()}.
	 */
	@Test
	public void testGetQName() {
		String qname = GraphUtil.IDENTIFIER_NAMESPACE+ GraphUtil.NS_SEPERATOR + GraphUtil.IDENTIFIER_NAME;
		assertEquals(qname, getFixture().getQName());
		getFixture().setName("something");
		assertEquals(qname, getFixture().getQName());
	}

	@Test
	public void testGetIdentifiableElement() {
		assertEquals(null, getFixture().getIdentifiableElement());
		Node node = GraphFactory.createNode();
		assertNotNull(node.getIdentifier());
		getFixture().setIdentifiableElement(node);
		assertEquals(node, getFixture().getIdentifiableElement());
	}

	@Test
	public void testGetId() {
		String id = "id1";
		assertNull(getFixture().getId());

		getFixture().setId(id);
		assertTrue(id.equalsIgnoreCase(getFixture().getId()));

		getFixture().setId(null);
		assertNull(getFixture().getId());
		assertNull(getFixture().getValue());

		getFixture().setValue(id);
		assertTrue(id.equalsIgnoreCase(getFixture().getValue().toString()));
	}

	/**
	 * Tests that the name is always the default one.
	 */
	@Test
	public void testSetName() {
		assertEquals(GraphUtil.IDENTIFIER_NAME, getFixture().getName());
		getFixture().setName("somename");
		assertEquals(GraphUtil.IDENTIFIER_NAME, getFixture().getName());
	}

	/**
	 * Tests that the namespace is always the default one.
	 */
	@Test
	public void testSetNameSpace() {
		assertEquals(GraphUtil.IDENTIFIER_NAMESPACE, getFixture().getNamespace());
		getFixture().setNamespace("somename");
		assertEquals(GraphUtil.IDENTIFIER_NAMESPACE, getFixture().getNamespace());
	}

	@Test
	public void testCheckOpposite() {
		Node node = GraphFactory.createNode();
		node.setIdentifier(getFixture());
		assertEquals(getFixture(), node.getIdentifier());
		assertEquals(getFixture().getIdentifiableElement(), node);

	}

	@Test
	public void testGeneralNameHandling() {
		assertEquals("graph", getFixture().getNamespace());
	}
} // IdentifierTest
