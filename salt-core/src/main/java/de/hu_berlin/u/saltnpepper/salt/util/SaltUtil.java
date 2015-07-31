package de.hu_berlin.u.saltnpepper.salt.util;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.salt.core.SFeature;

/**
 * This class contains a set of helpful methods.
 * 
 * @author florian
 *
 */
public class SaltUtil {
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
	 * Name for {@link SFeature} to store the type of a labels
	 * value.
	 */
	public static final String KW_VALUE_DATATYPE = "SVAL_TYPE";
	/**
	 * Name for {@link SFeature} to store the name of a node,
	 * relation, graph or label.
	 */
	public static final String KW_NAME = "SNAME";
	/**
	 * Qualified name for {@link SFeature} to store the name of a
	 * node, relation, graph or label.
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
