package de.hu_berlin.u.saltnpepper.salt.util.internal.persistence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.common.util.URI;

import com.google.common.io.BaseEncoding;

import de.hu_berlin.u.saltnpepper.graph.Identifier;
import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.graph.Layer;
import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.graph.Relation;
import de.hu_berlin.u.saltnpepper.salt.common.SaltProject;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpus;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusDocumentRelation;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusGraph;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusRelation;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SDocument;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDominanceRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SMedialDS;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SMedialRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SOrderRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SPointingRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSpan;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SSpanningRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SStructure;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STextualDS;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STextualRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STimeline;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STimelineRelation;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SToken;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SFeature;
import de.hu_berlin.u.saltnpepper.salt.core.SLayer;
import de.hu_berlin.u.saltnpepper.salt.core.SMetaAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.core.SProcessingAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SRelation;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltResourceException;
import de.hu_berlin.u.saltnpepper.salt.util.SaltUtil;

public class SaltXML10Writer implements SaltXML10Dictionary {

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

	private File path = null;
	private XMLStreamWriter xml = null;
	private XMLOutputFactory xmlFactory = XMLOutputFactory.newFactory();

	/**
	 * Writes a salt project to the xml stream.
	 * 
	 * @param project
	 */
	public void writeSaltProject(SaltProject project) {
		PrintWriter output = null;
		try {
			output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF8")), false);

			xml = xmlFactory.createXMLStreamWriter(output);
			xml.writeStartDocument("1.0");
			if (isPrettyPrint) {
				xml.writeCharacters("\n");
			}
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
		} catch (XMLStreamException | UnsupportedEncodingException | FileNotFoundException e) {
			throw new SaltResourceException("Cannot store salt project to file '" + path + "'. ", e);
		} finally {
			if (xml != null) {
				try {
					xml.flush();
					xml.close();
				} catch (XMLStreamException e) {
					throw new SaltResourceException("Cannot store salt project to file '" + path + "', because the opened stream is not closable. ", e);
				}
			}
			if (output != null) {
				output.flush();
				output.close();
			}
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
		PrintWriter output = null;
		try {
			if (xml == null) {
				output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF8")), false);
				xml = xmlFactory.createXMLStreamWriter(output);
			}
			if (!embedded) {
				xml.writeStartDocument("1.0");
				if (isPrettyPrint) {
					xml.writeCharacters("\n");
					xml.writeStartElement(NS_SALTCOMMON, TAG_SCORPUSGRAPH, NS_VALUE_SALTCOMMON);
					xml.writeNamespace(NS_SCORPUSSTRUCTURE, NS_VALUE_SCORPUSSTRUCTURE);
					xml.writeNamespace(NS_XMI, NS_VALUE_XMI);
					xml.writeNamespace(NS_XSI, NS_VALUE_XSI);
					xml.writeNamespace(NS_SALTCORE, NS_VALUE_SALTCORE);
					xml.writeNamespace(NS_SALTCOMMON, NS_VALUE_SALTCOMMON);
					xml.writeAttribute(NS_VALUE_XMI, ATT_XMI_VERSION, "2.0");
				}
			} else {
				xml.writeStartElement(TAG_SCORPUSGRAPH);
			}

			// write all labels
			if (graph.getLabels() != null) {
				Iterator<Label> labelIt = graph.getLabels().iterator();
				while (labelIt.hasNext()) {
					if (isPrettyPrint) {
						xml.writeCharacters("\n");
						xml.writeCharacters("\t");
					}
					writeLable(xml, labelIt.next());
				}
			}
			// stores the position of a single node in the list of nodes to
			// refer them in a relation
			Map<SNode, Integer> nodePositions = new HashMap<>();

			// write all nodes
			if (graph.getNodes() != null) {
				Iterator<SNode> nodeIt = graph.getNodes().iterator();
				Integer position = 0;
				position = 0;
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
		} catch (XMLStreamException | UnsupportedEncodingException | FileNotFoundException e) {
			throw new SaltResourceException("Cannot store salt project to file '" + path + "'. " + e.getMessage(), e);
		} finally {
			if (!embedded) {
				if (xml != null) {
					try {
						xml.flush();
						xml.close();
					} catch (XMLStreamException e) {
						throw new SaltResourceException("Cannot store salt project to file '" + path + "', because the opened stream is not closable. ", e);
					}
				}
				if (output != null) {
					output.flush();
					output.close();
				}
			}
		}
	}

	/**
	 * Writes a document graph to the xml stream
	 * 
	 * @param graph
	 */
	public void writeDocumentGraph(SDocumentGraph graph) {
		PrintWriter output = null;
		try {
			output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF8")), false);

			xml = xmlFactory.createXMLStreamWriter(output);
			xml.writeStartDocument("1.0");
			if (isPrettyPrint) {
				xml.writeCharacters("\n");
			}
			xml.writeStartElement(NS_SDOCUMENTSTRUCTURE, TAG_SDOCUMENTSTRUCTURE_SDOCUMENTGRAPH, NS_VALUE_SDOCUMENTSTRUCTURE);
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
				writeLable(xml, labelIt.next());
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

			// write all relations
			Iterator<SRelation<SNode, SNode>> relIt = graph.getRelations().iterator();
			position = 0;
			while (relIt.hasNext()) {
				SRelation<SNode, SNode> rel = relIt.next();
				writeRelation(xml, rel, nodePositions, layerPositions);
				relPositions.put(rel, position);
				position++;
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
			xml.writeEndDocument();
		} catch (XMLStreamException | UnsupportedEncodingException | FileNotFoundException e) {
			throw new SaltResourceException("Cannot store document graph to file '" + path + "'. ", e);
		} finally {
			if (xml != null) {
				output.flush();
				output.close();
				try {
					xml.flush();
					xml.close();
				} catch (XMLStreamException e) {
					throw new SaltResourceException("Cannot store document graph to file '" + path + "', because the opened stream is not closable. ", e);
				}
			}
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
	public void writeLable(XMLStreamWriter xml, Label label) throws XMLStreamException {
		// ignore when label is reference to SDocument
		if (label != null && label.getValue() instanceof SDocument) {
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
	 */
	public String marshallValue(Object value) {
		String retVal = null;
		if (value == null) {
		} else if (value instanceof String) {
			retVal = "T::" + StringEscapeUtils.escapeXml11((String) value);
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
			retVal = "U::" + StringEscapeUtils.escapeXml11(value.toString());
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
	 * @throws XMLStreamException
	 */
	public void writeNode(XMLStreamWriter xml, Node node, Map<SLayer, Integer> layerPositions) throws XMLStreamException {
		if (isPrettyPrint) {
			xml.writeCharacters("\n");
			xml.writeCharacters("\t");
		}
		xml.writeStartElement(TAG_NODES);
		String type = "";
		// write type
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
				layerAtt.append("//@layers.");
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
			writeLable(xml, labelIt.next());
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
	 * @throws XMLStreamException
	 */
	public void writeRelation(XMLStreamWriter xml, Relation relation, Map<SNode, Integer> nodePositions, Map<SLayer, Integer> layerPositions) throws XMLStreamException {
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
		xml.writeAttribute(ATT_SOURCE, "//@nodes." + sourcePos);
		xml.writeAttribute(ATT_TARGET, "//@nodes." + targetPos);

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
				layerAtt.append("//@layers.");
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
			writeLable(xml, labelIt.next());
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
	 *            a map containing all positions of a single node in the list of
	 *            nodes
	 * @param relPositions
	 *            a map containing all positions of a single relation in the
	 *            list of relations
	 * @throws XMLStreamException
	 */
	public void writeLayer(XMLStreamWriter xml, Layer layer, Map<SNode, Integer> nodePositions, Map<SRelation<SNode, SNode>, Integer> relPositions) throws XMLStreamException {
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
				nodeAtt.append("//@nodes.");
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
				relAtt.append(nodePositions.get(relIt.next()));
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
			writeLable(xml, labelIt.next());
		}
		if (isPrettyPrint) {
			xml.writeCharacters("\n");
			xml.writeCharacters("\t");
		}
		xml.writeEndElement();
	}
}
