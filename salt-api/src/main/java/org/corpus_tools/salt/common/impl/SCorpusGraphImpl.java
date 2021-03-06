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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SCorpus;
import org.corpus_tools.salt.common.SCorpusDocumentRelation;
import org.corpus_tools.salt.common.SCorpusGraph;
import org.corpus_tools.salt.common.SCorpusRelation;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.common.SaltProject;
import org.corpus_tools.salt.core.SGraph;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.core.impl.SGraphImpl;
import org.corpus_tools.salt.exceptions.SaltInsertionException;
import org.corpus_tools.salt.exceptions.SaltParameterException;
import org.corpus_tools.salt.graph.Graph;
import org.corpus_tools.salt.graph.GraphFactory;
import org.corpus_tools.salt.graph.Identifier;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.graph.Relation;
import org.corpus_tools.salt.util.SaltUtil;
import org.eclipse.emf.common.util.URI;

import com.google.common.base.Strings;

@SuppressWarnings("serial")
public class SCorpusGraphImpl extends SGraphImpl implements SCorpusGraph {
	/** Initializes an object of type {@link SGraphImpl}. **/
	public SCorpusGraphImpl() {
	}

	/**
	 * Initializes an object of type {@link SGraphImpl}. If {@link #delegate} is not
	 * null, all functions of this method are delegated to the delegate object.
	 * Setting {@link #delegate} makes this object to a container.
	 * 
	 * @param a delegate object of the same type.
	 */
	public SCorpusGraphImpl(Graph delegate) {
		super(delegate);
	}

	/**
	 * Calls the init of super class and expands its initialization for adding
	 * {@link SaltUtil#IDX_NODETYPE} of indexes:
	 * <ul>
	 * <li>Initializes index {@link SaltUtil#IDX_NODETYPE}</li>
	 * <li>Initializes index {@link SaltUtil#IDX_RELATIONTYPE}</li>
	 * </ul>
	 */
	@Override
	protected void init() {
		super.init();

		getIndexMgr().createIndex(SaltUtil.IDX_NODETYPE, Class.class, Node.class, expectedNodes / 2, expectedNodes);
		getIndexMgr().createIndex(SaltUtil.IDX_RELATIONTYPE, Class.class, Relation.class, expectedRelations / 2,
				expectedRelations);
	}

	/** Salt-project containing this corpus structure **/
	protected transient SaltProject saltProject = null;

	/** {@inheritDoc} **/
	@Override
	public SaltProject getSaltProject() {
		return (saltProject);
	}

	/** {@inheritDoc} **/
	@Override
	public void setSaltProject(SaltProject saltProject) {
		if (saltProject != null) {
			if (saltProject instanceof SaltProjectImpl) {
				((SaltProjectImpl) saltProject).basic_addCorpusGraph(this);
			}
		} else {
			if (getSaltProject() instanceof SaltProjectImpl) {
				((SaltProjectImpl) getSaltProject()).basic_removeCorpusGraph(this);
			}
		}
		basic_setSaltProject(saltProject);
	}

	/**
	 * This is an internally used method. To implement a double chaining of
	 * {@link SCorpusGraph} and {@link SaltProject} object when an node is inserted
	 * into this graph and to avoid an endless invocation the insertion of an node
	 * is splited into the two methods {@link #setSaltProject(SaltProject)} and
	 * {@link #basic_setSaltProject(SaltProject)}.
	 * 
	 * @param saltProject the Salt project containing the corpus structure
	 */
	public void basic_setSaltProject(SaltProject saltProject) {
		this.saltProject = saltProject;
	}

	private void setRelationIdIfNecessary(Relation<? extends Node, ? extends Node> relation) {
		// start: create a name if none exists
		if (Strings.isNullOrEmpty(((SRelation) relation).getName())) {
			if (relation instanceof SCorpusRelation) {
				((SRelation) relation).setName("corpRel" + (getCorpusRelations().size() + 1));
			} else if (relation instanceof SCorpusDocumentRelation) {
				((SRelation) relation).setName("corpDocRel" + (getCorpusDocumentRelations().size() + 1));
			} else {
				((SRelation) relation).setName("rel" + (getRelations().size() + 1));
			}
		}
		// end: create a name if none exists
		if (Strings.isNullOrEmpty(relation.getId())) {
			((SRelation) relation).setId("salt:/" + ((SRelation) relation).getName());
		}
	}

	// ============================ start: handling relations
	/**
	 * Calls the super method an puts the given relation into a relation type index.
	 * an exception will be thrown.
	 * 
	 * @param relation to add
	 */
	@Override
	protected void basicAddRelation(Relation<? extends Node, ? extends Node> relation) {
		if (!(relation instanceof SRelation)) {
			throw new SaltInsertionException(this, relation,
					"Cannot insert an edge, which is not a SRelation object. ");
		}
		setRelationIdIfNecessary(relation);
		super.basicAddRelation(relation);
	}

