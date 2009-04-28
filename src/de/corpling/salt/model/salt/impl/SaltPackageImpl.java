/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.salt.impl;

import de.corpling.salt.model.salt.SCorpDocRelation;
import de.corpling.salt.model.salt.SCorpus;
import de.corpling.salt.model.salt.SCorpusGraph;
import de.corpling.salt.model.salt.SCorpusRelation;
import de.corpling.salt.model.salt.SDataSource;
import de.corpling.salt.model.salt.SDocument;
import de.corpling.salt.model.salt.SDocumentGraph;
import de.corpling.salt.model.salt.SDominanceRelation;
import de.corpling.salt.model.salt.SPointingRelation;
import de.corpling.salt.model.salt.SProject;
import de.corpling.salt.model.salt.SSpanRelation;
import de.corpling.salt.model.salt.SStructure;
import de.corpling.salt.model.salt.STextualDataSource;
import de.corpling.salt.model.salt.STextualRelation;
import de.corpling.salt.model.salt.SToken;
import de.corpling.salt.model.salt.SaltFactory;
import de.corpling.salt.model.salt.SaltPackage;

import de.corpling.salt.model.saltCore.SaltCorePackage;

import de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl;

import de.util.graph.GraphPackage;

import de.util.graph.impl.GraphPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
public class SaltPackageImpl extends EPackageImpl implements SaltPackage {
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
	private EClass sDataSourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sTextualDataSourceEClass = null;

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
	private EClass sTextualRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sStructureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sSpanRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sProjectEClass = null;

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
	private EClass sCorpusRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sCorpDocRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sDominanceRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sPointingRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sstereotypesEEnum = null;

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
	 * @see de.corpling.salt.model.salt.SaltPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SaltPackageImpl() {
		super(eNS_URI, SaltFactory.eINSTANCE);
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
	public static SaltPackage init() {
		if (isInited) return (SaltPackage)EPackage.Registry.INSTANCE.getEPackage(SaltPackage.eNS_URI);

		// Obtain or create and register package
		SaltPackageImpl theSaltPackage = (SaltPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof SaltPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new SaltPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		SaltCorePackageImpl theSaltCorePackage = (SaltCorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SaltCorePackage.eNS_URI) instanceof SaltCorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SaltCorePackage.eNS_URI) : SaltCorePackage.eINSTANCE);
		GraphPackageImpl theGraphPackage = (GraphPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI) instanceof GraphPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI) : GraphPackage.eINSTANCE);

		// Create package meta-data objects
		theSaltPackage.createPackageContents();
		theSaltCorePackage.createPackageContents();
		theGraphPackage.createPackageContents();

		// Initialize created meta-data
		theSaltPackage.initializePackageContents();
		theSaltCorePackage.initializePackageContents();
		theGraphPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSaltPackage.freeze();

		return theSaltPackage;
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
	public EAttribute getSToken_SLeft() {
		return (EAttribute)sTokenEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSToken_SRight() {
		return (EAttribute)sTokenEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSToken_SDocumentGraph() {
		return (EReference)sTokenEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSDataSource() {
		return sDataSourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSDataSource_SDataSource() {
		return (EAttribute)sDataSourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSTextualDataSource() {
		return sTextualDataSourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSTextualDataSource_SText() {
		return (EAttribute)sTextualDataSourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSTextualDataSource_SDocumentGraph() {
		return (EReference)sTextualDataSourceEClass.getEStructuralFeatures().get(1);
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
	public EReference getSDocumentGraph_STokens() {
		return (EReference)sDocumentGraphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDocumentGraph_STextualRelations() {
		return (EReference)sDocumentGraphEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDocumentGraph_STextualDataSources() {
		return (EReference)sDocumentGraphEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDocumentGraph_SStructures() {
		return (EReference)sDocumentGraphEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDocumentGraph_SpanRelations() {
		return (EReference)sDocumentGraphEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDocumentGraph_SDocument() {
		return (EReference)sDocumentGraphEClass.getEStructuralFeatures().get(5);
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
	public EReference getSTextualRelation_STextualDataSource() {
		return (EReference)sTextualRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSTextualRelation_SLeftPos() {
		return (EAttribute)sTextualRelationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSTextualRelation_SRightPos() {
		return (EAttribute)sTextualRelationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSTextualRelation_SDocumentGraph() {
		return (EReference)sTextualRelationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSStructure() {
		return sStructureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSStructure_SDocumentGraph() {
		return (EReference)sStructureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSSpanRelation() {
		return sSpanRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSSpanRelation_SDocumentGraph() {
		return (EReference)sSpanRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSSpanRelation_SStructure() {
		return (EReference)sSpanRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSSpanRelation_SToken() {
		return (EReference)sSpanRelationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSProject() {
		return sProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSProject_SCorpusGraphs() {
		return (EReference)sProjectEClass.getEStructuralFeatures().get(0);
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
	public EClass getSCorpusGraph() {
		return sCorpusGraphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCorpusGraph_SCorpora() {
		return (EReference)sCorpusGraphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCorpusGraph_SDocuments() {
		return (EReference)sCorpusGraphEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCorpusGraph_SCorpusRelations() {
		return (EReference)sCorpusGraphEClass.getEStructuralFeatures().get(2);
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
	public EReference getSDocument_SDocumentGraph() {
		return (EReference)sDocumentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDocument_SCorpusGraph() {
		return (EReference)sDocumentEClass.getEStructuralFeatures().get(1);
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
	public EClass getSCorpDocRelation() {
		return sCorpDocRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCorpDocRelation_SCorpus() {
		return (EReference)sCorpDocRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCorpDocRelation_SDocument() {
		return (EReference)sCorpDocRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSDominanceRelation() {
		return sDominanceRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSPointingRelation() {
		return sPointingRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSSTEREOTYPES() {
		return sstereotypesEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltFactory getSaltFactory() {
		return (SaltFactory)getEFactoryInstance();
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
		sTokenEClass = createEClass(STOKEN);
		createEAttribute(sTokenEClass, STOKEN__SLEFT);
		createEAttribute(sTokenEClass, STOKEN__SRIGHT);
		createEReference(sTokenEClass, STOKEN__SDOCUMENT_GRAPH);

		sDataSourceEClass = createEClass(SDATA_SOURCE);
		createEAttribute(sDataSourceEClass, SDATA_SOURCE__SDATA_SOURCE);

		sTextualDataSourceEClass = createEClass(STEXTUAL_DATA_SOURCE);
		createEAttribute(sTextualDataSourceEClass, STEXTUAL_DATA_SOURCE__STEXT);
		createEReference(sTextualDataSourceEClass, STEXTUAL_DATA_SOURCE__SDOCUMENT_GRAPH);

		sDocumentGraphEClass = createEClass(SDOCUMENT_GRAPH);
		createEReference(sDocumentGraphEClass, SDOCUMENT_GRAPH__STOKENS);
		createEReference(sDocumentGraphEClass, SDOCUMENT_GRAPH__STEXTUAL_RELATIONS);
		createEReference(sDocumentGraphEClass, SDOCUMENT_GRAPH__STEXTUAL_DATA_SOURCES);
		createEReference(sDocumentGraphEClass, SDOCUMENT_GRAPH__SSTRUCTURES);
		createEReference(sDocumentGraphEClass, SDOCUMENT_GRAPH__SPAN_RELATIONS);
		createEReference(sDocumentGraphEClass, SDOCUMENT_GRAPH__SDOCUMENT);

		sTextualRelationEClass = createEClass(STEXTUAL_RELATION);
		createEReference(sTextualRelationEClass, STEXTUAL_RELATION__STOKEN);
		createEReference(sTextualRelationEClass, STEXTUAL_RELATION__STEXTUAL_DATA_SOURCE);
		createEAttribute(sTextualRelationEClass, STEXTUAL_RELATION__SLEFT_POS);
		createEAttribute(sTextualRelationEClass, STEXTUAL_RELATION__SRIGHT_POS);
		createEReference(sTextualRelationEClass, STEXTUAL_RELATION__SDOCUMENT_GRAPH);

		sStructureEClass = createEClass(SSTRUCTURE);
		createEReference(sStructureEClass, SSTRUCTURE__SDOCUMENT_GRAPH);

		sSpanRelationEClass = createEClass(SSPAN_RELATION);
		createEReference(sSpanRelationEClass, SSPAN_RELATION__SDOCUMENT_GRAPH);
		createEReference(sSpanRelationEClass, SSPAN_RELATION__SSTRUCTURE);
		createEReference(sSpanRelationEClass, SSPAN_RELATION__STOKEN);

		sProjectEClass = createEClass(SPROJECT);
		createEReference(sProjectEClass, SPROJECT__SCORPUS_GRAPHS);

		sCorpusEClass = createEClass(SCORPUS);

		sCorpusGraphEClass = createEClass(SCORPUS_GRAPH);
		createEReference(sCorpusGraphEClass, SCORPUS_GRAPH__SCORPORA);
		createEReference(sCorpusGraphEClass, SCORPUS_GRAPH__SDOCUMENTS);
		createEReference(sCorpusGraphEClass, SCORPUS_GRAPH__SCORPUS_RELATIONS);

		sDocumentEClass = createEClass(SDOCUMENT);
		createEReference(sDocumentEClass, SDOCUMENT__SDOCUMENT_GRAPH);
		createEReference(sDocumentEClass, SDOCUMENT__SCORPUS_GRAPH);

		sCorpusRelationEClass = createEClass(SCORPUS_RELATION);
		createEReference(sCorpusRelationEClass, SCORPUS_RELATION__SSUPER_CORPUS);
		createEReference(sCorpusRelationEClass, SCORPUS_RELATION__SSUB_CORPUS);

		sCorpDocRelationEClass = createEClass(SCORP_DOC_RELATION);
		createEReference(sCorpDocRelationEClass, SCORP_DOC_RELATION__SCORPUS);
		createEReference(sCorpDocRelationEClass, SCORP_DOC_RELATION__SDOCUMENT);

		sDominanceRelationEClass = createEClass(SDOMINANCE_RELATION);

		sPointingRelationEClass = createEClass(SPOINTING_RELATION);

		// Create enums
		sstereotypesEEnum = createEEnum(SSTEREOTYPES);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		sTokenEClass.getESuperTypes().add(theSaltCorePackage.getSElement());
		sDataSourceEClass.getESuperTypes().add(theSaltCorePackage.getSElement());
		sTextualDataSourceEClass.getESuperTypes().add(this.getSDataSource());
		sDocumentGraphEClass.getESuperTypes().add(theSaltCorePackage.getSGraph());
		sTextualRelationEClass.getESuperTypes().add(theSaltCorePackage.getSRelation());
		sStructureEClass.getESuperTypes().add(theSaltCorePackage.getSElement());
		sSpanRelationEClass.getESuperTypes().add(theSaltCorePackage.getSRelation());
		sProjectEClass.getESuperTypes().add(theSaltCorePackage.getSCoreProject());
		sCorpusEClass.getESuperTypes().add(theSaltCorePackage.getSElement());
		sCorpusGraphEClass.getESuperTypes().add(theSaltCorePackage.getSGraph());
		sDocumentEClass.getESuperTypes().add(theSaltCorePackage.getSElement());
		sCorpusRelationEClass.getESuperTypes().add(theSaltCorePackage.getSRelation());
		sCorpDocRelationEClass.getESuperTypes().add(theSaltCorePackage.getSRelation());
		sDominanceRelationEClass.getESuperTypes().add(theSaltCorePackage.getSRelation());
		sPointingRelationEClass.getESuperTypes().add(theSaltCorePackage.getSRelation());

		// Initialize classes and features; add operations and parameters
		initEClass(sTokenEClass, SToken.class, "SToken", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSToken_SLeft(), ecorePackage.getELongObject(), "sLeft", null, 0, 1, SToken.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getSToken_SRight(), ecorePackage.getELongObject(), "sRight", null, 0, 1, SToken.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSToken_SDocumentGraph(), this.getSDocumentGraph(), this.getSDocumentGraph_STokens(), "sDocumentGraph", null, 1, 1, SToken.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sDataSourceEClass, SDataSource.class, "SDataSource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSDataSource_SDataSource(), ecorePackage.getEJavaObject(), "sDataSource", null, 0, 1, SDataSource.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sTextualDataSourceEClass, STextualDataSource.class, "STextualDataSource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSTextualDataSource_SText(), ecorePackage.getEString(), "sText", null, 0, 1, STextualDataSource.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSTextualDataSource_SDocumentGraph(), this.getSDocumentGraph(), this.getSDocumentGraph_STextualDataSources(), "sDocumentGraph", null, 0, 1, STextualDataSource.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sDocumentGraphEClass, SDocumentGraph.class, "SDocumentGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSDocumentGraph_STokens(), this.getSToken(), this.getSToken_SDocumentGraph(), "sTokens", null, 0, -1, SDocumentGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSDocumentGraph_STextualRelations(), this.getSTextualRelation(), this.getSTextualRelation_SDocumentGraph(), "sTextualRelations", null, 0, -1, SDocumentGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSDocumentGraph_STextualDataSources(), this.getSTextualDataSource(), this.getSTextualDataSource_SDocumentGraph(), "sTextualDataSources", null, 0, -1, SDocumentGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSDocumentGraph_SStructures(), this.getSStructure(), this.getSStructure_SDocumentGraph(), "sStructures", null, 0, -1, SDocumentGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSDocumentGraph_SpanRelations(), this.getSSpanRelation(), this.getSSpanRelation_SDocumentGraph(), "SpanRelations", null, 0, -1, SDocumentGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSDocumentGraph_SDocument(), this.getSDocument(), this.getSDocument_SDocumentGraph(), "sDocument", null, 0, 1, SDocumentGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sTextualRelationEClass, STextualRelation.class, "STextualRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSTextualRelation_SToken(), this.getSToken(), null, "sToken", null, 0, 1, STextualRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSTextualRelation_STextualDataSource(), this.getSTextualDataSource(), null, "sTextualDataSource", null, 0, 1, STextualRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getSTextualRelation_SLeftPos(), ecorePackage.getELongObject(), "sLeftPos", null, 0, 1, STextualRelation.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getSTextualRelation_SRightPos(), ecorePackage.getELongObject(), "sRightPos", null, 0, 1, STextualRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSTextualRelation_SDocumentGraph(), this.getSDocumentGraph(), this.getSDocumentGraph_STextualRelations(), "sDocumentGraph", null, 0, 1, STextualRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sStructureEClass, SStructure.class, "SStructure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSStructure_SDocumentGraph(), this.getSDocumentGraph(), this.getSDocumentGraph_SStructures(), "sDocumentGraph", null, 0, 1, SStructure.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sSpanRelationEClass, SSpanRelation.class, "SSpanRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSSpanRelation_SDocumentGraph(), this.getSDocumentGraph(), this.getSDocumentGraph_SpanRelations(), "sDocumentGraph", null, 0, 1, SSpanRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSSpanRelation_SStructure(), this.getSStructure(), null, "sStructure", null, 0, 1, SSpanRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSSpanRelation_SToken(), this.getSToken(), null, "sToken", null, 0, 1, SSpanRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sProjectEClass, SProject.class, "SProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSProject_SCorpusGraphs(), this.getSCorpusGraph(), null, "sCorpusGraphs", null, 0, -1, SProject.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(sProjectEClass, theSaltCorePackage.getSStereotype(), "getSStereotypeByEnum", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSSTEREOTYPES(), "sStereotypeEnum", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sCorpusEClass, SCorpus.class, "SCorpus", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sCorpusGraphEClass, SCorpusGraph.class, "SCorpusGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSCorpusGraph_SCorpora(), this.getSCorpus(), null, "sCorpora", null, 0, -1, SCorpusGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSCorpusGraph_SDocuments(), this.getSDocument(), this.getSDocument_SCorpusGraph(), "sDocuments", null, 0, -1, SCorpusGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSCorpusGraph_SCorpusRelations(), this.getSCorpusRelation(), null, "sCorpusRelations", null, 0, -1, SCorpusGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sDocumentEClass, SDocument.class, "SDocument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSDocument_SDocumentGraph(), this.getSDocumentGraph(), this.getSDocumentGraph_SDocument(), "sDocumentGraph", null, 1, 1, SDocument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSDocument_SCorpusGraph(), this.getSCorpusGraph(), this.getSCorpusGraph_SDocuments(), "sCorpusGraph", null, 0, 1, SDocument.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sCorpusRelationEClass, SCorpusRelation.class, "SCorpusRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSCorpusRelation_SSuperCorpus(), this.getSCorpus(), null, "sSuperCorpus", null, 0, 1, SCorpusRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSCorpusRelation_SSubCorpus(), this.getSCorpus(), null, "sSubCorpus", null, 0, 1, SCorpusRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sCorpDocRelationEClass, SCorpDocRelation.class, "SCorpDocRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSCorpDocRelation_SCorpus(), this.getSCorpus(), null, "sCorpus", null, 0, 1, SCorpDocRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSCorpDocRelation_SDocument(), this.getSDocument(), null, "sDocument", null, 0, 1, SCorpDocRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sDominanceRelationEClass, SDominanceRelation.class, "SDominanceRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sPointingRelationEClass, SPointingRelation.class, "SPointingRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(sstereotypesEEnum, de.corpling.salt.model.salt.SSTEREOTYPES.class, "SSTEREOTYPES");
		addEEnumLiteral(sstereotypesEEnum, de.corpling.salt.model.salt.SSTEREOTYPES.STOKEN);
		addEEnumLiteral(sstereotypesEEnum, de.corpling.salt.model.salt.SSTEREOTYPES.SDATASOURCE);
		addEEnumLiteral(sstereotypesEEnum, de.corpling.salt.model.salt.SSTEREOTYPES.STEXTUAL_DATASOURCE);
		addEEnumLiteral(sstereotypesEEnum, de.corpling.salt.model.salt.SSTEREOTYPES.STEXTUAL_RELATION);
		addEEnumLiteral(sstereotypesEEnum, de.corpling.salt.model.salt.SSTEREOTYPES.SCORPUS);
		addEEnumLiteral(sstereotypesEEnum, de.corpling.salt.model.salt.SSTEREOTYPES.SDOCUMENT);
		addEEnumLiteral(sstereotypesEEnum, de.corpling.salt.model.salt.SSTEREOTYPES.SCORPUS_RELATION);
		addEEnumLiteral(sstereotypesEEnum, de.corpling.salt.model.salt.SSTEREOTYPES.SCORPDOC_RELATION);
		addEEnumLiteral(sstereotypesEEnum, de.corpling.salt.model.salt.SSTEREOTYPES.SSPAN_RELATION);
		addEEnumLiteral(sstereotypesEEnum, de.corpling.salt.model.salt.SSTEREOTYPES.SDOMINANCE_RELATION);
		addEEnumLiteral(sstereotypesEEnum, de.corpling.salt.model.salt.SSTEREOTYPES.SPOINTING_RELATION);
		addEEnumLiteral(sstereotypesEEnum, de.corpling.salt.model.salt.SSTEREOTYPES.SSTRUCTURE);

		// Create resource
		createResource(eNS_URI);
	}

} //SaltPackageImpl
