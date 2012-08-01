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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonPackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.impl.SaltCommonPackageImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SCorpusStructurePackageImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDSRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDataSource;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructureFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SOrderRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructuredNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextOverlappingRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeOverlappingRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeline;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimelineRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SDocumentStructurePackageImpl extends EPackageImpl implements SDocumentStructurePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sDocumentGraphEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sTextualDSEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sTokenEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sTextualRelationEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sSequentialRelationEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sSequentialDSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sTimelineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sTimelineRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sSpanEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sSpanningRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sTextOverlappingRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sTimeOverlappingRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sStructuredNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sStructureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sPointingRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sDominanceRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sDataSourceSequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sAudioDataSourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sAudioDSRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sOrderRelationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sfeaturE_NAMESEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum stypE_NAMEEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SDocumentStructurePackageImpl() {
		super(eNS_URI, SDocumentStructureFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link SDocumentStructurePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SDocumentStructurePackage init() {
		if (isInited) return (SDocumentStructurePackage)EPackage.Registry.INSTANCE.getEPackage(SDocumentStructurePackage.eNS_URI);

		// Obtain or create and register package
		SDocumentStructurePackageImpl theSDocumentStructurePackage = (SDocumentStructurePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SDocumentStructurePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SDocumentStructurePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		SaltCorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		SaltCommonPackageImpl theSaltCommonPackage = (SaltCommonPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SaltCommonPackage.eNS_URI) instanceof SaltCommonPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SaltCommonPackage.eNS_URI) : SaltCommonPackage.eINSTANCE);
		SCorpusStructurePackageImpl theSCorpusStructurePackage = (SCorpusStructurePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SCorpusStructurePackage.eNS_URI) instanceof SCorpusStructurePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SCorpusStructurePackage.eNS_URI) : SCorpusStructurePackage.eINSTANCE);

		// Create package meta-data objects
		theSDocumentStructurePackage.createPackageContents();
		theSaltCommonPackage.createPackageContents();
		theSCorpusStructurePackage.createPackageContents();

		// Initialize created meta-data
		theSDocumentStructurePackage.initializePackageContents();
		theSaltCommonPackage.initializePackageContents();
		theSCorpusStructurePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSDocumentStructurePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SDocumentStructurePackage.eNS_URI, theSDocumentStructurePackage);
		return theSDocumentStructurePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSDocumentGraph() {
		return sDocumentGraphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDocumentGraph_SDocument() {
		return (EReference)sDocumentGraphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDocumentGraph_STextualDSs() {
		return (EReference)sDocumentGraphEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDocumentGraph_STextualRelations() {
		return (EReference)sDocumentGraphEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDocumentGraph_STokens() {
		return (EReference)sDocumentGraphEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDocumentGraph_STimeline() {
		return (EReference)sDocumentGraphEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDocumentGraph_STimelineRelations() {
		return (EReference)sDocumentGraphEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDocumentGraph_SSpanningRelations() {
		return (EReference)sDocumentGraphEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDocumentGraph_SSpans() {
		return (EReference)sDocumentGraphEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDocumentGraph_SStructures() {
		return (EReference)sDocumentGraphEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDocumentGraph_SDominanceRelations() {
		return (EReference)sDocumentGraphEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDocumentGraph_SPointingRelations() {
		return (EReference)sDocumentGraphEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDocumentGraph_SAudioDSRelations() {
		return (EReference)sDocumentGraphEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDocumentGraph_SAudioDataSources() {
		return (EReference)sDocumentGraphEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDocumentGraph_SOrderRelations() {
		return (EReference)sDocumentGraphEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSTextualDS() {
		return sTextualDSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSTextualDS_SText() {
		return (EAttribute)sTextualDSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSTextualDS_SDocumentGraph() {
		return (EReference)sTextualDSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSToken() {
		return sTokenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSToken_SDocumentGraph() {
		return (EReference)sTokenEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSTextualRelation() {
		return sTextualRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSTextualRelation_SToken() {
		return (EReference)sTextualRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSTextualRelation_STextualDS() {
		return (EReference)sTextualRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSTextualRelation_SDocumentGraph() {
		return (EReference)sTextualRelationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSSequentialRelation() {
		return sSequentialRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSSequentialRelation_SStart() {
		return (EAttribute)sSequentialRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSSequentialRelation_SEnd() {
		return (EAttribute)sSequentialRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSSequentialDS() {
		return sSequentialDSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSSequentialDS_SData() {
		return (EAttribute)sSequentialDSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSSequentialDS_SStart() {
		return (EAttribute)sSequentialDSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSSequentialDS_SEnd() {
		return (EAttribute)sSequentialDSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSTimeline() {
		return sTimelineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSTimeline_SPointsOfTime() {
		return (EAttribute)sTimelineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSTimeline_SDocumentGraph() {
		return (EReference)sTimelineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSTimelineRelation() {
		return sTimelineRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSTimelineRelation_STimeline() {
		return (EReference)sTimelineRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSTimelineRelation_SToken() {
		return (EReference)sTimelineRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSTimelineRelation_SDocumentGraph() {
		return (EReference)sTimelineRelationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSSpan() {
		return sSpanEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSSpan_SDocumentGraph() {
		return (EReference)sSpanEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSSpanningRelation() {
		return sSpanningRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSSpanningRelation_SToken() {
		return (EReference)sSpanningRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSSpanningRelation_SSpan() {
		return (EReference)sSpanningRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSSpanningRelation_SDocumentGraph() {
		return (EReference)sSpanningRelationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSTextOverlappingRelation() {
		return sTextOverlappingRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSTimeOverlappingRelation() {
		return sTimeOverlappingRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSStructuredNode() {
		return sStructuredNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSStructure() {
		return sStructureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSStructure_SDocumentGraph() {
		return (EReference)sStructureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSPointingRelation() {
		return sPointingRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSPointingRelation_SStructuredSource() {
		return (EReference)sPointingRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSPointingRelation_SStructuredTarget() {
		return (EReference)sPointingRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSPointingRelation_SDocumentGraph() {
		return (EReference)sPointingRelationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSDominanceRelation() {
		return sDominanceRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDominanceRelation_SStructure() {
		return (EReference)sDominanceRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDominanceRelation_SStructuredTarget() {
		return (EReference)sDominanceRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDominanceRelation_SDocumentGraph() {
		return (EReference)sDominanceRelationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSDataSourceSequence() {
		return sDataSourceSequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSDataSourceSequence_SStart() {
		return (EAttribute)sDataSourceSequenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSDataSourceSequence_SEnd() {
		return (EAttribute)sDataSourceSequenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSDataSourceSequence_SSequentialDS() {
		return (EReference)sDataSourceSequenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSAudioDataSource() {
		return sAudioDataSourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSAudioDataSource_SDocumentGraph() {
		return (EReference)sAudioDataSourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSAudioDataSource_SAudioReference() {
		return (EAttribute)sAudioDataSourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSAudioDSRelation() {
		return sAudioDSRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSAudioDSRelation_SStart() {
		return (EAttribute)sAudioDSRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSAudioDSRelation_SEnd() {
		return (EAttribute)sAudioDSRelationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSAudioDSRelation_SToken() {
		return (EReference)sAudioDSRelationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSAudioDSRelation_SAudioDS() {
		return (EReference)sAudioDSRelationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSAudioDSRelation_SDocumentGraph() {
		return (EReference)sAudioDSRelationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSOrderRelation() {
		return sOrderRelationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSOrderRelation_SDocumentGraph() {
		return (EReference)sOrderRelationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSFEATURE_NAMES() {
		return sfeaturE_NAMESEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSTYPE_NAME() {
		return stypE_NAMEEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDocumentStructureFactory getSDocumentStructureFactory() {
		return (SDocumentStructureFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		sDocumentGraphEClass = createEClass(SDOCUMENT_GRAPH);
		createEReference(sDocumentGraphEClass, SDOCUMENT_GRAPH__SDOCUMENT);
		createEReference(sDocumentGraphEClass, SDOCUMENT_GRAPH__STEXTUAL_DSS);
		createEReference(sDocumentGraphEClass, SDOCUMENT_GRAPH__STEXTUAL_RELATIONS);
		createEReference(sDocumentGraphEClass, SDOCUMENT_GRAPH__STOKENS);
		createEReference(sDocumentGraphEClass, SDOCUMENT_GRAPH__STIMELINE);
		createEReference(sDocumentGraphEClass, SDOCUMENT_GRAPH__STIMELINE_RELATIONS);
		createEReference(sDocumentGraphEClass, SDOCUMENT_GRAPH__SSPANNING_RELATIONS);
		createEReference(sDocumentGraphEClass, SDOCUMENT_GRAPH__SSPANS);
		createEReference(sDocumentGraphEClass, SDOCUMENT_GRAPH__SSTRUCTURES);
		createEReference(sDocumentGraphEClass, SDOCUMENT_GRAPH__SDOMINANCE_RELATIONS);
		createEReference(sDocumentGraphEClass, SDOCUMENT_GRAPH__SPOINTING_RELATIONS);
		createEReference(sDocumentGraphEClass, SDOCUMENT_GRAPH__SAUDIO_DS_RELATIONS);
		createEReference(sDocumentGraphEClass, SDOCUMENT_GRAPH__SAUDIO_DATA_SOURCES);
		createEReference(sDocumentGraphEClass, SDOCUMENT_GRAPH__SORDER_RELATIONS);

		sTextualDSEClass = createEClass(STEXTUAL_DS);
		createEAttribute(sTextualDSEClass, STEXTUAL_DS__STEXT);
		createEReference(sTextualDSEClass, STEXTUAL_DS__SDOCUMENT_GRAPH);

		sTokenEClass = createEClass(STOKEN);
		createEReference(sTokenEClass, STOKEN__SDOCUMENT_GRAPH);

		sTextualRelationEClass = createEClass(STEXTUAL_RELATION);
		createEReference(sTextualRelationEClass, STEXTUAL_RELATION__STOKEN);
		createEReference(sTextualRelationEClass, STEXTUAL_RELATION__STEXTUAL_DS);
		createEReference(sTextualRelationEClass, STEXTUAL_RELATION__SDOCUMENT_GRAPH);

		sSequentialRelationEClass = createEClass(SSEQUENTIAL_RELATION);
		createEAttribute(sSequentialRelationEClass, SSEQUENTIAL_RELATION__SSTART);
		createEAttribute(sSequentialRelationEClass, SSEQUENTIAL_RELATION__SEND);

		sSequentialDSEClass = createEClass(SSEQUENTIAL_DS);
		createEAttribute(sSequentialDSEClass, SSEQUENTIAL_DS__SDATA);
		createEAttribute(sSequentialDSEClass, SSEQUENTIAL_DS__SSTART);
		createEAttribute(sSequentialDSEClass, SSEQUENTIAL_DS__SEND);

		sTimelineEClass = createEClass(STIMELINE);
		createEReference(sTimelineEClass, STIMELINE__SDOCUMENT_GRAPH);
		createEAttribute(sTimelineEClass, STIMELINE__SPOINTS_OF_TIME);

		sTimelineRelationEClass = createEClass(STIMELINE_RELATION);
		createEReference(sTimelineRelationEClass, STIMELINE_RELATION__STIMELINE);
		createEReference(sTimelineRelationEClass, STIMELINE_RELATION__STOKEN);
		createEReference(sTimelineRelationEClass, STIMELINE_RELATION__SDOCUMENT_GRAPH);

		sSpanEClass = createEClass(SSPAN);
		createEReference(sSpanEClass, SSPAN__SDOCUMENT_GRAPH);

		sSpanningRelationEClass = createEClass(SSPANNING_RELATION);
		createEReference(sSpanningRelationEClass, SSPANNING_RELATION__STOKEN);
		createEReference(sSpanningRelationEClass, SSPANNING_RELATION__SSPAN);
		createEReference(sSpanningRelationEClass, SSPANNING_RELATION__SDOCUMENT_GRAPH);

		sTextOverlappingRelationEClass = createEClass(STEXT_OVERLAPPING_RELATION);

		sTimeOverlappingRelationEClass = createEClass(STIME_OVERLAPPING_RELATION);

		sStructuredNodeEClass = createEClass(SSTRUCTURED_NODE);

		sStructureEClass = createEClass(SSTRUCTURE);
		createEReference(sStructureEClass, SSTRUCTURE__SDOCUMENT_GRAPH);

		sPointingRelationEClass = createEClass(SPOINTING_RELATION);
		createEReference(sPointingRelationEClass, SPOINTING_RELATION__SSTRUCTURED_SOURCE);
		createEReference(sPointingRelationEClass, SPOINTING_RELATION__SSTRUCTURED_TARGET);
		createEReference(sPointingRelationEClass, SPOINTING_RELATION__SDOCUMENT_GRAPH);

		sDominanceRelationEClass = createEClass(SDOMINANCE_RELATION);
		createEReference(sDominanceRelationEClass, SDOMINANCE_RELATION__SSTRUCTURE);
		createEReference(sDominanceRelationEClass, SDOMINANCE_RELATION__SSTRUCTURED_TARGET);
		createEReference(sDominanceRelationEClass, SDOMINANCE_RELATION__SDOCUMENT_GRAPH);

		sDataSourceSequenceEClass = createEClass(SDATA_SOURCE_SEQUENCE);
		createEAttribute(sDataSourceSequenceEClass, SDATA_SOURCE_SEQUENCE__SSTART);
		createEAttribute(sDataSourceSequenceEClass, SDATA_SOURCE_SEQUENCE__SEND);
		createEReference(sDataSourceSequenceEClass, SDATA_SOURCE_SEQUENCE__SSEQUENTIAL_DS);

		sAudioDataSourceEClass = createEClass(SAUDIO_DATA_SOURCE);
		createEReference(sAudioDataSourceEClass, SAUDIO_DATA_SOURCE__SDOCUMENT_GRAPH);
		createEAttribute(sAudioDataSourceEClass, SAUDIO_DATA_SOURCE__SAUDIO_REFERENCE);

		sAudioDSRelationEClass = createEClass(SAUDIO_DS_RELATION);
		createEAttribute(sAudioDSRelationEClass, SAUDIO_DS_RELATION__SSTART);
		createEAttribute(sAudioDSRelationEClass, SAUDIO_DS_RELATION__SEND);
		createEReference(sAudioDSRelationEClass, SAUDIO_DS_RELATION__STOKEN);
		createEReference(sAudioDSRelationEClass, SAUDIO_DS_RELATION__SAUDIO_DS);
		createEReference(sAudioDSRelationEClass, SAUDIO_DS_RELATION__SDOCUMENT_GRAPH);

		sOrderRelationEClass = createEClass(SORDER_RELATION);
		createEReference(sOrderRelationEClass, SORDER_RELATION__SDOCUMENT_GRAPH);

		// Create enums
		sfeaturE_NAMESEEnum = createEEnum(SFEATURE_NAMES);
		stypE_NAMEEEnum = createEEnum(STYPE_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		SaltCorePackage theSaltCorePackage = (SaltCorePackage)EPackage.Registry.INSTANCE.getEPackage(SaltCorePackage.eNS_URI);
		SCorpusStructurePackage theSCorpusStructurePackage = (SCorpusStructurePackage)EPackage.Registry.INSTANCE.getEPackage(SCorpusStructurePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		sDocumentGraphEClass.getESuperTypes().add(theSaltCorePackage.getSGraph());
		sTextualDSEClass.getESuperTypes().add(this.getSSequentialDS());
		sTokenEClass.getESuperTypes().add(this.getSStructuredNode());
		sTextualRelationEClass.getESuperTypes().add(this.getSSequentialRelation());
		sTextualRelationEClass.getESuperTypes().add(this.getSTextOverlappingRelation());
		sSequentialRelationEClass.getESuperTypes().add(theSaltCorePackage.getSRelation());
		sSequentialDSEClass.getESuperTypes().add(theSaltCorePackage.getSNode());
		sTimelineEClass.getESuperTypes().add(this.getSSequentialDS());
		sTimelineRelationEClass.getESuperTypes().add(this.getSSequentialRelation());
		sTimelineRelationEClass.getESuperTypes().add(this.getSTimeOverlappingRelation());
		sSpanEClass.getESuperTypes().add(this.getSStructuredNode());
		sSpanningRelationEClass.getESuperTypes().add(theSaltCorePackage.getSRelation());
		sSpanningRelationEClass.getESuperTypes().add(this.getSTextOverlappingRelation());
		sSpanningRelationEClass.getESuperTypes().add(this.getSTimeOverlappingRelation());
		sTextOverlappingRelationEClass.getESuperTypes().add(theSaltCorePackage.getSRelation());
		sTimeOverlappingRelationEClass.getESuperTypes().add(theSaltCorePackage.getSRelation());
		sStructuredNodeEClass.getESuperTypes().add(theSaltCorePackage.getSNode());
		sStructureEClass.getESuperTypes().add(this.getSStructuredNode());
		sPointingRelationEClass.getESuperTypes().add(theSaltCorePackage.getSRelation());
		sDominanceRelationEClass.getESuperTypes().add(this.getSTextOverlappingRelation());
		sDominanceRelationEClass.getESuperTypes().add(this.getSTimeOverlappingRelation());
		sAudioDataSourceEClass.getESuperTypes().add(this.getSSequentialDS());
		sAudioDSRelationEClass.getESuperTypes().add(theSaltCorePackage.getSRelation());
		sOrderRelationEClass.getESuperTypes().add(theSaltCorePackage.getSRelation());

		// Initialize classes and features; add operations and parameters
		initEClass(sDocumentGraphEClass, SDocumentGraph.class, "SDocumentGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSDocumentGraph_SDocument(), theSCorpusStructurePackage.getSDocument(), theSCorpusStructurePackage.getSDocument_SDocumentGraph(), "sDocument", null, 0, 1, SDocumentGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSDocumentGraph_STextualDSs(), this.getSTextualDS(), this.getSTextualDS_SDocumentGraph(), "sTextualDSs", null, 0, -1, SDocumentGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSDocumentGraph_STextualRelations(), this.getSTextualRelation(), this.getSTextualRelation_SDocumentGraph(), "sTextualRelations", null, 0, -1, SDocumentGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSDocumentGraph_STokens(), this.getSToken(), this.getSToken_SDocumentGraph(), "sTokens", null, 0, -1, SDocumentGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSDocumentGraph_STimeline(), this.getSTimeline(), this.getSTimeline_SDocumentGraph(), "sTimeline", null, 0, 1, SDocumentGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSDocumentGraph_STimelineRelations(), this.getSTimelineRelation(), this.getSTimelineRelation_SDocumentGraph(), "sTimelineRelations", null, 0, -1, SDocumentGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSDocumentGraph_SSpanningRelations(), this.getSSpanningRelation(), this.getSSpanningRelation_SDocumentGraph(), "sSpanningRelations", null, 0, -1, SDocumentGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSDocumentGraph_SSpans(), this.getSSpan(), this.getSSpan_SDocumentGraph(), "sSpans", null, 0, -1, SDocumentGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSDocumentGraph_SStructures(), this.getSStructure(), this.getSStructure_SDocumentGraph(), "sStructures", null, 0, -1, SDocumentGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSDocumentGraph_SDominanceRelations(), this.getSDominanceRelation(), this.getSDominanceRelation_SDocumentGraph(), "sDominanceRelations", null, 0, -1, SDocumentGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSDocumentGraph_SPointingRelations(), this.getSPointingRelation(), this.getSPointingRelation_SDocumentGraph(), "sPointingRelations", null, 0, -1, SDocumentGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSDocumentGraph_SAudioDSRelations(), this.getSAudioDSRelation(), this.getSAudioDSRelation_SDocumentGraph(), "sAudioDSRelations", null, 0, -1, SDocumentGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSDocumentGraph_SAudioDataSources(), this.getSAudioDataSource(), this.getSAudioDataSource_SDocumentGraph(), "sAudioDataSources", null, 0, -1, SDocumentGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSDocumentGraph_SOrderRelations(), this.getSOrderRelation(), this.getSOrderRelation_SDocumentGraph(), "sOrderRelations", null, 0, -1, SDocumentGraph.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(sDocumentGraphEClass, theSaltCorePackage.getSRelation(), "addSNode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getSNode(), "sourceSNode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getSNode(), "targetSNode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSTYPE_NAME(), "sRelationType", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sDocumentGraphEClass, this.getSSpan(), "getSSpanBySequence", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSDataSourceSequence(), "sequence", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sDocumentGraphEClass, this.getSTextualDS(), "createSTextualDS", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "sText", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sDocumentGraphEClass, this.getSToken(), "createSToken", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSDataSourceSequence(), "sDSSequences", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sDocumentGraphEClass, this.getSToken(), "createSToken", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSDataSourceSequence(), "sDSSequence", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(sDocumentGraphEClass, this.getSTimeline(), "createSTimeline", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sDocumentGraphEClass, this.getSToken(), "getSTokensBySequence", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSDataSourceSequence(), "sequence", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sDocumentGraphEClass, this.getSStructure(), "getSStructureBySequence", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSDataSourceSequence(), "sequence", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sDocumentGraphEClass, theSaltCorePackage.getSNode(), "getSNodeBySequence", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSDataSourceSequence(), "sequence", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sDocumentGraphEClass, this.getSDataSourceSequence(), "getOverlappedDSSequences", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getSNode(), "sNode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSTYPE_NAME(), "sRelationTypes", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sDocumentGraphEClass, this.getSDataSourceSequence(), "getOverlappedDSSequences", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getSNode(), "sNode", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSTYPE_NAME(), "sRelationTypes", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sDocumentGraphEClass, ecorePackage.getEBoolean(), "isContinuousByText", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getSNode(), "subSNodeList", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getSNode(), "fullSNodeList", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sDocumentGraphEClass, ecorePackage.getEBoolean(), "isContinuousByText", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getSNode(), "subSNodeList", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sDocumentGraphEClass, this.getSToken(), "getSortedSTokenByText", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSToken(), "sTokens2sort", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(sDocumentGraphEClass, this.getSToken(), "getSortedSTokenByText", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sDocumentGraphEClass, this.getSSpan(), "createSSpan", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSToken(), "sourceSToken", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sDocumentGraphEClass, this.getSSpan(), "createSSpan", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSToken(), "sTokens", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sDocumentGraphEClass, this.getSStructure(), "createSStructure", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSStructuredNode(), "sourceSNode", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(sDocumentGraphEClass, null, "sortSTokenByText", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sDocumentGraphEClass, this.getSStructure(), "createSStructure", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSStructuredNode(), "sStructures", 0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sDocumentGraphEClass, theSaltCorePackage.getSNode(), "getRootsBySRelation", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSTYPE_NAME(), "sType", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(sDocumentGraphEClass, null, "getRootsBySRelationSType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSTYPE_NAME(), "sType", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEEList());
		g1.getETypeArguments().add(g2);
		EGenericType g3 = createEGenericType(theSaltCorePackage.getSNode());
		g2.getETypeArguments().add(g3);
		initEOperation(op, g1);

		op = addEOperation(sDocumentGraphEClass, this.getSToken(), "createSToken", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSSequentialDS(), "sSequentialDS", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEIntegerObject(), "sStart", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEIntegerObject(), "sEnd", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sTextualDSEClass, STextualDS.class, "STextualDS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSTextualDS_SText(), ecorePackage.getEString(), "sText", null, 0, 1, STextualDS.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSTextualDS_SDocumentGraph(), this.getSDocumentGraph(), this.getSDocumentGraph_STextualDSs(), "sDocumentGraph", null, 0, 1, STextualDS.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sTokenEClass, SToken.class, "SToken", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSToken_SDocumentGraph(), this.getSDocumentGraph(), this.getSDocumentGraph_STokens(), "sDocumentGraph", null, 0, 1, SToken.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sTextualRelationEClass, STextualRelation.class, "STextualRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSTextualRelation_SToken(), this.getSToken(), null, "sToken", null, 0, 1, STextualRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSTextualRelation_STextualDS(), this.getSTextualDS(), null, "sTextualDS", null, 0, 1, STextualRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSTextualRelation_SDocumentGraph(), this.getSDocumentGraph(), this.getSDocumentGraph_STextualRelations(), "sDocumentGraph", null, 0, 1, STextualRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sSequentialRelationEClass, SSequentialRelation.class, "SSequentialRelation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSSequentialRelation_SStart(), ecorePackage.getEIntegerObject(), "sStart", null, 0, 1, SSequentialRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getSSequentialRelation_SEnd(), ecorePackage.getEIntegerObject(), "sEnd", null, 0, 1, SSequentialRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sSequentialDSEClass, SSequentialDS.class, "SSequentialDS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSSequentialDS_SData(), ecorePackage.getEJavaObject(), "sData", null, 0, 1, SSequentialDS.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getSSequentialDS_SStart(), ecorePackage.getEIntegerObject(), "sStart", null, 0, 1, SSequentialDS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getSSequentialDS_SEnd(), ecorePackage.getEIntegerObject(), "sEnd", null, 0, 1, SSequentialDS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sTimelineEClass, STimeline.class, "STimeline", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSTimeline_SDocumentGraph(), this.getSDocumentGraph(), this.getSDocumentGraph_STimeline(), "sDocumentGraph", null, 0, 1, STimeline.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getSTimeline_SPointsOfTime(), ecorePackage.getEString(), "sPointsOfTime", null, 0, -1, STimeline.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		op = addEOperation(sTimelineEClass, null, "addSPointOfTime", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "sPointOfTime", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sTimelineRelationEClass, STimelineRelation.class, "STimelineRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSTimelineRelation_STimeline(), this.getSTimeline(), null, "sTimeline", null, 0, 1, STimelineRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSTimelineRelation_SToken(), this.getSToken(), null, "sToken", null, 0, 1, STimelineRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSTimelineRelation_SDocumentGraph(), this.getSDocumentGraph(), this.getSDocumentGraph_STimelineRelations(), "sDocumentGraph", null, 0, 1, STimelineRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sSpanEClass, SSpan.class, "SSpan", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSSpan_SDocumentGraph(), this.getSDocumentGraph(), this.getSDocumentGraph_SSpans(), "sDocumentGraph", null, 0, 1, SSpan.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sSpanningRelationEClass, SSpanningRelation.class, "SSpanningRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSSpanningRelation_SToken(), this.getSToken(), null, "sToken", null, 0, 1, SSpanningRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSSpanningRelation_SSpan(), this.getSSpan(), null, "sSpan", null, 0, 1, SSpanningRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSSpanningRelation_SDocumentGraph(), this.getSDocumentGraph(), this.getSDocumentGraph_SSpanningRelations(), "sDocumentGraph", null, 0, 1, SSpanningRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sTextOverlappingRelationEClass, STextOverlappingRelation.class, "STextOverlappingRelation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(sTextOverlappingRelationEClass, ecorePackage.getEBooleanObject(), "isSTextOverlapping", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sTimeOverlappingRelationEClass, STimeOverlappingRelation.class, "STimeOverlappingRelation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(sTimeOverlappingRelationEClass, ecorePackage.getEBooleanObject(), "isSTimeOverlapping", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sStructuredNodeEClass, SStructuredNode.class, "SStructuredNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(sStructureEClass, SStructure.class, "SStructure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSStructure_SDocumentGraph(), this.getSDocumentGraph(), this.getSDocumentGraph_SStructures(), "sDocumentGraph", null, 0, 1, SStructure.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sPointingRelationEClass, SPointingRelation.class, "SPointingRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSPointingRelation_SStructuredSource(), this.getSStructuredNode(), null, "SStructuredSource", null, 0, 1, SPointingRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSPointingRelation_SStructuredTarget(), this.getSStructuredNode(), null, "SStructuredTarget", null, 0, 1, SPointingRelation.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSPointingRelation_SDocumentGraph(), this.getSDocumentGraph(), this.getSDocumentGraph_SPointingRelations(), "sDocumentGraph", null, 0, 1, SPointingRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sDominanceRelationEClass, SDominanceRelation.class, "SDominanceRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSDominanceRelation_SStructure(), this.getSStructure(), null, "sStructure", null, 0, 1, SDominanceRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSDominanceRelation_SStructuredTarget(), this.getSStructuredNode(), null, "sStructuredTarget", null, 0, 1, SDominanceRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSDominanceRelation_SDocumentGraph(), this.getSDocumentGraph(), this.getSDocumentGraph_SDominanceRelations(), "sDocumentGraph", null, 0, 1, SDominanceRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sDataSourceSequenceEClass, SDataSourceSequence.class, "SDataSourceSequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSDataSourceSequence_SStart(), ecorePackage.getEIntegerObject(), "sStart", null, 0, 1, SDataSourceSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSDataSourceSequence_SEnd(), ecorePackage.getEIntegerObject(), "sEnd", null, 0, 1, SDataSourceSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSDataSourceSequence_SSequentialDS(), this.getSSequentialDS(), null, "sSequentialDS", null, 0, 1, SDataSourceSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(sDataSourceSequenceEClass, ecorePackage.getEBooleanObject(), "validate", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sAudioDataSourceEClass, SAudioDataSource.class, "SAudioDataSource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSAudioDataSource_SDocumentGraph(), this.getSDocumentGraph(), this.getSDocumentGraph_SAudioDataSources(), "sDocumentGraph", null, 0, 1, SAudioDataSource.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getSAudioDataSource_SAudioReference(), theSaltCorePackage.getURI(), "sAudioReference", null, 0, 1, SAudioDataSource.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sAudioDSRelationEClass, SAudioDSRelation.class, "SAudioDSRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSAudioDSRelation_SStart(), ecorePackage.getEDoubleObject(), "sStart", null, 0, 1, SAudioDSRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getSAudioDSRelation_SEnd(), ecorePackage.getEDoubleObject(), "sEnd", null, 0, 1, SAudioDSRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSAudioDSRelation_SToken(), this.getSToken(), null, "sToken", null, 0, 1, SAudioDSRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSAudioDSRelation_SAudioDS(), this.getSAudioDataSource(), null, "sAudioDS", null, 0, 1, SAudioDSRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getSAudioDSRelation_SDocumentGraph(), this.getSDocumentGraph(), this.getSDocumentGraph_SAudioDSRelations(), "sDocumentGraph", null, 0, 1, SAudioDSRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(sOrderRelationEClass, SOrderRelation.class, "SOrderRelation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSOrderRelation_SDocumentGraph(), this.getSDocumentGraph(), this.getSDocumentGraph_SOrderRelations(), "sDocumentGraph", null, 0, 1, SOrderRelation.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(sfeaturE_NAMESEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SFEATURE_NAMES.class, "SFEATURE_NAMES");
		addEEnumLiteral(sfeaturE_NAMESEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SFEATURE_NAMES.STEXT_OVERLAPPING);
		addEEnumLiteral(sfeaturE_NAMESEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SFEATURE_NAMES.SSTART);
		addEEnumLiteral(sfeaturE_NAMESEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SFEATURE_NAMES.SEND);
		addEEnumLiteral(sfeaturE_NAMESEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SFEATURE_NAMES.STEXT);
		addEEnumLiteral(sfeaturE_NAMESEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SFEATURE_NAMES.SDATA);
		addEEnumLiteral(sfeaturE_NAMESEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SFEATURE_NAMES.STIME_OVERLAPPING);
		addEEnumLiteral(sfeaturE_NAMESEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SFEATURE_NAMES.STYPE_SRELATION);

		initEEnum(stypE_NAMEEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME.class, "STYPE_NAME");
		addEEnumLiteral(stypE_NAMEEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME.STEXTUAL_DS);
		addEEnumLiteral(stypE_NAMEEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME.STOKEN);
		addEEnumLiteral(stypE_NAMEEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME.SSPAN);
		addEEnumLiteral(stypE_NAMEEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME.SSTRUCTURE);
		addEEnumLiteral(stypE_NAMEEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME.STEXTUAL_RELATION);
		addEEnumLiteral(stypE_NAMEEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME.SSPANNING_RELATION);
		addEEnumLiteral(stypE_NAMEEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME.SDOMINANCE_RELATION);
		addEEnumLiteral(stypE_NAMEEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME.SPOINTING_RELATION);
		addEEnumLiteral(stypE_NAMEEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME.STEXT_OVERLAPPING_RELATION);
		addEEnumLiteral(stypE_NAMEEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME.STIME_OVERLAPPING_RELATION);
		addEEnumLiteral(stypE_NAMEEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME.SSEQUENTIAL_RELATION);
		addEEnumLiteral(stypE_NAMEEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STYPE_NAME.SORDER_RELATION);
	}

} //SDocumentStructurePackageImpl
