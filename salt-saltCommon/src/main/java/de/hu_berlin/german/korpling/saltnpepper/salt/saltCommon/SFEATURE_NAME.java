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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>SFEATURE NAME</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonPackage#getSFEATURE_NAME()
 * @model
 * @generated
 */
public enum SFEATURE_NAME implements Enumerator {
	/**
	 * The '<em><b>SDOCUMENT GRAPH LOCATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SDOCUMENT_GRAPH_LOCATION_VALUE
	 * @generated
	 * @ordered
	 */
	SDOCUMENT_GRAPH_LOCATION(0, "SDOCUMENT_GRAPH_LOCATION", "SDOCUMENT_GRAPH_LOCATION");

	/**
	 * The '<em><b>SDOCUMENT GRAPH LOCATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SDOCUMENT GRAPH LOCATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SDOCUMENT_GRAPH_LOCATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SDOCUMENT_GRAPH_LOCATION_VALUE = 0;

	/**
	 * An array of all the '<em><b>SFEATURE NAME</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SFEATURE_NAME[] VALUES_ARRAY =
		new SFEATURE_NAME[] {
			SDOCUMENT_GRAPH_LOCATION,
		};

	/**
	 * A public read-only list of all the '<em><b>SFEATURE NAME</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<SFEATURE_NAME> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>SFEATURE NAME</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SFEATURE_NAME get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SFEATURE_NAME result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>SFEATURE NAME</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SFEATURE_NAME getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SFEATURE_NAME result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>SFEATURE NAME</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SFEATURE_NAME get(int value) {
		switch (value) {
			case SDOCUMENT_GRAPH_LOCATION_VALUE: return SDOCUMENT_GRAPH_LOCATION;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private SFEATURE_NAME(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //SFEATURE_NAME
