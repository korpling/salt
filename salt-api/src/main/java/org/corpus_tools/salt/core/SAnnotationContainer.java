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
package org.corpus_tools.salt.core;

import java.util.Iterator;
import java.util.Set;

import org.corpus_tools.salt.graph.LabelableElement;

/**
 * This interface defines a container to hold annotations ({@link SAnnotation}),
 * meta-annotations ({@link SMetaAnnotation}), processing annotations (
 * {@link SProcessingAnnotation}) and features ({@link SFeature}).
 * 
 * @author florian
 *
 */
public interface SAnnotationContainer extends LabelableElement {
	// =======================================> SAnnotation
	/**
	 * Creates and returns an annotation having the passed namespace, name and
	 * value.
	 * 
	 * @param namespace
	 *            namespace of the annotation
	 * @param name
	 *            name of the annotation
	 * @param value
	 *            value of the annotation
	 * @return the created annotation
	 */
	public SAnnotation createAnnotation(String namespace, String name, Object value);

	/**
	 * This method parses the given annotation String and adds an
	 * {@link SAnnotation} object for each annotation being contained in that
	 * string to the given {@link SAnnotationContainer} object. The syntax for
	 * Annotations is:<br/>
	 * (SNS::)?SNAME(=SVALUE)?(;SNS::SNAME=SVALUE)+ <br/>
	 * where SNS is the namespace of the annotation, SNAME is its name and
	 * SVALUE is the value of the annotation
	 * 
	 * @param annotationString
	 *            String containing the annotations
	 */
	public <A extends SAnnotation> Set<A> createAnnotations(String annotationString);

	/**
	 * Returns all annotations contained by this object.
	 * <p>
	 * Attention: This method is slow, since it iterates over all contained
	 * labels and creates a new list of all {@link SAnnotation} objects. Use
	 * {@link #iterator_SAnnotation()} instead.
	 * </p>
	 * 
	 * @return a list of all annotations
	 */
	public <A extends SAnnotation> Set<A> getAnnotations();

	/**
	 * Adds the passed annotation to this container.
	 * 
	 * @param annotation
	 *            annotation to be added
	 */
	public void addAnnotation(SAnnotation annotation);

	/**
	 * Returns an annotation having the passed qualified name, if this container
	 * contains such an annotation.
	 * 
	 * @param qName
	 *            the qualified of the annotation. A qualified name consists of:
	 *            namespace+'::'+name
	 * @return an annotation having the qualified name, if such an annotation
	 *         exists, null otherwise
	 */
	public SAnnotation getAnnotation(String qName);

	/**
	 * Returns an annotation having the passed qualified name, if this container
	 * contains such an annotation.
	 *
	 * @param namespace
	 *            the namespace of the annotation.
	 * @param name
	 *            the name of the annotation.
	 * @return an annotation having the qualified name, if such an annotation
	 *         exists, null otherwise
	 */
	public SAnnotation getAnnotation(String namespace, String name);

	/**
	 * Returns an iterator to iterate over the {@link SAnnotation} objects
	 * contained by this container. Using an iterator is slightly faster than
	 * {@link #getAnnotations()}.
	 * 
	 * @return an iterator of {@link SAnnotation} objects
	 */
	public Iterator<SAnnotation> iterator_SAnnotation();

	// =======================================< SAnnotation

	// =======================================> SMetaAnnotation
	/**
	 * Creates and returns a meta annotation having the passed namespace, name
	 * and value.
	 * 
	 * @param namespace
	 *            namespace of the meta annotation
	 * @param name
	 *            name of the meta annotation
	 * @param value
	 *            value of the meta annotation
	 * @return the created meta annotation
	 */
	public SMetaAnnotation createMetaAnnotation(String namespace, String name, Object value);

	/**
	 * This method parses the given meta annotation String and adds an
	 * {@link SMetaAnnotation} object for each meta annotation being contained
	 * in that string to the given {@link SAnnotationContainer} object. The
	 * syntax for meta annotations is:<br/>
	 * (SNS::)?SNAME(=SVALUE)?(;SNS::SNAME=SVALUE)+ <br/>
	 * where SNS is the namespace of the meta annotation, SNAME is its name and
	 * SVALUE is the value of the meta annotation
	 * 
	 * @param metaAnnotationString
	 *            String containing the meta annotations
	 */
	public <A extends SMetaAnnotation> Set<A> createMetaAnnotations(String metaAnnotationString);

	/**
	 * Returns all meta annotations contained by this object.
	 * <p>
	 * Attention: This method is slow, since it iterates over all contained
	 * labels and creates a new list of all {@link SAnnotation} objects. Use
	 * {@link #iterator_SAnnotation()} instead.
	 * </p>
	 * 
	 * @return a list of all meta annotations
	 */
	public <A extends SMetaAnnotation> Set<A> getMetaAnnotations();

	/**
	 * Adds the passed meta annotation to this container.
	 * 
	 * @param metaAnnotation
	 *            meta annotation to be added
	 */
	public void addMetaAnnotation(SMetaAnnotation metaAnnotation);

	/**
	 * Returns a meta annotation having the passed qualified name, if this
	 * container contains such a meta annotation.
	 * 
	 * @param qName
	 *            the qualified of the meta annotation. A qualified name
	 *            consists of: namespace+'::'+name
	 * @return a meta annotation having the qualified name, if such a meta
	 *         annotation exists, null otherwise
	 */
	public SMetaAnnotation getMetaAnnotation(String qName);

