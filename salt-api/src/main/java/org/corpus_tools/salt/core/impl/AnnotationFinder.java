package org.corpus_tools.salt.core.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.corpus_tools.salt.core.SAbstractAnnotation;
import org.corpus_tools.salt.core.SAnnotationContainer;
import org.corpus_tools.salt.graph.Label;
import org.corpus_tools.salt.util.SaltUtil;

import com.google.common.base.Strings;

public class AnnotationFinder<L extends SAbstractAnnotation> {
	private final Class<L> resultType;
	private final SAnnotationContainer container;
	private String namespace = null;
	private String name = null;

	public AnnotationFinder(Class<L> resultType, SAnnotationContainer container) {
		this.resultType = resultType;
		this.container = container;
	}

	public AnnotationFinder<L> withNamespace(String namespace) {
		this.namespace = namespace;
		return this;
	}

	public AnnotationFinder<L> withName(String name) {
		this.name = name;
		return this;
	}

	public AnnotationFinder<L> withQName(String qName) {
		Pair<String, String> namespaceName = SaltUtil.splitQName(qName);
		namespace = namespaceName.getLeft();
		name = namespaceName.getRight();
		return this;
	}

	public List<L> go() {
		return find(resultType, namespace, name);
	}

	@SuppressWarnings("unchecked")
	private <T extends SAbstractAnnotation> List<T> find(Class<T> resultType, String namespace, String name) {
		if (resultType == null) {
			return Collections.emptyList();
		}
		List<T> foundAnnotations = new ArrayList<>();
		boolean hasNamespace = !Strings.isNullOrEmpty(namespace);
		boolean hasName = !Strings.isNullOrEmpty(name);
		if (hasName && hasNamespace) {
			Label label = container.getLabel(SaltUtil.createQName(namespace, name));
			if (resultType.isInstance(label)) {
				foundAnnotations.add((T) label);
			}
		} else {
			for (Label label : container.getLabels()) {
				if ((hasName && name.equals(label.getName()))
						|| (hasNamespace && namespace.equals(label.getNamespace()))) {
					if (resultType.isInstance(label)) {
						foundAnnotations.add((T) label);
					}
				}
			}
		}
		return foundAnnotations;
	}

}
