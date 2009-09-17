/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure.impl;

import de.hub.corpling.salt.saltCommon.sDocumentStructure.*;

import org.eclipse.emf.ecore.EClass;
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
			case SDocumentStructurePackage.SSEQUENTIAL_RELATION: return createSSequentialRelation();
			case SDocumentStructurePackage.SSEQUENTIAL_DS: return createSSequentialDS();
			case SDocumentStructurePackage.STIMELINE: return createSTimeline();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
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
	public SSequentialRelation createSSequentialRelation() {
		SSequentialRelationImpl sSequentialRelation = new SSequentialRelationImpl();
		return sSequentialRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SSequentialDS createSSequentialDS() {
		SSequentialDSImpl sSequentialDS = new SSequentialDSImpl();
		return sSequentialDS;
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
