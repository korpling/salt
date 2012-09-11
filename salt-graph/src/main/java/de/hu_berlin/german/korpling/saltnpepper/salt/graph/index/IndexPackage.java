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
package de.hu_berlin.german.korpling.saltnpepper.salt.graph.index;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GraphPackage;

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
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexFactory
 * @model kind="package"
 * @generated
 */
public interface IndexPackage extends EPackage {
	/**
     * The package name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNAME = "index";

	/**
     * The package namespace URI.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_URI = "index";

	/**
     * The package namespace name.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	String eNS_PREFIX = "index";

	/**
     * The singleton instance of the package.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	IndexPackage eINSTANCE = de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.IndexPackageImpl.init();

	/**
     * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index <em>Index</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.IndexPackageImpl#getIndex()
     * @generated
     */
	int INDEX = 0;

	/**
     * The feature id for the '<em><b>Labels</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INDEX__LABELS = GraphPackage.IDENTIFIABLE_ELEMENT__LABELS;

	/**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INDEX__ID = GraphPackage.IDENTIFIABLE_ELEMENT__ID;

	/**
     * The feature id for the '<em><b>Identifier</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INDEX__IDENTIFIER = GraphPackage.IDENTIFIABLE_ELEMENT__IDENTIFIER;

	/**
     * The feature id for the '<em><b>Num Of Elements</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INDEX__NUM_OF_ELEMENTS = GraphPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Index</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INDEX_FEATURE_COUNT = GraphPackage.IDENTIFIABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.SimpleIndexImpl <em>Simple Index</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.SimpleIndexImpl
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.IndexPackageImpl#getSimpleIndex()
     * @generated
     */
	int SIMPLE_INDEX = 1;

	/**
     * The feature id for the '<em><b>Labels</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIMPLE_INDEX__LABELS = INDEX__LABELS;

	/**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIMPLE_INDEX__ID = INDEX__ID;

	/**
     * The feature id for the '<em><b>Identifier</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIMPLE_INDEX__IDENTIFIER = INDEX__IDENTIFIER;

	/**
     * The feature id for the '<em><b>Num Of Elements</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIMPLE_INDEX__NUM_OF_ELEMENTS = INDEX__NUM_OF_ELEMENTS;

	/**
     * The feature id for the '<em><b>Idx Table</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIMPLE_INDEX__IDX_TABLE = INDEX_FEATURE_COUNT + 0;

	/**
     * The number of structural features of the '<em>Simple Index</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int SIMPLE_INDEX_FEATURE_COUNT = INDEX_FEATURE_COUNT + 1;

	/**
     * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.IndexMgrImpl <em>Mgr</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.IndexMgrImpl
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.IndexPackageImpl#getIndexMgr()
     * @generated
     */
	int INDEX_MGR = 2;

	/**
     * The feature id for the '<em><b>Indexes</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INDEX_MGR__INDEXES = 0;

	/**
     * The feature id for the '<em><b>Num Of Indexes</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INDEX_MGR__NUM_OF_INDEXES = 1;

	/**
     * The feature id for the '<em><b>Graph</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INDEX_MGR__GRAPH = 2;

	/**
     * The number of structural features of the '<em>Mgr</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int INDEX_MGR_FEATURE_COUNT = 3;


	/**
     * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.ComplexIndexImpl <em>Complex Index</em>}' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.ComplexIndexImpl
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.IndexPackageImpl#getComplexIndex()
     * @generated
     */
	int COMPLEX_INDEX = 3;

	/**
     * The feature id for the '<em><b>Labels</b></em>' containment reference list.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COMPLEX_INDEX__LABELS = INDEX__LABELS;

	/**
     * The feature id for the '<em><b>Id</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COMPLEX_INDEX__ID = INDEX__ID;

	/**
     * The feature id for the '<em><b>Identifier</b></em>' reference.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COMPLEX_INDEX__IDENTIFIER = INDEX__IDENTIFIER;

	/**
     * The feature id for the '<em><b>Num Of Elements</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COMPLEX_INDEX__NUM_OF_ELEMENTS = INDEX__NUM_OF_ELEMENTS;

	/**
     * The feature id for the '<em><b>Num Of Slots</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COMPLEX_INDEX__NUM_OF_SLOTS = INDEX_FEATURE_COUNT + 0;

	/**
     * The feature id for the '<em><b>Idx Table</b></em>' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COMPLEX_INDEX__IDX_TABLE = INDEX_FEATURE_COUNT + 1;

	/**
     * The feature id for the '<em><b>Sortable</b></em>' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    int COMPLEX_INDEX__SORTABLE = INDEX_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Complex Index</em>' class.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
	int COMPLEX_INDEX_FEATURE_COUNT = INDEX_FEATURE_COUNT + 3;


	/**
     * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index <em>Index</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Index</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index
     * @generated
     */
	EClass getIndex();

	/**
     * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index#getNumOfElements <em>Num Of Elements</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Num Of Elements</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index#getNumOfElements()
     * @see #getIndex()
     * @generated
     */
	EAttribute getIndex_NumOfElements();

