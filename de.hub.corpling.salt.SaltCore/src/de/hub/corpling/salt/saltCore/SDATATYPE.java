/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>SDATATYPE</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#getSDATATYPE()
 * @model
 * @generated
 */
public enum SDATATYPE implements Enumerator {
	/**
	 * The '<em><b>STEXT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STEXT_VALUE
	 * @generated
	 * @ordered
	 */
	STEXT(0, "STEXT", "STEXT"),

	/**
	 * The '<em><b>SBOOLEAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SBOOLEAN_VALUE
	 * @generated
	 * @ordered
	 */
	SBOOLEAN(1, "SBOOLEAN", "SBOOLEAN"),

	/**
	 * The '<em><b>SNUMERIC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SNUMERIC_VALUE
	 * @generated
	 * @ordered
	 */
	SNUMERIC(2, "SNUMERIC", "SNUMERIC"),

	/**
	 * The '<em><b>SFLOAT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SFLOAT_VALUE
	 * @generated
	 * @ordered
	 */
	SFLOAT(3, "SFLOAT", "SFLOAT"),

	/**
	 * The '<em><b>SURI</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SURI_VALUE
	 * @generated
	 * @ordered
	 */
	SURI(4, "SURI", "SURI"),

	/**
	 * The '<em><b>SOBJECT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	SOBJECT(5, "SOBJECT", "SOBJECT");

	/**
	 * The '<em><b>STEXT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STEXT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STEXT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STEXT_VALUE = 0;

	/**
	 * The '<em><b>SBOOLEAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SBOOLEAN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SBOOLEAN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SBOOLEAN_VALUE = 1;

	/**
	 * The '<em><b>SNUMERIC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SNUMERIC</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SNUMERIC
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SNUMERIC_VALUE = 2;

	/**
	 * The '<em><b>SFLOAT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SFLOAT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SFLOAT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SFLOAT_VALUE = 3;

	/**
	 * The '<em><b>SURI</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SURI</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SURI
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SURI_VALUE = 4;

	/**
	 * The '<em><b>SOBJECT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SOBJECT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SOBJECT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SOBJECT_VALUE = 5;

	/**
	 * An array of all the '<em><b>SDATATYPE</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SDATATYPE[] VALUES_ARRAY =
		new SDATATYPE[] {
			STEXT,
			SBOOLEAN,
			SNUMERIC,
			SFLOAT,
			SURI,
			SOBJECT,
		};

	/**
	 * A public read-only list of all the '<em><b>SDATATYPE</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<SDATATYPE> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>SDATATYPE</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SDATATYPE get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SDATATYPE result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>SDATATYPE</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SDATATYPE getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SDATATYPE result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>SDATATYPE</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SDATATYPE get(int value) {
		switch (value) {
			case STEXT_VALUE: return STEXT;
			case SBOOLEAN_VALUE: return SBOOLEAN;
			case SNUMERIC_VALUE: return SNUMERIC;
			case SFLOAT_VALUE: return SFLOAT;
			case SURI_VALUE: return SURI;
			case SOBJECT_VALUE: return SOBJECT;
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
	private SDATATYPE(int value, String name, String literal) {
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
	
} //SDATATYPE
