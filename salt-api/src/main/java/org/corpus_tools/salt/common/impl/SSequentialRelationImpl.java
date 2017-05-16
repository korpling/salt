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
import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.common.SSequentialRelation;
import org.corpus_tools.salt.core.SFeature;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.impl.SRelationImpl;
import org.corpus_tools.salt.exceptions.SaltParameterException;
import org.corpus_tools.salt.graph.Graph;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.graph.Relation;
import org.corpus_tools.salt.util.SaltUtil;

@SuppressWarnings("serial")
public abstract class SSequentialRelationImpl<S extends SNode, T extends SNode, P extends Number>
		extends SRelationImpl<S, T> implements SSequentialRelation<S, T, P> {
	private final Class<P> pointClass;

	/** Initializes an object of type {@link SSequentialRelationImpl}. **/
	public SSequentialRelationImpl(Class<S> sourceClass, Class<T> targetClass, Class<P> pointClass) {
		this(null, sourceClass, targetClass, pointClass);
	}

	/**
	 * Initializes an object of type {@link SSequentialRelationImpl}. If
	 * {@link #delegate} is not null, all functions of this method are delegated
	 * to the delegate object. Setting {@link #delegate} makes this object to a
	 * container.
	 * 
	 * @param a
	 *            delegate object of the same type.
	 */
	public SSequentialRelationImpl(Relation<S, T> delegate, Class<S> sourceClass, Class<T> targetClass,
			Class<P> pointClass) {
		super(delegate, sourceClass, targetClass);
		this.pointClass = pointClass;
	}

	/** {@inheritDoc} **/
	@Override
	public P getStart() {
		P retVal = null;
		SFeature sFeature = getFeature(SaltUtil.FEAT_SSTART_QNAME);
		if (sFeature != null) {
			Object val = sFeature.getValue();
			if (pointClass.isInstance(val)) {
				retVal = pointClass.cast(sFeature.getValue());
			}
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public void setStart(P newSStart) {
		SFeature sFeature = this.getFeature(SaltUtil.FEAT_SSTART_QNAME);
		if (sFeature == null) {// create a new sFeature
			sFeature = SaltFactory.createSFeature();
			sFeature.setNamespace(SaltUtil.SALT_NAMESPACE);
			sFeature.setName(SaltUtil.FEAT_SSTART);
			add(sFeature);
		}
		sFeature.setValue(newSStart);
	}

	/** {@inheritDoc} **/
	@Override
	public P getEnd() {
		P retVal = null;
		SFeature sFeature = this.getFeature(SaltUtil.FEAT_SEND_QNAME);
		if (sFeature != null) {
			Object val = sFeature.getValue();
			if (pointClass.isInstance(val)) {
				retVal = pointClass.cast(sFeature.getValue());
			}
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public void setEnd(P newSEnd) {
		SFeature sFeature = this.getFeature(SaltUtil.FEAT_SEND_QNAME);
		if (sFeature == null) {// create a new sFeature
			sFeature = SaltFactory.createSFeature();
			sFeature.setNamespace(SaltUtil.SALT_NAMESPACE);
			sFeature.setName(SaltUtil.FEAT_SEND);
			add(sFeature);
		}
		sFeature.setValue(newSEnd);
	}

	/** {@inheritDoc} **/
	@Override
	public SDocumentGraph getGraph() {
		return ((SDocumentGraph) super.getGraph());
	}

	@Override
	protected void basicSetGraph(Graph<? extends Node, ?, ?> graph) {
		if (graph != null && getDelegate() == null && !(graph instanceof SDocumentGraph)) {
			throw new SaltParameterException("graph", "basicSetGraph", getClass(), "Must be of type SDocumentGraph.");
		}
		super.basicSetGraph(graph);
	}

} // SSequentialRelationImpl
