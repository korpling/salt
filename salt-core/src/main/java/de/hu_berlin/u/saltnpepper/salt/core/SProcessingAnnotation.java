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

import de.hu_berlin.u.saltnpepper.graph.Label;

/**
 * <p>
 * An object of class {@link SProcessingAnnotation} is a label and can be added
 * like every other label to a node, relation, graph, layer or to another label.
 * Like every label a {@link SProcessingAnnotation} object consists of the main
 * fields {@link Label#getNamespace()}, {@link Label#getName()} and
 * {@link Label#getValue()}.
 * </p>
 * <p>
 * SFeature objects are used to store structural information of Salt, which are
 * necessary to map a linguistic model to a graph. For instance {@link SFeature}
 * added to the relation between a token and a primary text contain the start
 * and end position of the token in the primary text. In the very most cases a
 * user of the Salt api will never need to use a {@link SFeature} object.<br/>
 * For further information on labels,
 * </p>
 * 
 * @see Label
 * 
 * @author florian
 *
 */
public interface SProcessingAnnotation extends Label {
	public SAnnotatableElement getSProcessingAnnotatableElement();

	public void setSProcessingAnnotatableElement(SAnnotatableElement value);

} // SProcessingAnnotation
