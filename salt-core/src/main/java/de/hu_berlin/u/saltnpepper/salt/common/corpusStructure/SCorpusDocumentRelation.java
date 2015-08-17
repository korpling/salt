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
package de.hu_berlin.u.saltnpepper.salt.common.corpusStructure;

import de.hu_berlin.u.saltnpepper.salt.core.SRelation;

/**
 * This type represents a hierarchical relation between a corpus (objects of
 * type {@link SCorpus}) and a document (objects of type {@link SDocument}). The
 * source of this relation determines the corpus and the target determines the
 * document in the hierarchical relation.
 * 
 * @author florian
 */
public interface SCorpusDocumentRelation extends SRelation<SCorpus, SDocument> {
	// /**
	// * Returns the document structure containing the linguistic data to this
	// * element.
	// *
	// * @return document structure
	// */
	// public SCorpusGraph getSCorpusGraph();
	// /**
	// * Sets the document structure containing the linguistic data to this
	// * element.
	// *
	// * @param documentStructure document structure
	// */
	// public void setSCorpusGraph(SCorpusGraph documentStructure);

} // SCorpusDocumentRelation
