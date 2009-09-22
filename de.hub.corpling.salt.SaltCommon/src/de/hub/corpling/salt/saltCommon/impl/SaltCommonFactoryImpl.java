/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.hub.corpling.salt.saltCommon.SaltCommonFactory;
import de.hub.corpling.salt.saltCommon.SaltCommonPackage;
import de.hub.corpling.salt.saltCommon.SaltProject;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructureFactory;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.SDocument;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructureFactory;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialDS;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SSequentialRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SSpan;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SSpanningRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextOverlappingRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualDS;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STextualRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeline;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STimelineRelation;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SToken;
import de.hub.corpling.salt.saltCore.SAnnotatableElement;
import de.hub.corpling.salt.saltCore.SAnnotation;
import de.hub.corpling.salt.saltCore.SElementId;
import de.hub.corpling.salt.saltCore.SFeaturableElement;
import de.hub.corpling.salt.saltCore.SFeature;
import de.hub.corpling.salt.saltCore.SGraph;
import de.hub.corpling.salt.saltCore.SIdentifiableElement;
import de.hub.corpling.salt.saltCore.SNamedElement;
import de.hub.corpling.salt.saltCore.SNode;
import de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement;
import de.hub.corpling.salt.saltCore.SProcessingAnnotation;
import de.hub.corpling.salt.saltCore.SRelation;
import de.hub.corpling.salt.saltCore.SaltCoreFactory;
import de.hub.corpling.salt.saltCore.SaltCorePackage;

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
	public SaltProject createSaltProject() {
		SaltProjectImpl saltProject = new SaltProjectImpl();
		return saltProject;
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

	@Override
	public SSequentialDS createSSequentialDS() {
		return(this.sDocumentStructureFactory.createSSequentialDS());
	}

	@Override
	public SSequentialRelation createSSequentialRelation() {
		return(this.sDocumentStructureFactory.createSSequentialRelation());
	}

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

	@Override
	public STextOverlappingRelation createSTextOverlappingRelation() 
	{
		return(this.sDocumentStructureFactory.createSTextOverlappingRelation());
	}
	
	@Override
	public SDocumentStructurePackage getSDocumentStructurePackage() {
		return(this.sDocumentStructureFactory.getSDocumentStructurePackage());
	}
// ===================================== end: SDocumentStructureFactory

	

} //SaltCommonFactoryImpl
