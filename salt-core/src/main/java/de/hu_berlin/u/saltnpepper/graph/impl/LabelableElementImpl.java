package de.hu_berlin.u.saltnpepper.graph.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.graph.IdentifiableElement;
import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.graph.LabelableElement;
import de.hu_berlin.u.saltnpepper.graph.Node;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltInsertionException;
import de.hu_berlin.u.saltnpepper.salt.util.GraphUtil;

/**
 * This class is an abstract container containing a set of {@link Label}
 * objects.
 * 
 * @author florian
 *
 */
@SuppressWarnings("serial")
public abstract class LabelableElementImpl implements LabelableElement, Serializable {
	/** internal set of all labels **/
	private Map<String, Label<?>> labels = null;

	/** {@inheritDoc LabelableElement#getLabels()} **/
	@Override
	public Collection<Label<?>> getLabels() {
		Collection<Label<?>> retVal = null;
		if (labels != null) {
			retVal = labels.values();
		}
		return (retVal);
	}

	/** {@inheritDoc LabelableElement#getLabel(String)} **/
	@Override
	public Label<?> getLabel(String qName) {
		if (labels != null) {
			return (labels.get(qName));
		} else {
			return (null);
		}
	}

	/** {@inheritedDoc LabelableElement#getLabel(String, String)} **/
	@Override
	public Label<?> getLabel(String namespace, String name) {
		String qName = GraphUtil.createQName(namespace, name);
		return (getLabel(qName));
	}

	/** {@inheritDoc LabelableElement#getLabelsByNamespace(String)} **/
	@Override
	public Set<Label<?>> getLabelsByNamespace(String ns) {
		Set<Label<?>> retVal = new HashSet<Label<?>>();
		if (labels != null) {
			for (Label<?> label : labels.values()) {
				if (ns == null) {
					if (label.getNamespace() == null) {
						retVal.add(label);
					}
				} else if (ns.equals(label.getNamespace())) {
					retVal.add(label);
				}
			}
		}
		return (retVal);
	}

	/** {@inheritDoc} */
	@Override
	public void addLabel(Label<?> label) {
		if (label != null) {
			if (label instanceof LabelImpl) {
				((LabelImpl) label).basicSetLabelableElement(this);
			}
			basicAddLabel(label);
		}
	}

	/**
	 * This is an internally used method. To implement a double chaining of
	 * {@link LabelableElement} and {@link label} object. When a label is
	 * inserted into this container and to avoid an endless invocation the
	 * insertion of a label is split into the two methods
	 * {@link #addLabel(Label)} and {@link #basicAddLabel(Label)}. The
	 * invocation of methods is implement as follows:
	 * 
	 * <pre>
	 * {@link #addLabel(Label)}                      {@link Label#setContainer(LabelableElement)}
	 *         ||             \ /                   ||
	 *         ||              X                    ||
	 *         \/             / \                   \/
	 * {@link #basicAddLabel(Label)}            {@link LabelImpl#basicSetLabelableElement(LabelableElement)}
	 * </pre>
	 * 
	 * That means method {@link #addLabel(Label)} calls
	 * {@link #basicAddLabel(Label)} and {@link Label#basicSetGraph(Graph)}. And
	 * method {@link Label#setContainer(LabelableElement)} calls
	 * {@link #basicAddLabel(Label)} and
	 * {@link LabelImpl#basicSetLabelableElement(LabelableElement)}.
	 * 
	 * @param label
	 *            label to be inserted
	 */
	public void basicAddLabel(Label<?> label) {
		if (label != null) {
			if ((label.getName() == null) || (label.getName().isEmpty())) {
				throw new SaltInsertionException(this, label, "Cannot add a label object without a name.");
			}
			if (labels == null) {
				labels = new HashMap<String, Label<?>>();
			}
			String qName = GraphUtil.createQName(label.getNamespace(), label.getName());
			if (labels.containsKey(qName)) {
				if (this instanceof IdentifiableElement) {
					throw new SaltInsertionException(this, label, " Because an id already exists: " + labels.get(qName) + ".");
				} else {
					throw new SaltInsertionException(this, label, "Cannot add the given label object, because a label with this QName already exists: " + label.getQName());
				}
			}
			labels.put(qName, label);
		}
	}

	/** {@inheritDoc LabelableElement#removeLabel(String)} **/
	@Override
	public void removeLabel(String qName) {
		if (qName != null) {
			Label label= getLabel(qName);
			if (label instanceof LabelImpl){
				((LabelImpl)label).setContainer(null);
			}
			basicRemoveLabel(qName);
		}
	}

	/**
	 * This is an internally used method. To implement a double chaining of
	 * {@link LabelableElement} and {@link label} object. When a label is
	 * inserted into this container and to avoid an endless invocation the
	 * insertion of a label is split into the two methods
	 * {@link #removeLabel(String)} and {@link #basicRemoveLabel(String)}. The
	 * invocation of methods is implement as follows:
	 * 
	 * <pre>
	 * {@link #removeLabel(String)}                      {@link Label#setContainer(LabelableElement)}
	 *         ||             \ /                   ||
	 *         ||              X                    ||
	 *         \/             / \                   \/
	 * {@link #basicRemoveLabel(STring)}            {@link LabelImpl#basicSetLabelableElement(LabelableElement)}
	 * </pre>
	 * 
	 * That means method {@link #removeLabel(String)} calls
	 * {@link #basicRemoveLabel(String)} and {@link Label#basicSetGraph(Graph)}.
	 * And method {@link Label#setContainer(LabelableElement)} calls
	 * {@link #basicRemoveLabel(String)} and
	 * {@link LabelImpl#basicSetLabelableElement(LabelableElement)}.
	 * 
	 * @param label
	 *            label to be inserted
	 */
	public void basicRemoveLabel(String qName) {
		if (qName != null) {
			labels.remove(qName);
		}
	}

	/** {@inheritDoc LabelableElement#removeLabel(String, String))} **/
	@Override
	public void removeLabel(String namespace, String name) {
		removeLabel(GraphUtil.createQName(namespace, name));
	}

	/** {@inheritDoc LabelableElement#removeAll()} **/
	@Override
	public void removeAll() {
		labels = new HashMap<String, Label<?>>();
	}

	/** {@inheritDoc LabelableElement#containsLabel(String)} **/
	@Override
	public boolean containsLabel(String qName) {
		return (labels.containsKey(qName));
	}

	/** {@inheritDoc LabelableElement#sizeLabels()} **/
	@Override
	public Integer sizeLabels() {
		if (labels != null) {
			return (labels.values().size());
		}
		return (0);
	}
}
