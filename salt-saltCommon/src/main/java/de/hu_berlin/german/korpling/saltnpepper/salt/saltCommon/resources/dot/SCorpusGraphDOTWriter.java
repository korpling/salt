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
package de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.dot;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;

import de.hu_berlin.german.korpling.saltnpepper.salt.SaltFactory;
import de.hu_berlin.german.korpling.saltnpepper.salt.graph.GRAPH_TRAVERSE_TYPE;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltModuleException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.exceptions.SaltResourceException;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.dot.model.DOTEdge;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.resources.dot.model.DOTNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpus;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusDocumentRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusGraph;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SCorpusRelation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCommon.sCorpusStructure.SDocument;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAbstractAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SGraphTraverseHandler;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SMetaAnnotation;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SNode;
import de.hu_berlin.german.korpling.saltnpepper.salt.saltCore.SRelation;

/**
 * This class writes the corpus structure in dot format to file.
 * 
 * @author Florian Zipser
 * 
 */
public class SCorpusGraphDOTWriter implements SGraphTraverseHandler {
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
		if (outputURI == null)
			throw new SaltModuleException("Cannot print the given model to dot, because no output file is given.");

		File outputFile = new File(this.getOutputURI().toFileString());
		File outputDir = null;

		if (outputFile.getName().endsWith("." + SaltFactory.FILE_ENDING_DOT)) {
			outputDir = outputFile.getParentFile();
		} else {
			outputDir = outputFile;
		}
		outputDir.mkdirs();
		try {
			this.currOutputStream = new PrintStream(outputFile, "UTF-8");
		} catch (FileNotFoundException e) {
			throw new SaltResourceException("Cannot save " + SCorpusGraph.class.getSimpleName() + " object to uri '" + outputURI + "'", e);
		} catch (UnsupportedEncodingException e) {
			throw new SaltResourceException("Cannot save " + SCorpusGraph.class.getSimpleName() + " object to uri '" + outputURI + "'", e);
		}
		this.currOutputStream.println("digraph G {");
		this.currOutputStream.println("ordering=out;");

		// if documentgraph isn't null print it
		if (this.getSCorpusGraph() != null) {
			try {
				this.getSCorpusGraph().traverse(this.getSCorpusGraph().getSRootCorpus(), GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST, "", this);
			} catch (Exception e) {
				throw new SaltException("Cannot print SCorpusGraph as dot serialization, because of nested exception. ", e);
			}

		} else {
			this.currOutputStream.println("<empty>[color=red,style=filled]");
		}
		this.currOutputStream.println("}");
		// close and flusch stream
		this.currOutputStream.flush();
		this.currOutputStream.close();
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
		if (sAnno.getSValue() != null)
			anno = sAnno.getSValue().toString().replace("\"", "\\\"");
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
	public void nodeReached(GRAPH_TRAVERSE_TYPE traversalType, String traversalId, SNode currSNode, SRelation sRelation, SNode fromSNode, long order) {
		DOTNode dotNode = new DOTNode();
		dotNode.id = currSNode.getId().toString();

		// print sName
		if (currSNode.getSName() != null)
			dotNode.labels.add("sName" + "= " + currSNode.getSName());

		// create all annotations incl. meta annotations
		for (SMetaAnnotation sMetaAnno : currSNode.getSMetaAnnotations()) {
			dotNode.labels.add(this.createAnnotations(sMetaAnno));
		}

		for (SAnnotation sAnno : currSNode.getSAnnotations()) {
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
		if (sRelation != null) {
			DOTEdge dotEdge = new DOTEdge();
			dotEdge.fromId = fromSNode.getId().toString();
			dotEdge.toId = currSNode.getId().toString();

			// print sName
			if (sRelation.getSName() != null)
				dotEdge.labels.add("sName" + "= " + sRelation.getSName());

			{// print edge type, if exists
				EList<String> sTypes = sRelation.getSTypes();
				if ((sTypes != null) && (sTypes.size() > 0)) {
					String dotString = "";
					for (String sType : sTypes) {
						if (dotString.isEmpty())
							dotString = sType;
						else
							dotString = dotString + sType + ", ";
					}
					dotString = "sTypes=[" + dotString + "]";

					dotEdge.labels.add(dotString);
				}
			}
			for (SAnnotation sAnno : sRelation.getSAnnotations()) {
				dotEdge.labels.add(sAnno.getQName() + "= " + sAnno.getValue().toString());
			}

			// SCORPUS_RELATION
			if (sRelation instanceof SCorpusRelation) {
				dotEdge.color = "gray28";
				dotEdge.style = "filled";
			}
			// SCORPDOC_RELATION
			else if (sRelation instanceof SCorpusDocumentRelation) {
				dotEdge.color = "gray";
				dotEdge.style = "filled";
			}
			currOutputStream.println(dotEdge.toString());
		}
	}
}
