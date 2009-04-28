/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.saltFW.util;

import de.corpling.salt.model.salt.SCorpusGraph;
import de.corpling.salt.model.salt.SProject;

import de.corpling.salt.model.saltCore.SCoreProject;
import de.corpling.salt.model.saltCore.SGraph;
import de.corpling.salt.model.saltCore.SStereotypeContainer;

import de.corpling.salt.saltFW.*;

import de.util.graph.Graph;
import de.util.graph.IdentifiableElement;
import de.util.graph.IndexMgr;
import de.util.graph.LabelableElement;
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
 * @see de.corpling.salt.saltFW.SaltFWPackage
 * @generated
 */
public class SaltFWAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SaltFWPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltFWAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SaltFWPackage.eINSTANCE;
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
	protected SaltFWSwitch<Adapter> modelSwitch =
		new SaltFWSwitch<Adapter>() {
			@Override
			public Adapter caseSaltProject(SaltProject object) {
				return createSaltProjectAdapter();
			}
			@Override
			public Adapter caseSaltGraph(SaltGraph object) {
				return createSaltGraphAdapter();
			}
			@Override
			public Adapter caseSaltModule(SaltModule object) {
				return createSaltModuleAdapter();
			}
			@Override
			public Adapter caseSaltAccessorModule(SaltAccessorModule object) {
				return createSaltAccessorModuleAdapter();
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
			public Adapter caseSProject(SProject object) {
				return createSProjectAdapter();
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
			public Adapter caseSCorpusGraph(SCorpusGraph object) {
				return createSCorpusGraphAdapter();
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
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.saltFW.SaltProject <em>Salt Project</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.saltFW.SaltProject
	 * @generated
	 */
	public Adapter createSaltProjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.saltFW.SaltGraph <em>Salt Graph</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.saltFW.SaltGraph
	 * @generated
	 */
	public Adapter createSaltGraphAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.saltFW.SaltModule <em>Salt Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.saltFW.SaltModule
	 * @generated
	 */
	public Adapter createSaltModuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.corpling.salt.saltFW.SaltAccessorModule <em>Salt Accessor Module</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.corpling.salt.saltFW.SaltAccessorModule
	 * @generated
	 */
	public Adapter createSaltAccessorModuleAdapter() {
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

} //SaltFWAdapterFactory
