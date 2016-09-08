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
import org.corpus_tools.salt.common.SCorpusGraph;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.core.SFeature;
import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.impl.SLayerImpl;
import org.corpus_tools.salt.core.impl.SNodeImpl;
import org.corpus_tools.salt.exceptions.SaltInvalidModelException;
import org.corpus_tools.salt.graph.Graph;
import org.corpus_tools.salt.graph.Identifier;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.util.SaltUtil;
import org.eclipse.emf.common.util.URI;

@SuppressWarnings("serial")
public class SDocumentImpl extends SNodeImpl implements SDocument {
	/** Initializes an object of type {@link SLayerImpl}. **/
	public SDocumentImpl() {
	}

	/**
	 * Initializes an object of type {@link SLayerImpl}. If {@link #delegate} is
	 * not null, all functions of this method are delegated to the delegate
	 * object. Setting {@link #delegate} makes this object to a container.
	 * 
	 * @param a
	 *            delegate object of the same type.
	 */
	public SDocumentImpl(Node delegate) {
		super(delegate);
	}

	/** {@inheritDoc} **/
	@Override
	public SDocumentGraph getDocumentGraph() {
		SDocumentGraph retVal = null;
		final SFeature sFeature = getFeature(SaltUtil.FEAT_SDOCUMENT_GRAPH_QNAME);
		if (sFeature != null) {
			retVal = (SDocumentGraph) sFeature.getValue();
		}
		return (retVal);
	}
	
	/**
	 * Returns the document structure which belongs to this document. If no
	 * document structure was created so far, a new one is created and returned
	 * .
	 * 
	 * @return document structure
	 */
	public SDocumentGraph createDocumentGraph(){
		SDocumentGraph retVal= getDocumentGraph();
		if (retVal == null){
			retVal= SaltFactory.createSDocumentGraph();
			setDocumentGraph(retVal);
		}
		return retVal;
	}

	/** {@inheritDoc} **/
	@Override
	public void setDocumentGraph(final SDocumentGraph documentGraph) {
		final SDocumentGraph oldDocumentGraph = getDocumentGraph();
		if ((oldDocumentGraph != null) && (oldDocumentGraph != documentGraph)) {
			if (oldDocumentGraph instanceof SDocumentGraphImpl) {
				((SDocumentGraphImpl) oldDocumentGraph).basic_setDocument(null);
			}
		}
		if (documentGraph != null) {
			if (documentGraph instanceof SDocumentGraphImpl) {
				((SDocumentGraphImpl) documentGraph).basic_setDocument(this);
			}
		}
		basic_setDocumentGraph(documentGraph);
	}

	/**
	 * This is an internally used method. To implement a double chaining of
	 * {@link SDocument} and {@link SDocumentGraph} object when a document is
	 * set to avoid an endless invocation. The invocation of methods is
	 * implement as follows:
	 * 
	 * <pre>
	 * {@link #setSDocument(SDocument)}                      {@link SDocument#setDocumentGraph(Graph)}
	 *         ||             \ /                   ||
	 *         ||              X                    ||
	 *         \/             / \                   \/
	 * {@link #basicSDocument(SDocument)}            {@link SDocument#basicSetSDocumentGraph(Graph)}
	 * </pre>
	 * 
	 * @param document
	 *            the container document of this document graph
	 */
	public void basic_setDocumentGraph(SDocumentGraph documentGraph) {
		SFeature sFeature = getFeature(SaltUtil.FEAT_SDOCUMENT_GRAPH_QNAME);
		if (sFeature == null) {
			// create a new sFeature
			sFeature = SaltFactory.createSFeature();
			sFeature.setNamespace(SaltUtil.SALT_NAMESPACE);
			sFeature.setName(SaltUtil.FEAT_SDOCUMENT_GRAPH);
			addFeature(sFeature);
		}
		sFeature.setValue(documentGraph);
		if (getId() != null && !getId().isEmpty()) {
			SaltFactory.createIdentifier(documentGraph, getId());
		}
	}

	/**
	 * {@inheritDoc} Creates a new {@link Identifier} and sets it to the
	 * document graph. The identifier has the same id value as this document.
	 **/
	@Override
	public void setId(String id) {
		super.setId(id);
		if (getDocumentGraph() != null && getId() != null && !getId().isEmpty()) {
			SaltFactory.createIdentifier(getDocumentGraph(), getId());
		}
	}

	/**
	 * {@inheritDoc} Creates a new {@link Identifier} and sets it to the
	 * document graph. The identifier has the same id value as this document.
	 **/
	@Override
	public void setIdentifier(Identifier identifier) {
		super.setIdentifier(identifier);
		if (getDocumentGraph() != null && getId() != null && !getId().isEmpty()) {
			SaltFactory.createIdentifier(getDocumentGraph(), getId());
		}
	}

	/** {@inheritDoc} **/
	@Override
	public URI getDocumentGraphLocation() {
		URI retVal = null;
		String name = SaltUtil.FEAT_SDOCUMENT_GRAPH_LOCATION_QNAME;
		SFeature sFeature = getFeature(name);
		if (sFeature != null) {
			Object obj = sFeature.getValue();
			if (obj instanceof URI) {
				retVal = (URI) obj;
			} else {
				retVal = URI.createURI(obj.toString());
			}
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public void setDocumentGraphLocation(URI location) {
		String name = SaltUtil.FEAT_SDOCUMENT_GRAPH_LOCATION_QNAME;
		SFeature sFeature = getFeature(name);
		if (sFeature == null) {
			// create a new sFeature
			sFeature = SaltFactory.createSFeature();
			sFeature.setNamespace(SaltUtil.SALT_NAMESPACE);
			sFeature.setName(SaltUtil.FEAT_SDOCUMENT_GRAPH_LOCATION);
			sFeature.setValue(location);
			addFeature(sFeature);
		}
		sFeature.setValue(location.toString());
	}

	/** {@inheritDoc} **/
	@Override
	public void saveDocumentGraph(URI documentGraphLocation) {
		SaltUtil.saveDocumentGraph(getDocumentGraph(), documentGraphLocation);
		setDocumentGraph(null);
		setDocumentGraphLocation(documentGraphLocation);
	}

	/** {@inheritDoc} **/
	@Override
	public void loadDocumentGraph() {
		loadDocumentGraph(getDocumentGraphLocation());
	}

	/** {@inheritDoc} **/
	@Override
	public void loadDocumentGraph(URI documentGraphLocation) {
		SDocumentGraph sDocumentGraph = SaltUtil.loadDocumentGraph(documentGraphLocation);
		setDocumentGraph(sDocumentGraph);
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(getClass().getSimpleName());
		str.append("(");
		str.append(getId());
		str.append(")");
		return (str.toString());
	}

	@Override
	public SCorpusGraph getGraph() {
		SGraph superGraph = super.getGraph();

		if (superGraph == null) {
			return null;
		}

		if (superGraph instanceof SCorpusGraph) {
			return (SCorpusGraph) superGraph;
		}

		throw new SaltInvalidModelException("Graph implementation is not of type SCorpusGraph (actual type is " + superGraph.getClass().getName() + ")");
	}

} // SDocumentImpl
