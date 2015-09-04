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
package de.hu_berlin.u.saltnpepper.salt.util.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;

import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotationContainer;
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
public class SAnnotationContainerHelper {

	public static class MyIterator<E extends Label> implements Iterator<E> {

		/** The real iterator, to which this iterator delegates its methods **/
		protected Iterator<Label> delegatee = null;
		protected Class<E> clazz = null;

		public MyIterator(Iterator<Label> delegatee, Class<E> clazz) {
			this.delegatee = delegatee;
			this.clazz = clazz;
		}

		/**
		 * A handle to the next element, this is necessary to get
		 * {@link #hasNext()} run.
		 **/
		protected E next = null;

		@Override
		public boolean hasNext() {
			if (!delegatee.hasNext()) {
				return (false);
			} else {
				next = next();
				if (next != null) {
					return (true);
				} else {
					return (false);
				}
			}
		}

		@SuppressWarnings("unchecked")
		@Override
		public synchronized E next() {
			E retVal = next;
			next = null;
			if (retVal == null) {
				Label label = null;
				while ((delegatee.hasNext()) && ((label = delegatee.next()) != null) && (!(clazz.isInstance(label)))) {
				}
				if (clazz.isInstance(label)) {
					retVal = (E) label;
				}

			}
			return (retVal);
		}

		@Override
		public void remove() {
			delegatee.remove();
		}
	}

	/**
	 * A default list, which could be returned by methods to not create an empty
	 * list each time a method was invoked.
	 */
	private static final Set<? extends Label> DEFAULT_EMPTY_LIST = Collections.unmodifiableSet(new HashSet<SAnnotation>());

	// =======================================> SAnnotation
	public static void addAnnotation(SAnnotationContainer container, SAnnotation annotation) {
		container.addLabel(annotation);
	}

	public static SAnnotation getAnnotation(SAnnotationContainer container, String qName) {
		SAnnotation anno = null;
		Label label = container.getLabel(qName);
		if (label instanceof SAnnotation) {
			anno = (SAnnotation) label;
		}
		return (anno);
	}

