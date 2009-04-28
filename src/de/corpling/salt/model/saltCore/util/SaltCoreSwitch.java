/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.saltCore.util;

import de.corpling.salt.model.saltCore.*;

import de.util.graph.Edge;
import de.util.graph.Graph;
import de.util.graph.IdentifiableElement;
import de.util.graph.IndexMgr;
import de.util.graph.Label;
import de.util.graph.LabelableElement;
import de.util.graph.Node;

import de.util.graph.TraversalObject;
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
 * @see de.corpling.salt.model.saltCore.SaltCorePackage
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
			case SaltCorePackage.SIDENTIFIABLE_ELEMENT: {
				SIdentifiableElement sIdentifiableElement = (SIdentifiableElement)theEObject;
				T result = caseSIdentifiableElement(sIdentifiableElement);
				if (result == null) result = caseSNamedElement(sIdentifiableElement);
				if (result == null) result = caseIdentifiableElement(sIdentifiableElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.SELEMENT: {
				SElement sElement = (SElement)theEObject;
				T result = caseSElement(sElement);
				if (result == null) result = caseSIdentifiableElement(sElement);
				if (result == null) result = caseSAnnotatableElement(sElement);
				if (result == null) result = caseSStereotypeableElement(sElement);
				if (result == null) result = caseSProcessingAnnotatableElement(sElement);
				if (result == null) result = caseNode(sElement);
				if (result == null) result = caseSNamedElement(sElement);
				if (result == null) result = caseIdentifiableElement(sElement);
				if (result == null) result = caseLabelableElement(sElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.SANNOTATION: {
				SAnnotation sAnnotation = (SAnnotation)theEObject;
				T result = caseSAnnotation(sAnnotation);
				if (result == null) result = caseLabel(sAnnotation);
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
			case SaltCorePackage.SRELATION: {
				SRelation sRelation = (SRelation)theEObject;
				T result = caseSRelation(sRelation);
				if (result == null) result = caseEdge(sRelation);
				if (result == null) result = caseSIdentifiableElement(sRelation);
				if (result == null) result = caseSAnnotatableElement(sRelation);
				if (result == null) result = caseSStereotypeableElement(sRelation);
				if (result == null) result = caseSProcessingAnnotatableElement(sRelation);
				if (result == null) result = caseIdentifiableElement(sRelation);
				if (result == null) result = caseLabelableElement(sRelation);
				if (result == null) result = caseSNamedElement(sRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.SNAMED_ELEMENT: {
				SNamedElement sNamedElement = (SNamedElement)theEObject;
				T result = caseSNamedElement(sNamedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.SSTEREOTYPEABLE_ELEMENT: {
				SStereotypeableElement sStereotypeableElement = (SStereotypeableElement)theEObject;
				T result = caseSStereotypeableElement(sStereotypeableElement);
				if (result == null) result = caseLabelableElement(sStereotypeableElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.SFEATURE: {
				SFeature sFeature = (SFeature)theEObject;
				T result = caseSFeature(sFeature);
				if (result == null) result = caseLabel(sFeature);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.SSTEREOTYPE: {
				SStereotype sStereotype = (SStereotype)theEObject;
				T result = caseSStereotype(sStereotype);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.SFEATURE_DESCRIPTION: {
				SFeatureDescription sFeatureDescription = (SFeatureDescription)theEObject;
				T result = caseSFeatureDescription(sFeatureDescription);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.SGRAPH: {
				SGraph sGraph = (SGraph)theEObject;
				T result = caseSGraph(sGraph);
				if (result == null) result = caseGraph(sGraph);
				if (result == null) result = caseIdentifiableElement(sGraph);
				if (result == null) result = caseLabelableElement(sGraph);
				if (result == null) result = caseIndexMgr(sGraph);
				if (result == null) result = caseTraversalObject(sGraph);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.SCORE_PROJECT: {
				SCoreProject sCoreProject = (SCoreProject)theEObject;
				T result = caseSCoreProject(sCoreProject);
				if (result == null) result = caseSStereotypeContainer(sCoreProject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.SSTEREOTYPE_CONTAINER: {
				SStereotypeContainer sStereotypeContainer = (SStereotypeContainer)theEObject;
				T result = caseSStereotypeContainer(sStereotypeContainer);
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
			case SaltCorePackage.SPROCESSING_ANNOTATION: {
				SProcessingAnnotation sProcessingAnnotation = (SProcessingAnnotation)theEObject;
				T result = caseSProcessingAnnotation(sProcessingAnnotation);
				if (result == null) result = caseLabel(sProcessingAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltCorePackage.STRAVERSAL_OBJECT: {
				STraversalObject sTraversalObject = (STraversalObject)theEObject;
				T result = caseSTraversalObject(sTraversalObject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
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
	 * Returns the result of interpreting the object as an instance of '<em>SElement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SElement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSElement(SElement object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>SStereotypeable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SStereotypeable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSStereotypeableElement(SStereotypeableElement object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>SStereotype</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SStereotype</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSStereotype(SStereotype object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SFeature Description</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SFeature Description</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSFeatureDescription(SFeatureDescription object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>SCore Project</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCore Project</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSCoreProject(SCoreProject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SStereotype Container</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SStereotype Container</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSStereotypeContainer(SStereotypeContainer object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>STraversal Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>STraversal Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSTraversalObject(STraversalObject object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Index Mgr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Index Mgr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIndexMgr(IndexMgr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Traversal Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Traversal Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTraversalObject(TraversalObject object) {
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
