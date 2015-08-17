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
package de.hu_berlin.u.saltnpepper.salt.common.documentStructure.impl;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSequentialRelation;
import de.hu_berlin.u.saltnpepper.salt.core.SFeature;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SRelationImpl;
import de.hu_berlin.u.saltnpepper.salt.util.SaltUtil;

@SuppressWarnings("serial")
public abstract class SSequentialRelationImpl<S extends SNode, T extends SNode, P> extends SRelationImpl<S, T> implements SSequentialRelation<S, T, P> {

	/** {@inheritDoc} **/
	@Override
	public P getStart() {
		P retVal = null;
		SFeature sFeature = getFeature(SaltUtil.FEAT_SSTART_QNAME);
		if (sFeature != null) {
			retVal = (P) sFeature.getValue();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public void setStart(P newSStart) {
		SFeature sFeature = this.getFeature(SaltUtil.FEAT_SSTART_QNAME);
		if (sFeature == null) {// create a new sFeature
			sFeature = SaltFactory.createSFeature();
			sFeature.setNamespace(SaltUtil.SALT_NAMESPACE);
			sFeature.setName(SaltUtil.FEAT_SSTART);
			this.addFeature(sFeature);
		}
		sFeature.setValue(newSStart);
	}

	/** {@inheritDoc} **/
	@Override
	public P getEnd() {
		P retVal = null;
		SFeature sFeature = this.getFeature(SaltUtil.FEAT_SEND_QNAME);
		if ((sFeature != null) && (sFeature.getValue() != null)) {
			retVal = (P) sFeature.getValue();
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public void setEnd(P newSEnd) {
		SFeature sFeature = this.getFeature(SaltUtil.FEAT_SEND_QNAME);
		if (sFeature == null) {// create a new sFeature
			sFeature = SaltFactory.createSFeature();
			sFeature.setNamespace(SaltUtil.SALT_NAMESPACE);
			sFeature.setName(SaltUtil.FEAT_SEND);
			this.addFeature(sFeature);
		}
		sFeature.setValue(newSEnd);
	}
} // SSequentialRelationImpl
