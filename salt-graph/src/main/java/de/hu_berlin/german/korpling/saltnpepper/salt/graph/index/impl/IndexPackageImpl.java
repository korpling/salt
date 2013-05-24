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
package de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.impl.GraphPackageImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.ComplexIndex;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.FatComplexIndex;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexPackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.SimpleIndex;



import de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.SlimComplexIndex;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class IndexPackageImpl extends EPackageImpl implements IndexPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass indexEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleIndexEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass indexMgrEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complexIndexEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fatComplexIndexEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass slimComplexIndexEClass = null;

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
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private IndexPackageImpl() {
		super(eNS_URI, IndexFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link IndexPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static IndexPackage init() {
		if (isInited) return (IndexPackage)EPackage.Registry.INSTANCE.getEPackage(IndexPackage.eNS_URI);

		// Obtain or create and register package
		IndexPackageImpl theIndexPackage = (IndexPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof IndexPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new IndexPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		GraphPackageImpl theGraphPackage = (GraphPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI) instanceof GraphPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI) : GraphPackage.eINSTANCE);

		// Create package meta-data objects
		theIndexPackage.createPackageContents();
		theGraphPackage.createPackageContents();

		// Initialize created meta-data
		theIndexPackage.initializePackageContents();
		theGraphPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theIndexPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(IndexPackage.eNS_URI, theIndexPackage);
		return theIndexPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIndex() {
		return indexEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndex_NumOfElements() {
		return (EAttribute)indexEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndex_NumOfElementIds() {
		return (EAttribute)indexEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndex_IndexMap() {
		return (EAttribute)indexEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndex_EstimatedCapacity() {
		return (EAttribute)indexEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleIndex() {
		return simpleIndexEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIndexMgr() {
		return indexMgrEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIndexMgr_Indexes() {
		return (EReference)indexMgrEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIndexMgr_NumOfIndexes() {
		return (EAttribute)indexMgrEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIndexMgr_Graph() {
		return (EReference)indexMgrEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComplexIndex() {
		return complexIndexEClass;
	}

	/**
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public EAttribute getComplexIndex_Sortable()
    {
		return (EAttribute)complexIndexEClass.getEStructuralFeatures().get(0);
	}

    /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFatComplexIndex() {
		return fatComplexIndexEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSlimComplexIndex() {
		return slimComplexIndexEClass;
	}

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IndexFactory getIndexFactory() {
		return (IndexFactory)getEFactoryInstance();
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
		indexEClass = createEClass(INDEX);
		createEAttribute(indexEClass, INDEX__NUM_OF_ELEMENTS);
		createEAttribute(indexEClass, INDEX__NUM_OF_ELEMENT_IDS);
		createEAttribute(indexEClass, INDEX__INDEX_MAP);
		createEAttribute(indexEClass, INDEX__ESTIMATED_CAPACITY);

		simpleIndexEClass = createEClass(SIMPLE_INDEX);

		indexMgrEClass = createEClass(INDEX_MGR);
		createEReference(indexMgrEClass, INDEX_MGR__INDEXES);
		createEAttribute(indexMgrEClass, INDEX_MGR__NUM_OF_INDEXES);
		createEReference(indexMgrEClass, INDEX_MGR__GRAPH);

		complexIndexEClass = createEClass(COMPLEX_INDEX);
		createEAttribute(complexIndexEClass, COMPLEX_INDEX__SORTABLE);

		fatComplexIndexEClass = createEClass(FAT_COMPLEX_INDEX);

		slimComplexIndexEClass = createEClass(SLIM_COMPLEX_INDEX);
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
		GraphPackage theGraphPackage = (GraphPackage)EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI);

		// Create type parameters
		ETypeParameter indexEClass_K = addETypeParameter(indexEClass, "K");
		ETypeParameter indexEClass_V = addETypeParameter(indexEClass, "V");
		ETypeParameter simpleIndexEClass_K = addETypeParameter(simpleIndexEClass, "K");
		ETypeParameter simpleIndexEClass_V = addETypeParameter(simpleIndexEClass, "V");
		ETypeParameter complexIndexEClass_K = addETypeParameter(complexIndexEClass, "K");
		ETypeParameter complexIndexEClass_V = addETypeParameter(complexIndexEClass, "V");
		ETypeParameter fatComplexIndexEClass_K = addETypeParameter(fatComplexIndexEClass, "K");
		ETypeParameter fatComplexIndexEClass_V = addETypeParameter(fatComplexIndexEClass, "V");
		ETypeParameter slimComplexIndexEClass_K = addETypeParameter(slimComplexIndexEClass, "K");
		ETypeParameter slimComplexIndexEClass_V = addETypeParameter(slimComplexIndexEClass, "V");

		// Set bounds for type parameters

		// Add supertypes to classes
		indexEClass.getESuperTypes().add(theGraphPackage.getIdentifiableElement());
		EGenericType g1 = createEGenericType(this.getIndex());
		EGenericType g2 = createEGenericType(simpleIndexEClass_K);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(simpleIndexEClass_V);
		g1.getETypeArguments().add(g2);
		simpleIndexEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getIndex());
		g2 = createEGenericType(complexIndexEClass_K);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(complexIndexEClass_V);
		g1.getETypeArguments().add(g2);
		complexIndexEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getComplexIndex());
		g2 = createEGenericType(fatComplexIndexEClass_K);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(fatComplexIndexEClass_V);
		g1.getETypeArguments().add(g2);
		fatComplexIndexEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getComplexIndex());
		g2 = createEGenericType(slimComplexIndexEClass_K);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(slimComplexIndexEClass_V);
		g1.getETypeArguments().add(g2);
		slimComplexIndexEClass.getEGenericSuperTypes().add(g1);

		// Initialize classes and features; add operations and parameters
		initEClass(indexEClass, Index.class, "Index", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIndex_NumOfElements(), ecorePackage.getELongObject(), "numOfElements", null, 0, 1, Index.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getIndex_NumOfElementIds(), ecorePackage.getELongObject(), "numOfElementIds", null, 0, 1, Index.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(indexEClass_K);
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(indexEClass_V);
		g1.getETypeArguments().add(g2);
		initEAttribute(getIndex_IndexMap(), g1, "indexMap", null, 0, 1, Index.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIndex_EstimatedCapacity(), ecorePackage.getEIntegerObject(), "estimatedCapacity", "10000", 0, 1, Index.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(indexEClass, null, "addElement", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(indexEClass_K);
		addEParameter(op, g1, "elementId", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(indexEClass_V);
		addEParameter(op, g1, "element", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(indexEClass, ecorePackage.getEBooleanObject(), "hasKey", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(indexEClass_K);
		addEParameter(op, g1, "elementId", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(indexEClass, ecorePackage.getEBooleanObject(), "removeElement", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(indexEClass_V);
		addEParameter(op, g1, "element", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(indexEClass, ecorePackage.getEBooleanObject(), "removeAll", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(simpleIndexEClass, SimpleIndex.class, "SimpleIndex", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(simpleIndexEClass, null, "getElement", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(simpleIndexEClass_K);
		addEParameter(op, g1, "elementId", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(simpleIndexEClass_V);
		initEOperation(op, g1);

		op = addEOperation(simpleIndexEClass, ecorePackage.getEBooleanObject(), "removeElementById", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(simpleIndexEClass_K);
		addEParameter(op, g1, "elementId", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(indexMgrEClass, IndexMgr.class, "IndexMgr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIndexMgr_Indexes(), this.getIndex(), null, "indexes", null, 0, -1, IndexMgr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIndexMgr_NumOfIndexes(), ecorePackage.getELongObject(), "numOfIndexes", null, 0, 1, IndexMgr.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getIndexMgr_Graph(), theGraphPackage.getGraph(), theGraphPackage.getGraph_IndexMgr(), "graph", null, 0, 1, IndexMgr.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(indexMgrEClass, null, "addIndex", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIndex(), "index", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(indexMgrEClass, ecorePackage.getEBooleanObject(), "hasIndex", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "indexId", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(indexMgrEClass, this.getIndex(), "getIndex", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "indexId", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(indexMgrEClass, ecorePackage.getEBooleanObject(), "removeIndex", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "indexId", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(indexMgrEClass, ecorePackage.getEBooleanObject(), "removeAll", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(indexMgrEClass, ecorePackage.getEBooleanObject(), "removeElement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "elementId", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(complexIndexEClass, ComplexIndex.class, "ComplexIndex", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getComplexIndex_Sortable(), ecorePackage.getEBoolean(), "sortable", "false", 0, 1, ComplexIndex.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(complexIndexEClass, ecorePackage.getEBooleanObject(), "hasSlot", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(complexIndexEClass_K);
		addEParameter(op, g1, "elementId", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(complexIndexEClass, null, "getSlot", 0, -1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(complexIndexEClass_K);
		addEParameter(op, g1, "elementId", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(complexIndexEClass_V);
		initEOperation(op, g1);

		op = addEOperation(complexIndexEClass, null, "getSlotIds", 0, -1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(complexIndexEClass_K);
		initEOperation(op, g1);

		op = addEOperation(complexIndexEClass, ecorePackage.getEBooleanObject(), "removeSlot", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(complexIndexEClass_K);
		addEParameter(op, g1, "elementId", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(fatComplexIndexEClass, FatComplexIndex.class, "FatComplexIndex", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(slimComplexIndexEClass, SlimComplexIndex.class, "SlimComplexIndex", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
	}

} //IndexPackageImpl
