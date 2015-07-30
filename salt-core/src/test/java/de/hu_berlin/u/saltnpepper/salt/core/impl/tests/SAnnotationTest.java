package de.hu_berlin.u.saltnpepper.salt.core.impl.tests;

import org.junit.Before;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;

public class SAnnotationTest extends SAbstractAnnotationTest{

	@Before
	@Override
	public void setUp() throws Exception {
		setFixture(SaltFactory.createSAnnotation());
	}

}
