package de.hu_berlin.u.saltnpepper.salt.util;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

import de.hu_berlin.u.saltnpepper.graph.IdentifiableElement;
import de.hu_berlin.u.saltnpepper.salt.common.SDocumentGraph;

/**
 * Objects of this class are produces by
 * {@link SDocumentGraph#findDiffs(SDocumentGraph)} to determine differences
 * between two {@link SDocumentGraph} objects.
 * 
 * @author florian
 */
@SuppressWarnings("serial")
public class Difference implements Serializable {
	/** Object of graph template, if this difference type has one **/
	public Object templateObject;
	/** Object of graph other, if this difference type has one **/
	public Object otherObject;
	/** Object containing the given object, e.g. used for layers **/
	public Object container;
	/** type of the difference **/
	public DIFF_TYPES diffType;

	public Set<Difference> subDiffs = null;

	public void addSubDiffs(Set<Difference> subDiffs) {
		this.subDiffs = subDiffs;
	}

	public Difference(Object templateObject, Object otherObject, Object container, DIFF_TYPES diffType) {
		this.templateObject = templateObject;
		this.otherObject = otherObject;
		this.container = container;
		this.diffType = diffType;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(diffType.toString());

		if (templateObject != null) {
			str.append("	Graph1_Object:");
			str.append(" salt-type:");
			str.append((String) templateObject.getClass().getSimpleName());
			str.append(" id:");
			if (templateObject instanceof IdentifiableElement) {
				str.append(((IdentifiableElement) templateObject).getId());
			}
		}

		if (otherObject != null) {
			str.append(" Graph2_Object:");
			str.append(" salt-type:");

			str.append((String) otherObject.getClass().getSimpleName());

			str.append(" id:");
			if (otherObject instanceof IdentifiableElement) {
				str.append(((IdentifiableElement) otherObject).getId());
			}
		}

		if (container != null) {
			str.append(" Container:" + container.toString());
		}

		if (subDiffs != null) {
			Iterator<Difference> iterator = subDiffs.iterator();
			while (iterator.hasNext()) {
				str.append("\n	" + iterator.next().toString());
			}

		}

		return str.toString();
	}
}
