/**
 * Copyright 2016 Humboldt-Universität zu Berlin.
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
package org.corpus_tools.salt.util.internal;

public class Invalidity {
	private final Object invalidObject;
	private final String reason;

	public Invalidity(Object invalidObject, String reason) {
		this.invalidObject = invalidObject;
		this.reason = reason;
	}

	/**
	 * A human readable description, why the {@link #getInvalidObject()} is
	 * invalid.
	 * 
	 * @return
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * The invalid object itself.
	 * 
	 * @return
	 */
	public Object getInvalidObject() {
		return invalidObject;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((invalidObject == null) ? 0 : invalidObject.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invalidity other = (Invalidity) obj;
		if (invalidObject == null) {
			if (other.invalidObject != null)
				return false;
		} else if (!invalidObject.equals(other.invalidObject))
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Invalidity [invalidObject=" + invalidObject + ", reason=" + reason + "]";
	}
}