/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.saltFW.impl;

import de.corpling.salt.model.salt.SaltPackage;

import de.corpling.salt.model.salt.impl.SaltPackageImpl;

import de.corpling.salt.model.saltCore.SaltCorePackage;

import de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl;

import de.corpling.salt.saltFW.SaltAccessorModule;
import de.corpling.salt.saltFW.SaltFWFactory;
import de.corpling.salt.saltFW.SaltFWPackage;
import de.corpling.salt.saltFW.SaltGraph;
import de.corpling.salt.saltFW.SaltModule;
import de.corpling.salt.saltFW.SaltProject;

import de.util.graph.GraphPackage;

import de.util.graph.impl.GraphPackageImpl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SaltFWPackageImpl extends EPackageImpl implements SaltFWPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass saltProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass saltGraphEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass saltModuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass saltAccessorModuleEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.corpling.salt.saltFW.SaltFWPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SaltFWPackageImpl() {
		super(eNS_URI, SaltFWFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SaltFWPackage init() {
		if (isInited) return (SaltFWPackage)EPackage.Registry.INSTANCE.getEPackage(SaltFWPackage.eNS_URI);

		// Obtain or create and register package
		SaltFWPackageImpl theSaltFWPackage = (SaltFWPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof SaltFWPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new SaltFWPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		SaltPackageImpl theSaltPackage = (SaltPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SaltPackage.eNS_URI) instanceof SaltPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SaltPackage.eNS_URI) : SaltPackage.eINSTANCE);
		SaltCorePackageImpl theSaltCorePackage = (SaltCorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SaltCorePackage.eNS_URI) instanceof SaltCorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SaltCorePackage.eNS_URI) : SaltCorePackage.eINSTANCE);
		GraphPackageImpl theGraphPackage = (GraphPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI) instanceof GraphPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI) : GraphPackage.eINSTANCE);

		// Create package meta-data objects
		theSaltFWPackage.createPackageContents();
		theSaltPackage.createPackageContents();
		theSaltCorePackage.createPackageContents();
		theGraphPackage.createPackageContents();

		// Initialize created meta-data
		theSaltFWPackage.initializePackageContents();
		theSaltPackage.initializePackageContents();
		theSaltCorePackage.initializePackageContents();
		theGraphPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSaltFWPackage.freeze();

		return theSaltFWPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSaltProject() {
		return saltProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSaltProject_SaltGraphs() {
		return (EReference)saltProjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSaltProject_SModules() {
		return (EReference)saltProjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSaltGraph() {
		return saltGraphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSaltModule() {
		return saltModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSaltModule_SaltProject() {
		return (EReference)saltModuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSaltAccessorModule() {
		return saltAccessorModuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltFWFactory getSaltFWFactory() {
		return (SaltFWFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		saltProjectEClass = createEClass(SALT_PROJECT);
		createEReference(saltProjectEClass, SALT_PROJECT__SALT_GRAPHS);
		createEReference(saltProjectEClass, SALT_PROJECT__SMODULES);

		saltGraphEClass = createEClass(SALT_GRAPH);

		saltModuleEClass = createEClass(SALT_MODULE);
		createEReference(saltModuleEClass, SALT_MODULE__SALT_PROJECT);

		saltAccessorModuleEClass = createEClass(SALT_ACCESSOR_MODULE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		SaltPackage theSaltPackage = (SaltPackage)EPackage.Registry.INSTANCE.getEPackage(SaltPackage.eNS_URI);
		SaltCorePackage theSaltCorePackage = (SaltCorePackage)EPackage.Registry.INSTANCE.getEPackage(SaltCorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		saltProjectEClass.getESuperTypes().add(theSaltPackage.getSProject());
		saltGraphEClass.getESuperTypes().add(theSaltPackage.getSCorpusGraph());
		saltAccessorModuleEClass.getESuperTypes().add(this.getSaltModule());
		saltAccessorModuleEClass.getESuperTypes().add(theSaltCorePackage.getSTraversalObject());

		// Initialize classes and features; add operations and parameters
		initEClass(saltProjectEClass, SaltProject.class, "SaltProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSaltProject_SaltGraphs(), this.getSaltGraph(), null, "saltGraphs", null, 0, -1, SaltProject.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSaltProject_SModules(), this.getSaltModule(), this.getSaltModule_SaltProject(), "sModules", null, 0, -1, SaltProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(saltGraphEClass, SaltGraph.class, "SaltGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(saltModuleEClass, SaltModule.class, "SaltModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSaltModule_SaltProject(), this.getSaltProject(), this.getSaltProject_SModules(), "saltProject", null, 0, 1, SaltModule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(saltAccessorModuleEClass, SaltAccessorModule.class, "SaltAccessorModule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(saltAccessorModuleEClass, theSaltPackage.getSToken(), "getTokenByPos", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltPackage.getSDocument(), "sDocument", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(saltAccessorModuleEClass, ecorePackage.getEString(), "getOverlapedText", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getSElement(), "sElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(saltAccessorModuleEClass, theSaltPackage.getSTextualDataSource(), "getSTextualDataSource", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getSElement(), "sElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(saltAccessorModuleEClass, ecorePackage.getELongObject(), "getSLeftPos", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getSElement(), "sElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(saltAccessorModuleEClass, ecorePackage.getELongObject(), "getSRightPos", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getSElement(), "sElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(saltAccessorModuleEClass, ecorePackage.getEBoolean(), "isContinuous", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getSElement(), "sElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(saltAccessorModuleEClass, theSaltPackage.getSToken(), "getDominancedTokens", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltPackage.getSStructure(), "sStructure", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(saltAccessorModuleEClass, theSaltCorePackage.getSElement(), "getCorpusPathAsList", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getSElement(), "sElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //SaltFWPackageImpl
