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
package de.hu_berlin.german.korpling.saltnpepper.salt.graph.index.impl;

import java.util.HashMap;

import de.hu_berlin.german.korpling.saltnpepper.salt.graph.IdentifiableElement;

/**
 * Implements {@link SimpleIndex}, the value of the index is any object of type {@link IdentifiableElement}, therefore its key is set to the
 * id of the {@link IdentifiableElement} object accessed via {@link IdentifiableElement#getId()}.
 * @author Florian Zipser
 *
 * @param <V>
 */
public class IdentifiableElementIndex<V extends IdentifiableElement> extends SimpleIndexImpl<String, V> 
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	protected IdentifiableElementIndex() {
		super();
		this.init();
	}

	private void init()
	{
		this.setIndexMap(new HashMap<String, V>());
	}
	
	/**
	 * Removes the given element from this index.
	 * @param element - the element which shall be removed
	 * @return true, if removing was successful 
	 * @model
	 */
	public Boolean removeElement(V element) 
	{
		return(this.removeElementById(element.getId()));
	}
}
