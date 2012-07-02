/**
 * Copyright 2009 Humboldt University of Berlin, INRIA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.impl;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonPackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltProject;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusStructurePackageImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage;






import java.util.Properties;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
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
public class SaltCommonPackageImpl extends EPackageImpl implements SaltCommonPackage {
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
	private EEnum sfeaturE_NAMEEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType propertiesEDataType = null;

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
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonPackage#eNS_URI
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
	public EAttribute getSaltProject_SName() {
		return (EAttribute)saltProjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSFEATURE_NAME() {
		return sfeaturE_NAMEEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getProperties() {
		return propertiesEDataType;
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
		createEAttribute(saltProjectEClass, SALT_PROJECT__SNAME);

		// Create enums
		sfeaturE_NAMEEEnum = createEEnum(SFEATURE_NAME);

		// Create data types
		propertiesEDataType = createEDataType(PROPERTIES);
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
		SaltCorePackage theSaltCorePackage = (SaltCorePackage)EPackage.Registry.INSTANCE.getEPackage(SaltCorePackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theSCorpusStructurePackage);
		getESubpackages().add(theSDocumentStructurePackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(saltProjectEClass, SaltProject.class, "SaltProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSaltProject_SCorpusGraphs(), theSCorpusStructurePackage.getSCorpusGraph(), theSCorpusStructurePackage.getSCorpusGraph_SaltProject(), "sCorpusGraphs", null, 0, -1, SaltProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSaltProject_SName(), ecorePackage.getEString(), "sName", null, 0, 1, SaltProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(saltProjectEClass, null, "loadSaltProject", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getURI(), "saltProjectURI", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(saltProjectEClass, null, "loadSaltProject_GrAF", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getURI(), "saltProjectUri", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getProperties(), "properties", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(saltProjectEClass, ecorePackage.getEString(), "differences", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "obj", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(saltProjectEClass, ecorePackage.getEMap(), "loadSCorpusGraph_GrAF", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getURI(), "sCorpusGraphURI", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getProperties(), "properties", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(saltProjectEClass, null, "loadSDocumentGraph_GrAF", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getURI(), "sDocumentGraphURI", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSCorpusStructurePackage.getSDocument(), "sDocument", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getProperties(), "properties", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(saltProjectEClass, null, "saveSCorpusGraph_DOT", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getURI(), "uri", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getSElementId(), "sElementID", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(saltProjectEClass, null, "saveSaltProject", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getURI(), "saltProjectURI", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(saltProjectEClass, null, "saveSaltProject_DOT", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getURI(), "uri", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(saltProjectEClass, null, "saveSDocumentGraph_DOT", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getURI(), "uri", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getSElementId(), "sElementID", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(saltProjectEClass, null, "loadSCorpusStructure", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getURI(), "saltProjectURI", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(saltProjectEClass, null, "getSDocumentGraphLocations", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(theSaltCorePackage.getSElementId());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(theSaltCorePackage.getURI());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		// Initialize enums and add enum literals
		initEEnum(sfeaturE_NAMEEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SFEATURE_NAME.class, "SFEATURE_NAME");
		addEEnumLiteral(sfeaturE_NAMEEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SFEATURE_NAME.SDOCUMENT_GRAPH_LOCATION);
		addEEnumLiteral(sfeaturE_NAMEEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SFEATURE_NAME.SDOCUMENT_GRAPH);
		addEEnumLiteral(sfeaturE_NAMEEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SFEATURE_NAME.SDOCUMENT);

		// Initialize data types
		initEDataType(propertiesEDataType, Properties.class, "Properties", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //SaltCommonPackageImpl
