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

import static org.junit.Assert.*;
import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSequentialRelation;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltWrongParameterException;

public abstract class SSequentialRelationTest<S extends SNode, T extends SNode, P> extends SRelationAbstractTest{

	protected SSequentialRelation<S, T, P> getFixture() {
		return (SSequentialRelation<S, T, P>)fixture;
	}

	/** Tests whether the start value is set and returned correct. **/
	@Test
	public abstract void testSetGetStart();

	/** Tests whether the end value is set and returned correct. **/
	@Test
	public abstract void testSetGetEnd();
} // SSequentialDSTest
