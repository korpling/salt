/**
 * Copyright 2009 Humboldt-Universität zu Berlin
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
package org.corpus_tools.salt.extensions.notification.graph;

import java.util.Collection;
import java.util.List;

import org.corpus_tools.salt.Beta;
import org.corpus_tools.salt.extensions.notification.Listener;

/**
 * To all classes implementing this interface a listener can be added. This
 * listener would then be notified about all changes in the object.
 */
@Beta
public interface Notifier {
	/**
	 * Returns an unmodifiable list of all listeners. If no listener is
	 * registered null is returned.
	 * 
	 * @return all registered listeners
	 **/
	@Beta
	public List<Listener> getListener();

	/**
	 * Adds a new listener, which then will be notified about a change in this
	 * object.
	 * 
	 * @param listener
	 *            to be notified
	 */
	@Beta
	public void addListener(Listener listener);

	/**
	 * Adds a set of new listener, which then will be notified about a change in
	 * this object.
	 * 
	 * @param listener
	 *            to be notified
	 */
	@Beta
	public void addListener(Collection<Listener> listener);

	/**
	 * Removes a listener, which won't be notified about a change in this object
	 * anymore.
	 * 
	 * @param listener
	 *            to be notified
	 */
	@Beta
	public void removeListener(Listener listener);
}