	/**
     * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.SimpleIndex <em>Simple Index</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Simple Index</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.SimpleIndex
     * @generated
     */
	EClass getSimpleIndex();

	/**
     * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.SimpleIndex#getIdxTable <em>Idx Table</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Idx Table</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.SimpleIndex#getIdxTable()
     * @see #getSimpleIndex()
     * @generated
     */
	EAttribute getSimpleIndex_IdxTable();

	/**
     * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr <em>Mgr</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Mgr</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr
     * @generated
     */
	EClass getIndexMgr();

	/**
     * Returns the meta object for the containment reference list '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr#getIndexes <em>Indexes</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the containment reference list '<em>Indexes</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr#getIndexes()
     * @see #getIndexMgr()
     * @generated
     */
	EReference getIndexMgr_Indexes();

	/**
     * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr#getNumOfIndexes <em>Num Of Indexes</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Num Of Indexes</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr#getNumOfIndexes()
     * @see #getIndexMgr()
     * @generated
     */
	EAttribute getIndexMgr_NumOfIndexes();

	/**
     * Returns the meta object for the reference '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr#getGraph <em>Graph</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the reference '<em>Graph</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.IndexMgr#getGraph()
     * @see #getIndexMgr()
     * @generated
     */
	EReference getIndexMgr_Graph();

	/**
     * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.ComplexIndex <em>Complex Index</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for class '<em>Complex Index</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.ComplexIndex
     * @generated
     */
	EClass getComplexIndex();

	/**
     * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.ComplexIndex#getNumOfSlots <em>Num Of Slots</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Num Of Slots</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.ComplexIndex#getNumOfSlots()
     * @see #getComplexIndex()
     * @generated
     */
	EAttribute getComplexIndex_NumOfSlots();

	/**
     * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.ComplexIndex#getIdxTable <em>Idx Table</em>}'.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Idx Table</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.ComplexIndex#getIdxTable()
     * @see #getComplexIndex()
     * @generated
     */
	EAttribute getComplexIndex_IdxTable();

	/**
     * Returns the meta object for the attribute '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.ComplexIndex#isSortable <em>Sortable</em>}'.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @return the meta object for the attribute '<em>Sortable</em>'.
     * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.ComplexIndex#isSortable()
     * @see #getComplexIndex()
     * @generated
     */
    EAttribute getComplexIndex_Sortable();

    /**
     * Returns the factory that creates the instances of the model.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the factory that creates the instances of the model.
     * @generated
     */
	IndexFactory getIndexFactory();

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
         * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index <em>Index</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.Index
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.IndexPackageImpl#getIndex()
         * @generated
         */
		EClass INDEX = eINSTANCE.getIndex();

		/**
         * The meta object literal for the '<em><b>Num Of Elements</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute INDEX__NUM_OF_ELEMENTS = eINSTANCE.getIndex_NumOfElements();

		/**
         * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.SimpleIndexImpl <em>Simple Index</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.SimpleIndexImpl
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.IndexPackageImpl#getSimpleIndex()
         * @generated
         */
		EClass SIMPLE_INDEX = eINSTANCE.getSimpleIndex();

		/**
         * The meta object literal for the '<em><b>Idx Table</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute SIMPLE_INDEX__IDX_TABLE = eINSTANCE.getSimpleIndex_IdxTable();

		/**
         * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.IndexMgrImpl <em>Mgr</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.IndexMgrImpl
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.IndexPackageImpl#getIndexMgr()
         * @generated
         */
		EClass INDEX_MGR = eINSTANCE.getIndexMgr();

		/**
         * The meta object literal for the '<em><b>Indexes</b></em>' containment reference list feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference INDEX_MGR__INDEXES = eINSTANCE.getIndexMgr_Indexes();

		/**
         * The meta object literal for the '<em><b>Num Of Indexes</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute INDEX_MGR__NUM_OF_INDEXES = eINSTANCE.getIndexMgr_NumOfIndexes();

		/**
         * The meta object literal for the '<em><b>Graph</b></em>' reference feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EReference INDEX_MGR__GRAPH = eINSTANCE.getIndexMgr_Graph();

		/**
         * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.ComplexIndexImpl <em>Complex Index</em>}' class.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.ComplexIndexImpl
         * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl.IndexPackageImpl#getComplexIndex()
         * @generated
         */
		EClass COMPLEX_INDEX = eINSTANCE.getComplexIndex();

		/**
         * The meta object literal for the '<em><b>Num Of Slots</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute COMPLEX_INDEX__NUM_OF_SLOTS = eINSTANCE.getComplexIndex_NumOfSlots();

		/**
         * The meta object literal for the '<em><b>Idx Table</b></em>' attribute feature.
         * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
         * @generated
         */
		EAttribute COMPLEX_INDEX__IDX_TABLE = eINSTANCE.getComplexIndex_IdxTable();

        /**
         * The meta object literal for the '<em><b>Sortable</b></em>' attribute feature.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        EAttribute COMPLEX_INDEX__SORTABLE = eINSTANCE.getComplexIndex_Sortable();

	}

} //IndexPackage
