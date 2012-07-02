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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Identifier;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SFEATURE_NAME;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.SaltCommonPackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusStructurePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SFeature;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SNamedElementImpl;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.impl.SNodeImpl;

/**
 * Please note, that the flag @generated of the  methods {@link #eInverseAdd(InternalEObject, int, Class, NotificationChain)} and 
 * {@link #eInverseRemove(InternalEObject, int, NotificationChain)} have been removed. This was done to delegate the 
 * connection to the {@link SDocumentGraph} object via an {@link SFeature} and still using the notification mechanism provided by EMF. 
 * 
 * 
 * 
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SDocumentImpl#getSCorpusGraph <em>SCorpus Graph</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SDocumentImpl#getSDocumentGraph <em>SDocument Graph</em>}</li>
 *   <li>{@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.impl.SDocumentImpl#getSDocumentGraphLocation <em>SDocument Graph Location</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SDocumentImpl extends SNodeImpl implements SDocument {
	/**
	 * The default value of the '{@link #getSDocumentGraphLocation() <em>SDocument Graph Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSDocumentGraphLocation()
	 * @generated
	 * @ordered
	 */
	protected static final URI SDOCUMENT_GRAPH_LOCATION_EDEFAULT = null;

	/**
	 * Initializes this object and creates a {@link SFeature} object for relation to a 
	 * {@link SDocumentGraph} object. The initial value is null.
	 */
	protected SDocumentImpl() {
		super();
		this.setSDocumentGraph(null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SCorpusStructurePackage.Literals.SDOCUMENT;
	}

	/**
	 * {@inheritDoc SDocument#clone()}
	 */
	@Override
	public Object clone() 
	{
		return(this.clone(SaltFactory.eINSTANCE.createSDocument()));
	}

	/**
	 * {@inheritDoc SDocument#clone()}
	 */
	@Override
	public Object clone(SDocument clone)
	{
		super.clone(clone);
		return(clone);
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SCorpusGraph getSCorpusGraph() 
	{
		SCorpusGraph retVal= null;
		if (super.getSGraph() instanceof SCorpusGraph)
			retVal= (SCorpusGraph) super.getSGraph();
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSCorpusGraph(SCorpusGraph newSCorpusGraph) 
	{
		super.setSGraph(newSCorpusGraph);
	}

// =========================================== start: relation to SDocumentGraph	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SDocumentGraph getSDocumentGraph() {
		SDocumentGraph retVal= null;
		String name= SaltCommonPackage.eNS_PREFIX + "::" + SFEATURE_NAME.SDOCUMENT_GRAPH;
		SFeature sFeature= this.getSFeature(name);
		if (sFeature!= null)
		{
			Object obj= sFeature.getSValue();
			if (obj instanceof SDocumentGraph)
				retVal= (SDocumentGraph) obj;
		}
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSDocumentGraph(SDocumentGraph newSDocumentGraph) {
		if (newSDocumentGraph != this.getSDocumentGraph()) {
			NotificationChain msgs = null;
			if (this.getSDocumentGraph() != null)
				msgs = ((InternalEObject)this.getSDocumentGraph()).eInverseRemove(this, SDocumentStructurePackage.SDOCUMENT_GRAPH__SDOCUMENT, SDocumentGraph.class, msgs);
			if (newSDocumentGraph != null)
				msgs = ((InternalEObject)newSDocumentGraph).eInverseAdd(this, SDocumentStructurePackage.SDOCUMENT_GRAPH__SDOCUMENT, SDocumentGraph.class, msgs);
			msgs = basicSetSDocumentGraph(newSDocumentGraph, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SCorpusStructurePackage.SDOCUMENT__SDOCUMENT_GRAPH, newSDocumentGraph, newSDocumentGraph));

		if (this.getSDocumentGraph()!=null) {
			this.getSDocumentGraph().basicSetSElementId();
		}
	}
	
	/**
	 * This method really sets the internal {@link SDocumentGraph} object to the given one. The two method
	 * mechanism is necessary, for inverse methods like {@link #eInverseRemove(InternalEObject, int, NotificationChain)},
	 * to not start a never ending notification process. It also removes the {@link SFeature} object
	 * containing a {@link URI} to a referenced {@link SDocumentGraph} object (namely {@value SFEATURE_NAME#SDOCUMENT_GRAPH_LOCATION}).
	 * @param newSDocumentGraph {@link SDocumentGraph} object to be set
	 * @param msgs Messages
	 */
	public NotificationChain basicSetSDocumentGraph(SDocumentGraph newSDocumentGraph, NotificationChain msgs) {
		SDocumentGraph oldSDocumentGraph = this.getSDocumentGraph();
		
		String name= SaltCommonPackage.eNS_PREFIX + "::" + SFEATURE_NAME.SDOCUMENT_GRAPH; 
		SFeature sFeature= this.getSFeature(name);
		if (sFeature== null)
		{//create a new sFeature
			sFeature= SaltFactory.eINSTANCE.createSFeature();
			sFeature.setSNS(SaltCommonPackage.eNS_PREFIX);
			sFeature.setSName(SFEATURE_NAME.SDOCUMENT_GRAPH.toString());
			this.addSFeature(sFeature);
		}	
		sFeature.setSValue(newSDocumentGraph);
		this.removeLabel(SaltFactory.NAMESPACE_SALT, SFEATURE_NAME.SDOCUMENT_GRAPH_LOCATION.toString());
		
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SCorpusStructurePackage.SDOCUMENT__SDOCUMENT_GRAPH, oldSDocumentGraph, newSDocumentGraph);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SCorpusStructurePackage.SDOCUMENT__SDOCUMENT_GRAPH:
				if (this.getSDocumentGraph() != null) {
					msgs = ((InternalEObject)this.getSDocumentGraph()).eInverseRemove(this, SDocumentStructurePackage.SDOCUMENT_GRAPH__SDOCUMENT, SDocumentGraph.class, msgs);
					this.getSDocumentGraph().basicSetSElementId();					
				}
				return basicSetSDocumentGraph((SDocumentGraph)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SCorpusStructurePackage.SDOCUMENT__SDOCUMENT_GRAPH:
				return basicSetSDocumentGraph(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}
// =========================================== end: relation to SDocumentGraph
	
	/**
	 *{@inheritDoc SDocument#getSDocumentGraphLocation()}
	 */
	@Override
	public URI getSDocumentGraphLocation() {
		URI retVal= null;
		String name= SaltFactory.NAMESPACE_SALT + "::" + SFEATURE_NAME.SDOCUMENT_GRAPH_LOCATION;
		SFeature sFeature= this.getSFeature(name);
		if (sFeature!= null)
		{
			Object obj= sFeature.getSValue();
			if (obj instanceof URI)
				retVal= (URI) obj;
			else retVal= URI.createURI(obj.toString());
		}
		return(retVal);
	}

	/**
	 *{@inheritDoc SDocument#setSDocumentGraph(SDocumentGraph)}
	 */
	@Override
	public void setSDocumentGraphLocation(URI newSDocumentGraphLocation) {
		String name= SaltFactory.NAMESPACE_SALT + "::" + SFEATURE_NAME.SDOCUMENT_GRAPH_LOCATION; 
		SFeature sFeature= this.getSFeature(name);
		if (sFeature== null)
		{//create a new sFeature
			sFeature= SaltFactory.eINSTANCE.createSFeature();
			sFeature.setSNS(SaltFactory.NAMESPACE_SALT);
			sFeature.setSName(SFEATURE_NAME.SDOCUMENT_GRAPH_LOCATION.toString());
			this.addSFeature(sFeature);
		}	
		sFeature.setSValue(newSDocumentGraphLocation.toString());
	}

	/**
	 * {@inheritDoc SDocument#save(URI)}
	 */
	@Override
	public void saveSDocumentGraph(URI sDocumentGraphLocation) {
		SaltFactory.eINSTANCE.saveSDocumentGraph(this.getSDocumentGraph(), sDocumentGraphLocation);
		//remove sDocumentGrpah and double linking 
		this.setSDocumentGraph(null);
		//remove results removing of SDocumentGraphLocation, therefore set location again
		this.setSDocumentGraphLocation(sDocumentGraphLocation);
	}

	/**
	 * {@inheritDoc SDocument#load()}
	 */
	@Override
	public void loadSDocumentGraph() {
		this.loadSDocumentGraph(this.getSDocumentGraphLocation());
	}

	/**
	 * {@inheritDoc SDocument#load(URI)}
	 */
	@Override
	public void loadSDocumentGraph(URI sDocumentGraphLocation) {
		SDocumentGraph sDocumentGraph= SaltFactory.eINSTANCE.loadSDocumentGraph(sDocumentGraphLocation);
		this.setSDocumentGraph(sDocumentGraph);
		//remove SFeature containing location of where SaltXML file containing the loaded object  
		this.removeLabel(SaltFactory.NAMESPACE_SALT, SFEATURE_NAME.SDOCUMENT_GRAPH_LOCATION.toString());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSName(String newSName) {
		String oldSName = this.getSName();
		SNamedElementImpl.setSName(this, newSName);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SaltCorePackage.SNODE__SNAME, oldSName, newSName));
		if (this.getSDocumentGraph()!=null) {
			this.getSDocumentGraph().basicSetSElementId();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SCorpusStructurePackage.SDOCUMENT__SCORPUS_GRAPH:
				return eInternalContainer().eInverseRemove(this, SCorpusStructurePackage.SCORPUS_GRAPH__SDOCUMENTS, SCorpusGraph.class, msgs);
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
			case SCorpusStructurePackage.SDOCUMENT__SCORPUS_GRAPH:
				return getSCorpusGraph();
			case SCorpusStructurePackage.SDOCUMENT__SDOCUMENT_GRAPH:
				return getSDocumentGraph();
			case SCorpusStructurePackage.SDOCUMENT__SDOCUMENT_GRAPH_LOCATION:
				return getSDocumentGraphLocation();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SCorpusStructurePackage.SDOCUMENT__SCORPUS_GRAPH:
				setSCorpusGraph((SCorpusGraph)newValue);
				return;
			case SCorpusStructurePackage.SDOCUMENT__SDOCUMENT_GRAPH:
				setSDocumentGraph((SDocumentGraph)newValue);
				return;
			case SCorpusStructurePackage.SDOCUMENT__SDOCUMENT_GRAPH_LOCATION:
				setSDocumentGraphLocation((URI)newValue);
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
			case SCorpusStructurePackage.SDOCUMENT__SCORPUS_GRAPH:
				setSCorpusGraph((SCorpusGraph)null);
				return;
			case SCorpusStructurePackage.SDOCUMENT__SDOCUMENT_GRAPH:
				setSDocumentGraph((SDocumentGraph)null);
				return;
			case SCorpusStructurePackage.SDOCUMENT__SDOCUMENT_GRAPH_LOCATION:
				setSDocumentGraphLocation(SDOCUMENT_GRAPH_LOCATION_EDEFAULT);
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
			case SCorpusStructurePackage.SDOCUMENT__SCORPUS_GRAPH:
				return getSCorpusGraph() != null;
			case SCorpusStructurePackage.SDOCUMENT__SDOCUMENT_GRAPH:
				return getSDocumentGraph() != null;
			case SCorpusStructurePackage.SDOCUMENT__SDOCUMENT_GRAPH_LOCATION:
				return SDOCUMENT_GRAPH_LOCATION_EDEFAULT == null ? getSDocumentGraphLocation() != null : !SDOCUMENT_GRAPH_LOCATION_EDEFAULT.equals(getSDocumentGraphLocation());
		}
		return super.eIsSet(featureID);
	}

	/**
	 * Returns a String representation for this object. 
	 */
	@Override
	public String toString()
	{
		StringBuffer strBuffer= new StringBuffer();
		strBuffer.append("["+this.getClass().getSimpleName());
		strBuffer.append("("+ this.getId()+")");
		if (this.getLabels()!= null)
		{
			strBuffer.append(": ");
			for (Label label: this.getLabels())
			{
				if (	(!(label instanceof Identifier))&&
						(!(SaltCommonPackage.eNS_PREFIX + "::" + SFEATURE_NAME.SDOCUMENT_GRAPH).equals(label.getQName())))
				{	
					if (label.getNamespace()!= null)
						strBuffer.append(label.getNamespace()+":");
					strBuffer.append(label.getName()+"=");
					strBuffer.append(label.getValue());
					strBuffer.append(", ");
				}
			}
		}
		strBuffer.append("]");
		return(strBuffer.toString());
	}
	
} //SDocumentImpl
