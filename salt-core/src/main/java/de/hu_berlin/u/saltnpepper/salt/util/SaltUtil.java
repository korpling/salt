package de.hu_berlin.u.saltnpepper.salt.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.eclipse.emf.common.util.URI;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.salt.common.SaltProject;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SCorpusGraph;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SDocument;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.core.SFeature;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltException;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltResourceException;
import de.hu_berlin.u.saltnpepper.salt.saltCommon.semantics.SCatAnnotation;
import de.hu_berlin.u.saltnpepper.salt.saltCommon.semantics.SLemmaAnnotation;
import de.hu_berlin.u.saltnpepper.salt.saltCommon.semantics.SPOSAnnotation;
import de.hu_berlin.u.saltnpepper.salt.saltCommon.semantics.SSentenceAnnotation;
import de.hu_berlin.u.saltnpepper.salt.saltCommon.semantics.STypeAnnotation;
import de.hu_berlin.u.saltnpepper.salt.saltCommon.semantics.SWordAnnotation;
import de.hu_berlin.u.saltnpepper.salt.util.internal.SaltXML10Writer;
import de.hu_berlin.u.saltnpepper.salt.util.internal.SaltXMLHandler;

/**
 * This class contains a set of helpful methods.
 * 
 * @author florian
 *
 */
public class SaltUtil {

	// ===================================> common Salt stuff
	/** The ending of a Salt XML file. **/
	public static final String FILE_ENDING_SALT_XML = "salt";
	/**
	 * Default name of the saltProject file.
	 */
	public static final String FILE_SALT_PROJECT = "saltProject" + "." + FILE_ENDING_SALT_XML;

	/**
	 * default name for of derived namespace-attribute
	 */
	public static final String SALT_NAMESPACE = "salt";
	/**
	 * Separator between namespace and name: qname= NAMESPACE
	 * {@value #NAMESPACE_SEPERATOR} NAME.
	 */
	public static final String NAMESPACE_SEPERATOR = "::";
	/**
	 * A NULL value as String.
	 */
	public static final String SALT_NULL_VALUE = SaltUtil.SALT_NAMESPACE + SaltUtil.NAMESPACE_SEPERATOR + "NULL";
	// ===================================< common Salt stuff

	// ======================================> index names
	/** name of index for node-types */
	public static final String IDX_NODETYPE = "idx_sNodeType";
	/** name of index for relation-types */
	public static final String IDX_RELATIONTYPE = "idx_sRelationType";
	/** name of index for relating ids and nodes */
	public static final String IDX_ID_NODES = "idx_id_nodes";
	/** name of index for relating ids and relations */
	public static final String IDX_ID_RELATIONS = "idx_id_relation";
	/** name of index for relating ids and layers */
	public static final String IDX_ID_LAYER = "idx_id_layer";
	/** name of index for relating node ids and outgoing relations */
	public static final String IDX_OUT_RELATIONS = "idx_out_relations";
	/** name of index for relating node ids and incoming relations */
	public static final String IDX_IN_RELATIONS = "idx_in_relations";
	// ======================================< index names

	// ======================================> keywords for features
	/**
	 * Name of {@link Label} to store the identifier of a node, relation, graph
	 * or layer.
	 */
	public static final String LABEL_ID = "id";
	/**
	 * Qualified name of {@link Label} to store the identifier of a node,
	 * relation, graph or layer.
	 */
	public static final String LABEL_ID_QNAME = SALT_NAMESPACE + NAMESPACE_SEPERATOR + LABEL_ID;
	/**
	 * Name for {@link SFeature} to store the type of a labels value.
	 */
	public static final String FEAT_VALUE_DATATYPE = "SVAL_TYPE";
	/**
	 * Name for {@link SFeature} to store the name of a node, relation, graph or
	 * label.
	 */
	public static final String FEAT_NAME = "SNAME";
	/**
	 * Qualified name for {@link SFeature} to store the name of a node,
	 * relation, graph or label.
	 */
	public static final String FEAT_NAME_QNAME = SALT_NAMESPACE + NAMESPACE_SEPERATOR + FEAT_NAME;
	/**
	 * Name for {@link SFeature} to store the type of a relation.
	 */
	public static final String FEAT_TYPE = "STYPE";
	/**
	 * Qualified name for {@link SFeature} to store the type of a relation.
	 */
	public static final String FEAT_TYPE_QNAME = SALT_NAMESPACE + NAMESPACE_SEPERATOR + FEAT_TYPE;

