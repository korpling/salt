/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure;

import de.hub.corpling.salt.saltCore.SaltCorePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructureFactory
 * @model kind="package"
 * @generated
 */
public interface SDocumentStructurePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sDocumentStructure";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "sDocumentStructure";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sDocumentStructure";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SDocumentStructurePackage eINSTANCE = de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentGraphImpl <em>SDocument Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentGraphImpl
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSDocumentGraph()
	 * @generated
	 */
	int SDOCUMENT_GRAPH = 0;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__LABELS = SaltCorePackage.SGRAPH__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__ID = SaltCorePackage.SGRAPH__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__IDENTIFIER = SaltCorePackage.SGRAPH__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Index Mgr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__INDEX_MGR = SaltCorePackage.SGRAPH__INDEX_MGR;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__NODES = SaltCorePackage.SGRAPH__NODES;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__EDGES = SaltCorePackage.SGRAPH__EDGES;

	/**
	 * The feature id for the '<em><b>Num Of Nodes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__NUM_OF_NODES = SaltCorePackage.SGRAPH__NUM_OF_NODES;

	/**
	 * The feature id for the '<em><b>Num Of Edges</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__NUM_OF_EDGES = SaltCorePackage.SGRAPH__NUM_OF_EDGES;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SNAME = SaltCorePackage.SGRAPH__SNAME;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SANNOTATIONS = SaltCorePackage.SGRAPH__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SELEMENT_ID = SaltCorePackage.SGRAPH__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SID = SaltCorePackage.SGRAPH__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SELEMENT_PATH = SaltCorePackage.SGRAPH__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SPROCESSING_ANNOTATIONS = SaltCorePackage.SGRAPH__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SFEATURES = SaltCorePackage.SGRAPH__SFEATURES;

	/**
	 * The feature id for the '<em><b>SRelations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SRELATIONS = SaltCorePackage.SGRAPH__SRELATIONS;

	/**
	 * The feature id for the '<em><b>SNodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SNODES = SaltCorePackage.SGRAPH__SNODES;

	/**
	 * The feature id for the '<em><b>SDocument</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SDOCUMENT = SaltCorePackage.SGRAPH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>STextual DSs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__STEXTUAL_DSS = SaltCorePackage.SGRAPH_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>STextual Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__STEXTUAL_RELATIONS = SaltCorePackage.SGRAPH_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>STokens</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__STOKENS = SaltCorePackage.SGRAPH_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>STimeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__STIMELINE = SaltCorePackage.SGRAPH_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>STimeline Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__STIMELINE_RELATIONS = SaltCorePackage.SGRAPH_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>SSpanning Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SSPANNING_RELATIONS = SaltCorePackage.SGRAPH_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>SSpans</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SSPANS = SaltCorePackage.SGRAPH_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>SDocument Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH_FEATURE_COUNT = SaltCorePackage.SGRAPH_FEATURE_COUNT + 8;


	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SSequentialDSImpl <em>SSequential DS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SSequentialDSImpl
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSSequentialDS()
	 * @generated
	 */
	int SSEQUENTIAL_DS = 5;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__LABELS = SaltCorePackage.SNODE__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__ID = SaltCorePackage.SNODE__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__IDENTIFIER = SaltCorePackage.SNODE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__GRAPH = SaltCorePackage.SNODE__GRAPH;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__SANNOTATIONS = SaltCorePackage.SNODE__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__SNAME = SaltCorePackage.SNODE__SNAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__SELEMENT_ID = SaltCorePackage.SNODE__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__SID = SaltCorePackage.SNODE__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__SELEMENT_PATH = SaltCorePackage.SNODE__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__SPROCESSING_ANNOTATIONS = SaltCorePackage.SNODE__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__SFEATURES = SaltCorePackage.SNODE__SFEATURES;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__SGRAPH = SaltCorePackage.SNODE__SGRAPH;

	/**
	 * The feature id for the '<em><b>SData</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__SDATA = SaltCorePackage.SNODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SSequential DS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS_FEATURE_COUNT = SaltCorePackage.SNODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextualDSImpl <em>STextual DS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextualDSImpl
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSTextualDS()
	 * @generated
	 */
	int STEXTUAL_DS = 1;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__LABELS = SSEQUENTIAL_DS__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__ID = SSEQUENTIAL_DS__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__IDENTIFIER = SSEQUENTIAL_DS__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__GRAPH = SSEQUENTIAL_DS__GRAPH;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__SANNOTATIONS = SSEQUENTIAL_DS__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__SNAME = SSEQUENTIAL_DS__SNAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__SELEMENT_ID = SSEQUENTIAL_DS__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__SID = SSEQUENTIAL_DS__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__SELEMENT_PATH = SSEQUENTIAL_DS__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__SPROCESSING_ANNOTATIONS = SSEQUENTIAL_DS__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__SFEATURES = SSEQUENTIAL_DS__SFEATURES;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__SGRAPH = SSEQUENTIAL_DS__SGRAPH;

	/**
	 * The feature id for the '<em><b>SData</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__SDATA = SSEQUENTIAL_DS__SDATA;

	/**
	 * The feature id for the '<em><b>SText</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__STEXT = SSEQUENTIAL_DS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SDocument Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__SDOCUMENT_GRAPH = SSEQUENTIAL_DS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>STextual DS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS_FEATURE_COUNT = SSEQUENTIAL_DS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STokenImpl <em>SToken</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STokenImpl
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSToken()
	 * @generated
	 */
	int STOKEN = 2;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__LABELS = SaltCorePackage.SNODE__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__ID = SaltCorePackage.SNODE__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__IDENTIFIER = SaltCorePackage.SNODE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__GRAPH = SaltCorePackage.SNODE__GRAPH;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SANNOTATIONS = SaltCorePackage.SNODE__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SNAME = SaltCorePackage.SNODE__SNAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SELEMENT_ID = SaltCorePackage.SNODE__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SID = SaltCorePackage.SNODE__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SELEMENT_PATH = SaltCorePackage.SNODE__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SPROCESSING_ANNOTATIONS = SaltCorePackage.SNODE__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SFEATURES = SaltCorePackage.SNODE__SFEATURES;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SGRAPH = SaltCorePackage.SNODE__SGRAPH;

	/**
	 * The feature id for the '<em><b>SDocument Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SDOCUMENT_GRAPH = SaltCorePackage.SNODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SToken</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN_FEATURE_COUNT = SaltCorePackage.SNODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SSequentialRelationImpl <em>SSequential Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SSequentialRelationImpl
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSSequentialRelation()
	 * @generated
	 */
	int SSEQUENTIAL_RELATION = 4;

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextualRelationImpl <em>STextual Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextualRelationImpl
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSTextualRelation()
	 * @generated
	 */
	int STEXTUAL_RELATION = 3;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__LABELS = SaltCorePackage.SRELATION__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__ID = SaltCorePackage.SRELATION__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__IDENTIFIER = SaltCorePackage.SRELATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__GRAPH = SaltCorePackage.SRELATION__GRAPH;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__SOURCE = SaltCorePackage.SRELATION__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__TARGET = SaltCorePackage.SRELATION__TARGET;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__SANNOTATIONS = SaltCorePackage.SRELATION__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__SNAME = SaltCorePackage.SRELATION__SNAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__SELEMENT_ID = SaltCorePackage.SRELATION__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__SID = SaltCorePackage.SRELATION__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__SELEMENT_PATH = SaltCorePackage.SRELATION__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__SPROCESSING_ANNOTATIONS = SaltCorePackage.SRELATION__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__SFEATURES = SaltCorePackage.SRELATION__SFEATURES;

	/**
	 * The feature id for the '<em><b>SSource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__SSOURCE = SaltCorePackage.SRELATION__SSOURCE;

	/**
	 * The feature id for the '<em><b>STarget</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__STARGET = SaltCorePackage.SRELATION__STARGET;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__SGRAPH = SaltCorePackage.SRELATION__SGRAPH;

	/**
	 * The feature id for the '<em><b>SStart</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__SSTART = SaltCorePackage.SRELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SEnd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__SEND = SaltCorePackage.SRELATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>SSequential Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION_FEATURE_COUNT = SaltCorePackage.SRELATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__LABELS = SSEQUENTIAL_RELATION__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__ID = SSEQUENTIAL_RELATION__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__IDENTIFIER = SSEQUENTIAL_RELATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__GRAPH = SSEQUENTIAL_RELATION__GRAPH;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SOURCE = SSEQUENTIAL_RELATION__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__TARGET = SSEQUENTIAL_RELATION__TARGET;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SANNOTATIONS = SSEQUENTIAL_RELATION__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SNAME = SSEQUENTIAL_RELATION__SNAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SELEMENT_ID = SSEQUENTIAL_RELATION__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SID = SSEQUENTIAL_RELATION__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SELEMENT_PATH = SSEQUENTIAL_RELATION__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SPROCESSING_ANNOTATIONS = SSEQUENTIAL_RELATION__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SFEATURES = SSEQUENTIAL_RELATION__SFEATURES;

	/**
	 * The feature id for the '<em><b>SSource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SSOURCE = SSEQUENTIAL_RELATION__SSOURCE;

	/**
	 * The feature id for the '<em><b>STarget</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__STARGET = SSEQUENTIAL_RELATION__STARGET;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SGRAPH = SSEQUENTIAL_RELATION__SGRAPH;

	/**
	 * The feature id for the '<em><b>SStart</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SSTART = SSEQUENTIAL_RELATION__SSTART;

	/**
	 * The feature id for the '<em><b>SEnd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SEND = SSEQUENTIAL_RELATION__SEND;

	/**
	 * The feature id for the '<em><b>SToken</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__STOKEN = SSEQUENTIAL_RELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>STextual DS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__STEXTUAL_DS = SSEQUENTIAL_RELATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SDocument Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SDOCUMENT_GRAPH = SSEQUENTIAL_RELATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>STextual Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION_FEATURE_COUNT = SSEQUENTIAL_RELATION_FEATURE_COUNT + 3;


	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STimelineImpl <em>STimeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STimelineImpl
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSTimeline()
	 * @generated
	 */
	int STIMELINE = 6;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__LABELS = SSEQUENTIAL_DS__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__ID = SSEQUENTIAL_DS__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__IDENTIFIER = SSEQUENTIAL_DS__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__GRAPH = SSEQUENTIAL_DS__GRAPH;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__SANNOTATIONS = SSEQUENTIAL_DS__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__SNAME = SSEQUENTIAL_DS__SNAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__SELEMENT_ID = SSEQUENTIAL_DS__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__SID = SSEQUENTIAL_DS__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__SELEMENT_PATH = SSEQUENTIAL_DS__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__SPROCESSING_ANNOTATIONS = SSEQUENTIAL_DS__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__SFEATURES = SSEQUENTIAL_DS__SFEATURES;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__SGRAPH = SSEQUENTIAL_DS__SGRAPH;

	/**
	 * The feature id for the '<em><b>SData</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__SDATA = SSEQUENTIAL_DS__SDATA;

	/**
	 * The feature id for the '<em><b>SPoints Of Time</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__SPOINTS_OF_TIME = SSEQUENTIAL_DS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SDocument Graph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__SDOCUMENT_GRAPH = SSEQUENTIAL_DS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>STimeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE_FEATURE_COUNT = SSEQUENTIAL_DS_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STimelineRelationImpl <em>STimeline Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STimelineRelationImpl
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSTimelineRelation()
	 * @generated
	 */
	int STIMELINE_RELATION = 7;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE_RELATION__LABELS = SSEQUENTIAL_RELATION__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE_RELATION__ID = SSEQUENTIAL_RELATION__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE_RELATION__IDENTIFIER = SSEQUENTIAL_RELATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE_RELATION__GRAPH = SSEQUENTIAL_RELATION__GRAPH;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE_RELATION__SOURCE = SSEQUENTIAL_RELATION__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE_RELATION__TARGET = SSEQUENTIAL_RELATION__TARGET;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE_RELATION__SANNOTATIONS = SSEQUENTIAL_RELATION__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE_RELATION__SNAME = SSEQUENTIAL_RELATION__SNAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE_RELATION__SELEMENT_ID = SSEQUENTIAL_RELATION__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE_RELATION__SID = SSEQUENTIAL_RELATION__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE_RELATION__SELEMENT_PATH = SSEQUENTIAL_RELATION__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE_RELATION__SPROCESSING_ANNOTATIONS = SSEQUENTIAL_RELATION__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE_RELATION__SFEATURES = SSEQUENTIAL_RELATION__SFEATURES;

	/**
	 * The feature id for the '<em><b>SSource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE_RELATION__SSOURCE = SSEQUENTIAL_RELATION__SSOURCE;

	/**
	 * The feature id for the '<em><b>STarget</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE_RELATION__STARGET = SSEQUENTIAL_RELATION__STARGET;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE_RELATION__SGRAPH = SSEQUENTIAL_RELATION__SGRAPH;

	/**
	 * The feature id for the '<em><b>SStart</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE_RELATION__SSTART = SSEQUENTIAL_RELATION__SSTART;

	/**
	 * The feature id for the '<em><b>SEnd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE_RELATION__SEND = SSEQUENTIAL_RELATION__SEND;

	/**
	 * The feature id for the '<em><b>STimeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE_RELATION__STIMELINE = SSEQUENTIAL_RELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SToken</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE_RELATION__STOKEN = SSEQUENTIAL_RELATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SDocument Graph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE_RELATION__SDOCUMENT_GRAPH = SSEQUENTIAL_RELATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>STimeline Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE_RELATION_FEATURE_COUNT = SSEQUENTIAL_RELATION_FEATURE_COUNT + 3;


	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SSpanImpl <em>SSpan</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SSpanImpl
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSSpan()
	 * @generated
	 */
	int SSPAN = 8;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN__LABELS = SaltCorePackage.SNODE__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN__ID = SaltCorePackage.SNODE__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN__IDENTIFIER = SaltCorePackage.SNODE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN__GRAPH = SaltCorePackage.SNODE__GRAPH;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN__SANNOTATIONS = SaltCorePackage.SNODE__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN__SNAME = SaltCorePackage.SNODE__SNAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN__SELEMENT_ID = SaltCorePackage.SNODE__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN__SID = SaltCorePackage.SNODE__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN__SELEMENT_PATH = SaltCorePackage.SNODE__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN__SPROCESSING_ANNOTATIONS = SaltCorePackage.SNODE__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN__SFEATURES = SaltCorePackage.SNODE__SFEATURES;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN__SGRAPH = SaltCorePackage.SNODE__SGRAPH;

	/**
	 * The feature id for the '<em><b>SDocument Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN__SDOCUMENT_GRAPH = SaltCorePackage.SNODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SSpan</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN_FEATURE_COUNT = SaltCorePackage.SNODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SSpanningRelationImpl <em>SSpanning Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SSpanningRelationImpl
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSSpanningRelation()
	 * @generated
	 */
	int SSPANNING_RELATION = 9;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPANNING_RELATION__LABELS = SaltCorePackage.SRELATION__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPANNING_RELATION__ID = SaltCorePackage.SRELATION__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPANNING_RELATION__IDENTIFIER = SaltCorePackage.SRELATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPANNING_RELATION__GRAPH = SaltCorePackage.SRELATION__GRAPH;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPANNING_RELATION__SOURCE = SaltCorePackage.SRELATION__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPANNING_RELATION__TARGET = SaltCorePackage.SRELATION__TARGET;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPANNING_RELATION__SANNOTATIONS = SaltCorePackage.SRELATION__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPANNING_RELATION__SNAME = SaltCorePackage.SRELATION__SNAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPANNING_RELATION__SELEMENT_ID = SaltCorePackage.SRELATION__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPANNING_RELATION__SID = SaltCorePackage.SRELATION__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPANNING_RELATION__SELEMENT_PATH = SaltCorePackage.SRELATION__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPANNING_RELATION__SPROCESSING_ANNOTATIONS = SaltCorePackage.SRELATION__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPANNING_RELATION__SFEATURES = SaltCorePackage.SRELATION__SFEATURES;

	/**
	 * The feature id for the '<em><b>SSource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPANNING_RELATION__SSOURCE = SaltCorePackage.SRELATION__SSOURCE;

	/**
	 * The feature id for the '<em><b>STarget</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPANNING_RELATION__STARGET = SaltCorePackage.SRELATION__STARGET;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPANNING_RELATION__SGRAPH = SaltCorePackage.SRELATION__SGRAPH;

	/**
	 * The feature id for the '<em><b>SToken</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPANNING_RELATION__STOKEN = SaltCorePackage.SRELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SSpan</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPANNING_RELATION__SSPAN = SaltCorePackage.SRELATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SDocument Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPANNING_RELATION__SDOCUMENT_GRAPH = SaltCorePackage.SRELATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>SSpanning Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPANNING_RELATION_FEATURE_COUNT = SaltCorePackage.SRELATION_FEATURE_COUNT + 3;


	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextOverlappingRelationImpl <em>SText Overlapping Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextOverlappingRelationImpl
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSTextOverlappingRelation()
	 * @generated
	 */
	int STEXT_OVERLAPPING_RELATION = 10;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXT_OVERLAPPING_RELATION__LABELS = SaltCorePackage.SRELATION__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXT_OVERLAPPING_RELATION__ID = SaltCorePackage.SRELATION__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXT_OVERLAPPING_RELATION__IDENTIFIER = SaltCorePackage.SRELATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXT_OVERLAPPING_RELATION__GRAPH = SaltCorePackage.SRELATION__GRAPH;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXT_OVERLAPPING_RELATION__SOURCE = SaltCorePackage.SRELATION__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXT_OVERLAPPING_RELATION__TARGET = SaltCorePackage.SRELATION__TARGET;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXT_OVERLAPPING_RELATION__SANNOTATIONS = SaltCorePackage.SRELATION__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXT_OVERLAPPING_RELATION__SNAME = SaltCorePackage.SRELATION__SNAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXT_OVERLAPPING_RELATION__SELEMENT_ID = SaltCorePackage.SRELATION__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXT_OVERLAPPING_RELATION__SID = SaltCorePackage.SRELATION__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXT_OVERLAPPING_RELATION__SELEMENT_PATH = SaltCorePackage.SRELATION__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXT_OVERLAPPING_RELATION__SPROCESSING_ANNOTATIONS = SaltCorePackage.SRELATION__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXT_OVERLAPPING_RELATION__SFEATURES = SaltCorePackage.SRELATION__SFEATURES;

	/**
	 * The feature id for the '<em><b>SSource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXT_OVERLAPPING_RELATION__SSOURCE = SaltCorePackage.SRELATION__SSOURCE;

	/**
	 * The feature id for the '<em><b>STarget</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXT_OVERLAPPING_RELATION__STARGET = SaltCorePackage.SRELATION__STARGET;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXT_OVERLAPPING_RELATION__SGRAPH = SaltCorePackage.SRELATION__SGRAPH;

	/**
	 * The number of structural features of the '<em>SText Overlapping Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXT_OVERLAPPING_RELATION_FEATURE_COUNT = SaltCorePackage.SRELATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STimeOverlappingRelationImpl <em>STime Overlapping Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STimeOverlappingRelationImpl
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSTimeOverlappingRelation()
	 * @generated
	 */
	int STIME_OVERLAPPING_RELATION = 11;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIME_OVERLAPPING_RELATION__LABELS = SaltCorePackage.SRELATION__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIME_OVERLAPPING_RELATION__ID = SaltCorePackage.SRELATION__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIME_OVERLAPPING_RELATION__IDENTIFIER = SaltCorePackage.SRELATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIME_OVERLAPPING_RELATION__GRAPH = SaltCorePackage.SRELATION__GRAPH;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIME_OVERLAPPING_RELATION__SOURCE = SaltCorePackage.SRELATION__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIME_OVERLAPPING_RELATION__TARGET = SaltCorePackage.SRELATION__TARGET;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIME_OVERLAPPING_RELATION__SANNOTATIONS = SaltCorePackage.SRELATION__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIME_OVERLAPPING_RELATION__SNAME = SaltCorePackage.SRELATION__SNAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIME_OVERLAPPING_RELATION__SELEMENT_ID = SaltCorePackage.SRELATION__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIME_OVERLAPPING_RELATION__SID = SaltCorePackage.SRELATION__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIME_OVERLAPPING_RELATION__SELEMENT_PATH = SaltCorePackage.SRELATION__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIME_OVERLAPPING_RELATION__SPROCESSING_ANNOTATIONS = SaltCorePackage.SRELATION__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIME_OVERLAPPING_RELATION__SFEATURES = SaltCorePackage.SRELATION__SFEATURES;

	/**
	 * The feature id for the '<em><b>SSource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIME_OVERLAPPING_RELATION__SSOURCE = SaltCorePackage.SRELATION__SSOURCE;

	/**
	 * The feature id for the '<em><b>STarget</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIME_OVERLAPPING_RELATION__STARGET = SaltCorePackage.SRELATION__STARGET;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIME_OVERLAPPING_RELATION__SGRAPH = SaltCorePackage.SRELATION__SGRAPH;

	/**
	 * The number of structural features of the '<em>STime Overlapping Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIME_OVERLAPPING_RELATION_FEATURE_COUNT = SaltCorePackage.SRELATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SFEATURE_NAMES <em>SFEATURE NAMES</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SFEATURE_NAMES
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSFEATURE_NAMES()
	 * @generated
	 */
	int SFEATURE_NAMES = 12;


	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SDocument Graph</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph
	 * @generated
	 */
	EClass getSDocumentGraph();

	/**
	 * Returns the meta object for the reference '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSDocument <em>SDocument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SDocument</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSDocument()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_SDocument();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualDSs <em>STextual DSs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>STextual DSs</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualDSs()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_STextualDSs();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualRelations <em>STextual Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>STextual Relations</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualRelations()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_STextualRelations();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTokens <em>STokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>STokens</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTokens()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_STokens();

	/**
	 * Returns the meta object for the reference '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimeline <em>STimeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>STimeline</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimeline()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_STimeline();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimelineRelations <em>STimeline Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>STimeline Relations</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimelineRelations()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_STimelineRelations();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSSpanningRelations <em>SSpanning Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SSpanning Relations</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSSpanningRelations()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_SSpanningRelations();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSSpans <em>SSpans</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SSpans</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSSpans()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_SSpans();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS <em>STextual DS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>STextual DS</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS
	 * @generated
	 */
	EClass getSTextualDS();

	/**
	 * Returns the meta object for the attribute '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS#getSText <em>SText</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SText</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS#getSText()
	 * @see #getSTextualDS()
	 * @generated
	 */
	EAttribute getSTextualDS_SText();

	/**
	 * Returns the meta object for the container reference '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SDocument Graph</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS#getSDocumentGraph()
	 * @see #getSTextualDS()
	 * @generated
	 */
	EReference getSTextualDS_SDocumentGraph();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken <em>SToken</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SToken</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken
	 * @generated
	 */
	EClass getSToken();

	/**
	 * Returns the meta object for the container reference '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SDocument Graph</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken#getSDocumentGraph()
	 * @see #getSToken()
	 * @generated
	 */
	EReference getSToken_SDocumentGraph();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation <em>STextual Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>STextual Relation</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation
	 * @generated
	 */
	EClass getSTextualRelation();

	/**
	 * Returns the meta object for the reference '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#getSToken <em>SToken</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SToken</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#getSToken()
	 * @see #getSTextualRelation()
	 * @generated
	 */
	EReference getSTextualRelation_SToken();

	/**
	 * Returns the meta object for the reference '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#getSTextualDS <em>STextual DS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>STextual DS</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#getSTextualDS()
	 * @see #getSTextualRelation()
	 * @generated
	 */
	EReference getSTextualRelation_STextualDS();

	/**
	 * Returns the meta object for the container reference '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SDocument Graph</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation#getSDocumentGraph()
	 * @see #getSTextualRelation()
	 * @generated
	 */
	EReference getSTextualRelation_SDocumentGraph();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialRelation <em>SSequential Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SSequential Relation</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialRelation
	 * @generated
	 */
	EClass getSSequentialRelation();

	/**
	 * Returns the meta object for the attribute '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialRelation#getSStart <em>SStart</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SStart</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialRelation#getSStart()
	 * @see #getSSequentialRelation()
	 * @generated
	 */
	EAttribute getSSequentialRelation_SStart();

	/**
	 * Returns the meta object for the attribute '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialRelation#getSEnd <em>SEnd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SEnd</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialRelation#getSEnd()
	 * @see #getSSequentialRelation()
	 * @generated
	 */
	EAttribute getSSequentialRelation_SEnd();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialDS <em>SSequential DS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SSequential DS</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialDS
	 * @generated
	 */
	EClass getSSequentialDS();

	/**
	 * Returns the meta object for the attribute '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialDS#getSData <em>SData</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SData</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialDS#getSData()
	 * @see #getSSequentialDS()
	 * @generated
	 */
	EAttribute getSSequentialDS_SData();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeline <em>STimeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>STimeline</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeline
	 * @generated
	 */
	EClass getSTimeline();

	/**
	 * Returns the meta object for the attribute list '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeline#getSPointsOfTime <em>SPoints Of Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>SPoints Of Time</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeline#getSPointsOfTime()
	 * @see #getSTimeline()
	 * @generated
	 */
	EAttribute getSTimeline_SPointsOfTime();

	/**
	 * Returns the meta object for the reference '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeline#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SDocument Graph</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeline#getSDocumentGraph()
	 * @see #getSTimeline()
	 * @generated
	 */
	EReference getSTimeline_SDocumentGraph();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STimelineRelation <em>STimeline Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>STimeline Relation</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STimelineRelation
	 * @generated
	 */
	EClass getSTimelineRelation();

	/**
	 * Returns the meta object for the reference '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STimelineRelation#getSTimeline <em>STimeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>STimeline</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STimelineRelation#getSTimeline()
	 * @see #getSTimelineRelation()
	 * @generated
	 */
	EReference getSTimelineRelation_STimeline();

	/**
	 * Returns the meta object for the reference '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STimelineRelation#getSToken <em>SToken</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SToken</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STimelineRelation#getSToken()
	 * @see #getSTimelineRelation()
	 * @generated
	 */
	EReference getSTimelineRelation_SToken();

	/**
	 * Returns the meta object for the reference '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STimelineRelation#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SDocument Graph</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STimelineRelation#getSDocumentGraph()
	 * @see #getSTimelineRelation()
	 * @generated
	 */
	EReference getSTimelineRelation_SDocumentGraph();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SSpan <em>SSpan</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SSpan</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SSpan
	 * @generated
	 */
	EClass getSSpan();

	/**
	 * Returns the meta object for the container reference '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SSpan#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SDocument Graph</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SSpan#getSDocumentGraph()
	 * @see #getSSpan()
	 * @generated
	 */
	EReference getSSpan_SDocumentGraph();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SSpanningRelation <em>SSpanning Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SSpanning Relation</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SSpanningRelation
	 * @generated
	 */
	EClass getSSpanningRelation();

	/**
	 * Returns the meta object for the reference '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SSpanningRelation#getSToken <em>SToken</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SToken</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SSpanningRelation#getSToken()
	 * @see #getSSpanningRelation()
	 * @generated
	 */
	EReference getSSpanningRelation_SToken();

	/**
	 * Returns the meta object for the reference '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SSpanningRelation#getSSpan <em>SSpan</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SSpan</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SSpanningRelation#getSSpan()
	 * @see #getSSpanningRelation()
	 * @generated
	 */
	EReference getSSpanningRelation_SSpan();

	/**
	 * Returns the meta object for the container reference '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SSpanningRelation#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SDocument Graph</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SSpanningRelation#getSDocumentGraph()
	 * @see #getSSpanningRelation()
	 * @generated
	 */
	EReference getSSpanningRelation_SDocumentGraph();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STextOverlappingRelation <em>SText Overlapping Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SText Overlapping Relation</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STextOverlappingRelation
	 * @generated
	 */
	EClass getSTextOverlappingRelation();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeOverlappingRelation <em>STime Overlapping Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>STime Overlapping Relation</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeOverlappingRelation
	 * @generated
	 */
	EClass getSTimeOverlappingRelation();

	/**
	 * Returns the meta object for enum '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SFEATURE_NAMES <em>SFEATURE NAMES</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>SFEATURE NAMES</em>'.
	 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SFEATURE_NAMES
	 * @generated
	 */
	EEnum getSFEATURE_NAMES();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SDocumentStructureFactory getSDocumentStructureFactory();

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
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentGraphImpl <em>SDocument Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentGraphImpl
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSDocumentGraph()
		 * @generated
		 */
		EClass SDOCUMENT_GRAPH = eINSTANCE.getSDocumentGraph();

		/**
		 * The meta object literal for the '<em><b>SDocument</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOCUMENT_GRAPH__SDOCUMENT = eINSTANCE.getSDocumentGraph_SDocument();

		/**
		 * The meta object literal for the '<em><b>STextual DSs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOCUMENT_GRAPH__STEXTUAL_DSS = eINSTANCE.getSDocumentGraph_STextualDSs();

		/**
		 * The meta object literal for the '<em><b>STextual Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOCUMENT_GRAPH__STEXTUAL_RELATIONS = eINSTANCE.getSDocumentGraph_STextualRelations();

		/**
		 * The meta object literal for the '<em><b>STokens</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOCUMENT_GRAPH__STOKENS = eINSTANCE.getSDocumentGraph_STokens();

		/**
		 * The meta object literal for the '<em><b>STimeline</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOCUMENT_GRAPH__STIMELINE = eINSTANCE.getSDocumentGraph_STimeline();

		/**
		 * The meta object literal for the '<em><b>STimeline Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOCUMENT_GRAPH__STIMELINE_RELATIONS = eINSTANCE.getSDocumentGraph_STimelineRelations();

		/**
		 * The meta object literal for the '<em><b>SSpanning Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOCUMENT_GRAPH__SSPANNING_RELATIONS = eINSTANCE.getSDocumentGraph_SSpanningRelations();

		/**
		 * The meta object literal for the '<em><b>SSpans</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOCUMENT_GRAPH__SSPANS = eINSTANCE.getSDocumentGraph_SSpans();

		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextualDSImpl <em>STextual DS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextualDSImpl
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSTextualDS()
		 * @generated
		 */
		EClass STEXTUAL_DS = eINSTANCE.getSTextualDS();

		/**
		 * The meta object literal for the '<em><b>SText</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEXTUAL_DS__STEXT = eINSTANCE.getSTextualDS_SText();

		/**
		 * The meta object literal for the '<em><b>SDocument Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEXTUAL_DS__SDOCUMENT_GRAPH = eINSTANCE.getSTextualDS_SDocumentGraph();

		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STokenImpl <em>SToken</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STokenImpl
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSToken()
		 * @generated
		 */
		EClass STOKEN = eINSTANCE.getSToken();

		/**
		 * The meta object literal for the '<em><b>SDocument Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STOKEN__SDOCUMENT_GRAPH = eINSTANCE.getSToken_SDocumentGraph();

		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextualRelationImpl <em>STextual Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextualRelationImpl
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSTextualRelation()
		 * @generated
		 */
		EClass STEXTUAL_RELATION = eINSTANCE.getSTextualRelation();

		/**
		 * The meta object literal for the '<em><b>SToken</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEXTUAL_RELATION__STOKEN = eINSTANCE.getSTextualRelation_SToken();

		/**
		 * The meta object literal for the '<em><b>STextual DS</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEXTUAL_RELATION__STEXTUAL_DS = eINSTANCE.getSTextualRelation_STextualDS();

		/**
		 * The meta object literal for the '<em><b>SDocument Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEXTUAL_RELATION__SDOCUMENT_GRAPH = eINSTANCE.getSTextualRelation_SDocumentGraph();

		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SSequentialRelationImpl <em>SSequential Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SSequentialRelationImpl
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSSequentialRelation()
		 * @generated
		 */
		EClass SSEQUENTIAL_RELATION = eINSTANCE.getSSequentialRelation();

		/**
		 * The meta object literal for the '<em><b>SStart</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SSEQUENTIAL_RELATION__SSTART = eINSTANCE.getSSequentialRelation_SStart();

		/**
		 * The meta object literal for the '<em><b>SEnd</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SSEQUENTIAL_RELATION__SEND = eINSTANCE.getSSequentialRelation_SEnd();

		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SSequentialDSImpl <em>SSequential DS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SSequentialDSImpl
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSSequentialDS()
		 * @generated
		 */
		EClass SSEQUENTIAL_DS = eINSTANCE.getSSequentialDS();

		/**
		 * The meta object literal for the '<em><b>SData</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SSEQUENTIAL_DS__SDATA = eINSTANCE.getSSequentialDS_SData();

		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STimelineImpl <em>STimeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STimelineImpl
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSTimeline()
		 * @generated
		 */
		EClass STIMELINE = eINSTANCE.getSTimeline();

		/**
		 * The meta object literal for the '<em><b>SPoints Of Time</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STIMELINE__SPOINTS_OF_TIME = eINSTANCE.getSTimeline_SPointsOfTime();

		/**
		 * The meta object literal for the '<em><b>SDocument Graph</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STIMELINE__SDOCUMENT_GRAPH = eINSTANCE.getSTimeline_SDocumentGraph();

		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STimelineRelationImpl <em>STimeline Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STimelineRelationImpl
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSTimelineRelation()
		 * @generated
		 */
		EClass STIMELINE_RELATION = eINSTANCE.getSTimelineRelation();

		/**
		 * The meta object literal for the '<em><b>STimeline</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STIMELINE_RELATION__STIMELINE = eINSTANCE.getSTimelineRelation_STimeline();

		/**
		 * The meta object literal for the '<em><b>SToken</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STIMELINE_RELATION__STOKEN = eINSTANCE.getSTimelineRelation_SToken();

		/**
		 * The meta object literal for the '<em><b>SDocument Graph</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STIMELINE_RELATION__SDOCUMENT_GRAPH = eINSTANCE.getSTimelineRelation_SDocumentGraph();

		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SSpanImpl <em>SSpan</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SSpanImpl
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSSpan()
		 * @generated
		 */
		EClass SSPAN = eINSTANCE.getSSpan();

		/**
		 * The meta object literal for the '<em><b>SDocument Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SSPAN__SDOCUMENT_GRAPH = eINSTANCE.getSSpan_SDocumentGraph();

		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SSpanningRelationImpl <em>SSpanning Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SSpanningRelationImpl
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSSpanningRelation()
		 * @generated
		 */
		EClass SSPANNING_RELATION = eINSTANCE.getSSpanningRelation();

		/**
		 * The meta object literal for the '<em><b>SToken</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SSPANNING_RELATION__STOKEN = eINSTANCE.getSSpanningRelation_SToken();

		/**
		 * The meta object literal for the '<em><b>SSpan</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SSPANNING_RELATION__SSPAN = eINSTANCE.getSSpanningRelation_SSpan();

		/**
		 * The meta object literal for the '<em><b>SDocument Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SSPANNING_RELATION__SDOCUMENT_GRAPH = eINSTANCE.getSSpanningRelation_SDocumentGraph();

		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextOverlappingRelationImpl <em>SText Overlapping Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STextOverlappingRelationImpl
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSTextOverlappingRelation()
		 * @generated
		 */
		EClass STEXT_OVERLAPPING_RELATION = eINSTANCE.getSTextOverlappingRelation();

		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STimeOverlappingRelationImpl <em>STime Overlapping Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STimeOverlappingRelationImpl
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSTimeOverlappingRelation()
		 * @generated
		 */
		EClass STIME_OVERLAPPING_RELATION = eINSTANCE.getSTimeOverlappingRelation();

		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.SFEATURE_NAMES <em>SFEATURE NAMES</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SFEATURE_NAMES
		 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSFEATURE_NAMES()
		 * @generated
		 */
		EEnum SFEATURE_NAMES = eINSTANCE.getSFEATURE_NAMES();

	}

} //SDocumentStructurePackage
