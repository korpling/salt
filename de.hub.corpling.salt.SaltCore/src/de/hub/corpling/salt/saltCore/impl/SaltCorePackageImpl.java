/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.hub.corpling.graph.GraphPackage;
import de.hub.corpling.salt.saltCore.SAbstractAnnotation;
import de.hub.corpling.salt.saltCore.SAnnotatableElement;
import de.hub.corpling.salt.saltCore.SAnnotation;
import de.hub.corpling.salt.saltCore.SElementId;
import de.hub.corpling.salt.saltCore.SFeaturableElement;
import de.hub.corpling.salt.saltCore.SFeature;
import de.hub.corpling.salt.saltCore.SGraph;
import de.hub.corpling.salt.saltCore.SIdentifiableElement;
import de.hub.corpling.salt.saltCore.SMetaAnnotatableElement;
import de.hub.corpling.salt.saltCore.SMetaAnnotation;
import de.hub.corpling.salt.saltCore.SNamedElement;
import de.hub.corpling.salt.saltCore.SNode;
import de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement;
import de.hub.corpling.salt.saltCore.SProcessingAnnotation;
import de.hub.corpling.salt.saltCore.SRelation;
import de.hub.corpling.salt.saltCore.SaltCoreFactory;
import de.hub.corpling.salt.saltCore.SaltCorePackage;

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
	private EClass sNodeEClass = null;

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
	private EClass sAnnotatableElementEClass = null;

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
	private EClass sGraphEClass = null;

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
	private EClass sIdentifiableElementEClass = null;

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
	private EClass sProcessingAnnotatableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sElementIdEClass = null;

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
	private EClass sFeaturableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sMetaAnnotatableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sMetaAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sAbstractAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sdatatypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uriEDataType = null;

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
	 * @see de.hub.corpling.salt.saltCore.SaltCorePackage#eNS_URI
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
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link SaltCorePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
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
		SaltCorePackageImpl theSaltCorePackage = (SaltCorePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SaltCorePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SaltCorePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		GraphPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSaltCorePackage.createPackageContents();

		// Initialize created meta-data
		theSaltCorePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSaltCorePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SaltCorePackage.eNS_URI, theSaltCorePackage);
		return theSaltCorePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSNode() {
		return sNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSNode_SGraph() {
		return (EReference)sNodeEClass.getEStructuralFeatures().get(0);
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
	public EReference getSRelation_SSource() {
		return (EReference)sRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSRelation_STarget() {
		return (EReference)sRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSRelation_SGraph() {
		return (EReference)sRelationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSRelation_STypes() {
		return (EAttribute)sRelationEClass.getEStructuralFeatures().get(3);
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
	public EClass getSAnnotation() {
		return sAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSAnnotation_SAnnotatableElement() {
		return (EReference)sAnnotationEClass.getEStructuralFeatures().get(0);
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
	public EReference getSGraph_SRelations() {
		return (EReference)sGraphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSGraph_SNodes() {
		return (EReference)sGraphEClass.getEStructuralFeatures().get(1);
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
	public EAttribute getSNamedElement_SName() {
		return (EAttribute)sNamedElementEClass.getEStructuralFeatures().get(0);
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
	public EReference getSIdentifiableElement_SElementId() {
		return (EReference)sIdentifiableElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSIdentifiableElement_SId() {
		return (EAttribute)sIdentifiableElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSIdentifiableElement_SElementPath() {
		return (EAttribute)sIdentifiableElementEClass.getEStructuralFeatures().get(2);
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
	public EReference getSProcessingAnnotation_SProcessingAnnotatableElement() {
		return (EReference)sProcessingAnnotationEClass.getEStructuralFeatures().get(0);
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
	public EClass getSElementId() {
		return sElementIdEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSElementId_SIdentifiableElement() {
		return (EReference)sElementIdEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSElementId_SId() {
		return (EAttribute)sElementIdEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSElementId_SElementPath() {
		return (EAttribute)sElementIdEClass.getEStructuralFeatures().get(2);
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
	public EReference getSFeature_SFeaturableElement() {
		return (EReference)sFeatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSFeaturableElement() {
		return sFeaturableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSFeaturableElement_SFeatures() {
		return (EReference)sFeaturableElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSMetaAnnotatableElement() {
		return sMetaAnnotatableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSMetaAnnotatableElement_SMetaAnnotations() {
		return (EReference)sMetaAnnotatableElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSMetaAnnotation() {
		return sMetaAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSMetaAnnotation_SMetaAnnotatableElement() {
		return (EReference)sMetaAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSAbstractAnnotation() {
		return sAbstractAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSAbstractAnnotation_SNS() {
		return (EAttribute)sAbstractAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSAbstractAnnotation_SName() {
		return (EAttribute)sAbstractAnnotationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSAbstractAnnotation_SValue() {
		return (EAttribute)sAbstractAnnotationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSAbstractAnnotation_SValueType() {
		return (EAttribute)sAbstractAnnotationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSDATATYPE() {
		return sdatatypeEEnum;
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
		sNodeEClass = createEClass(SNODE);
		createEReference(sNodeEClass, SNODE__SGRAPH);

		sRelationEClass = createEClass(SRELATION);
		createEReference(sRelationEClass, SRELATION__SSOURCE);
		createEReference(sRelationEClass, SRELATION__STARGET);
		createEReference(sRelationEClass, SRELATION__SGRAPH);
		createEAttribute(sRelationEClass, SRELATION__STYPES);

		sAnnotatableElementEClass = createEClass(SANNOTATABLE_ELEMENT);
		createEReference(sAnnotatableElementEClass, SANNOTATABLE_ELEMENT__SANNOTATIONS);

		sAnnotationEClass = createEClass(SANNOTATION);
		createEReference(sAnnotationEClass, SANNOTATION__SANNOTATABLE_ELEMENT);

		sGraphEClass = createEClass(SGRAPH);
		createEReference(sGraphEClass, SGRAPH__SRELATIONS);
		createEReference(sGraphEClass, SGRAPH__SNODES);

		sNamedElementEClass = createEClass(SNAMED_ELEMENT);
		createEAttribute(sNamedElementEClass, SNAMED_ELEMENT__SNAME);

		sIdentifiableElementEClass = createEClass(SIDENTIFIABLE_ELEMENT);
		createEReference(sIdentifiableElementEClass, SIDENTIFIABLE_ELEMENT__SELEMENT_ID);
		createEAttribute(sIdentifiableElementEClass, SIDENTIFIABLE_ELEMENT__SID);
		createEAttribute(sIdentifiableElementEClass, SIDENTIFIABLE_ELEMENT__SELEMENT_PATH);

		sProcessingAnnotationEClass = createEClass(SPROCESSING_ANNOTATION);
		createEReference(sProcessingAnnotationEClass, SPROCESSING_ANNOTATION__SPROCESSING_ANNOTATABLE_ELEMENT);

		sProcessingAnnotatableElementEClass = createEClass(SPROCESSING_ANNOTATABLE_ELEMENT);
		createEReference(sProcessingAnnotatableElementEClass, SPROCESSING_ANNOTATABLE_ELEMENT__SPROCESSING_ANNOTATIONS);

		sElementIdEClass = createEClass(SELEMENT_ID);
		createEReference(sElementIdEClass, SELEMENT_ID__SIDENTIFIABLE_ELEMENT);
		createEAttribute(sElementIdEClass, SELEMENT_ID__SID);
		createEAttribute(sElementIdEClass, SELEMENT_ID__SELEMENT_PATH);

		sFeatureEClass = createEClass(SFEATURE);
		createEReference(sFeatureEClass, SFEATURE__SFEATURABLE_ELEMENT);

		sFeaturableElementEClass = createEClass(SFEATURABLE_ELEMENT);
		createEReference(sFeaturableElementEClass, SFEATURABLE_ELEMENT__SFEATURES);

		sMetaAnnotatableElementEClass = createEClass(SMETA_ANNOTATABLE_ELEMENT);
		createEReference(sMetaAnnotatableElementEClass, SMETA_ANNOTATABLE_ELEMENT__SMETA_ANNOTATIONS);

		sMetaAnnotationEClass = createEClass(SMETA_ANNOTATION);
		createEReference(sMetaAnnotationEClass, SMETA_ANNOTATION__SMETA_ANNOTATABLE_ELEMENT);

		sAbstractAnnotationEClass = createEClass(SABSTRACT_ANNOTATION);
		createEAttribute(sAbstractAnnotationEClass, SABSTRACT_ANNOTATION__SNS);
		createEAttribute(sAbstractAnnotationEClass, SABSTRACT_ANNOTATION__SNAME);
		createEAttribute(sAbstractAnnotationEClass, SABSTRACT_ANNOTATION__SVALUE);
		createEAttribute(sAbstractAnnotationEClass, SABSTRACT_ANNOTATION__SVALUE_TYPE);

		// Create enums
		sdatatypeEEnum = createEEnum(SDATATYPE);

		// Create data types
		uriEDataType = createEDataType(URI);
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
		sNodeEClass.getESuperTypes().add(theGraphPackage.getNode());
		sNodeEClass.getESuperTypes().add(this.getSAnnotatableElement());
		sNodeEClass.getESuperTypes().add(this.getSNamedElement());
		sNodeEClass.getESuperTypes().add(this.getSIdentifiableElement());
		sNodeEClass.getESuperTypes().add(this.getSProcessingAnnotatableElement());
		sNodeEClass.getESuperTypes().add(this.getSFeaturableElement());
		sNodeEClass.getESuperTypes().add(this.getSMetaAnnotatableElement());
		sRelationEClass.getESuperTypes().add(theGraphPackage.getEdge());
		sRelationEClass.getESuperTypes().add(this.getSAnnotatableElement());
		sRelationEClass.getESuperTypes().add(this.getSNamedElement());
		sRelationEClass.getESuperTypes().add(this.getSIdentifiableElement());
		sRelationEClass.getESuperTypes().add(this.getSProcessingAnnotatableElement());
		sRelationEClass.getESuperTypes().add(this.getSFeaturableElement());
		sRelationEClass.getESuperTypes().add(this.getSMetaAnnotatableElement());
		sAnnotatableElementEClass.getESuperTypes().add(theGraphPackage.getLabelableElement());
		sAnnotationEClass.getESuperTypes().add(this.getSAbstractAnnotation());
		sGraphEClass.getESuperTypes().add(theGraphPackage.getGraph());
		sGraphEClass.getESuperTypes().add(this.getSNamedElement());
		sGraphEClass.getESuperTypes().add(this.getSAnnotatableElement());
		sGraphEClass.getESuperTypes().add(this.getSIdentifiableElement());
		sGraphEClass.getESuperTypes().add(this.getSProcessingAnnotatableElement());
		sGraphEClass.getESuperTypes().add(this.getSFeaturableElement());
		sGraphEClass.getESuperTypes().add(this.getSMetaAnnotatableElement());
		sIdentifiableElementEClass.getESuperTypes().add(theGraphPackage.getIdentifiableElement());
		sProcessingAnnotationEClass.getESuperTypes().add(this.getSAbstractAnnotation());
		sProcessingAnnotatableElementEClass.getESuperTypes().add(theGraphPackage.getLabelableElement());
		sElementIdEClass.getESuperTypes().add(theGraphPackage.getIdentifier());
		sFeatureEClass.getESuperTypes().add(this.getSAbstractAnnotation());
		sFeaturableElementEClass.getESuperTypes().add(theGraphPackage.getLabelableElement());
		sMetaAnnotatableElementEClass.getESuperTypes().add(theGraphPackage.getLabelableElement());
		sMetaAnnotationEClass.getESuperTypes().add(this.getSAbstractAnnotation());
		sAbstractAnnotationEClass.getESuperTypes().add(theGraphPackage.getLabel());

		// Initialize classes and features; add operations and parameters
		initEClass(sNodeEClass, SNode.class, "SNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSNode_SGraph(), this.getSGraph(), this.getSGraph_SNodes(), "sGraph", null, 0, 1, SNode.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sRelationEClass, SRelation.class, "SRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSRelation_SSource(), this.getSNode(), null, "sSource", null, 0, 1, SRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSRelation_STarget(), this.getSNode(), null, "sTarget", null, 0, 1, SRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSRelation_SGraph(), this.getSGraph(), this.getSGraph_SRelations(), "sGraph", null, 0, 1, SRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getSRelation_STypes(), ecorePackage.getEString(), "sTypes", null, 0, -1, SRelation.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(sRelationEClass, null, "addSType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "sType", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sAnnotatableElementEClass, SAnnotatableElement.class, "SAnnotatableElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSAnnotatableElement_SAnnotations(), this.getSAnnotation(), this.getSAnnotation_SAnnotatableElement(), "sAnnotations", null, 0, -1, SAnnotatableElement.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		op = addEOperation(sAnnotatableElementEClass, null, "addSAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSAnnotation(), "sAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sAnnotatableElementEClass, this.getSAnnotation(), "getSAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "fullName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sAnnotationEClass, SAnnotation.class, "SAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSAnnotation_SAnnotatableElement(), this.getSAnnotatableElement(), this.getSAnnotatableElement_SAnnotations(), "sAnnotatableElement", null, 0, 1, SAnnotation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sGraphEClass, SGraph.class, "SGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSGraph_SRelations(), this.getSRelation(), this.getSRelation_SGraph(), "sRelations", null, 0, -1, SGraph.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSGraph_SNodes(), this.getSNode(), this.getSNode_SGraph(), "sNodes", null, 0, -1, SGraph.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		op = addEOperation(sGraphEClass, null, "addSNode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSNode(), "sNode", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sGraphEClass, this.getSNode(), "getSNode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "sNodeId", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sGraphEClass, null, "addSRelation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSRelation(), "sRelation", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sGraphEClass, this.getSRelation(), "getSRelation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "sRelationId", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sNamedElementEClass, SNamedElement.class, "SNamedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSNamedElement_SName(), ecorePackage.getEString(), "sName", null, 0, 1, SNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sIdentifiableElementEClass, SIdentifiableElement.class, "SIdentifiableElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSIdentifiableElement_SElementId(), this.getSElementId(), this.getSElementId_SIdentifiableElement(), "sElementId", null, 0, 1, SIdentifiableElement.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getSIdentifiableElement_SId(), ecorePackage.getEString(), "sId", null, 0, 1, SIdentifiableElement.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getSIdentifiableElement_SElementPath(), this.getURI(), "sElementPath", null, 0, 1, SIdentifiableElement.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sProcessingAnnotationEClass, SProcessingAnnotation.class, "SProcessingAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSProcessingAnnotation_SProcessingAnnotatableElement(), this.getSProcessingAnnotatableElement(), this.getSProcessingAnnotatableElement_SProcessingAnnotations(), "sProcessingAnnotatableElement", null, 0, 1, SProcessingAnnotation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sProcessingAnnotatableElementEClass, SProcessingAnnotatableElement.class, "SProcessingAnnotatableElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSProcessingAnnotatableElement_SProcessingAnnotations(), this.getSProcessingAnnotation(), this.getSProcessingAnnotation_SProcessingAnnotatableElement(), "sProcessingAnnotations", null, 0, -1, SProcessingAnnotatableElement.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		op = addEOperation(sProcessingAnnotatableElementEClass, null, "addSProcessingAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSProcessingAnnotation(), "sProcessingAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sProcessingAnnotatableElementEClass, this.getSProcessingAnnotation(), "getSProcessingAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "fullName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sElementIdEClass, SElementId.class, "SElementId", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSElementId_SIdentifiableElement(), this.getSIdentifiableElement(), this.getSIdentifiableElement_SElementId(), "sIdentifiableElement", null, 0, 1, SElementId.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getSElementId_SId(), ecorePackage.getEString(), "sId", null, 0, 1, SElementId.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getSElementId_SElementPath(), this.getURI(), "sElementPath", null, 0, 1, SElementId.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sFeatureEClass, SFeature.class, "SFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSFeature_SFeaturableElement(), this.getSFeaturableElement(), this.getSFeaturableElement_SFeatures(), "sFeaturableElement", null, 0, 1, SFeature.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sFeaturableElementEClass, SFeaturableElement.class, "SFeaturableElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSFeaturableElement_SFeatures(), this.getSFeature(), this.getSFeature_SFeaturableElement(), "sFeatures", null, 0, -1, SFeaturableElement.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		op = addEOperation(sFeaturableElementEClass, null, "addSFeature", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSFeature(), "sFeature", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sFeaturableElementEClass, this.getSFeature(), "getSFeature", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "sFeatureName", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sFeaturableElementEClass, this.getSFeature(), "getSFeature", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "sNamespace", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "sFeatureName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sMetaAnnotatableElementEClass, SMetaAnnotatableElement.class, "SMetaAnnotatableElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSMetaAnnotatableElement_SMetaAnnotations(), this.getSMetaAnnotation(), this.getSMetaAnnotation_SMetaAnnotatableElement(), "sMetaAnnotations", null, 0, -1, SMetaAnnotatableElement.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		op = addEOperation(sMetaAnnotatableElementEClass, null, "addSMetaAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSMetaAnnotation(), "sMetaAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sMetaAnnotatableElementEClass, this.getSMetaAnnotation(), "getSMetaAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "fullName", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sMetaAnnotationEClass, SMetaAnnotation.class, "SMetaAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSMetaAnnotation_SMetaAnnotatableElement(), this.getSMetaAnnotatableElement(), this.getSMetaAnnotatableElement_SMetaAnnotations(), "sMetaAnnotatableElement", null, 0, 1, SMetaAnnotation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sAbstractAnnotationEClass, SAbstractAnnotation.class, "SAbstractAnnotation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSAbstractAnnotation_SNS(), ecorePackage.getEString(), "SNS", null, 0, 1, SAbstractAnnotation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getSAbstractAnnotation_SName(), ecorePackage.getEString(), "SName", null, 0, 1, SAbstractAnnotation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getSAbstractAnnotation_SValue(), ecorePackage.getEJavaObject(), "SValue", null, 0, 1, SAbstractAnnotation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getSAbstractAnnotation_SValueType(), this.getSDATATYPE(), "SValueType", null, 0, 1, SAbstractAnnotation.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		addEOperation(sAbstractAnnotationEClass, ecorePackage.getEString(), "getSValueSTEXT", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(sAbstractAnnotationEClass, ecorePackage.getEBooleanObject(), "getSValueSBOOLEAN", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(sAbstractAnnotationEClass, ecorePackage.getELongObject(), "getSValueSNUMERIC", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(sAbstractAnnotationEClass, ecorePackage.getEDoubleObject(), "getSValueSFLOAT", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(sAbstractAnnotationEClass, this.getURI(), "getSValueSURI", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(sAbstractAnnotationEClass, ecorePackage.getEJavaObject(), "getSValueSOBJECT", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(sdatatypeEEnum, de.hub.corpling.salt.saltCore.SDATATYPE.class, "SDATATYPE");
		addEEnumLiteral(sdatatypeEEnum, de.hub.corpling.salt.saltCore.SDATATYPE.STEXT);
		addEEnumLiteral(sdatatypeEEnum, de.hub.corpling.salt.saltCore.SDATATYPE.SBOOLEAN);
		addEEnumLiteral(sdatatypeEEnum, de.hub.corpling.salt.saltCore.SDATATYPE.SNUMERIC);
		addEEnumLiteral(sdatatypeEEnum, de.hub.corpling.salt.saltCore.SDATATYPE.SFLOAT);
		addEEnumLiteral(sdatatypeEEnum, de.hub.corpling.salt.saltCore.SDATATYPE.SURI);
		addEEnumLiteral(sdatatypeEEnum, de.hub.corpling.salt.saltCore.SDATATYPE.SOBJECT);

		// Initialize data types
		initEDataType(uriEDataType, org.eclipse.emf.common.util.URI.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //SaltCorePackageImpl