	/**
	 * Name for {@link SFeature} to store the {@link SDocumentGraph} in a
	 * {@link SDocument} object
	 */
	public static final String FEAT_SDOCUMENT_GRAPH = "SDOCUMENT_GRAPH";
	/**
	 * Qualified name for {@link SFeature} to store the {@link SDocumentGraph}
	 * in a {@link SDocument} object
	 */
	public static final String FEAT_SDOCUMENT_GRAPH_QNAME = SALT_NAMESPACE + NAMESPACE_SEPERATOR + "SDOCUMENT_GRAPH";
	/**
	 * Name for {@link SFeature} to store the {@link SDocument} corresponding to
	 * a {@link SDocumentGraph} object
	 */
	public static final String FEAT_SDOCUMENT = "SDOCUMENT";
	/**
	 * Qualified name for {@link SFeature} to store the {@link SDocument}
	 * corresponding to a {@link SDocumentGraph} object
	 */
	public static final String FEAT_SDOCUMENT_QNAME = SALT_NAMESPACE + NAMESPACE_SEPERATOR + "SDOCUMENT";
	/**
	 * Name for {@link SFeature} to store the uri reference of a
	 * {@link SDocumentGraph} in a {@link SDocument}
	 */
	public static final String FEAT_SDOCUMENT_GRAPH_LOCATION = "SDOCUMENT_GRAPH_LOCATION";
	/**
	 * Qualified name name for {@link SFeature} to store the uri reference of a
	 * {@link SDocumentGraph} in a {@link SDocument}
	 */
	public static final String FEAT_SDOCUMENT_GRAPH_LOCATION_QNAME = SALT_NAMESPACE + NAMESPACE_SEPERATOR + FEAT_SDOCUMENT_GRAPH_LOCATION;
	/**
	 * The name of the {@link SFeature} for the reference to an audio file.
	 */
	public static final String FEAT_SMEDIA_REFERNCE = "SAUDIO_REFERENCE";
	/**
	 * The qualified name of the name of the {@link SFeature} for the reference
	 * to an audio file.
	 */
	public static final String FEAT_SMEDIA_REFERNCE_QNAME = SALT_NAMESPACE + NAMESPACE_SEPERATOR + FEAT_SMEDIA_REFERNCE;

	/** The name of the {@link SFeature} for the start value. */
	public static final String FEAT_SSTART = "SSTART";
	/**
	 * The qualified name of the name of the {@link SFeature} for the start
	 * value.
	 */
	public static final String FEAT_SSTART_QNAME = SALT_NAMESPACE + NAMESPACE_SEPERATOR + FEAT_SSTART;
	/** The name of the {@link SFeature} for the end value. */
	public static final String FEAT_SEND = "SEND";
	/**
	 * The qualified name of the name of the {@link SFeature} for the end value.
	 */
	public static final String FEAT_SEND_QNAME = SALT_NAMESPACE + NAMESPACE_SEPERATOR + FEAT_SEND;
	/**
	 * The name of the {@link SFeature} for the data label for textual sources,
	 * etc..
	 */
	public static final String FEAT_SDATA = "SDATA";

	/**
	 * Qualified name name of the {@link SFeature} for the data label for
	 * textual sources, etc..
	 */
	public static final String FEAT_SDATA_QNAME = SALT_NAMESPACE + NAMESPACE_SEPERATOR + FEAT_SDATA;

