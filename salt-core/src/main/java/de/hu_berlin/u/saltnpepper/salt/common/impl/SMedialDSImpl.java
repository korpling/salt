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
package de.hu_berlin.u.saltnpepper.salt.common.impl;

import org.eclipse.emf.common.util.URI;

import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.common.SMedialDS;
import de.hu_berlin.u.saltnpepper.salt.core.SFeature;
import de.hu_berlin.u.saltnpepper.salt.util.SaltUtil;

@SuppressWarnings("serial")
public class SMedialDSImpl extends SSequentialDSImpl<URI, Double> implements SMedialDS {
	/** Initializes an object of type {@link SMedialDSImpl}. **/
	public SMedialDSImpl() {
	}

	/**
	 * Initializes an object of type {@link SMedialDSImpl}. If {@link #delegate}
	 * is not null, all functions of this method are delegated to the delegate
	 * object. Setting {@link #delegate} makes this object to a container.
	 * 
	 * @param a
	 *            delegate object of the same type.
	 */
	public SMedialDSImpl(Node delegate) {
		super(delegate);
	}

	/** {@inheritDoc} */
	@Override
	public URI getMediaReference() {
		URI retVal = null;
		SFeature sFeature = getFeature(SaltUtil.FEAT_SMEDIA_REFERNCE_QNAME);
		if ((sFeature != null) && (sFeature.getValue() != null)) {
			retVal = URI.createURI(sFeature.getValue().toString());
		}
		return (retVal);
	}

	/** {@inheritDoc} */
	@Override
	public void setMediaReference(URI mediaRef) {
		SFeature sFeature = getFeature(SaltUtil.FEAT_SMEDIA_REFERNCE_QNAME);
		if (sFeature == null) {// create a new sFeature
			sFeature = SaltFactory.createSFeature();
			sFeature.setNamespace(SaltUtil.SALT_NAMESPACE);
			sFeature.setName(SaltUtil.FEAT_SMEDIA_REFERNCE);
			addFeature(sFeature);
		}
		sFeature.setValue(mediaRef);
	}

	/** {@inheritDoc} */
	@Override
	public Double getStart() {
		return null;
	}

	/** {@inheritDoc} */
	@Override
	public Double getEnd() {
		return null;
	}

} // SAudioDataSourceImpl
