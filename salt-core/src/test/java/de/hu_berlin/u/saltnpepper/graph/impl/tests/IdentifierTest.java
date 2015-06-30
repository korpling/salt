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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.graph.IdentifiableElement;
import de.hu_berlin.u.saltnpepper.graph.Identifier;
import de.hu_berlin.u.saltnpepper.graph.impl.GraphFactory;
import de.hu_berlin.u.saltnpepper.graph.impl.IdentifiableElementImpl;
import de.hu_berlin.u.saltnpepper.graph.util.GraphUtil;

public class IdentifierTest {

	private Identifier fixture = null;

	public Identifier getFixture() {
		return fixture;
	}

	public void setFixture(Identifier fixture) {
		this.fixture = fixture;
	}

	class MyContainer extends IdentifiableElementImpl {
		private static final long serialVersionUID = 5834449609454195900L;
	}

	@Before
	public void setUp() throws Exception {
		MyContainer container = new MyContainer();
		setFixture(GraphFactory.createIdentifier(container, "myId"));
	}

	@After
	public void tearDown() throws Exception {
		setFixture(null);
	}

	@Test
	public void testQNameHandling() {
		// should be ok
		String name = GraphUtil.IDENTIFIER_NAME;
		String qName = GraphUtil.IDENTIFIER_NAMESPACE + Identifier.NS_SEPERATOR + name;
		getFixture().setQName(name);
		assertEquals(qName, getFixture().getQName());
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
		String qname = GraphUtil.IDENTIFIER_NAMESPACE + GraphUtil.NS_SEPERATOR + GraphUtil.IDENTIFIER_NAME;
		assertEquals(qname, getFixture().getQName());
		getFixture().setName("something");
		assertEquals(qname, getFixture().getQName());
	}

	@Test
	public void testGetId() {
		assertEquals("myId", getFixture().getId());
		assertEquals("myId", getFixture().getValue());
	}

	/** Checks that id is not changeable. **/
	@Test
	public void testSetValue() {
		getFixture().setValue("newId");
		assertEquals("myId", getFixture().getValue());
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

	/**
	 * Checks that {@link IdentifiableElement} and {@link Identifier} are always
	 * correctly connected.
	 **/
	@Test
	public void testCheckOpposite() {
		MyContainer newContainer = new MyContainer();
		Identifier id= GraphFactory.createIdentifier(newContainer, GraphUtil.IDENTIFIER_NAME);
		assertEquals(newContainer.getIdentifier(), id);
		
		newContainer.setId("newId");
		assertFalse(newContainer.equals(id));
	}

	@Test
	public void testGeneralNameHandling() {
		assertEquals(GraphUtil.IDENTIFIER_NAMESPACE, getFixture().getNamespace());
	}
} // IdentifierTest
