/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.saltFW.impl;

import de.corpling.salt.model.salt.SaltFactory;
import de.corpling.salt.model.salt.impl.SaltFactoryImpl;
import de.corpling.salt.model.saltCore.SStereotype;
import de.corpling.salt.model.saltCore.SaltCoreFactory;
import de.corpling.salt.saltFW.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated NOT
 */
public class SaltFWFactoryImpl extends SaltFactoryImpl implements SaltFWFactory 
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SaltFWFactory init() {
		try {
			SaltFWFactory theSaltFWFactory = (SaltFWFactory)EPackage.Registry.INSTANCE.getEFactory("www.corpling.de/saltFW"); 
			if (theSaltFWFactory != null) {
				return theSaltFWFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SaltFWFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltFWFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SaltFWPackage.SALT_PROJECT: return createSaltProject();
			case SaltFWPackage.SALT_GRAPH: return createSaltGraph();
			case SaltFWPackage.SALT_MODULE: return createSaltModule();
			case SaltFWPackage.SALT_ACCESSOR_MODULE: return createSaltAccessorModule();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SaltProject createSaltProject() 
	{
		SaltProjectImpl saltProject = new SaltProjectImpl();
		
		//setting of stereotypes, same procedure as in SProject
		for (SStereotype sStereotype: SaltFactory.eINSTANCE.getPredefinedStereotypes())
			saltProject.getSStereotypes().add(sStereotype);
		
		//accessor module
		SaltAccessorModule module= this.createSaltAccessorModule();
		saltProject.getSModules().add(module);
		
		
		return saltProject;
		
//		//old
//		SaltProjectImpl saltProject = new SaltProjectImpl();
//		return saltProject;
		
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltGraph createSaltGraph() {
		SaltGraphImpl saltGraph = new SaltGraphImpl();
		return saltGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltModule createSaltModule() {
		SaltModuleImpl saltModule = new SaltModuleImpl();
		return saltModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltAccessorModule createSaltAccessorModule() {
		SaltAccessorModuleImpl saltAccessorModule = new SaltAccessorModuleImpl();
		return saltAccessorModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltFWPackage getSaltFWPackage() {
		return (SaltFWPackage)getEPackage();
	}

//	/**
//	 * <!-- begin-user-doc -->
//	 * <!-- end-user-doc -->
//	 * @deprecated
//	 * @generated
//	 */
//	@Deprecated
//	public static SaltFWPackage getPackage() {
//		return SaltFWPackage.eINSTANCE;
//	}

} //SaltFWFactoryImpl
