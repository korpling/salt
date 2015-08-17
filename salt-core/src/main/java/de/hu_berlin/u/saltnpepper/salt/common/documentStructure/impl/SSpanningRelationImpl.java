package de.hu_berlin.u.saltnpepper.salt.common.documentStructure.impl;

import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSpan;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSpanningRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SToken;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SRelationImpl;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltWrongParameterException;

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
			throw new SaltWrongParameterException("graph", "setGrah", getClass(), "The parameter was not of type SDocumentGraph. ");
		}
		super.setGraph(graph);
	}
}
