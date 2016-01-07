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
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltInsertionException;
import de.hu_berlin.u.saltnpepper.salt.util.SaltUtil;

/**
 * This class is an abstract container containing a set of {@link Label}
 * objects.
 * 
 * @author florian
 *
 */
@SuppressWarnings("serial")
public abstract class LabelableElementImpl implements LabelableElement, Serializable {

	public LabelableElementImpl() {
	}

	/**
	 * A delegate object of the same type. If {@link #delegate} is not null, all
	 * functions of this method are delegated to the delegate object. Setting
	 * {@link #delegate} makes this object to a container.
	 **/
	protected LabelableElement delegate = null;

	/**
	 * Returns the delegate object. If {@link #delegate} is not null, all
	 * functions of this method are delegated to the delegate object. Setting
	 * {@link #delegate} makes this object to a container.
	 * 
	 * @return the delegate object
	 */
	protected LabelableElement getDelegate() {
		return (delegate);
	}

	/**
	 * Initializes a new object and sets an internal delegatee. This means, all
	 * method invocations are passed to the delegatee.
	 * 
	 * @param delegatee
	 *            object to pass method invocations to.
	 */
	public LabelableElementImpl(LabelableElement delegatee) {
		this.delegate = delegatee;
	}

	/** internal set of all labels **/
	private Map<String, Label> labels = null;

	/** {@inheritDoc LabelableElement#getLabels()} **/
	@Override
	public Collection<Label> getLabels() {
		if (getDelegate() != null) {
			return (getDelegate().getLabels());
		}
		Collection<Label> retVal = null;
		if (labels != null) {
			retVal = labels.values();
		}
		return (retVal);
	}

	/** {@inheritDoc LabelableElement#getLabel(String)} **/
	@Override
	public Label getLabel(String qName) {
		if (getDelegate() != null) {
			return (getDelegate().getLabel(qName));
		}
		if (labels != null) {
			return (labels.get(qName));
		} else {
			return (null);
		}
	}

	/** {@inheritedDoc LabelableElement#getLabel(String, String)} **/
	@Override
	public Label getLabel(String namespace, String name) {
		if (getDelegate() != null) {
			return (getDelegate().getLabel(namespace, name));
		}
		String qName = SaltUtil.createQName(namespace, name);
		return (getLabel(qName));
	}

	/** {@inheritDoc LabelableElement#getLabelsByNamespace(String)} **/
	@Override
	public Set<Label> getLabelsByNamespace(String namespace) {
		if (getDelegate() != null) {
			return (getDelegate().getLabelsByNamespace(namespace));
		}
		Set<Label> retVal = new HashSet<Label>();
		if (labels != null) {
			for (Label label : labels.values()) {
				if (namespace == null) {
					if (label.getNamespace() == null) {
						retVal.add(label);
					}
				} else if (namespace.equals(label.getNamespace())) {
					retVal.add(label);
				}
			}
		}
		return (retVal);
	}

	/** {@inheritDoc} */
	@Override
	public void addLabel(Label label) {
		if (getDelegate() != null) {
			getDelegate().addLabel(label);
		} else {
			if (label != null) {
				if (label instanceof LabelImpl) {
					((LabelImpl) label).basicSetLabelableElement(this);
				}
				basicAddLabel(label);
			}
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
	public void basicAddLabel(Label label) {
		if (getDelegate() != null && getDelegate() instanceof LabelableElementImpl) {
			((LabelableElementImpl) getDelegate()).basicAddLabel(label);
		} else {
			if (label != null) {
				if ((label.getName() == null) || (label.getName().isEmpty())) {
					throw new SaltInsertionException(this, label, "Cannot add a label object without a name.");
				}
				if (labels == null) {
					labels = new HashMap<String, Label>();
				}
				String qName = SaltUtil.createQName(label.getNamespace(), label.getName());
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
	}

	/** {@inheritDoc LabelableElement#removeLabel(String)} **/
	@Override
	public void removeLabel(String qName) {
		if (getDelegate() != null) {
			getDelegate().removeLabel(qName);
		} else {
			if (qName != null) {
				Label label = getLabel(qName);
				if (label instanceof LabelImpl) {
					((LabelImpl) label).setContainer(null);
				}
				basicRemoveLabel(qName);
			}
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
		if (getDelegate() != null && getDelegate() instanceof LabelableElementImpl) {
			((LabelableElementImpl) getDelegate()).basicRemoveLabel(qName);
		} else {
			if (qName != null) {
				labels.remove(qName);
			}
		}
	}

	/** {@inheritDoc LabelableElement#removeLabel(String, String))} **/
	@Override
	public void removeLabel(String namespace, String name) {
		if (getDelegate() != null) {
			getDelegate().removeLabel(namespace, name);
		} else {
			removeLabel(SaltUtil.createQName(namespace, name));
		}
	}

	/** {@inheritDoc LabelableElement#removeAll()} **/
	@Override
	public void removeAll() {
		if (getDelegate() != null) {
			getDelegate().removeAll();
		} else {
			labels = new HashMap<String, Label>();
		}
	}

	/** {@inheritDoc LabelableElement#containsLabel(String)} **/
	@Override
	public boolean containsLabel(String qName) {
		if (getDelegate() != null) {
			return (getDelegate().containsLabel(qName));
		}
		return (labels.containsKey(qName));
	}

	/** {@inheritDoc LabelableElement#sizeLabels()} **/
	@Override
	public Integer sizeLabels() {
		if (getDelegate() != null) {
			return (getDelegate().sizeLabels());
		} else {

			if (labels != null) {
				return (labels.values().size());
			}
			return (0);
		}
	}
}
