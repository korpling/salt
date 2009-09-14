/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore.impl;

import de.hub.corpling.salt.saltCore.*;

import org.eclipse.emf.common.util.URI;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
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
