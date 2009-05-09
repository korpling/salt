/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.saltCore.impl;

import de.corpling.salt.model.saltCore.SAnnotatableElement;
import de.corpling.salt.model.saltCore.SAnnotation;
import de.corpling.salt.model.saltCore.SCoreProject;
import de.corpling.salt.model.saltCore.SElement;
import de.corpling.salt.model.saltCore.SFeature;
import de.corpling.salt.model.saltCore.SFeatureDescription;
import de.corpling.salt.model.saltCore.SGraph;
import de.corpling.salt.model.saltCore.SIdentifiableElement;
import de.corpling.salt.model.saltCore.SNamedElement;
import de.corpling.salt.model.saltCore.SProcessingAnnotatableElement;
import de.corpling.salt.model.saltCore.SProcessingAnnotation;
import de.corpling.salt.model.saltCore.SRelation;
import de.corpling.salt.model.saltCore.SStereotype;
import de.corpling.salt.model.saltCore.SStereotypeContainer;
import de.corpling.salt.model.saltCore.SStereotypeableElement;
import de.corpling.salt.model.saltCore.STraversalObject;
import de.corpling.salt.model.saltCore.SaltCoreFactory;
import de.corpling.salt.model.saltCore.SaltCorePackage;

import de.util.graph.GraphPackage;

import de.util.graph.impl.GraphPackageImpl;

