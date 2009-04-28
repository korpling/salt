/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.saltFW;

import de.corpling.salt.model.salt.SDocument;
import de.corpling.salt.model.salt.SStructure;
import de.corpling.salt.model.salt.STextualDataSource;
import de.corpling.salt.model.salt.SToken;
import de.corpling.salt.model.saltCore.SElement;

import de.util.graph.TraversalObject;
import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Accessor Module</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see de.corpling.salt.saltFW.SaltFWPackage#getSaltAccessorModule()
 * @model
 * @generated
 */
public interface SaltAccessorModule extends SaltModule, TraversalObject {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<SToken> getTokenByPos(SDocument sDocument);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String getOverlapedText(SElement sElement);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	STextualDataSource getSTextualDataSource(SElement sElement);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Long getSLeftPos(SElement sElement);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	Long getSRightPos(SElement sElement);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean isContinuous(SElement sElement);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<SToken> getDominancedTokens(SStructure sStructure);
} // SaltAccessorModule
