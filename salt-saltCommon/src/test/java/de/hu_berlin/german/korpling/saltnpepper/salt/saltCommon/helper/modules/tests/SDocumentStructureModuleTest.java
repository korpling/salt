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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.helper.modules.tests;

import junit.framework.TestCase;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.helper.modules.SDocumentStructureModule;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;

public class SDocumentStructureModuleTest extends TestCase 
{
	private SDocumentStructureModule fixture= null;

	public void setFixture(SDocumentStructureModule fixture) {
		this.fixture = fixture;
	}

	public SDocumentStructureModule getFixture() {
		return fixture;
	} 
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception 
	{
		setFixture(new SDocumentStructureModule());
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}
	
	/**
	 * Tests setting and getting the {@link SDocumentGraph} object.
	 */
	public void testGetGraph() 
	{
		SDocumentGraph sDocGraph= SaltCommonFactory.eINSTANCE.createSDocumentGraph();
		this.getFixture().setSDocumentGraph(sDocGraph);
		assertEquals(sDocGraph, this.getFixture().getSDocumentGraph());
	}
}
