package de.hub.corpling.salt.saltCore.accessors;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEList;

import de.hub.corpling.graph.Label;
import de.hub.corpling.salt.saltCore.SMetaAnnotatableElement;
import de.hub.corpling.salt.saltCore.SMetaAnnotation;
import de.hub.corpling.salt.saltCore.SaltCorePackage;

public class SMetaAnnotatableElementAccessor 
{
	public void addSMetaAnnotation(	SMetaAnnotatableElement sProcElem,
											SMetaAnnotation SMetaAnnotation) 
	{
		sProcElem.addLabel(SMetaAnnotation);
	}

	public SMetaAnnotation getSMetaAnnotation(	SMetaAnnotatableElement sProcElem,
															String fullName) 
	{
		SMetaAnnotation sProcMetaAnno= null;
		Label label= sProcElem.getLabel(fullName);
		if (label instanceof SMetaAnnotation)
			sProcMetaAnno= (SMetaAnnotation) label;
		return(sProcMetaAnno);
	}

	@SuppressWarnings("unchecked")
	public EList<SMetaAnnotation> getSMetaAnnotations(SMetaAnnotatableElement sProcElem) 
	{
		EList<SMetaAnnotation> sProcMetaAnnos= null;
		ArrayList<SMetaAnnotation> sProcMetaAnnosList = new ArrayList<SMetaAnnotation>();
		for (Label label: sProcElem.getLabels() ) 
		{
			if (label instanceof SMetaAnnotation)
				sProcMetaAnnosList.add((SMetaAnnotation) label);
		}
		sProcMetaAnnos= new EcoreEList.UnmodifiableEList((InternalEObject)sProcElem,
												SaltCorePackage.eINSTANCE.getSMetaAnnotatableElement_SMetaAnnotations(),
												sProcMetaAnnosList.size(), sProcMetaAnnosList.toArray());
		return(sProcMetaAnnos);	
	}
}
