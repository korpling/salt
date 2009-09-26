/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltSemantics.util;

import de.hub.corpling.graph.Label;
import de.hub.corpling.graph.LabelableElement;

import de.hub.corpling.salt.saltCore.SAnnotation;

import de.hub.corpling.salt.saltSemantics.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.hub.corpling.salt.saltSemantics.SaltSemanticsPackage
 * @generated
 */
public class SaltSemanticsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SaltSemanticsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SaltSemanticsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SaltSemanticsPackage.eINSTANCE;
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
	protected SaltSemanticsSwitch<Adapter> modelSwitch =
		new SaltSemanticsSwitch<Adapter>() {
			@Override
			public Adapter caseSPOSAnnotation(SPOSAnnotation object) {
				return createSPOSAnnotationAdapter();
			}
			@Override
			public Adapter caseSLemmaAnnotation(SLemmaAnnotation object) {
				return createSLemmaAnnotationAdapter();
			}
			@Override
			public Adapter caseSCatAnnotation(SCatAnnotation object) {
				return createSCatAnnotationAdapter();
			}
			@Override
			public Adapter caseSTypeAnnotation(STypeAnnotation object) {
				return createSTypeAnnotationAdapter();
			}
			@Override
			public Adapter caseSWordAnnotation(SWordAnnotation object) {
				return createSWordAnnotationAdapter();
			}
			@Override
			public Adapter caseSSentenceAnnotation(SSentenceAnnotation object) {
				return createSSentenceAnnotationAdapter();
			}
			@Override
			public Adapter caseLabelableElement(LabelableElement object) {
				return createLabelableElementAdapter();
			}
			@Override
			public Adapter caseLabel(Label object) {
				return createLabelAdapter();
			}
			@Override
			public Adapter caseSAnnotation(SAnnotation object) {
				return createSAnnotationAdapter();
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
	 * Creates a new adapter for an object of class '{@link de.hub.corpling.salt.saltSemantics.SPOSAnnotation <em>SPOS Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hub.corpling.salt.saltSemantics.SPOSAnnotation
	 * @generated
	 */
	public Adapter createSPOSAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hub.corpling.salt.saltSemantics.SLemmaAnnotation <em>SLemma Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hub.corpling.salt.saltSemantics.SLemmaAnnotation
	 * @generated
	 */
	public Adapter createSLemmaAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hub.corpling.salt.saltSemantics.SCatAnnotation <em>SCat Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hub.corpling.salt.saltSemantics.SCatAnnotation
	 * @generated
	 */
	public Adapter createSCatAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hub.corpling.salt.saltSemantics.STypeAnnotation <em>SType Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hub.corpling.salt.saltSemantics.STypeAnnotation
	 * @generated
	 */
	public Adapter createSTypeAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hub.corpling.salt.saltSemantics.SWordAnnotation <em>SWord Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hub.corpling.salt.saltSemantics.SWordAnnotation
	 * @generated
	 */
	public Adapter createSWordAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hub.corpling.salt.saltSemantics.SSentenceAnnotation <em>SSentence Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hub.corpling.salt.saltSemantics.SSentenceAnnotation
	 * @generated
	 */
	public Adapter createSSentenceAnnotationAdapter() {
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
	 * Creates a new adapter for an object of class '{@link de.hub.corpling.graph.Label <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hub.corpling.graph.Label
	 * @generated
	 */
	public Adapter createLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.hub.corpling.salt.saltCore.SAnnotation <em>SAnnotation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.hub.corpling.salt.saltCore.SAnnotation
	 * @generated
	 */
	public Adapter createSAnnotationAdapter() {
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

} //SaltSemanticsAdapterFactory
