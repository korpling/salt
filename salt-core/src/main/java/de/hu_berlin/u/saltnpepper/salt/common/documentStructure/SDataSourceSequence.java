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
package de.hu_berlin.u.saltnpepper.salt.common.documentStructure;


public interface SDataSourceSequence{
	public Integer getSStart();

	public void setSStart(Integer value);

	public Integer getSEnd();

	public void setSEnd(Integer value);

	public SSequentialDS getSSequentialDS();

	public void setSSequentialDS(SSequentialDS value);

	/**
	 * Checks if this object is valid. Means, that the given start and end points are inside the borders 
	 * of the set data source. This method throws an {@link SaltValidateException} if this object is not
	 * valid and returns true, if it is.
	 * @return true, if and only if the object is valid 
	 * @model
	 */
	public Boolean validate();

} // SDataSourceSequence
