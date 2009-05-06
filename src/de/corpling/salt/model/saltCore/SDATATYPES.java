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
 * A representation of the literals of the enumeration '<em><b>SDATATYPES</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSDATATYPES()
 * @model
 * @generated
 */
public enum SDATATYPES implements Enumerator {
	/**
	 * The '<em><b>SNUMBER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SNUMBER_VALUE
	 * @generated
	 * @ordered
	 */
	SNUMBER(0, "SNUMBER", "SNUMBER"),

	/**
	 * The '<em><b>SREAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SREAL_VALUE
	 * @generated
	 * @ordered
	 */
	SREAL(1, "SREAL", "SREAL"),

	/**
	 * The '<em><b>STEXT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STEXT_VALUE
	 * @generated
	 * @ordered
	 */
	STEXT(2, "STEXT", "STEXT"),

	/**
	 * The '<em><b>SURI</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SURI_VALUE
	 * @generated
	 * @ordered
	 */
	SURI(3, "SURI", "SURI"),

	/**
	 * The '<em><b>SOBJECT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOBJECT_VALUE
	 * @generated
	 * @ordered
	 */
	SOBJECT(4, "SOBJECT", "SOBJECT");

	/**
	 * The '<em><b>SNUMBER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SNUMBER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SNUMBER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SNUMBER_VALUE = 0;

	/**
	 * The '<em><b>SREAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SREAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SREAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int SREAL_VALUE = 1;

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
	public static final int STEXT_VALUE = 2;

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
	public static final int SURI_VALUE = 3;

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
	public static final int SOBJECT_VALUE = 4;

	/**
	 * An array of all the '<em><b>SDATATYPES</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SDATATYPES[] VALUES_ARRAY =
		new SDATATYPES[] {
			SNUMBER,
			SREAL,
			STEXT,
			SURI,
			SOBJECT,
		};

	/**
	 * A public read-only list of all the '<em><b>SDATATYPES</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<SDATATYPES> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>SDATATYPES</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SDATATYPES get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SDATATYPES result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>SDATATYPES</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SDATATYPES getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SDATATYPES result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>SDATATYPES</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SDATATYPES get(int value) {
		switch (value) {
			case SNUMBER_VALUE: return SNUMBER;
			case SREAL_VALUE: return SREAL;
			case STEXT_VALUE: return STEXT;
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
	private SDATATYPES(int value, String name, String literal) {
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
	
} //SDATATYPES
