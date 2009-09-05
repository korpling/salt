/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sCorpusStructure.impl;

import de.hub.corpling.salt.saltCommon.sCorpusStructure.*;

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
public class SCorpusStructureFactoryImpl extends EFactoryImpl implements SCorpusStructureFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SCorpusStructureFactory init() {
		try {
			SCorpusStructureFactory theSCorpusStructureFactory = (SCorpusStructureFactory)EPackage.Registry.INSTANCE.getEFactory("sCorpusStructure"); 
			if (theSCorpusStructureFactory != null) {
				return theSCorpusStructureFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SCorpusStructureFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCorpusStructureFactoryImpl() {
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
			case SCorpusStructurePackage.SCORPUS_GRAPH: return createSCorpusGraph();
			case SCorpusStructurePackage.SDOCUMENT: return createSDocument();
			case SCorpusStructurePackage.SCORPUS: return createSCorpus();
			case SCorpusStructurePackage.SCORPUS_RELATION: return createSCorpusRelation();
			case SCorpusStructurePackage.SCORPUS_DOCUMENT_RELATION: return createSCorpusDocumentRelation();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCorpusGraph createSCorpusGraph() {
		SCorpusGraphImpl sCorpusGraph = new SCorpusGraphImpl();
		return sCorpusGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDocument createSDocument() {
		SDocumentImpl sDocument = new SDocumentImpl();
		return sDocument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCorpus createSCorpus() {
		SCorpusImpl sCorpus = new SCorpusImpl();
		return sCorpus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCorpusRelation createSCorpusRelation() {
		SCorpusRelationImpl sCorpusRelation = new SCorpusRelationImpl();
		return sCorpusRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCorpusDocumentRelation createSCorpusDocumentRelation() {
		SCorpusDocumentRelationImpl sCorpusDocumentRelation = new SCorpusDocumentRelationImpl();
		return sCorpusDocumentRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCorpusStructurePackage getSCorpusStructurePackage() {
		return (SCorpusStructurePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SCorpusStructurePackage getPackage() {
		return SCorpusStructurePackage.eINSTANCE;
	}

} //SCorpusStructureFactoryImpl
