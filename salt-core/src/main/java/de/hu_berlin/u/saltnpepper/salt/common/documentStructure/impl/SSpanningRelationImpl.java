package de.hu_berlin.u.saltnpepper.salt.common.documentStructure.impl;

import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSpan;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSpanningRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SToken;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SRelationImpl;

@SuppressWarnings("serial")
public class SSpanningRelationImpl extends SRelationImpl<SSpan, SToken> implements SSpanningRelation {

	@Override
	public Boolean isSTextOverlapping() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isSTimeOverlapping() {
		// TODO Auto-generated method stub
		return null;
	}
}
