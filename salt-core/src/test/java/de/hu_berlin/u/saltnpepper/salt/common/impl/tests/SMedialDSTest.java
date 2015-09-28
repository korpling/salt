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
package de.hu_berlin.u.saltnpepper.salt.common.impl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.eclipse.emf.common.util.URI;
import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.common.SMedialDS;

public class SMedialDSTest extends SSequentialDSTest<URI, Double> {

	public SMedialDS getFixture() {
		return (SMedialDS) fixture;
	}

	@Before
	public void setUp() throws Exception {
		setFixture(SaltFactory.createSMedialDS());
	}

	/** {@inheritDoc} **/
	@Test
	@Override
	public void testSetGetData() {
		assertNull(getFixture().getData());

		URI data = URI.createURI("whatever");
		getFixture().setData(data);
		assertEquals(data, this.getFixture().getData());

		data = null;
		getFixture().setData(data);
		assertNull(getFixture().getData());
	}

	/** {@inheritDoc} **/
	@Test
	@Override
	public void testGetStart() {
		assertNull(getFixture().getStart());
		getFixture().setData(URI.createURI("whatever"));
		assertNull(getFixture().getStart());
	}

	/** {@inheritDoc} **/
	@Test
	@Override
	public void testGetEnd() {
		assertNull(getFixture().getEnd());
		getFixture().setData(URI.createURI("whatever"));
		assertNull(getFixture().getEnd());
	}

	/**
	 * Tests that the set media reference is returned again.
	 */
	@Test
	public void testSetGetMediaReference() {
		assertNull(getFixture().getMediaReference());

		URI anyUri = null;
		getFixture().setMediaReference(anyUri);
		assertEquals(anyUri, getFixture().getMediaReference());

		// relative uri (not existing)
		anyUri = URI.createFileURI("./somewhere");
		getFixture().setMediaReference(anyUri);
		assertEquals(anyUri, getFixture().getMediaReference());

		// absolute uri (not existing)
		anyUri = URI.createFileURI("/somewhere");
		getFixture().setMediaReference(anyUri);
		assertEquals(anyUri, getFixture().getMediaReference());
	}
} // SAudioDataSourceTest
