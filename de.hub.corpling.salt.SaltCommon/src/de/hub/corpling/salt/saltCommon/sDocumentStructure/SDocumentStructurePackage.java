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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__NAME = SaltCorePackage.SGRAPH__NAME;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SANNOTATIONS = SaltCorePackage.SGRAPH__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SELEMENT_ID = SaltCorePackage.SGRAPH__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SRelations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH__SRELATIONS = SaltCorePackage.SGRAPH__SRELATIONS;

	/**
	 * The feature id for the '<em><b>SNodes</b></em>' containment reference list.
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
	 * The number of structural features of the '<em>SDocument Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SDOCUMENT_GRAPH_FEATURE_COUNT = SaltCorePackage.SGRAPH_FEATURE_COUNT + 4;


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
	 * The feature id for the '<em><b>SData</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS__SDATA = 0;

	/**
	 * The number of structural features of the '<em>SSequential DS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_DS_FEATURE_COUNT = 1;

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
	 * The feature id for the '<em><b>SData</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__SDATA = SSEQUENTIAL_DS__SDATA;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__SANNOTATIONS = SSEQUENTIAL_DS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__NAME = SSEQUENTIAL_DS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__SELEMENT_ID = SSEQUENTIAL_DS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__SGRAPH = SSEQUENTIAL_DS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>SText</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__STEXT = SSEQUENTIAL_DS_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>SDocument Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS__SDOCUMENT_GRAPH = SSEQUENTIAL_DS_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>STextual DS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_DS_FEATURE_COUNT = SSEQUENTIAL_DS_FEATURE_COUNT + 6;

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
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SANNOTATIONS = SaltCorePackage.SNODE__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__NAME = SaltCorePackage.SNODE__NAME;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STOKEN__SELEMENT_ID = SaltCorePackage.SNODE__SELEMENT_ID;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' container reference.
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
	 * The feature id for the '<em><b>SStart</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__SSTART = 0;

	/**
	 * The feature id for the '<em><b>SEnd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION__SEND = 1;

	/**
	 * The number of structural features of the '<em>SSequential Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSEQUENTIAL_RELATION_FEATURE_COUNT = 2;

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
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SANNOTATIONS = SSEQUENTIAL_RELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__NAME = SSEQUENTIAL_RELATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SELEMENT_ID = SSEQUENTIAL_RELATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SGRAPH = SSEQUENTIAL_RELATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>SToken</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__STOKEN = SSEQUENTIAL_RELATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>STextual DS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__STEXTUAL_DS = SSEQUENTIAL_RELATION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>SDocument Graph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION__SDOCUMENT_GRAPH = SSEQUENTIAL_RELATION_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>STextual Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEXTUAL_RELATION_FEATURE_COUNT = SSEQUENTIAL_RELATION_FEATURE_COUNT + 7;


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

	}

} //SDocumentStructurePackage
