package de.hu_berlin.u.saltnpepper.salt.util.internal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.google.common.io.BaseEncoding;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.emf.common.util.URI;

import de.hu_berlin.u.saltnpepper.graph.Identifier;
import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.graph.Layer;
import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.graph.Relation;
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

public class SaltXML10Writer {
	/** constant to address the xml-namespace prefix'saltCore'. **/
	public static final String NS_SALTCORE = "saltCore";
	/** constant to address the xml-namespace 'saltCore'. **/
	public static final String NS_VALUE_SALTCORE = "saltCore";
	/** constant to address the xml-namespace prefix'sDocumentStructure'. **/
	public static final String NS_SDOCUMENTSTRUCTURE = "sDocumentStructure";
	/** constant to address the xml-namespace 'sDocumentStructure'. **/
	public static final String NS_VALUE_SDOCUMENTSTRUCTURE = "sDocumentStructure";
	/** constant to address the xml-namespace prefix'xmi'. **/
	public static final String NS_XMI = "xmi";
	/** constant to address the xml-namespace 'http://www.omg.org/XMI'. **/
	public static final String NS_VALUE_XMI = "http://www.omg.org/XMI";
	/** constant to address the xml-namespace prefix'xsi'. **/
	public static final String NS_XSI = "xsi";
	/**
	 * constant to address the xml-namespace
	 * 'http://www.w3.org/2001/XMLSchema-instance'.
	 **/
	public static final String NS_VALUE_XSI = "http://www.w3.org/2001/XMLSchema-instance";

	/** constant to address the xml-element 'edges'. **/
	public static final String TAG_EDGES = "edges";
	/** constant to address the xml-element 'nodes'. **/
	public static final String TAG_NODES = "nodes";
	/** constant to address the xml-element 'sDocumentStructure:SDocumentGraph'. **/
	public static final String TAG_SDOCUMENTSTRUCTURE_SDOCUMENTGRAPH = "SDocumentGraph";
	/** constant to address the xml-element 'layers'. **/
	public static final String TAG_LAYERS = "layers";
	/** constant to address the xml-element 'labels'. **/
	public static final String TAG_LABELS = "labels";
	/** constant to address the xml-element 'sDocument'. **/
	public static final String TAG_SDOCUMENT = "sDocument";

	/** constant to address the xml-attribute 'edges'. **/
	public static final String ATT_EDGES = "edges";
	/** constant to address the xml-attribute 'source'. **/
	public static final String ATT_SOURCE = "source";
	/** constant to address the xml-attribute 'nodes'. **/
	public static final String ATT_NODES = "nodes";
	/** constant to address the xml-attribute 'layers'. **/
	public static final String ATT_LAYERS = "layers";
	/** constant to address the xml-attribute 'name'. **/
	public static final String ATT_NAME = "name";
	/** constant to address the xml-attribute 'target'. **/
	public static final String ATT_TARGET = "target";
	/** constant to address the xml-attribute 'value'. **/
	public static final String ATT_VALUE = "value";
	/** constant to address the xml-attribute 'xsi:type'. **/
	public static final String ATT_XSI_TYPE = "type";
	/** constant to address the xml-attribute 'href'. **/
	public static final String ATT_HREF = "href";
	/** constant to address the xml-attribute 'namespace'. **/
	public static final String ATT_NAMESPACE = "namespace";
	/** constant to address the xml-attribute 'xmi:version'. **/
	public static final String ATT_XMI_VERSION = "version";

	public SaltXML10Writer(File path) {
		this.path = path;
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
			// to
			// refer them later
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
		} catch (Exception e) {
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
		//ignore when label is reference to SDocument
		if (label!= null && label.getValue() instanceof SDocument){
			return;
		}
		
		xml.writeEmptyElement(TAG_LABELS);
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
			if (SaltUtil.FEAT_SDATA.equals(label.getName())){
				xml.writeAttribute(ATT_NAMESPACE, "saltCommon");
			}else{
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
	
	/**
	 * Serializes an object as String. If the passed object is 
	 * <ul>
	 * <li>{@link String} - it is prefixed with "T::"</li>
	 * <li>{@link Boolean} - it is prefixed with "B::"</li>
	 * <li>{@link Integer} - it is prefixed with "N::"</li>
	 * <li>{@link Integer} - it is prefixed with "L::"</li>
	 * <li>{@link Float} - it is prefixed with "F::"</li>
	 *  <li>{@link URI} - it is prefixed with "U::"</li>
	 * </ul>
	 */
	public String marshallValue(Object value) {
		String retVal= null;
		if (value== null){
		}else if(value instanceof String){
			retVal= "T::"+StringEscapeUtils.escapeXml11((String)value);
		}else if(value instanceof Boolean){
			retVal="B::"+value.toString();
		}else if(value instanceof Integer){
			retVal="N::"+value.toString();
		}else if(value instanceof Long){
			retVal="N::"+value.toString();
		}else if(value instanceof Double){
			retVal="F::"+value.toString();
		}else if(value instanceof Float){
			retVal="F::"+value.toString();
		}else if (value instanceof URI){
			retVal= "U::"+ StringEscapeUtils.escapeXml11(value.toString());
		} else if(value instanceof Serializable) {
			byte[] rawBytes = SerializationUtils.serialize((Serializable) value);
			retVal= "O::" + BaseEncoding.base64().encode(rawBytes);
		}
		return(retVal);
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
			type = "sDocumentStructure:STextualDS";
		} else if (node instanceof STimeline) {
			type = "sDocumentStructure:STimeline";
		} else if (node instanceof SMedialDS) {
			type = "sDocumentStructure:SAudioDataSource";
		} else if (node instanceof SToken) {
			type = "sDocumentStructure:SToken";
		} else if (node instanceof SSpan) {
			type = "sDocumentStructure:SSpan";
		} else if (node instanceof SStructure) {
			type = "sDocumentStructure:SStructure";
		}
		xml.writeAttribute(NS_VALUE_XSI, ATT_XSI_TYPE, type);

		// write layers
		if (node.getLayers().size() > 0) {
			StringBuilder layerAtt = new StringBuilder();
			Iterator<Layer> layerIt = node.getLayers().iterator();
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
			type = "sDocumentStructure:STextualRelation";
		} else if (relation instanceof STimelineRelation) {
			type = "sDocumentStructure:STimelineRelation";
		} else if (relation instanceof SMedialRelation) {
			type = "sDocumentStructure:SAudioRelation";
		} else if (relation instanceof SSpanningRelation) {
			type = "sDocumentStructure:SSpanningRelation";
		} else if (relation instanceof SDominanceRelation) {
			type = "sDocumentStructure:SDominanceRelation";
		} else if (relation instanceof SPointingRelation) {
			type = "sDocumentStructure:SPointingRelation";
		} else if (relation instanceof SOrderRelation) {
			type = "sDocumentStructure:SOrderRelation";
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
