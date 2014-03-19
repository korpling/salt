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
package de.hu_berlin.german.korpling.saltnpepper.salt.graph;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * Types, which can be used for traversing a graph, these types have two parts, first the direction and second
 * the order of edges to be processed first. For instance the value {@link #TOP_DOWN_DEPTH_FIRST} contains of the
 * direction TOP_DOWN, which means, that a traversal follows the direction of the edges and DEPTH_FIRST means, that
 * first the subgraph of the target of an edge will be traversed, before the next edge of the same parent node will
 * be traversed. 
 * @author Florian Zipser
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage#getGRAPH_TRAVERSE_TYPE()
 * @model
 * @generated
 */
public enum GRAPH_TRAVERSE_TYPE implements Enumerator {
	/**
	 * The '<em><b>TOP DOWN DEPTH FIRST</b></em>' literal object.
	 * Follows the direction of edges and first tarverses a subgraph, before the next edge of a node is traversed.
	 * @see #TOP_DOWN_DEPTH_FIRST_VALUE
	 * @generated
	 * @ordered
	 */
	TOP_DOWN_DEPTH_FIRST(0, "TOP_DOWN_DEPTH_FIRST", "TOP_DOWN_DEPTH_FIRST"),

	/**
	 * The '<em><b>TOP DOWN BREADTH FIRST</b></em>' literal object.
	 * Follows the direction of edges and first tarverses all edges of a node, before the subgraph is traversed.
	 * @see #TOP_DOWN_BREADTH_FIRST_VALUE
	 * @generated
	 * @ordered
	 */
	TOP_DOWN_BREADTH_FIRST(1, "TOP_DOWN_BREADTH_FIRST", "TOP_DOWN_BREADTH_FIRST"),

	/**
	 * The '<em><b>BOTTOM UP DEPTH FIRST</b></em>' literal object.
	 * Traverses in opposite to the direction of edges the direction of edges and first tarverses a subgraph, before the next edge of a node is traversed.
	 * @see #BOTTOM_UP_DEPTH_FIRST_VALUE
	 * @generated
	 * @ordered
	 */
	BOTTOM_UP_DEPTH_FIRST(2, "BOTTOM_UP_DEPTH_FIRST", "BOTTOM_UP_DEPTH_FIRST"),

	/**
	 * The '<em><b>BOTTOM UP BREADTH FIRST</b></em>' literal object.
	 * Traverses in opposite to the direction of edges the direction of edges and first tarverses all edges of a node, before the subgraph is traversed.
	 * @see #BOTTOM_UP_BREADTH_FIRST_VALUE
	 * @generated
	 * @ordered
	 */
	BOTTOM_UP_BREADTH_FIRST(3, "BOTTOM_UP_BREADTH_FIRST", "BOTTOM_UP_BREADTH_FIRST");

	/**
	 * The '<em><b>TOP DOWN DEPTH FIRST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TOP DOWN DEPTH FIRST</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TOP_DOWN_DEPTH_FIRST
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TOP_DOWN_DEPTH_FIRST_VALUE = 0;

	/**
	 * The '<em><b>TOP DOWN BREADTH FIRST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TOP DOWN BREADTH FIRST</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TOP_DOWN_BREADTH_FIRST
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TOP_DOWN_BREADTH_FIRST_VALUE = 1;

	/**
	 * The '<em><b>BOTTOM UP DEPTH FIRST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BOTTOM UP DEPTH FIRST</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOTTOM_UP_DEPTH_FIRST
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BOTTOM_UP_DEPTH_FIRST_VALUE = 2;

	/**
	 * The '<em><b>BOTTOM UP BREADTH FIRST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BOTTOM UP BREADTH FIRST</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOTTOM_UP_BREADTH_FIRST
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BOTTOM_UP_BREADTH_FIRST_VALUE = 3;

	/**
	 * An array of all the '<em><b>GRAPH TRAVERSE TYPE</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final GRAPH_TRAVERSE_TYPE[] VALUES_ARRAY =
		new GRAPH_TRAVERSE_TYPE[] {
			TOP_DOWN_DEPTH_FIRST,
			TOP_DOWN_BREADTH_FIRST,
			BOTTOM_UP_DEPTH_FIRST,
			BOTTOM_UP_BREADTH_FIRST,
		};

	/**
	 * A public read-only list of all the '<em><b>GRAPH TRAVERSE TYPE</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<GRAPH_TRAVERSE_TYPE> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>GRAPH TRAVERSE TYPE</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GRAPH_TRAVERSE_TYPE get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GRAPH_TRAVERSE_TYPE result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>GRAPH TRAVERSE TYPE</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GRAPH_TRAVERSE_TYPE getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			GRAPH_TRAVERSE_TYPE result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>GRAPH TRAVERSE TYPE</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GRAPH_TRAVERSE_TYPE get(int value) {
		switch (value) {
			case TOP_DOWN_DEPTH_FIRST_VALUE: return TOP_DOWN_DEPTH_FIRST;
			case TOP_DOWN_BREADTH_FIRST_VALUE: return TOP_DOWN_BREADTH_FIRST;
			case BOTTOM_UP_DEPTH_FIRST_VALUE: return BOTTOM_UP_DEPTH_FIRST;
			case BOTTOM_UP_BREADTH_FIRST_VALUE: return BOTTOM_UP_BREADTH_FIRST;
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
	private GRAPH_TRAVERSE_TYPE(int value, String name, String literal) {
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
	
} //GRAPH_TRAVERSE_TYPE
