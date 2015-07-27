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
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotatableElement;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SFeature;
import de.hu_berlin.u.saltnpepper.salt.core.SGraph;
import de.hu_berlin.u.saltnpepper.salt.core.SMetaAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SProcessingAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltException;

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
	public static void addSAnnotation(SAnnotatableElement container, SAnnotation annotation) {
		container.addLabel(annotation);
	}

	public static SAnnotation getSAnnotation(SAnnotatableElement container, String qName) {
		SAnnotation anno = null;
		Label label = container.getLabel(qName);
		if (label instanceof SAnnotation) {
			anno = (SAnnotation) label;
		}
		return (anno);
	}

	public static Set<SAnnotation> createAnnotations(SAnnotatableElement container, String annotationString) {
		Set<SAnnotation> retVal = new HashSet<>();
		if ((annotationString != null) && (!annotationString.isEmpty())) {
			String[] annotations = annotationString.split(";");
			for (String annotation : annotations) {
				SAnnotation sAnno = SaltFactory.createSAnnotation();
				retVal.add(sAnno);
				String[] nsParts = annotation.split(Label.NS_SEPERATOR);
				String rest;
				if (nsParts.length > 2)
					throw new SaltException("The given annotation String '" + annotation + "' is not conform to language: (SNS::)?SNAME(=SVALUE)?(;SNS::SNAME=SVALUE)++");
				else if (nsParts.length == 2) {
					sAnno.setNamespace(nsParts[0]);
					rest = nsParts[1];
				} else
					rest = nsParts[0];

				String[] nameParts = rest.split("=");
				if (nameParts.length > 2)
					throw new SaltException("The given annotation String '" + annotation + "' is not conform to language: (SNS::)?SNAME(=SVALUE)?(;SNS::SNAME=SVALUE)++");
				else if (nameParts.length == 2) {
					sAnno.setName(nameParts[0]);
					sAnno.setValue(nameParts[1]);
				} else
					sAnno.setName(nameParts[0]);
				container.addSAnnotation(sAnno);
			}

		}
		return (retVal);
	}

	/**
	 * A default list, which could be returned by methods to not create an empty
	 * list each time a method was invoked.
	 */
	private static final Set<SAnnotation> DEFAULT_EMPTY_LIST = Collections.unmodifiableSet(new HashSet<SAnnotation>());

	/**
	 * Returns all {@link SAnnotation} object, which are contained by the passed
	 * container.
	 * <p>
	 * Attention: This method is slow, since it iterates over all contained
	 * labels and creates a new list of all {@link SAnnotation} objects.
	 * </p>
	 * 
	 * @param container
	 *            the container object which contains the {@link SAnnotation} to
	 *            be searched for
	 * @return an unmodifiable list of {@link SAnnotation} object or an empty
	 *         list
	 */
	@SuppressWarnings("unchecked")
	public static <A extends SAnnotation> Set<A> getAnnotations(SAnnotatableElement container) {
		Set<SAnnotation> retVal = null;
		if (container != null) {
			for (Label label : container.getLabels()) {
				if (label instanceof SAnnotation) {
					if (retVal == null) {
						retVal = new HashSet<SAnnotation>();
					}
					retVal.add((SAnnotation) label);
				}
			}
		}
		if (retVal != null) {
			retVal = Collections.unmodifiableSet(retVal);
		} else {
			return (Set<A>) (DEFAULT_EMPTY_LIST);
		}
		return (Set<A>) (retVal);
	}

	public static SAnnotation createSAnnotation(SAnnotatableElement container, String namespace, String name, Object value) {
		SAnnotation retVal = SaltFactory.createSAnnotation();
		retVal.setNamespace(namespace);
		retVal.setName(name);
		retVal.setValue(value);
		container.addSAnnotation(retVal);
		return retVal;
	}
}
