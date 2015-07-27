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
package de.hu_berlin.u.saltnpepper.salt.core;

import java.util.Set;

import de.hu_berlin.u.saltnpepper.graph.LabelableElement;

/**
 * This interface defines a container to hold annotations ({@link SAnnotation}),
 * meta-annotations ({@link SMetaAnnotation}), processing annotations (
 * {@link SProcessingAnnotation}) and features ({@link SFeature}).
 * 
 * @author florian
 *
 */
public interface SAnnotatableElement extends LabelableElement {
	public <A extends SAnnotation> Set<A> getAnnotations();

	/**
	 * Adds the passed annotation to this container.
	 * @param annotation annotation to be added
	 */
	public void addSAnnotation(SAnnotation annotation);

	/**
	 * Returns an annotation having the passed qualified name, if this container
	 * contains such an annotation.
	 * 
	 * @param qName
	 *            the qualified of the annotation. A qualified name consists of: namespace+'::'+name
	 * @return an annotation having the qualified name, if such an annotation exists, null otherwise
	 */
	public SAnnotation getAnnotation(String qName);

	/**
	 * Creates and returns an annotation having the passed namespace, name and value.
	 * @param namespace namespace of the annotation
	 * @param name name of the annotation
	 * @param value value of the annotation
	 * @return the created annotation
	 */
	public SAnnotation createAnnotation(String namespace, String name, Object value);
//	/**
//	 * Creates and returns an annotation having the passed namespace, name and value.
//	 * @param namespace namespace of the annotation
//	 * @param name name of the annotation
//	 * @param value value of the annotation
//	 * @return the created annotation
//	 */
//	public SAnnotation createAnnotation(String namespace, String name, String valueString);

	/**
	 * This method parses the given annotation String and adds an
	 * {@link SAnnotation} object for each annotation being contained in that
	 * string to the given {@link SAnnotatableElement} object. The syntax for
	 * Annotations is:<br/>
	 * (SNS::)?SNAME(=SVALUE)?(;SNS::SNAME=SVALUE)+ <br/>
	 * where SNS is the namespace of the annotation, SNAME is its name and
	 * SVALUE is the value of the annotation
	 * 
	 * @param annotationString
	 *            String containing the annotations
	 */
	public <A extends SAnnotation> Set<A> createAnnotations(String annotationString);

} // SAnnotatableElement
