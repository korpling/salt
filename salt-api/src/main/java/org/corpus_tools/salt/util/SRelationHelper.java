package org.corpus_tools.salt.util;

import org.corpus_tools.salt.common.SDominanceRelation;
import org.corpus_tools.salt.common.SOrderRelation;
import org.corpus_tools.salt.common.SPointingRelation;
import org.corpus_tools.salt.common.SSpan;
import org.corpus_tools.salt.common.SSpanningRelation;
import org.corpus_tools.salt.common.SStructure;
import org.corpus_tools.salt.common.SStructuredNode;
import org.corpus_tools.salt.common.STextualDS;
import org.corpus_tools.salt.common.STextualRelation;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.exceptions.SaltParameterException;

public class SRelationHelper<R extends SRelation<S,T>, S extends SNode, T extends SNode> {

	private final Class<S> sourceClass;
	private final Class<T> targetClass;
	
	private SRelationHelper(Class<S> sourceClass, Class<T> targetClass) {
		
		this.sourceClass = sourceClass;
		this.targetClass = targetClass;
	}
	
	/**
	 * Helper function to set source and target node of a relation.
	 * 
	 * @param relation
	 * @param source
	 * @param target
	 * @return
	 * @throws SaltParameterException Throws exception when source or target node have wrong type.
	 */
	public R set(R relation, SNode source, SNode target) throws SaltParameterException {
		if( relation == null) {
			throw new SaltParameterException("relation", "fill", getClass(), "Must not be null.");
		}
		
		if(!sourceClass.isInstance(source)) {
			throw new SaltParameterException("source", "fill", getClass(), "Must not of type " + sourceClass.getSimpleName() + ".");
		}
		
		if(!targetClass.isInstance(target)) {
			throw new SaltParameterException("target", "fill", getClass(), "Must not of type " + sourceClass.getSimpleName() + ".");
		}
		relation.setSource(sourceClass.cast(source));
		relation.setTarget(targetClass.cast(target));
		
		return relation;
	}
	
	public static final SRelationHelper<SDominanceRelation, SStructure, SStructuredNode> DOMINANCE = 
			new SRelationHelper<>(SStructure.class, SStructuredNode.class);
	
	public static final SRelationHelper<SPointingRelation, SStructuredNode, SStructuredNode> POINTING = 
			new SRelationHelper<>(SStructuredNode.class, SStructuredNode.class);
	
	public static final SRelationHelper<SOrderRelation, SStructuredNode, SStructuredNode> ORDER = 
			new SRelationHelper<>(SStructuredNode.class, SStructuredNode.class);
	
	public static final SRelationHelper<SSpanningRelation, SSpan, SToken> SPANNING = 
			new SRelationHelper<>(SSpan.class, SToken.class);
	
	public static final SRelationHelper<STextualRelation, SToken, STextualDS> TEXTUAL = 
			new SRelationHelper<>(SToken.class, STextualDS.class);
}
