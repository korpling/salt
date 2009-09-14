/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore;

import de.hub.corpling.graph.GraphPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see de.hub.corpling.salt.saltCore.SaltCoreFactory
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
	SaltCorePackage eINSTANCE = de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCore.impl.SNodeImpl <em>SNode</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.impl.SNodeImpl
	 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSNode()
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
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNODE__GRAPH = GraphPackage.NODE__GRAPH;

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
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNODE__SID = GraphPackage.NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNODE__SELEMENT_PATH = GraphPackage.NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNODE__SPROCESSING_ANNOTATIONS = GraphPackage.NODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNODE__SGRAPH = GraphPackage.NODE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>SNode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNODE_FEATURE_COUNT = GraphPackage.NODE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCore.impl.SRelationImpl <em>SRelation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.impl.SRelationImpl
	 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSRelation()
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
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__SID = GraphPackage.EDGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__SELEMENT_PATH = GraphPackage.EDGE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__SPROCESSING_ANNOTATIONS = GraphPackage.EDGE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>SSource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__SSOURCE = GraphPackage.EDGE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>STarget</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__STARGET = GraphPackage.EDGE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__SGRAPH = GraphPackage.EDGE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>SRelation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION_FEATURE_COUNT = GraphPackage.EDGE_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCore.impl.SAnnotatableElementImpl <em>SAnnotatable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.impl.SAnnotatableElementImpl
	 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSAnnotatableElement()
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
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCore.impl.SAnnotationImpl <em>SAnnotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.impl.SAnnotationImpl
	 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSAnnotation()
	 * @generated
	 */
	int SANNOTATION = 3;

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
	 * The feature id for the '<em><b>Labelable Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATION__LABELABLE_ELEMENT = GraphPackage.LABEL__LABELABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Value String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATION__VALUE_STRING = GraphPackage.LABEL__VALUE_STRING;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATION__SNAME = GraphPackage.LABEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SValue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATION__SVALUE = GraphPackage.LABEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SAnnotatable Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATION__SANNOTATABLE_ELEMENT = GraphPackage.LABEL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>SAnnotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATION_FEATURE_COUNT = GraphPackage.LABEL_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCore.impl.SGraphImpl <em>SGraph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.impl.SGraphImpl
	 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSGraph()
	 * @generated
	 */
	int SGRAPH = 4;

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
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__SID = GraphPackage.GRAPH_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__SELEMENT_PATH = GraphPackage.GRAPH_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__SPROCESSING_ANNOTATIONS = GraphPackage.GRAPH_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>SRelations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__SRELATIONS = GraphPackage.GRAPH_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>SNodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__SNODES = GraphPackage.GRAPH_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>SGraph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH_FEATURE_COUNT = GraphPackage.GRAPH_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCore.impl.SNamedElementImpl <em>SNamed Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.impl.SNamedElementImpl
	 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSNamedElement()
	 * @generated
	 */
	int SNAMED_ELEMENT = 5;

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
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCore.impl.SIdentifiableElementImpl <em>SIdentifiable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.impl.SIdentifiableElementImpl
	 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSIdentifiableElement()
	 * @generated
	 */
	int SIDENTIFIABLE_ELEMENT = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIDENTIFIABLE_ELEMENT__ID = GraphPackage.IDENTIFIABLE_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIDENTIFIABLE_ELEMENT__SID = GraphPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIDENTIFIABLE_ELEMENT__SELEMENT_PATH = GraphPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>SIdentifiable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIDENTIFIABLE_ELEMENT_FEATURE_COUNT = GraphPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCore.impl.SProcessingAnnotationImpl <em>SProcessing Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.impl.SProcessingAnnotationImpl
	 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSProcessingAnnotation()
	 * @generated
	 */
	int SPROCESSING_ANNOTATION = 7;

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
	 * The feature id for the '<em><b>Labelable Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROCESSING_ANNOTATION__LABELABLE_ELEMENT = GraphPackage.LABEL__LABELABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Value String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROCESSING_ANNOTATION__VALUE_STRING = GraphPackage.LABEL__VALUE_STRING;

	/**
	 * The feature id for the '<em><b>SProcessing Annotatable Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROCESSING_ANNOTATION__SPROCESSING_ANNOTATABLE_ELEMENT = GraphPackage.LABEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROCESSING_ANNOTATION__SNAME = GraphPackage.LABEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SValue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROCESSING_ANNOTATION__SVALUE = GraphPackage.LABEL_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>SProcessing Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROCESSING_ANNOTATION_FEATURE_COUNT = GraphPackage.LABEL_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCore.impl.SProcessingAnnotatableElementImpl <em>SProcessing Annotatable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.impl.SProcessingAnnotatableElementImpl
	 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSProcessingAnnotatableElement()
	 * @generated
	 */
	int SPROCESSING_ANNOTATABLE_ELEMENT = 8;

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
	 * The meta object id for the '<em>URI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.URI
	 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getURI()
	 * @generated
	 */
	int URI = 9;


	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCore.SNode <em>SNode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SNode</em>'.
	 * @see de.hub.corpling.salt.saltCore.SNode
	 * @generated
	 */
	EClass getSNode();

	/**
	 * Returns the meta object for the reference '{@link de.hub.corpling.salt.saltCore.SNode#getSGraph <em>SGraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SGraph</em>'.
	 * @see de.hub.corpling.salt.saltCore.SNode#getSGraph()
	 * @see #getSNode()
	 * @generated
	 */
	EReference getSNode_SGraph();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCore.SRelation <em>SRelation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SRelation</em>'.
	 * @see de.hub.corpling.salt.saltCore.SRelation
	 * @generated
	 */
	EClass getSRelation();

	/**
	 * Returns the meta object for the reference '{@link de.hub.corpling.salt.saltCore.SRelation#getSSource <em>SSource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SSource</em>'.
	 * @see de.hub.corpling.salt.saltCore.SRelation#getSSource()
	 * @see #getSRelation()
	 * @generated
	 */
	EReference getSRelation_SSource();

	/**
	 * Returns the meta object for the reference '{@link de.hub.corpling.salt.saltCore.SRelation#getSTarget <em>STarget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>STarget</em>'.
	 * @see de.hub.corpling.salt.saltCore.SRelation#getSTarget()
	 * @see #getSRelation()
	 * @generated
	 */
	EReference getSRelation_STarget();

	/**
	 * Returns the meta object for the reference '{@link de.hub.corpling.salt.saltCore.SRelation#getSGraph <em>SGraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SGraph</em>'.
	 * @see de.hub.corpling.salt.saltCore.SRelation#getSGraph()
	 * @see #getSRelation()
	 * @generated
	 */
	EReference getSRelation_SGraph();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCore.SAnnotatableElement <em>SAnnotatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SAnnotatable Element</em>'.
	 * @see de.hub.corpling.salt.saltCore.SAnnotatableElement
	 * @generated
	 */
	EClass getSAnnotatableElement();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hub.corpling.salt.saltCore.SAnnotatableElement#getSAnnotations <em>SAnnotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SAnnotations</em>'.
	 * @see de.hub.corpling.salt.saltCore.SAnnotatableElement#getSAnnotations()
	 * @see #getSAnnotatableElement()
	 * @generated
	 */
	EReference getSAnnotatableElement_SAnnotations();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCore.SAnnotation <em>SAnnotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SAnnotation</em>'.
	 * @see de.hub.corpling.salt.saltCore.SAnnotation
	 * @generated
	 */
	EClass getSAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link de.hub.corpling.salt.saltCore.SAnnotation#getSName <em>SName</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SName</em>'.
	 * @see de.hub.corpling.salt.saltCore.SAnnotation#getSName()
	 * @see #getSAnnotation()
	 * @generated
	 */
	EAttribute getSAnnotation_SName();

	/**
	 * Returns the meta object for the attribute '{@link de.hub.corpling.salt.saltCore.SAnnotation#getSValue <em>SValue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SValue</em>'.
	 * @see de.hub.corpling.salt.saltCore.SAnnotation#getSValue()
	 * @see #getSAnnotation()
	 * @generated
	 */
	EAttribute getSAnnotation_SValue();

	/**
	 * Returns the meta object for the container reference '{@link de.hub.corpling.salt.saltCore.SAnnotation#getSAnnotatableElement <em>SAnnotatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SAnnotatable Element</em>'.
	 * @see de.hub.corpling.salt.saltCore.SAnnotation#getSAnnotatableElement()
	 * @see #getSAnnotation()
	 * @generated
	 */
	EReference getSAnnotation_SAnnotatableElement();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCore.SGraph <em>SGraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SGraph</em>'.
	 * @see de.hub.corpling.salt.saltCore.SGraph
	 * @generated
	 */
	EClass getSGraph();

	/**
	 * Returns the meta object for the reference list '{@link de.hub.corpling.salt.saltCore.SGraph#getSRelations <em>SRelations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>SRelations</em>'.
	 * @see de.hub.corpling.salt.saltCore.SGraph#getSRelations()
	 * @see #getSGraph()
	 * @generated
	 */
	EReference getSGraph_SRelations();

	/**
	 * Returns the meta object for the reference list '{@link de.hub.corpling.salt.saltCore.SGraph#getSNodes <em>SNodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>SNodes</em>'.
	 * @see de.hub.corpling.salt.saltCore.SGraph#getSNodes()
	 * @see #getSGraph()
	 * @generated
	 */
	EReference getSGraph_SNodes();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCore.SNamedElement <em>SNamed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SNamed Element</em>'.
	 * @see de.hub.corpling.salt.saltCore.SNamedElement
	 * @generated
	 */
	EClass getSNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link de.hub.corpling.salt.saltCore.SNamedElement#getSName <em>SName</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SName</em>'.
	 * @see de.hub.corpling.salt.saltCore.SNamedElement#getSName()
	 * @see #getSNamedElement()
	 * @generated
	 */
	EAttribute getSNamedElement_SName();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCore.SIdentifiableElement <em>SIdentifiable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SIdentifiable Element</em>'.
	 * @see de.hub.corpling.salt.saltCore.SIdentifiableElement
	 * @generated
	 */
	EClass getSIdentifiableElement();

	/**
	 * Returns the meta object for the attribute '{@link de.hub.corpling.salt.saltCore.SIdentifiableElement#getSId <em>SId</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SId</em>'.
	 * @see de.hub.corpling.salt.saltCore.SIdentifiableElement#getSId()
	 * @see #getSIdentifiableElement()
	 * @generated
	 */
	EAttribute getSIdentifiableElement_SId();

	/**
	 * Returns the meta object for the attribute '{@link de.hub.corpling.salt.saltCore.SIdentifiableElement#getSElementPath <em>SElement Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SElement Path</em>'.
	 * @see de.hub.corpling.salt.saltCore.SIdentifiableElement#getSElementPath()
	 * @see #getSIdentifiableElement()
	 * @generated
	 */
	EAttribute getSIdentifiableElement_SElementPath();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCore.SProcessingAnnotation <em>SProcessing Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SProcessing Annotation</em>'.
	 * @see de.hub.corpling.salt.saltCore.SProcessingAnnotation
	 * @generated
	 */
	EClass getSProcessingAnnotation();

	/**
	 * Returns the meta object for the container reference '{@link de.hub.corpling.salt.saltCore.SProcessingAnnotation#getSProcessingAnnotatableElement <em>SProcessing Annotatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SProcessing Annotatable Element</em>'.
	 * @see de.hub.corpling.salt.saltCore.SProcessingAnnotation#getSProcessingAnnotatableElement()
	 * @see #getSProcessingAnnotation()
	 * @generated
	 */
	EReference getSProcessingAnnotation_SProcessingAnnotatableElement();

	/**
	 * Returns the meta object for the attribute '{@link de.hub.corpling.salt.saltCore.SProcessingAnnotation#getSName <em>SName</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SName</em>'.
	 * @see de.hub.corpling.salt.saltCore.SProcessingAnnotation#getSName()
	 * @see #getSProcessingAnnotation()
	 * @generated
	 */
	EAttribute getSProcessingAnnotation_SName();

	/**
	 * Returns the meta object for the attribute '{@link de.hub.corpling.salt.saltCore.SProcessingAnnotation#getSValue <em>SValue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SValue</em>'.
	 * @see de.hub.corpling.salt.saltCore.SProcessingAnnotation#getSValue()
	 * @see #getSProcessingAnnotation()
	 * @generated
	 */
	EAttribute getSProcessingAnnotation_SValue();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement <em>SProcessing Annotatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SProcessing Annotatable Element</em>'.
	 * @see de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement
	 * @generated
	 */
	EClass getSProcessingAnnotatableElement();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotations <em>SProcessing Annotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SProcessing Annotations</em>'.
	 * @see de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement#getSProcessingAnnotations()
	 * @see #getSProcessingAnnotatableElement()
	 * @generated
	 */
	EReference getSProcessingAnnotatableElement_SProcessingAnnotations();

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
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCore.impl.SNodeImpl <em>SNode</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCore.impl.SNodeImpl
		 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSNode()
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
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCore.impl.SRelationImpl <em>SRelation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCore.impl.SRelationImpl
		 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSRelation()
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
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCore.impl.SAnnotatableElementImpl <em>SAnnotatable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCore.impl.SAnnotatableElementImpl
		 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSAnnotatableElement()
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
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCore.impl.SAnnotationImpl <em>SAnnotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCore.impl.SAnnotationImpl
		 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSAnnotation()
		 * @generated
		 */
		EClass SANNOTATION = eINSTANCE.getSAnnotation();

		/**
		 * The meta object literal for the '<em><b>SName</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SANNOTATION__SNAME = eINSTANCE.getSAnnotation_SName();

		/**
		 * The meta object literal for the '<em><b>SValue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SANNOTATION__SVALUE = eINSTANCE.getSAnnotation_SValue();

		/**
		 * The meta object literal for the '<em><b>SAnnotatable Element</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SANNOTATION__SANNOTATABLE_ELEMENT = eINSTANCE.getSAnnotation_SAnnotatableElement();

		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCore.impl.SGraphImpl <em>SGraph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCore.impl.SGraphImpl
		 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSGraph()
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
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCore.impl.SNamedElementImpl <em>SNamed Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCore.impl.SNamedElementImpl
		 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSNamedElement()
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
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCore.impl.SIdentifiableElementImpl <em>SIdentifiable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCore.impl.SIdentifiableElementImpl
		 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSIdentifiableElement()
		 * @generated
		 */
		EClass SIDENTIFIABLE_ELEMENT = eINSTANCE.getSIdentifiableElement();

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
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCore.impl.SProcessingAnnotationImpl <em>SProcessing Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCore.impl.SProcessingAnnotationImpl
		 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSProcessingAnnotation()
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
		 * The meta object literal for the '<em><b>SName</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPROCESSING_ANNOTATION__SNAME = eINSTANCE.getSProcessingAnnotation_SName();

		/**
		 * The meta object literal for the '<em><b>SValue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPROCESSING_ANNOTATION__SVALUE = eINSTANCE.getSProcessingAnnotation_SValue();

		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCore.impl.SProcessingAnnotatableElementImpl <em>SProcessing Annotatable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCore.impl.SProcessingAnnotatableElementImpl
		 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSProcessingAnnotatableElement()
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
		 * The meta object literal for the '<em>URI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.URI
		 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getURI()
		 * @generated
		 */
		EDataType URI = eINSTANCE.getURI();

	}

} //SaltCorePackage
