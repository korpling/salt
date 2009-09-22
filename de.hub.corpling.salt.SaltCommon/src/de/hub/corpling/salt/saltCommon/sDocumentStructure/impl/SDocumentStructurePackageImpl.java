/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.hub.corpling.salt.saltCommon.SaltCommonPackage;
import de.hub.corpling.salt.saltCommon.impl.SaltCommonPackageImpl;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.impl.SCorpusStructurePackageImpl;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructureFactory;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialDS;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SSpan;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SSpanningRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextOverlappingRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeline;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STimelineRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken;
import de.hub.corpling.salt.saltCore.SaltCorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SDocumentStructurePackageImpl extends EPackageImpl implements SDocumentStructurePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sDocumentGraphEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sTextualDSEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sTokenEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sTextualRelationEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sSequentialRelationEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sSequentialDSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sTimelineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sTimelineRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sSpanEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sSpanningRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sTextOverlappingRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sfeaturE_NAMESEEnum = null;

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
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SDocumentStructurePackageImpl() {
		super(eNS_URI, SDocumentStructureFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SDocumentStructurePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SDocumentStructurePackage init() {
		if (isInited) return (SDocumentStructurePackage)EPackage.Registry.INSTANCE.getEPackage(SDocumentStructurePackage.eNS_URI);

		// Obtain or create and register package
		SDocumentStructurePackageImpl theSDocumentStructurePackage = (SDocumentStructurePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SDocumentStructurePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SDocumentStructurePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		SaltCorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		SaltCommonPackageImpl theSaltCommonPackage = (SaltCommonPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SaltCommonPackage.eNS_URI) instanceof SaltCommonPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SaltCommonPackage.eNS_URI) : SaltCommonPackage.eINSTANCE);
		SCorpusStructurePackageImpl theSCorpusStructurePackage = (SCorpusStructurePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SCorpusStructurePackage.eNS_URI) instanceof SCorpusStructurePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SCorpusStructurePackage.eNS_URI) : SCorpusStructurePackage.eINSTANCE);

		// Create package meta-data objects
		theSDocumentStructurePackage.createPackageContents();
		theSaltCommonPackage.createPackageContents();
		theSCorpusStructurePackage.createPackageContents();

		// Initialize created meta-data
		theSDocumentStructurePackage.initializePackageContents();
		theSaltCommonPackage.initializePackageContents();
		theSCorpusStructurePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSDocumentStructurePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SDocumentStructurePackage.eNS_URI, theSDocumentStructurePackage);
		return theSDocumentStructurePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSDocumentGraph() {
		return sDocumentGraphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDocumentGraph_SDocument() {
		return (EReference)sDocumentGraphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDocumentGraph_STextualDSs() {
		return (EReference)sDocumentGraphEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDocumentGraph_STextualRelations() {
		return (EReference)sDocumentGraphEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDocumentGraph_STokens() {
		return (EReference)sDocumentGraphEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDocumentGraph_STimeline() {
		return (EReference)sDocumentGraphEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDocumentGraph_STimelineRelations() {
		return (EReference)sDocumentGraphEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDocumentGraph_SSpanningRelations() {
		return (EReference)sDocumentGraphEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDocumentGraph_SSpans() {
		return (EReference)sDocumentGraphEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSTextualDS() {
		return sTextualDSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSTextualDS_SText() {
		return (EAttribute)sTextualDSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSTextualDS_SDocumentGraph() {
		return (EReference)sTextualDSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSToken() {
		return sTokenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSToken_SDocumentGraph() {
		return (EReference)sTokenEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSTextualRelation() {
		return sTextualRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSTextualRelation_SToken() {
		return (EReference)sTextualRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSTextualRelation_STextualDS() {
		return (EReference)sTextualRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSTextualRelation_SDocumentGraph() {
		return (EReference)sTextualRelationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSSequentialRelation() {
		return sSequentialRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSSequentialRelation_SStart() {
		return (EAttribute)sSequentialRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSSequentialRelation_SEnd() {
		return (EAttribute)sSequentialRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSSequentialDS() {
		return sSequentialDSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSSequentialDS_SData() {
		return (EAttribute)sSequentialDSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSTimeline() {
		return sTimelineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSTimeline_SPointsOfTime() {
		return (EAttribute)sTimelineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSTimeline_SDocumentGraph() {
		return (EReference)sTimelineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSTimelineRelation() {
		return sTimelineRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSTimelineRelation_STimeline() {
		return (EReference)sTimelineRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSTimelineRelation_SToken() {
		return (EReference)sTimelineRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSTimelineRelation_SDocumentGraph() {
		return (EReference)sTimelineRelationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSSpan() {
		return sSpanEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSSpan_SDocumentGraph() {
		return (EReference)sSpanEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSSpanningRelation() {
		return sSpanningRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSSpanningRelation_SToken() {
		return (EReference)sSpanningRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSSpanningRelation_SSpan() {
		return (EReference)sSpanningRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSSpanningRelation_SDocumentGraph() {
		return (EReference)sSpanningRelationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSTextOverlappingRelation() {
		return sTextOverlappingRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSFEATURE_NAMES() {
		return sfeaturE_NAMESEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDocumentStructureFactory getSDocumentStructureFactory() {
		return (SDocumentStructureFactory)getEFactoryInstance();
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
		sDocumentGraphEClass = createEClass(SDOCUMENT_GRAPH);
		createEReference(sDocumentGraphEClass, SDOCUMENT_GRAPH__SDOCUMENT);
		createEReference(sDocumentGraphEClass, SDOCUMENT_GRAPH__STEXTUAL_DSS);
		createEReference(sDocumentGraphEClass, SDOCUMENT_GRAPH__STEXTUAL_RELATIONS);
		createEReference(sDocumentGraphEClass, SDOCUMENT_GRAPH__STOKENS);
		createEReference(sDocumentGraphEClass, SDOCUMENT_GRAPH__STIMELINE);
		createEReference(sDocumentGraphEClass, SDOCUMENT_GRAPH__STIMELINE_RELATIONS);
		createEReference(sDocumentGraphEClass, SDOCUMENT_GRAPH__SSPANNING_RELATIONS);
		createEReference(sDocumentGraphEClass, SDOCUMENT_GRAPH__SSPANS);

		sTextualDSEClass = createEClass(STEXTUAL_DS);
		createEAttribute(sTextualDSEClass, STEXTUAL_DS__STEXT);
		createEReference(sTextualDSEClass, STEXTUAL_DS__SDOCUMENT_GRAPH);

		sTokenEClass = createEClass(STOKEN);
		createEReference(sTokenEClass, STOKEN__SDOCUMENT_GRAPH);

		sTextualRelationEClass = createEClass(STEXTUAL_RELATION);
		createEReference(sTextualRelationEClass, STEXTUAL_RELATION__STOKEN);
		createEReference(sTextualRelationEClass, STEXTUAL_RELATION__STEXTUAL_DS);
		createEReference(sTextualRelationEClass, STEXTUAL_RELATION__SDOCUMENT_GRAPH);

		sSequentialRelationEClass = createEClass(SSEQUENTIAL_RELATION);
		createEAttribute(sSequentialRelationEClass, SSEQUENTIAL_RELATION__SSTART);
		createEAttribute(sSequentialRelationEClass, SSEQUENTIAL_RELATION__SEND);

		sSequentialDSEClass = createEClass(SSEQUENTIAL_DS);
		createEAttribute(sSequentialDSEClass, SSEQUENTIAL_DS__SDATA);

		sTimelineEClass = createEClass(STIMELINE);
		createEAttribute(sTimelineEClass, STIMELINE__SPOINTS_OF_TIME);
		createEReference(sTimelineEClass, STIMELINE__SDOCUMENT_GRAPH);

		sTimelineRelationEClass = createEClass(STIMELINE_RELATION);
		createEReference(sTimelineRelationEClass, STIMELINE_RELATION__STIMELINE);
		createEReference(sTimelineRelationEClass, STIMELINE_RELATION__STOKEN);
		createEReference(sTimelineRelationEClass, STIMELINE_RELATION__SDOCUMENT_GRAPH);

		sSpanEClass = createEClass(SSPAN);
		createEReference(sSpanEClass, SSPAN__SDOCUMENT_GRAPH);

		sSpanningRelationEClass = createEClass(SSPANNING_RELATION);
		createEReference(sSpanningRelationEClass, SSPANNING_RELATION__STOKEN);
		createEReference(sSpanningRelationEClass, SSPANNING_RELATION__SSPAN);
		createEReference(sSpanningRelationEClass, SSPANNING_RELATION__SDOCUMENT_GRAPH);

		sTextOverlappingRelationEClass = createEClass(STEXT_OVERLAPPING_RELATION);

		// Create enums
		sfeaturE_NAMESEEnum = createEEnum(SFEATURE_NAMES);
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
		SCorpusStructurePackage theSCorpusStructurePackage = (SCorpusStructurePackage)EPackage.Registry.INSTANCE.getEPackage(SCorpusStructurePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		sDocumentGraphEClass.getESuperTypes().add(theSaltCorePackage.getSGraph());
		sTextualDSEClass.getESuperTypes().add(this.getSSequentialDS());
		sTokenEClass.getESuperTypes().add(theSaltCorePackage.getSNode());
		sTextualRelationEClass.getESuperTypes().add(this.getSSequentialRelation());
		sTextualRelationEClass.getESuperTypes().add(this.getSTextOverlappingRelation());
		sSequentialRelationEClass.getESuperTypes().add(theSaltCorePackage.getSRelation());
		sSequentialDSEClass.getESuperTypes().add(theSaltCorePackage.getSNode());
		sTimelineEClass.getESuperTypes().add(this.getSSequentialDS());
		sTimelineRelationEClass.getESuperTypes().add(this.getSSequentialRelation());
		sSpanEClass.getESuperTypes().add(theSaltCorePackage.getSNode());
		sSpanningRelationEClass.getESuperTypes().add(theSaltCorePackage.getSRelation());
		sSpanningRelationEClass.getESuperTypes().add(this.getSTextOverlappingRelation());
		sTextOverlappingRelationEClass.getESuperTypes().add(theSaltCorePackage.getSRelation());

		// Initialize classes and features; add operations and parameters
		initEClass(sDocumentGraphEClass, SDocumentGraph.class, "SDocumentGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSDocumentGraph_SDocument(), theSCorpusStructurePackage.getSDocument(), theSCorpusStructurePackage.getSDocument_SDocumentGraph(), "sDocument", null, 0, 1, SDocumentGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSDocumentGraph_STextualDSs(), this.getSTextualDS(), this.getSTextualDS_SDocumentGraph(), "sTextualDSs", null, 0, -1, SDocumentGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSDocumentGraph_STextualRelations(), this.getSTextualRelation(), this.getSTextualRelation_SDocumentGraph(), "sTextualRelations", null, 0, -1, SDocumentGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSDocumentGraph_STokens(), this.getSToken(), this.getSToken_SDocumentGraph(), "sTokens", null, 0, -1, SDocumentGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSDocumentGraph_STimeline(), this.getSTimeline(), this.getSTimeline_SDocumentGraph(), "sTimeline", null, 0, 1, SDocumentGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSDocumentGraph_STimelineRelations(), this.getSTimelineRelation(), null, "sTimelineRelations", null, 0, -1, SDocumentGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSDocumentGraph_SSpanningRelations(), this.getSSpanningRelation(), this.getSSpanningRelation_SDocumentGraph(), "sSpanningRelations", null, 0, -1, SDocumentGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSDocumentGraph_SSpans(), this.getSSpan(), this.getSSpan_SDocumentGraph(), "sSpans", null, 0, -1, SDocumentGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sTextualDSEClass, STextualDS.class, "STextualDS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSTextualDS_SText(), ecorePackage.getEString(), "sText", null, 0, 1, STextualDS.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSTextualDS_SDocumentGraph(), this.getSDocumentGraph(), this.getSDocumentGraph_STextualDSs(), "sDocumentGraph", null, 0, 1, STextualDS.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sTokenEClass, SToken.class, "SToken", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSToken_SDocumentGraph(), this.getSDocumentGraph(), this.getSDocumentGraph_STokens(), "sDocumentGraph", null, 0, 1, SToken.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sTextualRelationEClass, STextualRelation.class, "STextualRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSTextualRelation_SToken(), this.getSToken(), null, "sToken", null, 0, 1, STextualRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSTextualRelation_STextualDS(), this.getSTextualDS(), null, "sTextualDS", null, 0, 1, STextualRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSTextualRelation_SDocumentGraph(), this.getSDocumentGraph(), this.getSDocumentGraph_STextualRelations(), "sDocumentGraph", null, 0, 1, STextualRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sSequentialRelationEClass, SSequentialRelation.class, "SSequentialRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSSequentialRelation_SStart(), ecorePackage.getEIntegerObject(), "sStart", null, 0, 1, SSequentialRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getSSequentialRelation_SEnd(), ecorePackage.getEIntegerObject(), "sEnd", null, 0, 1, SSequentialRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sSequentialDSEClass, SSequentialDS.class, "SSequentialDS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSSequentialDS_SData(), ecorePackage.getEJavaObject(), "sData", null, 0, 1, SSequentialDS.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sTimelineEClass, STimeline.class, "STimeline", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSTimeline_SPointsOfTime(), ecorePackage.getEString(), "sPointsOfTime", null, 0, -1, STimeline.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSTimeline_SDocumentGraph(), this.getSDocumentGraph(), this.getSDocumentGraph_STimeline(), "sDocumentGraph", null, 0, 1, STimeline.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(sTimelineEClass, null, "addSPointOfTime", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "sPointOfTime", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sTimelineRelationEClass, STimelineRelation.class, "STimelineRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSTimelineRelation_STimeline(), this.getSTimeline(), null, "sTimeline", null, 0, 1, STimelineRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSTimelineRelation_SToken(), this.getSToken(), null, "sToken", null, 0, 1, STimelineRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSTimelineRelation_SDocumentGraph(), this.getSDocumentGraph(), null, "sDocumentGraph", null, 0, 1, STimelineRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sSpanEClass, SSpan.class, "SSpan", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSSpan_SDocumentGraph(), this.getSDocumentGraph(), this.getSDocumentGraph_SSpans(), "sDocumentGraph", null, 0, 1, SSpan.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sSpanningRelationEClass, SSpanningRelation.class, "SSpanningRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSSpanningRelation_SToken(), this.getSToken(), null, "sToken", null, 0, 1, SSpanningRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSSpanningRelation_SSpan(), this.getSSpan(), null, "sSpan", null, 0, 1, SSpanningRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSSpanningRelation_SDocumentGraph(), this.getSDocumentGraph(), this.getSDocumentGraph_SSpanningRelations(), "sDocumentGraph", null, 0, 1, SSpanningRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sTextOverlappingRelationEClass, STextOverlappingRelation.class, "STextOverlappingRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(sTextOverlappingRelationEClass, ecorePackage.getEBooleanObject(), "isSTextOverlapping", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(sfeaturE_NAMESEEnum, de.hub.corpling.salt.saltCommon.sDocumentStructure.SFEATURE_NAMES.class, "SFEATURE_NAMES");
		addEEnumLiteral(sfeaturE_NAMESEEnum, de.hub.corpling.salt.saltCommon.sDocumentStructure.SFEATURE_NAMES.STEXT_OVERLAPPING);
		addEEnumLiteral(sfeaturE_NAMESEEnum, de.hub.corpling.salt.saltCommon.sDocumentStructure.SFEATURE_NAMES.SSTART);
		addEEnumLiteral(sfeaturE_NAMESEEnum, de.hub.corpling.salt.saltCommon.sDocumentStructure.SFEATURE_NAMES.SEND);
		addEEnumLiteral(sfeaturE_NAMESEEnum, de.hub.corpling.salt.saltCommon.sDocumentStructure.SFEATURE_NAMES.STEXT);
		addEEnumLiteral(sfeaturE_NAMESEEnum, de.hub.corpling.salt.saltCommon.sDocumentStructure.SFEATURE_NAMES.SDATA);
	}

} //SDocumentStructurePackageImpl
