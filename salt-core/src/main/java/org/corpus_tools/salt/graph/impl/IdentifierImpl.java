package org.corpus_tools.salt.graph.impl;

import org.corpus_tools.salt.graph.IdentifiableElement;
import org.corpus_tools.salt.graph.Identifier;
import org.corpus_tools.salt.util.SaltUtil;

@SuppressWarnings("serial")
public class IdentifierImpl extends LabelImpl implements Identifier {

	/**
	 * Instantiates an {@link IdentifierImpl} object and sets its passed
	 * container and id. Further sets its namespace to
	 * {@link SaltUtil#SALT_NAMESPACE} and its name to {@link SaltUtil#LABEL_ID}
	 * .
	 * 
	 * @param container
	 * @param id
	 */
	public IdentifierImpl(IdentifiableElement container, String id) {
		this.container = container;
		this.value = id;
		super.setNamespace(SaltUtil.SALT_NAMESPACE);
		super.setName(SaltUtil.LABEL_ID);
		if (container != null) {
			container.setIdentifier(this);
		}
	}

	/** Do nothing **/
	@Override
	public void setNamespace(String namespace) {
	}

	/** Do nothing **/
	@Override
	public void setName(String name) {
	}

	/** {@inheritDoc Identifier#setValue(String)} **/
	@Override
	public void setValue(String value) {
	}

	/** {@inheritDoc Identifier#getId()} **/
	@Override
	public String getId() {
		return (getValue().toString());
	}

	private IdentifiableElement container = null;

	/** {@inheritDoc Identifier#getIdentifiableElement()} **/
	@Override
	public IdentifiableElement getIdentifiableElement() {
		return (container);
	}
}
