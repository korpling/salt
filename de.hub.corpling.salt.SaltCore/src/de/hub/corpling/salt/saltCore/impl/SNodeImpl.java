/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCore.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.InternalEList;

import de.hub.corpling.graph.Graph;
import de.hub.corpling.graph.impl.NodeImpl;
import de.hub.corpling.salt.saltCore.SAnnotatableElement;
import de.hub.corpling.salt.saltCore.SAnnotation;
import de.hub.corpling.salt.saltCore.SGraph;
import de.hub.corpling.salt.saltCore.SIdentifiableElement;
import de.hub.corpling.salt.saltCore.SNamedElement;
import de.hub.corpling.salt.saltCore.SNode;
import de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement;
import de.hub.corpling.salt.saltCore.SProcessingAnnotation;
import de.hub.corpling.salt.saltCore.SaltCorePackage;
import de.hub.corpling.salt.saltCore.accessors.SAnnotatableElementAccessor;
import de.hub.corpling.salt.saltCore.accessors.SIdentifiableElementAccessor;
import de.hub.corpling.salt.saltCore.accessors.SProcessingAnnotatableElementAccessor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SNode</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SNodeImpl#getSAnnotations <em>SAnnotations</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SNodeImpl#getSName <em>SName</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SNodeImpl#getSId <em>SId</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SNodeImpl#getSElementPath <em>SElement Path</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SNodeImpl#getSProcessingAnnotations <em>SProcessing Annotations</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SNodeImpl#getSGraph <em>SGraph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SNodeImpl extends NodeImpl implements SNode {
	/**
	 * The default value of the '{@link #getSName() <em>SName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSName()
	 * @generated
	 * @ordered
	 */
	protected static final String SNAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSName() <em>SName</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSName()
	 * @generated
	 * @ordered
	 */
	protected String sName = SNAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSId() <em>SId</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSId()
	 * @generated
	 * @ordered
	 */
	protected static final String SID_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getSElementPath() <em>SElement Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSElementPath()
	 * @generated
	 * @ordered
	 */
	protected static final URI SELEMENT_PATH_EDEFAULT = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected SNodeImpl() {
		super();
		init();
	}
	
	private void init()
	{
		this.sAnnoAccessor= new SAnnotatableElementAccessor();
		this.sProcAnnoAccessor= new SProcessingAnnotatableElementAccessor();
		this.sIdentAccessor= new SIdentifiableElementAccessor();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltCorePackage.Literals.SNODE;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSName() {
		return sName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSName(String newSName) {
		String oldSName = sName;
		sName = newSName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SNODE__SNAME, oldSName, sName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SGraph getSGraph() {
		SGraph sGraph = basicGetSGraph();
		return sGraph != null && sGraph.eIsProxy() ? (SGraph)eResolveProxy((InternalEObject)sGraph) : sGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SGraph basicGetSGraph() 
	{
		SGraph sGraph= null;
		Graph graph= super.getGraph();
		if (graph instanceof SGraph)
			sGraph = (SGraph) graph;
		return(sGraph);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSGraph(SGraph newSGraph) 
	{
		super.setGraph(newSGraph);
	}

//=================== start: handling SIdentifiableElement	
	/**
	 * Delegatee for SIdentifiableElement
	 */
	private SIdentifiableElementAccessor sIdentAccessor= null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public String getSId() 
	{
		return(this.sIdentAccessor.getSId(this));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSId(String newSId) 
	{
		this.sIdentAccessor.setSId(this, newSId);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public URI getSElementPath() 
	{
		return(this.sIdentAccessor.getSElementPath(this));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSElementPath(URI newSElementPath) 
	{
		this.sIdentAccessor.setSElementPath(this, newSElementPath);
	}
//=================== end: handling SIdentifiableElement	
//=================== start: handling SAnnotatableElement	
	/**
	 * Delegatee for SAnnotatableElement
	 */
	private SAnnotatableElementAccessor sAnnoAccessor= null;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EList<SAnnotation> getSAnnotations() 
	{
		return(this.sAnnoAccessor.getSAnnotations(this));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addSAnnotation(SAnnotation SAnnotation) 
	{
		this.sAnnoAccessor.addSAnnotation(this, SAnnotation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SAnnotation getSAnnotation(String fullName) 
	{
		return(this.sAnnoAccessor.getSAnnotation(this, fullName));
	}
//=================== end: handling SAnnotatableElement
//=================== start: handling SProcessingAnnotatableElement
	/**
	 * Delegatee for SProcessingAnnotatableElement
	 */
	private SProcessingAnnotatableElementAccessor sProcAnnoAccessor= null;
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public EList<SProcessingAnnotation> getSProcessingAnnotations() 
	{
		return(this.sProcAnnoAccessor.getSProcessingAnnotations(this));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addSProcessingAnnotation(SProcessingAnnotation sProcessingAnnotation) 
	{
		this.sProcAnnoAccessor.addSProcessingAnnotation(this, sProcessingAnnotation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SProcessingAnnotation getSProcessingAnnotation(String fullName) 
	{
		return(this.sProcAnnoAccessor.getSProcessingAnnotation(this, fullName));
	}
//=================== end: handling SProcessingAnnotatableElement
	
	/**
	 * Checks if a given SNode has the same entries as this SNode-object. 
	 * @return if all values are equals.
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (!(obj instanceof SNode))
			return(false);
		SNode sNode2= (SNode) obj;
		{//check ids
			if (this.getSId()!= null)
			{	
				if (sNode2.getSId()== null)
					return(false);
				if (!this.getSId().equalsIgnoreCase(sNode2.getSId()))
					return(false);
			}
		}
		{//check SProcessingAnnotations
			for(SProcessingAnnotation sProcAnno1: this.getSProcessingAnnotations())
			{
				boolean hasOpponend= false;
				for(SProcessingAnnotation sProcAnno2: sNode2.getSProcessingAnnotations())
				{
					if (sProcAnno1. equals(sProcAnno2))
						hasOpponend= true;
				}
				if (!hasOpponend)
					return(false);
			}	
		}
		{//check SAnnotations
			for(SAnnotation sAnno1: this.getSAnnotations())
			{
				boolean hasOpponend= false;
				for(SAnnotation sAnno2: sNode2.getSAnnotations())
				{
					if (sAnno1. equals(sAnno2))
						hasOpponend= true;
				}
				if (!hasOpponend)
					return(false);
			}	
		}
		return(true);
	}
	
//	public boolean equals(SNode sNode2)
//	{
//		{//check SProcessingAnnotations
//			for(SProcessingAnnotation sProcAnno1: this.getSProcessingAnnotations())
//			{
//				boolean hasOpponend= false;
//				for(SProcessingAnnotation sProcAnno2: sNode2.getSProcessingAnnotations())
//				{
//					if (sProcAnno1. equals(sProcAnno2))
//						hasOpponend= true;
//				}
//				if (!hasOpponend)
//					return(false);
//			}	
//		}
//		return(true);
//	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SaltCorePackage.SNODE__SANNOTATIONS:
				return ((InternalEList<?>)getSAnnotations()).basicRemove(otherEnd, msgs);
			case SaltCorePackage.SNODE__SPROCESSING_ANNOTATIONS:
				return ((InternalEList<?>)getSProcessingAnnotations()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SaltCorePackage.SNODE__SANNOTATIONS:
				return getSAnnotations();
			case SaltCorePackage.SNODE__SNAME:
				return getSName();
			case SaltCorePackage.SNODE__SID:
				return getSId();
			case SaltCorePackage.SNODE__SELEMENT_PATH:
				return getSElementPath();
			case SaltCorePackage.SNODE__SPROCESSING_ANNOTATIONS:
				return getSProcessingAnnotations();
			case SaltCorePackage.SNODE__SGRAPH:
				if (resolve) return getSGraph();
				return basicGetSGraph();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SaltCorePackage.SNODE__SANNOTATIONS:
				getSAnnotations().clear();
				getSAnnotations().addAll((Collection<? extends SAnnotation>)newValue);
				return;
			case SaltCorePackage.SNODE__SNAME:
				setSName((String)newValue);
				return;
			case SaltCorePackage.SNODE__SID:
				setSId((String)newValue);
				return;
			case SaltCorePackage.SNODE__SELEMENT_PATH:
				setSElementPath((URI)newValue);
				return;
			case SaltCorePackage.SNODE__SGRAPH:
				setSGraph((SGraph)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SaltCorePackage.SNODE__SANNOTATIONS:
				getSAnnotations().clear();
				return;
			case SaltCorePackage.SNODE__SNAME:
				setSName(SNAME_EDEFAULT);
				return;
			case SaltCorePackage.SNODE__SID:
				setSId(SID_EDEFAULT);
				return;
			case SaltCorePackage.SNODE__SELEMENT_PATH:
				setSElementPath(SELEMENT_PATH_EDEFAULT);
				return;
			case SaltCorePackage.SNODE__SGRAPH:
				setSGraph((SGraph)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SaltCorePackage.SNODE__SANNOTATIONS:
				return !getSAnnotations().isEmpty();
			case SaltCorePackage.SNODE__SNAME:
				return SNAME_EDEFAULT == null ? sName != null : !SNAME_EDEFAULT.equals(sName);
			case SaltCorePackage.SNODE__SID:
				return SID_EDEFAULT == null ? getSId() != null : !SID_EDEFAULT.equals(getSId());
			case SaltCorePackage.SNODE__SELEMENT_PATH:
				return SELEMENT_PATH_EDEFAULT == null ? getSElementPath() != null : !SELEMENT_PATH_EDEFAULT.equals(getSElementPath());
			case SaltCorePackage.SNODE__SPROCESSING_ANNOTATIONS:
				return !getSProcessingAnnotations().isEmpty();
			case SaltCorePackage.SNODE__SGRAPH:
				return basicGetSGraph() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == SAnnotatableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SNODE__SANNOTATIONS: return SaltCorePackage.SANNOTATABLE_ELEMENT__SANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == SNamedElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SNODE__SNAME: return SaltCorePackage.SNAMED_ELEMENT__SNAME;
				default: return -1;
			}
		}
		if (baseClass == SIdentifiableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SNODE__SID: return SaltCorePackage.SIDENTIFIABLE_ELEMENT__SID;
				case SaltCorePackage.SNODE__SELEMENT_PATH: return SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_PATH;
				default: return -1;
			}
		}
		if (baseClass == SProcessingAnnotatableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SNODE__SPROCESSING_ANNOTATIONS: return SaltCorePackage.SPROCESSING_ANNOTATABLE_ELEMENT__SPROCESSING_ANNOTATIONS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == SAnnotatableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SANNOTATABLE_ELEMENT__SANNOTATIONS: return SaltCorePackage.SNODE__SANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == SNamedElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SNAMED_ELEMENT__SNAME: return SaltCorePackage.SNODE__SNAME;
				default: return -1;
			}
		}
		if (baseClass == SIdentifiableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SID: return SaltCorePackage.SNODE__SID;
				case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_PATH: return SaltCorePackage.SNODE__SELEMENT_PATH;
				default: return -1;
			}
		}
		if (baseClass == SProcessingAnnotatableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SPROCESSING_ANNOTATABLE_ELEMENT__SPROCESSING_ANNOTATIONS: return SaltCorePackage.SNODE__SPROCESSING_ANNOTATIONS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (sName: ");
		result.append(sName);
		result.append(')');
		return result.toString();
	}

} //SNodeImpl
