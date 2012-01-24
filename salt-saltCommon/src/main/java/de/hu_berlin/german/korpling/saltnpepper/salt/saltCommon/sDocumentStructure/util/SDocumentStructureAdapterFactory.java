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


import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage
 * @generated
 */
public class SDocumentStructureAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SDocumentStructurePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDocumentStructureAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SDocumentStructurePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SDocumentStructureSwitch<Adapter> modelSwitch =
		new SDocumentStructureSwitch<Adapter>() {
			@Override
			public Adapter caseSDocumentGraph(SDocumentGraph object) {
				return createSDocumentGraphAdapter();
			}
			@Override
			public Adapter caseSTextualDS(STextualDS object) {
				return createSTextualDSAdapter();
			}
			@Override
			public Adapter caseSToken(SToken object) {
				return createSTokenAdapter();
			}
			@Override
			public Adapter caseSTextualRelation(STextualRelation object) {
				return createSTextualRelationAdapter();
			}
			@Override
			public Adapter caseSSequentialRelation(SSequentialRelation object) {
				return createSSequentialRelationAdapter();
			}
			@Override
			public Adapter caseSSequentialDS(SSequentialDS object) {
				return createSSequentialDSAdapter();
			}
			@Override
			public Adapter caseSTimeline(STimeline object) {
				return createSTimelineAdapter();
			}
			@Override
			public Adapter caseSTimelineRelation(STimelineRelation object) {
				return createSTimelineRelationAdapter();
			}
			@Override
			public Adapter caseSSpan(SSpan object) {
				return createSSpanAdapter();
			}
			@Override
			public Adapter caseSSpanningRelation(SSpanningRelation object) {
				return createSSpanningRelationAdapter();
			}
			@Override
			public Adapter caseSTextOverlappingRelation(STextOverlappingRelation object) {
				return createSTextOverlappingRelationAdapter();
			}
			@Override
			public Adapter caseSTimeOverlappingRelation(STimeOverlappingRelation object) {
				return createSTimeOverlappingRelationAdapter();
			}
			@Override
			public Adapter caseSStructuredNode(SStructuredNode object) {
				return createSStructuredNodeAdapter();
			}
			@Override
			public Adapter caseSStructure(SStructure object) {
				return createSStructureAdapter();
			}
			@Override
			public Adapter caseSPointingRelation(SPointingRelation object) {
				return createSPointingRelationAdapter();
			}
			@Override
			public Adapter caseSDominanceRelation(SDominanceRelation object) {
				return createSDominanceRelationAdapter();
			}
			@Override
			public Adapter caseSDataSourceSequence(SDataSourceSequence object) {
				return createSDataSourceSequenceAdapter();
			}
			@Override
			public Adapter caseLabelableElement(LabelableElement object) {
				return createLabelableElementAdapter();
			}
			@Override
			public Adapter caseIdentifiableElement(IdentifiableElement object) {
				return createIdentifiableElementAdapter();
			}
			@Override
			public Adapter caseGraph(Graph object) {
				return createGraphAdapter();
			}
			@Override
			public Adapter caseSNamedElement(SNamedElement object) {
				return createSNamedElementAdapter();
			}
			@Override
			public Adapter caseSAnnotatableElement(SAnnotatableElement object) {
				return createSAnnotatableElementAdapter();
			}
			@Override
			public Adapter caseSIdentifiableElement(SIdentifiableElement object) {
				return createSIdentifiableElementAdapter();
			}
			@Override
			public Adapter caseSProcessingAnnotatableElement(SProcessingAnnotatableElement object) {
				return createSProcessingAnnotatableElementAdapter();
			}
			@Override
			public Adapter caseSFeaturableElement(SFeaturableElement object) {
				return createSFeaturableElementAdapter();
			}
			@Override
			public Adapter caseSMetaAnnotatableElement(SMetaAnnotatableElement object) {
				return createSMetaAnnotatableElementAdapter();
			}
			@Override
			public Adapter caseSGraph(SGraph object) {
				return createSGraphAdapter();
			}
			@Override
			public Adapter caseNode(Node object) {
				return createNodeAdapter();
			}
			@Override
			public Adapter caseSNode(SNode object) {
				return createSNodeAdapter();
			}
			@Override
			public Adapter caseEdge(Edge object) {
				return createEdgeAdapter();
			}
			@Override
			public Adapter caseSRelation(SRelation object) {
				return createSRelationAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph
	 * @generated
	 */
	public Adapter createSDocumentGraphAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS <em>STextual DS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualDS
	 * @generated
	 */
	public Adapter createSTextualDSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken <em>SToken</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SToken
	 * @generated
	 */
	public Adapter createSTokenAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation <em>STextual Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextualRelation
	 * @generated
	 */
	public Adapter createSTextualRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialRelation <em>SSequential Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialRelation
	 * @generated
	 */
	public Adapter createSSequentialRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialDS <em>SSequential DS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSequentialDS
	 * @generated
	 */
	public Adapter createSSequentialDSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeline <em>STimeline</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeline
	 * @generated
	 */
	public Adapter createSTimelineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimelineRelation <em>STimeline Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimelineRelation
	 * @generated
	 */
	public Adapter createSTimelineRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan <em>SSpan</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpan
	 * @generated
	 */
	public Adapter createSSpanAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation <em>SSpanning Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SSpanningRelation
	 * @generated
	 */
	public Adapter createSSpanningRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextOverlappingRelation <em>SText Overlapping Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STextOverlappingRelation
	 * @generated
	 */
	public Adapter createSTextOverlappingRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeOverlappingRelation <em>STime Overlapping Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.STimeOverlappingRelation
	 * @generated
	 */
	public Adapter createSTimeOverlappingRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructuredNode <em>SStructured Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructuredNode
	 * @generated
	 */
	public Adapter createSStructuredNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure <em>SStructure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SStructure
	 * @generated
	 */
	public Adapter createSStructureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation <em>SPointing Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SPointingRelation
	 * @generated
	 */
	public Adapter createSPointingRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation <em>SDominance Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDominanceRelation
	 * @generated
	 */
	public Adapter createSDominanceRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence <em>SData Source Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDataSourceSequence
	 * @generated
	 */
	public Adapter createSDataSourceSequenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement <em>Labelable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.LabelableElement
	 * @generated
	 */
	public Adapter createLabelableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement <em>Identifiable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement
	 * @generated
	 */
	public Adapter createIdentifiableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Graph
	 * @generated
	 */
	public Adapter createGraphAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNamedElement <em>SNamed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNamedElement
	 * @generated
	 */
	public Adapter createSNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement <em>SAnnotatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement
	 * @generated
	 */
	public Adapter createSAnnotatableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement <em>SIdentifiable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SIdentifiableElement
	 * @generated
	 */
	public Adapter createSIdentifiableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement <em>SProcessing Annotatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SProcessingAnnotatableElement
	 * @generated
	 */
	public Adapter createSProcessingAnnotatableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement <em>SFeaturable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeaturableElement
	 * @generated
	 */
	public Adapter createSFeaturableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement <em>SMeta Annotatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement
	 * @generated
	 */
	public Adapter createSMetaAnnotatableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraph <em>SGraph</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraph
	 * @generated
	 */
	public Adapter createSGraphAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Node
	 * @generated
	 */
	public Adapter createNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode <em>SNode</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode
	 * @generated
	 */
	public Adapter createSNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.graph.Edge
	 * @generated
	 */
	public Adapter createEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation <em>SRelation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation
	 * @generated
	 */
	public Adapter createSRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //SDocumentStructureAdapterFactory
