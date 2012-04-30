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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage;

import org.eclipse.emf.ecore.EClass;
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
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusStructureFactory
 * @model kind="package"
 * @generated
 */
public interface SCorpusStructurePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sCorpusStructure";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "sCorpusStructure";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sCorpusStructure";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SCorpusStructurePackage eINSTANCE = de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusStructurePackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusGraphImpl <em>SCorpus Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusGraphImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusStructurePackageImpl#getSCorpusGraph()
	 * @generated
	 */
	int SCORPUS_GRAPH = 0;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__LABELS = SaltCorePackage.SGRAPH__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__ID = SaltCorePackage.SGRAPH__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__IDENTIFIER = SaltCorePackage.SGRAPH__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Index Mgr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__INDEX_MGR = SaltCorePackage.SGRAPH__INDEX_MGR;

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
	 * The feature id for the '<em><b>Layers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__LAYERS = SaltCorePackage.SGRAPH__LAYERS;

	/**
	 * The feature id for the '<em><b>Num Of Layers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__NUM_OF_LAYERS = SaltCorePackage.SGRAPH__NUM_OF_LAYERS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__SFEATURES = SaltCorePackage.SGRAPH__SFEATURES;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__SNAME = SaltCorePackage.SGRAPH__SNAME;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__SANNOTATIONS = SaltCorePackage.SGRAPH__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__SELEMENT_ID = SaltCorePackage.SGRAPH__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__SID = SaltCorePackage.SGRAPH__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__SELEMENT_PATH = SaltCorePackage.SGRAPH__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__SPROCESSING_ANNOTATIONS = SaltCorePackage.SGRAPH__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SMeta Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__SMETA_ANNOTATIONS = SaltCorePackage.SGRAPH__SMETA_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SRelations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__SRELATIONS = SaltCorePackage.SGRAPH__SRELATIONS;

	/**
	 * The feature id for the '<em><b>SNodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__SNODES = SaltCorePackage.SGRAPH__SNODES;

	/**
	 * The feature id for the '<em><b>SLayers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__SLAYERS = SaltCorePackage.SGRAPH__SLAYERS;

	/**
	 * The feature id for the '<em><b>SDocuments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__SDOCUMENTS = SaltCorePackage.SGRAPH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Salt Project</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__SALT_PROJECT = SaltCorePackage.SGRAPH_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SCorpora</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__SCORPORA = SaltCorePackage.SGRAPH_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>SCorpus Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__SCORPUS_RELATIONS = SaltCorePackage.SGRAPH_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>SCorpus Document Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH__SCORPUS_DOCUMENT_RELATIONS = SaltCorePackage.SGRAPH_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>SCorpus Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_GRAPH_FEATURE_COUNT = SaltCorePackage.SGRAPH_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SDocumentImpl <em>SDocument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SDocumentImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusStructurePackageImpl#getSDocument()
	 * @generated
	 */
	int SDOCUMENT = 1;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__LABELS = SaltCorePackage.SNODE__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__ID = SaltCorePackage.SNODE__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__IDENTIFIER = SaltCorePackage.SNODE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__GRAPH = SaltCorePackage.SNODE__GRAPH;

	/**
	 * The feature id for the '<em><b>Layers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__LAYERS = SaltCorePackage.SNODE__LAYERS;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__SANNOTATIONS = SaltCorePackage.SNODE__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__SFEATURES = SaltCorePackage.SNODE__SFEATURES;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__SNAME = SaltCorePackage.SNODE__SNAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__SELEMENT_ID = SaltCorePackage.SNODE__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__SID = SaltCorePackage.SNODE__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__SELEMENT_PATH = SaltCorePackage.SNODE__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__SPROCESSING_ANNOTATIONS = SaltCorePackage.SNODE__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SMeta Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__SMETA_ANNOTATIONS = SaltCorePackage.SNODE__SMETA_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__SGRAPH = SaltCorePackage.SNODE__SGRAPH;

	/**
	 * The feature id for the '<em><b>SLayers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__SLAYERS = SaltCorePackage.SNODE__SLAYERS;

	/**
	 * The feature id for the '<em><b>SCorpus Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__SCORPUS_GRAPH = SaltCorePackage.SNODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SDocument Graph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT__SDOCUMENT_GRAPH = SaltCorePackage.SNODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>SDocument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_FEATURE_COUNT = SaltCorePackage.SNODE_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusImpl <em>SCorpus</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusStructurePackageImpl#getSCorpus()
	 * @generated
	 */
	int SCORPUS = 2;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__LABELS = SaltCorePackage.SNODE__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__ID = SaltCorePackage.SNODE__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__IDENTIFIER = SaltCorePackage.SNODE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__GRAPH = SaltCorePackage.SNODE__GRAPH;

	/**
	 * The feature id for the '<em><b>Layers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__LAYERS = SaltCorePackage.SNODE__LAYERS;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__SANNOTATIONS = SaltCorePackage.SNODE__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__SFEATURES = SaltCorePackage.SNODE__SFEATURES;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__SNAME = SaltCorePackage.SNODE__SNAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__SELEMENT_ID = SaltCorePackage.SNODE__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__SID = SaltCorePackage.SNODE__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__SELEMENT_PATH = SaltCorePackage.SNODE__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__SPROCESSING_ANNOTATIONS = SaltCorePackage.SNODE__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SMeta Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__SMETA_ANNOTATIONS = SaltCorePackage.SNODE__SMETA_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__SGRAPH = SaltCorePackage.SNODE__SGRAPH;

	/**
	 * The feature id for the '<em><b>SLayers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__SLAYERS = SaltCorePackage.SNODE__SLAYERS;

	/**
	 * The feature id for the '<em><b>SCorpus Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS__SCORPUS_GRAPH = SaltCorePackage.SNODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SCorpus</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_FEATURE_COUNT = SaltCorePackage.SNODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusRelationImpl <em>SCorpus Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusRelationImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusStructurePackageImpl#getSCorpusRelation()
	 * @generated
	 */
	int SCORPUS_RELATION = 3;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__LABELS = SaltCorePackage.SRELATION__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__ID = SaltCorePackage.SRELATION__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__IDENTIFIER = SaltCorePackage.SRELATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__GRAPH = SaltCorePackage.SRELATION__GRAPH;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SOURCE = SaltCorePackage.SRELATION__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__TARGET = SaltCorePackage.SRELATION__TARGET;

	/**
	 * The feature id for the '<em><b>Layers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__LAYERS = SaltCorePackage.SRELATION__LAYERS;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SANNOTATIONS = SaltCorePackage.SRELATION__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SFEATURES = SaltCorePackage.SRELATION__SFEATURES;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SNAME = SaltCorePackage.SRELATION__SNAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SELEMENT_ID = SaltCorePackage.SRELATION__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SID = SaltCorePackage.SRELATION__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SELEMENT_PATH = SaltCorePackage.SRELATION__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SPROCESSING_ANNOTATIONS = SaltCorePackage.SRELATION__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SMeta Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SMETA_ANNOTATIONS = SaltCorePackage.SRELATION__SMETA_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SSource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SSOURCE = SaltCorePackage.SRELATION__SSOURCE;

	/**
	 * The feature id for the '<em><b>STarget</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__STARGET = SaltCorePackage.SRELATION__STARGET;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SGRAPH = SaltCorePackage.SRELATION__SGRAPH;

	/**
	 * The feature id for the '<em><b>STypes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__STYPES = SaltCorePackage.SRELATION__STYPES;

	/**
	 * The feature id for the '<em><b>SLayers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SLAYERS = SaltCorePackage.SRELATION__SLAYERS;

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
	 * The feature id for the '<em><b>SCorpus Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION__SCORPUS_GRAPH = SaltCorePackage.SRELATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>SCorpus Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_RELATION_FEATURE_COUNT = SaltCorePackage.SRELATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusDocumentRelationImpl <em>SCorpus Document Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusDocumentRelationImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusStructurePackageImpl#getSCorpusDocumentRelation()
	 * @generated
	 */
	int SCORPUS_DOCUMENT_RELATION = 4;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION__LABELS = SaltCorePackage.SRELATION__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION__ID = SaltCorePackage.SRELATION__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION__IDENTIFIER = SaltCorePackage.SRELATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION__GRAPH = SaltCorePackage.SRELATION__GRAPH;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION__SOURCE = SaltCorePackage.SRELATION__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION__TARGET = SaltCorePackage.SRELATION__TARGET;

	/**
	 * The feature id for the '<em><b>Layers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION__LAYERS = SaltCorePackage.SRELATION__LAYERS;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION__SANNOTATIONS = SaltCorePackage.SRELATION__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION__SFEATURES = SaltCorePackage.SRELATION__SFEATURES;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION__SNAME = SaltCorePackage.SRELATION__SNAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION__SELEMENT_ID = SaltCorePackage.SRELATION__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION__SID = SaltCorePackage.SRELATION__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION__SELEMENT_PATH = SaltCorePackage.SRELATION__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION__SPROCESSING_ANNOTATIONS = SaltCorePackage.SRELATION__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SMeta Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION__SMETA_ANNOTATIONS = SaltCorePackage.SRELATION__SMETA_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SSource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION__SSOURCE = SaltCorePackage.SRELATION__SSOURCE;

	/**
	 * The feature id for the '<em><b>STarget</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION__STARGET = SaltCorePackage.SRELATION__STARGET;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION__SGRAPH = SaltCorePackage.SRELATION__SGRAPH;

	/**
	 * The feature id for the '<em><b>STypes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION__STYPES = SaltCorePackage.SRELATION__STYPES;

	/**
	 * The feature id for the '<em><b>SLayers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION__SLAYERS = SaltCorePackage.SRELATION__SLAYERS;

	/**
	 * The feature id for the '<em><b>SCorpus</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION__SCORPUS = SaltCorePackage.SRELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SDocument</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION__SDOCUMENT = SaltCorePackage.SRELATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SCorpus Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION__SCORPUS_GRAPH = SaltCorePackage.SRELATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>SCorpus Document Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCORPUS_DOCUMENT_RELATION_FEATURE_COUNT = SaltCorePackage.SRELATION_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph <em>SCorpus Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCorpus Graph</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph
	 * @generated
	 */
	EClass getSCorpusGraph();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSDocuments <em>SDocuments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SDocuments</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSDocuments()
	 * @see #getSCorpusGraph()
	 * @generated
	 */
	EReference getSCorpusGraph_SDocuments();

	/**
	 * Returns the meta object for the container reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSaltProject <em>Salt Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Salt Project</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSaltProject()
	 * @see #getSCorpusGraph()
	 * @generated
	 */
	EReference getSCorpusGraph_SaltProject();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpora <em>SCorpora</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SCorpora</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpora()
	 * @see #getSCorpusGraph()
	 * @generated
	 */
	EReference getSCorpusGraph_SCorpora();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpusRelations <em>SCorpus Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SCorpus Relations</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpusRelations()
	 * @see #getSCorpusGraph()
	 * @generated
	 */
	EReference getSCorpusGraph_SCorpusRelations();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpusDocumentRelations <em>SCorpus Document Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SCorpus Document Relations</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph#getSCorpusDocumentRelations()
	 * @see #getSCorpusGraph()
	 * @generated
	 */
	EReference getSCorpusGraph_SCorpusDocumentRelations();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument <em>SDocument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SDocument</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument
	 * @generated
	 */
	EClass getSDocument();

	/**
	 * Returns the meta object for the container reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument#getSCorpusGraph <em>SCorpus Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SCorpus Graph</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument#getSCorpusGraph()
	 * @see #getSDocument()
	 * @generated
	 */
	EReference getSDocument_SCorpusGraph();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SDocument Graph</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument#getSDocumentGraph()
	 * @see #getSDocument()
	 * @generated
	 */
	EReference getSDocument_SDocumentGraph();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus <em>SCorpus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCorpus</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus
	 * @generated
	 */
	EClass getSCorpus();

	/**
	 * Returns the meta object for the container reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus#getSCorpusGraph <em>SCorpus Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SCorpus Graph</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus#getSCorpusGraph()
	 * @see #getSCorpus()
	 * @generated
	 */
	EReference getSCorpus_SCorpusGraph();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusRelation <em>SCorpus Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCorpus Relation</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusRelation
	 * @generated
	 */
	EClass getSCorpusRelation();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSSuperCorpus <em>SSuper Corpus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SSuper Corpus</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSSuperCorpus()
	 * @see #getSCorpusRelation()
	 * @generated
	 */
	EReference getSCorpusRelation_SSuperCorpus();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSSubCorpus <em>SSub Corpus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SSub Corpus</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSSubCorpus()
	 * @see #getSCorpusRelation()
	 * @generated
	 */
	EReference getSCorpusRelation_SSubCorpus();

	/**
	 * Returns the meta object for the container reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSCorpusGraph <em>SCorpus Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SCorpus Graph</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusRelation#getSCorpusGraph()
	 * @see #getSCorpusRelation()
	 * @generated
	 */
	EReference getSCorpusRelation_SCorpusGraph();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation <em>SCorpus Document Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCorpus Document Relation</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation
	 * @generated
	 */
	EClass getSCorpusDocumentRelation();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSCorpus <em>SCorpus</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SCorpus</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSCorpus()
	 * @see #getSCorpusDocumentRelation()
	 * @generated
	 */
	EReference getSCorpusDocumentRelation_SCorpus();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSDocument <em>SDocument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SDocument</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSDocument()
	 * @see #getSCorpusDocumentRelation()
	 * @generated
	 */
	EReference getSCorpusDocumentRelation_SDocument();

	/**
	 * Returns the meta object for the container reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSCorpusGraph <em>SCorpus Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SCorpus Graph</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation#getSCorpusGraph()
	 * @see #getSCorpusDocumentRelation()
	 * @generated
	 */
	EReference getSCorpusDocumentRelation_SCorpusGraph();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SCorpusStructureFactory getSCorpusStructureFactory();

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
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusGraphImpl <em>SCorpus Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusGraphImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusStructurePackageImpl#getSCorpusGraph()
		 * @generated
		 */
		EClass SCORPUS_GRAPH = eINSTANCE.getSCorpusGraph();

		/**
		 * The meta object literal for the '<em><b>SDocuments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORPUS_GRAPH__SDOCUMENTS = eINSTANCE.getSCorpusGraph_SDocuments();

		/**
		 * The meta object literal for the '<em><b>Salt Project</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORPUS_GRAPH__SALT_PROJECT = eINSTANCE.getSCorpusGraph_SaltProject();

		/**
		 * The meta object literal for the '<em><b>SCorpora</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORPUS_GRAPH__SCORPORA = eINSTANCE.getSCorpusGraph_SCorpora();

		/**
		 * The meta object literal for the '<em><b>SCorpus Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORPUS_GRAPH__SCORPUS_RELATIONS = eINSTANCE.getSCorpusGraph_SCorpusRelations();

		/**
		 * The meta object literal for the '<em><b>SCorpus Document Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORPUS_GRAPH__SCORPUS_DOCUMENT_RELATIONS = eINSTANCE.getSCorpusGraph_SCorpusDocumentRelations();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SDocumentImpl <em>SDocument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SDocumentImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusStructurePackageImpl#getSDocument()
		 * @generated
		 */
		EClass SDOCUMENT = eINSTANCE.getSDocument();

		/**
		 * The meta object literal for the '<em><b>SCorpus Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOCUMENT__SCORPUS_GRAPH = eINSTANCE.getSDocument_SCorpusGraph();

		/**
		 * The meta object literal for the '<em><b>SDocument Graph</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOCUMENT__SDOCUMENT_GRAPH = eINSTANCE.getSDocument_SDocumentGraph();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusImpl <em>SCorpus</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusStructurePackageImpl#getSCorpus()
		 * @generated
		 */
		EClass SCORPUS = eINSTANCE.getSCorpus();

		/**
		 * The meta object literal for the '<em><b>SCorpus Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORPUS__SCORPUS_GRAPH = eINSTANCE.getSCorpus_SCorpusGraph();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusRelationImpl <em>SCorpus Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusRelationImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusStructurePackageImpl#getSCorpusRelation()
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
		 * The meta object literal for the '<em><b>SCorpus Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORPUS_RELATION__SCORPUS_GRAPH = eINSTANCE.getSCorpusRelation_SCorpusGraph();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusDocumentRelationImpl <em>SCorpus Document Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusDocumentRelationImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusStructurePackageImpl#getSCorpusDocumentRelation()
		 * @generated
		 */
		EClass SCORPUS_DOCUMENT_RELATION = eINSTANCE.getSCorpusDocumentRelation();

		/**
		 * The meta object literal for the '<em><b>SCorpus</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORPUS_DOCUMENT_RELATION__SCORPUS = eINSTANCE.getSCorpusDocumentRelation_SCorpus();

		/**
		 * The meta object literal for the '<em><b>SDocument</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORPUS_DOCUMENT_RELATION__SDOCUMENT = eINSTANCE.getSCorpusDocumentRelation_SDocument();

		/**
		 * The meta object literal for the '<em><b>SCorpus Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCORPUS_DOCUMENT_RELATION__SCORPUS_GRAPH = eINSTANCE.getSCorpusDocumentRelation_SCorpusGraph();

	}

} //SCorpusStructurePackage
