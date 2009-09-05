/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see de.hub.corpling.salt.saltCore.SaltCoreFactory
 * @model kind="package"
 * @generated
 */
public interface SaltCorePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "saltCore";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "saltCore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "saltCore";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SaltCorePackage eINSTANCE = de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl.init();

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCore.impl.SAnnotatableElementImpl <em>SAnnotatable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.impl.SAnnotatableElementImpl
	 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSAnnotatableElement()
	 * @generated
	 */
	int SANNOTATABLE_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATABLE_ELEMENT__SANNOTATIONS = 0;

	/**
	 * The number of structural features of the '<em>SAnnotatable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATABLE_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCore.impl.SNodeImpl <em>SNode</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.impl.SNodeImpl
	 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSNode()
	 * @generated
	 */
	int SNODE = 0;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNODE__SANNOTATIONS = SANNOTATABLE_ELEMENT__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNODE__NAME = SANNOTATABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNODE__SELEMENT_ID = SANNOTATABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNODE__SGRAPH = SANNOTATABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>SNode</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNODE_FEATURE_COUNT = SANNOTATABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCore.impl.SRelationImpl <em>SRelation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.impl.SRelationImpl
	 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSRelation()
	 * @generated
	 */
	int SRELATION = 1;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__SANNOTATIONS = SANNOTATABLE_ELEMENT__SANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__NAME = SANNOTATABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__SELEMENT_ID = SANNOTATABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source SNode</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__SOURCE_SNODE = SANNOTATABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Target SNode</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__TARGET_SNODE = SANNOTATABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>SGraph</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION__SGRAPH = SANNOTATABLE_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>SRelation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SRELATION_FEATURE_COUNT = SANNOTATABLE_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCore.impl.SAnnotationImpl <em>SAnnotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.impl.SAnnotationImpl
	 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSAnnotation()
	 * @generated
	 */
	int SANNOTATION = 3;

	/**
	 * The feature id for the '<em><b>SName</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATION__SNAME = 0;

	/**
	 * The feature id for the '<em><b>SValue</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATION__SVALUE = 1;

	/**
	 * The feature id for the '<em><b>SAnnotatbale Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATION__SANNOTATBALE_ELEMENT = 2;

	/**
	 * The number of structural features of the '<em>SAnnotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SANNOTATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCore.impl.SNamedElementImpl <em>SNamed Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.impl.SNamedElementImpl
	 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSNamedElement()
	 * @generated
	 */
	int SNAMED_ELEMENT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>SNamed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCore.impl.SGraphImpl <em>SGraph</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.impl.SGraphImpl
	 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSGraph()
	 * @generated
	 */
	int SGRAPH = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__NAME = SNAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>SAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__SANNOTATIONS = SNAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__SELEMENT_ID = SNAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>SRelations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__SRELATIONS = SNAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>SNodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH__SNODES = SNAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>SGraph</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SGRAPH_FEATURE_COUNT = SNAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCore.impl.SIdentifiableElementImpl <em>SIdentifiable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.impl.SIdentifiableElementImpl
	 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSIdentifiableElement()
	 * @generated
	 */
	int SIDENTIFIABLE_ELEMENT = 6;

	/**
	 * The feature id for the '<em><b>SElement Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIDENTIFIABLE_ELEMENT__SELEMENT_ID = 0;

	/**
	 * The number of structural features of the '<em>SIdentifiable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIDENTIFIABLE_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.hub.corpling.salt.saltCore.impl.SElementIdImpl <em>SElement Id</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.hub.corpling.salt.saltCore.impl.SElementIdImpl
	 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSElementId()
	 * @generated
	 */
	int SELEMENT_ID = 7;

	/**
	 * The feature id for the '<em><b>SId</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT_ID__SID = 0;

	/**
	 * The feature id for the '<em><b>SIdentifiable Element</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT_ID__SIDENTIFIABLE_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>SElement Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT_ID__SELEMENT_PATH = 2;

	/**
	 * The number of structural features of the '<em>SElement Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SELEMENT_ID_FEATURE_COUNT = 3;


	/**
	 * The meta object id for the '<em>URI</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.URI
	 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getURI()
	 * @generated
	 */
	int URI = 8;


	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCore.SNode <em>SNode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SNode</em>'.
	 * @see de.hub.corpling.salt.saltCore.SNode
	 * @generated
	 */
	EClass getSNode();

	/**
	 * Returns the meta object for the container reference '{@link de.hub.corpling.salt.saltCore.SNode#getSGraph <em>SGraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SGraph</em>'.
	 * @see de.hub.corpling.salt.saltCore.SNode#getSGraph()
	 * @see #getSNode()
	 * @generated
	 */
	EReference getSNode_SGraph();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCore.SRelation <em>SRelation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SRelation</em>'.
	 * @see de.hub.corpling.salt.saltCore.SRelation
	 * @generated
	 */
	EClass getSRelation();

	/**
	 * Returns the meta object for the reference '{@link de.hub.corpling.salt.saltCore.SRelation#getSourceSNode <em>Source SNode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source SNode</em>'.
	 * @see de.hub.corpling.salt.saltCore.SRelation#getSourceSNode()
	 * @see #getSRelation()
	 * @generated
	 */
	EReference getSRelation_SourceSNode();

	/**
	 * Returns the meta object for the reference '{@link de.hub.corpling.salt.saltCore.SRelation#getTargetSNode <em>Target SNode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target SNode</em>'.
	 * @see de.hub.corpling.salt.saltCore.SRelation#getTargetSNode()
	 * @see #getSRelation()
	 * @generated
	 */
	EReference getSRelation_TargetSNode();

	/**
	 * Returns the meta object for the container reference '{@link de.hub.corpling.salt.saltCore.SRelation#getSGraph <em>SGraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SGraph</em>'.
	 * @see de.hub.corpling.salt.saltCore.SRelation#getSGraph()
	 * @see #getSRelation()
	 * @generated
	 */
	EReference getSRelation_SGraph();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCore.SAnnotatableElement <em>SAnnotatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SAnnotatable Element</em>'.
	 * @see de.hub.corpling.salt.saltCore.SAnnotatableElement
	 * @generated
	 */
	EClass getSAnnotatableElement();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hub.corpling.salt.saltCore.SAnnotatableElement#getSAnnotations <em>SAnnotations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SAnnotations</em>'.
	 * @see de.hub.corpling.salt.saltCore.SAnnotatableElement#getSAnnotations()
	 * @see #getSAnnotatableElement()
	 * @generated
	 */
	EReference getSAnnotatableElement_SAnnotations();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCore.SAnnotation <em>SAnnotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SAnnotation</em>'.
	 * @see de.hub.corpling.salt.saltCore.SAnnotation
	 * @generated
	 */
	EClass getSAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link de.hub.corpling.salt.saltCore.SAnnotation#getSName <em>SName</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SName</em>'.
	 * @see de.hub.corpling.salt.saltCore.SAnnotation#getSName()
	 * @see #getSAnnotation()
	 * @generated
	 */
	EAttribute getSAnnotation_SName();

	/**
	 * Returns the meta object for the attribute '{@link de.hub.corpling.salt.saltCore.SAnnotation#getSValue <em>SValue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SValue</em>'.
	 * @see de.hub.corpling.salt.saltCore.SAnnotation#getSValue()
	 * @see #getSAnnotation()
	 * @generated
	 */
	EAttribute getSAnnotation_SValue();

	/**
	 * Returns the meta object for the container reference '{@link de.hub.corpling.salt.saltCore.SAnnotation#getSAnnotatbaleElement <em>SAnnotatbale Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SAnnotatbale Element</em>'.
	 * @see de.hub.corpling.salt.saltCore.SAnnotation#getSAnnotatbaleElement()
	 * @see #getSAnnotation()
	 * @generated
	 */
	EReference getSAnnotation_SAnnotatbaleElement();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCore.SGraph <em>SGraph</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SGraph</em>'.
	 * @see de.hub.corpling.salt.saltCore.SGraph
	 * @generated
	 */
	EClass getSGraph();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hub.corpling.salt.saltCore.SGraph#getSRelations <em>SRelations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SRelations</em>'.
	 * @see de.hub.corpling.salt.saltCore.SGraph#getSRelations()
	 * @see #getSGraph()
	 * @generated
	 */
	EReference getSGraph_SRelations();

	/**
	 * Returns the meta object for the containment reference list '{@link de.hub.corpling.salt.saltCore.SGraph#getSNodes <em>SNodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>SNodes</em>'.
	 * @see de.hub.corpling.salt.saltCore.SGraph#getSNodes()
	 * @see #getSGraph()
	 * @generated
	 */
	EReference getSGraph_SNodes();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCore.SNamedElement <em>SNamed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SNamed Element</em>'.
	 * @see de.hub.corpling.salt.saltCore.SNamedElement
	 * @generated
	 */
	EClass getSNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link de.hub.corpling.salt.saltCore.SNamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.hub.corpling.salt.saltCore.SNamedElement#getName()
	 * @see #getSNamedElement()
	 * @generated
	 */
	EAttribute getSNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCore.SIdentifiableElement <em>SIdentifiable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SIdentifiable Element</em>'.
	 * @see de.hub.corpling.salt.saltCore.SIdentifiableElement
	 * @generated
	 */
	EClass getSIdentifiableElement();

	/**
	 * Returns the meta object for the containment reference '{@link de.hub.corpling.salt.saltCore.SIdentifiableElement#getSElementId <em>SElement Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>SElement Id</em>'.
	 * @see de.hub.corpling.salt.saltCore.SIdentifiableElement#getSElementId()
	 * @see #getSIdentifiableElement()
	 * @generated
	 */
	EReference getSIdentifiableElement_SElementId();

	/**
	 * Returns the meta object for class '{@link de.hub.corpling.salt.saltCore.SElementId <em>SElement Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SElement Id</em>'.
	 * @see de.hub.corpling.salt.saltCore.SElementId
	 * @generated
	 */
	EClass getSElementId();

	/**
	 * Returns the meta object for the attribute '{@link de.hub.corpling.salt.saltCore.SElementId#getSId <em>SId</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SId</em>'.
	 * @see de.hub.corpling.salt.saltCore.SElementId#getSId()
	 * @see #getSElementId()
	 * @generated
	 */
	EAttribute getSElementId_SId();

	/**
	 * Returns the meta object for the container reference '{@link de.hub.corpling.salt.saltCore.SElementId#getSIdentifiableElement <em>SIdentifiable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>SIdentifiable Element</em>'.
	 * @see de.hub.corpling.salt.saltCore.SElementId#getSIdentifiableElement()
	 * @see #getSElementId()
	 * @generated
	 */
	EReference getSElementId_SIdentifiableElement();

	/**
	 * Returns the meta object for the attribute '{@link de.hub.corpling.salt.saltCore.SElementId#getSElementPath <em>SElement Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SElement Path</em>'.
	 * @see de.hub.corpling.salt.saltCore.SElementId#getSElementPath()
	 * @see #getSElementId()
	 * @generated
	 */
	EAttribute getSElementId_SElementPath();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.emf.common.util.URI <em>URI</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>URI</em>'.
	 * @see org.eclipse.emf.common.util.URI
	 * @model instanceClass="org.eclipse.emf.common.util.URI"
	 * @generated
	 */
	EDataType getURI();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SaltCoreFactory getSaltCoreFactory();

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
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCore.impl.SNodeImpl <em>SNode</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCore.impl.SNodeImpl
		 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSNode()
		 * @generated
		 */
		EClass SNODE = eINSTANCE.getSNode();

		/**
		 * The meta object literal for the '<em><b>SGraph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SNODE__SGRAPH = eINSTANCE.getSNode_SGraph();

		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCore.impl.SRelationImpl <em>SRelation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCore.impl.SRelationImpl
		 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSRelation()
		 * @generated
		 */
		EClass SRELATION = eINSTANCE.getSRelation();

		/**
		 * The meta object literal for the '<em><b>Source SNode</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SRELATION__SOURCE_SNODE = eINSTANCE.getSRelation_SourceSNode();

		/**
		 * The meta object literal for the '<em><b>Target SNode</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SRELATION__TARGET_SNODE = eINSTANCE.getSRelation_TargetSNode();

		/**
		 * The meta object literal for the '<em><b>SGraph</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SRELATION__SGRAPH = eINSTANCE.getSRelation_SGraph();

		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCore.impl.SAnnotatableElementImpl <em>SAnnotatable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCore.impl.SAnnotatableElementImpl
		 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSAnnotatableElement()
		 * @generated
		 */
		EClass SANNOTATABLE_ELEMENT = eINSTANCE.getSAnnotatableElement();

		/**
		 * The meta object literal for the '<em><b>SAnnotations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SANNOTATABLE_ELEMENT__SANNOTATIONS = eINSTANCE.getSAnnotatableElement_SAnnotations();

		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCore.impl.SAnnotationImpl <em>SAnnotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCore.impl.SAnnotationImpl
		 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSAnnotation()
		 * @generated
		 */
		EClass SANNOTATION = eINSTANCE.getSAnnotation();

		/**
		 * The meta object literal for the '<em><b>SName</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SANNOTATION__SNAME = eINSTANCE.getSAnnotation_SName();

		/**
		 * The meta object literal for the '<em><b>SValue</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SANNOTATION__SVALUE = eINSTANCE.getSAnnotation_SValue();

		/**
		 * The meta object literal for the '<em><b>SAnnotatbale Element</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SANNOTATION__SANNOTATBALE_ELEMENT = eINSTANCE.getSAnnotation_SAnnotatbaleElement();

		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCore.impl.SGraphImpl <em>SGraph</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCore.impl.SGraphImpl
		 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSGraph()
		 * @generated
		 */
		EClass SGRAPH = eINSTANCE.getSGraph();

		/**
		 * The meta object literal for the '<em><b>SRelations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SGRAPH__SRELATIONS = eINSTANCE.getSGraph_SRelations();

		/**
		 * The meta object literal for the '<em><b>SNodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SGRAPH__SNODES = eINSTANCE.getSGraph_SNodes();

		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCore.impl.SNamedElementImpl <em>SNamed Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCore.impl.SNamedElementImpl
		 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSNamedElement()
		 * @generated
		 */
		EClass SNAMED_ELEMENT = eINSTANCE.getSNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SNAMED_ELEMENT__NAME = eINSTANCE.getSNamedElement_Name();

		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCore.impl.SIdentifiableElementImpl <em>SIdentifiable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCore.impl.SIdentifiableElementImpl
		 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSIdentifiableElement()
		 * @generated
		 */
		EClass SIDENTIFIABLE_ELEMENT = eINSTANCE.getSIdentifiableElement();

		/**
		 * The meta object literal for the '<em><b>SElement Id</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIDENTIFIABLE_ELEMENT__SELEMENT_ID = eINSTANCE.getSIdentifiableElement_SElementId();

		/**
		 * The meta object literal for the '{@link de.hub.corpling.salt.saltCore.impl.SElementIdImpl <em>SElement Id</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.hub.corpling.salt.saltCore.impl.SElementIdImpl
		 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getSElementId()
		 * @generated
		 */
		EClass SELEMENT_ID = eINSTANCE.getSElementId();

		/**
		 * The meta object literal for the '<em><b>SId</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELEMENT_ID__SID = eINSTANCE.getSElementId_SId();

		/**
		 * The meta object literal for the '<em><b>SIdentifiable Element</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SELEMENT_ID__SIDENTIFIABLE_ELEMENT = eINSTANCE.getSElementId_SIdentifiableElement();

		/**
		 * The meta object literal for the '<em><b>SElement Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SELEMENT_ID__SELEMENT_PATH = eINSTANCE.getSElementId_SElementPath();

		/**
		 * The meta object literal for the '<em>URI</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.common.util.URI
		 * @see de.hub.corpling.salt.saltCore.impl.SaltCorePackageImpl#getURI()
		 * @generated
		 */
		EDataType URI = eINSTANCE.getURI();

	}

} //SaltCorePackage
