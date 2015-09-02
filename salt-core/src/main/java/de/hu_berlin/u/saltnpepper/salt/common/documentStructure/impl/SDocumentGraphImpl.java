package de.hu_berlin.u.saltnpepper.salt.common.documentStructure.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.graph.Relation;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SDocument;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDominanceRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SMedialDS;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SMedialRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SOrderRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SPointingRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSequentialDS;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSpan;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSpanningRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SStructure;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SStructuredNode;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STextualDS;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STextualRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STimeline;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STimelineRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SToken;
import de.hu_berlin.u.saltnpepper.salt.common.tokenizer.Tokenizer;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SGraphImpl;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltException;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltInsertionException;
import de.hu_berlin.u.saltnpepper.salt.util.DataSourceSequence;
import de.hu_berlin.u.saltnpepper.salt.util.SALT_TYPE;
import de.hu_berlin.u.saltnpepper.salt.util.SaltUtil;

@SuppressWarnings("serial")
public class SDocumentGraphImpl extends SGraphImpl implements SDocumentGraph {

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

		indexMgr.createIndex(SaltUtil.IDX_NODETYPE, Class.class, Node.class, expectedNodes / 2, expectedNodes);
		indexMgr.createIndex(SaltUtil.IDX_RELATIONTYPE, Class.class, Relation.class, expectedRelations / 2, expectedRelations);
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
		if (relation != null) {
			if (!(relation instanceof SRelation)) {
				throw new SaltInsertionException(this, relation, "Cannot insert an relation, which is not a SRelation object.");
			}
			// start: create a name if none exists
			if ((((SRelation) relation).getName() == null) || (((SRelation) relation).getName().isEmpty())) {
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
			super.basicAddRelation(relation);

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
	/**
	 * Calls the super method an puts the given node into a node type index. an
	 * exception will be thrown.
	 * 
	 * @param node
	 *            to add
	 */
	@Override
	protected void basicAddNode(SNode node) {
		if (node != null) {
			if (!(node instanceof SNode)) {
				throw new SaltInsertionException(this, node, "Cannot insert a node, which is not a SNode object. ");
			}
			// start: create a name if none exists
			if ((((SNode) node).getName() == null) || (((SNode) node).getName().isEmpty())) {
				if (node instanceof STextualDS) {
					((SNode) node).setName("sText" + (getTextualDSs().size() + 1));
				} else if (node instanceof SToken) {
					((SNode) node).setName("sTok" + (getTokens().size() + 1));
				} else if (node instanceof STimeline) {
					((SNode) node).setName("sTimeline" + (getTokens().size() + 1));
				} else if (node instanceof SSpan) {
					((SNode) node).setName("sSpan" + (getSpans().size() + 1));
				} else if (node instanceof SStructure) {
					((SNode) node).setName("structure" + (getStructures().size() + 1));
				} else if (node instanceof SMedialDS) {
					((SNode) node).setName("audio" + (getMedialDSs().size() + 1));
				} else {
					((SNode) node).setName("sNode" + (getNodes().size() + 1));
				}
			}
			// end: create a name if none exists

			if ((((SNode) node).getId() == null) || (((SNode) node).getId().isEmpty())) {
				((SNode) node).setId(getId() + "#" + ((SNode) node).getName());
			}
			super.basicAddNode(node);

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
	// TODO double-chain
	@Override
	public SDocument getDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	// TODO double-chain
	@Override
	public void setDocument(SDocument document) {
		// TODO Auto-generated method stub

	}

	/** {@inheritDoc} **/
	@Override
	public List<STextualDS> getTextualDSs() {
		List<STextualDS> retVal= getIndexMgr().getAll(SaltUtil.IDX_NODETYPE, STextualDS.class);
		if (retVal== null){
			retVal= new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public List<STextualRelation> getTextualRelations() {
		List<STextualRelation> retVal= getIndexMgr().getAll(SaltUtil.IDX_RELATIONTYPE, STextualRelation.class);
		if (retVal== null){
			retVal= new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SToken> getTokens() {
		List<SToken> retVal= getIndexMgr().getAll(SaltUtil.IDX_NODETYPE, SToken.class);
		if (retVal== null){
			retVal= new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public STimeline getTimeline() {
		return(getIndexMgr().get(SaltUtil.IDX_NODETYPE, STimeline.class));
	}

	/** {@inheritDoc} **/
	@Override
	public void setTimeline(STimeline value) {
		addNode(value);
	}

	/** {@inheritDoc} **/
	@Override
	public List<STimelineRelation> getTimelineRelations() {
		List<STimelineRelation> retVal= getIndexMgr().getAll(SaltUtil.IDX_RELATIONTYPE, STimelineRelation.class);
		if (retVal== null){
			retVal= new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SSpanningRelation> getSpanningRelations() {
		List<SSpanningRelation> retVal= getIndexMgr().getAll(SaltUtil.IDX_RELATIONTYPE, SSpanningRelation.class);
		if (retVal== null){
			retVal= new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SSpan> getSpans() {
		List<SSpan> retVal= getIndexMgr().getAll(SaltUtil.IDX_NODETYPE, SSpan.class);
		if (retVal== null){
			retVal= new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SStructure> getStructures() {
		List<SStructure> retVal= getIndexMgr().getAll(SaltUtil.IDX_NODETYPE, SStructure.class);
		if (retVal== null){
			retVal= new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SDominanceRelation> getDominanceRelations() {
		List<SDominanceRelation> retVal= getIndexMgr().getAll(SaltUtil.IDX_RELATIONTYPE, SDominanceRelation.class);
		if (retVal== null){
			retVal= new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SPointingRelation> getPointingRelations() {
		List<SPointingRelation> retVal= getIndexMgr().getAll(SaltUtil.IDX_RELATIONTYPE, SPointingRelation.class);
		if (retVal== null){
			retVal= new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SMedialRelation> getMedialRelations() {
		List<SMedialRelation> retVal= getIndexMgr().getAll(SaltUtil.IDX_RELATIONTYPE, SMedialRelation.class);
		if (retVal== null){
			retVal= new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SMedialDS> getMedialDSs() {
		List<SMedialDS> retVal= getIndexMgr().getAll(SaltUtil.IDX_NODETYPE, SMedialDS.class);
		if (retVal== null){
			retVal= new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public List<SOrderRelation> getOrderRelations() {
		List<SOrderRelation> retVal= getIndexMgr().getAll(SaltUtil.IDX_RELATIONTYPE, SOrderRelation.class);
		if (retVal== null){
			retVal= new ArrayList<>();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public SRelation addNode(SNode sourceSNode, SNode targetSNode, SALT_TYPE sRelationType) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public STextualDS createSTextualDS(String sText) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public SToken createSToken(List<DataSourceSequence> sDSSequences) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public SToken createSToken(DataSourceSequence sDSSequence) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public SSpan createSSpan(SToken sourceSToken) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public SSpan createSSpan(List<SToken> sTokens) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public SStructure createSStructure(SStructuredNode sourceSNode) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public SStructure createSStructure(List<SStructuredNode> sStructures) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public STimeline createSTimeline() {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public List<SToken> getTokensBySequence(DataSourceSequence sequence) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public List<SSpan> getSpansBySequence(DataSourceSequence sequence) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public List<SStructure> getStructuresBySequence(DataSourceSequence sequence) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public List<SNode> getNodesBySequence(DataSourceSequence sequence) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public List<DataSourceSequence> getOverlappedDSSequences(SNode node, List<SALT_TYPE> relationTypes) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public List<DataSourceSequence> getOverlappedDSSequences(List<SNode> sNode, List<SALT_TYPE> relationTypes) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public boolean isContinuousByText(List<SNode> subNodeList, List<SNode> fullNodeList) {
		// TODO Auto-generated method stub
		return false;
	}

	/** {@inheritDoc} **/
	@Override
	public boolean isContinuousByText(List<SNode> subNodeList) {
		// TODO Auto-generated method stub
		return false;
	}

	/** {@inheritDoc} **/
	@Override
	public List<SToken> getSortedSTokenByText(List<SToken> tokens2sort) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public List<SToken> getSortedTokenByText() {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public void sortTokenByText() {
		// TODO Auto-generated method stub

	}

	/** {@inheritDoc} **/
	@Override
	public List<SNode> getRootsByRelation(SALT_TYPE type) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public Map<String, List<SNode>> getRootsBySRelationSType(SALT_TYPE type) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public SToken createSToken(SSequentialDS sequentialDS, Integer start, Integer end) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public List<SToken> tokenize() {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public Tokenizer createTokenizer() {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public SToken insertSTokenAt(STextualDS sTextualDS, Integer posInText, String text, Boolean insertSpace) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public List<SToken> insertSTokensAt(STextualDS sTextualDS, Integer posInText, List<String> texts, Boolean insertSpace) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public SRelation createSRelation(SNode sSource, SNode sTarget, SALT_TYPE sRelationType, String sAnnotations) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public List<SToken> getOverlappedSTokens(SNode overlappingNode, List<SALT_TYPE> overlappingRelationTypes) {
		// TODO Auto-generated method stub
		return null;
	}

	/** {@inheritDoc} **/
	@Override
	public String getSText(SNode sNode) {
		// TODO Auto-generated method stub
		return null;
	}

}
