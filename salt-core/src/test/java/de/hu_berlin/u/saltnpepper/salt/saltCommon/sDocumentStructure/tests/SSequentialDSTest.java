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
package de.hu_berlin.u.saltnpepper.salt.saltCommon.sDocumentStructure.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSequentialDS;

public abstract class SSequentialDSTest<D, P> {

	protected SSequentialDS<D, P> fixture = null;

	protected void setFixture(SSequentialDS<D, P> fixture) {
		this.fixture = fixture;
	}

	protected SSequentialDS<D, P> getFixture() {
		return fixture;
	}

	/**
	 * This method tests whether the set data value is also returned again.
	 */
	@Test
	public abstract void testSetGetData();

	/**
	 * This method tests whether the set start value is also returned again.
	 */
	@Test
	public abstract void testGetStart();

	/**
	 * This method tests whether the set start value is also returned again.
	 */
	@Test
	public abstract void testGetEnd();
	
	/** Tests whether returned graph is of type {@link SDocumentGraph}. **/
	@Test
	public void testGetGraph(){
		getFixture().setGraph(SaltFactory.createSDocumentGraph());
		assertTrue(getFixture().getGraph() instanceof SDocumentGraph);
	}
} // SSequentialDSTest
