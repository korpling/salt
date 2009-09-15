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
import de.hub.corpling.graph.Node;
import de.hub.corpling.graph.impl.EdgeImpl;
import de.hub.corpling.salt.saltCore.SAnnotatableElement;
import de.hub.corpling.salt.saltCore.SAnnotation;
import de.hub.corpling.salt.saltCore.SGraph;
import de.hub.corpling.salt.saltCore.SIdentifiableElement;
import de.hub.corpling.salt.saltCore.SNamedElement;
import de.hub.corpling.salt.saltCore.SNode;
import de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement;
import de.hub.corpling.salt.saltCore.SProcessingAnnotation;
import de.hub.corpling.salt.saltCore.SRelation;
import de.hub.corpling.salt.saltCore.SaltCorePackage;
import de.hub.corpling.salt.saltCore.accessors.SAnnotatableElementAccessor;
import de.hub.corpling.salt.saltCore.accessors.SIdentifiableElementAccessor;
import de.hub.corpling.salt.saltCore.accessors.SProcessingAnnotatableElementAccessor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SRelation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SRelationImpl#getSAnnotations <em>SAnnotations</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SRelationImpl#getSName <em>SName</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SRelationImpl#getSId <em>SId</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SRelationImpl#getSElementPath <em>SElement Path</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SRelationImpl#getSProcessingAnnotations <em>SProcessing Annotations</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SRelationImpl#getSSource <em>SSource</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SRelationImpl#getSTarget <em>STarget</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCore.impl.SRelationImpl#getSGraph <em>SGraph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SRelationImpl extends EdgeImpl implements SRelation {
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
	protected SRelationImpl() {
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
		return SaltCorePackage.Literals.SRELATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SRELATION__SNAME, oldSName, sName));
	}

	/**
	 * Checks if a given SRelation has the same entries as this SNode-object. 
	 * @return if all values are equals.
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (!(obj instanceof SRelation))
			return(false);
		SRelation sRelation2= (SRelation) obj;
		{//check ids
			if (this.getSId()!= null)
			{	
				if (sRelation2.getSId()== null)
					return(false);
				if (!this.getSId().equalsIgnoreCase(sRelation2.getSId()))
					return(false);
			}
		}
		{//check SProcessingAnnotations
			for(SProcessingAnnotation sProcAnno1: this.getSProcessingAnnotations())
			{
				boolean hasOpponend= false;
				for(SProcessingAnnotation sProcAnno2: sRelation2.getSProcessingAnnotations())
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
				for(SAnnotation sAnno2: sRelation2.getSAnnotations())
				{
					if (sAnno1. equals(sAnno2))
						hasOpponend= true;
				}
				if (!hasOpponend)
					return(false);
			}	
		}
		//TODO check nodes
		return(true);
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SNode getSSource() {
		SNode sSource = basicGetSSource();
		return sSource != null && sSource.eIsProxy() ? (SNode)eResolveProxy((InternalEObject)sSource) : sSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SNode basicGetSSource() 
	{
		SNode retVal= null;
		Node node= super.getSource();
		if (node instanceof SNode)
			retVal= (SNode) node;
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSSource(SNode newSSource) 
	{
		super.setSource(newSSource);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SNode getSTarget() {
		SNode sTarget = basicGetSTarget();
		return sTarget != null && sTarget.eIsProxy() ? (SNode)eResolveProxy((InternalEObject)sTarget) : sTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SNode basicGetSTarget() 
	{
		SNode retVal= null;
		Node node= super.getTarget();
		if (node instanceof SNode)
			retVal= (SNode) node;
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSTarget(SNode newSTarget) 
	{
		super.setTarget(newSTarget);
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SaltCorePackage.SRELATION__SANNOTATIONS:
				return ((InternalEList<?>)getSAnnotations()).basicRemove(otherEnd, msgs);
			case SaltCorePackage.SRELATION__SPROCESSING_ANNOTATIONS:
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
			case SaltCorePackage.SRELATION__SANNOTATIONS:
				return getSAnnotations();
			case SaltCorePackage.SRELATION__SNAME:
				return getSName();
			case SaltCorePackage.SRELATION__SID:
				return getSId();
			case SaltCorePackage.SRELATION__SELEMENT_PATH:
				return getSElementPath();
			case SaltCorePackage.SRELATION__SPROCESSING_ANNOTATIONS:
				return getSProcessingAnnotations();
			case SaltCorePackage.SRELATION__SSOURCE:
				if (resolve) return getSSource();
				return basicGetSSource();
			case SaltCorePackage.SRELATION__STARGET:
				if (resolve) return getSTarget();
				return basicGetSTarget();
			case SaltCorePackage.SRELATION__SGRAPH:
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
			case SaltCorePackage.SRELATION__SANNOTATIONS:
				getSAnnotations().clear();
				getSAnnotations().addAll((Collection<? extends SAnnotation>)newValue);
				return;
			case SaltCorePackage.SRELATION__SNAME:
				setSName((String)newValue);
				return;
			case SaltCorePackage.SRELATION__SID:
				setSId((String)newValue);
				return;
			case SaltCorePackage.SRELATION__SELEMENT_PATH:
				setSElementPath((URI)newValue);
				return;
			case SaltCorePackage.SRELATION__SSOURCE:
				setSSource((SNode)newValue);
				return;
			case SaltCorePackage.SRELATION__STARGET:
				setSTarget((SNode)newValue);
				return;
			case SaltCorePackage.SRELATION__SGRAPH:
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
			case SaltCorePackage.SRELATION__SANNOTATIONS:
				getSAnnotations().clear();
				return;
			case SaltCorePackage.SRELATION__SNAME:
				setSName(SNAME_EDEFAULT);
				return;
			case SaltCorePackage.SRELATION__SID:
				setSId(SID_EDEFAULT);
				return;
			case SaltCorePackage.SRELATION__SELEMENT_PATH:
				setSElementPath(SELEMENT_PATH_EDEFAULT);
				return;
			case SaltCorePackage.SRELATION__SSOURCE:
				setSSource((SNode)null);
				return;
			case SaltCorePackage.SRELATION__STARGET:
				setSTarget((SNode)null);
				return;
			case SaltCorePackage.SRELATION__SGRAPH:
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
			case SaltCorePackage.SRELATION__SANNOTATIONS:
				return !getSAnnotations().isEmpty();
			case SaltCorePackage.SRELATION__SNAME:
				return SNAME_EDEFAULT == null ? sName != null : !SNAME_EDEFAULT.equals(sName);
			case SaltCorePackage.SRELATION__SID:
				return SID_EDEFAULT == null ? getSId() != null : !SID_EDEFAULT.equals(getSId());
			case SaltCorePackage.SRELATION__SELEMENT_PATH:
				return SELEMENT_PATH_EDEFAULT == null ? getSElementPath() != null : !SELEMENT_PATH_EDEFAULT.equals(getSElementPath());
			case SaltCorePackage.SRELATION__SPROCESSING_ANNOTATIONS:
				return !getSProcessingAnnotations().isEmpty();
			case SaltCorePackage.SRELATION__SSOURCE:
				return basicGetSSource() != null;
			case SaltCorePackage.SRELATION__STARGET:
				return basicGetSTarget() != null;
			case SaltCorePackage.SRELATION__SGRAPH:
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
				case SaltCorePackage.SRELATION__SANNOTATIONS: return SaltCorePackage.SANNOTATABLE_ELEMENT__SANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == SNamedElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SRELATION__SNAME: return SaltCorePackage.SNAMED_ELEMENT__SNAME;
				default: return -1;
			}
		}
		if (baseClass == SIdentifiableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SRELATION__SID: return SaltCorePackage.SIDENTIFIABLE_ELEMENT__SID;
				case SaltCorePackage.SRELATION__SELEMENT_PATH: return SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_PATH;
				default: return -1;
			}
		}
		if (baseClass == SProcessingAnnotatableElement.class) {
			switch (derivedFeatureID) {
				case SaltCorePackage.SRELATION__SPROCESSING_ANNOTATIONS: return SaltCorePackage.SPROCESSING_ANNOTATABLE_ELEMENT__SPROCESSING_ANNOTATIONS;
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
				case SaltCorePackage.SANNOTATABLE_ELEMENT__SANNOTATIONS: return SaltCorePackage.SRELATION__SANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == SNamedElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SNAMED_ELEMENT__SNAME: return SaltCorePackage.SRELATION__SNAME;
				default: return -1;
			}
		}
		if (baseClass == SIdentifiableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SID: return SaltCorePackage.SRELATION__SID;
				case SaltCorePackage.SIDENTIFIABLE_ELEMENT__SELEMENT_PATH: return SaltCorePackage.SRELATION__SELEMENT_PATH;
				default: return -1;
			}
		}
		if (baseClass == SProcessingAnnotatableElement.class) {
			switch (baseFeatureID) {
				case SaltCorePackage.SPROCESSING_ANNOTATABLE_ELEMENT__SPROCESSING_ANNOTATIONS: return SaltCorePackage.SRELATION__SPROCESSING_ANNOTATIONS;
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

} //SRelationImpl
