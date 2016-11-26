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
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.corpus_tools.salt.SALT_TYPE;
import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.common.SDominanceRelation;
import org.corpus_tools.salt.common.SMedialDS;
import org.corpus_tools.salt.common.SMedialRelation;
import org.corpus_tools.salt.common.SOrderRelation;
import org.corpus_tools.salt.common.SPointingRelation;
import org.corpus_tools.salt.common.SSequentialDS;
import org.corpus_tools.salt.common.SSequentialRelation;
import org.corpus_tools.salt.common.SSpan;
import org.corpus_tools.salt.common.SSpanningRelation;
import org.corpus_tools.salt.common.SStructure;
import org.corpus_tools.salt.common.SStructuredNode;
import org.corpus_tools.salt.common.STextualDS;
import org.corpus_tools.salt.common.STextualRelation;
import org.corpus_tools.salt.common.STimeline;
import org.corpus_tools.salt.common.STimelineRelation;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.common.tokenizer.Tokenizer;
import org.corpus_tools.salt.core.SFeature;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.core.impl.SGraphImpl;
import org.corpus_tools.salt.exceptions.SaltElementNotInGraphException;
import org.corpus_tools.salt.exceptions.SaltInsertionException;
import org.corpus_tools.salt.exceptions.SaltParameterException;
import org.corpus_tools.salt.graph.Graph;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.graph.Relation;
import org.corpus_tools.salt.util.DataSourceSequence;
import org.corpus_tools.salt.util.DiffOptions;
import org.corpus_tools.salt.util.Difference;
import org.corpus_tools.salt.util.SaltUtil;
import org.corpus_tools.salt.util.internal.DataSourceAccessor;
import org.corpus_tools.salt.util.internal.Diff;
import org.corpus_tools.salt.util.internal.GetXBySequence;

import com.google.common.base.Strings;
import com.google.common.collect.Multimap;

@SuppressWarnings("serial")
public class SDocumentGraphImpl extends SGraphImpl implements SDocumentGraph {
	/** Initializes an object of type {@link SDocumentGraphImpl}. **/
	public SDocumentGraphImpl() {
		super();
	}

