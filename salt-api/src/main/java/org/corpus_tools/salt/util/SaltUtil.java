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
package org.corpus_tools.salt.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.corpus_tools.salt.SaltFactory;
import org.corpus_tools.salt.common.SCorpus;
import org.corpus_tools.salt.common.SCorpusGraph;
import org.corpus_tools.salt.common.SDocument;
import org.corpus_tools.salt.common.SDocumentGraph;
import org.corpus_tools.salt.common.SaltProject;
import org.corpus_tools.salt.core.SAnnotation;
import org.corpus_tools.salt.core.SAnnotationContainer;
import org.corpus_tools.salt.core.SFeature;
import org.corpus_tools.salt.core.SLayer;
import org.corpus_tools.salt.core.SMetaAnnotation;
import org.corpus_tools.salt.core.SNode;
import org.corpus_tools.salt.core.SProcessingAnnotation;
import org.corpus_tools.salt.core.SRelation;
import org.corpus_tools.salt.exceptions.SaltException;
import org.corpus_tools.salt.exceptions.SaltResourceException;
import org.corpus_tools.salt.graph.Identifier;
import org.corpus_tools.salt.graph.Label;
import org.corpus_tools.salt.semantics.SCatAnnotation;
import org.corpus_tools.salt.semantics.SLemmaAnnotation;
import org.corpus_tools.salt.semantics.SPOSAnnotation;
import org.corpus_tools.salt.semantics.SSentenceAnnotation;
import org.corpus_tools.salt.semantics.STypeAnnotation;
import org.corpus_tools.salt.semantics.SWordAnnotation;
import org.corpus_tools.salt.util.internal.persistence.SaltXML10Handler;
import org.corpus_tools.salt.util.internal.persistence.SaltXML10Writer;
import org.corpus_tools.salt.util.internal.persistence.dot.SCorpusGraphDOTWriter;
import org.corpus_tools.salt.util.internal.persistence.dot.SDocumentGraphDOTWriter;
import org.eclipse.emf.common.util.URI;
import org.omg.PortableInterceptor.ServerIdHelper;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

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

	/**
	 * Returns a global ID for the passed object (either if {@link Identifier}
	 * belongs to {@link SDocument} or {@link SCorpus} object). A global id only
	 * can be returned, if the element is contained in a {@link SCorpusGraph}
	 * object. If this is not the case, the {@link ServerIdHelper} is returned.
	 * 
	 * @param id
	 *            Object to retrieve global id.
	 * @return String value for global id, if one is given.
	 */
	public static String getGlobalId(Identifier id) {
		StringBuffer globalId = new StringBuffer();
		if ((id != null) && (id.getIdentifiableElement() != null)) {
			SCorpusGraph graph = null;
			if ((id.getIdentifiableElement() instanceof SDocument) && (((SDocument) id.getIdentifiableElement()).getGraph() != null)) {
				graph = ((SDocument) id.getIdentifiableElement()).getGraph();
			} else if ((id.getIdentifiableElement() instanceof SCorpus) && (((SCorpus) id.getIdentifiableElement()).getGraph() != null)) {
				graph = ((SCorpus) id.getIdentifiableElement()).getGraph();
			} else if (id.getIdentifiableElement() instanceof SNode) {
				SNode sNode = (SNode) id.getIdentifiableElement();
				if ((sNode.getGraph() != null)) {
					if (sNode.getGraph() instanceof SCorpusGraph) {
						graph = (SCorpusGraph) sNode.getGraph();
					} else if (sNode.getGraph() instanceof SDocumentGraph) {
						graph = ((SDocumentGraph) sNode.getGraph()).getDocument().getGraph();
					}
				}
			} else if (id.getIdentifiableElement() instanceof SRelation) {
				SRelation<?, ?> sRel = (SRelation<?, ?>) id.getIdentifiableElement();
				if ((sRel.getGraph() != null)) {
					if (sRel.getGraph() instanceof SCorpusGraph) {
						graph = (SCorpusGraph) sRel.getGraph();
					} else if (sRel.getGraph() instanceof SDocumentGraph) {
						graph = ((SDocumentGraph) sRel.getGraph()).getDocument().getGraph();
					}
				}
			}

			if (graph != null) {
				globalId.append(SALT_NAMESPACE + ":");
				SaltProject project = graph.getSaltProject();
				if (project != null) {
					globalId.append("/");
					globalId.append(project.getCorpusGraphs().indexOf(graph));
					globalId.append("/");
				}
				String actualId = id.getId().replace(SALT_NAMESPACE + ":", "");
				if (actualId.startsWith("/")) {
					actualId = actualId.substring(1, actualId.length());
				}
				globalId.append(actualId);
				if (id.getIdentifiableElement() instanceof SCorpus) {
					globalId.append("/");
				}
			} else {
				globalId.append(id.getId());
			}
		}
		return (globalId.toString());
	}

	// ================================================> Persistence SaltXML
	/**
	 * Loads an object coming from a SaltXML (.{@link #FILE_ENDING_SALT_XML})
	 * and returns it.
	 * 
	 * If multiple objects are contained in the file it will only load the first
	 * one.
	 * 
	 * @param location
	 *            {@link URI} to SaltXML file containing the object or
	 *            {@code null} if the fule does not contain any objects.
	 * @return loaded object
	 * 
	 * @see #loadObjects(org.eclipse.emf.common.util.URI) loadObjects(...):
	 *      similar function that returns all the objects of a file.
	 */
	public static Object load(URI location) {
		// actially get all the objects that are included in the file
		List<Object> objects = loadObjects(location);
		if (objects == null || objects.isEmpty()) {
			return null;
		} else {
			// only return the first one.s
			return objects.get(0);
		}
	}

	// ================================================> Persistence SaltXML
	/**
	 * Loads a list of root objects coming from a SaltXML (.
	 * {@link #FILE_ENDING_SALT_XML}) and returns it.
	 * 
	 * @param objectURI
	 *            {@link URI} to SaltXML file containing the object
	 * @return loaded objects
	 */
	public static List<Object> loadObjects(URI location) {
		if (location == null) {
			throw new SaltResourceException("Cannot load Salt object, because the given uri is null.");
		}
		File objectFile = new File((location.toFileString() == null) ? location.toString() : location.toFileString());
		if (!objectFile.exists()) {
			throw new SaltResourceException("Cannot load Salt object, because the file '" + objectFile.getAbsolutePath() + "' does not exist.");
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
		return contentHandler.getRootObjects();
	}

	/**
	 * Iterates through the documents of a corpus graph and sets the correct
	 * document graph locations.
	 * 
	 * @see SDocument#getDocumentGraphLocation()
	 * @param corpusGraph
	 * @param root
	 *            The root folder or the salt project file.
	 */
	private static void insertDocumentGraphLocations(SCorpusGraph corpusGraph, URI root) {
		if (corpusGraph == null || root == null) {
			return;
		}

		File rootFile = new File(root.toFileString());
		if (rootFile.isFile()) {
			rootFile = rootFile.getParentFile();
			root = URI.createFileURI(rootFile.getAbsolutePath());
		}
		for (SDocument doc : corpusGraph.getDocuments()) {
			URI location = root;
			location = location.appendSegments(doc.getPath().segments());
			location = location.appendFileExtension(SaltUtil.FILE_ENDING_SALT_XML);
			File f = new File(location.toFileString());
			if (f.exists()) {
				doc.setDocumentGraphLocation(location);
			}
		}
	}

	/**
	 * Moves the content of <code>source</code> to <code>target</code>. Caution:
	 * Object contained in <code>source</code> will be moved, which from
	 * <code>target</code> to <code>source</code>, which will mean, that object
	 * are not content of <code>source</code> any more after using
	 * {@link #moveCorpusGraph(SCorpusGraph, SCorpusGraph)}.
	 * 
	 * @param source
	 *            {@link SCorpusGraph} delivering the content to
	 *            moveSCorpusGraph
	 * @param target
	 *            {@link SCorpusGraph} object to where the content will be moved
	 */
	public static void moveCorpusGraph(SCorpusGraph source, SCorpusGraph target) {
		// copy all sRelations and source and target SNode as well from loaded
		// graph into existing one
		for (SRelation<? extends SNode, ? extends SNode> sRelation : new LinkedList<>(source.getRelations())) {
			if (target.getNode(sRelation.getSource().getId()) == null)
				target.addNode(sRelation.getSource());
			if (target.getNode(sRelation.getTarget().getId()) == null)
				target.addNode(sRelation.getTarget());
			target.addRelation(sRelation);
		}

		// copy all sNodes from loaded graph into existing one
		for (SNode sNode : new LinkedList<>(source.getNodes())) {
			if (target.getNode(sNode.getId()) == null)
				target.addNode(sNode);
			target.addNode(sNode);
		}

		// copy all sAnnotation from loaded graph into existing one
		for (SAnnotation sAnno : source.getAnnotations())
			target.addAnnotation(sAnno);

		// copy all sMetaAnnotation from loaded graph into existing one
		for (SMetaAnnotation sMetaAnno : source.getMetaAnnotations())
			target.addMetaAnnotation(sMetaAnno);
		// copy all sProcessingAnnotation from loaded graph into existing one
		for (SProcessingAnnotation sProcAnno : source.getProcessingAnnotations())
			target.addProcessingAnnotation(sProcAnno);

		// copy all SFeature from loaded graph into existing one
		for (SFeature sfeature : source.getFeatures()) {
			target.addFeature(sfeature);
		}

		// copy identifier
		target.setIdentifier(source.getIdentifier());

		// copy all sLayer from loaded graph into existing one
		for (SLayer sLayer : new LinkedList<>(source.getLayers()))
			target.addLayer(sLayer);
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
	 * Persists the passed {@link SCorpusGraph} object in a
	 * {@value SaltUtil#FILE_ENDING_SALT_XML} file at the passed location. The
	 * relation between all {@link SDocument}s and their {@link SDocumentGraph}
	 * will be removed.
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
	 * Loads the given SaltXML file (.{@value SaltFactory#FILE_ENDING_SALT})
	 * into this object. If the given SaltXML file does not contain a
	 * {@link SCorpusGraph} object persisting, an exception will be thrown. If
	 * the SaltXML file contains persistings for more than one
	 * {@link SCorpusGraph} object, the first one will be loaded.
	 * 
	 * @param sCorpusGraphURI
	 *            the {@link URI} to locate the SaltXML file
	 * @return
	 */
	public static SCorpusGraph loadCorpusGraph(URI sCorpusGraphURI) {
		return loadCorpusGraph(sCorpusGraphURI, 0);
	}

	/**
	 * Loads the given SaltXML file (.{@value SaltFactory#FILE_ENDING_SALT})
	 * into this object. If the given SaltXML file does not contain a
	 * {@link SCorpusGraph} object persisting, an exception will be thrown. The
	 * parameter <code>idxOfSCorpusGraph</code> determines which object shall be
	 * load, in case of the given SaltXML file contains more than one persisting
	 * of {@link SCorpusGraph} objects.
	 * 
	 * @param sCorpusGraphUri
	 *            the {@link URI} to locate the SaltXML file
	 * @param idxOfSCorpusGraph
	 *            number of graph to be load, note that the list of graphs
	 *            starts with 0
	 * @return
	 */
	public static SCorpusGraph loadCorpusGraph(URI sCorpusGraphUri, Integer idxOfSCorpusGraph) {
		if (sCorpusGraphUri == null)
			throw new SaltResourceException("Cannot load '" + SCorpusGraph.class.getSimpleName() + "' object, because the passed uri is empty. ");

		SCorpusGraph retVal = null;

		if (!sCorpusGraphUri.toFileString().endsWith("." + SaltUtil.FILE_ENDING_SALT_XML)) {
			// looks weird, but is necessary in case of uri ends with /
			if (sCorpusGraphUri.toString().endsWith("/")) {
				sCorpusGraphUri = sCorpusGraphUri.trimSegments(1);
			}
			sCorpusGraphUri = sCorpusGraphUri.appendSegment(SaltUtil.FILE_SALT_PROJECT);
		}

		Object obj = load(sCorpusGraphUri);
		if (obj instanceof SCorpusGraph) {
			retVal = (SCorpusGraph) obj;
		} else if (obj instanceof SaltProject) {
			if ((((SaltProject) obj).getCorpusGraphs() != null) && (((SaltProject) obj).getCorpusGraphs().size() >= idxOfSCorpusGraph)) {
				retVal = ((SaltProject) obj).getCorpusGraphs().get(idxOfSCorpusGraph);
			}
		}

		if (retVal != null) {
			insertDocumentGraphLocations(retVal, sCorpusGraphUri);
		}

		return (retVal);
	}

	/**
	 * Persists the passed {@link SaltProject} object in a SaltXML file at the
	 * passed location. The relation between all {@link SDocument}s and their
	 * {@link SDocumentGraph} will be removed.
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

	/**
	 * Loads a SaltProject from given uri and returns it as object structure.
	 * This does not load the document graphs which are belong to the
	 * SaltProject from the disk. You have to call
	 * {@link SDocument#loadDocumentGraph() } on each document to load the
	 * actual document graph.
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

		for (SCorpusGraph corpusGraph : saltProject.getCorpusGraphs()) {
			insertDocumentGraphLocations(corpusGraph, location);
		}
		return (saltProject);
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

	/**
	 * Returns the annotation at position idx in the passed set of annotations.
	 * 
	 * @param idx
	 *            position of the annotation to be returned
	 * @param annotations
	 *            set of annotations
	 * @return annotation at position idx
	 */
	public static <P extends Label> P getAnnotation(Integer idx, Set<P> annotations) {
		P retVal = null;
		if (annotations != null && annotations.size() < idx) {
			Iterator<P> it = annotations.iterator();
			for (int i = 0; i <= idx; i++) {
				retVal = it.next();
			}
		}
		return (retVal);
	}

	/**
	 * Moves all {@link SAnnotation} objects from <code>from</code> to
	 * <code>to</code>.
	 * 
	 * @param from
	 *            {@link SAnnotatableElement} object from which
	 *            {@link SAnnotation} object should be moved
	 * @param to
	 *            {@link SAnnotatableElement} object to which
	 *            {@link SAnnotation} object should be moved
	 */
	public static void moveAnnotations(SAnnotationContainer from, SAnnotationContainer to) {
		if ((from != null) && (to != null)) {
			for (SAnnotation fromSAnno : from.getAnnotations()) {
				// if to contains an SAnnotation with the same namespace and
				// name
				String newSName = fromSAnno.getName();
				if (to.getAnnotation(fromSAnno.getQName()) != null) {
					int i = 1;
					while (to.getAnnotation(fromSAnno.getQName() + "_" + i) != null) {
						// while there is an anno "annoQName_i", increment i
						i++;
					} // while there is an anno "annoQName_i" , increment i
					newSName = fromSAnno.getName() + "_" + i;
					fromSAnno.setName(newSName);
					to.addAnnotation(fromSAnno);
				} else {
					// moveSCorpusGraph
					to.addAnnotation(fromSAnno);
				}
			}
		}
	}

	/**
	 * Moves all {@link SMetaAnnotation} objects from <code>from</code> to
	 * <code>to</code>.
	 * 
	 * @param from
	 *            {@link SMetaAnnotatableElement} object from which
	 *            {@link SMetaAnnotation} object should be moved
	 * @param to
	 *            {@link SMetaAnnotatableElement} object to which
	 *            {@link SMetaAnnotation} object should be moved
	 */
	public static void moveMetaAnnotations(SAnnotationContainer from, SAnnotationContainer to) {
		if ((from != null) && (to != null)) {
			for (SMetaAnnotation fromSAnno : from.getMetaAnnotations()) {
				String newSName = fromSAnno.getName();
				if (to.getMetaAnnotation(fromSAnno.getQName()) != null) {
					int i = 1;
					while (to.getMetaAnnotation(fromSAnno.getQName() + "_" + i) != null) {
						// while there is a meta anno "annoQName_i" , increment
						// i
						i++;
					} // while there is a meta anno "annoQName_i" , increment i
					newSName = fromSAnno.getName() + "_" + i;
					fromSAnno.setName(newSName);
					to.addMetaAnnotation(fromSAnno);

				} else {
					// moveSCorpusGraph
					to.addMetaAnnotation(fromSAnno);
				}
			}
		}
	}

	/**
	 * Splits an annotation string of the form 'namespace::name=value
	 * (,namespace::name=value)* into a collection of (namespace, name, value).
	 * 
	 * @param marshalledString
	 *            the annotation string to be unmarschalled
	 * @return a collection of (namespace, name, value).
	 */
	public static Collection<String[]> unmarshalAnnotation(String marshalledString) {
		Collection<String[]> retVal = new ArrayList<>();
		String left = null;
		String middle = null;
		String right = null;
		if ((marshalledString != null) && (!marshalledString.isEmpty())) {
			String[] annotations = marshalledString.split(";");
			for (String annotation : annotations) {
				left = null;
				middle = null;
				right = null;
				String[] nsParts = annotation.split(Label.NS_SEPERATOR);
				String rest;
				if (nsParts.length > 2) {
					throw new SaltException("The given annotation String '" + annotation + "' is not conform to language: (SNS::)?SNAME(=SVALUE)?(;SNS::SNAME=SVALUE)++");
				} else if (nsParts.length == 2) {
					left = nsParts[0].trim();
					if (left.isEmpty()) {
						left = null;
					}
					rest = nsParts[1].trim();
				} else {
					rest = nsParts[0].trim();
				}
				String[] nameParts = rest.split("=");
				if (nameParts.length > 2) {
					throw new SaltException("The given annotation String '" + annotation + "' is not conform to language: (SNS::)?SNAME(=SVALUE)?(;SNS::SNAME=SVALUE)++");
				} else if (nameParts.length == 2) {
					middle = nameParts[0].trim();
					if (middle.isEmpty()) {
						middle = null;
					}
					right = nameParts[1].trim();
					if (right.isEmpty()) {
						right = null;
					}
				} else {
					middle = nameParts[0].trim();
					if (middle.isEmpty()) {
						middle = null;
					}
				}
				String[] triple = { left, middle, right };
				retVal.add(triple);
			}
		}
		return (retVal);
	}
}