import java.util.Properties;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
public class SaltCorePackageImpl extends EPackageImpl implements SaltCorePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sIdentifiableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sAnnotatableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sNamedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sStereotypeableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sFeatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sStereotypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sFeatureDescriptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sGraphEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sCoreProjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sStereotypeContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sProcessingAnnotatableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sProcessingAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sTraversalObjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum straversaL_MODEEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sdatatypesEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType propertiesEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uriEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType objectEDataType = null;

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
	 * @see de.corpling.salt.model.saltCore.SaltCorePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SaltCorePackageImpl() {
		super(eNS_URI, SaltCoreFactory.eINSTANCE);
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
	public static SaltCorePackage init() {
		if (isInited) return (SaltCorePackage)EPackage.Registry.INSTANCE.getEPackage(SaltCorePackage.eNS_URI);

		// Obtain or create and register package
		SaltCorePackageImpl theSaltCorePackage = (SaltCorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof SaltCorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new SaltCorePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		GraphPackageImpl theGraphPackage = (GraphPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI) instanceof GraphPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI) : GraphPackage.eINSTANCE);

		// Create package meta-data objects
		theSaltCorePackage.createPackageContents();
		theGraphPackage.createPackageContents();

		// Initialize created meta-data
		theSaltCorePackage.initializePackageContents();
		theGraphPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSaltCorePackage.freeze();

		return theSaltCorePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSIdentifiableElement() {
		return sIdentifiableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSElement() {
		return sElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSElement_SSterotypeableElement() {
		return (EReference)sElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSElement_SAnnotatableElement() {
		return (EReference)sElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSElement_SProcessingAnnotatableElement() {
		return (EReference)sElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSElement_SGraph() {
		return (EReference)sElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSAnnotation() {
		return sAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSAnnotation_SType() {
		return (EAttribute)sAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSAnnotation_SuperAnnotatableElement() {
		return (EReference)sAnnotationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSAnnotatableElement() {
		return sAnnotatableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSAnnotatableElement_SAnnotations() {
		return (EReference)sAnnotatableElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSRelation() {
		return sRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSRelation_SSourceElement() {
		return (EReference)sRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSRelation_SDestinationElement() {
		return (EReference)sRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSRelation_SStereotypableElement() {
		return (EReference)sRelationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSRelation_SAnnotatableElement() {
		return (EReference)sRelationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSRelation_SProcessingAnnotatableElement() {
		return (EReference)sRelationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSRelation_SGraph() {
		return (EReference)sRelationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSRelation_SType() {
		return (EAttribute)sRelationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSNamedElement() {
		return sNamedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSNamedElement_Name() {
		return (EAttribute)sNamedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSStereotypeableElement() {
		return sStereotypeableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSStereotypeableElement_SStereotype() {
		return (EReference)sStereotypeableElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSStereotypeableElement_SFeatures() {
		return (EReference)sStereotypeableElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSFeature() {
		return sFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSStereotype() {
		return sStereotypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSStereotype_Name() {
		return (EAttribute)sStereotypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSStereotype_SFeatureDescriptions() {
		return (EReference)sStereotypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSStereotype_SSuperStereotype() {
		return (EReference)sStereotypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSStereotype_SProject() {
		return (EReference)sStereotypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSFeatureDescription() {
		return sFeatureDescriptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSFeatureDescription_Name() {
		return (EAttribute)sFeatureDescriptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSGraph() {
		return sGraphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSGraph_SElements() {
		return (EReference)sGraphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSGraph_SRelations() {
		return (EReference)sGraphEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSGraph_SCoreProject() {
		return (EReference)sGraphEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCoreProject() {
		return sCoreProjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCoreProject_SGraphs() {
		return (EReference)sCoreProjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSCoreProject_SStereotypeContainer() {
		return (EReference)sCoreProjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSStereotypeContainer() {
		return sStereotypeContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSStereotypeContainer_SStereotypes() {
		return (EReference)sStereotypeContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSProcessingAnnotatableElement() {
		return sProcessingAnnotatableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSProcessingAnnotatableElement_SProcessingAnnotations() {
		return (EReference)sProcessingAnnotatableElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSProcessingAnnotation() {
		return sProcessingAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSTraversalObject() {
		return sTraversalObjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSTRAVERSAL_MODE() {
		return straversaL_MODEEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSDATATYPES() {
		return sdatatypesEEnum;
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
	public EDataType getURI() {
		return uriEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getObject() {
		return objectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltCoreFactory getSaltCoreFactory() {
		return (SaltCoreFactory)getEFactoryInstance();
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
		sIdentifiableElementEClass = createEClass(SIDENTIFIABLE_ELEMENT);

		sElementEClass = createEClass(SELEMENT);
		createEReference(sElementEClass, SELEMENT__SSTEROTYPEABLE_ELEMENT);
		createEReference(sElementEClass, SELEMENT__SANNOTATABLE_ELEMENT);
		createEReference(sElementEClass, SELEMENT__SPROCESSING_ANNOTATABLE_ELEMENT);
		createEReference(sElementEClass, SELEMENT__SGRAPH);

		sAnnotationEClass = createEClass(SANNOTATION);
		createEAttribute(sAnnotationEClass, SANNOTATION__STYPE);
		createEReference(sAnnotationEClass, SANNOTATION__SUPER_ANNOTATABLE_ELEMENT);

		sAnnotatableElementEClass = createEClass(SANNOTATABLE_ELEMENT);
		createEReference(sAnnotatableElementEClass, SANNOTATABLE_ELEMENT__SANNOTATIONS);

		sRelationEClass = createEClass(SRELATION);
		createEReference(sRelationEClass, SRELATION__SSOURCE_ELEMENT);
		createEReference(sRelationEClass, SRELATION__SDESTINATION_ELEMENT);
		createEReference(sRelationEClass, SRELATION__SSTEREOTYPABLE_ELEMENT);
		createEReference(sRelationEClass, SRELATION__SANNOTATABLE_ELEMENT);
		createEReference(sRelationEClass, SRELATION__SPROCESSING_ANNOTATABLE_ELEMENT);
		createEReference(sRelationEClass, SRELATION__SGRAPH);
		createEAttribute(sRelationEClass, SRELATION__STYPE);

		sNamedElementEClass = createEClass(SNAMED_ELEMENT);
		createEAttribute(sNamedElementEClass, SNAMED_ELEMENT__NAME);

		sStereotypeableElementEClass = createEClass(SSTEREOTYPEABLE_ELEMENT);
		createEReference(sStereotypeableElementEClass, SSTEREOTYPEABLE_ELEMENT__SSTEREOTYPE);
		createEReference(sStereotypeableElementEClass, SSTEREOTYPEABLE_ELEMENT__SFEATURES);

		sFeatureEClass = createEClass(SFEATURE);

		sStereotypeEClass = createEClass(SSTEREOTYPE);
		createEAttribute(sStereotypeEClass, SSTEREOTYPE__NAME);
		createEReference(sStereotypeEClass, SSTEREOTYPE__SFEATURE_DESCRIPTIONS);
		createEReference(sStereotypeEClass, SSTEREOTYPE__SSUPER_STEREOTYPE);
		createEReference(sStereotypeEClass, SSTEREOTYPE__SPROJECT);

		sFeatureDescriptionEClass = createEClass(SFEATURE_DESCRIPTION);
		createEAttribute(sFeatureDescriptionEClass, SFEATURE_DESCRIPTION__NAME);

		sGraphEClass = createEClass(SGRAPH);
		createEReference(sGraphEClass, SGRAPH__SELEMENTS);
		createEReference(sGraphEClass, SGRAPH__SRELATIONS);
		createEReference(sGraphEClass, SGRAPH__SCORE_PROJECT);

		sCoreProjectEClass = createEClass(SCORE_PROJECT);
		createEReference(sCoreProjectEClass, SCORE_PROJECT__SGRAPHS);
		createEReference(sCoreProjectEClass, SCORE_PROJECT__SSTEREOTYPE_CONTAINER);

		sStereotypeContainerEClass = createEClass(SSTEREOTYPE_CONTAINER);
		createEReference(sStereotypeContainerEClass, SSTEREOTYPE_CONTAINER__SSTEREOTYPES);

		sProcessingAnnotatableElementEClass = createEClass(SPROCESSING_ANNOTATABLE_ELEMENT);
		createEReference(sProcessingAnnotatableElementEClass, SPROCESSING_ANNOTATABLE_ELEMENT__SPROCESSING_ANNOTATIONS);

		sProcessingAnnotationEClass = createEClass(SPROCESSING_ANNOTATION);

		sTraversalObjectEClass = createEClass(STRAVERSAL_OBJECT);

		// Create enums
		straversaL_MODEEEnum = createEEnum(STRAVERSAL_MODE);
		sdatatypesEEnum = createEEnum(SDATATYPES);

		// Create data types
		propertiesEDataType = createEDataType(PROPERTIES);
		uriEDataType = createEDataType(URI);
		objectEDataType = createEDataType(OBJECT);
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

		// Set bounds for type parameters

		// Add supertypes to classes
		sIdentifiableElementEClass.getESuperTypes().add(this.getSNamedElement());
		sIdentifiableElementEClass.getESuperTypes().add(theGraphPackage.getIdentifiableElement());
		sElementEClass.getESuperTypes().add(this.getSIdentifiableElement());
		sElementEClass.getESuperTypes().add(this.getSAnnotatableElement());
		sElementEClass.getESuperTypes().add(this.getSStereotypeableElement());
		sElementEClass.getESuperTypes().add(this.getSProcessingAnnotatableElement());
		sElementEClass.getESuperTypes().add(theGraphPackage.getNode());
		sAnnotationEClass.getESuperTypes().add(theGraphPackage.getLabel());
		sAnnotationEClass.getESuperTypes().add(this.getSAnnotatableElement());
		sAnnotatableElementEClass.getESuperTypes().add(theGraphPackage.getLabelableElement());
		sRelationEClass.getESuperTypes().add(theGraphPackage.getEdge());
		sRelationEClass.getESuperTypes().add(this.getSIdentifiableElement());
		sRelationEClass.getESuperTypes().add(this.getSAnnotatableElement());
		sRelationEClass.getESuperTypes().add(this.getSStereotypeableElement());
		sRelationEClass.getESuperTypes().add(this.getSProcessingAnnotatableElement());
		sStereotypeableElementEClass.getESuperTypes().add(theGraphPackage.getLabelableElement());
		sFeatureEClass.getESuperTypes().add(theGraphPackage.getLabel());
		sGraphEClass.getESuperTypes().add(theGraphPackage.getGraph());
		sCoreProjectEClass.getESuperTypes().add(this.getSStereotypeContainer());
		sProcessingAnnotatableElementEClass.getESuperTypes().add(theGraphPackage.getLabelableElement());
		sProcessingAnnotationEClass.getESuperTypes().add(theGraphPackage.getLabel());

		// Initialize classes and features; add operations and parameters
		initEClass(sIdentifiableElementEClass, SIdentifiableElement.class, "SIdentifiableElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sElementEClass, SElement.class, "SElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSElement_SSterotypeableElement(), this.getSStereotypeableElement(), null, "sSterotypeableElement", null, 1, 1, SElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSElement_SAnnotatableElement(), this.getSAnnotatableElement(), null, "sAnnotatableElement", null, 0, 1, SElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSElement_SProcessingAnnotatableElement(), this.getSProcessingAnnotatableElement(), null, "sProcessingAnnotatableElement", null, 0, 1, SElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSElement_SGraph(), this.getSGraph(), this.getSGraph_SElements(), "sGraph", null, 0, 1, SElement.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sAnnotationEClass, SAnnotation.class, "SAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSAnnotation_SType(), this.getSDATATYPES(), "sType", "STEXT", 0, 1, SAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSAnnotation_SuperAnnotatableElement(), this.getSAnnotatableElement(), null, "superAnnotatableElement", null, 1, 1, SAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(sAnnotationEClass, ecorePackage.getELongObject(), "getValueSNumber", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(sAnnotationEClass, ecorePackage.getEDoubleObject(), "getValueSReal", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(sAnnotationEClass, ecorePackage.getEString(), "getValueSText", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(sAnnotationEClass, this.getURI(), "getValueSURI", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(sAnnotationEClass, ecorePackage.getEJavaObject(), "getValueSObject", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sAnnotatableElementEClass, SAnnotatableElement.class, "SAnnotatableElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSAnnotatableElement_SAnnotations(), this.getSAnnotation(), null, "sAnnotations", null, 0, -1, SAnnotatableElement.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(sAnnotatableElementEClass, null, "addSAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSAnnotation(), "sAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sAnnotatableElementEClass, this.getSAnnotation(), "getSAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "fullName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sRelationEClass, SRelation.class, "SRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSRelation_SSourceElement(), this.getSElement(), null, "sSourceElement", null, 0, 1, SRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSRelation_SDestinationElement(), this.getSElement(), null, "sDestinationElement", null, 0, 1, SRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSRelation_SStereotypableElement(), this.getSStereotypeableElement(), null, "sStereotypableElement", null, 1, 1, SRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSRelation_SAnnotatableElement(), this.getSAnnotatableElement(), null, "sAnnotatableElement", null, 0, 1, SRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSRelation_SProcessingAnnotatableElement(), this.getSProcessingAnnotatableElement(), null, "sProcessingAnnotatableElement", null, 0, 1, SRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSRelation_SGraph(), this.getSGraph(), this.getSGraph_SRelations(), "sGraph", null, 0, 1, SRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getSRelation_SType(), ecorePackage.getEString(), "sType", null, 0, 1, SRelation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sNamedElementEClass, SNamedElement.class, "SNamedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSNamedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, SNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sStereotypeableElementEClass, SStereotypeableElement.class, "SStereotypeableElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSStereotypeableElement_SStereotype(), this.getSStereotype(), null, "sStereotype", null, 1, 1, SStereotypeableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSStereotypeableElement_SFeatures(), this.getSFeature(), null, "sFeatures", null, 0, -1, SStereotypeableElement.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		op = addEOperation(sStereotypeableElementEClass, null, "addSFeature", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "featureName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "featureValue", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sStereotypeableElementEClass, this.getSFeature(), "getSFeature", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "featureName", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sStereotypeableElementEClass, ecorePackage.getEBoolean(), "removeSFeature", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "featureName", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sStereotypeableElementEClass, null, "addSFeature", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSFeature(), "feature", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sFeatureEClass, SFeature.class, "SFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sStereotypeEClass, SStereotype.class, "SStereotype", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSStereotype_Name(), ecorePackage.getEString(), "name", null, 0, 1, SStereotype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSStereotype_SFeatureDescriptions(), this.getSFeatureDescription(), null, "sFeatureDescriptions", null, 0, 1, SStereotype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSStereotype_SSuperStereotype(), this.getSStereotype(), null, "sSuperStereotype", null, 0, 1, SStereotype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSStereotype_SProject(), this.getSStereotypeContainer(), this.getSStereotypeContainer_SStereotypes(), "sProject", null, 0, 1, SStereotype.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sFeatureDescriptionEClass, SFeatureDescription.class, "SFeatureDescription", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSFeatureDescription_Name(), ecorePackage.getEString(), "name", null, 0, 1, SFeatureDescription.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sGraphEClass, SGraph.class, "SGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSGraph_SElements(), this.getSElement(), this.getSElement_SGraph(), "sElements", null, 0, -1, SGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSGraph_SRelations(), this.getSRelation(), this.getSRelation_SGraph(), "sRelations", null, 0, -1, SGraph.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSGraph_SCoreProject(), this.getSCoreProject(), this.getSCoreProject_SGraphs(), "sCoreProject", null, 0, 1, SGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(sGraphEClass, null, "addSElement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSElement(), "sElement", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sGraphEClass, this.getSElement(), "getSElementById", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "sElementId", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sGraphEClass, this.getSElement(), "getSElementsByStereotype", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSStereotype(), "sStereotype", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sGraphEClass, null, "addSRelation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSRelation(), "sRelation", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sGraphEClass, this.getSRelation(), "getSRelationById", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "sRelationId", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sGraphEClass, this.getSRelation(), "getSRelationsByStereotype", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSStereotype(), "sStereotype", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(sGraphEClass, this.getSElement(), "getSRoots", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sGraphEClass, this.getSElement(), "getSRootsBySStereotypeRelation", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSStereotype(), "sStereotype", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sGraphEClass, null, "traverseSGraph", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSTRAVERSAL_MODE(), "sTraversalMode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEEList(), "startSElements", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSTraversalObject(), "sTraversalObject", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSStereotype(), "sStereotype", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sGraphEClass, null, "traverseSGraph", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSTRAVERSAL_MODE(), "sTraversalMode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSElement(), "startSElements", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSTraversalObject(), "sTraversalObject", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSStereotype(), "sStereotype", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sCoreProjectEClass, SCoreProject.class, "SCoreProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSCoreProject_SGraphs(), this.getSGraph(), this.getSGraph_SCoreProject(), "sGraphs", null, 0, -1, SCoreProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSCoreProject_SStereotypeContainer(), this.getSStereotypeContainer(), null, "sStereotypeContainer", null, 0, 1, SCoreProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(sCoreProjectEClass, null, "addSGraph", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSGraph(), "sGraph", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sCoreProjectEClass, this.getSGraph(), "getSGraphById", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "sGraphId", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sStereotypeContainerEClass, SStereotypeContainer.class, "SStereotypeContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSStereotypeContainer_SStereotypes(), this.getSStereotype(), this.getSStereotype_SProject(), "sStereotypes", null, 0, -1, SStereotypeContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(sStereotypeContainerEClass, this.getSStereotype(), "getSStereotypeByName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "sStereotypeName", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sStereotypeContainerEClass, null, "setSStereotypes", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getProperties(), "properties", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sProcessingAnnotatableElementEClass, SProcessingAnnotatableElement.class, "SProcessingAnnotatableElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSProcessingAnnotatableElement_SProcessingAnnotations(), this.getSProcessingAnnotation(), null, "sProcessingAnnotations", null, 0, -1, SProcessingAnnotatableElement.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		op = addEOperation(sProcessingAnnotatableElementEClass, null, "addSProcessingAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSProcessingAnnotation(), "sProcessingAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sProcessingAnnotatableElementEClass, this.getSProcessingAnnotation(), "getSProcessingAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "fullName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sProcessingAnnotationEClass, SProcessingAnnotation.class, "SProcessingAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sTraversalObjectEClass, STraversalObject.class, "STraversalObject", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(sTraversalObjectEClass, null, "sElementReached", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSTRAVERSAL_MODE(), "traversalMode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSElement(), "currSElement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSRelation(), "sRelation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSElement(), "fromSElement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getELong(), "order", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sTraversalObjectEClass, null, "sElementLeft", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSTRAVERSAL_MODE(), "traversalMode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSElement(), "currSElement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSRelation(), "sRelation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSElement(), "fromSElement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getELong(), "order", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sTraversalObjectEClass, ecorePackage.getEBoolean(), "checkConstraint", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSTRAVERSAL_MODE(), "traversalMode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSRelation(), "sRelation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSElement(), "currSElement", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getELong(), "order", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(straversaL_MODEEEnum, de.corpling.salt.model.saltCore.STRAVERSAL_MODE.class, "STRAVERSAL_MODE");
		addEEnumLiteral(straversaL_MODEEEnum, de.corpling.salt.model.saltCore.STRAVERSAL_MODE.DEPTH_FIRST);
		addEEnumLiteral(straversaL_MODEEEnum, de.corpling.salt.model.saltCore.STRAVERSAL_MODE.BOTTOM_UP);

		initEEnum(sdatatypesEEnum, de.corpling.salt.model.saltCore.SDATATYPES.class, "SDATATYPES");
		addEEnumLiteral(sdatatypesEEnum, de.corpling.salt.model.saltCore.SDATATYPES.SNUMBER);
		addEEnumLiteral(sdatatypesEEnum, de.corpling.salt.model.saltCore.SDATATYPES.SREAL);
		addEEnumLiteral(sdatatypesEEnum, de.corpling.salt.model.saltCore.SDATATYPES.STEXT);
		addEEnumLiteral(sdatatypesEEnum, de.corpling.salt.model.saltCore.SDATATYPES.SURI);
		addEEnumLiteral(sdatatypesEEnum, de.corpling.salt.model.saltCore.SDATATYPES.SOBJECT);

		// Initialize data types
		initEDataType(propertiesEDataType, Properties.class, "Properties", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(uriEDataType, java.net.URI.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(objectEDataType, Object.class, "Object", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //SaltCorePackageImpl
