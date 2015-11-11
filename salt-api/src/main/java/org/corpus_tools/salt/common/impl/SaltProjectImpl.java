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

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SCorpusGraph;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.common.SaltProject;
import org.corpus_tools.salt.exceptions.SaltResourceException;
import org.corpus_tools.salt.util.SaltUtil;
import org.eclipse.emf.common.util.URI;

public class SaltProjectImpl implements SaltProject {

	public SaltProjectImpl() {
		corpusGraphs = new ArrayList<SCorpusGraph>();
	}

	/** list of all {@link SCorpusGraph} objects contained in this Salt project **/
	private List<SCorpusGraph> corpusGraphs = null;

	/** {@inheritDoc} **/
	@Override
	public List<SCorpusGraph> getCorpusGraphs() {
		return (Collections.unmodifiableList(corpusGraphs));
	}

	/** {@inheritDoc} **/
	@Override
	public void addCorpusGraph(SCorpusGraph corpusGraph) {
		if (corpusGraph != null) {
			if (corpusGraph instanceof SCorpusGraphImpl) {
				((SCorpusGraphImpl) corpusGraph).basic_setSaltProject(this);
			}
		}
		basic_addCorpusGraph(corpusGraph);
	}

	/**
	 * Adds the corpus graph to the internal list of corpus graphs.
	 * 
	 * @param corpusGraph
	 *            to add
	 */
	public void basic_addCorpusGraph(SCorpusGraph corpusGraph) {
		if (corpusGraph != null) {
			corpusGraphs.add(corpusGraph);
		}
	}

	@Override
	public void removeCorpusGraph(SCorpusGraph corpusGraph) {
		if (corpusGraph != null) {
			if (corpusGraph instanceof SCorpusGraphImpl) {
				((SCorpusGraphImpl) corpusGraph).basic_setSaltProject(null);
			}
		}
		basic_removeCorpusGraph(corpusGraph);
	}

	/**
	 * Removes the corpus graph to the internal list of corpus graphs.
	 * 
	 * @param corpusGraph
	 *            graph to remove
	 */
	public void basic_removeCorpusGraph(SCorpusGraph corpusGraph) {
		if (corpusGraph != null) {
			corpusGraphs.remove(corpusGraph);
		}
	}

	/** Name of the Salt project. **/
	private String name = null;

	/** {@inheritDoc} **/
	@Override
	public String getName() {
		return name;
	}

	/** {@inheritDoc} **/
	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void saveSaltProject(URI saltProjectURI) {
		SaltUtil.saveSaltProject(this, saltProjectURI);
	}

	@Override
	public void loadSaltProject(URI saltProjectURI) {
		if (saltProjectURI == null)
			throw new SaltResourceException("Cannot load salt project, because the paassed uri is null.");
		this.loadCorpusStructure(saltProjectURI);
		for (SCorpusGraph sCorpusGraph : this.getCorpusGraphs()) {
			for (SDocument sDoc : sCorpusGraph.getDocuments()) {
				try {
					sDoc.loadDocumentGraph();
				} catch (SaltResourceException e) {
					throw new SaltResourceException("A problem occured when loading salt project from '" + saltProjectURI + "', because one of its documents could not have been load '" + sDoc.getId() + "'.", e);
				} catch (Exception e) {
					throw new SaltResourceException("A problem occured when loading salt project from '" + saltProjectURI + "', because of a nested exception during loading one of its documents '" + sDoc.getId() + "'.", e);
				}
			}
		}

	}

	@Override
	public void loadCorpusStructure(URI saltProjectURI) {
		// remove the old ones if they exist
		List<SCorpusGraph> corpusGraphList = getCorpusGraphs();
		if (corpusGraphList != null) {
			for (SCorpusGraph corpusGraph : new LinkedList<>(corpusGraphList)) {
				removeCorpusGraph(corpusGraph);
			}
		}
		// do the actual work with the SaltUtil
		SaltProject loadedProject = SaltUtil.loadSaltProject(saltProjectURI);

		// copy name
		setName(loadedProject.getName());

		// copy the loaded corpus graphs
		for (SCorpusGraph corpusGraph : new LinkedList<>(loadedProject.getCorpusGraphs())) {
			addCorpusGraph(corpusGraph);
		}

	}

	/** {@inheritDoc} **/
	@Override
	public String toString() {
		StringBuilder retStr = new StringBuilder();
		retStr.append("SaltProject(");
		retStr.append(getName());
		retStr.append(")");
		retStr.append(": ");
		retStr.append(getCorpusGraphs().size());
		retStr.append("corpus graphs");
		return (retStr.toString());
	}

	/** {@inheritDoc} **/
	@Override
	public SCorpusGraph createCorpusGraph() {
		SCorpusGraph corpGraph = SaltFactory.createSCorpusGraph();
		addCorpusGraph(corpGraph);
		return (corpGraph);
	}
}