	public static Set<SAnnotation> createAnnotations(SAnnotationContainer container, String annotationString) {
		Set<SAnnotation> retVal = new HashSet<>();
		for (Triple<String, String, String> triple : unmarshalString(annotationString)) {
			retVal.add(container.createAnnotation(triple.getLeft(), triple.getMiddle(), triple.getRight()));
		}
		return (retVal);
	}

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
	public static <A extends SAnnotation> Set<A> getAnnotations(SAnnotationContainer container) {
		Set<SAnnotation> retVal = null;
		if ((container != null) && (container.getLabels() != null)) {
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

	public static Iterator<SAnnotation> iterator_SAnnotation(SAnnotationContainer container) {
		Iterator<SAnnotation> retVal = null;
		if (container != null) {
			retVal = new MyIterator<SAnnotation>(container.getLabels().iterator(), SAnnotation.class);
		}
		return (retVal);
	}

	public static SAnnotation createAnnotation(SAnnotationContainer container, String namespace, String name, Object value) {
		SAnnotation retVal = SaltFactory.createSAnnotation();
		retVal.setNamespace(namespace);
		retVal.setName(name);
		retVal.setValue(value);
		container.addAnnotation(retVal);
		return retVal;
	}

	// =======================================< SAnnotation

	// =======================================> SMetaAnnotation
	public static void addMetaAnnotation(SAnnotationContainer container, SMetaAnnotation metaAnnotation) {
		container.addLabel(metaAnnotation);
	}

	public static SMetaAnnotation createMetaAnnotation(SAnnotationContainer container, String namespace, String name, Object value) {
		SMetaAnnotation retVal = SaltFactory.createSMetaAnnotation();
		retVal.setNamespace(namespace);
		retVal.setName(name);
		retVal.setValue(value);
		container.addMetaAnnotation(retVal);
		return retVal;
	}

	public static Collection<Triple<String, String, String>> unmarshalString(String marshalledString) {
		Collection<Triple<String, String, String>> retVal = new ArrayList<>();
		String left = null;
		String middle = null;
		String right = null;
		if ((marshalledString != null) && (!marshalledString.isEmpty())) {
			String[] annotations = marshalledString.split(";");
			for (String annotation : annotations) {
				left = null;
				middle = null;
				right = null;
				String[] nsParts = annotation.split(Label.NS_SEPERATOR);
				String rest;
				if (nsParts.length > 2) {
					throw new SaltException("The given annotation String '" + annotation + "' is not conform to language: (SNS::)?SNAME(=SVALUE)?(;SNS::SNAME=SVALUE)++");
				} else if (nsParts.length == 2) {
					left = nsParts[0];
					rest = nsParts[1];
				} else {
					rest = nsParts[0];
				}
				String[] nameParts = rest.split("=");
				if (nameParts.length > 2) {
					throw new SaltException("The given annotation String '" + annotation + "' is not conform to language: (SNS::)?SNAME(=SVALUE)?(;SNS::SNAME=SVALUE)++");
				} else if (nameParts.length == 2) {
					middle = nameParts[0];
					right = nameParts[1];
				} else {
					middle = nameParts[0];
				}
				retVal.add(new ImmutableTriple<String, String, String>(left, middle, right));
			}
		}
		return (retVal);
	}

	public static Set<SMetaAnnotation> createMetaAnnotations(SAnnotationContainer container, String metaAnnotationString) {
		Set<SMetaAnnotation> retVal = new HashSet<>();
		for (Triple<String, String, String> triple : unmarshalString(metaAnnotationString)) {
			retVal.add(container.createMetaAnnotation(triple.getLeft(), triple.getMiddle(), triple.getRight()));
		}
		return (retVal);
	}

	/**
	 * Returns all {@link SMetaAnnotation} object, which are contained by the
	 * passed container.
	 * <p>
	 * Attention: This method is slow, since it iterates over all contained
	 * labels and creates a new list of all {@link SMetaAnnotation} objects.
	 * </p>
	 * 
	 * @param container
	 *            the container object which contains the
	 *            {@link SMetaAnnotation} to be searched for
	 * @return an unmodifiable list of {@link SMetaAnnotation} object or an
	 *         empty list
	 */
	@SuppressWarnings("unchecked")
	public static <A extends SMetaAnnotation> Set<A> getMetaAnnotations(SAnnotationContainer container) {
		Set<SMetaAnnotation> retVal = null;
		if ((container != null) && (container.getLabels() != null)) {
			for (Label label : container.getLabels()) {
				if (label instanceof SMetaAnnotation) {
					if (retVal == null) {
						retVal = new HashSet<SMetaAnnotation>();
					}
					retVal.add((SMetaAnnotation) label);
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

	public static SMetaAnnotation getMetaAnnotation(SAnnotationContainer container, String qName) {
		SMetaAnnotation anno = null;
		Label label = container.getLabel(qName);
		if (label instanceof SMetaAnnotation) {
			anno = (SMetaAnnotation) label;
		}
		return (anno);
	}

	public static Iterator<SMetaAnnotation> iterator_SMetaAnnotation(SAnnotationContainer container) {
		Iterator<SMetaAnnotation> retVal = null;
		if (container != null) {
			retVal = new MyIterator<SMetaAnnotation>(container.getLabels().iterator(), SMetaAnnotation.class);
		}
		return (retVal);
	}

	// =======================================< SMetaAnnotation
	// =======================================> SProcessingAnnotation
	public static void addProcessingAnnotation(SAnnotationContainer container, SProcessingAnnotation annotation) {
		container.addLabel(annotation);
	}

	public static SProcessingAnnotation getProcessingAnnotation(SAnnotationContainer container, String qName) {
		SProcessingAnnotation anno = null;
		Label label = container.getLabel(qName);
		if (label instanceof SProcessingAnnotation) {
			anno = (SProcessingAnnotation) label;
		}
		return (anno);
	}

	public static Set<SProcessingAnnotation> createProcessingAnnotations(SAnnotationContainer container, String annotationString) {
		Set<SProcessingAnnotation> retVal = new HashSet<>();
		for (Triple<String, String, String> triple : unmarshalString(annotationString)) {
			retVal.add(container.createProcessingAnnotation(triple.getLeft(), triple.getMiddle(), triple.getRight()));
		}
		return (retVal);
	}

	/**
	 * Returns all {@link SProcessingAnnotation} object, which are contained by
	 * the passed container.
	 * <p>
	 * Attention: This method is slow, since it iterates over all contained
	 * labels and creates a new list of all {@link SProcessingAnnotation}
	 * objects.
	 * </p>
	 * 
	 * @param container
	 *            the container object which contains the
	 *            {@link SProcessingAnnotation} to be searched for
	 * @return an unmodifiable list of {@link SProcessingAnnotation} object or
	 *         an empty list
	 */
	@SuppressWarnings("unchecked")
	public static <A extends SProcessingAnnotation> Set<A> getProcessingAnnotations(SAnnotationContainer container) {
		Set<SProcessingAnnotation> retVal = null;
		if ((container != null) && (container.getLabels() != null)) {
			for (Label label : container.getLabels()) {
				if (label instanceof SProcessingAnnotation) {
					if (retVal == null) {
						retVal = new HashSet<SProcessingAnnotation>();
					}
					retVal.add((SProcessingAnnotation) label);
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

	public static Iterator<SProcessingAnnotation> iterator_SProcessingAnnotation(SAnnotationContainer container) {
		Iterator<SProcessingAnnotation> retVal = null;
		if (container != null) {
			retVal = new MyIterator<SProcessingAnnotation>(container.getLabels().iterator(), SProcessingAnnotation.class);
		}
		return (retVal);
	}

	public static SProcessingAnnotation createProcessingAnnotation(SAnnotationContainer container, String namespace, String name, Object value) {
		SProcessingAnnotation retVal = SaltFactory.createSProcessingAnnotation();
		retVal.setNamespace(namespace);
		retVal.setName(name);
		retVal.setValue(value);
		container.addProcessingAnnotation(retVal);
		return retVal;
	}

	// =======================================< SProcessingAnnotation
	// =======================================> SFeature
	public static void addFeature(SAnnotationContainer container, SFeature annotation) {
		container.addLabel(annotation);
	}

	public static SFeature getFeature(SAnnotationContainer container, String qName) {
		SFeature anno = null;
		Label label = container.getLabel(qName);
		if (label instanceof SFeature) {
			anno = (SFeature) label;
		}
		return (anno);
	}

	public static Set<SFeature> createFeatures(SAnnotationContainer container, String annotationString) {
		Set<SFeature> retVal = new HashSet<>();
		for (Triple<String, String, String> triple : unmarshalString(annotationString)) {
			retVal.add(container.createFeature(triple.getLeft(), triple.getMiddle(), triple.getRight()));
		}
		return (retVal);
	}

	/**
	 * Returns all {@link SFeature} object, which are contained by the passed
	 * container.
	 * <p>
	 * Attention: This method is slow, since it iterates over all contained
	 * labels and creates a new list of all {@link SFeature} objects.
	 * </p>
	 * 
	 * @param container
	 *            the container object which contains the {@link SFeature} to be
	 *            searched for
	 * @return an unmodifiable list of {@link SFeature} object or an empty list
	 */
	@SuppressWarnings("unchecked")
	public static <A extends SFeature> Set<A> getFeatures(SAnnotationContainer container) {
		Set<SFeature> retVal = null;
		if ((container != null) && (container.getLabels() != null)) {
			for (Label label : container.getLabels()) {
				if (label instanceof SFeature) {
					if (retVal == null) {
						retVal = new HashSet<SFeature>();
					}
					retVal.add((SFeature) label);
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

	public static Iterator<SFeature> iterator_SFeature(SAnnotationContainer container) {
		Iterator<SFeature> retVal = null;
		if (container != null) {
			retVal = new MyIterator<SFeature>(container.getLabels().iterator(), SFeature.class);
		}
		return (retVal);
	}

	public static SFeature createFeature(SAnnotationContainer container, String namespace, String name, Object value) {
		SFeature retVal = SaltFactory.createSFeature();
		retVal.setNamespace(namespace);
		retVal.setName(name);
		retVal.setValue(value);
		container.addFeature(retVal);
		return retVal;
	}
	// =======================================< SFeature
}
