package de.hu_berlin.u.saltnpepper.graph.impl;

import org.apache.commons.lang3.tuple.Pair;

import de.hu_berlin.u.saltnpepper.graph.Graph;
import de.hu_berlin.u.saltnpepper.graph.Label;
import de.hu_berlin.u.saltnpepper.graph.LabelableElement;
import de.hu_berlin.u.saltnpepper.salt.exceptions.SaltException;
import de.hu_berlin.u.saltnpepper.salt.util.Copyable;
import de.hu_berlin.u.saltnpepper.salt.util.SaltUtil;

@SuppressWarnings("serial")
public class LabelImpl extends LabelableElementImpl implements Label, Copyable<Label> {

	public LabelImpl() {
		super();
	}

	/**
	 * Initializes a new object and sets an internal delegatee. This means, all
	 * method invocations are passed to the delegatee.
	 * 
	 * @param delegatee
	 *            object to pass method invocations to.
	 */
	public LabelImpl(Label delegatee) {
		super(delegatee);
	}
	/** {@inheritDoc} **/
	@Override
	protected Label getDelegate() {
		return ((Label)delegate);
	}

	protected String namespace = null;

	/** {@inheritDoc Label#getNamespace()} */
	@Override
	public String getNamespace() {
		if (getDelegate() != null) {
			return (getDelegate().getNamespace());
		}
		return namespace;
	}

	/** {@inheritDoc Label#setNamespace(String)} */
	@Override
	public void setNamespace(String namespace) {
		if (getDelegate() != null) {
			getDelegate().setNamespace(namespace);
		} else {
			this.namespace = namespace;
		}
	}

	protected String name = null;

	/** {@inheritDoc Label#getName()} */
	@Override
	public String getName() {
		if (getDelegate() != null) {
			return (getDelegate().getName());
		}
		return name;
	}

	/** {@inheritDoc Label#setName(String)} */
	@Override
	public void setName(String name) {
		if (getDelegate() != null) {
			getDelegate().setName(name);
		} else {

			if ((name == null) || (name.isEmpty())) {
				throw new SaltException("Cannot set the name of this label object, because it is empty.");
			}
			if (name.contains(NS_SEPERATOR)) {
				throw new SaltException("Cannot set the name to the given, because a namespace with namespace seperaor is illegal.");
			}
			this.name = name;
		}
	}

	/** {@inheritDoc Label#getQName()} */
	@Override
	public String getQName() {
		if (getDelegate() != null) {
			return (getDelegate().getQName());
		}
		return SaltUtil.createQName(getNamespace(), getName());
	}

	/** {@inheritDoc Label#setQName(String)} */
	public void setQName(String newQName) {
		if (getDelegate() != null) {
			getDelegate().setQName(newQName);
		} else {
			Pair<String, String> pair = SaltUtil.splitQName(newQName);
			setNamespace(pair.getLeft());
			setName(pair.getRight());
		}
	}

	/** The generic value field. **/
	protected Object value = null;

	/** {@inheritDoc Label#getValue()} */
	@Override
	public Object getValue() {
		if (getDelegate() != null) {
			return (getDelegate().getValue());
		}
		return value;
	}

	/** {@inheritDoc Label#setValue(Object)} */
	@Override
	public void setValue(Object value) {
		if (getDelegate() != null) {
			getDelegate().setValue(value);
		} else {
			this.value = value;
		}
	}

	// ==========================================> container
	/** The container of this object. **/
	protected LabelableElement container = null;

	/** {@inheritDoc} */
	@Override
	public void setContainer(LabelableElement container) {
		if (getDelegate() != null) {
			getDelegate().setContainer(container);
		} else {
			LabelableElement oldContainer = this.container;
			if (container != null) {
				// add label to container
				if (container instanceof LabelableElementImpl) {
					container.addLabel(this);
				}

			}
			if (oldContainer != null) {
				// remove label from old container
				if (oldContainer instanceof LabelableElementImpl) {
					((LabelableElementImpl) oldContainer).basicRemoveLabel(this.getQName());
				}
			}
		}
	}

	/** {@inheritDoc} */
	@Override
	public LabelableElement getContainer() {
		if (getDelegate() != null) {
			return (getDelegate().getContainer());
		}
		return (container);
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
	public void basicSetLabelableElement(LabelableElement container) {
		if (getDelegate() != null && getDelegate() instanceof LabelImpl) {
			((LabelImpl) getDelegate()).basicSetLabelableElement(container);
		} else {
			this.container = container;
		}
	}

	// ==========================================< container

	/**
	 * This method the namespace, the name and the value from this object to the
	 * passed one and returns the passed one.
	 * 
	 * @param clone
	 *            the clone to which all properties of this shall be copied to
	 * @return other enhanced for namespace, name and value
	 */
	@Override
	public void copy(Label other) {
		if (getDelegate() != null) {
			getDelegate().copy(other);
		} else {

			if (other == null) {
				throw new SaltException("Cannot clone label '" + this + "', because the given object is null and its not possible to copy values into a null object.");
			}
			other.setNamespace(this.getNamespace());
			other.setName(this.getName());
			other.setValue(this.getValue());
		}
	}

	@Override
	public String toString() {
		if (getDelegate() != null) {
			return (getDelegate().toString());
		}

		StringBuilder str = new StringBuilder();
		str.append(SaltUtil.createQName(getNamespace(), getName()));
		str.append("=");
		str.append(getValue());
		return (str.toString());
	}
}
