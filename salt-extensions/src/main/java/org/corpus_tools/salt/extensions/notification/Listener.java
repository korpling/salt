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
package org.corpus_tools.salt.extensions.notification;

import org.corpus_tools.salt.Beta;
import org.corpus_tools.salt.extensions.notification.graph.Notifier;
import org.corpus_tools.salt.graph.GRAPH_ATTRIBUTES;

/**
 * An object implementing this interface can be registered in a {@link Notifier}
 * object. If this listener is added, it will be notified about all changes in
 * the {@link org.eclipse.emf.common.notify.Notifier} object.
 * 
 * @author florian
 */
@Beta
public interface Listener {
	/**
	 * An enumeration containing all possible types of a notification.
	 * 
	 * @author florian
	 *
	 */
  @Beta
	public enum NOTIFICATION_TYPE {
		/** An object or value has been added **/
		ADD,
		/** An object or value has been removed. **/
		REMOVE,
		/** All objects or values have been removed. **/
		REMOVE_ALL,
		/** An object or value has been set. **/
		SET
	}

	/**
	 * A notification about any change in a {@link Notifier} object.
	 * 
	 * @param type
	 *            type of the notification.
	 * @param attribute
	 *            determines the attribute type
	 * @param oldValue
	 *            the value before the change
	 * @param newValue
	 *            the value after the change
	 * @param container
	 *            the object, which contains the changed object
	 */
  @Beta
	public void notify(NOTIFICATION_TYPE type, GRAPH_ATTRIBUTES attribute, Object oldValue, Object newValue, Object container);

  @Beta
	public static class Event {
		public NOTIFICATION_TYPE type = null;
		public GRAPH_ATTRIBUTES attribute = null;
		public Object oldValue = null;
		public Object newValue = null;
		public Object container = null;

		public Event(NOTIFICATION_TYPE type, GRAPH_ATTRIBUTES attribute, Object oldValue, Object newValue, Object container) {
			this.type = type;
			this.attribute = attribute;
			this.oldValue = oldValue;
			this.newValue = newValue;
			this.container = container;
		}
	}
}
