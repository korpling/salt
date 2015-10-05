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
package de.hu_berlin.german.korpling.saltnpepper.salt.graph.tests;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.impl.EDataTypeImpl;
import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphFactoryImpl;
import java.io.Serializable;
import java.util.Objects;

public class GraphFactoryImplTest extends TestCase{
	private GraphFactoryImpl fixture= null;
	
	private final static String unknownObjectSerialization =
			"O::rO0ABXNyAGBkZS5odV9iZXJsaW4uZ2VybWFuLmtvcnBsaW5nLnNh"
			+ "bHRucGVwcGVyLnNhbHQuZ3JhcGgudGVzdHMuR3JhcGhGYWN0b3J5S"
			+ "W1wbFRlc3QkVW5rbm93blRlc3RPYmplY3T211MlAS44twIAAUkAAW"
			+ "N4cgBZZGUuaHVfYmVybGluLmdlcm1hbi5rb3JwbGluZy5zYWx0bnB"
			+ "lcHBlci5zYWx0LmdyYXBoLnRlc3RzLkdyYXBoRmFjdG9yeUltcGxU"
			+ "ZXN0JFRlc3RPYmplY3R4r50rUMulywIAA0kAAWJMAAFhdAASTGphd"
			+ "mEvbGFuZy9TdHJpbmc7TAAGbmVzdGVkdABbTGRlL2h1X2Jlcmxpbi"
			+ "9nZXJtYW4va29ycGxpbmcvc2FsdG5wZXBwZXIvc2FsdC9ncmFwaC9"
			+ "0ZXN0cy9HcmFwaEZhY3RvcnlJbXBsVGVzdCRUZXN0T2JqZWN0O3hw"
			+ "AAAAe3QAA2FiY3NxAH4AAQAAAch0AANkZWZwAAAAAQ==";

	public GraphFactoryImpl getFixture() {
		return fixture;
	}

	public void setFixture(GraphFactoryImpl fixture) {
		this.fixture = fixture;
	}
	
	@Before
	public void setUp(){
		setFixture(new GraphFactoryImpl());
	}
	
	class MyDataType extends EDataTypeImpl implements EDataType{
		public MyDataType(){
			super();
		}
	}
	/**
	 * Tests different objects if they can be serialized and deserialized by {@link GraphFactoryImpl} via
	 * methods {@link GraphFactoryImpl#convertObjectToString(org.eclipse.emf.ecore.EDataType, Object)} and
	 * {@link GraphFactoryImpl#createObjectFromString(org.eclipse.emf.ecore.EDataType, String)}.
	 * Tested is:
	 * <ul>
	 *   <li>null</li>
	 *   <li>String - latin text: hello</li>
	 *   <li>String - xml escape characters: <hello>\' & @\"</li>
	 *   <li>String - control characters: hello \n\f\t\r</li>
	 *   <li>String - utf-8: hello فأوصلت</li>
	 *   <li>Integer - 10</li>
	 *   <li>Long - 10</li>
	 *   <li>Float - 10.000001</li>
	 *   <li>URI - file://anyFile</li>
	 * </ul>
	 */
	@Test
	public void testStoreTest(){
		Object object= null;
		String result= null;
		EDataType eDataType= new MyDataType();
		eDataType.setName("Object");
		eDataType.setInstanceClass(Object.class);
		eDataType.setSerializable(true);
		eDataType.setInstanceClassName("Object");
		eDataType.setInstanceTypeName("Object");
		
		//null value
		result= getFixture().convertObjectToString(eDataType, object);
		assertNull(getFixture().createObjectFromString(null, result));
		
		//latin text
		object= "Hello";
		result= getFixture().convertObjectToString(eDataType, object);
		assertEquals(object, getFixture().createObjectFromString(null, result));
		
		//xml escape characters
		object= "<hello>\' & @\"";
		result= getFixture().convertObjectToString(eDataType, object);
		assertEquals(object, getFixture().createObjectFromString(null, result));
		
		//control characters
		object= "hello \n\f\t\r";
		result= getFixture().convertObjectToString(eDataType, object);
		assertEquals(object, getFixture().createObjectFromString(null, result));
		
		//utf-8
		object="hello فأوصلت";
		result= getFixture().convertObjectToString(eDataType, object);
		assertEquals(object, getFixture().createObjectFromString(null, result));
		
		//numeric
		object=new Integer(10);
		result= getFixture().convertObjectToString(eDataType, object);
		object=new Long(10);
		assertEquals(object, getFixture().createObjectFromString(null, result));
		
		//numeric
		object=new Long(10);
		result= getFixture().convertObjectToString(eDataType, object);
		assertEquals(object, getFixture().createObjectFromString(null, result));
		
		//float
		object=new Double(10.000001);
		result= getFixture().convertObjectToString(eDataType, object);
		object=new Float(10.000001);
		assertEquals(object, getFixture().createObjectFromString(null, result));
		
		//float
		object=new Float(10.000001);
		result= getFixture().convertObjectToString(eDataType, object);
		assertEquals(object, getFixture().createObjectFromString(null, result));
		
		//URI
		object=URI.createFileURI("/anyFile/");
		result= getFixture().convertObjectToString(eDataType, object);
		assertEquals(object, getFixture().createObjectFromString(null, result));
		
		// known object
		object = new TestObject("abc", 123, new TestObject("def", 456));
		result = getFixture().convertObjectToString(eDataType, object);
		assertEquals(object, getFixture().createObjectFromString(null, result));
		
		// unknown objects should be ignored
		assertEquals(null, getFixture().createObjectFromString(null, unknownObjectSerialization));
	}
	
	public static class TestObject implements Serializable
	{
		private String a;
		private int b;
		private TestObject nested;

		public TestObject(String a, int b)
		{
			this.a = a;
			this.b = b;
		}

		public TestObject(String a, int b, TestObject nested)
		{
			this.a = a;
			this.b = b;
			this.nested = nested;
		}

		@Override
		public int hashCode()
		{
			int hash = 5;
			hash = 29 * hash + Objects.hashCode(this.a);
			hash = 29 * hash + this.b;
			hash = 29 * hash + Objects.hashCode(this.nested);
			return hash;
		}

		@Override
		public boolean equals(Object obj)
		{
			if (obj == null)
			{
				return false;
			}
			if (getClass() != obj.getClass())
			{
				return false;
			}
			final TestObject other = (TestObject) obj;
			if (!Objects.equals(this.a, other.a))
			{
				return false;
			}
			if (this.b != other.b)
			{
				return false;
			}
			if (!Objects.equals(this.nested, other.nested))
			{
				return false;
			}
			return true;
		}
	}
}
