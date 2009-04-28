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
 * A representation of the literals of the enumeration '<em><b>SELEMENT TYPE</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.corpling.salt.model.saltCore.SaltCorePackage#getSELEMENT_TYPE()
 * @model
 * @generated
 */
public enum SELEMENT_TYPE implements Enumerator {
	/**
	 * The '<em><b>CORPUS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CORPUS_VALUE
	 * @generated
	 * @ordered
	 */
	CORPUS(0, "CORPUS", "CORPUS"),

	/**
	 * The '<em><b>DOCUMENT</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DOCUMENT_VALUE
	 * @generated
	 * @ordered
	 */
	DOCUMENT(1, "DOCUMENT", "DOCUMENT"),

	/**
	 * The '<em><b>DATASOURCE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DATASOURCE_VALUE
	 * @generated
	 * @ordered
	 */
	DATASOURCE(2, "DATASOURCE", "DATASOURCE"),

	/**
	 * The '<em><b>TOKEN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TOKEN_VALUE
	 * @generated
	 * @ordered
	 */
	TOKEN(3, "TOKEN", "TOKEN"),

	/**
	 * The '<em><b>STRUCTURE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STRUCTURE_VALUE
	 * @generated
	 * @ordered
	 */
	STRUCTURE(4, "STRUCTURE", "STRUCTURE"),

	/**
	 * The '<em><b>ANNOTATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ANNOTATION_VALUE
	 * @generated
	 * @ordered
	 */
	ANNOTATION(5, "ANNOTATION", "ANNOTATION");

	/**
	 * The '<em><b>CORPUS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>CORPUS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CORPUS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int CORPUS_VALUE = 0;

	/**
	 * The '<em><b>DOCUMENT</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DOCUMENT</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DOCUMENT
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DOCUMENT_VALUE = 1;

	/**
	 * The '<em><b>DATASOURCE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DATASOURCE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DATASOURCE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int DATASOURCE_VALUE = 2;

	/**
	 * The '<em><b>TOKEN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>TOKEN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #TOKEN
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int TOKEN_VALUE = 3;

	/**
	 * The '<em><b>STRUCTURE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STRUCTURE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STRUCTURE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int STRUCTURE_VALUE = 4;

	/**
	 * The '<em><b>ANNOTATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ANNOTATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ANNOTATION
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ANNOTATION_VALUE = 5;

	/**
	 * An array of all the '<em><b>SELEMENT TYPE</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final SELEMENT_TYPE[] VALUES_ARRAY =
		new SELEMENT_TYPE[] {
			CORPUS,
			DOCUMENT,
			DATASOURCE,
			TOKEN,
			STRUCTURE,
			ANNOTATION,
		};

	/**
	 * A public read-only list of all the '<em><b>SELEMENT TYPE</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<SELEMENT_TYPE> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>SELEMENT TYPE</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SELEMENT_TYPE get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SELEMENT_TYPE result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>SELEMENT TYPE</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SELEMENT_TYPE getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			SELEMENT_TYPE result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>SELEMENT TYPE</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SELEMENT_TYPE get(int value) {
		switch (value) {
			case CORPUS_VALUE: return CORPUS;
			case DOCUMENT_VALUE: return DOCUMENT;
			case DATASOURCE_VALUE: return DATASOURCE;
			case TOKEN_VALUE: return TOKEN;
			case STRUCTURE_VALUE: return STRUCTURE;
			case ANNOTATION_VALUE: return ANNOTATION;
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
	private SELEMENT_TYPE(int value, String name, String literal) {
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
	
} //SELEMENT_TYPE
