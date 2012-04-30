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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.impl;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.*;
import java.util.Properties;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusStructureFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDSRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SAudioDataSource;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructureFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeline;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimelineRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SLayer;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNamedElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCoreFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SaltCommonFactoryImpl extends EFactoryImpl implements SaltCommonFactory 
{
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SaltCommonFactory init() {
		try {
			SaltCommonFactory theSaltCommonFactory = (SaltCommonFactory)EPackage.Registry.INSTANCE.getEFactory("saltCommon"); 
			if (theSaltCommonFactory != null) {
				return theSaltCommonFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SaltCommonFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SaltCommonFactoryImpl() {
		super();
		this.initFactory();
	}

	/**
	 * Initializes this object.
	 * For example sets all factory-objects, to realize derived functions in this
	 * class.
	 */
	private void initFactory()
	{
		//initialize all factories
		this.saltCoreFactory= SaltCoreFactory.eINSTANCE;
		this.sCorpusStructureFactory= SCorpusStructureFactory.eINSTANCE;
		this.sDocumentStructureFactory= SDocumentStructureFactory.eINSTANCE;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SaltCommonPackage.SALT_PROJECT: return createSaltProject();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case SaltCommonPackage.PROPERTIES:
				return createPropertiesFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case SaltCommonPackage.PROPERTIES:
				return convertPropertiesToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltProject createSaltProject() {
		SaltProjectImpl saltProject = new SaltProjectImpl();
		return saltProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Properties createPropertiesFromString(EDataType eDataType, String initialValue) {
		return (Properties)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPropertiesToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltCommonPackage getSaltCommonPackage() {
		return (SaltCommonPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SaltCommonPackage getPackage() {
		return SaltCommonPackage.eINSTANCE;
	}
	
	

// ===================================== start: SaltCoreFactory	
	/**
	 * Factory object of SaltCoreFactory. This is necessary to derive all 
	 * functions from SaltCoreFactory. 
	 */
	private SaltCoreFactory saltCoreFactory= null;	
	@Override
	public SAnnotatableElement createSAnnotatableElement() {
		return(this.saltCoreFactory.createSAnnotatableElement());
	}

	@Override
	public SAnnotation createSAnnotation() 
	{
		return(this.saltCoreFactory.createSAnnotation());
	}

	@Override
	public SProcessingAnnotatableElement createSProcessingAnnotatableElement() 
	{
		return(this.saltCoreFactory.createSProcessingAnnotatableElement());
	}

	@Override
	public SProcessingAnnotation createSProcessingAnnotation() 
	{
		return(this.saltCoreFactory.createSProcessingAnnotation());
	}
	@Override
	public SFeaturableElement createSFeaturableElement() 
	{
		return(this.saltCoreFactory.createSFeaturableElement());
	}

	@Override
	public SFeature createSFeature() 
	{
		return(this.saltCoreFactory.createSFeature());
	}
	@Override
	public SElementId createSElementId() 
	{
		return(this.saltCoreFactory.createSElementId());
	}

	@Override
	public SGraph createSGraph() 
	{
		return(this.saltCoreFactory.createSGraph());
	}

	@Override
	public SIdentifiableElement createSIdentifiableElement() 
	{
		return(this.saltCoreFactory.createSIdentifiableElement());
	}

	@Override
	public SNamedElement createSNamedElement() 
	{
		return(this.saltCoreFactory.createSNamedElement());
	}

	@Override
	public SNode createSNode() 
	{
		return(this.saltCoreFactory.createSNode());
	}

	@Override
	public SRelation createSRelation() 
	{
		return(this.saltCoreFactory.createSRelation());
	}

	@Override
	public SLayer createSLayer() {
		return(this.saltCoreFactory.createSLayer());
	}
	
	@Override
	public SMetaAnnotatableElement createSMetaAnnotatableElement() 
	{
		return(this.saltCoreFactory.createSMetaAnnotatableElement());
	}

	@Override
	public SMetaAnnotation createSMetaAnnotation() 
	{
		return(this.saltCoreFactory.createSMetaAnnotation());
	}
	
	@Override
	public SaltCorePackage getSaltCorePackage() 
	{
		return(this.saltCoreFactory.getSaltCorePackage());
	}
// ===================================== end: SaltCoreFactory	

// ===================================== start: SCorpusStructureFactory
	
	/**
	 * Factory object of SCorpusStructureFactory. This is necessary to derive all 
	 * functions from SCorpusStructureFactory. 
	 */
	private SCorpusStructureFactory sCorpusStructureFactory= null;
	
	@Override
	public SCorpusGraph createSCorpusGraph() 
	{
		return(this.sCorpusStructureFactory.createSCorpusGraph());
	}

	@Override
	public SDocument createSDocument() {
		return(this.sCorpusStructureFactory.createSDocument());
	}

	@Override
	public SCorpus createSCorpus() {
		return(this.sCorpusStructureFactory.createSCorpus());
	}

	@Override
	public SCorpusDocumentRelation createSCorpusDocumentRelation() {
		return(this.sCorpusStructureFactory.createSCorpusDocumentRelation());
	}

	@Override
	public SCorpusRelation createSCorpusRelation() {
		return(this.sCorpusStructureFactory.createSCorpusRelation());
	}
	
	@Override
	public SCorpusStructurePackage getSCorpusStructurePackage() {
		return(this.sCorpusStructureFactory.getSCorpusStructurePackage());
	}
// ===================================== end: SCorpusStructureFactory
// ===================================== start: SDocumentStructureFactory
	/**
	 * Factory object of SaltCoreFactory. This is necessary to derive all 
	 * functions from SaltCoreFactory. 
	 */
	private SDocumentStructureFactory sDocumentStructureFactory= null;
	
	@Override
	public SDocumentGraph createSDocumentGraph() {
		return(this.sDocumentStructureFactory.createSDocumentGraph());
	}

//	@Override
//	public SSequentialDS createSSequentialDS() {
//		return(this.sDocumentStructureFactory.createSSequentialDS());
//	}

//	@Override
//	public SSequentialRelation createSSequentialRelation() {
//		return(this.sDocumentStructureFactory.createSSequentialRelation());
//	}

	@Override
	public STextualDS createSTextualDS() {
		return(this.sDocumentStructureFactory.createSTextualDS());
	}

	@Override
	public STextualRelation createSTextualRelation() {
		return(this.sDocumentStructureFactory.createSTextualRelation());
	}

	@Override
	public SToken createSToken() {
		return(this.sDocumentStructureFactory.createSToken());
	}
	
	@Override
	public STimeline createSTimeline() {
		return(this.sDocumentStructureFactory.createSTimeline());
	}
	
	@Override
	public STimelineRelation createSTimelineRelation() 
	{
		return(this.sDocumentStructureFactory.createSTimelineRelation());
	}
	
	@Override
	public SSpan createSSpan() 
	{
		return(this.sDocumentStructureFactory.createSSpan());
	}

	@Override
	public SSpanningRelation createSSpanningRelation() 
	{
		return(this.sDocumentStructureFactory.createSSpanningRelation());
	}

//	@Override
//	public STextOverlappingRelation createSTextOverlappingRelation() 
//	{
//		return(this.sDocumentStructureFactory.createSTextOverlappingRelation());
//	}
//	
//	@Override
//	public STimeOverlappingRelation createSTimeOverlappingRelation() {
//		return(this.sDocumentStructureFactory.createSTimeOverlappingRelation());
//	}
	
	@Override
	public SDominanceRelation createSDominanceRelation() 
	{
		return(this.sDocumentStructureFactory.createSDominanceRelation());
	}

	@Override
	public SPointingRelation createSPointingRelation() 
	{
		return(this.sDocumentStructureFactory.createSPointingRelation());
	}

	@Override
	public SStructure createSStructure() 
	{
		return(this.sDocumentStructureFactory.createSStructure());
	}

	@Override
	public SDataSourceSequence createSDataSourceSequence() {
		return(this.sDocumentStructureFactory.createSDataSourceSequence());
	}
	
	@Override
	public SAudioDataSource createSAudioDataSource() {
		return(this.sDocumentStructureFactory.createSAudioDataSource());
	}

	@Override
	public SAudioDSRelation createSAudioDSRelation() {
		return(this.sDocumentStructureFactory.createSAudioDSRelation());
	}
	
//	@Override
//	public SStructuredNode createSStructuredNode() 
//	{
//		return(this.sDocumentStructureFactory.createSStructuredNode());
//	}
	
	@Override
	public SDocumentStructurePackage getSDocumentStructurePackage() {
		return(this.sDocumentStructureFactory.getSDocumentStructurePackage());
	}
// ===================================== end: SDocumentStructureFactory
	
} //SaltCommonFactoryImpl
