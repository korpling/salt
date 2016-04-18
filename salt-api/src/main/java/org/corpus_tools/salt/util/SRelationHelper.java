package org.corpus_tools.salt.util;

import org.corpus_tools.salt.common.SCorpus;
import org.corpus_tools.salt.common.SCorpusDocumentRelation;
import org.corpus_tools.salt.common.SCorpusRelation;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.common.SDominanceRelation;
import org.corpus_tools.salt.common.SMedialDS;
import org.corpus_tools.salt.common.SMedialRelation;
import org.corpus_tools.salt.common.SOrderRelation;
import org.corpus_tools.salt.common.SPointingRelation;
import org.corpus_tools.salt.common.SSpan;
import org.corpus_tools.salt.common.SSpanningRelation;
import org.corpus_tools.salt.common.SStructure;
import org.corpus_tools.salt.common.SStructuredNode;
import org.corpus_tools.salt.common.STextualDS;
import org.corpus_tools.salt.common.STextualRelation;
import org.corpus_tools.salt.common.STimeline;
import org.corpus_tools.salt.common.STimelineRelation;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.exceptions.SaltParameterException;

public class SRelationHelper<R extends SRelation<S,T>, S extends SNode, T extends SNode> {

	private final Class<R> relationClass;
	private final Class<S> sourceClass;
	private final Class<T> targetClass;
	
	private SRelationHelper(Class<R> relationClass, Class<S> sourceClass, Class<T> targetClass) {
		this.relationClass = relationClass;
		this.sourceClass = sourceClass;
		this.targetClass = targetClass;
	}
	
	/**
	 * Helper function to set source and target node of a relation.
	 * 
	 * @param relation The untyped relation.
	 * @param source The untyped source node.
	 * @param target The untyped target node.
	 * @return
	 * @throws SaltParameterException Throws exception when relation, source or target node have wrong type.
	 */
	public R setArgs(SRelation<?,?> relation, SNode source, SNode target) throws SaltParameterException {
		if( relation == null) {
			throw new SaltParameterException("relation", "setArgs", getClass(), "Must not be null.");
		}
		
		if(!relationClass.isInstance(relation)) {
			throw new SaltParameterException("relation", "setArgs", getClass(), "Not of type " + relationClass.getSimpleName() + ".");
		}
		R typedRel = relationClass.cast(relation);
		
		if(!sourceClass.isInstance(source)) {
			throw new SaltParameterException("source", "setArgs", getClass(), "Not of type " + sourceClass.getSimpleName() + ".");
		}
		
		if(!targetClass.isInstance(target)) {
			throw new SaltParameterException("target", "setArgs", getClass(), "Not of type " + sourceClass.getSimpleName() + ".");
		}
		
		typedRel.setSource(sourceClass.cast(source));
		typedRel.setTarget(targetClass.cast(target));
		
		return typedRel;
	}
	
	public static final SRelationHelper<SDominanceRelation, SStructure, SStructuredNode> DOMINANCE = 
			new SRelationHelper<>(SDominanceRelation.class, SStructure.class, SStructuredNode.class);
	
	public static final SRelationHelper<SPointingRelation, SStructuredNode, SStructuredNode> POINTING = 
			new SRelationHelper<>(SPointingRelation.class, SStructuredNode.class, SStructuredNode.class);
	
	public static final SRelationHelper<SOrderRelation, SStructuredNode, SStructuredNode> ORDER = 
			new SRelationHelper<>(SOrderRelation.class, SStructuredNode.class, SStructuredNode.class);
	
	public static final SRelationHelper<SSpanningRelation, SSpan, SToken> SPANNING = 
			new SRelationHelper<>(SSpanningRelation.class, SSpan.class, SToken.class);
	
	public static final SRelationHelper<STimelineRelation, SToken, STimeline> TIMELINE = 
			new SRelationHelper<>(STimelineRelation.class, SToken.class, STimeline.class);
	
	public static final SRelationHelper<STextualRelation, SToken, STextualDS> TEXTUAL = 
			new SRelationHelper<>(STextualRelation.class, SToken.class, STextualDS.class);
	
	public static final SRelationHelper<SMedialRelation, SToken, SMedialDS> MEDIAL = 
			new SRelationHelper<>(SMedialRelation.class, SToken.class, SMedialDS.class);
	
	public static final SRelationHelper<SCorpusRelation, SCorpus, SCorpus> CORPUS = 
			new SRelationHelper<>(SCorpusRelation.class, SCorpus.class, SCorpus.class);
	
	public static final SRelationHelper<SCorpusDocumentRelation, SCorpus, SDocument> CORPUSDOCUMENT = 
			new SRelationHelper<>(SCorpusDocumentRelation.class, SCorpus.class, SDocument.class);
}
