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

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.Label;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotatableElement;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCoreFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SaltCorePackage;

public class SMetaAnnotatableElementAccessor 
{
	public void addSMetaAnnotation(	SMetaAnnotatableElement sProcElem,
											SMetaAnnotation SMetaAnnotation) 
	{
		sProcElem.addLabel(SMetaAnnotation);
	}

	public SMetaAnnotation getSMetaAnnotation(	SMetaAnnotatableElement sProcElem,
															String qName) 
	{
		SMetaAnnotation sProcMetaAnno= null;
		Label label= sProcElem.getLabel(qName);
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
	
	public SMetaAnnotation createSMetaAnnotation(SMetaAnnotatableElement sProcElem, String sNS, String sName, Object sValue, SDATATYPE sValueType) {
		SMetaAnnotation retVal = SaltCoreFactory.eINSTANCE.createSMetaAnnotation();
		retVal.setSNS(sNS);
		retVal.setSName(sName);
		retVal.setSValue(sValue);
		sProcElem.addSMetaAnnotation(retVal);
		return retVal;
	}
}
