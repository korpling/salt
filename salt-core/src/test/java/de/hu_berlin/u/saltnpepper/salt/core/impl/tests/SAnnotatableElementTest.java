package de.hu_berlin.u.saltnpepper.salt.core.impl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotationContainer;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotation;
import de.hu_berlin.u.saltnpepper.salt.util.SaltUtil;

public abstract class SAnnotatableElementTest {

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

	@Test
	public void testGetAnnotations() {
		String[] qNames = { "ns::name1", "ns::name2", "ns::name3", "ns::name4" };
		List<SAnnotation> annos = new ArrayList<>();
		for (String qName : qNames) {
			SAnnotation anno = SaltFactory.createSAnnotation();
			anno.setQName(qName);
			this.getFixture().addSAnnotation(anno);
			annos.add(anno);
		}
		assertTrue(annos.containsAll(this.getFixture().getAnnotations()));
		assertTrue(this.getFixture().getAnnotations().containsAll(annos));
	}

	@Test
	public void testAddSAnnotation() {
		String QName = "ns::name";
		SAnnotation anno = SaltFactory.createSAnnotation();
		anno.setQName(QName);
		this.getFixture().addSAnnotation(anno);
		assertEquals(anno, this.getFixture().getAnnotation(QName));
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
	public void testCreateSAnnotation() {
		String name = "name";
		String namespace = "namespace";
		String value = "value";
		SAnnotation anno = this.getFixture().createAnnotation(namespace, name, value);
		assertEquals(1, this.getFixture().getAnnotations().size());
		assertTrue(this.getFixture().getAnnotations().contains(anno));
		assertEquals(anno, this.getFixture().getAnnotation(SaltUtil.createQName(namespace, name)));
	}
	
	/**
	 * Tests whether the container and the label are double chained.
	 */
	public void testDoubleChaining() {
		SAnnotation anno = SaltFactory.createSAnnotation();
		anno.setName("labelName");
		this.getFixture().addLabel(anno);

		assertEquals(this.getFixture(), anno.getContainer());
	}

	// ========================= end: testing SAnnotatableElement
}