	// ======================================< keywords for features
	// ======================================> keywords for semantics
	/** name for {@link SCatAnnotation} **/
	public static final String SEMANTICS_CAT = "cat";
	/** name for {@link SPOSAnnotation} **/
	public static final String SEMANTICS_POS = "pos";
	/** name for {@link SLemmaAnnotation} **/
	public static final String SEMANTICS_LEMMA = "lemma";
	/** name for {@link SSentenceAnnotation} **/
	public static final String SEMANTICS_SENTENCE = "sentence";
	/** value for {@link STypeAnnotation} **/
	public static final String SEMANTICS_TYPE = "type";
	/** value for {@link SWordAnnotation} **/
	public static final String SEMANTICS_WORD = "word";
	/** name for {@link SWordAnnotation} and {@link SSentenceAnnotation} **/
	public static final String SEMANTICS_UNIT = "unit";

	// ======================================< keywords for semantics

	/**
	 * Returns the concatenation of a labels namespace and a labels name as a
	 * qualified name: qname= NAMESPACE {@value #NAMESPACE_SEPERATOR} NAME.
	 * 
	 * @param namespace
	 *            the namespace of a label
	 * @param name
	 *            the name of a label
	 */
	public static String createQName(String namespace, String name) {
		if (namespace == null || namespace.isEmpty()) {
			return name;
		} else if (name == null || name.isEmpty()) {
			return namespace + Label.NS_SEPERATOR;
		} else {
			return namespace + Label.NS_SEPERATOR + name;
		}
	}

	/**
	 * Splits the passed qName into a namespace and a name.
	 * 
	 * @return {@link Pair#getLeft()} is the namespace, whereas
	 *         {@link Pair#getRight()} is the name
	 */
	public static Pair<String, String> splitQName(String qName) {
		Pair<String, String> retVal = null;
		if ((qName != null) && (!qName.isEmpty())) {
			String[] fullName = qName.split(NAMESPACE_SEPERATOR);
			StringBuffer ns = new StringBuffer();
			String name = null;
			for (int i = 0; i < fullName.length; i++) {
				// last part of fullname reached
				if (i == fullName.length - 1)
					name = fullName[i];
				else {
					if ((ns == null) || (ns.toString().isEmpty()))
						ns.append(fullName[i]);
					else {
						ns.append(NAMESPACE_SEPERATOR);
						ns.append(fullName[i]);
					}
				}
			}
			if ((ns.length() != 0) && (name.length() != 0)) {
				retVal = new ImmutablePair<String, String>(ns.toString(), name.toString());
			} else if (ns.length() != 0) {
				retVal = new ImmutablePair<String, String>(ns.toString(), null);
			} else if (name.length() != 0) {
				retVal = new ImmutablePair<String, String>(null, name.toString());
			}
		}
		return (retVal);
	}

