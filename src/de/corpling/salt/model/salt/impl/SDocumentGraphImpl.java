/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.corpling.salt.model.salt.impl;

import de.corpling.salt.model.saltCore.impl.SGraphImpl;
import de.corpling.salt.model.salt.SDocument;
import de.corpling.salt.model.salt.SDocumentGraph;
import de.corpling.salt.model.salt.SSTEREOTYPES;
import de.corpling.salt.model.salt.SSpanRelation;
import de.corpling.salt.model.salt.SStructure;
import de.corpling.salt.model.salt.STextualDataSource;
import de.corpling.salt.model.salt.STextualRelation;
import de.corpling.salt.model.salt.SToken;
import de.corpling.salt.model.salt.SaltPackage;

import de.corpling.salt.model.saltCore.SCoreProject;
import de.corpling.salt.model.saltCore.SElement;
import de.corpling.salt.model.saltCore.SStereotype;
import de.util.graph.GraphFactory;
import de.util.graph.Index;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SDocument Graph</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.corpling.salt.model.salt.impl.SDocumentGraphImpl#getSTokens <em>STokens</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.impl.SDocumentGraphImpl#getSTextualRelations <em>STextual Relations</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.impl.SDocumentGraphImpl#getSTextualDataSources <em>STextual Data Sources</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.impl.SDocumentGraphImpl#getSStructures <em>SStructures</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.impl.SDocumentGraphImpl#getSpanRelations <em>Span Relations</em>}</li>
 *   <li>{@link de.corpling.salt.model.salt.impl.SDocumentGraphImpl#getSDocument <em>SDocument</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SDocumentGraphImpl extends SGraphImpl implements SDocumentGraph 
{
	private static final String MSG_ERR=	"Error("+SDocumentGraphImpl.class+"): ";
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected SDocumentGraphImpl() {
		super();
		init();
	}
	
	private final String IDX_ELEMENT_TYPE= "idx_elem_type"; 
	/**
	 * Initializes this object:
	 * creating an index for different ELEMENT-types
	 */
	private void init()
	{
		Index idx= GraphFactory.eINSTANCE.createComplexIndex();
		idx.setId(IDX_ELEMENT_TYPE);
		super.addIndex(idx);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SaltPackage.Literals.SDOCUMENT_GRAPH;
	}

// ======================================== start: getSElements
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	public EList<STextualDataSource> getSTextualDataSources() 
	{
		if (this.getSCoreProject()== null)
			throw new NullPointerException(MSG_ERR + "Cannot return a textual data source, because project isn´t set.");
		EList<STextualDataSource> retList= null;
		SStereotype sStereotype= this.getSCoreProject().getSStereotypeByName(SSTEREOTYPES.STEXTUAL_DATASOURCE.getName());
		retList= (EList<STextualDataSource>)(EList<? extends SElement>)this.getSElementsByStereotype(sStereotype);
		return(retList);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	public EList<SToken> getSTokens() 
	{
		if (this.getSCoreProject()== null)
			throw new NullPointerException(MSG_ERR + "Cannot return a token, because project isn´t set.");
		EList<SToken> retList= null;
		SStereotype sStereotype= this.getSCoreProject().getSStereotypeByName(SSTEREOTYPES.STOKEN.getName());
		retList= (EList<SToken>)(EList<? extends SElement>)this.getSElementsByStereotype(sStereotype);
		return(retList);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	public EList<SStructure> getSStructures() 
	{
		if (this.getSCoreProject()== null)
			throw new NullPointerException(MSG_ERR + "Cannot return a structure, because project isn´t set.");
		EList<SStructure> retList= null;
		SStereotype sStereotype= this.getSCoreProject().getSStereotypeByName(SSTEREOTYPES.SSTRUCTURE.getName());
		retList= (EList<SStructure>)(EList<? extends SElement>)this.getSElementsByStereotype(sStereotype);
		return(retList);
	}	
// ======================================== end: getSElements

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<STextualRelation> getSTextualRelations() {
		// TODO: implement this method to return the 'STextual Relations' containment reference list
		// Ensure that you remove @generated or mark it @generated NOT
		// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
		// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
		throw new UnsupportedOperationException();
	}

	

	EList<STextualDataSource> textList= null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	/*
	@SuppressWarnings("unchecked")
	public EList<STextualDataSource> getSTextualDataSources() 
	{
		/*
		EList<STextualDataSource> retList= null;
		ComplexIndex idx= (ComplexIndex)this.getIndex(IDX_ELEMENT_TYPE);
		retList= (EList<STextualDataSource>)((EList<? extends SElement>)idx.getSlot(STextualDataSource.class));
		if (retList==null)
		{
			retList= new EObjectWithInverseResolvingEList<STextualDataSource>(STextualDataSource.class, this, SaltConcretePackage.SDOCUMENT_GRAPH__STEXTUAL_DATA_SOURCES, SaltConcretePackage.STEXTUAL_DATA_SOURCE__GRAPH);
			idx.addElement(STextualDataSource.class, retList);
		}
		
		return(retList);
		
		if (textList== null)
			textList= new EObjectWithInverseResolvingEList<STextualDataSource>(STextualDataSource.class, this, SaltConcretePackage.SDOCUMENT_GRAPH__STEXTUAL_DATA_SOURCES, SaltConcretePackage.STEXTUAL_DATA_SOURCE__SDOCUMENT_GRAPH);
		return(textList);
	}*/

	

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SSpanRelation> getSpanRelations() {
		// TODO: implement this method to return the 'Span Relations' containment reference list
		// Ensure that you remove @generated or mark it @generated NOT
		// The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
		// so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
		throw new UnsupportedOperationException();
	}

	/**
	 * new since 13.3.09
	 */
	public SCoreProject getSCoreProject()
	{
		if (this.getSDocument()== null)
			throw new NullPointerException(MSG_ERR + "Cannot return SCoreProject, because sDocument isn´t set.");
		return(this.getSDocument().getSCorpusGraph().getSCoreProject());
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDocument getSDocument() {
		if (eContainerFeatureID != SaltPackage.SDOCUMENT_GRAPH__SDOCUMENT) return null;
		return (SDocument)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSDocument(SDocument newSDocument, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSDocument, SaltPackage.SDOCUMENT_GRAPH__SDOCUMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSDocument(SDocument newSDocument) {
		if (newSDocument != eInternalContainer() || (eContainerFeatureID != SaltPackage.SDOCUMENT_GRAPH__SDOCUMENT && newSDocument != null)) {
			if (EcoreUtil.isAncestor(this, newSDocument))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSDocument != null)
				msgs = ((InternalEObject)newSDocument).eInverseAdd(this, SaltPackage.SDOCUMENT__SDOCUMENT_GRAPH, SDocument.class, msgs);
			msgs = basicSetSDocument(newSDocument, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltPackage.SDOCUMENT_GRAPH__SDOCUMENT, newSDocument, newSDocument));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SaltPackage.SDOCUMENT_GRAPH__SDOCUMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSDocument((SDocument)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SaltPackage.SDOCUMENT_GRAPH__STOKENS:
				return ((InternalEList<?>)getSTokens()).basicRemove(otherEnd, msgs);
			case SaltPackage.SDOCUMENT_GRAPH__STEXTUAL_RELATIONS:
				return ((InternalEList<?>)getSTextualRelations()).basicRemove(otherEnd, msgs);
			case SaltPackage.SDOCUMENT_GRAPH__STEXTUAL_DATA_SOURCES:
				return ((InternalEList<?>)getSTextualDataSources()).basicRemove(otherEnd, msgs);
			case SaltPackage.SDOCUMENT_GRAPH__SSTRUCTURES:
				return ((InternalEList<?>)getSStructures()).basicRemove(otherEnd, msgs);
			case SaltPackage.SDOCUMENT_GRAPH__SPAN_RELATIONS:
				return ((InternalEList<?>)getSpanRelations()).basicRemove(otherEnd, msgs);
			case SaltPackage.SDOCUMENT_GRAPH__SDOCUMENT:
				return basicSetSDocument(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID) {
			case SaltPackage.SDOCUMENT_GRAPH__SDOCUMENT:
				return eInternalContainer().eInverseRemove(this, SaltPackage.SDOCUMENT__SDOCUMENT_GRAPH, SDocument.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SaltPackage.SDOCUMENT_GRAPH__STOKENS:
				return getSTokens();
			case SaltPackage.SDOCUMENT_GRAPH__STEXTUAL_RELATIONS:
				return getSTextualRelations();
			case SaltPackage.SDOCUMENT_GRAPH__STEXTUAL_DATA_SOURCES:
				return getSTextualDataSources();
			case SaltPackage.SDOCUMENT_GRAPH__SSTRUCTURES:
				return getSStructures();
			case SaltPackage.SDOCUMENT_GRAPH__SPAN_RELATIONS:
				return getSpanRelations();
			case SaltPackage.SDOCUMENT_GRAPH__SDOCUMENT:
				return getSDocument();
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
	public void eSet(int featureID, Object newValue) 
	{
		switch (featureID) {
			case SaltPackage.SDOCUMENT_GRAPH__STOKENS:
				getSTokens().clear();
				getSTokens().addAll((Collection<? extends SToken>)newValue);
				return;
			case SaltPackage.SDOCUMENT_GRAPH__STEXTUAL_RELATIONS:
				getSTextualRelations().clear();
				getSTextualRelations().addAll((Collection<? extends STextualRelation>)newValue);
				return;
			case SaltPackage.SDOCUMENT_GRAPH__STEXTUAL_DATA_SOURCES:
				getSTextualDataSources().clear();
				getSTextualDataSources().addAll((Collection<? extends STextualDataSource>)newValue);
				return;
			case SaltPackage.SDOCUMENT_GRAPH__SSTRUCTURES:
				getSStructures().clear();
				getSStructures().addAll((Collection<? extends SStructure>)newValue);
				return;
			case SaltPackage.SDOCUMENT_GRAPH__SPAN_RELATIONS:
				getSpanRelations().clear();
				getSpanRelations().addAll((Collection<? extends SSpanRelation>)newValue);
				return;
			case SaltPackage.SDOCUMENT_GRAPH__SDOCUMENT:
				setSDocument((SDocument)newValue);
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
			case SaltPackage.SDOCUMENT_GRAPH__STOKENS:
				getSTokens().clear();
				return;
			case SaltPackage.SDOCUMENT_GRAPH__STEXTUAL_RELATIONS:
				getSTextualRelations().clear();
				return;
			case SaltPackage.SDOCUMENT_GRAPH__STEXTUAL_DATA_SOURCES:
				getSTextualDataSources().clear();
				return;
			case SaltPackage.SDOCUMENT_GRAPH__SSTRUCTURES:
				getSStructures().clear();
				return;
			case SaltPackage.SDOCUMENT_GRAPH__SPAN_RELATIONS:
				getSpanRelations().clear();
				return;
			case SaltPackage.SDOCUMENT_GRAPH__SDOCUMENT:
				setSDocument((SDocument)null);
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
			case SaltPackage.SDOCUMENT_GRAPH__STOKENS:
				return !getSTokens().isEmpty();
			case SaltPackage.SDOCUMENT_GRAPH__STEXTUAL_RELATIONS:
				return !getSTextualRelations().isEmpty();
			case SaltPackage.SDOCUMENT_GRAPH__STEXTUAL_DATA_SOURCES:
				return !getSTextualDataSources().isEmpty();
			case SaltPackage.SDOCUMENT_GRAPH__SSTRUCTURES:
				return !getSStructures().isEmpty();
			case SaltPackage.SDOCUMENT_GRAPH__SPAN_RELATIONS:
				return !getSpanRelations().isEmpty();
			case SaltPackage.SDOCUMENT_GRAPH__SDOCUMENT:
				return getSDocument() != null;
		}
		return super.eIsSet(featureID);
	}

} //SDocumentGraphImpl
