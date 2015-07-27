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
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotatableElement;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotation;

public abstract class SAnnotatableElementTest {

	protected SAnnotatableElement fixture = null;

	public SAnnotatableElement getFixture() {
		return fixture;
	}

	public void setFixture(SAnnotatableElement fixture) {
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
		System.out.println("---> all annos: "+ this.getFixture().getAnnotations());
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
	 * Tests whether the extraction of an annotations string works quite well.
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
	 * Tests whether the container and the label are double chained.
	 */
	public void testDoubleChaining() {
		SAnnotation anno = SaltFactory.createSAnnotation();
		anno.setName("labelName");
		this.getFixture().addLabel(anno);
		
		assertEquals(this.getFixture(), anno.getContainer());
	}

}
