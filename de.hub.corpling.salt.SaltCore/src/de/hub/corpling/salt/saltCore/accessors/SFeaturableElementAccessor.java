package de.hub.corpling.salt.saltCore.accessors;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEList;

import de.hub.corpling.graph.Label;
import de.hub.corpling.salt.saltCore.SFeaturableElement;
import de.hub.corpling.salt.saltCore.SFeature;
import de.hub.corpling.salt.saltCore.SaltCorePackage;

public class SFeaturableElementAccessor 
{
	public void addSFeature(	SFeaturableElement sFeatElem,
											SFeature SFeature) 
	{
		sFeatElem.addLabel(SFeature);
	}

	public SFeature getSFeature(	SFeaturableElement sFeatElem,
															String fullName) 
	{
		SFeature sFeatAnno= null;
		Label label= sFeatElem.getLabel(fullName);
		if (label instanceof SFeature)
			sFeatAnno= (SFeature) label;
		return(sFeatAnno);
	}

	@SuppressWarnings("unchecked")
	public EList<SFeature> getSFeatures(SFeaturableElement sFeatElem) 
	{
		EList<SFeature> sFeatAnnos= null;
		ArrayList<SFeature> sFeatAnnosList = new ArrayList<SFeature>();
		for (Label label: sFeatElem.getLabels() ) 
		{
			if (label instanceof SFeature)
				sFeatAnnosList.add((SFeature) label);
		}
		sFeatAnnos= new EcoreEList.UnmodifiableEList((InternalEObject)sFeatElem,
												SaltCorePackage.eINSTANCE.getSFeaturableElement_SFeatures(),
												sFeatAnnosList.size(), sFeatAnnosList.toArray());
		return(sFeatAnnos);	
	}
}