	/**
	 * Initializes an object of type {@link SDocumentGraphImpl}. If
	 * {@link #delegate} is not null, all functions of this method are delegated
	 * to the delegate object. Setting {@link #delegate} makes this object to a
	 * container.
	 * 
	 * @param a
	 *            delegate object of the same type.
	 */
	public SDocumentGraphImpl(Graph delegate) {
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

	// ============================ start: handling relations

	@Override
	public void addRelation(Relation<? extends SNode, ? extends SNode> relation) {
		if (relation != null) {
			if (!(relation instanceof SRelation)) {
				throw new SaltInsertionException(this, relation,
						"Cannot insert an relation, which is not a SRelation object.");
			}
			// start: create a name if none exists
			if (Strings.isNullOrEmpty(((SRelation) relation).getName())) {
				if (relation instanceof STextualRelation) {
					((SRelation) relation).setName("sTextRel" + (getTextualRelations().size() + 1));
				} else if (relation instanceof STimelineRelation) {
					((SRelation) relation).setName("sTimeRel" + (getTimelineRelations().size() + 1));
				} else if (relation instanceof SSpanningRelation) {
					((SRelation) relation).setName("sSpanRel" + (getSpanningRelations().size() + 1));
				} else if (relation instanceof SPointingRelation) {
					((SRelation) relation).setName("sPointingRel" + (getPointingRelations().size() + 1));
				} else if (relation instanceof SDominanceRelation) {
					((SRelation) relation).setName("sDomRel" + (getDominanceRelations().size() + 1));
				} else if (relation instanceof SMedialRelation) {
					((SRelation) relation).setName("sAudioRel" + (getMedialRelations().size() + 1));
				} else if (relation instanceof SOrderRelation) {
					((SRelation) relation).setName("sOrderRel" + (getOrderRelations().size() + 1));
				} else {
					((SRelation) relation).setName("sRel" + (getRelations().size() + 1));
				}
			}
			// end: create a name if none exists
			((SRelation) relation).setId(getId() + "#" + ((SRelation) relation).getName());
			super.addRelation(relation);

			Class<?> key;
			// map some implementation types to the matching interfaces
			if (relation instanceof STextualRelation) {
				key = STextualRelation.class;
			} else if (relation instanceof STimelineRelation) {
				key = STimelineRelation.class;
			} else if (relation instanceof SSpanningRelation) {
				key = SSpanningRelation.class;
			} else if (relation instanceof SPointingRelation) {
				key = SPointingRelation.class;
			} else if (relation instanceof SDominanceRelation) {
				key = SDominanceRelation.class;
			} else if (relation instanceof SMedialRelation) {
				key = SMedialRelation.class;
			} else if (relation instanceof SOrderRelation) {
				key = SOrderRelation.class;
			} else {
				key = relation.getClass();
			}

			getIndexMgr().put(SaltUtil.IDX_RELATIONTYPE, key, relation);
		}
	}

	// ============================ end: handling relations
	// ============================ start: handling nodes
	@Override
	public void addNode(SNode node) {
		// check if node already exists
		if (getIndexMgr().containsKey(SaltUtil.IDX_ID_NODES_INVERSE, node)) {
			// do nothing, node is already added
			return;
		}
		if (node != null) {
			// start: create a name if none exists
			if (Strings.isNullOrEmpty(node.getName())) {
				if (node instanceof STextualDS) {
					node.setName("sText" + (getTextualDSs().size() + 1));
				} else if (node instanceof SToken) {
					node.setName("sTok" + (getTokens().size() + 1));
				} else if (node instanceof STimeline) {
					node.setName("sTimeline" + (getTokens().size() + 1));
				} else if (node instanceof SSpan) {
					node.setName("sSpan" + (getSpans().size() + 1));
				} else if (node instanceof SStructure) {
					node.setName("structure" + (getStructures().size() + 1));
				} else if (node instanceof SMedialDS) {
					node.setName("audio" + (getMedialDSs().size() + 1));
				} else {
					node.setName("sNode" + (getNodes().size() + 1));
				}
			}
			// end: create a name if none exists
			if (Strings.isNullOrEmpty(node.getId())) {
				node.setId(getId() + "#" + node.getName());
			}
			super.addNode(node);

			// map some implementation types to the matching interfaces
			Class<?> key;
			if (node instanceof SToken) {
				key = SToken.class;
			} else if (node instanceof STextualDS) {
				key = STextualDS.class;
			} else if (node instanceof STimeline) {
				key = STimeline.class;
			} else if (node instanceof SSpan) {
				key = SSpan.class;
			} else if (node instanceof SStructure) {
				key = SStructure.class;
			} else if (node instanceof SMedialDS) {
				key = SMedialDS.class;
			} else {
				key = node.getClass();
			}
			getIndexMgr().put(SaltUtil.IDX_NODETYPE, key, node);
		}
	}

	/** {@inheritDoc} **/
	@Override
	public SDocument getDocument() {
		SDocument retVal = null;
		SFeature sFeature = getFeature(SaltUtil.FEAT_SDOCUMENT_QNAME);
		if (sFeature != null) {
			retVal = (SDocument) sFeature.getValue();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public void setDocument(SDocument document) {
		SDocument oldDocument = getDocument();
		if ((oldDocument != null) && (oldDocument != document)) {
			if (oldDocument instanceof SDocumentImpl) {
				((SDocumentImpl) oldDocument).basic_setDocumentGraph(null);
			}
		}
		if (document != null) {
			if (document instanceof SDocumentImpl) {
				((SDocumentImpl) document).basic_setDocumentGraph(this);
			}
		}
		basic_setDocument(document);
	}

	/**
	 * This is an internally used method. To implement a double chaining of
	 * {@link SDocument} and {@link SDocumentGraph} object when a document is
	 * set to avoid an endless invocation. The invocation of methods is
	 * implement as follows:
	 * 
	 * <pre>
	 * {@link #setDocument(SDocument)}                      {@link SDocument#setDocumentGraph(Graph)}
	 *         ||             \ /                   ||
	 *         ||              X                    ||
	 *         \/             / \                   \/
	 * {@link #basicDocument(SDocument)}            {@link SDocument#basicSetDocumentGraph(Graph)}
	 * </pre>
	 * 
	 * @param document
	 *            the container document of this document graph
	 */
	public void basic_setDocument(SDocument document) {
		SFeature sFeature = getFeature(SaltUtil.FEAT_SDOCUMENT_QNAME);
		if (sFeature == null) {
			// create a new sFeature
			sFeature = SaltFactory.createSFeature();
			sFeature.setNamespace(SaltUtil.SALT_NAMESPACE);
			sFeature.setName(SaltUtil.FEAT_SDOCUMENT);
			addFeature(sFeature);
		}
		sFeature.setValue(document);
	}

	/** {@inheritDoc} **/
	@Override
	public List<STextualDS> getTextualDSs() {
		List<STextualDS> retVal = getIndexMgr().getAll(SaltUtil.IDX_NODETYPE, STextualDS.class);
		if (retVal == null) {
			retVal = new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SRelation> getRelations(SALT_TYPE type) {
		List<SRelation> relations = null;
		relations = getRelations(type.getJavaType());
		return (relations);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SRelation> getRelations(Class<?> clazz) {
		List<SRelation> relations = null;
		relations = getIndexMgr().getAll(SaltUtil.IDX_RELATIONTYPE, clazz);
		return (relations);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SNode> getNodes(SALT_TYPE type) {
		List<SNode> nodes = null;
		nodes = getNodes(type.getJavaType());
		return (nodes);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SNode> getNodes(Class<?> clazz) {
		List<SNode> nodes = null;
		nodes = getIndexMgr().getAll(SaltUtil.IDX_NODETYPE, clazz);
		return (nodes);
	}

	/** {@inheritDoc} **/
	@Override
	public List<STextualRelation> getTextualRelations() {
		List<STextualRelation> retVal = getIndexMgr().getAll(SaltUtil.IDX_RELATIONTYPE, STextualRelation.class);
		if (retVal == null) {
			retVal = new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SToken> getTokens() {
		List<SToken> retVal = getIndexMgr().getAll(SaltUtil.IDX_NODETYPE, SToken.class);
		if (retVal == null) {
			retVal = new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public STimeline getTimeline() {
		return (getIndexMgr().get(SaltUtil.IDX_NODETYPE, STimeline.class));
	}

	/** {@inheritDoc} **/
	@Override
	public void setTimeline(STimeline value) {
		addNode(value);
	}

	/** {@inheritDoc} **/
	@Override
	public List<STimelineRelation> getTimelineRelations() {
		List<STimelineRelation> retVal = getIndexMgr().getAll(SaltUtil.IDX_RELATIONTYPE, STimelineRelation.class);
		if (retVal == null) {
			retVal = new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SSpanningRelation> getSpanningRelations() {
		List<SSpanningRelation> retVal = getIndexMgr().getAll(SaltUtil.IDX_RELATIONTYPE, SSpanningRelation.class);
		if (retVal == null) {
			retVal = new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SSpan> getSpans() {
		List<SSpan> retVal = getIndexMgr().getAll(SaltUtil.IDX_NODETYPE, SSpan.class);
		if (retVal == null) {
			retVal = new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SStructure> getStructures() {
		List<SStructure> retVal = getIndexMgr().getAll(SaltUtil.IDX_NODETYPE, SStructure.class);
		if (retVal == null) {
			retVal = new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SDominanceRelation> getDominanceRelations() {
		List<SDominanceRelation> retVal = getIndexMgr().getAll(SaltUtil.IDX_RELATIONTYPE, SDominanceRelation.class);
		if (retVal == null) {
			retVal = new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SPointingRelation> getPointingRelations() {
		List<SPointingRelation> retVal = getIndexMgr().getAll(SaltUtil.IDX_RELATIONTYPE, SPointingRelation.class);
		if (retVal == null) {
			retVal = new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SMedialRelation> getMedialRelations() {
		List<SMedialRelation> retVal = getIndexMgr().getAll(SaltUtil.IDX_RELATIONTYPE, SMedialRelation.class);
		if (retVal == null) {
			retVal = new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SMedialDS> getMedialDSs() {
		List<SMedialDS> retVal = getIndexMgr().getAll(SaltUtil.IDX_NODETYPE, SMedialDS.class);
		if (retVal == null) {
			retVal = new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SOrderRelation> getOrderRelations() {
		List<SOrderRelation> retVal = getIndexMgr().getAll(SaltUtil.IDX_RELATIONTYPE, SOrderRelation.class);
		if (retVal == null) {
			retVal = new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public SRelation addNode(SNode source, SNode target, SALT_TYPE sRelationType) {
		if (!getNodes().contains(source)) {
			throw new SaltElementNotInGraphException(this, source,
					"Given SNode cannot be used as source node, because it is not contained in the SDocumentGraph");
		}
		SRelation retVal = null;
		switch (sRelationType) {
		case STEXTUAL_RELATION:
			retVal = SaltFactory.createSTextualRelation();
			break;
		case SPOINTING_RELATION:
			retVal = SaltFactory.createSPointingRelation();
			break;
		case SSPANNING_RELATION:
			retVal = SaltFactory.createSSpanningRelation();
			break;
		case SDOMINANCE_RELATION:
			retVal = SaltFactory.createSDominanceRelation();
			break;
		default:
			break;
		}
		if (retVal == null) {
			throw new SaltParameterException(
					"Improper STYPE_NAME for this method; must be one of STEXTUAL_RELATION, SPOINTING_RELATION, SSPANNING_RELATION and SDOMINANCE_RELATION.");
		}
		retVal.setSource(source);
		retVal.setTarget(target);
		if (!getNodes().contains(target)) {
			addNode(target);
		}
		addRelation(retVal);
		return retVal;
	}

	/** {@inheritDoc} **/
	@Override
	public STextualDS createTextualDS(String text) {
		STextualDS sTextualDS = SaltFactory.createSTextualDS();
		sTextualDS.setText(text);
		addNode(sTextualDS);
		return (sTextualDS);
	}

	/** {@inheritDoc} **/
	@Override
	public SToken createToken(List<DataSourceSequence> sequences) {
		if (sequences == null) {
			throw new SaltParameterException("sDSSequences", "addSToken", this.getClass());
		}
		if (sequences.size() > 0) {
			SToken sToken = SaltFactory.createSToken();
			this.addNode(sToken);
			for (DataSourceSequence sequence : sequences) {
				addToken(sToken, sequence);
			}
			return (sToken);
		} else {
			return (null);
		}
	}

	/** {@inheritDoc} **/
	@Override
	public SToken createToken(SSequentialDS sequentialDS, Integer start, Integer end) {
		if (sequentialDS == null) {
			throw new SaltParameterException("sequentialDS", "createToken", this.getClass(),
					"The passed sequentialDS is empty. ");
		}
		if (sequentialDS.getId() == null || !containsNode(sequentialDS.getId())) {
			throw new SaltInsertionException(this, sequentialDS,
					"The passed sequentialDS does not belong to this document graph. ");
		}
		SToken sTok = SaltFactory.createSToken();
		DataSourceSequence sequence = new DataSourceSequence<Number>();
		sequence.setStart(start);
		sequence.setEnd(end);
		sequence.setDataSource(sequentialDS);
		addToken(sTok, sequence);
		return (sTok);
	}

	/**
	 * Connects the given {@link SToken} object to the given
	 * {@link SSequentialDS} object. If the given {@link SToken} object is not
	 * already add to the graph, it will be added.
	 * 
	 * @param token
	 *            token to connect to the {@link SSequentialDS} object
	 * @param sequence
	 *            object containing the {@link SSequentialDS} object and the
	 *            borders, to which the token points to
	 */
	private void addToken(SToken token, DataSourceSequence sequence) {
		if (sequence == null) {
			throw new SaltParameterException("sDSSequence", "addSToken", this.getClass());
		}
		if (sequence.getDataSource() == null) {
			throw new SaltParameterException("sDSSequences.getSSequentialDS()", "addSToken", this.getClass());
		}
		if (sequence.getStart() == null) {
			throw new SaltParameterException("sDSSequences.getSStart()", "addSToken", this.getClass());
		}
		if (sequence.getEnd() == null) {
			throw new SaltParameterException("sDSSequences.getSEnd()", "addSToken", this.getClass());
		}
		if ((token.getId() == null) || (getNode(token.getId()) == null)) {
			addNode(token);
		}

		SSequentialRelation seqRel = null;

		if (sequence.getDataSource() instanceof STextualDS) {
			seqRel = SaltFactory.createSTextualRelation();
			((STextualRelation) seqRel).setTarget((STextualDS) sequence.getDataSource());
		} else if (sequence.getDataSource() instanceof STimeline) {
			seqRel = SaltFactory.createSTimelineRelation();
			((STimelineRelation) seqRel).setTarget((STimeline) sequence.getDataSource());
		}
		if (seqRel != null) {
			seqRel.setSource(token);
			seqRel.setStart(sequence.getStart());
			seqRel.setEnd(sequence.getEnd());
			addRelation(seqRel);
		}
	}

	/** {@inheritDoc} **/
	@Override
	public SToken createToken(DataSourceSequence sDSSequence) {
		SToken sToken = SaltFactory.createSToken();
		addNode(sToken);
		addToken(sToken, sDSSequence);
		return (sToken);
	}

	/** {@inheritDoc} **/
	@Override
	public SSpan createSpan(List<SToken> tokens) {
		if (SaltUtil.isNotNullOrEmpty(tokens)) {
			return (createSpan(tokens.toArray(new SToken[tokens.size()])));
		} else {
			return (null);
		}
	}

	/** {@inheritDoc} **/
	@Override
	public SSpan createSpan(SToken... tokens) {
		SSpan retVal = null;
		if (tokens != null) {
			for (SToken sToken : tokens) {
				if (sToken != null) {
					if (retVal == null) {
						retVal = SaltFactory.createSSpan();
						addNode(retVal);
					}
					SSpanningRelation sSpanRel = SaltFactory.createSSpanningRelation();
					sSpanRel.setSource(retVal);
					sSpanRel.setTarget(sToken);
					addRelation(sSpanRel);
				}
			}
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public SStructure createStructure(List<SStructuredNode> sourceNodes) {
		if (SaltUtil.isNotNullOrEmpty(sourceNodes)) {
			return (createStructure(sourceNodes.toArray(new SStructuredNode[sourceNodes.size()])));
		} else {
			return (null);
		}
	}

	/** {@inheritDoc} **/
	@Override
	public SStructure createStructure(SStructuredNode... structures) {
		SStructure retVal = null;
		if (structures != null) {
			for (SStructuredNode sStructuredNode : structures) {
				if (sStructuredNode != null) {
					if (retVal == null) {
						retVal = SaltFactory.createSStructure();
						addNode(retVal);
					}
					SDominanceRelation sDomRel = SaltFactory.createSDominanceRelation();
					sDomRel.setSource(retVal);
					sDomRel.setTarget(sStructuredNode);
					addRelation(sDomRel);
				}
			}
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public STimeline createTimeline() {
		STimeline retVal = null;
		if ((getTimeline() == null) || (getTimeline().getEnd() == 0)) {
			STimeline sTimeline = SaltFactory.createSTimeline();
			addNode(sTimeline);
			List<STimelineRelation> sTimeRelList = new ArrayList<>();
			Map<STextualDS, List<STimelineRelation>> sTimeRelTable = new Hashtable<>();
			for (STextualRelation sTextRel : getTextualRelations()) {
				// for each token create a STimeline object
				STimelineRelation sTimeRel = SaltFactory.createSTimelineRelation();
				sTimeRel.setTarget(sTimeline);
				sTimeRel.setSource(sTextRel.getSource());

				// start: put STimelineRelation into sTimeRelTable
				if (sTimeRelTable.get(sTextRel.getTarget()) == null) {
					sTimeRelTable.put(sTextRel.getTarget(), new ArrayList<STimelineRelation>());
				}
				// TODO not only adding the timeRel, sorting for left and right
				// textual position
				sTimeRelTable.get(sTextRel.getTarget()).add(sTimeRel);
				// end: put STimelineRelation into sTimeRelTable
			} // for each token create a STimeline object
			for (STextualDS sTextualDS : getTextualDSs()) {
				sTimeRelList.addAll(sTimeRelTable.get(sTextualDS));
			}
			Integer pot = 0;
			for (STimelineRelation sTimeRelation : sTimeRelList) {
				sTimeRelation.setStart(pot);
				pot++;
				sTimeline.increasePointOfTime();
				sTimeRelation.setEnd(pot);
				addRelation(sTimeRelation);
			}
			retVal = sTimeline;
		} else {
			retVal = getTimeline();
		}

		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SToken> getTokensBySequence(DataSourceSequence sequence) {
		return (new GetXBySequence(this).getTokensBySequence(sequence));
	}

	/** {@inheritDoc} **/
	@Override
	public List<SSpan> getSpansBySequence(DataSourceSequence sequence) {
		return (new GetXBySequence(this).getSpanBySequence(sequence));
	}

	/** {@inheritDoc} **/
	@Override
	public List<SStructure> getStructuresBySequence(DataSourceSequence sequence) {
		return (new GetXBySequence(this).getStructureBySequence(sequence));
	}

	/** {@inheritDoc} **/
	@Override
	public List<SNode> getNodesBySequence(DataSourceSequence sequence) {
		return (new GetXBySequence(this).getNodeBySequence(sequence));
	}

	/** {@inheritDoc} **/
	@Override
	public List<DataSourceSequence> getOverlappedDataSourceSequence(SNode node, SALT_TYPE... relationTypes) {
		return (DataSourceAccessor.getOverlappedDataSourceSequence(this, node, relationTypes));
	}

	/** {@inheritDoc} **/
	@Override
	public List<DataSourceSequence> getOverlappedDataSourceSequence(List<SNode> nodes, SALT_TYPE... relationTypes) {
		return (DataSourceAccessor.getOverlappedDataSourceSequence(this, nodes, relationTypes));
	}

	/** {@inheritDoc} **/
	@Override
	public boolean isContinuousByText(List<SNode> subNodeList, List<SNode> fullNodeList) {
		return (DataSourceAccessor.isContinuousByText(this, subNodeList, fullNodeList));
	}

	/** {@inheritDoc} **/
	@Override
	public boolean isContinuousByText(List<SNode> subNodeList) {
		return (DataSourceAccessor.isContinuousByText(this, subNodeList));
	}

	/** {@inheritDoc} **/
	@Override
	public List<SToken> getSortedTokenByText(List<SToken> tokens2sort) {
		return (DataSourceAccessor.getSortedSTokenByText(this, tokens2sort));
	}

	/** {@inheritDoc} **/
	@Override
	public List<SToken> getSortedTokenByText() {
		return (DataSourceAccessor.getSortedSTokenByText(this));
	}

	/** {@inheritDoc} **/
	@Override
	public void sortTokenByText() {
		DataSourceAccessor.sortSTokenByText(this);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SNode> getRootsByRelation(SALT_TYPE... type) {
		return (DataSourceAccessor.getRootsByRelation(this, type));
	}

	/** {@inheritDoc} **/
	@Override
	public Multimap<String, SNode> getRootsByRelationType(SALT_TYPE type) {
		return (DataSourceAccessor.getRootsByRelationType(this, type));
	}

	/** {@inheritDoc} **/
	@Override
	public List<SToken> tokenize() {
		List<SToken> retVal = null;
		if (getTextualDSs().size() > 0) {
			Tokenizer tokenizer = createTokenizer();
			for (STextualDS sTextualDS : getTextualDSs()) {
				if (sTextualDS != null) {
					if (retVal == null) {
						retVal = new ArrayList<>();
					}
					retVal.addAll(tokenizer.tokenize(sTextualDS));
				}
			}
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public Tokenizer createTokenizer() {
		Tokenizer tokenizer = new Tokenizer();
		tokenizer.setsDocumentGraph(this);
		return (tokenizer);
	}

	/** {@inheritDoc} **/
	@Override
	public SToken insertTokenAt(STextualDS sTextualDS, Integer posInText, String text, Boolean insertSpace) {
		List<String> texts = new ArrayList<>();
		texts.add(text);
		return (insertTokensAt(sTextualDS, posInText, texts, insertSpace).get(0));
	}

	/** {@inheritDoc} **/
	@Override
	public List<SToken> insertTokensAt(STextualDS sTextualDS, Integer posInText, List<String> texts,
			Boolean insertSpace) {
		List<SToken> sTokens = new ArrayList<>();
		Set<STextualRelation> newSTextualRelations = new HashSet<STextualRelation>();

		StringBuilder newSTextualDSvalueBuilder = new StringBuilder(sTextualDS.getText().substring(0, posInText));

		int sizeOfnewTexts = newSTextualDSvalueBuilder.length();
		for (String text : texts) {

			Integer start = newSTextualDSvalueBuilder.length();
			newSTextualDSvalueBuilder.append(text);
			Integer end = newSTextualDSvalueBuilder.length();
			SToken sTok = SaltFactory.createSToken();
			addNode(sTok);
			sTokens.add(sTok);

			STextualRelation sTextRel = SaltFactory.createSTextualRelation();
			sTextRel.setStart(start);
			sTextRel.setEnd(end);
			sTextRel.setSource(sTok);
			sTextRel.setTarget(sTextualDS);
			addRelation(sTextRel);

			newSTextualRelations.add(sTextRel);

			if (insertSpace) {
				newSTextualDSvalueBuilder.append(" ");
			}
		}

		sizeOfnewTexts = newSTextualDSvalueBuilder.length() - sizeOfnewTexts;

		newSTextualDSvalueBuilder.append(sTextualDS.getText().substring(posInText));

		sTextualDS.setText(newSTextualDSvalueBuilder.toString());

		for (STextualRelation sTextualRelation : getTextualRelations()) {

			if (!newSTextualRelations.contains(sTextualRelation)) {
				if (sTextualRelation.getStart() >= posInText) {
					sTextualRelation.setStart(sTextualRelation.getStart() + sizeOfnewTexts);
				}
				if (sTextualRelation.getEnd() > posInText) {
					sTextualRelation.setEnd(sTextualRelation.getEnd() + sizeOfnewTexts);
				}
			}
		}
		return (sTokens);
	}

	/** {@inheritDoc} **/
	@Override
	public SRelation createRelation(SNode sSource, SNode sTarget, SALT_TYPE sRelationType, String sAnnotations) {
		if (sSource == null) {
			throw new SaltParameterException("Cannot create an Srelation, because the passed source node is null.");
		}
		if (sTarget == null) {
			throw new SaltParameterException("Cannot create an Srelation, because the passed target node is null.");
		}
		if (sRelationType == null) {
			throw new SaltParameterException("Cannot create an Srelation, because the type of relation is null.");
		}
		SRelation sRel = null;
		switch (sRelationType) {
		case SPOINTING_RELATION:
			sRel = SaltFactory.createSPointingRelation();
			break;
		case SSPANNING_RELATION:
			sRel = SaltFactory.createSSpanningRelation();
			break;
		case SDOMINANCE_RELATION:
			sRel = SaltFactory.createSDominanceRelation();
			break;
		case SORDER_RELATION:
			sRel = SaltFactory.createSOrderRelation();
			break;
		default:
			throw new SaltParameterException("Cannot create an SRelation, because the passed type '" + sRelationType
					+ "' is not supported for this method.");
		}
		try {
			sRel.setSource(sSource);
			sRel.setTarget(sTarget);
		} catch (Exception e) {
			throw new SaltParameterException("Cannot create an SRelation for the passed type '" + sRelationType
					+ "', because of a nested exception. It might be, that the passed type is not compatible to the types of passed sSource '"
					+ sSource.getClass() + "' or sTarget node '" + sTarget.getClass() + "'.");
		}
		addRelation(sRel);
		sRel.createAnnotations(sAnnotations);
		return (sRel);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SToken> getOverlappedTokens(SNode overlappingNode) {
		return (DataSourceAccessor.getOverlappedSTokens(this, overlappingNode, SALT_TYPE.STEXT_OVERLAPPING_RELATION));
	}

	/** {@inheritDoc} **/
	@Override
	public List<SToken> getOverlappedTokens(SNode overlappingNode, SALT_TYPE... relationTypes) {
		return (DataSourceAccessor.getOverlappedSTokens(this, overlappingNode, relationTypes));
	}

	/** {@inheritDoc} **/
	@Override
	public String getText(SNode sNode) {
		if (sNode == null) {
			return null;
		}
		if (this.getOverlappedDataSourceSequence(sNode, SALT_TYPE.STEXT_OVERLAPPING_RELATION) == null) {
			return null;
		}
		DataSourceSequence sData = getOverlappedDataSourceSequence(sNode, SALT_TYPE.STEXT_OVERLAPPING_RELATION).get(0);
		return ((STextualDS) sData.getDataSource()).getText().substring((Integer) sData.getStart(),
				(Integer) sData.getEnd());
	}

	/** {@inheritDoc SDocumentGraph#isIsomorph(SDocumentGraph)} **/
	@Override
	public boolean isIsomorph(SDocumentGraph other) {
		Diff diff = new Diff(this, other);
		return (diff.isIsomorph());
	}

	/** {@inheritDoc SDocumentGraph#isIsomorph(SDocumentGraph, DiffOptions)} **/
	@Override
	public boolean isIsomorph(SDocumentGraph other, DiffOptions options) {
		Diff diff = new Diff(this, other, options);
		return (diff.isIsomorph());
	}

	/** {@inheritDoc SDocumentGraph#findDiffs()} **/
	@Override
	public Set<Difference> findDiffs(SDocumentGraph other) {
		Diff diff = new Diff(this, other);
		return (diff.findDiffs());
	}

	/** {@inheritDoc SDocumentGraph#findDiffs(SDocumentGraph, DiffOptions)} **/
	@Override
	public Set<Difference> findDiffs(SDocumentGraph other, DiffOptions options) {
		Diff diff = new Diff(this, other, options);
		return (diff.findDiffs());
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
}
