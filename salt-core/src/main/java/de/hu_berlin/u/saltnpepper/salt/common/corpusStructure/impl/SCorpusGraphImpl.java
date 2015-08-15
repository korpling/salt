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
package de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.impl;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import de.hu_berlin.u.saltnpepper.graph.Identifier;
import de.hu_berlin.u.saltnpepper.graph.Relation;
import de.hu_berlin.u.saltnpepper.salt.common.SaltProject;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpus;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusDocumentRelation;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusGraph;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusRelation;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SDocument;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SGraphImpl;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltException;
import de.hu_berlin.u.saltnpepper.salt.util.SaltUtil;

@SuppressWarnings("serial")
public class SCorpusGraphImpl extends SGraphImpl implements SCorpusGraph {

	/** Salt-project containing this corpus structure **/
	protected SaltProject saltProject = null;

	/** {@inheritDoc} **/
	@Override
	public SaltProject getSaltProject() {
		return (saltProject);
	}

	/** {@inheritDoc} **/
	@Override
	public void setSaltProject(SaltProject saltProject) {
		this.saltProject = saltProject;
	}

	
	// ============================ start: handling specific nodes

	/** {@inheritDoc} **/
	@Override
	public List<SCorpus> getCorpora() {
		return(getIndexMgr().getAll(SaltUtil.IDX_NODETYPE, SCorpus.class));
	}

	/** {@inheritDoc} **/
	@Override
	public List<SDocument> getDocuments() {
		return(getIndexMgr().getAll(SaltUtil.IDX_NODETYPE, SDocument.class));
	}

	// ============================ end: handling specific nodes
	// ============================ start: handling specific relations
	/** {@inheritDoc} **/
	@Override
	public List<SCorpusRelation> getCorpusRelations() {
		return(getIndexMgr().getAll(SaltUtil.IDX_RELATIONTYPE, SCorpusRelation.class));
	}

	/** {@inheritDoc} **/
	@Override
	public List<SCorpusDocumentRelation> getCorpusDocumentRelations() {
		return(getIndexMgr().getAll(SaltUtil.IDX_RELATIONTYPE, SCorpusDocumentRelation.class));
	}

	// ============================ end: handling specific relations

	@Override
	public SCorpus getCorpus(Identifier corpusId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SCorpus getDocuemnt(Identifier documentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Identifier addSSubCorpus(SCorpus superCorpus, SCorpus subCorpus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Identifier addSDocument(SCorpus corpus, SDocument document) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SCorpus getCorpus(SDocument document) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void load(URI corpusGraphUri) {
		// TODO Auto-generated method stub

	}

	@Override
	public SCorpus createSCorpus(SCorpus superCorpus, String corpusName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SDocument createSDocument(SCorpus parentCorpus, String documentName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SCorpus> createSCorpus(URI corpusPath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SDocument createSDocument(URI documentPath) {
		// TODO Auto-generated method stub
		return null;
	}

} // SCorpusGraphImpl
