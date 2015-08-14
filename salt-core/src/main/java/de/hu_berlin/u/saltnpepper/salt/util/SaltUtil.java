package de.hu_berlin.u.saltnpepper.salt.util;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.salt.common.corpusStructure.SDocument;
import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.core.SFeature;

/**
 * This class contains a set of helpful methods.
 * 
 * @author florian
 *
 */
public class SaltUtil {
	/**
	 * name of index for node-types
	 */
	public static final String IDX_SNODETYPE = "idx_sNodeType";
	/**
	 * name of index for relation-types
	 */
	public static final String IDX_SRELATIONTYPE = "idx_sRelationType";
	/**
	 * name of index for relating ids and nodes
	 */
	public static final String IDX_ID_NODES = "idx_id_nodes";
	/**
	 * name of index for relating ids and relations
	 */
	public static final String IDX_ID_RELATIONS = "idx_id_relation";
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
	 * Name of {@link Label} to store the identifier of a node, relation, graph
	 * or layer.
	 */
	public static final String KW_IDENTIFIER = "id";
	/**
	 * Qualified name of {@link Label} to store the identifier of a node,
	 * relation, graph or layer.
	 */
	public static final String KW_QNAME_ID = SALT_NAMESPACE + NAMESPACE_SEPERATOR + KW_IDENTIFIER;
	/**
	 * Name for {@link SFeature} to store the type of a labels value.
	 */
	public static final String KW_VALUE_DATATYPE = "SVAL_TYPE";
	/**
	 * Name for {@link SFeature} to store the name of a node, relation, graph or
	 * label.
	 */
	public static final String KW_NAME = "SNAME";
	/**
	 * Qualified name for {@link SFeature} to store the name of a node,
	 * relation, graph or label.
	 */
	public static final String KW_QNAME_NAME = SALT_NAMESPACE + NAMESPACE_SEPERATOR + KW_NAME;
	/**
	 * Name for {@link SFeature} to store the type of a relation.
	 */
	public static final String KW_TYPE = "STYPE";
	/**
	 * Qualified name for {@link SFeature} to store the type of a relation.
	 */
	public static final String KW_QNAME_TYPE = SALT_NAMESPACE + NAMESPACE_SEPERATOR + KW_TYPE;

	/**
	 * Name for {@link SFeature} to store the uri reference of a
	 * {@link SDocumentGraph} in a {@link SDocument}
	 */
	public static final String KW_SDOCUMENT_GRAPH_LOCATION = "SDOCUMENT_GRAPH_LOCATION";
	/**
	 * QUalified name name for {@link SFeature} to store the uri reference of a
	 * {@link SDocumentGraph} in a {@link SDocument}
	 */
	public static final String KW_QNAME_SDOCUMENT_GRAPH_LOCATION = SALT_NAMESPACE + NAMESPACE_SEPERATOR +KW_SDOCUMENT_GRAPH_LOCATION;
	/**
	 * The name of the {@link SFeature} for the reference to an audio file.
	 */
	public static final String FEAT_SAUDIO_REFERNCE = "SAUDIO_REFERENCE";

	/**
	 * The name of the {@link SFeature} for the start value.
	 */
	public static final String FEAT_SSTART = "SSTART";
	/**
	 * The name of the {@link SFeature} for the end value.
	 */
	public static final String FEAT_SEND = "SEND";

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
