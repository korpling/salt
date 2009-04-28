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
import de.corpling.salt.model.saltCore.STypedElement;

import de.util.graph.Edge;
import de.util.graph.Graph;
import de.util.graph.IdentifiableElement;
import de.util.graph.IndexMgr;
import de.util.graph.LabelableElement;
import de.util.graph.Node;
import de.util.graph.TraversalObject;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.corpling.salt.model.salt.SaltPackage
 * @generated
 */
public class SaltAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SaltPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SaltPackage.eINSTANCE;
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
	protected SaltSwitch<Adapter> modelSwitch =
		new SaltSwitch<Adapter>() {
			@Override
			public Adapter caseSToken(SToken object) {
				return createSTokenAdapter();
			}
			@Override
			public Adapter caseSDataSource(SDataSource object) {
				return createSDataSourceAdapter();
			}
			@Override
			public Adapter caseSTextualDataSource(STextualDataSource object) {
				return createSTextualDataSourceAdapter();
			}
			@Override
			public Adapter caseSDocumentGraph(SDocumentGraph object) {
				return createSDocumentGraphAdapter();
			}
			@Override
			public Adapter caseSTextualRelation(STextualRelation object) {
				return createSTextualRelationAdapter();
			}
			@Override
			public Adapter caseSStructure(SStructure object) {
				return createSStructureAdapter();
			}
			@Override
			public Adapter caseSSpanRelation(SSpanRelation object) {
				return createSSpanRelationAdapter();
			}
			@Override
			public Adapter caseSProject(SProject object) {
				return createSProjectAdapter();
			}
			@Override
			public Adapter caseSCorpus(SCorpus object) {
				return createSCorpusAdapter();
			}
			@Override
			public Adapter caseSCorpusGraph(SCorpusGraph object) {
				return createSCorpusGraphAdapter();
			}
			@Override
			public Adapter caseSDocument(SDocument object) {
				return createSDocumentAdapter();
			}
			@Override
			public Adapter caseSCorpusRelation(SCorpusRelation object) {
				return createSCorpusRelationAdapter();
			}
			@Override
			public Adapter caseSCorpDocRelation(SCorpDocRelation object) {
				return createSCorpDocRelationAdapter();
			}
			@Override
			public Adapter caseSDominanceRelation(SDominanceRelation object) {
				return createSDominanceRelationAdapter();
			}
			@Override
			public Adapter caseSPointingRelation(SPointingRelation object) {
				return createSPointingRelationAdapter();
			}
			@Override
			public Adapter caseSNamedElement(SNamedElement object) {
				return createSNamedElementAdapter();
			}
			@Override
			public Adapter caseIdentifiableElement(IdentifiableElement object) {
				return createIdentifiableElementAdapter();
			}
			@Override
			public Adapter caseSIdentifiableElement(SIdentifiableElement object) {
				return createSIdentifiableElementAdapter();
			}
			@Override
			public Adapter caseLabelableElement(LabelableElement object) {
				return createLabelableElementAdapter();
			}
			@Override
			public Adapter caseSAnnotatableElement(SAnnotatableElement object) {
				return createSAnnotatableElementAdapter();
			}
			@Override
			public Adapter caseSStereotypeableElement(SStereotypeableElement object) {
				return createSStereotypeableElementAdapter();
			}
			@Override
			public Adapter caseSProcessingAnnotatableElement(SProcessingAnnotatableElement object) {
				return createSProcessingAnnotatableElementAdapter();
			}
			@Override
			public Adapter caseNode(Node object) {
				return createNodeAdapter();
			}
			@Override
			public Adapter caseSElement(SElement object) {
				return createSElementAdapter();
			}
			@Override
			public Adapter caseIndexMgr(IndexMgr object) {
				return createIndexMgrAdapter();
			}
			@Override
			public Adapter caseTraversalObject(TraversalObject object) {
				return createTraversalObjectAdapter();
			}
			@Override
			public Adapter caseGraph(Graph object) {
				return createGraphAdapter();
			}
			@Override
			public Adapter caseSGraph(SGraph object) {
				return createSGraphAdapter();
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
			public Adapter caseSStereotypeContainer(SStereotypeContainer object) {
				return createSStereotypeContainerAdapter();
			}
			@Override
			public Adapter caseSCoreProject(SCoreProject object) {
				return createSCoreProjectAdapter();
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
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.salt.SToken <em>SToken</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.salt.SToken
	 * @generated
	 */
	public Adapter createSTokenAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.salt.SDataSource <em>SData Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.salt.SDataSource
	 * @generated
	 */
	public Adapter createSDataSourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.salt.STextualDataSource <em>STextual Data Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.salt.STextualDataSource
	 * @generated
	 */
	public Adapter createSTextualDataSourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.salt.SDocumentGraph <em>SDocument Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.salt.SDocumentGraph
	 * @generated
	 */
	public Adapter createSDocumentGraphAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.salt.STextualRelation <em>STextual Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.salt.STextualRelation
	 * @generated
	 */
	public Adapter createSTextualRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.salt.SStructure <em>SStructure</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.salt.SStructure
	 * @generated
	 */
	public Adapter createSStructureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.salt.SSpanRelation <em>SSpan Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.salt.SSpanRelation
	 * @generated
	 */
	public Adapter createSSpanRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.salt.SProject <em>SProject</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.salt.SProject
	 * @generated
	 */
	public Adapter createSProjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.salt.SCorpus <em>SCorpus</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.salt.SCorpus
	 * @generated
	 */
	public Adapter createSCorpusAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.salt.SCorpusGraph <em>SCorpus Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.salt.SCorpusGraph
	 * @generated
	 */
	public Adapter createSCorpusGraphAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.salt.SDocument <em>SDocument</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.salt.SDocument
	 * @generated
	 */
	public Adapter createSDocumentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.salt.SCorpusRelation <em>SCorpus Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.salt.SCorpusRelation
	 * @generated
	 */
	public Adapter createSCorpusRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.salt.SCorpDocRelation <em>SCorp Doc Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.salt.SCorpDocRelation
	 * @generated
	 */
	public Adapter createSCorpDocRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.salt.SDominanceRelation <em>SDominance Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.salt.SDominanceRelation
	 * @generated
	 */
	public Adapter createSDominanceRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.salt.SPointingRelation <em>SPointing Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.salt.SPointingRelation
	 * @generated
	 */
	public Adapter createSPointingRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.saltCore.SNamedElement <em>SNamed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.saltCore.SNamedElement
	 * @generated
	 */
	public Adapter createSNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.util.graph.IdentifiableElement <em>Identifiable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.util.graph.IdentifiableElement
	 * @generated
	 */
	public Adapter createIdentifiableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.saltCore.SIdentifiableElement <em>SIdentifiable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.saltCore.SIdentifiableElement
	 * @generated
	 */
	public Adapter createSIdentifiableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.util.graph.LabelableElement <em>Labelable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.util.graph.LabelableElement
	 * @generated
	 */
	public Adapter createLabelableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.saltCore.SAnnotatableElement <em>SAnnotatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.saltCore.SAnnotatableElement
	 * @generated
	 */
	public Adapter createSAnnotatableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.saltCore.SStereotypeableElement <em>SStereotypeable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.saltCore.SStereotypeableElement
	 * @generated
	 */
	public Adapter createSStereotypeableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.saltCore.SProcessingAnnotatableElement <em>SProcessing Annotatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.saltCore.SProcessingAnnotatableElement
	 * @generated
	 */
	public Adapter createSProcessingAnnotatableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.util.graph.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.util.graph.Node
	 * @generated
	 */
	public Adapter createNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.saltCore.SElement <em>SElement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.saltCore.SElement
	 * @generated
	 */
	public Adapter createSElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.util.graph.IndexMgr <em>Index Mgr</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.util.graph.IndexMgr
	 * @generated
	 */
	public Adapter createIndexMgrAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.util.graph.TraversalObject <em>Traversal Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.util.graph.TraversalObject
	 * @generated
	 */
	public Adapter createTraversalObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.util.graph.Graph <em>Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.util.graph.Graph
	 * @generated
	 */
	public Adapter createGraphAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.saltCore.SGraph <em>SGraph</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.saltCore.SGraph
	 * @generated
	 */
	public Adapter createSGraphAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.util.graph.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.util.graph.Edge
	 * @generated
	 */
	public Adapter createEdgeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.saltCore.SRelation <em>SRelation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.saltCore.SRelation
	 * @generated
	 */
	public Adapter createSRelationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.saltCore.SStereotypeContainer <em>SStereotype Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.saltCore.SStereotypeContainer
	 * @generated
	 */
	public Adapter createSStereotypeContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.saltCore.SCoreProject <em>SCore Project</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.saltCore.SCoreProject
	 * @generated
	 */
	public Adapter createSCoreProjectAdapter() {
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

} //SaltAdapterFactory
