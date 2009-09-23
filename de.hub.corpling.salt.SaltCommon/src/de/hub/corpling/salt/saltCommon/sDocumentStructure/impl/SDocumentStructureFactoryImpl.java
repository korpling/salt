/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure.impl;

import de.hub.corpling.salt.saltCommon.sDocumentStructure.*;

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
public class SDocumentStructureFactoryImpl extends EFactoryImpl implements SDocumentStructureFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SDocumentStructureFactory init() {
		try {
			SDocumentStructureFactory theSDocumentStructureFactory = (SDocumentStructureFactory)EPackage.Registry.INSTANCE.getEFactory("sDocumentStructure"); 
			if (theSDocumentStructureFactory != null) {
				return theSDocumentStructureFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SDocumentStructureFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDocumentStructureFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SDocumentStructurePackage.SDOCUMENT_GRAPH: return createSDocumentGraph();
			case SDocumentStructurePackage.STEXTUAL_DS: return createSTextualDS();
			case SDocumentStructurePackage.STOKEN: return createSToken();
			case SDocumentStructurePackage.STEXTUAL_RELATION: return createSTextualRelation();
			case SDocumentStructurePackage.STIMELINE: return createSTimeline();
			case SDocumentStructurePackage.STIMELINE_RELATION: return createSTimelineRelation();
			case SDocumentStructurePackage.SSPAN: return createSSpan();
			case SDocumentStructurePackage.SSPANNING_RELATION: return createSSpanningRelation();
			case SDocumentStructurePackage.SSTRUCTURE: return createSStructure();
			case SDocumentStructurePackage.SPOINTING_RELATION: return createSPointingRelation();
			case SDocumentStructurePackage.SDOMINANCE_RELATION: return createSDominanceRelation();
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
			case SDocumentStructurePackage.SFEATURE_NAMES:
				return createSFEATURE_NAMESFromString(eDataType, initialValue);
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
			case SDocumentStructurePackage.SFEATURE_NAMES:
				return convertSFEATURE_NAMESToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDocumentGraph createSDocumentGraph() {
		SDocumentGraphImpl sDocumentGraph = new SDocumentGraphImpl();
		return sDocumentGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STextualDS createSTextualDS() {
		STextualDSImpl sTextualDS = new STextualDSImpl();
		return sTextualDS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SToken createSToken() {
		STokenImpl sToken = new STokenImpl();
		return sToken;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STextualRelation createSTextualRelation() {
		STextualRelationImpl sTextualRelation = new STextualRelationImpl();
		return sTextualRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STimeline createSTimeline() {
		STimelineImpl sTimeline = new STimelineImpl();
		return sTimeline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STimelineRelation createSTimelineRelation() {
		STimelineRelationImpl sTimelineRelation = new STimelineRelationImpl();
		return sTimelineRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SSpan createSSpan() {
		SSpanImpl sSpan = new SSpanImpl();
		return sSpan;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SSpanningRelation createSSpanningRelation() {
		SSpanningRelationImpl sSpanningRelation = new SSpanningRelationImpl();
		return sSpanningRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SStructure createSStructure() {
		SStructureImpl sStructure = new SStructureImpl();
		return sStructure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SPointingRelation createSPointingRelation() {
		SPointingRelationImpl sPointingRelation = new SPointingRelationImpl();
		return sPointingRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDominanceRelation createSDominanceRelation() {
		SDominanceRelationImpl sDominanceRelation = new SDominanceRelationImpl();
		return sDominanceRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SFEATURE_NAMES createSFEATURE_NAMESFromString(EDataType eDataType, String initialValue) {
		SFEATURE_NAMES result = SFEATURE_NAMES.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSFEATURE_NAMESToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDocumentStructurePackage getSDocumentStructurePackage() {
		return (SDocumentStructurePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SDocumentStructurePackage getPackage() {
		return SDocumentStructurePackage.eINSTANCE;
	}

} //SDocumentStructureFactoryImpl
