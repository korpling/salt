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