package de.hu_berlin.u.saltnpepper.salt.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.eclipse.emf.common.util.URI;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.salt.common.SCorpus;
import de.hu_berlin.u.saltnpepper.salt.common.SCorpusGraph;
import de.hu_berlin.u.saltnpepper.salt.common.SDocument;
import de.hu_berlin.u.saltnpepper.salt.common.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.common.SaltProject;
import de.hu_berlin.u.saltnpepper.salt.core.SFeature;
import de.hu_berlin.u.saltnpepper.salt.core.SNode;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltException;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltResourceException;
import de.hu_berlin.u.saltnpepper.salt.semantics.SCatAnnotation;
import de.hu_berlin.u.saltnpepper.salt.semantics.SLemmaAnnotation;
import de.hu_berlin.u.saltnpepper.salt.semantics.SPOSAnnotation;
import de.hu_berlin.u.saltnpepper.salt.semantics.SSentenceAnnotation;
import de.hu_berlin.u.saltnpepper.salt.semantics.STypeAnnotation;
import de.hu_berlin.u.saltnpepper.salt.semantics.SWordAnnotation;
import de.hu_berlin.u.saltnpepper.salt.util.internal.persistence.SaltXML10Handler;
import de.hu_berlin.u.saltnpepper.salt.util.internal.persistence.SaltXML10Writer;
import de.hu_berlin.u.saltnpepper.salt.util.internal.persistence.dot.SCorpusGraphDOTWriter;
import de.hu_berlin.u.saltnpepper.salt.util.internal.persistence.dot.SDocumentGraphDOTWriter;

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
	/** The ending of a dot file. **/
	public static final String FILE_ENDING_DOT = "dot";
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
	/** name of index for relating ids and nodes (inverse) */
	public static final String IDX_ID_NODES_INVERSE = "idx_id_nodes_inverse";
	/** name of index for relating ids and relations */
	public static final String IDX_ID_RELATIONS = "idx_id_relation";
	/** name of index for relating ids and relations (inverse) */
	public static final String IDX_ID_RELATIONS_INVERSE = "idx_id_relation_inverse";
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
				if (i == fullName.length - 1) {
					name = fullName[i];
				} else {
					if ((ns.toString().isEmpty())) {
						ns.append(fullName[i]);
					} else {
						ns.append(NAMESPACE_SEPERATOR);
						ns.append(fullName[i]);
					}
				}
			}
			if ((ns.length() != 0) && (name.length() != 0)) {
				retVal = new ImmutablePair<String, String>(ns.toString(), name);
			} else if (ns.length() != 0) {
				retVal = new ImmutablePair<String, String>(ns.toString(), null);
			} else if (name.length() != 0) {
				retVal = new ImmutablePair<String, String>(null, name);
			}
		}
		return (retVal);
	}

	/**
	 * Creates a Salt URI from the passed path.
	 * 
	 * @param path
	 *            path to an element
	 * @return corresponding Salt URI
	 */
	public static URI createSaltURI(String path) {
		URI uri = null;
		if (path != null && !path.isEmpty()) {
			if (path.startsWith(SALT_NAMESPACE + ":")) {
				uri = URI.createURI(path);
			} else {
				uri = URI.createURI(SALT_NAMESPACE + ":" + path);
			}
		}
		return (uri);
	}

	// ================================================> Persistence SaltXML
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
		SaltXML10Handler contentHandler = new SaltXML10Handler();

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
		if (!FILE_ENDING_SALT_XML.equals(location.fileExtension())) {
			location = location.appendSegment(FILE_SALT_PROJECT);
		}

		SaltProject saltProject = null;
		if (location == null) {
			throw new SaltResourceException("Can not load SaltProject, because the given uri is null. ");
		}
		File saltProjectFile = null;
		try {
			saltProjectFile = new File(location.toFileString());
		} catch (Exception e) {
			throw new SaltResourceException("Can not load SaltProject. ", e);
		}
		if (!saltProjectFile.exists()) {
			throw new SaltResourceException("Can not load SaltProject, because path '" + saltProjectFile + "' does not exist. ");
		}

		Object project = load(location);
		if (project instanceof SaltProject) {
			saltProject = (SaltProject) project;
		} else {
			throw new SaltResourceException("Can not load SaltProject, because the file at '" + saltProjectFile + "' does not contain a Salt project. ");
		}
		return (saltProject);
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
	 * Persists the passed {@link SDocumentGraph} object in a SaltXML file at
	 * the passed location.
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

			SaltXML10Writer writer = new SaltXML10Writer(out);
			writer.writeDocumentGraph(documentGraph);
		}
	}

	/**
	 * Persists the passed {@link SCorpusGraph} object in a SaltXML file at the
	 * passed location.
	 * 
	 * @param corpusGraph
	 *            {@link SCorpusGraph} object to persist
	 * @param location
	 *            location of where to persist object as {@link URI}
	 */
	public static void saveCorpusGraph(SCorpusGraph corpusGraph, URI location) {
		if ((corpusGraph.getDocuments() != null) && (corpusGraph.getDocuments().size() > 0)) {
			Iterator<SDocument> docs = corpusGraph.getDocuments().iterator();
			while (docs.hasNext()) {
				SDocument doc = docs.next();
				URI docURI = location;
				for (String seg : doc.getPath().segments()) {
					docURI = docURI.appendSegment(seg);
				}
				docURI = docURI.appendFileExtension(FILE_ENDING_SALT_XML);
				if (doc.getDocumentGraph() != null) {
					// store document structure
					doc.saveDocumentGraph(docURI);
				} else {
					// only store folder structure
					URI corpUri = docURI.trimFileExtension().trimSegments(1);
					String str = corpUri.toFileString();
					if (str == null || str.isEmpty()) {
						str = corpUri.toString();
					}
					File corpFile = new File(str);
					corpFile.mkdirs();
				}
			}
		}
	}

	/**
	 * Persists the passed {@link SaltProject} object in a SaltXML file at the
	 * passed location.
	 * 
	 * @param saltProject
	 *            {@link SaltProject} object to persist
	 * @param location
	 *            location of where to persist object as {@link URI}
	 */
	public static void saveSaltProject(SaltProject saltProject, URI location) {
		if (location == null) {
			throw new SaltResourceException("Cannot save SaltProject, because the given uri is null.");
		}
		URI saltProjectFolder = null;
		URI saltProjectFile = null;
		if (FILE_ENDING_SALT_XML.equals(location.fileExtension())) {
			// location is a file name
			saltProjectFile = location;
			saltProjectFolder = location.trimFileExtension().trimSegments(1);
		} else {
			// location is a folder name
			saltProjectFile = location.appendSegment(FILE_SALT_PROJECT);
			saltProjectFolder = location;
		}
		// in case the salt project folder does not exist, create it
		String str = saltProjectFolder.toFileString();
		if (str == null || str.isEmpty()) {
			str = saltProjectFolder.toString();
		}
		File folder = new File(str);
		folder.mkdirs();

		// write SaltProject to file
		SaltXML10Writer writer = new SaltXML10Writer(saltProjectFile);
		writer.writeSaltProject(saltProject);

		// write folders and document structures to file
		if ((saltProject.getCorpusGraphs() != null) && (saltProject.getCorpusGraphs().size() > 0)) {
			// store all documents if exist
			Iterator<SCorpusGraph> cGraphs = saltProject.getCorpusGraphs().iterator();
			while (cGraphs.hasNext()) {
				SCorpusGraph cGraph = cGraphs.next();
				saveCorpusGraph(cGraph, saltProjectFolder);
			}
		}
	}

	// ==================================================< Persistence SaltXML
	// ==================================================> Persistence DOT
	/**
	 * Stores a {@link SCorpusGraph} into DOT file.
	 * 
	 * @param corpusGraph
	 *            the corpus graph to be stored
	 * @param location
	 *            the location to where the corpus graph is stored
	 */
	public static void saveCorpusGraph_DOT(SCorpusGraph corpusGraph, URI location) {
		URI targetUri = null;
		if (location.fileExtension() == null) {
			if ((corpusGraph.getSaltProject() != null) && (corpusGraph.getSaltProject().getCorpusGraphs().size() > 1)) {
				Integer pos = corpusGraph.getSaltProject().getCorpusGraphs().indexOf(corpusGraph);
				targetUri = location.appendSegment(pos.toString()).appendFileExtension(SaltUtil.FILE_ENDING_DOT);
			} else {
				List<SNode> roots = corpusGraph.getRoots();
				if ((roots != null) && (!roots.isEmpty())) {
					targetUri = location.appendSegment(((SCorpus) roots.get(0)).getName()).appendFileExtension(SaltUtil.FILE_ENDING_DOT);
				} else {
					targetUri = location.appendSegment(corpusGraph.getName()).appendFileExtension(SaltUtil.FILE_ENDING_DOT);
				}
			}
		} else {
			targetUri = location;
		}
		SCorpusGraphDOTWriter writer = new SCorpusGraphDOTWriter();
		writer.setSCorpusGraph(corpusGraph);
		writer.setOutputURI(targetUri);
		writer.save();
	}

	/**
	 * Stores a {@link SDocumentGraph} into DOT file.
	 * 
	 * @param documentGraph
	 *            the document graph to be stored
	 * @param location
	 *            the location to where the document graph is stored
	 */
	public static void saveDocumentGraph_DOT(SDocumentGraph documentGraph, URI location) {
		URI targetUri = null;
		if (location.fileExtension() == null) {
			if (documentGraph.getDocument() != null) {
				targetUri = location.appendSegment(documentGraph.getDocument().getName()).appendFileExtension(SaltUtil.FILE_ENDING_DOT);
			} else {
				targetUri = location.appendSegment(documentGraph.getName()).appendFileExtension(SaltUtil.FILE_ENDING_DOT);
			}
		} else {
			targetUri = location;
		}
		SDocumentGraphDOTWriter writer = new SDocumentGraphDOTWriter();
		writer.setDocumentGraph(documentGraph);
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
	public static void save_DOT(Object saltObject, URI location) {
		if (location == null) {
			throw new SaltResourceException("Exception in storing Salt model to dot file, because no uri was given.");
		}
		if (saltObject == null) {
			throw new SaltResourceException("Exception in storing Salt model to dot file. Cannot write more than one content per file.");
		}

		if (saltObject instanceof SCorpus) {
			SCorpus sCorpus = (SCorpus) saltObject;
			if (sCorpus.getGraph() != null) {
				saltObject = sCorpus.getGraph();
			} else {
				throw new SaltResourceException("Cannot save Salt model to DOT format, because the given " + SCorpus.class.getSimpleName() + " is not part of a " + SCorpusGraph.class.getSimpleName() + " container");
			}
		} else if (saltObject instanceof SDocument) {
			SDocument sDocument = (SDocument) saltObject;
			if (sDocument.getDocumentGraph() != null) {
				saltObject = sDocument.getDocumentGraph();
			} else {
				throw new SaltResourceException("Cannot save Salt model to DOT format, because the given " + SDocument.class.getSimpleName() + " does not contain a " + SDocumentGraph.class.getSimpleName() + " content");
			}
		}

		// if content is a SDocumentGraph or SCorpusGraph, outputURI does not
		// have to be changed
		if (saltObject instanceof SCorpusGraph) {
			saveCorpusGraph_DOT((SCorpusGraph) saltObject, location);
		} else if (saltObject instanceof SDocumentGraph) {
			saveDocumentGraph_DOT((SDocumentGraph) saltObject, location);
		}
		// if it is a SaltProject, different URIs for the different components
		// of the project are needed
		else if (saltObject instanceof SaltProject) {
			Collection<SCorpusGraph> corpGraphs = Collections.synchronizedCollection(((SaltProject) saltObject).getCorpusGraphs());
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
						URI docURI = corpUri;
						for (String seg : sDocument.getPath().segments()) {
							docURI = docURI.appendSegment(seg);
						}
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
			throw new SaltResourceException("Cannot save Salt model to DOT format, because content is neither " + SCorpusGraph.class.getSimpleName() + ", " + SDocumentGraph.class.getSimpleName() + " nor " + SaltProject.class.getSimpleName() + " content. The given content is of type: '" + saltObject.getClass() + "'.");
		}
	}
	// ===================================================< Persistence DOT
}
