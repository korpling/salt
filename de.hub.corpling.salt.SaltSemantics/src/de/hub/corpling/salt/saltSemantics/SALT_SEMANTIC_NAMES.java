/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltSemantics;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>SALT SEMANTIC NAMES</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.hub.corpling.salt.saltSemantics.SaltSemanticsPackage#getSALT_SEMANTIC_NAMES()
 * @model
 * @generated
 */
public enum SALT_SEMANTIC_NAMES implements Enumerator {
	/**
	 * The '<em><b>POS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #POS_VALUE
	 * @generated
	 * @ordered
	 */
	POS(0, "POS", "POS"),

	/**
	 * The '<em><b>LEMMA</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LEMMA_VALUE
	 * @generated
	 * @ordered
	 */
	LEMMA(1, "LEMMA", "LEMMA"), /**
	 * The '<em><b>CAT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CAT_VALUE
	 * @generated
	 * @ordered
	 */
	CAT(2, "CAT", "CAT"), /**
	 * The '<em><b>TYPE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TYPE_VALUE
	 * @generated
	 * @ordered
	 */
	TYPE(3, "TYPE", "TYPE"), /**
	 * The '<em><b>TEXT UNIT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TEXT_UNIT_VALUE
	 * @generated
	 * @ordered
	 */
	TEXT_UNIT(4, "TEXT_UNIT", "TEXT_UNIT"), /**
	 * The '<em><b>TEXT UNIT WORD</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TEXT_UNIT_WORD_VALUE
	 * @generated
	 * @ordered
	 */
	TEXT_UNIT_WORD(5, "TEXT_UNIT_WORD", "TEXT_UNIT_WORD"), /**
	 * The '<em><b>TEXT UNIT SENTENCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TEXT_UNIT_SENTENCE_VALUE
	 * @generated
	 * @ordered
	 */
	TEXT_UNIT_SENTENCE(6, "TEXT_UNIT_SENTENCE", "TEXT_UNIT_SENTENCE");

	/**
	 * The '<em><b>POS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>POS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #POS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int POS_VALUE = 0;

	/**
	 * The '<em><b>LEMMA</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>LEMMA</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LEMMA
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int LEMMA_VALUE = 1;

	/**
	 * The '<em><b>CAT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CAT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CAT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CAT_VALUE = 2;

	/**
	 * The '<em><b>TYPE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TYPE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TYPE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TYPE_VALUE = 3;

	/**
	 * The '<em><b>TEXT UNIT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TEXT UNIT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TEXT_UNIT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TEXT_UNIT_VALUE = 4;

	/**
	 * The '<em><b>TEXT UNIT WORD</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TEXT UNIT WORD</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TEXT_UNIT_WORD
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TEXT_UNIT_WORD_VALUE = 5;

	/**
	 * The '<em><b>TEXT UNIT SENTENCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TEXT UNIT SENTENCE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TEXT_UNIT_SENTENCE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TEXT_UNIT_SENTENCE_VALUE = 6;

	/**
	 * An array of all the '<em><b>SALT SEMANTIC NAMES</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SALT_SEMANTIC_NAMES[] VALUES_ARRAY =
		new SALT_SEMANTIC_NAMES[] {
			POS,
			LEMMA,
			CAT,
			TYPE,
			TEXT_UNIT,
			TEXT_UNIT_WORD,
			TEXT_UNIT_SENTENCE,
		};

	/**
	 * A public read-only list of all the '<em><b>SALT SEMANTIC NAMES</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<SALT_SEMANTIC_NAMES> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>SALT SEMANTIC NAMES</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SALT_SEMANTIC_NAMES get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SALT_SEMANTIC_NAMES result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>SALT SEMANTIC NAMES</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SALT_SEMANTIC_NAMES getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SALT_SEMANTIC_NAMES result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>SALT SEMANTIC NAMES</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SALT_SEMANTIC_NAMES get(int value) {
		switch (value) {
			case POS_VALUE: return POS;
			case LEMMA_VALUE: return LEMMA;
			case CAT_VALUE: return CAT;
			case TYPE_VALUE: return TYPE;
			case TEXT_UNIT_VALUE: return TEXT_UNIT;
			case TEXT_UNIT_WORD_VALUE: return TEXT_UNIT_WORD;
			case TEXT_UNIT_SENTENCE_VALUE: return TEXT_UNIT_SENTENCE;
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
	private SALT_SEMANTIC_NAMES(int value, String name, String literal) {
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
	
} //SALT_SEMANTIC_NAMES
