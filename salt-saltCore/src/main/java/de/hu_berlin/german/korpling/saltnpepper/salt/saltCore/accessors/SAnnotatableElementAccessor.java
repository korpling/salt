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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.accessors;

import java.util.ArrayList;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEList;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCoreFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label;

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
		if (	(sProcElem.getLabels()!= null) &&
				(sProcElem.getLabels().size()>0))
		{
			
		}	
		for (int i= 0; i < sProcElem.getLabels().size(); i++)
		{
			Label label= sProcElem.getLabels().get(i);
			if (label instanceof SAnnotation)
				sProcAnnosList.add((SAnnotation) label);
		}
//		old since 2010-10-15	
//		for (Label label: sProcElem.getLabels() ) 
//		{
//			if (label instanceof SAnnotation)
//				sProcAnnosList.add((SAnnotation) label);
//		}
		sProcAnnos= new EcoreEList.UnmodifiableEList((InternalEObject)sProcElem,
												SaltCorePackage.eINSTANCE.getSAnnotatableElement_SAnnotations(),
												sProcAnnosList.size(), sProcAnnosList.toArray());
		return(sProcAnnos);	
	}
	
	public SAnnotation createSAnnotation(SAnnotatableElement sProcElem, String sNS, String sName, Object sValue, SDATATYPE sValueType) {
		SAnnotation retVal = SaltCoreFactory.eINSTANCE.createSAnnotation();
		retVal.setSNS(sNS);
		retVal.setSName(sName);
		retVal.setSValue(sValue);
		sProcElem.addSAnnotation(retVal);
		return retVal;
	}
	
}
