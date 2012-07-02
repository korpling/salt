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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonPackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.impl.SaltCommonPackageImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusStructureFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage;






import org.eclipse.emf.ecore.EAttribute;
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
public class SCorpusStructurePackageImpl extends EPackageImpl implements SCorpusStructurePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sCorpusGraphEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sDocumentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sCorpusEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sCorpusRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sCorpusDocumentRelationEClass = null;

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
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SCorpusStructurePackageImpl() {
		super(eNS_URI, SCorpusStructureFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SCorpusStructurePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SCorpusStructurePackage init() {
		if (isInited) return (SCorpusStructurePackage)EPackage.Registry.INSTANCE.getEPackage(SCorpusStructurePackage.eNS_URI);

		// Obtain or create and register package
		SCorpusStructurePackageImpl theSCorpusStructurePackage = (SCorpusStructurePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SCorpusStructurePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SCorpusStructurePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		SaltCorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		SaltCommonPackageImpl theSaltCommonPackage = (SaltCommonPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SaltCommonPackage.eNS_URI) instanceof SaltCommonPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SaltCommonPackage.eNS_URI) : SaltCommonPackage.eINSTANCE);
		SDocumentStructurePackageImpl theSDocumentStructurePackage = (SDocumentStructurePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SDocumentStructurePackage.eNS_URI) instanceof SDocumentStructurePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SDocumentStructurePackage.eNS_URI) : SDocumentStructurePackage.eINSTANCE);

		// Create package meta-data objects
		theSCorpusStructurePackage.createPackageContents();
		theSaltCommonPackage.createPackageContents();
		theSDocumentStructurePackage.createPackageContents();

		// Initialize created meta-data
		theSCorpusStructurePackage.initializePackageContents();
		theSaltCommonPackage.initializePackageContents();
		theSDocumentStructurePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSCorpusStructurePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SCorpusStructurePackage.eNS_URI, theSCorpusStructurePackage);
		return theSCorpusStructurePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCorpusGraph() {
		return sCorpusGraphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCorpusGraph_SDocuments() {
		return (EReference)sCorpusGraphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCorpusGraph_SaltProject() {
		return (EReference)sCorpusGraphEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCorpusGraph_SCorpora() {
		return (EReference)sCorpusGraphEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCorpusGraph_SCorpusRelations() {
		return (EReference)sCorpusGraphEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCorpusGraph_SCorpusDocumentRelations() {
		return (EReference)sCorpusGraphEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSDocument() {
		return sDocumentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDocument_SCorpusGraph() {
		return (EReference)sDocumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDocument_SDocumentGraph() {
		return (EReference)sDocumentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSDocument_SDocumentGraphLocation() {
		return (EAttribute)sDocumentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCorpus() {
		return sCorpusEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCorpus_SCorpusGraph() {
		return (EReference)sCorpusEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCorpusRelation() {
		return sCorpusRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCorpusRelation_SSuperCorpus() {
		return (EReference)sCorpusRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCorpusRelation_SSubCorpus() {
		return (EReference)sCorpusRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCorpusRelation_SCorpusGraph() {
		return (EReference)sCorpusRelationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCorpusDocumentRelation() {
		return sCorpusDocumentRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCorpusDocumentRelation_SCorpus() {
		return (EReference)sCorpusDocumentRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCorpusDocumentRelation_SDocument() {
		return (EReference)sCorpusDocumentRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCorpusDocumentRelation_SCorpusGraph() {
		return (EReference)sCorpusDocumentRelationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCorpusStructureFactory getSCorpusStructureFactory() {
		return (SCorpusStructureFactory)getEFactoryInstance();
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
		sCorpusGraphEClass = createEClass(SCORPUS_GRAPH);
		createEReference(sCorpusGraphEClass, SCORPUS_GRAPH__SDOCUMENTS);
		createEReference(sCorpusGraphEClass, SCORPUS_GRAPH__SALT_PROJECT);
		createEReference(sCorpusGraphEClass, SCORPUS_GRAPH__SCORPORA);
		createEReference(sCorpusGraphEClass, SCORPUS_GRAPH__SCORPUS_RELATIONS);
		createEReference(sCorpusGraphEClass, SCORPUS_GRAPH__SCORPUS_DOCUMENT_RELATIONS);

		sDocumentEClass = createEClass(SDOCUMENT);
		createEReference(sDocumentEClass, SDOCUMENT__SCORPUS_GRAPH);
		createEReference(sDocumentEClass, SDOCUMENT__SDOCUMENT_GRAPH);
		createEAttribute(sDocumentEClass, SDOCUMENT__SDOCUMENT_GRAPH_LOCATION);

		sCorpusEClass = createEClass(SCORPUS);
		createEReference(sCorpusEClass, SCORPUS__SCORPUS_GRAPH);

		sCorpusRelationEClass = createEClass(SCORPUS_RELATION);
		createEReference(sCorpusRelationEClass, SCORPUS_RELATION__SSUPER_CORPUS);
		createEReference(sCorpusRelationEClass, SCORPUS_RELATION__SSUB_CORPUS);
		createEReference(sCorpusRelationEClass, SCORPUS_RELATION__SCORPUS_GRAPH);

		sCorpusDocumentRelationEClass = createEClass(SCORPUS_DOCUMENT_RELATION);
		createEReference(sCorpusDocumentRelationEClass, SCORPUS_DOCUMENT_RELATION__SCORPUS);
		createEReference(sCorpusDocumentRelationEClass, SCORPUS_DOCUMENT_RELATION__SDOCUMENT);
		createEReference(sCorpusDocumentRelationEClass, SCORPUS_DOCUMENT_RELATION__SCORPUS_GRAPH);
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
		SaltCorePackage theSaltCorePackage = (SaltCorePackage)EPackage.Registry.INSTANCE.getEPackage(SaltCorePackage.eNS_URI);
		SaltCommonPackage theSaltCommonPackage = (SaltCommonPackage)EPackage.Registry.INSTANCE.getEPackage(SaltCommonPackage.eNS_URI);
		SDocumentStructurePackage theSDocumentStructurePackage = (SDocumentStructurePackage)EPackage.Registry.INSTANCE.getEPackage(SDocumentStructurePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		sCorpusGraphEClass.getESuperTypes().add(theSaltCorePackage.getSGraph());
		sDocumentEClass.getESuperTypes().add(theSaltCorePackage.getSNode());
		sCorpusEClass.getESuperTypes().add(theSaltCorePackage.getSNode());
		sCorpusRelationEClass.getESuperTypes().add(theSaltCorePackage.getSRelation());
		sCorpusDocumentRelationEClass.getESuperTypes().add(theSaltCorePackage.getSRelation());

		// Initialize classes and features; add operations and parameters
		initEClass(sCorpusGraphEClass, SCorpusGraph.class, "SCorpusGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSCorpusGraph_SDocuments(), this.getSDocument(), this.getSDocument_SCorpusGraph(), "sDocuments", null, 0, -1, SCorpusGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSCorpusGraph_SaltProject(), theSaltCommonPackage.getSaltProject(), theSaltCommonPackage.getSaltProject_SCorpusGraphs(), "saltProject", null, 0, 1, SCorpusGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSCorpusGraph_SCorpora(), this.getSCorpus(), this.getSCorpus_SCorpusGraph(), "sCorpora", null, 0, -1, SCorpusGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSCorpusGraph_SCorpusRelations(), this.getSCorpusRelation(), this.getSCorpusRelation_SCorpusGraph(), "sCorpusRelations", null, 0, -1, SCorpusGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSCorpusGraph_SCorpusDocumentRelations(), this.getSCorpusDocumentRelation(), this.getSCorpusDocumentRelation_SCorpusGraph(), "sCorpusDocumentRelations", null, 0, -1, SCorpusGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(sCorpusGraphEClass, this.getSCorpus(), "getSCorpus", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getSElementId(), "sCorpusId", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sCorpusGraphEClass, this.getSDocument(), "getSDocument", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getSElementId(), "sDocumentId", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sCorpusGraphEClass, theSaltCorePackage.getSElementId(), "addSSubCorpus", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSCorpus(), "sSuperCorpus", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSCorpus(), "sSubCorpus", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sCorpusGraphEClass, theSaltCorePackage.getSElementId(), "addSDocument", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSCorpus(), "sCorpus", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSDocument(), "sDocument", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sCorpusGraphEClass, this.getSCorpus(), "getSCorpus", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSDocument(), "sDocument", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(sCorpusGraphEClass, this.getSCorpus(), "getSRootCorpus", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sCorpusGraphEClass, null, "load", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getURI(), "sCorpusGraphUri", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sDocumentEClass, SDocument.class, "SDocument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSDocument_SCorpusGraph(), this.getSCorpusGraph(), this.getSCorpusGraph_SDocuments(), "sCorpusGraph", null, 0, 1, SDocument.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSDocument_SDocumentGraph(), theSDocumentStructurePackage.getSDocumentGraph(), theSDocumentStructurePackage.getSDocumentGraph_SDocument(), "sDocumentGraph", null, 0, 1, SDocument.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getSDocument_SDocumentGraphLocation(), theSaltCorePackage.getURI(), "SDocumentGraphLocation", null, 0, 1, SDocument.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		op = addEOperation(sDocumentEClass, null, "saveSDocumentGraph", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getURI(), "sDocumentGraphLocation", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(sDocumentEClass, null, "loadSDocumentGraph", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sDocumentEClass, null, "loadSDocumentGraph", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getURI(), "sDocumentGraphLocation", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sCorpusEClass, SCorpus.class, "SCorpus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSCorpus_SCorpusGraph(), this.getSCorpusGraph(), this.getSCorpusGraph_SCorpora(), "sCorpusGraph", null, 0, 1, SCorpus.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sCorpusRelationEClass, SCorpusRelation.class, "SCorpusRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSCorpusRelation_SSuperCorpus(), this.getSCorpus(), null, "sSuperCorpus", null, 0, 1, SCorpusRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSCorpusRelation_SSubCorpus(), this.getSCorpus(), null, "sSubCorpus", null, 0, 1, SCorpusRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSCorpusRelation_SCorpusGraph(), this.getSCorpusGraph(), this.getSCorpusGraph_SCorpusRelations(), "sCorpusGraph", null, 0, 1, SCorpusRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sCorpusDocumentRelationEClass, SCorpusDocumentRelation.class, "SCorpusDocumentRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSCorpusDocumentRelation_SCorpus(), this.getSCorpus(), null, "sCorpus", null, 0, 1, SCorpusDocumentRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSCorpusDocumentRelation_SDocument(), this.getSDocument(), null, "sDocument", null, 0, 1, SCorpusDocumentRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSCorpusDocumentRelation_SCorpusGraph(), this.getSCorpusGraph(), this.getSCorpusGraph_SCorpusDocumentRelations(), "sCorpusGraph", null, 0, 1, SCorpusDocumentRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
	}

} //SCorpusStructurePackageImpl
