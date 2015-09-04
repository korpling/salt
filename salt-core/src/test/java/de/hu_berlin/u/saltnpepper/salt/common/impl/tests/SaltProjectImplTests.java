package de.hu_berlin.u.saltnpepper.salt.common.impl.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.common.SaltProject;

public class SaltProjectImplTests {

	private SaltProject fixture= null;
	
	public SaltProject getFixture() {
		return fixture;
	}

	public void setFixture(SaltProject fixture) {
		this.fixture = fixture;
	}

	@Before
	public void setUp() throws Exception {
		setFixture(SaltFactory.createSaltProject());
	}

	@Test
	public void testSetGetName() {
		assertNull(getFixture().getName());
		String name="myProject";
		getFixture().setName(name);
		assertEquals(name, getFixture().getName());
	}

}
