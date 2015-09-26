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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.eclipse.emf.common.util.URI;

import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpus;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusDocumentRelation;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusGraph;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusRelation;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SDocument;
import de.hu_berlin.u.saltnpepper.salt.core.GraphTraverseHandler;
import de.hu_berlin.u.saltnpepper.salt.core.SAbstractAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SGraph.GRAPH_TRAVERSE_TYPE;
import de.hu_berlin.u.saltnpepper.salt.core.SMetaAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltException;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltResourceException;
import de.hu_berlin.u.saltnpepper.salt.util.SaltUtil;

/**
 * This class writes the corpus structure in dot format to file.
 * 
 * @author Florian Zipser
 * 
 */
public class SCorpusGraphDOTWriter implements GraphTraverseHandler {
	private URI outputURI = null;

	public void setOutputURI(URI outputURI) {
		this.outputURI = outputURI;
	}

	public URI getOutputURI() {
		return outputURI;
	}

	private SCorpusGraph sCorpusGraph = null;

	public void setSCorpusGraph(SCorpusGraph sCorpusGraph) {
		this.sCorpusGraph = sCorpusGraph;
	}

	public SCorpusGraph getSCorpusGraph() {
		return sCorpusGraph;
	}

	private PrintStream currOutputStream = null;

	public void save() {
		if (getOutputURI() == null) {
			throw new SaltException("Cannot print the given model to dot, because no output file is given.");
		}
		String str = getOutputURI().toFileString();
		if (str == null) {
			str = getOutputURI().toString();
		}
		File outputFile = new File(str);
		File outputDir = null;

		if (outputFile.getName().endsWith("." + SaltUtil.FILE_ENDING_DOT)) {
			outputDir = outputFile.getParentFile();
		} else {
			outputDir = outputFile;
		}
		outputDir.mkdirs();
		try {
			currOutputStream = new PrintStream(outputFile, "UTF-8");
		} catch (FileNotFoundException e) {
			throw new SaltResourceException("Cannot save " + SCorpusGraph.class.getSimpleName() + " object to uri '" + outputURI + "'", e);
		} catch (UnsupportedEncodingException e) {
			throw new SaltResourceException("Cannot save " + SCorpusGraph.class.getSimpleName() + " object to uri '" + outputURI + "'", e);
		}
		currOutputStream.println("digraph G {");
		currOutputStream.println("ordering=out;");

		// if documentgraph isn't null print it
		if (getSCorpusGraph() != null) {
			try {
				getSCorpusGraph().traverse(getSCorpusGraph().getRoots(), GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, "", this);
			} catch (Exception e) {
				throw new SaltException("Cannot print SCorpusGraph as dot serialization, because of nested exception. ", e);
			}

		} else {
			currOutputStream.println("<empty>[color=red,style=filled]");
		}
		currOutputStream.println("}");
		// close and flusch stream
		currOutputStream.flush();
		currOutputStream.close();
	}

	/**
	 * Creates all annotation for dotNode comming from SAnnotation. This methode
	 * also includes traversing recursive Annotations (meta annotations).
	 * 
	 * @param sAnno
	 *            salt object form which all annotations come
	 * @return returns a label for dot node
	 */
	private String createAnnotations(SAbstractAnnotation sAnno) {
		String retStr = null;

		String anno = null;
		if (sAnno.getValue() != null)
			anno = sAnno.getValue().toString().replace("\"", "\\\"");
		retStr = (sAnno.getQName() + "= " + anno);

		return (retStr);
	}

	@Override
	public boolean checkConstraint(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SRelation edge, SNode currNode, long order) {
		return true;
	}

	@Override
	public void nodeLeft(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currNode, SRelation edge, SNode fromNode, long order) {
	}

	@Override
	public void nodeReached(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currSNode, SRelation relation, SNode fromSNode, long order) {
		DOTNode dotNode = new DOTNode();
		dotNode.id = currSNode.getId().toString();

		// print name
		if (currSNode.getName() != null)
			dotNode.labels.add("name" + "= " + currSNode.getName());

		// create all annotations incl. meta annotations
		for (SMetaAnnotation sMetaAnno : currSNode.getMetaAnnotations()) {
			dotNode.labels.add(createAnnotations(sMetaAnno));
		}

		for (SAnnotation sAnno : currSNode.getAnnotations()) {
			String anno = sAnno.getValue().toString().replace("\"", "\\\"");
			dotNode.labels.add(sAnno.getQName() + "= " + anno);
		}
		// SCORPUS
		if (currSNode instanceof SCorpus) {
			dotNode.color = "gray28";
			dotNode.style = "filled";
			dotNode.shape = "Mrecord";
		}
		// SDOCUMENT
		else if (currSNode instanceof SDocument) {
			dotNode.color = "gray";
			dotNode.style = "filled";
			dotNode.shape = "Mrecord";
		}
		currOutputStream.println(dotNode.toString());
		// print relation, if exists
		if (relation != null) {
			DOTEdge dotEdge = new DOTEdge();
			dotEdge.fromId = fromSNode.getId().toString();
			dotEdge.toId = currSNode.getId().toString();

			// print name
			if (relation.getName() != null)
				dotEdge.labels.add("name" + "= " + relation.getName());

			// print edge type, if exists
			String type = relation.getType();
			if ((type != null) && (!type.isEmpty())) {
				dotEdge.labels.add("type=[" + type + "]");
			}
			for (SAnnotation sAnno : relation.getAnnotations()) {
				dotEdge.labels.add(sAnno.getQName() + "= " + sAnno.getValue().toString());
			}

			// SCORPUS_RELATION
			if (relation instanceof SCorpusRelation) {
				dotEdge.color = "gray28";
				dotEdge.style = "filled";
			}
			// SCORPDOC_RELATION
			else if (relation instanceof SCorpusDocumentRelation) {
				dotEdge.color = "gray";
				dotEdge.style = "filled";
			}
			currOutputStream.println(dotEdge.toString());
		}
	}
}
