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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.*;

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
