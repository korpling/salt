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
package org.corpus_tools.salt.common.impl;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.common.SSequentialDS;
import org.corpus_tools.salt.core.SFeature;
import org.corpus_tools.salt.core.impl.SLayerImpl;
import org.corpus_tools.salt.core.impl.SNodeImpl;
import org.corpus_tools.salt.exceptions.SaltParameterException;
import org.corpus_tools.salt.graph.Graph;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.util.SaltUtil;

@SuppressWarnings("serial")
public abstract class SSequentialDSImpl<D, P extends Number> extends SNodeImpl implements SSequentialDS<D, P> {
	/** Initializes an object of type {@link SLayerImpl}. **/
	public SSequentialDSImpl() {
	}

	/**
	 * Initializes an object of type {@link SLayerImpl}. If {@link #delegate} is
	 * not null, all functions of this method are delegated to the delegate
	 * object. Setting {@link #delegate} makes this object to a container.
	 * 
	 * @param a
	 *            delegate object of the same type.
	 */
	public SSequentialDSImpl(Node delegate) {
		super(delegate);
	}

	/** {@inheritDoc} */
	@Override
	public D getData() {
		D retVal = null;
		SFeature feature = getFeature(SaltUtil.FEAT_SDATA_QNAME);
		if (feature != null) {
			retVal = (D) feature.getValue();
		}
		return (retVal);
	}

	/** {@inheritDoc} */
	@Override
	public void setData(D newSData) {
		SFeature feature = getFeature(SaltUtil.FEAT_SDATA_QNAME);
		if (feature == null) {// create a new sFeature
			feature = SaltFactory.createSFeature();
			feature.setNamespace(SaltUtil.SALT_NAMESPACE);
			feature.setName(SaltUtil.FEAT_SDATA);
			this.addFeature(feature);
		}
		feature.setValue(newSData);
	}

	/** {@inheritDoc} */
	@Override
	public SDocumentGraph getGraph() {
		return ((SDocumentGraph) super.getGraph());
	}

	/** {@inheritDoc} **/
	@Override
	public void setGraph(@SuppressWarnings("rawtypes") Graph graph) {
		if (!(graph instanceof SDocumentGraph)) {
			throw new SaltParameterException("graph", "setGrah", getClass(), "The parameter was not of type SDocumentGraph. ");
		}
		super.setGraph(graph);
	}

	/** {@inheritDoc SSequentialDS#getSStart()} */
	@Override
	public abstract P getStart();

	/** {@inheritDoc SSequentialDS#getSStart()} */
	@Override
	public abstract P getEnd();
} // SSequentialDSImpl
