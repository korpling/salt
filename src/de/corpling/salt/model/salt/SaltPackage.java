/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.salt;

import de.corpling.salt.model.saltCore.SaltCorePackage;

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
 * @see de.corpling.salt.model.salt.SaltFactory
 * @model kind="package"
 * @generated
 */
public interface SaltPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "salt";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "www.corpling.salt.model.salt";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "salt";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SaltPackage eINSTANCE = de.corpling.salt.model.salt.impl.SaltPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.salt.impl.STokenImpl <em>SToken</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.salt.impl.STokenImpl
	 * @see de.corpling.salt.model.salt.impl.SaltPackageImpl#getSToken()
	 * @generated
	 */
	int STOKEN = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__NAME = SaltCorePackage.SELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__TYPE = SaltCorePackage.SELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__ID = SaltCorePackage.SELEMENT__ID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SELEMENT_PATH = SaltCorePackage.SELEMENT__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__LABELS = SaltCorePackage.SELEMENT__LABELS;

	/**
	 * The feature id for the '<em><b>Num Of Labels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__NUM_OF_LABELS = SaltCorePackage.SELEMENT__NUM_OF_LABELS;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SANNOTATIONS = SaltCorePackage.SELEMENT__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SStereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SSTEREOTYPE = SaltCorePackage.SELEMENT__SSTEREOTYPE;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SFEATURES = SaltCorePackage.SELEMENT__SFEATURES;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SPROCESSING_ANNOTATIONS = SaltCorePackage.SELEMENT__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__GRAPH = SaltCorePackage.SELEMENT__GRAPH;

	/**
	 * The feature id for the '<em><b>Labelable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__LABELABLE_ELEMENT = SaltCorePackage.SELEMENT__LABELABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SSterotypeable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SSTEROTYPEABLE_ELEMENT = SaltCorePackage.SELEMENT__SSTEROTYPEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SAnnotatable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SANNOTATABLE_ELEMENT = SaltCorePackage.SELEMENT__SANNOTATABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SProcessing Annotatable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SPROCESSING_ANNOTATABLE_ELEMENT = SaltCorePackage.SELEMENT__SPROCESSING_ANNOTATABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SGRAPH = SaltCorePackage.SELEMENT__SGRAPH;

	/**
	 * The feature id for the '<em><b>SLeft</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SLEFT = SaltCorePackage.SELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SRight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SRIGHT = SaltCorePackage.SELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SDocument Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SDOCUMENT_GRAPH = SaltCorePackage.SELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>SToken</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN_FEATURE_COUNT = SaltCorePackage.SELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.salt.impl.SDataSourceImpl <em>SData Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.salt.impl.SDataSourceImpl
	 * @see de.corpling.salt.model.salt.impl.SaltPackageImpl#getSDataSource()
	 * @generated
	 */
	int SDATA_SOURCE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDATA_SOURCE__NAME = SaltCorePackage.SELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDATA_SOURCE__TYPE = SaltCorePackage.SELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDATA_SOURCE__ID = SaltCorePackage.SELEMENT__ID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDATA_SOURCE__SELEMENT_PATH = SaltCorePackage.SELEMENT__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDATA_SOURCE__LABELS = SaltCorePackage.SELEMENT__LABELS;

	/**
	 * The feature id for the '<em><b>Num Of Labels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDATA_SOURCE__NUM_OF_LABELS = SaltCorePackage.SELEMENT__NUM_OF_LABELS;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDATA_SOURCE__SANNOTATIONS = SaltCorePackage.SELEMENT__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SStereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDATA_SOURCE__SSTEREOTYPE = SaltCorePackage.SELEMENT__SSTEREOTYPE;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDATA_SOURCE__SFEATURES = SaltCorePackage.SELEMENT__SFEATURES;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDATA_SOURCE__SPROCESSING_ANNOTATIONS = SaltCorePackage.SELEMENT__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDATA_SOURCE__GRAPH = SaltCorePackage.SELEMENT__GRAPH;

	/**
	 * The feature id for the '<em><b>Labelable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDATA_SOURCE__LABELABLE_ELEMENT = SaltCorePackage.SELEMENT__LABELABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SSterotypeable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDATA_SOURCE__SSTEROTYPEABLE_ELEMENT = SaltCorePackage.SELEMENT__SSTEROTYPEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SAnnotatable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDATA_SOURCE__SANNOTATABLE_ELEMENT = SaltCorePackage.SELEMENT__SANNOTATABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SProcessing Annotatable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDATA_SOURCE__SPROCESSING_ANNOTATABLE_ELEMENT = SaltCorePackage.SELEMENT__SPROCESSING_ANNOTATABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDATA_SOURCE__SGRAPH = SaltCorePackage.SELEMENT__SGRAPH;

	/**
	 * The feature id for the '<em><b>SData Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDATA_SOURCE__SDATA_SOURCE = SaltCorePackage.SELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SData Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDATA_SOURCE_FEATURE_COUNT = SaltCorePackage.SELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.salt.impl.STextualDataSourceImpl <em>STextual Data Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.salt.impl.STextualDataSourceImpl
	 * @see de.corpling.salt.model.salt.impl.SaltPackageImpl#getSTextualDataSource()
	 * @generated
	 */
	int STEXTUAL_DATA_SOURCE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DATA_SOURCE__NAME = SDATA_SOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DATA_SOURCE__TYPE = SDATA_SOURCE__TYPE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DATA_SOURCE__ID = SDATA_SOURCE__ID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DATA_SOURCE__SELEMENT_PATH = SDATA_SOURCE__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DATA_SOURCE__LABELS = SDATA_SOURCE__LABELS;

	/**
	 * The feature id for the '<em><b>Num Of Labels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DATA_SOURCE__NUM_OF_LABELS = SDATA_SOURCE__NUM_OF_LABELS;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DATA_SOURCE__SANNOTATIONS = SDATA_SOURCE__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SStereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DATA_SOURCE__SSTEREOTYPE = SDATA_SOURCE__SSTEREOTYPE;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DATA_SOURCE__SFEATURES = SDATA_SOURCE__SFEATURES;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DATA_SOURCE__SPROCESSING_ANNOTATIONS = SDATA_SOURCE__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DATA_SOURCE__GRAPH = SDATA_SOURCE__GRAPH;

	/**
	 * The feature id for the '<em><b>Labelable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DATA_SOURCE__LABELABLE_ELEMENT = SDATA_SOURCE__LABELABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SSterotypeable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DATA_SOURCE__SSTEROTYPEABLE_ELEMENT = SDATA_SOURCE__SSTEROTYPEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SAnnotatable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DATA_SOURCE__SANNOTATABLE_ELEMENT = SDATA_SOURCE__SANNOTATABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SProcessing Annotatable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DATA_SOURCE__SPROCESSING_ANNOTATABLE_ELEMENT = SDATA_SOURCE__SPROCESSING_ANNOTATABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DATA_SOURCE__SGRAPH = SDATA_SOURCE__SGRAPH;

	/**
	 * The feature id for the '<em><b>SData Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DATA_SOURCE__SDATA_SOURCE = SDATA_SOURCE__SDATA_SOURCE;

	/**
	 * The feature id for the '<em><b>SText</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DATA_SOURCE__STEXT = SDATA_SOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SDocument Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DATA_SOURCE__SDOCUMENT_GRAPH = SDATA_SOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>STextual Data Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DATA_SOURCE_FEATURE_COUNT = SDATA_SOURCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.salt.impl.SDocumentGraphImpl <em>SDocument Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.salt.impl.SDocumentGraphImpl
	 * @see de.corpling.salt.model.salt.impl.SaltPackageImpl#getSDocumentGraph()
	 * @generated
	 */
	int SDOCUMENT_GRAPH = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__ID = SaltCorePackage.SGRAPH__ID;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__LABELS = SaltCorePackage.SGRAPH__LABELS;

	/**
	 * The feature id for the '<em><b>Num Of Labels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__NUM_OF_LABELS = SaltCorePackage.SGRAPH__NUM_OF_LABELS;

	/**
	 * The feature id for the '<em><b>Indexes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__INDEXES = SaltCorePackage.SGRAPH__INDEXES;

	/**
	 * The feature id for the '<em><b>Num Of Indexes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__NUM_OF_INDEXES = SaltCorePackage.SGRAPH__NUM_OF_INDEXES;

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
	 * The feature id for the '<em><b>Labelable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__LABELABLE_ELEMENT = SaltCorePackage.SGRAPH__LABELABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Index Mgr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__INDEX_MGR = SaltCorePackage.SGRAPH__INDEX_MGR;

	/**
	 * The feature id for the '<em><b>SElements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SELEMENTS = SaltCorePackage.SGRAPH__SELEMENTS;

	/**
	 * The feature id for the '<em><b>SRelations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SRELATIONS = SaltCorePackage.SGRAPH__SRELATIONS;

	/**
	 * The feature id for the '<em><b>SCore Project</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SCORE_PROJECT = SaltCorePackage.SGRAPH__SCORE_PROJECT;

	/**
	 * The feature id for the '<em><b>STokens</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__STOKENS = SaltCorePackage.SGRAPH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>STextual Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__STEXTUAL_RELATIONS = SaltCorePackage.SGRAPH_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>STextual Data Sources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__STEXTUAL_DATA_SOURCES = SaltCorePackage.SGRAPH_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>SStructures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SSTRUCTURES = SaltCorePackage.SGRAPH_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Span Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SPAN_RELATIONS = SaltCorePackage.SGRAPH_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>SDocument</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SDOCUMENT = SaltCorePackage.SGRAPH_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>SDocument Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH_FEATURE_COUNT = SaltCorePackage.SGRAPH_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.salt.impl.STextualRelationImpl <em>STextual Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.salt.impl.STextualRelationImpl
	 * @see de.corpling.salt.model.salt.impl.SaltPackageImpl#getSTextualRelation()
	 * @generated
	 */
	int STEXTUAL_RELATION = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__ID = SaltCorePackage.SRELATION__ID;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__LABELS = SaltCorePackage.SRELATION__LABELS;

	/**
	 * The feature id for the '<em><b>Num Of Labels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__NUM_OF_LABELS = SaltCorePackage.SRELATION__NUM_OF_LABELS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SOURCE = SaltCorePackage.SRELATION__SOURCE;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__DESTINATION = SaltCorePackage.SRELATION__DESTINATION;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__GRAPH = SaltCorePackage.SRELATION__GRAPH;

	/**
	 * The feature id for the '<em><b>Labelable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__LABELABLE_ELEMENT = SaltCorePackage.SRELATION__LABELABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__NAME = SaltCorePackage.SRELATION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__TYPE = SaltCorePackage.SRELATION__TYPE;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SELEMENT_PATH = SaltCorePackage.SRELATION__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SANNOTATIONS = SaltCorePackage.SRELATION__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SStereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SSTEREOTYPE = SaltCorePackage.SRELATION__SSTEREOTYPE;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SFEATURES = SaltCorePackage.SRELATION__SFEATURES;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SPROCESSING_ANNOTATIONS = SaltCorePackage.SRELATION__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SSource Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SSOURCE_ELEMENT = SaltCorePackage.SRELATION__SSOURCE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SDestination Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SDESTINATION_ELEMENT = SaltCorePackage.SRELATION__SDESTINATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>SStereotypable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SSTEREOTYPABLE_ELEMENT = SaltCorePackage.SRELATION__SSTEREOTYPABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SAnnotatable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SANNOTATABLE_ELEMENT = SaltCorePackage.SRELATION__SANNOTATABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SProcessing Annotatable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SPROCESSING_ANNOTATABLE_ELEMENT = SaltCorePackage.SRELATION__SPROCESSING_ANNOTATABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SGRAPH = SaltCorePackage.SRELATION__SGRAPH;

	/**
	 * The feature id for the '<em><b>SType</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__STYPE = SaltCorePackage.SRELATION__STYPE;

	/**
	 * The feature id for the '<em><b>SToken</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__STOKEN = SaltCorePackage.SRELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>STextual Data Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__STEXTUAL_DATA_SOURCE = SaltCorePackage.SRELATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SLeft Pos</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SLEFT_POS = SaltCorePackage.SRELATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>SRight Pos</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SRIGHT_POS = SaltCorePackage.SRELATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>SDocument Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SDOCUMENT_GRAPH = SaltCorePackage.SRELATION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>STextual Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION_FEATURE_COUNT = SaltCorePackage.SRELATION_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.salt.impl.SStructureImpl <em>SStructure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.salt.impl.SStructureImpl
	 * @see de.corpling.salt.model.salt.impl.SaltPackageImpl#getSStructure()
	 * @generated
	 */
	int SSTRUCTURE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__NAME = SaltCorePackage.SELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__TYPE = SaltCorePackage.SELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__ID = SaltCorePackage.SELEMENT__ID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__SELEMENT_PATH = SaltCorePackage.SELEMENT__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__LABELS = SaltCorePackage.SELEMENT__LABELS;

	/**
	 * The feature id for the '<em><b>Num Of Labels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__NUM_OF_LABELS = SaltCorePackage.SELEMENT__NUM_OF_LABELS;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__SANNOTATIONS = SaltCorePackage.SELEMENT__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SStereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__SSTEREOTYPE = SaltCorePackage.SELEMENT__SSTEREOTYPE;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__SFEATURES = SaltCorePackage.SELEMENT__SFEATURES;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__SPROCESSING_ANNOTATIONS = SaltCorePackage.SELEMENT__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__GRAPH = SaltCorePackage.SELEMENT__GRAPH;

	/**
	 * The feature id for the '<em><b>Labelable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__LABELABLE_ELEMENT = SaltCorePackage.SELEMENT__LABELABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SSterotypeable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__SSTEROTYPEABLE_ELEMENT = SaltCorePackage.SELEMENT__SSTEROTYPEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SAnnotatable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__SANNOTATABLE_ELEMENT = SaltCorePackage.SELEMENT__SANNOTATABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SProcessing Annotatable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__SPROCESSING_ANNOTATABLE_ELEMENT = SaltCorePackage.SELEMENT__SPROCESSING_ANNOTATABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__SGRAPH = SaltCorePackage.SELEMENT__SGRAPH;

	/**
	 * The feature id for the '<em><b>SDocument Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__SDOCUMENT_GRAPH = SaltCorePackage.SELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SStructure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE_FEATURE_COUNT = SaltCorePackage.SELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.salt.impl.SSpanRelationImpl <em>SSpan Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.salt.impl.SSpanRelationImpl
	 * @see de.corpling.salt.model.salt.impl.SaltPackageImpl#getSSpanRelation()
	 * @generated
	 */
	int SSPAN_RELATION = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN_RELATION__ID = SaltCorePackage.SRELATION__ID;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN_RELATION__LABELS = SaltCorePackage.SRELATION__LABELS;

	/**
	 * The feature id for the '<em><b>Num Of Labels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN_RELATION__NUM_OF_LABELS = SaltCorePackage.SRELATION__NUM_OF_LABELS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN_RELATION__SOURCE = SaltCorePackage.SRELATION__SOURCE;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN_RELATION__DESTINATION = SaltCorePackage.SRELATION__DESTINATION;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN_RELATION__GRAPH = SaltCorePackage.SRELATION__GRAPH;

	/**
	 * The feature id for the '<em><b>Labelable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN_RELATION__LABELABLE_ELEMENT = SaltCorePackage.SRELATION__LABELABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN_RELATION__NAME = SaltCorePackage.SRELATION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN_RELATION__TYPE = SaltCorePackage.SRELATION__TYPE;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN_RELATION__SELEMENT_PATH = SaltCorePackage.SRELATION__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN_RELATION__SANNOTATIONS = SaltCorePackage.SRELATION__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SStereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN_RELATION__SSTEREOTYPE = SaltCorePackage.SRELATION__SSTEREOTYPE;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN_RELATION__SFEATURES = SaltCorePackage.SRELATION__SFEATURES;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN_RELATION__SPROCESSING_ANNOTATIONS = SaltCorePackage.SRELATION__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SSource Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN_RELATION__SSOURCE_ELEMENT = SaltCorePackage.SRELATION__SSOURCE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SDestination Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN_RELATION__SDESTINATION_ELEMENT = SaltCorePackage.SRELATION__SDESTINATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>SStereotypable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN_RELATION__SSTEREOTYPABLE_ELEMENT = SaltCorePackage.SRELATION__SSTEREOTYPABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SAnnotatable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN_RELATION__SANNOTATABLE_ELEMENT = SaltCorePackage.SRELATION__SANNOTATABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SProcessing Annotatable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN_RELATION__SPROCESSING_ANNOTATABLE_ELEMENT = SaltCorePackage.SRELATION__SPROCESSING_ANNOTATABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN_RELATION__SGRAPH = SaltCorePackage.SRELATION__SGRAPH;

	/**
	 * The feature id for the '<em><b>SType</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN_RELATION__STYPE = SaltCorePackage.SRELATION__STYPE;

	/**
	 * The feature id for the '<em><b>SDocument Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN_RELATION__SDOCUMENT_GRAPH = SaltCorePackage.SRELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SStructure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN_RELATION__SSTRUCTURE = SaltCorePackage.SRELATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SToken</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN_RELATION__STOKEN = SaltCorePackage.SRELATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>SSpan Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN_RELATION_FEATURE_COUNT = SaltCorePackage.SRELATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.salt.impl.SProjectImpl <em>SProject</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.salt.impl.SProjectImpl
	 * @see de.corpling.salt.model.salt.impl.SaltPackageImpl#getSProject()
	 * @generated
	 */
	int SPROJECT = 7;

	/**
	 * The feature id for the '<em><b>SStereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROJECT__SSTEREOTYPES = SaltCorePackage.SCORE_PROJECT__SSTEREOTYPES;

	/**
	 * The feature id for the '<em><b>SGraphs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROJECT__SGRAPHS = SaltCorePackage.SCORE_PROJECT__SGRAPHS;

	/**
	 * The feature id for the '<em><b>SStereotype Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROJECT__SSTEREOTYPE_CONTAINER = SaltCorePackage.SCORE_PROJECT__SSTEREOTYPE_CONTAINER;

	/**
	 * The feature id for the '<em><b>SCorpus Graphs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROJECT__SCORPUS_GRAPHS = SaltCorePackage.SCORE_PROJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SProject</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPROJECT_FEATURE_COUNT = SaltCorePackage.SCORE_PROJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.salt.impl.SCorpusImpl <em>SCorpus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.salt.impl.SCorpusImpl
	 * @see de.corpling.salt.model.salt.impl.SaltPackageImpl#getSCorpus()
	 * @generated
	 */
	int SCORPUS = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__NAME = SaltCorePackage.SELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__TYPE = SaltCorePackage.SELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__ID = SaltCorePackage.SELEMENT__ID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__SELEMENT_PATH = SaltCorePackage.SELEMENT__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__LABELS = SaltCorePackage.SELEMENT__LABELS;

	/**
	 * The feature id for the '<em><b>Num Of Labels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__NUM_OF_LABELS = SaltCorePackage.SELEMENT__NUM_OF_LABELS;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__SANNOTATIONS = SaltCorePackage.SELEMENT__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SStereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__SSTEREOTYPE = SaltCorePackage.SELEMENT__SSTEREOTYPE;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__SFEATURES = SaltCorePackage.SELEMENT__SFEATURES;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__SPROCESSING_ANNOTATIONS = SaltCorePackage.SELEMENT__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__GRAPH = SaltCorePackage.SELEMENT__GRAPH;

	/**
	 * The feature id for the '<em><b>Labelable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__LABELABLE_ELEMENT = SaltCorePackage.SELEMENT__LABELABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SSterotypeable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__SSTEROTYPEABLE_ELEMENT = SaltCorePackage.SELEMENT__SSTEROTYPEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SAnnotatable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__SANNOTATABLE_ELEMENT = SaltCorePackage.SELEMENT__SANNOTATABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SProcessing Annotatable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__SPROCESSING_ANNOTATABLE_ELEMENT = SaltCorePackage.SELEMENT__SPROCESSING_ANNOTATABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__SGRAPH = SaltCorePackage.SELEMENT__SGRAPH;

	/**
	 * The number of structural features of the '<em>SCorpus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_FEATURE_COUNT = SaltCorePackage.SELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.salt.impl.SCorpusGraphImpl <em>SCorpus Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.salt.impl.SCorpusGraphImpl
	 * @see de.corpling.salt.model.salt.impl.SaltPackageImpl#getSCorpusGraph()
	 * @generated
	 */
	int SCORPUS_GRAPH = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__ID = SaltCorePackage.SGRAPH__ID;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__LABELS = SaltCorePackage.SGRAPH__LABELS;

	/**
	 * The feature id for the '<em><b>Num Of Labels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__NUM_OF_LABELS = SaltCorePackage.SGRAPH__NUM_OF_LABELS;

	/**
	 * The feature id for the '<em><b>Indexes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__INDEXES = SaltCorePackage.SGRAPH__INDEXES;

	/**
	 * The feature id for the '<em><b>Num Of Indexes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__NUM_OF_INDEXES = SaltCorePackage.SGRAPH__NUM_OF_INDEXES;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__NODES = SaltCorePackage.SGRAPH__NODES;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__EDGES = SaltCorePackage.SGRAPH__EDGES;

	/**
	 * The feature id for the '<em><b>Num Of Nodes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__NUM_OF_NODES = SaltCorePackage.SGRAPH__NUM_OF_NODES;

	/**
	 * The feature id for the '<em><b>Num Of Edges</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__NUM_OF_EDGES = SaltCorePackage.SGRAPH__NUM_OF_EDGES;

	/**
	 * The feature id for the '<em><b>Labelable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__LABELABLE_ELEMENT = SaltCorePackage.SGRAPH__LABELABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Index Mgr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__INDEX_MGR = SaltCorePackage.SGRAPH__INDEX_MGR;

	/**
	 * The feature id for the '<em><b>SElements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__SELEMENTS = SaltCorePackage.SGRAPH__SELEMENTS;

	/**
	 * The feature id for the '<em><b>SRelations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__SRELATIONS = SaltCorePackage.SGRAPH__SRELATIONS;

	/**
	 * The feature id for the '<em><b>SCore Project</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__SCORE_PROJECT = SaltCorePackage.SGRAPH__SCORE_PROJECT;

	/**
	 * The feature id for the '<em><b>SCorpora</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__SCORPORA = SaltCorePackage.SGRAPH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SDocuments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__SDOCUMENTS = SaltCorePackage.SGRAPH_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SCorpus Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__SCORPUS_RELATIONS = SaltCorePackage.SGRAPH_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>SCorpus Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH_FEATURE_COUNT = SaltCorePackage.SGRAPH_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.salt.impl.SDocumentImpl <em>SDocument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.salt.impl.SDocumentImpl
	 * @see de.corpling.salt.model.salt.impl.SaltPackageImpl#getSDocument()
	 * @generated
	 */
	int SDOCUMENT = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__NAME = SaltCorePackage.SELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__TYPE = SaltCorePackage.SELEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__ID = SaltCorePackage.SELEMENT__ID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__SELEMENT_PATH = SaltCorePackage.SELEMENT__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__LABELS = SaltCorePackage.SELEMENT__LABELS;

	/**
	 * The feature id for the '<em><b>Num Of Labels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__NUM_OF_LABELS = SaltCorePackage.SELEMENT__NUM_OF_LABELS;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__SANNOTATIONS = SaltCorePackage.SELEMENT__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SStereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__SSTEREOTYPE = SaltCorePackage.SELEMENT__SSTEREOTYPE;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__SFEATURES = SaltCorePackage.SELEMENT__SFEATURES;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__SPROCESSING_ANNOTATIONS = SaltCorePackage.SELEMENT__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__GRAPH = SaltCorePackage.SELEMENT__GRAPH;

	/**
	 * The feature id for the '<em><b>Labelable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__LABELABLE_ELEMENT = SaltCorePackage.SELEMENT__LABELABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SSterotypeable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__SSTEROTYPEABLE_ELEMENT = SaltCorePackage.SELEMENT__SSTEROTYPEABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SAnnotatable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__SANNOTATABLE_ELEMENT = SaltCorePackage.SELEMENT__SANNOTATABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SProcessing Annotatable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__SPROCESSING_ANNOTATABLE_ELEMENT = SaltCorePackage.SELEMENT__SPROCESSING_ANNOTATABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__SGRAPH = SaltCorePackage.SELEMENT__SGRAPH;

	/**
	 * The feature id for the '<em><b>SDocument Graph</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__SDOCUMENT_GRAPH = SaltCorePackage.SELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SCorpus Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__SCORPUS_GRAPH = SaltCorePackage.SELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>SDocument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_FEATURE_COUNT = SaltCorePackage.SELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.salt.impl.SCorpusRelationImpl <em>SCorpus Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.salt.impl.SCorpusRelationImpl
	 * @see de.corpling.salt.model.salt.impl.SaltPackageImpl#getSCorpusRelation()
	 * @generated
	 */
	int SCORPUS_RELATION = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__ID = SaltCorePackage.SRELATION__ID;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__LABELS = SaltCorePackage.SRELATION__LABELS;

	/**
	 * The feature id for the '<em><b>Num Of Labels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__NUM_OF_LABELS = SaltCorePackage.SRELATION__NUM_OF_LABELS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SOURCE = SaltCorePackage.SRELATION__SOURCE;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__DESTINATION = SaltCorePackage.SRELATION__DESTINATION;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__GRAPH = SaltCorePackage.SRELATION__GRAPH;

	/**
	 * The feature id for the '<em><b>Labelable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__LABELABLE_ELEMENT = SaltCorePackage.SRELATION__LABELABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__NAME = SaltCorePackage.SRELATION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__TYPE = SaltCorePackage.SRELATION__TYPE;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SELEMENT_PATH = SaltCorePackage.SRELATION__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SANNOTATIONS = SaltCorePackage.SRELATION__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SStereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SSTEREOTYPE = SaltCorePackage.SRELATION__SSTEREOTYPE;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SFEATURES = SaltCorePackage.SRELATION__SFEATURES;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SPROCESSING_ANNOTATIONS = SaltCorePackage.SRELATION__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SSource Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SSOURCE_ELEMENT = SaltCorePackage.SRELATION__SSOURCE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SDestination Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SDESTINATION_ELEMENT = SaltCorePackage.SRELATION__SDESTINATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>SStereotypable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SSTEREOTYPABLE_ELEMENT = SaltCorePackage.SRELATION__SSTEREOTYPABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SAnnotatable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SANNOTATABLE_ELEMENT = SaltCorePackage.SRELATION__SANNOTATABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SProcessing Annotatable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SPROCESSING_ANNOTATABLE_ELEMENT = SaltCorePackage.SRELATION__SPROCESSING_ANNOTATABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SGRAPH = SaltCorePackage.SRELATION__SGRAPH;

	/**
	 * The feature id for the '<em><b>SType</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__STYPE = SaltCorePackage.SRELATION__STYPE;

	/**
	 * The feature id for the '<em><b>SSuper Corpus</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SSUPER_CORPUS = SaltCorePackage.SRELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SSub Corpus</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SSUB_CORPUS = SaltCorePackage.SRELATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>SCorpus Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION_FEATURE_COUNT = SaltCorePackage.SRELATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.salt.impl.SCorpDocRelationImpl <em>SCorp Doc Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.salt.impl.SCorpDocRelationImpl
	 * @see de.corpling.salt.model.salt.impl.SaltPackageImpl#getSCorpDocRelation()
	 * @generated
	 */
	int SCORP_DOC_RELATION = 12;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORP_DOC_RELATION__ID = SaltCorePackage.SRELATION__ID;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORP_DOC_RELATION__LABELS = SaltCorePackage.SRELATION__LABELS;

	/**
	 * The feature id for the '<em><b>Num Of Labels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORP_DOC_RELATION__NUM_OF_LABELS = SaltCorePackage.SRELATION__NUM_OF_LABELS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORP_DOC_RELATION__SOURCE = SaltCorePackage.SRELATION__SOURCE;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORP_DOC_RELATION__DESTINATION = SaltCorePackage.SRELATION__DESTINATION;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORP_DOC_RELATION__GRAPH = SaltCorePackage.SRELATION__GRAPH;

	/**
	 * The feature id for the '<em><b>Labelable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORP_DOC_RELATION__LABELABLE_ELEMENT = SaltCorePackage.SRELATION__LABELABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORP_DOC_RELATION__NAME = SaltCorePackage.SRELATION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORP_DOC_RELATION__TYPE = SaltCorePackage.SRELATION__TYPE;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORP_DOC_RELATION__SELEMENT_PATH = SaltCorePackage.SRELATION__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORP_DOC_RELATION__SANNOTATIONS = SaltCorePackage.SRELATION__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SStereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORP_DOC_RELATION__SSTEREOTYPE = SaltCorePackage.SRELATION__SSTEREOTYPE;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORP_DOC_RELATION__SFEATURES = SaltCorePackage.SRELATION__SFEATURES;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORP_DOC_RELATION__SPROCESSING_ANNOTATIONS = SaltCorePackage.SRELATION__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SSource Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORP_DOC_RELATION__SSOURCE_ELEMENT = SaltCorePackage.SRELATION__SSOURCE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SDestination Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORP_DOC_RELATION__SDESTINATION_ELEMENT = SaltCorePackage.SRELATION__SDESTINATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>SStereotypable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORP_DOC_RELATION__SSTEREOTYPABLE_ELEMENT = SaltCorePackage.SRELATION__SSTEREOTYPABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SAnnotatable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORP_DOC_RELATION__SANNOTATABLE_ELEMENT = SaltCorePackage.SRELATION__SANNOTATABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SProcessing Annotatable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORP_DOC_RELATION__SPROCESSING_ANNOTATABLE_ELEMENT = SaltCorePackage.SRELATION__SPROCESSING_ANNOTATABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORP_DOC_RELATION__SGRAPH = SaltCorePackage.SRELATION__SGRAPH;

	/**
	 * The feature id for the '<em><b>SType</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORP_DOC_RELATION__STYPE = SaltCorePackage.SRELATION__STYPE;

	/**
	 * The feature id for the '<em><b>SCorpus</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORP_DOC_RELATION__SCORPUS = SaltCorePackage.SRELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SDocument</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORP_DOC_RELATION__SDOCUMENT = SaltCorePackage.SRELATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>SCorp Doc Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORP_DOC_RELATION_FEATURE_COUNT = SaltCorePackage.SRELATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.salt.impl.SDominanceRelationImpl <em>SDominance Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.salt.impl.SDominanceRelationImpl
	 * @see de.corpling.salt.model.salt.impl.SaltPackageImpl#getSDominanceRelation()
	 * @generated
	 */
	int SDOMINANCE_RELATION = 13;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__ID = SaltCorePackage.SRELATION__ID;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__LABELS = SaltCorePackage.SRELATION__LABELS;

	/**
	 * The feature id for the '<em><b>Num Of Labels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__NUM_OF_LABELS = SaltCorePackage.SRELATION__NUM_OF_LABELS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__SOURCE = SaltCorePackage.SRELATION__SOURCE;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__DESTINATION = SaltCorePackage.SRELATION__DESTINATION;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__GRAPH = SaltCorePackage.SRELATION__GRAPH;

	/**
	 * The feature id for the '<em><b>Labelable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__LABELABLE_ELEMENT = SaltCorePackage.SRELATION__LABELABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__NAME = SaltCorePackage.SRELATION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__TYPE = SaltCorePackage.SRELATION__TYPE;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__SELEMENT_PATH = SaltCorePackage.SRELATION__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__SANNOTATIONS = SaltCorePackage.SRELATION__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SStereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__SSTEREOTYPE = SaltCorePackage.SRELATION__SSTEREOTYPE;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__SFEATURES = SaltCorePackage.SRELATION__SFEATURES;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__SPROCESSING_ANNOTATIONS = SaltCorePackage.SRELATION__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SSource Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__SSOURCE_ELEMENT = SaltCorePackage.SRELATION__SSOURCE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SDestination Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__SDESTINATION_ELEMENT = SaltCorePackage.SRELATION__SDESTINATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>SStereotypable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__SSTEREOTYPABLE_ELEMENT = SaltCorePackage.SRELATION__SSTEREOTYPABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SAnnotatable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__SANNOTATABLE_ELEMENT = SaltCorePackage.SRELATION__SANNOTATABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SProcessing Annotatable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__SPROCESSING_ANNOTATABLE_ELEMENT = SaltCorePackage.SRELATION__SPROCESSING_ANNOTATABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__SGRAPH = SaltCorePackage.SRELATION__SGRAPH;

	/**
	 * The feature id for the '<em><b>SType</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__STYPE = SaltCorePackage.SRELATION__STYPE;

	/**
	 * The number of structural features of the '<em>SDominance Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION_FEATURE_COUNT = SaltCorePackage.SRELATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.salt.impl.SPointingRelationImpl <em>SPointing Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.salt.impl.SPointingRelationImpl
	 * @see de.corpling.salt.model.salt.impl.SaltPackageImpl#getSPointingRelation()
	 * @generated
	 */
	int SPOINTING_RELATION = 14;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__ID = SaltCorePackage.SRELATION__ID;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__LABELS = SaltCorePackage.SRELATION__LABELS;

	/**
	 * The feature id for the '<em><b>Num Of Labels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__NUM_OF_LABELS = SaltCorePackage.SRELATION__NUM_OF_LABELS;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__SOURCE = SaltCorePackage.SRELATION__SOURCE;

	/**
	 * The feature id for the '<em><b>Destination</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__DESTINATION = SaltCorePackage.SRELATION__DESTINATION;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__GRAPH = SaltCorePackage.SRELATION__GRAPH;

	/**
	 * The feature id for the '<em><b>Labelable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__LABELABLE_ELEMENT = SaltCorePackage.SRELATION__LABELABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__NAME = SaltCorePackage.SRELATION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__TYPE = SaltCorePackage.SRELATION__TYPE;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__SELEMENT_PATH = SaltCorePackage.SRELATION__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__SANNOTATIONS = SaltCorePackage.SRELATION__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SStereotype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__SSTEREOTYPE = SaltCorePackage.SRELATION__SSTEREOTYPE;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__SFEATURES = SaltCorePackage.SRELATION__SFEATURES;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__SPROCESSING_ANNOTATIONS = SaltCorePackage.SRELATION__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SSource Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__SSOURCE_ELEMENT = SaltCorePackage.SRELATION__SSOURCE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SDestination Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__SDESTINATION_ELEMENT = SaltCorePackage.SRELATION__SDESTINATION_ELEMENT;

	/**
	 * The feature id for the '<em><b>SStereotypable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__SSTEREOTYPABLE_ELEMENT = SaltCorePackage.SRELATION__SSTEREOTYPABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SAnnotatable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__SANNOTATABLE_ELEMENT = SaltCorePackage.SRELATION__SANNOTATABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SProcessing Annotatable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__SPROCESSING_ANNOTATABLE_ELEMENT = SaltCorePackage.SRELATION__SPROCESSING_ANNOTATABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__SGRAPH = SaltCorePackage.SRELATION__SGRAPH;

	/**
	 * The feature id for the '<em><b>SType</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__STYPE = SaltCorePackage.SRELATION__STYPE;

	/**
	 * The number of structural features of the '<em>SPointing Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION_FEATURE_COUNT = SaltCorePackage.SRELATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.corpling.salt.model.salt.SSTEREOTYPES <em>SSTEREOTYPES</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.model.salt.SSTEREOTYPES
	 * @see de.corpling.salt.model.salt.impl.SaltPackageImpl#getSSTEREOTYPES()
	 * @generated
	 */
	int SSTEREOTYPES = 15;

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.model.salt.SToken <em>SToken</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SToken</em>'.
	 * @see de.corpling.salt.model.salt.SToken
	 * @generated
	 */
	EClass getSToken();

	/**
	 * Returns the meta object for the attribute '{@link de.corpling.salt.model.salt.SToken#getSLeft <em>SLeft</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SLeft</em>'.
	 * @see de.corpling.salt.model.salt.SToken#getSLeft()
	 * @see #getSToken()
	 * @generated
	 */
	EAttribute getSToken_SLeft();

	/**
	 * Returns the meta object for the attribute '{@link de.corpling.salt.model.salt.SToken#getSRight <em>SRight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SRight</em>'.
	 * @see de.corpling.salt.model.salt.SToken#getSRight()
	 * @see #getSToken()
	 * @generated
	 */
	EAttribute getSToken_SRight();

	/**
	 * Returns the meta object for the container reference '{@link de.corpling.salt.model.salt.SToken#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SDocument Graph</em>'.
	 * @see de.corpling.salt.model.salt.SToken#getSDocumentGraph()
	 * @see #getSToken()
	 * @generated
	 */
	EReference getSToken_SDocumentGraph();

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.model.salt.SDataSource <em>SData Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SData Source</em>'.
	 * @see de.corpling.salt.model.salt.SDataSource
	 * @generated
	 */
	EClass getSDataSource();

	/**
	 * Returns the meta object for the attribute '{@link de.corpling.salt.model.salt.SDataSource#getSDataSource <em>SData Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SData Source</em>'.
	 * @see de.corpling.salt.model.salt.SDataSource#getSDataSource()
	 * @see #getSDataSource()
	 * @generated
	 */
	EAttribute getSDataSource_SDataSource();

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.model.salt.STextualDataSource <em>STextual Data Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>STextual Data Source</em>'.
	 * @see de.corpling.salt.model.salt.STextualDataSource
	 * @generated
	 */
	EClass getSTextualDataSource();

	/**
	 * Returns the meta object for the attribute '{@link de.corpling.salt.model.salt.STextualDataSource#getSText <em>SText</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SText</em>'.
	 * @see de.corpling.salt.model.salt.STextualDataSource#getSText()
	 * @see #getSTextualDataSource()
	 * @generated
	 */
	EAttribute getSTextualDataSource_SText();

	/**
	 * Returns the meta object for the container reference '{@link de.corpling.salt.model.salt.STextualDataSource#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SDocument Graph</em>'.
	 * @see de.corpling.salt.model.salt.STextualDataSource#getSDocumentGraph()
	 * @see #getSTextualDataSource()
	 * @generated
	 */
	EReference getSTextualDataSource_SDocumentGraph();

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.model.salt.SDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SDocument Graph</em>'.
	 * @see de.corpling.salt.model.salt.SDocumentGraph
	 * @generated
	 */
	EClass getSDocumentGraph();

	/**
	 * Returns the meta object for the containment reference list '{@link de.corpling.salt.model.salt.SDocumentGraph#getSTokens <em>STokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>STokens</em>'.
	 * @see de.corpling.salt.model.salt.SDocumentGraph#getSTokens()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_STokens();

	/**
	 * Returns the meta object for the containment reference list '{@link de.corpling.salt.model.salt.SDocumentGraph#getSTextualRelations <em>STextual Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>STextual Relations</em>'.
	 * @see de.corpling.salt.model.salt.SDocumentGraph#getSTextualRelations()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_STextualRelations();

	/**
	 * Returns the meta object for the containment reference list '{@link de.corpling.salt.model.salt.SDocumentGraph#getSTextualDataSources <em>STextual Data Sources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>STextual Data Sources</em>'.
	 * @see de.corpling.salt.model.salt.SDocumentGraph#getSTextualDataSources()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_STextualDataSources();

	/**
	 * Returns the meta object for the containment reference list '{@link de.corpling.salt.model.salt.SDocumentGraph#getSStructures <em>SStructures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SStructures</em>'.
	 * @see de.corpling.salt.model.salt.SDocumentGraph#getSStructures()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_SStructures();

	/**
	 * Returns the meta object for the containment reference list '{@link de.corpling.salt.model.salt.SDocumentGraph#getSpanRelations <em>Span Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Span Relations</em>'.
	 * @see de.corpling.salt.model.salt.SDocumentGraph#getSpanRelations()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_SpanRelations();

	/**
	 * Returns the meta object for the container reference '{@link de.corpling.salt.model.salt.SDocumentGraph#getSDocument <em>SDocument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SDocument</em>'.
	 * @see de.corpling.salt.model.salt.SDocumentGraph#getSDocument()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_SDocument();

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.model.salt.STextualRelation <em>STextual Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>STextual Relation</em>'.
	 * @see de.corpling.salt.model.salt.STextualRelation
	 * @generated
	 */
	EClass getSTextualRelation();

	/**
	 * Returns the meta object for the reference '{@link de.corpling.salt.model.salt.STextualRelation#getSToken <em>SToken</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SToken</em>'.
	 * @see de.corpling.salt.model.salt.STextualRelation#getSToken()
	 * @see #getSTextualRelation()
	 * @generated
	 */
	EReference getSTextualRelation_SToken();

	/**
	 * Returns the meta object for the reference '{@link de.corpling.salt.model.salt.STextualRelation#getSTextualDataSource <em>STextual Data Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>STextual Data Source</em>'.
	 * @see de.corpling.salt.model.salt.STextualRelation#getSTextualDataSource()
	 * @see #getSTextualRelation()
	 * @generated
	 */
	EReference getSTextualRelation_STextualDataSource();

	/**
	 * Returns the meta object for the attribute '{@link de.corpling.salt.model.salt.STextualRelation#getSLeftPos <em>SLeft Pos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SLeft Pos</em>'.
	 * @see de.corpling.salt.model.salt.STextualRelation#getSLeftPos()
	 * @see #getSTextualRelation()
	 * @generated
	 */
	EAttribute getSTextualRelation_SLeftPos();

	/**
	 * Returns the meta object for the attribute '{@link de.corpling.salt.model.salt.STextualRelation#getSRightPos <em>SRight Pos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SRight Pos</em>'.
	 * @see de.corpling.salt.model.salt.STextualRelation#getSRightPos()
	 * @see #getSTextualRelation()
	 * @generated
	 */
	EAttribute getSTextualRelation_SRightPos();

	/**
	 * Returns the meta object for the container reference '{@link de.corpling.salt.model.salt.STextualRelation#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SDocument Graph</em>'.
	 * @see de.corpling.salt.model.salt.STextualRelation#getSDocumentGraph()
	 * @see #getSTextualRelation()
	 * @generated
	 */
	EReference getSTextualRelation_SDocumentGraph();

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.model.salt.SStructure <em>SStructure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SStructure</em>'.
	 * @see de.corpling.salt.model.salt.SStructure
	 * @generated
	 */
	EClass getSStructure();

	/**
	 * Returns the meta object for the container reference '{@link de.corpling.salt.model.salt.SStructure#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SDocument Graph</em>'.
	 * @see de.corpling.salt.model.salt.SStructure#getSDocumentGraph()
	 * @see #getSStructure()
	 * @generated
	 */
	EReference getSStructure_SDocumentGraph();

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.model.salt.SSpanRelation <em>SSpan Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SSpan Relation</em>'.
	 * @see de.corpling.salt.model.salt.SSpanRelation
	 * @generated
	 */
	EClass getSSpanRelation();

	/**
	 * Returns the meta object for the container reference '{@link de.corpling.salt.model.salt.SSpanRelation#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SDocument Graph</em>'.
	 * @see de.corpling.salt.model.salt.SSpanRelation#getSDocumentGraph()
	 * @see #getSSpanRelation()
	 * @generated
	 */
	EReference getSSpanRelation_SDocumentGraph();

	/**
	 * Returns the meta object for the reference '{@link de.corpling.salt.model.salt.SSpanRelation#getSStructure <em>SStructure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SStructure</em>'.
	 * @see de.corpling.salt.model.salt.SSpanRelation#getSStructure()
	 * @see #getSSpanRelation()
	 * @generated
	 */
	EReference getSSpanRelation_SStructure();

	/**
	 * Returns the meta object for the reference '{@link de.corpling.salt.model.salt.SSpanRelation#getSToken <em>SToken</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SToken</em>'.
	 * @see de.corpling.salt.model.salt.SSpanRelation#getSToken()
	 * @see #getSSpanRelation()
	 * @generated
	 */
	EReference getSSpanRelation_SToken();

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.model.salt.SProject <em>SProject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SProject</em>'.
	 * @see de.corpling.salt.model.salt.SProject
	 * @generated
	 */
	EClass getSProject();

	/**
	 * Returns the meta object for the containment reference list '{@link de.corpling.salt.model.salt.SProject#getSCorpusGraphs <em>SCorpus Graphs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SCorpus Graphs</em>'.
	 * @see de.corpling.salt.model.salt.SProject#getSCorpusGraphs()
	 * @see #getSProject()
	 * @generated
	 */
	EReference getSProject_SCorpusGraphs();

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.model.salt.SCorpus <em>SCorpus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCorpus</em>'.
	 * @see de.corpling.salt.model.salt.SCorpus
	 * @generated
	 */
	EClass getSCorpus();

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.model.salt.SCorpusGraph <em>SCorpus Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCorpus Graph</em>'.
	 * @see de.corpling.salt.model.salt.SCorpusGraph
	 * @generated
	 */
	EClass getSCorpusGraph();

	/**
	 * Returns the meta object for the containment reference list '{@link de.corpling.salt.model.salt.SCorpusGraph#getSCorpora <em>SCorpora</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SCorpora</em>'.
	 * @see de.corpling.salt.model.salt.SCorpusGraph#getSCorpora()
	 * @see #getSCorpusGraph()
	 * @generated
	 */
	EReference getSCorpusGraph_SCorpora();

	/**
	 * Returns the meta object for the containment reference list '{@link de.corpling.salt.model.salt.SCorpusGraph#getSDocuments <em>SDocuments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SDocuments</em>'.
	 * @see de.corpling.salt.model.salt.SCorpusGraph#getSDocuments()
	 * @see #getSCorpusGraph()
	 * @generated
	 */
	EReference getSCorpusGraph_SDocuments();

	/**
	 * Returns the meta object for the containment reference list '{@link de.corpling.salt.model.salt.SCorpusGraph#getSCorpusRelations <em>SCorpus Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SCorpus Relations</em>'.
	 * @see de.corpling.salt.model.salt.SCorpusGraph#getSCorpusRelations()
	 * @see #getSCorpusGraph()
	 * @generated
	 */
	EReference getSCorpusGraph_SCorpusRelations();

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.model.salt.SDocument <em>SDocument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SDocument</em>'.
	 * @see de.corpling.salt.model.salt.SDocument
	 * @generated
	 */
	EClass getSDocument();

	/**
	 * Returns the meta object for the containment reference '{@link de.corpling.salt.model.salt.SDocument#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>SDocument Graph</em>'.
	 * @see de.corpling.salt.model.salt.SDocument#getSDocumentGraph()
	 * @see #getSDocument()
	 * @generated
	 */
	EReference getSDocument_SDocumentGraph();

	/**
	 * Returns the meta object for the container reference '{@link de.corpling.salt.model.salt.SDocument#getSCorpusGraph <em>SCorpus Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SCorpus Graph</em>'.
	 * @see de.corpling.salt.model.salt.SDocument#getSCorpusGraph()
	 * @see #getSDocument()
	 * @generated
	 */
	EReference getSDocument_SCorpusGraph();

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.model.salt.SCorpusRelation <em>SCorpus Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCorpus Relation</em>'.
	 * @see de.corpling.salt.model.salt.SCorpusRelation
	 * @generated
	 */
	EClass getSCorpusRelation();

	/**
	 * Returns the meta object for the reference '{@link de.corpling.salt.model.salt.SCorpusRelation#getSSuperCorpus <em>SSuper Corpus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SSuper Corpus</em>'.
	 * @see de.corpling.salt.model.salt.SCorpusRelation#getSSuperCorpus()
	 * @see #getSCorpusRelation()
	 * @generated
	 */
	EReference getSCorpusRelation_SSuperCorpus();

	/**
	 * Returns the meta object for the reference '{@link de.corpling.salt.model.salt.SCorpusRelation#getSSubCorpus <em>SSub Corpus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SSub Corpus</em>'.
	 * @see de.corpling.salt.model.salt.SCorpusRelation#getSSubCorpus()
	 * @see #getSCorpusRelation()
	 * @generated
	 */
	EReference getSCorpusRelation_SSubCorpus();

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.model.salt.SCorpDocRelation <em>SCorp Doc Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCorp Doc Relation</em>'.
	 * @see de.corpling.salt.model.salt.SCorpDocRelation
	 * @generated
	 */
	EClass getSCorpDocRelation();

	/**
	 * Returns the meta object for the reference '{@link de.corpling.salt.model.salt.SCorpDocRelation#getSCorpus <em>SCorpus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SCorpus</em>'.
	 * @see de.corpling.salt.model.salt.SCorpDocRelation#getSCorpus()
	 * @see #getSCorpDocRelation()
	 * @generated
	 */
	EReference getSCorpDocRelation_SCorpus();

	/**
	 * Returns the meta object for the reference '{@link de.corpling.salt.model.salt.SCorpDocRelation#getSDocument <em>SDocument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SDocument</em>'.
	 * @see de.corpling.salt.model.salt.SCorpDocRelation#getSDocument()
	 * @see #getSCorpDocRelation()
	 * @generated
	 */
	EReference getSCorpDocRelation_SDocument();

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.model.salt.SDominanceRelation <em>SDominance Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SDominance Relation</em>'.
	 * @see de.corpling.salt.model.salt.SDominanceRelation
	 * @generated
	 */
	EClass getSDominanceRelation();

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.model.salt.SPointingRelation <em>SPointing Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SPointing Relation</em>'.
	 * @see de.corpling.salt.model.salt.SPointingRelation
	 * @generated
	 */
	EClass getSPointingRelation();

	/**
	 * Returns the meta object for enum '{@link de.corpling.salt.model.salt.SSTEREOTYPES <em>SSTEREOTYPES</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>SSTEREOTYPES</em>'.
	 * @see de.corpling.salt.model.salt.SSTEREOTYPES
	 * @generated
	 */
	EEnum getSSTEREOTYPES();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SaltFactory getSaltFactory();

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
		 * The meta object literal for the '{@link de.corpling.salt.model.salt.impl.STokenImpl <em>SToken</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.salt.impl.STokenImpl
		 * @see de.corpling.salt.model.salt.impl.SaltPackageImpl#getSToken()
		 * @generated
		 */
		EClass STOKEN = eINSTANCE.getSToken();
		/**
		 * The meta object literal for the '<em><b>SLeft</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STOKEN__SLEFT = eINSTANCE.getSToken_SLeft();
		/**
		 * The meta object literal for the '<em><b>SRight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STOKEN__SRIGHT = eINSTANCE.getSToken_SRight();
		/**
		 * The meta object literal for the '<em><b>SDocument Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STOKEN__SDOCUMENT_GRAPH = eINSTANCE.getSToken_SDocumentGraph();
		/**
		 * The meta object literal for the '{@link de.corpling.salt.model.salt.impl.SDataSourceImpl <em>SData Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.salt.impl.SDataSourceImpl
		 * @see de.corpling.salt.model.salt.impl.SaltPackageImpl#getSDataSource()
		 * @generated
		 */
		EClass SDATA_SOURCE = eINSTANCE.getSDataSource();
		/**
		 * The meta object literal for the '<em><b>SData Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SDATA_SOURCE__SDATA_SOURCE = eINSTANCE.getSDataSource_SDataSource();
		/**
		 * The meta object literal for the '{@link de.corpling.salt.model.salt.impl.STextualDataSourceImpl <em>STextual Data Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.salt.impl.STextualDataSourceImpl
		 * @see de.corpling.salt.model.salt.impl.SaltPackageImpl#getSTextualDataSource()
		 * @generated
		 */
		EClass STEXTUAL_DATA_SOURCE = eINSTANCE.getSTextualDataSource();
		/**
		 * The meta object literal for the '<em><b>SText</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEXTUAL_DATA_SOURCE__STEXT = eINSTANCE.getSTextualDataSource_SText();
		/**
		 * The meta object literal for the '<em><b>SDocument Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEXTUAL_DATA_SOURCE__SDOCUMENT_GRAPH = eINSTANCE.getSTextualDataSource_SDocumentGraph();
		/**
		 * The meta object literal for the '{@link de.corpling.salt.model.salt.impl.SDocumentGraphImpl <em>SDocument Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.salt.impl.SDocumentGraphImpl
		 * @see de.corpling.salt.model.salt.impl.SaltPackageImpl#getSDocumentGraph()
		 * @generated
		 */
		EClass SDOCUMENT_GRAPH = eINSTANCE.getSDocumentGraph();
		/**
		 * The meta object literal for the '<em><b>STokens</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOCUMENT_GRAPH__STOKENS = eINSTANCE.getSDocumentGraph_STokens();
		/**
		 * The meta object literal for the '<em><b>STextual Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOCUMENT_GRAPH__STEXTUAL_RELATIONS = eINSTANCE.getSDocumentGraph_STextualRelations();
		/**
		 * The meta object literal for the '<em><b>STextual Data Sources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOCUMENT_GRAPH__STEXTUAL_DATA_SOURCES = eINSTANCE.getSDocumentGraph_STextualDataSources();
		/**
		 * The meta object literal for the '<em><b>SStructures</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOCUMENT_GRAPH__SSTRUCTURES = eINSTANCE.getSDocumentGraph_SStructures();
		/**
		 * The meta object literal for the '<em><b>Span Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOCUMENT_GRAPH__SPAN_RELATIONS = eINSTANCE.getSDocumentGraph_SpanRelations();
		/**
		 * The meta object literal for the '<em><b>SDocument</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOCUMENT_GRAPH__SDOCUMENT = eINSTANCE.getSDocumentGraph_SDocument();
		/**
		 * The meta object literal for the '{@link de.corpling.salt.model.salt.impl.STextualRelationImpl <em>STextual Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.salt.impl.STextualRelationImpl
		 * @see de.corpling.salt.model.salt.impl.SaltPackageImpl#getSTextualRelation()
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
		 * The meta object literal for the '<em><b>STextual Data Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEXTUAL_RELATION__STEXTUAL_DATA_SOURCE = eINSTANCE.getSTextualRelation_STextualDataSource();
		/**
		 * The meta object literal for the '<em><b>SLeft Pos</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEXTUAL_RELATION__SLEFT_POS = eINSTANCE.getSTextualRelation_SLeftPos();
		/**
		 * The meta object literal for the '<em><b>SRight Pos</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEXTUAL_RELATION__SRIGHT_POS = eINSTANCE.getSTextualRelation_SRightPos();
		/**
		 * The meta object literal for the '<em><b>SDocument Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STEXTUAL_RELATION__SDOCUMENT_GRAPH = eINSTANCE.getSTextualRelation_SDocumentGraph();
		/**
		 * The meta object literal for the '{@link de.corpling.salt.model.salt.impl.SStructureImpl <em>SStructure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.salt.impl.SStructureImpl
		 * @see de.corpling.salt.model.salt.impl.SaltPackageImpl#getSStructure()
		 * @generated
		 */
		EClass SSTRUCTURE = eINSTANCE.getSStructure();
		/**
		 * The meta object literal for the '<em><b>SDocument Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SSTRUCTURE__SDOCUMENT_GRAPH = eINSTANCE.getSStructure_SDocumentGraph();
		/**
		 * The meta object literal for the '{@link de.corpling.salt.model.salt.impl.SSpanRelationImpl <em>SSpan Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.salt.impl.SSpanRelationImpl
		 * @see de.corpling.salt.model.salt.impl.SaltPackageImpl#getSSpanRelation()
		 * @generated
		 */
		EClass SSPAN_RELATION = eINSTANCE.getSSpanRelation();
		/**
		 * The meta object literal for the '<em><b>SDocument Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SSPAN_RELATION__SDOCUMENT_GRAPH = eINSTANCE.getSSpanRelation_SDocumentGraph();
		/**
		 * The meta object literal for the '<em><b>SStructure</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SSPAN_RELATION__SSTRUCTURE = eINSTANCE.getSSpanRelation_SStructure();
		/**
		 * The meta object literal for the '<em><b>SToken</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SSPAN_RELATION__STOKEN = eINSTANCE.getSSpanRelation_SToken();
		/**
		 * The meta object literal for the '{@link de.corpling.salt.model.salt.impl.SProjectImpl <em>SProject</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.salt.impl.SProjectImpl
		 * @see de.corpling.salt.model.salt.impl.SaltPackageImpl#getSProject()
		 * @generated
		 */
		EClass SPROJECT = eINSTANCE.getSProject();
		/**
		 * The meta object literal for the '<em><b>SCorpus Graphs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPROJECT__SCORPUS_GRAPHS = eINSTANCE.getSProject_SCorpusGraphs();
		/**
		 * The meta object literal for the '{@link de.corpling.salt.model.salt.impl.SCorpusImpl <em>SCorpus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.salt.impl.SCorpusImpl
		 * @see de.corpling.salt.model.salt.impl.SaltPackageImpl#getSCorpus()
		 * @generated
		 */
		EClass SCORPUS = eINSTANCE.getSCorpus();
		/**
		 * The meta object literal for the '{@link de.corpling.salt.model.salt.impl.SCorpusGraphImpl <em>SCorpus Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.salt.impl.SCorpusGraphImpl
		 * @see de.corpling.salt.model.salt.impl.SaltPackageImpl#getSCorpusGraph()
		 * @generated
		 */
		EClass SCORPUS_GRAPH = eINSTANCE.getSCorpusGraph();
		/**
		 * The meta object literal for the '<em><b>SCorpora</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORPUS_GRAPH__SCORPORA = eINSTANCE.getSCorpusGraph_SCorpora();
		/**
		 * The meta object literal for the '<em><b>SDocuments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORPUS_GRAPH__SDOCUMENTS = eINSTANCE.getSCorpusGraph_SDocuments();
		/**
		 * The meta object literal for the '<em><b>SCorpus Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORPUS_GRAPH__SCORPUS_RELATIONS = eINSTANCE.getSCorpusGraph_SCorpusRelations();
		/**
		 * The meta object literal for the '{@link de.corpling.salt.model.salt.impl.SDocumentImpl <em>SDocument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.salt.impl.SDocumentImpl
		 * @see de.corpling.salt.model.salt.impl.SaltPackageImpl#getSDocument()
		 * @generated
		 */
		EClass SDOCUMENT = eINSTANCE.getSDocument();
		/**
		 * The meta object literal for the '<em><b>SDocument Graph</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOCUMENT__SDOCUMENT_GRAPH = eINSTANCE.getSDocument_SDocumentGraph();
		/**
		 * The meta object literal for the '<em><b>SCorpus Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOCUMENT__SCORPUS_GRAPH = eINSTANCE.getSDocument_SCorpusGraph();
		/**
		 * The meta object literal for the '{@link de.corpling.salt.model.salt.impl.SCorpusRelationImpl <em>SCorpus Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.salt.impl.SCorpusRelationImpl
		 * @see de.corpling.salt.model.salt.impl.SaltPackageImpl#getSCorpusRelation()
		 * @generated
		 */
		EClass SCORPUS_RELATION = eINSTANCE.getSCorpusRelation();
		/**
		 * The meta object literal for the '<em><b>SSuper Corpus</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORPUS_RELATION__SSUPER_CORPUS = eINSTANCE.getSCorpusRelation_SSuperCorpus();
		/**
		 * The meta object literal for the '<em><b>SSub Corpus</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORPUS_RELATION__SSUB_CORPUS = eINSTANCE.getSCorpusRelation_SSubCorpus();
		/**
		 * The meta object literal for the '{@link de.corpling.salt.model.salt.impl.SCorpDocRelationImpl <em>SCorp Doc Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.salt.impl.SCorpDocRelationImpl
		 * @see de.corpling.salt.model.salt.impl.SaltPackageImpl#getSCorpDocRelation()
		 * @generated
		 */
		EClass SCORP_DOC_RELATION = eINSTANCE.getSCorpDocRelation();
		/**
		 * The meta object literal for the '<em><b>SCorpus</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORP_DOC_RELATION__SCORPUS = eINSTANCE.getSCorpDocRelation_SCorpus();
		/**
		 * The meta object literal for the '<em><b>SDocument</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORP_DOC_RELATION__SDOCUMENT = eINSTANCE.getSCorpDocRelation_SDocument();
		/**
		 * The meta object literal for the '{@link de.corpling.salt.model.salt.impl.SDominanceRelationImpl <em>SDominance Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.salt.impl.SDominanceRelationImpl
		 * @see de.corpling.salt.model.salt.impl.SaltPackageImpl#getSDominanceRelation()
		 * @generated
		 */
		EClass SDOMINANCE_RELATION = eINSTANCE.getSDominanceRelation();
		/**
		 * The meta object literal for the '{@link de.corpling.salt.model.salt.impl.SPointingRelationImpl <em>SPointing Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.salt.impl.SPointingRelationImpl
		 * @see de.corpling.salt.model.salt.impl.SaltPackageImpl#getSPointingRelation()
		 * @generated
		 */
		EClass SPOINTING_RELATION = eINSTANCE.getSPointingRelation();
		/**
		 * The meta object literal for the '{@link de.corpling.salt.model.salt.SSTEREOTYPES <em>SSTEREOTYPES</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.model.salt.SSTEREOTYPES
		 * @see de.corpling.salt.model.salt.impl.SaltPackageImpl#getSSTEREOTYPES()
		 * @generated
		 */
		EEnum SSTEREOTYPES = eINSTANCE.getSSTEREOTYPES();

	}

} //SaltConcretePackage
