/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.util;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Layer;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage
 * @generated
 */
public class SaltCoreSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SaltCorePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltCoreSwitch() {
		if (modelPackage == null) {
			modelPackage = SaltCorePackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case SaltCorePackage.SNODE: {
				SNode sNode = (SNode)theEObject;
				T result = caseSNode(sNode);
				if (result == null) result = caseNode(sNode);
				if (result == null) result = caseSAnnotatableElement(sNode);
				if (result == null) result = caseSNamedElement(sNode);
				if (result == null) result = caseSIdentifiableElement(sNode);
				if (result == null) result = caseSProcessingAnnotatableElement(sNode);
				if (result == null) result = caseSFeaturableElement(sNode);
				if (result == null) result = caseSMetaAnnotatableElement(sNode);
				if (result == null) result = caseIdentifiableElement(sNode);
				if (result == null) result = caseLabelableElement(sNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.SRELATION: {
				SRelation sRelation = (SRelation)theEObject;
				T result = caseSRelation(sRelation);
				if (result == null) result = caseEdge(sRelation);
				if (result == null) result = caseSAnnotatableElement(sRelation);
				if (result == null) result = caseSNamedElement(sRelation);
				if (result == null) result = caseSIdentifiableElement(sRelation);
				if (result == null) result = caseSProcessingAnnotatableElement(sRelation);
				if (result == null) result = caseSFeaturableElement(sRelation);
				if (result == null) result = caseSMetaAnnotatableElement(sRelation);
				if (result == null) result = caseIdentifiableElement(sRelation);
				if (result == null) result = caseLabelableElement(sRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.SANNOTATABLE_ELEMENT: {
				SAnnotatableElement sAnnotatableElement = (SAnnotatableElement)theEObject;
				T result = caseSAnnotatableElement(sAnnotatableElement);
				if (result == null) result = caseLabelableElement(sAnnotatableElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.SANNOTATION: {
				SAnnotation sAnnotation = (SAnnotation)theEObject;
				T result = caseSAnnotation(sAnnotation);
				if (result == null) result = caseSAbstractAnnotation(sAnnotation);
				if (result == null) result = caseLabel(sAnnotation);
				if (result == null) result = caseLabelableElement(sAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.SGRAPH: {
				SGraph sGraph = (SGraph)theEObject;
				T result = caseSGraph(sGraph);
				if (result == null) result = caseGraph(sGraph);
				if (result == null) result = caseSNamedElement(sGraph);
				if (result == null) result = caseSAnnotatableElement(sGraph);
				if (result == null) result = caseSIdentifiableElement(sGraph);
				if (result == null) result = caseSProcessingAnnotatableElement(sGraph);
				if (result == null) result = caseSFeaturableElement(sGraph);
				if (result == null) result = caseSMetaAnnotatableElement(sGraph);
				if (result == null) result = caseIdentifiableElement(sGraph);
				if (result == null) result = caseLabelableElement(sGraph);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.SNAMED_ELEMENT: {
				SNamedElement sNamedElement = (SNamedElement)theEObject;
				T result = caseSNamedElement(sNamedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT: {
				SIdentifiableElement sIdentifiableElement = (SIdentifiableElement)theEObject;
				T result = caseSIdentifiableElement(sIdentifiableElement);
				if (result == null) result = caseIdentifiableElement(sIdentifiableElement);
				if (result == null) result = caseLabelableElement(sIdentifiableElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.SPROCESSING_ANNOTATION: {
				SProcessingAnnotation sProcessingAnnotation = (SProcessingAnnotation)theEObject;
				T result = caseSProcessingAnnotation(sProcessingAnnotation);
				if (result == null) result = caseSAbstractAnnotation(sProcessingAnnotation);
				if (result == null) result = caseLabel(sProcessingAnnotation);
				if (result == null) result = caseLabelableElement(sProcessingAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.SPROCESSING_ANNOTATABLE_ELEMENT: {
				SProcessingAnnotatableElement sProcessingAnnotatableElement = (SProcessingAnnotatableElement)theEObject;
				T result = caseSProcessingAnnotatableElement(sProcessingAnnotatableElement);
				if (result == null) result = caseLabelableElement(sProcessingAnnotatableElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.SELEMENT_ID: {
				SElementId sElementId = (SElementId)theEObject;
				T result = caseSElementId(sElementId);
				if (result == null) result = caseIdentifier(sElementId);
				if (result == null) result = caseLabel(sElementId);
				if (result == null) result = caseLabelableElement(sElementId);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.SFEATURE: {
				SFeature sFeature = (SFeature)theEObject;
				T result = caseSFeature(sFeature);
				if (result == null) result = caseSAbstractAnnotation(sFeature);
				if (result == null) result = caseLabel(sFeature);
				if (result == null) result = caseLabelableElement(sFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.SFEATURABLE_ELEMENT: {
				SFeaturableElement sFeaturableElement = (SFeaturableElement)theEObject;
				T result = caseSFeaturableElement(sFeaturableElement);
				if (result == null) result = caseLabelableElement(sFeaturableElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.SMETA_ANNOTATABLE_ELEMENT: {
				SMetaAnnotatableElement sMetaAnnotatableElement = (SMetaAnnotatableElement)theEObject;
				T result = caseSMetaAnnotatableElement(sMetaAnnotatableElement);
				if (result == null) result = caseLabelableElement(sMetaAnnotatableElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.SMETA_ANNOTATION: {
				SMetaAnnotation sMetaAnnotation = (SMetaAnnotation)theEObject;
				T result = caseSMetaAnnotation(sMetaAnnotation);
				if (result == null) result = caseSAbstractAnnotation(sMetaAnnotation);
				if (result == null) result = caseLabel(sMetaAnnotation);
				if (result == null) result = caseLabelableElement(sMetaAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.SABSTRACT_ANNOTATION: {
				SAbstractAnnotation sAbstractAnnotation = (SAbstractAnnotation)theEObject;
				T result = caseSAbstractAnnotation(sAbstractAnnotation);
				if (result == null) result = caseLabel(sAbstractAnnotation);
				if (result == null) result = caseLabelableElement(sAbstractAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.SLAYER: {
				SLayer sLayer = (SLayer)theEObject;
				T result = caseSLayer(sLayer);
				if (result == null) result = caseLayer(sLayer);
				if (result == null) result = caseSNamedElement(sLayer);
				if (result == null) result = caseSIdentifiableElement(sLayer);
				if (result == null) result = caseSProcessingAnnotatableElement(sLayer);
				if (result == null) result = caseSAnnotatableElement(sLayer);
				if (result == null) result = caseSMetaAnnotatableElement(sLayer);
				if (result == null) result = caseSFeaturableElement(sLayer);
				if (result == null) result = caseIdentifiableElement(sLayer);
				if (result == null) result = caseLabelableElement(sLayer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SNode</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SNode</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSNode(SNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SRelation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SRelation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSRelation(SRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SAnnotatable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SAnnotatable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSAnnotatableElement(SAnnotatableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SAnnotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SAnnotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSAnnotation(SAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SGraph</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SGraph</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSGraph(SGraph object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SNamed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SNamed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSNamedElement(SNamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SIdentifiable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SIdentifiable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSIdentifiableElement(SIdentifiableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SProcessing Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SProcessing Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSProcessingAnnotation(SProcessingAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SProcessing Annotatable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SProcessing Annotatable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSProcessingAnnotatableElement(SProcessingAnnotatableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SElement Id</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SElement Id</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSElementId(SElementId object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SFeature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SFeature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSFeature(SFeature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SFeaturable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SFeaturable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSFeaturableElement(SFeaturableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SMeta Annotatable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SMeta Annotatable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSMetaAnnotatableElement(SMetaAnnotatableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SMeta Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SMeta Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSMetaAnnotation(SMetaAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SAbstract Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SAbstract Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSAbstractAnnotation(SAbstractAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SLayer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SLayer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSLayer(SLayer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Labelable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Labelable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLabelableElement(LabelableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifiable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifiable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifiableElement(IdentifiableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNode(Node object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Edge</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Edge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEdge(Edge object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLabel(Label object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Graph</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Graph</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGraph(Graph object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifier(Identifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Layer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Layer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLayer(Layer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //SaltCoreSwitch
