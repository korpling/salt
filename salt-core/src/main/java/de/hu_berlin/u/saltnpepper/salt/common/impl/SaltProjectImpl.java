package de.hu_berlin.u.saltnpepper.salt.common.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;

import de.hu_berlin.u.saltnpepper.graph.Identifier;
import de.hu_berlin.u.saltnpepper.salt.common.SCorpusGraph;
import de.hu_berlin.u.saltnpepper.salt.common.SaltProject;

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
		// TODO Auto-generated method stub

	}

	@Override
	public void loadSaltProject(URI saltProjectURI) {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadCorpusStructure(URI saltProjectURI) {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<Identifier, URI> getDocumentGraphLocations() {
		// TODO Auto-generated method stub
		return null;
	}

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
}
