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
