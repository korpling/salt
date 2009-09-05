/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.impl;

import de.hub.corpling.salt.saltCommon.SaltCommonFactory;
import de.hub.corpling.salt.saltCommon.SaltCommonPackage;
import de.hub.corpling.salt.saltCommon.SaltProject;

import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage;

import de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusStructurePackageImpl;

import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;

import de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl;

import de.hub.corpling.salt.saltCore.SaltCorePackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SaltCommonPackageImpl extends EPackageImpl implements SaltCommonPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass saltProjectEClass = null;

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
	 * @see de.hub.corpling.salt.saltCommon.SaltCommonPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SaltCommonPackageImpl() {
		super(eNS_URI, SaltCommonFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link SaltCommonPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SaltCommonPackage init() {
		if (isInited) return (SaltCommonPackage)EPackage.Registry.INSTANCE.getEPackage(SaltCommonPackage.eNS_URI);

		// Obtain or create and register package
		SaltCommonPackageImpl theSaltCommonPackage = (SaltCommonPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SaltCommonPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SaltCommonPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		SaltCorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		SCorpusStructurePackageImpl theSCorpusStructurePackage = (SCorpusStructurePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SCorpusStructurePackage.eNS_URI) instanceof SCorpusStructurePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SCorpusStructurePackage.eNS_URI) : SCorpusStructurePackage.eINSTANCE);
		SDocumentStructurePackageImpl theSDocumentStructurePackage = (SDocumentStructurePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SDocumentStructurePackage.eNS_URI) instanceof SDocumentStructurePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SDocumentStructurePackage.eNS_URI) : SDocumentStructurePackage.eINSTANCE);

		// Create package meta-data objects
		theSaltCommonPackage.createPackageContents();
		theSCorpusStructurePackage.createPackageContents();
		theSDocumentStructurePackage.createPackageContents();

		// Initialize created meta-data
		theSaltCommonPackage.initializePackageContents();
		theSCorpusStructurePackage.initializePackageContents();
		theSDocumentStructurePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSaltCommonPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SaltCommonPackage.eNS_URI, theSaltCommonPackage);
		return theSaltCommonPackage;
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
	public EReference getSaltProject_SCorpusGraphs() {
		return (EReference)saltProjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltCommonFactory getSaltCommonFactory() {
		return (SaltCommonFactory)getEFactoryInstance();
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
		createEReference(saltProjectEClass, SALT_PROJECT__SCORPUS_GRAPHS);
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
		SCorpusStructurePackage theSCorpusStructurePackage = (SCorpusStructurePackage)EPackage.Registry.INSTANCE.getEPackage(SCorpusStructurePackage.eNS_URI);
		SDocumentStructurePackage theSDocumentStructurePackage = (SDocumentStructurePackage)EPackage.Registry.INSTANCE.getEPackage(SDocumentStructurePackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theSCorpusStructurePackage);
		getESubpackages().add(theSDocumentStructurePackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(saltProjectEClass, SaltProject.class, "SaltProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSaltProject_SCorpusGraphs(), theSCorpusStructurePackage.getSCorpusGraph(), theSCorpusStructurePackage.getSCorpusGraph_SaltProject(), "sCorpusGraphs", null, 0, -1, SaltProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //SaltCommonPackageImpl
