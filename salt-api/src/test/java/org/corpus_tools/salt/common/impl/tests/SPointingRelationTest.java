package org.corpus_tools.salt.common.impl.tests;

import org.corpus_tools.salt.SaltFactory;
import org.junit.Before;

public class SPointingRelationTest extends SRelationAbstractTest {

	@Before
	public void setUp() throws Exception {
		setFixture(SaltFactory.createSPointingRelation());
	}

}
