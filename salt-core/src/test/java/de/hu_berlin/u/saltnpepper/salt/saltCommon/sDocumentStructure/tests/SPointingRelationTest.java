package de.hu_berlin.u.saltnpepper.salt.saltCommon.sDocumentStructure.tests;

import org.junit.Before;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;

public class SPointingRelationTest extends SRelationAbstractTest {

	@Before
	public void setUp() throws Exception {
		setFixture(SaltFactory.createSPointingRelation());
	}

}
