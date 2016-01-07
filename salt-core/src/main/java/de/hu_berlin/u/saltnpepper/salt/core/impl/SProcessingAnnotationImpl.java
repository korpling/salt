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
package de.hu_berlin.u.saltnpepper.salt.core.impl;

import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.salt.core.SProcessingAnnotation;

@SuppressWarnings("serial")
public class SProcessingAnnotationImpl extends SAbstractAnnotationImpl implements SProcessingAnnotation {
	/** Initializes an object of type {@link SProcessingAnnotationImpl}. **/
	public SProcessingAnnotationImpl() {
	}

	/**
	 * Initializes an object of type {@link SProcessingAnnotationImpl}. If
	 * {@link #delegate} is not null, all functions of this method are delegated
	 * to the delegate object. Setting {@link #delegate} makes this object to a
	 * container.
	 * 
	 * @param a
	 *            delegate object of the same type.
	 */
	public SProcessingAnnotationImpl(Label delegate) {
		super(delegate);
	}
} // SAnnotationImpl
