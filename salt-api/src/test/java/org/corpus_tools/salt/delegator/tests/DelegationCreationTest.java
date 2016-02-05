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
package org.corpus_tools.salt.delegator.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.impl.SaltFactoryImpl;
import org.corpus_tools.salt.samples.SampleGenerator;
import org.corpus_tools.salt.util.Difference;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DelegationCreationTest {

	@Before
	public void setUp() throws Exception {
		SaltFactory.setFactory(new SaltFactoryImpl());
		assertTrue(SaltFactory.getFactory() instanceof SaltFactoryImpl);
	}

	@After
	public void tearDown() throws Exception {
		SaltFactory.setFactory(new SaltFactoryImpl());
		assertTrue(SaltFactory.getFactory() instanceof SaltFactoryImpl);
	}

	/**
	 * Compares a sample generated by {@link SampleGenerator} created 1) with
	 * default factory and 2) with {@link DelegatorTestFactory}. <br/>
	 * The sample is the {@link SampleGenerator#createPrimaryData(SDocument)}.
	 */
	@Test
	public void testDelegatedPrimaryData() {
		SDocument template_doc = SaltFactory.createSDocument();
		SampleGenerator.createPrimaryData(template_doc);

		SaltFactory.setFactory(new DelegatorTestFactory());
		assertTrue(SaltFactory.getFactory() instanceof DelegatorTestFactory);

		SDocument fixture_doc = SaltFactory.createSDocument();
		SampleGenerator.createPrimaryData(fixture_doc);

		Set<Difference> diffs = template_doc.getDocumentGraph().findDiffs(fixture_doc.getDocumentGraph());
		assertEquals("" + diffs, 0, diffs.size());
	}

	/**
	 * Compares a sample generated by {@link SampleGenerator} created 1) with
	 * default factory and 2) with {@link DelegatorTestFactory}. <br/>
	 * The sample is the {@link SampleGenerator#createTokens(SDocument)}.
	 */
	@Test
	public void testDelegatedTokens() {
		SDocument template_doc = SaltFactory.createSDocument();
		SampleGenerator.createTokens(template_doc);

		SaltFactory.setFactory(new DelegatorTestFactory());
		assertTrue(SaltFactory.getFactory() instanceof DelegatorTestFactory);

		SDocument fixture_doc = SaltFactory.createSDocument();
		SampleGenerator.createTokens(fixture_doc);

		Set<Difference> diffs = template_doc.getDocumentGraph().findDiffs(fixture_doc.getDocumentGraph());
		assertEquals("" + diffs, 0, diffs.size());
	}

	/**
	 * Compares a sample generated by {@link SampleGenerator} created 1) with
	 * default factory and 2) with {@link DelegatorTestFactory}. <br/>
	 * The sample is the
	 * {@link SampleGenerator#createMorphologyAnnotations(SDocument)}.
	 */
	@Test
	public void testDelegatedMorphologyAnnotations() {
		SDocument template_doc = SaltFactory.createSDocument();
		SampleGenerator.createMorphologyAnnotations(template_doc);

		SaltFactory.setFactory(new DelegatorTestFactory());
		assertTrue(SaltFactory.getFactory() instanceof DelegatorTestFactory);

		SDocument fixture_doc = SaltFactory.createSDocument();
		SampleGenerator.createMorphologyAnnotations(fixture_doc);

		Set<Difference> diffs = template_doc.getDocumentGraph().findDiffs(fixture_doc.getDocumentGraph());
		assertEquals("" + diffs, 0, diffs.size());
	}

	/**
	 * Compares a sample generated by {@link SampleGenerator} created 1) with
	 * default factory and 2) with {@link DelegatorTestFactory}. <br/>
	 * The sample is the
	 * {@link SampleGenerator#createInformationStructureSpan(SDocument)}.
	 */
	@Test
	public void testDelegatedInformationStructureSpan() {
		SDocument template_doc = SaltFactory.createSDocument();
		SampleGenerator.createInformationStructureSpan(template_doc);

		SaltFactory.setFactory(new DelegatorTestFactory());
		assertTrue(SaltFactory.getFactory() instanceof DelegatorTestFactory);

		SDocument fixture_doc = SaltFactory.createSDocument();
		SampleGenerator.createInformationStructureSpan(fixture_doc);

		Set<Difference> diffs = template_doc.getDocumentGraph().findDiffs(fixture_doc.getDocumentGraph());
		assertEquals("" + diffs, 0, diffs.size());
	}

	/**
	 * Compares a sample generated by {@link SampleGenerator} created 1) with
	 * default factory and 2) with {@link DelegatorTestFactory}. <br/>
	 * The sample is the
	 * {@link SampleGenerator#createInformationStructureAnnotations(SDocument)}.
	 */
	@Test
	public void testDelegatedInformationStructureAnnotations() {
		SDocument template_doc = SaltFactory.createSDocument();
		SampleGenerator.createInformationStructureAnnotations(template_doc);

		SaltFactory.setFactory(new DelegatorTestFactory());
		assertTrue(SaltFactory.getFactory() instanceof DelegatorTestFactory);

		SDocument fixture_doc = SaltFactory.createSDocument();
		SampleGenerator.createInformationStructureAnnotations(fixture_doc);

		Set<Difference> diffs = template_doc.getDocumentGraph().findDiffs(fixture_doc.getDocumentGraph());
		assertEquals("" + diffs, 0, diffs.size());
	}

	/**
	 * Compares a sample generated by {@link SampleGenerator} created 1) with
	 * default factory and 2) with {@link DelegatorTestFactory}. <br/>
	 * The sample is the
	 * {@link SampleGenerator#createSyntaxStructure(SDocument)}.
	 */
	@Test
	public void testDelegatedSyntaxStructure() {
		SDocument template_doc = SaltFactory.createSDocument();
		SampleGenerator.createSyntaxStructure(template_doc);

		SaltFactory.setFactory(new DelegatorTestFactory());
		assertTrue(SaltFactory.getFactory() instanceof DelegatorTestFactory);

		SDocument fixture_doc = SaltFactory.createSDocument();
		SampleGenerator.createSyntaxStructure(fixture_doc);

		Set<Difference> diffs = template_doc.getDocumentGraph().findDiffs(fixture_doc.getDocumentGraph());
		assertEquals("" + diffs, 0, diffs.size());
	}

	/**
	 * Compares a sample generated by {@link SampleGenerator} created 1) with
	 * default factory and 2) with {@link DelegatorTestFactory}. <br/>
	 * The sample is the
	 * {@link SampleGenerator#createSyntaxAnnotations(SDocument)}.
	 */
	@Test
	public void testDelegatedSyntaxAnnotations() {
		SDocument template_doc = SaltFactory.createSDocument();
		SampleGenerator.createSyntaxAnnotations(template_doc);

		SaltFactory.setFactory(new DelegatorTestFactory());
		assertTrue(SaltFactory.getFactory() instanceof DelegatorTestFactory);

		SDocument fixture_doc = SaltFactory.createSDocument();
		SampleGenerator.createSyntaxAnnotations(fixture_doc);

		Set<Difference> diffs = template_doc.getDocumentGraph().findDiffs(fixture_doc.getDocumentGraph());
		assertEquals("" + diffs, 0, diffs.size());
	}

	/**
	 * Compares a sample generated by {@link SampleGenerator} created 1) with
	 * default factory and 2) with {@link DelegatorTestFactory}. <br/>
	 * The sample is the
	 * {@link SampleGenerator#createAnaphoricAnnotations(SDocument)}.
	 */
	@Test
	public void testDelegatedAnaphoricAnnotations() {
		SDocument template_doc = SaltFactory.createSDocument();
		SampleGenerator.createAnaphoricAnnotations(template_doc);

		SaltFactory.setFactory(new DelegatorTestFactory());
		assertTrue(SaltFactory.getFactory() instanceof DelegatorTestFactory);

		SDocument fixture_doc = SaltFactory.createSDocument();
		SampleGenerator.createAnaphoricAnnotations(fixture_doc);

		Set<Difference> diffs = template_doc.getDocumentGraph().findDiffs(fixture_doc.getDocumentGraph());
		assertEquals("" + diffs, 0, diffs.size());
	}

	/**
	 * Compares a sample generated by {@link SampleGenerator} created 1) with
	 * default factory and 2) with {@link DelegatorTestFactory}. <br/>
	 * The sample is the
	 * {@link SampleGenerator#createDocumentStructure(SDocument)}.
	 */
	@Test
	public void testDelegatedDocumentStructure() {
		SDocument template_doc = SaltFactory.createSDocument();
		SampleGenerator.createDocumentStructure(template_doc);

		SaltFactory.setFactory(new DelegatorTestFactory());
		assertTrue(SaltFactory.getFactory() instanceof DelegatorTestFactory);

		SDocument fixture_doc = SaltFactory.createSDocument();
		SampleGenerator.createDocumentStructure(fixture_doc);

		Set<Difference> diffs = template_doc.getDocumentGraph().findDiffs(fixture_doc.getDocumentGraph());
		assertEquals("" + diffs, 0, diffs.size());
	}
}
