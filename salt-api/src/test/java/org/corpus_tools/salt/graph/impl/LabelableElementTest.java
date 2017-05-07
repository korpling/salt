/**
 * Copyright 2009 Humboldt-Universität zu Berlin.
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
package org.corpus_tools.salt.graph.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Set;
import java.util.Vector;

import org.corpus_tools.salt.graph.GraphFactory;
import org.corpus_tools.salt.graph.Label;
import org.corpus_tools.salt.graph.LabelableElement;
import org.junit.Before;
import org.junit.Test;

public class LabelableElementTest {

	protected LabelableElement fixture = null;

	protected void setFixture(LabelableElement fixture) {
		this.fixture = fixture;
	}

	protected LabelableElement getFixture() {
		return fixture;
	}

	@Before
	public void setUp() throws Exception {
		this.setFixture(new MyLabelableElement());
	}

	static class MyLabelableElement extends LabelableElementImpl {
		private static final long serialVersionUID = 1L;
	}

	/**
	 * Tests adding of labels to a {@link LabelableElement}
	 */
	@Test
	public void testAddingGettingLabels() {
		Label label = null;

		// test 1 - empty label should not be added
		getFixture().addLabel(null);
		assertEquals(null, getFixture().getLabels());

		// test 2 - add all
		String[] labelNames = { "label1", "label2", "label3", "label4", "label5" };

		for (String labelName : labelNames) {
			label = GraphFactory.createLabel();
			label.setName(labelName);
			getFixture().addLabel(label);
			assertEquals(label, getFixture().getLabel(labelName));
		}
	}

	@Test
	public void testAddingRemovingLabels() {
		LabelableElement labelableElement = this.getFixture();
		Label label = null;

		String[] labelNames = { "label1", "label2", "label3", "label4", "label5" };
		String label1 = "label1";
		Integer numOfLabels = labelNames.length + labelableElement.sizeLabels();

		// test 1 - should fail
		for (String labelName : labelNames) {
			label = GraphFactory.createLabel();
			label.setName(labelName);
			labelableElement.addLabel(label);
		}
		assertEquals(numOfLabels, labelableElement.sizeLabels());
		try {
			for (String labelName : labelNames) {
				label = GraphFactory.createLabel();
				label.setName(labelName);
				labelableElement.addLabel(label);
				fail("You should not add two labels with same name");
			}

		} catch (Exception e) {
		}

		// test 2 remove all
		for (String labelName : labelNames) {
			labelableElement.removeLabel(labelName);
		}
		numOfLabels = 0;

		assertEquals(numOfLabels, labelableElement.sizeLabels());
		for (String labelName : labelNames) {
			label = GraphFactory.createLabel();
			label.setName(labelName);
			labelableElement.addLabel(label);
		}
		numOfLabels = labelNames.length;
		assertEquals(numOfLabels, labelableElement.sizeLabels());
		for (String labelName : labelNames) {
			labelableElement.removeLabel(labelName);
		}

		// test removing one element and adding again
		for (String labelName : labelNames) {
			label = GraphFactory.createLabel();
			label.setName(labelName);
			labelableElement.addLabel(label);
		}
		numOfLabels = labelNames.length;
		assertEquals(numOfLabels, labelableElement.sizeLabels());
		labelableElement.removeLabel(label1);
		numOfLabels = numOfLabels - 1;
		assertEquals(numOfLabels, labelableElement.sizeLabels());
		label = GraphFactory.createLabel();
		label.setName(label1);
		labelableElement.addLabel(label);
		assertEquals(label, labelableElement.getLabel(label1));
	}

	@Test
	public void testRemoveAll() throws Exception {
		LabelableElement labelableElement = this.getFixture();
		Label label = null;
		String[] labelNames = { "label1", "label2", "label3", "label4", "label5" };
		Integer numOfLabels = labelNames.length + labelableElement.sizeLabels();

		// testing removing all elements by removeAll()
		for (String labelName : labelNames) {
			label = GraphFactory.createLabel();
			label.setName(labelName);
			labelableElement.addLabel(label);
			assertEquals(label, labelableElement.getLabel(labelName));
		}
		assertEquals(numOfLabels, labelableElement.sizeLabels());
		labelableElement.removeAll();
		assertEquals(Integer.valueOf(0), labelableElement.sizeLabels());
		for (String labelName : labelNames) {
			assertNull(labelableElement.getLabel(labelName));
		}
	}

	@Test
	public void testGetLabelsByNamespace__String() {
		LabelableElement labelableElement = this.getFixture();
		Label label = null;
		String ns1 = "ns1";
		String ns2 = null;
		String ns3 = "ns2";
		String[] labelNames1 = { "ns1::label1", "ns1::label2" };
		String[] labelNames2 = { "label3" };
		String[] labelNames3 = { "ns2::label2", "ns2::label3", "ns2::label4" };
		Vector<String> labelNames = new Vector<String>();
		labelNames.addAll(new Vector<String>(Arrays.asList(labelNames1)));
		labelNames.addAll(new Vector<String>(Arrays.asList(labelNames2)));
		labelNames.addAll(new Vector<String>(Arrays.asList(labelNames3)));
		for (String labelName : labelNames) {
			label = GraphFactory.createLabel();
			label.setQName(labelName);
			labelableElement.addLabel(label);
		}

		// searching for ns1
		Set<Label> labels = labelableElement.getLabelsByNamespace(ns1);
		assertEquals(labelNames1.length, labels.size());
		boolean found = false;
		for (String labelName : labelNames1) {
			found = false;
			for (Label searchLabel : labels) {
				if (searchLabel.getQName().equalsIgnoreCase(labelName))
					found = true;
			}
			assertTrue("the searched value should be found", found);
		}

		// searching for ns2
		labels = labelableElement.getLabelsByNamespace(ns2);
		assertEquals(labelNames2.length, labels.size());
		found = false;
		for (String labelName : labelNames2) {
			found = false;
			for (Label searchLabel : labels) {
				if (searchLabel.getQName().equalsIgnoreCase(labelName))
					found = true;
			}
			assertTrue("the searched value should be found", found);
		}

		// searching for ns3
		labels = labelableElement.getLabelsByNamespace(ns3);
		assertEquals(labelNames3.length, labels.size());
		found = false;
		for (String labelName : labelNames3) {
			found = false;
			for (Label searchLabel : labels) {
				if (searchLabel.getQName().equalsIgnoreCase(labelName))
					found = true;
			}
			assertTrue("the searched value should be found", found);
		}

	}

	@Test
	public void testHasLabel__String() {
		LabelableElement labelableElement = this.getFixture();
		Label label = null;
		String[] labelNamesOK = { "ns1::label1", "ns1::label2", "label1", "ns:label4", "label6" };
		String[] labelNamesNOTOK = { "label2", "ns1::label6" };
		// add labels
		for (String labelName : labelNamesOK) {
			label = GraphFactory.createLabel();
			label.setQName(labelName);
			labelableElement.addLabel(label);
		}
		// checking existing labels
		for (String labelName : labelNamesOK) {
			assertTrue(this.getFixture().containsLabel(labelName));
		}
		// checking not existing labels
		for (String labelName : labelNamesNOTOK) {
			assertFalse(this.getFixture().containsLabel(labelName));
		}

	}

	@Test
	public void testRemoveLabel__String_String() {
		Label label = GraphFactory.createLabel();
		label.setNamespace("ns1");
		label.setName("name1");

		this.getFixture().addLabel(label);

		assertTrue(this.getFixture().containsLabel(label.getQName()));
		this.getFixture().removeLabel(label.getNamespace(), label.getName());
		assertFalse(this.getFixture().containsLabel(label.getQName()));
	}

	@Test
	public void testGetLabel__String_String() {
		Label label = GraphFactory.createLabel();
		label.setNamespace("sNS");
		label.setName("name");
		this.getFixture().addLabel(label);
		assertEquals(label, this.getFixture().getLabel(label.getNamespace(), label.getName()));
	}

	/**
	 * Tests whether a label, which is added to a container contains the
	 * container as {@link Label#getContainer()}.
	 */
	@Test
	public void testDoubleChaining() {
		Label label = GraphFactory.createLabel();
		label.setQName("labelName");
		assertNull(getFixture().getLabels());
		label.setContainer(getFixture());
		assertEquals(1, getFixture().getLabels().size());

		assertTrue(getFixture().containsLabel(label.getQName()));
		label.setContainer(null);
		assertFalse(getFixture().containsLabel(label.getQName()));
	}

	private static class Colour extends LabelImpl {
		private static final long serialVersionUID = 907666241544786170L;

		public Colour(String namespace, String name) {
			setName(name);
			setNamespace(namespace);
		}

		public Colour(String name) {
			setName(name);
		}
	}

	private static class PastelPen extends LabelImpl {
		private static final long serialVersionUID = 6111118769873347129L;

		public PastelPen(String name) {
			setNamespace(PASTEL);
			setName(name);
		}
	}

	private static final Colour RED = new Colour("red");
	private static final Colour GREEN = new Colour("green");
	private static final Colour BLUE = new Colour("blue");
	private static final String PASTEL = "pastel";
	private static final Colour PASTEL_RED = new Colour(PASTEL, "red");
	private static final Colour PASTEL_GREEN = new Colour(PASTEL, "green");
	private static final Colour PASTEL_BLUE = new Colour(PASTEL, "blue");
	private static final Label PASTEL_PEN = new PastelPen("gray");

	private void given() {
		getFixture().addLabel(RED);
		getFixture().addLabel(PASTEL_GREEN);
		getFixture().addLabel(BLUE);
		getFixture().addLabel(PASTEL_BLUE);
		getFixture().addLabel(GREEN);
		getFixture().addLabel(PASTEL_RED);
		getFixture().addLabel(PASTEL_PEN);
	}

	@Test
	public void whenFindRedGreenBlue_returnEach() {
		// given
		given();
		// when and then
		assertThat(getFixture().find(Colour.class).withNamespace(PASTEL).withName("blue").go())
				.containsOnly(PASTEL_BLUE);
		assertThat(getFixture().find(Colour.class).withNamespace(PASTEL).withName("green").go())
				.containsOnly(PASTEL_GREEN);
		assertThat(getFixture().find(Colour.class).withNamespace(PASTEL).withName("red").go()).containsOnly(PASTEL_RED);
	}

	@Test
	public void whenFindAllBlues_returnBlueAndPastelBlue() {
		// given
		given();
		// when and then
		assertThat(getFixture().find(Colour.class).withName("blue").go()).containsOnly(BLUE, PASTEL_BLUE);
	}

	@Test
	public void whenFindAllPastelColors_returnRedGreenBlue() {
		// given
		given();
		// when and then
		assertThat(getFixture().find(Colour.class).withNamespace(PASTEL).go()).containsOnly(PASTEL_BLUE, PASTEL_GREEN,
				PASTEL_RED);
	}
} // LabelableElementTest
