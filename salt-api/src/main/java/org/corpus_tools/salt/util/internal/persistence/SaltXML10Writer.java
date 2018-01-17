/**
 * Copyright 2009 Humboldt-Universität zu Berlin.
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
package org.corpus_tools.salt.util.internal.persistence;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.commons.lang3.SerializationUtils;
import org.corpus_tools.salt.common.SCorpus;
import org.corpus_tools.salt.common.SCorpusDocumentRelation;
import org.corpus_tools.salt.common.SCorpusGraph;
import org.corpus_tools.salt.common.SCorpusRelation;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.common.SDominanceRelation;
import org.corpus_tools.salt.common.SMedialDS;
import org.corpus_tools.salt.common.SMedialRelation;
import org.corpus_tools.salt.common.SOrderRelation;
import org.corpus_tools.salt.common.SPointingRelation;
import org.corpus_tools.salt.common.SSpan;
import org.corpus_tools.salt.common.SSpanningRelation;
import org.corpus_tools.salt.common.SStructure;
import org.corpus_tools.salt.common.STextualDS;
import org.corpus_tools.salt.common.STextualRelation;
import org.corpus_tools.salt.common.STimeline;
import org.corpus_tools.salt.common.STimelineRelation;
import org.corpus_tools.salt.common.SToken;
import org.corpus_tools.salt.common.SaltProject;
import org.corpus_tools.salt.core.SAnnotation;
import org.corpus_tools.salt.core.SFeature;
import org.corpus_tools.salt.core.SLayer;
import org.corpus_tools.salt.core.SMetaAnnotation;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SProcessingAnnotation;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.exceptions.SaltResourceException;
import org.corpus_tools.salt.graph.Identifier;
import org.corpus_tools.salt.graph.Label;
import org.corpus_tools.salt.graph.Layer;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.graph.Relation;
import org.corpus_tools.salt.util.SaltUtil;
import org.eclipse.emf.common.util.URI;

import com.ctc.wstx.stax.WstxOutputFactory;
import com.google.common.io.BaseEncoding;

public class SaltXML10Writer implements SaltXML10Dictionary {

	public SaltXML10Writer() {
		this.path = null;
	}

	public SaltXML10Writer(File path) {
		this.path = path;
	}

	public SaltXML10Writer(URI path) {
		if (path != null) {
			String str = path.toFileString();
			if (str != null && !str.isEmpty()) {
				this.path = new File(str);
			}
		}
	}

	/** Determines whether the outputted SaltXML should be pretty printed. **/
	private boolean isPrettyPrint = true;

	/**
	 * Determines whether the outputted SaltXML should be pretty printed.
	 * 
	 * @param isPrettyPrint
	 *            true when output needs to be pretty printed
	 */
	public void setPrettyPrint(boolean isPrettyPrint) {
		this.isPrettyPrint = isPrettyPrint;
	}

	public File getPath() {
		return path;
	}

	private String getLocationStr() {
		if (path == null) {
			return "<no-file>";
		} else {
			return path.toString();
		}
	}

	private File path = null;
	private final XMLOutputFactory xmlFactory = new WstxOutputFactory();

	/**
	 * List of already written root objects or null if there is only one root
	 * object.
	 */
	private List<Object> writtenRootObjects = null;

	/**
	 * Write a number of root objects (objects without a container) to XML.
	 * 
	 * @param xml
	 * @param objects
	 *            List of objects of type {@link SaltProject},
	 *            {@link SDocumentGraph} or {@link SCorpusGraph}
	 */
	public void writeObjects(XMLStreamWriter xml, Object... objects) {

		List<Object> filteredObjects = new ArrayList<>(objects.length);

		// add the valid objects that we can save to a list, throw an error if
		// an invalid object type is dectected
		for (Object o : objects) {
			if (o instanceof SaltProject || o instanceof SDocumentGraph || o instanceof SCorpusGraph) {
				filteredObjects.add(o);
			} else {
				throw new SaltResourceException("Invalid type \"" + o.getClass().getSimpleName() + "\". Root objects "
						+ "must be either of type SaltProject, SDocumentGraph of SCorpusGraph");
			}
		}

		if (writtenRootObjects == null) {
			writtenRootObjects = new ArrayList<>(filteredObjects.size());
		}

		// decide which specialized serializatio function to call depending on
		// the type of the object
		for (Object o : filteredObjects) {
			if (o instanceof SaltProject) {
				writeSaltProject(xml, (SaltProject) o);
			} else if (o instanceof SDocumentGraph) {
				writeDocumentGraph(xml, (SDocumentGraph) o);
			} else if (o instanceof SCorpusGraph) {
				writeCorpusGraph(xml, (SCorpusGraph) o, true);
			}
			// add it to the list of already written objects
			writtenRootObjects.add(o);
		}

	}

	/**
	 * Writes a Salt project to the file given by {@link #getPath()}.
	 * 
	 * @param project
	 *            the Salt project to be written
	 */
	public void writeSaltProject(SaltProject project) {
		XMLStreamWriter xml = null;
		try (OutputStream output = new FileOutputStream(path)) {
			xml = xmlFactory.createXMLStreamWriter(output, "UTF-8");
			xml.writeStartDocument("1.0");
			if (isPrettyPrint) {
				xml.writeCharacters("\n");
			}
			writeSaltProject(xml, project);

			xml.writeEndDocument();

		} catch (XMLStreamException | IOException e) {
			throw new SaltResourceException("Cannot store salt project to file '" + getLocationStr() + "'. ", e);
		} finally {
			if (xml != null) {
				try {
					xml.flush();
					xml.close();
				} catch (XMLStreamException e) {
					throw new SaltResourceException("Cannot store salt project to file '" + getLocationStr()
							+ "', because the opened stream is not closable. ", e);
				}
			}
		}
	}

	/**
	 * Writes a salt project to the xml stream.
	 * 
	 * @param xml
	 *            A pre-configured {@link XMLStreamWriter}
	 * @param project
	 */
	public void writeSaltProject(XMLStreamWriter xml, SaltProject project) {

		try {

			xml.writeStartElement(NS_SALTCOMMON, TAG_SALT_PROJECT, NS_VALUE_SALTCOMMON);
			xml.writeNamespace(NS_SCORPUSSTRUCTURE, NS_VALUE_SCORPUSSTRUCTURE);
			xml.writeNamespace(NS_XMI, NS_VALUE_XMI);
			xml.writeNamespace(NS_XSI, NS_VALUE_XSI);
			xml.writeNamespace(NS_SALTCORE, NS_VALUE_SALTCORE);
			xml.writeNamespace(NS_SALTCOMMON, NS_VALUE_SALTCOMMON);
			xml.writeAttribute(NS_VALUE_XMI, ATT_XMI_VERSION, "2.0");

			Iterator<SCorpusGraph> cGraphs = project.getCorpusGraphs().iterator();
			while (cGraphs.hasNext()) {
				if (isPrettyPrint) {
					xml.writeCharacters("\n");
					xml.writeCharacters("\t");
				}
				writeCorpusGraph(xml, cGraphs.next(), true);
			}

			if (isPrettyPrint) {
				xml.writeCharacters("\n");
			}
			xml.writeEndElement();
		} catch (XMLStreamException e) {
			throw new SaltResourceException("Cannot store salt project to file '" + getLocationStr() + "'. ", e);
		}
	}

	/**
	 * Writes a corpus graph to the xml stream
	 * 
	 * @param graph
	 *            the corpus graph to be written
	 * @param embedded
	 *            determines whether this corpus graph is part of a saltProject
	 * @param xml
	 *            xml stream to write corpus graph to, if the passed one is
	 *            null, a new one will be created
	 */
	public void writeCorpusGraph(XMLStreamWriter xml, SCorpusGraph graph, boolean embedded) {
		try {
			if (!embedded) {
				xml.writeStartDocument("1.0");
				if (isPrettyPrint) {
					xml.writeCharacters("\n");
					xml.writeStartElement(NS_SALTCOMMON, TAG_SCORPUS_GRAPH, NS_VALUE_SALTCOMMON);
					xml.writeNamespace(NS_SCORPUSSTRUCTURE, NS_VALUE_SCORPUSSTRUCTURE);
					xml.writeNamespace(NS_XMI, NS_VALUE_XMI);
					xml.writeNamespace(NS_XSI, NS_VALUE_XSI);
					xml.writeNamespace(NS_SALTCORE, NS_VALUE_SALTCORE);
					xml.writeNamespace(NS_SALTCOMMON, NS_VALUE_SALTCOMMON);
					xml.writeAttribute(NS_VALUE_XMI, ATT_XMI_VERSION, "2.0");
				}
			} else {
				xml.writeStartElement(TAG_SCORPUS_GRAPH);
			}

			// write all labels
			if (graph.getLabels() != null) {
				Iterator<Label> labelIt = graph.getLabels().iterator();
				while (labelIt.hasNext()) {
					if (isPrettyPrint) {
						xml.writeCharacters("\n");
						xml.writeCharacters("\t");
					}
					writeLabel(xml, labelIt.next());
				}
			}
			// stores the position of a single node in the list of nodes to
			// refer them in a relation
			Map<SNode, Integer> nodePositions = new HashMap<>();

			// write all nodes
			if (graph.getNodes() != null) {
				Iterator<SNode> nodeIt = graph.getNodes().iterator();
				Integer position = 0;
				while (nodeIt.hasNext()) {
					SNode node = nodeIt.next();
					writeNode(xml, node, null);
					nodePositions.put(node, position);
					position++;
				}
			}

			// write all relations
			if (graph.getRelations() != null) {
				Iterator<SRelation<SNode, SNode>> relIt = graph.getRelations().iterator();
				while (relIt.hasNext()) {
					SRelation<SNode, SNode> rel = relIt.next();
					writeRelation(xml, rel, nodePositions, null);
				}
			}
			if (isPrettyPrint) {
				xml.writeCharacters("\n");
				xml.writeCharacters("\t");
			}
			xml.writeEndElement();
		} catch (XMLStreamException e) {
			throw new SaltResourceException(
					"Cannot store salt project to file '" + getLocationStr() + "'. " + e.getMessage(), e);
		} finally {
			if (!embedded) {
				if (xml != null) {
					try {
						xml.flush();
						xml.close();
					} catch (XMLStreamException e) {
						throw new SaltResourceException("Cannot store salt project to file '" + getLocationStr()
								+ "', because the opened stream is not closable. ", e);
					}
				}
			}
		}
	}

	/**
	 * Writes a document graph to the file given by {@link #getPath()}.
	 * 
	 * @param graph
	 */
	public void writeDocumentGraph(SDocumentGraph graph) {
		XMLStreamWriter xml = null;
		try (OutputStream output = new FileOutputStream(path);){
			xml = xmlFactory.createXMLStreamWriter(output, "UTF-8");

			xml.writeStartDocument("1.0");
			if (isPrettyPrint) {
				xml.writeCharacters("\n");
			}

			writeDocumentGraph(xml, graph);

			xml.writeEndDocument();
			try {
				xml.flush();
				xml.close();
			}
			catch (XMLStreamException e) {
				throw new SaltResourceException("Cannot store document graph to file '" + getLocationStr()
				+ "', because the opened XML stream is not closable. ", e);
			}
		}
		catch (XMLStreamException | IOException e) {
			throw new SaltResourceException("Cannot store document graph to file '" + getLocationStr() + "'. ", e);
		}
	}

	/**
	 * Writes a document graph to the xml stream.
	 * 
	 * @param xml
	 *            A pre-configured {@link XMLStreamWriter}
	 * @param graph
	 */
	public void writeDocumentGraph(XMLStreamWriter xml, SDocumentGraph graph) {
		try {
			xml.writeStartElement(NS_SDOCUMENTSTRUCTURE, TAG_SDOCUMENTSTRUCTURE_SDOCUMENTGRAPH,
					NS_VALUE_SDOCUMENTSTRUCTURE);
			xml.writeNamespace(NS_SDOCUMENTSTRUCTURE, NS_VALUE_SDOCUMENTSTRUCTURE);
			xml.writeNamespace(NS_XMI, NS_VALUE_XMI);
			xml.writeNamespace(NS_XSI, NS_VALUE_XSI);
			xml.writeNamespace(NS_SALTCORE, NS_VALUE_SALTCORE);

			xml.writeAttribute(NS_VALUE_XMI, ATT_XMI_VERSION, "2.0");

			// write all labels
			Iterator<Label> labelIt = graph.getLabels().iterator();
			while (labelIt.hasNext()) {
				if (isPrettyPrint) {
					xml.writeCharacters("\n");
					xml.writeCharacters("\t");
				}
				writeLabel(xml, labelIt.next());
			}

			// stores the position of a single layer in the list of layers to
			// refer them in a relation
			Map<SLayer, Integer> layerPositions = new HashMap<>();
			Iterator<SLayer> layerIt = graph.getLayers().iterator();
			Integer position = 0;
			while (layerIt.hasNext()) {
				layerPositions.put(layerIt.next(), position);
				position++;
			}

			// stores the position of a single node in the list of nodes to
			// refer them in a relation
			Map<SNode, Integer> nodePositions = new HashMap<>();

			// write all nodes
			Iterator<SNode> nodeIt = graph.getNodes().iterator();
			position = 0;
			while (nodeIt.hasNext()) {
				SNode node = nodeIt.next();
				writeNode(xml, node, layerPositions);
				nodePositions.put(node, position);
				position++;
			}

			// stores the position of a single relation in the list of relations
			// to refer them later
			Map<SRelation<SNode, SNode>, Integer> relPositions = new HashMap<>();

			{
				// write all relations
				Iterator<SRelation<SNode, SNode>> relIt = graph.getRelations().iterator();
				position = 0;
				while (relIt.hasNext()) {
					SRelation<SNode, SNode> rel = relIt.next();
					writeRelation(xml, rel, nodePositions, layerPositions);
					relPositions.put(rel, position);
					position++;
				}
			}

			// write layers
			layerIt = graph.getLayers().iterator();
			while (layerIt.hasNext()) {
				writeLayer(xml, layerIt.next(), nodePositions, relPositions);
			}

			if (isPrettyPrint) {
				xml.writeCharacters("\n");
			}
			xml.writeEndElement();
		} catch (XMLStreamException e) {
			throw new SaltResourceException("Cannot store document graph to file '" + getLocationStr() + "'. ", e);
		}
	}

	/**
	 * Writes the passed label object to the passed {@link XMLStreamWriter}.
	 * 
	 * @param label
	 *            to be persist
	 * @param xml
	 *            stream to write data to
	 * @throws XMLStreamException
	 */
	public void writeLabel(XMLStreamWriter xml, Label label) throws XMLStreamException {
		// ignore when label is reference to SDocument or SDocumentGraph
		if (label != null && (label.getValue() instanceof SDocument || label.getValue() instanceof SDocumentGraph)) {
			return;
		}

		xml.writeEmptyElement(TAG_LABELS);
		if (label != null) {
			String type = "";
			if (label instanceof SAnnotation) {
				type = "saltCore:SAnnotation";
			} else if (label instanceof SMetaAnnotation) {
				type = "saltCore:SMetaAnnotation";
			} else if (label instanceof SProcessingAnnotation) {
				type = "saltCore:SProcessingAnnotation";
			} else if (label instanceof SFeature) {
				type = "saltCore:SFeature";
			} else if (label instanceof Identifier) {
				type = "saltCore:SElementId";
			}
			xml.writeAttribute(NS_VALUE_XSI, ATT_XSI_TYPE, type);

			if (label.getNamespace() != null && !label.getNamespace().isEmpty()) {
				if (SaltUtil.FEAT_SDATA.equals(label.getName())) {
					xml.writeAttribute(ATT_NAMESPACE, "saltCommon");
				} else {
					xml.writeAttribute(ATT_NAMESPACE, label.getNamespace());
				}
			}
			if (label.getName() != null && !label.getName().isEmpty()) {
				xml.writeAttribute(ATT_NAME, label.getName());
			}
			if (label.getValue() != null) {
				xml.writeAttribute(ATT_VALUE, marshallValue(label.getValue()));
			}
		}
	}

	/**
	 * Serializes an object as String. If the passed object is
	 * <ul>
	 * <li>{@link String} - it is prefixed with "T::"</li>
	 * <li>{@link Boolean} - it is prefixed with "B::"</li>
	 * <li>{@link Integer} - it is prefixed with "N::"</li>
	 * <li>{@link Integer} - it is prefixed with "L::"</li>
	 * <li>{@link Float} - it is prefixed with "F::"</li>
	 * <li>{@link URI} - it is prefixed with "U::"</li>
	 * </ul>
	 * 
	 * @param value
	 * @return
	 */
	public String marshallValue(Object value) {
		String retVal = null;
		if (value == null) {
		} else if (value instanceof String) {
			retVal = "T::" + (String) value;
		} else if (value instanceof Boolean) {
			retVal = "B::" + value.toString();
		} else if (value instanceof Integer) {
			retVal = "N::" + value.toString();
		} else if (value instanceof Long) {
			retVal = "N::" + value.toString();
		} else if (value instanceof Double) {
			retVal = "F::" + value.toString();
		} else if (value instanceof Float) {
			retVal = "F::" + value.toString();
		} else if (value instanceof URI) {
			retVal = "U::" + value.toString();
		} else if (value instanceof Serializable) {
			byte[] rawBytes = SerializationUtils.serialize((Serializable) value);
			retVal = "O::" + BaseEncoding.base64().encode(rawBytes);
		}
		return (retVal);
	}

	/**
	 * Writes the passed node object to the passed {@link XMLStreamWriter}.
	 * 
	 * @param node
	 *            to be persist
	 * @param xml
	 *            stream to write data to
	 * @param layerPositions
	 * @throws XMLStreamException
	 */
	public void writeNode(XMLStreamWriter xml, Node node, Map<? extends Layer, Integer> layerPositions)
			throws XMLStreamException {
		if (isPrettyPrint) {
			xml.writeCharacters("\n");
			xml.writeCharacters("\t");
		}
		xml.writeStartElement(TAG_NODES);
		String type = "";
		// write type as attribute
		if (node instanceof STextualDS) {
			type = TYPE_STEXTUALDS;
		} else if (node instanceof STimeline) {
			type = TYPE_STIMELINE;
		} else if (node instanceof SMedialDS) {
			type = TYPE_SAUDIODS;
		} else if (node instanceof SToken) {
			type = TYPE_STOKEN;
		} else if (node instanceof SSpan) {
			type = TYPE_SSPAN;
		} else if (node instanceof SStructure) {
			type = TYPE_SSTRUCTURE;
		} else if (node instanceof SDocument) {
			type = TYPE_SDOCUMENT;
		} else if (node instanceof SCorpus) {
			type = TYPE_SCORPUS;
		}
		xml.writeAttribute(NS_VALUE_XSI, ATT_XSI_TYPE, type);

		// write layers
		if (node.getLayers().size() > 0) {
			StringBuilder layerAtt = new StringBuilder();
			Iterator<? extends Layer> layerIt = node.getLayers().iterator();
			boolean isFirst = true;
			while (layerIt.hasNext()) {
				if (!isFirst) {
					layerAtt.append(" ");
				}
				isFirst = false;
				layerAtt.append("/");
				if (writtenRootObjects != null) {
					layerAtt.append(writtenRootObjects.size());
				}
				layerAtt.append("/@layers.");
				layerAtt.append(layerPositions.get(layerIt.next()));
			}
			xml.writeAttribute(ATT_LAYERS, layerAtt.toString());
		}

		// write all labels
		Iterator<Label> labelIt = node.getLabels().iterator();
		while (labelIt.hasNext()) {
			if (isPrettyPrint) {
				xml.writeCharacters("\n");
				xml.writeCharacters("\t");
				xml.writeCharacters("\t");
			}
			writeLabel(xml, labelIt.next());
		}
		if (isPrettyPrint) {
			xml.writeCharacters("\n");
			xml.writeCharacters("\t");
		}
		xml.writeEndElement();
	}

	/**
	 * Writes the passed relation object to the passed {@link XMLStreamWriter}.
	 * 
	 * @param relation
	 *            to be persist
	 * @param xml
	 *            stream to write data to
	 * @param nodePositions
	 *            a map containing all positions of nodes in the list of nodes
	 * @param layerPositions
	 * @throws XMLStreamException
	 */
	public void writeRelation(XMLStreamWriter xml, Relation relation, Map<? extends Node, Integer> nodePositions,
			Map<? extends Layer, Integer> layerPositions) throws XMLStreamException {
		if (isPrettyPrint) {
			xml.writeCharacters("\n");
			xml.writeCharacters("\t");
		}
		xml.writeStartElement(TAG_EDGES);

		// write type
		String type = "";
		if (relation instanceof STextualRelation) {
			type = TYPE_STEXTUAL_RELATION;
		} else if (relation instanceof STimelineRelation) {
			type = TYPE_STIMELINE_RELATION;
		} else if (relation instanceof SMedialRelation) {
			type = TYPE_SAUDIO_RELATION;
		} else if (relation instanceof SSpanningRelation) {
			type = TYPE_SSPANNING_RELATION;
		} else if (relation instanceof SDominanceRelation) {
			type = TYPE_SDOMINANCE_RELATION;
		} else if (relation instanceof SPointingRelation) {
			type = TYPE_SPOINTING_RELATION;
		} else if (relation instanceof SOrderRelation) {
			type = TYPE_SORDER_RELATION;
		} else if (relation instanceof SCorpusRelation) {
			type = TYPE_SCORPUS_RELATION;
		} else if (relation instanceof SCorpusDocumentRelation) {
			type = TYPE_SCORPUS_DOCUMENT_RELATION;
		}
		xml.writeAttribute(NS_VALUE_XSI, ATT_XSI_TYPE, type);
		int sourcePos = nodePositions.get(relation.getSource());
		int targetPos = nodePositions.get(relation.getTarget());
		if (writtenRootObjects == null) {
			// write shorcut notation if there is only one root object in the
			// file
			xml.writeAttribute(ATT_SOURCE, "//@nodes." + sourcePos);
			xml.writeAttribute(ATT_TARGET, "//@nodes." + targetPos);
		} else {
			// write full notation when there are multiple root objects in the
			// file
			int rootIndex = writtenRootObjects.size();
			xml.writeAttribute(ATT_SOURCE, "/" + rootIndex + "/@nodes." + sourcePos);
			xml.writeAttribute(ATT_TARGET, "/" + rootIndex + "/@nodes." + targetPos);
		}

		// write layers
		if (relation.getLayers().size() > 0) {
			StringBuilder layerAtt = new StringBuilder();
			Iterator<Layer> layerIt = relation.getLayers().iterator();
			boolean isFirst = true;
			while (layerIt.hasNext()) {
				if (!isFirst) {
					layerAtt.append(" ");
				}
				isFirst = false;
				layerAtt.append("/");
				if (writtenRootObjects != null) {
					// write full notation when there are multiple root objects
					// in the file
					layerAtt.append(writtenRootObjects.size());
				}
				layerAtt.append("/@layers.");
				layerAtt.append(layerPositions.get(layerIt.next()));
			}
			xml.writeAttribute(ATT_LAYERS, layerAtt.toString());
		}

		// write all labels
		Iterator<Label> labelIt = relation.getLabels().iterator();
		while (labelIt.hasNext()) {
			if (isPrettyPrint) {
				xml.writeCharacters("\n");
				xml.writeCharacters("\t");
				xml.writeCharacters("\t");
			}
			writeLabel(xml, labelIt.next());
		}
		if (isPrettyPrint) {
			xml.writeCharacters("\n");
			xml.writeCharacters("\t");
		}
		xml.writeEndElement();
	}

	/**
	 * Writes the passed relation object to the passed {@link XMLStreamWriter}.
	 * 
	 * @param layer
	 * @param xml
	 *            stream to write data to
	 * @param nodePositions
	 *            a map containing all positions of a single node in the list of
	 *            nodes
	 * @param relPositions
	 *            a map containing all positions of a single relation in the
	 *            list of relations
	 * @throws XMLStreamException
	 */
	public void writeLayer(XMLStreamWriter xml, Layer layer, Map<SNode, Integer> nodePositions,
			Map<SRelation<SNode, SNode>, Integer> relPositions) throws XMLStreamException {
		if (isPrettyPrint) {
			xml.writeCharacters("\n");
			xml.writeCharacters("\t");
		}
		xml.writeStartElement(TAG_LAYERS);
		// write type
		xml.writeAttribute(NS_VALUE_XSI, ATT_XSI_TYPE, "saltCore:SLayer");

		// write nodes
		if (layer.getNodes().size() > 0) {
			StringBuilder nodeAtt = new StringBuilder();
			Iterator<SNode> nodeIt = layer.getNodes().iterator();
			boolean isFirst = true;
			while (nodeIt.hasNext()) {
				if (!isFirst) {
					nodeAtt.append(" ");
				}
				isFirst = false;
				nodeAtt.append("/");
				if (writtenRootObjects != null) {
					// write full notation when there are multiple root objects
					// in the file
					nodeAtt.append(writtenRootObjects.size());
				}
				nodeAtt.append("/@nodes.");
				nodeAtt.append(nodePositions.get(nodeIt.next()));
			}
			xml.writeAttribute(ATT_NODES, nodeAtt.toString());
		}

		// write relations
		if (layer.getRelations().size() > 0) {
			StringBuilder relAtt = new StringBuilder();
			Iterator<SRelation<SNode, SNode>> relIt = layer.getRelations().iterator();
			boolean isFirst = true;
			while (relIt.hasNext()) {
				if (!isFirst) {
					relAtt.append(" ");
				}
				isFirst = false;
				relAtt.append("//@edges.");
				relAtt.append(relPositions.get(relIt.next()));
			}
			xml.writeAttribute(ATT_EDGES, relAtt.toString());
		}

		// write all labels
		Iterator<Label> labelIt = layer.getLabels().iterator();
		while (labelIt.hasNext()) {
			if (isPrettyPrint) {
				xml.writeCharacters("\n");
				xml.writeCharacters("\t");
				xml.writeCharacters("\t");
			}
			writeLabel(xml, labelIt.next());
		}
		if (isPrettyPrint) {
			xml.writeCharacters("\n");
			xml.writeCharacters("\t");
		}
		xml.writeEndElement();
	}

	/**
	 * Writes an Salt XMI header to the {@link XMLStreamWriter}. Salt XMI has a
	 * certain header structure (including the namespaces). This helper function
	 * writes this header to an existing {@link XMLStreamWriter}.
	 * 
	 * @param xml
	 * @throws XMLStreamException
	 */
	public void writeXMIRootElement(XMLStreamWriter xml) throws XMLStreamException {
		xml.writeStartElement(NS_XMI, "XMI", NS_VALUE_XMI);
		xml.writeNamespace(NS_SDOCUMENTSTRUCTURE, NS_VALUE_SDOCUMENTSTRUCTURE);
		xml.writeNamespace(NS_XMI, NS_VALUE_XMI);
		xml.writeNamespace(NS_XSI, NS_VALUE_XSI);
		xml.writeNamespace(NS_SALTCORE, NS_VALUE_SALTCORE);
		xml.writeAttribute(NS_VALUE_XMI, ATT_XMI_VERSION, "2.0");
		if (isPrettyPrint) {
			xml.writeCharacters("\n");
		}
	}
}
