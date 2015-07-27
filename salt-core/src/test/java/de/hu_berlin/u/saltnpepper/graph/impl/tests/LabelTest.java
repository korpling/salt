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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.graph.LabelableElement;
import de.hu_berlin.u.saltnpepper.graph.impl.GraphFactory;
import de.hu_berlin.u.saltnpepper.graph.impl.LabelableElementImpl;
import de.hu_berlin.u.saltnpepper.salt.util.GraphUtil;

public class LabelTest {

	private Label fixture = null;

	public Label getFixture() {
		return fixture;
	}

	public void setFixture(Label fixture) {
		this.fixture = fixture;
	}

	@Before
	public void setUp() throws Exception {
		setFixture(GraphFactory.createLabel());
	}

	@Test
	public void testGetQName() {
		Label label = this.getFixture();
		String qName = null;
		qName = label.getQName();
		assertEquals(qName, label.getQName());

		// shouldn't be ok
		label = this.getFixture();
		qName = null;
		try {
			label.setQName(qName);
			fail("should fail if an empty QName is set.");
		} catch (Exception e) {
		}

		// shouldn't be ok
		label = this.getFixture();
		qName = "";
		try {
			label.setQName(qName);
			fail("should fail if an empty QName is set.");
		} catch (Exception e) {
		}

		// should be ok
		label = GraphFactory.createLabel();
		qName = "any name";
		label.setQName(qName);
		assertEquals(qName, label.getQName());

		// should be ok
		this.setFixture(GraphFactory.createLabel());
		label = this.getFixture();
		qName = "label1";
		label.setQName(qName);
		assertEquals(qName, label.getQName());

		// should be ok
		label = this.getFixture();
		qName = "ns::name";
		label.setQName(qName);
		assertEquals(qName, label.getQName());

		// should be ok
		label = this.getFixture();
		qName = "ns::ns2::name";
		label.setQName(qName);
		assertEquals(qName, label.getQName());

		// should be ok
		label = this.getFixture();
		qName = "ns::ns::name";
		label.setQName(qName);
		assertEquals(qName, label.getQName());
	}

	/**
	 * Checks if qname is returned correctly, if name or namespace is missing.
	 * <ol>
	 * <li>qName= name if namespace is missing</li>
	 * <li>qName= namespace + {@value Label#NS_SEPERATOR}, if name is missing</li>
	 * <li>qName= namespace + {@value Label#NS_SEPERATOR} + name, if both is
	 * given</li>
	 * </ol>
	 */
	@Test
	public void testGetQName2() {
		assertNull(this.getFixture().getQName());
		String name = "name";
		String namespace = "namespace";

		this.getFixture().setName(name);
		assertEquals(name, this.getFixture().getQName());

		this.setFixture(GraphFactory.createLabel());
		this.getFixture().setNamespace(namespace);
		assertEquals(namespace + Label.NS_SEPERATOR, this.getFixture().getQName());

		this.getFixture().setName(name);
		assertEquals(namespace + Label.NS_SEPERATOR + name, this.getFixture().getQName());
	}

	@Test
	public void testGeneralNameHandling() {
		Label label = this.getFixture();
		String ns = null;
		String name = null;
		String QName = null;

		// test1
		label = this.getFixture();
		ns = null;
		name = "label1";
		QName = name;
		label.setNamespace(ns);
		label.setName(name);
		assertEquals(QName, label.getQName());

		// test1
		label = this.getFixture();
		ns = "ns1";
		name = null;
		label.setNamespace(ns);
		try {
			label.setName(name);
			fail("should fail if an empty name was given.");
		} catch (Exception e) {
		}

		// test1
		label = this.getFixture();
		ns = "ns1";
		name = "";
		label.setNamespace(ns);
		try {
			label.setName(name);
			fail("should fail if an empty name was given.");
		} catch (Exception e) {
		}

		// test1
		label = this.getFixture();
		ns = null;
		name = "name1" + GraphUtil.NS_SEPERATOR + "name2";
		QName = ns + GraphUtil.NS_SEPERATOR + name;
		label.setNamespace(ns);
		try {
			label.setName(name);
			fail("a name with the namespace sperator is illegal.");
		} catch (Exception e) {
		}

		// test1
		label = this.getFixture();
		ns = null;
		name = "label1";
		label.setName(name);
		assertEquals(name, label.getQName());

	}

	public void testValueHandling() {
		Label label = this.getFixture();
		String value = null;

		label.setValue(value);
		assertEquals(value, label.getValue());

		// test
		value = "val1";
		label.setValue(value);
		assertEquals(value, label.getValue());

		// test
		value = "val1::val2";
		label.setValue(value);
		assertEquals(value, label.getValue());
	}

	@Test
	public void testGetValue() {
		assertNull(this.getFixture().getValue());

		Object obj = new Object();
		this.getFixture().setValue(obj);
		assertEquals(obj, this.getFixture().getValue());

		String value = "value";
		this.getFixture().setValue(value);
		assertEquals(value, this.getFixture().getValue());
	}

	/**
	 * Tests the method {@link Label#copy(Label)}
	 */
	@Test
	public void testCopy() {
		getFixture().setNamespace("namespace1");
		getFixture().setName("name1");
		getFixture().setValue("value1");

		Label<String> other = GraphFactory.createLabel();
		getFixture().copy(other);

		assertEquals(getFixture().getNamespace(), other.getNamespace());
		assertEquals(getFixture().getName(), other.getName());
		assertEquals(getFixture().getValue(), other.getValue());
	}

	/**
	 * Tests whether a label, which is added to a container contains the
	 * container as {@link Label#getLabelableElement()}.
	 */
	@Test
	public void testDoubleChaining() {
		@SuppressWarnings("serial")
		LabelableElement container = new LabelableElementImpl() {
		};
		getFixture().setQName("labelName");
		assertNull(getFixture().getLabelableElement());
		container.addLabel(getFixture());		
		assertEquals(container, getFixture().getLabelableElement());
	}
} // LabelTest
