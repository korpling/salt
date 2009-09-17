/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sCorpusStructure.util;

import de.hub.corpling.graph.Edge;
import de.hub.corpling.graph.Graph;
import de.hub.corpling.graph.IdentifiableElement;
import de.hub.corpling.graph.LabelableElement;
import de.hub.corpling.graph.Node;
import de.hub.corpling.salt.saltCommon.sCorpusStructure.*;

import de.hub.corpling.salt.saltCore.SAnnotatableElement;
import de.hub.corpling.salt.saltCore.SFeaturableElement;
import de.hub.corpling.salt.saltCore.SGraph;
import de.hub.corpling.salt.saltCore.SIdentifiableElement;
import de.hub.corpling.salt.saltCore.SNamedElement;
import de.hub.corpling.salt.saltCore.SNode;

import de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement;
import de.hub.corpling.salt.saltCore.SRelation;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage
 * @generated
 */
public class SCorpusStructureAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SCorpusStructurePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SCorpusStructureAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SCorpusStructurePackage.eINSTANCE;
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
	protected SCorpusStructureSwitch<Adapter> modelSwitch =
		new SCorpusStructureSwitch<Adapter>() {
			@Override
			public Adapter caseSCorpusGraph(SCorpusGraph object) {
				return createSCorpusGraphAdapter();
			}
			@Override
			public Adapter caseSDocument(SDocument object) {
				return createSDocumentAdapter();
			}
			@Override
			public Adapter caseSCorpus(SCorpus object) {
				return createSCorpusAdapter();
			}
			@Override
			public Adapter caseSCorpusRelation(SCorpusRelation object) {
				return createSCorpusRelationAdapter();
			}
			@Override
			public Adapter caseSCorpusDocumentRelation(SCorpusDocumentRelation object) {
				return createSCorpusDocumentRelationAdapter();
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
	 * Creates a new adapter for an object of class '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph <em>SCorpus Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusGraph
	 * @generated
	 */
	public Adapter createSCorpusGraphAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SDocument <em>SDocument</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SDocument
	 * @generated
	 */
	public Adapter createSDocumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpus <em>SCorpus</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpus
	 * @generated
	 */
	public Adapter createSCorpusAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation <em>SCorpus Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusRelation
	 * @generated
	 */
	public Adapter createSCorpusRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation <em>SCorpus Document Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hub.corpling.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation
	 * @generated
	 */
	public Adapter createSCorpusDocumentRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hub.corpling.graph.LabelableElement <em>Labelable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hub.corpling.graph.LabelableElement
	 * @generated
	 */
	public Adapter createLabelableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hub.corpling.graph.IdentifiableElement <em>Identifiable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hub.corpling.graph.IdentifiableElement
	 * @generated
	 */
	public Adapter createIdentifiableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hub.corpling.graph.Graph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hub.corpling.graph.Graph
	 * @generated
	 */
	public Adapter createGraphAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hub.corpling.salt.saltCore.SNamedElement <em>SNamed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hub.corpling.salt.saltCore.SNamedElement
	 * @generated
	 */
	public Adapter createSNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hub.corpling.salt.saltCore.SAnnotatableElement <em>SAnnotatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hub.corpling.salt.saltCore.SAnnotatableElement
	 * @generated
	 */
	public Adapter createSAnnotatableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hub.corpling.salt.saltCore.SIdentifiableElement <em>SIdentifiable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hub.corpling.salt.saltCore.SIdentifiableElement
	 * @generated
	 */
	public Adapter createSIdentifiableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement <em>SProcessing Annotatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement
	 * @generated
	 */
	public Adapter createSProcessingAnnotatableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hub.corpling.salt.saltCore.SFeaturableElement <em>SFeaturable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hub.corpling.salt.saltCore.SFeaturableElement
	 * @generated
	 */
	public Adapter createSFeaturableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hub.corpling.salt.saltCore.SGraph <em>SGraph</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hub.corpling.salt.saltCore.SGraph
	 * @generated
	 */
	public Adapter createSGraphAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hub.corpling.graph.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hub.corpling.graph.Node
	 * @generated
	 */
	public Adapter createNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hub.corpling.salt.saltCore.SNode <em>SNode</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hub.corpling.salt.saltCore.SNode
	 * @generated
	 */
	public Adapter createSNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hub.corpling.graph.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hub.corpling.graph.Edge
	 * @generated
	 */
	public Adapter createEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hub.corpling.salt.saltCore.SRelation <em>SRelation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hub.corpling.salt.saltCore.SRelation
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

} //SCorpusStructureAdapterFactory
