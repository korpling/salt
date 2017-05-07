package org.corpus_tools.salt.graph.impl;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.corpus_tools.salt.graph.Label;
import org.corpus_tools.salt.graph.LabelableElement;
import org.corpus_tools.salt.util.SaltUtil;

public class LabelFinder<L extends Label> {
	private final Class<L> resultType;
	private final LabelableElement container;
	private String namespace = null;
	private String name = null;

	public LabelFinder(Class<L> resultType, LabelableElement container) {
		this.resultType = resultType;
		this.container = container;
	}

	public LabelFinder<L> withNamespace(String namespace) {
		this.namespace = namespace;
		return this;
	}

	public LabelFinder<L> withName(String name) {
		this.name = name;
		return this;
	}

	public LabelFinder<L> withQName(String qName) {
		Pair<String, String> namespaceName = SaltUtil.splitQName(qName);
		namespace = namespaceName.getLeft();
		name = namespaceName.getRight();
		return this;
	}

	public List<L> go() {
		return container.find(resultType, namespace, name);
	}

}
