package de.hu_berlin.u.saltnpepper.salt.core.impl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotationContainer;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SMetaAnnotation;
import de.hu_berlin.u.saltnpepper.salt.util.SaltUtil;

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
	public void testIterator_SAnnotation(){
		Set<SAnnotation> annos= new HashSet<>();
		annos.add(getFixture().createAnnotation("stts", "pos", "VVFIN"));
		getFixture().createMetaAnnotation(null, "meta1", "val1");
		getFixture().createMetaAnnotation(null, "meta2", "val2");
		annos.add(getFixture().createAnnotation(null, "lemma", "go"));
		annos.add(getFixture().createAnnotation(null, "text", "went"));
		getFixture().createMetaAnnotation(null, "meta3", "val3");
		annos.add(getFixture().createAnnotation(null, "other", null));
		
		Iterator<SAnnotation> it= getFixture().iterator_SAnnotation();
		Set<SAnnotation> itAnnos= new HashSet<>();
		while (it.hasNext()){
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
	// =============================< SMetaAnnotation
}
