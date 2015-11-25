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

import org.eclipse.emf.common.util.URI;

/**
 * Each object implementing this interface is able to return a {@link URI} for
 * the id of this object.
 * 
 * @author florian
 *
 */
public interface SPathElement {
	/**
	 * Returns the id of this object as a URI path If no Id exists, null is
	 * returned.
	 * 
	 * @return uri path corresponding to the id of this object
	 */
	public URI getPath();
}
