/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.saltCore.impl;

import de.corpling.salt.model.saltCore.*;
import java.net.URI;
import java.net.URL;
import de.corpling.salt.model.saltCore.SAnnotatableElement;
import de.corpling.salt.model.saltCore.SAnnotation;
import de.corpling.salt.model.saltCore.SCoreProject;
import de.corpling.salt.model.saltCore.SElement;
import de.corpling.salt.model.saltCore.SFeature;
import de.corpling.salt.model.saltCore.SFeatureDescription;
import de.corpling.salt.model.saltCore.SGraph;
import de.corpling.salt.model.saltCore.SIdentifiableElement;
import de.corpling.salt.model.saltCore.SNamedElement;
import de.corpling.salt.model.saltCore.SProcessingAnnotatableElement;
import de.corpling.salt.model.saltCore.SProcessingAnnotation;
import de.corpling.salt.model.saltCore.SRelation;
import de.corpling.salt.model.saltCore.SStereotype;
import de.corpling.salt.model.saltCore.SStereotypeContainer;
import de.corpling.salt.model.saltCore.SStereotypeableElement;
import de.corpling.salt.model.saltCore.SaltCoreFactory;
import de.corpling.salt.model.saltCore.SaltCorePackage;

import java.util.Properties;
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
			SaltCoreFactory theSaltCoreFactory = (SaltCoreFactory)EPackage.Registry.INSTANCE.getEFactory("www.corpling.de/salt/saltCore"); 
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
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT: return createSIdentifiableElement();
			case SaltCorePackage.SELEMENT: return createSElement();
			case SaltCorePackage.SANNOTATION: return createSAnnotation();
			case SaltCorePackage.SANNOTATABLE_ELEMENT: return createSAnnotatableElement();
			case SaltCorePackage.SRELATION: return createSRelation();
			case SaltCorePackage.SNAMED_ELEMENT: return createSNamedElement();
			case SaltCorePackage.SSTEREOTYPEABLE_ELEMENT: return createSStereotypeableElement();
			case SaltCorePackage.SFEATURE: return createSFeature();
			case SaltCorePackage.SSTEREOTYPE: return createSStereotype();
			case SaltCorePackage.SFEATURE_DESCRIPTION: return createSFeatureDescription();
			case SaltCorePackage.SGRAPH: return createSGraph();
			case SaltCorePackage.SCORE_PROJECT: return createSCoreProject();
			case SaltCorePackage.SSTEREOTYPE_CONTAINER: return createSStereotypeContainer();
			case SaltCorePackage.SPROCESSING_ANNOTATABLE_ELEMENT: return createSProcessingAnnotatableElement();
			case SaltCorePackage.SPROCESSING_ANNOTATION: return createSProcessingAnnotation();
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
			case SaltCorePackage.STRAVERSAL_MODE:
				return createSTRAVERSAL_MODEFromString(eDataType, initialValue);
			case SaltCorePackage.SDATATYPES:
				return createSDATATYPESFromString(eDataType, initialValue);
			case SaltCorePackage.PROPERTIES:
				return createPropertiesFromString(eDataType, initialValue);
			case SaltCorePackage.URI:
				return createURIFromString(eDataType, initialValue);
			case SaltCorePackage.OBJECT:
				return createObjectFromString(eDataType, initialValue);
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
			case SaltCorePackage.STRAVERSAL_MODE:
				return convertSTRAVERSAL_MODEToString(eDataType, instanceValue);
			case SaltCorePackage.SDATATYPES:
				return convertSDATATYPESToString(eDataType, instanceValue);
			case SaltCorePackage.PROPERTIES:
				return convertPropertiesToString(eDataType, instanceValue);
			case SaltCorePackage.URI:
				return convertURIToString(eDataType, instanceValue);
			case SaltCorePackage.OBJECT:
				return convertObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
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
	public SElement createSElement() {
		SElementImpl sElement = new SElementImpl();
		return sElement;
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
	public SAnnotatableElement createSAnnotatableElement() {
		SAnnotatableElementImpl sAnnotatableElement = new SAnnotatableElementImpl();
		return sAnnotatableElement;
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
	public SNamedElement createSNamedElement() {
		SNamedElementImpl sNamedElement = new SNamedElementImpl();
		return sNamedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SStereotypeableElement createSStereotypeableElement() {
		SStereotypeableElementImpl sStereotypeableElement = new SStereotypeableElementImpl();
		return sStereotypeableElement;
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
	public SStereotype createSStereotype() {
		SStereotypeImpl sStereotype = new SStereotypeImpl();
		return sStereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SFeatureDescription createSFeatureDescription() {
		SFeatureDescriptionImpl sFeatureDescription = new SFeatureDescriptionImpl();
		return sFeatureDescription;
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
	public SCoreProject createSCoreProject() {
		SCoreProjectImpl sCoreProject = new SCoreProjectImpl();
		return sCoreProject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SStereotypeContainer createSStereotypeContainer() {
		SStereotypeContainerImpl sStereotypeContainer = new SStereotypeContainerImpl();
		return sStereotypeContainer;
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
	public SProcessingAnnotation createSProcessingAnnotation() {
		SProcessingAnnotationImpl sProcessingAnnotation = new SProcessingAnnotationImpl();
		return sProcessingAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STRAVERSAL_MODE createSTRAVERSAL_MODEFromString(EDataType eDataType, String initialValue) {
		STRAVERSAL_MODE result = STRAVERSAL_MODE.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSTRAVERSAL_MODEToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDATATYPES createSDATATYPESFromString(EDataType eDataType, String initialValue) {
		SDATATYPES result = SDATATYPES.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSDATATYPESToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
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
	public Object createObjectFromString(EDataType eDataType, String initialValue) {
		return super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertObjectToString(EDataType eDataType, Object instanceValue) {
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
