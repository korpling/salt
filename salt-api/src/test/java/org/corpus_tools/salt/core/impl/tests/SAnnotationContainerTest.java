package org.corpus_tools.salt.core.impl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.core.SAnnotation;
import org.corpus_tools.salt.core.SAnnotationContainer;
import org.corpus_tools.salt.core.SFeature;
import org.corpus_tools.salt.core.SMetaAnnotation;
import org.corpus_tools.salt.core.SProcessingAnnotation;
import org.corpus_tools.salt.util.SaltUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public abstract class SAnnotationContainerTest {

	protected SAnnotationContainer fixture = null;

	public SAnnotationContainer getFixture() {
		return fixture;
	}

	public void setFixture(SAnnotationContainer fixture) {
		this.fixture = fixture;
	}

	@Before
	public void setUp() throws Exception {
		throw new UnsupportedOperationException("Please implement method setUp() to run tests. ");
	}

	@After
	public void tearDown() throws Exception {
		setFixture(null);
	}

	// =============================> SAnnotation
	@Test
	public void testGetAnnotations() {
		String[] qNames = { "ns::name1", "ns::name2", "ns::name3", "ns::name4" };
		List<SAnnotation> annos = new ArrayList<>();
		for (String qName : qNames) {
			SAnnotation anno = SaltFactory.createSAnnotation();
			anno.setQName(qName);
			getFixture().addAnnotation(anno);
			annos.add(anno);
		}
		assertTrue(annos.containsAll(getFixture().getAnnotations()));
		assertTrue(getFixture().getAnnotations().containsAll(annos));
	}

	@Test
	public void testAddSAnnotation() {
		String QName = "ns::name";
		SAnnotation anno = SaltFactory.createSAnnotation();
		anno.setQName(QName);
		getFixture().addAnnotation(anno);
		assertEquals(anno, getFixture().getAnnotation(QName));
	}

	/**
	 * Tests the creation of a set of annotations, along a formatted string.
	 */
	@Test
	public void testCreateAnnotations() {
		String annotationString = "blub";
		getFixture().createAnnotations(annotationString);
		assertNotNull(getFixture().getAnnotation("blub"));

		annotationString = "myNS::bla=blub;foo;x=y";
		getFixture().createAnnotations(annotationString);
		assertNotNull(getFixture().getAnnotations());
		assertEquals(4, getFixture().getAnnotations().size());
		assertNotNull(getFixture().getAnnotation("myNS::bla"));
		assertEquals("blub", getFixture().getAnnotation("myNS::bla").getValue());
		assertNotNull(getFixture().getAnnotation("foo"));
		assertNotNull(getFixture().getAnnotation("x"));
		assertEquals("y", getFixture().getAnnotation("x").getValue());
	}

	/**
	 * Checks the creation of a single annotation
	 */
	@Test
	public void testCreateSAnnotation() {
		String name = "name";
		String namespace = "namespace";
		String value = "value";
		SAnnotation anno = getFixture().createAnnotation(namespace, name, value);
		assertEquals(1, getFixture().getAnnotations().size());
		assertTrue(getFixture().getAnnotations().contains(anno));
		assertEquals(anno, getFixture().getAnnotation(SaltUtil.createQName(namespace, name)));
	}

	/**
	 * Tests whether the container and the label are double chained.
	 */
	@Test
	public void testDoubleChaining_SAnnotation() {
		SAnnotation anno = SaltFactory.createSAnnotation();
		anno.setName("labelName");
		getFixture().addLabel(anno);

		assertEquals(getFixture(), anno.getContainer());
	}

	/**
	 * Creates some {@link SAnnotation} and {@link SMetaAnnotation} objects and
	 * adds them in a mixed order to the container. The iterator is checked if
	 * it finds each {@link SAnnotation} object.
	 */
	@Test
	public void testIterator_SAnnotation() {
		Set<SAnnotation> annos = new HashSet<>();
		annos.add(getFixture().createAnnotation("stts", "pos", "VVFIN"));
		getFixture().createMetaAnnotation(null, "meta1", "val1");
		getFixture().createMetaAnnotation(null, "meta2", "val2");
		annos.add(getFixture().createAnnotation(null, "lemma", "go"));
		annos.add(getFixture().createAnnotation(null, "text", "went"));
		getFixture().createMetaAnnotation(null, "meta3", "val3");
		annos.add(getFixture().createAnnotation(null, "other", null));

		Iterator<SAnnotation> it = getFixture().iterator_SAnnotation();
		Set<SAnnotation> itAnnos = new HashSet<>();
		while (it.hasNext()) {
			itAnnos.add(it.next());
		}
		assertEquals(itAnnos.size(), annos.size());
		assertTrue(itAnnos.containsAll(annos));
		assertTrue(annos.containsAll(itAnnos));
	}

	// =============================< SAnnotation

	// =============================> SMetaAnnotation
	@Test
	public void testGetMetaAnnotations() {
		String[] qNames = { "ns::name1", "ns::name2", "ns::name3", "ns::name4" };
		List<SMetaAnnotation> annos = new ArrayList<>();
		for (String qName : qNames) {
			SMetaAnnotation anno = SaltFactory.createSMetaAnnotation();
			anno.setQName(qName);
			getFixture().addMetaAnnotation(anno);
			annos.add(anno);
		}
		assertTrue(annos.containsAll(getFixture().getMetaAnnotations()));
		assertTrue(getFixture().getMetaAnnotations().containsAll(annos));
	}

	@Test
	public void testAddSMetaAnnotation() {
		String QName = "ns::name";
		SMetaAnnotation anno = SaltFactory.createSMetaAnnotation();
		anno.setQName(QName);
		getFixture().addMetaAnnotation(anno);
		assertEquals(anno, getFixture().getMetaAnnotation(QName));
	}

	/**
	 * Tests the creation of a set of MetaAnnotations, along a formatted string.
	 */
	@Test
	public void testCreateMetaAnnotations() {
		String MetaAnnotationString = "blub";
		getFixture().createMetaAnnotations(MetaAnnotationString);
		assertNotNull(getFixture().getMetaAnnotation("blub"));

		MetaAnnotationString = "myNS::bla=blub;foo;x=y";
		getFixture().createMetaAnnotations(MetaAnnotationString);
		assertNotNull(getFixture().getMetaAnnotations());
		assertEquals(4, getFixture().getMetaAnnotations().size());
		assertNotNull(getFixture().getMetaAnnotation("myNS::bla"));
		assertEquals("blub", getFixture().getMetaAnnotation("myNS::bla").getValue());
		assertNotNull(getFixture().getMetaAnnotation("foo"));
		assertNotNull(getFixture().getMetaAnnotation("x"));
		assertEquals("y", getFixture().getMetaAnnotation("x").getValue());
	}

	/**
	 * Checks the creation of a single MetaAnnotation
	 */
	@Test
	public void testCreateSMetaAnnotation() {
		String name = "name";
		String namespace = "namespace";
		String value = "value";
		SMetaAnnotation anno = getFixture().createMetaAnnotation(namespace, name, value);
		assertEquals(1, getFixture().getMetaAnnotations().size());
		assertTrue(getFixture().getMetaAnnotations().contains(anno));
		assertEquals(anno, getFixture().getMetaAnnotation(SaltUtil.createQName(namespace, name)));
	}

	/**
	 * Tests whether the container and the label are double chained.
	 */
	@Test
	public void testDoubleChaining_SMetaAnnotation() {
		SMetaAnnotation anno = SaltFactory.createSMetaAnnotation();
		anno.setName("labelName");
		getFixture().addLabel(anno);

		assertEquals(getFixture(), anno.getContainer());
	}

	/**
	 * Creates some {@link SAnnotation} and {@link SMetaAnnotation} objects and
	 * adds them in a mixed order to the container. The iterator is checked if
	 * it finds each {@link SAnnotation} object.
	 */
	@Test
	public void testIterator_SMetaAnnotation() {
		Set<SMetaAnnotation> metaAnnos = new HashSet<>();
		getFixture().createAnnotation("stts", "pos", "VVFIN");
		metaAnnos.add(getFixture().createMetaAnnotation(null, "meta1", "val1"));
		metaAnnos.add(getFixture().createMetaAnnotation(null, "meta2", "val2"));
		getFixture().createAnnotation(null, "lemma", "go");
		getFixture().createAnnotation(null, "text", "went");
		metaAnnos.add(getFixture().createMetaAnnotation(null, "meta3", "val3"));
		getFixture().createAnnotation(null, "other", null);

		Iterator<SMetaAnnotation> it = getFixture().iterator_SMetaAnnotation();
		Set<SMetaAnnotation> itAnnos = new HashSet<>();
		while (it.hasNext()) {
			itAnnos.add(it.next());
		}
		assertEquals(itAnnos.size(), metaAnnos.size());
		assertTrue(itAnnos.containsAll(metaAnnos));
		assertTrue(metaAnnos.containsAll(itAnnos));
	}

	// =============================< SMetaAnnotation
	// =============================> SProcessingAnnotation
	@Test
	public void testGetProcessingAnnotations() {
		String[] qNames = { "ns::name1", "ns::name2", "ns::name3", "ns::name4" };
		List<SProcessingAnnotation> annos = new ArrayList<>();
		for (String qName : qNames) {
			SProcessingAnnotation anno = SaltFactory.createSProcessingAnnotation();
			anno.setQName(qName);
			getFixture().addProcessingAnnotation(anno);
			annos.add(anno);
		}
		assertTrue(annos.containsAll(getFixture().getProcessingAnnotations()));
		assertTrue(getFixture().getProcessingAnnotations().containsAll(annos));
	}

	@Test
	public void testAddSProcessingAnnotation() {
		String QName = "ns::name";
		SProcessingAnnotation anno = SaltFactory.createSProcessingAnnotation();
		anno.setQName(QName);
		getFixture().addProcessingAnnotation(anno);
		assertEquals(anno, getFixture().getProcessingAnnotation(QName));
	}

	/**
	 * Tests the creation of a set of ProcessingAnnotations, along a formatted
	 * string.
	 */
	@Test
	public void testCreateProcessingAnnotations() {
		String ProcessingAnnotationString = "blub";
		getFixture().createProcessingAnnotations(ProcessingAnnotationString);
		assertNotNull(getFixture().getProcessingAnnotation("blub"));

		ProcessingAnnotationString = "myNS::bla=blub;foo;x=y";
		getFixture().createProcessingAnnotations(ProcessingAnnotationString);
		assertNotNull(getFixture().getProcessingAnnotations());
		assertEquals(4, getFixture().getProcessingAnnotations().size());
		assertNotNull(getFixture().getProcessingAnnotation("myNS::bla"));
		assertEquals("blub", getFixture().getProcessingAnnotation("myNS::bla").getValue());
		assertNotNull(getFixture().getProcessingAnnotation("foo"));
		assertNotNull(getFixture().getProcessingAnnotation("x"));
		assertEquals("y", getFixture().getProcessingAnnotation("x").getValue());
	}

	/**
	 * Checks the creation of a single ProcessingAnnotation
	 */
	@Test
	public void testCreateSProcessingAnnotation() {
		String name = "name";
		String namespace = "namespace";
		String value = "value";
		SProcessingAnnotation anno = getFixture().createProcessingAnnotation(namespace, name, value);
		assertEquals(1, getFixture().getProcessingAnnotations().size());
		assertTrue(getFixture().getProcessingAnnotations().contains(anno));
		assertEquals(anno, getFixture().getProcessingAnnotation(SaltUtil.createQName(namespace, name)));
	}

	/**
	 * Tests whether the container and the label are double chained.
	 */
	@Test
	public void testDoubleChaining_SProcessingAnnotation() {
		SProcessingAnnotation anno = SaltFactory.createSProcessingAnnotation();
		anno.setName("labelName");
		getFixture().addLabel(anno);

		assertEquals(getFixture(), anno.getContainer());
	}

	// =============================< SProcessingAnnotation
	// =============================> SFeature
	@Test
	public void testGetFeatures() {
		String[] qNames = { "ns::name1", "ns::name2", "ns::name3", "ns::name4" };
		List<SFeature> annos = new ArrayList<>();
		for (String qName : qNames) {
			SFeature anno = SaltFactory.createSFeature();
			anno.setQName(qName);
			getFixture().addFeature(anno);
			annos.add(anno);
		}
		assertTrue(annos.containsAll(getFixture().getFeatures()));
		assertTrue(getFixture().getFeatures().containsAll(annos));
	}

	@Test
	public void testAddSFeature() {
		String QName = "ns::name";
		SFeature anno = SaltFactory.createSFeature();
		anno.setQName(QName);
		getFixture().addFeature(anno);
		assertEquals(anno, getFixture().getFeature(QName));
	}

	/**
	 * Tests the creation of a set of Features, along a formatted string.
	 */
	@Test
	public void testCreateFeatures() {
		String FeatureString = "blub";
		getFixture().createFeatures(FeatureString);
		assertNotNull(getFixture().getFeature("blub"));

		FeatureString = "myNS::bla=blub;foo;x=y";
		getFixture().createFeatures(FeatureString);
		assertNotNull(getFixture().getFeatures());
		assertEquals(4, getFixture().getFeatures().size());
		assertNotNull(getFixture().getFeature("myNS::bla"));
		assertEquals("blub", getFixture().getFeature("myNS::bla").getValue());
		assertNotNull(getFixture().getFeature("foo"));
		assertNotNull(getFixture().getFeature("x"));
		assertEquals("y", getFixture().getFeature("x").getValue());
	}

	/**
	 * Checks the creation of a single Feature
	 */
	@Test
	public void testCreateSFeature() {
		String name = "name";
		String namespace = "namespace";
		String value = "value";
		SFeature anno = getFixture().createFeature(namespace, name, value);
		assertEquals(1, getFixture().getFeatures().size());
		assertTrue(getFixture().getFeatures().contains(anno));
		assertEquals(anno, getFixture().getFeature(SaltUtil.createQName(namespace, name)));
	}

	/**
	 * Tests whether the container and the label are double chained.
	 */
	@Test
	public void testDoubleChaining_SFeature() {
		SFeature anno = SaltFactory.createSFeature();
		anno.setName("labelName");
		getFixture().addLabel(anno);

		assertEquals(getFixture(), anno.getContainer());
	}
	// =============================< SFeature
}
