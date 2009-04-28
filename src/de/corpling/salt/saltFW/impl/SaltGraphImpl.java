/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.saltFW.impl;

import de.corpling.salt.model.salt.SaltPackage;
import de.corpling.salt.model.salt.impl.SCorpusGraphImpl;

import de.corpling.salt.saltFW.SaltFWPackage;
import de.corpling.salt.saltFW.SaltGraph;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SaltGraphImpl extends SCorpusGraphImpl implements SaltGraph {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SaltGraphImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltFWPackage.Literals.SALT_GRAPH;
	}

} //SaltGraphImpl
