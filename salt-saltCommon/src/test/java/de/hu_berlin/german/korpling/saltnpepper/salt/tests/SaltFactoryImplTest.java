/**
 * Copyright 2009 Humboldt University of Berlin, INRIA.
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
package de.hu_berlin.german.korpling.saltnpepper.salt.tests;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import junit.framework.TestCase;

public class SaltFactoryImplTest extends TestCase 
{
	private SaltFactory fixture= null;

	public void setFixture(SaltFactory fixture) {
		this.fixture = fixture;
	}

	public SaltFactory getFixture() {
		return fixture;
	}
	
	@Override
	public void setUp()
	{
		this.setFixture(SaltFactory.eINSTANCE);
	}
	
	public void testLoadSaltProject()
	{
		
	}
	
}