	/**
	 * Returns an iterator to iterate over the {@link SMetaAnnotation} objects
	 * contained by this container. Using an iterator is slightly faster than
	 * {@link #getMetaAnnotations()}.
	 * 
	 * @return an iterator of {@link SAnnotation} objects
	 */
	public Iterator<SMetaAnnotation> iterator_SMetaAnnotation();

	// =======================================< SMetaAnnotation

	// =======================================> SProcessingAnnotation
	/**
	 * Creates and returns a processing-annotation having the passed namespace,
	 * name and value.
	 * 
	 * @param namespace
	 *            namespace of the processing-annotation
	 * @param name
	 *            name of the processing-annotation
	 * @param value
	 *            value of the processing-annotation
	 * @return the created processing-annotation
	 */
	public SProcessingAnnotation createProcessingAnnotation(String namespace, String name, Object value);

	/**
	 * This method parses the given processing-annotation String and adds an
	 * {@link SProcessingAnnotation} object for each processing-annotation being
	 * contained in that string to the given {@link SAnnotationContainer}
	 * object. The syntax for processing-annotations is:<br/>
	 * (SNS::)?SNAME(=SVALUE)?(;SNS::SNAME=SVALUE)+ <br/>
	 * where SNS is the namespace of the processing-annotation, SNAME is its
	 * name and SVALUE is the value of the processing-annotation
	 * 
	 * @param annotationString
	 *            String containing the processing-annotations
	 */
	public <A extends SProcessingAnnotation> Set<A> createProcessingAnnotations(String annotationString);

	/**
	 * Returns all processing-annotations contained by this object.
	 * <p>
	 * Attention: This method is slow, since it iterates over all contained
	 * labels and creates a new list of all {@link SProcessingAnnotation}
	 * objects. Use {@link #iterator_SProcessingAnnotation()} instead.
	 * </p>
	 * 
	 * @return a list of all processing-annotations
	 */
	public <A extends SProcessingAnnotation> Set<A> getProcessingAnnotations();

	/**
	 * Adds the passed processing-annotation to this container.
	 * 
	 * @param processingAnnotation
	 *            annotation to be added
	 */
	public void addProcessingAnnotation(SProcessingAnnotation processingAnnotation);

	/**
	 * Returns a processing-annotation having the passed qualified name, if this
	 * container contains such a processing-annotation.
	 * 
	 * @param qName
	 *            the qualified of the processing-annotation. A qualified name
	 *            consists of: namespace+'::'+name
	 * @return an processing-annotation having the qualified name, if such an
	 *         processing-annotation exists, null otherwise
	 */
	public SProcessingAnnotation getProcessingAnnotation(String qName);

	/**
	 * Returns an iterator to iterate over the {@link SProcessingAnnotation}
	 * objects contained by this container. Using an iterator is slightly faster
	 * than {@link #getProcessingAnnotations()}.
	 * 
	 * @return an iterator of {@link SAnnotation} objects
	 */
	public Iterator<SProcessingAnnotation> iterator_SProcessingAnnotation();

	// =======================================< SProcessingAnnotation
	// =======================================> SFeature
	/**
	 * Creates and returns an feature having the passed namespace, name and
	 * value.
	 * 
	 * @param namespace
	 *            namespace of the feature
	 * @param name
	 *            name of the feature
	 * @param value
	 *            value of the feature
	 * @return the created feature
	 */
	public SFeature createFeature(String namespace, String name, Object value);

	/**
	 * This method parses the given feature String and adds an {@link SFeature}
	 * object for each feature being contained in that string to the given
	 * {@link SAnnotationContainer} object. The syntax for Features is:<br/>
	 * (SNS::)?SNAME(=SVALUE)?(;SNS::SNAME=SVALUE)+ <br/>
	 * where SNS is the namespace of the feature, SNAME is its name and SVALUE
	 * is the value of the feature
	 * 
	 * @param featureString
	 *            String containing the features
	 */
	public <A extends SFeature> Set<A> createFeatures(String featureString);

	/**
	 * Returns all features contained by this object.
	 * <p>
	 * Attention: This method is slow, since it iterates over all contained
	 * labels and creates a new list of all {@link SFeature} objects. Use
	 * {@link #iterator_SFeature()} instead.
	 * </p>
	 * 
	 * @return a list of all features
	 */
	public <A extends SFeature> Set<A> getFeatures();

	/**
	 * Adds the passed feature to this container.
	 * 
	 * @param feature
	 *            feature to be added
	 */
	public void addFeature(SFeature feature);

	/**
	 * Returns an feature having the passed qualified name, if this container
	 * contains such an feature.
	 * 
	 * @param qName
	 *            the qualified of the feature. A qualified name consists of:
	 *            namespace+'::'+name
	 * @return an feature having the qualified name, if such an feature exists,
	 *         null otherwise
	 */
	public SFeature getFeature(String qName);

	/**
	 * Returns an feature having the passed qualified name, if this container
	 * contains such an feature.
	 * 
	 * @param namespace
	 *            the namespace of the feature.
	 *
	 * @param name
	 *            the name of the feature.
	 * @return an feature having the qualified name, if such an feature exists,
	 *         null otherwise
	 */
	public SFeature getFeature(String namespace, String name);

	/**
	 * Returns an iterator to iterate over the {@link SFeature} objects
	 * contained by this container. Using an iterator is slightly faster than
	 * {@link #getFeatures()}.
	 * 
	 * @return an iterator of {@link SFeature} objects
	 */
	public Iterator<SFeature> iterator_SFeature();
	// =======================================< SFeature
}