	@Override
	public void addRelation(Relation<? extends SNode, ? extends SNode> relation) {
		
		if (getDelegate() != null) {
			// Normally, basicAddRelation() would set the ID, since the delegate does not
			// call it, set the ID here
			setRelationIdIfNecessary(relation);
		}

		super.addRelation(relation);

		// map some implementation types to the matching interfaces
		Class<?> key;
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

	private void setNodeIdIfNecessary(SNode node) {
		// start: create a name if none exists
		if (Strings.isNullOrEmpty(((SNode) node).getName())) {
			if (node instanceof SCorpus) {
				((SNode) node).setName("corp" + (getCorpora().size() + 1));
			} else if (node instanceof SDocument) {
				((SNode) node).setName("doc" + (getDocuments().size() + 1));
			} else {
				((SNode) node).setName("node" + (getDocuments().size() + 1));
			}
		}
		// end: create a name if none exists
		if (Strings.isNullOrEmpty(node.getId())) {
			// id a name if none exists
			((SNode) node).setId("salt:/" + ((SNode) node).getName());
		}
	}

	/**
	 * Calls the super method an puts the given node into a node type index. an
	 * exception will be thrown.
	 * 
	 * @param node to add
	 */
	@Override
	protected void basicAddNode(SNode node) {
		setNodeIdIfNecessary(node);

		super.basicAddNode(node);
	}

	@Override
	public void addNode(SNode node) {
		if (getDelegate() != null) {
			// Normally, basicAddNode() would set the ID, since the delegate does not call
			// it, set the ID here
			setNodeIdIfNecessary(node);
		}
		
		super.addNode(node);

		// map some implementation types to the matching interfaces
		Class<? extends SNode> key;
		if (node instanceof SCorpus) {
			key = SCorpus.class;
		} else if (node instanceof SDocument) {
			key = SDocument.class;
		} else {
			key = node.getClass();
		}
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
		SNode node = getNode(corpusId.getId());
		if (node instanceof SCorpus)
			retVal = (SCorpus) node;
		return retVal;
	}

	/** {@inheritDoc} **/
	@Override
	public SDocument getDocument(Identifier documentId) {
		SDocument retVal = null;
		SNode node = getNode(documentId.getId());
		if (node instanceof SDocument)
			retVal = (SDocument) node;
		return retVal;
	}

	/** {@inheritDoc} **/
	@Override
	public Identifier addSubCorpus(SCorpus superCorpus, SCorpus subCorpus) {
		if (superCorpus == null) {
			throw new SaltParameterException("superCorpus", "addSubCorpus", this.getClass(),
					"Cannot add the given subCorpus, because the given superCorpus is null.");
		}
		if (subCorpus == null) {
			throw new SaltParameterException("subCorpus", "addSubCorpus", this.getClass(),
					"Cannot add the given subCorpus, because it is null.");
		}
		if (superCorpus.getId() == null) {
			throw new SaltInsertionException(this, subCorpus,
					"Cannot add the given subCorpus, because the given superCorpus is not already contained in corpus graph.");
		}
		if (getNode(superCorpus.getId()) == null) {
			throw new SaltInsertionException(this, subCorpus,
					"Cannot add the given subCorpus, because the given superCorpus is not already contained in corpus graph.");
		}

		String namePart = null;
		namePart = subCorpus.getName();
		if (Strings.isNullOrEmpty(namePart)) {
			namePart = "corp_" + getCorpora().size();
		}

		// creates and sets identifier
		GraphFactory.createIdentifier(subCorpus, URI.createURI(superCorpus.getId() + "/" + namePart).toString());

		addNode(subCorpus);
		SCorpusRelation corpRel = SaltFactory.createSCorpusRelation();
		corpRel.setSource(superCorpus);
		corpRel.setTarget(subCorpus);
		addRelation(corpRel);

		return (corpRel.getIdentifier());
	}

	/** {@inheritDoc} **/
	@Override
	public Identifier addDocument(SCorpus corpus, SDocument document) {
		if (corpus == null) {
			throw new SaltParameterException("corpus", "addDocument", this.getClass(),
					"Cannot add the given sDocument, because the given sCorpus is null.");
		}
		if (document == null) {
			throw new SaltParameterException("document", "addDocument", this.getClass(),
					"Cannot add the given sDocument, because it is null.");
		}
		if (getNode(corpus.getId()) == null) {
			throw new SaltInsertionException(this, document,
					"Cannot add the given sDocument, because the given sCorpus is not already contained in corpus graph.");
		}
		String namePart = null;
		namePart = document.getName();
		if (Strings.isNullOrEmpty(namePart)) {
			namePart = "doc_" + getCorpora().size();
		}
		GraphFactory.createIdentifier(document, URI.createURI(corpus.getId() + "/" + namePart).toString());

		addNode(document);
		SCorpusDocumentRelation corpDocRel = SaltFactory.createSCorpusDocumentRelation();
		corpDocRel.setSource(corpus);
		corpDocRel.setTarget(document);
		addRelation(corpDocRel);

		return (corpDocRel.getIdentifier());
	}

	/** {@inheritDoc} **/
	@Override
	public SCorpus getCorpus(SDocument document) {
		SCorpus retVal = null;
		if (document != null) {
			List<SRelation<SNode, SNode>> inRels = getInRelations(document.getId());
			for (SRelation inEdge : Collections.synchronizedCollection(inRels)) {
				if (inEdge instanceof SCorpusDocumentRelation) {

					retVal = ((SCorpusDocumentRelation) inEdge).getSource();
					break;
				}
			}
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public void load(URI corpusGraphUri) {
		SCorpusGraph loaded = SaltUtil.loadCorpusGraph(corpusGraphUri);
		SaltUtil.moveCorpusGraph(loaded, this);
	}

	/** {@inheritDoc} **/
	@Override
	public SCorpus createCorpus(SCorpus superCorpus, String corpusName) {
		SCorpus corpus = SaltFactory.createSCorpus();
		corpus.setName(corpusName);
		if (superCorpus != null) {
			addSubCorpus(superCorpus, corpus);
		} else {
			addNode(corpus);
		}
		return (corpus);
	}

	/** {@inheritDoc} **/
	@Override
	public SDocument createDocument(SCorpus parentCorpus, String documentName) {
		SDocument document = SaltFactory.createSDocument();
		document.setName(documentName);
		addDocument(parentCorpus, document);
		return (document);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SCorpus> createCorpus(final URI corpusPath) {
		final URI cPath = SaltUtil.createSaltURI(corpusPath);
		List<SCorpus> retVal = null;
		if (cPath != null) {
			SCorpus parentCorpus = null;
			for (int i = cPath.segments().length - 1; i >= 0; i--) {
				final URI currPath = cPath.trimSegments(i);
				String id = currPath.toString();
				final SNode node = getNode(id);
				if (node == null) {
					parentCorpus = createCorpus(parentCorpus, currPath.lastSegment());
					if (retVal == null) {
						retVal = new ArrayList<SCorpus>();
					}
					retVal.add(parentCorpus);
				} else {
					parentCorpus = (SCorpus) node;
				}
			}
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public SDocument createDocument(final URI documentPath) {
		final URI dPath = SaltUtil.createSaltURI(documentPath);
		SDocument retVal = null;
		List<SCorpus> corpora = createCorpus(dPath.trimSegments(1));
		if ((corpora == null) || (corpora.size() == 0)) {
			corpora = new ArrayList<SCorpus>();
			String id = dPath.trimSegments(1).toString();
			corpora.add((SCorpus) getNode(id));
		}
		retVal = createDocument(corpora.get(corpora.size() - 1), dPath.lastSegment());
		return (retVal);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toTreeString() {
		final List<SNode> roots = getRoots();
		final StringBuilder str = new StringBuilder();
		if (SaltUtil.isNotNullOrEmpty(roots)) {
			for (SNode root : roots) {
				str.append(reportCorpusStructure(this, root, "", true));
			}
		}
		return str.toString();
	}

	/**
	 * Returns the corpus structure as an ascii tree.
	 * 
	 * @param sGraph the corpus structure to be printed
	 * @param node   root node to start from
	 * @param prefix
	 * @param isTail
	 * @return
	 */
	private String reportCorpusStructure(final SGraph sGraph, final SNode node, final String prefix,
			final boolean isTail) {
		final StringBuilder retStr = new StringBuilder();
		retStr.append(prefix);
		retStr.append(((isTail ? "└── " : "├── ") + node.getName()));
		retStr.append("\n");
		final List<SRelation<SNode, SNode>> outRelations = sGraph.getOutRelations(node.getId());
		int i = 0;
		for (SRelation<SNode, SNode> out : outRelations) {
			boolean newTail = true;
			if (i < outRelations.size() - 1) {
				newTail = false;
			}
			retStr.append(reportCorpusStructure(sGraph, (SNode) out.getTarget(), prefix + (isTail ? "    " : "│   "),
					newTail));
			i++;
		}
		return (retStr.toString());
	}
} // SCorpusGraphImpl