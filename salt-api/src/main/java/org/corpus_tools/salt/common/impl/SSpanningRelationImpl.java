package org.corpus_tools.salt.common.impl;

import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.common.SSpan;
import org.corpus_tools.salt.common.SSpanningRelation;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.core.impl.SRelationImpl;
import org.corpus_tools.salt.exceptions.SaltParameterException;
import org.corpus_tools.salt.graph.Graph;

@SuppressWarnings("serial")
public class SSpanningRelationImpl extends SRelationImpl<SSpan, SToken> implements SSpanningRelation {
	/** {@inheritDoc} **/
	@Override
	public SDocumentGraph getGraph() {
		return ((SDocumentGraph) super.getGraph());
	}

	/** {@inheritDoc} **/
	@Override
	public void setGraph(@SuppressWarnings("rawtypes") Graph graph) {
		if (!(graph instanceof SDocumentGraph)) {
			throw new SaltParameterException("graph", "setGrah", getClass(), "The parameter was not of type SDocumentGraph. ");
		}
		super.setGraph(graph);
	}
}
