package de.hu_berlin.german.korpling.saltnpepper.salt.graph.tests;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.impl.EDataTypeImpl;
import org.junit.Before;
import org.junit.Test;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphFactoryImpl;

public class GraphFactoryImplTest extends TestCase{
	private GraphFactoryImpl fixture= null;

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
	}
}
