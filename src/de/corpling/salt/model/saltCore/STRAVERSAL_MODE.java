/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.saltCore;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>STRAVERSAL MODE</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSTRAVERSAL_MODE()
 * @model
 * @generated
 */
public enum STRAVERSAL_MODE implements Enumerator {
	/**
	 * The '<em><b>DEPTH FIRST</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEPTH_FIRST_VALUE
	 * @generated
	 * @ordered
	 */
	DEPTH_FIRST(0, "DEPTH_FIRST", "DEPTH_FIRST"),

	/**
	 * The '<em><b>BOTTOM UP</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BOTTOM_UP_VALUE
	 * @generated
	 * @ordered
	 */
	BOTTOM_UP(1, "BOTTOM_UP", "BOTTOM_UP");

	/**
	 * The '<em><b>DEPTH FIRST</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DEPTH FIRST</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DEPTH_FIRST
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DEPTH_FIRST_VALUE = 0;

	/**
	 * The '<em><b>BOTTOM UP</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BOTTOM UP</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BOTTOM_UP
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BOTTOM_UP_VALUE = 1;

	/**
	 * An array of all the '<em><b>STRAVERSAL MODE</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final STRAVERSAL_MODE[] VALUES_ARRAY =
		new STRAVERSAL_MODE[] {
			DEPTH_FIRST,
			BOTTOM_UP,
		};

	/**
	 * A public read-only list of all the '<em><b>STRAVERSAL MODE</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<STRAVERSAL_MODE> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>STRAVERSAL MODE</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static STRAVERSAL_MODE get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			STRAVERSAL_MODE result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>STRAVERSAL MODE</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static STRAVERSAL_MODE getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			STRAVERSAL_MODE result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>STRAVERSAL MODE</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static STRAVERSAL_MODE get(int value) {
		switch (value) {
			case DEPTH_FIRST_VALUE: return DEPTH_FIRST;
			case BOTTOM_UP_VALUE: return BOTTOM_UP;
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
	private STRAVERSAL_MODE(int value, String name, String literal) {
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
	
} //STRAVERSAL_MODE
