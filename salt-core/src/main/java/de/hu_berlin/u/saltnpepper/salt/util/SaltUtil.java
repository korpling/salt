package de.hu_berlin.u.saltnpepper.salt.util;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SDocument;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.STimeline;
import de.hu_berlin.u.saltnpepper.salt.core.SFeature;

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
	 * Name for {@link SFeature} to store the {@link SDocumentGraph} in a {@link SDocument} object
	 */
	public static final String FEAT_SDOCUMENT_GRAPH = "SDOCUMENT_GRAPH";
	/**
	 * Qualified name for {@link SFeature} to store the {@link SDocumentGraph} in a {@link SDocument} object
	 */
	public static final String FEAT_SDOCUMENT_GRAPH_QNAME = SALT_NAMESPACE + NAMESPACE_SEPERATOR + "SDOCUMENT_GRAPH";
	/**
	 * Name for {@link SFeature} to store the {@link SDocument} corresponding to a {@link SDocumentGraph} object
	 */
	public static final String FEAT_SDOCUMENT = "SDOCUMENT";
	/**
	 * Qualified name for {@link SFeature} to store the {@link SDocument} corresponding to a {@link SDocumentGraph} object
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
	 * The qualified name of the name of the {@link SFeature} for the reference to an audio file.
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

//	/** Determines the separator between points of time in a {@link STimeline}**/
//	public static final String TIMELINE_SEPARATOR = "#";
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
}
