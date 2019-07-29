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
/**
 * 
 */
package org.corpus_tools.salt.extensions.notification.common.impl;

import java.util.Collection;
import java.util.List;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SCorpus;
import org.corpus_tools.salt.common.SCorpusGraph;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.common.SaltProject;
import org.corpus_tools.salt.common.impl.SCorpusGraphImpl;
import org.corpus_tools.salt.extensions.notification.Listener;
import org.corpus_tools.salt.extensions.notification.Listener.NOTIFICATION_TYPE;
import org.corpus_tools.salt.extensions.notification.graph.Notifier;
import org.corpus_tools.salt.extensions.notification.graph.impl.NotifierHelper;
import org.corpus_tools.salt.graph.GRAPH_ATTRIBUTES;
import org.corpus_tools.salt.graph.Identifier;
import org.eclipse.emf.common.util.URI;

/**
 * // TODO Add description
 *
 * @author Stephan Druskat <[mail@sdruskat.net](mailto:mail@sdruskat.net)>
 * 
 */
@SuppressWarnings("serial")
public class CorpusGraphNotifierImpl extends SCorpusGraphImpl implements SCorpusGraph, Notifier {

	protected List<Listener> listenerList = null;

	/** {@inheritDoc} **/
	@Override
	public List<Listener> getListener() {
		return (NotifierHelper.getListener(listenerList));
	}

	/** {@inheritDoc} **/
	@Override
	public synchronized void addListener(Listener listener) {
		listenerList = NotifierHelper.addListener(listenerList, listener);
	}

	/** {@inheritDoc} **/
	@Override
	public void addListener(Collection<Listener> listener) {
		listenerList = NotifierHelper.addListener(listenerList, listener);
	}

	/** {@inheritDoc} **/
	@Override
	public synchronized void removeListener(Listener listener) {
		listenerList = NotifierHelper.removeListener(listenerList, listener);
	}

	/** {@inheritDoc} **/
	@Override
	public void setSaltProject(SaltProject saltProject) {
		SaltProject oldSaltProject = getSaltProject();
		super.setSaltProject(saltProject);
		NotifierHelper.notify(listenerList, Listener.NOTIFICATION_TYPE.SET, GRAPH_ATTRIBUTES.GRAPH_NODES, oldSaltProject,
				saltProject, this);
	}
	
	/** {@inheritDoc} **/
	@Override
	public Identifier addSubCorpus(SCorpus superCorpus, SCorpus subCorpus) {
		Identifier newIdentifier = super.addSubCorpus(superCorpus, subCorpus);
		NotifierHelper.notify(listenerList, NOTIFICATION_TYPE.ADD, GRAPH_ATTRIBUTES.GRAPH_NODES, null, subCorpus, this);
		return newIdentifier;
	}
	
	/** {@inheritDoc} **/
	@Override
	public Identifier addDocument(SCorpus corpus, SDocument document) {
		Identifier newIdentifier = super.addDocument(corpus, document);
		NotifierHelper.notify(listenerList, NOTIFICATION_TYPE.ADD, GRAPH_ATTRIBUTES.GRAPH_NODES, null, document, this);
		return newIdentifier;
	}
	
	/** {@inheritDoc} **/
	@Override
	public SCorpus createCorpus(SCorpus superCorpus, String corpusName) {
		SCorpus newCorpus = super.createCorpus(superCorpus, corpusName);
		NotifierHelper.notify(listenerList, NOTIFICATION_TYPE.ADD, GRAPH_ATTRIBUTES.GRAPH_NODES, null, newCorpus, this);
		return newCorpus;
	}
	
	/** {@inheritDoc} **/
	@Override
	public SDocument createDocument(SCorpus parentCorpus, String documentName) {
		SDocument newDocument = super.createDocument(parentCorpus, documentName);
		NotifierHelper.notify(listenerList, NOTIFICATION_TYPE.ADD, GRAPH_ATTRIBUTES.GRAPH_NODES, null, newDocument, this);
		return newDocument;
	}
	
	/** {@inheritDoc} **/
	@Override
	public List<SCorpus> createCorpus(final URI corpusPath) {
		List<SCorpus> oldCorporaList = getCorpora();
		List<SCorpus> corporaList = super.createCorpus(corpusPath);
		NotifierHelper.notify(listenerList, NOTIFICATION_TYPE.ADD, GRAPH_ATTRIBUTES.GRAPH_NODES, oldCorporaList, corporaList, this);
		return corporaList;
	}
	
	/** {@inheritDoc} **/
	@Override
	public SDocument createDocument(final URI documentPath) {
		SDocument newDocument = super.createDocument(documentPath);
		NotifierHelper.notify(listenerList, NOTIFICATION_TYPE.ADD, GRAPH_ATTRIBUTES.GRAPH_NODES, null, newDocument, this);
		return newDocument;
	}
}
