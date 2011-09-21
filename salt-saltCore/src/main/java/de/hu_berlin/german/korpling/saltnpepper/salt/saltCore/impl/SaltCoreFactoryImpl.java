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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE;
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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SaltCoreFactoryImpl extends EFactoryImpl implements SaltCoreFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SaltCoreFactory init() {
		try {
			SaltCoreFactory theSaltCoreFactory = (SaltCoreFactory)EPackage.Registry.INSTANCE.getEFactory("saltCore"); 
			if (theSaltCoreFactory != null) {
				return theSaltCoreFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SaltCoreFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltCoreFactoryImpl() {
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
			case SaltCorePackage.SNODE: return createSNode();
			case SaltCorePackage.SRELATION: return createSRelation();
			case SaltCorePackage.SANNOTATABLE_ELEMENT: return createSAnnotatableElement();
			case SaltCorePackage.SANNOTATION: return createSAnnotation();
			case SaltCorePackage.SGRAPH: return createSGraph();
			case SaltCorePackage.SNAMED_ELEMENT: return createSNamedElement();
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT: return createSIdentifiableElement();
			case SaltCorePackage.SPROCESSING_ANNOTATION: return createSProcessingAnnotation();
			case SaltCorePackage.SPROCESSING_ANNOTATABLE_ELEMENT: return createSProcessingAnnotatableElement();
			case SaltCorePackage.SELEMENT_ID: return createSElementId();
			case SaltCorePackage.SFEATURE: return createSFeature();
			case SaltCorePackage.SFEATURABLE_ELEMENT: return createSFeaturableElement();
			case SaltCorePackage.SMETA_ANNOTATABLE_ELEMENT: return createSMetaAnnotatableElement();
			case SaltCorePackage.SMETA_ANNOTATION: return createSMetaAnnotation();
			case SaltCorePackage.SLAYER: return createSLayer();
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
			case SaltCorePackage.SDATATYPE:
				return createSDATATYPEFromString(eDataType, initialValue);
			case SaltCorePackage.URI:
				return createURIFromString(eDataType, initialValue);
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
			case SaltCorePackage.SDATATYPE:
				return convertSDATATYPEToString(eDataType, instanceValue);
			case SaltCorePackage.URI:
				return convertURIToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SNode createSNode() {
		SNodeImpl sNode = new SNodeImpl();
		return sNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SRelation createSRelation() {
		SRelationImpl sRelation = new SRelationImpl();
		return sRelation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SAnnotatableElement createSAnnotatableElement() {
		SAnnotatableElementImpl sAnnotatableElement = new SAnnotatableElementImpl();
		return sAnnotatableElement;
	}

	/**
	 * Creates a new SAnnotation object.
	 */
	public SAnnotation createSAnnotation() {
		SAnnotationImpl sAnnotation = new SAnnotationImpl();
		return sAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SGraph createSGraph() {
		SGraphImpl sGraph = new SGraphImpl();
		return sGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SNamedElement createSNamedElement() {
		SNamedElementImpl sNamedElement = new SNamedElementImpl();
		return sNamedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SIdentifiableElement createSIdentifiableElement() {
		SIdentifiableElementImpl sIdentifiableElement = new SIdentifiableElementImpl();
		return sIdentifiableElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SProcessingAnnotation createSProcessingAnnotation() {
		SProcessingAnnotationImpl sProcessingAnnotation = new SProcessingAnnotationImpl();
		return sProcessingAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SProcessingAnnotatableElement createSProcessingAnnotatableElement() {
		SProcessingAnnotatableElementImpl sProcessingAnnotatableElement = new SProcessingAnnotatableElementImpl();
		return sProcessingAnnotatableElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SElementId createSElementId() {
		SElementIdImpl sElementId = new SElementIdImpl();
		return sElementId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SFeature createSFeature() {
		SFeatureImpl sFeature = new SFeatureImpl();
		return sFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SFeaturableElement createSFeaturableElement() {
		SFeaturableElementImpl sFeaturableElement = new SFeaturableElementImpl();
		return sFeaturableElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SMetaAnnotatableElement createSMetaAnnotatableElement() {
		SMetaAnnotatableElementImpl sMetaAnnotatableElement = new SMetaAnnotatableElementImpl();
		return sMetaAnnotatableElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SMetaAnnotation createSMetaAnnotation() {
		SMetaAnnotationImpl sMetaAnnotation = new SMetaAnnotationImpl();
		return sMetaAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SLayer createSLayer() {
		SLayerImpl sLayer = new SLayerImpl();
		return sLayer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDATATYPE createSDATATYPEFromString(EDataType eDataType, String initialValue) {
		SDATATYPE result = SDATATYPE.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSDATATYPEToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI createURIFromString(EDataType eDataType, String initialValue) {
		return (URI)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertURIToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltCorePackage getSaltCorePackage() {
		return (SaltCorePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SaltCorePackage getPackage() {
		return SaltCorePackage.eINSTANCE;
	}

} //SaltCoreFactoryImpl
