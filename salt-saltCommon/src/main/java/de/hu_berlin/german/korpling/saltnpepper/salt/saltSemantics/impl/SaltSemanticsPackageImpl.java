/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SCatAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SLemmaAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SPOSAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SSentenceAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.STypeAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SWordAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SaltSemanticsFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SaltSemanticsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SaltSemanticsPackageImpl extends EPackageImpl implements SaltSemanticsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sposAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sLemmaAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sCatAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sTypeAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sWordAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sSentenceAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum salT_SEMANTIC_NAMESEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SaltSemanticsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SaltSemanticsPackageImpl() {
		super(eNS_URI, SaltSemanticsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link SaltSemanticsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SaltSemanticsPackage init() {
		if (isInited) return (SaltSemanticsPackage)EPackage.Registry.INSTANCE.getEPackage(SaltSemanticsPackage.eNS_URI);

		// Obtain or create and register package
		SaltSemanticsPackageImpl theSaltSemanticsPackage = (SaltSemanticsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SaltSemanticsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SaltSemanticsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		SaltCorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSaltSemanticsPackage.createPackageContents();

		// Initialize created meta-data
		theSaltSemanticsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSaltSemanticsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SaltSemanticsPackage.eNS_URI, theSaltSemanticsPackage);
		return theSaltSemanticsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSPOSAnnotation() {
		return sposAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSLemmaAnnotation() {
		return sLemmaAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSCatAnnotation() {
		return sCatAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSTypeAnnotation() {
		return sTypeAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSWordAnnotation() {
		return sWordAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSSentenceAnnotation() {
		return sSentenceAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSALT_SEMANTIC_NAMES() {
		return salT_SEMANTIC_NAMESEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltSemanticsFactory getSaltSemanticsFactory() {
		return (SaltSemanticsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		sposAnnotationEClass = createEClass(SPOS_ANNOTATION);

		sLemmaAnnotationEClass = createEClass(SLEMMA_ANNOTATION);

		sCatAnnotationEClass = createEClass(SCAT_ANNOTATION);

		sTypeAnnotationEClass = createEClass(STYPE_ANNOTATION);

		sWordAnnotationEClass = createEClass(SWORD_ANNOTATION);

		sSentenceAnnotationEClass = createEClass(SSENTENCE_ANNOTATION);

		// Create enums
		salT_SEMANTIC_NAMESEEnum = createEEnum(SALT_SEMANTIC_NAMES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		SaltCorePackage theSaltCorePackage = (SaltCorePackage)EPackage.Registry.INSTANCE.getEPackage(SaltCorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		sposAnnotationEClass.getESuperTypes().add(theSaltCorePackage.getSAnnotation());
		sLemmaAnnotationEClass.getESuperTypes().add(theSaltCorePackage.getSAnnotation());
		sCatAnnotationEClass.getESuperTypes().add(theSaltCorePackage.getSAnnotation());
		sTypeAnnotationEClass.getESuperTypes().add(theSaltCorePackage.getSAnnotation());
		sWordAnnotationEClass.getESuperTypes().add(theSaltCorePackage.getSAnnotation());
		sSentenceAnnotationEClass.getESuperTypes().add(theSaltCorePackage.getSAnnotation());

		// Initialize classes and features; add operations and parameters
		initEClass(sposAnnotationEClass, SPOSAnnotation.class, "SPOSAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(sposAnnotationEClass, ecorePackage.getEBooleanObject(), "isSPOSAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getSAnnotation(), "sAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sLemmaAnnotationEClass, SLemmaAnnotation.class, "SLemmaAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(sLemmaAnnotationEClass, ecorePackage.getEBooleanObject(), "isSLemmaAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getSAnnotation(), "sAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sCatAnnotationEClass, SCatAnnotation.class, "SCatAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(sCatAnnotationEClass, ecorePackage.getEBooleanObject(), "isSCatAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getSAnnotation(), "sAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sTypeAnnotationEClass, STypeAnnotation.class, "STypeAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(sTypeAnnotationEClass, ecorePackage.getEBooleanObject(), "isSTypeAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getSAnnotation(), "sAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sWordAnnotationEClass, SWordAnnotation.class, "SWordAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(sWordAnnotationEClass, ecorePackage.getEBooleanObject(), "isSWordAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getSAnnotation(), "sAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(sSentenceAnnotationEClass, SSentenceAnnotation.class, "SSentenceAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(sSentenceAnnotationEClass, ecorePackage.getEBooleanObject(), "isSSentenceAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSaltCorePackage.getSAnnotation(), "sAnnotation", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(salT_SEMANTIC_NAMESEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SALT_SEMANTIC_NAMES.class, "SALT_SEMANTIC_NAMES");
		addEEnumLiteral(salT_SEMANTIC_NAMESEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SALT_SEMANTIC_NAMES.POS);
		addEEnumLiteral(salT_SEMANTIC_NAMESEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SALT_SEMANTIC_NAMES.LEMMA);
		addEEnumLiteral(salT_SEMANTIC_NAMESEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SALT_SEMANTIC_NAMES.CAT);
		addEEnumLiteral(salT_SEMANTIC_NAMESEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SALT_SEMANTIC_NAMES.TYPE);
		addEEnumLiteral(salT_SEMANTIC_NAMESEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SALT_SEMANTIC_NAMES.TEXT_UNIT);
		addEEnumLiteral(salT_SEMANTIC_NAMESEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SALT_SEMANTIC_NAMES.TEXT_UNIT_WORD);
		addEEnumLiteral(salT_SEMANTIC_NAMESEEnum, de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SALT_SEMANTIC_NAMES.TEXT_UNIT_SENTENCE);

		// Create resource
		createResource(eNS_URI);
	}

} //SaltSemanticsPackageImpl
