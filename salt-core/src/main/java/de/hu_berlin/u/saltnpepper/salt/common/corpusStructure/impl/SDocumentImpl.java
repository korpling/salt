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

import org.eclipse.emf.common.util.URI;

import de.hu_berlin.u.saltnpepper.salt.SaltFactory;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SDocument;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.core.SFeature;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SNodeImpl;
import de.hu_berlin.u.saltnpepper.salt.util.SaltUtil;

@SuppressWarnings("serial")
public class SDocumentImpl extends SNodeImpl implements SDocument {

	/** document structure which is contained in this document */
	protected SDocumentGraph documentStructure;

	/** {@inheritDoc} **/
	@Override
	public SDocumentGraph getDocumentGraph() {
		return(documentStructure);
	}

	/** {@inheritDoc} **/
	@Override
	public void setDocumentGraph(SDocumentGraph documentStructure) {
		this.documentStructure= documentStructure;
	}

	/** {@inheritDoc} **/
	@Override
	public URI getDocumentGraphLocation() {
		URI retVal = null;
		String name = SaltUtil.KW_QNAME_SDOCUMENT_GRAPH_LOCATION;
		SFeature sFeature = getFeature(name);
		if (sFeature != null) {
			Object obj = sFeature.getValue();
			if (obj instanceof URI)
				retVal = (URI) obj;
			else
				retVal = URI.createURI(obj.toString());
		}
		return (retVal);
	}

	/** {@inheritDoc} **/
	@Override
	public void setDocumentGraphLocation(URI location) {
		String name = SaltUtil.KW_QNAME_SDOCUMENT_GRAPH_LOCATION;
		SFeature sFeature = getFeature(name);
		if (sFeature == null) {
			// create a new sFeature
			sFeature = SaltFactory.createSFeature();
			sFeature.setNamespace(SaltUtil.SALT_NAMESPACE);
			sFeature.setName(SaltUtil.KW_SDOCUMENT_GRAPH_LOCATION);
			addFeature(sFeature);
		}
		sFeature.setValue(location.toString());
	}

	/** {@inheritDoc} **/
	@Override
	public void saveDocumentGraph(URI documentGraphLocation) {
		//TODO
//		SaltFactory.eINSTANCE.saveSDocumentGraph(getDocumentGraph(), documentGraphLocation);
//		setDocumentGraph(null);
//		setDocumentGraphLocation(documentGraphLocation);
	}

	/** {@inheritDoc} **/
	@Override
	public void loadDocumentGraph() {
		//TODO
//		loadSDocumentGraph(getDocumentGraphLocation());
	}

	/** {@inheritDoc} **/
	@Override
	public void loadDocumentGraph(URI documentGraphLocation) {
		//TODO
//		SDocumentGraph sDocumentGraph= SaltFactory.eINSTANCE.loadSDocumentGraph(documentGraphLocation);
//		setDocumentGraph(sDocumentGraph);
//		//remove SFeature containing location of where SaltXML file containing the loaded object  
//		removeLabel(SaltUtil.KW_QNAME_SDOCUMENT_GRAPH_LOCATION);
	}

} // SDocumentImpl
