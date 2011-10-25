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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.tests;

import java.io.File;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAbstractAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>SAbstract Annotation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAbstractAnnotation#getSNS() <em>SNS</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAbstractAnnotation#getSName() <em>SName</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAbstractAnnotation#getSValue() <em>SValue</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAbstractAnnotation#getSValueType() <em>SValue Type</em>}</li>
 * </ul>
 * </p>
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAbstractAnnotation#getSValueSTEXT() <em>Get SValue STEXT</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAbstractAnnotation#getSValueSBOOLEAN() <em>Get SValue SBOOLEAN</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAbstractAnnotation#getSValueSNUMERIC() <em>Get SValue SNUMERIC</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAbstractAnnotation#getSValueSFLOAT() <em>Get SValue SFLOAT</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAbstractAnnotation#getSValueSURI() <em>Get SValue SURI</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAbstractAnnotation#getSValueSOBJECT() <em>Get SValue SOBJECT</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public abstract class SAbstractAnnotationTest extends TestCase {

	/**
	 * The fixture for this SAbstract Annotation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SAbstractAnnotation fixture = null;

	/**
	 * Constructs a new SAbstract Annotation test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SAbstractAnnotationTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this SAbstract Annotation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(SAbstractAnnotation fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this SAbstract Annotation test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SAbstractAnnotation getFixture() {
		return fixture;
	}

	/**
	 * Tests the '{@link de.corpling.salt.model.saltCore.SAnnotation#getSValueSNumber() <em>Get Value SNumber</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.saltCore.SAnnotation#getSValueSNumber()
	 */
	public void testGetSValueSNUMERIC() 
	{
		Long value= 1L;
		String name= "numeric";
		
		this.getFixture().setQName(name);
		
		//case 1
		this.getFixture().setSValue(value);
		assertEquals(value, this.getFixture().getSValueSNUMERIC());
		
		//case2
		value= null;
		this.getFixture().setSValue(value);
		assertEquals(value, this.getFixture().getSValueSNUMERIC());
		
		//case 3
		int intVal= 1;
		this.getFixture().setSValue(intVal);
		assertTrue(intVal== this.getFixture().getSValueSNUMERIC());
		
		//case3
		File file= new File(""); 
		this.getFixture().setSValue(file);
		assertNull(this.getFixture().getSValueSNUMERIC());
	}

	/**
	 * Tests the '{@link de.corpling.salt.model.saltCore.SAnnotation#getSValueSReal() <em>Get Value SReal</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.saltCore.SAnnotation#getSValueSReal()
	 */
	public void testGetSValueSFLOAT() 
	{
		Double value= 1.0;
		String name= "float";
		
		this.getFixture().setQName(name);
		this.getFixture().setSValue(value);
		assertEquals(value, this.getFixture().getSValueSFLOAT());
		
		//setting float
		Float floatVal= 1.0F;
		this.getFixture().setQName(name);
		this.getFixture().setSValue(floatVal);
		assertEquals(value, this.getFixture().getSValueSFLOAT());
		
		//case2
		value= null;
		this.getFixture().setSValue(value);
		assertEquals(value, this.getFixture().getSValueSFLOAT());
		
		//case3
		File file= new File(""); 
		this.getFixture().setSValue(file);
		assertNull(this.getFixture().getSValueSFLOAT());
	}

	/**
	 * Tests the '{@link de.corpling.salt.model.saltCore.SAnnotation#getSValueSText() <em>Get Value SText</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.saltCore.SAnnotation#getSValueSText()
	 */
	public void testGetSValueSTEXT() 
	{
		String value= "Text";
		String name= "Text";
		
		this.getFixture().setQName(name);
		this.getFixture().setSValue(value);
		assertEquals(value, this.getFixture().getSValueSTEXT());
		
		//case 2
		value= null;
		this.getFixture().setSValue(value);
		assertEquals(value, this.getFixture().getSValueSTEXT());
	}
	
	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAbstractAnnotation#getSValueSBOOLEAN() <em>Get SValue SBOOLEAN</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAbstractAnnotation#getSValueSBOOLEAN()
	 */
	public void testGetSValueSBOOLEAN() 
	{
		Boolean value= true;
		String name= "Text";
		
		this.getFixture().setQName(name);
		this.getFixture().setSValue(value);
		assertEquals(value, this.getFixture().getSValueSBOOLEAN());
		
		//case 2
		value= null;
		this.getFixture().setSValue(value);
		assertEquals(value, this.getFixture().getSValueSBOOLEAN());
		
		//case3
		File file= new File(""); 
		this.getFixture().setSValue(file);
		assertNull(this.getFixture().getSValueSBOOLEAN());
	}

	/**
	 * Tests the '{@link de.corpling.salt.model.saltCore.SAnnotation#getSValueSOBJECT() <em>Get Value SObject</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.saltCore.SAnnotation#getSValueSOBJECT()
	 */
	public void testGetSValueSOBJECT() 
	{
		Object value= new Object();
		String name= "Object";
		
		this.getFixture().setQName(name);
		this.getFixture().setSValue(value);
		assertEquals(value, this.getFixture().getSValueSOBJECT());
		
		//not an object 
		value= "hello";
		this.getFixture().setSValue(value);
		assertEquals(value, this.getFixture().getSValueSOBJECT());
		
		//not an object 
		value= 1l;
		this.getFixture().setSValue(value);
		assertEquals(value, this.getFixture().getSValueSOBJECT());
		
		//case 2
		value= null;
		this.getFixture().setSValue(value);
		assertEquals(value, this.getFixture().getSValueSOBJECT());
	}	

	/**
	 * Tests the '{@link de.corpling.salt.model.saltCore.SAnnotation#getValueSURI() <em>Get Value SURI</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.saltCore.SAnnotation#getValueSURI()
	 */
	public void testGetSValueSURI() 
	{
		URI value= null;
		String name= "URI";
		
		this.getFixture().setQName(name);
		this.getFixture().setSValue(value);
		assertEquals(value, this.getFixture().getSValueSURI());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation#getSName() <em>SName</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation#getSName()
	 */
	public void testGetSName() 
	{
		assertNull(this.getFixture().getSName());
		
		String name= "name";
		this.getFixture().setSName(name);
		assertEquals(name, this.getFixture().getSName());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation#setSName(java.lang.String) <em>SName</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation#setSName(java.lang.String)
	 */
	public void testSetSName() 
	{
		this.testGetSName();
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation#getSValue() <em>SValue</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation#getSValue()
	 */
	public void testGetSValue() 
	{
		assertNull(this.getFixture().getSValue());
		
		String value= "value";
		this.getFixture().setSValue(value);
		assertEquals(value, this.getFixture().getSValue());
		
		Object valueObj= new Object();
		this.getFixture().setSValue(valueObj);
		assertEquals(valueObj, this.getFixture().getSValue());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation#setSValue(java.lang.Object) <em>SValue</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation#setSValue(java.lang.Object)
	 */
	public void testSetSValue() 
	{
		this.testGetSValue();
	}

	

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAbstractAnnotation#getSValueType() <em>SValue Type</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAbstractAnnotation#getSValueType()
	 */
	public void testGetSValueType() 
	{
		SDATATYPE dataType= null;
				
		dataType= SDATATYPE.SBOOLEAN;
		this.getFixture().setSValue(true);
		assertEquals(dataType, this.getFixture().getSValueType());
		
		dataType= SDATATYPE.STEXT;
		this.getFixture().setSValue("String");
		assertEquals(dataType, this.getFixture().getSValueType());
		
		dataType= SDATATYPE.SNUMERIC;
		this.getFixture().setSValue(1);
		
		dataType= SDATATYPE.SNUMERIC;
		this.getFixture().setSValue(1l);
		assertEquals(dataType, this.getFixture().getSValueType());
		
		dataType= SDATATYPE.SFLOAT;
		this.getFixture().setSValue(1.0F);
		assertEquals(dataType, this.getFixture().getSValueType());
		
		dataType= SDATATYPE.SFLOAT;
		this.getFixture().setSValue(1.0);
		assertEquals(dataType, this.getFixture().getSValueType());
		
		dataType= SDATATYPE.SURI;
		this.getFixture().setSValue(URI.createFileURI(""));
		assertEquals(dataType, this.getFixture().getSValueType());
		
		dataType= SDATATYPE.SOBJECT;
		this.getFixture().setSValue(new Object());
		assertEquals(dataType, this.getFixture().getSValueType());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAbstractAnnotation#setSValueType(de.hub.corpling.salt.saltCore.SDATATYPES) <em>SValue Type</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAbstractAnnotation#setSValueType(de.hub.corpling.salt.saltCore.SDATATYPES)
	 */
	public void testSetSValueType() 
	{
		this.testGetSValueType();
	}
	

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation#getSNS() <em>SNS</em>}' feature getter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation#getSNS()
	 */
	public void testGetSNS() 
	{

		assertNull(this.getFixture().getSNS());
		
		String ns= "namespace";
		this.getFixture().setSNS(ns);
		assertEquals(ns, this.getFixture().getSNS());
	}

	/**
	 * Tests the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation#setSNS(java.lang.String) <em>SNS</em>}' feature setter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation#setSNS(java.lang.String)
	 */
	public void testSetSNS() 
	{
		this.testGetSNS();
	}
} //SAbstractAnnotationTest
