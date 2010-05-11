/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>STYPE NAME</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#getSTYPE_NAME()
 * @model
 * @generated
 */
public enum STYPE_NAME implements Enumerator {
	/**
	 * The '<em><b>STEXTUAL DS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STEXTUAL_DS_VALUE
	 * @generated
	 * @ordered
	 */
	STEXTUAL_DS(0, "STEXTUAL_DS", "STextualDS"),

	/**
	 * The '<em><b>STOKEN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STOKEN_VALUE
	 * @generated
	 * @ordered
	 */
	STOKEN(1, "STOKEN", "SToken"),

	/**
	 * The '<em><b>SSPAN</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SSPAN_VALUE
	 * @generated
	 * @ordered
	 */
	SSPAN(2, "SSPAN", "SSpan"),

	/**
	 * The '<em><b>SSTRUCTURE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SSTRUCTURE_VALUE
	 * @generated
	 * @ordered
	 */
	SSTRUCTURE(3, "SSTRUCTURE", "SStructure"),

	/**
	 * The '<em><b>STEXTUAL RELATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STEXTUAL_RELATION_VALUE
	 * @generated
	 * @ordered
	 */
	STEXTUAL_RELATION(4, "STEXTUAL_RELATION", "STextualRelation"),

	/**
	 * The '<em><b>SSPANNING RELATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SSPANNING_RELATION_VALUE
	 * @generated
	 * @ordered
	 */
	SSPANNING_RELATION(5, "SSPANNING_RELATION", "SSpanningRelation"),

	/**
	 * The '<em><b>SDOMINANCE RELATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SDOMINANCE_RELATION_VALUE
	 * @generated
	 * @ordered
	 */
	SDOMINANCE_RELATION(6, "SDOMINANCE_RELATION", "SDominanceRelation"), /**
	 * The '<em><b>SPOINTING RELATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPOINTING_RELATION_VALUE
	 * @generated
	 * @ordered
	 */
	SPOINTING_RELATION(7, "SPOINTING_RELATION", "SPointingRelation");

	/**
	 * The '<em><b>STEXTUAL DS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STEXTUAL DS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STEXTUAL_DS
	 * @model literal="STextualDS"
	 * @generated
	 * @ordered
	 */
	public static final int STEXTUAL_DS_VALUE = 0;

	/**
	 * The '<em><b>STOKEN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STOKEN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STOKEN
	 * @model literal="SToken"
	 * @generated
	 * @ordered
	 */
	public static final int STOKEN_VALUE = 1;

	/**
	 * The '<em><b>SSPAN</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SSPAN</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SSPAN
	 * @model literal="SSpan"
	 * @generated
	 * @ordered
	 */
	public static final int SSPAN_VALUE = 2;

	/**
	 * The '<em><b>SSTRUCTURE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SSTRUCTURE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SSTRUCTURE
	 * @model literal="SStructure"
	 * @generated
	 * @ordered
	 */
	public static final int SSTRUCTURE_VALUE = 3;

	/**
	 * The '<em><b>STEXTUAL RELATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>STEXTUAL RELATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STEXTUAL_RELATION
	 * @model literal="STextualRelation"
	 * @generated
	 * @ordered
	 */
	public static final int STEXTUAL_RELATION_VALUE = 4;

	/**
	 * The '<em><b>SSPANNING RELATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SSPANNING RELATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SSPANNING_RELATION
	 * @model literal="SSpanningRelation"
	 * @generated
	 * @ordered
	 */
	public static final int SSPANNING_RELATION_VALUE = 5;

	/**
	 * The '<em><b>SDOMINANCE RELATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SDOMINANCE RELATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SDOMINANCE_RELATION
	 * @model literal="SDominanceRelation"
	 * @generated
	 * @ordered
	 */
	public static final int SDOMINANCE_RELATION_VALUE = 6;

	/**
	 * The '<em><b>SPOINTING RELATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>SPOINTING RELATION</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SPOINTING_RELATION
	 * @model literal="SPointingRelation"
	 * @generated
	 * @ordered
	 */
	public static final int SPOINTING_RELATION_VALUE = 7;

	/**
	 * An array of all the '<em><b>STYPE NAME</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final STYPE_NAME[] VALUES_ARRAY =
		new STYPE_NAME[] {
			STEXTUAL_DS,
			STOKEN,
			SSPAN,
			SSTRUCTURE,
			STEXTUAL_RELATION,
			SSPANNING_RELATION,
			SDOMINANCE_RELATION,
			SPOINTING_RELATION,
		};

	/**
	 * A public read-only list of all the '<em><b>STYPE NAME</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<STYPE_NAME> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>STYPE NAME</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static STYPE_NAME get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			STYPE_NAME result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>STYPE NAME</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static STYPE_NAME getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			STYPE_NAME result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>STYPE NAME</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static STYPE_NAME get(int value) {
		switch (value) {
			case STEXTUAL_DS_VALUE: return STEXTUAL_DS;
			case STOKEN_VALUE: return STOKEN;
			case SSPAN_VALUE: return SSPAN;
			case SSTRUCTURE_VALUE: return SSTRUCTURE;
			case STEXTUAL_RELATION_VALUE: return STEXTUAL_RELATION;
			case SSPANNING_RELATION_VALUE: return SSPANNING_RELATION;
			case SDOMINANCE_RELATION_VALUE: return SDOMINANCE_RELATION;
			case SPOINTING_RELATION_VALUE: return SPOINTING_RELATION;
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
	private STYPE_NAME(int value, String name, String literal) {
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
	
} //STYPE_NAME
