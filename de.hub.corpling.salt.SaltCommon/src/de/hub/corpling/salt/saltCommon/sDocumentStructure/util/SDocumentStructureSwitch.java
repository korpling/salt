/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure.util;

import de.hub.corpling.graph.Edge;
import de.hub.corpling.graph.Graph;
import de.hub.corpling.graph.IdentifiableElement;
import de.hub.corpling.graph.LabelableElement;
import de.hub.corpling.graph.Node;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.*;

import de.hub.corpling.salt.saltCore.SAnnotatableElement;
import de.hub.corpling.salt.saltCore.SFeaturableElement;
import de.hub.corpling.salt.saltCore.SGraph;
import de.hub.corpling.salt.saltCore.SIdentifiableElement;
import de.hub.corpling.salt.saltCore.SNamedElement;

import de.hub.corpling.salt.saltCore.SNode;
import de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement;
import de.hub.corpling.salt.saltCore.SRelation;
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
 * @see de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage
 * @generated
 */
public class SDocumentStructureSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SDocumentStructurePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDocumentStructureSwitch() {
		if (modelPackage == null) {
			modelPackage = SDocumentStructurePackage.eINSTANCE;
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
			case SDocumentStructurePackage.SDOCUMENT_GRAPH: {
				SDocumentGraph sDocumentGraph = (SDocumentGraph)theEObject;
				T result = caseSDocumentGraph(sDocumentGraph);
				if (result == null) result = caseSGraph(sDocumentGraph);
				if (result == null) result = caseGraph(sDocumentGraph);
				if (result == null) result = caseSNamedElement(sDocumentGraph);
				if (result == null) result = caseSAnnotatableElement(sDocumentGraph);
				if (result == null) result = caseSIdentifiableElement(sDocumentGraph);
				if (result == null) result = caseSProcessingAnnotatableElement(sDocumentGraph);
				if (result == null) result = caseSFeaturableElement(sDocumentGraph);
				if (result == null) result = caseLabelableElement(sDocumentGraph);
				if (result == null) result = caseIdentifiableElement(sDocumentGraph);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDocumentStructurePackage.STEXTUAL_DS: {
				STextualDS sTextualDS = (STextualDS)theEObject;
				T result = caseSTextualDS(sTextualDS);
				if (result == null) result = caseSSequentialDS(sTextualDS);
				if (result == null) result = caseSNode(sTextualDS);
				if (result == null) result = caseNode(sTextualDS);
				if (result == null) result = caseSAnnotatableElement(sTextualDS);
				if (result == null) result = caseSNamedElement(sTextualDS);
				if (result == null) result = caseSIdentifiableElement(sTextualDS);
				if (result == null) result = caseSProcessingAnnotatableElement(sTextualDS);
				if (result == null) result = caseSFeaturableElement(sTextualDS);
				if (result == null) result = caseLabelableElement(sTextualDS);
				if (result == null) result = caseIdentifiableElement(sTextualDS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDocumentStructurePackage.STOKEN: {
				SToken sToken = (SToken)theEObject;
				T result = caseSToken(sToken);
				if (result == null) result = caseSNode(sToken);
				if (result == null) result = caseNode(sToken);
				if (result == null) result = caseSAnnotatableElement(sToken);
				if (result == null) result = caseSNamedElement(sToken);
				if (result == null) result = caseSIdentifiableElement(sToken);
				if (result == null) result = caseSProcessingAnnotatableElement(sToken);
				if (result == null) result = caseSFeaturableElement(sToken);
				if (result == null) result = caseLabelableElement(sToken);
				if (result == null) result = caseIdentifiableElement(sToken);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDocumentStructurePackage.STEXTUAL_RELATION: {
				STextualRelation sTextualRelation = (STextualRelation)theEObject;
				T result = caseSTextualRelation(sTextualRelation);
				if (result == null) result = caseSSequentialRelation(sTextualRelation);
				if (result == null) result = caseSRelation(sTextualRelation);
				if (result == null) result = caseEdge(sTextualRelation);
				if (result == null) result = caseSAnnotatableElement(sTextualRelation);
				if (result == null) result = caseSNamedElement(sTextualRelation);
				if (result == null) result = caseSIdentifiableElement(sTextualRelation);
				if (result == null) result = caseSProcessingAnnotatableElement(sTextualRelation);
				if (result == null) result = caseSFeaturableElement(sTextualRelation);
				if (result == null) result = caseLabelableElement(sTextualRelation);
				if (result == null) result = caseIdentifiableElement(sTextualRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDocumentStructurePackage.SSEQUENTIAL_RELATION: {
				SSequentialRelation sSequentialRelation = (SSequentialRelation)theEObject;
				T result = caseSSequentialRelation(sSequentialRelation);
				if (result == null) result = caseSRelation(sSequentialRelation);
				if (result == null) result = caseEdge(sSequentialRelation);
				if (result == null) result = caseSAnnotatableElement(sSequentialRelation);
				if (result == null) result = caseSNamedElement(sSequentialRelation);
				if (result == null) result = caseSIdentifiableElement(sSequentialRelation);
				if (result == null) result = caseSProcessingAnnotatableElement(sSequentialRelation);
				if (result == null) result = caseSFeaturableElement(sSequentialRelation);
				if (result == null) result = caseLabelableElement(sSequentialRelation);
				if (result == null) result = caseIdentifiableElement(sSequentialRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDocumentStructurePackage.SSEQUENTIAL_DS: {
				SSequentialDS sSequentialDS = (SSequentialDS)theEObject;
				T result = caseSSequentialDS(sSequentialDS);
				if (result == null) result = caseSNode(sSequentialDS);
				if (result == null) result = caseNode(sSequentialDS);
				if (result == null) result = caseSAnnotatableElement(sSequentialDS);
				if (result == null) result = caseSNamedElement(sSequentialDS);
				if (result == null) result = caseSIdentifiableElement(sSequentialDS);
				if (result == null) result = caseSProcessingAnnotatableElement(sSequentialDS);
				if (result == null) result = caseSFeaturableElement(sSequentialDS);
				if (result == null) result = caseLabelableElement(sSequentialDS);
				if (result == null) result = caseIdentifiableElement(sSequentialDS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDocumentStructurePackage.STIMELINE: {
				STimeline sTimeline = (STimeline)theEObject;
				T result = caseSTimeline(sTimeline);
				if (result == null) result = caseSSequentialDS(sTimeline);
				if (result == null) result = caseSNode(sTimeline);
				if (result == null) result = caseNode(sTimeline);
				if (result == null) result = caseSAnnotatableElement(sTimeline);
				if (result == null) result = caseSNamedElement(sTimeline);
				if (result == null) result = caseSIdentifiableElement(sTimeline);
				if (result == null) result = caseSProcessingAnnotatableElement(sTimeline);
				if (result == null) result = caseSFeaturableElement(sTimeline);
				if (result == null) result = caseLabelableElement(sTimeline);
				if (result == null) result = caseIdentifiableElement(sTimeline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SDocument Graph</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SDocument Graph</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSDocumentGraph(SDocumentGraph object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>STextual DS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>STextual DS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSTextualDS(STextualDS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SToken</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SToken</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSToken(SToken object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>STextual Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>STextual Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSTextualRelation(STextualRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SSequential Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SSequential Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSSequentialRelation(SSequentialRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SSequential DS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SSequential DS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSSequentialDS(SSequentialDS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>STimeline</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>STimeline</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSTimeline(STimeline object) {
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

} //SDocumentStructureSwitch
