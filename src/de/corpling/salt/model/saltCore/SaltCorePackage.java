/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.saltCore;

import de.util.graph.GraphPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.corpling.salt.model.saltCore.SaltCoreFactory
 * @model kind="package"
 * @generated
 */
public interface SaltCorePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "saltCore";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "www.corpling.de/salt/saltCore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "saltCore";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SaltCorePackage eINSTANCE = de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl.init();

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.saltCore.impl.SNamedElementImpl <em>SNamed Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.saltCore.impl.SNamedElementImpl
	 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSNamedElement()
	 * @generated
	 */
	int SNAMED_ELEMENT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>SNamed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.saltCore.impl.SIdentifiableElementImpl <em>SIdentifiable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.saltCore.impl.SIdentifiableElementImpl
	 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSIdentifiableElement()
	 * @generated
	 */
	int SIDENTIFIABLE_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIDENTIFIABLE_ELEMENT__NAME = SNAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIDENTIFIABLE_ELEMENT__ID = SNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SIdentifiable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIDENTIFIABLE_ELEMENT_FEATURE_COUNT = SNAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.saltCore.impl.SElementImpl <em>SElement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.saltCore.impl.SElementImpl
	 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSElement()
	 * @generated
	 */
	int SELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT__NAME = SIDENTIFIABLE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT__ID = SIDENTIFIABLE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT__LABELS = SIDENTIFIABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Num Of Labels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT__NUM_OF_LABELS = SIDENTIFIABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT__SANNOTATIONS = SIDENTIFIABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>SStereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT__SSTEREOTYPE = SIDENTIFIABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT__SFEATURES = SIDENTIFIABLE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT__SPROCESSING_ANNOTATIONS = SIDENTIFIABLE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT__GRAPH = SIDENTIFIABLE_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Labelable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT__LABELABLE_ELEMENT = SIDENTIFIABLE_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>SSterotypeable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT__SSTEROTYPEABLE_ELEMENT = SIDENTIFIABLE_ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>SAnnotatable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT__SANNOTATABLE_ELEMENT = SIDENTIFIABLE_ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>SProcessing Annotatable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT__SPROCESSING_ANNOTATABLE_ELEMENT = SIDENTIFIABLE_ELEMENT_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT__SGRAPH = SIDENTIFIABLE_ELEMENT_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>SElement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT_FEATURE_COUNT = SIDENTIFIABLE_ELEMENT_FEATURE_COUNT + 12;

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.saltCore.impl.SAnnotationImpl <em>SAnnotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.saltCore.impl.SAnnotationImpl
	 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSAnnotation()
	 * @generated
	 */
	int SANNOTATION = 2;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATION__NAMESPACE = GraphPackage.LABEL__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATION__NAME = GraphPackage.LABEL__NAME;

	/**
	 * The feature id for the '<em><b>Full Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATION__FULL_NAME = GraphPackage.LABEL__FULL_NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATION__VALUE = GraphPackage.LABEL__VALUE;

	/**
	 * The feature id for the '<em><b>Label Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATION__LABEL_OWNER = GraphPackage.LABEL__LABEL_OWNER;

	/**
	 * The number of structural features of the '<em>SAnnotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATION_FEATURE_COUNT = GraphPackage.LABEL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.saltCore.impl.SAnnotatableElementImpl <em>SAnnotatable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.saltCore.impl.SAnnotatableElementImpl
	 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSAnnotatableElement()
	 * @generated
	 */
	int SANNOTATABLE_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATABLE_ELEMENT__LABELS = GraphPackage.LABELABLE_ELEMENT__LABELS;

	/**
	 * The feature id for the '<em><b>Num Of Labels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATABLE_ELEMENT__NUM_OF_LABELS = GraphPackage.LABELABLE_ELEMENT__NUM_OF_LABELS;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATABLE_ELEMENT__SANNOTATIONS = GraphPackage.LABELABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SAnnotatable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATABLE_ELEMENT_FEATURE_COUNT = GraphPackage.LABELABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.saltCore.impl.SRelationImpl <em>SRelation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.saltCore.impl.SRelationImpl
	 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSRelation()
	 * @generated
	 */
	int SRELATION = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__ID = GraphPackage.EDGE__ID;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__LABELS = GraphPackage.EDGE__LABELS;

	/**
	 * The feature id for the '<em><b>Num Of Labels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__NUM_OF_LABELS = GraphPackage.EDGE__NUM_OF_LABELS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__SOURCE = GraphPackage.EDGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__DESTINATION = GraphPackage.EDGE__DESTINATION;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__GRAPH = GraphPackage.EDGE__GRAPH;

	/**
	 * The feature id for the '<em><b>Labelable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__LABELABLE_ELEMENT = GraphPackage.EDGE__LABELABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__NAME = GraphPackage.EDGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__SANNOTATIONS = GraphPackage.EDGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SStereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__SSTEREOTYPE = GraphPackage.EDGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__SFEATURES = GraphPackage.EDGE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__SPROCESSING_ANNOTATIONS = GraphPackage.EDGE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>SSource Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__SSOURCE_ELEMENT = GraphPackage.EDGE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>SDestination Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__SDESTINATION_ELEMENT = GraphPackage.EDGE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>SStereotypable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__SSTEREOTYPABLE_ELEMENT = GraphPackage.EDGE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>SAnnotatable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__SANNOTATABLE_ELEMENT = GraphPackage.EDGE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>SProcessing Annotatable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__SPROCESSING_ANNOTATABLE_ELEMENT = GraphPackage.EDGE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__SGRAPH = GraphPackage.EDGE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>SType</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__STYPE = GraphPackage.EDGE_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>SRelation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION_FEATURE_COUNT = GraphPackage.EDGE_FEATURE_COUNT + 12;

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.saltCore.impl.SStereotypeableElementImpl <em>SStereotypeable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.saltCore.impl.SStereotypeableElementImpl
	 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSStereotypeableElement()
	 * @generated
	 */
	int SSTEREOTYPEABLE_ELEMENT = 6;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTEREOTYPEABLE_ELEMENT__LABELS = GraphPackage.LABELABLE_ELEMENT__LABELS;

	/**
	 * The feature id for the '<em><b>Num Of Labels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTEREOTYPEABLE_ELEMENT__NUM_OF_LABELS = GraphPackage.LABELABLE_ELEMENT__NUM_OF_LABELS;

	/**
	 * The feature id for the '<em><b>SStereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTEREOTYPEABLE_ELEMENT__SSTEREOTYPE = GraphPackage.LABELABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTEREOTYPEABLE_ELEMENT__SFEATURES = GraphPackage.LABELABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>SStereotypeable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTEREOTYPEABLE_ELEMENT_FEATURE_COUNT = GraphPackage.LABELABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.saltCore.impl.SFeatureImpl <em>SFeature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.saltCore.impl.SFeatureImpl
	 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSFeature()
	 * @generated
	 */
	int SFEATURE = 7;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SFEATURE__NAMESPACE = GraphPackage.LABEL__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SFEATURE__NAME = GraphPackage.LABEL__NAME;

	/**
	 * The feature id for the '<em><b>Full Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SFEATURE__FULL_NAME = GraphPackage.LABEL__FULL_NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SFEATURE__VALUE = GraphPackage.LABEL__VALUE;

	/**
	 * The feature id for the '<em><b>Label Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SFEATURE__LABEL_OWNER = GraphPackage.LABEL__LABEL_OWNER;

	/**
	 * The number of structural features of the '<em>SFeature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SFEATURE_FEATURE_COUNT = GraphPackage.LABEL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.saltCore.impl.SStereotypeImpl <em>SStereotype</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.saltCore.impl.SStereotypeImpl
	 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSStereotype()
	 * @generated
	 */
	int SSTEREOTYPE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTEREOTYPE__NAME = 0;

	/**
	 * The feature id for the '<em><b>SFeature Descriptions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTEREOTYPE__SFEATURE_DESCRIPTIONS = 1;

	/**
	 * The feature id for the '<em><b>SSuper Stereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTEREOTYPE__SSUPER_STEREOTYPE = 2;

	/**
	 * The feature id for the '<em><b>SProject</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTEREOTYPE__SPROJECT = 3;

	/**
	 * The number of structural features of the '<em>SStereotype</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTEREOTYPE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.saltCore.impl.SFeatureDescriptionImpl <em>SFeature Description</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.saltCore.impl.SFeatureDescriptionImpl
	 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSFeatureDescription()
	 * @generated
	 */
	int SFEATURE_DESCRIPTION = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SFEATURE_DESCRIPTION__NAME = 0;

	/**
	 * The number of structural features of the '<em>SFeature Description</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SFEATURE_DESCRIPTION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.saltCore.impl.SGraphImpl <em>SGraph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.saltCore.impl.SGraphImpl
	 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSGraph()
	 * @generated
	 */
	int SGRAPH = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__ID = GraphPackage.GRAPH__ID;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__LABELS = GraphPackage.GRAPH__LABELS;

	/**
	 * The feature id for the '<em><b>Num Of Labels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__NUM_OF_LABELS = GraphPackage.GRAPH__NUM_OF_LABELS;

	/**
	 * The feature id for the '<em><b>Indexes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__INDEXES = GraphPackage.GRAPH__INDEXES;

	/**
	 * The feature id for the '<em><b>Num Of Indexes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__NUM_OF_INDEXES = GraphPackage.GRAPH__NUM_OF_INDEXES;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__NODES = GraphPackage.GRAPH__NODES;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__EDGES = GraphPackage.GRAPH__EDGES;

	/**
	 * The feature id for the '<em><b>Num Of Nodes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__NUM_OF_NODES = GraphPackage.GRAPH__NUM_OF_NODES;

	/**
	 * The feature id for the '<em><b>Num Of Edges</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__NUM_OF_EDGES = GraphPackage.GRAPH__NUM_OF_EDGES;

	/**
	 * The feature id for the '<em><b>Labelable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__LABELABLE_ELEMENT = GraphPackage.GRAPH__LABELABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Index Mgr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__INDEX_MGR = GraphPackage.GRAPH__INDEX_MGR;

	/**
	 * The feature id for the '<em><b>SElements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__SELEMENTS = GraphPackage.GRAPH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SRelations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__SRELATIONS = GraphPackage.GRAPH_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SCore Project</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__SCORE_PROJECT = GraphPackage.GRAPH_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>SGraph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH_FEATURE_COUNT = GraphPackage.GRAPH_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.saltCore.impl.SStereotypeContainerImpl <em>SStereotype Container</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.saltCore.impl.SStereotypeContainerImpl
	 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSStereotypeContainer()
	 * @generated
	 */
	int SSTEREOTYPE_CONTAINER = 12;

	/**
	 * The feature id for the '<em><b>SStereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTEREOTYPE_CONTAINER__SSTEREOTYPES = 0;

	/**
	 * The number of structural features of the '<em>SStereotype Container</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTEREOTYPE_CONTAINER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.saltCore.impl.SCoreProjectImpl <em>SCore Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.saltCore.impl.SCoreProjectImpl
	 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSCoreProject()
	 * @generated
	 */
	int SCORE_PROJECT = 11;

	/**
	 * The feature id for the '<em><b>SStereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORE_PROJECT__SSTEREOTYPES = SSTEREOTYPE_CONTAINER__SSTEREOTYPES;

	/**
	 * The feature id for the '<em><b>SGraphs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORE_PROJECT__SGRAPHS = SSTEREOTYPE_CONTAINER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SStereotype Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORE_PROJECT__SSTEREOTYPE_CONTAINER = SSTEREOTYPE_CONTAINER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>SCore Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORE_PROJECT_FEATURE_COUNT = SSTEREOTYPE_CONTAINER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.saltCore.impl.SProcessingAnnotatableElementImpl <em>SProcessing Annotatable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.saltCore.impl.SProcessingAnnotatableElementImpl
	 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSProcessingAnnotatableElement()
	 * @generated
	 */
	int SPROCESSING_ANNOTATABLE_ELEMENT = 13;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROCESSING_ANNOTATABLE_ELEMENT__LABELS = GraphPackage.LABELABLE_ELEMENT__LABELS;

	/**
	 * The feature id for the '<em><b>Num Of Labels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROCESSING_ANNOTATABLE_ELEMENT__NUM_OF_LABELS = GraphPackage.LABELABLE_ELEMENT__NUM_OF_LABELS;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROCESSING_ANNOTATABLE_ELEMENT__SPROCESSING_ANNOTATIONS = GraphPackage.LABELABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SProcessing Annotatable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROCESSING_ANNOTATABLE_ELEMENT_FEATURE_COUNT = GraphPackage.LABELABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.saltCore.impl.SProcessingAnnotationImpl <em>SProcessing Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.saltCore.impl.SProcessingAnnotationImpl
	 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSProcessingAnnotation()
	 * @generated
	 */
	int SPROCESSING_ANNOTATION = 14;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROCESSING_ANNOTATION__NAMESPACE = GraphPackage.LABEL__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROCESSING_ANNOTATION__NAME = GraphPackage.LABEL__NAME;

	/**
	 * The feature id for the '<em><b>Full Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROCESSING_ANNOTATION__FULL_NAME = GraphPackage.LABEL__FULL_NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROCESSING_ANNOTATION__VALUE = GraphPackage.LABEL__VALUE;

	/**
	 * The feature id for the '<em><b>Label Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROCESSING_ANNOTATION__LABEL_OWNER = GraphPackage.LABEL__LABEL_OWNER;

	/**
	 * The number of structural features of the '<em>SProcessing Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROCESSING_ANNOTATION_FEATURE_COUNT = GraphPackage.LABEL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.saltCore.STraversalObject <em>STraversal Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.saltCore.STraversalObject
	 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSTraversalObject()
	 * @generated
	 */
	int STRAVERSAL_OBJECT = 15;

	/**
	 * The number of structural features of the '<em>STraversal Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRAVERSAL_OBJECT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.saltCore.STRAVERSAL_MODE <em>STRAVERSAL MODE</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.saltCore.STRAVERSAL_MODE
	 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSTRAVERSAL_MODE()
	 * @generated
	 */
	int STRAVERSAL_MODE = 16;

	/**
	 * The meta object id for the '<em>Properties</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.Properties
	 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getProperties()
	 * @generated
	 */
	int PROPERTIES = 17;


	/**
	 * Returns the meta object for class '{@link de.corpling.salt.model.saltCore.SIdentifiableElement <em>SIdentifiable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SIdentifiable Element</em>'.
	 * @see de.corpling.salt.model.saltCore.SIdentifiableElement
	 * @generated
	 */
	EClass getSIdentifiableElement();

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.model.saltCore.SElement <em>SElement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SElement</em>'.
	 * @see de.corpling.salt.model.saltCore.SElement
	 * @generated
	 */
	EClass getSElement();

	/**
	 * Returns the meta object for the containment reference '{@link de.corpling.salt.model.saltCore.SElement#getSSterotypeableElement <em>SSterotypeable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>SSterotypeable Element</em>'.
	 * @see de.corpling.salt.model.saltCore.SElement#getSSterotypeableElement()
	 * @see #getSElement()
	 * @generated
	 */
	EReference getSElement_SSterotypeableElement();

	/**
	 * Returns the meta object for the containment reference '{@link de.corpling.salt.model.saltCore.SElement#getSAnnotatableElement <em>SAnnotatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>SAnnotatable Element</em>'.
	 * @see de.corpling.salt.model.saltCore.SElement#getSAnnotatableElement()
	 * @see #getSElement()
	 * @generated
	 */
	EReference getSElement_SAnnotatableElement();

	/**
	 * Returns the meta object for the containment reference '{@link de.corpling.salt.model.saltCore.SElement#getSProcessingAnnotatableElement <em>SProcessing Annotatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>SProcessing Annotatable Element</em>'.
	 * @see de.corpling.salt.model.saltCore.SElement#getSProcessingAnnotatableElement()
	 * @see #getSElement()
	 * @generated
	 */
	EReference getSElement_SProcessingAnnotatableElement();

	/**
	 * Returns the meta object for the container reference '{@link de.corpling.salt.model.saltCore.SElement#getSGraph <em>SGraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SGraph</em>'.
	 * @see de.corpling.salt.model.saltCore.SElement#getSGraph()
	 * @see #getSElement()
	 * @generated
	 */
	EReference getSElement_SGraph();

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.model.saltCore.SAnnotation <em>SAnnotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SAnnotation</em>'.
	 * @see de.corpling.salt.model.saltCore.SAnnotation
	 * @generated
	 */
	EClass getSAnnotation();

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.model.saltCore.SAnnotatableElement <em>SAnnotatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SAnnotatable Element</em>'.
	 * @see de.corpling.salt.model.saltCore.SAnnotatableElement
	 * @generated
	 */
	EClass getSAnnotatableElement();

	/**
	 * Returns the meta object for the containment reference list '{@link de.corpling.salt.model.saltCore.SAnnotatableElement#getSAnnotations <em>SAnnotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SAnnotations</em>'.
	 * @see de.corpling.salt.model.saltCore.SAnnotatableElement#getSAnnotations()
	 * @see #getSAnnotatableElement()
	 * @generated
	 */
	EReference getSAnnotatableElement_SAnnotations();

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.model.saltCore.SRelation <em>SRelation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SRelation</em>'.
	 * @see de.corpling.salt.model.saltCore.SRelation
	 * @generated
	 */
	EClass getSRelation();

	/**
	 * Returns the meta object for the reference '{@link de.corpling.salt.model.saltCore.SRelation#getSSourceElement <em>SSource Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SSource Element</em>'.
	 * @see de.corpling.salt.model.saltCore.SRelation#getSSourceElement()
	 * @see #getSRelation()
	 * @generated
	 */
	EReference getSRelation_SSourceElement();

	/**
	 * Returns the meta object for the reference '{@link de.corpling.salt.model.saltCore.SRelation#getSDestinationElement <em>SDestination Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SDestination Element</em>'.
	 * @see de.corpling.salt.model.saltCore.SRelation#getSDestinationElement()
	 * @see #getSRelation()
	 * @generated
	 */
	EReference getSRelation_SDestinationElement();

	/**
	 * Returns the meta object for the containment reference '{@link de.corpling.salt.model.saltCore.SRelation#getSStereotypableElement <em>SStereotypable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>SStereotypable Element</em>'.
	 * @see de.corpling.salt.model.saltCore.SRelation#getSStereotypableElement()
	 * @see #getSRelation()
	 * @generated
	 */
	EReference getSRelation_SStereotypableElement();

	/**
	 * Returns the meta object for the containment reference '{@link de.corpling.salt.model.saltCore.SRelation#getSAnnotatableElement <em>SAnnotatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>SAnnotatable Element</em>'.
	 * @see de.corpling.salt.model.saltCore.SRelation#getSAnnotatableElement()
	 * @see #getSRelation()
	 * @generated
	 */
	EReference getSRelation_SAnnotatableElement();

	/**
	 * Returns the meta object for the containment reference '{@link de.corpling.salt.model.saltCore.SRelation#getSProcessingAnnotatableElement <em>SProcessing Annotatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>SProcessing Annotatable Element</em>'.
	 * @see de.corpling.salt.model.saltCore.SRelation#getSProcessingAnnotatableElement()
	 * @see #getSRelation()
	 * @generated
	 */
	EReference getSRelation_SProcessingAnnotatableElement();

	/**
	 * Returns the meta object for the container reference '{@link de.corpling.salt.model.saltCore.SRelation#getSGraph <em>SGraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SGraph</em>'.
	 * @see de.corpling.salt.model.saltCore.SRelation#getSGraph()
	 * @see #getSRelation()
	 * @generated
	 */
	EReference getSRelation_SGraph();

	/**
	 * Returns the meta object for the attribute '{@link de.corpling.salt.model.saltCore.SRelation#getSType <em>SType</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SType</em>'.
	 * @see de.corpling.salt.model.saltCore.SRelation#getSType()
	 * @see #getSRelation()
	 * @generated
	 */
	EAttribute getSRelation_SType();

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.model.saltCore.SNamedElement <em>SNamed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SNamed Element</em>'.
	 * @see de.corpling.salt.model.saltCore.SNamedElement
	 * @generated
	 */
	EClass getSNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link de.corpling.salt.model.saltCore.SNamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.corpling.salt.model.saltCore.SNamedElement#getName()
	 * @see #getSNamedElement()
	 * @generated
	 */
	EAttribute getSNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.model.saltCore.SStereotypeableElement <em>SStereotypeable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SStereotypeable Element</em>'.
	 * @see de.corpling.salt.model.saltCore.SStereotypeableElement
	 * @generated
	 */
	EClass getSStereotypeableElement();

	/**
	 * Returns the meta object for the reference '{@link de.corpling.salt.model.saltCore.SStereotypeableElement#getSStereotype <em>SStereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SStereotype</em>'.
	 * @see de.corpling.salt.model.saltCore.SStereotypeableElement#getSStereotype()
	 * @see #getSStereotypeableElement()
	 * @generated
	 */
	EReference getSStereotypeableElement_SStereotype();

	/**
	 * Returns the meta object for the containment reference list '{@link de.corpling.salt.model.saltCore.SStereotypeableElement#getSFeatures <em>SFeatures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SFeatures</em>'.
	 * @see de.corpling.salt.model.saltCore.SStereotypeableElement#getSFeatures()
	 * @see #getSStereotypeableElement()
	 * @generated
	 */
	EReference getSStereotypeableElement_SFeatures();

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.model.saltCore.SFeature <em>SFeature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SFeature</em>'.
	 * @see de.corpling.salt.model.saltCore.SFeature
	 * @generated
	 */
	EClass getSFeature();

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.model.saltCore.SStereotype <em>SStereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SStereotype</em>'.
	 * @see de.corpling.salt.model.saltCore.SStereotype
	 * @generated
	 */
	EClass getSStereotype();

	/**
	 * Returns the meta object for the attribute '{@link de.corpling.salt.model.saltCore.SStereotype#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.corpling.salt.model.saltCore.SStereotype#getName()
	 * @see #getSStereotype()
	 * @generated
	 */
	EAttribute getSStereotype_Name();

	/**
	 * Returns the meta object for the containment reference '{@link de.corpling.salt.model.saltCore.SStereotype#getSFeatureDescriptions <em>SFeature Descriptions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>SFeature Descriptions</em>'.
	 * @see de.corpling.salt.model.saltCore.SStereotype#getSFeatureDescriptions()
	 * @see #getSStereotype()
	 * @generated
	 */
	EReference getSStereotype_SFeatureDescriptions();

	/**
	 * Returns the meta object for the reference '{@link de.corpling.salt.model.saltCore.SStereotype#getSSuperStereotype <em>SSuper Stereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SSuper Stereotype</em>'.
	 * @see de.corpling.salt.model.saltCore.SStereotype#getSSuperStereotype()
	 * @see #getSStereotype()
	 * @generated
	 */
	EReference getSStereotype_SSuperStereotype();

	/**
	 * Returns the meta object for the container reference '{@link de.corpling.salt.model.saltCore.SStereotype#getSProject <em>SProject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SProject</em>'.
	 * @see de.corpling.salt.model.saltCore.SStereotype#getSProject()
	 * @see #getSStereotype()
	 * @generated
	 */
	EReference getSStereotype_SProject();

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.model.saltCore.SFeatureDescription <em>SFeature Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SFeature Description</em>'.
	 * @see de.corpling.salt.model.saltCore.SFeatureDescription
	 * @generated
	 */
	EClass getSFeatureDescription();

	/**
	 * Returns the meta object for the attribute '{@link de.corpling.salt.model.saltCore.SFeatureDescription#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.corpling.salt.model.saltCore.SFeatureDescription#getName()
	 * @see #getSFeatureDescription()
	 * @generated
	 */
	EAttribute getSFeatureDescription_Name();

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.model.saltCore.SGraph <em>SGraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SGraph</em>'.
	 * @see de.corpling.salt.model.saltCore.SGraph
	 * @generated
	 */
	EClass getSGraph();

	/**
	 * Returns the meta object for the containment reference list '{@link de.corpling.salt.model.saltCore.SGraph#getSElements <em>SElements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SElements</em>'.
	 * @see de.corpling.salt.model.saltCore.SGraph#getSElements()
	 * @see #getSGraph()
	 * @generated
	 */
	EReference getSGraph_SElements();

	/**
	 * Returns the meta object for the containment reference list '{@link de.corpling.salt.model.saltCore.SGraph#getSRelations <em>SRelations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SRelations</em>'.
	 * @see de.corpling.salt.model.saltCore.SGraph#getSRelations()
	 * @see #getSGraph()
	 * @generated
	 */
	EReference getSGraph_SRelations();

	/**
	 * Returns the meta object for the container reference '{@link de.corpling.salt.model.saltCore.SGraph#getSCoreProject <em>SCore Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SCore Project</em>'.
	 * @see de.corpling.salt.model.saltCore.SGraph#getSCoreProject()
	 * @see #getSGraph()
	 * @generated
	 */
	EReference getSGraph_SCoreProject();

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.model.saltCore.SCoreProject <em>SCore Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCore Project</em>'.
	 * @see de.corpling.salt.model.saltCore.SCoreProject
	 * @generated
	 */
	EClass getSCoreProject();

	/**
	 * Returns the meta object for the containment reference list '{@link de.corpling.salt.model.saltCore.SCoreProject#getSGraphs <em>SGraphs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SGraphs</em>'.
	 * @see de.corpling.salt.model.saltCore.SCoreProject#getSGraphs()
	 * @see #getSCoreProject()
	 * @generated
	 */
	EReference getSCoreProject_SGraphs();

	/**
	 * Returns the meta object for the containment reference '{@link de.corpling.salt.model.saltCore.SCoreProject#getSStereotypeContainer <em>SStereotype Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>SStereotype Container</em>'.
	 * @see de.corpling.salt.model.saltCore.SCoreProject#getSStereotypeContainer()
	 * @see #getSCoreProject()
	 * @generated
	 */
	EReference getSCoreProject_SStereotypeContainer();

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.model.saltCore.SStereotypeContainer <em>SStereotype Container</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SStereotype Container</em>'.
	 * @see de.corpling.salt.model.saltCore.SStereotypeContainer
	 * @generated
	 */
	EClass getSStereotypeContainer();

	/**
	 * Returns the meta object for the containment reference list '{@link de.corpling.salt.model.saltCore.SStereotypeContainer#getSStereotypes <em>SStereotypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SStereotypes</em>'.
	 * @see de.corpling.salt.model.saltCore.SStereotypeContainer#getSStereotypes()
	 * @see #getSStereotypeContainer()
	 * @generated
	 */
	EReference getSStereotypeContainer_SStereotypes();

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.model.saltCore.SProcessingAnnotatableElement <em>SProcessing Annotatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SProcessing Annotatable Element</em>'.
	 * @see de.corpling.salt.model.saltCore.SProcessingAnnotatableElement
	 * @generated
	 */
	EClass getSProcessingAnnotatableElement();

	/**
	 * Returns the meta object for the containment reference list '{@link de.corpling.salt.model.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotations <em>SProcessing Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SProcessing Annotations</em>'.
	 * @see de.corpling.salt.model.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotations()
	 * @see #getSProcessingAnnotatableElement()
	 * @generated
	 */
	EReference getSProcessingAnnotatableElement_SProcessingAnnotations();

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.model.saltCore.SProcessingAnnotation <em>SProcessing Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SProcessing Annotation</em>'.
	 * @see de.corpling.salt.model.saltCore.SProcessingAnnotation
	 * @generated
	 */
	EClass getSProcessingAnnotation();

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.model.saltCore.STraversalObject <em>STraversal Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>STraversal Object</em>'.
	 * @see de.corpling.salt.model.saltCore.STraversalObject
	 * @generated
	 */
	EClass getSTraversalObject();

	/**
	 * Returns the meta object for enum '{@link de.corpling.salt.model.saltCore.STRAVERSAL_MODE <em>STRAVERSAL MODE</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>STRAVERSAL MODE</em>'.
	 * @see de.corpling.salt.model.saltCore.STRAVERSAL_MODE
	 * @generated
	 */
	EEnum getSTRAVERSAL_MODE();

	/**
	 * Returns the meta object for data type '{@link java.util.Properties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Properties</em>'.
	 * @see java.util.Properties
	 * @model instanceClass="java.util.Properties"
	 * @generated
	 */
	EDataType getProperties();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SaltCoreFactory getSaltCoreFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.corpling.salt.model.saltCore.impl.SIdentifiableElementImpl <em>SIdentifiable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.saltCore.impl.SIdentifiableElementImpl
		 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSIdentifiableElement()
		 * @generated
		 */
		EClass SIDENTIFIABLE_ELEMENT = eINSTANCE.getSIdentifiableElement();

		/**
		 * The meta object literal for the '{@link de.corpling.salt.model.saltCore.impl.SElementImpl <em>SElement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.saltCore.impl.SElementImpl
		 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSElement()
		 * @generated
		 */
		EClass SELEMENT = eINSTANCE.getSElement();

		/**
		 * The meta object literal for the '<em><b>SSterotypeable Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELEMENT__SSTEROTYPEABLE_ELEMENT = eINSTANCE.getSElement_SSterotypeableElement();

		/**
		 * The meta object literal for the '<em><b>SAnnotatable Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELEMENT__SANNOTATABLE_ELEMENT = eINSTANCE.getSElement_SAnnotatableElement();

		/**
		 * The meta object literal for the '<em><b>SProcessing Annotatable Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELEMENT__SPROCESSING_ANNOTATABLE_ELEMENT = eINSTANCE.getSElement_SProcessingAnnotatableElement();

		/**
		 * The meta object literal for the '<em><b>SGraph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELEMENT__SGRAPH = eINSTANCE.getSElement_SGraph();

		/**
		 * The meta object literal for the '{@link de.corpling.salt.model.saltCore.impl.SAnnotationImpl <em>SAnnotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.saltCore.impl.SAnnotationImpl
		 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSAnnotation()
		 * @generated
		 */
		EClass SANNOTATION = eINSTANCE.getSAnnotation();

		/**
		 * The meta object literal for the '{@link de.corpling.salt.model.saltCore.impl.SAnnotatableElementImpl <em>SAnnotatable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.saltCore.impl.SAnnotatableElementImpl
		 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSAnnotatableElement()
		 * @generated
		 */
		EClass SANNOTATABLE_ELEMENT = eINSTANCE.getSAnnotatableElement();

		/**
		 * The meta object literal for the '<em><b>SAnnotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SANNOTATABLE_ELEMENT__SANNOTATIONS = eINSTANCE.getSAnnotatableElement_SAnnotations();

		/**
		 * The meta object literal for the '{@link de.corpling.salt.model.saltCore.impl.SRelationImpl <em>SRelation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.saltCore.impl.SRelationImpl
		 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSRelation()
		 * @generated
		 */
		EClass SRELATION = eINSTANCE.getSRelation();

		/**
		 * The meta object literal for the '<em><b>SSource Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SRELATION__SSOURCE_ELEMENT = eINSTANCE.getSRelation_SSourceElement();

		/**
		 * The meta object literal for the '<em><b>SDestination Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SRELATION__SDESTINATION_ELEMENT = eINSTANCE.getSRelation_SDestinationElement();

		/**
		 * The meta object literal for the '<em><b>SStereotypable Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SRELATION__SSTEREOTYPABLE_ELEMENT = eINSTANCE.getSRelation_SStereotypableElement();

		/**
		 * The meta object literal for the '<em><b>SAnnotatable Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SRELATION__SANNOTATABLE_ELEMENT = eINSTANCE.getSRelation_SAnnotatableElement();

		/**
		 * The meta object literal for the '<em><b>SProcessing Annotatable Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SRELATION__SPROCESSING_ANNOTATABLE_ELEMENT = eINSTANCE.getSRelation_SProcessingAnnotatableElement();

		/**
		 * The meta object literal for the '<em><b>SGraph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SRELATION__SGRAPH = eINSTANCE.getSRelation_SGraph();

		/**
		 * The meta object literal for the '<em><b>SType</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SRELATION__STYPE = eINSTANCE.getSRelation_SType();

		/**
		 * The meta object literal for the '{@link de.corpling.salt.model.saltCore.impl.SNamedElementImpl <em>SNamed Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.saltCore.impl.SNamedElementImpl
		 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSNamedElement()
		 * @generated
		 */
		EClass SNAMED_ELEMENT = eINSTANCE.getSNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SNAMED_ELEMENT__NAME = eINSTANCE.getSNamedElement_Name();

		/**
		 * The meta object literal for the '{@link de.corpling.salt.model.saltCore.impl.SStereotypeableElementImpl <em>SStereotypeable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.saltCore.impl.SStereotypeableElementImpl
		 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSStereotypeableElement()
		 * @generated
		 */
		EClass SSTEREOTYPEABLE_ELEMENT = eINSTANCE.getSStereotypeableElement();

		/**
		 * The meta object literal for the '<em><b>SStereotype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SSTEREOTYPEABLE_ELEMENT__SSTEREOTYPE = eINSTANCE.getSStereotypeableElement_SStereotype();

		/**
		 * The meta object literal for the '<em><b>SFeatures</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SSTEREOTYPEABLE_ELEMENT__SFEATURES = eINSTANCE.getSStereotypeableElement_SFeatures();

		/**
		 * The meta object literal for the '{@link de.corpling.salt.model.saltCore.impl.SFeatureImpl <em>SFeature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.saltCore.impl.SFeatureImpl
		 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSFeature()
		 * @generated
		 */
		EClass SFEATURE = eINSTANCE.getSFeature();

		/**
		 * The meta object literal for the '{@link de.corpling.salt.model.saltCore.impl.SStereotypeImpl <em>SStereotype</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.saltCore.impl.SStereotypeImpl
		 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSStereotype()
		 * @generated
		 */
		EClass SSTEREOTYPE = eINSTANCE.getSStereotype();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SSTEREOTYPE__NAME = eINSTANCE.getSStereotype_Name();

		/**
		 * The meta object literal for the '<em><b>SFeature Descriptions</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SSTEREOTYPE__SFEATURE_DESCRIPTIONS = eINSTANCE.getSStereotype_SFeatureDescriptions();

		/**
		 * The meta object literal for the '<em><b>SSuper Stereotype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SSTEREOTYPE__SSUPER_STEREOTYPE = eINSTANCE.getSStereotype_SSuperStereotype();

		/**
		 * The meta object literal for the '<em><b>SProject</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SSTEREOTYPE__SPROJECT = eINSTANCE.getSStereotype_SProject();

		/**
		 * The meta object literal for the '{@link de.corpling.salt.model.saltCore.impl.SFeatureDescriptionImpl <em>SFeature Description</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.saltCore.impl.SFeatureDescriptionImpl
		 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSFeatureDescription()
		 * @generated
		 */
		EClass SFEATURE_DESCRIPTION = eINSTANCE.getSFeatureDescription();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SFEATURE_DESCRIPTION__NAME = eINSTANCE.getSFeatureDescription_Name();

		/**
		 * The meta object literal for the '{@link de.corpling.salt.model.saltCore.impl.SGraphImpl <em>SGraph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.saltCore.impl.SGraphImpl
		 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSGraph()
		 * @generated
		 */
		EClass SGRAPH = eINSTANCE.getSGraph();

		/**
		 * The meta object literal for the '<em><b>SElements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SGRAPH__SELEMENTS = eINSTANCE.getSGraph_SElements();

		/**
		 * The meta object literal for the '<em><b>SRelations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SGRAPH__SRELATIONS = eINSTANCE.getSGraph_SRelations();

		/**
		 * The meta object literal for the '<em><b>SCore Project</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SGRAPH__SCORE_PROJECT = eINSTANCE.getSGraph_SCoreProject();

		/**
		 * The meta object literal for the '{@link de.corpling.salt.model.saltCore.impl.SCoreProjectImpl <em>SCore Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.saltCore.impl.SCoreProjectImpl
		 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSCoreProject()
		 * @generated
		 */
		EClass SCORE_PROJECT = eINSTANCE.getSCoreProject();

		/**
		 * The meta object literal for the '<em><b>SGraphs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORE_PROJECT__SGRAPHS = eINSTANCE.getSCoreProject_SGraphs();

		/**
		 * The meta object literal for the '<em><b>SStereotype Container</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORE_PROJECT__SSTEREOTYPE_CONTAINER = eINSTANCE.getSCoreProject_SStereotypeContainer();

		/**
		 * The meta object literal for the '{@link de.corpling.salt.model.saltCore.impl.SStereotypeContainerImpl <em>SStereotype Container</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.saltCore.impl.SStereotypeContainerImpl
		 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSStereotypeContainer()
		 * @generated
		 */
		EClass SSTEREOTYPE_CONTAINER = eINSTANCE.getSStereotypeContainer();

		/**
		 * The meta object literal for the '<em><b>SStereotypes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SSTEREOTYPE_CONTAINER__SSTEREOTYPES = eINSTANCE.getSStereotypeContainer_SStereotypes();

		/**
		 * The meta object literal for the '{@link de.corpling.salt.model.saltCore.impl.SProcessingAnnotatableElementImpl <em>SProcessing Annotatable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.saltCore.impl.SProcessingAnnotatableElementImpl
		 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSProcessingAnnotatableElement()
		 * @generated
		 */
		EClass SPROCESSING_ANNOTATABLE_ELEMENT = eINSTANCE.getSProcessingAnnotatableElement();

		/**
		 * The meta object literal for the '<em><b>SProcessing Annotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPROCESSING_ANNOTATABLE_ELEMENT__SPROCESSING_ANNOTATIONS = eINSTANCE.getSProcessingAnnotatableElement_SProcessingAnnotations();

		/**
		 * The meta object literal for the '{@link de.corpling.salt.model.saltCore.impl.SProcessingAnnotationImpl <em>SProcessing Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.saltCore.impl.SProcessingAnnotationImpl
		 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSProcessingAnnotation()
		 * @generated
		 */
		EClass SPROCESSING_ANNOTATION = eINSTANCE.getSProcessingAnnotation();

		/**
		 * The meta object literal for the '{@link de.corpling.salt.model.saltCore.STraversalObject <em>STraversal Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.saltCore.STraversalObject
		 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSTraversalObject()
		 * @generated
		 */
		EClass STRAVERSAL_OBJECT = eINSTANCE.getSTraversalObject();

		/**
		 * The meta object literal for the '{@link de.corpling.salt.model.saltCore.STRAVERSAL_MODE <em>STRAVERSAL MODE</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.saltCore.STRAVERSAL_MODE
		 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getSTRAVERSAL_MODE()
		 * @generated
		 */
		EEnum STRAVERSAL_MODE = eINSTANCE.getSTRAVERSAL_MODE();

		/**
		 * The meta object literal for the '<em>Properties</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.Properties
		 * @see de.corpling.salt.model.saltCore.impl.SaltCorePackageImpl#getProperties()
		 * @generated
		 */
		EDataType PROPERTIES = eINSTANCE.getProperties();

	}

} //SaltCorePackage
