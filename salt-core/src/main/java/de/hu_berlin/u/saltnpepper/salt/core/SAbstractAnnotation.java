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

import org.eclipse.emf.common.util.URI;

import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.salt.SDATATYPE;

/**
 * <p>
 * An annotation in Salt is an attribute-value-pair and can belong to either a
 * node, an edge, a graph, a layer or another label. An attribute-value-pair is
 * a triple which consists of a namespace, a name and a value
 * (namespace:name=value). The combination of name and namespace is used to
 * identify a label and therefore must be unique. The namespace is an optional
 * value, to distinguish in case of there are two annotations having the same
 * name. For instance a node etc. can have a label stts:pos=VVFIN as well as the
 * label pos:VV to annotate it with two part-of-speech annotations from
 * different tagsets.
 * </p>
 * </p> SFeature objects are used to store structural information of Salt, which
 * are necessary to map a linguistic model to a graph. For instance
 * {@link SFeature} added to the relation between a token and a primary text
 * contain the start and end position of the token in the primary text. In the
 * very most cases a user of the Salt api will never need to use a
 * {@link SFeature} object.</p> For further information on labels,
 * 
 * @see Label
 * 
 * @author florian
 *
 */
public interface SAbstractAnnotation extends Label {
	/**
	 * Returns the value of the '<em><b>SValue Type</b></em>' attribute. The
	 * literals are from the enumeration
	 * {@link de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SDATATYPE}.
	 * If no {@link SDATATYPE} was set, a value will be computed. Here is the
	 * list of how java objects will be mapped to a {@link SDATATYPE} value.
	 * <ul>
	 * <li>null--> {@link SDATATYPE#SOBJECT}</li>
	 * <li>String --> {@link SDATATYPE#STEXT}</li>
	 * <li>Boolean --> {@link SDATATYPE#SBOOLEAN}</li>
	 * <li>Integer --> {@link SDATATYPE#SNUMERIC}</li>
	 * <li>Long --> {@link SDATATYPE#SNUMERIC}</li>
	 * <li>Double --> {@link SDATATYPE#SFLOAT}</li>
	 * <li>Float --> {@link SDATATYPE#SFLOAT}</li>
	 * <li>URI --> {@link SDATATYPE#SURI}</li>
	 * <li>else --> {@link SDATATYPE#SOBJECT}</li>
	 * </ul>
	 * 
	 * @return the value of the '<em>SValue Type</em>' attribute.
	 */
	public SDATATYPE getValueType();

	public void setValueType(SDATATYPE value);

	/**
	 * Returns the <em>sValue</em> attribute of this object as String
	 * representation. If the <em>sValue</em> is of type {@link String} it will
	 * be returned, else the {@link #toString()} method will be called. If no
	 * value is given, null will be returned.
	 * 
	 * @return {@link String} representation of the <em>sValue</em> attribute.
	 */
	public String getValue_STEXT();

	/**
	 * Returns the <em>sValue</em> attribute of this object as {@link Boolean}
	 * if possible. If the value is not of type {@link Boolean} or is empty,
	 * null will be returned.
	 * 
	 * @return {@link Boolean} representation of the <em>sValue</em> attribute.
	 */
	public Boolean getValue_SBOOLEAN();

	/**
	 * Returns the <em>sValue</em> attribute of this object as {@link Long} if
	 * possible. If the value is not of type {@link Long} or is empty, null will
	 * be returned.
	 * 
	 * @return {@link Long} representation of the <em>sValue</em> attribute.
	 */
	public Long getValue_SNUMERIC();

	/**
	 * Returns the <em>sValue</em> attribute of this object as {@link Float} if
	 * possible. If the value is not of type {@link Float} or is empty, null
	 * will be returned.
	 * 
	 * @return {@link Float} representation of the <em>sValue</em> attribute.
	 */
	public Double getValue_SFLOAT();

	/**
	 * Returns the <em>sValue</em> attribute of this object as {@link URI} if
	 * possible. If the value is not of type {@link URI} or is empty, null will
	 * be returned.
	 * 
	 * @return {@link URI} representation of the <em>sValue</em> attribute.
	 */
	public URI getValue_SURI();

	/**
	 * Returns the the <em>sValue</em> attribute of this object as the original
	 * object. This will always work as long as <em>sValue</em> is not empty. If
	 * the <em>sValue</em> attribute is empty null will be returned.
	 * 
	 * @return {@link Object} representation of the <em>sValue</em> attribute
	 */
	public Object getValue_SOBJECT();
}
