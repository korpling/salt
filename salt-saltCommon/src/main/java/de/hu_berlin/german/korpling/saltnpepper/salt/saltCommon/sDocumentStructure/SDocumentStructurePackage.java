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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage;

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
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructureFactory
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
	 * This ending will be attached the SName of SDocuments to generate the name of the associated SDocumentGraph
	 */
	static public String SDOCUMENTGRAPH_ENDING = "_graph";
	
	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SDocumentStructurePackage eINSTANCE = de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentGraphImpl <em>SDocument Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentGraphImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSDocumentGraph()
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
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
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
	 * The feature id for the '<em><b>Layers</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__LAYERS = SaltCorePackage.SGRAPH__LAYERS;

	/**
	 * The feature id for the '<em><b>Num Of Layers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__NUM_OF_LAYERS = SaltCorePackage.SGRAPH__NUM_OF_LAYERS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SFEATURES = SaltCorePackage.SGRAPH__SFEATURES;

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
	 * The feature id for the '<em><b>SMeta Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SMETA_ANNOTATIONS = SaltCorePackage.SGRAPH__SMETA_ANNOTATIONS;

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
	 * The feature id for the '<em><b>SLayers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SLAYERS = SaltCorePackage.SGRAPH__SLAYERS;

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
	 * The feature id for the '<em><b>SStructures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SSTRUCTURES = SaltCorePackage.SGRAPH_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>SDominance Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SDOMINANCE_RELATIONS = SaltCorePackage.SGRAPH_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>SPointing Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SPOINTING_RELATIONS = SaltCorePackage.SGRAPH_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>SAudio DS Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SAUDIO_DS_RELATIONS = SaltCorePackage.SGRAPH_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>SAudio Data Sources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SAUDIO_DATA_SOURCES = SaltCorePackage.SGRAPH_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>SOrder Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SORDER_RELATIONS = SaltCorePackage.SGRAPH_FEATURE_COUNT + 13;

	/**
	 * The number of structural features of the '<em>SDocument Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH_FEATURE_COUNT = SaltCorePackage.SGRAPH_FEATURE_COUNT + 14;


	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SSequentialDSImpl <em>SSequential DS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SSequentialDSImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSSequentialDS()
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
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
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
	 * The feature id for the '<em><b>Layers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__LAYERS = SaltCorePackage.SNODE__LAYERS;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__SANNOTATIONS = SaltCorePackage.SNODE__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__SFEATURES = SaltCorePackage.SNODE__SFEATURES;

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
	 * The feature id for the '<em><b>SMeta Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__SMETA_ANNOTATIONS = SaltCorePackage.SNODE__SMETA_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__SGRAPH = SaltCorePackage.SNODE__SGRAPH;

	/**
	 * The feature id for the '<em><b>SLayers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__SLAYERS = SaltCorePackage.SNODE__SLAYERS;

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
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STextualDSImpl <em>STextual DS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STextualDSImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSTextualDS()
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
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
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
	 * The feature id for the '<em><b>Layers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__LAYERS = SSEQUENTIAL_DS__LAYERS;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__SANNOTATIONS = SSEQUENTIAL_DS__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__SFEATURES = SSEQUENTIAL_DS__SFEATURES;

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
	 * The feature id for the '<em><b>SMeta Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__SMETA_ANNOTATIONS = SSEQUENTIAL_DS__SMETA_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__SGRAPH = SSEQUENTIAL_DS__SGRAPH;

	/**
	 * The feature id for the '<em><b>SLayers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__SLAYERS = SSEQUENTIAL_DS__SLAYERS;

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
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SStructuredNodeImpl <em>SStructured Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SStructuredNodeImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSStructuredNode()
	 * @generated
	 */
	int SSTRUCTURED_NODE = 12;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURED_NODE__LABELS = SaltCorePackage.SNODE__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURED_NODE__ID = SaltCorePackage.SNODE__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURED_NODE__IDENTIFIER = SaltCorePackage.SNODE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURED_NODE__GRAPH = SaltCorePackage.SNODE__GRAPH;

	/**
	 * The feature id for the '<em><b>Layers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURED_NODE__LAYERS = SaltCorePackage.SNODE__LAYERS;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURED_NODE__SANNOTATIONS = SaltCorePackage.SNODE__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURED_NODE__SFEATURES = SaltCorePackage.SNODE__SFEATURES;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURED_NODE__SNAME = SaltCorePackage.SNODE__SNAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURED_NODE__SELEMENT_ID = SaltCorePackage.SNODE__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURED_NODE__SID = SaltCorePackage.SNODE__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURED_NODE__SELEMENT_PATH = SaltCorePackage.SNODE__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURED_NODE__SPROCESSING_ANNOTATIONS = SaltCorePackage.SNODE__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SMeta Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURED_NODE__SMETA_ANNOTATIONS = SaltCorePackage.SNODE__SMETA_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURED_NODE__SGRAPH = SaltCorePackage.SNODE__SGRAPH;

	/**
	 * The feature id for the '<em><b>SLayers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURED_NODE__SLAYERS = SaltCorePackage.SNODE__SLAYERS;

	/**
	 * The number of structural features of the '<em>SStructured Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURED_NODE_FEATURE_COUNT = SaltCorePackage.SNODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STokenImpl <em>SToken</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STokenImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSToken()
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
	int STOKEN__LABELS = SSTRUCTURED_NODE__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__ID = SSTRUCTURED_NODE__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__IDENTIFIER = SSTRUCTURED_NODE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__GRAPH = SSTRUCTURED_NODE__GRAPH;

	/**
	 * The feature id for the '<em><b>Layers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__LAYERS = SSTRUCTURED_NODE__LAYERS;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SANNOTATIONS = SSTRUCTURED_NODE__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SFEATURES = SSTRUCTURED_NODE__SFEATURES;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SNAME = SSTRUCTURED_NODE__SNAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SELEMENT_ID = SSTRUCTURED_NODE__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SID = SSTRUCTURED_NODE__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SELEMENT_PATH = SSTRUCTURED_NODE__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SPROCESSING_ANNOTATIONS = SSTRUCTURED_NODE__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SMeta Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SMETA_ANNOTATIONS = SSTRUCTURED_NODE__SMETA_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SGRAPH = SSTRUCTURED_NODE__SGRAPH;

	/**
	 * The feature id for the '<em><b>SLayers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SLAYERS = SSTRUCTURED_NODE__SLAYERS;

	/**
	 * The feature id for the '<em><b>SDocument Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SDOCUMENT_GRAPH = SSTRUCTURED_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SToken</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN_FEATURE_COUNT = SSTRUCTURED_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SSequentialRelationImpl <em>SSequential Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SSequentialRelationImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSSequentialRelation()
	 * @generated
	 */
	int SSEQUENTIAL_RELATION = 4;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STextualRelationImpl <em>STextual Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STextualRelationImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSTextualRelation()
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
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
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
	 * The feature id for the '<em><b>Layers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__LAYERS = SaltCorePackage.SRELATION__LAYERS;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__SANNOTATIONS = SaltCorePackage.SRELATION__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__SFEATURES = SaltCorePackage.SRELATION__SFEATURES;

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
	 * The feature id for the '<em><b>SMeta Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__SMETA_ANNOTATIONS = SaltCorePackage.SRELATION__SMETA_ANNOTATIONS;

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
	 * The feature id for the '<em><b>STypes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__STYPES = SaltCorePackage.SRELATION__STYPES;

	/**
	 * The feature id for the '<em><b>SLayers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__SLAYERS = SaltCorePackage.SRELATION__SLAYERS;

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
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
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
	 * The feature id for the '<em><b>Layers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__LAYERS = SSEQUENTIAL_RELATION__LAYERS;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SANNOTATIONS = SSEQUENTIAL_RELATION__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SFEATURES = SSEQUENTIAL_RELATION__SFEATURES;

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
	 * The feature id for the '<em><b>SMeta Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SMETA_ANNOTATIONS = SSEQUENTIAL_RELATION__SMETA_ANNOTATIONS;

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
	 * The feature id for the '<em><b>STypes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__STYPES = SSEQUENTIAL_RELATION__STYPES;

	/**
	 * The feature id for the '<em><b>SLayers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SLAYERS = SSEQUENTIAL_RELATION__SLAYERS;

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
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STimelineImpl <em>STimeline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STimelineImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSTimeline()
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
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
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
	 * The feature id for the '<em><b>Layers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__LAYERS = SSEQUENTIAL_DS__LAYERS;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__SANNOTATIONS = SSEQUENTIAL_DS__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__SFEATURES = SSEQUENTIAL_DS__SFEATURES;

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
	 * The feature id for the '<em><b>SMeta Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__SMETA_ANNOTATIONS = SSEQUENTIAL_DS__SMETA_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__SGRAPH = SSEQUENTIAL_DS__SGRAPH;

	/**
	 * The feature id for the '<em><b>SLayers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__SLAYERS = SSEQUENTIAL_DS__SLAYERS;

	/**
	 * The feature id for the '<em><b>SData</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__SDATA = SSEQUENTIAL_DS__SDATA;

	/**
	 * The feature id for the '<em><b>SDocument Graph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__SDOCUMENT_GRAPH = SSEQUENTIAL_DS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SPoints Of Time</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE__SPOINTS_OF_TIME = SSEQUENTIAL_DS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>STimeline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE_FEATURE_COUNT = SSEQUENTIAL_DS_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STimelineRelationImpl <em>STimeline Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STimelineRelationImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSTimelineRelation()
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
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
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
	 * The feature id for the '<em><b>Layers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE_RELATION__LAYERS = SSEQUENTIAL_RELATION__LAYERS;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE_RELATION__SANNOTATIONS = SSEQUENTIAL_RELATION__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE_RELATION__SFEATURES = SSEQUENTIAL_RELATION__SFEATURES;

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
	 * The feature id for the '<em><b>SMeta Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE_RELATION__SMETA_ANNOTATIONS = SSEQUENTIAL_RELATION__SMETA_ANNOTATIONS;

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
	 * The feature id for the '<em><b>STypes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE_RELATION__STYPES = SSEQUENTIAL_RELATION__STYPES;

	/**
	 * The feature id for the '<em><b>SLayers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIMELINE_RELATION__SLAYERS = SSEQUENTIAL_RELATION__SLAYERS;

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
	 * The feature id for the '<em><b>SDocument Graph</b></em>' container reference.
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
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SSpanImpl <em>SSpan</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SSpanImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSSpan()
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
	int SSPAN__LABELS = SSTRUCTURED_NODE__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN__ID = SSTRUCTURED_NODE__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN__IDENTIFIER = SSTRUCTURED_NODE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN__GRAPH = SSTRUCTURED_NODE__GRAPH;

	/**
	 * The feature id for the '<em><b>Layers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN__LAYERS = SSTRUCTURED_NODE__LAYERS;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN__SANNOTATIONS = SSTRUCTURED_NODE__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN__SFEATURES = SSTRUCTURED_NODE__SFEATURES;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN__SNAME = SSTRUCTURED_NODE__SNAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN__SELEMENT_ID = SSTRUCTURED_NODE__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN__SID = SSTRUCTURED_NODE__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN__SELEMENT_PATH = SSTRUCTURED_NODE__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN__SPROCESSING_ANNOTATIONS = SSTRUCTURED_NODE__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SMeta Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN__SMETA_ANNOTATIONS = SSTRUCTURED_NODE__SMETA_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN__SGRAPH = SSTRUCTURED_NODE__SGRAPH;

	/**
	 * The feature id for the '<em><b>SLayers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN__SLAYERS = SSTRUCTURED_NODE__SLAYERS;

	/**
	 * The feature id for the '<em><b>SDocument Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN__SDOCUMENT_GRAPH = SSTRUCTURED_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SSpan</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPAN_FEATURE_COUNT = SSTRUCTURED_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SSpanningRelationImpl <em>SSpanning Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SSpanningRelationImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSSpanningRelation()
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
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
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
	 * The feature id for the '<em><b>Layers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPANNING_RELATION__LAYERS = SaltCorePackage.SRELATION__LAYERS;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPANNING_RELATION__SANNOTATIONS = SaltCorePackage.SRELATION__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPANNING_RELATION__SFEATURES = SaltCorePackage.SRELATION__SFEATURES;

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
	 * The feature id for the '<em><b>SMeta Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPANNING_RELATION__SMETA_ANNOTATIONS = SaltCorePackage.SRELATION__SMETA_ANNOTATIONS;

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
	 * The feature id for the '<em><b>STypes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPANNING_RELATION__STYPES = SaltCorePackage.SRELATION__STYPES;

	/**
	 * The feature id for the '<em><b>SLayers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSPANNING_RELATION__SLAYERS = SaltCorePackage.SRELATION__SLAYERS;

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
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STextOverlappingRelationImpl <em>SText Overlapping Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STextOverlappingRelationImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSTextOverlappingRelation()
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
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
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
	 * The feature id for the '<em><b>Layers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXT_OVERLAPPING_RELATION__LAYERS = SaltCorePackage.SRELATION__LAYERS;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXT_OVERLAPPING_RELATION__SANNOTATIONS = SaltCorePackage.SRELATION__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXT_OVERLAPPING_RELATION__SFEATURES = SaltCorePackage.SRELATION__SFEATURES;

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
	 * The feature id for the '<em><b>SMeta Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXT_OVERLAPPING_RELATION__SMETA_ANNOTATIONS = SaltCorePackage.SRELATION__SMETA_ANNOTATIONS;

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
	 * The feature id for the '<em><b>STypes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXT_OVERLAPPING_RELATION__STYPES = SaltCorePackage.SRELATION__STYPES;

	/**
	 * The feature id for the '<em><b>SLayers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXT_OVERLAPPING_RELATION__SLAYERS = SaltCorePackage.SRELATION__SLAYERS;

	/**
	 * The number of structural features of the '<em>SText Overlapping Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXT_OVERLAPPING_RELATION_FEATURE_COUNT = SaltCorePackage.SRELATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STimeOverlappingRelationImpl <em>STime Overlapping Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STimeOverlappingRelationImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSTimeOverlappingRelation()
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
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
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
	 * The feature id for the '<em><b>Layers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIME_OVERLAPPING_RELATION__LAYERS = SaltCorePackage.SRELATION__LAYERS;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIME_OVERLAPPING_RELATION__SANNOTATIONS = SaltCorePackage.SRELATION__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIME_OVERLAPPING_RELATION__SFEATURES = SaltCorePackage.SRELATION__SFEATURES;

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
	 * The feature id for the '<em><b>SMeta Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIME_OVERLAPPING_RELATION__SMETA_ANNOTATIONS = SaltCorePackage.SRELATION__SMETA_ANNOTATIONS;

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
	 * The feature id for the '<em><b>STypes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIME_OVERLAPPING_RELATION__STYPES = SaltCorePackage.SRELATION__STYPES;

	/**
	 * The feature id for the '<em><b>SLayers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIME_OVERLAPPING_RELATION__SLAYERS = SaltCorePackage.SRELATION__SLAYERS;

	/**
	 * The number of structural features of the '<em>STime Overlapping Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STIME_OVERLAPPING_RELATION_FEATURE_COUNT = SaltCorePackage.SRELATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SStructureImpl <em>SStructure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SStructureImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSStructure()
	 * @generated
	 */
	int SSTRUCTURE = 13;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__LABELS = SSTRUCTURED_NODE__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__ID = SSTRUCTURED_NODE__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__IDENTIFIER = SSTRUCTURED_NODE__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__GRAPH = SSTRUCTURED_NODE__GRAPH;

	/**
	 * The feature id for the '<em><b>Layers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__LAYERS = SSTRUCTURED_NODE__LAYERS;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__SANNOTATIONS = SSTRUCTURED_NODE__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__SFEATURES = SSTRUCTURED_NODE__SFEATURES;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__SNAME = SSTRUCTURED_NODE__SNAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__SELEMENT_ID = SSTRUCTURED_NODE__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__SID = SSTRUCTURED_NODE__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__SELEMENT_PATH = SSTRUCTURED_NODE__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__SPROCESSING_ANNOTATIONS = SSTRUCTURED_NODE__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SMeta Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__SMETA_ANNOTATIONS = SSTRUCTURED_NODE__SMETA_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__SGRAPH = SSTRUCTURED_NODE__SGRAPH;

	/**
	 * The feature id for the '<em><b>SLayers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__SLAYERS = SSTRUCTURED_NODE__SLAYERS;

	/**
	 * The feature id for the '<em><b>SDocument Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE__SDOCUMENT_GRAPH = SSTRUCTURED_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SStructure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSTRUCTURE_FEATURE_COUNT = SSTRUCTURED_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SPointingRelationImpl <em>SPointing Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SPointingRelationImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSPointingRelation()
	 * @generated
	 */
	int SPOINTING_RELATION = 14;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__LABELS = SaltCorePackage.SRELATION__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__ID = SaltCorePackage.SRELATION__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__IDENTIFIER = SaltCorePackage.SRELATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__GRAPH = SaltCorePackage.SRELATION__GRAPH;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__SOURCE = SaltCorePackage.SRELATION__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__TARGET = SaltCorePackage.SRELATION__TARGET;

	/**
	 * The feature id for the '<em><b>Layers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__LAYERS = SaltCorePackage.SRELATION__LAYERS;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__SANNOTATIONS = SaltCorePackage.SRELATION__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__SFEATURES = SaltCorePackage.SRELATION__SFEATURES;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__SNAME = SaltCorePackage.SRELATION__SNAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__SELEMENT_ID = SaltCorePackage.SRELATION__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__SID = SaltCorePackage.SRELATION__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__SELEMENT_PATH = SaltCorePackage.SRELATION__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__SPROCESSING_ANNOTATIONS = SaltCorePackage.SRELATION__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SMeta Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__SMETA_ANNOTATIONS = SaltCorePackage.SRELATION__SMETA_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SSource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__SSOURCE = SaltCorePackage.SRELATION__SSOURCE;

	/**
	 * The feature id for the '<em><b>STarget</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__STARGET = SaltCorePackage.SRELATION__STARGET;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__SGRAPH = SaltCorePackage.SRELATION__SGRAPH;

	/**
	 * The feature id for the '<em><b>STypes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__STYPES = SaltCorePackage.SRELATION__STYPES;

	/**
	 * The feature id for the '<em><b>SLayers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__SLAYERS = SaltCorePackage.SRELATION__SLAYERS;

	/**
	 * The feature id for the '<em><b>SStructured Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__SSTRUCTURED_SOURCE = SaltCorePackage.SRELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SStructured Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__SSTRUCTURED_TARGET = SaltCorePackage.SRELATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SDocument Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION__SDOCUMENT_GRAPH = SaltCorePackage.SRELATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>SPointing Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOINTING_RELATION_FEATURE_COUNT = SaltCorePackage.SRELATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDominanceRelationImpl <em>SDominance Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDominanceRelationImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSDominanceRelation()
	 * @generated
	 */
	int SDOMINANCE_RELATION = 15;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__LABELS = STEXT_OVERLAPPING_RELATION__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__ID = STEXT_OVERLAPPING_RELATION__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__IDENTIFIER = STEXT_OVERLAPPING_RELATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__GRAPH = STEXT_OVERLAPPING_RELATION__GRAPH;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__SOURCE = STEXT_OVERLAPPING_RELATION__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__TARGET = STEXT_OVERLAPPING_RELATION__TARGET;

	/**
	 * The feature id for the '<em><b>Layers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__LAYERS = STEXT_OVERLAPPING_RELATION__LAYERS;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__SANNOTATIONS = STEXT_OVERLAPPING_RELATION__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__SFEATURES = STEXT_OVERLAPPING_RELATION__SFEATURES;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__SNAME = STEXT_OVERLAPPING_RELATION__SNAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__SELEMENT_ID = STEXT_OVERLAPPING_RELATION__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__SID = STEXT_OVERLAPPING_RELATION__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__SELEMENT_PATH = STEXT_OVERLAPPING_RELATION__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__SPROCESSING_ANNOTATIONS = STEXT_OVERLAPPING_RELATION__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SMeta Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__SMETA_ANNOTATIONS = STEXT_OVERLAPPING_RELATION__SMETA_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SSource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__SSOURCE = STEXT_OVERLAPPING_RELATION__SSOURCE;

	/**
	 * The feature id for the '<em><b>STarget</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__STARGET = STEXT_OVERLAPPING_RELATION__STARGET;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__SGRAPH = STEXT_OVERLAPPING_RELATION__SGRAPH;

	/**
	 * The feature id for the '<em><b>STypes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__STYPES = STEXT_OVERLAPPING_RELATION__STYPES;

	/**
	 * The feature id for the '<em><b>SLayers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__SLAYERS = STEXT_OVERLAPPING_RELATION__SLAYERS;

	/**
	 * The feature id for the '<em><b>SStructure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__SSTRUCTURE = STEXT_OVERLAPPING_RELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SStructured Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__SSTRUCTURED_TARGET = STEXT_OVERLAPPING_RELATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SDocument Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION__SDOCUMENT_GRAPH = STEXT_OVERLAPPING_RELATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>SDominance Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOMINANCE_RELATION_FEATURE_COUNT = STEXT_OVERLAPPING_RELATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDataSourceSequenceImpl <em>SData Source Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDataSourceSequenceImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSDataSourceSequence()
	 * @generated
	 */
	int SDATA_SOURCE_SEQUENCE = 16;

	/**
	 * The feature id for the '<em><b>SStart</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDATA_SOURCE_SEQUENCE__SSTART = 0;

	/**
	 * The feature id for the '<em><b>SEnd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDATA_SOURCE_SEQUENCE__SEND = 1;

	/**
	 * The feature id for the '<em><b>SSequential DS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDATA_SOURCE_SEQUENCE__SSEQUENTIAL_DS = 2;

	/**
	 * The number of structural features of the '<em>SData Source Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDATA_SOURCE_SEQUENCE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SAudioDataSourceImpl <em>SAudio Data Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SAudioDataSourceImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSAudioDataSource()
	 * @generated
	 */
	int SAUDIO_DATA_SOURCE = 17;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DATA_SOURCE__LABELS = SSEQUENTIAL_DS__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DATA_SOURCE__ID = SSEQUENTIAL_DS__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DATA_SOURCE__IDENTIFIER = SSEQUENTIAL_DS__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DATA_SOURCE__GRAPH = SSEQUENTIAL_DS__GRAPH;

	/**
	 * The feature id for the '<em><b>Layers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DATA_SOURCE__LAYERS = SSEQUENTIAL_DS__LAYERS;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DATA_SOURCE__SANNOTATIONS = SSEQUENTIAL_DS__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DATA_SOURCE__SFEATURES = SSEQUENTIAL_DS__SFEATURES;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DATA_SOURCE__SNAME = SSEQUENTIAL_DS__SNAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DATA_SOURCE__SELEMENT_ID = SSEQUENTIAL_DS__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DATA_SOURCE__SID = SSEQUENTIAL_DS__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DATA_SOURCE__SELEMENT_PATH = SSEQUENTIAL_DS__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DATA_SOURCE__SPROCESSING_ANNOTATIONS = SSEQUENTIAL_DS__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SMeta Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DATA_SOURCE__SMETA_ANNOTATIONS = SSEQUENTIAL_DS__SMETA_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DATA_SOURCE__SGRAPH = SSEQUENTIAL_DS__SGRAPH;

	/**
	 * The feature id for the '<em><b>SLayers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DATA_SOURCE__SLAYERS = SSEQUENTIAL_DS__SLAYERS;

	/**
	 * The feature id for the '<em><b>SData</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DATA_SOURCE__SDATA = SSEQUENTIAL_DS__SDATA;

	/**
	 * The feature id for the '<em><b>SDocument Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DATA_SOURCE__SDOCUMENT_GRAPH = SSEQUENTIAL_DS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SAudio Reference</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DATA_SOURCE__SAUDIO_REFERENCE = SSEQUENTIAL_DS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>SAudio Data Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DATA_SOURCE_FEATURE_COUNT = SSEQUENTIAL_DS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SAudioDSRelationImpl <em>SAudio DS Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SAudioDSRelationImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSAudioDSRelation()
	 * @generated
	 */
	int SAUDIO_DS_RELATION = 18;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DS_RELATION__LABELS = SaltCorePackage.SRELATION__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DS_RELATION__ID = SaltCorePackage.SRELATION__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DS_RELATION__IDENTIFIER = SaltCorePackage.SRELATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DS_RELATION__GRAPH = SaltCorePackage.SRELATION__GRAPH;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DS_RELATION__SOURCE = SaltCorePackage.SRELATION__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DS_RELATION__TARGET = SaltCorePackage.SRELATION__TARGET;

	/**
	 * The feature id for the '<em><b>Layers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DS_RELATION__LAYERS = SaltCorePackage.SRELATION__LAYERS;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DS_RELATION__SANNOTATIONS = SaltCorePackage.SRELATION__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DS_RELATION__SFEATURES = SaltCorePackage.SRELATION__SFEATURES;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DS_RELATION__SNAME = SaltCorePackage.SRELATION__SNAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DS_RELATION__SELEMENT_ID = SaltCorePackage.SRELATION__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DS_RELATION__SID = SaltCorePackage.SRELATION__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DS_RELATION__SELEMENT_PATH = SaltCorePackage.SRELATION__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DS_RELATION__SPROCESSING_ANNOTATIONS = SaltCorePackage.SRELATION__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SMeta Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DS_RELATION__SMETA_ANNOTATIONS = SaltCorePackage.SRELATION__SMETA_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SSource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DS_RELATION__SSOURCE = SaltCorePackage.SRELATION__SSOURCE;

	/**
	 * The feature id for the '<em><b>STarget</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DS_RELATION__STARGET = SaltCorePackage.SRELATION__STARGET;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DS_RELATION__SGRAPH = SaltCorePackage.SRELATION__SGRAPH;

	/**
	 * The feature id for the '<em><b>STypes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DS_RELATION__STYPES = SaltCorePackage.SRELATION__STYPES;

	/**
	 * The feature id for the '<em><b>SLayers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DS_RELATION__SLAYERS = SaltCorePackage.SRELATION__SLAYERS;

	/**
	 * The feature id for the '<em><b>SStart</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DS_RELATION__SSTART = SaltCorePackage.SRELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SEnd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DS_RELATION__SEND = SaltCorePackage.SRELATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SToken</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DS_RELATION__STOKEN = SaltCorePackage.SRELATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>SAudio DS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DS_RELATION__SAUDIO_DS = SaltCorePackage.SRELATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>SDocument Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DS_RELATION__SDOCUMENT_GRAPH = SaltCorePackage.SRELATION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>SAudio DS Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SAUDIO_DS_RELATION_FEATURE_COUNT = SaltCorePackage.SRELATION_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SOrderRelationImpl <em>SOrder Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SOrderRelationImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSOrderRelation()
	 * @generated
	 */
	int SORDER_RELATION = 19;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORDER_RELATION__LABELS = SaltCorePackage.SRELATION__LABELS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORDER_RELATION__ID = SaltCorePackage.SRELATION__ID;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORDER_RELATION__IDENTIFIER = SaltCorePackage.SRELATION__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORDER_RELATION__GRAPH = SaltCorePackage.SRELATION__GRAPH;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORDER_RELATION__SOURCE = SaltCorePackage.SRELATION__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORDER_RELATION__TARGET = SaltCorePackage.SRELATION__TARGET;

	/**
	 * The feature id for the '<em><b>Layers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORDER_RELATION__LAYERS = SaltCorePackage.SRELATION__LAYERS;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORDER_RELATION__SANNOTATIONS = SaltCorePackage.SRELATION__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SFeatures</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORDER_RELATION__SFEATURES = SaltCorePackage.SRELATION__SFEATURES;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORDER_RELATION__SNAME = SaltCorePackage.SRELATION__SNAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORDER_RELATION__SELEMENT_ID = SaltCorePackage.SRELATION__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORDER_RELATION__SID = SaltCorePackage.SRELATION__SID;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORDER_RELATION__SELEMENT_PATH = SaltCorePackage.SRELATION__SELEMENT_PATH;

	/**
	 * The feature id for the '<em><b>SProcessing Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORDER_RELATION__SPROCESSING_ANNOTATIONS = SaltCorePackage.SRELATION__SPROCESSING_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SMeta Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORDER_RELATION__SMETA_ANNOTATIONS = SaltCorePackage.SRELATION__SMETA_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SSource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORDER_RELATION__SSOURCE = SaltCorePackage.SRELATION__SSOURCE;

	/**
	 * The feature id for the '<em><b>STarget</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORDER_RELATION__STARGET = SaltCorePackage.SRELATION__STARGET;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORDER_RELATION__SGRAPH = SaltCorePackage.SRELATION__SGRAPH;

	/**
	 * The feature id for the '<em><b>STypes</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORDER_RELATION__STYPES = SaltCorePackage.SRELATION__STYPES;

	/**
	 * The feature id for the '<em><b>SLayers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORDER_RELATION__SLAYERS = SaltCorePackage.SRELATION__SLAYERS;

	/**
	 * The feature id for the '<em><b>SDocument Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORDER_RELATION__SDOCUMENT_GRAPH = SaltCorePackage.SRELATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>SOrder Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SORDER_RELATION_FEATURE_COUNT = SaltCorePackage.SRELATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SFEATURE_NAMES <em>SFEATURE NAMES</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SFEATURE_NAMES
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSFEATURE_NAMES()
	 * @generated
	 */
	int SFEATURE_NAMES = 20;


	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME <em>STYPE NAME</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSTYPE_NAME()
	 * @generated
	 */
	int STYPE_NAME = 21;


	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SDocument Graph</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph
	 * @generated
	 */
	EClass getSDocumentGraph();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSDocument <em>SDocument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SDocument</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSDocument()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_SDocument();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualDSs <em>STextual DSs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>STextual DSs</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualDSs()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_STextualDSs();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualRelations <em>STextual Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>STextual Relations</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTextualRelations()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_STextualRelations();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTokens <em>STokens</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>STokens</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTokens()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_STokens();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimeline <em>STimeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>STimeline</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimeline()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_STimeline();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimelineRelations <em>STimeline Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>STimeline Relations</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSTimelineRelations()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_STimelineRelations();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSSpanningRelations <em>SSpanning Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SSpanning Relations</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSSpanningRelations()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_SSpanningRelations();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSSpans <em>SSpans</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SSpans</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSSpans()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_SSpans();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSStructures <em>SStructures</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SStructures</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSStructures()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_SStructures();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSDominanceRelations <em>SDominance Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SDominance Relations</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSDominanceRelations()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_SDominanceRelations();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSPointingRelations <em>SPointing Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SPointing Relations</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSPointingRelations()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_SPointingRelations();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSAudioDSRelations <em>SAudio DS Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SAudio DS Relations</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSAudioDSRelations()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_SAudioDSRelations();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSAudioDataSources <em>SAudio Data Sources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SAudio Data Sources</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSAudioDataSources()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_SAudioDataSources();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSOrderRelations <em>SOrder Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SOrder Relations</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph#getSOrderRelations()
	 * @see #getSDocumentGraph()
	 * @generated
	 */
	EReference getSDocumentGraph_SOrderRelations();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS <em>STextual DS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>STextual DS</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS
	 * @generated
	 */
	EClass getSTextualDS();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS#getSText <em>SText</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SText</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS#getSText()
	 * @see #getSTextualDS()
	 * @generated
	 */
	EAttribute getSTextualDS_SText();

	/**
	 * Returns the meta object for the container reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SDocument Graph</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS#getSDocumentGraph()
	 * @see #getSTextualDS()
	 * @generated
	 */
	EReference getSTextualDS_SDocumentGraph();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken <em>SToken</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SToken</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken
	 * @generated
	 */
	EClass getSToken();

	/**
	 * Returns the meta object for the container reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SDocument Graph</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken#getSDocumentGraph()
	 * @see #getSToken()
	 * @generated
	 */
	EReference getSToken_SDocumentGraph();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation <em>STextual Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>STextual Relation</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation
	 * @generated
	 */
	EClass getSTextualRelation();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation#getSToken <em>SToken</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SToken</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation#getSToken()
	 * @see #getSTextualRelation()
	 * @generated
	 */
	EReference getSTextualRelation_SToken();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation#getSTextualDS <em>STextual DS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>STextual DS</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation#getSTextualDS()
	 * @see #getSTextualRelation()
	 * @generated
	 */
	EReference getSTextualRelation_STextualDS();

	/**
	 * Returns the meta object for the container reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SDocument Graph</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation#getSDocumentGraph()
	 * @see #getSTextualRelation()
	 * @generated
	 */
	EReference getSTextualRelation_SDocumentGraph();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialRelation <em>SSequential Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SSequential Relation</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialRelation
	 * @generated
	 */
	EClass getSSequentialRelation();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialRelation#getSStart <em>SStart</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SStart</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialRelation#getSStart()
	 * @see #getSSequentialRelation()
	 * @generated
	 */
	EAttribute getSSequentialRelation_SStart();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialRelation#getSEnd <em>SEnd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SEnd</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialRelation#getSEnd()
	 * @see #getSSequentialRelation()
	 * @generated
	 */
	EAttribute getSSequentialRelation_SEnd();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialDS <em>SSequential DS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SSequential DS</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialDS
	 * @generated
	 */
	EClass getSSequentialDS();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialDS#getSData <em>SData</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SData</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialDS#getSData()
	 * @see #getSSequentialDS()
	 * @generated
	 */
	EAttribute getSSequentialDS_SData();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeline <em>STimeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>STimeline</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeline
	 * @generated
	 */
	EClass getSTimeline();

	/**
	 * Returns the meta object for the attribute list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeline#getSPointsOfTime <em>SPoints Of Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>SPoints Of Time</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeline#getSPointsOfTime()
	 * @see #getSTimeline()
	 * @generated
	 */
	EAttribute getSTimeline_SPointsOfTime();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeline#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SDocument Graph</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeline#getSDocumentGraph()
	 * @see #getSTimeline()
	 * @generated
	 */
	EReference getSTimeline_SDocumentGraph();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimelineRelation <em>STimeline Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>STimeline Relation</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimelineRelation
	 * @generated
	 */
	EClass getSTimelineRelation();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimelineRelation#getSTimeline <em>STimeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>STimeline</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimelineRelation#getSTimeline()
	 * @see #getSTimelineRelation()
	 * @generated
	 */
	EReference getSTimelineRelation_STimeline();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimelineRelation#getSToken <em>SToken</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SToken</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimelineRelation#getSToken()
	 * @see #getSTimelineRelation()
	 * @generated
	 */
	EReference getSTimelineRelation_SToken();

	/**
	 * Returns the meta object for the container reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimelineRelation#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SDocument Graph</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimelineRelation#getSDocumentGraph()
	 * @see #getSTimelineRelation()
	 * @generated
	 */
	EReference getSTimelineRelation_SDocumentGraph();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan <em>SSpan</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SSpan</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan
	 * @generated
	 */
	EClass getSSpan();

	/**
	 * Returns the meta object for the container reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SDocument Graph</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan#getSDocumentGraph()
	 * @see #getSSpan()
	 * @generated
	 */
	EReference getSSpan_SDocumentGraph();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation <em>SSpanning Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SSpanning Relation</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation
	 * @generated
	 */
	EClass getSSpanningRelation();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation#getSToken <em>SToken</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SToken</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation#getSToken()
	 * @see #getSSpanningRelation()
	 * @generated
	 */
	EReference getSSpanningRelation_SToken();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation#getSSpan <em>SSpan</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SSpan</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation#getSSpan()
	 * @see #getSSpanningRelation()
	 * @generated
	 */
	EReference getSSpanningRelation_SSpan();

	/**
	 * Returns the meta object for the container reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SDocument Graph</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation#getSDocumentGraph()
	 * @see #getSSpanningRelation()
	 * @generated
	 */
	EReference getSSpanningRelation_SDocumentGraph();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextOverlappingRelation <em>SText Overlapping Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SText Overlapping Relation</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextOverlappingRelation
	 * @generated
	 */
	EClass getSTextOverlappingRelation();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeOverlappingRelation <em>STime Overlapping Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>STime Overlapping Relation</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeOverlappingRelation
	 * @generated
	 */
	EClass getSTimeOverlappingRelation();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructuredNode <em>SStructured Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SStructured Node</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructuredNode
	 * @generated
	 */
	EClass getSStructuredNode();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure <em>SStructure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SStructure</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure
	 * @generated
	 */
	EClass getSStructure();

	/**
	 * Returns the meta object for the container reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SDocument Graph</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure#getSDocumentGraph()
	 * @see #getSStructure()
	 * @generated
	 */
	EReference getSStructure_SDocumentGraph();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation <em>SPointing Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SPointing Relation</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation
	 * @generated
	 */
	EClass getSPointingRelation();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation#getSStructuredSource <em>SStructured Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SStructured Source</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation#getSStructuredSource()
	 * @see #getSPointingRelation()
	 * @generated
	 */
	EReference getSPointingRelation_SStructuredSource();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation#getSStructuredTarget <em>SStructured Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SStructured Target</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation#getSStructuredTarget()
	 * @see #getSPointingRelation()
	 * @generated
	 */
	EReference getSPointingRelation_SStructuredTarget();

	/**
	 * Returns the meta object for the container reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SDocument Graph</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation#getSDocumentGraph()
	 * @see #getSPointingRelation()
	 * @generated
	 */
	EReference getSPointingRelation_SDocumentGraph();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation <em>SDominance Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SDominance Relation</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation
	 * @generated
	 */
	EClass getSDominanceRelation();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSStructure <em>SStructure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SStructure</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSStructure()
	 * @see #getSDominanceRelation()
	 * @generated
	 */
	EReference getSDominanceRelation_SStructure();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSStructuredTarget <em>SStructured Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SStructured Target</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSStructuredTarget()
	 * @see #getSDominanceRelation()
	 * @generated
	 */
	EReference getSDominanceRelation_SStructuredTarget();

	/**
	 * Returns the meta object for the container reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SDocument Graph</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation#getSDocumentGraph()
	 * @see #getSDominanceRelation()
	 * @generated
	 */
	EReference getSDominanceRelation_SDocumentGraph();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence <em>SData Source Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SData Source Sequence</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence
	 * @generated
	 */
	EClass getSDataSourceSequence();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence#getSStart <em>SStart</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SStart</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence#getSStart()
	 * @see #getSDataSourceSequence()
	 * @generated
	 */
	EAttribute getSDataSourceSequence_SStart();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence#getSEnd <em>SEnd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SEnd</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence#getSEnd()
	 * @see #getSDataSourceSequence()
	 * @generated
	 */
	EAttribute getSDataSourceSequence_SEnd();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence#getSSequentialDS <em>SSequential DS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SSequential DS</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence#getSSequentialDS()
	 * @see #getSDataSourceSequence()
	 * @generated
	 */
	EReference getSDataSourceSequence_SSequentialDS();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDataSource <em>SAudio Data Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SAudio Data Source</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDataSource
	 * @generated
	 */
	EClass getSAudioDataSource();

	/**
	 * Returns the meta object for the container reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDataSource#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SDocument Graph</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDataSource#getSDocumentGraph()
	 * @see #getSAudioDataSource()
	 * @generated
	 */
	EReference getSAudioDataSource_SDocumentGraph();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDataSource#getSAudioReference <em>SAudio Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SAudio Reference</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDataSource#getSAudioReference()
	 * @see #getSAudioDataSource()
	 * @generated
	 */
	EAttribute getSAudioDataSource_SAudioReference();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDSRelation <em>SAudio DS Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SAudio DS Relation</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDSRelation
	 * @generated
	 */
	EClass getSAudioDSRelation();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDSRelation#getSStart <em>SStart</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SStart</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDSRelation#getSStart()
	 * @see #getSAudioDSRelation()
	 * @generated
	 */
	EAttribute getSAudioDSRelation_SStart();

	/**
	 * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDSRelation#getSEnd <em>SEnd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SEnd</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDSRelation#getSEnd()
	 * @see #getSAudioDSRelation()
	 * @generated
	 */
	EAttribute getSAudioDSRelation_SEnd();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDSRelation#getSToken <em>SToken</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SToken</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDSRelation#getSToken()
	 * @see #getSAudioDSRelation()
	 * @generated
	 */
	EReference getSAudioDSRelation_SToken();

	/**
	 * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDSRelation#getSAudioDS <em>SAudio DS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>SAudio DS</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDSRelation#getSAudioDS()
	 * @see #getSAudioDSRelation()
	 * @generated
	 */
	EReference getSAudioDSRelation_SAudioDS();

	/**
	 * Returns the meta object for the container reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDSRelation#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SDocument Graph</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDSRelation#getSDocumentGraph()
	 * @see #getSAudioDSRelation()
	 * @generated
	 */
	EReference getSAudioDSRelation_SDocumentGraph();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SOrderRelation <em>SOrder Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SOrder Relation</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SOrderRelation
	 * @generated
	 */
	EClass getSOrderRelation();

	/**
	 * Returns the meta object for the container reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SOrderRelation#getSDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SDocument Graph</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SOrderRelation#getSDocumentGraph()
	 * @see #getSOrderRelation()
	 * @generated
	 */
	EReference getSOrderRelation_SDocumentGraph();

	/**
	 * Returns the meta object for enum '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SFEATURE_NAMES <em>SFEATURE NAMES</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>SFEATURE NAMES</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SFEATURE_NAMES
	 * @generated
	 */
	EEnum getSFEATURE_NAMES();

	/**
	 * Returns the meta object for enum '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME <em>STYPE NAME</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>STYPE NAME</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME
	 * @generated
	 */
	EEnum getSTYPE_NAME();

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
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentGraphImpl <em>SDocument Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentGraphImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSDocumentGraph()
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
		 * The meta object literal for the '<em><b>SStructures</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOCUMENT_GRAPH__SSTRUCTURES = eINSTANCE.getSDocumentGraph_SStructures();

		/**
		 * The meta object literal for the '<em><b>SDominance Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOCUMENT_GRAPH__SDOMINANCE_RELATIONS = eINSTANCE.getSDocumentGraph_SDominanceRelations();

		/**
		 * The meta object literal for the '<em><b>SPointing Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOCUMENT_GRAPH__SPOINTING_RELATIONS = eINSTANCE.getSDocumentGraph_SPointingRelations();

		/**
		 * The meta object literal for the '<em><b>SAudio DS Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOCUMENT_GRAPH__SAUDIO_DS_RELATIONS = eINSTANCE.getSDocumentGraph_SAudioDSRelations();

		/**
		 * The meta object literal for the '<em><b>SAudio Data Sources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOCUMENT_GRAPH__SAUDIO_DATA_SOURCES = eINSTANCE.getSDocumentGraph_SAudioDataSources();

		/**
		 * The meta object literal for the '<em><b>SOrder Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOCUMENT_GRAPH__SORDER_RELATIONS = eINSTANCE.getSDocumentGraph_SOrderRelations();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STextualDSImpl <em>STextual DS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STextualDSImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSTextualDS()
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
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STokenImpl <em>SToken</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STokenImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSToken()
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
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STextualRelationImpl <em>STextual Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STextualRelationImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSTextualRelation()
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
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SSequentialRelationImpl <em>SSequential Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SSequentialRelationImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSSequentialRelation()
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
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SSequentialDSImpl <em>SSequential DS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SSequentialDSImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSSequentialDS()
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
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STimelineImpl <em>STimeline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STimelineImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSTimeline()
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
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STimelineRelationImpl <em>STimeline Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STimelineRelationImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSTimelineRelation()
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
		 * The meta object literal for the '<em><b>SDocument Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STIMELINE_RELATION__SDOCUMENT_GRAPH = eINSTANCE.getSTimelineRelation_SDocumentGraph();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SSpanImpl <em>SSpan</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SSpanImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSSpan()
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
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SSpanningRelationImpl <em>SSpanning Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SSpanningRelationImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSSpanningRelation()
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
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STextOverlappingRelationImpl <em>SText Overlapping Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STextOverlappingRelationImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSTextOverlappingRelation()
		 * @generated
		 */
		EClass STEXT_OVERLAPPING_RELATION = eINSTANCE.getSTextOverlappingRelation();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STimeOverlappingRelationImpl <em>STime Overlapping Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.STimeOverlappingRelationImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSTimeOverlappingRelation()
		 * @generated
		 */
		EClass STIME_OVERLAPPING_RELATION = eINSTANCE.getSTimeOverlappingRelation();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SStructuredNodeImpl <em>SStructured Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SStructuredNodeImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSStructuredNode()
		 * @generated
		 */
		EClass SSTRUCTURED_NODE = eINSTANCE.getSStructuredNode();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SStructureImpl <em>SStructure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SStructureImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSStructure()
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
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SPointingRelationImpl <em>SPointing Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SPointingRelationImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSPointingRelation()
		 * @generated
		 */
		EClass SPOINTING_RELATION = eINSTANCE.getSPointingRelation();

		/**
		 * The meta object literal for the '<em><b>SStructured Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPOINTING_RELATION__SSTRUCTURED_SOURCE = eINSTANCE.getSPointingRelation_SStructuredSource();

		/**
		 * The meta object literal for the '<em><b>SStructured Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPOINTING_RELATION__SSTRUCTURED_TARGET = eINSTANCE.getSPointingRelation_SStructuredTarget();

		/**
		 * The meta object literal for the '<em><b>SDocument Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPOINTING_RELATION__SDOCUMENT_GRAPH = eINSTANCE.getSPointingRelation_SDocumentGraph();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDominanceRelationImpl <em>SDominance Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDominanceRelationImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSDominanceRelation()
		 * @generated
		 */
		EClass SDOMINANCE_RELATION = eINSTANCE.getSDominanceRelation();

		/**
		 * The meta object literal for the '<em><b>SStructure</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOMINANCE_RELATION__SSTRUCTURE = eINSTANCE.getSDominanceRelation_SStructure();

		/**
		 * The meta object literal for the '<em><b>SStructured Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOMINANCE_RELATION__SSTRUCTURED_TARGET = eINSTANCE.getSDominanceRelation_SStructuredTarget();

		/**
		 * The meta object literal for the '<em><b>SDocument Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDOMINANCE_RELATION__SDOCUMENT_GRAPH = eINSTANCE.getSDominanceRelation_SDocumentGraph();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDataSourceSequenceImpl <em>SData Source Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDataSourceSequenceImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSDataSourceSequence()
		 * @generated
		 */
		EClass SDATA_SOURCE_SEQUENCE = eINSTANCE.getSDataSourceSequence();

		/**
		 * The meta object literal for the '<em><b>SStart</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SDATA_SOURCE_SEQUENCE__SSTART = eINSTANCE.getSDataSourceSequence_SStart();

		/**
		 * The meta object literal for the '<em><b>SEnd</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SDATA_SOURCE_SEQUENCE__SEND = eINSTANCE.getSDataSourceSequence_SEnd();

		/**
		 * The meta object literal for the '<em><b>SSequential DS</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SDATA_SOURCE_SEQUENCE__SSEQUENTIAL_DS = eINSTANCE.getSDataSourceSequence_SSequentialDS();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SAudioDataSourceImpl <em>SAudio Data Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SAudioDataSourceImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSAudioDataSource()
		 * @generated
		 */
		EClass SAUDIO_DATA_SOURCE = eINSTANCE.getSAudioDataSource();

		/**
		 * The meta object literal for the '<em><b>SDocument Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAUDIO_DATA_SOURCE__SDOCUMENT_GRAPH = eINSTANCE.getSAudioDataSource_SDocumentGraph();

		/**
		 * The meta object literal for the '<em><b>SAudio Reference</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAUDIO_DATA_SOURCE__SAUDIO_REFERENCE = eINSTANCE.getSAudioDataSource_SAudioReference();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SAudioDSRelationImpl <em>SAudio DS Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SAudioDSRelationImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSAudioDSRelation()
		 * @generated
		 */
		EClass SAUDIO_DS_RELATION = eINSTANCE.getSAudioDSRelation();

		/**
		 * The meta object literal for the '<em><b>SStart</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAUDIO_DS_RELATION__SSTART = eINSTANCE.getSAudioDSRelation_SStart();

		/**
		 * The meta object literal for the '<em><b>SEnd</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SAUDIO_DS_RELATION__SEND = eINSTANCE.getSAudioDSRelation_SEnd();

		/**
		 * The meta object literal for the '<em><b>SToken</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAUDIO_DS_RELATION__STOKEN = eINSTANCE.getSAudioDSRelation_SToken();

		/**
		 * The meta object literal for the '<em><b>SAudio DS</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAUDIO_DS_RELATION__SAUDIO_DS = eINSTANCE.getSAudioDSRelation_SAudioDS();

		/**
		 * The meta object literal for the '<em><b>SDocument Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SAUDIO_DS_RELATION__SDOCUMENT_GRAPH = eINSTANCE.getSAudioDSRelation_SDocumentGraph();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SOrderRelationImpl <em>SOrder Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SOrderRelationImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSOrderRelation()
		 * @generated
		 */
		EClass SORDER_RELATION = eINSTANCE.getSOrderRelation();

		/**
		 * The meta object literal for the '<em><b>SDocument Graph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SORDER_RELATION__SDOCUMENT_GRAPH = eINSTANCE.getSOrderRelation_SDocumentGraph();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SFEATURE_NAMES <em>SFEATURE NAMES</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SFEATURE_NAMES
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSFEATURE_NAMES()
		 * @generated
		 */
		EEnum SFEATURE_NAMES = eINSTANCE.getSFEATURE_NAMES();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME <em>STYPE NAME</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl.SDocumentStructurePackageImpl#getSTYPE_NAME()
		 * @generated
		 */
		EEnum STYPE_NAME = eINSTANCE.getSTYPE_NAME();

	}

} //SDocumentStructurePackage
