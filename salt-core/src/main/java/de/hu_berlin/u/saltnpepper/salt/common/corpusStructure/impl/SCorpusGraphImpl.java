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

import org.eclipse.emf.common.util.URI;

import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SElementId;
import de.hu_berlin.u.saltnpepper.graph.Identifier;
import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.graph.Relation;
import de.hu_berlin.u.saltnpepper.salt.common.SaltProject;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpus;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusDocumentRelation;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusGraph;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusRelation;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SDocument;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SGraphImpl;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltException;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltInsertionException;
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

	// ============================ start: handling relations
	/**
	 * Calls the super method an puts the given relation into a relation type
	 * index. an exception will be thrown.
	 * 
	 * @param relation
	 *            to add
	 */
	@Override
	protected void basicAddRelation(Relation<? extends Node, ? extends Node> relation) {
		if (!(relation instanceof SRelation)) {
			throw new SaltInsertionException(this, relation, "Cannot insert an edge, which is not a SRelation object. ");
		}
		// start: create a name if none exists
		if ((((SRelation) relation).getName() == null) || (((SRelation) relation).getName().isEmpty())) {
			if (relation instanceof SCorpusRelation)
				((SRelation) relation).setName("corpRel" + (this.getCorpusRelations().size() + 1));
			else if (relation instanceof SCorpusDocumentRelation)
				((SRelation) relation).setName("corpDocRel" + (this.getCorpusDocumentRelations().size() + 1));
			else
				((SRelation) relation).setName("rel" + (this.getRelations().size() + 1));
		}
		// end: create a name if none exists
		if ((((SRelation) relation).getId() == null) || (((SRelation) relation).getId().isEmpty())) {
			((SRelation) relation).setId("salt:/" + ((SRelation) relation).getName());
		}
		super.basicAddRelation(relation);

		// map some implementation types to the matching interfaces
		Class key;
		if (relation instanceof SCorpusRelation) {
			key = SCorpusRelation.class;
		} else if (relation instanceof SCorpusDocumentRelation) {
			key = SCorpusDocumentRelation.class;
		} else {
			key = relation.getClass();
		}
		getIndexMgr().put(SaltUtil.IDX_RELATIONTYPE, key, relation);
	}

	// ============================ end: handling relations
	// ============================ start: handling nodes

	/**
	 * Calls the super method an puts the given node into a node type index. an
	 * exception will be thrown.
	 * 
	 * @param node
	 *            to add
	 */
	@Override
	protected void basicAddNode(SNode node) {
		if (!(node instanceof SNode)) {
			throw new SaltException("Cannot insert a node, which is not a SNode object: " + node);
		}
		// start: create a name if none exists
		if ((((SNode) node).getName() == null) || (((SNode) node).getName().isEmpty())) {
			if (node instanceof SCorpus)
				((SNode) node).setName("corp" + (this.getCorpora().size() + 1));
			else if (node instanceof SDocument)
				((SNode) node).setName("doc" + (this.getDocuments().size() + 1));
			else
				((SNode) node).setName("node" + (this.getDocuments().size() + 1));
		}
		// end: create a name if none exists
		if ((((SNode) node).getId() == null) || (((SNode) node).getId().isEmpty())) {
			// id a name if none exists
			((SNode) node).setId("salt:/" + ((SNode) node).getName());
		}// id a name if none exists

		super.basicAddNode(node);

		// map some implementation types to the matching interfaces
		Class key;
		if (node instanceof SCorpus)
			key = SCorpus.class;
		else if (node instanceof SDocument)
			key = SDocument.class;
		else
			key = node.getClass();

		// end: compute slot id
		getIndexMgr().put(SaltUtil.IDX_NODETYPE, key, node);
	}

	// ============================ end: handling nodes

	// ============================ start: handling specific nodes

	/** {@inheritDoc} **/
	@Override
	public List<SCorpus> getCorpora() {
		return (getIndexMgr().getAll(SaltUtil.IDX_NODETYPE, SCorpus.class));
	}

	/** {@inheritDoc} **/
	@Override
	public List<SDocument> getDocuments() {
		return (getIndexMgr().getAll(SaltUtil.IDX_NODETYPE, SDocument.class));
	}

	// ============================ end: handling specific nodes
	// ============================ start: handling specific relations
	/** {@inheritDoc} **/
	@Override
	public List<SCorpusRelation> getCorpusRelations() {
		return (getIndexMgr().getAll(SaltUtil.IDX_RELATIONTYPE, SCorpusRelation.class));
	}

	/** {@inheritDoc} **/
	@Override
	public List<SCorpusDocumentRelation> getCorpusDocumentRelations() {
		return (getIndexMgr().getAll(SaltUtil.IDX_RELATIONTYPE, SCorpusDocumentRelation.class));
	}

	// ============================ end: handling specific relations
	/** {@inheritDoc} **/
	@Override
	public SCorpus getCorpus(Identifier corpusId) {
		SCorpus retVal = null;
		SNode sNode = this.getNode(corpusId.getId());
		if (sNode instanceof SCorpus)
			retVal = (SCorpus) sNode;
		return retVal;
	}

	/** {@inheritDoc} **/
	@Override
	public SDocument getDocument(Identifier documentId){
		SDocument retVal = null;
		SNode sNode = this.getNode(documentId.getId());
		if (sNode instanceof SDocument)
			retVal = (SDocument) sNode;
		return retVal;
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
