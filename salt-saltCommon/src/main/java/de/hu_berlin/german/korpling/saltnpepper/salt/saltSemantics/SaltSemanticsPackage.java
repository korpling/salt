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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SaltSemanticsFactory
 * @model kind="package"
 * @generated
 */
public interface SaltSemanticsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "saltSemantics";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "SaltSemantics";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "saltSemantics";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SaltSemanticsPackage eINSTANCE = de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SaltSemanticsPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SPOSAnnotationImpl <em>SPOS Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SPOSAnnotationImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SaltSemanticsPackageImpl#getSPOSAnnotation()
	 * @generated
	 */
	int SPOS_ANNOTATION = 0;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOS_ANNOTATION__LABELS = SaltCorePackage.SANNOTATION__LABELS;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOS_ANNOTATION__NAMESPACE = SaltCorePackage.SANNOTATION__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOS_ANNOTATION__NAME = SaltCorePackage.SANNOTATION__NAME;

	/**
	 * The feature id for the '<em><b>Full Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOS_ANNOTATION__FULL_NAME = SaltCorePackage.SANNOTATION__QNAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOS_ANNOTATION__VALUE = SaltCorePackage.SANNOTATION__VALUE;

	/**
	 * The feature id for the '<em><b>Labelable Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOS_ANNOTATION__LABELABLE_ELEMENT = SaltCorePackage.SANNOTATION__LABELABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Value String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOS_ANNOTATION__VALUE_STRING = SaltCorePackage.SANNOTATION__VALUE_STRING;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOS_ANNOTATION__SNAME = SaltCorePackage.SANNOTATION__SNAME;

	/**
	 * The feature id for the '<em><b>SValue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOS_ANNOTATION__SVALUE = SaltCorePackage.SANNOTATION__SVALUE;

	/**
	 * The feature id for the '<em><b>SAnnotatable Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOS_ANNOTATION__SANNOTATABLE_ELEMENT = SaltCorePackage.SANNOTATION__SANNOTATABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SNS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOS_ANNOTATION__SNS = SaltCorePackage.SANNOTATION__SNS;

	/**
	 * The number of structural features of the '<em>SPOS Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPOS_ANNOTATION_FEATURE_COUNT = SaltCorePackage.SANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SLemmaAnnotationImpl <em>SLemma Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SLemmaAnnotationImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SaltSemanticsPackageImpl#getSLemmaAnnotation()
	 * @generated
	 */
	int SLEMMA_ANNOTATION = 1;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLEMMA_ANNOTATION__LABELS = SaltCorePackage.SANNOTATION__LABELS;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLEMMA_ANNOTATION__NAMESPACE = SaltCorePackage.SANNOTATION__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLEMMA_ANNOTATION__NAME = SaltCorePackage.SANNOTATION__NAME;

	/**
	 * The feature id for the '<em><b>Full Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLEMMA_ANNOTATION__FULL_NAME = SaltCorePackage.SANNOTATION__QNAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLEMMA_ANNOTATION__VALUE = SaltCorePackage.SANNOTATION__VALUE;

	/**
	 * The feature id for the '<em><b>Labelable Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLEMMA_ANNOTATION__LABELABLE_ELEMENT = SaltCorePackage.SANNOTATION__LABELABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Value String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLEMMA_ANNOTATION__VALUE_STRING = SaltCorePackage.SANNOTATION__VALUE_STRING;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLEMMA_ANNOTATION__SNAME = SaltCorePackage.SANNOTATION__SNAME;

	/**
	 * The feature id for the '<em><b>SValue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLEMMA_ANNOTATION__SVALUE = SaltCorePackage.SANNOTATION__SVALUE;

	/**
	 * The feature id for the '<em><b>SAnnotatable Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLEMMA_ANNOTATION__SANNOTATABLE_ELEMENT = SaltCorePackage.SANNOTATION__SANNOTATABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SNS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLEMMA_ANNOTATION__SNS = SaltCorePackage.SANNOTATION__SNS;

	/**
	 * The number of structural features of the '<em>SLemma Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SLEMMA_ANNOTATION_FEATURE_COUNT = SaltCorePackage.SANNOTATION_FEATURE_COUNT + 0;


	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SCatAnnotationImpl <em>SCat Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SCatAnnotationImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SaltSemanticsPackageImpl#getSCatAnnotation()
	 * @generated
	 */
	int SCAT_ANNOTATION = 2;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAT_ANNOTATION__LABELS = SaltCorePackage.SANNOTATION__LABELS;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAT_ANNOTATION__NAMESPACE = SaltCorePackage.SANNOTATION__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAT_ANNOTATION__NAME = SaltCorePackage.SANNOTATION__NAME;

	/**
	 * The feature id for the '<em><b>Full Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAT_ANNOTATION__FULL_NAME = SaltCorePackage.SANNOTATION__QNAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAT_ANNOTATION__VALUE = SaltCorePackage.SANNOTATION__VALUE;

	/**
	 * The feature id for the '<em><b>Labelable Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAT_ANNOTATION__LABELABLE_ELEMENT = SaltCorePackage.SANNOTATION__LABELABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Value String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAT_ANNOTATION__VALUE_STRING = SaltCorePackage.SANNOTATION__VALUE_STRING;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAT_ANNOTATION__SNAME = SaltCorePackage.SANNOTATION__SNAME;

	/**
	 * The feature id for the '<em><b>SValue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAT_ANNOTATION__SVALUE = SaltCorePackage.SANNOTATION__SVALUE;

	/**
	 * The feature id for the '<em><b>SAnnotatable Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAT_ANNOTATION__SANNOTATABLE_ELEMENT = SaltCorePackage.SANNOTATION__SANNOTATABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SNS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAT_ANNOTATION__SNS = SaltCorePackage.SANNOTATION__SNS;

	/**
	 * The number of structural features of the '<em>SCat Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCAT_ANNOTATION_FEATURE_COUNT = SaltCorePackage.SANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.STypeAnnotationImpl <em>SType Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.STypeAnnotationImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SaltSemanticsPackageImpl#getSTypeAnnotation()
	 * @generated
	 */
	int STYPE_ANNOTATION = 3;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYPE_ANNOTATION__LABELS = SaltCorePackage.SANNOTATION__LABELS;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYPE_ANNOTATION__NAMESPACE = SaltCorePackage.SANNOTATION__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYPE_ANNOTATION__NAME = SaltCorePackage.SANNOTATION__NAME;

	/**
	 * The feature id for the '<em><b>Full Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYPE_ANNOTATION__FULL_NAME = SaltCorePackage.SANNOTATION__QNAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYPE_ANNOTATION__VALUE = SaltCorePackage.SANNOTATION__VALUE;

	/**
	 * The feature id for the '<em><b>Labelable Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYPE_ANNOTATION__LABELABLE_ELEMENT = SaltCorePackage.SANNOTATION__LABELABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Value String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYPE_ANNOTATION__VALUE_STRING = SaltCorePackage.SANNOTATION__VALUE_STRING;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYPE_ANNOTATION__SNAME = SaltCorePackage.SANNOTATION__SNAME;

	/**
	 * The feature id for the '<em><b>SValue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYPE_ANNOTATION__SVALUE = SaltCorePackage.SANNOTATION__SVALUE;

	/**
	 * The feature id for the '<em><b>SAnnotatable Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYPE_ANNOTATION__SANNOTATABLE_ELEMENT = SaltCorePackage.SANNOTATION__SANNOTATABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SNS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYPE_ANNOTATION__SNS = SaltCorePackage.SANNOTATION__SNS;

	/**
	 * The number of structural features of the '<em>SType Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYPE_ANNOTATION_FEATURE_COUNT = SaltCorePackage.SANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SWordAnnotationImpl <em>SWord Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SWordAnnotationImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SaltSemanticsPackageImpl#getSWordAnnotation()
	 * @generated
	 */
	int SWORD_ANNOTATION = 4;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWORD_ANNOTATION__LABELS = SaltCorePackage.SANNOTATION__LABELS;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWORD_ANNOTATION__NAMESPACE = SaltCorePackage.SANNOTATION__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWORD_ANNOTATION__NAME = SaltCorePackage.SANNOTATION__NAME;

	/**
	 * The feature id for the '<em><b>Full Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWORD_ANNOTATION__FULL_NAME = SaltCorePackage.SANNOTATION__QNAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWORD_ANNOTATION__VALUE = SaltCorePackage.SANNOTATION__VALUE;

	/**
	 * The feature id for the '<em><b>Labelable Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWORD_ANNOTATION__LABELABLE_ELEMENT = SaltCorePackage.SANNOTATION__LABELABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Value String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWORD_ANNOTATION__VALUE_STRING = SaltCorePackage.SANNOTATION__VALUE_STRING;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWORD_ANNOTATION__SNAME = SaltCorePackage.SANNOTATION__SNAME;

	/**
	 * The feature id for the '<em><b>SValue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWORD_ANNOTATION__SVALUE = SaltCorePackage.SANNOTATION__SVALUE;

	/**
	 * The feature id for the '<em><b>SAnnotatable Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWORD_ANNOTATION__SANNOTATABLE_ELEMENT = SaltCorePackage.SANNOTATION__SANNOTATABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SNS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWORD_ANNOTATION__SNS = SaltCorePackage.SANNOTATION__SNS;

	/**
	 * The number of structural features of the '<em>SWord Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWORD_ANNOTATION_FEATURE_COUNT = SaltCorePackage.SANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SSentenceAnnotationImpl <em>SSentence Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SSentenceAnnotationImpl
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SaltSemanticsPackageImpl#getSSentenceAnnotation()
	 * @generated
	 */
	int SSENTENCE_ANNOTATION = 5;

	/**
	 * The feature id for the '<em><b>Labels</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSENTENCE_ANNOTATION__LABELS = SaltCorePackage.SANNOTATION__LABELS;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSENTENCE_ANNOTATION__NAMESPACE = SaltCorePackage.SANNOTATION__NAMESPACE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSENTENCE_ANNOTATION__NAME = SaltCorePackage.SANNOTATION__NAME;

	/**
	 * The feature id for the '<em><b>Full Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSENTENCE_ANNOTATION__FULL_NAME = SaltCorePackage.SANNOTATION__QNAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSENTENCE_ANNOTATION__VALUE = SaltCorePackage.SANNOTATION__VALUE;

	/**
	 * The feature id for the '<em><b>Labelable Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSENTENCE_ANNOTATION__LABELABLE_ELEMENT = SaltCorePackage.SANNOTATION__LABELABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Value String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSENTENCE_ANNOTATION__VALUE_STRING = SaltCorePackage.SANNOTATION__VALUE_STRING;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSENTENCE_ANNOTATION__SNAME = SaltCorePackage.SANNOTATION__SNAME;

	/**
	 * The feature id for the '<em><b>SValue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSENTENCE_ANNOTATION__SVALUE = SaltCorePackage.SANNOTATION__SVALUE;

	/**
	 * The feature id for the '<em><b>SAnnotatable Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSENTENCE_ANNOTATION__SANNOTATABLE_ELEMENT = SaltCorePackage.SANNOTATION__SANNOTATABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>SNS</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSENTENCE_ANNOTATION__SNS = SaltCorePackage.SANNOTATION__SNS;

	/**
	 * The number of structural features of the '<em>SSentence Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SSENTENCE_ANNOTATION_FEATURE_COUNT = SaltCorePackage.SANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SALT_SEMANTIC_NAMES <em>SALT SEMANTIC NAMES</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SALT_SEMANTIC_NAMES
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SaltSemanticsPackageImpl#getSALT_SEMANTIC_NAMES()
	 * @generated
	 */
	int SALT_SEMANTIC_NAMES = 6;


	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SPOSAnnotation <em>SPOS Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SPOS Annotation</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SPOSAnnotation
	 * @generated
	 */
	EClass getSPOSAnnotation();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SLemmaAnnotation <em>SLemma Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SLemma Annotation</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SLemmaAnnotation
	 * @generated
	 */
	EClass getSLemmaAnnotation();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SCatAnnotation <em>SCat Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SCat Annotation</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SCatAnnotation
	 * @generated
	 */
	EClass getSCatAnnotation();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.STypeAnnotation <em>SType Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SType Annotation</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.STypeAnnotation
	 * @generated
	 */
	EClass getSTypeAnnotation();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SWordAnnotation <em>SWord Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SWord Annotation</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SWordAnnotation
	 * @generated
	 */
	EClass getSWordAnnotation();

	/**
	 * Returns the meta object for class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SSentenceAnnotation <em>SSentence Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SSentence Annotation</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SSentenceAnnotation
	 * @generated
	 */
	EClass getSSentenceAnnotation();

	/**
	 * Returns the meta object for enum '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SALT_SEMANTIC_NAMES <em>SALT SEMANTIC NAMES</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>SALT SEMANTIC NAMES</em>'.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SALT_SEMANTIC_NAMES
	 * @generated
	 */
	EEnum getSALT_SEMANTIC_NAMES();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SaltSemanticsFactory getSaltSemanticsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SPOSAnnotationImpl <em>SPOS Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SPOSAnnotationImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SaltSemanticsPackageImpl#getSPOSAnnotation()
		 * @generated
		 */
		EClass SPOS_ANNOTATION = eINSTANCE.getSPOSAnnotation();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SLemmaAnnotationImpl <em>SLemma Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SLemmaAnnotationImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SaltSemanticsPackageImpl#getSLemmaAnnotation()
		 * @generated
		 */
		EClass SLEMMA_ANNOTATION = eINSTANCE.getSLemmaAnnotation();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SCatAnnotationImpl <em>SCat Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SCatAnnotationImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SaltSemanticsPackageImpl#getSCatAnnotation()
		 * @generated
		 */
		EClass SCAT_ANNOTATION = eINSTANCE.getSCatAnnotation();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.STypeAnnotationImpl <em>SType Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.STypeAnnotationImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SaltSemanticsPackageImpl#getSTypeAnnotation()
		 * @generated
		 */
		EClass STYPE_ANNOTATION = eINSTANCE.getSTypeAnnotation();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SWordAnnotationImpl <em>SWord Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SWordAnnotationImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SaltSemanticsPackageImpl#getSWordAnnotation()
		 * @generated
		 */
		EClass SWORD_ANNOTATION = eINSTANCE.getSWordAnnotation();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SSentenceAnnotationImpl <em>SSentence Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SSentenceAnnotationImpl
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SaltSemanticsPackageImpl#getSSentenceAnnotation()
		 * @generated
		 */
		EClass SSENTENCE_ANNOTATION = eINSTANCE.getSSentenceAnnotation();

		/**
		 * The meta object literal for the '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SALT_SEMANTIC_NAMES <em>SALT SEMANTIC NAMES</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.SALT_SEMANTIC_NAMES
		 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltSemantics.impl.SaltSemanticsPackageImpl#getSALT_SEMANTIC_NAMES()
		 * @generated
		 */
		EEnum SALT_SEMANTIC_NAMES = eINSTANCE.getSALT_SEMANTIC_NAMES();

	}

} //SaltSemanticsPackage