	/**
	 * Loads an object coming from a SaltXML (.{@link #FILE_ENDING_SALT_XML})
	 * and returns it.
	 * 
	 * @param objectURI
	 *            {@link URI} to SaltXML file containing the object
	 * @return loaded object
	 */
	public static Object load(URI location) {
		if (location == null) {
			throw new SaltResourceException("Cannot load Salt object, because the given uri is null.");
		}
		File objectFile = new File((location.toFileString() == null) ? location.toString() : location.toFileString());
		if (!objectFile.exists()) {
			throw new SaltResourceException("Cannot load Salt object, because the file '" + objectFile + "' does not exist.");
		}

		SAXParser parser;
		XMLReader xmlReader;
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SaltXMLHandler contentHandler = new SaltXMLHandler();

		try {
			parser = factory.newSAXParser();
			xmlReader = parser.getXMLReader();
			xmlReader.setContentHandler(contentHandler);
		} catch (ParserConfigurationException e) {
			throw new SaltResourceException("Cannot load Salt object from file '" + objectFile.getAbsolutePath() + "'.", e);
		} catch (Exception e) {
			throw new SaltResourceException("Cannot load Salt object from file '" + objectFile.getAbsolutePath() + "'.", e);
		}
		try {
			InputStream inputStream = new FileInputStream(objectFile);
			Reader reader = new InputStreamReader(inputStream, "UTF-8");
			InputSource is = new InputSource(reader);
			is.setEncoding("UTF-8");
			xmlReader.parse(is);
		} catch (SAXException e) {
			try {
				parser = factory.newSAXParser();
				xmlReader = parser.getXMLReader();
				xmlReader.setContentHandler(contentHandler);
				xmlReader.parse(objectFile.getAbsolutePath());
			} catch (Exception e1) {
				throw new SaltResourceException("Cannot load Salt object from file '" + objectFile.getAbsolutePath() + "'.", e1);
			}
		} catch (Exception e) {
			if (e instanceof SaltException) {
				throw (SaltException) e;
			} else {
				throw new SaltResourceException("Cannot load Salt object from file'" + objectFile + "', because of a nested exception. ", e);
			}
		}
		return ((Object) contentHandler.getSaltObject());
	}

	/**
	 * Loads a SaltProject from given uri and returns it as object structure.
	 * 
	 * @param location
	 *            location to the Salt project file
	 * @return returns a saltProject, which is filled with data coming from
	 *         corpus in uri
	 */
	public static SaltProject loadSaltProject(URI location) {
		if (!location.toFileString().endsWith(FILE_ENDING_SALT_XML)) {
			// looks weird, but is necessary in case of uri ends with /
			if (location.toString().endsWith("/")) {
				location = location.trimSegments(1);
			}
			location = location.appendSegment(FILE_SALT_PROJECT);
		}

		SaltProject saltProject = null;
		if (location == null) {
			throw new SaltResourceException("Can not load SaltProject, because the given uri is null.");
		}
		File saltProjectPath = null;
		try {
			saltProjectPath = new File(location.toFileString());
		} catch (Exception e) {
			throw new SaltResourceException("Can not load SaltProject.", e);
		}
		if (saltProjectPath.exists()) {
			throw new SaltResourceException("Can not load SaltProject, because path '" + saltProjectPath + "' does not exist.");
		}
		if (saltProjectPath.isDirectory()) {
			throw new SaltResourceException("Can not load SaltProject, because path '" + saltProjectPath + "' is not a directory.");
		}

		return (saltProject);
	}

	/**
	 * Loads the given SaltXML file (.{@value #FILE_ENDING_SALT_XML}) into this
	 * object. If the given SaltXML file does not contain a {@link SCorpusGraph}
	 * object persisting, an exception will be thrown. If the SaltXML file
	 * contains persistings for more than one {@link SCorpusGraph} object, the
	 * first one will be load (analog to {@link #load(URI, 0)}).
	 * 
	 * @param location
	 *            the {@link URI} to locate the SaltXML file
	 */
	public static SCorpusGraph loadCorpusGraph(URI location) {
		return (loadCorpusGraph(location, 0));
	}

