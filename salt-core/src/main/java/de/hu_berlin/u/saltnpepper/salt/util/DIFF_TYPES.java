package de.hu_berlin.u.saltnpepper.salt.util;

import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;

/**
 * Defines types of differences between two {@link SDocumentGraph} objects.
 * 
 * @author florian
 *
 */
public enum DIFF_TYPES {
	/**
	 * one of the compared objects contains a label, which is missing for the
	 * other one
	 */
	LABEL_MISSING,
	/** the compared labels differ in their namespace */
	LABEL_NAMESPACES_DIFFERING,
	/** the compared labels differ in their name */
	LABEL_NAME_DIFFERING,
	/** the compared labels differ in their value */
	LABEL_VALUE_DIFFERING,
	/** the ids of the compared objects differ */
	ID_DIFFERING,
	/**
	 * one of the compared graphs contains a node that is missing for the other
	 * one
	 */
	NODE_MISSING,
	/** the compared nodes differ in their name */
	NODE_NAME_DIFFERING,
	/** the compared nodes differ in for instance their labels **/
	NODE_DIFFERING,
	/**
	 * one of the compared graphs contains a relation that is missing for the
	 * other one
	 */
	RELATION_MISSING,
	/** the compared relations differ in their type */
	RELATION_TYPE_DIFFERING,
	/** the compared relations differ in their name */
	RELATION_NAME_DIFFERING,
	/**
	 * one of the compared graphs contains a layer that is missing for the other
	 * one
	 */
	LAYER_MISSING,
	/** the compared layers differ in their name */
	LAYER_NAME_DIFFERING
}
