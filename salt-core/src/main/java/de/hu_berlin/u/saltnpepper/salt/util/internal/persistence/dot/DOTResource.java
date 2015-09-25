/**
 * Copyright 2009 Humboldt University of Berlin, INRIA.
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
package de.hu_berlin.u.saltnpepper.salt.util.internal.persistence.dot;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;

import de.hu_berlin.u.saltnpepper.salt.common.SaltProject;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpus;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusGraph;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SDocument;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltResourceException;
import de.hu_berlin.u.saltnpepper.salt.util.SaltUtil;

/**
 * This method stores a Salt model in the dot syntax (see:
 * http://www.graphviz.org/) in a file. The stored dot graph can be visualized
 * via the Graphviz toolbox (see: http://www.graphviz.org/) into a bunch of
 * graphical formats like jpeg, png, svg etc.. <br/>
 * In case of a {@link SaltProject} like the following is stored:
 * 
 * <pre>
 * |-----------------------------------------------|
 * | SaltProject:                                  |
 * |-----------------------------------------------|
 * | corpus-structure 0      | corpus-structure 1  |
 * |                         |                     |
 * |          c1             |       c1            |
 * |        /     \          |       |             |
 * |       c2      c3        |       d1            |
 * |   /   |   \   |   \     |                     |
 * |  d1   d2  d3  d4  d5    |                     |
 * |-----------------------------------------------|
 * </pre>
 * 
 * A structure like the following is created:
 * 
 * <pre>
 * 
 *  |-0
 *  | |-c1
 *  | | |-c2
 *  | |   |-d1.dot
 *  | |   |-d2.dot
 *  | |   |-d3.dot
 *  | | |-c3
 *  | |   |-d4.dot
 *  | |   |-d5.dot
 *  | |-0.dot
 *  |-1
 *    |-c1
 *    | |-d1.dot
 *    |-1.dot
 * </pre>
 * 
 * @author Florian Zipser
 */
public class DOTResource {
	// /**
	// * Stores the passed {@link Econtent} to a dot file located by the passed
	// * {@link URI}.<br/>
	// * <strong>Note, that only a set of {@link Econtent} types is
	// * supported</strong>
	// *
	// * @param content
	// * A SaltProject, SCorpusGraph or SDocumentGraph
	// * @param outputURI
	// * locating the place to store dot file
	// */
	// public static void save(EObject content, URI outputURI) {
	// save(content, outputURI, null);
	// }
	//
	// /**
	// * Stores the passed {@link Econtent} to a dot file located by the passed
	// * {@link URI}.<br/>
	// * <strong>Note, that only a set of {@link Econtent} types is
	// * supported</strong>
	// *
	// * @param content
	// * A SaltProject, SCorpusGraph or SDocumentGraph
	// * @param outputURI
	// * locating the place to store dot file
	// * @param options
	// * a map of options to customize the storing behavior
	// */
	// public static void save(EObject content, URI outputURI, Map<?, ?>
	// options) {
	// if (outputURI == null)
	// throw new
	// SaltResourceException("Cannot store the given Salt model content to resource, beacue it is empty.");
	// if (content == null)
	// throw new
	// SaltResourceException("Cannot store the given Salt model content to resource, beacue the content is empty.");
	//
	// Resource resourceOut = new DOTResource();
	// resourceOut.setURI(outputURI);
	// resourceOut.getContents().add(content);
	// try {
	// resourceOut.save(options);
	// } catch (IOException e) {
	// throw new SaltResourceException("Cannot export model to file '" +
	// outputURI + "', because of an unknown error.", e);
	// }
	// }

	/**
	 * Stores a SCorpusGraph model into DOT file
	 */
	private void saveCorpusGraph_DOT(SCorpusGraph sCorpusGraph, URI location) {
		URI targetUri = null;
		if (location.fileExtension() == null) {
			if ((sCorpusGraph.getSaltProject() != null) && (sCorpusGraph.getSaltProject().getCorpusGraphs().size() > 1)) {
				Integer pos = sCorpusGraph.getSaltProject().getCorpusGraphs().indexOf(sCorpusGraph);
				targetUri = location.appendSegment(pos.toString()).appendFileExtension(SaltUtil.FILE_ENDING_DOT);
			} else {
				List<SNode> roots = sCorpusGraph.getRoots();
				if ((roots != null) && (!roots.isEmpty())) {
					targetUri = location.appendSegment(((SCorpus) roots.get(0)).getName()).appendFileExtension(SaltUtil.FILE_ENDING_DOT);
				} else {
					targetUri = location.appendSegment(sCorpusGraph.getName()).appendFileExtension(SaltUtil.FILE_ENDING_DOT);
				}
			}
		} else {
			targetUri = location;
		}
		SCorpusGraphDOTWriter writer = new SCorpusGraphDOTWriter();
		writer.setSCorpusGraph(sCorpusGraph);
		writer.setOutputURI(targetUri);
		writer.save();
	}

