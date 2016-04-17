/**
 * Copyright 2009 Humboldt-Universität zu Berlin, INRIA.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */
package org.corpus_tools.salt.graph.impl;

import org.corpus_tools.salt.graph.Graph;
import org.corpus_tools.salt.graph.IGraphFactory;
import org.corpus_tools.salt.graph.IdentifiableElement;
import org.corpus_tools.salt.graph.Identifier;
import org.corpus_tools.salt.graph.Label;
import org.corpus_tools.salt.graph.Layer;
import org.corpus_tools.salt.graph.Node;
import org.corpus_tools.salt.graph.Relation;

public class GraphFactoryImpl implements IGraphFactory {

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hu_berlin.u.saltnpepper.graph.impl.IGraphFactory#createGraph()
	 */
	@Override
	public<N extends Node,R extends Relation<? extends N, ? extends N>, L extends Layer<N,R>> 
		Graph<N,R,L> createGraph() {
		return (new GraphImpl<N,R,L>());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hu_berlin.u.saltnpepper.graph.impl.IGraphFactory#createNode()
	 */
	@Override
	public Node createNode() {
		return (new NodeImpl());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hu_berlin.u.saltnpepper.graph.impl.IGraphFactory#createRelation()
	 */
	@Override
	public <S extends Node, T extends Node> Relation<S,T> createRelation() {
		return (new RelationImpl<S, T>());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hu_berlin.u.saltnpepper.graph.impl.IGraphFactory#createLabel()
	 */
	@Override
	public Label createLabel() {
		return (new LabelImpl());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.hu_berlin.u.saltnpepper.graph.impl.IGraphFactory#createIdentifier(
	 * de.hu_berlin.u.saltnpepper.graph.IdentifiableElement, java.lang.String)
	 */
	@Override
	public Identifier createIdentifier(IdentifiableElement container, String id) {
		return (new IdentifierImpl(container, id));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.hu_berlin.u.saltnpepper.graph.impl.IGraphFactory#createLayer()
	 */
	@Override
	public Layer<Node, Relation<Node, Node>> createLayer() {
		return (new LayerImpl<Node, Relation<Node, Node>>());
	}
}