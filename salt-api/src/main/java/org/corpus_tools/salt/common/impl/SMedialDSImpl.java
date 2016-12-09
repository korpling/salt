/**
 * Copyright 2009 Humboldt-Universität zu Berlin.
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
package org.corpus_tools.salt.common.impl;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SMedialDS;
import org.corpus_tools.salt.core.SFeature;
import org.corpus_tools.salt.core.impl.SLayerImpl;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.util.SaltUtil;
import org.eclipse.emf.common.util.URI;

@SuppressWarnings("serial")
public class SMedialDSImpl extends SSequentialDSImpl<URI, Double> implements SMedialDS {
	/** Initializes an object of type {@link SLayerImpl}. **/
	public SMedialDSImpl() {
		this(null);
	}

	/**
	 * Initializes an object of type {@link SLayerImpl}. If {@link #delegate} is
	 * not null, all functions of this method are delegated to the delegate
	 * object. Setting {@link #delegate} makes this object to a container.
	 * 
	 * @param a
	 *            delegate object of the same type.
	 */
	public SMedialDSImpl(Node delegate) {
		super(delegate, URI.class);
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