	/**
	 * Stores a SDocumentGraph model into DOT file
	 */
	private void saveDocumentGraph_DOT(SDocumentGraph sDocumentGraph, URI location) {
		URI targetUri = null;
		if (location.fileExtension() == null) {
			if (sDocumentGraph.getDocument() != null) {
				targetUri = location.appendSegment(sDocumentGraph.getDocument().getName()).appendFileExtension(SaltUtil.FILE_ENDING_DOT);
			} else {
				targetUri = location.appendSegment(sDocumentGraph.getName()).appendFileExtension(SaltUtil.FILE_ENDING_DOT);
			}
		} else {
			targetUri = location;
		}
		SDocumentGraphDOTWriter writer = new SDocumentGraphDOTWriter();
		writer.setSDocumentGraph(sDocumentGraph);
		writer.setOutputURI(targetUri);
		writer.save();
	}

	/**
	 * This method stores a Salt model in the dot syntax (see:
	 * http://www.graphviz.org/) in a file. The stored dot graph can be
	 * visualized via the Graphviz toolbox (see: http://www.graphviz.org/) into
	 * a bunch of graphical formats like jpeg, png, svg etc.. <br/>
	 * In case of a {@link SaltProject} like the following is stored:
	 * 
	 * <pre>
	 * |-----------------------------------------------|
	 * | SaltProject:                                  |
	 * |-----------------------------------------------|
	 * | corpus-structure 0      | corpus-structure 1  |
	 * |                         |                     |
	 * |          c1             |       c1            |
	 * |        /     \          |       |             |
	 * |       c2      c3        |       d1            |
	 * |   /   |   \   |   \     |                     |
	 * |  d1   d2  d3  d4  d5    |                     |
	 * |-----------------------------------------------|
	 * </pre>
	 * 
	 * A structure like the following is created:
	 * 
	 * <pre>
	 * 
	 *  |-0
	 *  | |-c1
	 *  | | |-c2
	 *  | |   |-d1.dot
	 *  | |   |-d2.dot
	 *  | |   |-d3.dot
	 *  | | |-c3
	 *  | |   |-d4.dot
	 *  | |   |-d5.dot
	 *  | |-0.dot
	 *  |-1
	 *    |-c1
	 *    | |-d1.dot
	 *    |-1.dot
	 * </pre>
	 */
	public void save_DOT(Object content, URI location) throws java.io.IOException {
		if (location == null) {
			throw new SaltResourceException("Exception in storing Salt model to dot file, because no uri was given.");
		}
		if (content == null) {
			throw new SaltResourceException("Exception in storing Salt model to dot file. Cannot write more than one content per file.");
		}

		if (content instanceof SCorpus) {
			SCorpus sCorpus = (SCorpus) content;
			if (sCorpus.getGraph() != null) {
				content = sCorpus.getGraph();
			} else {
				throw new SaltResourceException("Cannot save Salt model to DOT format, because the given " + SCorpus.class.getSimpleName() + " is not part of a " + SCorpusGraph.class.getSimpleName() + " container");
			}
		} else if (content instanceof SDocument) {
			SDocument sDocument = (SDocument) content;
			if (sDocument.getDocumentGraph() != null) {
				content = sDocument.getDocumentGraph();
			} else {
				throw new SaltResourceException("Cannot save Salt model to DOT format, because the given " + SDocument.class.getSimpleName() + " does not contain a " + SDocumentGraph.class.getSimpleName() + " content");
			}
		}

		// if content is a SDocumentGraph or SCorpusGraph, outputURI does not
		// have to be changed
		if (content instanceof SCorpusGraph) {
			saveCorpusGraph_DOT((SCorpusGraph) content, location);
		} else if (content instanceof SDocumentGraph) {
			saveDocumentGraph_DOT((SDocumentGraph) content, location);
		}
		// if it is a SaltProject, different URIs for the different components
		// of the project are needed
		else if (content instanceof SaltProject) {
			Collection<SCorpusGraph> corpGraphs = Collections.synchronizedCollection(((SaltProject) content).getCorpusGraphs());
			Integer corpIndex = 0;
			for (SCorpusGraph sCorpusGraph : corpGraphs) {
				URI corpUri = location;

				saveCorpusGraph_DOT(sCorpusGraph, corpUri);

				if (corpGraphs.size() > 1) {
					corpUri = corpUri.appendSegment(corpIndex.toString());
				}
				for (int docIndex = 0; docIndex < sCorpusGraph.getDocuments().size(); docIndex++) {
					SDocument sDocument = sCorpusGraph.getDocuments().get(docIndex);
					if (sDocument.getDocumentGraph() != null) {
						URI docURI = corpUri.appendSegments((String[]) sDocument.getPath().segmentsList().toArray());
						SDocumentGraph sDocGraph = sDocument.getDocumentGraph();
						saveDocumentGraph_DOT(sDocGraph, docURI.appendFileExtension(SaltUtil.FILE_ENDING_DOT));
						// when calling saveResource(), the sCorpusGraph content
						// will be attached to the resource and therefore
						// removed from list of SaltProject, therefore the graph
						// must be artificially added again
						sDocument.setDocumentGraph(sDocGraph);
					}
				}
				corpIndex++;
			}
		} else {
			throw new SaltResourceException("Cannot save Salt model to DOT format, because content is neither " + SCorpusGraph.class.getSimpleName() + ", " + SDocumentGraph.class.getSimpleName() + " nor " + SaltProject.class.getSimpleName() + " content. The given content is of type: '" + content.getClass() + "'.");
		}
	}
}
