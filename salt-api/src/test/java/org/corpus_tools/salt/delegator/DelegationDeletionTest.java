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
package org.corpus_tools.salt.delegator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;
import java.util.Vector;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.impl.SaltFactoryImpl;
import org.corpus_tools.salt.samples.SampleGenerator;
import org.corpus_tools.salt.util.Difference;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DelegationDeletionTest {

	@Before
	public void setUp() throws Exception {
		SaltFactory.setFactory(new DelegatorTestFactory());
		assertTrue(SaltFactory.getFactory() instanceof DelegatorTestFactory);
	}

	@After
	public void tearDown() throws Exception {
		SaltFactory.setFactory(new SaltFactoryImpl());
		assertTrue(SaltFactory.getFactory() instanceof SaltFactoryImpl);
	}

	/**
	 * Removes all pointing relations and compares two graphs created 1) with
	 * default factory and 2) with {@link DelegatorTestFactory}.
	 */
	@Test
	public void testDelegated_DeletePointingRelations() {
		SDocument template_doc = SaltFactory.createSDocument();
		SampleGenerator.createDocumentStructure(template_doc);

		SaltFactory.setFactory(new DelegatorTestFactory());
		assertTrue(SaltFactory.getFactory() instanceof DelegatorTestFactory);

		SDocument fixture_doc = SaltFactory.createSDocument();
		SampleGenerator.createDocumentStructure(fixture_doc);

		Set<Difference> diffs = template_doc.getDocumentGraph().findDiffs(fixture_doc.getDocumentGraph());
		assertEquals("" + diffs, 0, diffs.size());

		assertEquals(template_doc.getDocumentGraph().getRelations().size(),
				fixture_doc.getDocumentGraph().getRelations().size());

		List<SRelation<?,?>> rels = new Vector<>();
		rels.addAll(template_doc.getDocumentGraph().getPointingRelations());
		for (SRelation<?,?> rel : rels) {
			template_doc.getDocumentGraph().removeRelation(rel);
		}

		rels = new Vector<>();
		rels.addAll(fixture_doc.getDocumentGraph().getPointingRelations());
		for (SRelation<?,?> rel : rels) {
			fixture_doc.getDocumentGraph().removeRelation(rel);
		}

		diffs = template_doc.getDocumentGraph().findDiffs(fixture_doc.getDocumentGraph());
		assertEquals("" + diffs, 0, diffs.size());
	}

	/**
	 * Removes all structures and dominance relations and compares two graphs
	 * created 1) with default factory and 2) with {@link DelegatorTestFactory}.
	 */
	@Test
	public void testDelegated_DeleteSyntax() {
		SDocument template_doc = SaltFactory.createSDocument();
		SampleGenerator.createDocumentStructure(template_doc);

		SaltFactory.setFactory(new DelegatorTestFactory());
		assertTrue(SaltFactory.getFactory() instanceof DelegatorTestFactory);

		SDocument fixture_doc = SaltFactory.createSDocument();
		SampleGenerator.createDocumentStructure(fixture_doc);

		Set<Difference> diffs = template_doc.getDocumentGraph().findDiffs(fixture_doc.getDocumentGraph());
		assertEquals("" + diffs, 0, diffs.size());

		assertEquals(template_doc.getDocumentGraph().getRelations().size(),
				fixture_doc.getDocumentGraph().getRelations().size());

		List<SRelation<?,?>> rels = new Vector<>();
		rels.addAll(template_doc.getDocumentGraph().getDominanceRelations());
		for (SRelation<?,?> rel : rels) {
			template_doc.getDocumentGraph().removeRelation(rel);
		}
		List<SNode> nodes = new Vector<>();
		nodes.addAll(template_doc.getDocumentGraph().getStructures());
		for (SNode node : nodes) {
			template_doc.getDocumentGraph().removeNode(node);
		}

		rels = new Vector<>();
		rels.addAll(fixture_doc.getDocumentGraph().getDominanceRelations());
		for (SRelation<?,?> rel : rels) {
			fixture_doc.getDocumentGraph().removeRelation(rel);
		}
		nodes = new Vector<>();
		nodes.addAll(fixture_doc.getDocumentGraph().getStructures());
		for (SNode node : nodes) {
			fixture_doc.getDocumentGraph().removeNode(node);
		}

		diffs = template_doc.getDocumentGraph().findDiffs(fixture_doc.getDocumentGraph());
		assertEquals("" + diffs, 0, diffs.size());
	}

	/**
	 * Removes all spans and spanning relations and compares two graphs created
	 * 1) with default factory and 2) with {@link DelegatorTestFactory}.
	 */
	@Test
	public void testDelegated_DeleteInformationStructure() {
		SDocument template_doc = SaltFactory.createSDocument();
		SampleGenerator.createDocumentStructure(template_doc);

		SaltFactory.setFactory(new DelegatorTestFactory());
		assertTrue(SaltFactory.getFactory() instanceof DelegatorTestFactory);

		SDocument fixture_doc = SaltFactory.createSDocument();
		SampleGenerator.createDocumentStructure(fixture_doc);

		Set<Difference> diffs = template_doc.getDocumentGraph().findDiffs(fixture_doc.getDocumentGraph());
		assertEquals("" + diffs, 0, diffs.size());

		assertEquals(template_doc.getDocumentGraph().getRelations().size(),
				fixture_doc.getDocumentGraph().getRelations().size());

		List<SRelation<?,?>> rels = new Vector<>();
		rels.addAll(template_doc.getDocumentGraph().getSpanningRelations());
		for (SRelation<?,?> rel : rels) {
			template_doc.getDocumentGraph().removeRelation(rel);
		}
		List<SNode> nodes = new Vector<>();
		nodes.addAll(template_doc.getDocumentGraph().getSpans());
		for (SNode node : nodes) {
			template_doc.getDocumentGraph().removeNode(node);
		}

		rels = new Vector<>();
		rels.addAll(fixture_doc.getDocumentGraph().getSpanningRelations());
		for (SRelation<?,?> rel : rels) {
			fixture_doc.getDocumentGraph().removeRelation(rel);
		}
		nodes = new Vector<>();
		nodes.addAll(fixture_doc.getDocumentGraph().getSpans());
		for (SNode node : nodes) {
			fixture_doc.getDocumentGraph().removeNode(node);
		}

		diffs = template_doc.getDocumentGraph().findDiffs(fixture_doc.getDocumentGraph());
		assertEquals("" + diffs, 0, diffs.size());
	}
}
