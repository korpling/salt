package de.hu_berlin.u.saltnpepper.salt.util.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDominanceRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SOrderRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SPointingRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSpan;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSpanningRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SStructure;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SToken;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.impl.SSpanImpl;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.impl.SStructureImpl;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.impl.STokenImpl;
import de.hu_berlin.u.saltnpepper.salt.util.SALT_TYPE;

public class SALT_TYPE_Tests {

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Tests if the conversion works correctly
	 */
	@Test
	public void testConvertClazzToSTypeName() {
		assertTrue(SALT_TYPE.class2SaltType(SOrderRelation.class).contains(SALT_TYPE.SORDER_RELATION));
		assertTrue(SALT_TYPE.class2SaltType(SPointingRelation.class).contains(SALT_TYPE.SPOINTING_RELATION));
		assertTrue(SALT_TYPE.class2SaltType(SDominanceRelation.class).contains(SALT_TYPE.SDOMINANCE_RELATION));
		assertTrue(SALT_TYPE.class2SaltType(SSpanningRelation.class).contains(SALT_TYPE.SSPANNING_RELATION));

		assertFalse(SALT_TYPE.class2SaltType(SSpanningRelation.class).contains(SALT_TYPE.SDOMINANCE_RELATION));
		assertFalse(SALT_TYPE.class2SaltType(SDominanceRelation.class).contains(SALT_TYPE.SSPANNING_RELATION));

		assertTrue(SALT_TYPE.class2SaltType(SToken.class).contains(SALT_TYPE.STOKEN));
		assertTrue(SALT_TYPE.class2SaltType(SSpan.class).contains(SALT_TYPE.SSPAN));
		assertTrue(SALT_TYPE.class2SaltType(SStructure.class).contains(SALT_TYPE.SSTRUCTURE));

		assertTrue(SALT_TYPE.class2SaltType(STokenImpl.class).contains(SALT_TYPE.STOKEN));
		assertTrue(SALT_TYPE.class2SaltType(SSpanImpl.class).contains(SALT_TYPE.SSPAN));
		assertTrue(SALT_TYPE.class2SaltType(SStructureImpl.class).contains(SALT_TYPE.SSTRUCTURE));
	}
}