	/**
	 * Loads the given SaltXML file (.{@value #FILE_ENDING_SALT_XML}) into this
	 * object. If the given SaltXML file does not contain a {@link SCorpusGraph}
	 * object persisting, an exception will be thrown. The parameter
	 * <code>numOfSCorpusGraph</code> determines which object shall be load, in
	 * case of the given SaltXML file contains more than one persisting of
	 * {@link SCorpusGraph} objects.
	 * 
	 * @param location
	 *            the {@link URI} to locate the SaltXML file
	 * @param numOfCorpusGraph
	 *            number of graph to be load, note that the list of graphs
	 *            starts with 0
	 */
	public static SCorpusGraph loadCorpusGraph(URI location, Integer numOfCorpusGraph) {
		if (location == null) {
			throw new SaltResourceException("Cannot load '" + SCorpusGraph.class.getSimpleName() + "' object, because the passed uri is empty. ");
		}
		SCorpusGraph retVal = null;

		if (!location.toFileString().endsWith("." + FILE_ENDING_SALT_XML)) {
			// looks weird, but is necessary in case of uri ends with /
			if (location.toString().endsWith("/")) {
				location = location.trimSegments(1);
			}
			location = location.appendSegment(FILE_SALT_PROJECT);
		}

		Object obj = load(location);
		if (obj instanceof SCorpusGraph) {
			retVal = (SCorpusGraph) obj;
		} else if (obj instanceof SaltProject) {
			if ((((SaltProject) obj).getCorpusGraphs() != null) && (((SaltProject) obj).getCorpusGraphs().size() >= numOfCorpusGraph)) {
				retVal = ((SaltProject) obj).getCorpusGraphs().get(numOfCorpusGraph);
			}
		}
		if (retVal == null) {
			throw new SaltResourceException("No '" + SCorpusGraph.class.getName() + "' object was found in resource '" + location + "'.");
		}
		// {// TODO all this can be removed, when feature request Feature #117
		// is
		// // done
		// SaltLoadingTraverser loadingTraverser = new SaltLoadingTraverser();
		// loadingTraverser.saltProjectPath =
		// sCorpusGraphUri.toFileString().replace(SaltFactory.FILE_SALT_PROJECT,
		// "");
		// EList<Node> startNodes = (EList<Node>) (EList<? extends Node>)
		// retVal.getSRoots();
		// if ((startNodes != null) && (startNodes.size() > 0)) {
		// retVal.traverse(startNodes, GRAPH_TRAVERSE_TYPE.TOP_DOWN_DEPTH_FIRST,
		// "SCOPRUS_GRAPH_LOADING", loadingTraverser);
		// }
		// }// TODO all this can be removed, when feature request Feature #117
		// is
		// done
		return (retVal);

	}

	/**
	 * Loads a {@link SDocumentGraph} object and returns it. The location of
	 * where to find the SaltXML containing the {@link SDocumentGraph} object is
	 * given by the passed {@link URI} object.
	 * 
	 * @param location
	 *            location of SaltXML to load {@link SDocumentGraph} object.
	 */
	public static SDocumentGraph loadDocumentGraph(URI location) {
		SDocumentGraph retVal = null;
		Object obj = load(location);
		if (obj == null) {
			throw new SaltResourceException("Cannot load the requested " + SDocumentGraph.class.getName() + ", because file located at contains no such object, the returned object was null.");
		} else if (obj instanceof SDocumentGraph) {
			retVal = (SDocumentGraph) obj;
		} else {
			throw new SaltResourceException("Cannot load the requested " + SDocumentGraph.class.getName() + ", because file located at contains no such object. It contains: " + obj.getClass());
		}
		return (retVal);

	}

	/**
	 * Persists the given {@link SDocumentGraph} object as SaltXML file at the
	 * location given by the passed {@link URI} object. The {@link URI} of where
	 * the {@link SDocumentGraph} is stored as {@link SFeature} by calling
	 * {@link SDocument#setSDocumentGraphLocation(URI)}, in case of the given
	 * {@link SDocumentGraph} is contained by an {@link SDocument} object.
	 * 
	 * @param documentGraph
	 *            {@link SDocumentGraph} object to persist
	 * @param location
	 *            location of where to persist object as {@link URI}
	 */
	public static void saveDocumentGraph(SDocumentGraph documentGraph, URI location) {
		if (documentGraph != null && location != null) {
			String path = location.toFileString();
			if (path == null || path.isEmpty()) {
				path = location.toString();
			}
			File out = new File(path);
			out.getParentFile().mkdirs();

			SaltXML10Writer writer= new SaltXML10Writer(out);
			writer.writeDocumentGraph(documentGraph);
		}
	}
}
