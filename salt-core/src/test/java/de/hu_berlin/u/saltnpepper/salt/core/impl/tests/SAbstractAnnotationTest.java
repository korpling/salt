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
package de.hu_berlin.u.saltnpepper.salt.core.impl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.junit.Test;

import de.hu_berlin.u.saltnpepper.salt.SDATATYPE;
import de.hu_berlin.u.saltnpepper.salt.core.SAbstractAnnotation;

public abstract class SAbstractAnnotationTest extends SAnnotationContainerTest {
	
	public SAbstractAnnotation getFixture() {
		return (SAbstractAnnotation)fixture;
	}
	public void setFixture(SAbstractAnnotation fixture) {
		this.fixture = fixture;
	}
	
	@Test
	public void testGetSValueSNUMERIC() {
		Long value = 1L;
		String name = "numeric";

		getFixture().setQName(name);

		// case 1
		getFixture().setValue(value);
		assertEquals(value, getFixture().getValue_SNUMERIC());

		// case2
		value = null;
		getFixture().setValue(value);
		assertEquals(value, getFixture().getValue_SNUMERIC());

		// case 3
		int intVal = 1;
		getFixture().setValue(intVal);
		assertTrue(intVal == getFixture().getValue_SNUMERIC());

		// case3
		File file = new File("");
		getFixture().setValue(file);
		assertNull(getFixture().getValue_SNUMERIC());
	}

	@Test
	public void testGetSValueSFLOAT() {
		Double value = 1.0;
		String name = "float";

		getFixture().setQName(name);
		getFixture().setValue(value);
		assertEquals(value, getFixture().getValue_SFLOAT());

		// setting float
		Float floatVal = 1.0F;
		getFixture().setQName(name);
		getFixture().setValue(floatVal);
		assertEquals(value, getFixture().getValue_SFLOAT());

		// case2
		value = null;
		getFixture().setValue(value);
		assertEquals(value, getFixture().getValue_SFLOAT());

		// case3
		File file = new File("");
		getFixture().setValue(file);
		assertNull(getFixture().getValue_SFLOAT());
	}

	@Test
	public void testGetSValueSTEXT() {
		String value = "Text";
		String name = "Text";

		getFixture().setQName(name);
		getFixture().setValue(value);
		assertEquals(value, getFixture().getValue_STEXT());

		// case 2
		value = null;
		getFixture().setValue(value);
		assertEquals(value, getFixture().getValue_STEXT());
	}
	
	@Test
	public void testGetSValueSBOOLEAN() {
		Boolean value = true;
		String name = "Text";

		getFixture().setQName(name);
		getFixture().setValue(value);
		assertEquals(value, getFixture().getValue_SBOOLEAN());

		// case 2
		value = null;
		getFixture().setValue(value);
		assertEquals(value, getFixture().getValue_SBOOLEAN());

		// case3
		File file = new File("");
		getFixture().setValue(file);
		assertNull(getFixture().getValue_SBOOLEAN());
	}

	@Test
	public void testGetSValueSOBJECT() {
		Object value = new Object();
		String name = "Object";

		getFixture().setQName(name);
		getFixture().setValue(value);
		assertEquals(value, getFixture().getValue_SOBJECT());

		// not an object
		value = "hello";
		getFixture().setValue(value);
		assertEquals(value, getFixture().getValue_SOBJECT());

		// not an object
		value = 1l;
		getFixture().setValue(value);
		assertEquals(value, getFixture().getValue_SOBJECT());

		// case 2
		value = null;
		getFixture().setValue(value);
		assertEquals(value, getFixture().getValue_SOBJECT());
	}

	@Test
	public void testGetSValueSURI() {
		URI value = null;
		String name = "URI";

		getFixture().setQName(name);
		getFixture().setValue(value);
		assertEquals(value, getFixture().getValue_SURI());
	}

	@Test
	public void testGetSValueType_SBOOLEAN() {
		SDATATYPE dataType = null;

		dataType = SDATATYPE.SBOOLEAN;
		getFixture().setValue(true);
		assertEquals(dataType, getFixture().getValueType());
	}

	@Test
	public void testGetSValueType_STEXT() {
		SDATATYPE dataType = null;

		dataType = SDATATYPE.STEXT;
		getFixture().setValue("String");
		assertEquals(dataType, getFixture().getValueType());
	}

	@Test
	public void testGetSValueType_SNUMERIC() {
		SDATATYPE dataType = null;

		dataType = SDATATYPE.SNUMERIC;
		getFixture().setValue(1);

		dataType = SDATATYPE.SNUMERIC;
		getFixture().setValue(1l);
		assertEquals(dataType, getFixture().getValueType());
	}

	@Test
	public void testGetSValueType_SFLOAT() {
		SDATATYPE dataType = null;

		dataType = SDATATYPE.SFLOAT;
		getFixture().setValue(1.0F);
		assertEquals(dataType, getFixture().getValueType());

		dataType = SDATATYPE.SFLOAT;
		getFixture().setValue(1.0);
		assertEquals(dataType, getFixture().getValueType());
	}

	@Test
	public void testGetSValueType_SURI() {
		SDATATYPE dataType = null;

		dataType = SDATATYPE.SURI;
		getFixture().setValue(URI.createFileURI("."));
		assertEquals(dataType, getFixture().getValueType());
	}

	@Test
	public void testGetSValueType_SOBJECT() {
		SDATATYPE dataType = null;

		dataType = SDATATYPE.SOBJECT;
		getFixture().setValue(new Object());
		assertEquals(dataType, getFixture().getValueType());
	}

	@Test
	public void testGetSValueType() {
		this.testGetSValueType_SBOOLEAN();
		this.testGetSValueType_SFLOAT();
		this.testGetSValueType_SNUMERIC();
		this.testGetSValueType_SOBJECT();
		this.testGetSValueType_STEXT();
		this.testGetSValueType_SURI();
	}

	/**
	 * tests user created failure
	 */
	@Test
	public void testGetSValueType2() {
		SDATATYPE dataType = null;

		dataType = SDATATYPE.SURI;
		getFixture().setValue(URI.createFileURI(""));
		getFixture().setValueType(null);
		assertEquals(dataType, getFixture().getValueType());
	}
} // SAbstractAnnotationTest
