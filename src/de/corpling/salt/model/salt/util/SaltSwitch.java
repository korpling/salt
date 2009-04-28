/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.salt.util;

import de.corpling.salt.model.salt.*;

import de.corpling.salt.model.saltCore.SAnnotatableElement;
import de.corpling.salt.model.saltCore.SCoreProject;
import de.corpling.salt.model.saltCore.SElement;
import de.corpling.salt.model.saltCore.SGraph;
import de.corpling.salt.model.saltCore.SIdentifiableElement;
import de.corpling.salt.model.saltCore.SNamedElement;
import de.corpling.salt.model.saltCore.SProcessingAnnotatableElement;
import de.corpling.salt.model.saltCore.SRelation;
import de.corpling.salt.model.saltCore.SStereotypeContainer;
import de.corpling.salt.model.saltCore.SStereotypeableElement;

import de.util.graph.Edge;
import de.util.graph.Graph;
import de.util.graph.IdentifiableElement;
import de.util.graph.IndexMgr;
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
 * @see de.corpling.salt.model.salt.SaltPackage
 * @generated
 */
public class SaltSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SaltPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltSwitch() {
		if (modelPackage == null) {
			modelPackage = SaltPackage.eINSTANCE;
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
			case SaltPackage.STOKEN: {
				SToken sToken = (SToken)theEObject;
				T result = caseSToken(sToken);
				if (result == null) result = caseSElement(sToken);
				if (result == null) result = caseSIdentifiableElement(sToken);
				if (result == null) result = caseSAnnotatableElement(sToken);
				if (result == null) result = caseSStereotypeableElement(sToken);
				if (result == null) result = caseSProcessingAnnotatableElement(sToken);
				if (result == null) result = caseNode(sToken);
				if (result == null) result = caseSNamedElement(sToken);
				if (result == null) result = caseIdentifiableElement(sToken);
				if (result == null) result = caseLabelableElement(sToken);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltPackage.SDATA_SOURCE: {
				SDataSource sDataSource = (SDataSource)theEObject;
				T result = caseSDataSource(sDataSource);
				if (result == null) result = caseSElement(sDataSource);
				if (result == null) result = caseSIdentifiableElement(sDataSource);
				if (result == null) result = caseSAnnotatableElement(sDataSource);
				if (result == null) result = caseSStereotypeableElement(sDataSource);
				if (result == null) result = caseSProcessingAnnotatableElement(sDataSource);
				if (result == null) result = caseNode(sDataSource);
				if (result == null) result = caseSNamedElement(sDataSource);
				if (result == null) result = caseIdentifiableElement(sDataSource);
				if (result == null) result = caseLabelableElement(sDataSource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltPackage.STEXTUAL_DATA_SOURCE: {
				STextualDataSource sTextualDataSource = (STextualDataSource)theEObject;
				T result = caseSTextualDataSource(sTextualDataSource);
				if (result == null) result = caseSDataSource(sTextualDataSource);
				if (result == null) result = caseSElement(sTextualDataSource);
				if (result == null) result = caseSIdentifiableElement(sTextualDataSource);
				if (result == null) result = caseSAnnotatableElement(sTextualDataSource);
				if (result == null) result = caseSStereotypeableElement(sTextualDataSource);
				if (result == null) result = caseSProcessingAnnotatableElement(sTextualDataSource);
				if (result == null) result = caseNode(sTextualDataSource);
				if (result == null) result = caseSNamedElement(sTextualDataSource);
				if (result == null) result = caseIdentifiableElement(sTextualDataSource);
				if (result == null) result = caseLabelableElement(sTextualDataSource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltPackage.SDOCUMENT_GRAPH: {
				SDocumentGraph sDocumentGraph = (SDocumentGraph)theEObject;
				T result = caseSDocumentGraph(sDocumentGraph);
				if (result == null) result = caseSGraph(sDocumentGraph);
				if (result == null) result = caseGraph(sDocumentGraph);
				if (result == null) result = caseIdentifiableElement(sDocumentGraph);
				if (result == null) result = caseLabelableElement(sDocumentGraph);
				if (result == null) result = caseIndexMgr(sDocumentGraph);
				if (result == null) result = caseTraversalObject(sDocumentGraph);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltPackage.STEXTUAL_RELATION: {
				STextualRelation sTextualRelation = (STextualRelation)theEObject;
				T result = caseSTextualRelation(sTextualRelation);
				if (result == null) result = caseSRelation(sTextualRelation);
				if (result == null) result = caseEdge(sTextualRelation);
				if (result == null) result = caseSIdentifiableElement(sTextualRelation);
				if (result == null) result = caseSAnnotatableElement(sTextualRelation);
				if (result == null) result = caseSStereotypeableElement(sTextualRelation);
				if (result == null) result = caseSProcessingAnnotatableElement(sTextualRelation);
				if (result == null) result = caseIdentifiableElement(sTextualRelation);
				if (result == null) result = caseLabelableElement(sTextualRelation);
				if (result == null) result = caseSNamedElement(sTextualRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltPackage.SSTRUCTURE: {
				SStructure sStructure = (SStructure)theEObject;
				T result = caseSStructure(sStructure);
				if (result == null) result = caseSElement(sStructure);
				if (result == null) result = caseSIdentifiableElement(sStructure);
				if (result == null) result = caseSAnnotatableElement(sStructure);
				if (result == null) result = caseSStereotypeableElement(sStructure);
				if (result == null) result = caseSProcessingAnnotatableElement(sStructure);
				if (result == null) result = caseNode(sStructure);
				if (result == null) result = caseSNamedElement(sStructure);
				if (result == null) result = caseIdentifiableElement(sStructure);
				if (result == null) result = caseLabelableElement(sStructure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltPackage.SSPAN_RELATION: {
				SSpanRelation sSpanRelation = (SSpanRelation)theEObject;
				T result = caseSSpanRelation(sSpanRelation);
				if (result == null) result = caseSRelation(sSpanRelation);
				if (result == null) result = caseEdge(sSpanRelation);
				if (result == null) result = caseSIdentifiableElement(sSpanRelation);
				if (result == null) result = caseSAnnotatableElement(sSpanRelation);
				if (result == null) result = caseSStereotypeableElement(sSpanRelation);
				if (result == null) result = caseSProcessingAnnotatableElement(sSpanRelation);
				if (result == null) result = caseIdentifiableElement(sSpanRelation);
				if (result == null) result = caseLabelableElement(sSpanRelation);
				if (result == null) result = caseSNamedElement(sSpanRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltPackage.SPROJECT: {
				SProject sProject = (SProject)theEObject;
				T result = caseSProject(sProject);
				if (result == null) result = caseSCoreProject(sProject);
				if (result == null) result = caseSStereotypeContainer(sProject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltPackage.SCORPUS: {
				SCorpus sCorpus = (SCorpus)theEObject;
				T result = caseSCorpus(sCorpus);
				if (result == null) result = caseSElement(sCorpus);
				if (result == null) result = caseSIdentifiableElement(sCorpus);
				if (result == null) result = caseSAnnotatableElement(sCorpus);
				if (result == null) result = caseSStereotypeableElement(sCorpus);
				if (result == null) result = caseSProcessingAnnotatableElement(sCorpus);
				if (result == null) result = caseNode(sCorpus);
				if (result == null) result = caseSNamedElement(sCorpus);
				if (result == null) result = caseIdentifiableElement(sCorpus);
				if (result == null) result = caseLabelableElement(sCorpus);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltPackage.SCORPUS_GRAPH: {
				SCorpusGraph sCorpusGraph = (SCorpusGraph)theEObject;
				T result = caseSCorpusGraph(sCorpusGraph);
				if (result == null) result = caseSGraph(sCorpusGraph);
				if (result == null) result = caseGraph(sCorpusGraph);
				if (result == null) result = caseIdentifiableElement(sCorpusGraph);
				if (result == null) result = caseLabelableElement(sCorpusGraph);
				if (result == null) result = caseIndexMgr(sCorpusGraph);
				if (result == null) result = caseTraversalObject(sCorpusGraph);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltPackage.SDOCUMENT: {
				SDocument sDocument = (SDocument)theEObject;
				T result = caseSDocument(sDocument);
				if (result == null) result = caseSElement(sDocument);
				if (result == null) result = caseSIdentifiableElement(sDocument);
				if (result == null) result = caseSAnnotatableElement(sDocument);
				if (result == null) result = caseSStereotypeableElement(sDocument);
				if (result == null) result = caseSProcessingAnnotatableElement(sDocument);
				if (result == null) result = caseNode(sDocument);
				if (result == null) result = caseSNamedElement(sDocument);
				if (result == null) result = caseIdentifiableElement(sDocument);
				if (result == null) result = caseLabelableElement(sDocument);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltPackage.SCORPUS_RELATION: {
				SCorpusRelation sCorpusRelation = (SCorpusRelation)theEObject;
				T result = caseSCorpusRelation(sCorpusRelation);
				if (result == null) result = caseSRelation(sCorpusRelation);
				if (result == null) result = caseEdge(sCorpusRelation);
				if (result == null) result = caseSIdentifiableElement(sCorpusRelation);
				if (result == null) result = caseSAnnotatableElement(sCorpusRelation);
				if (result == null) result = caseSStereotypeableElement(sCorpusRelation);
				if (result == null) result = caseSProcessingAnnotatableElement(sCorpusRelation);
				if (result == null) result = caseIdentifiableElement(sCorpusRelation);
				if (result == null) result = caseLabelableElement(sCorpusRelation);
				if (result == null) result = caseSNamedElement(sCorpusRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltPackage.SCORP_DOC_RELATION: {
				SCorpDocRelation sCorpDocRelation = (SCorpDocRelation)theEObject;
				T result = caseSCorpDocRelation(sCorpDocRelation);
				if (result == null) result = caseSRelation(sCorpDocRelation);
				if (result == null) result = caseEdge(sCorpDocRelation);
				if (result == null) result = caseSIdentifiableElement(sCorpDocRelation);
				if (result == null) result = caseSAnnotatableElement(sCorpDocRelation);
				if (result == null) result = caseSStereotypeableElement(sCorpDocRelation);
				if (result == null) result = caseSProcessingAnnotatableElement(sCorpDocRelation);
				if (result == null) result = caseIdentifiableElement(sCorpDocRelation);
				if (result == null) result = caseLabelableElement(sCorpDocRelation);
				if (result == null) result = caseSNamedElement(sCorpDocRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltPackage.SDOMINANCE_RELATION: {
				SDominanceRelation sDominanceRelation = (SDominanceRelation)theEObject;
				T result = caseSDominanceRelation(sDominanceRelation);
				if (result == null) result = caseSRelation(sDominanceRelation);
				if (result == null) result = caseEdge(sDominanceRelation);
				if (result == null) result = caseSIdentifiableElement(sDominanceRelation);
				if (result == null) result = caseSAnnotatableElement(sDominanceRelation);
				if (result == null) result = caseSStereotypeableElement(sDominanceRelation);
				if (result == null) result = caseSProcessingAnnotatableElement(sDominanceRelation);
				if (result == null) result = caseIdentifiableElement(sDominanceRelation);
				if (result == null) result = caseLabelableElement(sDominanceRelation);
				if (result == null) result = caseSNamedElement(sDominanceRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SaltPackage.SPOINTING_RELATION: {
				SPointingRelation sPointingRelation = (SPointingRelation)theEObject;
				T result = caseSPointingRelation(sPointingRelation);
				if (result == null) result = caseSRelation(sPointingRelation);
				if (result == null) result = caseEdge(sPointingRelation);
				if (result == null) result = caseSIdentifiableElement(sPointingRelation);
				if (result == null) result = caseSAnnotatableElement(sPointingRelation);
				if (result == null) result = caseSStereotypeableElement(sPointingRelation);
				if (result == null) result = caseSProcessingAnnotatableElement(sPointingRelation);
				if (result == null) result = caseIdentifiableElement(sPointingRelation);
				if (result == null) result = caseLabelableElement(sPointingRelation);
				if (result == null) result = caseSNamedElement(sPointingRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
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
	 * Returns the result of interpreting the object as an instance of '<em>SData Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SData Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSDataSource(SDataSource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>STextual Data Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>STextual Data Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSTextualDataSource(STextualDataSource object) {
		return null;
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
	 * Returns the result of interpreting the object as an instance of '<em>SStructure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SStructure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSStructure(SStructure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SSpan Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SSpan Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSSpanRelation(SSpanRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SProject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SProject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSProject(SProject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCorpus</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCorpus</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSCorpus(SCorpus object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCorpus Graph</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCorpus Graph</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSCorpusGraph(SCorpusGraph object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SDocument</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SDocument</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSDocument(SDocument object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCorpus Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCorpus Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSCorpusRelation(SCorpusRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SCorp Doc Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SCorp Doc Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSCorpDocRelation(SCorpDocRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SDominance Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SDominance Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSDominanceRelation(SDominanceRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SPointing Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SPointing Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSPointingRelation(SPointingRelation object) {
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

} //SaltSwitch
