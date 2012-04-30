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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.util;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.*;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNamedElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node;


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
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage
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
				if (result == null) result = caseSMetaAnnotatableElement(sDocumentGraph);
				if (result == null) result = caseIdentifiableElement(sDocumentGraph);
				if (result == null) result = caseSFeaturableElement(sDocumentGraph);
				if (result == null) result = caseLabelableElement(sDocumentGraph);
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
				if (result == null) result = caseSMetaAnnotatableElement(sTextualDS);
				if (result == null) result = caseIdentifiableElement(sTextualDS);
				if (result == null) result = caseSFeaturableElement(sTextualDS);
				if (result == null) result = caseLabelableElement(sTextualDS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDocumentStructurePackage.STOKEN: {
				SToken sToken = (SToken)theEObject;
				T result = caseSToken(sToken);
				if (result == null) result = caseSStructuredNode(sToken);
				if (result == null) result = caseSNode(sToken);
				if (result == null) result = caseNode(sToken);
				if (result == null) result = caseSAnnotatableElement(sToken);
				if (result == null) result = caseSNamedElement(sToken);
				if (result == null) result = caseSIdentifiableElement(sToken);
				if (result == null) result = caseSProcessingAnnotatableElement(sToken);
				if (result == null) result = caseSMetaAnnotatableElement(sToken);
				if (result == null) result = caseIdentifiableElement(sToken);
				if (result == null) result = caseSFeaturableElement(sToken);
				if (result == null) result = caseLabelableElement(sToken);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDocumentStructurePackage.STEXTUAL_RELATION: {
				STextualRelation sTextualRelation = (STextualRelation)theEObject;
				T result = caseSTextualRelation(sTextualRelation);
				if (result == null) result = caseSSequentialRelation(sTextualRelation);
				if (result == null) result = caseSTextOverlappingRelation(sTextualRelation);
				if (result == null) result = caseSRelation(sTextualRelation);
				if (result == null) result = caseEdge(sTextualRelation);
				if (result == null) result = caseSAnnotatableElement(sTextualRelation);
				if (result == null) result = caseSNamedElement(sTextualRelation);
				if (result == null) result = caseSIdentifiableElement(sTextualRelation);
				if (result == null) result = caseSProcessingAnnotatableElement(sTextualRelation);
				if (result == null) result = caseSMetaAnnotatableElement(sTextualRelation);
				if (result == null) result = caseIdentifiableElement(sTextualRelation);
				if (result == null) result = caseSFeaturableElement(sTextualRelation);
				if (result == null) result = caseLabelableElement(sTextualRelation);
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
				if (result == null) result = caseSMetaAnnotatableElement(sSequentialRelation);
				if (result == null) result = caseIdentifiableElement(sSequentialRelation);
				if (result == null) result = caseSFeaturableElement(sSequentialRelation);
				if (result == null) result = caseLabelableElement(sSequentialRelation);
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
				if (result == null) result = caseSMetaAnnotatableElement(sSequentialDS);
				if (result == null) result = caseIdentifiableElement(sSequentialDS);
				if (result == null) result = caseSFeaturableElement(sSequentialDS);
				if (result == null) result = caseLabelableElement(sSequentialDS);
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
				if (result == null) result = caseSMetaAnnotatableElement(sTimeline);
				if (result == null) result = caseIdentifiableElement(sTimeline);
				if (result == null) result = caseSFeaturableElement(sTimeline);
				if (result == null) result = caseLabelableElement(sTimeline);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDocumentStructurePackage.STIMELINE_RELATION: {
				STimelineRelation sTimelineRelation = (STimelineRelation)theEObject;
				T result = caseSTimelineRelation(sTimelineRelation);
				if (result == null) result = caseSSequentialRelation(sTimelineRelation);
				if (result == null) result = caseSTimeOverlappingRelation(sTimelineRelation);
				if (result == null) result = caseSRelation(sTimelineRelation);
				if (result == null) result = caseEdge(sTimelineRelation);
				if (result == null) result = caseSAnnotatableElement(sTimelineRelation);
				if (result == null) result = caseSNamedElement(sTimelineRelation);
				if (result == null) result = caseSIdentifiableElement(sTimelineRelation);
				if (result == null) result = caseSProcessingAnnotatableElement(sTimelineRelation);
				if (result == null) result = caseSMetaAnnotatableElement(sTimelineRelation);
				if (result == null) result = caseIdentifiableElement(sTimelineRelation);
				if (result == null) result = caseSFeaturableElement(sTimelineRelation);
				if (result == null) result = caseLabelableElement(sTimelineRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDocumentStructurePackage.SSPAN: {
				SSpan sSpan = (SSpan)theEObject;
				T result = caseSSpan(sSpan);
				if (result == null) result = caseSStructuredNode(sSpan);
				if (result == null) result = caseSNode(sSpan);
				if (result == null) result = caseNode(sSpan);
				if (result == null) result = caseSAnnotatableElement(sSpan);
				if (result == null) result = caseSNamedElement(sSpan);
				if (result == null) result = caseSIdentifiableElement(sSpan);
				if (result == null) result = caseSProcessingAnnotatableElement(sSpan);
				if (result == null) result = caseSMetaAnnotatableElement(sSpan);
				if (result == null) result = caseIdentifiableElement(sSpan);
				if (result == null) result = caseSFeaturableElement(sSpan);
				if (result == null) result = caseLabelableElement(sSpan);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDocumentStructurePackage.SSPANNING_RELATION: {
				SSpanningRelation sSpanningRelation = (SSpanningRelation)theEObject;
				T result = caseSSpanningRelation(sSpanningRelation);
				if (result == null) result = caseSTextOverlappingRelation(sSpanningRelation);
				if (result == null) result = caseSTimeOverlappingRelation(sSpanningRelation);
				if (result == null) result = caseSRelation(sSpanningRelation);
				if (result == null) result = caseEdge(sSpanningRelation);
				if (result == null) result = caseSAnnotatableElement(sSpanningRelation);
				if (result == null) result = caseSNamedElement(sSpanningRelation);
				if (result == null) result = caseSIdentifiableElement(sSpanningRelation);
				if (result == null) result = caseSProcessingAnnotatableElement(sSpanningRelation);
				if (result == null) result = caseSMetaAnnotatableElement(sSpanningRelation);
				if (result == null) result = caseIdentifiableElement(sSpanningRelation);
				if (result == null) result = caseSFeaturableElement(sSpanningRelation);
				if (result == null) result = caseLabelableElement(sSpanningRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDocumentStructurePackage.STEXT_OVERLAPPING_RELATION: {
				STextOverlappingRelation sTextOverlappingRelation = (STextOverlappingRelation)theEObject;
				T result = caseSTextOverlappingRelation(sTextOverlappingRelation);
				if (result == null) result = caseSRelation(sTextOverlappingRelation);
				if (result == null) result = caseEdge(sTextOverlappingRelation);
				if (result == null) result = caseSAnnotatableElement(sTextOverlappingRelation);
				if (result == null) result = caseSNamedElement(sTextOverlappingRelation);
				if (result == null) result = caseSIdentifiableElement(sTextOverlappingRelation);
				if (result == null) result = caseSProcessingAnnotatableElement(sTextOverlappingRelation);
				if (result == null) result = caseSMetaAnnotatableElement(sTextOverlappingRelation);
				if (result == null) result = caseIdentifiableElement(sTextOverlappingRelation);
				if (result == null) result = caseSFeaturableElement(sTextOverlappingRelation);
				if (result == null) result = caseLabelableElement(sTextOverlappingRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDocumentStructurePackage.STIME_OVERLAPPING_RELATION: {
				STimeOverlappingRelation sTimeOverlappingRelation = (STimeOverlappingRelation)theEObject;
				T result = caseSTimeOverlappingRelation(sTimeOverlappingRelation);
				if (result == null) result = caseSRelation(sTimeOverlappingRelation);
				if (result == null) result = caseEdge(sTimeOverlappingRelation);
				if (result == null) result = caseSAnnotatableElement(sTimeOverlappingRelation);
				if (result == null) result = caseSNamedElement(sTimeOverlappingRelation);
				if (result == null) result = caseSIdentifiableElement(sTimeOverlappingRelation);
				if (result == null) result = caseSProcessingAnnotatableElement(sTimeOverlappingRelation);
				if (result == null) result = caseSMetaAnnotatableElement(sTimeOverlappingRelation);
				if (result == null) result = caseIdentifiableElement(sTimeOverlappingRelation);
				if (result == null) result = caseSFeaturableElement(sTimeOverlappingRelation);
				if (result == null) result = caseLabelableElement(sTimeOverlappingRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDocumentStructurePackage.SSTRUCTURED_NODE: {
				SStructuredNode sStructuredNode = (SStructuredNode)theEObject;
				T result = caseSStructuredNode(sStructuredNode);
				if (result == null) result = caseSNode(sStructuredNode);
				if (result == null) result = caseNode(sStructuredNode);
				if (result == null) result = caseSAnnotatableElement(sStructuredNode);
				if (result == null) result = caseSNamedElement(sStructuredNode);
				if (result == null) result = caseSIdentifiableElement(sStructuredNode);
				if (result == null) result = caseSProcessingAnnotatableElement(sStructuredNode);
				if (result == null) result = caseSMetaAnnotatableElement(sStructuredNode);
				if (result == null) result = caseIdentifiableElement(sStructuredNode);
				if (result == null) result = caseSFeaturableElement(sStructuredNode);
				if (result == null) result = caseLabelableElement(sStructuredNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDocumentStructurePackage.SSTRUCTURE: {
				SStructure sStructure = (SStructure)theEObject;
				T result = caseSStructure(sStructure);
				if (result == null) result = caseSStructuredNode(sStructure);
				if (result == null) result = caseSNode(sStructure);
				if (result == null) result = caseNode(sStructure);
				if (result == null) result = caseSAnnotatableElement(sStructure);
				if (result == null) result = caseSNamedElement(sStructure);
				if (result == null) result = caseSIdentifiableElement(sStructure);
				if (result == null) result = caseSProcessingAnnotatableElement(sStructure);
				if (result == null) result = caseSMetaAnnotatableElement(sStructure);
				if (result == null) result = caseIdentifiableElement(sStructure);
				if (result == null) result = caseSFeaturableElement(sStructure);
				if (result == null) result = caseLabelableElement(sStructure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDocumentStructurePackage.SPOINTING_RELATION: {
				SPointingRelation sPointingRelation = (SPointingRelation)theEObject;
				T result = caseSPointingRelation(sPointingRelation);
				if (result == null) result = caseSRelation(sPointingRelation);
				if (result == null) result = caseEdge(sPointingRelation);
				if (result == null) result = caseSAnnotatableElement(sPointingRelation);
				if (result == null) result = caseSNamedElement(sPointingRelation);
				if (result == null) result = caseSIdentifiableElement(sPointingRelation);
				if (result == null) result = caseSProcessingAnnotatableElement(sPointingRelation);
				if (result == null) result = caseSMetaAnnotatableElement(sPointingRelation);
				if (result == null) result = caseIdentifiableElement(sPointingRelation);
				if (result == null) result = caseSFeaturableElement(sPointingRelation);
				if (result == null) result = caseLabelableElement(sPointingRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDocumentStructurePackage.SDOMINANCE_RELATION: {
				SDominanceRelation sDominanceRelation = (SDominanceRelation)theEObject;
				T result = caseSDominanceRelation(sDominanceRelation);
				if (result == null) result = caseSTextOverlappingRelation(sDominanceRelation);
				if (result == null) result = caseSTimeOverlappingRelation(sDominanceRelation);
				if (result == null) result = caseSRelation(sDominanceRelation);
				if (result == null) result = caseEdge(sDominanceRelation);
				if (result == null) result = caseSAnnotatableElement(sDominanceRelation);
				if (result == null) result = caseSNamedElement(sDominanceRelation);
				if (result == null) result = caseSIdentifiableElement(sDominanceRelation);
				if (result == null) result = caseSProcessingAnnotatableElement(sDominanceRelation);
				if (result == null) result = caseSMetaAnnotatableElement(sDominanceRelation);
				if (result == null) result = caseIdentifiableElement(sDominanceRelation);
				if (result == null) result = caseSFeaturableElement(sDominanceRelation);
				if (result == null) result = caseLabelableElement(sDominanceRelation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDocumentStructurePackage.SDATA_SOURCE_SEQUENCE: {
				SDataSourceSequence sDataSourceSequence = (SDataSourceSequence)theEObject;
				T result = caseSDataSourceSequence(sDataSourceSequence);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDocumentStructurePackage.SAUDIO_DATA_SOURCE: {
				SAudioDataSource sAudioDataSource = (SAudioDataSource)theEObject;
				T result = caseSAudioDataSource(sAudioDataSource);
				if (result == null) result = caseSSequentialDS(sAudioDataSource);
				if (result == null) result = caseSNode(sAudioDataSource);
				if (result == null) result = caseNode(sAudioDataSource);
				if (result == null) result = caseSAnnotatableElement(sAudioDataSource);
				if (result == null) result = caseSNamedElement(sAudioDataSource);
				if (result == null) result = caseSIdentifiableElement(sAudioDataSource);
				if (result == null) result = caseSProcessingAnnotatableElement(sAudioDataSource);
				if (result == null) result = caseSMetaAnnotatableElement(sAudioDataSource);
				if (result == null) result = caseIdentifiableElement(sAudioDataSource);
				if (result == null) result = caseSFeaturableElement(sAudioDataSource);
				if (result == null) result = caseLabelableElement(sAudioDataSource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SDocumentStructurePackage.SAUDIO_DS_RELATION: {
				SAudioDSRelation sAudioDSRelation = (SAudioDSRelation)theEObject;
				T result = caseSAudioDSRelation(sAudioDSRelation);
				if (result == null) result = caseSRelation(sAudioDSRelation);
				if (result == null) result = caseEdge(sAudioDSRelation);
				if (result == null) result = caseSAnnotatableElement(sAudioDSRelation);
				if (result == null) result = caseSNamedElement(sAudioDSRelation);
				if (result == null) result = caseSIdentifiableElement(sAudioDSRelation);
				if (result == null) result = caseSProcessingAnnotatableElement(sAudioDSRelation);
				if (result == null) result = caseSMetaAnnotatableElement(sAudioDSRelation);
				if (result == null) result = caseIdentifiableElement(sAudioDSRelation);
				if (result == null) result = caseSFeaturableElement(sAudioDSRelation);
				if (result == null) result = caseLabelableElement(sAudioDSRelation);
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
	 * Returns the result of interpreting the object as an instance of '<em>STimeline Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>STimeline Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSTimelineRelation(STimelineRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SSpan</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SSpan</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSSpan(SSpan object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SSpanning Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SSpanning Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSSpanningRelation(SSpanningRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SText Overlapping Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SText Overlapping Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSTextOverlappingRelation(STextOverlappingRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>STime Overlapping Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>STime Overlapping Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSTimeOverlappingRelation(STimeOverlappingRelation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SStructured Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SStructured Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSStructuredNode(SStructuredNode object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>SData Source Sequence</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SData Source Sequence</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSDataSourceSequence(SDataSourceSequence object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SAudio Data Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SAudio Data Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSAudioDataSource(SAudioDataSource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SAudio DS Relation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SAudio DS Relation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSAudioDSRelation(SAudioDSRelation object) {
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
