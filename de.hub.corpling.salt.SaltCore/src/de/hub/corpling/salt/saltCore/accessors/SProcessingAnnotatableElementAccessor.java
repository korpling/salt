package de.hub.corpling.salt.saltCore.accessors;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEList;

import de.hub.corpling.graph.Label;
import de.hub.corpling.salt.saltCore.SProcessingAnnotatableElement;
import de.hub.corpling.salt.saltCore.SProcessingAnnotation;
import de.hub.corpling.salt.saltCore.SaltCorePackage;

public class SProcessingAnnotatableElementAccessor 
{
	public void addSProcessingAnnotation(	SProcessingAnnotatableElement sProcElem,
											SProcessingAnnotation sProcessingAnnotation) 
	{
		sProcElem.addLabel(sProcessingAnnotation);
	}

	public SProcessingAnnotation getSProcessingAnnotation(	SProcessingAnnotatableElement sProcElem,
															String fullName) 
	{
		SProcessingAnnotation sProcAnno= null;
		Label label= sProcElem.getLabel(fullName);
		if (label instanceof SProcessingAnnotation)
			sProcAnno= (SProcessingAnnotation) label;
		return(sProcAnno);
	}

	@SuppressWarnings("unchecked")
	public EList<SProcessingAnnotation> getSProcessingAnnotations(SProcessingAnnotatableElement sProcElem) 
	{
		EList<SProcessingAnnotation> sProcAnnos= null;
		ArrayList<SProcessingAnnotation> sProcAnnosList = new ArrayList<SProcessingAnnotation>();
		for (Label label: sProcElem.getLabels() ) 
		{
			if (label instanceof SProcessingAnnotation)
				sProcAnnosList.add((SProcessingAnnotation) label);
		}
		sProcAnnos= new EcoreEList.UnmodifiableEList((InternalEObject)sProcElem,
												SaltCorePackage.eINSTANCE.getSProcessingAnnotatableElement_SProcessingAnnotations(),
												sProcAnnosList.size(), sProcAnnosList.toArray());
		return(sProcAnnos);	
	}
}
