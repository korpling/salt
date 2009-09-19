/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hub.corpling.salt.saltCommon.sDocumentStructure.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEList;

import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentGraph;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.SDocumentStructurePackage;
import de.hub.corpling.salt.saltCommon.sDocumentStructure.STimeline;
import de.hub.corpling.salt.saltCore.SaltCorePackage;
import de.hub.corpling.salt.saltExceptions.SaltException;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>STimeline</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STimelineImpl#getSPointsOfTime <em>SPoints Of Time</em>}</li>
 *   <li>{@link de.hub.corpling.salt.saltCommon.sDocumentStructure.impl.STimelineImpl#getSDocumentGraph <em>SDocument Graph</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class STimelineImpl extends SSequentialDSImpl implements STimeline {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected STimelineImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SDocumentStructurePackage.Literals.STIMELINE;
	}

	public String timeLineSeperator= "#";
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@SuppressWarnings("unchecked")
	public EList<String> getSPointsOfTime()  
	{
		String timelineStr= (String) super.getSData();
		String[] timelineStrArr= timelineStr.split("#");
		
//		Double[] doubleArr= new Double[timelineStrArr.length];
//		for (int i= 0; i< timelineStrArr.length; i++)
//			doubleArr[i]= Double.parseDouble(timelineStrArr[i]);
			
		EList<String> retVal= null;
		retVal= new EcoreEList.UnmodifiableEList(this,
				SaltCorePackage.eINSTANCE.getSFeaturableElement_SFeatures(),
				timelineStrArr.length, timelineStrArr);
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SDocumentGraph getSDocumentGraph() {
		SDocumentGraph sDocumentGraph = basicGetSDocumentGraph();
		return sDocumentGraph != null && sDocumentGraph.eIsProxy() ? (SDocumentGraph)eResolveProxy((InternalEObject)sDocumentGraph) : sDocumentGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public SDocumentGraph basicGetSDocumentGraph() 
	{
		SDocumentGraph retVal= null;
		if (super.getSGraph() instanceof SDocumentGraph)
			retVal= (SDocumentGraph) super.getSGraph();
		return(retVal);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void setSDocumentGraph(SDocumentGraph newSDocumentGraph) 
	{
		super.setSGraph(newSDocumentGraph);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public void addSPointOfTime(String sPointOfTime) 
	{
		if (sPointOfTime== null)
			throw new SaltException("Cannot add an empty point of time.");
		String timeline= (String) super.getSData();
		if (timeline== null)
			timeline= sPointOfTime.toString();
		else
			timeline= timeline+ timeLineSeperator + sPointOfTime;
		super.setSData(timeline);
//		SFeature sFeature= super.getSData(); 
//		String timeline= null;
//		
//		if (sFeature == null)
//		{
//			sFeature= SaltCommonFactory.eINSTANCE.createSFeature();
//			sFeature.setSName(KW_TIMELINE);
//			this.addSFeature(sFeature);
//		}
//		else 
//			timeline= (String) sFeature.getSValue();
//		if (timeline== null)
//			timeline= sPointOfTime.toString();
//		else
//			timeline= timeline+ timeLineSeperator + sPointOfTime;
//		sFeature.setSValue(timeline);	
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SDocumentStructurePackage.STIMELINE__SPOINTS_OF_TIME:
				return getSPointsOfTime();
			case SDocumentStructurePackage.STIMELINE__SDOCUMENT_GRAPH:
				if (resolve) return getSDocumentGraph();
				return basicGetSDocumentGraph();
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
			case SDocumentStructurePackage.STIMELINE__SPOINTS_OF_TIME:
				getSPointsOfTime().clear();
				getSPointsOfTime().addAll((Collection<? extends String>)newValue);
				return;
			case SDocumentStructurePackage.STIMELINE__SDOCUMENT_GRAPH:
				setSDocumentGraph((SDocumentGraph)newValue);
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
			case SDocumentStructurePackage.STIMELINE__SPOINTS_OF_TIME:
				getSPointsOfTime().clear();
				return;
			case SDocumentStructurePackage.STIMELINE__SDOCUMENT_GRAPH:
				setSDocumentGraph((SDocumentGraph)null);
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
			case SDocumentStructurePackage.STIMELINE__SPOINTS_OF_TIME:
				return !getSPointsOfTime().isEmpty();
			case SDocumentStructurePackage.STIMELINE__SDOCUMENT_GRAPH:
				return basicGetSDocumentGraph() != null;
		}
		return super.eIsSet(featureID);
	}

} //STimelineImpl
