/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
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
package de.hu_berlin.u.saltnpepper.salt.util;

import java.util.ArrayList;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEList;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotatableElement;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SFeature;
import de.hu_berlin.u.saltnpepper.salt.core.SGraph;
import de.hu_berlin.u.saltnpepper.salt.core.SMetaAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SProcessingAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;

/**
 * This class is a helper class for internal use. It is used by {@link SNode},
 * {@link SRelation}, {@link SGraph} etc. . It provides methods to access all
 * {@link SAnnotation}, {@link SMetaAnnotation}, {@link SProcessingAnnotation}
 * and {@link SFeature} objects. 
 * 
 * @author florian
 *
 */
public class SAnnotatableElementHelper {
//	public void addSAnnotation(SAnnotatableElement sProcElem, SAnnotation SAnnotation) {
//		sProcElem.addLabel(SAnnotation);
//	}
//
//	public SAnnotation getSAnnotation(SAnnotatableElement sProcElem, String qName) {
//		SAnnotation sProcAnno = null;
//		Label label = sProcElem.getLabel(qName);
//		if (label instanceof SAnnotation)
//			sProcAnno = (SAnnotation) label;
//		return (sProcAnno);
//	}
//
//	/**
//	 * {@inheritDoc SaltFactory#createSAnnotations(SAnnotatableElement, String)}
//	 */
//	public EList<SAnnotation> createSAnnotations(SAnnotatableElement sProcElem, String annotationString) {
//		EList<SAnnotation> retVal = new BasicEList<SAnnotation>();
//		if ((annotationString != null) && (!annotationString.isEmpty())) {
//			String[] annotations = annotationString.split(";");
//			for (String annotation : annotations) {
//				SAnnotation sAnno = SaltCoreFactory.eINSTANCE.createSAnnotation();
//				retVal.add(sAnno);
//				String[] nsParts = annotation.split(Label.NS_SEPERATOR);
//				String rest;
//				if (nsParts.length > 2)
//					throw new SaltCoreException("The given annotation String '" + annotation + "' is not conform to language: (SNS::)?SNAME(=SVALUE)?(;SNS::SNAME=SVALUE)++");
//				else if (nsParts.length == 2) {
//					sAnno.setSNS(nsParts[0]);
//					rest = nsParts[1];
//				} else
//					rest = nsParts[0];
//
//				String[] nameParts = rest.split("=");
//				if (nameParts.length > 2)
//					throw new SaltCoreException("The given annotation String '" + annotation + "' is not conform to language: (SNS::)?SNAME(=SVALUE)?(;SNS::SNAME=SVALUE)++");
//				else if (nameParts.length == 2) {
//					sAnno.setSName(nameParts[0]);
//					sAnno.setSValue(nameParts[1]);
//				} else
//					sAnno.setSName(nameParts[0]);
//				sProcElem.addSAnnotation(sAnno);
//			}
//
//		}
//		return (retVal);
//	}
//
//	@SuppressWarnings("unchecked")
//	public EList<SAnnotation> getSAnnotations(SAnnotatableElement sProcElem) {
//		EList<SAnnotation> sProcAnnos = null;
//		ArrayList<SAnnotation> sProcAnnosList = new ArrayList<SAnnotation>();
//		if ((sProcElem.getLabels() != null) && (sProcElem.getLabels().size() > 0)) {
//
//		}
//		for (int i = 0; i < sProcElem.getLabels().size(); i++) {
//			Label label = sProcElem.getLabels().get(i);
//			if (label instanceof SAnnotation)
//				sProcAnnosList.add((SAnnotation) label);
//		}
//		sProcAnnos = new EcoreEList.UnmodifiableEList((InternalEObject) sProcElem, SaltCorePackage.eINSTANCE.getSAnnotatableElement_SAnnotations(), sProcAnnosList.size(), sProcAnnosList.toArray());
//		return (sProcAnnos);
//	}
//
//	public SAnnotation createSAnnotation(SAnnotatableElement sProcElem, String sNS, String sName, Object sValue, SDATATYPE sValueType) {
//		SAnnotation retVal = SaltFactory.createSAnnotation();
//		retVal.setSNS(sNS);
//		retVal.setSName(sName);
//		retVal.setSValue(sValue);
//		sProcElem.addSAnnotation(retVal);
//		return retVal;
//	}
}
