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
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.corpling.salt.model.saltCore.SaltCorePackage
 * @generated
 */
public class SaltCoreAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SaltCorePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltCoreAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SaltCorePackage.eINSTANCE;
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
	protected SaltCoreSwitch<Adapter> modelSwitch =
		new SaltCoreSwitch<Adapter>() {
			@Override
			public Adapter caseSElementPath(SElementPath object) {
				return createSElementPathAdapter();
			}
			@Override
			public Adapter caseSIdentifiableElement(SIdentifiableElement object) {
				return createSIdentifiableElementAdapter();
			}
			@Override
			public Adapter caseSElement(SElement object) {
				return createSElementAdapter();
			}
			@Override
			public Adapter caseSAnnotation(SAnnotation object) {
				return createSAnnotationAdapter();
			}
			@Override
			public Adapter caseSAnnotatableElement(SAnnotatableElement object) {
				return createSAnnotatableElementAdapter();
			}
			@Override
			public Adapter caseSRelation(SRelation object) {
				return createSRelationAdapter();
			}
			@Override
			public Adapter caseSNamedElement(SNamedElement object) {
				return createSNamedElementAdapter();
			}
			@Override
			public Adapter caseSTypedElement(STypedElement object) {
				return createSTypedElementAdapter();
			}
			@Override
			public Adapter caseSStereotypeableElement(SStereotypeableElement object) {
				return createSStereotypeableElementAdapter();
			}
			@Override
			public Adapter caseSFeature(SFeature object) {
				return createSFeatureAdapter();
			}
			@Override
			public Adapter caseSStereotype(SStereotype object) {
				return createSStereotypeAdapter();
			}
			@Override
			public Adapter caseSFeatureDescription(SFeatureDescription object) {
				return createSFeatureDescriptionAdapter();
			}
			@Override
			public Adapter caseSGraph(SGraph object) {
				return createSGraphAdapter();
			}
			@Override
			public Adapter caseSCoreProject(SCoreProject object) {
				return createSCoreProjectAdapter();
			}
			@Override
			public Adapter caseSStereotypeContainer(SStereotypeContainer object) {
				return createSStereotypeContainerAdapter();
			}
			@Override
			public Adapter caseSProcessingAnnotatableElement(SProcessingAnnotatableElement object) {
				return createSProcessingAnnotatableElementAdapter();
			}
			@Override
			public Adapter caseSProcessingAnnotation(SProcessingAnnotation object) {
				return createSProcessingAnnotationAdapter();
			}
			@Override
			public Adapter caseSTraversalObject(STraversalObject object) {
				return createSTraversalObjectAdapter();
			}
			@Override
			public Adapter caseIdentifiableElement(IdentifiableElement object) {
				return createIdentifiableElementAdapter();
			}
			@Override
			public Adapter caseLabelableElement(LabelableElement object) {
				return createLabelableElementAdapter();
			}
			@Override
			public Adapter caseNode(Node object) {
				return createNodeAdapter();
			}
			@Override
			public Adapter caseLabel(Label object) {
				return createLabelAdapter();
			}
			@Override
			public Adapter caseEdge(Edge object) {
				return createEdgeAdapter();
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
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.saltCore.SElementPath <em>SElement Path</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.saltCore.SElementPath
	 * @generated
	 */
	public Adapter createSElementPathAdapter() {
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
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.saltCore.SAnnotation <em>SAnnotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.saltCore.SAnnotation
	 * @generated
	 */
	public Adapter createSAnnotationAdapter() {
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
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.saltCore.STypedElement <em>STyped Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.saltCore.STypedElement
	 * @generated
	 */
	public Adapter createSTypedElementAdapter() {
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
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.saltCore.SFeature <em>SFeature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.saltCore.SFeature
	 * @generated
	 */
	public Adapter createSFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.saltCore.SStereotype <em>SStereotype</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.saltCore.SStereotype
	 * @generated
	 */
	public Adapter createSStereotypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.saltCore.SFeatureDescription <em>SFeature Description</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.saltCore.SFeatureDescription
	 * @generated
	 */
	public Adapter createSFeatureDescriptionAdapter() {
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
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.saltCore.SProcessingAnnotation <em>SProcessing Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.saltCore.SProcessingAnnotation
	 * @generated
	 */
	public Adapter createSProcessingAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.model.saltCore.STraversalObject <em>STraversal Object</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.model.saltCore.STraversalObject
	 * @generated
	 */
	public Adapter createSTraversalObjectAdapter() {
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
	 * Creates a new adapter for an object of class '{@link de.util.graph.Label <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.util.graph.Label
	 * @generated
	 */
	public Adapter createLabelAdapter() {
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

} //SaltCoreAdapterFactory
