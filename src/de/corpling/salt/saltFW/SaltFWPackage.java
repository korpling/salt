/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.saltFW;

import de.corpling.salt.model.salt.SaltPackage;

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
 * @see de.corpling.salt.saltFW.SaltFWFactory
 * @model kind="package"
 * @generated
 */
public interface SaltFWPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "saltFW";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "www.corpling.de/saltFW";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "saltFW";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SaltFWPackage eINSTANCE = de.corpling.salt.saltFW.impl.SaltFWPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.corpling.salt.saltFW.impl.SaltProjectImpl <em>Salt Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.saltFW.impl.SaltProjectImpl
	 * @see de.corpling.salt.saltFW.impl.SaltFWPackageImpl#getSaltProject()
	 * @generated
	 */
	int SALT_PROJECT = 0;

	/**
	 * The feature id for the '<em><b>SStereotypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_PROJECT__SSTEREOTYPES = SaltPackage.SPROJECT__SSTEREOTYPES;

	/**
	 * The feature id for the '<em><b>SGraphs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_PROJECT__SGRAPHS = SaltPackage.SPROJECT__SGRAPHS;

	/**
	 * The feature id for the '<em><b>SStereotype Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_PROJECT__SSTEREOTYPE_CONTAINER = SaltPackage.SPROJECT__SSTEREOTYPE_CONTAINER;

	/**
	 * The feature id for the '<em><b>SCorpus Graphs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_PROJECT__SCORPUS_GRAPHS = SaltPackage.SPROJECT__SCORPUS_GRAPHS;

	/**
	 * The feature id for the '<em><b>Salt Graphs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_PROJECT__SALT_GRAPHS = SaltPackage.SPROJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SModules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_PROJECT__SMODULES = SaltPackage.SPROJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Salt Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_PROJECT_FEATURE_COUNT = SaltPackage.SPROJECT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.corpling.salt.saltFW.impl.SaltGraphImpl <em>Salt Graph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.saltFW.impl.SaltGraphImpl
	 * @see de.corpling.salt.saltFW.impl.SaltFWPackageImpl#getSaltGraph()
	 * @generated
	 */
	int SALT_GRAPH = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_GRAPH__ID = SaltPackage.SCORPUS_GRAPH__ID;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_GRAPH__LABELS = SaltPackage.SCORPUS_GRAPH__LABELS;

	/**
	 * The feature id for the '<em><b>Num Of Labels</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_GRAPH__NUM_OF_LABELS = SaltPackage.SCORPUS_GRAPH__NUM_OF_LABELS;

	/**
	 * The feature id for the '<em><b>Indexes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_GRAPH__INDEXES = SaltPackage.SCORPUS_GRAPH__INDEXES;

	/**
	 * The feature id for the '<em><b>Num Of Indexes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_GRAPH__NUM_OF_INDEXES = SaltPackage.SCORPUS_GRAPH__NUM_OF_INDEXES;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_GRAPH__NODES = SaltPackage.SCORPUS_GRAPH__NODES;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_GRAPH__EDGES = SaltPackage.SCORPUS_GRAPH__EDGES;

	/**
	 * The feature id for the '<em><b>Num Of Nodes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_GRAPH__NUM_OF_NODES = SaltPackage.SCORPUS_GRAPH__NUM_OF_NODES;

	/**
	 * The feature id for the '<em><b>Num Of Edges</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_GRAPH__NUM_OF_EDGES = SaltPackage.SCORPUS_GRAPH__NUM_OF_EDGES;

	/**
	 * The feature id for the '<em><b>Labelable Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_GRAPH__LABELABLE_ELEMENT = SaltPackage.SCORPUS_GRAPH__LABELABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Index Mgr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_GRAPH__INDEX_MGR = SaltPackage.SCORPUS_GRAPH__INDEX_MGR;

	/**
	 * The feature id for the '<em><b>SElements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_GRAPH__SELEMENTS = SaltPackage.SCORPUS_GRAPH__SELEMENTS;

	/**
	 * The feature id for the '<em><b>SRelations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_GRAPH__SRELATIONS = SaltPackage.SCORPUS_GRAPH__SRELATIONS;

	/**
	 * The feature id for the '<em><b>SCore Project</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_GRAPH__SCORE_PROJECT = SaltPackage.SCORPUS_GRAPH__SCORE_PROJECT;

	/**
	 * The feature id for the '<em><b>SCorpora</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_GRAPH__SCORPORA = SaltPackage.SCORPUS_GRAPH__SCORPORA;

	/**
	 * The feature id for the '<em><b>SDocuments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_GRAPH__SDOCUMENTS = SaltPackage.SCORPUS_GRAPH__SDOCUMENTS;

	/**
	 * The feature id for the '<em><b>SCorpus Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_GRAPH__SCORPUS_RELATIONS = SaltPackage.SCORPUS_GRAPH__SCORPUS_RELATIONS;

	/**
	 * The number of structural features of the '<em>Salt Graph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_GRAPH_FEATURE_COUNT = SaltPackage.SCORPUS_GRAPH_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.corpling.salt.saltFW.impl.SaltModuleImpl <em>Salt Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.saltFW.impl.SaltModuleImpl
	 * @see de.corpling.salt.saltFW.impl.SaltFWPackageImpl#getSaltModule()
	 * @generated
	 */
	int SALT_MODULE = 2;

	/**
	 * The feature id for the '<em><b>Salt Project</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_MODULE__SALT_PROJECT = 0;

	/**
	 * The number of structural features of the '<em>Salt Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_MODULE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.corpling.salt.saltFW.impl.SaltAccessorModuleImpl <em>Salt Accessor Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.corpling.salt.saltFW.impl.SaltAccessorModuleImpl
	 * @see de.corpling.salt.saltFW.impl.SaltFWPackageImpl#getSaltAccessorModule()
	 * @generated
	 */
	int SALT_ACCESSOR_MODULE = 3;

	/**
	 * The feature id for the '<em><b>Salt Project</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_ACCESSOR_MODULE__SALT_PROJECT = SALT_MODULE__SALT_PROJECT;

	/**
	 * The number of structural features of the '<em>Salt Accessor Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SALT_ACCESSOR_MODULE_FEATURE_COUNT = SALT_MODULE_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link de.corpling.salt.saltFW.SaltProject <em>Salt Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Salt Project</em>'.
	 * @see de.corpling.salt.saltFW.SaltProject
	 * @generated
	 */
	EClass getSaltProject();

	/**
	 * Returns the meta object for the containment reference list '{@link de.corpling.salt.saltFW.SaltProject#getSaltGraphs <em>Salt Graphs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Salt Graphs</em>'.
	 * @see de.corpling.salt.saltFW.SaltProject#getSaltGraphs()
	 * @see #getSaltProject()
	 * @generated
	 */
	EReference getSaltProject_SaltGraphs();

	/**
	 * Returns the meta object for the containment reference list '{@link de.corpling.salt.saltFW.SaltProject#getSModules <em>SModules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SModules</em>'.
	 * @see de.corpling.salt.saltFW.SaltProject#getSModules()
	 * @see #getSaltProject()
	 * @generated
	 */
	EReference getSaltProject_SModules();

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.saltFW.SaltGraph <em>Salt Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Salt Graph</em>'.
	 * @see de.corpling.salt.saltFW.SaltGraph
	 * @generated
	 */
	EClass getSaltGraph();

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.saltFW.SaltModule <em>Salt Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Salt Module</em>'.
	 * @see de.corpling.salt.saltFW.SaltModule
	 * @generated
	 */
	EClass getSaltModule();

	/**
	 * Returns the meta object for the container reference '{@link de.corpling.salt.saltFW.SaltModule#getSaltProject <em>Salt Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Salt Project</em>'.
	 * @see de.corpling.salt.saltFW.SaltModule#getSaltProject()
	 * @see #getSaltModule()
	 * @generated
	 */
	EReference getSaltModule_SaltProject();

	/**
	 * Returns the meta object for class '{@link de.corpling.salt.saltFW.SaltAccessorModule <em>Salt Accessor Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Salt Accessor Module</em>'.
	 * @see de.corpling.salt.saltFW.SaltAccessorModule
	 * @generated
	 */
	EClass getSaltAccessorModule();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SaltFWFactory getSaltFWFactory();

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
		 * The meta object literal for the '{@link de.corpling.salt.saltFW.impl.SaltProjectImpl <em>Salt Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.saltFW.impl.SaltProjectImpl
		 * @see de.corpling.salt.saltFW.impl.SaltFWPackageImpl#getSaltProject()
		 * @generated
		 */
		EClass SALT_PROJECT = eINSTANCE.getSaltProject();

		/**
		 * The meta object literal for the '<em><b>Salt Graphs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SALT_PROJECT__SALT_GRAPHS = eINSTANCE.getSaltProject_SaltGraphs();

		/**
		 * The meta object literal for the '<em><b>SModules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SALT_PROJECT__SMODULES = eINSTANCE.getSaltProject_SModules();

		/**
		 * The meta object literal for the '{@link de.corpling.salt.saltFW.impl.SaltGraphImpl <em>Salt Graph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.saltFW.impl.SaltGraphImpl
		 * @see de.corpling.salt.saltFW.impl.SaltFWPackageImpl#getSaltGraph()
		 * @generated
		 */
		EClass SALT_GRAPH = eINSTANCE.getSaltGraph();

		/**
		 * The meta object literal for the '{@link de.corpling.salt.saltFW.impl.SaltModuleImpl <em>Salt Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.saltFW.impl.SaltModuleImpl
		 * @see de.corpling.salt.saltFW.impl.SaltFWPackageImpl#getSaltModule()
		 * @generated
		 */
		EClass SALT_MODULE = eINSTANCE.getSaltModule();

		/**
		 * The meta object literal for the '<em><b>Salt Project</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SALT_MODULE__SALT_PROJECT = eINSTANCE.getSaltModule_SaltProject();

		/**
		 * The meta object literal for the '{@link de.corpling.salt.saltFW.impl.SaltAccessorModuleImpl <em>Salt Accessor Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.corpling.salt.saltFW.impl.SaltAccessorModuleImpl
		 * @see de.corpling.salt.saltFW.impl.SaltFWPackageImpl#getSaltAccessorModule()
		 * @generated
		 */
		EClass SALT_ACCESSOR_MODULE = eINSTANCE.getSaltAccessorModule();

	}

} //SaltFWPackage
