/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltSemantics.impl;

import de.hub.corpling.salt.saltSemantics.*;

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
public class SaltSemanticsFactoryImpl extends EFactoryImpl implements SaltSemanticsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SaltSemanticsFactory init() {
		try {
			SaltSemanticsFactory theSaltSemanticsFactory = (SaltSemanticsFactory)EPackage.Registry.INSTANCE.getEFactory("SaltSemantics"); 
			if (theSaltSemanticsFactory != null) {
				return theSaltSemanticsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SaltSemanticsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltSemanticsFactoryImpl() {
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
			case SaltSemanticsPackage.SPOS_ANNOTATION: return createSPOSAnnotation();
			case SaltSemanticsPackage.SLEMMA_ANNOTATION: return createSLemmaAnnotation();
			case SaltSemanticsPackage.SCAT_ANNOTATION: return createSCatAnnotation();
			case SaltSemanticsPackage.STYPE_ANNOTATION: return createSTypeAnnotation();
			case SaltSemanticsPackage.SWORD_ANNOTATION: return createSWordAnnotation();
			case SaltSemanticsPackage.SSENTENCE_ANNOTATION: return createSSentenceAnnotation();
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
			case SaltSemanticsPackage.SALT_SEMANTIC_NAMES:
				return createSALT_SEMANTIC_NAMESFromString(eDataType, initialValue);
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
			case SaltSemanticsPackage.SALT_SEMANTIC_NAMES:
				return convertSALT_SEMANTIC_NAMESToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SPOSAnnotation createSPOSAnnotation() {
		SPOSAnnotationImpl sposAnnotation = new SPOSAnnotationImpl();
		return sposAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SLemmaAnnotation createSLemmaAnnotation() {
		SLemmaAnnotationImpl sLemmaAnnotation = new SLemmaAnnotationImpl();
		return sLemmaAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCatAnnotation createSCatAnnotation() {
		SCatAnnotationImpl sCatAnnotation = new SCatAnnotationImpl();
		return sCatAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public STypeAnnotation createSTypeAnnotation() {
		STypeAnnotationImpl sTypeAnnotation = new STypeAnnotationImpl();
		return sTypeAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SWordAnnotation createSWordAnnotation() {
		SWordAnnotationImpl sWordAnnotation = new SWordAnnotationImpl();
		return sWordAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SSentenceAnnotation createSSentenceAnnotation() {
		SSentenceAnnotationImpl sSentenceAnnotation = new SSentenceAnnotationImpl();
		return sSentenceAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SALT_SEMANTIC_NAMES createSALT_SEMANTIC_NAMESFromString(EDataType eDataType, String initialValue) {
		SALT_SEMANTIC_NAMES result = SALT_SEMANTIC_NAMES.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSALT_SEMANTIC_NAMESToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltSemanticsPackage getSaltSemanticsPackage() {
		return (SaltSemanticsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SaltSemanticsPackage getPackage() {
		return SaltSemanticsPackage.eINSTANCE;
	}

} //SaltSemanticsFactoryImpl
