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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCore;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage;

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
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCoreFactory
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
	String eNS_URI = "saltCore";

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
	SaltCorePackage eINSTANCE = de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SNodeImpl <em>SNode</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SNodeImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSNode()
	 * @generated
	 */
	int SNODE = 0;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNODE__LABELS = GraphPackage.NODE__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNODE__ID = GraphPackage.NODE__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNODE__IDENTIFIER = GraphPackage.NODE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNODE__GRAPH = GraphPackage.NODE__GRAPH;

	/**
	 * The feature id for the '<em><b>Layers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNODE__LAYERS = GraphPackage.NODE__LAYERS;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNODE__SANNOTATIONS = GraphPackage.NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNODE__SNAME = GraphPackage.NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNODE__SELEMENT_ID = GraphPackage.NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNODE__SID = GraphPackage.NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNODE__SELEMENT_PATH = GraphPackage.NODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNODE__SPROCESSING_ANNOTATIONS = GraphPackage.NODE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNODE__SFEATURES = GraphPackage.NODE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>SMeta Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNODE__SMETA_ANNOTATIONS = GraphPackage.NODE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNODE__SGRAPH = GraphPackage.NODE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>SLayers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNODE__SLAYERS = GraphPackage.NODE_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>SNode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNODE_FEATURE_COUNT = GraphPackage.NODE_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SRelationImpl <em>SRelation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SRelationImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSRelation()
	 * @generated
	 */
	int SRELATION = 1;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__LABELS = GraphPackage.EDGE__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__ID = GraphPackage.EDGE__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__IDENTIFIER = GraphPackage.EDGE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__GRAPH = GraphPackage.EDGE__GRAPH;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__SOURCE = GraphPackage.EDGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__TARGET = GraphPackage.EDGE__TARGET;

	/**
	 * The feature id for the '<em><b>Layers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__LAYERS = GraphPackage.EDGE__LAYERS;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__SANNOTATIONS = GraphPackage.EDGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__SNAME = GraphPackage.EDGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__SELEMENT_ID = GraphPackage.EDGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__SID = GraphPackage.EDGE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__SELEMENT_PATH = GraphPackage.EDGE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__SPROCESSING_ANNOTATIONS = GraphPackage.EDGE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__SFEATURES = GraphPackage.EDGE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>SMeta Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__SMETA_ANNOTATIONS = GraphPackage.EDGE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>SSource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__SSOURCE = GraphPackage.EDGE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>STarget</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__STARGET = GraphPackage.EDGE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__SGRAPH = GraphPackage.EDGE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>STypes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__STYPES = GraphPackage.EDGE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>SLayers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__SLAYERS = GraphPackage.EDGE_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>SRelation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION_FEATURE_COUNT = GraphPackage.EDGE_FEATURE_COUNT + 13;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SAnnotatableElementImpl <em>SAnnotatable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SAnnotatableElementImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSAnnotatableElement()
	 * @generated
	 */
	int SANNOTATABLE_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATABLE_ELEMENT__LABELS = GraphPackage.LABELABLE_ELEMENT__LABELS;

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
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SAnnotationImpl <em>SAnnotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SAnnotationImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSAnnotation()
	 * @generated
	 */
	int SANNOTATION = 3;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SGraphImpl <em>SGraph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SGraphImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSGraph()
	 * @generated
	 */
	int SGRAPH = 4;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SNamedElementImpl <em>SNamed Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SNamedElementImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSNamedElement()
	 * @generated
	 */
	int SNAMED_ELEMENT = 5;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SIdentifiableElementImpl <em>SIdentifiable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SIdentifiableElementImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSIdentifiableElement()
	 * @generated
	 */
	int SIDENTIFIABLE_ELEMENT = 6;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SProcessingAnnotationImpl <em>SProcessing Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SProcessingAnnotationImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSProcessingAnnotation()
	 * @generated
	 */
	int SPROCESSING_ANNOTATION = 7;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SProcessingAnnotatableElementImpl <em>SProcessing Annotatable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SProcessingAnnotatableElementImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSProcessingAnnotatableElement()
	 * @generated
	 */
	int SPROCESSING_ANNOTATABLE_ELEMENT = 8;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SElementIdImpl <em>SElement Id</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SElementIdImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSElementId()
	 * @generated
	 */
	int SELEMENT_ID = 9;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SFeatureImpl <em>SFeature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SFeatureImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSFeature()
	 * @generated
	 */
	int SFEATURE = 10;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SFeaturableElementImpl <em>SFeaturable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SFeaturableElementImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSFeaturableElement()
	 * @generated
	 */
	int SFEATURABLE_ELEMENT = 11;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SMetaAnnotatableElementImpl <em>SMeta Annotatable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SMetaAnnotatableElementImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSMetaAnnotatableElement()
	 * @generated
	 */
	int SMETA_ANNOTATABLE_ELEMENT = 12;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SMetaAnnotationImpl <em>SMeta Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SMetaAnnotationImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSMetaAnnotation()
	 * @generated
	 */
	int SMETA_ANNOTATION = 13;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SAbstractAnnotationImpl <em>SAbstract Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SAbstractAnnotationImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSAbstractAnnotation()
	 * @generated
	 */
	int SABSTRACT_ANNOTATION = 14;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SABSTRACT_ANNOTATION__LABELS = GraphPackage.LABEL__LABELS;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SABSTRACT_ANNOTATION__NAMESPACE = GraphPackage.LABEL__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SABSTRACT_ANNOTATION__NAME = GraphPackage.LABEL__NAME;

	/**
	 * The feature id for the '<em><b>QName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SABSTRACT_ANNOTATION__QNAME = GraphPackage.LABEL__QNAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SABSTRACT_ANNOTATION__VALUE = GraphPackage.LABEL__VALUE;

	/**
	 * The feature id for the '<em><b>Labelable Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SABSTRACT_ANNOTATION__LABELABLE_ELEMENT = GraphPackage.LABEL__LABELABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Value String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SABSTRACT_ANNOTATION__VALUE_STRING = GraphPackage.LABEL__VALUE_STRING;

	/**
	 * The feature id for the '<em><b>SNS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SABSTRACT_ANNOTATION__SNS = GraphPackage.LABEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SABSTRACT_ANNOTATION__SNAME = GraphPackage.LABEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SValue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SABSTRACT_ANNOTATION__SVALUE = GraphPackage.LABEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>SValue Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SABSTRACT_ANNOTATION__SVALUE_TYPE = GraphPackage.LABEL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>SAbstract Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SABSTRACT_ANNOTATION_FEATURE_COUNT = GraphPackage.LABEL_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATION__LABELS = SABSTRACT_ANNOTATION__LABELS;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATION__NAMESPACE = SABSTRACT_ANNOTATION__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATION__NAME = SABSTRACT_ANNOTATION__NAME;

	/**
	 * The feature id for the '<em><b>QName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATION__QNAME = SABSTRACT_ANNOTATION__QNAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATION__VALUE = SABSTRACT_ANNOTATION__VALUE;

	/**
	 * The feature id for the '<em><b>Labelable Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATION__LABELABLE_ELEMENT = SABSTRACT_ANNOTATION__LABELABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Value String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATION__VALUE_STRING = SABSTRACT_ANNOTATION__VALUE_STRING;

	/**
	 * The feature id for the '<em><b>SNS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATION__SNS = SABSTRACT_ANNOTATION__SNS;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATION__SNAME = SABSTRACT_ANNOTATION__SNAME;

	/**
	 * The feature id for the '<em><b>SValue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATION__SVALUE = SABSTRACT_ANNOTATION__SVALUE;

	/**
	 * The feature id for the '<em><b>SValue Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATION__SVALUE_TYPE = SABSTRACT_ANNOTATION__SVALUE_TYPE;

	/**
	 * The feature id for the '<em><b>SAnnotatable Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATION__SANNOTATABLE_ELEMENT = SABSTRACT_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SAnnotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATION_FEATURE_COUNT = SABSTRACT_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__LABELS = GraphPackage.GRAPH__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__ID = GraphPackage.GRAPH__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__IDENTIFIER = GraphPackage.GRAPH__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Index Mgr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__INDEX_MGR = GraphPackage.GRAPH__INDEX_MGR;

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
	 * The feature id for the '<em><b>Layers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__LAYERS = GraphPackage.GRAPH__LAYERS;

	/**
	 * The feature id for the '<em><b>Num Of Layers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__NUM_OF_LAYERS = GraphPackage.GRAPH__NUM_OF_LAYERS;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__SNAME = GraphPackage.GRAPH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__SANNOTATIONS = GraphPackage.GRAPH_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__SELEMENT_ID = GraphPackage.GRAPH_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__SID = GraphPackage.GRAPH_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__SELEMENT_PATH = GraphPackage.GRAPH_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__SPROCESSING_ANNOTATIONS = GraphPackage.GRAPH_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__SFEATURES = GraphPackage.GRAPH_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>SMeta Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__SMETA_ANNOTATIONS = GraphPackage.GRAPH_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>SRelations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__SRELATIONS = GraphPackage.GRAPH_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>SNodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__SNODES = GraphPackage.GRAPH_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>SLayers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__SLAYERS = GraphPackage.GRAPH_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>SGraph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH_FEATURE_COUNT = GraphPackage.GRAPH_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAMED_ELEMENT__SNAME = 0;

	/**
	 * The number of structural features of the '<em>SNamed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIDENTIFIABLE_ELEMENT__LABELS = GraphPackage.IDENTIFIABLE_ELEMENT__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIDENTIFIABLE_ELEMENT__ID = GraphPackage.IDENTIFIABLE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIDENTIFIABLE_ELEMENT__IDENTIFIER = GraphPackage.IDENTIFIABLE_ELEMENT__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIDENTIFIABLE_ELEMENT__SELEMENT_ID = GraphPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIDENTIFIABLE_ELEMENT__SID = GraphPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIDENTIFIABLE_ELEMENT__SELEMENT_PATH = GraphPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>SIdentifiable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIDENTIFIABLE_ELEMENT_FEATURE_COUNT = GraphPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROCESSING_ANNOTATION__LABELS = SABSTRACT_ANNOTATION__LABELS;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROCESSING_ANNOTATION__NAMESPACE = SABSTRACT_ANNOTATION__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROCESSING_ANNOTATION__NAME = SABSTRACT_ANNOTATION__NAME;

	/**
	 * The feature id for the '<em><b>QName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROCESSING_ANNOTATION__QNAME = SABSTRACT_ANNOTATION__QNAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROCESSING_ANNOTATION__VALUE = SABSTRACT_ANNOTATION__VALUE;

	/**
	 * The feature id for the '<em><b>Labelable Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROCESSING_ANNOTATION__LABELABLE_ELEMENT = SABSTRACT_ANNOTATION__LABELABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Value String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROCESSING_ANNOTATION__VALUE_STRING = SABSTRACT_ANNOTATION__VALUE_STRING;

	/**
	 * The feature id for the '<em><b>SNS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROCESSING_ANNOTATION__SNS = SABSTRACT_ANNOTATION__SNS;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROCESSING_ANNOTATION__SNAME = SABSTRACT_ANNOTATION__SNAME;

	/**
	 * The feature id for the '<em><b>SValue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROCESSING_ANNOTATION__SVALUE = SABSTRACT_ANNOTATION__SVALUE;

	/**
	 * The feature id for the '<em><b>SValue Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROCESSING_ANNOTATION__SVALUE_TYPE = SABSTRACT_ANNOTATION__SVALUE_TYPE;

	/**
	 * The feature id for the '<em><b>SProcessing Annotatable Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROCESSING_ANNOTATION__SPROCESSING_ANNOTATABLE_ELEMENT = SABSTRACT_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SProcessing Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROCESSING_ANNOTATION_FEATURE_COUNT = SABSTRACT_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROCESSING_ANNOTATABLE_ELEMENT__LABELS = GraphPackage.LABELABLE_ELEMENT__LABELS;

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
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT_ID__LABELS = GraphPackage.IDENTIFIER__LABELS;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT_ID__NAMESPACE = GraphPackage.IDENTIFIER__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT_ID__NAME = GraphPackage.IDENTIFIER__NAME;

	/**
	 * The feature id for the '<em><b>QName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT_ID__QNAME = GraphPackage.IDENTIFIER__QNAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT_ID__VALUE = GraphPackage.IDENTIFIER__VALUE;

	/**
	 * The feature id for the '<em><b>Labelable Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT_ID__LABELABLE_ELEMENT = GraphPackage.IDENTIFIER__LABELABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Value String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT_ID__VALUE_STRING = GraphPackage.IDENTIFIER__VALUE_STRING;

	/**
	 * The feature id for the '<em><b>Identifiable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT_ID__IDENTIFIABLE_ELEMENT = GraphPackage.IDENTIFIER__IDENTIFIABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT_ID__ID = GraphPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>SIdentifiable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT_ID__SIDENTIFIABLE_ELEMENT = GraphPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT_ID__SID = GraphPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT_ID__SELEMENT_PATH = GraphPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>SElement Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT_ID_FEATURE_COUNT = GraphPackage.IDENTIFIER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SFEATURE__LABELS = SABSTRACT_ANNOTATION__LABELS;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SFEATURE__NAMESPACE = SABSTRACT_ANNOTATION__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SFEATURE__NAME = SABSTRACT_ANNOTATION__NAME;

	/**
	 * The feature id for the '<em><b>QName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SFEATURE__QNAME = SABSTRACT_ANNOTATION__QNAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SFEATURE__VALUE = SABSTRACT_ANNOTATION__VALUE;

	/**
	 * The feature id for the '<em><b>Labelable Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SFEATURE__LABELABLE_ELEMENT = SABSTRACT_ANNOTATION__LABELABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Value String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SFEATURE__VALUE_STRING = SABSTRACT_ANNOTATION__VALUE_STRING;

	/**
	 * The feature id for the '<em><b>SNS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SFEATURE__SNS = SABSTRACT_ANNOTATION__SNS;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SFEATURE__SNAME = SABSTRACT_ANNOTATION__SNAME;

	/**
	 * The feature id for the '<em><b>SValue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SFEATURE__SVALUE = SABSTRACT_ANNOTATION__SVALUE;

	/**
	 * The feature id for the '<em><b>SValue Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SFEATURE__SVALUE_TYPE = SABSTRACT_ANNOTATION__SVALUE_TYPE;

	/**
	 * The feature id for the '<em><b>SFeaturable Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SFEATURE__SFEATURABLE_ELEMENT = SABSTRACT_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SFeature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SFEATURE_FEATURE_COUNT = SABSTRACT_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SFEATURABLE_ELEMENT__LABELS = GraphPackage.LABELABLE_ELEMENT__LABELS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SFEATURABLE_ELEMENT__SFEATURES = GraphPackage.LABELABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SFeaturable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SFEATURABLE_ELEMENT_FEATURE_COUNT = GraphPackage.LABELABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMETA_ANNOTATABLE_ELEMENT__LABELS = GraphPackage.LABELABLE_ELEMENT__LABELS;

	/**
	 * The feature id for the '<em><b>SMeta Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMETA_ANNOTATABLE_ELEMENT__SMETA_ANNOTATIONS = GraphPackage.LABELABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SMeta Annotatable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMETA_ANNOTATABLE_ELEMENT_FEATURE_COUNT = GraphPackage.LABELABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMETA_ANNOTATION__LABELS = SABSTRACT_ANNOTATION__LABELS;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMETA_ANNOTATION__NAMESPACE = SABSTRACT_ANNOTATION__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMETA_ANNOTATION__NAME = SABSTRACT_ANNOTATION__NAME;

	/**
	 * The feature id for the '<em><b>QName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMETA_ANNOTATION__QNAME = SABSTRACT_ANNOTATION__QNAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMETA_ANNOTATION__VALUE = SABSTRACT_ANNOTATION__VALUE;

	/**
	 * The feature id for the '<em><b>Labelable Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMETA_ANNOTATION__LABELABLE_ELEMENT = SABSTRACT_ANNOTATION__LABELABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Value String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMETA_ANNOTATION__VALUE_STRING = SABSTRACT_ANNOTATION__VALUE_STRING;

	/**
	 * The feature id for the '<em><b>SNS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMETA_ANNOTATION__SNS = SABSTRACT_ANNOTATION__SNS;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMETA_ANNOTATION__SNAME = SABSTRACT_ANNOTATION__SNAME;

	/**
	 * The feature id for the '<em><b>SValue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMETA_ANNOTATION__SVALUE = SABSTRACT_ANNOTATION__SVALUE;

	/**
	 * The feature id for the '<em><b>SValue Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMETA_ANNOTATION__SVALUE_TYPE = SABSTRACT_ANNOTATION__SVALUE_TYPE;

	/**
	 * The feature id for the '<em><b>SMeta Annotatable Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMETA_ANNOTATION__SMETA_ANNOTATABLE_ELEMENT = SABSTRACT_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SMeta Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SMETA_ANNOTATION_FEATURE_COUNT = SABSTRACT_ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SLayerImpl <em>SLayer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SLayerImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSLayer()
	 * @generated
	 */
	int SLAYER = 15;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAYER__LABELS = GraphPackage.LAYER__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAYER__ID = GraphPackage.LAYER__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAYER__IDENTIFIER = GraphPackage.LAYER__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAYER__GRAPH = GraphPackage.LAYER__GRAPH;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAYER__NODES = GraphPackage.LAYER__NODES;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAYER__EDGES = GraphPackage.LAYER__EDGES;

	/**
	 * The feature id for the '<em><b>Super Layer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAYER__SUPER_LAYER = GraphPackage.LAYER__SUPER_LAYER;

	/**
	 * The feature id for the '<em><b>Sub Layers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAYER__SUB_LAYERS = GraphPackage.LAYER__SUB_LAYERS;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAYER__SNAME = GraphPackage.LAYER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAYER__SELEMENT_ID = GraphPackage.LAYER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAYER__SID = GraphPackage.LAYER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAYER__SELEMENT_PATH = GraphPackage.LAYER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAYER__SPROCESSING_ANNOTATIONS = GraphPackage.LAYER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAYER__SANNOTATIONS = GraphPackage.LAYER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>SMeta Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAYER__SMETA_ANNOTATIONS = GraphPackage.LAYER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAYER__SFEATURES = GraphPackage.LAYER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>SRelations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAYER__SRELATIONS = GraphPackage.LAYER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>SNodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAYER__SNODES = GraphPackage.LAYER_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAYER__SGRAPH = GraphPackage.LAYER_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>SSub Layers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAYER__SSUB_LAYERS = GraphPackage.LAYER_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>SSuper Layer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAYER__SSUPER_LAYER = GraphPackage.LAYER_FEATURE_COUNT + 12;

	/**
	 * The number of structural features of the '<em>SLayer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLAYER_FEATURE_COUNT = GraphPackage.LAYER_FEATURE_COUNT + 13;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE <em>SDATATYPE</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSDATATYPE()
	 * @generated
	 */
	int SDATATYPE = 16;

	/**
	 * The meta object id for the '<em>URI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.URI
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getURI()
	 * @generated
	 */
	int URI = 17;


	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode <em>SNode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SNode</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode
	 * @generated
	 */
	EClass getSNode();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode#getSGraph <em>SGraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SGraph</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode#getSGraph()
	 * @see #getSNode()
	 * @generated
	 */
	EReference getSNode_SGraph();

	/**
	 * Returns the meta object for the reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode#getSLayers <em>SLayers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>SLayers</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode#getSLayers()
	 * @see #getSNode()
	 * @generated
	 */
	EReference getSNode_SLayers();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation <em>SRelation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SRelation</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation
	 * @generated
	 */
	EClass getSRelation();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation#getSSource <em>SSource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SSource</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation#getSSource()
	 * @see #getSRelation()
	 * @generated
	 */
	EReference getSRelation_SSource();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation#getSTarget <em>STarget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>STarget</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation#getSTarget()
	 * @see #getSRelation()
	 * @generated
	 */
	EReference getSRelation_STarget();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation#getSGraph <em>SGraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SGraph</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation#getSGraph()
	 * @see #getSRelation()
	 * @generated
	 */
	EReference getSRelation_SGraph();

	/**
	 * Returns the meta object for the attribute list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation#getSTypes <em>STypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>STypes</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation#getSTypes()
	 * @see #getSRelation()
	 * @generated
	 */
	EAttribute getSRelation_STypes();

	/**
	 * Returns the meta object for the reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation#getSLayers <em>SLayers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>SLayers</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation#getSLayers()
	 * @see #getSRelation()
	 * @generated
	 */
	EReference getSRelation_SLayers();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement <em>SAnnotatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SAnnotatable Element</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement
	 * @generated
	 */
	EClass getSAnnotatableElement();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#getSAnnotations <em>SAnnotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SAnnotations</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement#getSAnnotations()
	 * @see #getSAnnotatableElement()
	 * @generated
	 */
	EReference getSAnnotatableElement_SAnnotations();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation <em>SAnnotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SAnnotation</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation
	 * @generated
	 */
	EClass getSAnnotation();

	/**
	 * Returns the meta object for the container reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation#getSAnnotatableElement <em>SAnnotatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SAnnotatable Element</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation#getSAnnotatableElement()
	 * @see #getSAnnotation()
	 * @generated
	 */
	EReference getSAnnotation_SAnnotatableElement();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraph <em>SGraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SGraph</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraph
	 * @generated
	 */
	EClass getSGraph();

	/**
	 * Returns the meta object for the reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraph#getSRelations <em>SRelations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>SRelations</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraph#getSRelations()
	 * @see #getSGraph()
	 * @generated
	 */
	EReference getSGraph_SRelations();

	/**
	 * Returns the meta object for the reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraph#getSNodes <em>SNodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>SNodes</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraph#getSNodes()
	 * @see #getSGraph()
	 * @generated
	 */
	EReference getSGraph_SNodes();

	/**
	 * Returns the meta object for the reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraph#getSLayers <em>SLayers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>SLayers</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraph#getSLayers()
	 * @see #getSGraph()
	 * @generated
	 */
	EReference getSGraph_SLayers();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNamedElement <em>SNamed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SNamed Element</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNamedElement
	 * @generated
	 */
	EClass getSNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNamedElement#getSName <em>SName</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SName</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNamedElement#getSName()
	 * @see #getSNamedElement()
	 * @generated
	 */
	EAttribute getSNamedElement_SName();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement <em>SIdentifiable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SIdentifiable Element</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement
	 * @generated
	 */
	EClass getSIdentifiableElement();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement#getSElementId <em>SElement Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SElement Id</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement#getSElementId()
	 * @see #getSIdentifiableElement()
	 * @generated
	 */
	EReference getSIdentifiableElement_SElementId();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement#getSId <em>SId</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SId</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement#getSId()
	 * @see #getSIdentifiableElement()
	 * @generated
	 */
	EAttribute getSIdentifiableElement_SId();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement#getSElementPath <em>SElement Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SElement Path</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement#getSElementPath()
	 * @see #getSIdentifiableElement()
	 * @generated
	 */
	EAttribute getSIdentifiableElement_SElementPath();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation <em>SProcessing Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SProcessing Annotation</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation
	 * @generated
	 */
	EClass getSProcessingAnnotation();

	/**
	 * Returns the meta object for the container reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation#getSProcessingAnnotatableElement <em>SProcessing Annotatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SProcessing Annotatable Element</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation#getSProcessingAnnotatableElement()
	 * @see #getSProcessingAnnotation()
	 * @generated
	 */
	EReference getSProcessingAnnotation_SProcessingAnnotatableElement();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement <em>SProcessing Annotatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SProcessing Annotatable Element</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement
	 * @generated
	 */
	EClass getSProcessingAnnotatableElement();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotations <em>SProcessing Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SProcessing Annotations</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotations()
	 * @see #getSProcessingAnnotatableElement()
	 * @generated
	 */
	EReference getSProcessingAnnotatableElement_SProcessingAnnotations();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId <em>SElement Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SElement Id</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId
	 * @generated
	 */
	EClass getSElementId();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId#getSIdentifiableElement <em>SIdentifiable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SIdentifiable Element</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId#getSIdentifiableElement()
	 * @see #getSElementId()
	 * @generated
	 */
	EReference getSElementId_SIdentifiableElement();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId#getSId <em>SId</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SId</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId#getSId()
	 * @see #getSElementId()
	 * @generated
	 */
	EAttribute getSElementId_SId();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId#getSElementPath <em>SElement Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SElement Path</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId#getSElementPath()
	 * @see #getSElementId()
	 * @generated
	 */
	EAttribute getSElementId_SElementPath();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature <em>SFeature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SFeature</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature
	 * @generated
	 */
	EClass getSFeature();

	/**
	 * Returns the meta object for the container reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature#getSFeaturableElement <em>SFeaturable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SFeaturable Element</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature#getSFeaturableElement()
	 * @see #getSFeature()
	 * @generated
	 */
	EReference getSFeature_SFeaturableElement();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement <em>SFeaturable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SFeaturable Element</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement
	 * @generated
	 */
	EClass getSFeaturableElement();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#getSFeatures <em>SFeatures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SFeatures</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement#getSFeatures()
	 * @see #getSFeaturableElement()
	 * @generated
	 */
	EReference getSFeaturableElement_SFeatures();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement <em>SMeta Annotatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SMeta Annotatable Element</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement
	 * @generated
	 */
	EClass getSMetaAnnotatableElement();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#getSMetaAnnotations <em>SMeta Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SMeta Annotations</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement#getSMetaAnnotations()
	 * @see #getSMetaAnnotatableElement()
	 * @generated
	 */
	EReference getSMetaAnnotatableElement_SMetaAnnotations();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation <em>SMeta Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SMeta Annotation</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation
	 * @generated
	 */
	EClass getSMetaAnnotation();

	/**
	 * Returns the meta object for the container reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation#getSMetaAnnotatableElement <em>SMeta Annotatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SMeta Annotatable Element</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation#getSMetaAnnotatableElement()
	 * @see #getSMetaAnnotation()
	 * @generated
	 */
	EReference getSMetaAnnotation_SMetaAnnotatableElement();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAbstractAnnotation <em>SAbstract Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SAbstract Annotation</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAbstractAnnotation
	 * @generated
	 */
	EClass getSAbstractAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAbstractAnnotation#getSNS <em>SNS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SNS</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAbstractAnnotation#getSNS()
	 * @see #getSAbstractAnnotation()
	 * @generated
	 */
	EAttribute getSAbstractAnnotation_SNS();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAbstractAnnotation#getSName <em>SName</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SName</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAbstractAnnotation#getSName()
	 * @see #getSAbstractAnnotation()
	 * @generated
	 */
	EAttribute getSAbstractAnnotation_SName();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAbstractAnnotation#getSValue <em>SValue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SValue</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAbstractAnnotation#getSValue()
	 * @see #getSAbstractAnnotation()
	 * @generated
	 */
	EAttribute getSAbstractAnnotation_SValue();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAbstractAnnotation#getSValueType <em>SValue Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SValue Type</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAbstractAnnotation#getSValueType()
	 * @see #getSAbstractAnnotation()
	 * @generated
	 */
	EAttribute getSAbstractAnnotation_SValueType();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer <em>SLayer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SLayer</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer
	 * @generated
	 */
	EClass getSLayer();

	/**
	 * Returns the meta object for the reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSRelations <em>SRelations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>SRelations</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSRelations()
	 * @see #getSLayer()
	 * @generated
	 */
	EReference getSLayer_SRelations();

	/**
	 * Returns the meta object for the reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSNodes <em>SNodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>SNodes</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSNodes()
	 * @see #getSLayer()
	 * @generated
	 */
	EReference getSLayer_SNodes();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSGraph <em>SGraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SGraph</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSGraph()
	 * @see #getSLayer()
	 * @generated
	 */
	EReference getSLayer_SGraph();

	/**
	 * Returns the meta object for the reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSSubLayers <em>SSub Layers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>SSub Layers</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSSubLayers()
	 * @see #getSLayer()
	 * @generated
	 */
	EReference getSLayer_SSubLayers();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSSuperLayer <em>SSuper Layer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SSuper Layer</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer#getSSuperLayer()
	 * @see #getSLayer()
	 * @generated
	 */
	EReference getSLayer_SSuperLayer();

	/**
	 * Returns the meta object for enum '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE <em>SDATATYPE</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>SDATATYPE</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE
	 * @generated
	 */
	EEnum getSDATATYPE();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.util.URI <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>URI</em>'.
	 * @see org.eclipse.emf.common.util.URI
	 * @model instanceClass="org.eclipse.emf.common.util.URI"
	 * @generated
	 */
	EDataType getURI();

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
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SNodeImpl <em>SNode</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SNodeImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSNode()
		 * @generated
		 */
		EClass SNODE = eINSTANCE.getSNode();

		/**
		 * The meta object literal for the '<em><b>SGraph</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SNODE__SGRAPH = eINSTANCE.getSNode_SGraph();

		/**
		 * The meta object literal for the '<em><b>SLayers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SNODE__SLAYERS = eINSTANCE.getSNode_SLayers();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SRelationImpl <em>SRelation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SRelationImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSRelation()
		 * @generated
		 */
		EClass SRELATION = eINSTANCE.getSRelation();

		/**
		 * The meta object literal for the '<em><b>SSource</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SRELATION__SSOURCE = eINSTANCE.getSRelation_SSource();

		/**
		 * The meta object literal for the '<em><b>STarget</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SRELATION__STARGET = eINSTANCE.getSRelation_STarget();

		/**
		 * The meta object literal for the '<em><b>SGraph</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SRELATION__SGRAPH = eINSTANCE.getSRelation_SGraph();

		/**
		 * The meta object literal for the '<em><b>STypes</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SRELATION__STYPES = eINSTANCE.getSRelation_STypes();

		/**
		 * The meta object literal for the '<em><b>SLayers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SRELATION__SLAYERS = eINSTANCE.getSRelation_SLayers();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SAnnotatableElementImpl <em>SAnnotatable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SAnnotatableElementImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSAnnotatableElement()
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
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SAnnotationImpl <em>SAnnotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SAnnotationImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSAnnotation()
		 * @generated
		 */
		EClass SANNOTATION = eINSTANCE.getSAnnotation();

		/**
		 * The meta object literal for the '<em><b>SAnnotatable Element</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SANNOTATION__SANNOTATABLE_ELEMENT = eINSTANCE.getSAnnotation_SAnnotatableElement();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SGraphImpl <em>SGraph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SGraphImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSGraph()
		 * @generated
		 */
		EClass SGRAPH = eINSTANCE.getSGraph();

		/**
		 * The meta object literal for the '<em><b>SRelations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SGRAPH__SRELATIONS = eINSTANCE.getSGraph_SRelations();

		/**
		 * The meta object literal for the '<em><b>SNodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SGRAPH__SNODES = eINSTANCE.getSGraph_SNodes();

		/**
		 * The meta object literal for the '<em><b>SLayers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SGRAPH__SLAYERS = eINSTANCE.getSGraph_SLayers();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SNamedElementImpl <em>SNamed Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SNamedElementImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSNamedElement()
		 * @generated
		 */
		EClass SNAMED_ELEMENT = eINSTANCE.getSNamedElement();

		/**
		 * The meta object literal for the '<em><b>SName</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SNAMED_ELEMENT__SNAME = eINSTANCE.getSNamedElement_SName();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SIdentifiableElementImpl <em>SIdentifiable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SIdentifiableElementImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSIdentifiableElement()
		 * @generated
		 */
		EClass SIDENTIFIABLE_ELEMENT = eINSTANCE.getSIdentifiableElement();

		/**
		 * The meta object literal for the '<em><b>SElement Id</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIDENTIFIABLE_ELEMENT__SELEMENT_ID = eINSTANCE.getSIdentifiableElement_SElementId();

		/**
		 * The meta object literal for the '<em><b>SId</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIDENTIFIABLE_ELEMENT__SID = eINSTANCE.getSIdentifiableElement_SId();

		/**
		 * The meta object literal for the '<em><b>SElement Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIDENTIFIABLE_ELEMENT__SELEMENT_PATH = eINSTANCE.getSIdentifiableElement_SElementPath();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SProcessingAnnotationImpl <em>SProcessing Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SProcessingAnnotationImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSProcessingAnnotation()
		 * @generated
		 */
		EClass SPROCESSING_ANNOTATION = eINSTANCE.getSProcessingAnnotation();

		/**
		 * The meta object literal for the '<em><b>SProcessing Annotatable Element</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPROCESSING_ANNOTATION__SPROCESSING_ANNOTATABLE_ELEMENT = eINSTANCE.getSProcessingAnnotation_SProcessingAnnotatableElement();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SProcessingAnnotatableElementImpl <em>SProcessing Annotatable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SProcessingAnnotatableElementImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSProcessingAnnotatableElement()
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
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SElementIdImpl <em>SElement Id</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SElementIdImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSElementId()
		 * @generated
		 */
		EClass SELEMENT_ID = eINSTANCE.getSElementId();

		/**
		 * The meta object literal for the '<em><b>SIdentifiable Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELEMENT_ID__SIDENTIFIABLE_ELEMENT = eINSTANCE.getSElementId_SIdentifiableElement();

		/**
		 * The meta object literal for the '<em><b>SId</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELEMENT_ID__SID = eINSTANCE.getSElementId_SId();

		/**
		 * The meta object literal for the '<em><b>SElement Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELEMENT_ID__SELEMENT_PATH = eINSTANCE.getSElementId_SElementPath();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SFeatureImpl <em>SFeature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SFeatureImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSFeature()
		 * @generated
		 */
		EClass SFEATURE = eINSTANCE.getSFeature();

		/**
		 * The meta object literal for the '<em><b>SFeaturable Element</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SFEATURE__SFEATURABLE_ELEMENT = eINSTANCE.getSFeature_SFeaturableElement();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SFeaturableElementImpl <em>SFeaturable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SFeaturableElementImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSFeaturableElement()
		 * @generated
		 */
		EClass SFEATURABLE_ELEMENT = eINSTANCE.getSFeaturableElement();

		/**
		 * The meta object literal for the '<em><b>SFeatures</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SFEATURABLE_ELEMENT__SFEATURES = eINSTANCE.getSFeaturableElement_SFeatures();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SMetaAnnotatableElementImpl <em>SMeta Annotatable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SMetaAnnotatableElementImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSMetaAnnotatableElement()
		 * @generated
		 */
		EClass SMETA_ANNOTATABLE_ELEMENT = eINSTANCE.getSMetaAnnotatableElement();

		/**
		 * The meta object literal for the '<em><b>SMeta Annotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SMETA_ANNOTATABLE_ELEMENT__SMETA_ANNOTATIONS = eINSTANCE.getSMetaAnnotatableElement_SMetaAnnotations();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SMetaAnnotationImpl <em>SMeta Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SMetaAnnotationImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSMetaAnnotation()
		 * @generated
		 */
		EClass SMETA_ANNOTATION = eINSTANCE.getSMetaAnnotation();

		/**
		 * The meta object literal for the '<em><b>SMeta Annotatable Element</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SMETA_ANNOTATION__SMETA_ANNOTATABLE_ELEMENT = eINSTANCE.getSMetaAnnotation_SMetaAnnotatableElement();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SAbstractAnnotationImpl <em>SAbstract Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SAbstractAnnotationImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSAbstractAnnotation()
		 * @generated
		 */
		EClass SABSTRACT_ANNOTATION = eINSTANCE.getSAbstractAnnotation();

		/**
		 * The meta object literal for the '<em><b>SNS</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SABSTRACT_ANNOTATION__SNS = eINSTANCE.getSAbstractAnnotation_SNS();

		/**
		 * The meta object literal for the '<em><b>SName</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SABSTRACT_ANNOTATION__SNAME = eINSTANCE.getSAbstractAnnotation_SName();

		/**
		 * The meta object literal for the '<em><b>SValue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SABSTRACT_ANNOTATION__SVALUE = eINSTANCE.getSAbstractAnnotation_SValue();

		/**
		 * The meta object literal for the '<em><b>SValue Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SABSTRACT_ANNOTATION__SVALUE_TYPE = eINSTANCE.getSAbstractAnnotation_SValueType();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SLayerImpl <em>SLayer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SLayerImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSLayer()
		 * @generated
		 */
		EClass SLAYER = eINSTANCE.getSLayer();

		/**
		 * The meta object literal for the '<em><b>SRelations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SLAYER__SRELATIONS = eINSTANCE.getSLayer_SRelations();

		/**
		 * The meta object literal for the '<em><b>SNodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SLAYER__SNODES = eINSTANCE.getSLayer_SNodes();

		/**
		 * The meta object literal for the '<em><b>SGraph</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SLAYER__SGRAPH = eINSTANCE.getSLayer_SGraph();

		/**
		 * The meta object literal for the '<em><b>SSub Layers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SLAYER__SSUB_LAYERS = eINSTANCE.getSLayer_SSubLayers();

		/**
		 * The meta object literal for the '<em><b>SSuper Layer</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SLAYER__SSUPER_LAYER = eINSTANCE.getSLayer_SSuperLayer();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE <em>SDATATYPE</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getSDATATYPE()
		 * @generated
		 */
		EEnum SDATATYPE = eINSTANCE.getSDATATYPE();

		/**
		 * The meta object literal for the '<em>URI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.URI
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SaltCorePackageImpl#getURI()
		 * @generated
		 */
		EDataType URI = eINSTANCE.getURI();

	}

} //SaltCorePackage
