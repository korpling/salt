package de.hu_berlin.u.saltnpepper.salt.util;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

import de.hu_berlin.u.saltnpepper.salt.common.documentStructure.SDocumentGraph;
import de.hu_berlin.u.saltnpepper.salt.core.SAnnotation;
import de.hu_berlin.u.saltnpepper.salt.core.SFeature;
import de.hu_berlin.u.saltnpepper.salt.core.SNamedElement;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SAnnotationImpl;
import de.hu_berlin.u.saltnpepper.salt.core.impl.SFeatureImpl;

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
			str.append(" name:");
			if (templateObject instanceof SAnnotationImpl) {
				str.append((String) ((SAnnotation) templateObject).getName());
			} else if (templateObject instanceof SFeatureImpl) {
				str.append((String) ((SFeature) templateObject).getName());
			} else {
				str.append((String) ((SNamedElement) templateObject).getName());
			}
		}

		if (otherObject != null) {
			str.append(" Graph2_Object:");
			str.append(" salt-type:");

			str.append((String) otherObject.getClass().getSimpleName());

			str.append(" name:");
			if (otherObject instanceof SAnnotationImpl) {
				str.append((String) ((SAnnotation) otherObject).getName());
			} else if (otherObject instanceof SFeatureImpl) {
				str.append((String) ((SFeature) otherObject).getName());
			} else {
				str.append((String) ((SNamedElement) otherObject).getName());
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
