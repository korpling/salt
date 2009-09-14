package de.hub.corpling.salt.saltCore.accessors;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEList;

import de.hub.corpling.graph.Label;
import de.hub.corpling.salt.saltCore.SAnnotatableElement;
import de.hub.corpling.salt.saltCore.SAnnotation;
import de.hub.corpling.salt.saltCore.SaltCorePackage;

public class SAnnotatableElementAccessor 
{
	public void addSAnnotation(	SAnnotatableElement sProcElem,
											SAnnotation SAnnotation) 
	{
		sProcElem.addLabel(SAnnotation);
	}

	public SAnnotation getSAnnotation(	SAnnotatableElement sProcElem,
															String fullName) 
	{
		SAnnotation sProcAnno= null;
		Label label= sProcElem.getLabel(fullName);
		if (label instanceof SAnnotation)
			sProcAnno= (SAnnotation) label;
		return(sProcAnno);
	}

	@SuppressWarnings("unchecked")
	public EList<SAnnotation> getSAnnotations(SAnnotatableElement sProcElem) 
	{
		EList<SAnnotation> sProcAnnos= null;
		ArrayList<SAnnotation> sProcAnnosList = new ArrayList<SAnnotation>();
		for (Label label: sProcElem.getLabels() ) 
		{
			if (label instanceof SAnnotation)
				sProcAnnosList.add((SAnnotation) label);
		}
		sProcAnnos= new EcoreEList.UnmodifiableEList((InternalEObject)sProcElem,
												SaltCorePackage.eINSTANCE.getSAnnotatableElement_SAnnotations(),
												sProcAnnosList.size(), sProcAnnosList.toArray());
		return(sProcAnnos);	
	}
}
