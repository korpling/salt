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
package org.corpus_tools.salt.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.corpus_tools.salt.SALT_TYPE;
import org.corpus_tools.salt.common.SDominanceRelation;
import org.corpus_tools.salt.common.SOrderRelation;
import org.corpus_tools.salt.common.SPointingRelation;
import org.corpus_tools.salt.common.SSpan;
import org.corpus_tools.salt.common.SSpanningRelation;
import org.corpus_tools.salt.common.SStructure;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.common.impl.SSpanImpl;
import org.corpus_tools.salt.common.impl.SStructureImpl;
import org.corpus_tools.salt.common.impl.STokenImpl;
import org.junit.Before;
import org.junit.Test;

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
